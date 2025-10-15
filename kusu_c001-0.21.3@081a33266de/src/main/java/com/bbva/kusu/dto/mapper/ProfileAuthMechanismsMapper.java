package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.ProfAuthMchmMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfAuthMechanismsEntity;

public class ProfileAuthMechanismsMapper {

	private ProfileAuthMechanismsMapper() {

	}

	public static ProfAuthMechanismsEntity authMchmMapperFromMgmtToLive(ProfAuthMchmMgmtEntity mgmt, String auditUser, String status) {
		ProfAuthMechanismsEntity op = new ProfAuthMechanismsEntity();
		op.setgUserAccountId(mgmt.getgUserAccountId());
		op.setgUserProfAccessMethodType(mgmt.getgUserProfAccessMethodType());
		op.setgUserProfAccessMethodId(mgmt.getgUserProfAccessMethodId());
		op.setgAccessMethodStatusType(status != null ? status : mgmt.getgAccessMethodStatusType());
		op.setGfUserAuditId(auditUser);
		op.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		op.setgUsrProfileAccMethIdType(mgmt.getgUsrProfileAccMethIdType());
		op.setHoldingEntityId(mgmt.getHoldingEntityId());
		op.setgOfflineDeleteIndType(mgmt.getgOfflineDeleteIndType());
		return op;
	}

	public static ProfAuthMchmMgmtEntity authMchmMapperFromLiveToMgmt(ProfAuthMechanismsEntity live, String recordUpdateType, String auditUser,
			String status) {
		ProfAuthMchmMgmtEntity mgmt = new ProfAuthMchmMgmtEntity();
		mgmt.setgRecordUpdateType(recordUpdateType);
		mgmt.setgUserAccountId(live.getgUserAccountId());
		mgmt.setgUserProfAccessMethodType(live.getgUserProfAccessMethodType());
		mgmt.setgUserProfAccessMethodId(live.getgUserProfAccessMethodId());
		mgmt.setgAccessMethodStatusType(status != null ? status : live.getgAccessMethodStatusType());
		mgmt.setGfUserAuditId(auditUser);
		mgmt.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		mgmt.setgUsrProfileAccMethIdType(live.getgUsrProfileAccMethIdType());
		mgmt.setHoldingEntityId(live.getHoldingEntityId());
		mgmt.setgOfflineDeleteIndType(live.getgOfflineDeleteIndType());
		return mgmt;
	}
}
