package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomCapEntityCommons;

public class UserCustomCapMgmtEntity extends UserCustomCapEntityCommons implements Serializable {
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
		return "UserCustomCapMgmtEntity [gRecordUpdateType=" + gRecordUpdateType + ", toString()=" + super.toString() + "]";
	}

}
