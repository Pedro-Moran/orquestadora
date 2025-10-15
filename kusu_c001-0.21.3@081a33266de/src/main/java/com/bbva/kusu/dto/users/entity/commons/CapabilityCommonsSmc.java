package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class CapabilityCommonsSmc extends CapabilityCommons implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String gfUserRoleId;

	private String gfSmcInternalId;

	private String gRoleMgmtIndType;

	private String gCapabilityMgmtIndType;

	private String gSmcMgmtIndType;
	
	private String gUserMgmtMasterIndType;

	public String getGfUserRoleId() {
		return this.gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getGfSmcInternalId() {
		return gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	public String getgRoleMgmtIndType() {
		return gRoleMgmtIndType;
	}

	public void setgRoleMgmtIndType(String gRoleMgmtIndType) {
		this.gRoleMgmtIndType = gRoleMgmtIndType;
	}

	public String getgCapabilityMgmtIndType() {
		return gCapabilityMgmtIndType;
	}

	public void setgCapabilityMgmtIndType(String gCapabilityMgmtIndType) {
		this.gCapabilityMgmtIndType = gCapabilityMgmtIndType;
	}

	public String getgSmcMgmtIndType() {
		return gSmcMgmtIndType;
	}

	public void setgSmcMgmtIndType(String gSmcMgmtIndType) {
		this.gSmcMgmtIndType = gSmcMgmtIndType;
	}

	public String getgUserMgmtMasterIndType() {
		return gUserMgmtMasterIndType;
	}

	public void setgUserMgmtMasterIndType(String gUserMgmtMasterIndType) {
		this.gUserMgmtMasterIndType = gUserMgmtMasterIndType;
	}

	@Override
	public String toString() {
		return "CapabilityCommonsSmc [gfUserRoleId=" + gfUserRoleId + ", gfSmcInternalId=" + gfSmcInternalId
				+ ", gRoleMgmtIndType=" + gRoleMgmtIndType + ", gCapabilityMgmtIndType=" + gCapabilityMgmtIndType
				+ ", gSmcMgmtIndType=" + gSmcMgmtIndType + ", gUserMgmtMasterIndType=" + gUserMgmtMasterIndType + "]";
	}
	
}
