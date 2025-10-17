package com.bbva.kusu;

import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.test.osgi.DummyBundleContext;
import com.bbva.kusu.dto.users.beans.UserContract;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.lib.r325.KUSUR325;

/**
 * Test for transaction KUSUT32401ZZTransaction
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/elara-test.xml",
		"classpath:/META-INF/spring/KUSUT32401ZZTest.xml" })
public class KUSUT32401ZZTransactionTest {

	@Autowired
	private KUSUT32401ZZTransaction transaction;

	@Resource(name = "dummyBundleContext")
	private DummyBundleContext bundleContext;

	@Mock
	private KUSUR325 kusur325;

	@Spy
	private Context context;

	@Mock
	private CommonRequestHeader header;

	@Mock
	private TransactionRequest transactionRequest;

	@Before
	public void initializeClass() throws Exception {
		// Initializing mocks
		MockitoAnnotations.initMocks(this);
		// Start BundleContext
		this.transaction.start(bundleContext);
		// Setting Context
		this.transaction.setContext(new Context());
		// Set Body
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<>());
		this.transactionRequest.setBody(commonRequestBody);
		// Set Header Mock
		this.transactionRequest.setHeader(header);
		// Set TransactionRequest
		this.transaction.getContext().setTransactionRequest(transactionRequest);
	}

	@Test
	public void testNotNull(){
		Assert.assertNotNull(this.transaction);
		this.transaction.execute();
	}

	@Test
	public void testOK(){
		this.addParameter("userId", "UserTest");
		this.addParameter("profileId", "123456789MX");

		List<AliasFavContractEntity> contracts = new ArrayList<>();
		List<AliasFavContractEntity> resList = new ArrayList<>();
		AliasFavContractEntity res = new AliasFavContractEntity();
		res.setGContractId("A");
		res.setGfContractAliasName("B");
		res.setGUserAccountId("C");
		resList.add(res);

		context.setAdviceList(null);

		Mockito.when(kusur325.executeGetAliasFavoriteContractsList("", "", contracts)).thenReturn(resList);
		transaction.execute();
		Assert.assertNotNull(resList);
	}

	@Test
	public void testSetAliasFavContractList() {
		List<UserContract> contracts = new ArrayList<>();
		UserContract contract = new UserContract();
		contract.setId("123546");
		contracts.add(contract);

		addParameter("userId", "userIdTest");
		addParameter("profileId", "profileIdTest");
		addParameter("contractId", "contractIdTest");
		transaction.generateAliasFavContractList(contracts);
		assertNull(transaction.getAdvice());
	}

	@Test
	public void testSetUserContractList() {
		List<AliasFavContractEntity> aliasFavContractList = new ArrayList<>();
		AliasFavContractEntity aliasFavContract = new AliasFavContractEntity();
		aliasFavContract.setGContractId("123546");
		aliasFavContract.setGfContractAliasName("Alias Name Test");
		aliasFavContract.setGPreferredContractId(new BigDecimal(1));
		aliasFavContractList.add(aliasFavContract);

		addParameter("userId", "userIdTest");
		addParameter("profileId", "profileIdTest");
		addParameter("contractId", "contractIdTest");
		transaction.generateUserContractList(aliasFavContractList);
		assertNull(transaction.getAdvice());
	}

	@Test
	public void testSetUserContractIsFavFalse() {
		List<AliasFavContractEntity> aliasFavContractList = new ArrayList<>();
		AliasFavContractEntity aliasFavContract = new AliasFavContractEntity();
		aliasFavContract.setGContractId("123546");
		aliasFavContract.setGfContractAliasName("Alias Name Test");
		aliasFavContract.setGPreferredContractId(new BigDecimal(0));
		aliasFavContractList.add(aliasFavContract);

		addParameter("userId", "userIdTest");
		addParameter("profileId", "profileIdTest");
		addParameter("contractId", "contractIdTest");
		transaction.generateUserContractList(aliasFavContractList);
		assertNull(transaction.getAdvice());
	}

	@Test
	public void testSetUserContractAliasFavNull() {
		addParameter("userId", "userIdTest");
		addParameter("profileId", "profileIdTest");
		addParameter("contractId", "contractIdTest");

		transaction.generateUserContractList(null);
		assertNull(transaction.getAdvice());
	}



	@Test
	public void testOKUserIdEmpty() {
		List<AliasFavContractEntity> contracts = new ArrayList<>();

		this.addParameter("profileId", "1234567890");

		Mockito.when(kusur325.executeGetAliasFavoriteContractsList("", "", contracts)).thenReturn(null);
		this.transaction.execute();
		Assert.assertNull(kusur325.executeGetAliasFavoriteContractsList("", "", contracts));
	}

	@Test
	public void testOKProfileIdEmpty() {
		List<AliasFavContractEntity> contracts = new ArrayList<>();

		this.addParameter("userId", "1234567890");

		Mockito.when(kusur325.executeGetAliasFavoriteContractsList("", "", contracts)).thenReturn(null);
		this.transaction.execute();
		Assert.assertNull(kusur325.executeGetAliasFavoriteContractsList("", "", contracts));
	}

	// Add Parameter to Transaction
	private void addParameter(final String parameter, final Object value) {
		final TransactionParameter tParameter = new TransactionParameter(parameter, value);
		transaction.getContext().getParameterList().put(parameter, tParameter);
	}

	// Get Parameter from Transaction
	private Object getParameter(final String parameter) {
		final TransactionParameter param = transaction.getContext().getParameterList().get(parameter);
		return param != null ? param.getValue() : null;
	}
}
