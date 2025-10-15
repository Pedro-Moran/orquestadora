package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.ProfCustomMltxMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfCustomMultitaxEntity;

public class ProfCustomMultitaxMapper {

	private ProfCustomMultitaxMapper() {

	}

	public static ProfCustomMultitaxEntity mltxMapperFromMgmtToLive(ProfCustomMltxMgmtEntity mgmt, String auditUser) {
		ProfCustomMultitaxEntity op = new ProfCustomMultitaxEntity();
		op.setgUserAccountId(mgmt.getgUserAccountId());
		op.setgCustomerId(mgmt.getgCustomerId());
		op.setGfUserAuditId(auditUser);
		op.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		op.setgSolProfBastanteoIndType(mgmt.getgSolProfBastanteoIndType());
		op.setgOfflineDeleteIndType(mgmt.getgOfflineDeleteIndType());
		return op;
	}

	public static ProfCustomMltxMgmtEntity mltxMapperFromLiveToMgmt(ProfCustomMultitaxEntity op, String recordUpdateType, String auditUser) {
		ProfCustomMltxMgmtEntity mgmt = new ProfCustomMltxMgmtEntity();
		mgmt.setgRecordUpdateType(recordUpdateType);
		mgmt.setgUserAccountId(op.getgUserAccountId());
		mgmt.setgCustomerId(op.getgCustomerId());
		mgmt.setGfUserAuditId(auditUser);
		mgmt.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		mgmt.setgSolProfBastanteoIndType(op.getgSolProfBastanteoIndType());
		mgmt.setgOfflineDeleteIndType(op.getgOfflineDeleteIndType());
		return mgmt;
	}
}
