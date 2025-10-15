package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class DeviceSupplierEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gDeviceSupplierType;
	private String gDeviceSupplierTypeName;

	public String getgDeviceSupplierType() {
		return this.gDeviceSupplierType;
	}

	public void setgDeviceSupplierType(String gDeviceSupplierType) {
		this.gDeviceSupplierType = gDeviceSupplierType;
	}

	public String getgDeviceSupplierTypeName() {
		return this.gDeviceSupplierTypeName;
	}

	public void setgDeviceSupplierTypeName(String gDeviceSupplierTypeName) {
		this.gDeviceSupplierTypeName = gDeviceSupplierTypeName;
	}

	@Override
	public String toString() {
		return "DeviceSupplierEntity [super.toString()=" + super.toString() + ", gDeviceSupplierType=" + gDeviceSupplierType
				+ ", gDeviceSupplierTypeName=" + gDeviceSupplierTypeName + "]";
	}
}
