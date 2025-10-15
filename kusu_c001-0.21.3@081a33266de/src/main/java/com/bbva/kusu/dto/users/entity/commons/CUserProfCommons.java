package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CUserProfCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gUserId;
	private String gfUserAuditId;
	private String gUserAccountId;
	private Date gfUserStartDate;
	private String gCustomerId;
	private String gPersonRoleType;
	private String gRolePersonId;
	private Date gfUserChangeStatusDate;
	private String gUserStatusType;
	private String gCategoryProfileType;
	private String gUserProfileId;
	private BigDecimal gfSignatureLimitAmount;
	private BigDecimal gfSignatureWeightPer;
	private BigDecimal gfUserValidationWeightPer;
	private String gCurrencyId;
	private String gPhoneType;
	private String gPrefixPhoneId;
	private String gfExtensionPhoneId;
	private String gfContactChanValidityType;
	private String gfPhoneId;
	private Timestamp gfAuditDate;
	private String gCustomMultitaxIndType;
	private String gCstMultitaxRoleIndType;
	private String gCstMultitaxCtrctIndType;
	private String gCstExtCtrctIndType;
	private String gSolProfBastanteoIndType;
	private String gProfOperativeModeType;
	private String gCstMltxExtCtrctIndType;
	private String gUserProfileGroupId;
	private String gUserProfileGroupType;
	private String gAuthMechanismCstmIndType;
	private String gAdminSmcPackageIndType;
	private String gOfflineDeleteIndType;
	private String gfLocalUserAccountId;
	private String gRelatedSmcPackageId;
	private String gApplyBastanteoSmcIndType;

	public String getGUserId() {
		return this.gUserId;
	}

	public void setGUserId(String gUserId) {
		this.gUserId = gUserId;
	}

	public String getGfUserAuditId() {
		return this.gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public String getGPersonRoleType() {
		return gPersonRoleType;
	}

	public void setGPersonRoleType(String gPersonRoleType) {
		this.gPersonRoleType = gPersonRoleType;
	}

	public String getGRolePersonId() {
		return gRolePersonId;
	}

	public void setGRolePersonId(String gRolePersonId) {
		this.gRolePersonId = gRolePersonId;
	}

	public Date getGfUserStartDate() {
		return this.gfUserStartDate;
	}

	public void setGfUserStartDate(Date gfUserStartDate) {
		this.gfUserStartDate = gfUserStartDate;
	}

	public String getGUserStatusType() {
		return this.gUserStatusType;
	}

	public void setGUserStatusType(String gUserStatusType) {
		this.gUserStatusType = gUserStatusType;
	}

	public Date getGfUserChangeStatusDate() {
		return this.gfUserChangeStatusDate;
	}

	public void setGfUserChangeStatusDate(Date gfUserChangeStatusDate) {
		this.gfUserChangeStatusDate = gfUserChangeStatusDate;
	}

	public String getGCategoryProfileType() {
		return this.gCategoryProfileType;
	}

	public void setGCategoryProfileType(String gCategoryProfileType) {
		this.gCategoryProfileType = gCategoryProfileType;
	}

	public String getGUserProfileId() {
		return this.gUserProfileId;
	}

	public void setGUserProfileId(String gUserProfileId) {
		this.gUserProfileId = gUserProfileId;
	}

	public BigDecimal getGfSignatureWeightPer() {
		return this.gfSignatureWeightPer;
	}

	public void setGfSignatureWeightPer(BigDecimal gfSignatureWeightPer) {
		this.gfSignatureWeightPer = gfSignatureWeightPer;
	}

	public BigDecimal getGfSignatureLimitAmount() {
		return this.gfSignatureLimitAmount;
	}

	public void setGfSignatureLimitAmount(BigDecimal gfSignatureLimitAmount) {
		this.gfSignatureLimitAmount = gfSignatureLimitAmount;
	}

	public String getGCurrencyId() {
		return this.gCurrencyId;
	}

	public void setGCurrencyId(String gCurrencyId) {
		this.gCurrencyId = gCurrencyId;
	}

	public BigDecimal getGfUserValidationWeightPer() {
		return this.gfUserValidationWeightPer;
	}

	public void setGfUserValidationWeightPer(BigDecimal gfUserValidationWeightPer) {
		this.gfUserValidationWeightPer = gfUserValidationWeightPer;
	}

	public Timestamp getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getGPrefixPhoneId() {
		return this.gPrefixPhoneId;
	}

	public void setGPrefixPhoneId(String gPrefixPhoneId) {
		this.gPrefixPhoneId = gPrefixPhoneId;
	}

	public String getGPhoneType() {
		return this.gPhoneType;
	}

	public void setGPhoneType(String gPhoneType) {
		this.gPhoneType = gPhoneType;
	}

	public String getGfPhoneId() {
		return this.gfPhoneId;
	}

	public void setGfPhoneId(String gfPhoneId) {
		this.gfPhoneId = gfPhoneId;
	}

	public String getGfExtensionPhoneId() {
		return this.gfExtensionPhoneId;
	}

	public void setGfExtensionPhoneId(String gfExtensionPhoneId) {
		this.gfExtensionPhoneId = gfExtensionPhoneId;
	}

	public String getGfContactChanValidityType() {
		return this.gfContactChanValidityType;
	}

	public void setGfContactChanValidityType(String gfContactChanValidityType) {
		this.gfContactChanValidityType = gfContactChanValidityType;
	}

	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGCustomerId() {
		return gCustomerId;
	}

	public void setGCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	public String getgCustomMultitaxIndType() {
		return gCustomMultitaxIndType;
	}

	public void setgCustomMultitaxIndType(String gCustomMultitaxIndType) {
		this.gCustomMultitaxIndType = gCustomMultitaxIndType;
	}

	public String getgCstMultitaxRoleIndType() {
		return gCstMultitaxRoleIndType;
	}

	public void setgCstMultitaxRoleIndType(String gCstMultitaxRoleIndType) {
		this.gCstMultitaxRoleIndType = gCstMultitaxRoleIndType;
	}

	public String getgCstExtCtrctIndType() {
		return gCstExtCtrctIndType;
	}

	public void setgCstExtCtrctIndType(String gCstExtCtrctIndType) {
		this.gCstExtCtrctIndType = gCstExtCtrctIndType;
	}

	public String getgCstMultitaxCtrctIndType() {
		return gCstMultitaxCtrctIndType;
	}

	public void setgCstMultitaxCtrctIndType(String gCstMultitaxCtrctIndType) {
		this.gCstMultitaxCtrctIndType = gCstMultitaxCtrctIndType;
	}

	public String getgSolProfBastanteoIndType() {
		return gSolProfBastanteoIndType;
	}

	public void setgSolProfBastanteoIndType(String gSolProfBastanteoIndType) {
		this.gSolProfBastanteoIndType = gSolProfBastanteoIndType;
	}

	public String getgProfOperativeModeType() {
		return gProfOperativeModeType;
	}

	public void setgProfOperativeModeType(String gProfOperativeModeType) {
		this.gProfOperativeModeType = gProfOperativeModeType;
	}

	public String getgCstMltxExtCtrctIndType() {
		return gCstMltxExtCtrctIndType;
	}

	public void setgCstMltxExtCtrctIndType(String gCstMltxExtCtrctIndType) {
		this.gCstMltxExtCtrctIndType = gCstMltxExtCtrctIndType;
	}

	public String getgUserProfileGroupId() {
		return gUserProfileGroupId;
	}

	public void setgUserProfileGroupId(String gUserProfileGroupId) {
		this.gUserProfileGroupId = gUserProfileGroupId;
	}

	public String getgUserProfileGroupType() {
		return gUserProfileGroupType;
	}

	public void setgUserProfileGroupType(String gUserProfileGroupType) {
		this.gUserProfileGroupType = gUserProfileGroupType;
	}

	public String getgAuthMechanismCstmIndType() {
		return gAuthMechanismCstmIndType;
	}

	public void setgAuthMechanismCstmIndType(String gAuthMechanismCstmIndType) {
		this.gAuthMechanismCstmIndType = gAuthMechanismCstmIndType;
	}

	public String getgAdminSmcPackageIndType() {
		return gAdminSmcPackageIndType;
	}

	public void setgAdminSmcPackageIndType(String gAdminSmcPackageIndType) {
		this.gAdminSmcPackageIndType = gAdminSmcPackageIndType;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	public String getGfLocalUserAccountId() {
		return gfLocalUserAccountId;
	}

	public void setGfLocalUserAccountId(String gfLocalUserAccountId) {
		this.gfLocalUserAccountId = gfLocalUserAccountId;
	}

	public String getgRelatedSmcPackageId() {
		return gRelatedSmcPackageId;
	}

	public void setgRelatedSmcPackageId(String gRelatedSmcPackageId) {
		this.gRelatedSmcPackageId = gRelatedSmcPackageId;
	}

	public String getgApplyBastanteoSmcIndType() {
		return gApplyBastanteoSmcIndType;
	}

	public void setgApplyBastanteoSmcIndType(String gApplyBastanteoSmcIndType) {
		this.gApplyBastanteoSmcIndType = gApplyBastanteoSmcIndType;
	}

	@Override
	public String toString() {
		return "CUserProfCommons{" +
				"gUserId='" + gUserId + '\'' +
				", gfUserAuditId='" + gfUserAuditId + '\'' +
				", gUserAccountId='" + gUserAccountId + '\'' +
				", gfUserStartDate=" + gfUserStartDate +
				", gCustomerId='" + gCustomerId + '\'' +
				", gPersonRoleType='" + gPersonRoleType + '\'' +
				", gRolePersonId='" + gRolePersonId + '\'' +
				", gfUserChangeStatusDate=" + gfUserChangeStatusDate +
				", gUserStatusType='" + gUserStatusType + '\'' +
				", gCategoryProfileType='" + gCategoryProfileType + '\'' +
				", gUserProfileId='" + gUserProfileId + '\'' +
				", gfSignatureLimitAmount=" + gfSignatureLimitAmount +
				", gfSignatureWeightPer=" + gfSignatureWeightPer +
				", gfUserValidationWeightPer=" + gfUserValidationWeightPer +
				", gCurrencyId='" + gCurrencyId + '\'' +
				", gPhoneType='" + gPhoneType + '\'' +
				", gPrefixPhoneId='" + gPrefixPhoneId + '\'' +
				", gfExtensionPhoneId='" + gfExtensionPhoneId + '\'' +
				", gfContactChanValidityType='" + gfContactChanValidityType + '\'' +
				", gfPhoneId='" + gfPhoneId + '\'' +
				", gfAuditDate=" + gfAuditDate +
				", gCustomMultitaxIndType='" + gCustomMultitaxIndType + '\'' +
				", gCstMultitaxRoleIndType='" + gCstMultitaxRoleIndType + '\'' +
				", gCstMultitaxCtrctIndType='" + gCstMultitaxCtrctIndType + '\'' +
				", gCstExtCtrctIndType='" + gCstExtCtrctIndType + '\'' +
				", gSolProfBastanteoIndType='" + gSolProfBastanteoIndType + '\'' +
				", gProfOperativeModeType='" + gProfOperativeModeType + '\'' +
				", gCstMltxExtCtrctIndType='" + gCstMltxExtCtrctIndType + '\'' +
				", gUserProfileGroupId='" + gUserProfileGroupId + '\'' +
				", gUserProfileGroupType='" + gUserProfileGroupType + '\'' +
				", gAuthMechanismCstmIndType='" + gAuthMechanismCstmIndType + '\'' +
				", gAdminSmcPackageIndType='" + gAdminSmcPackageIndType + '\'' +
				", gOfflineDeleteIndType='" + gOfflineDeleteIndType + '\'' +
				", gfLocalUserAccountId='" + gfLocalUserAccountId + '\'' +
				", gRelatedSmcPackageId='" + gRelatedSmcPackageId + '\'' +
				", gApplyBastanteoSmcIndType='" + gApplyBastanteoSmcIndType + '\'' +
				'}';
	}
}
