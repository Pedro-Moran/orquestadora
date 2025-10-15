package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class ExternalContractCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gContractNonBbvaId;
	private BigDecimal gRecordSequentialId;
	private BigDecimal gfSignatureLimitAmount;
	private String gCurrencyId;
	private BigDecimal gfSignatureWeightPer;
	private String gfUserRoleId;
	private String gfUserCapabilityId;
	private String gfSmcInternalId;
	private String gUserPermissionCtrctId;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;
	private String gUserMgmtOperationType;
	private String gfContractAliasName;
	private BigDecimal gPreferredContractId;
	private String gOfflineDeleteIndType;
	private String gOperativeContractIndType;
	private String gVisibleContractIndType;
	
	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgContractNonBbvaId() {
		return gContractNonBbvaId;
	}

	public void setgContractNonBbvaId(String gContractNonBbvaId) {
		this.gContractNonBbvaId = gContractNonBbvaId;
	}

	public BigDecimal getgRecordSequentialId() {
		return gRecordSequentialId;
	}

	public void setgRecordSequentialId(BigDecimal gRecordSequentialId) {
		this.gRecordSequentialId = gRecordSequentialId;
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

	public BigDecimal getGfSignatureWeightPer() {
		return gfSignatureWeightPer;
	}

	public void setGfSignatureWeightPer(BigDecimal gfSignatureWeightPer) {
		this.gfSignatureWeightPer = gfSignatureWeightPer;
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

	public String getgUserPermissionCtrctId() {
		return gUserPermissionCtrctId;
	}

	public void setgUserPermissionCtrctId(String gUserPermissionCtrctId) {
		this.gUserPermissionCtrctId = gUserPermissionCtrctId;
	}

	public String getGfUserAuditId() {
		return gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getgUserMgmtOperationType() {
		return gUserMgmtOperationType;
	}

	public void setgUserMgmtOperationType(String gUserMgmtOperationType) {
		this.gUserMgmtOperationType = gUserMgmtOperationType;
	}

	public String getGfContractAliasName() {
		return gfContractAliasName;
	}

	public void setGfContractAliasName(String gfContractAliasName) {
		this.gfContractAliasName = gfContractAliasName;
	}

	public BigDecimal getgPreferredContractId() {
		return gPreferredContractId;
	}

	public void setgPreferredContractId(BigDecimal gPreferredContractId) {
		this.gPreferredContractId = gPreferredContractId;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	public String getgOperativeContractIndType() {
		return gOperativeContractIndType;
	}

	public void setgOperativeContractIndType(String gOperativeContractIndType) {
		this.gOperativeContractIndType = gOperativeContractIndType;
	}

	public String getgVisibleContractIndType() {
		return gVisibleContractIndType;
	}

	public void setgVisibleContractIndType(String gVisibleContractIndType) {
		this.gVisibleContractIndType = gVisibleContractIndType;
	}

	@Override
	public String toString() {
		return "ExternalContractCommons [gUserAccountId=" + gUserAccountId + ", gContractNonBbvaId=" + gContractNonBbvaId + ", gRecordSequentialId="
				+ gRecordSequentialId + ", gfSignatureLimitAmount=" + gfSignatureLimitAmount + ", gCurrencyId=" + gCurrencyId
				+ ", gfSignatureWeightPer=" + gfSignatureWeightPer + ", gfUserRoleId=" + gfUserRoleId + ", gfUserCapabilityId=" + gfUserCapabilityId
				+ ", gfSmcInternalId=" + gfSmcInternalId + ", gUserPermissionCtrctId=" + gUserPermissionCtrctId + ", gfUserAuditId=" + gfUserAuditId
				+ ", gfAuditDate=" + gfAuditDate + ", gUserMgmtOperationType=" + gUserMgmtOperationType + ", gfContractAliasName="
				+ gfContractAliasName + ", gPreferredContractId=" + gPreferredContractId + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType
				+ ", gOperativeContractIndType=" + gOperativeContractIndType + ", gVisibleContractIndType=" + gVisibleContractIndType + "]";
	}

}