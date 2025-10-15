package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserNUserExternalEntityCommons;

public class UserExternalEntity extends UserNUserExternalEntityCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserExternalEntity [toString()=" + super.toString() + "]";
	}

}
