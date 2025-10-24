package com.bbva.kbtq.lib.r518;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.kbtq.dto.basicdata.entities.BasicDataEntities;
import com.bbva.kbtq.dto.c100.entities.CustomerDocumentEntity;
import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.dto.c101.entities.EconomicData;
import com.bbva.kbtq.dto.c400.KbtqAdvices;
import com.bbva.kbtq.dto.c400.coexistence.CoexistenceInformation;
import com.bbva.kbtq.dto.catalogs.OutputCatalog;
import com.bbva.kbtq.dto.catalogs.OutputDescription;
import com.bbva.kbtq.dto.persons.domain.Customer;
import com.bbva.kbtq.lib.r110.KBTQR110;
import com.bbva.kbtq.lib.r115.KBTQR115;
import com.bbva.kbtq.lib.r404.KBTQR404;
import com.bbva.kbtq.lib.r410.KBTQR410;
import com.bbva.kbtq.lib.r518.impl.KBTQR518Impl;
import com.bbva.kbtq.lib.r718.KBTQR718;
import com.bbva.kbtq.lib.r807.KBTQR807;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.co.jemos.podam.api.PodamFactory;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.PERSONALSTATUSTYPE;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.TITLETYPE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/KBTQR518-app.xml",
        "classpath:/META-INF/spring/KBTQR518-app-test.xml",
        "classpath:/META-INF/spring/KBTQR518-arc.xml",
        "classpath:/META-INF/spring/KBTQR518-arc-test.xml"})
public class KBTQR518Test {

    @Spy
    private Context context;

    @Resource
    private PodamFactory factory;

    @Resource(name = "kbtqR807")
    private KBTQR807 kbtqR807;

	@Resource(name = "kbtqR115")
	private KBTQR115 kbtqR115;


	@Resource(name = "kbtqR518")
	private KBTQR518 kbtqR518;

    @Resource(name = "kbtqR110")
    private KBTQR110 kbtqR110;

    @Resource(name = "kbtqR718")
    private KBTQR718 kbtqR718;

    @Resource(name = "kbtqR404")
    private KBTQR404 kbtqR404;

    @Resource(name = "kbtqR410")
    private KBTQR410 kbtqR410;

