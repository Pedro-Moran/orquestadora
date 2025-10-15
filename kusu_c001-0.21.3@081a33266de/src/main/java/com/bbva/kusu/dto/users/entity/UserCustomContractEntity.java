package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomContractJoinAliasCommons;

public class UserCustomContractEntity extends UserCustomContractJoinAliasCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserPermissionCtrctId;

	public String getgUserPermissionCtrctId() {
		return this.gUserPermissionCtrctId;
	}

	public void setgUserPermissionCtrctId(String gUserPermissionCtrctId) {
		this.gUserPermissionCtrctId = gUserPermissionCtrctId;
	}

	@Override
	public String toString() {
		return "UserCustomContractEntity [gUserPermissionCtrctId=" + gUserPermissionCtrctId + ", toString()=" + super.toString() + "]";
	}

}
