package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.gson.annotations.SerializedName;

public class DeviceAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "g_device_id")
	private String deviceId;
	
	@SerializedName(value = "g_person_role_type")
	private String personRoleType;
	
	@SerializedName(value = "g_role_person_id")
	private String rolePersonId;
	
	@SerializedName(value = "g_device_serial_number_id")
	private String serialNumber;
	
	@SerializedName(value = "g_device_status_type")
	private String statusId;
	
	@SerializedName(value = "g_device_type")
	private String deviceTypeId;
	
	@SerializedName(value = "g_device_supplier_type")
	private String providerId;
	
	@SerializedName(value = "g_record_update_type")
	private String recordUpdateTypeId;
	
	@SerializedName(value = "gf_user_audit_id")
	private String userAudit;
	
	@SerializedName(value = "gf_audit_date")
	private Timestamp auditDate;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPersonRoleType() {
		return personRoleType;
	}

	public void setPersonRoleType(String personRoleType) {
		this.personRoleType = personRoleType;
	}

	public String getRolePersonId() {
		return rolePersonId;
	}

	public void setRolePersonId(String rolePersonId) {
		this.rolePersonId = rolePersonId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getRecordUpdateTypeId() {
		return recordUpdateTypeId;
	}

	public void setRecordUpdateTypeId(String recordUpdateTypeId) {
		this.recordUpdateTypeId = recordUpdateTypeId;
	}

	public String getUserAudit() {
		return userAudit;
	}

	public void setUserAudit(String userAudit) {
		this.userAudit = userAudit;
	}

	public Timestamp getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	@Override
	public String toString() {
		return "DeviceAuditEntity [deviceId=" + deviceId + ", personRoleType=" + personRoleType + ", rolePersonId="
				+ rolePersonId + ", serialNumber=" + serialNumber + ", statusId=" + statusId + ", deviceTypeId="
				+ deviceTypeId + ", providerId=" + providerId + ", recordUpdateTypeId=" + recordUpdateTypeId
				+ ", userAudit=" + userAudit + ", auditDate=" + auditDate + "]";
	}

}
