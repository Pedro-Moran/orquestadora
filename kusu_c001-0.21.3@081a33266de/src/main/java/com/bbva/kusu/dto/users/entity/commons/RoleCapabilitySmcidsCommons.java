package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class RoleCapabilitySmcidsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfUserRoleId;

	private String gfUserCapabilityId;

	private String gfSmcInternalId;

	public String getGfUserRoleId() {
		return this.gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getGfUserCapabilityId() {
		return this.gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	public String getGfSmcInternalId() {
		return this.gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	@Override
	public String toString() {
		return "RoleCapabilitySmcidsCommons [super.toString()=" + super.toString() + ", gfUserRoleId=" + gfUserRoleId + ", gfUserCapabilityId="
				+ gfUserCapabilityId + ", gfSmcInternalId=" + gfSmcInternalId + "]";
	}

}
