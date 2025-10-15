package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ProfileStatusCommons;

public class UserStatusMapEntity extends ProfileStatusCommons implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserStatusMapEntity [toString()=" + super.toString() + "]";
	}

}
