package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SecurityAuthProfileEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String gSecurityAuthProfileType;
	private String gSecurityAuthProfileName;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;
	private String gInformedEmailIndType;
	private String gValidatedEmailIndType;
	private String gInformedPhoneIndType;
	private String gValidatedPhoneIndType;
	private String gDeviceTypeId;

	public String getgSecurityAuthProfileType() {
		return this.gSecurityAuthProfileType;
	}

	public void setgSecurityAuthProfileType(String gSecurityAuthProfileType) {
		this.gSecurityAuthProfileType = gSecurityAuthProfileType;
	}

	public String getgSecurityAuthProfileName() {
		return this.gSecurityAuthProfileName;
	}

	public void setgSecurityAuthProfileName(String gSecurityAuthProfileName) {
		this.gSecurityAuthProfileName = gSecurityAuthProfileName;
	}

	public String getGfUserAuditId() {
		return gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getgInformedEmailIndType() {
		return gInformedEmailIndType;
	}

	public void setgInformedEmailIndType(String gInformedEmailIndType) {
		this.gInformedEmailIndType = gInformedEmailIndType;
	}

	public String getgValidatedEmailIndType() {
		return gValidatedEmailIndType;
	}

	public void setgValidatedEmailIndType(String gValidatedEmailIndType) {
		this.gValidatedEmailIndType = gValidatedEmailIndType;
	}

	public String getgInformedPhoneIndType() {
		return gInformedPhoneIndType;
	}

	public void setgInformedPhoneIndType(String gInformedPhoneIndType) {
		this.gInformedPhoneIndType = gInformedPhoneIndType;
	}

	public String getgValidatedPhoneIndType() {
		return gValidatedPhoneIndType;
	}

	public void setgValidatedPhoneIndType(String gValidatedPhoneIndType) {
		this.gValidatedPhoneIndType = gValidatedPhoneIndType;
	}

	public String getgDeviceTypeId() {
		return gDeviceTypeId;
	}

	public void setgDeviceTypeId(String gDeviceTypeId) {
		this.gDeviceTypeId = gDeviceTypeId;
	}

	
	@Override
	public String toString() {
		return "SecurityAuthProfileEntity [gSecurityAuthProfileType=" + gSecurityAuthProfileType + ", gSecurityAuthProfileName="
				+ gSecurityAuthProfileName + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + ", gInformedEmailIndType="
				+ gInformedEmailIndType + ", gValidatedEmailIndType=" + gValidatedEmailIndType + ", gInformedPhoneIndType=" + gInformedPhoneIndType
				+ ", gValidatedPhoneIndType=" + gValidatedPhoneIndType + ", gDeviceTypeId=" + gDeviceTypeId + "]";
	}

}
