package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

public class UserClientsPersonalization implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gCustomerId;
	private String gfUserAuditId;

	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	public String getGfUserAuditId() {
		return gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	@Override
	public String toString() {
		return "UserClientsPersonalization [gUserAccountId=" + gUserAccountId + ", gCustomerId=" + gCustomerId + ", gfUserAuditId=" + gfUserAuditId
				+ "]";
	}

}