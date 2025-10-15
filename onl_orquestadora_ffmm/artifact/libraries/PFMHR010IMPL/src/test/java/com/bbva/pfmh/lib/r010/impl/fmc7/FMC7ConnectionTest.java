package com.bbva.pfmh.lib.r010.impl.fmc7;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;

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
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.aop.framework.Advised;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FMC7ConnectionTest {

    @Spy
    private Context context;

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
        context = new Context();
        ThreadContext.set(context);
        getObjectIntrospection();
        fmc7Connection.setPfmhR015(pfmhR015);
        fmc7Connection.setKusuR325(kusuR325);
        fmc7Connection.initializeErrorCodeList();
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
    }

    @Test
    public void testMapOutNumberType_NullInput() {
        var result = fmc7Connection.mapOutNumberType(null, null);

        assertNull(result);
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
    public void testExecuteFMC7Input_HostAdviceCodeNotNull() {
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("00001171");
        input.setPaginationKey("key123");
        input.setPageSize(10);

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
    public void testGetVisible_KusurNull() {
        fmc7Connection.setKusuR325(null);

        boolean result = fmc7Connection.getVisible("PE00112233", "user123");

        assertFalse(result);
    }

    @Test
    public void testGetVisible_Exception() {
        when(kusuR325.executeGetAliasFavoriteContractsList(any(), Mockito.<AliasFavContractEntity>anyList()))
                .thenThrow(new RuntimeException("err"));

        assertThrows(RuntimeException.class,
                () -> fmc7Connection.getVisible("PE00112233", "user123"));
    }

    @Test
    public void testGetVisible_EmptyList() {
        when(kusuR325.executeGetAliasFavoriteContractsList(any(), Mockito.<AliasFavContractEntity>anyList())).thenReturn(Collections.emptyList());

        boolean result = fmc7Connection.getVisible("PE00112233", "user123");

        assertFalse(result);
    }

    @Test
    public void testGetVisible_ReturnsTrueForVisibilityIndicators() {
        for (String indicator : Arrays.asList("true", "Y", " Si ", "sí", " Verdadero ")) {
            AliasFavContractEntity entity = new AliasFavContractEntity();
            entity.setgVisibleContractIndType(indicator);
            when(kusuR325.executeGetAliasFavoriteContractsList(any(), Mockito.<AliasFavContractEntity>anyList()))
                    .thenReturn(Collections.singletonList(entity));

            assertTrue("Expected visible for indicator: " + indicator,
                    fmc7Connection.getVisible("PE00112233", "user123"));

            Mockito.reset(kusuR325);
            fmc7Connection.setKusuR325(kusuR325);
        }
    }

    @Test
    public void testGetVisible_ReturnsFalseForNegativeIndicators() {
        for (String indicator : Arrays.asList(null, "", "0", "no", "false")) {
            AliasFavContractEntity entity = new AliasFavContractEntity();
            entity.setgVisibleContractIndType(indicator);
            when(kusuR325.executeGetAliasFavoriteContractsList(any(), Mockito.<AliasFavContractEntity>anyList()))
                    .thenReturn(Collections.singletonList(entity));

            assertFalse("Expected invisible for indicator: " + indicator,
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

        when(kusuR325.executeGetAliasFavoriteContractsList(any(), Mockito.<AliasFavContractEntity>anyList()))
                .thenReturn(Arrays.asList(nonMatching, matching));

        assertTrue(fmc7Connection.getVisible("PE00112233", "user123"));
    }

    @Test
    public void testGetVisible_SupportsBooleanIndicator() {
        AliasFavContractEntity entity = new BooleanAliasFavContractEntity(Boolean.TRUE);
        entity.setGContractId("PE00112233");

        when(kusuR325.executeGetAliasFavoriteContractsList(any(), Mockito.<AliasFavContractEntity>anyList()))
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
        FFMM7 ffmm7 = new FFMM7();
        ffmm7.setIdContr("00110122998000000412");
        response.setFfmm7(Collections.singletonList(ffmm7));
        FFMMPagination pagination = new FFMMPagination();
        pagination.setIdpagin("nextKey");
        pagination.setTampagi(20);
        response.setPagination(pagination);

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");

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
        FFMM7 ffmm7 = new FFMM7();
        ffmm7.setIdContr("00110122998000000412");
        response.setFfmm7(Collections.singletonList(ffmm7));
        FFMMPagination pagination = new FFMMPagination();
        pagination.setIdpagin("nextKey");
        response.setPagination(pagination);

        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");

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
        FFMM7 ffmm1 = new FFMM7();
        ffmm1.setIdContr("001");
        FFMM7 ffmm2 = new FFMM7();
        ffmm2.setIdContr("002");
        response.setFfmm7(Arrays.asList(ffmm1, ffmm2));
        FFMMPagination pagination = new FFMMPagination();
        pagination.setIdpagin("cursor");
        pagination.setTampagi(5);
        response.setPagination(pagination);
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setCustomerId("123");
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
}