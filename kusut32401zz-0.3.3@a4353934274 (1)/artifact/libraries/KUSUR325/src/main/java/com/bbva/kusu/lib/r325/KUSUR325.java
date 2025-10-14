package com.bbva.kusu.lib.r325;

import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;

import java.util.List;

/**
 * The  interface KUSUR325 class...
 */
public interface KUSUR325 {

	/**
	 * ALPHA FLOW -> Calls KUSUR106 to get the Customer User Profile and KUSUR205 to get the globalUserAccountId
	 * Finally calls to KUSUR121 to get the List of AliasFavContractEntity associated to globalUserAccountId
	 * HOST FLOW -> Call KUSUR342 to get the List of AliasFavContractEntity in Legacy
	 *
	 * @param userId userId
	 * @param profileId profileId
	 * @param contracts List of contract ids
	 * @return List<AliasFavContractEntity>
	 */
	List<AliasFavContractEntity> executeGetAliasFavoriteContractsList(String userId, String profileId, List<AliasFavContractEntity> contracts);

	/**
	 * Method to align to Spain that doesn't receive the userId parameter
	 * @param profileId profileId (gUserAccountId)
	 * @param contracts Unique identifier of a contract
	 * @return List<AliasFavContractEntity> List of contracts
	 */
	List<AliasFavContractEntity> executeGetAliasFavoriteContractsList(String profileId, List<AliasFavContractEntity> contracts);

}
