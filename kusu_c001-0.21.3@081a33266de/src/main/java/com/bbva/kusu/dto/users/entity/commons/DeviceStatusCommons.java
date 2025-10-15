package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class DeviceStatusCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gCountryId;
	private String gfDeviceStatusType;

	public String getgCountryId() {
		return this.gCountryId;
	}

	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfDeviceStatusType() {
		return this.gfDeviceStatusType;
	}

	public void setGfDeviceStatusType(String gfDeviceStatusType) {
		this.gfDeviceStatusType = gfDeviceStatusType;
	}

	@Override
	public String toString() {
		return "DeviceStatusCommons [super.toString()=" + super.toString() + ", gCountryId=" + gCountryId + ", gfDeviceStatusType="
				+ gfDeviceStatusType + "]";
	}

}
