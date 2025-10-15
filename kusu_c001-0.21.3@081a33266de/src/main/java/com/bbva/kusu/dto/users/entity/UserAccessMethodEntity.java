package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UserAccessMethodEntity extends AuditParamsCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gUserAccessMethodType;
	private String gUserAccessMethodName;

	public String getgUserAccessMethodType() {
		return this.gUserAccessMethodType;
	}

	public void setgUserAccessMethodType(String gUserAccessMethodType) {
		this.gUserAccessMethodType = gUserAccessMethodType;
	}

	public String getgUserAccessMethodName() {
		return this.gUserAccessMethodName;
	}

	public void setgUserAccessMethodName(String gUserAccessMethodName) {
		this.gUserAccessMethodName = gUserAccessMethodName;
	}

	@Override
	public String toString() {
		return "UserAccessMethodEntity [gUserAccessMethodType=" + gUserAccessMethodType + ", gUserAccessMethodName=" + gUserAccessMethodName
				+ ", super.toString()=" + super.toString() + "]";
	}
}
