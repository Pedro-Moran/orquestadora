package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserDeviceCommons;

public class UserDeviceManagementFilter extends UserDeviceCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String profileId;

	private String recordUpdateTypeId;

	public String getProfileId() {
		return this.profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getRecordUpdateTypeId() {
		return this.recordUpdateTypeId;
	}

	public void setRecordUpdateTypeId(String recordUpdateTypeId) {
		this.recordUpdateTypeId = recordUpdateTypeId;
	}

	@Override
	public String toString() {
		return "UserDeviceManagementFilter [profileId=" + profileId + ", recordUpdateTypeId=" + recordUpdateTypeId + ", toString()="
				+ super.toString() + "]";
	}

}
