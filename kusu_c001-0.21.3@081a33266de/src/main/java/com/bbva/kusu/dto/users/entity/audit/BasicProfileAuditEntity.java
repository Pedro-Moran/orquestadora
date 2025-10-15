package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class BasicProfileAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "g_person_role_type")
	private String personRoleType;
	
	@SerializedName(value = "g_role_person_id")
	private String rolePersonId;
	
	@SerializedName(value = "gf_user_start_date")
	private Date userStartDate;
	
	@SerializedName(value = "g_user_status_type")
	private String userStatusType;
	
	@SerializedName(value = "gf_user_change_status_date")
	private Date userChangeStatusDate;
	
	@SerializedName(value = "g_user_profile_id")
	private String userProfileId;
	
	@SerializedName(value = "g_category_profile_type")
	private String categoryProfileType;
	
	@SerializedName(value = "gf_signature_weight_per")
	private BigDecimal signatureWeightPer;
	
	@SerializedName(value = "gf_signature_limit_amount")
	private BigDecimal signatureLimitAmount;
	
	@SerializedName(value = "g_currency_id")
	private String currencyId;
	
	@SerializedName(value = "g_phone_type")
	private String phoneTypeProf;
	
	@SerializedName(value = "g_prefix_phone_id")
	private String prefixPhoneIdProf;
	
	@SerializedName(value = "gf_extension_phone_id")
	private String extensionPhoneIdProf;
	
	@SerializedName(value = "gf_phone_id")
	private String phoneIdProf;
	
	@SerializedName(value = "gf_contact_chan_validity_type")
	private String contactChanValidityType;
	
	@SerializedName(value = "gf_user_validation_weight_per")
	private BigDecimal userValidationWeightPer;
	
	@SerializedName(value = "g_user_custom_role_ind_type")
	private String userCustomRoleIndType;
	
	@SerializedName(value = "g_user_custom_ctrct_ind_type")
	private String userCustomCtrctIndType;
	
	@SerializedName(value = "g_updated_usr_profile_ind_type")
	private String updatedUsrProfileIndType;
	
	@SerializedName(value = "g_record_update_type")
	private String recordUpdateTypeId;
	
	@SerializedName(value = "g_user_mgmt_master_ind_type")
	private String userMgmtMasterIndType;
	
	@SerializedName(value = "gf_user_audit_id")
	private String userAuditId;
	
	@SerializedName(value = "gf_audit_date")
	private Timestamp auditDate;

	public String getPersonRoleType() {
		return personRoleType;
	}

	public void setPersonRoleType(String personRoleType) {
		this.personRoleType = personRoleType;
	}

	public String getRolePersonId() {
		return rolePersonId;
	}

	public void setRolePersonId(String rolePersonId) {
		this.rolePersonId = rolePersonId;
	}
	
	public Date getUserStartDate() {
		return userStartDate;
	}

	public void setUserStartDate(Date userStartDate) {
		this.userStartDate = userStartDate;
	}

	public String getUserStatusType() {
		return userStatusType;
	}

	public void setUserStatusType(String userStatusType) {
		this.userStatusType = userStatusType;
	}

	public Date getUserChangeStatusDate() {
		return userChangeStatusDate;
	}

	public void setUserChangeStatusDate(Date userChangeStatusDate) {
		this.userChangeStatusDate = userChangeStatusDate;
	}

	public String getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(String userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getCategoryProfileType() {
		return categoryProfileType;
	}

	public void setCategoryProfileType(String categoryProfileType) {
		this.categoryProfileType = categoryProfileType;
	}

	public BigDecimal getSignatureWeightPer() {
		return signatureWeightPer;
	}

	public void setSignatureWeightPer(BigDecimal signatureWeightPer) {
		this.signatureWeightPer = signatureWeightPer;
	}

	public BigDecimal getSignatureLimitAmount() {
		return signatureLimitAmount;
	}

	public void setSignatureLimitAmount(BigDecimal signatureLimitAmount) {
		this.signatureLimitAmount = signatureLimitAmount;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getPhoneTypeProf() {
		return phoneTypeProf;
	}

	public void setPhoneTypeProf(String phoneTypeProf) {
		this.phoneTypeProf = phoneTypeProf;
	}

	public String getPrefixPhoneIdProf() {
		return prefixPhoneIdProf;
	}

	public void setPrefixPhoneIdProf(String prefixPhoneIdProf) {
		this.prefixPhoneIdProf = prefixPhoneIdProf;
	}

	public String getExtensionPhoneIdProf() {
		return extensionPhoneIdProf;
	}

	public void setExtensionPhoneIdProf(String extensionPhoneIdProf) {
		this.extensionPhoneIdProf = extensionPhoneIdProf;
	}

	public String getPhoneIdProf() {
		return phoneIdProf;
	}

	public void setPhoneIdProf(String phoneIdProf) {
		this.phoneIdProf = phoneIdProf;
	}

	public String getContactChanValidityType() {
		return contactChanValidityType;
	}

	public void setContactChanValidityType(String contactChanValidityType) {
		this.contactChanValidityType = contactChanValidityType;
	}

	public BigDecimal getUserValidationWeightPer() {
		return userValidationWeightPer;
	}

	public void setUserValidationWeightPer(BigDecimal userValidationWeightPer) {
		this.userValidationWeightPer = userValidationWeightPer;
	}

	public String getUserCustomRoleIndType() {
		return userCustomRoleIndType;
	}

	public void setUserCustomRoleIndType(String userCustomRoleIndType) {
		this.userCustomRoleIndType = userCustomRoleIndType;
	}

	public String getUserCustomCtrctIndType() {
		return userCustomCtrctIndType;
	}

	public void setUserCustomCtrctIndType(String userCustomCtrctIndType) {
		this.userCustomCtrctIndType = userCustomCtrctIndType;
	}

	public String getUpdatedUsrProfileIndType() {
		return updatedUsrProfileIndType;
	}

	public void setUpdatedUsrProfileIndType(String updatedUsrProfileIndType) {
		this.updatedUsrProfileIndType = updatedUsrProfileIndType;
	}

	public String getRecordUpdateTypeId() {
		return recordUpdateTypeId;
	}

	public void setRecordUpdateTypeId(String recordUpdateTypeId) {
		this.recordUpdateTypeId = recordUpdateTypeId;
	}

	public String getUserAuditId() {
		return userAuditId;
	}

	public void setUserAuditId(String userAuditId) {
		this.userAuditId = userAuditId;
	}

	public Timestamp getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getUserMgmtMasterIndType() {
		return userMgmtMasterIndType;
	}

	public void setUserMgmtMasterIndType(String userMgmtMasterIndType) {
		this.userMgmtMasterIndType = userMgmtMasterIndType;
	}

	@Override
	public String toString() {
		return "BasicProfileAuditEntity [personRoleType=" + personRoleType + ", rolePersonId=" + rolePersonId
				+ ", userStartDate=" + userStartDate + ", userStatusType=" + userStatusType + ", userChangeStatusDate="
				+ userChangeStatusDate + ", userProfileId=" + userProfileId + ", categoryProfileType="
				+ categoryProfileType + ", signatureWeightPer=" + signatureWeightPer + ", signatureLimitAmount="
				+ signatureLimitAmount + ", currencyId=" + currencyId + ", phoneTypeProf=" + phoneTypeProf
				+ ", prefixPhoneIdProf=" + prefixPhoneIdProf + ", extensionPhoneIdProf=" + extensionPhoneIdProf
				+ ", phoneIdProf=" + phoneIdProf + ", contactChanValidityType=" + contactChanValidityType
				+ ", userValidationWeightPer=" + userValidationWeightPer + ", userCustomRoleIndType="
				+ userCustomRoleIndType + ", userCustomCtrctIndType=" + userCustomCtrctIndType
				+ ", updatedUsrProfileIndType=" + updatedUsrProfileIndType + ", recordUpdateTypeId="
				+ recordUpdateTypeId + ", userMgmtMasterIndType=" + userMgmtMasterIndType + ", userAuditId="
				+ userAuditId + ", auditDate=" + auditDate + "]";
	}

}
