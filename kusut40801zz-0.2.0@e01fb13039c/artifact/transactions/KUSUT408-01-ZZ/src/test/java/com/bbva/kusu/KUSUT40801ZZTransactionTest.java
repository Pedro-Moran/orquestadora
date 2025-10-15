package com.bbva.kusu;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.AdviceType;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.test.osgi.DummyBundleContext;
import com.bbva.kusu.lib.r408.KUSUR408;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/elara-test.xml", "classpath:/META-INF/spring/KUSUT40801ZZTest.xml" })
public class KUSUT40801ZZTransactionTest {

	@Autowired
	private KUSUT40801ZZTransaction transaction;

	@Resource(name = "dummyBundleContext")
	private DummyBundleContext bundleContext;

	private TransactionRequest transactionRequest;

	@Mock
	private KUSUR408 kusuR408;

	@Before
	public void initializeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
		transaction = new KUSUT40801ZZTransaction() {
			@Override
			protected <T> T getServiceLibrary(Class<T> serviceInterface) {
				return (T) kusuR408;
			}
		};

		this.transaction.start(bundleContext);
		this.transaction.setContext(new Context());
		this.transaction.getContext().setLanguageCode("ES");

		transactionRequest = Mockito.mock(TransactionRequest.class);
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<TransactionParameter>());
		transactionRequest.setBody(commonRequestBody);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn(null);
		this.transaction.getContext().setTransactionRequest(transactionRequest);

	}

	// ################################################

	@Test
	public void executeKoTest() {
		Answer<Void> addAdviceAnswer = new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
				Advice advice = new Advice("KUSU01433000", "Ha ocurrido un error", AdviceType.D, null);
				ThreadContext.get().getAdviceList().add(advice);
				return null;
			}
		};

		Mockito.doAnswer(addAdviceAnswer).when(kusuR408).executeGetVisibleOperableContracts(Mockito.any());
		this.transaction.execute();
		Assert.assertEquals(Severity.ENR, this.transaction.getSeverity());
		Assert.assertEquals("KUSU01433000", this.transaction.getContext().getAdviceList().getLast().getCode());
	}

	@Test
	public void executeOkTest() {
		this.transaction.execute();
		Assert.assertEquals(Severity.OK, this.transaction.getSeverity());
	}

}
