package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class AuthenticationSignParameterEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gSecurityAuthProfileType;
	private String gSecuriryMechanismType;
	private String gSecurityMechanismId;
	private String gDeviceType;
	private String gSecurityAuthenticationType;
	private String gValidationIndUpdType;
	private String gSecurMechanismSubtypeType;
	private String gUserProfAccessMethodType;
	private String gOfflineDeleteIndType;
	private String gSecurityMechanismSmpl1Id;
	private String gSecurityMechanismSmpl2Id;

	
	public String getgSecurityAuthProfileType() {
		return this.gSecurityAuthProfileType;
	}
	public void setgSecurityAuthProfileType(String gSecurityAuthProfileType) {
		this.gSecurityAuthProfileType = gSecurityAuthProfileType;
	}

	public String getgSecuriryMechanismType() {
		return this.gSecuriryMechanismType;
	}
	public void setgSecuriryMechanismType(String gSecuriryMechanismType) {
		this.gSecuriryMechanismType = gSecuriryMechanismType;
	}

	public String getgSecurityMechanismId() {
		return this.gSecurityMechanismId;
	}
	public void setgSecurityMechanismId(String gSecurityMechanismId) {
		this.gSecurityMechanismId = gSecurityMechanismId;
	}

	public String getgDeviceType() {
		return this.gDeviceType;
	}
	public void setgDeviceType(String gDeviceType) {
		this.gDeviceType = gDeviceType;
	}

	public String getgSecurityAuthenticationType() {
		return this.gSecurityAuthenticationType;
	}
	public void setgSecurityAuthenticationType(String gSecurityAuthenticationType) {
		this.gSecurityAuthenticationType = gSecurityAuthenticationType;
	}

	public String getgValidationIndUpdType() {
		return this.gValidationIndUpdType;
	}
	public void setgValidationIndUpdType(String gValidationIndUpdType) {
		this.gValidationIndUpdType = gValidationIndUpdType;
	}

	public String getgSecurMechanismSubtypeType() {
		return gSecurMechanismSubtypeType;
	}
	public void setgSecurMechanismSubtypeType(String gSecurMechanismSubtypeType) {
		this.gSecurMechanismSubtypeType = gSecurMechanismSubtypeType;
	}

	public String getgUserProfAccessMethodType() {
		return gUserProfAccessMethodType;
	}
	public void setgUserProfAccessMethodType(String gUserProfAccessMethodType) {
		this.gUserProfAccessMethodType = gUserProfAccessMethodType;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}
	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}


	public String getGSecurityMechanismSmpl1Id() {
		return gSecurityMechanismSmpl1Id;
	}
	public void setGSecurityMechanismSmpl1nd(String gSecurityMechanismSmpl1Id) {
		this.gSecurityMechanismSmpl1Id = gSecurityMechanismSmpl1Id;
	}

	public String getGSecurityMechanismSmpl2Id() {
		return gSecurityMechanismSmpl2Id;
	}
	public void setGSecurityMechanismSmpl2Id(String gSecurityMechanismSmpl2Id) {
		this.gSecurityMechanismSmpl2Id = gSecurityMechanismSmpl2Id;
	}

	@Override
	public String toString() {
		return "AuthenticationSignParameterEntity [super.toString()=" + super.toString() + ", gSecurityAuthProfileType=" + gSecurityAuthProfileType
				+ ", gSecuriryMechanismType=" + gSecuriryMechanismType + ", gSecurityMechanismId=" + gSecurityMechanismId + ", gDeviceType="
				+ gDeviceType + ", gSecurityAuthenticationType=" + gSecurityAuthenticationType + ", gValidationIndUpdType=" + gValidationIndUpdType
				+ ", gSecurMechanismSubtypeType=" + gSecurMechanismSubtypeType + ", gUserProfAccessMethodType=" + gUserProfAccessMethodType
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType
				+ ", gSecurityMechanismSmpl1Id=" + gSecurityMechanismSmpl1Id + ", gSecurityMechanismSmpl2Id=" + gSecurityMechanismSmpl2Id
		+ "]";
	}

}
