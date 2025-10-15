package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ExternalContractCommons;

public class ProfcstExtcontroleMgEntity extends ExternalContractCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gRecordUpdateType;

	public String getgRecordUpdateType() {
		return gRecordUpdateType;
	}

	public void setgRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	@Override
	public String toString() {
		return "ProfcstExtcontroleMg [gRecordUpdateType=" + gRecordUpdateType + ", toString()=" + super.toString() + "]";
	}

}
