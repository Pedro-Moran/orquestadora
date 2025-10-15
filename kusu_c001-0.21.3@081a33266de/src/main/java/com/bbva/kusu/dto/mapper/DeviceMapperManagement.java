package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bbva.kusu.dto.users.beans.Device;
import com.bbva.kusu.dto.users.beans.DeviceType;
import com.bbva.kusu.dto.users.beans.Owner;
import com.bbva.kusu.dto.users.beans.Provider;
import com.bbva.kusu.dto.users.beans.RoleType;
import com.bbva.kusu.dto.users.beans.Status;
import com.bbva.kusu.dto.users.entity.CustUserProfileDeviceEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfileDeviceMngmtEntity;
import com.bbva.kusu.dto.users.entity.UserDeviceEntity;
import com.bbva.kusu.dto.users.entity.UserDeviceManagementEntity;
import com.bbva.kusu.dto.users.types.EnumProviderType;
import com.bbva.kusu.dto.users.types.EnumRoleType;
import com.bbva.kusu.dto.users.types.EnumStatusDevice;
import com.bbva.kusu.dto.users.types.EnumTypeDevice;

public class DeviceMapperManagement {

	private static final String KUSU = "KUSU";
	private static final String BUSINESS = "BUSINESS";

	public Device fromUserDeviceManagementEntity(UserDeviceManagementEntity paramUserDeviceManagementEntity) {
		if (paramUserDeviceManagementEntity == null) {
			return null;
		}
		Device device = new Device();
		device.setOwner(userDeviceManagementEntityToOwner(paramUserDeviceManagementEntity));
		device.setSerialNumber(paramUserDeviceManagementEntity.getSerialNumber());
		device.setId(paramUserDeviceManagementEntity.getId());
		device.setDeviceType(userDeviceManagementEntityToDeviceType(paramUserDeviceManagementEntity));
		device.setProvider(userDeviceManagementEntityToProvider(paramUserDeviceManagementEntity));
		device.setStatus(userDeviceManagementEntityToStatus(paramUserDeviceManagementEntity));
		device.setInitEnrollmentUserId(paramUserDeviceManagementEntity.getgInitEnrollmentUserId());
		device.setChannelDeviceId(paramUserDeviceManagementEntity.getgChannelDeviceId());
		return device;
	}

	public List<Device> fromListUserDeviceEntity(List<UserDeviceManagementEntity> paramList) {
		if (paramList == null) {
			return new ArrayList<>();
		}
		List<Device> list = new ArrayList<>();
		for (UserDeviceManagementEntity userDeviceManagementEntity : paramList) {
			list.add(fromUserDeviceManagementEntity(userDeviceManagementEntity));
		}
		return list;
	}

	public UserDeviceManagementEntity fromDevice(Device device) {
		if (device == null) {
			return null;
		}
		UserDeviceManagementEntity userDeviceManagementEntity = new UserDeviceManagementEntity();
		userDeviceManagementEntity.setSerialNumber(device.getSerialNumber());
		userDeviceManagementEntity.setRolePersonId(deviceOwnerId(device));
		userDeviceManagementEntity
				.setDeviceTypeId((device.getDeviceType() != null) ? EnumTypeDevice.valueOf(device.getDeviceType().getId()).getCodigo()
						: EnumTypeDevice.NONE.getCodigo());
		userDeviceManagementEntity.setStatusId(EnumStatusDevice.valueOf(device.getStatus().getId()).getCodigo());
		userDeviceManagementEntity.setUserAudit(KUSU);
		userDeviceManagementEntity.setProviderId((device.getProvider() != null) ? EnumProviderType.valueOf(device.getProvider().getId()).getCodigo()
				: EnumProviderType.NONE.getCodigo());
		userDeviceManagementEntity.setId(device.getId());
		userDeviceManagementEntity.setPersonRoleType(EnumRoleType.valueOf(device.getOwner().getRoleType().getId()).getCodigo());
		userDeviceManagementEntity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		userDeviceManagementEntity.setgInitEnrollmentUserId(device.getInitEnrollmentUserId());
		userDeviceManagementEntity.setgChannelDeviceId(device.getChannelDeviceId());
		return userDeviceManagementEntity;
	}

	public CustUserProfileDeviceMngmtEntity fromDeviceToCustUserProfileDeviceMngmtEntity(Device device) {
		if (device == null) {
			return null;
		}
		CustUserProfileDeviceMngmtEntity custUserProfileDeviceMngmtEntity = new CustUserProfileDeviceMngmtEntity();
		custUserProfileDeviceMngmtEntity.setUniqueUserAccountId(device.getProfileId());
		custUserProfileDeviceMngmtEntity.setUniqueDeviceId(device.getId());
		custUserProfileDeviceMngmtEntity.setUserAuditId(KUSU);
		custUserProfileDeviceMngmtEntity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		return custUserProfileDeviceMngmtEntity;
	}

