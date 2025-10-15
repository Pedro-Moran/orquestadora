package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class DeviceTypeCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gDeviceType;
	private String gCountryId;
	private String gfDeviceType;

	public String getgDeviceType() {
		return this.gDeviceType;
	}

	public void setgDeviceType(String gDeviceType) {
		this.gDeviceType = gDeviceType;
	}

	public String getgCountryId() {
		return this.gCountryId;
	}

	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfDeviceType() {
		return this.gfDeviceType;
	}

	public void setGfDeviceType(String gfDeviceType) {
		this.gfDeviceType = gfDeviceType;
	}

	@Override
	public String toString() {
		return "DeviceTypeCommons [super.toString()=" + super.toString() + ", gDeviceType=" + gDeviceType + ", gCountryId=" + gCountryId
				+ ", gfDeviceType=" + gfDeviceType + "]";
	}

}
