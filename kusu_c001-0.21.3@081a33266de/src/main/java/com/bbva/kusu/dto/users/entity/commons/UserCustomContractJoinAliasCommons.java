package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserCustomContractJoinAliasCommons extends RoleCapabilitySmcidsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gContractId;

	private String gUserAccountId;

	private BigDecimal gfSignatureLimitAmount;

	private String gCurrencyId;

	private BigDecimal gfSignatureWeightPer;

	private String gfUserAuditId;

	private Date gfAuditDate;

	private BigDecimal gRecordSequentialId;

	private String gfContractAliasName;

	private BigDecimal gPreferredContractId;

	private BigDecimal gfSignatureLimitAmountRole;

	private String gCurrencyIdRole;

	private BigDecimal gfSignatureWeightPerRole;

	private String gCustomerId;
	
	private String gOfflineDeleteIndType;
	
	private String gOperativeContractIndType;
	
	private String gVisibleContractIndType;

	public String getGContractId() {
		return this.gContractId;
	}

	public void setGContractId(String gContractId) {
		this.gContractId = gContractId;
	}

	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public BigDecimal getGfSignatureLimitAmount() {
		return this.gfSignatureLimitAmount;
	}

	public void setGfSignatureLimitAmount(BigDecimal gfSignatureLimitAmount) {
		this.gfSignatureLimitAmount = gfSignatureLimitAmount;
	}

	public BigDecimal getGRecordSequentialId() {
		return this.gRecordSequentialId;
	}

	public void setGRecordSequentialId(BigDecimal gRecordSequentialId) {
		this.gRecordSequentialId = gRecordSequentialId;
	}

	public String getGCurrencyId() {
		return this.gCurrencyId;
	}

	public void setGCurrencyId(String gCurrencyId) {
		this.gCurrencyId = gCurrencyId;
	}

	public BigDecimal getGfSignatureWeightPer() {
		return this.gfSignatureWeightPer;
	}

	public void setGfSignatureWeightPer(BigDecimal gfSignatureWeightPer) {
		this.gfSignatureWeightPer = gfSignatureWeightPer;
	}

	public String getGfUserAuditId() {
		return this.gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Date getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Date gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getGfContractAliasName() {
		return this.gfContractAliasName;
	}

	public void setGfContractAliasName(String gfContractAliasName) {
		this.gfContractAliasName = gfContractAliasName;
	}

	public BigDecimal getgPreferredContractId() {
		return this.gPreferredContractId;
	}

	public void setgPreferredContractId(BigDecimal gPreferredContractId) {
		this.gPreferredContractId = gPreferredContractId;
	}

	public BigDecimal getGfSignatureLimitAmountRole() {
		return this.gfSignatureLimitAmountRole;
	}

	public void setGfSignatureLimitAmountRole(BigDecimal gfSignatureLimitAmountRole) {
		this.gfSignatureLimitAmountRole = gfSignatureLimitAmountRole;
	}

	public String getGCurrencyIdRole() {
		return this.gCurrencyIdRole;
	}

	public void setGCurrencyIdRole(String gCurrencyIdRole) {
		this.gCurrencyIdRole = gCurrencyIdRole;
	}

	public BigDecimal getGfSignatureWeightPerRole() {
		return this.gfSignatureWeightPerRole;
	}

	public void setGfSignatureWeightPerRole(BigDecimal gfSignatureWeightPerRole) {
		this.gfSignatureWeightPerRole = gfSignatureWeightPerRole;
	}

	public String getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
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
		return "UserCustomContractJoinAliasCommons [gContractId=" + gContractId + ", gUserAccountId=" + gUserAccountId
				+ ", gfSignatureLimitAmount=" + gfSignatureLimitAmount + ", gCurrencyId=" + gCurrencyId
				+ ", gfSignatureWeightPer=" + gfSignatureWeightPer + ", gfUserAuditId=" + gfUserAuditId
				+ ", gfAuditDate=" + gfAuditDate + ", gRecordSequentialId=" + gRecordSequentialId
				+ ", gfContractAliasName=" + gfContractAliasName + ", gPreferredContractId=" + gPreferredContractId
				+ ", gfSignatureLimitAmountRole=" + gfSignatureLimitAmountRole + ", gCurrencyIdRole=" + gCurrencyIdRole
				+ ", gfSignatureWeightPerRole=" + gfSignatureWeightPerRole + ", gCustomerId=" + gCustomerId
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + ", gOperativeContractIndType="
				+ gOperativeContractIndType + ", gVisibleContractIndType=" + gVisibleContractIndType + "]";
	}
	
}
