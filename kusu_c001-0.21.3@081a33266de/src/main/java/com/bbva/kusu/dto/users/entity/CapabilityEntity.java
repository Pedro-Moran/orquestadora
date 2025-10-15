package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CapabilityCommons;

public class CapabilityEntity extends CapabilityCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gfUserCapabilityName;

	public String getGfUserCapabilityName() {
		return this.gfUserCapabilityName;
	}

	public void setGfUserCapabilityName(String gfUserCapabilityName) {
		this.gfUserCapabilityName = gfUserCapabilityName;
	}

	@Override
	public String toString() {
		return "CapabilityEntity [super.toString()=" + super.toString() + ", gfUserCapabilityName=" + gfUserCapabilityName + ", toString()="
				+ super.toString() + "]";
	}

}
