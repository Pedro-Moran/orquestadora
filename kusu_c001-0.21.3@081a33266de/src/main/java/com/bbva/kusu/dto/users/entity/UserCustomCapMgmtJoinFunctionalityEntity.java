package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomCapCommons;

public class UserCustomCapMgmtJoinFunctionalityEntity extends UserCustomCapCommons implements Serializable {
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
		return "UserCustomCapMgmtJoinFunctionalityEntity [gRecordUpdateType=" + gRecordUpdateType + ", toString()=" + super.toString() + "]";
	}

}
