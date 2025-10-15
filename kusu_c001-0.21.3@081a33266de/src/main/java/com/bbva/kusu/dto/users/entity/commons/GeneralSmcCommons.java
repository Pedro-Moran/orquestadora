package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class GeneralSmcCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfUserCapabilityId;

	private String gUserAccountId;

	private String gfUserRoleId;

	private BigDecimal gfSignatureWeightPer;

	private String gfUserAuditId;

	private Timestamp gfAuditDate;

	private String gUserPermissionSmcType;

	private String gCapbCstmCtrctIndType;
	
	private String gSmcCstmCtrctIndType;

	private BigDecimal gfSignatureLimitAmount;

	private String gCurrencyId;
	
	private String gOfflineDeleteIndType;
	
	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGfUserRoleId() {
		return this.gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getGfUserCapabilityId() {
		return this.gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	public BigDecimal getGfSignatureWeightPer() {
		return gfSignatureWeightPer;
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

	public Timestamp getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getgUserPermissionSmcType() {
		return gUserPermissionSmcType;
	}

	public void setgUserPermissionSmcType(String gUserPermissionSmcType) {
		this.gUserPermissionSmcType = gUserPermissionSmcType;
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

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "GeneralSmcCommons [gfUserCapabilityId=" + gfUserCapabilityId + ", gUserAccountId=" + gUserAccountId + ", gfUserRoleId=" + gfUserRoleId
				+ ", gfSignatureWeightPer=" + gfSignatureWeightPer + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate
				+ ", gUserPermissionSmcType=" + gUserPermissionSmcType + ", gCapbCstmCtrctIndType=" + gCapbCstmCtrctIndType
				+ ", gSmcCstmCtrctIndType=" + gSmcCstmCtrctIndType + ", gfSignatureLimitAmount=" + gfSignatureLimitAmount + ", gCurrencyId="
				+ gCurrencyId + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
