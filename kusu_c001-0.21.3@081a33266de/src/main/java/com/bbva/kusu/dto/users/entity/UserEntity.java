package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserNUserEntityCommons;

public class UserEntity extends UserNUserEntityCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gCustomerId;

	public String getGCustomerId() {
		return this.gCustomerId;
	}

	public void setGCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	@Override
	public String toString() {
		return "UserEntity [gCustomerId=" + gCustomerId + ", toString()=" + super.toString() + "]";
	}

}
