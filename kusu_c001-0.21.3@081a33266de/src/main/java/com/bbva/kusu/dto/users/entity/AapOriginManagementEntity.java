package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class AapOriginManagementEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gAapOriginType;

	public String getgAapOriginType() {
		return gAapOriginType;
	}

	public void setgAapOriginType(String gAapOriginType) {
		this.gAapOriginType = gAapOriginType;
	}

	@Override
	public String toString() {
		return "AapOriginManagementEntity [gAapOriginType=" + gAapOriginType + ", gfUserAuditId=" + getGfUserAuditId() + ", gfAuditDate=" + getGfAuditDate()
				+ "]";
	}

}