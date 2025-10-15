package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserNUserEntityCommons;

public class UserManagementEntity extends UserNUserEntityCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gCustomerId;

	private String gRecordUpdateType;

	public String getGRecordUpdateType() {
		return this.gRecordUpdateType;
	}

	public void setGRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	public String getGCustomerId() {
		return this.gCustomerId;
	}

	public void setGCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	@Override
	public String toString() {
		return "UserManagementEntity [gCustomerId=" + gCustomerId + ", gRecordUpdateType=" + gRecordUpdateType + ", toString()=" + super.toString()
				+ "]";
	}

}
