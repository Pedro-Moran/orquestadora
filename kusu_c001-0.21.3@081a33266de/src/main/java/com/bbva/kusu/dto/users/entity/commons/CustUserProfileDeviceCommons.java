package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustUserProfileDeviceCommons implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String uniqueDeviceId;

	private String uniqueUserAccountId;

	private String userAuditId;

	private Timestamp auditDate;

	private String gOfflineDeleteIndType;

	public String getUniqueDeviceId() {
		return this.uniqueDeviceId;
	}

	public void setUniqueDeviceId(String uniqueDeviceId) {
		this.uniqueDeviceId = uniqueDeviceId;
	}

	public String getUniqueUserAccountId() {
		return this.uniqueUserAccountId;
	}

	public void setUniqueUserAccountId(String uniqueUserAccountId) {
		this.uniqueUserAccountId = uniqueUserAccountId;
	}

	public String getUserAuditId() {
		return this.userAuditId;
	}

	public void setUserAuditId(String userAuditId) {
		this.userAuditId = userAuditId;
	}

	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "CustUserProfileDeviceCommons [uniqueDeviceId=" + uniqueDeviceId + ", uniqueUserAccountId=" + uniqueUserAccountId + ", userAuditId="
				+ userAuditId + ", auditDate=" + auditDate + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
