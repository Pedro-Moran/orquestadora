package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomSmcCommons;

public class UserCustomSmcEntity extends UserCustomSmcCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserCustomSmcEntity [toString()=" + super.toString() + "]";
	}

}
