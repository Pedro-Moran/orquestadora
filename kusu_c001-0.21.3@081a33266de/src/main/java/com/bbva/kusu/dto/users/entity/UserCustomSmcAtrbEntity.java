package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomSmcEntityCommons;

public class UserCustomSmcAtrbEntity extends UserCustomSmcEntityCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gfSmcInternalId;

	public String getGfSmcInternalId() {
		return this.gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	@Override
	public String toString() {
		return "UserCustomSmcAtrbEntity [gfSmcInternalId=" + gfSmcInternalId + ", toString()=" + super.toString() + "]";
	}

}
