package com.bbva.kusu.lib.r325.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.apx.exception.business.BusinessException;
import com.bbva.kusu.dto.constants.ConstantError;
import com.bbva.kusu.dto.users.entity.UserMgmtChannelMapEntity;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfileEntity;
import com.bbva.kusu.dto.users.entity.ProfileUpdMgmtEntity;

/**
 * The KUSUR325Impl class...
 */
public class KUSUR325Impl extends KUSUR325Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(KUSUR325Impl.class);

	private static final String KUSU = "KUSU";
	private static final String YES = "Y";
	private static final String CONTRACT = "CONTRACT";

	/**
	 *
	 * @param gUserAccountId
	 *            Unique user account identifier
	 * @param contracts
	 *            Contracts list
	 * @return aliasFavContractList
	 */
	@Override
	public List<AliasFavContractEntity> executeGetAliasFavoriteContractsList(String gUserAccountId,
			List<AliasFavContractEntity> contracts) {
		LOGGER.info("START executeGetAliasFavoriteContractsList() without userId");
		List<AliasFavContractEntity> aliasFavContractList;
		aliasFavContractList = executeGetAliasFavoriteContractsList(gUserAccountId, gUserAccountId, contracts);
		return aliasFavContractList;
	}

	/**
	 *
	 * @param userId
	 *            Unique user identifier
	 * @param profileId
	 *            Unique profile identifier
	 * @param contracts
	 *            Contracts list
	 * @return res
	 */
	@Override
	public List<AliasFavContractEntity> executeGetAliasFavoriteContractsList(String userId, String profileId,
			List<AliasFavContractEntity> contracts) {
		LOGGER.info("START executeGetAliasFavoriteContractsList() with all params");
		List<AliasFavContractEntity> res = new ArrayList<>();

		try {
			LOGGER.info("-userId -> {}", userId);
			LOGGER.info("-profileId -> {}", profileId);
			LOGGER.info("-contracts -> {}", contracts);

			checkMandatory(userId, profileId, contracts);

			List<AliasFavContractEntity> contractsAux = removeDuplicates(contracts);
			LOGGER.info("-contractsAux -> {}", contractsAux);

			String globalUserAccountId = kusuR205.executeGetGlobalUserAccountId(profileId);
			LOGGER.info("-kusuR205.executeGetGlobalUserAccountId -> {}", globalUserAccountId);

			CustUserProfileEntity customerUserProfile = kusuR106.executeReadCustUserProfile(globalUserAccountId);
			LOGGER.info("-kusuR106.executeReadCustUserProfile -> {}", customerUserProfile);
			deleteKUSUAdvices(KUSU);

			List<AliasFavContractEntity> aliasFavContractsLEGACY = new ArrayList<>();

			// Get Alias and Favorite Contracts in ALPHA flow
			List<AliasFavContractEntity> aliasFavContractsALPHA = goToAlpha(globalUserAccountId, contractsAux);

			// If the profile or aap is not master alpha, then go to LEGACY
			if (customerUserProfile == null || checkUpdatedDefault(customerUserProfile)
					|| !YES.equals(customerUserProfile.getGUserMgmtMasterIndType()) || !isAapMasterAlpha()) {
				LOGGER.info("-LEGACY Flow");

				// Check if the profile is new
				boolean isNewProfile = customerUserProfile == null;
				LOGGER.info("-isNewProfile -> {}", isNewProfile);

				// Get Alias and Favorite Contracts in LEGACY flow
				aliasFavContractsLEGACY = goToLegacy(profileId, isNewProfile, contractsAux);
			}
			LOGGER.info("-aliasFavContractsLEGACY -> {}", aliasFavContractsLEGACY);

			// Merge ALPHA and LEGACY results
			mergeAliasFavContracts(aliasFavContractsALPHA, aliasFavContractsLEGACY, res);

			// Check if the response list is empty
			if (res.isEmpty()) {
				LOGGER.info("-Response list is empty !! -> {}", ConstantError.ALIAS_FAV_CONTRACT_NOT_FOUND);
				this.addAdvice(ConstantError.ALIAS_FAV_CONTRACT_NOT_FOUND);
			}

			return res;

		} catch (BusinessException error) {
			LOGGER.info("catch BusinessException !! {}", error.getAdviceCode());
			if (this.getAdviceList().isEmpty()) {
				this.addAdvice(error.getAdviceCode());
			}
		}

		LOGGER.info("END executeGetAliasFavoriteContractsList -> {}", res);
		return res;
	}

	/**
	 * Check if the AAP is Master Alpha
	 * 
	 * @return true if the AAP is Master Alpha
	 */
	private boolean isAapMasterAlpha() {
		boolean isMasterAlpha = false;

		UserMgmtChannelMapEntity in = new UserMgmtChannelMapEntity();
		in.setGfChannelId(getAAPCode());
		List<UserMgmtChannelMapEntity> userMgmtChannelMapList = kusuR183.executeListUserMgmtChannelMap(in);
		LOGGER.info("kusuR183.executeListUserMgmtChannelMap= {}", userMgmtChannelMapList);
		this.getAdviceList().clear();
		UserMgmtChannelMapEntity dto = null;
		if (!userMgmtChannelMapList.isEmpty()) {
			dto = userMgmtChannelMapList.get(0);
		}
		isMasterAlpha = (null != dto && YES.equalsIgnoreCase(dto.getgUserMgmtMasterIndType()));

		LOGGER.info("isAapMasterAlpha: {}", isMasterAlpha);

		return isMasterAlpha;
	}

	/**
	 * Get AAP code from request header
	 * 
	 * @return String AAP code
	 */
	private String getAAPCode() {
		Object headerAAP = this.getRequestHeader().getHeaderParameter(RequestHeaderParamsName.AAP);
		LOGGER.info("headerAap-> {}", headerAAP);
		return (headerAAP != null ? headerAAP.toString() : null);
	}

	/**
	 * Merge ALPHA and LEGACY results
	 *
	 * @param aliasFavContractsALPHA
	 *            ALPHA results
	 * @param aliasFavContractsLEGACY
	 *            LEGACY results
	 * @param res
	 *            Response list
	 */
	private void mergeAliasFavContracts(List<AliasFavContractEntity> aliasFavContractsALPHA,
			List<AliasFavContractEntity> aliasFavContractsLEGACY, List<AliasFavContractEntity> res) {
		// Add all LEGACY results
		res.addAll(aliasFavContractsLEGACY);

		// Get LEGACY contract ids
		Set<String> legacyContractIds = aliasFavContractsLEGACY.stream().map(AliasFavContractEntity::getGContractId)
				.collect(Collectors.toSet());

		// Remove LEGACY results from ALPHA results
		aliasFavContractsALPHA.removeIf(alphaContract -> legacyContractIds.contains(alphaContract.getGContractId()));

		// Add all ALPHA results
		res.addAll(aliasFavContractsALPHA);
		LOGGER.info("Merge ALPHA and LEGACY results-> {}", res);
	}

	/**
	 * Get Alias and Favorite Contracts in ALPHA flow
	 * 
	 * @param globalUserAccountId
	 *            Unique user account identifier
	 * @param contractsAux
	 *            Contracts list without duplicates
	 * @return res
	 */
	private List<AliasFavContractEntity> goToAlpha(String globalUserAccountId, List<AliasFavContractEntity> contractsAux) {

		LOGGER.info("ALPHA Flow");

		List<String> contractsIds = contractsAux.stream().map(AliasFavContractEntity::getGContractId).collect(Collectors.toList());

		List<AliasFavContractEntity> alphaAliasFavContracts = kusuR121.executeListAliasFavContract(globalUserAccountId, contractsIds);
		LOGGER.info("-kusuR121.executeListAliasFavContract-> {}", alphaAliasFavContracts);
		deleteKUSUAdvices(KUSU);

		return (null != alphaAliasFavContracts ? alphaAliasFavContracts : new ArrayList<>());
	}

	/**
	 * Check mandatory parameters
	 * 
	 * @param userId
	 *            Unique user identifier
	 * @param profileId
	 *            Unique profile identifier
	 * @param contracts
	 *            Contracts list
	 */
	private void checkMandatory(String userId, String profileId, List<AliasFavContractEntity> contracts) {
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(profileId) || null == contracts || contracts.isEmpty()) {
			LOGGER.info("Initial mandatory parameters are not informed !!");
			throw new BusinessException(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, true);
		}
	}

	/**
	 * Remove duplicate contracts
	 * 
	 * @param contractsIn
	 *            Contracts list
	 * @return contractsOut
	 */
	private List<AliasFavContractEntity> removeDuplicates(List<AliasFavContractEntity> contractsIn) {

		List<String> signMechanismsNoDuplicatesKeys = contractsIn.stream().map(AliasFavContractEntity::getGContractId)
				.distinct().collect(Collectors.toList());

		List<AliasFavContractEntity> contractsOut = new ArrayList<>();
		for (String contractId : signMechanismsNoDuplicatesKeys) {
			AliasFavContractEntity contract = new AliasFavContractEntity();
			contract.setGContractId(contractId);
			contractsOut.add(contract);
		}

		return contractsOut;
	}

	/**
	 * Get Alias and Favorite Contracts in LEGACY flow
	 * 
	 * @param gUserAccountId
	 *            Unique user account identifier
	 * @param contracts
	 *            Contracts list
	 * @return out
	 */
	private List<AliasFavContractEntity> goToLegacy(String gUserAccountId, boolean isNewProfile,
			List<AliasFavContractEntity> contracts) {
		deleteKUSUAdvices(KUSU);

		// The profile does not exist or was modified (Legacy Flow)
		List<AliasFavContractEntity> out = kusuRF25.executeGetAliasFavoriteContractsListHost(gUserAccountId,
				isNewProfile, contracts);
		LOGGER.info("-kusuRF25.executeGetAliasFavoriteContractsListHost -> {}", out);
		return out;
	}

	/**
	 * Check if the profile has been updated
	 *
	 * @param profileDataDefault
	 *            Profile data
	 * @return true if the profile has been updated
	 */
	private boolean checkUpdatedDefault(CustUserProfileEntity profileDataDefault) {
		if (YES.equalsIgnoreCase(profileDataDefault.getGUpdatedUsrProfileIndType())) {
			List<ProfileUpdMgmtEntity> updListDefault = kusuR232
					.executeListProfileUpdMgmt(profileDataDefault.getGUserAccountId(), null);
			LOGGER.info("-kusuR232.executeListProfileUpdMgmt {}", updListDefault);
			deleteKUSUAdvices(KUSU);

			return updListDefault.isEmpty()
					|| updListDefault.stream().anyMatch(u -> CONTRACT.equalsIgnoreCase(u.getgUserMgmtOperationType()));
		}
		return false;
	}

	/**
	 * Eliminar Advices generados desde KUSU, para respetar los que haya en
	 * sesion de otras UUAAs
	 */
	private void deleteKUSUAdvices(String uuaa) {
		this.getAdviceList().removeIf(x -> x.getCode().contains(uuaa));
	}

}