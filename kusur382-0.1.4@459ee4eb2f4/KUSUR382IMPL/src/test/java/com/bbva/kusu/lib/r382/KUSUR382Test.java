package com.bbva.kusu.lib.r382;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.OtmaPgApxQP05RequestHeader;
import com.bbva.elara.utility.jdbc.connector.JdbcUtils;
import com.bbva.kbtq.dto.c101.entities.MultitaxGroup;
import com.bbva.kbtq.lib.r504.KBTQR504;
import com.bbva.kusu.dto.constants.ConstantError;
import com.bbva.kusu.dto.users.entity.ProfCustomMultitaxEntity;
import com.bbva.kusu.dto.users.entity.UserMgmtChannelMapEntity;
import com.bbva.kusu.lib.r183.KUSUR183;
import com.bbva.kusu.lib.r205.KUSUR205;
import com.bbva.kusu.lib.r216.KUSUR216;
import com.bbva.kusu.lib.r382.factory.JdbcUtilsFactory;
import com.bbva.kusu.lib.r382.impl.KUSUR382Impl;
import com.bbva.kusu.lib.rf82.KUSURF82;
import com.bbva.kusu.mock.MockBundleContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/KUSUR382-app.xml", "classpath:/META-INF/spring/KUSUR382-app-test.xml",
		"classpath:/META-INF/spring/KUSUR382-arc.xml", "classpath:/META-INF/spring/KUSUR382-arc-test.xml" })

public class KUSUR382Test {

	private static final String G_USER_ID = "G_USER_ID";
	private static final String GF_PERSONAL_ID = "GF_PERSONAL_ID";
	private static final String G_USER_ACCOUNT_ID = "G_USER_ACCOUNT_ID";
	private static final String G_PERSON_ROLE_TYPE = "G_PERSON_ROLE_TYPE";
	private static final String G_ROLE_PERSON_ID = "G_ROLE_PERSON_ID";
	private static final String G_CUSTOM_MULTITAX_IND_TYPE = "G_CUSTOM_MULTITAX_IND_TYPE";
	
	@Spy
	@InjectMocks
	private KUSUR382Impl kusuR382;

	@Resource(name = "jdbcUtilsFactory")
	private JdbcUtilsFactory factory;

	@Resource(name = "bundleContext")
	private MockBundleContext bundleContext;

	@Mock
	private KUSUR205 kusuR205;

	@Mock
	private KUSUR183 kusuR183;

	@Mock
	private KUSURF82 kusuRF82;

	@Mock
	private KUSUR216 kusuR216;

	@Mock
	private KBTQR504 kbtqR504;

	@Mock
	private ApplicationConfigurationService applicationConfigurationService;

	@Spy
	private Context context;

