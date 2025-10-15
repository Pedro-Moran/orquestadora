package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.ProfileAuthAttributeEntity;
import com.bbva.kusu.dto.users.entity.ProfileAuthAttributeMgmtEntity;

public class ProfileAuthAttributeMapper {

	private ProfileAuthAttributeMapper() {

	}

	// T_KUSU_PROF_AUTH_ATTRIBUTES
	public static ProfileAuthAttributeEntity contractExtFromMgmtToLive(ProfileAuthAttributeMgmtEntity entityMgmt, String auditId) {
		ProfileAuthAttributeEntity entity = new ProfileAuthAttributeEntity();
		entity.setgUserAccountId(entityMgmt.getgUserAccountId());
		entity.setgPhoneType(entityMgmt.getgPhoneType());
		entity.setgPrefixPhoneId(entityMgmt.getgPrefixPhoneId());
		entity.setGfPhoneId(entityMgmt.getGfPhoneId());
		entity.setgPhoneVerifiedIndType(entityMgmt.getgPhoneVerifiedIndType());
		entity.setGfEmailDesc(entityMgmt.getGfEmailDesc());
		entity.setGfEmailVerifiedType(entityMgmt.getGfEmailVerifiedType());
		entity.setGfDoubleFactorLastAccDate(entityMgmt.getGfDoubleFactorLastAccDate());
		entity.setGfUserAuditId(auditId);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setGProfAuthAttSplitIndType(entityMgmt.getGProfAuthAttSplitIndType());
		entity.setGOfflineDeleteIndType(entityMgmt.getGOfflineDeleteIndType());
		entity.setgFacialRecognitionIndType(entityMgmt.getgFacialRecognitionIndType());
		return entity;
	}

	// T_KUSU_PROF_AUTH_ATRB_MGMT
	public static ProfileAuthAttributeMgmtEntity contractExtFromLiveToMgmt(ProfileAuthAttributeEntity entity, String recordUpdateType, String auditId) {
		ProfileAuthAttributeMgmtEntity entityMgmt = new ProfileAuthAttributeMgmtEntity();
		entityMgmt.setgRecordUpdateType(recordUpdateType);
		entityMgmt.setgUserAccountId(entity.getgUserAccountId());
		entityMgmt.setgPhoneType(entity.getgPhoneType());
		entityMgmt.setgPrefixPhoneId(entity.getgPrefixPhoneId());
		entityMgmt.setGfPhoneId(entity.getGfPhoneId());
		entityMgmt.setgPhoneVerifiedIndType(entity.getgPhoneVerifiedIndType());
		entityMgmt.setGfEmailDesc(entity.getGfEmailDesc());
		entityMgmt.setGfEmailVerifiedType(entity.getGfEmailVerifiedType());
		entityMgmt.setGfDoubleFactorLastAccDate(entity.getGfDoubleFactorLastAccDate());
		entityMgmt.setGfUserAuditId(auditId);
		entityMgmt.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entityMgmt.setGProfAuthAttSplitIndType(entity.getGProfAuthAttSplitIndType());
		entityMgmt.setGOfflineDeleteIndType(entity.getGOfflineDeleteIndType());
		entityMgmt.setgFacialRecognitionIndType(entity.getgFacialRecognitionIndType());
		return entityMgmt;
	}

}
