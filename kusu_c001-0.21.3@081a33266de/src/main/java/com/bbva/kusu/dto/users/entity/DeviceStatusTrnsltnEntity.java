package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.DeviceStatusCommons;

public class DeviceStatusTrnsltnEntity extends DeviceStatusCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gDeviceStatusType;

	public String getgDeviceStatusType() {
		return this.gDeviceStatusType;
	}

	public void setgDeviceStatusType(String gDeviceStatusType) {
		this.gDeviceStatusType = gDeviceStatusType;
	}

	@Override
	public String toString() {
		return "DeviceStatusTrnsltnEntity [super.toString()=" + super.toString() + ", gDeviceStatusType=" + gDeviceStatusType + ", toString()="
				+ super.toString() + "]";
	}

}
