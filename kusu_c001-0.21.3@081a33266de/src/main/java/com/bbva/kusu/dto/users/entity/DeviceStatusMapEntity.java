package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.DeviceStatusCommons;

public class DeviceStatusMapEntity extends DeviceStatusCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gDevideStatusType;

	public String getgDevideStatusType() {
		return this.gDevideStatusType;
	}

	public void setgDevideStatusType(String gDevideStatusType) {
		this.gDevideStatusType = gDevideStatusType;
	}

	@Override
	public String toString() {
		return "DeviceStatusMapEntity [super.toString()=" + super.toString() + ", gDevideStatusType=" + gDevideStatusType + ", toString()="
				+ super.toString() + "]";
	}

}