	@Mock
	JdbcUtils jdbcUtils;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		TransactionRequest transactionRequest = Mockito.mock(TransactionRequest.class);
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<TransactionParameter>());
		transactionRequest.setBody(commonRequestBody);
		context.setTransactionRequest(transactionRequest);
		ThreadContext.set(context);
		ThreadContext.get().getAdviceList().clear();
		libraryConfiguration();
		getObjectIntrospection();
		libraryHeaderConfiguration();
	}

	private void libraryConfiguration() {
		ThreadContext.get().getAdviceList().clear();
		kusuR382.setKusuR183(kusuR183);
		kusuR382.setKusuR205(kusuR205);
		kusuR382.setKusuR216(kusuR216);
		kusuR382.setKusuRF82(kusuRF82);
		kusuR382.setKbtqR504(kbtqR504);
		kusuR382.setApplicationConfigurationService(applicationConfigurationService);
	}

	private Object getObjectIntrospection() throws Exception {
		Object result = this.kusuR382;
		if (this.kusuR382 instanceof Advised) {
			Advised advised = (Advised) this.kusuR382;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}

	private void libraryHeaderConfiguration() {
		ThreadContext.get().getAdviceList().clear();
		OtmaPgApxQP05RequestHeader header = new OtmaPgApxQP05RequestHeader();
		header.setAap("12345678");
		context.getTransactionRequest().setHeader(header);
	}

	// ###################################################

	@Test
	public void mandatoryUserIdFieldTest() {
		List<String> out = kusuR382.executeGetUserAccountId(null, "rolePersonId");
		Assert.assertNotNull(out);
		Assert.assertTrue(out.isEmpty());
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void mandatoryRolePersonIdFieldTest() {
		List<String> out = kusuR382.executeGetUserAccountId("userId", null);
		Assert.assertNotNull(out);
		Assert.assertTrue(out.isEmpty());
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void contingenceOKTest() {
		List<String> legacyResponse = new ArrayList<>();
		legacyResponse.add("localId");
		Mockito.when(applicationConfigurationService.getProperty(Matchers.eq("kusu.contingencyActive"))).thenReturn("true");
		Mockito.when(kusuRF82.executeGetUserAccountId(Mockito.any(), Mockito.any())).thenReturn(legacyResponse);

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertEquals("localId", out.get(0));
		Assert.assertTrue(ThreadContext.get().getAdviceList().isEmpty());
	}

	@Test
	public void legacyDataNotFoundTest() {
		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertNotNull(out);
		Assert.assertTrue(out.isEmpty());
		Assert.assertEquals(ConstantError.PROFILE_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void legacyAAPMasterALPHATest() {
		Mockito.when(kusuR183.executeListUserMgmtChannelMap(Mockito.any())).thenReturn(kusuR183Dummy("Y"));

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertNotNull(out);
		Assert.assertTrue(out.isEmpty());
		Assert.assertEquals(ConstantError.PROFILE_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void legacyOKTest() {
		List<String> legacyResponse = new ArrayList<>();
		legacyResponse.add("localId");
		Mockito.when(kusuRF82.executeGetUserAccountId(Mockito.any(), Mockito.any())).thenReturn(legacyResponse);

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertEquals("localId", out.get(0));
		Assert.assertTrue(ThreadContext.get().getAdviceList().isEmpty());
	}

	@Test
	public void dataErrorTest() {
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readUser"), Mockito.anyMap())).thenReturn(userDummy());
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readProfile"), Mockito.anyMap())).thenReturn(null);

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertNotNull(out);
		Assert.assertTrue(out.isEmpty());
		Assert.assertEquals(ConstantError.PROFILE_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void customerProfileTest() {
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readUser"), Mockito.anyMap())).thenReturn(userDummy());
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readProfile"), Mockito.anyMap()))
				.thenReturn(profileDummy("CUSTOMER", "N", "rolePersonId"));
		Mockito.when(kusuR205.executeGetLocalUserAccountId(Mockito.anyString())).thenReturn("globalId");

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertEquals("globalId", out.get(0));
		Assert.assertTrue(ThreadContext.get().getAdviceList().isEmpty());
	}

	@Test
	public void customMultitaxProfileNotFoundTest() {
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readUser"), Mockito.anyMap())).thenReturn(userDummy());
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readProfile"), Mockito.anyMap()))
				.thenReturn(profileDummy("MULTITAX", "Y", "agrupador"));
		Mockito.when(kusuR216.executeGetProfCustomMultitax(Mockito.anyString(), Mockito.anyString())).thenReturn(null);

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertNotNull(out);
		Assert.assertTrue(out.isEmpty());
		Assert.assertEquals(ConstantError.PROFILE_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void customMultitaxProfileFoundTest() {
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readUser"), Mockito.anyMap())).thenReturn(userDummy());
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readProfile"), Mockito.anyMap()))
				.thenReturn(profileDummy("MULTITAX", "Y", "agrupador"));
		Mockito.when(kusuR216.executeGetProfCustomMultitax(Mockito.anyString(), Mockito.anyString())).thenReturn(kusuR216Dummy("rolePersonId"));
		Mockito.when(kusuR205.executeGetLocalUserAccountId(Mockito.anyString())).thenReturn("globalId");
		
		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertEquals("globalId", out.get(0));
		Assert.assertTrue(ThreadContext.get().getAdviceList().isEmpty());
	}

	@Test
	public void noCustomMultitaxProfileNotFoundKBTQTest() {
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readUser"), Mockito.anyMap())).thenReturn(userDummy());
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readProfile"), Mockito.anyMap()))
				.thenReturn(profileDummy("MULTITAX", "N", "agrupador"));
		Mockito.when(kbtqR504.executeListByMultitaxGroupId(Mockito.anyString())).thenReturn(null);

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertNotNull(out);
		Assert.assertTrue(out.isEmpty());
		Assert.assertEquals(ConstantError.PROFILE_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}

	@Test
	public void noCustomMultitaxProfileFoundKBTQTest() {
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readUser"), Mockito.anyMap())).thenReturn(userDummy());
		Mockito.when(jdbcUtils.queryForList(Matchers.eq("KUSU.readProfile"), Mockito.anyMap()))
				.thenReturn(profileDummy("MULTITAX", "N", "agrupador"));
		Mockito.when(kbtqR504.executeListByMultitaxGroupId(Mockito.anyString())).thenReturn(kbtqR504Dummy("rolePersonId"));
		Mockito.when(kusuR205.executeGetLocalUserAccountId(Mockito.anyString())).thenReturn("globalId");

		List<String> out = kusuR382.executeGetUserAccountId("userId", "rolePersonId");
		Assert.assertEquals("globalId", out.get(0));
		Assert.assertTrue(ThreadContext.get().getAdviceList().isEmpty());
	}

	// ###################################################

	private List<UserMgmtChannelMapEntity> kusuR183Dummy(String masterAlpha) {
		List<UserMgmtChannelMapEntity> out = new ArrayList<>();
		UserMgmtChannelMapEntity dto = new UserMgmtChannelMapEntity();
		dto.setgUserMgmtMasterIndType(masterAlpha);
		out.add(dto);
		return out;
	}

	private List<Map<String, Object>> userDummy() {
		List<Map<String, Object>> listOut = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put(G_USER_ID, "userId");
		map.put(GF_PERSONAL_ID, "doc");
		listOut.add(map);
		return listOut;
	}

	private List<Map<String, Object>> profileDummy(String personRoleType, String customMultitax, String rolePersonId) {
		List<Map<String, Object>> listOut = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put(G_USER_ACCOUNT_ID, "profileId");
		map.put(G_USER_ID, "userId");
		map.put(G_PERSON_ROLE_TYPE, personRoleType);
		map.put(G_ROLE_PERSON_ID, rolePersonId);
		map.put(G_CUSTOM_MULTITAX_IND_TYPE, customMultitax);
		listOut.add(map);
		return listOut;
	}

	private ProfCustomMultitaxEntity kusuR216Dummy(String rolePersonId) {
		ProfCustomMultitaxEntity dto = new ProfCustomMultitaxEntity();
		dto.setgCustomerId(rolePersonId);
		return dto;
	}

	private List<MultitaxGroup> kbtqR504Dummy(String rolePersonId) {
		List<MultitaxGroup> out = new ArrayList<>();
		MultitaxGroup dto = new MultitaxGroup();
		dto.setgCustomerId(rolePersonId);
		out.add(dto);
		return out;
	}

}
