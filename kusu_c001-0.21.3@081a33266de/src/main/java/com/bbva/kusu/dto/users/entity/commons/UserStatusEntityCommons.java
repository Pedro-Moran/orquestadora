package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class UserStatusEntityCommons extends CategoryAndUserStatusCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserStatusEntityCommons [super.toString()=" + super.toString() + ", getGfUserAuditId()=" + getGfUserAuditId() + ", getGfAuditDate()="
				+ super.toString() + "]";
	}

}
