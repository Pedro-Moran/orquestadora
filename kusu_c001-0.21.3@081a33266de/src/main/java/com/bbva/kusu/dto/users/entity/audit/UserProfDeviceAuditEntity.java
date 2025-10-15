package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.gson.annotations.SerializedName;

public class UserProfDeviceAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "device_str")
	private DeviceAuditEntity device;

	@SerializedName(value = "g_record_update_type")
	private String recordUpdateTypeId;

	@SerializedName(value = "gf_user_audit_id")
	private String userAuditId;
	
	@SerializedName(value = "gf_audit_date")
	private Timestamp auditDate;


	public DeviceAuditEntity getDevice() {
		return device;
	}

	public void setDevice(DeviceAuditEntity device) {
		this.device = device;
	}

	public String getUserAuditId() {
		return this.userAuditId;
	}

	public void setUserAuditId(String userAuditId) {
		this.userAuditId = userAuditId;
	}

	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}
	
	public String getRecordUpdateTypeId() {
		return recordUpdateTypeId;
	}

	public void setRecordUpdateTypeId(String recordUpdateTypeId) {
		this.recordUpdateTypeId = recordUpdateTypeId;
	}

	@Override
	public String toString() {
		return "UserProfDeviceAuditEntity [device=" + device + ", recordUpdateTypeId="
				+ recordUpdateTypeId + ", userAuditId=" + userAuditId + ", auditDate=" + auditDate + "]";
	}

}
