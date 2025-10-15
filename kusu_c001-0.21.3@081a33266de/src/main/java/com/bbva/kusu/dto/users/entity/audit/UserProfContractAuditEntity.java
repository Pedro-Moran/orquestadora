package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class UserProfContractAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "g_contract_id")
	private String contractId;
	
	@SerializedName(value = "g_record_sequential_id")
	private String recordSequentialId;
	
	@SerializedName(value = "gf_signature_limit_amount")
	private String signatureLimitAmount;
	
	@SerializedName(value = "g_currency_id")
	private String currencyId;
	
	@SerializedName(value = "gf_signature_weight_per")
	private String signatureWeightPer;
	
	@SerializedName(value = "gf_user_role_id")
	private String userRoleId;
	
	@SerializedName(value = "gf_user_capability_id")
	private String userCapabilityId;
	
	@SerializedName(value = "gf_contract_alias_name")
	private String contractAliasName;
	
	@SerializedName(value = "g_preferred_contract_id")
	private String preferredContractId;
	
	@SerializedName(value = "g_record_update_type")
	private String recordUpdateType;
	
	@SerializedName(value = "gf_user_audit_id")
	private String userAuditId;
	
	@SerializedName(value = "gf_audit_date")
	private String auditDate;

	@SerializedName(value = "g_user_permission_ctrct_id")
	private String userPermissionCtrctId;
	
	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getRecordSequentialId() {
		return recordSequentialId;
	}

	public void setRecordSequentialId(String recordSequentialId) {
		this.recordSequentialId = recordSequentialId;
	}

	public String getSignatureLimitAmount() {
		return signatureLimitAmount;
	}

	public void setSignatureLimitAmount(String signatureLimitAmount) {
		this.signatureLimitAmount = signatureLimitAmount;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getSignatureWeightPer() {
		return signatureWeightPer;
	}

	public void setSignatureWeightPer(String signatureWeightPer) {
		this.signatureWeightPer = signatureWeightPer;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserCapabilityId() {
		return userCapabilityId;
	}

	public void setUserCapabilityId(String userCapabilityId) {
		this.userCapabilityId = userCapabilityId;
	}

	public String getContractAliasName() {
		return contractAliasName;
	}

	public void setContractAliasName(String contractAliasName) {
		this.contractAliasName = contractAliasName;
	}

	public String getPreferredContractId() {
		return preferredContractId;
	}

	public void setPreferredContractId(String preferredContractId) {
		this.preferredContractId = preferredContractId;
	}

	public String getRecordUpdateType() {
		return recordUpdateType;
	}

	public void setRecordUpdateType(String recordUpdateType) {
		this.recordUpdateType = recordUpdateType;
	}

	public String getUserAuditId() {
		return userAuditId;
	}

	public void setUserAuditId(String userAuditId) {
		this.userAuditId = userAuditId;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public String getUserPermissionCtrctId() {
		return userPermissionCtrctId;
	}

	public void setUserPermissionCtrctId(String userPermissionCtrctId) {
		this.userPermissionCtrctId = userPermissionCtrctId;
	}

	@Override
	public String toString() {
		return "UserProfContractAuditEntity [contractId=" + contractId + ", recordSequentialId=" + recordSequentialId
				+ ", signatureLimitAmount=" + signatureLimitAmount + ", currencyId=" + currencyId
				+ ", signatureWeightPer=" + signatureWeightPer + ", userRoleId=" + userRoleId + ", userCapabilityId="
				+ userCapabilityId + ", contractAliasName=" + contractAliasName + ", preferredContractId="
				+ preferredContractId + ", recordUpdateType=" + recordUpdateType + ", userAuditId=" + userAuditId
				+ ", auditDate=" + auditDate + ", userPermissionCtrctId=" + userPermissionCtrctId + "]";
	}
}
