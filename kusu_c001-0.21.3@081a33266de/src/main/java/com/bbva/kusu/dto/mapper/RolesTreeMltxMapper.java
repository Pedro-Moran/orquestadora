package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.ProfCstMltxAtrbEntity;
import com.bbva.kusu.dto.users.entity.ProfCstMltxCapbEntity;
import com.bbva.kusu.dto.users.entity.ProfCstMltxRoleEntity;
import com.bbva.kusu.dto.users.entity.ProfCstMltxSmcEntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxAtrbMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxCapbMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxRoleMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxSmcMgmtEntity;

public class RolesTreeMltxMapper {
	
	private RolesTreeMltxMapper() {

	}
	
	//T_KUSU_PROF_CST_MLTX_ROLE
	public static ProfCstMltxRoleEntity rolesMtxMapperFromMgmtToOp(ProfcstMltxRoleMgmtEntity mgmt, String auditUser) {
		ProfCstMltxRoleEntity op = new ProfCstMltxRoleEntity();
		op.setgUserAccountId(mgmt.getgUserAccountId());
		op.setgCustomerId(mgmt.getgCustomerId());
		op.setGfUserRoleId(mgmt.getGfUserRoleId());
		op.setGfUserRoleStartDate(mgmt.getGfUserRoleStartDate());
		op.setGfUserAuditId(auditUser);
		op.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		op.setgOfflineDeleteIndType(mgmt.getgOfflineDeleteIndType());
		return op;
	}
	
	//T_KUSU_PROF_CST_MLTX_CAPB                       
	public static ProfCstMltxCapbEntity capabilitiesMtxMapperFromMgmtToOp(ProfcstMltxCapbMgmtEntity mgmt, String auditUser) {
		ProfCstMltxCapbEntity op = new ProfCstMltxCapbEntity();
		op.setgUserAccountId(mgmt.getgUserAccountId());
		op.setGfUserRoleId(mgmt.getGfUserRoleId());
		op.setGfUserCapabilityId(mgmt.getGfUserCapabilityId());
		op.setgCustomerId(mgmt.getgCustomerId());
		op.setgCapbCstmCtrctIndType(mgmt.getgCapbCstmCtrctIndType());
		op.setGfUserAuditId(auditUser);
		op.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		op.setgOfflineDeleteIndType(mgmt.getgOfflineDeleteIndType());
		return op;
	}

	//T_KUSU_PROF_CST_MLTX_SMC
	public static ProfCstMltxSmcEntity smcsMtxMapperFromMgmtToOp(ProfcstMltxSmcMgmtEntity mgmt, String auditUser) {
		ProfCstMltxSmcEntity op = new ProfCstMltxSmcEntity();
		op.setgUserAccountId(mgmt.getgUserAccountId());
		op.setGfUserRoleId(mgmt.getGfUserRoleId());
		op.setGfUserCapabilityId(mgmt.getGfUserCapabilityId());
		op.setGfSmcInternalId(mgmt.getGfSmcInternalId());
		op.setgCustomerId(mgmt.getgCustomerId());
		op.setgUserSgntrSmcIndType(mgmt.getgUserSgntrSmcIndType());
		op.setGfSignatureWeightPer(mgmt.getGfSignatureWeightPer());
		op.setgUserPermissionSmcType(mgmt.getgUserPermissionSmcType());
		op.setgCapbCstmCtrctIndType(mgmt.getgCapbCstmCtrctIndType());
		op.setgSmcCstmCtrctIndType(mgmt.getgSmcCstmCtrctIndType());
		op.setGfSignatureLimitAmount(mgmt.getGfSignatureLimitAmount());
		op.setgCurrencyId(mgmt.getgCurrencyId());
		op.setGfUserAuditId(auditUser);
		op.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		op.setgOfflineDeleteIndType(mgmt.getgOfflineDeleteIndType());
		return op;
	}

	//T_KUSU_PROF_CST_MLTX_ATRB
	public static ProfCstMltxAtrbEntity smcsAtrbMtxMapperFromMgmtToOp(ProfcstMltxAtrbMgmtEntity mgmt, String auditUser) {
		ProfCstMltxAtrbEntity op = new ProfCstMltxAtrbEntity();
		op.setgUserAccountId(mgmt.getgUserAccountId());
		op.setGfUserRoleId(mgmt.getGfUserRoleId());
		op.setGfUserCapabilityId(mgmt.getGfUserCapabilityId());
		op.setGfSmcInternalId(mgmt.getGfSmcInternalId());
		op.setgSpecificAttributeId(mgmt.getgSpecificAttributeId());
		op.setgCustomerId(mgmt.getgCustomerId());
		op.setGfUserAuditId(auditUser);
		op.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		op.setgOfflineDeleteIndType(mgmt.getgOfflineDeleteIndType());
		return op;
	}
	
}
