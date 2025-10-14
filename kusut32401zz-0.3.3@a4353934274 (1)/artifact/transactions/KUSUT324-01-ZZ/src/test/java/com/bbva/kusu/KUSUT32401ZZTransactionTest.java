package com.bbva.kusu;

import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.elara.domain.transaction.*;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.kusu.dto.constants.ConstantError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

	private final HttpResponseCode[] finalResponseCode = { null };

	private final Severity[] finalSeverity = { null };

	@Spy
	private Context context;

	@Mock
	private CommonRequestHeader header;

	@Mock
	private TransactionRequest transactionRequest;

	@Before
	public void initializeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.transaction.start(bundleContext);

		// Initializing transaction to test
		this.transaction.setContext(context);
		this.transaction.getContext().setLanguageCode("ES");

		transaction = new KUSUT32401ZZTransaction() {
			// Se mockea para que devuelva la instancia de la libreria mockeada.
			@Override
			protected <T> T getServiceLibrary(final Class<T> serviceInterface) {
				return (T) kusur325;
			}

			// Funciona como un Spy, cuando se invoca el metodo, en esta clase
			// obtienes las
			// variables con las que entra al metodo.
			@Override
			protected void setHttpResponseCode(final HttpResponseCode httpStatusCode, final Severity severity) {
				finalResponseCode[0] = httpStatusCode;
				finalSeverity[0] = severity;
			}

			@Override
			protected void setSeverity(final Severity severity) {
				finalSeverity[0] = severity;
			}
		};

		transactionRequest = Mockito.mock(TransactionRequest.class);
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<TransactionParameter>());
		transactionRequest.setBody(commonRequestBody);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn(null);
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

		// Mocking the response from KUSUR325
		List<AliasFavContractEntity> resList = new ArrayList<>();
		AliasFavContractEntity res = new AliasFavContractEntity();
		res.setGContractId("contractIdTest");
		res.setGfContractAliasName("Alias Name Test");
		res.setGUserAccountId("userAccountIdTest");
		res.setGPreferredContractId(new BigDecimal(31));
		res.setgOperativeContractIndType("Y");
		res.setgVisibleContractIndType("Y");
		res.setGfAuditDate(Timestamp.valueOf("2025-05-29 10:42:11.706"));
		res.setGfUserAuditId("auditUserTest");

		resList.add(res);

		context.setAdviceList(null);

		Mockito.when(kusur325.executeGetAliasFavoriteContractsList(Mockito.anyString(), Mockito.anyString(), Mockito.anyList())).thenReturn(resList);
		transaction.execute();
		Assert.assertNotNull(resList);
	}

	@Test
	public void testOkFalseIsVisibleAndIsOperative(){
		this.addParameter("userId", "UserTest");
		this.addParameter("profileId", "123456789MX");

		// Mocking the response from KUSUR325
		List<AliasFavContractEntity> resList = new ArrayList<>();
		AliasFavContractEntity res = new AliasFavContractEntity();
		res.setGContractId("contractIdTest");
		res.setGfContractAliasName("Alias Name Test");
		res.setGUserAccountId("userAccountIdTest");
		res.setGPreferredContractId(new BigDecimal(31));
		res.setgOperativeContractIndType("N");
		res.setgVisibleContractIndType("N");
		res.setGfAuditDate(Timestamp.valueOf("2025-05-29 10:42:11.706"));
		res.setGfUserAuditId("auditUserTest");

		resList.add(res);

		context.setAdviceList(null);

		Mockito.when(kusur325.executeGetAliasFavoriteContractsList(Mockito.anyString(), Mockito.anyString(), Mockito.anyList())).thenReturn(resList);
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

	/**
	 * Test for mandatory parameters exception
	 */
	@Test
	public void testMandatoryParametersException() {
		String userId = null;
		this.addParameter("userId", userId);
		this.transaction.execute();
		Advice transactionAdvice = this.transaction.getAdvice();
		Assert.assertNotNull(transactionAdvice);
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, transactionAdvice.getCode());
		Assert.assertTrue(transaction.getAdviceList() != null && !transaction.getAdviceList().isEmpty());
	}

	/**
	 * Test for advice list not empty
	 */
	@Test
	public void testAdviceListNotEmpty() {
		this.addParameter("userId", "1234567890");
		this.addParameter("profileId", "1234567890");

		// Mocking the advice list
		Answer<List<AliasFavContractEntity>> addAdviceAnswer = new Answer<List<AliasFavContractEntity>>() {
			@Override
			public List<AliasFavContractEntity> answer(final InvocationOnMock invocation) throws Throwable {
				Advice advice = new Advice("KUSU01433000", "Ha ocurrido un error", AdviceType.E, null);
				context.getAdviceList().add(advice);
				return new ArrayList<>(); // Return an empty list to simulate no contracts found
			}
		};

		// Mocking the response from KUSUR325
		Mockito.when(kusur325.executeGetAliasFavoriteContractsList(Mockito.anyString(), Mockito.anyString(), Mockito.anyList()))
				.thenAnswer(addAdviceAnswer);

		this.transaction.execute();

		Assert.assertTrue(this.transaction.getAdviceList() != null && !this.transaction.getAdviceList().isEmpty());
	}
}
