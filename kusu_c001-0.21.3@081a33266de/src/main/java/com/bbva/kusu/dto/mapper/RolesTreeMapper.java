package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.UserCustomCapMgmtJoinFunctionalityEntity;
import com.bbva.kusu.dto.users.entity.UserCustomCapabilityEntity;
import com.bbva.kusu.dto.users.entity.UserCustomSmcAtrbEntity;
import com.bbva.kusu.dto.users.entity.UserCustomSmcEntity;
import com.bbva.kusu.dto.users.entity.UserCustomSmcJoinAtrbMgmtEntity;
import com.bbva.kusu.dto.users.entity.UserProfRoleEntity;
import com.bbva.kusu.dto.users.entity.UserProfRoleJoinCapMgmtEntity;
import com.bbva.kusu.dto.users.entity.UsrCstmSmcAtrbMgmtEntity;

public class RolesTreeMapper {
	
	private RolesTreeMapper() {

	}
	
	//T_KUSU_USER_PROF_ROLE
	public static UserProfRoleEntity roleMapperFromMgmt(UserProfRoleJoinCapMgmtEntity mgmtEntity, String audit) {
		UserProfRoleEntity entity = new UserProfRoleEntity();
		entity.setGfUserRoleId(mgmtEntity.getGfUserRoleId());
		entity.setGUserAccountId(mgmtEntity.getGUserAccountId());
		entity.setGfUserRoleStartDate(mgmtEntity.getGfUserRoleStartDate());
		entity.setGfUserRoleName(mgmtEntity.getGfUserRoleName());
		entity.setGfUserCapabilityId(mgmtEntity.getGfUserCapabilityId());
		entity.setGfUserCapabilityName(mgmtEntity.getGfUserCapabilityName());
		entity.setGfUserAuditId(audit);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(mgmtEntity.getgOfflineDeleteIndType());
		return entity;
	}
	
	//T_KUSU_USER_CUSTOM_CAPABILITY
	public static UserCustomCapabilityEntity capMapperFromMgmt(UserCustomCapMgmtJoinFunctionalityEntity capability, String audit) {
		UserCustomCapabilityEntity entity = new UserCustomCapabilityEntity();
		entity.setGfUserCapabilityId(capability.getGfUserCapabilityId());
		entity.setGUserAccountId(capability.getGUserAccountId());
		entity.setGfUserRoleId(capability.getGfUserRoleId());
		entity.setgCapbCstmCtrctIndType(capability.getgCapbCstmCtrctIndType());
		entity.setGfUserAuditId(audit);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(capability.getgOfflineDeleteIndType());
		return entity;
	}
	
	//T_KUSU_USER_CUSTOM_SMC
	public static UserCustomSmcEntity smcMapperFromMgmt(UserCustomSmcJoinAtrbMgmtEntity functionality, String audit) {
		UserCustomSmcEntity entity = new UserCustomSmcEntity();
		entity.setGfSmcInternalId(functionality.getGfSmcInternalId());
		entity.setGUserAccountId(functionality.getGUserAccountId());
		entity.setGfUserRoleId(functionality.getGfUserRoleId());
		entity.setGfUserCapabilityId(functionality.getGfUserCapabilityId());
		entity.setGUserSgntrSmcIndType(functionality.getGUserSgntrSmcIndType());
		entity.setGfSignatureWeightPer(functionality.getGfSignatureWeightPer());
		entity.setgUserPermissionSmcType(functionality.getgUserPermissionSmcType());
		entity.setgCapbCstmCtrctIndType(functionality.getgCapbCstmCtrctIndType());
		entity.setgSmcCstmCtrctIndType(functionality.getgSmcCstmCtrctIndType());
		entity.setGfSignatureLimitAmount(functionality.getGfSignatureLimitAmount());
		entity.setgCurrencyId(functionality.getgCurrencyId());
		entity.setGfUserAuditId(audit);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(functionality.getgOfflineDeleteIndType());
		return entity;
	}
	
	//T_KUSU_USER_CUSTOM_SMC_ATRB
	public static UserCustomSmcAtrbEntity smcAtribMapperFromMgmt(UsrCstmSmcAtrbMgmtEntity attribute, String audit) {
		UserCustomSmcAtrbEntity entity = new UserCustomSmcAtrbEntity();
		entity.setGfSmcInternalId(attribute.getGfSmcInternalId());
		entity.setGSpecificAttributeId(attribute.getGSpecificAttributeId());
		entity.setGUserAccountId(attribute.getGUserAccountId());
		entity.setGfUserRoleId(attribute.getGfUserRoleId());
		entity.setGfUserCapabilityId(attribute.getGfUserCapabilityId());
		entity.setGfSignatureWeightPer(attribute.getGfSignatureWeightPer());
		entity.setgUserPermissionSmcType(attribute.getgUserPermissionSmcType());
		entity.setGfUserAuditId(audit);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(attribute.getgOfflineDeleteIndType());
		return entity;
	}
	
}
