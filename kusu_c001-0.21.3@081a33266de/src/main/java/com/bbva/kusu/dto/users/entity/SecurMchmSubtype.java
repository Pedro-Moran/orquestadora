package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SecurMchmSubtype implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gSecurMechanismSubtypeType;
	private String gSecurMechanismSubtypeName;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;

	public String getgSecurMechanismSubtypeType() {
		return gSecurMechanismSubtypeType;
	}

	public void setgSecurMechanismSubtypeType(String gSecurMechanismSubtypeType) {
		this.gSecurMechanismSubtypeType = gSecurMechanismSubtypeType;
	}

	public String getgSecurMechanismSubtypeName() {
		return gSecurMechanismSubtypeName;
	}

	public void setgSecurMechanismSubtypeName(String gSecurMechanismSubtypeName) {
		this.gSecurMechanismSubtypeName = gSecurMechanismSubtypeName;
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

	@Override
	public String toString() {
		return "SecurMchmSubtype [gSecurMechanismSubtypeType=" + gSecurMechanismSubtypeType + ", gSecurMechanismSubtypeName="
				+ gSecurMechanismSubtypeName + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + "]";
	}

}
