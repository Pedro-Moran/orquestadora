package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class CapabilityCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfUserCapabilityId;

	public String getGfUserCapabilityId() {
		return gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	@Override
	public String toString() {
		return "CapabilityCommons [super.toString()=" + super.toString() + ", gfUserCapabilityId=" + gfUserCapabilityId + "]";
	}

}
