package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class DeviceTypeIdEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gDeviceTypeId;
	private String gDeviceTypeIdName;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;

	public String getgDeviceTypeId() {
		return gDeviceTypeId;
	}

	public void setgDeviceTypeId(String gDeviceTypeId) {
		this.gDeviceTypeId = gDeviceTypeId;
	}

	public String getgDeviceTypeIdName() {
		return gDeviceTypeIdName;
	}

	public void setgDeviceTypeIdName(String gDeviceTypeIdName) {
		this.gDeviceTypeIdName = gDeviceTypeIdName;
	}

	public String getGfUserAuditId() {
		return gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	@Override
	public String toString() {
		return "DeviceTypeIdEntity [gDeviceTypeId=" + gDeviceTypeId + ", gDeviceTypeIdName=" + gDeviceTypeIdName + ", gfUserAuditId=" + gfUserAuditId
				+ ", gfAuditDate=" + gfAuditDate + "]";
	}

}
