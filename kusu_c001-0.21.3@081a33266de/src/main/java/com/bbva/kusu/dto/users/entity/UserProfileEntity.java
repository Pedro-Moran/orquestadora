package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UserProfileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gUserProfileId;

	private String gUserProfileName;

	private String gfUserAuditId;

	private Timestamp gfAuditDate;

	public String getGUserProfileId() {
		return this.gUserProfileId;
	}

	public void setGUserProfileId(String gUserProfileId) {
		this.gUserProfileId = gUserProfileId;
	}

	public String getGUserProfileName() {
		return this.gUserProfileName;
	}

	public void setGUserProfileName(String gUserProfileName) {
		this.gUserProfileName = gUserProfileName;
	}

	public String getGfUserAuditId() {
		return this.gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Date getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	@Override
	public String toString() {
		return "UserProfileEntity [gUserProfileId=" + gUserProfileId + ", gUserProfileName=" + gUserProfileName + ", gfUserAuditId=" + gfUserAuditId
				+ ", gfAuditDate=" + gfAuditDate + "]";
	}
}
