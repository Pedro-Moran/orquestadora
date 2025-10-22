package com.bbva.kbtq.lib.r226.impl;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;

import com.bbva.kbtq.dto.c226.entity.CustomerNationalityEntity;
import com.bbva.kbtq.dto.c400.KbtqAdvices;
import com.bbva.kbtq.lib.r226.KBTQR226;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/KBTQR226-app.xml",
        "classpath:/META-INF/spring/KBTQR226-app-test.xml",
        "classpath:/META-INF/spring/KBTQR226-arc.xml",
        "classpath:/META-INF/spring/KBTQR226-arc-test.xml"})
public class KBTQR226ImplTest {


    /* There are methods of the APX Architecture that require greater complexity to mock, for this reason
     * an instance of the class to be tested can be created with the overwritten methods and on these
     * methods the mocking of the classes is carried out, for example Header data
     * (The Mocking the header is only for libraries that are used online, in batch it would not work)
     *
     * Import section:
     * - import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
     * - import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
     *
     * Instance section:
     * 	@Mock
     *  private CommonRequestHeader commonRequestHeader;
     *
     *  @InjectMocks
     *  private KBTQR226Impl kbtqR226 = new KBTQR226Impl() {
     *  	@Override
     *  	protected CommonRequestHeader getRequestHeader() {
     *  		return commonRequestHeader;
     *  	}
     *  };
     */
    @Resource(name = "kbtqR226")
    private KBTQR226 kbtqR226;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ThreadContext.get().getAdviceList().clear();
    }

    @Test
    public void executeGetCustomerNationalities_withValidCustomerId_returnsCustomerNationalities() {
        String customerId = "CUST123";


        Optional<List<CustomerNationalityEntity>> result = kbtqR226.executeGetCustomerNationalities(customerId);

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(customerId, result.get().get(0).getCustomerId());

        customerId = "CUST987";


        result = kbtqR226.executeGetCustomerNationalities(customerId);

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(customerId, result.get().get(0).getCustomerId());

        customerId = "CUST456";


        result = kbtqR226.executeGetCustomerNationalities(customerId);

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(customerId, result.get().get(0).getCustomerId());
        customerId = "CUST321";


        result = kbtqR226.executeGetCustomerNationalities(customerId);

        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(customerId, result.get().get(0).getCustomerId());
    }

    @Test
    public void executeGetCustomerNationalities_withInvalidCustomerId_returnsEmpty() {
        String customerId = "INVALID_ID";

        Optional<List<CustomerNationalityEntity>> result = kbtqR226.executeGetCustomerNationalities(customerId);

        Assert.assertFalse(result.isPresent());
    }

    @Test
    public void executeGetCustomerNationalities_withEmptyCustomerId_addsAdviceAndReturnsEmpty() {
        String customerId = "";

        Optional<List<CustomerNationalityEntity>> result = kbtqR226.executeGetCustomerNationalities(customerId);

        Assert.assertFalse(result.isPresent());
    }
}
