package com.bbva.pinv;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.bbva.pinv.dto.research.Contract;
import com.bbva.pinv.dto.research.Holder;
import com.bbva.pinv.dto.research.Pagination;
import com.bbva.pinv.dto.research.PaginationLinks;
import com.bbva.pinv.dto.research.Receiver;
import com.bbva.pinv.dto.research.SearchResearchFolioResponseData;
import com.bbva.pinv.dto.research.SearchResearchFolioRequest;
import com.bbva.pinv.dto.research.Branch;
import com.bbva.pinv.dto.research.ResearchUser;
import com.bbva.pinv.dto.research.Sender;
import com.bbva.pinv.dto.research.Status;
import com.bbva.pinv.dto.research.SearchResearchFolioResponse;

import com.bbva.pinv.lib.r001.PINVR001;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.aop.framework.Advised;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class PINVT00101PETransactionTest {

	@Spy
	private Context context;

	private Map<String, Object> parameters;

	private Map<Class<?>, Object> serviceLibraries;


	@Mock
	private ApplicationConfigurationService applicationConfigurationService;

	@Mock
	private CommonRequestHeader commonRequestHeader;

	@Mock
	private PINVR001 pinvr001;


	private final PINVT00101PETransaction transaction = new PINVT00101PETransaction() {
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
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		initializeTransaction();
		setServiceLibrary(PINVR001.class, pinvr001);

		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}

	private Object getObjectIntrospection() throws Exception{
		Object result = this.pinvr001;
		if(this.pinvr001 instanceof Advised){
			Advised advised = (Advised) this.pinvr001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}

	private void initializeTransaction() {
		transaction.setContext(new Context());
		parameters = new HashMap<>();
		serviceLibraries = new HashMap<>();
	}

	private void setServiceLibrary(Class<?> clasz, Object mockObject) {
		serviceLibraries.put(clasz, mockObject);
	}



	@Test
	public void executeTest() {
		transaction.execute();
		Assert.assertEquals(0, transaction.getAdviceList().size());
	}

	@Test
	public void testNotNull(){
		assertNotNull(this.transaction);
		this.transaction.execute();
	}

	@Test
	public void testExecute(){

		SearchResearchFolioRequest searchResearchFolioRequest = new SearchResearchFolioRequest();
		searchResearchFolioRequest.setOperationNumber("123456");
		searchResearchFolioRequest.setOperationType("Test Operation");
		searchResearchFolioRequest.setStartDate(new java.util.Date());
		searchResearchFolioRequest.setEndDate(new java.util.Date());
		Status statusTest = new Status();
		statusTest.setId("1");
		ResearchUser researchUserTest = new ResearchUser();
		researchUserTest.setId("1");
		researchUserTest.setFullName("Test User");
		Branch branchTest = new Branch();
		branchTest.setId("1");

		SearchResearchFolioResponse searchResearchFolioResponse = new SearchResearchFolioResponse();
		SearchResearchFolioResponseData searchResearchFolioResponseData = new SearchResearchFolioResponseData();
		List<SearchResearchFolioResponseData> searchResearchFolioResponseDataList = new ArrayList<>();
		PaginationLinks paginationLinks = new PaginationLinks();
		Pagination pagination = new Pagination();

		Status status = new Status();
		status.setId("1");
		Branch branch = new Branch();
		branch.setId("1");
		ResearchUser researchUser = new ResearchUser();
		researchUser.setId("1");
		researchUser.setFullName("Test User");
		Sender sender = new Sender();
		Contract contract = new Contract();
		Holder holder = new Holder();
		holder.setFullName("Test Holder");
		contract.setId("123456");
		sender.setContract(contract);
		sender.setHolder(holder);
		Receiver receiver = new Receiver();
		receiver.setContract(contract);
		receiver.setHolder(holder);

		searchResearchFolioResponseData.setOperationNumber("123456");
		searchResearchFolioResponseData.setOperationType("Test Operation");
		searchResearchFolioResponseData.setLiquidationDate(java.sql.Date.valueOf("2025-05-13"));
		searchResearchFolioResponseData.setTransmissionCode("Test Transmission");
		searchResearchFolioResponseData.setBranch(branch);
		searchResearchFolioResponseData.setSender(sender);
		searchResearchFolioResponseData.setReceiver(receiver);
		searchResearchFolioResponseData.setResearchUser(researchUser);
		searchResearchFolioResponseData.setStatus(status);

		paginationLinks.setFirst("1");
		paginationLinks.setLast("2");
		paginationLinks.setNext("3");
		paginationLinks.setPrevious("4");
		pagination.setPage(1L);
		pagination.setTotalPages(10L);
		pagination.setTotalElements(100L);
		pagination.setPageSize(1L);

		searchResearchFolioResponseDataList.add(searchResearchFolioResponseData);
		searchResearchFolioResponse.setPagination(pagination);
		searchResearchFolioResponse.setData(searchResearchFolioResponseDataList);

		when(pinvr001.executeSearchResearchFolio(searchResearchFolioRequest)).thenReturn(searchResearchFolioResponse);
		transaction.mapResponse(searchResearchFolioResponse);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void testMapResponse_EmptyData() {
		SearchResearchFolioResponse response = new SearchResearchFolioResponse();
		response.setData(new ArrayList<>());
		response.setPagination(null);

		transaction.mapResponse(response);

		assertNotNull("Debe contener datos", response.getData());
		assertTrue("La lista de datos debe estar vacía", response.getData().isEmpty());
		assertNull("No debe existir paginación", response.getPagination());

	}

	@Test
	public void testExecuteWithDefaultsAndNullResponse() {
		PINVT00101PETransaction customTransaction = new PINVT00101PETransaction() {
			@Override
			public String getPaginationkeyParam() {
				return "5";
			}

			@Override
			public String getPagesizeParam() {
				return "4";
			}

			@Override
			protected <T> T getServiceLibrary(Class<T> serviceInterface) {
				if (serviceInterface.equals(PINVR001.class)) {
					return (T) pinvr001;
				}
				return super.getServiceLibrary(serviceInterface);
			}


			@Override
			public void mapResponse(SearchResearchFolioResponse response) {
				super.mapResponse(response);
			}
		};

		Mockito.when(pinvr001.executeSearchResearchFolio(Mockito.any())).thenReturn(null);

		customTransaction.execute();

		ArgumentCaptor<SearchResearchFolioRequest> captor = ArgumentCaptor.forClass(SearchResearchFolioRequest.class);
		Mockito.verify(pinvr001).executeSearchResearchFolio(captor.capture());
		SearchResearchFolioRequest request = captor.getValue();

		assertEquals("5", request.getPaginationKey());
		assertEquals("4", request.getPageSize());
	}

	@Test
	public void testMapResponseWithNullPagination() {
		PINVT00101PETransaction transactionResponse = new PINVT00101PETransaction();
		SearchResearchFolioResponse response = new SearchResearchFolioResponse();
		response.setData(Collections.singletonList(new SearchResearchFolioResponseData()));
		response.setPagination(null);
		transactionResponse.mapResponse(response);
		assertNull(transactionResponse.getPaginationkeyParam());
	}

}
