package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;

public class CategoryAndUserStatusCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfUserAuditId;

	private Timestamp gfAuditDate;

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

	@Override
	public String toString() {
		return "CategoryAndUserStatusCommons [gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + "]";
	}

}
