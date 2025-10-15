package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserNUserEntityCommons;

public class NuserEntity extends UserNUserEntityCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gNonCustomerId;

	public String getGNonCustomerId() {
		return this.gNonCustomerId;
	}

	public void setGNonCustomerId(String gNonCustomerId) {
		this.gNonCustomerId = gNonCustomerId;
	}

	@Override
	public String toString() {
		return "NuserEntity [gNonCustomerId=" + gNonCustomerId + ", toString()=" + super.toString() + "]";
	}

}
