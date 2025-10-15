package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.beans.Contract;
import com.bbva.kusu.dto.users.entity.AliasFavContMgmtEntity;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.dto.users.entity.CustomContRoleMgmtEntity;
import com.bbva.kusu.dto.users.entity.CustomContractRoleEntity;
import com.bbva.kusu.dto.users.entity.ProfCstMltxContRoleEntity;
import com.bbva.kusu.dto.users.entity.ProfCstMltxContRoleMgmtEntity;
import com.bbva.kusu.dto.users.entity.ProfCstMltxContractEntity;
import com.bbva.kusu.dto.users.entity.ProfCstMltxContractMgmtEntity;
import com.bbva.kusu.dto.users.entity.UserCustomContractEntity;
import com.bbva.kusu.dto.users.entity.UserCustomContractJoinAliasFavRoleCapMgmtEntity;
import com.bbva.kusu.dto.users.entity.UserCustomContractMgmtEntity;
import com.bbva.kusu.dto.users.types.EnumSignaturePower;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

public class CustUserContractMapper {
	
  public UserCustomContractMgmtEntity setCustUserContractFromInsert(Contract contract, String profileId, String contractId, String userAudit, String recordType) {
    UserCustomContractMgmtEntity userCustomContractMgmt = new UserCustomContractMgmtEntity();
    EnumSignaturePower signaturePower = EnumUtils.getEnum(EnumSignaturePower.class, contract.getSignatureOperationsRights().getSignaturePower().getId());
    userCustomContractMgmt.setGfSignatureWeightPer(new BigDecimal(signaturePower.getValue().toString()));
    userCustomContractMgmt.setGfSignatureLimitAmount(BigDecimal.valueOf(contract.getSignatureOperationsRights().getLimitAmount().getAmount().doubleValue()));
    userCustomContractMgmt.setGCurrencyId(contract.getSignatureOperationsRights().getLimitAmount().getCurrency());
    userCustomContractMgmt.setGUserPermissionCtrctId(contract.getPermissionType().getId());
    userCustomContractMgmt.setGContractId(contractId);
    userCustomContractMgmt.setGUserAccountId(profileId);
    userCustomContractMgmt.setGRecordUpdateType(recordType);
    userCustomContractMgmt.setGfUserAuditId(userAudit);
    userCustomContractMgmt.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    return userCustomContractMgmt;
  }
  
  public UserCustomContractMgmtEntity setCustUserContract(UserCustomContractEntity userCustomContract, UserCustomContractMgmtEntity userCustomContractMgmt, Contract contract, String profileId, String contractId, String userAudit, String recordType) {
    if (userCustomContractMgmt == null)
      userCustomContractMgmt = new UserCustomContractMgmtEntity(); 
    if (contract.getSignatureOperationsRights() != null) {
      userCustomContractMgmt = setSignatureOperations(userCustomContract, contract, userCustomContractMgmt);
    } else if (userCustomContract != null) {
      userCustomContractMgmt.setGfSignatureWeightPer(userCustomContract.getGfSignatureWeightPer());
      userCustomContractMgmt.setGfSignatureLimitAmount(userCustomContract.getGfSignatureLimitAmount());
      userCustomContractMgmt.setGCurrencyId(userCustomContract.getGCurrencyId());
    } 
    if (contract.getPermissionType() != null && !StringUtils.isBlank(contract.getPermissionType().getId())) {
      userCustomContractMgmt.setGUserPermissionCtrctId(contract.getPermissionType().getId());
    } else if (userCustomContract != null) {
      userCustomContractMgmt.setGUserPermissionCtrctId(userCustomContract.getgUserPermissionCtrctId());
    } 
    userCustomContractMgmt.setGContractId(contractId);
    userCustomContractMgmt.setGUserAccountId(profileId);
    userCustomContractMgmt.setGRecordUpdateType(recordType);
    userCustomContractMgmt.setGfUserAuditId(userAudit);
    userCustomContractMgmt.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    return userCustomContractMgmt;
  }
  
  public UserCustomContractMgmtEntity setSignatureOperations(UserCustomContractEntity userCustomContract, Contract contract, UserCustomContractMgmtEntity userCustomContractMgmt) {
    userCustomContractMgmt = setSignatureWeightPer(userCustomContract, contract, userCustomContractMgmt);
    userCustomContractMgmt = setCurrency(userCustomContract, contract, userCustomContractMgmt);
    userCustomContractMgmt = setAmount(userCustomContract, contract, userCustomContractMgmt);
    return userCustomContractMgmt;
  }
  
