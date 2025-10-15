package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomSmcCommons;

public class UserCustomSmcEntityMgmt extends UserCustomSmcCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gRecordUpdateType;

	public String getgRecordUpdateType() {
		return this.gRecordUpdateType;
	}

	public void setgRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	@Override
	public String toString() {
		return "UserCustomSmcEntityMgmt [gRecordUpdateType=" + gRecordUpdateType + ", toString()=" + super.toString() + "]";
	}
}
