package com.bbva.kusu.dto.users.entity;

import java.sql.Timestamp;

public class UserManagementAuditEntity {
	private String gUserAccountId;

	private String gUserMgmtOperationType;

	private String gUserId;

	private String gChangeStatusType;

	private String gfChangeUserId;

	private Timestamp gfUserChangeDate;

	private String gfUserAuditId;

	private Timestamp gfAuditDate;

	public String getgUserAccountId() {
		return this.gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgUserMgmtOperationType() {
		return this.gUserMgmtOperationType;
	}

	public void setgUserMgmtOperationType(String gUserMgmtOperationType) {
		this.gUserMgmtOperationType = gUserMgmtOperationType;
	}

	public String getgUserId() {
		return this.gUserId;
	}

	public void setgUserId(String gUserId) {
		this.gUserId = gUserId;
	}

	public String getgChangeStatusType() {
		return this.gChangeStatusType;
	}

	public void setgChangeStatusType(String gChangeStatusType) {
		this.gChangeStatusType = gChangeStatusType;
	}

	public String getGfUserAuditId() {
		return this.gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Timestamp getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getGfChangeUserId() {
		return this.gfChangeUserId;
	}

	public void setGfChangeUserId(String gfChangeUserId) {
		this.gfChangeUserId = gfChangeUserId;
	}

	public Timestamp getGfUserChangeDate() {
		return this.gfUserChangeDate;
	}

	public void setGfUserChangeDate(Timestamp gfUserChangeDate) {
		this.gfUserChangeDate = gfUserChangeDate;
	}

	@Override
	public String toString() {
		return "UserManagementAuditEntity [gUserAccountId=" + gUserAccountId + ", gUserMgmtOperationType=" + gUserMgmtOperationType + ", gUserId="
				+ gUserId + ", gChangeStatusType=" + gChangeStatusType + ", gfChangeUserId=" + gfChangeUserId + ", gfUserChangeDate="
				+ gfUserChangeDate + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + "]";
	}
}
