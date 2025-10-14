package com.bbva.kusu;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.kusu.dto.users.beans.UserContract;
import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractKUSUT32401ZZTransaction extends AbstractTransaction {

	protected AbstractKUSUT32401ZZTransaction(){
	}


	/**
	 * Return value for input parameter userId
	 */
	protected String getUserid(){
		return (String)this.getParameter("userId");
	}

	/**
	 * Return value for input parameter profileId
	 */
	protected String getProfileid(){
		return (String)this.getParameter("profileId");
	}

	/**
	 * Return value for input parameter contracts
	 */
	protected List<UserContract> getContracts(){
		return (List<UserContract>)this.getParameter("contracts");
	}

	/**
	 * Set value for List<UserContract> output parameter contracts
	 */
	protected void setContracts(final List<UserContract> field){
		this.addParameter("contracts", field);
	}
}
