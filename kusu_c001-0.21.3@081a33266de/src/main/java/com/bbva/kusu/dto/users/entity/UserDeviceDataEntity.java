package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

public class UserDeviceDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String deviceTypeId;
	private String serialNumber;
	private String phonePrefix;
	private String phoneNumber;
	private String emailDesc;

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDeviceTypeId() {
		return this.deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getPhonePrefix() {
		return this.phonePrefix;
	}

	public void setPhonePrefix(String phonePrefix) {
		this.phonePrefix = phonePrefix;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailDesc() {
		return this.emailDesc;
	}

	public void setEmailDesc(String emailDesc) {
		this.emailDesc = emailDesc;
	}

	@Override
	public String toString() {
		return "UserDeviceDataEntity [deviceTypeId=" + deviceTypeId + ", serialNumber=" + serialNumber + ", phonePrefix=" + phonePrefix
				+ ", phoneNumber=" + phoneNumber + ", emailDesc=" + emailDesc + "]";
	}

}
