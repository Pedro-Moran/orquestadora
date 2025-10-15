package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class SecurityMechanismEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gSecurityMechanismType;
	private String gSecurityMechanismName;

	public String getgSecurityMechanismType() {
		return this.gSecurityMechanismType;
	}

	public void setgSecurityMechanismType(String gSecurityMechanismType) {
		this.gSecurityMechanismType = gSecurityMechanismType;
	}

	public String getgSecurityMechanismName() {
		return this.gSecurityMechanismName;
	}

	public void setgSecurityMechanismName(String gSecurityMechanismName) {
		this.gSecurityMechanismName = gSecurityMechanismName;
	}

	@Override
	public String toString() {
		return "SecurityMechanismEntity [super.toString()=" + super.toString() + ", gSecurityMechanismType=" + gSecurityMechanismType
				+ ", gSecurityMechanismName=" + gSecurityMechanismName + "]";
	}

}
