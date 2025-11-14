package com.bbva.pfmh.lib.r010.impl.fmc7;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;

import com.bbva.ksan.dto.c101.ContractDetail;
import com.bbva.ksan.dto.c101.ContractsOut;
import com.bbva.ksan.lib.r101.KSANR101;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.lib.r325.KUSUR325;
import com.bbva.pfmh.dto.fmc7.ffmm.FFMM7;
import com.bbva.pfmh.dto.fmc7.pague.FFMMPagination;
import com.bbva.pfmh.dto.fmc7.request.FMC7Request;
import com.bbva.pfmh.dto.fmc7.response.FMC7Response;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.Fund;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFund;
import com.bbva.pfmh.lib.r010.impl.cics.FMC7Connection;
import com.bbva.pfmh.lib.r015.PFMHR015;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.aop.framework.Advised;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FMC7ConnectionTest {

    private Context context;
    private Method resolveRequestHeader;

    @Mock
    private PFMHR015 pfmhR015;

    @Mock
    private KSANR101 ksanR101;

    @Mock
    private KUSUR325 kusuR325;

    @InjectMocks
    private FMC7Connection fmc7Connection;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        context = createContextInstance();
        ThreadContext.set(context);
        resolveRequestHeader = FMC7Connection.class.getDeclaredMethod("resolveRequestHeader");
        resolveRequestHeader.setAccessible(true);
        getObjectIntrospection();
        fmc7Connection.setPfmhR015(pfmhR015);
        fmc7Connection.setKusuR325(kusuR325);
        fmc7Connection.initializeErrorCodeList();
    }

    @After
    public void tearDown() {
        clearTransactionRequest();
        ThreadContext.set(context);
    }

    private Context createContextInstance() {
        try {
            Constructor<Context> constructor = Context.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception ex) {
            throw new IllegalStateException("No fue posible instanciar Context", ex);
        }
    }

    private void assignTransactionRequest(TransactionRequest transactionRequest) {
        try {
            Field field = Context.class.getDeclaredField("transactionRequest");
            field.setAccessible(true);
            field.set(context, transactionRequest);
        } catch (Exception ex) {
            throw new IllegalStateException("No fue posible configurar TransactionRequest en el Contexto", ex);
        }
    }

    private void assignTransactionRequestHeader(CommonRequestHeader header) {
        TransactionRequest transactionRequest = transactionRequestWithHeader(header);
        assignTransactionRequest(transactionRequest);
    }

    private TransactionRequest transactionRequestWithHeader(Object header) {
        try {
            Constructor<TransactionRequest> constructor = TransactionRequest.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            TransactionRequest transactionRequest = constructor.newInstance();
            configureTransactionRequestHeader(transactionRequest, header);
            return transactionRequest;
        } catch (Exception ex) {
            throw new IllegalStateException("No fue posible instanciar TransactionRequest", ex);
        }
    }

    private void configureTransactionRequestHeader(TransactionRequest transactionRequest, Object header) {
        boolean configured = tryConfigureHeaderWithSetter(transactionRequest, header);
        if (!configured) {
            configured = tryConfigureHeaderWithField(transactionRequest, header);
        }
        if (!configured) {
            throw new IllegalStateException("No fue posible configurar el header en TransactionRequest");
        }
    }

    private boolean tryConfigureHeaderWithSetter(TransactionRequest transactionRequest, Object header) {
        for (Method method : TransactionRequest.class.getDeclaredMethods()) {
            if ("setHeader".equals(method.getName()) && method.getParameterTypes().length == 1) {
                try {
                    method.setAccessible(true);
                    method.invoke(transactionRequest, header);
                    return true;
                } catch (Exception ignored) {
                    // Intentaremos con los campos si el setter falla
                }
            }
        }
        return false;
    }

    private boolean tryConfigureHeaderWithField(TransactionRequest transactionRequest, Object header) {
        Field headerField = findHeaderField();
        if (headerField == null) {
            return false;
        }
        try {
            headerField.setAccessible(true);
            headerField.set(transactionRequest, header);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private Field findHeaderField() {
        Field directMatch = findFieldByName("header");
        if (directMatch != null) {
            return directMatch;
        }
        for (Field field : TransactionRequest.class.getDeclaredFields()) {
            Class<?> type = field.getType();
            if (CommonRequestHeader.class.isAssignableFrom(type) || Object.class.equals(type)) {
                return field;
            }
        }
        return null;
    }

    private Field findFieldByName(String name) {
        for (Field field : TransactionRequest.class.getDeclaredFields()) {
            if (field.getName().equals(name)) {
                return field;
            }
        }
        return null;
    }

    private void clearTransactionRequest() {
        assignTransactionRequest(null);
    }

    private CommonRequestHeader headerWithIdentifiers(String userId, String profileId) {
        CommonRequestHeader header = mock(CommonRequestHeader.class);
        doAnswer(invocation -> {
            Object[] arguments = invocation.getArguments();
            RequestHeaderParamsName parameter = (RequestHeaderParamsName) arguments[0];
            if (parameter == RequestHeaderParamsName.USERCODE) {
                return userId;
            }
            if (parameter == RequestHeaderParamsName.USERLOGON
                    || parameter == RequestHeaderParamsName.AGENTUSER
                    || parameter == RequestHeaderParamsName.MANAGERUSER) {
                return null;
            }
            if (parameter == RequestHeaderParamsName.PID) {
                return profileId;
            }
            return null;
        }).when(header).getHeaderParameter(any(RequestHeaderParamsName.class));
        return header;
    }

    private AliasFavContractEntity aliasContract(String globalContractId, String visibilityIndicator) {
        AliasFavContractEntity entity = new AliasFavContractEntity();
        entity.setGContractId(globalContractId);
        entity.setgVisibleContractIndType(visibilityIndicator);
        return entity;
    }

    private void getObjectIntrospection() throws Exception {
        if (this.pfmhR015 instanceof Advised) {
            Advised advised = (Advised) this.pfmhR015;
            advised.getTargetSource().getTarget();
        }
    }

    @Test
    public void testExecuteFMC7Transaction_ValidInput() {
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("00001171");
        input.setPaginationKey("");
        input.setPageSize(10);
        input.setProfileId("PROFILE-01");


        FFMM7 ffmm7 = new FFMM7();
        ffmm7.setIdContr("00110122998000000412");
        FMC7Response mockResponse = new FMC7Response();
        mockResponse.setFfmm7(Collections.singletonList(ffmm7));
        when(pfmhR015.executeFMC7(any(FMC7Request.class))).thenReturn(mockResponse);
        List<OutputInvestmentFundsDTO> result = fmc7Connection.executeFMC7Transaction(input);

        assertNotNull(result);
        verify(pfmhR015, times(1)).executeFMC7(any(FMC7Request.class));
    }

    @Test
    public void testExecuteFMC7Transaction_NullInput() {
        List<OutputInvestmentFundsDTO> result = fmc7Connection.executeFMC7Transaction(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(pfmhR015, never()).executeFMC7(any(FMC7Request.class));
    }

    @Test
    public void testExecuteFMC7Input() {
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("00001171");
        input.setPaginationKey("");
        input.setPageSize(10);
        input.setProfileId("PROFILE-01");

        FMC7Response mockResponse = new FMC7Response();
        mockResponse.setFfmm7(Collections.emptyList());
        when(pfmhR015.executeFMC7(any(FMC7Request.class))).thenReturn(mockResponse);

        List<OutputInvestmentFundsDTO> result = fmc7Connection.executeFMC7Input(input);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(pfmhR015, times(1)).executeFMC7(any(FMC7Request.class));
    }

    @Test
    public void testMapFMC7ouput_EmptyResponse() {
        FMC7Response response = new FMC7Response();
        response.setFfmm7(Collections.emptyList());

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
        input.setProfileId("PROFILE-01");

        List<OutputInvestmentFundsDTO> result = fmc7Connection.mapFMC7ouput(response, input);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testValidateContractHostLocal_ReturnsTrue() {
        OutputInvestmentFundsDTO dto = new OutputInvestmentFundsDTO();
        InvestmentFund fund = new InvestmentFund();
        fund.setNumber("00112233");
        dto.setData(Collections.singletonList(fund));

        boolean result = fmc7Connection.validateContractHostLocal(dto, "PE00112233");
        assertTrue(result);
    }

    @Test
    public void testMapOutFunds_EmptyResponse() {
        FMC7Response response = new FMC7Response();
        response.setFfmm7(Collections.emptyList());
        List<Fund> result = fmc7Connection.mapOutFunds(response);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMapOutFunds_NullResponse() {
        FMC7Response response = new FMC7Response();
        response.setFfmm7(null);
        List<Fund> result = fmc7Connection.mapOutFunds(response);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testMapOutNumberType_ValidInput() {
        String ctipnum = null;
        String dtipnum = "Tipo";

        var result = fmc7Connection.mapOutNumberType(ctipnum, dtipnum);

        assertEquals("Tipo", result.getName());
        assertEquals("Tipo", result.getId());
    }

    @Test
    public void testMapOutNumberType_NullInput() {
        var result = fmc7Connection.mapOutNumberType(null, null);

        assertNull(result);
    }

    @Test
    public void testMapOutNumberType_FallbacksWhenDescriptionMissing() {
        String ctipnum = "L";
        String dtipnum = null;

        var result = fmc7Connection.mapOutNumberType(ctipnum, dtipnum);

        assertNotNull(result);
        assertEquals("L", result.getId());
        assertEquals("L", result.getName());
    }

    @Test
    public void testResolveRequestHeader_ReturnsNullWhenContextMissing() throws Exception {
        ThreadContext.set(null);
        try {
            CommonRequestHeader header = (CommonRequestHeader) resolveRequestHeader.invoke(fmc7Connection);
            assertNull(header);
        } finally {
            ThreadContext.set(context);
        }
    }

    @Test
    public void testResolveRequestHeader_ReturnsNullWhenTransactionRequestMissing() throws Exception {
        clearTransactionRequest();
        CommonRequestHeader header = (CommonRequestHeader) resolveRequestHeader.invoke(fmc7Connection);
        assertNull(header);
    }

    @Test
    public void testResolveRequestHeader_ReturnsNullWhenHeaderMissing() throws Exception {
        TransactionRequest transactionRequest = transactionRequestWithHeader(null);
        assignTransactionRequest(transactionRequest);
        CommonRequestHeader header = (CommonRequestHeader) resolveRequestHeader.invoke(fmc7Connection);
        assertNull(header);
    }

    @Test
    public void testResolveRequestHeader_ReturnsHeaderWhenPresent() throws Exception {
        CommonRequestHeader requestHeader = mock(CommonRequestHeader.class);
        TransactionRequest transactionRequest = transactionRequestWithHeader(requestHeader);
        assignTransactionRequest(transactionRequest);
        CommonRequestHeader header = (CommonRequestHeader) resolveRequestHeader.invoke(fmc7Connection);
        assertSame(requestHeader, header);
    }

    @Test
    public void testGetVisible_DefaultsToVisibleWhenKusuNotConfigured() {
        fmc7Connection.setKusuR325(null);
        boolean visible = fmc7Connection.getVisible("PE00112233", "profile");
        assertTrue(visible);
    }

    @Test
    public void testGetVisible_DefaultsToVisibleWhenIdentifiersMissing() {
        reset(kusuR325);
        clearTransactionRequest();
        boolean visible = fmc7Connection.getVisible("PE00112233", null);
        assertTrue(visible);
    }

    @Test
    public void testGetVisible_ReturnsTrueWhenMatchingContractVisible() {
        reset(kusuR325);
        CommonRequestHeader header = headerWithIdentifiers("user123", "profileABC");
        assignTransactionRequestHeader(header);

        List<AliasFavContractEntity> contracts = new ArrayList<>();
        contracts.add(aliasContract("PE00112233", "Y"));

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("profileABC"), eq("profileABC"), anyList()))
                .thenReturn(contracts);

        boolean visible = fmc7Connection.getVisible("PE00112233", null);
        assertTrue(visible);
    }

    @Test
    public void testGetVisible_ReturnsFalseWhenFallbackExplicitInvisible() {
        reset(kusuR325);
        CommonRequestHeader header = headerWithIdentifiers("user999", "profile999");
        assignTransactionRequestHeader(header);

        List<AliasFavContractEntity> contracts = new ArrayList<>();
        contracts.add(aliasContract("PE00999999", "N"));

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("profile999"), eq("profile999"), anyList()))
                .thenReturn(contracts);

        boolean visible = fmc7Connection.getVisible("PE00112233", null);
        assertFalse(visible);
    }

    @Test
    public void testGetVisible_DefaultsToVisibleWhenIndicatorsMissing() {
        reset(kusuR325);
        CommonRequestHeader header = headerWithIdentifiers("user456", "profile456");
        assignTransactionRequestHeader(header);

        List<AliasFavContractEntity> contracts = new ArrayList<>();
        contracts.add(aliasContract("PE00999999", null));

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("profile456"), eq("profile456"), anyList()))
                .thenReturn(contracts);

        boolean visible = fmc7Connection.getVisible("PE00112233", null);
        assertTrue(visible);
    }

    @Test
    public void testGetVisible_DefaultsToVisibleWhenKusuResponseEmpty() {
        reset(kusuR325);
        CommonRequestHeader header = headerWithIdentifiers("user777", "profile777");
        assignTransactionRequestHeader(header);

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("profile777"), eq("profile777"), anyList()))
                .thenReturn(Collections.emptyList());

        boolean visible = fmc7Connection.getVisible("PE00112233", null);
        assertTrue(visible);
    }

    @Test
    public void testGetVisible_MatchingContractWithoutIndicatorDefaultsVisible() {
        reset(kusuR325);
        CommonRequestHeader header = headerWithIdentifiers("user888", "profile888");
        assignTransactionRequestHeader(header);

        AliasFavContractEntity entity = aliasContract("PE00112233", null);

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("profile888"), eq("profile888"), anyList()))
                .thenReturn(Collections.singletonList(entity));

        boolean visible = fmc7Connection.getVisible("PE00112233", null);
        assertTrue(visible);
    }

    @Test
    public void testGetVisible_ExtractsIndicatorFromRepresentationWhenGetterIgnored() {
        reset(kusuR325);
        CommonRequestHeader header = headerWithIdentifiers("user999", "profile999");
        assignTransactionRequestHeader(header);

        BooleanAliasFavContractEntity entity = new BooleanAliasFavContractEntity(Boolean.TRUE);
        entity.setGContractId("PE00112233");

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("profile999"), eq("profile999"), anyList()))
                .thenReturn(Collections.singletonList(entity));

        boolean visible = fmc7Connection.getVisible("PE00112233", null);
        assertTrue(visible);
    }

    @Test
    public void testMatchErrorCodeHost_ValidCode() {
        FMC7Response response = new FMC7Response();
        response.setHostAdviceCode("FME2026");

        String result = fmc7Connection.matchErrorCodeHost(response);

        assertEquals("PFMHFME2026", result);
    }

    @Test
    public void testMatchErrorCodeHost_InvalidCode() {
        FMC7Response response = new FMC7Response();
        response.setHostAdviceCode("9999");
        String result = fmc7Connection.matchErrorCodeHost(response);
        assertEquals("PFMHFME2026", result); // Default error
    }

    @Test
    public void testMapOutFunds_ValidResponse() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = new FFMM7();
        ffmm7.setIdContr("00110122998000000412");
        ffmm7.setNumCuot(BigDecimal.valueOf(100));
        ffmm7.setSalDisp(BigDecimal.valueOf(2000.0));
        ffmm7.setdMonEsd("USD");
        ffmm7.setIdSubPr("0031");
        ffmm7.setdSubPro("MULT.EST.CONS.S");
        ffmm7.setIdMonFn("USD");
        ffmm7.setSalCont(BigDecimal.valueOf(5000.0));
        ffmm7.setValCuot(BigDecimal.valueOf(50.0));
        ffmm7.setcTipNum("L");
        ffmm7.setdTipNum("CODIGO INTERNO DEL BBVA");
        response.setFfmm7(Collections.singletonList(ffmm7));

        List<Fund> result = fmc7Connection.mapOutFunds(response);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());

        Fund fund = result.get(0);
        assertEquals("0031", fund.getFundId());
        assertEquals(100, fund.getOwnedShares().intValue());
        assertEquals(5000.0, fund.getFundPosition().getAmount().doubleValue(), 0.01);
        assertEquals("USD", fund.getFundPosition().getCurrency());
        assertEquals("MULT.EST.CONS.S", fund.getTitle().getName());
        assertEquals("USD", fund.getCurrency().getId());
        assertEquals(2000.0, fund.getAvailableFundPosition().getAmount().doubleValue(), 0.01);
        assertEquals(50.0, fund.getNetAssetValue().getAmount().doubleValue(), 0.01);
    }

    @Test
    public void testMapOutFunds_IncompleteFundProducesNullEntry() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000412", "FUND-012");
        ffmm7.setValCuot(null);
        response.setFfmm7(Collections.singletonList(ffmm7));

        List<Fund> result = fmc7Connection.mapOutFunds(response);

        assertEquals(1, result.size());
        assertNull(result.get(0));
    }

    @Test
    public void testMapOutFunds_UsesFallbacksForTitleAndCurrency() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000412", "FUND-017");
        ffmm7.setdSubPro("   ");
        ffmm7.setIdMonFn(null);
        response.setFfmm7(Collections.singletonList(ffmm7));

        List<Fund> result = fmc7Connection.mapOutFunds(response);

        assertEquals(1, result.size());
        Fund fund = result.get(0);
        assertNotNull(fund);
        assertEquals("FUND-017", fund.getTitle().getName());
        assertEquals("USD", fund.getCurrency().getName());
    }

    @Test
    public void testMapOutFunds_UsesCurrencyCodeWhenDescriptionMissing() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000412", "FUND-019");
        ffmm7.setdMonEsd("   ");
        ffmm7.setIdMonFn("PEN");
        response.setFfmm7(Collections.singletonList(ffmm7));

        List<Fund> result = fmc7Connection.mapOutFunds(response);

        assertEquals(1, result.size());
        Fund fund = result.get(0);
        assertNotNull(fund);
        assertEquals("PEN", fund.getCurrency().getId());
        assertEquals("PEN", fund.getFundPosition().getCurrency());
        assertEquals("PEN", fund.getAvailableFundPosition().getCurrency());
        assertEquals("PEN", fund.getNetAssetValue().getCurrency());
    }

    @Test
    public void testMapOutFunds_UsesSaldoContableWhenAvailableAmountMissing() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000413", "FUND-018");
        ffmm7.setSalDisp(null);
        response.setFfmm7(Collections.singletonList(ffmm7));

        List<Fund> result = fmc7Connection.mapOutFunds(response);

        assertEquals(1, result.size());
        Fund fund = result.get(0);
        assertNotNull(fund);
        assertNotNull(fund.getAvailableFundPosition());
        assertEquals(ffmm7.getSalCont(), fund.getAvailableFundPosition().getAmount());
    }

    @Test
    public void testExecuteFMC7Input_HostAdviceCodeNotNull() {
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("00001171");
        input.setPaginationKey("key123");
        input.setPageSize(10);
        input.setProfileId("PROFILE-01");

        FMC7Response mockResponse = new FMC7Response();
        mockResponse.setHostAdviceCode("2026");
        mockResponse.setHostMessage("Error en la ejecución");
        when(pfmhR015.executeFMC7(any(FMC7Request.class))).thenReturn(mockResponse);
        List<OutputInvestmentFundsDTO> result = fmc7Connection.executeFMC7Input(input);
        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(pfmhR015, times(1)).executeFMC7(any(FMC7Request.class));
    }
    @Test
    public void testMapOutNumberType_CtipnumNotEmpty() {
        String ctipnum = "L";
        String dtipnum = "CODIGO INTERNO DEL BBVA";

        var result = fmc7Connection.mapOutNumberType(ctipnum, dtipnum);

        assertNotNull(result);
        assertEquals(ctipnum, result.getId());
        assertEquals(dtipnum, result.getName());
    }

    @Test
    public void testValidarContratoEnKsanYHost_True() {
        String contratoGlobal = "PE00112233";

        ContractsOut contractOut = new ContractsOut();
        contractOut.setContractList(Collections.singletonList(new ContractDetail()));
        when(ksanR101.executeGetContracts(anyList())).thenReturn(contractOut);

        OutputInvestmentFundsDTO dto = new OutputInvestmentFundsDTO();
        InvestmentFund fund = new InvestmentFund();
        fund.setNumber("00112233"); // sin el PE
        dto.setData(Collections.singletonList(fund));

        boolean result = fmc7Connection.validarContratoEnKsanYHost(contratoGlobal, dto);
        assertTrue(result);
    }

    @Test
    public void testGetVisible_DefaultsVisibleWhenKusurNull() {
        fmc7Connection.setKusuR325(null);

        boolean result = fmc7Connection.getVisible("PE00112233", "user123");

        assertTrue(result);
    }

    @Test
    public void testGetVisible_Exception() {
        when(kusuR325.executeGetAliasFavoriteContractsList(anyString(), anyString(), Mockito.<AliasFavContractEntity>anyList()))
                .thenThrow(new RuntimeException("err"));

        assertThrows(RuntimeException.class,
                () -> fmc7Connection.getVisible("PE00112233", "user123"));
    }

    @Test
    public void testGetVisible_DefaultsVisibleWhenListEmpty() {
        when(kusuR325.executeGetAliasFavoriteContractsList(anyString(), anyString(), Mockito.<AliasFavContractEntity>anyList())).thenReturn(Collections.emptyList());

        boolean result = fmc7Connection.getVisible("PE00112233", "user123");

        assertTrue(result);
    }

    @Test
    public void testGetVisible_ReturnsTrueForVisibilityIndicators() {
        for (String indicator : Arrays.asList("true", "Y", " Si ", "sí", " Verdadero ")) {
            AliasFavContractEntity entity = new AliasFavContractEntity();
            entity.setgVisibleContractIndType(indicator);
            when(kusuR325.executeGetAliasFavoriteContractsList(anyString(), anyString(), Mockito.<AliasFavContractEntity>anyList()))
                    .thenReturn(Collections.singletonList(entity));

            assertTrue("Expected visible for indicator: " + indicator,
                    fmc7Connection.getVisible("PE00112233", "user123"));

            Mockito.reset(kusuR325);
            fmc7Connection.setKusuR325(kusuR325);
        }
    }

    @Test
    public void testGetVisible_ReturnsFalseForNegativeIndicators() {
        for (String indicator : Arrays.asList("0", "no", "false")) {
            AliasFavContractEntity entity = new AliasFavContractEntity();
            entity.setgVisibleContractIndType(indicator);
            when(kusuR325.executeGetAliasFavoriteContractsList(anyString(), anyString(), Mockito.<AliasFavContractEntity>anyList()))
                    .thenReturn(Collections.singletonList(entity));

            assertFalse("Expected invisible for indicator: " + indicator,
                    fmc7Connection.getVisible("PE00112233", "user123"));

            Mockito.reset(kusuR325);
            fmc7Connection.setKusuR325(kusuR325);
        }
    }

    @Test
    public void testGetVisible_UsesProvidedProfileWhenHeaderMissing() {
        AliasFavContractEntity entity = new AliasFavContractEntity();
        entity.setgVisibleContractIndType("Y");

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("providedProfile"), eq("providedProfile"),
                Mockito.<AliasFavContractEntity>anyList())).thenReturn(Collections.singletonList(entity));

        assertTrue(fmc7Connection.getVisible("PE00112233", "providedProfile"));

        verify(kusuR325).executeGetAliasFavoriteContractsList(eq("providedProfile"), eq("providedProfile"),
                Mockito.<AliasFavContractEntity>anyList());
    }

    @Test
    public void testGetVisible_PrefersProvidedProfileOverHeader() {
        reset(kusuR325);
        CommonRequestHeader header = headerWithIdentifiers("headerUser", "headerProfile");
        assignTransactionRequestHeader(header);

        AliasFavContractEntity entity = aliasContract("PE00112233", "Y");
        when(kusuR325.executeGetAliasFavoriteContractsList(eq("providedProfile"), eq("providedProfile"),
                Mockito.<AliasFavContractEntity>anyList())).thenReturn(Collections.singletonList(entity));

        assertTrue(fmc7Connection.getVisible("PE00112233", "providedProfile"));

        verify(kusuR325).executeGetAliasFavoriteContractsList(eq("providedProfile"), eq("providedProfile"),
                Mockito.<AliasFavContractEntity>anyList());
    }

    @Test
    public void testGetVisible_DefaultsToTrueWhenIndicatorMissing() {
        for (String indicator : Arrays.asList(null, "", "   ")) {
            AliasFavContractEntity entity = new AliasFavContractEntity();
            entity.setgVisibleContractIndType(indicator);
            when(kusuR325.executeGetAliasFavoriteContractsList(anyString(), anyString(), Mockito.<AliasFavContractEntity>anyList()))
                    .thenReturn(Collections.singletonList(entity));

            assertTrue("Expected visible when indicator is missing: " + indicator,
                    fmc7Connection.getVisible("PE00112233", "user123"));

            Mockito.reset(kusuR325);
            fmc7Connection.setKusuR325(kusuR325);
        }
    }

    @Test
    public void testGetVisible_ReturnsTrueWhenMatchingContractHasIndicator() {
        AliasFavContractEntity nonMatching = new AliasFavContractEntity();
        nonMatching.setGContractId("PE00000000");
        nonMatching.setgVisibleContractIndType("N");

        AliasFavContractEntity matching = new AliasFavContractEntity();
        matching.setGContractId("PE00112233");
        matching.setgVisibleContractIndType("Y");

        when(kusuR325.executeGetAliasFavoriteContractsList(anyString(), anyString(), Mockito.<AliasFavContractEntity>anyList()))
                .thenReturn(Arrays.asList(nonMatching, matching));

        assertTrue(fmc7Connection.getVisible("PE00112233", "user123"));
    }

    @Test
    public void testGetVisible_SupportsBooleanIndicator() {
        AliasFavContractEntity entity = new BooleanAliasFavContractEntity(Boolean.TRUE);
        entity.setGContractId("PE00112233");

        when(kusuR325.executeGetAliasFavoriteContractsList(anyString(), anyString(), Mockito.<AliasFavContractEntity>anyList()))
                .thenReturn(Collections.singletonList(entity));

        assertTrue(fmc7Connection.getVisible("PE00112233", "user123"));
    }

    @Test
    public void testGetVisibilityIndicator_ReturnsNullWhenEntityIsNull() throws Exception {
        Method method = FMC7Connection.class.getDeclaredMethod("getVisibilityIndicator", AliasFavContractEntity.class);
        method.setAccessible(true);

        Object indicator = method.invoke(fmc7Connection, new Object[]{null});

        assertNull(indicator);
    }

    @Test
    public void testGetVisibilityIndicator_ReturnsExtractedBoolean() throws Exception {
        AliasFavContractEntity entity = new AliasFavContractEntity() {
            @Override
            public String toString() {
                return "AliasFavContractEntity [gVisibleContractIndType=true, gContractId=PE00112233]";
            }
        };
        Method method = FMC7Connection.class.getDeclaredMethod("getVisibilityIndicator", AliasFavContractEntity.class);
        method.setAccessible(true);

        Object indicator = method.invoke(fmc7Connection, entity);

        assertTrue(indicator instanceof Boolean);
        assertEquals(Boolean.TRUE, indicator);
    }

    @Test
    public void testGetVisibilityIndicator_ReturnsNullWhenIndicatorUnavailable() throws Exception {
        AliasFavContractEntity entity = new AliasFavContractEntity() {
            @Override
            public String toString() {
                return "AliasFavContractEntity [gContractId=PE00112233]";
            }
        };
        Method method = FMC7Connection.class.getDeclaredMethod("getVisibilityIndicator", AliasFavContractEntity.class);
        method.setAccessible(true);

        Object indicator = method.invoke(fmc7Connection, entity);

        assertNull(indicator);
    }

    @Test
    public void testGetVisibilityIndicator_ReturnsNullForExplicitNullValue() throws Exception {
        AliasFavContractEntity entity = new AliasFavContractEntity() {
            @Override
            public String toString() {
                return "AliasFavContractEntity [gVisibleContractIndType=null, gContractId=PE00112233]";
            }
        };
        Method method = FMC7Connection.class.getDeclaredMethod("getVisibilityIndicator", AliasFavContractEntity.class);
        method.setAccessible(true);

        Object indicator = method.invoke(fmc7Connection, entity);

        assertNull(indicator);
    }

    private static final class BooleanAliasFavContractEntity extends AliasFavContractEntity {
        private final Boolean gVisibleContractIndType;

        private BooleanAliasFavContractEntity(Boolean indicator) {
            this.gVisibleContractIndType = indicator;
        }

        @Override
        public String getgVisibleContractIndType() {
            throw new ClassCastException("java.lang.Boolean cannot be cast to class java.lang.String");
        }

        @Override
        public String toString() {
            return "AliasFavContractEntity [" +
                    "gVisibleContractIndType=" + gVisibleContractIndType +
                    ", gContractId=" + getGContractId() +
                    "]";
        }
    }

    @Test
    public void testValidarContratoEnKsanYHost_ContratoKsanNull() {
        OutputInvestmentFundsDTO dto = new OutputInvestmentFundsDTO();
        InvestmentFund fund = new InvestmentFund();
        fund.setNumber("00112233");
        dto.setData(Collections.singletonList(fund));

        boolean result = fmc7Connection.validarContratoEnKsanYHost(null, dto);
        assertFalse(result);
    }

    @Test
    public void testValidateContractHostLocal_NullDto() {
        boolean result = fmc7Connection.validateContractHostLocal(null, "PE00112233");

        assertFalse(result);
    }

    @Test
    public void testValidateContractHostLocal_EmptyData() {
        OutputInvestmentFundsDTO dto = new OutputInvestmentFundsDTO();
        dto.setData(Collections.emptyList());

        boolean result = fmc7Connection.validateContractHostLocal(dto, "PE00112233");

        assertFalse(result);
    }

    @Test
    public void testMapFMC7ouput_PaginationMapped() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000412", "FUND-001");
        response.setFfmm7(Collections.singletonList(ffmm7));
        FFMMPagination pagination = new FFMMPagination();
        pagination.setIdpagin("nextKey");
        pagination.setTampagi(20);
        response.setPagination(pagination);

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
        input.setProfileId("PROFILE-01");

        List<OutputInvestmentFundsDTO> result = fmc7Connection.mapFMC7ouput(response, input);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        for (OutputInvestmentFundsDTO dto : result) {
            IntPaginationDTO outPagination = dto.getDTOIntPagination();
            assertNotNull(outPagination);
            assertEquals("nextKey", outPagination.getPaginationKey());
            assertEquals(Long.valueOf(20), outPagination.getPageSize());
        }
    }

    @Test
    public void testMapFMC7ouput_PaginationWithoutPageSize() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000412", "FUND-002");
        response.setFfmm7(Collections.singletonList(ffmm7));
        FFMMPagination pagination = new FFMMPagination();
        pagination.setIdpagin("nextKey");
        response.setPagination(pagination);

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
        input.setProfileId("PROFILE-01");

        List<OutputInvestmentFundsDTO> result = fmc7Connection.mapFMC7ouput(response, input);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        for (OutputInvestmentFundsDTO dto : result) {
            IntPaginationDTO outPagination = dto.getDTOIntPagination();
            assertNotNull(outPagination);
            assertEquals("nextKey", outPagination.getPaginationKey());
            assertNull(outPagination.getPageSize());
        }
    }

    @Test
    public void testMapFMC7ouput_PaginationPropagatedToAllItems() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm1 = buildCompleteFfmm7("001", "FUND-003");
        FFMM7 ffmm2 = buildCompleteFfmm7("002", "FUND-004");
        response.setFfmm7(Arrays.asList(ffmm1, ffmm2));
        FFMMPagination pagination = new FFMMPagination();
        pagination.setIdpagin("cursor");
        pagination.setTampagi(5);
        response.setPagination(pagination);
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
        input.setProfileId("PROFILE-01");
        List<OutputInvestmentFundsDTO> result = fmc7Connection.mapFMC7ouput(response, input);
        assertEquals(2, result.size());
        for (OutputInvestmentFundsDTO dto : result) {
            IntPaginationDTO outPagination = dto.getDTOIntPagination();
            assertNotNull(outPagination);
            assertEquals("cursor", outPagination.getPaginationKey());
            assertEquals(Long.valueOf(5), outPagination.getPageSize());
        }
    }

    @Test
    public void testMapFMC7ouput_SkipsContractsWithoutNumberType() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000412", "FUND-010");
        ffmm7.setcTipNum(null);
        ffmm7.setdTipNum(null);
        response.setFfmm7(Collections.singletonList(ffmm7));

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
        input.setProfileId("PROFILE-01");

        List<OutputInvestmentFundsDTO> result = fmc7Connection.mapFMC7ouput(response, input);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testMapFMC7ouput_PreservesContractWhenFundsIncomplete() {
        FMC7Response response = new FMC7Response();
        FFMM7 ffmm7 = buildCompleteFfmm7("00110122998000000412", "FUND-011");
        ffmm7.setIdSubPr(null);
        response.setFfmm7(Collections.singletonList(ffmm7));

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
        input.setProfileId("PROFILE-01");

        List<OutputInvestmentFundsDTO> result = fmc7Connection.mapFMC7ouput(response, input);

        assertEquals(1, result.size());
        OutputInvestmentFundsDTO dto = result.get(0);
        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());
        InvestmentFund investmentFund = dto.getData().get(0);
        assertNull(investmentFund.getFunds());
    }

    private FFMM7 buildCompleteFfmm7(String contractId, String fundId) {
        FFMM7 ffmm7 = new FFMM7();
        ffmm7.setIdContr(contractId);
        ffmm7.setIdSubPr(fundId);
        ffmm7.setdSubPro("MULT.EST.CONS.S");
        ffmm7.setNumCuot(BigDecimal.ONE);
        ffmm7.setSalCont(BigDecimal.TEN);
        ffmm7.setSalDisp(BigDecimal.ZERO);
        ffmm7.setdMonEsd("USD");
        ffmm7.setIdMonFn("USD");
        ffmm7.setValCuot(BigDecimal.ONE);
        ffmm7.setcTipNum("L");
        ffmm7.setdTipNum("CODIGO INTERNO DEL BBVA");
        return ffmm7;
    }

    @Test
    public void testHasMandatoryFundFields_CoversPositiveAndNegativeCases() throws Exception {
        Method hasMandatoryFundFields = FMC7Connection.class.getDeclaredMethod("hasMandatoryFundFields", FFMM7.class);
        hasMandatoryFundFields.setAccessible(true);

        FFMM7 valid = buildCompleteFfmm7("001", "FUND-013");
        boolean validResult = (Boolean) hasMandatoryFundFields.invoke(fmc7Connection, valid);
        assertTrue(validResult);

        FFMM7 fallback = buildCompleteFfmm7("002", "FUND-014");
        fallback.setSalDisp(null);
        boolean fallbackResult = (Boolean) hasMandatoryFundFields.invoke(fmc7Connection, fallback);
        assertTrue(fallbackResult);

        FFMM7 missing = buildCompleteFfmm7("003", "FUND-015");
        missing.setIdSubPr(null);
        boolean missingResult = (Boolean) hasMandatoryFundFields.invoke(fmc7Connection, missing);
        assertFalse(missingResult);

        FFMM7 missingAvailable = buildCompleteFfmm7("004", "FUND-016");
        missingAvailable.setSalDisp(null);
        missingAvailable.setSalCont(null);
        boolean missingAvailableResult = (Boolean) hasMandatoryFundFields.invoke(fmc7Connection, missingAvailable);
        assertFalse(missingAvailableResult);
    }

    @Test
    public void testHasFundData_ReturnsFalseWhenMandatoryMissing() throws Exception {
        Method hasFundData = FMC7Connection.class.getDeclaredMethod("hasFundData", FFMM7.class);
        hasFundData.setAccessible(true);

        FFMM7 valid = buildCompleteFfmm7("003", "FUND-015");
        assertTrue((Boolean) hasFundData.invoke(fmc7Connection, valid));

        FFMM7 incomplete = buildCompleteFfmm7("004", "FUND-016");
        incomplete.setNumCuot(null);
        assertFalse((Boolean) hasFundData.invoke(fmc7Connection, incomplete));
    }

    @Test
    public void testToBoolean_WithBooleanValue() throws Exception {
        Method toBoolean = FMC7Connection.class.getDeclaredMethod("toBoolean", Object.class);
        toBoolean.setAccessible(true);

        assertTrue((Boolean) toBoolean.invoke(fmc7Connection, Boolean.TRUE));
        assertFalse((Boolean) toBoolean.invoke(fmc7Connection, Boolean.FALSE));
    }

    @Test
    public void testToBoolean_WithNumericValue() throws Exception {
        Method toBoolean = FMC7Connection.class.getDeclaredMethod("toBoolean", Object.class);
        toBoolean.setAccessible(true);

        assertTrue((Boolean) toBoolean.invoke(fmc7Connection, 1));
        assertTrue((Boolean) toBoolean.invoke(fmc7Connection, 2L));
        assertFalse((Boolean) toBoolean.invoke(fmc7Connection, 0));
    }

    @Test
    public void testToBoolean_WithAffirmativeStrings() throws Exception {
        Method toBoolean = FMC7Connection.class.getDeclaredMethod("toBoolean", Object.class);
        toBoolean.setAccessible(true);

        assertTrue((Boolean) toBoolean.invoke(fmc7Connection, "  sí  "));
        assertTrue((Boolean) toBoolean.invoke(fmc7Connection, "Y"));
        assertFalse((Boolean) toBoolean.invoke(fmc7Connection, "no"));
    }

    @Test
    public void testUnquote() throws Exception {
        Method unquote = FMC7Connection.class.getDeclaredMethod("unquote", String.class);
        unquote.setAccessible(true);

        assertEquals("valor", unquote.invoke(fmc7Connection, "\"valor\""));
        assertEquals("valor", unquote.invoke(fmc7Connection, "'valor'"));
        assertEquals("\"noMatch'", unquote.invoke(fmc7Connection, "\"noMatch'"));
        assertEquals("x", unquote.invoke(fmc7Connection, "x"));
    }

    @Test
    public void testFetchFavoriteContracts_ReusesUserWhenProfileBlank() throws Exception {
        reset(kusuR325);
        Class<?> identificationClass = Class.forName("com.bbva.pfmh.lib.r010.impl.cics.FMC7Connection$IdentificationData");
        Constructor<?> constructor = identificationClass.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Object identification = constructor.newInstance("userOnly", "");

        Method fetchFavoriteContracts = FMC7Connection.class.getDeclaredMethod("fetchFavoriteContracts", String.class,
                identificationClass);
        fetchFavoriteContracts.setAccessible(true);

        AliasFavContractEntity entity = aliasContract("PE00112233", "Y");
        when(kusuR325.executeGetAliasFavoriteContractsList(eq("userOnly"), eq("userOnly"),
                Mockito.<AliasFavContractEntity>anyList()))
                .thenReturn(Collections.singletonList(entity));

        @SuppressWarnings("unchecked")
        List<AliasFavContractEntity> result = (List<AliasFavContractEntity>) fetchFavoriteContracts.invoke(fmc7Connection,
                "PE00112233", identification);

        assertEquals(1, result.size());
        verify(kusuR325).executeGetAliasFavoriteContractsList(eq("userOnly"), eq("userOnly"),
                Mockito.<AliasFavContractEntity>anyList());
    }

    @Test
    public void testFetchFavoriteContracts_ReturnsEmptyWhenIdentifiersMissing() throws Exception {
        reset(kusuR325);
        Class<?> identificationClass = Class.forName("com.bbva.pfmh.lib.r010.impl.cics.FMC7Connection$IdentificationData");
        Constructor<?> constructor = identificationClass.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Object identification = constructor.newInstance(null, "  ");

        Method fetchFavoriteContracts = FMC7Connection.class.getDeclaredMethod("fetchFavoriteContracts", String.class,
                identificationClass);
        fetchFavoriteContracts.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<AliasFavContractEntity> result = (List<AliasFavContractEntity>) fetchFavoriteContracts.invoke(fmc7Connection,
                "PE00112233", identification);

        assertTrue(result.isEmpty());
        verify(kusuR325, never()).executeGetAliasFavoriteContractsList(anyString(), anyString(),
                Mockito.<AliasFavContractEntity>anyList());
    }

    @Test
    public void testFetchFavoriteContracts_NormalizesNullResult() throws Exception {
        reset(kusuR325);
        Class<?> identificationClass = Class.forName("com.bbva.pfmh.lib.r010.impl.cics.FMC7Connection$IdentificationData");
        Constructor<?> constructor = identificationClass.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Object identification = constructor.newInstance("userOnly", "profileId");

        when(kusuR325.executeGetAliasFavoriteContractsList(eq("profileId"), eq("profileId"),
                Mockito.<AliasFavContractEntity>anyList())).thenReturn(null);

        Method fetchFavoriteContracts = FMC7Connection.class.getDeclaredMethod("fetchFavoriteContracts", String.class,
                identificationClass);
        fetchFavoriteContracts.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<AliasFavContractEntity> result = (List<AliasFavContractEntity>) fetchFavoriteContracts.invoke(fmc7Connection,
                "PE00112233", identification);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(kusuR325).executeGetAliasFavoriteContractsList(eq("profileId"), eq("profileId"),
                Mockito.<AliasFavContractEntity>anyList());
    }

    @Test
    public void testApplyFallbackDecision_DefaultsToInvisibleWhenNoIndicatorInformation() throws Exception {
        Class<?> fallbackClass = Class.forName("com.bbva.pfmh.lib.r010.impl.cics.FMC7Connection$VisibilityFallbackState");
        Object none = Enum.valueOf((Class<Enum>) fallbackClass, "NONE");
        Method applyFallbackDecision = FMC7Connection.class.getDeclaredMethod("applyFallbackDecision", fallbackClass);
        applyFallbackDecision.setAccessible(true);

        boolean decision = (Boolean) applyFallbackDecision.invoke(fmc7Connection, none);

        assertFalse(decision);
    }

    @Test
    public void testApplyFallbackDecision_DefaultsToVisibleWhenIndicatorsMissing() throws Exception {
        Class<?> fallbackClass = Class.forName("com.bbva.pfmh.lib.r010.impl.cics.FMC7Connection$VisibilityFallbackState");
        Object missing = Enum.valueOf((Class<Enum>) fallbackClass, "MISSING_INDICATOR");
        Method applyFallbackDecision = FMC7Connection.class.getDeclaredMethod("applyFallbackDecision", fallbackClass);
        applyFallbackDecision.setAccessible(true);

        boolean decision = (Boolean) applyFallbackDecision.invoke(fmc7Connection, missing);

        assertTrue(decision);
    }

    @Test
    public void testApplyFallbackDecision_ExplicitInvisibleOverridesFallback() throws Exception {
        Class<?> fallbackClass = Class.forName("com.bbva.pfmh.lib.r010.impl.cics.FMC7Connection$VisibilityFallbackState");
        Object invisible = Enum.valueOf((Class<Enum>) fallbackClass, "EXPLICIT_INVISIBLE");
        Method applyFallbackDecision = FMC7Connection.class.getDeclaredMethod("applyFallbackDecision", fallbackClass);
        applyFallbackDecision.setAccessible(true);

        boolean decision = (Boolean) applyFallbackDecision.invoke(fmc7Connection, invisible);

        assertFalse(decision);
    }

    @Test
    public void testMapFMC7ouput_OmitsContractWhenValidationFails() {
        FMC7Connection rejectingConnection = new RejectingFMC7Connection();
        rejectingConnection.initializeErrorCodeList();

        FMC7Response response = new FMC7Response();
        response.setFfmm7(Collections.singletonList(buildCompleteFfmm7("00110122998000000412", "FUND-020")));

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
        input.setProfileId("PROFILE-01");

        List<OutputInvestmentFundsDTO> result = rejectingConnection.mapFMC7ouput(response, input);

        assertTrue(result.isEmpty());
    }

    private static final class RejectingFMC7Connection extends FMC7Connection {
        @Override
        public boolean validarContratoEnKsanYHost(String contratoGlobal, OutputInvestmentFundsDTO dto) {
            return false;
        }

        @Override
        public boolean getVisible(String globalContractId, String profileId) {
            return true;
        }
    }


}
