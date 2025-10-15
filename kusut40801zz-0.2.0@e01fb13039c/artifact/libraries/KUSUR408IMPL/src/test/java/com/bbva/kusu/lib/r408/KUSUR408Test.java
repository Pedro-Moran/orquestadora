package com.bbva.kusu.lib.r408;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.AdviceType;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.domain.transaction.request.header.OtmaPgApxQP05RequestHeader;
import com.bbva.kusu.dto.constants.ConstantError;
import com.bbva.kusu.dto.users.beans.ContractsVisibleOperableArray;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.dto.users.entity.AliasFavExtContractEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfileEntity;
import com.bbva.kusu.lib.r106.KUSUR106;
import com.bbva.kusu.lib.r121.KUSUR121;
import com.bbva.kusu.lib.r205.KUSUR205;
import com.bbva.kusu.lib.r408.impl.KUSUR408Impl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/KUSUR408-app.xml", "classpath:/META-INF/spring/KUSUR408-app-test.xml",
		"classpath:/META-INF/spring/KUSUR408-arc.xml", "classpath:/META-INF/spring/KUSUR408-arc-test.xml" })

public class KUSUR408Test {

	@InjectMocks
	private KUSUR408Impl kusuR408;

	@Mock
	private KUSUR106 kusuR106;

	@Mock
	private KUSUR121 kusuR121;

	@Mock
	private KUSUR205 kusuR205;

	@Mock
	private CommonRequestHeader requestHeader;

	@Mock
	private ApplicationConfigurationService applicationConfigurationService;

	@Spy
	private Context context;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		TransactionRequest transactionRequest = Mockito.mock(TransactionRequest.class);
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<TransactionParameter>());
		transactionRequest.setBody(commonRequestBody);
		context.setTransactionRequest(transactionRequest);
		ThreadContext.set(context);
		libraryConfiguration();
		getObjectIntrospection();
	}

	private void libraryConfiguration() {
		ThreadContext.get().getAdviceList().clear();
		kusuR408.setKusuR106(kusuR106);
		kusuR408.setKusuR121(kusuR121);
		kusuR408.setKusuR205(kusuR205);
		kusuR408.setApplicationConfigurationService(applicationConfigurationService);

		OtmaPgApxQP05RequestHeader header = new OtmaPgApxQP05RequestHeader();
		header.setCurrencyCode("EUR");
		header.setUserCode("XE36772");
		header.setAap("00000208");
		header.setChannelCode("01");
		header.setCountryCode("MX");
		context.getTransactionRequest().setHeader(header);
	}

	private Object getObjectIntrospection() throws Exception {
		Object result = this.kusuR408;
		if (this.kusuR408 instanceof Advised) {
			Advised advised = (Advised) this.kusuR408;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}

	// ######################################

	@Test
	public void mandatoryParametersTest() {
		kusuR408.executeGetVisibleOperableContracts(null);
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void profileNotFoundTest() {
		Answer<List<Map<String, Object>>> addAdviceAnswer = new Answer<List<Map<String, Object>>>() {
			@Override
			public List<Map<String, Object>> answer(final InvocationOnMock invocationOnMock) {

				Advice advice = new Advice(ConstantError.PROFILE_NOT_FOUND, "", AdviceType.E, null);
				context.getAdviceList().add(advice);
				return null;
			}
		};
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.any())).then(addAdviceAnswer);

		kusuR408.executeGetVisibleOperableContracts("acc");
		Assert.assertEquals(ConstantError.PROFILE_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void internalContractsTest() {
		Mockito.when(applicationConfigurationService.getProperty("kusu.countryCode")).thenReturn("ES");
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.any())).thenReturn(new CustUserProfileEntity());
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.any())).thenReturn(aliasFavContractDummy());

		ContractsVisibleOperableArray out = kusuR408.executeGetVisibleOperableContracts("acc");
		Assert.assertTrue(ThreadContext.get().getAdviceList().isEmpty());
		Assert.assertNotNull(out);
		
	}

	@Test
	public void emptyInternalContractsTest() {
		Mockito.when(applicationConfigurationService.getProperty("kusu.countryCode")).thenReturn("ES");
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.any())).thenReturn(new CustUserProfileEntity());
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.any())).thenReturn(null);

		ContractsVisibleOperableArray out = kusuR408.executeGetVisibleOperableContracts("acc");
		Assert.assertTrue(ThreadContext.get().getAdviceList().isEmpty());
		Assert.assertNull(out);
	}
	// ######################


	private List<AliasFavContractEntity> aliasFavContractDummy() {
		List<AliasFavContractEntity> outList = new ArrayList<>();

		AliasFavContractEntity dto = new AliasFavContractEntity();
		dto.setGUserAccountId("ACCOUNT-ID");
		dto.setGContractId("CONTRACT-ID");
		dto.setgOperativeContractIndType("N");
		dto.setgVisibleContractIndType("Y");
		outList.add(dto);

		AliasFavContractEntity dto2 = new AliasFavContractEntity();
		dto2.setGUserAccountId("ACCOUNT-ID");
		dto2.setGContractId("CONTRACT-ID");
		dto2.setgOperativeContractIndType("N");
		dto2.setgVisibleContractIndType("N");
		outList.add(dto2);

		AliasFavContractEntity dto3 = new AliasFavContractEntity();
		dto3.setGUserAccountId("ACCOUNT-ID");
		dto3.setGContractId("CONTRACT-ID");
		dto3.setgOperativeContractIndType("N");
		dto3.setgVisibleContractIndType("Y");
		outList.add(dto3);

		AliasFavContractEntity dto4 = new AliasFavContractEntity();
		dto4.setGUserAccountId("ACCOUNT-ID");
		dto4.setGContractId("CONTRACT-ID");
		dto4.setgOperativeContractIndType("N");
		dto4.setgVisibleContractIndType("N");
		outList.add(dto4);

		return outList;
	}

}