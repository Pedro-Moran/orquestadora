package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.DeviceSplyCommons;

public class DeviceSplyMapEntity extends DeviceSplyCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gDevideSupplierType;

	public String getgDevideSupplierType() {
		return this.gDevideSupplierType;
	}

	public void setgDevideSupplierType(String gDevideSupplierType) {
		this.gDevideSupplierType = gDevideSupplierType;
	}

	@Override
	public String toString() {
		return "DeviceSplyMapEntity [super.toString()=" + super.toString() + ", gDevideSupplierType=" + gDevideSupplierType + ", toString()="
				+ super.toString() + "]";
	}

}