  public UserCustomContractMgmtEntity setSignatureWeightPer(UserCustomContractEntity userCustomContract, Contract contract, UserCustomContractMgmtEntity userCustomContractMgmt) {
    if (contract.getSignatureOperationsRights().getSignaturePower() != null && 
      !StringUtils.isBlank(contract.getSignatureOperationsRights().getSignaturePower().getId())) {
      EnumSignaturePower signaturePower = EnumUtils.getEnum(EnumSignaturePower.class, contract
          .getSignatureOperationsRights().getSignaturePower().getId());
      if (signaturePower != null) {
        userCustomContractMgmt.setGfSignatureWeightPer(new BigDecimal(signaturePower.getValue().toString()));
      } else if (userCustomContract != null) {
        userCustomContractMgmt.setGfSignatureWeightPer(userCustomContract.getGfSignatureWeightPer());
      } 
    } else if (userCustomContract != null) {
      userCustomContractMgmt.setGfSignatureWeightPer(userCustomContract.getGfSignatureWeightPer());
    } 
    return userCustomContractMgmt;
  }
  
  public UserCustomContractMgmtEntity setCurrency(UserCustomContractEntity userCustomContract, Contract contract, UserCustomContractMgmtEntity userCustomContractMgmt) {
    if (contract.getSignatureOperationsRights().getLimitAmount() != null && contract
      .getSignatureOperationsRights().getLimitAmount().getCurrency() != null) {
      userCustomContractMgmt.setGCurrencyId(contract.getSignatureOperationsRights().getLimitAmount().getCurrency());
    } else if (userCustomContract != null) {
      userCustomContractMgmt.setGCurrencyId(userCustomContract.getGCurrencyId());
    } 
    return userCustomContractMgmt;
  }
  
  public UserCustomContractMgmtEntity setAmount(UserCustomContractEntity userCustomContract, Contract contract, UserCustomContractMgmtEntity userCustomContractMgmt) {
    if (contract.getSignatureOperationsRights().getLimitAmount() != null && contract.getSignatureOperationsRights().getLimitAmount().getAmount() != null) {
      userCustomContractMgmt.setGfSignatureLimitAmount(BigDecimal.valueOf(contract.getSignatureOperationsRights().getLimitAmount().getAmount().doubleValue()));
    } else if (userCustomContract != null) {
      userCustomContractMgmt.setGfSignatureLimitAmount(userCustomContract.getGfSignatureLimitAmount());
    } 
    return userCustomContractMgmt;
  }
  
  //T_KUSU_USER_CUSTOM_CONTRACT
  public static UserCustomContractEntity contractFromMgmt(UserCustomContractJoinAliasFavRoleCapMgmtEntity contract, String auditId) {
	UserCustomContractEntity entity = new UserCustomContractEntity();
	entity.setGContractId(contract.getGContractId());
	entity.setGUserAccountId(contract.getGUserAccountId());
	entity.setGfSignatureLimitAmount(contract.getGfSignatureLimitAmount());
	entity.setGCurrencyId(contract.getGCurrencyId());
	entity.setGfSignatureWeightPer(contract.getGfSignatureWeightPer());
	entity.setgUserPermissionCtrctId(contract.getGUserPermissionCtrctId());
	entity.setgCustomerId(contract.getgCustomerId());
	// JOIN T_KUSU_ALIAS_FAV_CONTRACT
	entity.setGfContractAliasName(contract.getGfContractAliasName());
	entity.setgPreferredContractId(contract.getgPreferredContractId());
	// JOIN T_KUSU_CUSTOM_CONTRACT_ROLE
	entity.setGRecordSequentialId(contract.getGRecordSequentialId());
	entity.setGfSignatureLimitAmountRole(contract.getGfSignatureLimitAmountRole());
	entity.setGCurrencyIdRole(contract.getGCurrencyIdRole());
	entity.setGfSignatureWeightPerRole(contract.getGfSignatureWeightPerRole());
	entity.setGfUserRoleId(contract.getGfUserRoleId());
	entity.setGfUserCapabilityId(contract.getGfUserCapabilityId());
	entity.setGfSmcInternalId(contract.getGfSmcInternalId());
	entity.setGfUserAuditId(auditId);
	entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
	entity.setgOfflineDeleteIndType(contract.getgOfflineDeleteIndType());
	return entity;
  }
  
