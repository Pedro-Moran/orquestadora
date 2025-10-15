package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class UserCustomContractBasicCommons extends UserCustomContractJoinAliasCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gRecordUpdateType;

	private String gUserPermissionCtrctId;

	public String getGRecordUpdateType() {
		return this.gRecordUpdateType;
	}

	public void setGRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	public String getGUserPermissionCtrctId() {
		return this.gUserPermissionCtrctId;
	}

	public void setGUserPermissionCtrctId(String gUserPermissionCtrctId) {
		this.gUserPermissionCtrctId = gUserPermissionCtrctId;
	}

	@Override
	public String toString() {
		return "UserCustomContractBasicCommons [super.toString()=" + super.toString() + ", gRecordUpdateType=" + gRecordUpdateType
				+ ", gUserPermissionCtrctId=" + gUserPermissionCtrctId + "]";
	}

}
