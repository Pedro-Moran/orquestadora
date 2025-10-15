package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;

import com.bbva.kusu.dto.mapper.commons.UserMapperCommons;
import com.bbva.kusu.dto.users.entity.UserDeviceEntity;
import com.bbva.kusu.dto.users.entity.UserDeviceManagementEntity;

public class UserDeviceMapper extends UserMapperCommons {

	private UserDeviceMapper() {

	}

	public static UserDeviceEntity devicesMapperFromMgmtAndToLive(UserDeviceManagementEntity mgmt, String auditUser, String deviceApiId) {
		UserDeviceEntity entity = new UserDeviceEntity();
		entity.setId(StringUtils.isNotBlank(deviceApiId) ? deviceApiId : mgmt.getId());
		entity.setRolePersonId(mgmt.getRolePersonId());
		entity.setPersonRoleType(mgmt.getPersonRoleType());
		entity.setSerialNumber(mgmt.getSerialNumber());
		entity.setStatusId(mgmt.getStatusId());
		entity.setDeviceTypeId(mgmt.getDeviceTypeId());
		entity.setProviderId(mgmt.getProviderId());
		entity.setGfDeviceAliasName(mgmt.getGfDeviceAliasName());
		entity.setgChannelDeviceId(mgmt.getgChannelDeviceId());
		entity.setgInitEnrollmentUserId(mgmt.getgInitEnrollmentUserId());
		entity.setUserAudit(auditUser);
		entity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setGlobalCustomerId(mgmt.getGlobalCustomerId());
		entity.setgDeviceSupplierType(mgmt.getgDeviceSupplierType());
		entity.setgOfflineDeleteIndType(mgmt.getgOfflineDeleteIndType());
		return entity;
	}

	public static UserDeviceManagementEntity devicesMapperFromMgmtAndToLive(UserDeviceEntity live, String recordUpdateType, String auditUser,
			String deviceApiId) {
		UserDeviceManagementEntity entity = new UserDeviceManagementEntity();
		entity.setRecordUpdateTypeId(recordUpdateType);
		entity.setId(StringUtils.isNotBlank(deviceApiId) ? deviceApiId : live.getId());
		entity.setRolePersonId(live.getRolePersonId());
		entity.setPersonRoleType(live.getPersonRoleType());
		entity.setSerialNumber(live.getSerialNumber());
		entity.setStatusId(live.getStatusId());
		entity.setDeviceTypeId(live.getDeviceTypeId());
		entity.setProviderId(live.getProviderId());
		entity.setGfDeviceAliasName(live.getGfDeviceAliasName());
		entity.setgChannelDeviceId(live.getgChannelDeviceId());
		entity.setgInitEnrollmentUserId(live.getgInitEnrollmentUserId());
		entity.setUserAudit(auditUser);
		entity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setGlobalCustomerId(live.getGlobalCustomerId());
		entity.setgDeviceSupplierType(live.getgDeviceSupplierType());
		entity.setgOfflineDeleteIndType(live.getgOfflineDeleteIndType());
		return entity;
	}
}