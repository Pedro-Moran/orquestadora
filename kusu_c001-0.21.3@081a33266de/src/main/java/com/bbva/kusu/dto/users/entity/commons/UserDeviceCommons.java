package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserDeviceCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String globalCustomerId;

	private String serialNumber;

	private String providerId;

	private String statusId;

	private String deviceTypeId;

	private String personRoleType;

	private String rolePersonId;

	private String userAudit;

	private Timestamp auditDate;

	private String gfDeviceAliasName;

	private String gChannelDeviceId;

	private String gInitEnrollmentUserId;

	private String gDeviceSupplierType;

	private String gOfflineDeleteIndType;

	public String getUserAudit() {
		return this.userAudit;
	}

	public void setUserAudit(String userAudit) {
		this.userAudit = userAudit;
	}

	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGlobalCustomerId() {
		return this.globalCustomerId;
	}

	public void setGlobalCustomerId(String globalCustomerId) {
		this.globalCustomerId = globalCustomerId;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProviderId() {
		return this.providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getDeviceTypeId() {
		return this.deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
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

	public String getGfDeviceAliasName() {
		return gfDeviceAliasName;
	}

	public void setGfDeviceAliasName(String gfDeviceAliasName) {
		this.gfDeviceAliasName = gfDeviceAliasName;
	}

	public String getgChannelDeviceId() {
		return gChannelDeviceId;
	}

	public void setgChannelDeviceId(String gChannelDeviceId) {
		this.gChannelDeviceId = gChannelDeviceId;
	}

	public String getgInitEnrollmentUserId() {
		return gInitEnrollmentUserId;
	}

	public void setgInitEnrollmentUserId(String gInitEnrollmentUserId) {
		this.gInitEnrollmentUserId = gInitEnrollmentUserId;
	}

	public String getgDeviceSupplierType() {
		return gDeviceSupplierType;
	}

	public void setgDeviceSupplierType(String gDeviceSupplierType) {
		this.gDeviceSupplierType = gDeviceSupplierType;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "UserDeviceCommons [id=" + id + ", globalCustomerId=" + globalCustomerId + ", serialNumber=" + serialNumber + ", providerId=" + providerId
				+ ", statusId=" + statusId + ", deviceTypeId=" + deviceTypeId + ", personRoleType=" + personRoleType + ", rolePersonId=" + rolePersonId
				+ ", userAudit=" + userAudit + ", auditDate=" + auditDate + ", gfDeviceAliasName=" + gfDeviceAliasName + ", gChannelDeviceId="
				+ gChannelDeviceId + ", gInitEnrollmentUserId=" + gInitEnrollmentUserId + ", gDeviceSupplierType=" + gDeviceSupplierType
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
