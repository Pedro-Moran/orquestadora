package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.DeviceSplyCommons;

public class DeviceSplyTrnsltnEntity extends DeviceSplyCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gDeviceSupplierType;

	public String getgDeviceSupplierType() {
		return this.gDeviceSupplierType;
	}

	public void setgDeviceSupplierType(String gDeviceSupplierType) {
		this.gDeviceSupplierType = gDeviceSupplierType;
	}

	@Override
	public String toString() {
		return "DeviceSplyTrnsltnEntity [super.toString()=" + super.toString() + ", gDeviceSupplierType=" + gDeviceSupplierType + ", toString()="
				+ super.toString() + "]";
	}

}
