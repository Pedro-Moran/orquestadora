package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserNUserProfChanCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gUserAccountId;

	private String gUserMgmtChannelId;

	private String gProfileChannelStatusType;

	private Timestamp gfUserChanFirstAccessDate;

	private Timestamp gfLastAccessChannelDate;

	private String gfUserLoginIpId;

	private String gfPlatformApplicationId;

	private Timestamp gfDoubleFactorLastAccDate;

	private String gfUserAuditId;

	private Timestamp gfAuditDate;

	private Timestamp gfPrevLastAccessChanDate;

	private String gUsrProfCustmChanIndType;

	private String gOfflineDeleteIndType;

	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgUserMgmtChannelId() {
		return gUserMgmtChannelId;
	}

	public void setgUserMgmtChannelId(String gUserMgmtChannelId) {
		this.gUserMgmtChannelId = gUserMgmtChannelId;
	}

	public String getGProfileChannelStatusType() {
		return this.gProfileChannelStatusType;
	}

	public void setGProfileChannelStatusType(String gProfileChannelStatusType) {
		this.gProfileChannelStatusType = gProfileChannelStatusType;
	}

	public Timestamp getGfUserChanFirstAccessDate() {
		return this.gfUserChanFirstAccessDate;
	}

	public void setGfUserChanFirstAccessDate(Timestamp gfUserChanFirstAccessDate) {
		this.gfUserChanFirstAccessDate = gfUserChanFirstAccessDate;
	}

	public Timestamp getGfLastAccessChannelDate() {
		return this.gfLastAccessChannelDate;
	}

	public void setGfLastAccessChannelDate(Timestamp gfLastAccessChannelDate) {
		this.gfLastAccessChannelDate = gfLastAccessChannelDate;
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

	public String getGfUserLoginIpId() {
		return gfUserLoginIpId;
	}

	public void setGfUserLoginIpId(String gfUserLoginIpId) {
		this.gfUserLoginIpId = gfUserLoginIpId;
	}

	public String getGfPlatformApplicationId() {
		return gfPlatformApplicationId;
	}

	public void setGfPlatformApplicationId(String gfPlatformApplicationId) {
		this.gfPlatformApplicationId = gfPlatformApplicationId;
	}

	public Timestamp getGfDoubleFactorLastAccDate() {
		return gfDoubleFactorLastAccDate;
	}

	public void setGfDoubleFactorLastAccDate(Timestamp gfDoubleFactorLastAccDate) {
		this.gfDoubleFactorLastAccDate = gfDoubleFactorLastAccDate;
	}

	public Timestamp getGfPrevLastAccessChanDate() {
		return gfPrevLastAccessChanDate;
	}

	public void setGfPrevLastAccessChanDate(Timestamp gfPrevLastAccessChanDate) {
		this.gfPrevLastAccessChanDate = gfPrevLastAccessChanDate;
	}

	public String getgUsrProfCustmChanIndType() {
		return gUsrProfCustmChanIndType;
	}

	public void setgUsrProfCustmChanIndType(String gUsrProfCustmChanIndType) {
		this.gUsrProfCustmChanIndType = gUsrProfCustmChanIndType;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "UserNUserProfChanCommons [gUserAccountId=" + gUserAccountId + ", gUserMgmtChannelId=" + gUserMgmtChannelId + ", gProfileChannelStatusType="
				+ gProfileChannelStatusType + ", gfUserChanFirstAccessDate=" + gfUserChanFirstAccessDate + ", gfLastAccessChannelDate="
				+ gfLastAccessChannelDate + ", gfUserLoginIpId=" + gfUserLoginIpId + ", gfPlatformApplicationId=" + gfPlatformApplicationId
				+ ", gfDoubleFactorLastAccDate=" + gfDoubleFactorLastAccDate + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate
				+ ", gfPrevLastAccessChanDate=" + gfPrevLastAccessChanDate + ", gUsrProfCustmChanIndType=" + gUsrProfCustmChanIndType
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
