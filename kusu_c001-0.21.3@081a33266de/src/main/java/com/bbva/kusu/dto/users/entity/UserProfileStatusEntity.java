package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserStatusEntityCommons;

public class UserProfileStatusEntity extends UserStatusEntityCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserStatusType;

	private String gUserStatusName;

	public String getgUserStatusType() {
		return this.gUserStatusType;
	}

	public void setgUserStatusType(String gUserStatusType) {
		this.gUserStatusType = gUserStatusType;
	}

	public String getgUserStatusName() {
		return this.gUserStatusName;
	}

	public void setgUserStatusName(String gUserStatusName) {
		this.gUserStatusName = gUserStatusName;
	}

	@Override
	public String toString() {
		return "UserProfileStatusEntity [gUserStatusType=" + gUserStatusType + ", gUserStatusName=" + gUserStatusName + ", toString()="
				+ super.toString() + "]";
	}

}
