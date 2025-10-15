package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class AapChannelManagementEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gAapChannelType;

	public String getgAapChannelType() {
		return gAapChannelType;
	}

	public void setgAapChannelType(String gAapChannelType) {
		this.gAapChannelType = gAapChannelType;
	}

	@Override
	public String toString() {
		return "AapChannelManagementEntity [gAapChannelType=" + gAapChannelType + ", gfUserAuditId=" + getGfUserAuditId() + ", gfAuditDate=" + getGfAuditDate()
				+ "]";
	}

}