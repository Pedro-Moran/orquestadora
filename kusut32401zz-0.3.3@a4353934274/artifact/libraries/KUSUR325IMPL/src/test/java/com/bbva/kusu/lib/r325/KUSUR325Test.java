package com.bbva.kusu.lib.r325;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.OtmaPgApxQP05RequestHeader;
import com.bbva.kusu.dto.users.entity.UserMgmtChannelMapEntity;
import com.bbva.kusu.lib.r183.KUSUR183;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
import com.bbva.kusu.dto.constants.ConstantError;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfileEntity;
import com.bbva.kusu.dto.users.entity.ProfileUpdMgmtEntity;
import com.bbva.kusu.lib.r106.KUSUR106;
import com.bbva.kusu.lib.r121.KUSUR121;
import com.bbva.kusu.lib.r205.KUSUR205;
import com.bbva.kusu.lib.r232.KUSUR232;
import com.bbva.kusu.lib.r325.impl.KUSUR325Impl;
import com.bbva.kusu.lib.rf25.KUSURF25;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/KUSUR325-app.xml",
		"classpath:/META-INF/spring/KUSUR325-app-test.xml",
		"classpath:/META-INF/spring/KUSUR325-arc.xml",
		"classpath:/META-INF/spring/KUSUR325-arc-test.xml" })
public class KUSUR325Test {


	@InjectMocks
	private KUSUR325Impl kusuR325;

	@Mock
	private KUSUR106 kusuR106;

	@Mock
	private KUSUR121 kusuR121;

	@Mock
	private KUSUR205 kusuR205;
	
	@Mock
	private KUSUR232 kusuR232;

	@Mock
	private KUSURF25 kusuRF25;

	@Mock
	private KUSUR183 kusuR183;

