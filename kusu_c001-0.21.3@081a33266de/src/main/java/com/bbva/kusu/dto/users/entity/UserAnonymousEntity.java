package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserNUserEntityCommons;

public class UserAnonymousEntity extends UserNUserEntityCommons implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserAnonymousEntity [super()=" + super.toString() + "]";
	}

}