    private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR518Impl.class);
    
    @Resource(name = "applicationConfigurationService")
    private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		Mockito.reset(kbtqR110);
		Mockito.reset(kbtqR115);
		Mockito.reset(kbtqR718);
		Mockito.reset(kbtqR404);
        Mockito.reset(kbtqR807);
        Mockito.reset(kbtqR115);
        Mockito.reset(kbtqR410);
		MockitoAnnotations.initMocks(this);
        Mockito.when(this.kbtqR404.executeGetProperty(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("country.origin.value")).thenReturn(Optional.of("GL"));
        context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}

    private Object getObjectIntrospection() throws Exception {
        Object result = this.kbtqR518;
        if (this.kbtqR518 instanceof Advised) {
            Advised advised = (Advised) this.kbtqR518;
            result = advised.getTargetSource().getTarget();
        }
        return result;
    }

    @Test
    public void executeTestDistNull() {
        Mockito.when(kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        Customer customer = kbtqR518.executeGetCustomer(null);
        Assert.assertEquals(null, customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistDummyId() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());

        LOGGER.info("Executing the test...");
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertEquals(null, customer);
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponse() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());

        LOGGER.info("Executing the test...");

        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(null);

        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNull(customer);
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());

        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull1() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("aaaa"));
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull2() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("aaaa"));
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull3() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull4() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull5() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfPersonalType("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull8() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfPersonalType(null);
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull6() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfPersonalId(null);
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull7() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfPersonalId("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull9() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.of("XXX"));
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGBirthCountryId(null);
        customerEntity.setgPersonMainBranchId("");
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfPersonalId("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull10() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        ;
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGfCustomerType("FIS");
        customerEntity.setGBirthCountryId(null);
        customerEntity.setgPersonMainBranchId(null);
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfPersonalId("");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull11() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGfCustomerType("FIS");
        customerEntity.setGBirthCountryId(null);
        customerEntity.setGfPersonalType("FIS");
        customerEntity.setGfPersonalId("XXXXX");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(null);
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull12() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId(null);
        customerEntity.setGfCustomerType("FIS");
        customerEntity.setGBirthCountryId(null);
        customerEntity.setGfPersonalType("FIS");
        customerEntity.setGfPersonalId("XXXXX");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(null);
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseFull13() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("ES"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId(null);
        customerEntity.setGfCustomerType("FIS");
        customerEntity.setGBirthCountryId(null);
        customerEntity.setGfPersonalType("FIS");
        customerEntity.setGfPersonalId("XXXXX");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(null);
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponsePartial() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntityEmpty();
        customerEntity.setGfPersonalType("FIS");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    /*@Test
    public void executeTestDistWithResponsePartialFail() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntityEmpty();
        customerEntity.setGfCustomerType("JUR");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNull(customer);
        Assert.assertEquals(1, context.getAdviceList().size());
    }*/

    @Test
    public void executeTestDistWithResponsePartialFail2() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntityEmpty();
        customerEntity.setGfCustomerType("FIS");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        kbtqR518.executeGetCustomer("XXXXX");
    }

    @Test
    public void executeTestDistWithResponseB() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());

        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseNull() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntityNull();
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(generateCustomerDocumentEntity()));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }


    @Test
    public void executeTestDistWithResponseNull3() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntityNull();
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfMainDocumentType(null);
        customerDocumentEntity.setGfExpeditionDocStateId("");
        customerEntity.setGfPersonalType("1234");
        customerEntity.setGfPersonalId(null);
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(customerDocumentEntity));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestDistWithResponseNull4() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());
        Mockito.when(kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.empty());
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntityNull();
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        CustomerDocumentEntity customerDocumentEntity = generateCustomerDocumentEntity();
        customerDocumentEntity.setGfMainDocumentType(null);
        customerDocumentEntity.setGfExpeditionDocStateId("");
        customerEntity.setGfPersonalType("1234");
        customerEntity.setGfPersonalId("");
        Mockito.when(kbtqR115.executeListCustomerDocument(Mockito.any())).thenReturn(Collections.singletonList(customerDocumentEntity));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestHostNull() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.empty());

        LOGGER.info("Executing the test...");
        Mockito.when(this.kbtqR404.executeCheckPropertyIsActive(Mockito.any())).thenReturn(true);
        Customer customer = kbtqR518.executeGetCustomer("aaaaaa");
        Assert.assertEquals(null, customer);
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_do_nothing() {
        kbtqR518.executeGetCustomer(null);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void it_should_do_nothing_distributed() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("distributed"));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_return_data_distributed() {
        CustomerEntity customerEntity = factory.manufacturePojo(CustomerEntity.class);
        customerEntity.setGfCustomerType("FIS");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("distributed"));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void it_should_do_nothing_coexistence() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.empty());
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_fail_coexistence() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.empty());
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_ok_coexistence() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(true);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_ok_coexistence12() {
        CustomerEntity customerEntity = factory.manufacturePojo(CustomerEntity.class);
        customerEntity.setGfCustomerType("FIS");
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
    }

    @Test
    public void it_should_ok_coexistence1() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_ok_coexistence3() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
        Advice advice = new Advice();
        advice.setCode("KBTQ01429036");
        context.getAdviceList().add(advice);
        Assert.assertEquals(2, context.getAdviceList().size());
    }

    @Test
    public void it_should_ok_coexistence7() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR110.executeReadCustomer(Mockito.any())).thenReturn(new CustomerEntity());
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_ok_coexistence2() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        Mockito.when(kbtqR404.executeCheckPropertyIsActive("kbtq.lib.kbtqr518.coexistence.timestamp.active")).thenReturn(true);
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_ok_coexistence4() {
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        Mockito.when(kbtqR404.executeCheckPropertyIsActive("kbtq.lib.kbtqr518.coexistence.timestamp.active")).thenReturn(true);
        Mockito.when(kbtqR718.executeGetLastUpdateDate(Mockito.any())).thenReturn(new Date());
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
        Assert.assertEquals(1, context.getAdviceList().size());
    }

    @Test
    public void it_should_ok_coexistence5() {
        Customer customer = new Customer();

        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        Mockito.when(kbtqR404.executeCheckPropertyIsActive("kbtq.lib.kbtqr518.coexistence.timestamp.active")).thenReturn(true);
        Mockito.when(kbtqR718.executeGetLastUpdateDate(Mockito.any())).thenReturn(new Date());

        Advice advice = new Advice();
        advice.setCode(KbtqAdvices.KBTQ01429104.getId());
        context.getAdviceList().add(advice);

        Mockito.when(kbtqR404.executeCompareDatesFromCoexistenceAndDistributed(Mockito.any(), Mockito.any())).thenReturn(true);
        Mockito.when(kbtqR718.executeGetCustomerBasicData(Mockito.any())).thenReturn(customer);
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setCutOffDate(null);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
    }

    @Test
    public void it_should_ok_coexistence6() {
        EconomicData economicData = new EconomicData();
        economicData.setCustomerId("ES040419393948");

        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.functionalName")).thenReturn(Optional.of("123213"));
        Mockito.when(kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP"));
        Mockito.when(kbtqR404.executeCheckPropertyIsActive("kbtq.lib.kbtqr518.coexistence.timestamp.active")).thenReturn(true);
        Mockito.when(kbtqR718.executeGetLastUpdateDate(Mockito.any())).thenReturn(new Date());
        Mockito.when(kbtqR404.executeCompareDatesFromCoexistenceAndDistributed(Mockito.any(), Mockito.any())).thenReturn(true);
        CoexistenceInformation coexistenceInformation = factory.manufacturePojoWithFullData(CoexistenceInformation.class);
        coexistenceInformation.setMasterIndType(false);
        Mockito.when(kbtqR404.executeGetFunctionalObject(Mockito.any())).thenReturn(Optional.of(coexistenceInformation));
        kbtqR518.executeGetCustomer("1");
    }

    @Test
    public void executeTestOKCrudCoexistence() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP_CRUD"));
        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGfCustomerType("FIS");
        CustomerDocumentEntity customerDocumentEntity = factory.manufacturePojo(CustomerDocumentEntity.class);

        BasicDataEntities basicDataEntities = new BasicDataEntities();
        basicDataEntities.setCustomerEntity(customerEntity);
        basicDataEntities.setCustomerDocumentEntities(Collections.singletonList(customerDocumentEntity));

        Mockito.when(kbtqR807.executeGetBasicDataEntities(Mockito.any())).thenReturn(Optional.of(basicDataEntities));
        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestOKCrudCoexistence2() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP_CRUD"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("ES"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.of("ES"));

        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGfCustomerType("FIS");
        customerEntity.setGfPersonalStatusType("XXX");
        CustomerDocumentEntity customerDocumentEntity = factory.manufacturePojo(CustomerDocumentEntity.class);
        customerDocumentEntity.setgExpeditionDocCountryId(null);
        customerDocumentEntity.setGfPersonalType("XXX");
        customerDocumentEntity.setGfMainDocumentType("XXX");

        BasicDataEntities basicDataEntities = new BasicDataEntities();
        basicDataEntities.setCustomerEntity(customerEntity);
        basicDataEntities.setCustomerDocumentEntities(Collections.singletonList(customerDocumentEntity));

        OutputCatalog outputCatalog = new OutputCatalog();
        OutputDescription outputDescription = new OutputDescription();
        outputDescription.setParameter("XXX");
        outputDescription.setDescription("Description");
        outputCatalog.setOutputDescriptions(Collections.singletonList(outputDescription));
        outputCatalog.setType(PERSONALSTATUSTYPE);

        Mockito.when(kbtqR410.executeGetListParamName(Mockito.any(),Mockito.any())).thenReturn(Collections.singletonList(outputCatalog));
        Mockito.when(kbtqR807.executeGetBasicDataEntities(Mockito.any())).thenReturn(Optional.of(basicDataEntities));

        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestOKCrudCoexistence10() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP_CRUD"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("ES"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.of("ES"));


        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGfCustomerType("FIS");
        customerEntity.setGfPersonalStatusType("XXX");
        customerEntity.setGfTitleType("XXX");
        CustomerDocumentEntity customerDocumentEntity = factory.manufacturePojo(CustomerDocumentEntity.class);
        customerDocumentEntity.setgExpeditionDocCountryId(null);
        customerDocumentEntity.setGfPersonalType("XXX");
        customerDocumentEntity.setGfMainDocumentType("XXX");

        BasicDataEntities basicDataEntities = new BasicDataEntities();
        basicDataEntities.setCustomerEntity(customerEntity);
        basicDataEntities.setCustomerDocumentEntities(Collections.singletonList(customerDocumentEntity));
        List<OutputCatalog> outputCatalogs = new ArrayList<>();

        OutputCatalog outputCatalog = new OutputCatalog();
        OutputDescription outputDescription = new OutputDescription();
        outputDescription.setParameter("XX");
        outputDescription.setDescription("Description");
        outputCatalog.setOutputDescriptions(Collections.singletonList(outputDescription));
        outputCatalog.setType(PERSONALSTATUSTYPE);
        outputCatalogs.add(outputCatalog);

        OutputCatalog outputCatalog1 = new OutputCatalog();
        OutputDescription outputDescription1 = new OutputDescription();
        outputDescription.setParameter(null);
        outputDescription.setDescription("Description");
        outputCatalog.setOutputDescriptions(Collections.singletonList(outputDescription1));
        outputCatalog.setType(TITLETYPE);
        outputCatalogs.add(outputCatalog1);

        Mockito.when(kbtqR410.executeGetListParamName(Mockito.any(),Mockito.any())).thenReturn(outputCatalogs);

        Mockito.when(kbtqR807.executeGetBasicDataEntities(Mockito.any())).thenReturn(Optional.of(basicDataEntities));

        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }


    @Test
    public void executeTestOKCrudCoexistence11() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP_CRUD"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("ES"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.of("ES"));


        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGfCustomerType("JUR");
        customerEntity.setGfPersonalStatusType("XXX");
        customerEntity.setGfTitleType("XXX");
        CustomerDocumentEntity customerDocumentEntity = factory.manufacturePojo(CustomerDocumentEntity.class);
        customerDocumentEntity.setgExpeditionDocCountryId(null);
        customerDocumentEntity.setGfPersonalStatusType("XXX");
        customerDocumentEntity.setGfMainDocumentType("XXX");

        BasicDataEntities basicDataEntities = new BasicDataEntities();
        basicDataEntities.setCustomerEntity(customerEntity);
        basicDataEntities.setCustomerDocumentEntities(Collections.singletonList(customerDocumentEntity));

        List<OutputCatalog> outputCatalogs = new ArrayList<>();

        OutputCatalog outputCatalog = new OutputCatalog();
        OutputDescription outputDescription = new OutputDescription();
        outputDescription.setParameter("XXX");
        outputDescription.setDescription("Description");
        outputCatalog.setOutputDescriptions(Collections.singletonList(outputDescription));
        outputCatalog.setType(PERSONALSTATUSTYPE);
        outputCatalogs.add(outputCatalog);

        OutputCatalog outputCatalog1 = new OutputCatalog();
        OutputDescription outputDescription1 = new OutputDescription();
        outputDescription1.setParameter(null);
        outputDescription1.setDescription("Description");
        outputCatalog1.setOutputDescriptions(Collections.singletonList(outputDescription1));
        outputCatalog1.setType(TITLETYPE);
        outputCatalogs.add(outputCatalog1);

        Mockito.when(kbtqR410.executeGetListParamName(Mockito.any(),Mockito.any())).thenReturn(outputCatalogs);

        Mockito.when(kbtqR807.executeGetBasicDataEntities(Mockito.any())).thenReturn(Optional.of(basicDataEntities));

        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }


    @Test
    public void executeTestKOCrudCoexistence3() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP_CRUD"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("ES"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.of("ES"));

        LOGGER.info("Executing the test...");

        CustomerDocumentEntity customerDocumentEntity = factory.manufacturePojo(CustomerDocumentEntity.class);
        customerDocumentEntity.setgExpeditionDocCountryId(null);

        BasicDataEntities basicDataEntities = new BasicDataEntities();
        basicDataEntities.setCustomerEntity(null);
        basicDataEntities.setCustomerDocumentEntities(Collections.singletonList(customerDocumentEntity));

        Mockito.when(kbtqR807.executeGetBasicDataEntities(Mockito.any())).thenReturn(Optional.of(basicDataEntities));

        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }


    @Test
    public void executeTestOKCrudCoexistence4() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP_CRUD"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.IdentityDocuments.country.id")).thenReturn(Optional.of("ES"));
        Mockito.when(this.kbtqR404.executeGetProperty("KBTQR254.birthData.country.id")).thenReturn(Optional.of("ES"));

        LOGGER.info("Executing the test...");
        CustomerEntity customerEntity = generateCustomerEntity();
        customerEntity.setgExpeditionDocCountryId("");
        customerEntity.setGfCustomerType("FIS");
        customerEntity.setGfCustomerStatusType(null);
        CustomerDocumentEntity customerDocumentEntity = factory.manufacturePojo(CustomerDocumentEntity.class);
        customerDocumentEntity.setgExpeditionDocCountryId(null);
        customerDocumentEntity.setGfCustomerVerificationType(null);

        BasicDataEntities basicDataEntities = new BasicDataEntities();
        basicDataEntities.setCustomerEntity(customerEntity);
        basicDataEntities.setCustomerDocumentEntities(Collections.singletonList(customerDocumentEntity));

        Mockito.when(kbtqR807.executeGetBasicDataEntities(Mockito.any())).thenReturn(Optional.of(basicDataEntities));

        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNotNull(customer);
        Assert.assertEquals(0, context.getAdviceList().size());
    }

    @Test
    public void executeTestOKCrudCoexistence3() {
        Mockito.when(this.kbtqR404.executeGetProperty("kbtq.lib.kbtqr518.coexistence.type")).thenReturn(Optional.of("COEXISTENCE_TIMESTAMP_CRUD"));
        LOGGER.info("Executing the test...");
        Mockito.when(kbtqR807.executeGetBasicDataEntities(Mockito.any())).thenReturn(Optional.empty());

        Customer customer = kbtqR518.executeGetCustomer("XXXXX");
        Assert.assertNull(customer);
        Assert.assertEquals(1, context.getAdviceList().size());
    }




    public CoexistenceInformation generateCoexistenceInformation() {
        CoexistenceInformation coexistenceInformation = new CoexistenceInformation();
        coexistenceInformation.setMasterIndType(false);
        return coexistenceInformation;
    }


    public CoexistenceInformation generateCoexistenceInformationNewDate() {
        CoexistenceInformation coexistenceInformation = new CoexistenceInformation();
        coexistenceInformation.setMasterIndType(false);
        coexistenceInformation.setCutOffDate(new Date());
        return coexistenceInformation;
    }


    private CustomerEntity generateCustomerEntityNull1() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(null);

        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityNull2() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("");

        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityNull3() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("a");
        customerEntity.setGfFirstName(null);
        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityNull4() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("a");
        customerEntity.setGfFirstName("");
        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityNull5() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("a");
        customerEntity.setGfFirstName("a");
        customerEntity.setGfPersonalType(null);
        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityNull6() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("a");
        customerEntity.setGfFirstName("a");
        customerEntity.setGfPersonalType("");
        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityNull7() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("a");
        customerEntity.setGfFirstName("a");
        customerEntity.setGfPersonalType("F");
        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityNull8() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("a");
        customerEntity.setGfFirstName("a");
        customerEntity.setGfPersonalType("F");
        customerEntity.setGfCustomerEntryDate(new Date());
        return customerEntity;
    }


    private CustomerEntity generateCustomerEntityNull() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("XXXX");
        customerEntity.setGCountryId("XXXX");
        customerEntity.setGfEntityId(null);
        customerEntity.setGfCustomerId("XXXX");
        customerEntity.setGfCustomerType("XXXX");
        customerEntity.setGfCustomerEntryDate(new Date());
        customerEntity.setGfCustomerUpdateTimeDate(new Date());
        customerEntity.setGfPersonalType("XXXX");
        customerEntity.setGfPersonalId(null);
        customerEntity.setGfPersonalStatusType("XXXX");
        customerEntity.setGfExpeditionDocStateId("XXXX");
        customerEntity.setGfExpeditionDocumentDate(new Date());
        customerEntity.setGfDocumentExpirationDate(new Date());
        customerEntity.setGfDocumentUpdateDate(new Date());
        customerEntity.setGfPersonalDocSubtypeType("XXXX");
        customerEntity.setGfLegalPersonInstType("XXXX");
        customerEntity.setGfInstTypeCriterionId("XXXX");
        customerEntity.setGfConsolidationCompaniesId("XXXX");
        customerEntity.setGfFirstName("XXXX");
        customerEntity.setGfPersonNameSuffixType("XXXX");
        customerEntity.setGfMiddleName("XXXX");
        customerEntity.setGfLastName("XXXX");
        customerEntity.setGfSecondLastName("XXXX");
        customerEntity.setGfCompanyTradeName("XXXX");
        customerEntity.setGfGenderType(null);
        customerEntity.setGfBirthDate(new Date());
        customerEntity.setGfResidentType("XXXX");
        customerEntity.setGfCountryNationalityId(null);
        customerEntity.setGResidenceCountryId("XXXX");
        customerEntity.setGBirthCountryId(null);
        customerEntity.setGfBirthTownName("XXXX");
        customerEntity.setGfProvinceBirthName("XXXX");
        customerEntity.setGfMaritalStatusType(null);
        customerEntity.setGfMatrimonialRegimeType("XXXX");
        customerEntity.setGfAddressType("XXXX");
        customerEntity.setGfResidenceType("XXXX");
        customerEntity.setGfAddressCountryId("XXXX");
        customerEntity.setGfGeographicGroupId("XXXX");
        customerEntity.setGfProvinceId("XXXX");
        customerEntity.setGfTownId("XXXX");
        customerEntity.setGfAddressDistrictId("XXXX");
        customerEntity.setGfRoadTypeId("XXXX");
        customerEntity.setGfAddressRoadDesc("XXXX");
        customerEntity.setGfPrimryAddrRoadNumberId("XXXX");
        customerEntity.setGfUrbanizationType("XXXX");
        customerEntity.setGfUrbanizationName("XXXX");
        customerEntity.setGfSecndyAddrRoadNumberId("XXXX");
        customerEntity.setGfAddressReferenceDesc("XXXX");
        customerEntity.setGfZipcodeId("XXXX");
        customerEntity.setGfAddressVerifiedType("XXXX");
        customerEntity.setGfAddressVerifiedDate(new Date());
        customerEntity.setGfAddressDesc("XXXX");
        customerEntity.setGfAddressXCoordNumber(new BigDecimal(333));
        customerEntity.setGfAddressYCoordNumber(new BigDecimal(3334));
        customerEntity.setGfEmailDesc("XXXX");
        customerEntity.setGfPhoneType("XXXX");
        customerEntity.setGfPrefixPhoneId("XXXX");
        customerEntity.setGfExtensionPhoneId("XXXX");
        customerEntity.setGfPhoneId("XXXX");
        customerEntity.setGfSegmentId("XXXX");
        customerEntity.setGfTitleType(null);
        customerEntity.setGfResidenceDate(new Date());
        customerEntity.setGfPersonEducationId("XXXX");
        customerEntity.setGfAccountingSectorId("XXXX");
        customerEntity.setGfAccountingSubsectorId("XXXX");
        customerEntity.setGfLegalStatusId("XXXX");
        customerEntity.setGfVipCustomerBankingType("XXXX");
        customerEntity.setGSwiftId("XXXX");
        customerEntity.setGfActivityEndDate(new Date());
        customerEntity.setGfCorrespondenceLanguageId(null);
        customerEntity.setGfLocalInstitutionId("XXXX");
        customerEntity.setGfTaxExemptType("XXXX");
        customerEntity.setGfTaxExemptionInitialDate(new Date());
        customerEntity.setGfTaxExemptEndDate(new Date());
        customerEntity.setGfRoleType("XXXX");
        customerEntity.setGfEmployeeEntityId(null);
        customerEntity.setGfFaxId("XXXX");
        customerEntity.setGfRecipientMailName("XXXX");
        customerEntity.setGfWebsiteDesc("XXXX");
        customerEntity.setGfCustomerEndDate(new Date());
        customerEntity.setGfTaxpayerId("XXXX");
        customerEntity.setGfCheckName("XXXX");
        customerEntity.setGAccountRegisterEntityId("XXXX");
        customerEntity.setGfAccountRegisterBranchId(null);
        customerEntity.setGfCardHolderName("XXXX");
        customerEntity.setGfStudyTitleId("XXXX");
        customerEntity.setGfCustomerContactType("XXXX");
        customerEntity.setGfPersonQttvRatingType("XXXX");
        customerEntity.setGfCustSubgroupClassifId("XXXX");
        customerEntity.setGfCustomerStatusType("XXXX");
        customerEntity.setGfCustomerVerificationType("XXXX");
        customerEntity.setGfCutCoEconActivityId("XXXX");
        customerEntity.setGfDecreeDependencyId("XXXX");
        customerEntity.setGfReserveDate(new Date());
        customerEntity.setGfReservedInformationType("XXXX");
        customerEntity.setGfStudyLevelType("XXXX");
        customerEntity.setGfTerminalLastModifyId("XXXX");
        customerEntity.setGfBankruptcySituationId("XXXX");
        customerEntity.setGfPersAddressForeignDesc("XXXX");
        customerEntity.setGfBranchReassignedId("XXXX");
        customerEntity.setGfBranchReassignedDesc("XXXX");
        customerEntity.setGfPoltclExpsPersType("XXXX");
        customerEntity.setGfUnifiedMailType("XXXX");
        customerEntity.setGfHoldedMailId("XXXX");
        customerEntity.setGfPeriodicityMailNumber(new BigDecimal(2333));
        customerEntity.setGfReturnedMailType("XXXX");
        customerEntity.setGfLastChangeEntityId("XXXX");
        customerEntity.setGfLastChangeBranchId("XXXX");
        customerEntity.setGfSeniorPosType("XXXX");
        customerEntity.setGCustomerLanguageId("XXXX");
        customerEntity.setGfUserAuditId("XXXX");
        customerEntity.setGfAuditDate(new Date());
        customerEntity.setgExpeditionDocCountryId("XXXX");
        customerEntity.setGfExpeditionDocTownName("XXXX");
        customerEntity.setgSoverignIndType("XXXX");
        customerEntity.setgCentAdmPubCompType("XXXX");
        customerEntity.setGfExtrNetInstallationId("XXXX");
        customerEntity.setGfLocalRepositoryId("XXXX");
        customerEntity.setGfRecordFunclUpdateDate(new Date());
        customerEntity.setGfOperationalAuditDate(new Date());
        customerEntity.setGfConciliationId("XXXX");
        customerEntity.setgUpdateSourceType("XXXX");
        customerEntity.setgCtrngDisqualificationType("XXX");
        customerEntity.setgCavaCustomerType("XXX");
        return customerEntity;
    }

    private CustomerEntity generateCustomerEntityEmpty() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("XXXX");
        customerEntity.setGCountryId("XXXX");
        customerEntity.setGfEntityId("");
        customerEntity.setGfCustomerId("XXXX");
        customerEntity.setGfCustomerType("XXXX");
        customerEntity.setGfCustomerEntryDate(new Date());
        customerEntity.setGfCustomerUpdateTimeDate(new Date());
        customerEntity.setGfPersonalType("XXXX");
        customerEntity.setGfPersonalId("");
        customerEntity.setGfPersonalStatusType("XXXX");
        customerEntity.setGfExpeditionDocStateId("XXXX");
        customerEntity.setGfExpeditionDocumentDate(new Date());
        customerEntity.setGfDocumentExpirationDate(new Date());
        customerEntity.setGfDocumentUpdateDate(new Date());
        customerEntity.setGfPersonalDocSubtypeType("XXXX");
        customerEntity.setGfLegalPersonInstType("XXXX");
        customerEntity.setGfInstTypeCriterionId("XXXX");
        customerEntity.setGfConsolidationCompaniesId("XXXX");
        customerEntity.setGfFirstName("XXXX");
        customerEntity.setGfPersonNameSuffixType("XXXX");
        customerEntity.setGfMiddleName("XXXX");
        customerEntity.setGfLastName("XXXX");
        customerEntity.setGfSecondLastName("XXXX");
        customerEntity.setGfCompanyTradeName("XXXX");
        customerEntity.setGfGenderType("");
        customerEntity.setGfBirthDate(new Date());
        customerEntity.setGfResidentType("XXXX");
        customerEntity.setGfCountryNationalityId("");
        customerEntity.setGResidenceCountryId("XXXX");
        customerEntity.setGBirthCountryId("");
        customerEntity.setGfBirthTownName("XXXX");
        customerEntity.setGfProvinceBirthName("XXXX");
        customerEntity.setGfMaritalStatusType("");
        customerEntity.setGfMatrimonialRegimeType("XXXX");
        customerEntity.setGfAddressType("XXXX");
        customerEntity.setGfResidenceType("XXXX");
        customerEntity.setGfAddressCountryId("XXXX");
        customerEntity.setGfGeographicGroupId("XXXX");
        customerEntity.setGfProvinceId("XXXX");
        customerEntity.setGfTownId("XXXX");
        customerEntity.setGfAddressDistrictId("XXXX");
        customerEntity.setGfRoadTypeId("XXXX");
        customerEntity.setGfAddressRoadDesc("XXXX");
        customerEntity.setGfPrimryAddrRoadNumberId("XXXX");
        customerEntity.setGfUrbanizationType("XXXX");
        customerEntity.setGfUrbanizationName("XXXX");
        customerEntity.setGfSecndyAddrRoadNumberId("XXXX");
        customerEntity.setGfAddressReferenceDesc("XXXX");
        customerEntity.setGfZipcodeId("XXXX");
        customerEntity.setGfAddressVerifiedType("XXXX");
        customerEntity.setGfAddressVerifiedDate(new Date());
        customerEntity.setGfAddressDesc("XXXX");
        customerEntity.setGfAddressXCoordNumber(new BigDecimal(333));
        customerEntity.setGfAddressYCoordNumber(new BigDecimal(3334));
        customerEntity.setGfEmailDesc("XXXX");
        customerEntity.setGfPhoneType("XXXX");
        customerEntity.setGfPrefixPhoneId("XXXX");
        customerEntity.setGfExtensionPhoneId("XXXX");
        customerEntity.setGfPhoneId("XXXX");
        customerEntity.setGfSegmentId("XXXX");
        customerEntity.setGfTitleType("");
        customerEntity.setGfResidenceDate(new Date());
        customerEntity.setGfPersonEducationId("XXXX");
        customerEntity.setGfAccountingSectorId("XXXX");
        customerEntity.setGfAccountingSubsectorId("XXXX");
        customerEntity.setGfLegalStatusId("XXXX");
        customerEntity.setGfVipCustomerBankingType("XXXX");
        customerEntity.setGSwiftId("XXXX");
        customerEntity.setGfActivityEndDate(new Date());
        customerEntity.setGfCorrespondenceLanguageId("");
        customerEntity.setGfLocalInstitutionId("XXXX");
        customerEntity.setGfTaxExemptType("XXXX");
        customerEntity.setGfTaxExemptionInitialDate(new Date());
        customerEntity.setGfTaxExemptEndDate(new Date());
        customerEntity.setGfRoleType("XXXX");
        customerEntity.setGfEmployeeEntityId("");
        customerEntity.setGfFaxId("XXXX");
        customerEntity.setGfRecipientMailName("XXXX");
        customerEntity.setGfWebsiteDesc("XXXX");
        customerEntity.setGfCustomerEndDate(new Date());
        customerEntity.setGfTaxpayerId("XXXX");
        customerEntity.setGfCheckName("XXXX");
        customerEntity.setGAccountRegisterEntityId("XXXX");
        customerEntity.setGfAccountRegisterBranchId("");
        customerEntity.setGfCardHolderName("XXXX");
        customerEntity.setGfStudyTitleId("XXXX");
        customerEntity.setGfCustomerContactType("XXXX");
        customerEntity.setGfPersonQttvRatingType("XXXX");
        customerEntity.setGfCustSubgroupClassifId("XXXX");
        customerEntity.setGfCustomerStatusType("XXXX");
        customerEntity.setGfCustomerVerificationType("XXXX");
        customerEntity.setGfCutCoEconActivityId("XXXX");
        customerEntity.setGfDecreeDependencyId("XXXX");
        customerEntity.setGfReserveDate(new Date());
        customerEntity.setGfReservedInformationType("XXXX");
        customerEntity.setGfStudyLevelType("XXXX");
        customerEntity.setGfTerminalLastModifyId("XXXX");
        customerEntity.setGfBankruptcySituationId("XXXX");
        customerEntity.setGfPersAddressForeignDesc("XXXX");
        customerEntity.setGfBranchReassignedId("XXXX");
        customerEntity.setGfBranchReassignedDesc("XXXX");
        customerEntity.setGfPoltclExpsPersType("XXXX");
        customerEntity.setGfUnifiedMailType("XXXX");
        customerEntity.setGfHoldedMailId("XXXX");
        customerEntity.setGfPeriodicityMailNumber(new BigDecimal(2333));
        customerEntity.setGfReturnedMailType("XXXX");
        customerEntity.setGfLastChangeEntityId("XXXX");
        customerEntity.setGfLastChangeBranchId("XXXX");
        customerEntity.setGfSeniorPosType("XXXX");
        customerEntity.setGCustomerLanguageId("XXXX");
        customerEntity.setGfUserAuditId("XXXX");
        customerEntity.setGfAuditDate(new Date());
        customerEntity.setgExpeditionDocCountryId("XXXX");
        customerEntity.setGfExpeditionDocTownName("XXXX");
        customerEntity.setgSoverignIndType("XXXX");
        customerEntity.setgCentAdmPubCompType("XXXX");
        customerEntity.setGfExtrNetInstallationId("XXXX");
        customerEntity.setGfLocalRepositoryId("XXXX");
        customerEntity.setGfRecordFunclUpdateDate(new Date());
        customerEntity.setGfOperationalAuditDate(new Date());
        customerEntity.setGfConciliationId("XXXX");
        customerEntity.setgUpdateSourceType("XXXX");
        customerEntity.setgPersonMainBranchId("");
        return customerEntity;
    }

    private CustomerEntity generateCustomerEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId("XXXX");
        customerEntity.setGCountryId("XXXX");
        customerEntity.setGfEntityId("XXXX");
        customerEntity.setGfCustomerId("XXXX");
        customerEntity.setGfCustomerType("J");
        customerEntity.setGfCustomerEntryDate(new Date());
        customerEntity.setGfCustomerUpdateTimeDate(new Date());
        customerEntity.setGfPersonalType("XXXX");
        customerEntity.setGfPersonalId("XXXX");
        customerEntity.setGfPersonalStatusType("XXXX");
        customerEntity.setGfExpeditionDocStateId("XXXX");
        customerEntity.setGfExpeditionDocumentDate(new Date());
        customerEntity.setGfDocumentExpirationDate(new Date());
        customerEntity.setGfDocumentUpdateDate(new Date());
        customerEntity.setGfPersonalDocSubtypeType("XXXX");
        customerEntity.setGfLegalPersonInstType("XXXX");
        customerEntity.setGfInstTypeCriterionId("XXXX");
        customerEntity.setGfConsolidationCompaniesId("XXXX");
        customerEntity.setGfFirstName("XXXX");
        customerEntity.setGfPersonNameSuffixType("XXXX");
        customerEntity.setGfMiddleName("XXXX");
        customerEntity.setGfLastName("XXXX");
        customerEntity.setGfSecondLastName("XXXX");
        customerEntity.setGfCompanyTradeName("XXXX");
        customerEntity.setGfGenderType("XXXX");
        customerEntity.setGfBirthDate(new Date());
        customerEntity.setGfResidentType("XXXX");
        customerEntity.setGfCountryNationalityId("XXXX");
        customerEntity.setGResidenceCountryId("XXXX");
        customerEntity.setGBirthCountryId("XXXX");
        customerEntity.setGfBirthTownName("XXXX");
        customerEntity.setGfProvinceBirthName("XXXX");
        customerEntity.setGfMaritalStatusType("XXXX");
        customerEntity.setGfMatrimonialRegimeType("XXXX");
        customerEntity.setGfAddressType("XXXX");
        customerEntity.setGfResidenceType("XXXX");
        customerEntity.setGfAddressCountryId("XXXX");
        customerEntity.setGfGeographicGroupId("XXXX");
        customerEntity.setGfProvinceId("XXXX");
        customerEntity.setGfTownId("XXXX");
        customerEntity.setGfAddressDistrictId("XXXX");
        customerEntity.setGfRoadTypeId("XXXX");
        customerEntity.setGfAddressRoadDesc("XXXX");
        customerEntity.setGfPrimryAddrRoadNumberId("XXXX");
        customerEntity.setGfUrbanizationType("XXXX");
        customerEntity.setGfUrbanizationName("XXXX");
        customerEntity.setGfSecndyAddrRoadNumberId("XXXX");
        customerEntity.setGfAddressReferenceDesc("XXXX");
        customerEntity.setGfZipcodeId("XXXX");
        customerEntity.setGfAddressVerifiedType("XXXX");
        customerEntity.setGfAddressVerifiedDate(new Date());
        customerEntity.setGfAddressDesc("XXXX");
        customerEntity.setGfAddressXCoordNumber(new BigDecimal(333));
        customerEntity.setGfAddressYCoordNumber(new BigDecimal(3334));
        customerEntity.setGfEmailDesc("XXXX");
        customerEntity.setGfPhoneType("XXXX");
        customerEntity.setGfPrefixPhoneId("XXXX");
        customerEntity.setGfExtensionPhoneId("XXXX");
        customerEntity.setGfPhoneId("XXXX");
        customerEntity.setGfSegmentId("XXXX");
        customerEntity.setGfTitleType("XXXX");
        customerEntity.setGfResidenceDate(new Date());
        customerEntity.setGfPersonEducationId("XXXX");
        customerEntity.setGfAccountingSectorId("XXXX");
        customerEntity.setGfAccountingSubsectorId("XXXX");
        customerEntity.setGfLegalStatusId("XXXX");
        customerEntity.setGfVipCustomerBankingType("XXXX");
        customerEntity.setGSwiftId("XXXX");
        customerEntity.setGfActivityEndDate(new Date());
        customerEntity.setGfCorrespondenceLanguageId("XXXX");
        customerEntity.setGfLocalInstitutionId("XXXX");
        customerEntity.setGfTaxExemptType("XXXX");
        customerEntity.setGfTaxExemptionInitialDate(new Date());
        customerEntity.setGfTaxExemptEndDate(new Date());
        customerEntity.setGfRoleType("XXXX");
        customerEntity.setGfEmployeeEntityId("XXXX");
        customerEntity.setGfFaxId("XXXX");
        customerEntity.setGfRecipientMailName("XXXX");
        customerEntity.setGfWebsiteDesc("XXXX");
        customerEntity.setGfCustomerEndDate(new Date());
        customerEntity.setGfCheckName("XXXX");
        customerEntity.setGAccountRegisterEntityId("XXXX");
        customerEntity.setGfAccountRegisterBranchId("XXXX");
        customerEntity.setGfCardHolderName("XXXX");
        customerEntity.setGfStudyTitleId("XXXX");
        customerEntity.setGfCustomerContactType("XXXX");
        customerEntity.setGfPersonQttvRatingType("XXXX");
        customerEntity.setGfCustSubgroupClassifId("XXXX");
        customerEntity.setGfCustomerStatusType("XXXX");
        customerEntity.setGfCustomerVerificationType("XXXX");
        customerEntity.setGfCutCoEconActivityId("XXXX");
        customerEntity.setGfDecreeDependencyId("XXXX");
        customerEntity.setGfReserveDate(new Date());
        customerEntity.setGfReservedInformationType("XXXX");
        customerEntity.setGfStudyLevelType("XXXX");
        customerEntity.setGfTerminalLastModifyId("XXXX");
        customerEntity.setGfBankruptcySituationId("XXXX");
        customerEntity.setGfPersAddressForeignDesc("XXXX");
        customerEntity.setGfBranchReassignedId("XXXX");
        customerEntity.setGfBranchReassignedDesc("XXXX");
        customerEntity.setGfPoltclExpsPersType("XXXX");
        customerEntity.setGfUnifiedMailType("XXXX");
        customerEntity.setGfHoldedMailId("XXXX");
        customerEntity.setGfPeriodicityMailNumber(new BigDecimal(2333));
        customerEntity.setGfReturnedMailType("XXXX");
        customerEntity.setGfLastChangeEntityId("XXXX");
        customerEntity.setGfLastChangeBranchId("XXXX");
        customerEntity.setGfSeniorPosType("XXXX");
        customerEntity.setGCustomerLanguageId("XXXX");
        customerEntity.setGfUserAuditId("XXXX");
        customerEntity.setGfAuditDate(new Date());
        customerEntity.setgExpeditionDocCountryId("XXXX");
        customerEntity.setGfExpeditionDocTownName("XXXX");
        customerEntity.setgSoverignIndType("XXXX");
        customerEntity.setgCentAdmPubCompType("XXXX");
        customerEntity.setGfExtrNetInstallationId("XXXX");
        customerEntity.setGfLocalRepositoryId("XXXX");
        customerEntity.setGfRecordFunclUpdateDate(new Date());
        customerEntity.setGfOperationalAuditDate(new Date());
        customerEntity.setGfConciliationId("XXXX");
        customerEntity.setgUpdateSourceType("XXXX");
        customerEntity.setgPersonMainBranchId("XXXXXX");
        return customerEntity;
    }


    private CustomerDocumentEntity generateCustomerDocumentEntity() {
        CustomerDocumentEntity customerDocumentEntity = new CustomerDocumentEntity();
        customerDocumentEntity.setGfPersonalType("FIS");
        customerDocumentEntity.setGfPersonalId("XXXX");
        customerDocumentEntity.setGfExpeditionDocStateId("XXXX");
        customerDocumentEntity.setGfExpeditionDocumentDate(new Date());
        customerDocumentEntity.setGfExpeditionDocTownName("XXXX");
        customerDocumentEntity.setgExpeditionDocCountryId("XXXX");
        customerDocumentEntity.setGfMainDocumentType("Y");
        return customerDocumentEntity;
    }
}
