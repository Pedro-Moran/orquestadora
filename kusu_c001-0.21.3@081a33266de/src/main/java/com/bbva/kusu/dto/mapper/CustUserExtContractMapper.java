package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.AliasFavExtContractEntity;
import com.bbva.kusu.dto.users.entity.AliasFavextContMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfcstExtContMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfcstExtContRoleEntity;
import com.bbva.kusu.dto.users.entity.ProfcstExtContractEntity;
import com.bbva.kusu.dto.users.entity.ProfcstExtcontroleMgEntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxExtContEntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxextContREntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxextCtMgEntity;
import com.bbva.kusu.dto.users.entity.ProfcstMltxextCtrMgEntity;

public class CustUserExtContractMapper {
	
	private CustUserExtContractMapper() {
		
	}
	
	//T_KUSU_PROFCST_EXT_CONTRACT
	public static ProfcstExtContractEntity contractExtFromMgmt(ProfcstExtContMgmtEntity contract, String auditId) {
		ProfcstExtContractEntity entity = new ProfcstExtContractEntity();
		entity.setgUserAccountId(contract.getgUserAccountId());
		entity.setgContractNonBbvaId(contract.getgContractNonBbvaId());
		entity.setGfSignatureLimitAmount(contract.getGfSignatureLimitAmount());
		entity.setgCurrencyId(contract.getgCurrencyId());
		entity.setGfSignatureWeightPer(contract.getGfSignatureWeightPer());
		entity.setgUserPermissionCtrctId(contract.getgUserPermissionCtrctId());
		entity.setGfUserAuditId(auditId);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(contract.getgOfflineDeleteIndType());
		entity.setgOperativeContractIndType(contract.getgOperativeContractIndType());
		entity.setgVisibleContractIndType(contract.getgVisibleContractIndType());
		return entity;
	}
	
	//T_KUSU_PROFCST_EXT_CONT_ROLE
	public static ProfcstExtContRoleEntity roleContractFromMgmtExt(ProfcstExtcontroleMgEntity contractExt, String auditId) {
		ProfcstExtContRoleEntity entityExt = new ProfcstExtContRoleEntity();
		entityExt.setgUserAccountId(contractExt.getgUserAccountId());
		entityExt.setgContractNonBbvaId(contractExt.getgContractNonBbvaId());
		entityExt.setgRecordSequentialId(contractExt.getgRecordSequentialId());
		entityExt.setGfSignatureLimitAmount(contractExt.getGfSignatureLimitAmount());
		entityExt.setgCurrencyId(contractExt.getgCurrencyId());
		entityExt.setGfSignatureWeightPer(contractExt.getGfSignatureWeightPer());
		entityExt.setGfUserRoleId(contractExt.getGfUserRoleId());
		entityExt.setGfUserCapabilityId(contractExt.getGfUserCapabilityId());
		entityExt.setGfSmcInternalId(contractExt.getGfSmcInternalId());
		entityExt.setgUserPermissionCtrctId(contractExt.getgUserPermissionCtrctId());
		entityExt.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entityExt.setGfUserAuditId(auditId);
		entityExt.setgOfflineDeleteIndType(contractExt.getgOfflineDeleteIndType());
		return entityExt;
	}
	
	//T_KUSU_ALIAS_FAV_EXT_CONTRACT
	public static AliasFavExtContractEntity aliasExtFromMgmt(AliasFavextContMgmtEntity aliasExt, String auditId) {
		AliasFavExtContractEntity entity = new AliasFavExtContractEntity();
		entity.setgUserAccountId(aliasExt.getgUserAccountId());
		entity.setgContractNonBbvaId(aliasExt.getgContractNonBbvaId());
		entity.setGfContractAliasName(aliasExt.getGfContractAliasName());
		entity.setgPreferredContractId(aliasExt.getgPreferredContractId());
		entity.setGfUserAuditId(auditId);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOperativeContractIndType(aliasExt.getgOperativeContractIndType());
		entity.setgVisibleContractIndType(aliasExt.getgVisibleContractIndType());
		entity.setgOfflineDeleteIndType(aliasExt.getgOfflineDeleteIndType());
		return entity;
	}
	
	//T_KUSU_PROFCST_MLTX_EXT_CONT
	public static ProfcstMltxExtContEntity contractMtxExtFromMgmt(ProfcstMltxextCtMgEntity contract, String auditId) {
		ProfcstMltxExtContEntity entity = new ProfcstMltxExtContEntity();
		entity.setgUserAccountId(contract.getgUserAccountId());
		entity.setgContractNonBbvaId(contract.getgContractNonBbvaId());
		entity.setgCustomerId(contract.getgCustomerId());
		entity.setGfSignatureLimitAmount(contract.getGfSignatureLimitAmount());
		entity.setgCurrencyId(contract.getgCurrencyId());
		entity.setGfSignatureWeightPer(contract.getGfSignatureWeightPer());
		entity.setgUserPermissionCtrctId(contract.getgUserPermissionCtrctId());
		entity.setGfUserAuditId(auditId);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(contract.getgOfflineDeleteIndType());
		return entity;
	}
	
	//T_KUSU_PROFCST_MLTXEXT_CONT_R
	public static ProfcstMltxextContREntity roleContractFromMgmtMtxExt(ProfcstMltxextCtrMgEntity contractMtxExt, String auditId) {
		ProfcstMltxextContREntity entityMtxExt = new ProfcstMltxextContREntity();
		entityMtxExt.setgUserAccountId(contractMtxExt.getgUserAccountId());
		entityMtxExt.setgContractNonBbvaId(contractMtxExt.getgContractNonBbvaId());
		entityMtxExt.setgCustomerId(contractMtxExt.getgCustomerId());
		entityMtxExt.setgRecordSequentialId(contractMtxExt.getgRecordSequentialId());
		entityMtxExt.setGfSignatureLimitAmount(contractMtxExt.getGfSignatureLimitAmount());
		entityMtxExt.setgCurrencyId(contractMtxExt.getgCurrencyId());
		entityMtxExt.setGfSignatureWeightPer(contractMtxExt.getGfSignatureWeightPer());
		entityMtxExt.setGfUserRoleId(contractMtxExt.getGfUserRoleId());
		entityMtxExt.setGfUserCapabilityId(contractMtxExt.getGfUserCapabilityId());
		entityMtxExt.setGfSmcInternalId(contractMtxExt.getGfSmcInternalId());
		entityMtxExt.setgUserPermissionCtrctId(contractMtxExt.getgUserPermissionCtrctId());
		entityMtxExt.setGfUserAuditId(auditId);
		entityMtxExt.setGfAuditDate(new Timestamp(System.currentTimeMillis()));	
		entityMtxExt.setgOfflineDeleteIndType(contractMtxExt.getgOfflineDeleteIndType());
		return entityMtxExt;
	}
}
