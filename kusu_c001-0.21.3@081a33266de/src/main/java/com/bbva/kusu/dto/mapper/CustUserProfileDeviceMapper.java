package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.CustUserProfileDeviceEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfileDeviceMngmtEntity;

public class CustUserProfileDeviceMapper {
	
	private CustUserProfileDeviceMapper() {
		
	}

	public static CustUserProfileDeviceEntity devicesProfileMapperFromMgmtAndApi(CustUserProfileDeviceMngmtEntity device, String auditUser,
			String deviceApiId) {
		CustUserProfileDeviceEntity entity = new CustUserProfileDeviceEntity();
		entity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setUniqueDeviceId(deviceApiId);
		entity.setUniqueUserAccountId(device.getUniqueUserAccountId());
		entity.setUserAuditId(auditUser);
		return entity;
	}

	public static CustUserProfileDeviceEntity devicesProfileMapperFromMgmtToLive(CustUserProfileDeviceMngmtEntity device, String auditUser) {
		CustUserProfileDeviceEntity entity = new CustUserProfileDeviceEntity();
		entity.setUniqueDeviceId(device.getUniqueDeviceId());
		entity.setUniqueUserAccountId(device.getUniqueUserAccountId());
		entity.setUserAuditId(auditUser);
		entity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		return entity;
	}

	public static CustUserProfileDeviceMngmtEntity devicesProfileMapperFromLive(CustUserProfileDeviceEntity device, String recordUpdateType,
			String auditUser) {
		CustUserProfileDeviceMngmtEntity entity = new CustUserProfileDeviceMngmtEntity();
		entity.setRecordUpdateTypeId(recordUpdateType);
		entity.setUniqueDeviceId(device.getUniqueDeviceId());
		entity.setUniqueUserAccountId(device.getUniqueUserAccountId());
		entity.setUserAuditId(auditUser);
		entity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		return entity;
	}
}
