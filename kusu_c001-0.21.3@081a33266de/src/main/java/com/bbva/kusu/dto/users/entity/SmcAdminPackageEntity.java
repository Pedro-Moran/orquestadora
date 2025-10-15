package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class SmcAdminPackageEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gfUserRoleId;
	private String gfUserCapabilityId;
	private String gfSmcInternalId;
	private String gfAdminSmcPackageId;

	public String getGfUserRoleId() {
		return gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getGfUserCapabilityId() {
		return gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	public String getGfSmcInternalId() {
		return gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	public String getGfAdminSmcPackageId() {
		return gfAdminSmcPackageId;
	}

	public void setGfAdminSmcPackageId(String gfAdminSmcPackageId) {
		this.gfAdminSmcPackageId = gfAdminSmcPackageId;
	}

	@Override
	public String toString() {
		return "SmcAdminPackageEntity [gfUserRoleId=" + gfUserRoleId + ", gfUserCapabilityId=" + gfUserCapabilityId + ", gfSmcInternalId=" + gfSmcInternalId
				+ ", gfAdminSmcPackageId=" + gfAdminSmcPackageId + ", super()=" + super.toString() + "]";
	}

}
