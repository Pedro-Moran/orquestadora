package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CustomContractRoleCommons;

public class CustomContRoleMgmtEntity extends CustomContractRoleCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserPermissionCtrctId;
	private String gCustomerId;

	public String getGUserPermissionCtrctId() {
		return getgUserPermissionCtrctId();
	}
	
	public String getgUserPermissionCtrctId() {
		return gUserPermissionCtrctId;
	}

	public void setGUserPermissionCtrctId(String gUserPermissionCtrctId) {
		this.setgUserPermissionCtrctId(gUserPermissionCtrctId);
	}
	
	public void setgUserPermissionCtrctId(String gUserPermissionCtrctId) {
		this.gUserPermissionCtrctId = gUserPermissionCtrctId;
	}

	public String getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	@Override
	public String toString() {
		return "CustomContRoleMgmtEntity [super.toString()=" + super.toString() + ", gUserPermissionCtrctId=" + gUserPermissionCtrctId
				+ ", gCustomerId=" + gCustomerId + "]";
	}

}
