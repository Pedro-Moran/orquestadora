package com.bbva.pfmh;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CompletionException;
import java.math.BigDecimal;
import java.math.BigInteger;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;


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


        // Configurar mocks
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

    private InvestmentFund createFund(String id) {
        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentFundId(id);
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

    private void setParameterToTransaction(String parameter, Object value) {
        parameters.put(parameter, value);
    }

    private Class<?> responseSummaryClass;

    @SuppressWarnings("unchecked")
    private <T> T invokeTransactionMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        return invokeTransactionMethod(transaction, methodName, parameterTypes, args);
    }

    @SuppressWarnings("unchecked")
    private <T> T invokeTransactionMethod(Object target, String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = PFMHT01001PETransaction.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return (T) method.invoke(target, args);
    }

    private Class<?> getResponseSummaryClass() throws Exception {
        if (responseSummaryClass == null) {
            Object sample = invokeTransactionMethod(
                    "summarizeResponse",
                    new Class[]{List.class, List.class},
                    Collections.emptyList(),
                    Collections.emptyList());
            responseSummaryClass = sample.getClass();
        }
        return responseSummaryClass;
    }

    private void assertEmptyLinks(LinksDTO links) {
        // Utilidad centralizada para verificar enlaces vacíos sin saturar cada caso de prueba
        assertNotNull(links);
        assertNull(links.getFirst());
        assertNull(links.getLast());
        assertNull(links.getNext());
        assertNull(links.getPrevious());
    }

    private void assertPaginationDefaults(PaginationDTO pagination, int expectedPageSize) {
        // Verificación compacta del DTO de paginación expuesto por la transacción
        assertNotNull(pagination);
        assertEquals(Integer.valueOf(0), pagination.getTotalElements());
        assertEquals(Integer.valueOf(0), pagination.getTotalPages());
        assertEquals(Integer.valueOf(expectedPageSize), pagination.getPageSize());
        assertEquals(Integer.valueOf(0), pagination.getPage());
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testResolvePayloadRetornaSobreVacioCuandoNoHayDatos() throws Exception {
        IntPaginationDTO paginationNode = new IntPaginationDTO();
        paginationNode.setPaginationKey("PK-0");

        List<OutputInvestmentFundsDTO> resolved = invokeTransactionMethod(
                "resolvePayload",
                new Class[]{List.class, IntPaginationDTO.class, Integer.class, int.class},
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
                new Class[]{List.class, IntPaginationDTO.class, Integer.class, int.class},
                sanitized,
                null,
                null,
                0);

        assertSame(sanitized, resolved);
    }

    @Test
    public void testExecute_ResponseNotNull() {
        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("0");
        intPag.setPageSize(10L);
        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<IntPaginationDTO> intPaginationCaptor = ArgumentCaptor.forClass(IntPaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(intPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        verify(pfmhR010, times(1)).executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class));
        verify(spyTransaction, times(1)).setResponseOut(responseCaptor.capture());
        List<OutputInvestmentFundsDTO> capturedResponse = responseCaptor.getValue();
        assertEquals(1, capturedResponse.size());
        assertEquals(output, capturedResponse.get(0));
        assertEquals(Collections.emptyList(), capturedResponse.get(0).getData());
        verify(spyTransaction, times(1)).setDTOIntPagination(any());
        assertEquals(intPag, intPaginationCaptor.getValue());
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
        verify(spyTransaction, times(1)).setPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(any());
        LinksDTO exposedLinks = linksCaptor.getValue();
        assertEmptyLinks(exposedLinks);
        PaginationDTO pagination = paginationCaptor.getValue();
        assertPaginationDefaults(pagination, 10);
        assertEmptyLinks(pagination.getDTOLinks());
        assertEquals(pagination, dtoPaginationCaptor.getValue());
    }


    @Test
    public void testExecute_ResponseNull() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
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
        verify(spyTransaction, times(1)).setPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(any());
        LinksDTO exposedLinks = linksCaptor.getValue();
        assertEmptyLinks(exposedLinks);
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
        PaginationDTO pagination = paginationCaptor.getValue();
        assertPaginationDefaults(pagination, 10);
        assertEmptyLinks(pagination.getDTOLinks());
        assertEquals(pagination, dtoPaginationCaptor.getValue());
    }

    @Test
    public void testExecute_InputNullTriggersFailure() {
        setParameterToTransaction("InputListInvestmentFundsDTO", null);

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(any());

        spyTransaction.execute();

        verify(pfmhR010, never()).executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class));
        List<OutputInvestmentFundsDTO> response = responseCaptor.getValue();
        assertEquals(1, response.size());
        assertEquals(Collections.emptyList(), response.get(0).getData());
        assertNull(response.get(0).getDTOIntPagination());
        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        PaginationDTO pagination = paginationCaptor.getValue();
        assertPaginationDefaults(pagination, 0);
        assertEquals(pagination, dtoPaginationCaptor.getValue());
        LinksDTO links = linksCaptor.getValue();
        assertEmptyLinks(links);
        assertEmptyLinks(pagination.getDTOLinks());
    }

    @Test
    public void testExecute_ResponseWithFullInvestmentFundStructure() {
        // Poblar numberType
        InvestmentFundNumberType numberType = new InvestmentFundNumberType();
        numberType.setId("LIC");
        numberType.setName("CODIGO INTERNO DEL BBVA");

        // Poblar investmentFundType
        InvestmentFundType investmentFundType = new InvestmentFundType();
        investmentFundType.setId("SIMPLE");
        investmentFundType.setName("SIMPLE");

        // Poblar title
        Title title = new Title();
        title.setId("0011");
        title.setName("MED P. SOL");

        // Poblar currency
        FundCurrency currency = new FundCurrency();
        currency.setId("PEN");
        currency.setName("SOLES");

        // Poblar fundPosition y netAssetValue
        FundPosition fundPosition = new FundPosition();
        fundPosition.setAmount(new BigDecimal("621.32"));
        fundPosition.setCurrency("PEN");

        NetAssetValue netAssetValue = new NetAssetValue();
        netAssetValue.setAmount(new BigDecimal("311.54220063"));
        netAssetValue.setCurrency("PEN");

        // Poblar availableFundPosition
        AvailableFundPosition availableFundPosition = new AvailableFundPosition();
        availableFundPosition.setAmount(new BigDecimal("621.32"));
        availableFundPosition.setCurrency("PEN");

        // Poblar sub-fondo
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

        // Poblar InvestmentFund principal
        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentFundId("Y2M4NTZHWXl1bkFyZmxjWDFRWTM");
        fund.setNumber("00110814108000036095");
        fund.setNumberType(numberType);
        fund.setInvestmentFundType(investmentFundType);
        fund.setFunds(subFunds);

        // Poblar OutputInvestmentFundsDTO
        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setData(Collections.singletonList(fund));
        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("0");
        intPag.setPageSize(10L);
        output.setDTOIntPagination(intPag);

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<IntPaginationDTO> intPaginationCaptor = ArgumentCaptor.forClass(IntPaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(intPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        assertEquals(Severity.OK, spyTransaction.getSeverity());
        verify(pfmhR010, times(1)).executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class));
        verify(spyTransaction, times(1)).setResponseOut(responseCaptor.capture());
        List<OutputInvestmentFundsDTO> capturedResponse = responseCaptor.getValue();
        assertEquals(1, capturedResponse.size());
        assertEquals(output, capturedResponse.get(0));
        verify(spyTransaction, times(1)).setDTOIntPagination(any());
        assertEquals(intPag, intPaginationCaptor.getValue());
        verify(spyTransaction, times(1)).setPagination(any());
        assertEquals(paginationCaptor.getValue(), dtoPaginationCaptor.getValue());
        verify(spyTransaction, times(1)).setDTOLinks(any());
        LinksDTO links = linksCaptor.getValue();
        assertNotNull(links);
        assertEquals(fund.getInvestmentFundId(), links.getFirst());
        assertEquals(fund.getInvestmentFundId(), links.getLast());
        assertNull(links.getNext());
        assertNull(links.getPrevious());
        verify(spyTransaction, times(1)).setData(any());
        List<InvestmentFund> aggregatedFunds = dataCaptor.getValue();
        assertEquals(1, aggregatedFunds.size());
        assertEquals(fund, aggregatedFunds.get(0));
    }

    @Test
    public void testExecute_RestClientException() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenThrow(new RestClientException("Error de prueba"));

        spyTransaction.execute();

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        verify(pfmhR010, times(1)).executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class));
        List<OutputInvestmentFundsDTO> captured = responseCaptor.getValue();
        assertEquals(1, captured.size());
        assertEquals(Collections.emptyList(), captured.get(0).getData());
        assertNull(captured.get(0).getDTOIntPagination());
        verify(spyTransaction, times(0)).setDTOIntPagination(any());
        verify(spyTransaction, times(1)).setPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(any());
        PaginationDTO pagination = paginationCaptor.getValue();
        assertPaginationDefaults(pagination, 0);
        assertEquals(pagination, dtoPaginationCaptor.getValue());
        LinksDTO links = linksCaptor.getValue();
        assertEmptyLinks(links);
        assertEmptyLinks(pagination.getDTOLinks());
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
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
                new Class[]{InputListInvestmentFundsDTO.class},
                original);

        assertNotSame(original, copy);
        assertEquals("CLIENTE", copy.getCustomerId());
        assertEquals("PERFIL", copy.getProfileId());
        assertNull(copy.getPaginationKey());
        assertNull(copy.getPageSize());
    }

    @Test
    public void testBuildServiceRequestConEntradaNula() throws Exception {
        InputListInvestmentFundsDTO copy = invokeTransactionMethod(
                "buildServiceRequest",
                new Class[]{InputListInvestmentFundsDTO.class},
                new Object[]{null});

        assertNull(copy);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testHandleFailureExponeRespuestaEstructurada() throws Exception {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);

        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(any());

        invokeTransactionMethod(spyTransaction, "handleFailure", new Class[]{});

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        List<OutputInvestmentFundsDTO> response = responseCaptor.getValue();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Collections.emptyList(), response.get(0).getData());
        assertNull(response.get(0).getDTOIntPagination());

        PaginationDTO pagination = paginationCaptor.getValue();
        assertNotNull(pagination);
        assertEquals(Integer.valueOf(0), pagination.getPage());
        assertEquals(Integer.valueOf(0), pagination.getPageSize());
        assertEquals(Integer.valueOf(0), pagination.getTotalElements());
        assertEquals(Integer.valueOf(0), pagination.getTotalPages());
        assertEmptyLinks(pagination.getDTOLinks());

        LinksDTO exposedLinks = linksCaptor.getValue();
        assertEmptyLinks(exposedLinks);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testHandleKnownFailureDevuelveOutcomeDeFalla() throws Exception {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(any());

        Object outcome = invokeTransactionMethod(
                spyTransaction,
                "handleKnownFailure",
                new Class[]{Throwable.class},
                new RestClientException("fallo forzado"));

        Class<?> outcomeClass = Class.forName("com.bbva.pfmh.PFMHT01001PETransaction$InvocationOutcome");
        Method failureHandled = outcomeClass.getDeclaredMethod("isFailureHandled");
        Method payload = outcomeClass.getDeclaredMethod("getPayload");
        failureHandled.setAccessible(true);
        payload.setAccessible(true);

        assertTrue((Boolean) failureHandled.invoke(outcome));
        List<OutputInvestmentFundsDTO> handledPayload = (List<OutputInvestmentFundsDTO>) payload.invoke(outcome);
        assertNotNull(handledPayload);
        assertTrue(handledPayload.isEmpty());

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        List<OutputInvestmentFundsDTO> response = responseCaptor.getValue();
        assertEquals(1, response.size());
        assertEquals(Collections.emptyList(), response.get(0).getData());
    }

    @Test
    public void testIsKnownFailureReconoceEscenariosEspecificos() throws Exception {
        boolean restClient = invokeTransactionMethod(
                "isKnownFailure",
                new Class[]{Throwable.class},
                new RestClientException("rest"));
        boolean iae = invokeTransactionMethod(
                "isKnownFailure",
                new Class[]{Throwable.class},
                new IllegalArgumentException("iae"));
        boolean generic = invokeTransactionMethod(
                "isKnownFailure",
                new Class[]{Throwable.class},
                new RuntimeException("otro"));

        assertTrue(restClient);
        assertTrue(iae);
        assertFalse(generic);
    }

    @Test
    public void testUnwrapRetornaCausaDeCompletionException() throws Exception {
        IllegalStateException inner = new IllegalStateException("inner");
        CompletionException wrapped = new CompletionException(inner);

        Throwable resolved = invokeTransactionMethod("unwrap", new Class[]{Throwable.class}, wrapped);
        assertSame(inner, resolved);

        Throwable passthrough = invokeTransactionMethod("unwrap", new Class[]{Throwable.class}, inner);
        assertSame(inner, passthrough);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testNormalizeResponseRetornaListaVaciaSiEsNula() throws Exception {
        List<OutputInvestmentFundsDTO> empty = invokeTransactionMethod("normalizeResponse", new Class[]{List.class}, new Object[]{null});
        assertNotNull(empty);
        assertTrue(empty.isEmpty());

        List<OutputInvestmentFundsDTO> provided = Collections.singletonList(new OutputInvestmentFundsDTO());
        List<OutputInvestmentFundsDTO> normalized = invokeTransactionMethod("normalizeResponse", new Class[]{List.class}, provided);
        assertSame(provided, normalized);
    }

    @Test
    public void testResolveCurrentPageInterpretaClaveValidaONula() throws Exception {
        InputListInvestmentFundsDTO dto = new InputListInvestmentFundsDTO();
        dto.setPaginationKey("7");
        dto.setPageSize(3);

        int pagina = invokeTransactionMethod("resolveCurrentPage", new Class[]{InputListInvestmentFundsDTO.class, Integer.class}, dto, 3);
        assertEquals(7, pagina);

        dto.setPaginationKey(null);
        int paginaDefault = invokeTransactionMethod("resolveCurrentPage", new Class[]{InputListInvestmentFundsDTO.class, Integer.class}, dto, 3);
        assertEquals(0, paginaDefault);
    }

    @Test
    public void testFilterNonNullFundsOmiteNulos() throws Exception {
        InvestmentFund present = createFund("OK");
        List<InvestmentFund> sanitized = invokeTransactionMethod(
                "filterNonNullFunds",
                new Class[]{List.class},
                Arrays.asList(present, null));

        assertEquals(1, sanitized.size());
        assertSame(present, sanitized.get(0));
    }

    @Test
    public void testComputeStartIndexOperaEnEscenariosValidosEInvalidos() throws Exception {
        int valido = invokeTransactionMethod("computeStartIndex", new Class[]{int.class, Integer.class}, 2, 5);
        assertEquals(10, valido);

        int paginaInvalida = invokeTransactionMethod("computeStartIndex", new Class[]{int.class, Integer.class}, -1, 5);
        assertEquals(0, paginaInvalida);

        int sinTamanio = invokeTransactionMethod("computeStartIndex", new Class[]{int.class, Integer.class}, 3, null);
        assertEquals(0, sinTamanio);
    }

    @Test
    public void testComputeStartIndexLimitaOverflow() throws Exception {
        int clamped = invokeTransactionMethod(
                "computeStartIndex",
                new Class[]{int.class, Integer.class},
                Integer.MAX_VALUE,
                Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, clamped);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testApplyPageSizeSegmentaSobres() throws Exception {
        OutputInvestmentFundsDTO first = buildEnvelope(createFund("F0"), createFund("F1"));
        OutputInvestmentFundsDTO second = buildEnvelope(createFund("F2"));

        List<OutputInvestmentFundsDTO> limited = invokeTransactionMethod(
                "applyPageSize",
                new Class[]{List.class, Integer.class, int.class},
                Arrays.asList(first, second),
                2,
                1);

        assertEquals(2, limited.size());
        assertEquals("F1", limited.get(0).getData().get(0).getInvestmentFundId());
        assertEquals("F2", limited.get(1).getData().get(0).getInvestmentFundId());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testApplyPageSizeVaciaCuandoOffsetExcedeFondos() throws Exception {
        OutputInvestmentFundsDTO only = buildEnvelope(createFund("F0"));

        List<OutputInvestmentFundsDTO> limited = invokeTransactionMethod(
                "applyPageSize",
                new Class[]{List.class, Integer.class, int.class},
                Collections.singletonList(only),
                1,
                5);

        assertTrue(limited.isEmpty());
    }

    @Test
    public void testApplyPaginationMetadataSinPaginationSoloExponeIntNode() throws Exception {
        PFMHT01001PETransaction spyTransaction = spy(transaction);
        IntPaginationDTO node = new IntPaginationDTO();

        invokeTransactionMethod(
                spyTransaction,
                "applyPaginationMetadata",
                new Class[]{IntPaginationDTO.class, PaginationDTO.class},
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
                new Class[]{IntPaginationDTO.class, PaginationDTO.class},
                null,
                pagination);

        verify(spyTransaction, times(1)).setPagination(pagination);
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
                new Class[]{List.class, List.class},
                Arrays.asList(first, second, third),
                Collections.singletonList(second));

        assertEquals("F0", links.getFirst());
        assertEquals("F2", links.getLast());
        assertEquals("F0", links.getPrevious());
        assertEquals("F2", links.getNext());
    }

    @Test
    public void testBuildFallbackLinksUsaResumen() throws Exception {
        List<InvestmentFund> disponibles = Arrays.asList(
                createFund("F0"), createFund("F1"), createFund("F2"), createFund("F3"), createFund("F4"));

        Object summary = invokeTransactionMethod(
                "summarizeResponse",
                new Class[]{List.class, List.class},
                Collections.singletonList(buildEnvelope(createFund("F0"))),
                disponibles);

        LinksDTO fallback = invokeTransactionMethod(
                "buildFallbackLinks",
                new Class[]{summary.getClass(), Integer.class, int.class},
                summary,
                2,
                2);

        assertEquals("0", fallback.getFirst());
        assertEquals("2", fallback.getLast());
        assertEquals("1", fallback.getPrevious());
        assertNull(fallback.getNext());
    }

    @Test
    public void testBuildLinksGeneraFallbackPosicionalConPaginacionActiva() throws Exception {
        // Comentario en español: se crean fondos sin identificadores válidos para forzar el uso del fallback posicional.
        InvestmentFund primero = createFundWithoutIdentifiers("ALIAS-1");
        InvestmentFund segundo = createFundWithoutIdentifiers("ALIAS-2");

        LinksDTO links = invokeTransactionMethod(
                "buildLinks",
                new Class[]{List.class, List.class},
                Arrays.asList(primero, segundo),
                Arrays.asList(primero));

        assertNotNull(links);
        assertEquals("0", links.getFirst());
        assertEquals("1", links.getLast());
        assertNull(links.getPrevious());
        assertEquals("1", links.getNext());
    }

    @Test
    public void testBuildPaginationLinksDesdeMetadata() throws Exception {
        PaginationDTO pagination = new PaginationDTO();
        pagination.setTotalPages(4);
        pagination.setPage(1);

        LinksDTO links = invokeTransactionMethod(
                "buildPaginationLinksFromMetadata",
                new Class[]{PaginationDTO.class},
                pagination);

        assertEquals("0", links.getFirst());
        assertEquals("3", links.getLast());
        assertEquals("0", links.getPrevious());
        assertEquals("2", links.getNext());
    }

    @Test
    public void testBuildPositionalLinksUsaIndicesDeLista() throws Exception {
        InvestmentFund first = createFund("F0");
        InvestmentFund second = createFund("F1");
        InvestmentFund third = createFund("F2");

        LinksDTO links = invokeTransactionMethod(
                "buildPositionalLinks",
                new Class[]{List.class, List.class},
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
                new Class[]{List.class, List.class},
                Collections.emptyList(),
                Collections.emptyList());

        assertNull(links);
    }

    @Test
    public void testHasAnyLinkValueDetectaValores() throws Exception {
        LinksDTO empty = new LinksDTO();
        boolean none = invokeTransactionMethod("hasAnyLinkValue", new Class[]{LinksDTO.class}, empty);
        assertFalse(none);

        empty.setLast("FINAL");
        boolean some = invokeTransactionMethod("hasAnyLinkValue", new Class[]{LinksDTO.class}, empty);
        assertTrue(some);
    }

    @Test
    public void testCopyLinksCreaInstanciaIndependiente() throws Exception {
        LinksDTO source = new LinksDTO();
        source.setFirst("F0");
        source.setLast("F9");
        source.setPrevious("F1");
        source.setNext("F8");

        LinksDTO copy = invokeTransactionMethod("copyLinks", new Class[]{LinksDTO.class}, source);

        assertNotSame(source, copy);
        assertEquals(source.getFirst(), copy.getFirst());
        assertEquals(source.getLast(), copy.getLast());
        assertEquals(source.getPrevious(), copy.getPrevious());
        assertEquals(source.getNext(), copy.getNext());
    }

    @Test
    public void testExposeLinksInicializaEClonaEnlaces() throws Exception {
        PaginationDTO pagination = new PaginationDTO();
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());

        invokeTransactionMethod(
                spyTransaction,
                "exposeLinks",
                new Class[]{LinksDTO.class, PaginationDTO.class},
                null,
                pagination);

        LinksDTO captured = linksCaptor.getValue();
        assertNotNull(captured);
        assertEmptyLinks(captured);
        assertNotNull(pagination.getDTOLinks());
        assertEmptyLinks(pagination.getDTOLinks());
        assertNotSame("Los enlaces expuestos deben ser copias independientes", captured, pagination.getDTOLinks());
    }

    @Test
    public void testExposeLinksNoSobrescribePaginacionExistente() throws Exception {
        LinksDTO existing = new LinksDTO();
        existing.setFirst("persistente");
        PaginationDTO pagination = new PaginationDTO();
        pagination.setDTOLinks(existing);

        LinksDTO exposed = new LinksDTO();
        exposed.setNext("nuevo");

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());

        invokeTransactionMethod(
                spyTransaction,
                "exposeLinks",
                new Class[]{LinksDTO.class, PaginationDTO.class},
                exposed,
                pagination);

        LinksDTO captured = linksCaptor.getValue();
        assertNotNull(captured);
        assertEquals("nuevo", captured.getNext());
        assertNotSame("Se debe exponer una copia de los enlaces originales", exposed, captured);
        assertSame("Los enlaces previos no deben ser reemplazados", existing, pagination.getDTOLinks());
        assertEquals("persistente", pagination.getDTOLinks().getFirst());
        assertNull("Los enlaces previos no deben ser contaminados por los nuevos valores", pagination.getDTOLinks().getNext());
    }

    @Test
    public void testSynchronizePaginationLinksClonaReferencias() throws Exception {
        PaginationDTO pagination = new PaginationDTO();
        LinksDTO links = new LinksDTO();
        links.setFirst("A");
        links.setLast("B");

        LinksDTO snapshot = invokeTransactionMethod(
                "synchronizePaginationLinks",
                new Class[]{PaginationDTO.class, LinksDTO.class},
                pagination,
                links);

        assertNotSame(links, snapshot);
        assertNotSame(snapshot, pagination.getDTOLinks());
        assertEquals("A", snapshot.getFirst());
        assertEquals("B", snapshot.getLast());
        assertEquals(snapshot.getFirst(), pagination.getDTOLinks().getFirst());
        assertEquals(snapshot.getLast(), pagination.getDTOLinks().getLast());
    }

    @Test
    public void testDescribeFundPriorizaIdentificador() throws Exception {
        InvestmentFund fund = new InvestmentFund();
        fund.setInvestmentFundId("  IDENTIFICADOR  ");
        fund.setNumber("0001");

        String fromId = invokeTransactionMethod("describeFund", new Class[]{InvestmentFund.class}, fund);
        assertEquals("IDENTIFICADOR", fromId);

        fund.setInvestmentFundId("   ");
        String fromNumber = invokeTransactionMethod("describeFund", new Class[]{InvestmentFund.class}, fund);
        assertEquals("0001", fromNumber);
    }

    @Test
    public void testIndexOfEncuentraCoincidencias() throws Exception {
        InvestmentFund fundA = createFund("A");
        InvestmentFund fundB = createFund("B");

        int found = invokeTransactionMethod("indexOf", new Class[]{List.class, InvestmentFund.class},
                Arrays.asList(fundA, fundB), fundB);
        assertEquals(1, found);

        int missing = invokeTransactionMethod("indexOf", new Class[]{List.class, InvestmentFund.class},
                Arrays.asList(fundA, fundB), createFund("C"));
        assertEquals(-1, missing);
    }

    @Test
    public void testResolvePageSizePrefiereEntradaYNormaliza() throws Exception {
        InputListInvestmentFundsDTO input = new InputListInvestmentFundsDTO();
        input.setPageSize(15);
        IntPaginationDTO pagination = new IntPaginationDTO();
        pagination.setPageSize(50L);

        Integer preferred = invokeTransactionMethod(
                "resolvePageSize",
                new Class[]{IntPaginationDTO.class, InputListInvestmentFundsDTO.class},
                pagination,
                input);
        assertEquals(Integer.valueOf(15), preferred);

        input.setPageSize(null);
        Integer fallback = invokeTransactionMethod(
                "resolvePageSize",
                new Class[]{IntPaginationDTO.class, InputListInvestmentFundsDTO.class},
                pagination,
                input);
        assertEquals(Integer.valueOf(50), fallback);

        pagination.setPageSize((long) Integer.MAX_VALUE + 20);
        Integer capped = invokeTransactionMethod(
                "resolvePageSize",
                new Class[]{IntPaginationDTO.class, InputListInvestmentFundsDTO.class},
                pagination,
                input);
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), capped);
    }

    @Test
    public void testSafeParseYNormalizeRechazanEntradasInvalidas() throws Exception {
        BigInteger parsed = invokeTransactionMethod("safeParse", new Class[]{String.class}, "abc123");
        assertEquals(BigInteger.ZERO, parsed);

        int negative = invokeTransactionMethod("normalize", new Class[]{BigInteger.class}, new BigInteger("-5"));
        assertEquals(0, negative);

        int overflow = invokeTransactionMethod(
                "normalize",
                new Class[]{BigInteger.class},
                BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.ONE));
        assertEquals(0, overflow);
    }

    @Test
    public void testSanitizeKeyLimpiaEspacios() throws Exception {
        String sanitized = invokeTransactionMethod("sanitizeKey", new Class[]{String.class}, "   IDENT   ");
        assertEquals("IDENT", sanitized);

        String blank = invokeTransactionMethod("sanitizeKey", new Class[]{String.class}, "   ");
        assertNull(blank);
    }

    @Test
    public void testUpdateSeverityAjustaEstado() throws Exception {
        Object emptySummary = invokeTransactionMethod(
                "summarizeResponse",
                new Class[]{List.class, List.class},
                Collections.emptyList(),
                Collections.emptyList());

        Object populatedSummary = invokeTransactionMethod(
                "summarizeResponse",
                new Class[]{List.class, List.class},
                Collections.singletonList(buildEnvelope(createFund("F0"))),
                Collections.singletonList(createFund("TOTAL")));

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        invokeTransactionMethod(
                spyTransaction,
                "updateSeverity",
                new Class[]{emptySummary.getClass()},
                emptySummary);
        assertEquals("La severidad debe ajustarse a ENR cuando no hay datos", Severity.ENR, spyTransaction.getSeverity());

        invokeTransactionMethod(
                spyTransaction,
                "updateSeverity",
                new Class[]{populatedSummary.getClass()},
                populatedSummary);
        assertEquals("La severidad debe ajustarse a OK cuando existe información", Severity.OK, spyTransaction.getSeverity());
    }
    @Test
    public void testExecute_RuntimeException() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenThrow(new IllegalStateException("Unexpected error"));

        spyTransaction.execute();

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        verify(pfmhR010, times(1)).executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class));
        List<OutputInvestmentFundsDTO> captured = responseCaptor.getValue();
        assertEquals(1, captured.size());
        assertEquals(Collections.emptyList(), captured.get(0).getData());
        assertNull(captured.get(0).getDTOIntPagination());
        verify(spyTransaction, times(0)).setDTOIntPagination(any());
        verify(spyTransaction, times(1)).setPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(any());
        PaginationDTO pagination = paginationCaptor.getValue();
        assertPaginationDefaults(pagination, 0);
        assertEquals(pagination, dtoPaginationCaptor.getValue());
        LinksDTO links = linksCaptor.getValue();
        assertEmptyLinks(links);
        assertEmptyLinks(pagination.getDTOLinks());
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
    }
    @Test
    public void testExecute_PaginationNextLink() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("0");
        intPag.setPageSize(1L);

        InvestmentFund firstFund = new InvestmentFund();
        firstFund.setInvestmentFundId("FUND-1");
        InvestmentFund secondFund = new InvestmentFund();
        secondFund.setInvestmentFundId("FUND-2");

        OutputInvestmentFundsDTO out1 = new OutputInvestmentFundsDTO();
        out1.setDTOIntPagination(intPag);
        out1.setData(Collections.singletonList(firstFund));
        OutputInvestmentFundsDTO out2 = new OutputInvestmentFundsDTO();
        out2.setData(Collections.singletonList(secondFund));

        List<OutputInvestmentFundsDTO> response = Arrays.asList(out1, out2);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> captor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(captor.capture());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = captor.getValue();
        assertEquals(Integer.valueOf(0), pagination.getPage());
        assertEquals(Integer.valueOf(2), pagination.getTotalElements());
        assertEquals(Integer.valueOf(2), pagination.getTotalPages());
        assertEquals(Integer.valueOf(1), pagination.getPageSize());
        assertEquals("FUND-2", pagination.getDTOLinks().getNext());
        assertNull(pagination.getDTOLinks().getPrevious());
        assertEquals("FUND-1", pagination.getDTOLinks().getFirst());
        assertEquals("FUND-2", pagination.getDTOLinks().getLast());
        assertEquals(pagination, dtoPaginationCaptor.getValue());
        List<InvestmentFund> aggregated = dataCaptor.getValue();
        assertEquals(1, aggregated.size());
        verify(spyTransaction, times(1)).setDTOLinks(any());
    }

    @Test
    public void testExecute_PaginationUsesInputPageSize() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(3);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("KEY-0");
        intPag.setPageSize(25L);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        output.setData(Arrays.asList(
                createFund("F0"),
                createFund("F1"),
                createFund("F2"),
                createFund("F3"),
                createFund("F4")));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        verify(spyTransaction, times(1)).setResponseOut(any());
        List<OutputInvestmentFundsDTO> paginated = responseCaptor.getValue();
        assertEquals(1, paginated.size());
        assertEquals(3, paginated.get(0).getData().size());

        List<InvestmentFund> aggregated = dataCaptor.getValue();
        assertEquals(3, aggregated.size());

        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(3), pagination.getPageSize());
        assertEquals(Integer.valueOf(5), pagination.getTotalElements());
        assertEquals(Integer.valueOf(2), pagination.getTotalPages());
        assertEquals(Integer.valueOf(0), pagination.getPage());
        assertNotNull(pagination.getDTOLinks());
        assertEquals("F0", pagination.getDTOLinks().getFirst());
        assertEquals("F4", pagination.getDTOLinks().getLast());
        assertEquals("F3", pagination.getDTOLinks().getNext());
        assertNull(pagination.getDTOLinks().getPrevious());
        assertEquals(pagination, dtoPaginationCaptor.getValue());

        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
    }

    @Test
    public void testEnsurePaginationLinksCreaObjetoCuandoPaginationEsNula() throws Exception {
        Object summary = invokeTransactionMethod(
                "summarizeResponse",
                new Class[]{List.class, List.class},
                Collections.emptyList(),
                Collections.emptyList());

        LinksDTO links = invokeTransactionMethod(
                "ensurePaginationLinks",
                new Class[]{PaginationDTO.class, getResponseSummaryClass(), Integer.class, int.class},
                null,
                summary,
                5,
                0);

        assertNotNull(links);
        assertNull(links.getFirst());
        assertNull(links.getLast());
        assertNull(links.getNext());
        assertNull(links.getPrevious());
    }

    @Test
    public void testEnsurePaginationLinksUtilizaResumenParaFallback() throws Exception {
        Object summary = invokeTransactionMethod(
                "summarizeResponse",
                new Class[]{List.class, List.class},
                Collections.singletonList(buildEnvelope(createFund("VISIBLE"))),
                Arrays.asList(createFund("F0"), createFund("F1"), createFund("F2")));

        PaginationDTO pagination = new PaginationDTO();

        LinksDTO links = invokeTransactionMethod(
                "ensurePaginationLinks",
                new Class[]{PaginationDTO.class, getResponseSummaryClass(), Integer.class, int.class},
                pagination,
                summary,
                1,
                1);

        assertEquals("0", links.getFirst());
        assertEquals("2", links.getLast());
        assertEquals("0", links.getPrevious());
        assertEquals("2", links.getNext());
        assertEquals(links, pagination.getDTOLinks());
    }

    @Test
    public void testEnsurePaginationLinksUsaMetadataCuandoNoHayResumen() throws Exception {
        PaginationDTO pagination = new PaginationDTO();
        pagination.setTotalPages(3);
        pagination.setPage(1);

        LinksDTO links = invokeTransactionMethod(
                "ensurePaginationLinks",
                new Class[]{PaginationDTO.class, getResponseSummaryClass(), Integer.class, int.class},
                pagination,
                null,
                5,
                1);

        assertEquals("0", links.getFirst());
        assertEquals("2", links.getLast());
        assertEquals("0", links.getPrevious());
        assertEquals("2", links.getNext());
        assertEquals(links, pagination.getDTOLinks());
    }

    @Test
    public void testExecute_PropagaLinksFallbackEnDtoPagination() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setData(Arrays.asList(
                createFundWithoutIdentifiers("ALPHA"),
                createFundWithoutIdentifiers("BETA")));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO dtoPagination = dtoPaginationCaptor.getValue();
        assertNotNull(dtoPagination);
        LinksDTO paginationLinks = dtoPagination.getDTOLinks();
        assertNotNull(paginationLinks);
        assertEquals("0", paginationLinks.getFirst());
        assertEquals("1", paginationLinks.getLast());
        assertEquals("1", paginationLinks.getNext());
        assertNull(paginationLinks.getPrevious());

        LinksDTO exposedLinks = linksCaptor.getValue();
        assertNotNull(exposedLinks);
        assertNotSame(paginationLinks, exposedLinks);
        assertEquals(paginationLinks.getFirst(), exposedLinks.getFirst());
        assertEquals(paginationLinks.getLast(), exposedLinks.getLast());
        assertEquals(paginationLinks.getNext(), exposedLinks.getNext());
        assertEquals(paginationLinks.getPrevious(), exposedLinks.getPrevious());
    }

    @Test
    public void testExecute_PublicaObjetoLinksVacioCuandoNoHayDatos() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(5);

        OutputInvestmentFundsDTO sobreVacio = new OutputInvestmentFundsDTO();
        sobreVacio.setData(Collections.emptyList());

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(sobreVacio);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(any());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO dtoPagination = dtoPaginationCaptor.getValue();
        assertNotNull(dtoPagination);
        LinksDTO paginationLinks = dtoPagination.getDTOLinks();
        assertNotNull("DTOPagination debe exponer siempre un objeto Links", paginationLinks);
        assertNull(paginationLinks.getFirst());
        assertNull(paginationLinks.getLast());
        assertNull(paginationLinks.getNext());
        assertNull(paginationLinks.getPrevious());

        LinksDTO exposedLinks = linksCaptor.getValue();
        assertNotNull(exposedLinks);
        assertNotSame("Los enlaces expuestos deben ser una copia del DTO", paginationLinks, exposedLinks);
        assertNull(exposedLinks.getFirst());
        assertNull(exposedLinks.getLast());
        assertNull(exposedLinks.getNext());
        assertNull(exposedLinks.getPrevious());
    }

    @Test
    public void testExecute_PaginationUsesServiceValueWhenInputInvalid() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(0);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("KEY-0");
        intPag.setPageSize(4L);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        output.setData(Arrays.asList(
                createFund("F0"),
                createFund("F1"),
                createFund("F2"),
                createFund("F3"),
                createFund("F4")));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(4), pagination.getPageSize());
        assertEquals(Integer.valueOf(5), pagination.getTotalElements());
        assertEquals(Integer.valueOf(2), pagination.getTotalPages());

        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
    }

    @Test
    public void testExecute_PaginationNextLinkWithDifferentKey() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("1");
        intPag.setPageSize(1L);

        InvestmentFund firstFund = new InvestmentFund();
        firstFund.setInvestmentFundId("FUND-1");
        InvestmentFund secondFund = new InvestmentFund();
        secondFund.setInvestmentFundId("FUND-2");

        OutputInvestmentFundsDTO out1 = new OutputInvestmentFundsDTO();
        out1.setDTOIntPagination(intPag);
        out1.setData(Collections.singletonList(firstFund));
        OutputInvestmentFundsDTO out2 = new OutputInvestmentFundsDTO();
        out2.setData(Collections.singletonList(secondFund));

        List<OutputInvestmentFundsDTO> response = Arrays.asList(out1, out2);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> captor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(captor.capture());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = captor.getValue();
        assertEquals("FUND-2", pagination.getDTOLinks().getNext());
        assertNull(pagination.getDTOLinks().getPrevious());
        assertEquals("FUND-1", pagination.getDTOLinks().getFirst());
        assertEquals("FUND-2", pagination.getDTOLinks().getLast());
        assertEquals(pagination, dtoPaginationCaptor.getValue());
        verify(spyTransaction, times(1)).setDTOLinks(any());
    }

    @Test
    public void testExecute_PaginationNextLinkWithLargeKey() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("001101308000011582");
        intPag.setPageSize(1L);

        InvestmentFund firstFund = new InvestmentFund();
        firstFund.setInvestmentFundId("FUND-A");
        InvestmentFund secondFund = new InvestmentFund();
        secondFund.setInvestmentFundId("FUND-B");

        OutputInvestmentFundsDTO out1 = new OutputInvestmentFundsDTO();
        out1.setDTOIntPagination(intPag);
        out1.setData(Collections.singletonList(firstFund));
        OutputInvestmentFundsDTO out2 = new OutputInvestmentFundsDTO();
        out2.setData(Collections.singletonList(secondFund));

        List<OutputInvestmentFundsDTO> response = Arrays.asList(out1, out2);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> captor = ArgumentCaptor.forClass(PaginationDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(captor.capture());
        doNothing().when(spyTransaction).setDTOLinks(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = captor.getValue();
        assertEquals(Integer.valueOf(0), pagination.getPage());
        assertEquals("FUND-B", pagination.getDTOLinks().getNext());
        assertNull(pagination.getDTOLinks().getPrevious());
        assertEquals("FUND-A", pagination.getDTOLinks().getFirst());
        assertEquals("FUND-B", pagination.getDTOLinks().getLast());
        verify(spyTransaction, times(1)).setDTOLinks(any());
    }

    @Test
    public void testExecute_PaginationLinkOmittedWhenKeyBlank() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey(" ");
        intPag.setPageSize(1L);

        OutputInvestmentFundsDTO out1 = new OutputInvestmentFundsDTO();
        out1.setDTOIntPagination(intPag);
        out1.setData(Collections.singletonList(createFund("BLANK-1")));
        OutputInvestmentFundsDTO out2 = new OutputInvestmentFundsDTO();
        out2.setData(Collections.singletonList(createFund("BLANK-2")));

        List<OutputInvestmentFundsDTO> response = Arrays.asList(out1, out2);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> captor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(captor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = captor.getValue();
        assertEquals(Integer.valueOf(0), pagination.getPage());
        LinksDTO links = pagination.getDTOLinks();
        assertNotNull(links);
        assertEquals("BLANK-2", links.getNext());
        assertNull(links.getPrevious());
        assertEquals("BLANK-1", links.getFirst());
        assertEquals("BLANK-2", links.getLast());
        LinksDTO capturedLinks = linksCaptor.getValue();
        assertNotSame(links, capturedLinks);
        assertEquals(links.getFirst(), capturedLinks.getFirst());
        assertEquals(links.getLast(), capturedLinks.getLast());
        assertEquals(links.getPrevious(), capturedLinks.getPrevious());
        assertEquals(links.getNext(), capturedLinks.getNext());
        verify(spyTransaction, times(1)).setDTOLinks(any());
    }

    @Test
    public void testExecute_PopulatesPreviousWhenRequestIncludesKey() {
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn("1");
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(5);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("2");
        intPag.setPageSize(5L);

        OutputInvestmentFundsDTO out1 = new OutputInvestmentFundsDTO();
        out1.setDTOIntPagination(intPag);
        out1.setData(Arrays.asList(
                createFund("F0"),
                createFund("F1"),
                createFund("F2"),
                createFund("F3"),
                createFund("F4")));

        OutputInvestmentFundsDTO out2 = new OutputInvestmentFundsDTO();
        out2.setData(Arrays.asList(
                createFund("F5"),
                createFund("F6"),
                createFund("F7"),
                createFund("F8"),
                createFund("F9")));

        List<OutputInvestmentFundsDTO> response = Arrays.asList(out1, out2);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(1), pagination.getPage());
        assertEquals(Integer.valueOf(10), pagination.getTotalElements());
        assertEquals(Integer.valueOf(2), pagination.getTotalPages());
        assertEquals(Integer.valueOf(5), pagination.getPageSize());

        LinksDTO links = linksCaptor.getValue();
        assertNotNull(links);
        assertEquals("F4", links.getPrevious());
        assertNull(links.getNext());
        assertEquals("F0", links.getFirst());
        assertEquals("F9", links.getLast());
        assertEquals(pagination, dtoPaginationCaptor.getValue());

        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(null);
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
    }

    @Test
    public void testExecute_SanitizesNullEntries() {
        OutputInvestmentFundsDTO validOutput = new OutputInvestmentFundsDTO();
        validOutput.setDTOIntPagination(new IntPaginationDTO());

        InvestmentFund validFund = new InvestmentFund();
        validOutput.setData(Arrays.asList(validFund, null));

        List<OutputInvestmentFundsDTO> response = Arrays.asList(null, validOutput, null);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setResponseOut(captor.capture());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        List<OutputInvestmentFundsDTO> sanitized = captor.getValue();
        assertEquals(1, sanitized.size());
        assertEquals(Collections.singletonList(validFund), sanitized.get(0).getData());
    }

    @Test
    public void testExecute_ResponseBecomesEmptyAfterSanitize() {
        List<OutputInvestmentFundsDTO> response = Collections.singletonList(null);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        List<OutputInvestmentFundsDTO> captured = responseCaptor.getValue();
        assertEquals(1, captured.size());
        assertEquals(Collections.emptyList(), captured.get(0).getData());
        verify(spyTransaction, times(0)).setDTOIntPagination(any());
        verify(spyTransaction, times(1)).setPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(any());
        LinksDTO exposedLinks = linksCaptor.getValue();
        assertNotNull(exposedLinks);
        assertNull(exposedLinks.getFirst());
        assertNull(exposedLinks.getLast());
        assertNull(exposedLinks.getNext());
        assertNull(exposedLinks.getPrevious());
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
        PaginationDTO pagination = paginationCaptor.getValue();
        assertNotNull(pagination);
        assertEquals(Integer.valueOf(0), pagination.getTotalElements());
        assertEquals(Integer.valueOf(0), pagination.getTotalPages());
        assertEquals(Integer.valueOf(10), pagination.getPageSize());
        assertEquals(Integer.valueOf(0), pagination.getPage());
        LinksDTO paginationLinks = pagination.getDTOLinks();
        assertNotNull(paginationLinks);
        assertNull(paginationLinks.getFirst());
        assertNull(paginationLinks.getLast());
        assertNull(paginationLinks.getNext());
        assertNull(paginationLinks.getPrevious());
        assertEquals(pagination, dtoPaginationCaptor.getValue());
    }

    @Test
    public void testExecute_PopulatesPaginationLinksWithoutIntPagination() {
        List<InvestmentFund> funds = Arrays.asList(createFund("FUND-A"), createFund("FUND-B"));
        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setData(funds);

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn("0");

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        verify(spyTransaction, never()).setDTOIntPagination(any());
        verify(spyTransaction, times(1)).setPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());
        PaginationDTO pagination = paginationCaptor.getValue();
        assertNotNull(pagination.getDTOLinks());
        assertEquals("FUND-A", pagination.getDTOLinks().getFirst());
        assertEquals("FUND-B", pagination.getDTOLinks().getLast());
        assertNull(pagination.getDTOLinks().getPrevious());
        assertEquals("FUND-B", pagination.getDTOLinks().getNext());
        assertEquals(pagination, dtoPaginationCaptor.getValue());
    }

    @Test
    public void testExecute_IntPaginationWithoutPageSize() {
        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("0");
        intPag.setPageSize(null);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        verify(spyTransaction, times(1)).setResponseOut(any());
        verify(spyTransaction, times(1)).setDTOIntPagination(intPag);
        verify(spyTransaction, times(1)).setPagination(any());
        verify(spyTransaction, times(1)).setDTOPagination(any());
        assertEquals(paginationCaptor.getValue(), dtoPaginationCaptor.getValue());
        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(0), pagination.getPage());
        assertEquals(Integer.valueOf(0), pagination.getTotalElements());
        assertEquals(Integer.valueOf(10), pagination.getPageSize());
        assertEquals(Integer.valueOf(0), pagination.getTotalPages());
        LinksDTO paginationLinks = pagination.getDTOLinks();
        assertNotNull(paginationLinks);
        assertNull(paginationLinks.getFirst());
        assertNull(paginationLinks.getLast());
        assertNull(paginationLinks.getNext());
        assertNull(paginationLinks.getPrevious());
        verify(spyTransaction, times(1)).setDTOLinks(any());
        LinksDTO exposedLinks = linksCaptor.getValue();
        assertNotNull(exposedLinks);
        assertNull(exposedLinks.getFirst());
        assertNull(exposedLinks.getLast());
        assertNull(exposedLinks.getNext());
        assertNull(exposedLinks.getPrevious());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
    }

    @Test
    public void testExecute_PageSizeGreaterThanIntegerMaxValue() {
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(null);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("key");
        intPag.setPageSize((long) Integer.MAX_VALUE + 10);

        InvestmentFund fund = createFund("MAX-LINK");
        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        output.setData(Collections.singletonList(fund));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), pagination.getPageSize());
        assertEquals(Integer.valueOf(1), pagination.getTotalPages());
        assertEquals(Integer.valueOf(1), pagination.getTotalElements());
        LinksDTO links = linksCaptor.getValue();
        assertNotNull(links);
        assertNull(links.getNext());
        assertNull(links.getPrevious());
        assertEquals("MAX-LINK", links.getFirst());
        assertEquals("MAX-LINK", links.getLast());
    }

    @Test
    public void testExecute_PreviousLinkUsesInputPageSizeWhenServiceOmit() {
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn("1");
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(5);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("2");
        intPag.setPageSize(null);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        output.setData(Arrays.asList(
                createFund("F0"),
                createFund("F1"),
                createFund("F2"),
                createFund("F3"),
                createFund("F4"),
                createFund("F5"),
                createFund("F6"),
                createFund("F7"),
                createFund("F8"),
                createFund("F9"),
                createFund("F10"),
                createFund("F11"),
                createFund("F12"),
                createFund("F13"),
                createFund("F14")));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);

        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(any());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        LinksDTO links = linksCaptor.getValue();
        assertNotNull(links);
        assertEquals("F4", links.getPrevious());
        assertEquals("F10", links.getNext());
        assertEquals("F0", links.getFirst());
        assertEquals("F14", links.getLast());

        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(5), pagination.getPageSize());
        assertEquals(Integer.valueOf(15), pagination.getTotalElements());
        assertEquals(Integer.valueOf(3), pagination.getTotalPages());
        assertEquals(Integer.valueOf(1), pagination.getPage());

        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(null);
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
    }

    @Test
    public void testExecute_CurrentPageDefaultsToZeroWhenKeyNonNumeric() {
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn("ABC123");
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(4);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("3");
        intPag.setPageSize(4L);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        output.setData(Arrays.asList(
                createFund("F0"),
                createFund("F1"),
                createFund("F2"),
                createFund("F3")));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);

        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());
        doNothing().when(spyTransaction).setData(any());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(0), pagination.getPage());
        assertEquals(Integer.valueOf(4), pagination.getTotalElements());
        assertEquals(Integer.valueOf(4), pagination.getPageSize());
        assertEquals(Integer.valueOf(1), pagination.getTotalPages());

        LinksDTO links = linksCaptor.getValue();
        assertNotNull(links);
        assertEquals("F0", links.getFirst());
        assertEquals("F3", links.getLast());
        assertNull(links.getNext());
        assertNull(links.getPrevious());

        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(null);
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
    }

    @Test
    public void testExecute_StartIndexIsClampedWhenOverflowOccurs() {
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(String.valueOf(Integer.MAX_VALUE));
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(2);

        IntPaginationDTO intPag = new IntPaginationDTO();
        intPag.setPaginationKey("MAX");
        intPag.setPageSize(2L);

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPag);
        output.setData(Arrays.asList(
                createFund("F0"),
                createFund("F1")));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);
        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(any());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        List<OutputInvestmentFundsDTO> visible = responseCaptor.getValue();
        assertEquals(1, visible.size());
        assertEquals(Collections.emptyList(), visible.get(0).getData());

        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), pagination.getPage());
        assertEquals(Integer.valueOf(2), pagination.getPageSize());
        assertEquals(Integer.valueOf(2), pagination.getTotalElements());
        assertEquals(Integer.valueOf(1), pagination.getTotalPages());
        assertEquals(Severity.ENR, spyTransaction.getSeverity());

        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(null);
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
    }

    @Test
    public void testExecute_UsaLinksDeRespaldoCuandoNoHayIdentificadores() throws Exception {
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn("1");
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(2);

        IntPaginationDTO intPagination = new IntPaginationDTO();
        intPagination.setPaginationKey("1");
        intPagination.setPageSize(2L);

        InvestmentFund primerFondo = createFundWithoutIdentifiers("F0");
        InvestmentFund segundoFondo = createFundWithoutIdentifiers("F1");
        InvestmentFund tercerFondo = createFundWithoutIdentifiers("F2");

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setDTOIntPagination(intPagination);
        output.setData(Arrays.asList(primerFondo, segundoFondo, tercerFondo));

        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<LinksDTO> linksCaptor = ArgumentCaptor.forClass(LinksDTO.class);

        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setData(any());
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(linksCaptor.capture());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        verify(spyTransaction, times(1)).setDTOLinks(any());

        LinksDTO fallbackLinks = linksCaptor.getValue();
        assertNotNull(fallbackLinks);

        List<OutputInvestmentFundsDTO> sobresVisibles = responseCaptor.getValue();
        OutputInvestmentFundsDTO sobreConFondos = sobresVisibles.get(0);

        List<InvestmentFund> fondosVisibles = sobreConFondos.getData();
        assertNotNull("Se esperan fondos expuestos en el primer sobre paginado", fondosVisibles);

        Integer pageSize = inputListInvestmentFundsDTO.getPageSize();

        List<InvestmentFund> fondosDisponiblesParaFallback = new ArrayList<>(output.getData());

        List<InvestmentFund> fondosVisiblesParaFallback = new ArrayList<>(fondosVisibles);
        if (pageSize != null && pageSize > 0 && fondosVisiblesParaFallback.size() > pageSize) {
            fondosVisiblesParaFallback = fondosVisiblesParaFallback.subList(0, pageSize);
        }

        LinksDTO expectedLinks = (LinksDTO) invokeTransactionMethod(
                spyTransaction,
                "buildPositionalLinks",
                new Class[]{List.class, List.class},
                fondosDisponiblesParaFallback,
                fondosVisiblesParaFallback
        );

        assertNotNull("El enlace 'first' debe estar informado", fallbackLinks.getFirst());
        assertEquals("El enlace 'first' debe coincidir con el cálculo posicional",
                expectedLinks.getFirst(), fallbackLinks.getFirst());

        assertNotNull("El enlace 'last' debe estar informado", fallbackLinks.getLast());
        assertEquals("El enlace 'last' debe coincidir con el cálculo posicional",
                expectedLinks.getLast(), fallbackLinks.getLast());

        assertEquals("El enlace 'previous' debe coincidir con el cálculo posicional",
                expectedLinks.getPrevious(), fallbackLinks.getPrevious());
        assertEquals("El enlace 'next' debe coincidir con el cálculo posicional",
                expectedLinks.getNext(), fallbackLinks.getNext());
        assertEquals(Severity.OK, spyTransaction.getSeverity());

        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(null);
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
    }
    @Test
    public void testBuildLinksUsaFondosVisiblesCuandoFaltanDisponibles() throws Exception {
        LinksDTO links = invokeTransactionMethod(
                "buildLinks",
                new Class[]{List.class, List.class},
                null,
                Arrays.asList(createFund("F0"), createFund("F1")));

        assertNotNull(links);
        assertEquals("F0", links.getFirst());
        assertEquals("F1", links.getLast());
        assertNull(links.getPrevious());
        assertNull(links.getNext());
    }
    @Test
    public void testExecute_PropagaErroresNoControlados() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class)))
                .thenAnswer(invocation -> {
                    throw new AssertionError("error crítico");
                });

        assertThrows("Se esperaba que se propagara el AssertionError", AssertionError.class, spyTransaction::execute);

        verify(spyTransaction, never()).setResponseOut(any());
    }

    @Test
    public void testExecute_LogsPaginationAndLinks() {
        List<InvestmentFund> funds = Arrays.asList(
                createFund("FUND-A"),
                createFund("FUND-B")
        );
        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setData(funds);
        List<OutputInvestmentFundsDTO> response = Collections.singletonList(output);

        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(1);
        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn("0");

        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<PaginationDTO> paginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);
        ArgumentCaptor<PaginationDTO> dtoPaginationCaptor = ArgumentCaptor.forClass(PaginationDTO.class);

        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(any());

        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        PaginationDTO pagination = paginationCaptor.getValue();
        assertNotNull(pagination);
        assertNotNull(pagination.getDTOLinks());
        assertEquals("FUND-A", pagination.getDTOLinks().getFirst());
        assertEquals("FUND-B", pagination.getDTOLinks().getLast());
    }
}