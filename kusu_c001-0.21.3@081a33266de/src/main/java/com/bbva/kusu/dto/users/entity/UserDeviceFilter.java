package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserDeviceCommons;

public class UserDeviceFilter extends UserDeviceCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String profileId;

	public String getProfileId() {
		return this.profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	@Override
	public String toString() {
		return "UserDeviceFilter [profileId=" + profileId + ", toString()=" + super.toString() + "]";
	}

}
