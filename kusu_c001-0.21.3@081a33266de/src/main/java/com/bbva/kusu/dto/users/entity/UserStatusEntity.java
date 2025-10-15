package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserStatusEntityCommons;

public class UserStatusEntity extends UserStatusEntityCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gUserStatusType;

	private String gUserStatusName;

	public String getGUserStatusType() {
		return this.gUserStatusType;
	}

	public void setGUserStatusType(String gUserStatusType) {
		this.gUserStatusType = gUserStatusType;
	}

	public String getGUserStatusName() {
		return this.gUserStatusName;
	}

	public void setGUserStatusName(String gUserStatusName) {
		this.gUserStatusName = gUserStatusName;
	}

	@Override
	public String toString() {
		return "UserStatusEntity [gUserStatusType=" + gUserStatusType + ", gUserStatusName=" + gUserStatusName + ", toString()=" + super.toString()
				+ "]";
	}

}
