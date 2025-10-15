package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class SecurityAuthEntity extends AuditParamsCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gSecurityAuthenticationType;
	private String gSecurityAuthenticationName;

	public String getgSecurityAuthenticationType() {
		return this.gSecurityAuthenticationType;
	}

	public void setgSecurityAuthenticationType(String gSecurityAuthenticationType) {
		this.gSecurityAuthenticationType = gSecurityAuthenticationType;
	}

	public String getgSecurityAuthenticationName() {
		return this.gSecurityAuthenticationName;
	}

	public void setgSecurityAuthenticationName(String gSecurityAuthenticationName) {
		this.gSecurityAuthenticationName = gSecurityAuthenticationName;
	}

	@Override
	public String toString() {
		return "SecurityAuthEntity [super.toString()=" + super.toString() + ", gSecurityAuthenticationType=" + gSecurityAuthenticationType
				+ ", gSecurityAuthenticationName=" + gSecurityAuthenticationName + "]";
	}
}
