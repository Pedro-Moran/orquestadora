package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.UserDeviceCommons;

public class UserDeviceManagementEntity extends UserDeviceCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String recordUpdateTypeId;

	private String userAudit;

	private Timestamp auditDate;

	public String getRecordUpdateTypeId() {
		return this.recordUpdateTypeId;
	}

	public void setRecordUpdateTypeId(String recordUpdateTypeId) {
		this.recordUpdateTypeId = recordUpdateTypeId;
	}

	public String getUserAudit() {
		return this.userAudit;
	}

	public void setUserAudit(String userAudit) {
		this.userAudit = userAudit;
	}

	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	@Override
	public String toString() {
		return "UserDeviceManagementEntity [recordUpdateTypeId=" + recordUpdateTypeId + ", userAudit=" + userAudit + ", auditDate=" + auditDate
				+ ", toString()=" + super.toString() + "]";
	}

}
