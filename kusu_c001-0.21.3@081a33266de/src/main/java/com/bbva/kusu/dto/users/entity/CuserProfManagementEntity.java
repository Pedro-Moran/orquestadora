package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CUserCommons;

public class CuserProfManagementEntity extends CUserCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gRecordUpdateType;

	public String getGRecordUpdateType() {
		return this.gRecordUpdateType;
	}

	public void setGRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}
	
	@Override
	public String toString() {
		return "CuserProfManagementEntity [gRecordUpdateType=" + gRecordUpdateType + "toString()=" + super.toString() + "]";
	}
	


}
