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

public class DeviceMapper {

	public DeviceMapper() {
		// Constructor
	}

	private static final String KUSU = "KUSU";
	private static final String BUSINESS = "BUSINESS";

	public Device fromUserDeviceEntity(UserDeviceEntity paramUserDeviceEntity) {
		if (paramUserDeviceEntity == null)
			return null;
		Device device = new Device();
		device.setOwner(userDeviceEntityToOwner(paramUserDeviceEntity));
		device.setSerialNumber(paramUserDeviceEntity.getSerialNumber());
		device.setId(paramUserDeviceEntity.getId());
		device.setDeviceType(userDeviceEntityToDeviceType(paramUserDeviceEntity));
		device.setProvider(userDeviceEntityToProvider(paramUserDeviceEntity));
		device.setStatus(userDeviceEntityToStatus(paramUserDeviceEntity));
		device.setInitEnrollmentUserId(paramUserDeviceEntity.getgInitEnrollmentUserId());
		device.setChannelDeviceId(paramUserDeviceEntity.getgChannelDeviceId());
		return device;
	}

	public List<Device> fromListUserDeviceEntity(List<UserDeviceEntity> paramList) {
		if (paramList == null) {
			return new ArrayList<>();
		}
		List<Device> list = new ArrayList<>();
		for (UserDeviceEntity userDeviceEntity : paramList) {
			list.add(fromUserDeviceEntity(userDeviceEntity));
		}
		return list;
	}

	public UserDeviceEntity fromDevice(Device device) {
		if (device == null) {
			return null;
		}
		UserDeviceEntity userDeviceEntity = new UserDeviceEntity();
		userDeviceEntity.setSerialNumber(device.getSerialNumber());
		userDeviceEntity.setRolePersonId(deviceOwnerId(device));
		userDeviceEntity.setId(device.getId());
		userDeviceEntity.setDeviceTypeId((device.getDeviceType() != null) ? EnumTypeDevice.valueOf(device.getDeviceType().getId()).getCodigo()
				: EnumTypeDevice.NONE.getCodigo());
		userDeviceEntity.setStatusId(EnumStatusDevice.valueOf(device.getStatus().getId()).getCodigo());
		userDeviceEntity.setUserAudit(KUSU);
		userDeviceEntity.setProviderId((device.getProvider() != null) ? EnumProviderType.valueOf(device.getProvider().getId()).getCodigo()
				: EnumProviderType.NONE.getCodigo());
		userDeviceEntity.setPersonRoleType(EnumRoleType.valueOf(device.getOwner().getRoleType().getId()).getCodigo());
		userDeviceEntity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		userDeviceEntity.setgInitEnrollmentUserId(device.getInitEnrollmentUserId());
		userDeviceEntity.setgChannelDeviceId(device.getChannelDeviceId());
		return userDeviceEntity;
	}

	public CustUserProfileDeviceEntity fromDeviceToCustUserProfileDeviceEntity(Device paramDevice) {
		if (paramDevice == null) {
			return null;
		}
		CustUserProfileDeviceEntity custUserProfileDeviceEntity = new CustUserProfileDeviceEntity();
		custUserProfileDeviceEntity.setUniqueUserAccountId(paramDevice.getProfileId());
		custUserProfileDeviceEntity.setUniqueDeviceId(paramDevice.getId());
		custUserProfileDeviceEntity.setUserAuditId(KUSU);
		custUserProfileDeviceEntity.setAuditDate(new Timestamp(System.currentTimeMillis()));
		return custUserProfileDeviceEntity;
	}

	protected RoleType userDeviceEntityToRoleType(UserDeviceEntity userDeviceEntity) {
		if (userDeviceEntity == null) {
			return null;
		}
		RoleType roleType = new RoleType();
		roleType.setId(EnumRoleType.getByCodigo(userDeviceEntity.getPersonRoleType()).name());
		return roleType;
	}

	protected Owner userDeviceEntityToOwner(UserDeviceEntity userDeviceEntity) {
		if (userDeviceEntity == null) {
			return null;
		}
		Owner owner = new Owner();
		owner.setId(userDeviceEntity.getRolePersonId());
		owner.setRoleType(userDeviceEntityToRoleType(userDeviceEntity));
		owner.setOwnerType(BUSINESS);
		return owner;
	}

	protected DeviceType userDeviceEntityToDeviceType(UserDeviceEntity userDeviceEntity) {
		if (userDeviceEntity == null) {
			return null;
		}
		DeviceType deviceType = new DeviceType();
		deviceType.setId(EnumTypeDevice.getByCodigo(userDeviceEntity.getDeviceTypeId()).name());
		return deviceType;
	}

	protected Provider userDeviceEntityToProvider(UserDeviceEntity userDeviceEntity) {
		if (userDeviceEntity == null) {
			return null;
		}
		Provider provider = new Provider();
		provider.setId(EnumProviderType.getByCodigo(userDeviceEntity.getProviderId()).name());
		return provider;
	}

	protected Status userDeviceEntityToStatus(UserDeviceEntity userDeviceEntity) {
		if (userDeviceEntity == null) {
			return null;
		}
		Status status = new Status();
		status.setId(EnumStatusDevice.getByCodigo(userDeviceEntity.getStatusId()).name());
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

	public Device fromCustUserProfileDeviceEntity(UserDeviceEntity userDeviceEntity, CustUserProfileDeviceEntity custUserProfileDeviceEntity) {
		Device device = null;
		if (userDeviceEntity == null) {
			return null;
		}
		device = fromUserDeviceEntity(userDeviceEntity);
		if (custUserProfileDeviceEntity != null) {
			device.setProfileId(custUserProfileDeviceEntity.getUniqueUserAccountId());
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