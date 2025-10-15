package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ExternalContractCommons;

public class ProfcstMltxextCtrMgEntity extends ExternalContractCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gCustomerId;
	private String gRecordUpdateType;

	public String getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	public String getgRecordUpdateType() {
		return gRecordUpdateType;
	}

	public void setgRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	@Override
	public String toString() {
		return "ProfcstMltxextCtrMgEntity [gCustomerId=" + gCustomerId + ", gRecordUpdateType=" + gRecordUpdateType + ", super.toString()="
				+ super.toString() + "]";
	}

}