	protected RoleType userDeviceManagementEntityToRoleType(UserDeviceManagementEntity userDeviceManagementEntity) {
		if (userDeviceManagementEntity == null) {
			return null;
		}
		RoleType roleType = new RoleType();
		roleType.setId(EnumRoleType.getByCodigo(userDeviceManagementEntity.getPersonRoleType()).name());
		return roleType;
	}

	protected Owner userDeviceManagementEntityToOwner(UserDeviceManagementEntity userDeviceManagementEntity) {
		if (userDeviceManagementEntity == null) {
			return null;
		}
		Owner owner = new Owner();
		owner.setId(userDeviceManagementEntity.getRolePersonId());
		owner.setRoleType(userDeviceManagementEntityToRoleType(userDeviceManagementEntity));
		owner.setOwnerType(BUSINESS);
		return owner;
	}

	protected DeviceType userDeviceManagementEntityToDeviceType(UserDeviceManagementEntity userDeviceManagementEntity) {
		if (userDeviceManagementEntity == null) {
			return null;
		}
		DeviceType deviceType = new DeviceType();
		deviceType.setId(EnumTypeDevice.getByCodigo(userDeviceManagementEntity.getDeviceTypeId()).name());
		return deviceType;
	}

	protected Provider userDeviceManagementEntityToProvider(UserDeviceManagementEntity userDeviceManagementEntity) {
		if (userDeviceManagementEntity == null) {
			return null;
		}
		Provider provider = new Provider();
		provider.setId(EnumProviderType.getByCodigo(userDeviceManagementEntity.getProviderId()).name());
		return provider;
	}

	protected Status userDeviceManagementEntityToStatus(UserDeviceManagementEntity userDeviceManagementEntity) {
		if (userDeviceManagementEntity == null) {
			return null;
		}
		Status status = new Status();
		status.setId(EnumStatusDevice.getByCodigo(userDeviceManagementEntity.getStatusId()).name());
		return status;
	}

	private String deviceOwnerId(Device device) {
		if (device == null) {
			return null;
		}
		Owner owner = device.getOwner();
		if (owner == null) {
			return null;
		}
		String id = owner.getId();
		if (id == null) {
			return null;
		}
		return id;
	}

	public Device fromCustUserProfileDeviceManagementEntity(UserDeviceManagementEntity userDeviceManagementEntity,
															CustUserProfileDeviceMngmtEntity custUserProfileDeviceMngmtEntity) {
		Device device = null;
		if (userDeviceManagementEntity == null) {
			return null;
		}
		device = fromUserDeviceManagementEntity(userDeviceManagementEntity);
		if (custUserProfileDeviceMngmtEntity != null) {
			device.setProfileId(custUserProfileDeviceMngmtEntity.getUniqueUserAccountId());
		}
		return device;
	}

	// T_KUSU_CUST_USER_PROF_DEVICE
	public static CustUserProfileDeviceEntity devicesProfileMapperFromMgmt(CustUserProfileDeviceMngmtEntity device, String auditUser) {
		CustUserProfileDeviceEntity entity = new CustUserProfileDeviceEntity();
		entity.setUniqueUserAccountId(device.getUniqueUserAccountId());
		entity.setUniqueDeviceId(device.getUniqueDeviceId());
		entity.setUserAuditId(auditUser);
		entity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(device.getgOfflineDeleteIndType());
		return entity;
	}

	// T_KUSU_DEVICE
	public static UserDeviceEntity devicesMapperFromMgmt(UserDeviceManagementEntity device, String auditUser) {
		UserDeviceEntity entity = new UserDeviceEntity();
		entity.setDeviceTypeId(device.getDeviceTypeId());
		entity.setId(device.getId());
		entity.setProviderId(device.getProviderId());
		entity.setSerialNumber(device.getSerialNumber());
		entity.setStatusId(device.getStatusId());
		entity.setUserAudit(auditUser);
		entity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setRolePersonId(device.getRolePersonId());
		entity.setPersonRoleType(device.getPersonRoleType());
		entity.setGlobalCustomerId(device.getGlobalCustomerId());
		entity.setGfDeviceAliasName(device.getGfDeviceAliasName());
		entity.setgChannelDeviceId(device.getgChannelDeviceId());
		entity.setgInitEnrollmentUserId(device.getgInitEnrollmentUserId());
		entity.setgDeviceSupplierType(device.getgDeviceSupplierType());
		entity.setgOfflineDeleteIndType(device.getgOfflineDeleteIndType());
		return entity;
	}
}