  //T_KUSU_CUSTOM_CONTRACT_ROLE
  public static CustomContractRoleEntity roleContractFromMgmt(CustomContRoleMgmtEntity contract, String auditId) {
	  CustomContractRoleEntity entity = new CustomContractRoleEntity();
	  entity.setGContractId(contract.getGContractId());
	  entity.setGUserAccountId(contract.getGUserAccountId());
	  entity.setGRecordSequentialId(contract.getGRecordSequentialId());
	  entity.setGfSignatureLimitAmount(contract.getGfSignatureLimitAmount());
	  entity.setGCurrencyId(contract.getGCurrencyId());
	  entity.setGfSignatureWeightPer(contract.getGfSignatureWeightPer());
	  entity.setGfUserRoleId(contract.getGfUserRoleId());
	  entity.setGfUserCapabilityId(contract.getGfUserCapabilityId());
	  entity.setGfSmcInternalId(contract.getGfSmcInternalId());
	  entity.setgUserPermissionCtrctId(contract.getgUserPermissionCtrctId());
	  entity.setgCustomerId(contract.getgCustomerId());
	  entity.setGfUserAuditId(auditId);
	  entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
	  entity.setgOfflineDeleteIndType(contract.getgOfflineDeleteIndType());
	  return entity;
  }
  
  //T_KUSU_ALIAS_FAV_CONTRACT
  public static AliasFavContractEntity aliasFromMgmt(AliasFavContMgmtEntity alias, String auditId) {
	  AliasFavContractEntity entity = new AliasFavContractEntity();
	  entity.setGContractId(alias.getGContractId());
	  entity.setGUserAccountId(alias.getGUserAccountId());
	  entity.setGfContractAliasName(alias.getGfContractAliasName());
	  entity.setGPreferredContractId(alias.getGPreferredContractId());
	  entity.setGfUserAuditId(auditId);
	  entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
	  entity.setgOperativeContractIndType(alias.getgOperativeContractIndType());
	  entity.setgVisibleContractIndType(alias.getgVisibleContractIndType());
	  return entity;
  }
  
  //T_KUSU_PROFCST_MLTX_CONTRACT
  public static ProfCstMltxContractEntity contractMtxFromMgmt(ProfCstMltxContractMgmtEntity contract, String auditId) {
	ProfCstMltxContractEntity entity = new ProfCstMltxContractEntity();
	entity.setGUserAccountId(contract.getGUserAccountId());
	entity.setGContractId(contract.getGContractId());
	entity.setgCustomerId(contract.getgCustomerId());
	entity.setGfSignatureLimitAmount(contract.getGfSignatureLimitAmount());
	entity.setGCurrencyId(contract.getGCurrencyId());
	entity.setGfSignatureWeightPer(contract.getGfSignatureWeightPer());
	entity.setGUserPermissionCtrctId(contract.getGUserPermissionCtrctId());
	entity.setGfUserAuditId(auditId);
	entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
	entity.setgOfflineDeleteIndType(contract.getgOfflineDeleteIndType());
	return entity;
  }
	
  //T_KUSU_PROFCST_MLTX_CONT_ROLE
  public static ProfCstMltxContRoleEntity roleContractFromMgmtMtx(ProfCstMltxContRoleMgmtEntity contractMtx, String auditId) {
	ProfCstMltxContRoleEntity entityMtx = new ProfCstMltxContRoleEntity();
	entityMtx.setGUserAccountId(contractMtx.getGUserAccountId());
	entityMtx.setGContractId(contractMtx.getGContractId());
	entityMtx.setgCustomerId(contractMtx.getgCustomerId());
	entityMtx.setGRecordSequentialId(contractMtx.getGRecordSequentialId());
	entityMtx.setGfSignatureLimitAmount(contractMtx.getGfSignatureLimitAmount());
	entityMtx.setGCurrencyId(contractMtx.getGCurrencyId());
	entityMtx.setGfSignatureWeightPer(contractMtx.getGfSignatureWeightPer());
	entityMtx.setGfUserRoleId(contractMtx.getGfUserRoleId());
	entityMtx.setGfUserCapabilityId(contractMtx.getGfUserCapabilityId());
	entityMtx.setGfSmcInternalId(contractMtx.getGfSmcInternalId());
	entityMtx.setgUserPermissionCtrctId(contractMtx.getgUserPermissionCtrctId());
	entityMtx.setGfUserAuditId(auditId);
	entityMtx.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
	entityMtx.setgOfflineDeleteIndType(contractMtx.getgOfflineDeleteIndType());
	return entityMtx;
  }
}
