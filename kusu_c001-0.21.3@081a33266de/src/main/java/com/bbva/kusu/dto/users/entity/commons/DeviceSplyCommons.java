package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class DeviceSplyCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gCountryId;
	private String gfDeviceSupplierType;

	public String getgCountryId() {
		return this.gCountryId;
	}

	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfDeviceSupplierType() {
		return this.gfDeviceSupplierType;
	}

	public void setGfDeviceSupplierType(String gfDeviceSupplierType) {
		this.gfDeviceSupplierType = gfDeviceSupplierType;
	}

	@Override
	public String toString() {
		return "DeviceSplyCommons [super.toString()=" + super.toString() + ", gCountryId=" + gCountryId + ", gfDeviceSupplierType="
				+ gfDeviceSupplierType + "]";
	}

}
