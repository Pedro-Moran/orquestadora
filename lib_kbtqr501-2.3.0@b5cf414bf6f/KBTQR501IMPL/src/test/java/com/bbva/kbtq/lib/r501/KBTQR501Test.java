package com.bbva.kbtq.lib.r501;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.lib.r110.KBTQR110;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/KBTQR501-app.xml", "classpath:/META-INF/spring/KBTQR501-app-test.xml", "classpath:/META-INF/spring/KBTQR501-arc.xml",
		"classpath:/META-INF/spring/KBTQR501-arc-test.xml" })
public class KBTQR501Test {

	private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR501Test.class);

	@Spy
	private Context context;

	@Resource(name = "kbtqR501")
	private KBTQR501 kbtqR501;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Autowired
	private KBTQR110 kbtqR110;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}

	private Object getObjectIntrospection() throws Exception {
		Object result = this.kbtqR501;
		if (this.kbtqR501 instanceof Advised) {
			Advised advised = (Advised) this.kbtqR501;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}

	@Test
	public void executeTestEmpty() {
		LOGGER.info("Executing the test...");
		CustomerEntity customerEntity = kbtqR501.executeGetCustomerById(null);
		Assert.assertNull(customerEntity);
		Assert.assertEquals(1, context.getAdviceList().size());
	}

	@Test
	public void executeTestOk() {
		LOGGER.info("Executing the test...");

		Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(new CustomerEntity());
		CustomerEntity customerEntity = kbtqR501.executeGetCustomerById("Customer");
		Assert.assertNotNull(customerEntity);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeTestListEmpty() {
		LOGGER.info("Executing the test...");
		List<CustomerEntity> customerEntity = kbtqR501.executeGetCustomerListById(null);
		Assert.assertNull(customerEntity);
	}

	@Test
	public void executeTestListOk() {
		LOGGER.info("Executing the test...");

		Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(new CustomerEntity());
		List<CustomerEntity> customerEntity = kbtqR501.executeGetCustomerListById(Arrays.asList("Customer"));
		Assert.assertNotNull(customerEntity);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

	@Test
	public void executeTestReadCustomerIdentityDocumentNull() {
		LOGGER.info("los parametros de entrada vienen a null");
		CustomerEntity customerEntity = kbtqR501.executeReadCustomerIdentityDocument(null, null);
		Assert.assertEquals(1, context.getAdviceList().size());
		Assert.assertNull(customerEntity);
	}

	@Test
	public void executeTestReadCustomerIdentityDocumentPersonalTypeNull() {
		LOGGER.info("el personalId viene correctamente informado pero el personalType no");
		CustomerEntity customerEntity = kbtqR501.executeReadCustomerIdentityDocument("hola", null);
		Assert.assertEquals(1, context.getAdviceList().size());
		Assert.assertNull(customerEntity);
	}

	@Test
	public void executeTestReadCustomerIdentityDocumentPersonalTypeOk() {
		LOGGER.info("Los parametros vienen correctamente informados y responde correctamente");
		Mockito.when(kbtqR110.executeReadCustomerIdentityDocument(Mockito.any(), Mockito.any())).thenReturn(new CustomerEntity());
		CustomerEntity customerEntity = kbtqR501.executeReadCustomerIdentityDocument("hola", "hola");
		Assert.assertEquals(0, context.getAdviceList().size());
		Assert.assertNotNull(customerEntity);
	}
}
