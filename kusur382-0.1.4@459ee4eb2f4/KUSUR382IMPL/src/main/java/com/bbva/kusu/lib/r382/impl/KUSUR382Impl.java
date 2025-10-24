package com.bbva.kusu.lib.r382.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.apx.exception.business.BusinessException;
import com.bbva.apx.exception.db.NoResultException;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.kbtq.dto.c101.entities.MultitaxGroup;
import com.bbva.kusu.dto.constants.ConstantError;
import com.bbva.kusu.dto.users.entity.CustUserProfileEntity;
import com.bbva.kusu.dto.users.entity.ProfCustomMultitaxEntity;
import com.bbva.kusu.dto.users.entity.UserEntity;
import com.bbva.kusu.dto.users.entity.UserMgmtChannelMapEntity;

public class KUSUR382Impl extends KUSUR382Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(KUSUR382Impl.class);

	private static final String CONTINGENCY = "kusu.contingencyActive";
	private static final String COUNTRY_CODE = "kusu.countryCode";
	private static final String KUSU_READ_USER = "KUSU.readUser";
	private static final String KUSU_READ_PROFILE = "KUSU.readProfile";

	private static final String YES = "Y";
	private static final String MULTITAX = "MULTITAX";
	private static final String G_USER_ID = "G_USER_ID";
	private static final String GF_PERSONAL_ID = "GF_PERSONAL_ID";
	private static final String G_USER_ACCOUNT_ID = "G_USER_ACCOUNT_ID";
	private static final String G_PERSON_ROLE_TYPE = "G_PERSON_ROLE_TYPE";
	private static final String G_ROLE_PERSON_ID = "G_ROLE_PERSON_ID";
	private static final String G_CUSTOM_MULTITAX_IND_TYPE = "G_CUSTOM_MULTITAX_IND_TYPE";

	@Override
	public List<String> executeGetUserAccountId(String identityDocumentId, String rolePersonId) {
		List<String> profileIdList = new ArrayList<>();

		try {
			LOGGER.info("KUSUR382Impl - START ...");
			LOGGER.info("identityDocumentId : {}", identityDocumentId);
			LOGGER.info("rolePersonId : {}", rolePersonId);

			validateParams(identityDocumentId, rolePersonId);

			boolean isContingencyActive = Boolean.parseBoolean(this.applicationConfigurationService.getProperty(CONTINGENCY));
			LOGGER.info("isContingencyActive : {}", isContingencyActive);
			if (isContingencyActive) {
				profileIdList = goToLegacy(identityDocumentId, rolePersonId);

			} else {
				// 1. Recuperar los usuarios que tienen el documento de entrada
				List<UserEntity> usersList = readUser(identityDocumentId);

				if (usersList.isEmpty()) {
					// recuperar el profileId local de legacy
					profileIdList = legacyFlow(identityDocumentId, rolePersonId);

				} else {
					// 2. Recuperar los perfiles ligados al usuario
					List<CustUserProfileEntity> profilesList = readCustUserProfiles(usersList);

					if (profilesList.isEmpty()) {
						profileIdList = legacyFlow(identityDocumentId, rolePersonId);
					}

					// 3. Filtrar los perfiles que tienen acceso al rolePersonId (sean CUSTOMER o MULTITAX)
					profileIdList = filterByRolePersonId(profilesList, rolePersonId);

					// 4. traducir el id global al local
					profileIdList = translateLocalUserAccountId(profileIdList);
				}
			}
		} catch (BusinessException e) {
			if (this.getAdviceList().isEmpty()) {
				this.addAdvice(e.getAdviceCode());
			}
		}
		LOGGER.info("KUSUR382Impl - END ... {}", profileIdList);
		return profileIdList;
	}
	
	/**
	 * Validar campos obligatorios
	 * 
	 * @param documentId
	 * @param rolePersonId
	 * @return
	 */
	private void validateParams(String documentId, String rolePersonId) {
		if (StringUtils.isBlank(documentId) || StringUtils.isBlank(rolePersonId)) {
			this.getAdviceList().clear();
			throw new BusinessException(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, false);
		}
	}

	/**
	 * Validar si el perfil tiene acceso al rolePersonId de entrada
	 * 
	 * @param profilesList
	 * @param multitaxId
	 */
	private List<String> filterByRolePersonId(List<CustUserProfileEntity> profilesList, String rolePersonId) {

		List<String> profilesListAux = new ArrayList<>();

		for (CustUserProfileEntity custUserProfile : profilesList) {
			String userAccountIdAux = null;

			if (MULTITAX.equals(custUserProfile.getGPersonRoleType())) {
				userAccountIdAux = checkMultitax(custUserProfile, rolePersonId);

			} else {
				if (custUserProfile.getGRolePersonId().equals(rolePersonId)) {
					// el perfil tiene como rolePersonId el que viene de entrada
					LOGGER.info("The profile '{}' has the field rolePersonId '{}' as his main customer !!", custUserProfile.getGUserAccountId(),
							rolePersonId);
					userAccountIdAux = custUserProfile.getGUserAccountId();
				}
			}

			if (StringUtils.isNotBlank(userAccountIdAux)) {
				profilesListAux.add(custUserProfile.getGUserAccountId());
			}
		}

		if (profilesListAux.isEmpty()) {
			// no tengo ningun perfil de usuario que tenga el documento de entrada y con relacion al rolePersonId de forma simultanea
			LOGGER.info("There is not any profile with access to the rolePersonId '{}' !!", rolePersonId);
			throw new BusinessException(ConstantError.PROFILE_NOT_FOUND, true);
		}

		return profilesListAux;
	}

	/**
	 * Validar si el perfil multitax tiene acceso al rolePersonId de entrada
	 * 
	 * @param custUserProfile
	 * @param rolePersonId
	 * @return
	 */
	private String checkMultitax(CustUserProfileEntity custUserProfile, String rolePersonId) {

		if (YES.equalsIgnoreCase(custUserProfile.getgCustomMultitaxIndType())) {
			// comprobar si el perfil tiene personalizado el multitax hijo de entrada
			ProfCustomMultitaxEntity profCustomMultitax = kusuR216.executeGetProfCustomMultitax(custUserProfile.getGUserAccountId(), rolePersonId);
			LOGGER.info("kusuR216.executeGetProfCustomMultitax {}", profCustomMultitax);
			this.getAdviceList().clear();

			if (null != profCustomMultitax) {
				LOGGER.info("The multitax profile '{}' has customized the multitaxId '{}' !!", custUserProfile.getGUserAccountId(), rolePersonId);
				return custUserProfile.getGUserAccountId();
			}

		} else {
			// comprobar si el perfil tiene acceso al multitax hijo de entrada en KBTQ
			// para ello buscamos los hijos del rolePersonId que tiene el perfil, entre los cuales debe estar el rolePersonId de entrada
			List<MultitaxGroup> multitaxGroups = kbtqR504.executeListByMultitaxGroupId(custUserProfile.getGRolePersonId());
			LOGGER.info("kbtqR504.executeListByMultitaxGroupId : {}", multitaxGroups);
			this.getAdviceList().clear();

			if (null != multitaxGroups
					&& !multitaxGroups.stream().filter(mtx -> mtx.getgCustomerId().contains(rolePersonId)).collect(Collectors.toList()).isEmpty()) {
				LOGGER.info("The multitax profile '{}' has access in KBTQ to the multitaxId '{}' !!", custUserProfile.getGUserAccountId(),
						rolePersonId);
				return custUserProfile.getGUserAccountId();
			}
		}

		LOGGER.info("The multitax profile '{}' has not any customer with the multitaxId '{}' !!", custUserProfile.getGUserAccountId(), rolePersonId);
		return null;
	}

	/**
	 * Comprobar si se puede ir a convivencia en funciona del AAP. Si esta no tiene convivencia no se va, evitando
	 * transaccionalidad innecesaria
	 *
	 * @param userAccountId
	 * @return
	 */
	private List<String> legacyFlow(String documentId, String rolePersonId) {
		List<String> profileIdList = null;

		// consultar si la AAP utilizada es master-alpha. En caso de no serlo se iria a
		// convivencia a consultar
		UserMgmtChannelMapEntity userMgmtChannelMap = null;
		userMgmtChannelMap = new UserMgmtChannelMapEntity();
		userMgmtChannelMap.setGCountryId(applicationConfigurationService.getProperty(COUNTRY_CODE));
		userMgmtChannelMap.setGfChannelId(getHeaderAap());
		List<UserMgmtChannelMapEntity> userMgmtChannelMapList = kusuR183.executeListUserMgmtChannelMap(userMgmtChannelMap);
		LOGGER.info("kusuR183.executeListUserMgmtChannelMap : {}", userMgmtChannelMapList);
		this.getAdviceList().clear();
		this.getAdviceList().clear();

		UserMgmtChannelMapEntity dto = null;
		if (!userMgmtChannelMapList.isEmpty()) {
			dto = userMgmtChannelMapList.get(0);
		}

		boolean canGoToLegacy = (null == dto || !YES.equalsIgnoreCase(dto.getgUserMgmtMasterIndType()));
		LOGGER.info("canGoToLegacy : {}", canGoToLegacy);

		if (canGoToLegacy) {
			profileIdList = goToLegacy(documentId, rolePersonId);
			if (null == profileIdList || profileIdList.isEmpty()) {
				this.getAdviceList().clear();
				throw new BusinessException(ConstantError.PROFILE_NOT_FOUND, false);
			}

		} else {
			this.getAdviceList().clear();
			throw new BusinessException(ConstantError.PROFILE_NOT_FOUND, false);
		}
		return profileIdList;
	}

	/**
	 * 
	 * @param documentId
	 * @param rolePersonId
	 * @return
	 */
	private List<String> goToLegacy(String documentId, String rolePersonId) {
		List<String> profileIdList = kusuRF82.executeGetUserAccountId(documentId, rolePersonId);
		LOGGER.info("kusuRF82.executeGetUserAccountId : {}", profileIdList);
		errorControl();
		return profileIdList;
	}

	/**
	 * Query para obtener los perfiles de los usuarios mediante el userId
	 * 
	 * @param userId
	 * @param rolePersonId
	 * @return
	 */
	private List<CustUserProfileEntity> readCustUserProfiles(List<UserEntity> usersList) {
		List<String> userIds = usersList.stream().map(UserEntity::getGUserId).collect(Collectors.toList());

		Map<String, Object> key = new HashMap<>();
		key.put(G_USER_ID, userIds);

		List<Map<String, Object>> mapOut = this.jdbcUtils.queryForList(KUSU_READ_PROFILE, key);
		LOGGER.info("KUSU.readProfile : {}", mapOut);
		return fromMapCustUserProfileData(mapOut);
	}

	/**
	 * Query para obtener el userId mediante el documento de identidad
	 * 
	 * @param documentId
	 * @return
	 */
	private List<UserEntity> readUser(String documentId) {
		try {
			Map<String, Object> key = new HashMap<>();
			key.put(GF_PERSONAL_ID, documentId);

			List<Map<String, Object>> mapList = this.jdbcUtils.queryForList(KUSU_READ_USER, key);
			LOGGER.info("KUSU.readUser : {}", mapList);
			return fromMapUserDataList(mapList);
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	/**
	 * 
	 * @param mapOut
	 * @return
	 */
	private List<UserEntity> fromMapUserDataList(List<Map<String, Object>> mapListIn) {
		List<UserEntity> outList = new ArrayList<>();
		if (null != mapListIn && !mapListIn.isEmpty()) {
			for (Map<String, Object> map : mapListIn) {
				UserEntity userEntity = new UserEntity();
				userEntity.setGUserId((String) map.get(G_USER_ID));
				userEntity.setGfPersonalId((String) map.get(GF_PERSONAL_ID));
				outList.add(userEntity);
			}
		}
		return outList;
	}

	/**
	 * 
	 * @param mapOut
	 * @return
	 */
	private List<CustUserProfileEntity> fromMapCustUserProfileData(List<Map<String, Object>> mapOut) {
		List<CustUserProfileEntity> listOut = new ArrayList<>();
		if (null != mapOut && !mapOut.isEmpty()) {
			for (Map<String, Object> map : mapOut) {
				CustUserProfileEntity dto = new CustUserProfileEntity();
				dto.setGUserAccountId((String) map.get(G_USER_ACCOUNT_ID));
				dto.setGUserId((String) map.get(G_USER_ID));
				dto.setGPersonRoleType((String) map.get(G_PERSON_ROLE_TYPE));
				dto.setGRolePersonId((String) map.get(G_ROLE_PERSON_ID));
				dto.setgCustomMultitaxIndType((String) map.get(G_CUSTOM_MULTITAX_IND_TYPE));
				listOut.add(dto);
			}
		}
		return listOut;
	}


	/**
	 * 
	 * @param profileIdList
	 * @return
	 */
	private List<String> translateLocalUserAccountId(List<String> profileIdList) {
		List<String> outList = new ArrayList<>();
		for (String profId : profileIdList) {
			outList.add(kusuR205.executeGetLocalUserAccountId(profId));
		}
		return outList;
	}
	
	/**
	 * Method for error control.
	 */
	private void errorControl() {
		if (getAdvice() != null) {
			String miError = getAdvice().getCode();
			throw new BusinessException(miError, false);
		}
	}

	/**
	 * Obtenemos la cabecera del aap
	 */
	private String getHeaderAap() {
		Object headerAap = this.getRequestHeader().getHeaderParameter(RequestHeaderParamsName.AAP);
		LOGGER.info("getHeaderAap() :: headerAap {}", headerAap);
		return headerAap != null ? headerAap.toString() : null;
	}
}