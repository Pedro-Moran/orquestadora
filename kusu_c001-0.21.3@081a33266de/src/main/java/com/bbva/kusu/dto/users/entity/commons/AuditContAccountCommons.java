package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class AuditContAccountCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gContractId;

	private String gUserAccountId;

	private String gfUserAuditId;

	public String getGContractId() {
		return this.gContractId;
	}

	public void setGContractId(String gContractId) {
		this.gContractId = gContractId;
	}

	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGfUserAuditId() {
		return gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	@Override
	public String toString() {
		return "AuditContAccountCommons [gContractId=" + gContractId + ", gUserAccountId=" + gUserAccountId + ", gfUserAuditId=" + gfUserAuditId
				+ "]";
	}

}
