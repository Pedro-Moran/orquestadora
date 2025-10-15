package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class SmcCategoryTypeEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gfUserCategoryId;
	private String gfUserRolePartialId;
	private String gfUserCapabilityPartialId;
	private String gfUserInternSmcPartialId;
	private String gfUserCategoryName;

	public String getGfUserCategoryId() {
		return gfUserCategoryId;
	}

	public void setGfUserCategoryId(String gfUserCategoryId) {
		this.gfUserCategoryId = gfUserCategoryId;
	}

	public String getGfUserRolePartialId() {
		return gfUserRolePartialId;
	}

	public void setGfUserRolePartialId(String gfUserRolePartialId) {
		this.gfUserRolePartialId = gfUserRolePartialId;
	}

	public String getGfUserCapabilityPartialId() {
		return gfUserCapabilityPartialId;
	}

	public void setGfUserCapabilityPartialId(String gfUserCapabilityPartialId) {
		this.gfUserCapabilityPartialId = gfUserCapabilityPartialId;
	}

	public String getGfUserInternSmcPartialId() {
		return gfUserInternSmcPartialId;
	}

	public void setGfUserInternSmcPartialId(String gfUserInternSmcPartialId) {
		this.gfUserInternSmcPartialId = gfUserInternSmcPartialId;
	}

	public String getGfUserCategoryName() {
		return gfUserCategoryName;
	}

	public void setGfUserCategoryName(String gfUserCategoryName) {
		this.gfUserCategoryName = gfUserCategoryName;
	}

	@Override
	public String toString() {
		return "SmcCategoryTypeEntity [gfUserCategoryId=" + gfUserCategoryId + ", gfUserRolePartialId=" + gfUserRolePartialId + ", gfUserCapabilityPartialId="
				+ gfUserCapabilityPartialId + ", gfUserInternSmcPartialId=" + gfUserInternSmcPartialId + ", gfUserCategoryName=" + gfUserCategoryName
				+ ", super()=" + super.toString() + "]";
	}
}
