package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class DeviceTypeEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gDeviceType;
	private String gDeviceTypeName;

	public String getgDeviceType() {
		return this.gDeviceType;
	}

	public void setgDeviceType(String gDeviceType) {
		this.gDeviceType = gDeviceType;
	}

	public String getgDeviceTypeName() {
		return this.gDeviceTypeName;
	}

	public void setgDeviceTypeName(String gDeviceTypeName) {
		this.gDeviceTypeName = gDeviceTypeName;
	}

	@Override
	public String toString() {
		return "DeviceTypeEntity [super.toString()=" + super.toString() + ", gDeviceType=" + gDeviceType + ", gDeviceTypeName=" + gDeviceTypeName
				+ "]";
	}
}
