package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CustomContractRoleCommons;

public class ProfCstMltxContRoleEntity extends CustomContractRoleCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gCustomerId;
	private String gUserPermissionCtrctId;

	public String getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	public String getgUserPermissionCtrctId() {
		return gUserPermissionCtrctId;
	}

	public void setgUserPermissionCtrctId(String gUserPermissionCtrctId) {
		this.gUserPermissionCtrctId = gUserPermissionCtrctId;
	}

	@Override
	public String toString() {
		return "ProfCstMltxContRoleEntity [gCustomerId=" + gCustomerId + ", gUserPermissionCtrctId=" + gUserPermissionCtrctId + ",super.toString()="
				+ super.toString() + "]";
	}

}