	@Spy
	private Context context;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

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
	}

	private void libraryConfiguration() {
		ThreadContext.get().getAdviceList().clear();
		kusuR325.setKusuR106(kusuR106);
		kusuR325.setKusuR205(kusuR205);
		kusuR325.setKusuR232(kusuR232);
		kusuR325.setKusuR121(kusuR121);
		kusuR325.setKusuRF25(kusuRF25);


		// Mock headers
		OtmaPgApxQP05RequestHeader header = new OtmaPgApxQP05RequestHeader();
		header.setLanguageCode("ES");
		header.setUserCode("user");
		header.setAap("30000030");

		context.getTransactionRequest().setHeader(header);
	}

	private void setHeader() {
		OtmaPgApxQP05RequestHeader header = new OtmaPgApxQP05RequestHeader();
		header.setCurrencyCode("PEN");
		header.setUserCode("XE99173");
		header.setAap("00000208");
		header.setChannelCode("01");
		header.setCountryCode("PE");

		context.getTransactionRequest().setHeader(header);
		ThreadContext.get().getAdviceList().clear();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.kusuR325;
		if(this.kusuR325 instanceof Advised){
			Advised advised = (Advised) this.kusuR325;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}

	// #####################################
	
	@Test
	public void executeMandatoryUserIdTest() {
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList(null, "profileId", new ArrayList<>());
		Assert.assertNotNull(res);
		Assert.assertTrue(res.isEmpty());
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}
	
	@Test
	public void executeMandatoryProfileIdTest() {
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", null, new ArrayList<>());
		Assert.assertNotNull(res);
		Assert.assertTrue(res.isEmpty());
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}
	
	@Test
	public void executeMandatoryContractsListTest() {
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", null);
		Assert.assertNotNull(res);
		Assert.assertTrue(res.isEmpty());
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}
	
	@Test
	public void executeEmptyContractsListTest() {
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", new ArrayList<>());
		Assert.assertNotNull(res);
		Assert.assertTrue(res.isEmpty());
		Assert.assertEquals(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}
	
	@Test
	public void executeOKTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("N", "N"));
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.anyString(), Mockito.anyList())).thenReturn(aliasFavContractList());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(10, res.size());
	}
	
	
	@Test
	public void executeOK2Test() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("N", "N"));
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.anyString(), Mockito.anyList())).thenReturn(aliasFavContractList());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(10, res.size());
	}

	@Test
	public void executeAnyContractFoundTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("N", "N"));
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.anyString(), Mockito.anyList())).thenReturn(new ArrayList<>());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertTrue(res.isEmpty());
		Assert.assertEquals(ConstantError.ALIAS_FAV_CONTRACT_NOT_FOUND, ThreadContext.get().getAdviceList().getLast().getCode());
	}
	
	@Test
	public void executeUpdatedProfileTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("Y", "N"));
		Mockito.when(kusuR232.executeListProfileUpdMgmt(Mockito.any(), Mockito.any())).thenReturn(updListDefaultDummy("CONTRACT"));
		Mockito.when(kusuRF25.executeGetAliasFavoriteContractsListHost(Mockito.any(), Mockito.anyBoolean(), Mockito.any())).thenReturn(aliasFavContractList());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(10, res.size());
	}

	@Test
	public void executeUpdatedMasterAlphaProfileTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("Y", "Y"));
		Mockito.when(kusuR205.executeGetGlobalUserAccountId(Mockito.anyString())).thenReturn("globalUserAccountId");
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.anyString(), Mockito.anyList())).thenReturn(aliasFavContractList());
		Mockito.when(kusuR183.executeListUserMgmtChannelMap(Mockito.any())).thenReturn(channelListDummy("N"));
		Mockito.when(kusuRF25.executeGetAliasFavoriteContractsListHost(Mockito.any(), Mockito.anyBoolean(), Mockito.any())).thenReturn(aliasFavContractList());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(10, res.size());
	}

	@Test
	public void executeChannelMasterAlphaTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("Y", "Y"));
		Mockito.when(kusuR205.executeGetGlobalUserAccountId(Mockito.anyString())).thenReturn("globalUserAccountId");
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.anyString(), Mockito.anyList())).thenReturn(aliasFavContractList());
		Mockito.when(kusuR183.executeListUserMgmtChannelMap(Mockito.any())).thenReturn(channelListDummy("Y"));
		Mockito.when(kusuRF25.executeGetAliasFavoriteContractsListHost(Mockito.any(), Mockito.anyBoolean(), Mockito.any())).thenReturn(aliasFavContractList());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(10, res.size());
	}
	
	@Test
	public void executeProfileNotExistTest() {
		Mockito.when(kusuRF25.executeGetAliasFavoriteContractsListHost(Mockito.any(), Mockito.anyBoolean(), Mockito.any())).thenReturn(aliasFavContractList());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(10, res.size());
	}

	@Test
	public void executeAlphaAndLegacyMergeTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("N", "N"));
		Mockito.when(kusuR205.executeGetGlobalUserAccountId(Mockito.anyString())).thenReturn("globalUserAccountId");
		Mockito.when(kusuR121.executeListAliasFavContract(Mockito.anyString(), Mockito.anyList())).thenReturn(aliasFavContractListLegacy());
		Mockito.when(kusuRF25.executeGetAliasFavoriteContractsListHost(Mockito.any(), Mockito.anyBoolean(), Mockito.any())).thenReturn(aliasFavContractListLegacy());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(4, res.size());
	}

	@Test
	public void executeAlphaAndLegacyMergeEmptyTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("N", "N"));
		Mockito.when(kusuR205.executeGetGlobalUserAccountId(Mockito.anyString())).thenReturn("globalUserAccountId");
		Mockito.when(kusuRF25.executeGetAliasFavoriteContractsListHost(Mockito.anyString(), Mockito.anyBoolean(), Mockito.anyList())).thenReturn(new ArrayList<>());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(0, res.size());
	}

	@Test
	public void executeCheckUpdateProfileTest() {
		Mockito.when(kusuR106.executeReadCustUserProfile(Mockito.anyString())).thenReturn(custUserProfileEntityDummy("Y", "N"));
		Mockito.when(kusuR232.executeListProfileUpdMgmt(Mockito.any(), Mockito.any())).thenReturn(updListDefaultDummy("CONTRACT"));
		Mockito.when(kusuRF25.executeGetAliasFavoriteContractsListHost(Mockito.any(), Mockito.anyBoolean(),  Mockito.any())).thenReturn(aliasFavContractList());
		List<AliasFavContractEntity> res = kusuR325.executeGetAliasFavoriteContractsList("userId", "profileId", aliasFavContractList());
		Assert.assertNotNull(res);
		Assert.assertEquals(10, res.size());
	}
	
	// #####################################
	
	private List<AliasFavContractEntity> aliasFavContractList() {
		List<AliasFavContractEntity> out = new ArrayList<>();
		out.add(aliasFavContractEntityDummy("1"));
		out.add(aliasFavContractEntityDummy("2"));
		out.add(aliasFavContractEntityDummy("3"));
		out.add(aliasFavContractEntityDummy("4"));
		out.add(aliasFavContractEntityDummy("5"));
		out.add(aliasFavContractEntityDummy("6"));
		out.add(aliasFavContractEntityDummy("7"));
		out.add(aliasFavContractEntityDummy("8"));
		out.add(aliasFavContractEntityDummy("9"));
		out.add(aliasFavContractEntityDummy("10"));
		return out;
	}

	private List<UserMgmtChannelMapEntity> channelListDummy(String isMasterAlpha) {
		List<UserMgmtChannelMapEntity> out = new ArrayList<>();
		UserMgmtChannelMapEntity dto = new UserMgmtChannelMapEntity();
		dto.setGfChannelId("1");
		dto.setgAapChannelType("aapTypeTest");
		dto.setgUserMgmtMasterIndType(isMasterAlpha);
		out.add(dto);
		return out;
	}

	private List<AliasFavContractEntity> aliasFavContractListLegacy() {
		List<AliasFavContractEntity> out = new ArrayList<>();
		out.add(aliasFavContractEntityDummy("4"));
		out.add(aliasFavContractEntityDummy("5"));
		out.add(aliasFavContractEntityDummy("6"));
		out.add(aliasFavContractEntityDummy("7"));
		return out;
	}

	private CustUserProfileEntity custUserProfileEntityDummy(String updatedProfile, String mgmtMasterAlpha) {
		CustUserProfileEntity custUserProfileEntity = new CustUserProfileEntity();
		custUserProfileEntity.setGUserAccountId("qwertyuiopasdfghADMINF");
		custUserProfileEntity.setGUpdatedUsrProfileIndType(updatedProfile);
		custUserProfileEntity.setGUserMgmtMasterIndType(mgmtMasterAlpha);
		return custUserProfileEntity;
	}

	private AliasFavContractEntity aliasFavContractEntityDummy(String contractId) {
		AliasFavContractEntity aliasFavContractEntity = new AliasFavContractEntity();
		aliasFavContractEntity.setGContractId(contractId);
		return aliasFavContractEntity;
	}
	
	private List<ProfileUpdMgmtEntity> updListDefaultDummy(String operationType) {
		List<ProfileUpdMgmtEntity> updListDefault = new ArrayList<>();
		ProfileUpdMgmtEntity dto = new ProfileUpdMgmtEntity();
		dto.setgUserMgmtOperationType(operationType);
		updListDefault.add(dto);
		return updListDefault;
	}
	
}
