package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class UserProfRoleAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "gf_user_role_id")
	private String userRoleId;
	
	@SerializedName(value = "gf_user_role_start_date")
	private String userRoleStartDate;
    
	@SerializedName(value = "gf_user_capability_id")
	private String userCapabilityId;
    
	@SerializedName(value = "gf_smc_internal_id")
	private String smcInternalId;
    
	@SerializedName(value = "g_user_sgntr_smc_ind_type")
	private String userSgntrSmcIndType;
    
	@SerializedName(value = "g_specific_attribute_id")
	private String specificAttributeId;
	
	@SerializedName(value = "g_record_update_type")
	private String rcdUpdateType;
	
	@SerializedName(value = "gf_user_audit_id")
	private String usrAuditId;
	
	@SerializedName(value = "gf_audit_date")
	private String auditDte;

	@SerializedName(value = "gf_signature_weight_per")
	private String signatureWeightPer;
	
	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleStartDate() {
		return userRoleStartDate;
	}

	public void setUserRoleStartDate(String userRoleStartDate) {
		this.userRoleStartDate = userRoleStartDate;
	}

	public String getUserCapabilityId() {
		return userCapabilityId;
	}

	public void setUserCapabilityId(String userCapabilityId) {
		this.userCapabilityId = userCapabilityId;
	}

	public String getSmcInternalId() {
		return smcInternalId;
	}

	public void setSmcInternalId(String smcInternalId) {
		this.smcInternalId = smcInternalId;
	}

	public String getUserSgntrSmcIndType() {
		return userSgntrSmcIndType;
	}

	public void setUserSgntrSmcIndType(String userSgntrSmcIndType) {
		this.userSgntrSmcIndType = userSgntrSmcIndType;
	}

	public String getSpecificAttributeId() {
		return specificAttributeId;
	}

	public void setSpecificAttributeId(String specificAttributeId) {
		this.specificAttributeId = specificAttributeId;
	}

	public String getRcdUpdateType() {
		return rcdUpdateType;
	}

	public void setRcdUpdateType(String rcdUpdateType) {
		this.rcdUpdateType = rcdUpdateType;
	}

	public String getUsrAuditId() {
		return usrAuditId;
	}

	public void setUsrAuditId(String usrAuditId) {
		this.usrAuditId = usrAuditId;
	}

	public String getAuditDte() {
		return auditDte;
	}

	public void setAuditDte(String auditDte) {
		this.auditDte = auditDte;
	}

	public String getSignatureWeightPer() {
		return signatureWeightPer;
	}

	public void setSignatureWeightPer(String signatureWeightPer) {
		this.signatureWeightPer = signatureWeightPer;
	}

	@Override
	public String toString() {
		return "UserProfRoleAuditEntity [userRoleId=" + userRoleId + ", userRoleStartDate=" + userRoleStartDate
				+ ", userCapabilityId=" + userCapabilityId + ", smcInternalId=" + smcInternalId
				+ ", userSgntrSmcIndType=" + userSgntrSmcIndType + ", specificAttributeId=" + specificAttributeId
				+ ", rcdUpdateType=" + rcdUpdateType + ", usrAuditId=" + usrAuditId + ", auditDte=" + auditDte
				+ ", signatureWeightPer=" + signatureWeightPer + "]";
	}

}
