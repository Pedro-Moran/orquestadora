package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProfileMultitaxCommons extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gCustomerId;
	private String gfUserRoleId;
	private String gfUserCapabilityId;
	private String gfSmcInternalId;
	private String gSpecificAttributeId;
	private String gSpecificAttributeDesc;
	private Date gfUserRoleStartDate;
	private String gUserProfAccessMethodType;
	private String gUserProfAccessMethodId;
	private String gAccessMethodStatusType;
	private String gUserSgntrSmcIndType;
	private String gUserPermissionSmcType;
	private BigDecimal gfSignatureWeightPer;
	private String gRecordUpdateType;
	private String gfUserRoleName;
	private String gfUserCapabilityName;
	private String gCapbCstmCtrctIndType;
	private String gSmcCstmCtrctIndType; 
	private BigDecimal gfSignatureLimitAmount;
	private String gCurrencyId;
	private String gSolProfBastanteoIndType;
	private String gUsrProfileAccMethIdType;
	private String gHoldingEntityId;
	private String gOfflineDeleteIndType;

	public String getgUsrProfileAccMethIdType() {
		return gUsrProfileAccMethIdType;
	}

	public void setgUsrProfileAccMethIdType(String gUsrProfileAccMethIdType) {
		this.gUsrProfileAccMethIdType = gUsrProfileAccMethIdType;
	}
	
	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	public String getGfUserRoleId() {
		return gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getGfUserCapabilityId() {
		return gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	public String getGfSmcInternalId() {
		return gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	public String getgSpecificAttributeId() {
		return gSpecificAttributeId;
	}

	public void setgSpecificAttributeId(String gSpecificAttributeId) {
		this.gSpecificAttributeId = gSpecificAttributeId;
	}

	public String getgSpecificAttributeDesc() {
		return gSpecificAttributeDesc;
	}

	public void setgSpecificAttributeDesc(String gSpecificAttributeDesc) {
		this.gSpecificAttributeDesc = gSpecificAttributeDesc;
	}

	public Date getGfUserRoleStartDate() {
		return gfUserRoleStartDate;
	}

	public void setGfUserRoleStartDate(Date gfUserRoleStartDate) {
		this.gfUserRoleStartDate = gfUserRoleStartDate;
	}

	public String getgUserProfAccessMethodType() {
		return gUserProfAccessMethodType;
	}

	public void setgUserProfAccessMethodType(String gUserProfAccessMethodType) {
		this.gUserProfAccessMethodType = gUserProfAccessMethodType;
	}

	public String getgUserProfAccessMethodId() {
		return gUserProfAccessMethodId;
	}

	public void setgUserProfAccessMethodId(String gUserProfAccessMethodId) {
		this.gUserProfAccessMethodId = gUserProfAccessMethodId;
	}

	public String getgAccessMethodStatusType() {
		return gAccessMethodStatusType;
	}

	public void setgAccessMethodStatusType(String gAccessMethodStatusType) {
		this.gAccessMethodStatusType = gAccessMethodStatusType;
	}

	public String getgUserSgntrSmcIndType() {
		return gUserSgntrSmcIndType;
	}

	public void setgUserSgntrSmcIndType(String gUserSgntrSmcIndType) {
		this.gUserSgntrSmcIndType = gUserSgntrSmcIndType;
	}

	public String getgUserPermissionSmcType() {
		return gUserPermissionSmcType;
	}

	public void setgUserPermissionSmcType(String gUserPermissionSmcType) {
		this.gUserPermissionSmcType = gUserPermissionSmcType;
	}

	public BigDecimal getGfSignatureWeightPer() {
		return gfSignatureWeightPer;
	}

	public void setGfSignatureWeightPer(BigDecimal gfSignatureWeightPer) {
		this.gfSignatureWeightPer = gfSignatureWeightPer;
	}

	public String getgRecordUpdateType() {
		return gRecordUpdateType;
	}

	public void setgRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	public String getGfUserRoleName() {
		return gfUserRoleName;
	}

	public void setGfUserRoleName(String gfUserRoleName) {
		this.gfUserRoleName = gfUserRoleName;
	}

	public String getGfUserCapabilityName() {
		return gfUserCapabilityName;
	}

	public void setGfUserCapabilityName(String gfUserCapabilityName) {
		this.gfUserCapabilityName = gfUserCapabilityName;
	}

	
	public String getgCapbCstmCtrctIndType() {
		return gCapbCstmCtrctIndType;
	}

	public void setgCapbCstmCtrctIndType(String gCapbCstmCtrctIndType) {
		this.gCapbCstmCtrctIndType = gCapbCstmCtrctIndType;
	}

	public String getgSmcCstmCtrctIndType() {
		return gSmcCstmCtrctIndType;
	}

	public void setgSmcCstmCtrctIndType(String gSmcCstmCtrctIndType) {
		this.gSmcCstmCtrctIndType = gSmcCstmCtrctIndType;
	}

	public BigDecimal getGfSignatureLimitAmount() {
		return gfSignatureLimitAmount;
	}

	public void setGfSignatureLimitAmount(BigDecimal gfSignatureLimitAmount) {
		this.gfSignatureLimitAmount = gfSignatureLimitAmount;
	}

	public String getgCurrencyId() {
		return gCurrencyId;
	}

	public void setgCurrencyId(String gCurrencyId) {
		this.gCurrencyId = gCurrencyId;
	}

	public String getgSolProfBastanteoIndType() {
		return gSolProfBastanteoIndType;
	}

	public void setgSolProfBastanteoIndType(String gSolProfBastanteoIndType) {
		this.gSolProfBastanteoIndType = gSolProfBastanteoIndType;
	}

	public String getHoldingEntityId() {
		return gHoldingEntityId;
	}

	public void setHoldingEntityId(String gHoldingEntityId) {
		this.gHoldingEntityId = gHoldingEntityId;
	}



	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "ProfileMultitaxCommons [gUserAccountId=" + gUserAccountId + ", gCustomerId=" + gCustomerId + ", gfUserRoleId=" + gfUserRoleId
				+ ", gfUserCapabilityId=" + gfUserCapabilityId + ", gfSmcInternalId=" + gfSmcInternalId + ", gSpecificAttributeId="
				+ gSpecificAttributeId + ", gSpecificAttributeDesc=" + gSpecificAttributeDesc + ", gfUserRoleStartDate=" + gfUserRoleStartDate
				+ ", gUserProfAccessMethodType=" + gUserProfAccessMethodType + ", gUserProfAccessMethodId=" + gUserProfAccessMethodId
				+ ", gAccessMethodStatusType=" + gAccessMethodStatusType + ", gUserSgntrSmcIndType=" + gUserSgntrSmcIndType
				+ ", gUserPermissionSmcType=" + gUserPermissionSmcType + ", gfSignatureWeightPer=" + gfSignatureWeightPer + ", gRecordUpdateType="
				+ gRecordUpdateType + ", gfUserRoleName=" + gfUserRoleName + ", gfUserCapabilityName=" + gfUserCapabilityName
				+ ", gCapbCstmCtrctIndType=" + gCapbCstmCtrctIndType + ", gSmcCstmCtrctIndType=" + gSmcCstmCtrctIndType + ", gfSignatureLimitAmount="
				+ gfSignatureLimitAmount + ", gCurrencyId=" + gCurrencyId + ", gSolProfBastanteoIndType=" + gSolProfBastanteoIndType 
				+ ", gUsrProfileAccMethIdType=" + gUsrProfileAccMethIdType + ", gHoldingEntityId=" + gHoldingEntityId
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}
	
}
