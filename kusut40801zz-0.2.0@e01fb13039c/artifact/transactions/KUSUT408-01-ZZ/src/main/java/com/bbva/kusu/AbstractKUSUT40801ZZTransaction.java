package com.bbva.kusu;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.kusu.dto.users.beans.ContractsVisibleOperableArray;

public abstract class AbstractKUSUT40801ZZTransaction extends AbstractTransaction {

	public AbstractKUSUT40801ZZTransaction() {
	}

	protected String getProfileId() {
		return (String) getParameter("profileId");
	}

	protected void setContractsVisibleOperableArray(final ContractsVisibleOperableArray contractsVisibleOperableArray) {
		this.addParameter("contractsVisibleOperableArray", contractsVisibleOperableArray);
	}

}
