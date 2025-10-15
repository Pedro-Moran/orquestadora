package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ProfileStatusCommons;

public class ProfileStatusMapEntity extends ProfileStatusCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ProfileStatusMapEntity [toString()=" + super.toString() + "]";
	}

}
