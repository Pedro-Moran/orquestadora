package com.bbva.kusu.lib.r408.impl;

import com.bbva.apx.exception.business.BusinessException;
import com.bbva.kusu.dto.constants.ConstantError;
import com.bbva.kusu.dto.users.beans.ContractsVisibleOperableArray;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfileEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KUSUR408Impl extends KUSUR408Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(KUSUR408Impl.class);

	private static final String YES = "Y";
	private static final String NO = "N";
	private static final String NON_OPERATIVE = "NON_OPERATIVE";

	@Override
	public ContractsVisibleOperableArray executeGetVisibleOperableContracts(String profileId) {

		ContractsVisibleOperableArray contractsVisibleOperableArrayOut = null;

		try {
			LOGGER.info("KUSUR408 - START ...");
			LOGGER.info("profileId {}", profileId);

			// Validar campos obligatorios de entrada
			checkMandatoryParameters(profileId);

			// traducir id perfil de local a global
			String globalUserAccountId = getGlobalUserAccountId(profileId);

			// comprobar perfil existe
			getCustUserProfileEntity(globalUserAccountId);
			errorControl();

			// recuperar contratos
			List<AliasFavContractEntity> aliasFavContractList = getAliasFavContracts(globalUserAccountId);

			// filtrar contratos
			aliasFavContractList = filterConts(NON_OPERATIVE, aliasFavContractList);

			// mapear formato salida
			contractsVisibleOperableArrayOut = getContractsResponse(aliasFavContractList);

		} catch (BusinessException e) {
			LOGGER.info("KUSUR408 - ERROR ... {}", e.getAdviceCode());
			if (this.getAdviceList().isEmpty()) {
				this.addAdvice(e.getAdviceCode());
			}
		}

		LOGGER.info("contractsVisibleOperableArrayOut {}", contractsVisibleOperableArrayOut);
		LOGGER.info("KUSUR408 - END ...");
		return contractsVisibleOperableArrayOut;

	}

	/**
	 * Filtrar los contratos por el modo de operatividad
	 */
	private List<AliasFavContractEntity> filterConts(String mode, List<AliasFavContractEntity> origConts) {
		List<AliasFavContractEntity> filteredConts = null;

		if (!CollectionUtils.isEmpty(origConts) && NON_OPERATIVE.equals(mode)) {
			filteredConts = origConts.stream().filter(c -> NO.equals(c.getgOperativeContractIndType()))
					.collect(Collectors.toList());
		}
		return filteredConts;
	}

	/**
	 * Mapea la respuesta de los contratos a un objeto ContractsVisibleOperableArray
	 */
	private ContractsVisibleOperableArray getContractsResponse(List<AliasFavContractEntity> aliasFavContractList) {

		ContractsVisibleOperableArray contractsVisibleOperableArray = null;

		if (null != aliasFavContractList && !aliasFavContractList.isEmpty()) {

			contractsVisibleOperableArray = new ContractsVisibleOperableArray();

			// flags para saber si hay contratos con/sin visibilidad/operables
			boolean isThereVisible = false;
			boolean isThereNoVisible = false;
			boolean isThereOperative = false;
			boolean isThereNoOperative = false;

			// listas provisionales con los contratos con/sin visibilidad/operables
			List<String> visible = new ArrayList<>();
			List<String> noVisible = new ArrayList<>();
			List<String> operative = new ArrayList<>();
			List<String> noOperative = new ArrayList<>();

			for (AliasFavContractEntity contract : aliasFavContractList) {
				// Si no tiene valor a es 'Y' se entiende que SI es visible
				if (StringUtils.isBlank(contract.getgVisibleContractIndType()) || YES.equals(contract.getgVisibleContractIndType())) {
					isThereVisible = true;
					visible.add(contract.getGContractId());
				} else {
					isThereNoVisible = true;
					noVisible.add(contract.getGContractId());
				}

				// Si no tiene valor a es 'Y' se entiende que SI es operativo
				if (StringUtils.isBlank(contract.getgOperativeContractIndType()) || YES.equals(contract.getgOperativeContractIndType())) {
					isThereOperative = true;
					operative.add(contract.getGContractId());
				} else {
					isThereNoOperative = true;
					noOperative.add(contract.getGContractId());
				}
			}
			
			LOGGER.info("checkVisibleContract # isThereVisible={} # visible={}", isThereVisible, visible);
			checkVisibleContract(contractsVisibleOperableArray, isThereVisible, visible);
			
			LOGGER.info("checkNoVisibleContract # isThereVisible={} # visible={}", isThereVisible, visible);
			checkNoVisibleContract(contractsVisibleOperableArray, isThereNoVisible, noVisible);
			
			LOGGER.info("checkOperativeContract # isThereVisible={} # visible={}", isThereVisible, visible);
			checkOperativeContract(contractsVisibleOperableArray, isThereOperative, operative);
			
			LOGGER.info("checkNoOperativeContract # isThereVisible={} # visible={}", isThereVisible, visible);
			checkNoOperativeContract(contractsVisibleOperableArray, isThereNoOperative, noOperative);
		}

		return contractsVisibleOperableArray;
	}

	/**
	 * Guardar el listado de contratos visible si existe alguno
	 */
	private void checkVisibleContract(ContractsVisibleOperableArray out, boolean isThereVisible, List<String> visible) {
		if (isThereVisible) {
			out.setVisibleContracts(visible.toArray(new String[visible.size()]));
		}
	}

	/**
	 * Guardar el listado de contratos no visible si existe alguno
	 */
	private void checkNoVisibleContract(ContractsVisibleOperableArray out, boolean isThereNoVisible, List<String> noVisible) {
		if (isThereNoVisible) {
			out.setNoVisibleContracts(noVisible.toArray(new String[noVisible.size()]));
		}
	}

	/**
	 * Guardar el listado de contratos operativos si existe alguno
	 */
	private void checkOperativeContract(ContractsVisibleOperableArray out, boolean isThereOperative, List<String> operative) {
		if (isThereOperative) {
			out.setOperableContracts(operative.toArray(new String[operative.size()]));
		}
	}

	/**
	 * Guardar el listado de contratos no operativos si existe alguno
	 */
	private void checkNoOperativeContract(ContractsVisibleOperableArray out, boolean isThereNoOperative, List<String> noOperative) {
		if (isThereNoOperative) {
			out.setNoOperableContracts(noOperative.toArray(new String[noOperative.size()]));
		}
	}

	/**
	 * Validar campos obligatorios
	 */
	public void checkMandatoryParameters(String profileId) {
		if (StringUtils.isBlank(profileId)) {
			throw new BusinessException(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND, false);
		}
	}

	/**
	 * Recuperar informacion del perfil de usuario
	 */
	private CustUserProfileEntity getCustUserProfileEntity(String globalUserAccountId) {
		CustUserProfileEntity custUserProfileEntity = kusuR106.executeReadCustUserProfile(globalUserAccountId);
		LOGGER.info("kusuR106.executeReadCustUserProfile {}", custUserProfileEntity);
		return custUserProfileEntity;
	}

	/**
	 * Recuperar informacion de los contratos del perfil de usuario
	 */
	private List<AliasFavContractEntity> getAliasFavContracts(String globalUserAccountId) {
		List<AliasFavContractEntity> aliasFavContractList = kusuR121.executeListAliasFavContract(globalUserAccountId);
		LOGGER.info("kusuR121.executeListAliasFavContract {}", aliasFavContractList);
		return aliasFavContractList;
	}

	/**
	 * Traducir id local del perfil a id global
	 */
	public String getGlobalUserAccountId(String localUserAccountId) {
		String globalUserAccountId = kusuR205.executeGetGlobalUserAccountId(localUserAccountId);
		LOGGER.info("kusuR205.executeGetGlobalUserAccountId = {}", globalUserAccountId);
		return globalUserAccountId;
	}

	/**
	 * Method for error control.
	 */
	private void errorControl() {
		if (getAdvice() != null) {
			String miError = getAdvice().getCode();
			LOGGER.info("errorControl() {}", miError);
			throw new BusinessException(miError, true);
		}
	}

}