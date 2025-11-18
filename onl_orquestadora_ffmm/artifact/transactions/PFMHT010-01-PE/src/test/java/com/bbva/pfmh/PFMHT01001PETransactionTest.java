package com.bbva.pfmh;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;
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
        verify(spyTransaction, times(1)).setDTOLinks(null);
        PaginationDTO pagination = paginationCaptor.getValue();
        assertEquals(Integer.valueOf(0), pagination.getPage());
        assertEquals(Integer.valueOf(0), pagination.getTotalElements());
        assertEquals(Integer.valueOf(0), pagination.getTotalPages());
        assertEquals(Integer.valueOf(10), pagination.getPageSize());
        assertEquals(pagination, dtoPaginationCaptor.getValue());
    }


    @Test
    public void testExecute_ResponseNull() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(any());
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
        verify(spyTransaction, times(0)).setPagination(any());
        verify(spyTransaction, times(0)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(null);
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
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
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(any());
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
        verify(spyTransaction, times(0)).setPagination(any());
        verify(spyTransaction, times(0)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(null);
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
    }

    @Test
    public void testExecute_RuntimeException() {
        PFMHT01001PETransaction spyTransaction = spy(transaction);

        ArgumentCaptor<List> responseCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(any());
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
        verify(spyTransaction, times(0)).setPagination(any());
        verify(spyTransaction, times(0)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(null);
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
        assertEquals(2, aggregated.size());
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
        assertEquals(5, aggregated.size());

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
        assertEquals(links, linksCaptor.getValue());
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
        doNothing().when(spyTransaction).setResponseOut(responseCaptor.capture());
        doNothing().when(spyTransaction).setPagination(any());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(any());
        doNothing().when(spyTransaction).setDTOLinks(any());
        doNothing().when(spyTransaction).setData(dataCaptor.capture());
        when(pfmhR010.executeGetFFMMStatements(any(InputListInvestmentFundsDTO.class))).thenReturn(response);

        spyTransaction.execute();

        assertEquals(Severity.ENR, spyTransaction.getSeverity());
        List<OutputInvestmentFundsDTO> captured = responseCaptor.getValue();
        assertEquals(1, captured.size());
        assertEquals(Collections.emptyList(), captured.get(0).getData());
        verify(spyTransaction, times(0)).setDTOIntPagination(any());
        verify(spyTransaction, times(0)).setPagination(any());
        verify(spyTransaction, times(0)).setDTOPagination(any());
        verify(spyTransaction, times(1)).setDTOLinks(null);
        verify(spyTransaction, times(1)).setData(any());
        assertEquals(Collections.emptyList(), dataCaptor.getValue());
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
        ArgumentCaptor<List> dataCaptor = ArgumentCaptor.forClass(List.class);
        doNothing().when(spyTransaction).setResponseOut(any());
        doNothing().when(spyTransaction).setPagination(paginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOIntPagination(any());
        doNothing().when(spyTransaction).setDTOPagination(dtoPaginationCaptor.capture());
        doNothing().when(spyTransaction).setDTOLinks(any());
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
        assertNull(pagination.getDTOLinks());
        verify(spyTransaction, times(1)).setDTOLinks(null);
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
    public void testExecute_UsaLinksDeRespaldoCuandoNoHayIdentificadores() {
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
        assertEquals("0", fallbackLinks.getFirst());
        assertEquals("1", fallbackLinks.getLast());
        assertEquals("0", fallbackLinks.getPrevious());
        assertNull(fallbackLinks.getNext());

        List<OutputInvestmentFundsDTO> sobresVisibles = responseCaptor.getValue();
        assertEquals(1, sobresVisibles.size());
        List<InvestmentFund> fondosVisibles = sobresVisibles.get(0).getData();
        assertEquals(1, fondosVisibles.size());
        assertEquals(tercerFondo, fondosVisibles.get(0));
        assertEquals(Severity.OK, spyTransaction.getSeverity());

        when(inputListInvestmentFundsDTO.getPaginationKey()).thenReturn(null);
        when(inputListInvestmentFundsDTO.getPageSize()).thenReturn(10);
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
}
