package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class UserProfAuthAtrb implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "g_phone_type")
	private String phoneType;

	@SerializedName(value = "g_prefix_phone_id")
	private String prefixPhoneId;

	@SerializedName(value = "gf_phone_id")
	private String phoneId;

	@SerializedName(value = "g_phone_verified_ind_type")
	private String phoneVerifiedIndType;

	@SerializedName(value = "gf_email_desc")
	private String emailDesc;

	@SerializedName(value = "gf_email_verified_type")
	private String emailVerifiedType;

	@SerializedName(value = "gf_double_factor_last_acc_date")
	private String doubleFactorLastAccDate;

	@SerializedName(value = "g_record_update_type")
	private String recordUpdateType;

	@SerializedName(value = "gf_user_audit_id")
	private String userAuditId;

	@SerializedName(value = "gf_audit_date")
	private String auditDate;

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPrefixPhoneId() {
		return prefixPhoneId;
	}

	public void setPrefixPhoneId(String prefixPhoneId) {
		this.prefixPhoneId = prefixPhoneId;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneVerifiedIndType() {
		return phoneVerifiedIndType;
	}

	public void setPhoneVerifiedIndType(String phoneVerifiedIndType) {
		this.phoneVerifiedIndType = phoneVerifiedIndType;
	}

	public String getEmailDesc() {
		return emailDesc;
	}

	public void setEmailDesc(String emailDesc) {
		this.emailDesc = emailDesc;
	}

	public String getEmailVerifiedType() {
		return emailVerifiedType;
	}

	public void setEmailVerifiedType(String emailVerifiedType) {
		this.emailVerifiedType = emailVerifiedType;
	}

	public String getDoubleFactorLastAccDate() {
		return doubleFactorLastAccDate;
	}

	public void setDoubleFactorLastAccDate(String doubleFactorLastAccDate) {
		this.doubleFactorLastAccDate = doubleFactorLastAccDate;
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

	@Override
	public String toString() {
		return "UserProfAuthAtrb [phoneType=" + phoneType + ", prefixPhoneId=" + prefixPhoneId + ", phoneId=" + phoneId
				+ ", phoneVerifiedIndType=" + phoneVerifiedIndType + ", emailDesc=" + emailDesc + ", emailVerifiedType="
				+ emailVerifiedType + ", doubleFactorLastAccDate=" + doubleFactorLastAccDate + ", recordUpdateType="
				+ recordUpdateType + ", userAuditId=" + userAuditId + ", auditDate=" + auditDate + "]";
	}

}
