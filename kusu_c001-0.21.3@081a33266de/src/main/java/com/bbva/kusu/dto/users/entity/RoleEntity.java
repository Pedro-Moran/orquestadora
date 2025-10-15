package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class RoleEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gfUserRoleId;
	private String gfUserRoleName;

	public String getGfUserRoleId() {
		return this.gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getGfUserRoleName() {
		return this.gfUserRoleName;
	}

	public void setGfUserRoleName(String gfUserRoleName) {
		this.gfUserRoleName = gfUserRoleName;
	}

	@Override
	public String toString() {
		return "RoleEntity [super.toString()=" + super.toString() + ", gfUserRoleId=" + gfUserRoleId + ", gfUserRoleName=" + gfUserRoleName + "]";
	}
}
