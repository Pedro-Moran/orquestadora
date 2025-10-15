package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class CustomContractRoleCommons extends AuditContAccountCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal gRecordSequentialId;

	private BigDecimal gfSignatureLimitAmount;

	private String gCurrencyId;

	private BigDecimal gfSignatureWeightPer;

	private String gfUserRoleId;

	private String gfUserCapabilityId;

	private String gfSmcInternalId;

	private String gRecordUpdateType;

	private Timestamp gfAuditDate;

	private String gOfflineDeleteIndType;

	public BigDecimal getGRecordSequentialId() {
		return this.gRecordSequentialId;
	}

	public void setGRecordSequentialId(BigDecimal gRecordSequentialId) {
		this.gRecordSequentialId = gRecordSequentialId;
	}

	public BigDecimal getGfSignatureLimitAmount() {
		return gfSignatureLimitAmount;
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

	public String getGRecordUpdateType() {
		return this.gRecordUpdateType;
	}

	public void setGRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "CustomContractRoleCommons [super.toString()=" + super.toString() + ", gRecordSequentialId=" + gRecordSequentialId
				+ ", gfSignatureLimitAmount=" + gfSignatureLimitAmount + ", gCurrencyId=" + gCurrencyId + ", gfSignatureWeightPer="
				+ gfSignatureWeightPer + ", gfUserRoleId=" + gfUserRoleId + ", gfUserCapabilityId=" + gfUserCapabilityId + ", gfSmcInternalId="
				+ gfSmcInternalId + ", gRecordUpdateType=" + gRecordUpdateType + ", gfAuditDate=" + gfAuditDate + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
