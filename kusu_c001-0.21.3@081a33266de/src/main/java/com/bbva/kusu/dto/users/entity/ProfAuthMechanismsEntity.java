package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ProfileMultitaxCommons;

public class ProfAuthMechanismsEntity extends ProfileMultitaxCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ProfAuthMechanismsEntity [super.toString()=" + super.toString() + "]";
	}

}