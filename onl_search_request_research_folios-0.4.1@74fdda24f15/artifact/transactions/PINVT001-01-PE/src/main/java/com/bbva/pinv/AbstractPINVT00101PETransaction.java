package com.bbva.pinv;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.pinv.dto.research.Pagination;
import com.bbva.pinv.dto.research.SearchResearchFolioResponseData;
import java.util.Date;
import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractPINVT00101PETransaction extends AbstractTransaction {

	protected AbstractPINVT00101PETransaction(){
	}


	/**
	 * Return value for input parameter operationNumber
	 */
	protected String getOperationnumber(){
		return (String)this.getParameter("operationNumber");
	}

	/**
	 * Return value for input parameter operationType
	 */
	protected String getOperationtype(){
		return (String)this.getParameter("operationType");
	}

	/**
	 * Return value for input parameter researchUser.id
	 */
	protected String getResearchuserId(){
		return (String)this.getParameter("researchUser.id");
	}

	/**
	 * Return value for input parameter startDate
	 */
	protected Date getStartdate(){
		return (Date)this.getParameter("startDate");
	}

	/**
	 * Return value for input parameter endDate
	 */
	protected Date getEnddate(){
		return (Date)this.getParameter("endDate");
	}

	/**
	 * Return value for input parameter branch.id
	 */
	protected String getBranchId(){
		return (String)this.getParameter("branch.id");
	}

	/**
	 * Return value for input parameter paginationKey
	 */
	protected String getPaginationkeyParam(){
		return (String)this.getParameter("paginationKey");
	}

	/**
	 * Return value for input parameter pageSize
	 */
	protected String getPagesizeParam(){
		return (String)this.getParameter("pageSize");
	}

	/**
	 * Return value for input parameter status.id
	 */
	protected String getStatusId(){
		return (String)this.getParameter("status.id");
	}

	/**
	 * Set value for List<SearchResearchFolioResponseData> output parameter data
	 */
	protected void setData(final List<SearchResearchFolioResponseData> field){
		this.addParameter("data", field);
	}

	/**
	 * Set value for Pagination output parameter pagination
	 */
	protected void setPagination(final Pagination field){
		this.addParameter("pagination", field);
	}
}
