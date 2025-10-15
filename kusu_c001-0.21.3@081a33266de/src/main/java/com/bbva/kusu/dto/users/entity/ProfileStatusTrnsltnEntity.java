package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ProfileStatusCommons;

public class ProfileStatusTrnsltnEntity extends ProfileStatusCommons implements Serializable {
	@Override
	public String toString() {
		return "ProfileStatusTrnsltnEntity [toString()=" + super.toString() + "]";
	}

	private static final long serialVersionUID = 1L;

}
