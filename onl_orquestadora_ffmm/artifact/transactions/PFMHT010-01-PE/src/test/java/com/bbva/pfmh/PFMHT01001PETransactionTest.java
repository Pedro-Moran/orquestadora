package com.bbva.pfmh;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.LinksDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.PaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.*;
import com.bbva.pfmh.lib.r010.PFMHR010;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClientException;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class PFMHT01001PETransactionTest {

    private Map<String, Object> parameters;
    private Map<Class<?>, Object> serviceLibraries;

    @Mock
    private ApplicationConfigurationService applicationConfigurationService;

    @Mock
    private CommonRequestHeader commonRequestHeader;

    @Mock
    private PFMHR010 pfmhR010;

    @Mock
    private InputListInvestmentFundsDTO inputListInvestmentFundsDTO;

    private final PFMHT01001PETransaction transaction = new PFMHT01001PETransaction() {
        @Override
        protected void addParameter(String field, Object obj) {
            if (parameters != null) {
                parameters.put(field, obj);
            }
        }

        @Override
        protected Object getParameter(String field) {
            return parameters.get(field);
        }

        @Override
        protected <T> T getServiceLibrary(Class<T> serviceInterface) {
            return (T) serviceLibraries.get(serviceInterface);
        }

        @Override
        public String getProperty(String keyProperty) {
            return applicationConfigurationService.getProperty(keyProperty);
        }

        @Override
        protected CommonRequestHeader getRequestHeader() {
            return commonRequestHeader;
        }
    };

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initializeTransaction();

        setServiceLibrary(PFMHR010.class, pfmhR010);
        setParameterToTransaction("InputListInvestmentFundsDTO", inputListInvestmentFundsDTO);

        when(inputListInvestmentFundsDTO.getCustomerId()).thenReturn("L40632175");
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(null);
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
        when(inputListInvestmentFundsDTO.getProfileId()).thenReturn("PROFILE-01");
    }

    private void initializeTransaction() {
        transaction.setContext(new Context());
        parameters = new HashMap<>();
        serviceLibraries = new HashMap<>();
    }

    private void setServiceLibrary(Class<?> clasz, Object mockObject) {
        serviceLibraries.put(clasz, mockObject);
    }

    private void setParameterToTransaction(String parameter, Object value) {
        parameters.put(parameter, value);
    }

    private InvestmentFund createFund(String id) {
        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentFundId(id);
        fund.setNumber(id);
        return fund;
    }

    private OutputInvestmentFundsDTO buildEnvelope(InvestmentFund... funds) {
        OutputInvestmentFundsDTO dto = new OutputInvestmentFundsDTO();
        if (funds == null || funds.length == 0) {
            dto.setData(Collections.emptyList());
        } else {
            dto.setData(Arrays.asList(funds));
        }
        return dto;
    }

    private InvestmentFund createFundWithoutIdentifiers(String alias) {
        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentFundId(null);
        fund.setNumber(null);
        fund.setAlias(alias);
        return fund;
    }

    @SuppressWarnings("unchecked")
    private <T> T invokeTransactionMethod(String methodName, Class<?>[] parameterTypes, Object... args)
            throws Exception {
        return invokeTransactionMethod(transaction, methodName, parameterTypes, args);
    }

    @SuppressWarnings("unchecked")
    private <T> T invokeTransactionMethod(Object target, String methodName, Class<?>[] parameterTypes, Object... args)
            throws Exception {

        Method method;
        try {
            method = PFMHT01001PETransaction.class.getDeclaredMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException ex) {
            method = null;
            for (Method candidate : PFMHT01001PETransaction.class.getDeclaredMethods()) {
                if (!candidate.getName().equals(methodName)) continue;

                Class<?>[] candidateParams = candidate.getParameterTypes();
                if (candidateParams.length != parameterTypes.length) continue;

                boolean compatible = true;
                for (int i = 0; i < candidateParams.length; i++) {
                    Class<?> provided = parameterTypes[i];
                    if (provided != null && !provided.isAssignableFrom(candidateParams[i])) {
                        compatible = false;
                        break;
                    }
                }

                if (compatible) {
                    method = candidate;
                    break;
                }
            }

            if (method == null) {
                for (Method candidate : PFMHT01001PETransaction.class.getDeclaredMethods()) {
                    if (candidate.getName().equals(methodName)) {
                        method = candidate;
                        break;
                    }
                }
                if (method == null) throw ex;
            }
        }

        method.setAccessible(true);
        return (T) method.invoke(target, args);
    }

    private void assertNullLinks(LinksDTO links) {
        assertNotNull("DTOLinks no debe ser null", links);
        assertNull(links.getFirst());
        assertNull(links.getLast());
        assertNull(links.getPrevious());
        assertNull(links.getNext());
    }

    private void assertZeroLinks(LinksDTO links) {
        assertNotNull("DTOLinks no debe ser null", links);
        assertTrue("El enlace 'first' debe ser \"0\" o null", links.getFirst() == null || "0".equals(links.getFirst()));
        assertTrue("El enlace 'last' debe ser \"0\" o null", links.getLast() == null || "0".equals(links.getLast()));
        assertNull("El enlace 'previous' debe ser null", links.getPrevious());
        assertNull("El enlace 'next' debe ser null", links.getNext());
    }

    // -----------------------------------------------------------------------------------------
    // Tests
    // -----------------------------------------------------------------------------------------

    @Test
    public void testExposeLinksSoloActualizaPaginacion() throws Exception {
        PaginationDTO pagination = new PaginationDTO();
        LinksDTO links = new LinksDTO();
        links.setFirst("0");

        invokeTransactionMethod(
                "exposeLinks",
                new Class[] { LinksDTO.class, PaginationDTO.class },
                links,
                pagination);

        assertEquals("0", pagination.getDtoLinks().getFirst());

        parameters.keySet().stream()
                .filter("dtolinks"::equalsIgnoreCase)
                .findFirst()
                .ifPresent(k -> assertSame(pagination.getDtoLinks(), parameters.get(k)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testResolvePayloadRetornaSobreVacioCuandoNoHayDatos() throws Exception {
        IntPaginationDTO paginationNode = new IntPaginationDTO();
        paginationNode.setPaginationKey("PK-0");

        List<OutputInvestmentFundsDTO> resolved = invokeTransactionMethod(
                "resolvePayload",
                new Class[] { List.class, IntPaginationDTO.class, Integer.class, int.class },
                Collections.emptyList(),
                paginationNode,
                2,
                0);

        assertEquals(1, resolved.size());
        assertEquals(Collections.emptyList(), resolved.get(0).getData());
        assertEquals(paginationNode, resolved.get(0).getDTOIntPagination());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testResolvePayloadRespetaRespuestaOriginal() throws Exception {
        List<OutputInvestmentFundsDTO> sanitized = Collections.singletonList(buildEnvelope(createFund("F0")));

        List<OutputInvestmentFundsDTO> resolved = invokeTransactionMethod(
                "resolvePayload",
                new Class[] { List.class, IntPaginationDTO.class, Integer.class, int.class },
                sanitized,
                null,
                null,
                0);

        assertSame(sanitized, resolved);
    }

    @Test
    public void testResolveLinksManejaBaseNula() throws Exception {
        LinksDTO links = invokeTransactionMethod(
                "resolveLinks",
                new Class[] { LinksDTO.class, int.class, int.class },
                null,
                0,
                0);

        assertNotNull(links);
        assertZeroLinks(links);
    }

    /**
     * FIX: el host pagina con key "0" y el fetchAllFromHost acumula dos veces el mismo sobre.
     * Por tanto, el payload final contiene 2 sobres y 2 fondos visibles.
     */
    @Test
    public void testExecute_ResponseNotNull() {
        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("0");
        intPag.setPageSize(10L);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        output.setData(Collections.singletonList(createFund("F0")));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<IntPaginationDTO> intPaginationCaptor = ArgumentCaptor.forClass(IntPaginationDTO.class);

        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(intPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenReturn(response, Collections.emptyList());

        spyTransaction.execute();

        assertEquals(Severity.OK, spyTransaction.getSeverity());

        verify(spyTransaction).setResponseOut(responseCaptor.capture());
        List<OutputInvestmentFundsDTO> capturedResponse = responseCaptor.getValue();

        assertEquals(1, capturedResponse.size());

        OutputInvestmentFundsDTO dto = capturedResponse.get(0);
        assertNotNull(dto);
        assertNotNull(dto.getData());
        assertEquals(1, dto.getData().size());
        assertEquals("F0", dto.getData().get(0).getInvestmentFundId());

        assertEquals(intPag, dto.getDTOIntPagination());

        assertNotNull(dto.getDTOPagination());
        assertNotNull(dto.getDTOPagination().getDtoLinks());

        assertEquals(intPag, intPaginationCaptor.getValue());
        assertEquals(1, dataCaptor.getValue().size());

        PaginationDTO dtoPagination = dtoPaginationCaptor.getValue();
        assertNotNull(dtoPagination);
        assertNotNull(dtoPagination.getDtoLinks());
    }


    @Test
    public void testExecute_ResponseNull() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);

        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(null);

        spyTransaction.execute();

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        verify(pfmhR010, times(1)).executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class));

        List<OutputInvestmentFundsDTO> captured = responseCaptor.getValue();
        assertEquals(1, captured.size());
        assertEquals(Collections.emptyList(), captured.get(0).getData());
        assertNull(captured.get(0).getDTOIntPagination());

        verify(spyTransaction, times(0)).setDTOIntPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());

        PaginationDTO dtoPagination = dtoPaginationCaptor.getValue();
        assertNotNull(dtoPagination);
        assertZeroLinks(dtoPagination.getDtoLinks());
    }

    @Test
    public void testExecute_InputNullTriggersFailure() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);
        doReturn(null).when(spyTransaction).getInputlistinvestmentfundsdto();

        spyTransaction.execute();

        ArgumentCaptor<PaginationDTO> pagCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        verify(spyTransaction).setDTOPagination(pagCaptor.capture());

        PaginationDTO pag = pagCaptor.getValue();
        assertNotNull(pag.getDtoLinks());
        assertZeroLinks(pag.getDtoLinks());
    }

    /**
     * FIX: por la doble iteración del host, next queda igual al id (fondo duplicado como “siguiente”).
     */
    @Test
    public void testExecute_ResponseWithFullInvestmentFundStructure() {
        InvestmentFundNumberType numberType = new InvestmentFundNumberType();
        numberType.setId("LIC");
        numberType.setName("CODIGO INTERNO DEL BBVA");

        InvestmentFundType investmentFundType = new InvestmentFundType();
        investmentFundType.setId("SIMPLE");
        investmentFundType.setName("SIMPLE");

        Title title = new Title();
        title.setId("0011");
        title.setName("MED P. SOL");

        FundCurrency currency = new FundCurrency();
        currency.setId("PEN");
        currency.setName("SOLES");

        FundPosition fundPosition = new FundPosition();
        fundPosition.setAmount(new BigDecimal("621.32"));
        fundPosition.setCurrency("PEN");

        NetAssetValue netAssetValue = new NetAssetValue();
        netAssetValue.setAmount(new BigDecimal("311.54220063"));
        netAssetValue.setCurrency("PEN");

        AvailableFundPosition availableFundPosition = new AvailableFundPosition();
        availableFundPosition.setAmount(new BigDecimal("621.32"));
        availableFundPosition.setCurrency("PEN");

        Fund subFund = new Fund();
        subFund.setFundId("0011");
        subFund.setAlias(null);
        subFund.setOwnedShares(new BigDecimal("1.99433714"));
        subFund.setFundPosition(fundPosition);
        subFund.setNetAssetValue(netAssetValue);
        subFund.setAccountedBalance(null);
        subFund.setTitle(title);
        subFund.setSerie(null);
        subFund.setNumberFormats(null);
        subFund.setCategories(null);
        subFund.setCurrency(currency);
        subFund.setOpeningDate(null);
        subFund.setCountry(null);
        subFund.setNetAssetValueDate(null);
        subFund.setAssets(null);
        subFund.setCurrentYearReturn(null);
        subFund.setLastYearReturn(null);
        subFund.setManagerCompany(null);
        subFund.setAvailableFundPosition(availableFundPosition);

        List<Fund> subFunds = Collections.singletonList(subFund);

        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentFundId("Y2M4NTZHWXl1bkFyZmxjWDFRWTM");
        fund.setNumber("00110814108000036095");
        fund.setNumberType(numberType);
        fund.setInvestmentFundType(investmentFundType);
        fund.setFunds(subFunds);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setData(Collections.singletonList(fund));
        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("0");
        intPag.setPageSize(10L);
        output.setDTOIntPagination(intPag);

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);

        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response, Collections.emptyList());

        spyTransaction.execute();

        assertEquals(Severity.OK, spyTransaction.getSeverity());

        PaginationDTO dtoPagination = dtoPaginationCaptor.getValue();
        assertNotNull(dtoPagination);
        LinksDTO links = dtoPagination.getDtoLinks();
        assertNotNull(links);

        assertEquals(fund.getInvestmentFundId(), links.getFirst());
        assertEquals(fund.getInvestmentFundId(), links.getLast());

        assertNull(links.getNext());
        assertNull(links.getPrevious());

        List<InvestmentFund> aggregatedFunds = dataCaptor.getValue();
        assertEquals(1, aggregatedFunds.size());
        assertEquals(fund, aggregatedFunds.get(0));
    }

    @Test
    public void testExecute_RestClientException_Propagates() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenThrow(new RestClientException("Error de prueba"));

        assertThrows(RestClientException.class, spyTransaction::execute);

        verify(spyTransaction, never()).setResponseOut(any());
    }

    @Test
    public void testBuildServiceRequestClonaDatosBasicos() throws Exception {
        InputListInvestmentFundsDTO original = new InputListInvestmentFundsDTO();
        original.setCustomerId("CLIENTE");
        original.setProfileId("PERFIL");
        original.setPaginationKey("IGNORADO");
        original.setPageSize(20);

        InputListInvestmentFundsDTO copy = invokeTransactionMethod(
                "buildServiceRequest",
                new Class[] { InputListInvestmentFundsDTO.class },
                original);

        assertNotSame(original, copy);
        assertEquals("CLIENTE", copy.getCustomerId());
        assertEquals("PERFIL", copy.getProfileId());
        assertEquals("IGNORADO", copy.getPaginationKey());
        assertEquals(Integer.valueOf(20), copy.getPageSize());
    }

    // buildServiceRequest(null) ahora retorna DTO vacío, no null
    @Test
    public void testBuildServiceRequestConEntradaNula() throws Exception {
        InputListInvestmentFundsDTO copy = invokeTransactionMethod(
                "buildServiceRequest",
                new Class[] { InputListInvestmentFundsDTO.class },
                new Object[] { null });

        assertNotNull(copy);
        assertNull(copy.getCustomerId());
        assertNull(copy.getProfileId());
        assertNull(copy.getPaginationKey());
        assertNull(copy.getPageSize());
    }

    @Test
    public void testHandleFailureExponeRespuestaEstructurada() throws Exception {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List<OutputInvestmentFundsDTO>> responseCaptor = ArgumentCaptor.forClass((Class) List.class);
        ArgumentCaptor<PaginationDTO> pagCaptor = ArgumentCaptor.forClass(PaginationDTO.class);

        doNothing().when(spyTransaction).setResponseOut(anyList());
        doNothing().when(spyTransaction).setPagination(any(PaginationDTO.class));
        doNothing().when(spyTransaction).setDTOPagination(any(PaginationDTO.class));
        doNothing().when(spyTransaction).setData(anyList());

        invokeTransactionMethod(spyTransaction, "handleFailure", new Class[] {} );

        verify(spyTransaction, times(1)).setResponseOut(responseCaptor.capture());
        verify(spyTransaction).setPagination(pagCaptor.capture());
        verify(spyTransaction).setDTOPagination(any(PaginationDTO.class));

        assertEquals(Severity.ENR, spyTransaction.getSeverity());

        List<OutputInvestmentFundsDTO> response = responseCaptor.getValue();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Collections.emptyList(), response.get(0).getData());
        assertNull(response.get(0).getDTOIntPagination());

        PaginationDTO pagination = pagCaptor.getValue();
        assertNotNull(pagination);
        assertNotNull(pagination.getDtoLinks());
        assertZeroLinks(pagination.getDtoLinks());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testNormalizeResponseRetornaListaVaciaSiEsNula() throws Exception {
        List<OutputInvestmentFundsDTO> empty = invokeTransactionMethod("normalizeResponse", new Class[] { List.class },
                new Object[] { null });
        assertNotNull(empty);
        assertTrue(empty.isEmpty());

        List<OutputInvestmentFundsDTO> provided = Collections.singletonList(new OutputInvestmentFundsDTO());
        List<OutputInvestmentFundsDTO> normalized = invokeTransactionMethod("normalizeResponse",
                new Class[] { List.class }, provided);
        assertSame(provided, normalized);
    }

    @Test
    public void testExecute_UsesPaginationKeyToSliceResults() {
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn("F1");
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(2);

        OutputInvestmentFundsDTO out = buildEnvelope(
                createFund("F0"), createFund("F1"), createFund("F2"), createFund("F3"));
        List<OutputInvestmentFundsDTO> response = Collections.singletonList(out);

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOPagination(any());

        when(pfmhR010.executeGetFFMMStatements(any())).thenReturn(response);

        spyTransaction.execute();

        List<InvestmentFund> visible = dataCaptor.getValue();
        assertEquals(2, visible.size());
        assertEquals("F1", visible.get(0).getInvestmentFundId());
    }

    @Test
    public void testFilterNonNullFundsOmiteNulos() throws Exception {
        InvestmentFund present = createFund("OK");
        List<InvestmentFund> sanitized = invokeTransactionMethod(
                "filterNonNullFunds",
                new Class[] { List.class },
                Arrays.asList(present, null));

        assertEquals(1, sanitized.size());
        assertSame(present, sanitized.get(0));
    }

    @Test
    public void testSanitizeFundsEliminaReferenciasNulas() throws Exception {
        InvestmentFund first = createFund("F1");
        InvestmentFund second = createFund("F2");

        List<InvestmentFund> cleaned = invokeTransactionMethod(
                "sanitizeFunds",
                new Class[] { List.class },
                Arrays.asList(first, null, second));

        assertEquals(2, cleaned.size());
        assertEquals("F1", cleaned.get(0).getInvestmentFundId());
        assertEquals("F2", cleaned.get(1).getInvestmentFundId());

        List<InvestmentFund> empty = invokeTransactionMethod(
                "sanitizeFunds",
                new Class[] { List.class },
                Arrays.asList(null, null));

        assertTrue(empty.isEmpty());
    }

    @Test
    public void testSanitizeResponseDepuraSobresYNulos() throws Exception {
        OutputInvestmentFundsDTO envelope = buildEnvelope(createFund("ID-1"), null);

        List<OutputInvestmentFundsDTO> sanitized = invokeTransactionMethod(
                "sanitizeResponse",
                new Class[] { List.class },
                Arrays.asList(null, envelope));

        assertEquals(1, sanitized.size());
        assertEquals(1, sanitized.get(0).getData().size());

        List<OutputInvestmentFundsDTO> empty = invokeTransactionMethod(
                "sanitizeResponse",
                new Class[] { List.class },
                Collections.emptyList());

        assertTrue(empty.isEmpty());
    }

    @Test
    public void testApplyPageSizeSegmentaSobres() throws Exception {
        OutputInvestmentFundsDTO first = buildEnvelope(createFund("F0"), createFund("F1"));
        OutputInvestmentFundsDTO second = buildEnvelope(createFund("F2"));

        List<OutputInvestmentFundsDTO> limited = invokeTransactionMethod(
                "applyPageSize",
                new Class[] { List.class, Integer.class, int.class },
                Arrays.asList(first, second),
                2,
                1);

        assertEquals(2, limited.size());
        assertEquals("F1", limited.get(0).getData().get(0).getInvestmentFundId());
        assertEquals("F2", limited.get(1).getData().get(0).getInvestmentFundId());
    }

    @Test
    public void testApplyPageSizeVaciaCuandoOffsetExcedeFondos() throws Exception {
        OutputInvestmentFundsDTO only = buildEnvelope(createFund("F0"));

        List<OutputInvestmentFundsDTO> limited = invokeTransactionMethod(
                "applyPageSize",
                new Class[] { List.class, Integer.class, int.class },
                Collections.singletonList(only),
                1,
                5);

        assertTrue(limited.isEmpty());
    }

    @Test
    public void testApplyPageSizeDescuentaOffsetDeSobresPrevios() throws Exception {
        OutputInvestmentFundsDTO first = buildEnvelope(createFund("F0"));
        OutputInvestmentFundsDTO second = buildEnvelope(createFund("F1"));

        List<OutputInvestmentFundsDTO> limited = invokeTransactionMethod(
                "applyPageSize",
                new Class[] { List.class, Integer.class, int.class },
                Arrays.asList(first, second),
                1,
                1);

        assertEquals(1, limited.size());
        assertEquals("F1", limited.get(0).getData().get(0).getInvestmentFundId());
    }

    @Test
    public void testApplyPaginationMetadataSinPaginationSoloExponeIntNode() throws Exception {
        PFMHT01001PETransaction spyTransaction = spy(transaction);
        IntPaginationDTO node = new IntPaginationDTO();

        invokeTransactionMethod(
                spyTransaction,
                "applyPaginationMetadata",
                new Class[] { IntPaginationDTO.class, PaginationDTO.class },
                node,
                null);

        verify(spyTransaction, times(1)).setDTOIntPagination(node);
        verify(spyTransaction, never()).setPagination(any());
        verify(spyTransaction, never()).setDTOPagination(any());
    }

    @Test
    public void testApplyPaginationMetadataReplicaPaginacion() throws Exception {
        PFMHT01001PETransaction spyTransaction = spy(transaction);
        PaginationDTO pagination = new PaginationDTO();

        invokeTransactionMethod(
                spyTransaction,
                "applyPaginationMetadata",
                new Class[] { IntPaginationDTO.class, PaginationDTO.class },
                null,
                pagination);

        verify(spyTransaction, times(1)).setDTOPagination(pagination);
        verify(spyTransaction, never()).setDTOIntPagination(any());
    }

    @Test
    public void testBuildLinksGeneraVecinos() throws Exception {
        InvestmentFund first = createFund("F0");
        InvestmentFund second = createFund("F1");
        InvestmentFund third = createFund("F2");

        LinksDTO links = invokeTransactionMethod(
                "buildLinks",
                new Class[] { List.class, List.class },
                Arrays.asList(first, second, third),
                Collections.singletonList(second));

        assertEquals("F0", links.getFirst());
        assertEquals("F2", links.getLast());
        assertEquals("F0", links.getPrevious());
        assertEquals("F2", links.getNext());
    }

    @Test
    public void testBuildLinksGeneraFallbackPosicionalConPaginacionActiva() throws Exception {
        InvestmentFund primero = createFundWithoutIdentifiers("ALIAS-1");
        InvestmentFund segundo = createFundWithoutIdentifiers("ALIAS-2");

        LinksDTO links = invokeTransactionMethod(
                "buildLinks",
                new Class[] { List.class, List.class },
                Arrays.asList(primero, segundo),
                Arrays.asList(primero));

        assertNotNull(links);

        LinksDTO expected = invokeTransactionMethod(
                "buildPositionalLinks",
                new Class[] { List.class, List.class },
                Arrays.asList(primero, segundo),
                Arrays.asList(primero));

        assertEquals(expected.getFirst(), links.getFirst());
        assertEquals(expected.getLast(), links.getLast());
        assertEquals(expected.getPrevious(), links.getPrevious());
        assertEquals(expected.getNext(), links.getNext());
    }

    @Test
    public void testBuildPositionalLinksUsaIndicesDeLista() throws Exception {
        InvestmentFund first = createFund("F0");
        InvestmentFund second = createFund("F1");
        InvestmentFund third = createFund("F2");

        LinksDTO links = invokeTransactionMethod(
                "buildPositionalLinks",
                new Class[] { List.class, List.class },
                Arrays.asList(first, second, third),
                Arrays.asList(second));

        assertEquals("0", links.getFirst());
        assertEquals("2", links.getLast());
        assertEquals("0", links.getPrevious());
        assertEquals("2", links.getNext());
    }

    @Test
    public void testBuildPositionalLinksRetornaNuloConListaVacia() throws Exception {
        LinksDTO links = invokeTransactionMethod(
                "buildPositionalLinks",
                new Class[] { List.class, List.class },
                Collections.emptyList(),
                Collections.emptyList());

        assertNull(links);
    }

    @Test
    public void testHasAnyLinkValueDetectaValores() throws Exception {
        LinksDTO empty = new LinksDTO();
        boolean none = invokeTransactionMethod("hasAnyLinkValue", new Class[] { LinksDTO.class }, empty);
        assertFalse(none);

        empty.setLast("FINAL");
        boolean some = invokeTransactionMethod("hasAnyLinkValue", new Class[] { LinksDTO.class }, empty);
        assertTrue(some);
    }

    @Test
    public void testBuildLinksRetornaLinksVaciosSinFondos() throws Exception {
        LinksDTO links = invokeTransactionMethod(
                "buildLinks",
                new Class[] { List.class, List.class },
                null,
                null);

        assertNotNull(links);
        assertNull(links.getFirst());
        assertNull(links.getLast());
        assertNull(links.getPrevious());
        assertNull(links.getNext());
    }

    @Test
    public void testCopyLinksCreaInstanciaIndependiente() throws Exception {
        LinksDTO source = new LinksDTO();
        source.setFirst("F0");
        source.setLast("F9");
        source.setPrevious("F1");
        source.setNext("F8");

        LinksDTO copy = invokeTransactionMethod("copyLinks", new Class[] { LinksDTO.class }, source);

        assertNotSame(source, copy);
        assertEquals(source.getFirst(), copy.getFirst());
        assertEquals(source.getLast(), copy.getLast());
        assertEquals(source.getPrevious(), copy.getPrevious());
        assertEquals(source.getNext(), copy.getNext());
    }

    @Test
    public void testClonePaginationCopiaValoresYLinks() throws Exception {
        PaginationDTO pagination = new PaginationDTO();
        pagination.setPage(3L);
        pagination.setPageSize(10L);
        pagination.setTotalElements(50L);
        pagination.setTotalPages(5L);

        LinksDTO links = new LinksDTO();
        links.setFirst("X0");
        links.setLast("X9");
        pagination.setDtoLinks(links);

        PaginationDTO clone = invokeTransactionMethod("clonePagination", new Class[] { PaginationDTO.class }, pagination);

        assertNotSame(pagination, clone);
        assertEquals(3L, clone.getPage().longValue());
        assertEquals(10L, clone.getPageSize().longValue());
        assertEquals(50L, clone.getTotalElements().longValue());
        assertEquals(5L, clone.getTotalPages().longValue());
        assertNotSame(links, clone.getDtoLinks());
        assertEquals("X0", clone.getDtoLinks().getFirst());
        assertEquals("X9", clone.getDtoLinks().getLast());
    }

    @Test
    public void testResolveLinksInicializaCuandoNoHayValores() throws Exception {
        LinksDTO links = invokeTransactionMethod(
                "resolveLinks",
                new Class[] { LinksDTO.class, int.class, int.class },
                null,
                1,
                3);

        assertEquals("0", links.getFirst());
        assertEquals("3", links.getLast());
        assertEquals("0", links.getPrevious());
        assertEquals("2", links.getNext());
    }

    @Test
    public void testResolveLinksNoSobrescribeLinksPresentes() throws Exception {
        LinksDTO base = new LinksDTO();
        base.setFirst("A");
        base.setLast("B");

        LinksDTO links = invokeTransactionMethod(
                "resolveLinks",
                new Class[] { LinksDTO.class, int.class, int.class },
                base,
                0,
                5);

        assertEquals("A", links.getFirst());
        assertEquals("B", links.getLast());
        assertNull(links.getPrevious());
        assertNull(links.getNext());
    }

    @Test
    public void testExposeLinksInicializaSoloEnPagination() throws Exception {
        PaginationDTO pagination = new PaginationDTO();
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        invokeTransactionMethod(
                spyTransaction,
                "exposeLinks",
                new Class[] { LinksDTO.class, PaginationDTO.class },
                null,
                pagination);

        assertNotNull(pagination.getDtoLinks());
        assertNullLinks(pagination.getDtoLinks());
    }

    @Test
    public void testDescribeFundPriorizaIdentificador() throws Exception {
        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentFundId("  IDENTIFICADOR  ");
        fund.setNumber("0001");

        String fromId = invokeTransactionMethod("describeFund", new Class[] { InvestmentFund.class }, fund);
        assertEquals("IDENTIFICADOR", fromId);

        fund.setInvestmentFundId("   ");
        String fromNumber = invokeTransactionMethod("describeFund", new Class[] { InvestmentFund.class }, fund);
        assertEquals("0001", fromNumber);
    }

    @Test
    public void testIndexOfEncuentraPorIdONumber() throws Exception {
        InvestmentFund f0 = new InvestmentFund();
        f0.setInvestmentFundId("ID-1");
        f0.setNumber("N-1");

        InvestmentFund f1 = new InvestmentFund();
        f1.setInvestmentFundId("ID-2");
        f1.setNumber("N-2");

        InvestmentFund targetById = new InvestmentFund();
        targetById.setInvestmentFundId("ID-2");

        int posId = invokeTransactionMethod(
                "indexOf",
                new Class[] { List.class, InvestmentFund.class },
                Arrays.asList(f0, f1), targetById);
        assertEquals(1, posId);

        InvestmentFund targetByNumber = new InvestmentFund();
        targetByNumber.setNumber("N-1");

        int posNumber = invokeTransactionMethod(
                "indexOf",
                new Class[] { List.class, InvestmentFund.class },
                Arrays.asList(f0, f1), targetByNumber);
        assertEquals(0, posNumber);
    }

    @Test
    public void testResolvePageSizePrefiereEntradaYNormaliza() throws Exception {
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setPageSize(15);

        Integer preferred = invokeTransactionMethod(
                "resolvePageSize",
                new Class[] { InputListInvestmentFundsDTO.class },
                input);
        assertEquals(Integer.valueOf(15), preferred);

        input.setPageSize(null);
        Integer nullWhenMissing = invokeTransactionMethod(
                "resolvePageSize",
                new Class[] { InputListInvestmentFundsDTO.class },
                input);
        assertNull(nullWhenMissing);

        input.setPageSize(0);
        Integer nullWhenZero = invokeTransactionMethod(
                "resolvePageSize",
                new Class[] { InputListInvestmentFundsDTO.class },
                input);
        assertNull(nullWhenZero);
    }
    @Test
    public void testNormalizePageSizeGestionaValoresNoPositivosYExtremos() throws Exception {
        Integer nullSize = invokeTransactionMethod(
                "normalizePageSize",
                new Class[] { Long.class },
                new Object[] { null });
        assertNull(nullSize);

        Integer zero = invokeTransactionMethod(
                "normalizePageSize",
                new Class[] { Long.class },
                0L);
        assertNull(zero);

        Integer negative = invokeTransactionMethod(
                "normalizePageSize",
                new Class[] { Long.class },
                -5L);
        assertNull(negative);

        long beyondInt = (long) Integer.MAX_VALUE + 100L;
        Integer capped = invokeTransactionMethod(
                "normalizePageSize",
                new Class[] { Long.class },
                beyondInt);
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), capped);

        Integer valid = invokeTransactionMethod(
                "normalizePageSize",
                new Class[] { Long.class },
                25L);
        assertEquals(Integer.valueOf(25), valid);
    }

    @Test
    public void testSanitizeKeyLimpiaEspacios() throws Exception {
        String sanitized = invokeTransactionMethod("sanitizeKey", new Class[] { String.class }, "   IDENT   ");
        assertEquals("IDENT", sanitized);

        String blank = invokeTransactionMethod("sanitizeKey", new Class[] { String.class }, "   ");
        assertNull(blank);
    }

    // Nuevo comportamiento: IllegalStateException se PROPAGA
    @Test
    public void testExecute_RuntimeException_Propagates() {
        when(pfmhR010.executeGetFFMMStatements(any()))
                .thenThrow(new IllegalStateException("Unexpected error"));

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        assertThrows(IllegalStateException.class, spyTransaction::execute);
    }

    @Test
    public void testExecute_PaginationNextLinkWithDifferentKey() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("1");
        intPag.setPageSize(1L);

        InvestmentFund firstFund = createFund("FUND-1");
        InvestmentFund secondFund = createFund("FUND-2");

        OutputInvestmentFundsDTO out1 = new OutputInvestmentFundsDTO();
        out1.setDTOIntPagination(intPag);
        out1.setData(Collections.singletonList(firstFund));
        OutputInvestmentFundsDTO out2 = new OutputInvestmentFundsDTO();
        out2.setData(Collections.singletonList(secondFund));

        List<OutputInvestmentFundsDTO> response = Arrays.asList(out1, out2);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);

        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = dtoPaginationCaptor.getValue();
        assertNotNull(pagination);
        LinksDTO links = pagination.getDtoLinks();
        assertNull(links.getPrevious());
        assertEquals("FUND-2", links.getNext());
        assertEquals("FUND-1", links.getFirst());
        assertEquals("FUND-2", links.getLast());
    }

    @Test
    public void testExecute_PropagaErroresNoControlados() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenAnswer(invocation -> { throw new AssertionError("error crítico"); });

        assertThrows(AssertionError.class, spyTransaction::execute);

        verify(spyTransaction, never()).setResponseOut(any());
    }

    @Test
    public void testApplyPageSize_OffsetSaltaSobreCompletoYRecortaSegundo() throws Exception {
        OutputInvestmentFundsDTO env1 = buildEnvelope(
                createFund("F0"), createFund("F1"));
        OutputInvestmentFundsDTO env2 = buildEnvelope(
                createFund("F2"), createFund("F3"));

        List<OutputInvestmentFundsDTO> limited = invokeTransactionMethod(
                "applyPageSize",
                new Class[] { List.class, Integer.class, int.class },
                Arrays.asList(env1, env2),
                2,
                3);

        assertEquals(1, limited.size());
        assertEquals(1, limited.get(0).getData().size());
        assertEquals("F3", limited.get(0).getData().get(0).getInvestmentFundId());
    }

    @Test
    public void testResolveStartIndexByCursor_BlankOrNullReturnsZero() throws Exception {
        int idx1 = invokeTransactionMethod(
                "resolveStartIndexByCursor",
                new Class[]{String.class, List.class},
                null, Arrays.asList(createFund("F0")));
        assertEquals(0, idx1);

        int idx2 = invokeTransactionMethod(
                "resolveStartIndexByCursor",
                new Class[]{String.class, List.class},
                "   ", Arrays.asList(createFund("F0")));
        assertEquals(0, idx2);
    }

    @Test
    public void testResolveStartIndexByCursor_MatchByIdOrNumber() throws Exception {
        InvestmentFund f0 = new InvestmentFund();
        f0.setInvestmentFundId("ID-0");
        f0.setNumber("N-0");

        InvestmentFund f1 = new InvestmentFund();
        f1.setInvestmentFundId("ID-1");
        f1.setNumber("N-1");

        List<InvestmentFund> funds = Arrays.asList(f0, f1);

        int byId = invokeTransactionMethod(
                "resolveStartIndexByCursor",
                new Class[]{String.class, List.class},
                "ID-0", funds);
        assertEquals(0, byId);

        int byNumber = invokeTransactionMethod(
                "resolveStartIndexByCursor",
                new Class[]{String.class, List.class},
                "N-1", funds);
        assertEquals(1, byNumber);
    }

    @Test
    public void testResolveStartIndexByCursor_NoMatchReturnsZero() throws Exception {
        int idx = invokeTransactionMethod(
                "resolveStartIndexByCursor",
                new Class[]{String.class, List.class},
                "NOPE", Arrays.asList(createFund("F0"), createFund("F1")));
        assertEquals(0, idx);
    }

    @Test
    public void testApplyPageSize_ReturnsOriginalWhenPageSizeNullOrInvalid() throws Exception {
        List<OutputInvestmentFundsDTO> response = Collections.singletonList(
                buildEnvelope(createFund("F0"), createFund("F1")));

        List<OutputInvestmentFundsDTO> r1 = invokeTransactionMethod(
                "applyPageSize",
                new Class[]{List.class, Integer.class, int.class},
                response, null, 0);
        assertSame(response, r1);

        List<OutputInvestmentFundsDTO> r2 = invokeTransactionMethod(
                "applyPageSize",
                new Class[]{List.class, Integer.class, int.class},
                response, 0, 0);
        assertSame(response, r2);
    }

    @Test
    public void testApplyPageSize_ReturnsOriginalWhenPageFitsAll() throws Exception {
        List<OutputInvestmentFundsDTO> response = Collections.singletonList(
                buildEnvelope(createFund("F0"), createFund("F1")));

        List<OutputInvestmentFundsDTO> r = invokeTransactionMethod(
                "applyPageSize",
                new Class[]{List.class, Integer.class, int.class},
                response, 10, 0);

        assertSame(response, r);
    }

    @Test
    public void testResolveLinks_FillsMissingFirstLastOnly() throws Exception {
        LinksDTO base = new LinksDTO();
        base.setNext("X");

        LinksDTO resolved = invokeTransactionMethod(
                "resolveLinks",
                new Class[]{LinksDTO.class, int.class, int.class},
                base, 0, 3);

        assertEquals("0", resolved.getFirst());
        assertEquals("3", resolved.getLast());
        assertNull(resolved.getPrevious());
        assertEquals("X", resolved.getNext());
    }

    // Nuevo comportamiento: IllegalArgumentException se PROPAGA
    @Test
    public void testExecute_IllegalArgumentException_Propagates() {
        when(pfmhR010.executeGetFFMMStatements(any()))
                .thenThrow(new IllegalArgumentException("boom"));

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        assertThrows(IllegalArgumentException.class, spyTransaction::execute);
    }

    // Nuevo comportamiento: NullPointerException se PROPAGA
    @Test
    public void testExecute_NullPointerException_Propagates() {
        when(pfmhR010.executeGetFFMMStatements(any()))
                .thenThrow(new NullPointerException("boom"));

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        assertThrows(NullPointerException.class, spyTransaction::execute);
    }
    @Test
    public void testFetchAllFromHost_TwoPagesThenEmpty_CoversLoopAndDedup() throws Exception {
        // page1 con PK=K1 y 2 fondos (uno duplicado)
        IntPaginationDTO p1 = new IntPaginationDTO();
        p1.setPaginationKey("K1");

        OutputInvestmentFundsDTO env1 = buildEnvelope(createFund("F0"), createFund("F1"));
        env1.setDTOIntPagination(p1);

        // page2 con PK=K2 y fondos: F1 duplicado + F2 nuevo
        IntPaginationDTO p2 = new IntPaginationDTO();
        p2.setPaginationKey("K2");

        OutputInvestmentFundsDTO env2 = buildEnvelope(createFund("F1"), createFund("F2"));
        env2.setDTOIntPagination(p2);

        // retorno del host: page1, page2, empty para cortar
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenReturn(
                        Collections.singletonList(env1),
                        Collections.singletonList(env2),
                        Collections.emptyList()
                );

        Object full = invokeTransactionMethod(
                "fetchAllFromHost",
                new Class[]{ PFMHR010.class, InputListInvestmentFundsDTO.class },
                pfmhR010,
                new InputListInvestmentFundsDTO()
        );

        // acceder a campos privados envelopes/funds/lastPaginationNode
        java.lang.reflect.Field envelopesF = full.getClass().getDeclaredField("envelopes");
        java.lang.reflect.Field fundsF = full.getClass().getDeclaredField("funds");
        java.lang.reflect.Field lastNodeF = full.getClass().getDeclaredField("lastPaginationNode");
        envelopesF.setAccessible(true);
        fundsF.setAccessible(true);
        lastNodeF.setAccessible(true);

        List<OutputInvestmentFundsDTO> envelopes = (List<OutputInvestmentFundsDTO>) envelopesF.get(full);
        List<InvestmentFund> funds = (List<InvestmentFund>) fundsF.get(full);
        IntPaginationDTO lastNode = (IntPaginationDTO) lastNodeF.get(full);

        assertEquals(2, envelopes.size());             // acumuló 2 páginas
        assertEquals(3, funds.size());                 // dedup: F0, F1, F2
        assertEquals("K2", lastNode.getPaginationKey());// último nodo es page2
    }

    @Test
    public void testFetchAllFromHost_StopsOnCycleKey() throws Exception {
        IntPaginationDTO p1 = new IntPaginationDTO();
        p1.setPaginationKey("K1");

        OutputInvestmentFundsDTO env1 = buildEnvelope(createFund("F0"));
        env1.setDTOIntPagination(p1);

        IntPaginationDTO pCycle = new IntPaginationDTO();
        pCycle.setPaginationKey("K1"); // misma key => ciclo

        OutputInvestmentFundsDTO env2 = buildEnvelope(createFund("F1"));
        env2.setDTOIntPagination(pCycle);

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenReturn(
                        Collections.singletonList(env1),
                        Collections.singletonList(env2)
                );

        Object full = invokeTransactionMethod(
                "fetchAllFromHost",
                new Class[]{ PFMHR010.class, InputListInvestmentFundsDTO.class },
                pfmhR010, new InputListInvestmentFundsDTO()
        );

        java.lang.reflect.Field fundsF = full.getClass().getDeclaredField("funds");
        fundsF.setAccessible(true);
        List<InvestmentFund> funds = (List<InvestmentFund>) fundsF.get(full);

        assertEquals(2, funds.size());
        verify(pfmhR010, times(3)).executeGetFFMMStatements(any());
    }

    @Test
    public void testFilterNewFunds_NullOrEmpty() throws Exception {
        List<InvestmentFund> out = invokeTransactionMethod(
                "filterNewFunds",
                new Class[]{List.class, Set.class},
                null, new HashSet<>());

        assertNotNull(out);
        assertTrue(out.isEmpty());
    }

    @Test
    public void testFilterNewFunds_DeduplicatesByInvestmentFundIdOrNumber() throws Exception {
        InvestmentFund a1 = createFund("A");
        InvestmentFund a2 = createFund("A"); // duplicado
        InvestmentFund b = createFund("B");

        Set<String> seen = new HashSet<>();

        List<InvestmentFund> out = invokeTransactionMethod(
                "filterNewFunds",
                new Class[]{List.class, Set.class},
                Arrays.asList(a1, a2, b), seen);

        assertEquals(2, out.size());
        assertEquals("A", out.get(0).getInvestmentFundId());
        assertEquals("B", out.get(1).getInvestmentFundId());
    }

    @Test
    public void testExtractPagination_FindsFirstNonNull() throws Exception {
        OutputInvestmentFundsDTO envNoPag = buildEnvelope(createFund("F0"));

        IntPaginationDTO p = new IntPaginationDTO();
        p.setPaginationKey("NEXT");

        OutputInvestmentFundsDTO envWithPag = buildEnvelope(createFund("F1"));
        envWithPag.setDTOIntPagination(p);

        IntPaginationDTO found = invokeTransactionMethod(
                "extractPagination",
                new Class[]{List.class},
                Arrays.asList(envNoPag, envWithPag));

        assertEquals("NEXT", found.getPaginationKey());
    }

    @Test
    public void testExtractNextKey_TrimsAndHandlesNull() throws Exception {
        String k1 = invokeTransactionMethod(
                "extractNextKey",
                new Class[]{IntPaginationDTO.class},
                (Object) null);
        assertNull(k1);

        IntPaginationDTO p = new IntPaginationDTO();
        p.setPaginationKey("  K  ");

        String k2 = invokeTransactionMethod(
                "extractNextKey",
                new Class[]{IntPaginationDTO.class},
                p);
        assertEquals("K", k2);
    }

    @Test
    public void testMapPagination_TotalPagesZeroWhenNoElementsOrInvalidPageSize() throws Exception {
        // summary con 0 elementos
        Object summary = invokeTransactionMethod(
                "summarizeResponse",
                new Class[]{List.class, List.class},
                Collections.singletonList(buildEnvelope()),
                Collections.emptyList()
        );

        PaginationDTO pag = invokeTransactionMethod(
                "mapPagination",
                new Class[]{summary.getClass(), LinksDTO.class, Integer.class, int.class},
                summary, new LinksDTO(), 10, 0
        );

        assertEquals(0L, pag.getTotalPages().longValue());
        assertEquals(0L, pag.getTotalElements().longValue());
    }

    @Test
    public void testMapPagination_ComputesPagesAndClampsCurrent() throws Exception {
        // 5 fondos totales / pageSize=2 => totalPages=3 (0,1,2)
        List<InvestmentFund> all = Arrays.asList(
                createFund("F0"), createFund("F1"), createFund("F2"),
                createFund("F3"), createFund("F4")
        );
        Object summary = invokeTransactionMethod(
                "summarizeResponse",
                new Class[]{List.class, List.class},
                Collections.singletonList(buildEnvelope(all.get(0))),
                all
        );

        PaginationDTO pag = invokeTransactionMethod(
                "mapPagination",
                new Class[]{summary.getClass(), LinksDTO.class, Integer.class, int.class},
                summary, new LinksDTO(), 2, 999 // currentPage fuera de rango
        );

        assertEquals(3L, pag.getTotalPages().longValue());
        assertEquals(5L, pag.getTotalElements().longValue());
        assertEquals(2L, pag.getPage().longValue()); // clamp a lastPage
    }

    @Test
    public void testBuildPagedRequest_SetsKeyOnlyWhenProvided_AndForcesHostPageSize() throws Exception {
        InputListInvestmentFundsDTO base = new InputListInvestmentFundsDTO();
        base.setCustomerId("C");
        base.setProfileId("P");
        base.setPaginationKey("BASE");
        base.setPageSize(99);

        InputListInvestmentFundsDTO r1 = invokeTransactionMethod(
                "buildPagedRequest",
                new Class[]{InputListInvestmentFundsDTO.class, String.class},
                base, null);

        assertEquals("BASE", r1.getPaginationKey());

        assertEquals(Integer.valueOf(99), r1.getPageSize());

        InputListInvestmentFundsDTO r2 = invokeTransactionMethod(
                "buildPagedRequest",
                new Class[]{InputListInvestmentFundsDTO.class, String.class},
                base, "NEW");

        assertEquals("NEW", r2.getPaginationKey());

        assertEquals(Integer.valueOf(99), r2.getPageSize());
    }
}