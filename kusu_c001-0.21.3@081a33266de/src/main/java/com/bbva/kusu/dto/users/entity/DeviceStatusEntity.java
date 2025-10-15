package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class DeviceStatusEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gDeviceStatusType;
	private String gDeviceStatusName;

	public String getgDeviceStatusType() {
		return this.gDeviceStatusType;
	}

	public void setgDeviceStatusType(String gDeviceStatusType) {
		this.gDeviceStatusType = gDeviceStatusType;
	}

	public String getgDeviceStatusName() {
		return this.gDeviceStatusName;
	}

	public void setgDeviceStatusName(String gDeviceStatusName) {
		this.gDeviceStatusName = gDeviceStatusName;
	}

	@Override
	public String toString() {
		return "DeviceStatusEntity [super.toString()=" + super.toString() + ", gDeviceStatusType=" + gDeviceStatusType + ", gDeviceStatusName="
				+ gDeviceStatusName + "]";
	}
}
