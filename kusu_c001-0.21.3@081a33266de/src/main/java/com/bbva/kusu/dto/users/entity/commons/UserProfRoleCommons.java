package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UserProfRoleCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfUserRoleId;

	private String gUserAccountId;

	private Date gfUserRoleStartDate;

	private String gfUserAuditId;

	private Timestamp gfAuditDate;

	private String gfUserRoleName;

	private String gfUserCapabilityId;

	private String gfUserCapabilityName;
	
	private String gOfflineDeleteIndType;

	public String getGfUserRoleId() {
		return this.gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public Date getGfUserRoleStartDate() {
		return this.gfUserRoleStartDate;
	}

	public void setGfUserRoleStartDate(Date gfUserRoleStartDate) {
		this.gfUserRoleStartDate = gfUserRoleStartDate;
	}

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

	public String getGfUserRoleName() {
		return this.gfUserRoleName;
	}

	public void setGfUserRoleName(String gfUserRoleName) {
		this.gfUserRoleName = gfUserRoleName;
	}

	public String getGfUserCapabilityId() {
		return this.gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	public String getGfUserCapabilityName() {
		return this.gfUserCapabilityName;
	}

	public void setGfUserCapabilityName(String gfUserCapabilityName) {
		this.gfUserCapabilityName = gfUserCapabilityName;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "UserProfRoleCommons [gfUserRoleId=" + gfUserRoleId + ", gUserAccountId=" + gUserAccountId + ", gfUserRoleStartDate="
				+ gfUserRoleStartDate + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + ", gfUserRoleName=" + gfUserRoleName
				+ ", gfUserCapabilityId=" + gfUserCapabilityId + ", gfUserCapabilityName=" + gfUserCapabilityName + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
