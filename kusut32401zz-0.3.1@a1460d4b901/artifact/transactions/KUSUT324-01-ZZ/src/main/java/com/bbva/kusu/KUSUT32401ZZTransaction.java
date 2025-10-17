package com.bbva.kusu;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.kusu.dto.constants.ConstantError;
import com.bbva.kusu.dto.users.beans.UserContract;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.lib.r325.KUSUR325;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Transaction that consults the alias/favorite of one or more contracts.
 *
 */
public class KUSUT32401ZZTransaction extends AbstractKUSUT32401ZZTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(KUSUT32401ZZTransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		LOGGER.info("START AliasFav Transaction");

		String userId = this.getUserid();
		String profileId = this.getProfileid();
		List<UserContract> contracts = this.getContracts();

		LOGGER.info("userId {}", userId);
		LOGGER.info("profileId {}", profileId);
		LOGGER.info("contractId {}", contracts);

		List<AliasFavContractEntity> aliasFavContractEntityList = generateAliasFavContractList(contracts);

		// Check mandatory parameters
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(profileId)) {
			LOGGER.info("Parameters userId or profileId were not reported");
			this.addAdvice(ConstantError.MANDATORY_PARAMETERES_NOT_FOUND);
			this.setSeverity(Severity.EWR);
			
		} else {
			// We call method executeGetAliasFavoriteContractsList
			KUSUR325 kusuR325 = this.getServiceLibrary(KUSUR325.class);
			List<AliasFavContractEntity> aliasFavContractEntity =  kusuR325.executeGetAliasFavoriteContractsList(userId, profileId, aliasFavContractEntityList);
			LOGGER.info("kusuR325.executeGetAliasFavoriteContractsList -> {}", aliasFavContractEntity);
			
			if (this.getAdvice() != null) {
				LOGGER.info("ERROR TRANSACTION KUSUT324 [ERROR CODE] -> {}", this.getAdvice().getCode());
				this.setSeverity(Severity.EWR);
				
			} else {
				List<UserContract> userContractList = generateUserContractList(aliasFavContractEntity);
				this.setContracts(userContractList);
				LOGGER.info("END AliasFav Transaction -> {}", userContractList);
			}
		}
	}

	/**
	 * Mapear entrada de la transaccion a entrada de la libreria
	 * @param contracts
	 * @return
	 */
	List<AliasFavContractEntity> generateAliasFavContractList(List<UserContract> contracts) {
		List<AliasFavContractEntity> aliasFavContractEntityList = new ArrayList<>();
		if (contracts != null) {
			contracts.forEach(contract -> {
				AliasFavContractEntity aliasFavContract = new AliasFavContractEntity();
				aliasFavContract.setGContractId(contract.getId());
				aliasFavContractEntityList.add(aliasFavContract);
			});
		}
		return aliasFavContractEntityList;
	}

	/**
	 * Mapear salida de la libreria a salida de la transaccion
	 * @param aliasFavContractEntity
	 * @return
	 */
	List<UserContract> generateUserContractList(List<AliasFavContractEntity> aliasFavContractEntity) {
		List<UserContract> contractList = new ArrayList<>();
		if (aliasFavContractEntity != null) {
			aliasFavContractEntity.forEach(aliasFavC -> {
				UserContract userContract = new UserContract();
				userContract.setId(aliasFavC.getGContractId());
				userContract.setAlias(aliasFavC.getGfContractAliasName());
				userContract.setIsFavorite(aliasFavC.getGPreferredContractId().intValue() > 0);
				
				LOGGER.info("User Contract Info -> {}", userContract);
				contractList.add(userContract);
			});
		}
		LOGGER.info("Contract List Info -> {}", contractList);
		return contractList;
	}

}
