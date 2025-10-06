package com.bbva.pinv;

import com.bbva.pinv.dto.research.SearchResearchFolioRequest;
import com.bbva.pinv.dto.research.Branch;
import com.bbva.pinv.dto.research.ResearchUser;
import com.bbva.pinv.dto.research.Status;
import com.bbva.pinv.dto.research.SearchResearchFolioResponse;
import com.bbva.pinv.lib.r001.PINVR001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * add transaction
 *
 */
public class PINVT00101PETransaction extends AbstractPINVT00101PETransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(PINVT00101PETransaction.class);
	private static final String PAGINATION_KEY_DEFAULT_VALUE = "0";
	private static final String PAGE_SIZE_DEFAULT_VALUE = "10";

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {

		LOGGER.info("Inicio de Trx PINVT001-01-PE");
		SearchResearchFolioRequest searchResearchFolioRequest = new SearchResearchFolioRequest();
		searchResearchFolioRequest.setOperationNumber(getOperationnumber());
		searchResearchFolioRequest.setOperationType(getOperationtype());
		ResearchUser researchUser = new ResearchUser();
		researchUser.setId(getResearchuserId());
		Status status = new Status();
		status.setId(getStatusId());
		searchResearchFolioRequest.setStartDate(getStartdate());
		searchResearchFolioRequest.setEndDate(getEnddate());
		Branch branch = new Branch();
		branch.setId(getBranchId());
		searchResearchFolioRequest.setPaginationKey(getPaginationkeyParam() != null ? getPaginationkeyParam() : PAGINATION_KEY_DEFAULT_VALUE);
		searchResearchFolioRequest.setPageSize(getPagesizeParam() != null ? getPagesizeParam() : PAGE_SIZE_DEFAULT_VALUE);

		PINVR001 pinvR001 = this.getServiceLibrary(PINVR001.class);

		SearchResearchFolioResponse response = pinvR001.executeSearchResearchFolio(searchResearchFolioRequest);
		mapResponse(response);
	}

	public void mapResponse(SearchResearchFolioResponse response) {
		LOGGER.info("PINVT001 mapResponse: {}", response);
			if (response != null && !response.getData().isEmpty() && response.getPagination() != null) {
			this.setData(response.getData());
			this.setPagination(response.getPagination());
		} else {
			this.setData(Collections.emptyList());
		}
		LOGGER.info("Fin de Trx PINVT001-01-PE");
		LOGGER.info("PINVT001 mapResponse: {}", this);
	}

}
