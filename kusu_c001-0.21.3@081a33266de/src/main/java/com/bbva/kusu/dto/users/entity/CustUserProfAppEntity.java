package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustUserProfAppEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gfPlatformApplicationId;
	private Timestamp gfDoubleFactorLastAccDate;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;
	private String gRecordUpdateType;

	public String getGUserAccountId() {
		return gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGfPlatformApplicationId() {
		return gfPlatformApplicationId;
	}

	public void setGfPlatformApplicationId(String gfPlatformApplicationId) {
		this.gfPlatformApplicationId = gfPlatformApplicationId;
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

	public Timestamp getGfDoubleFactorLastAccDate() {
		return gfDoubleFactorLastAccDate;
	}

	public void setGfDoubleFactorLastAccDate(Timestamp gfDoubleFactorLastAccDate) {
		this.gfDoubleFactorLastAccDate = gfDoubleFactorLastAccDate;
	}

	public String getgRecordUpdateType() {
		return gRecordUpdateType;
	}

	public void setgRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	@Override
	public String toString() {
		return "CustUserProfAppEntity [gUserAccountId=" + gUserAccountId + ", gfPlatformApplicationId="
				+ gfPlatformApplicationId + ", gfDoubleFactorLastAccDate=" + gfDoubleFactorLastAccDate
				+ ", gRecordUpdateType=" + gRecordUpdateType + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate="
				+ gfAuditDate + "]";
	}

}