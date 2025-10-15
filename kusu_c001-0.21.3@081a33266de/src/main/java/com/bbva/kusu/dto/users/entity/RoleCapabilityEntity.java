package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.Date;

public class RoleCapabilityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gfUserRoleId;

	private String gfUserRoleName;

	private String gfUserCapabilityId;

	private String gfUserCapabilityName;

	private String gRoleMgmtIndType;

	private String gCapabilityMgmtIndType;

	private String gfUserAuditId;

	private Date gfAuditDate;

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

	public String getgRoleMgmtIndType() {
		return this.gRoleMgmtIndType;
	}

	public void setgRoleMgmtIndType(String gRoleMgmtIndType) {
		this.gRoleMgmtIndType = gRoleMgmtIndType;
	}

	public String getgCapabilityMgmtIndType() {
		return this.gCapabilityMgmtIndType;
	}

	public void setgCapabilityMgmtIndType(String gCapabilityMgmtIndType) {
		this.gCapabilityMgmtIndType = gCapabilityMgmtIndType;
	}

	public String getGfUserAuditId() {
		return this.gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Date getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Date gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getGfUserRoleName() {
		return gfUserRoleName;
	}

	public void setGfUserRoleName(String gfUserRoleName) {
		this.gfUserRoleName = gfUserRoleName;
	}

	public String getGfUserCapabilityName() {
		return gfUserCapabilityName;
	}

	public void setGfUserCapabilityName(String gfUserCapabilityName) {
		this.gfUserCapabilityName = gfUserCapabilityName;
	}

	@Override
	public String toString() {
		return "RoleCapabilityEntity [gfUserRoleId=" + gfUserRoleId + ", gfUserRoleName=" + gfUserRoleName + ", gfUserCapabilityId="
				+ gfUserCapabilityId + ", gfUserCapabilityName=" + gfUserCapabilityName + ", gRoleMgmtIndType=" + gRoleMgmtIndType
				+ ", gCapabilityMgmtIndType=" + gCapabilityMgmtIndType + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + "]";
	}

}
