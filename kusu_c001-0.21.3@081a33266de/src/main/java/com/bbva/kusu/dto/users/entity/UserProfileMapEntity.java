package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UserProfileMapEntity extends AuditParamsCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gUserProfileId;

	private String gCountryId;

	private String gfUserProfileId;

	public String getgUserProfileId() {
		return this.gUserProfileId;
	}

	public void setgUserProfileId(String gUserProfileId) {
		this.gUserProfileId = gUserProfileId;
	}

	public String getgCountryId() {
		return this.gCountryId;
	}

	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfUserProfileId() {
		return this.gfUserProfileId;
	}

	public void setGfUserProfileId(String gfUserProfileId) {
		this.gfUserProfileId = gfUserProfileId;
	}

	@Override
	public String toString() {
		return "UserProfileMapEntity [gUserProfileId=" + gUserProfileId + ", gCountryId=" + gCountryId + ", gfUserProfileId=" + gfUserProfileId
				+ ", toString()=" + super.toString() + "]";
	}
}
