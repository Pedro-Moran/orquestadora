package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class UserCustomCapEntityCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfUserCapabilityId;
	private String gUserAccountId;
	private String gfUserRoleId;
	private String gCapbCstmCtrctIndType;
	private String gOfflineDeleteIndType;
	
	public String getGfUserCapabilityId() {
		return this.gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGfUserRoleId() {
		return this.gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getgCapbCstmCtrctIndType() {
		return gCapbCstmCtrctIndType;
	}

	public void setgCapbCstmCtrctIndType(String gCapbCstmCtrctIndType) {
		this.gCapbCstmCtrctIndType = gCapbCstmCtrctIndType;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "UserCustomCapEntityCommons [super.toString()=" + super.toString() + ", gfUserCapabilityId=" + gfUserCapabilityId + ", gUserAccountId="
				+ gUserAccountId + ", gfUserRoleId=" + gfUserRoleId + ", gCapbCstmCtrctIndType= " + gCapbCstmCtrctIndType + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
