package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustUserProfChannelEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserMgmtChannelId;
	private String gUserAccountId;
	private Timestamp gfUserChanFirstAccessDate;
	private Timestamp gfLastAccessChannelDate;
	private String gfUserAuditId;
	private String gProfileChannelStatusType;
	private Timestamp gfAuditDate;
	private String gfUserLoginIpId;
	private Timestamp gfPrevLastAccessChanDate;
	private String gUsrProfCustmChanIndType;
	private String gOfflineDeleteIndType;

	public Timestamp getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
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

	public String getGUserMgmtChannelId() {
		return this.gUserMgmtChannelId;
	}

	public void setGUserMgmtChannelId(String gUserMgmtChannelId) {
		this.gUserMgmtChannelId = gUserMgmtChannelId;
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

	public String getGUserAccountId() {
		return this.gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGfUserLoginIpId() {
		return gfUserLoginIpId;
	}

	public void setGfUserLoginIpId(String gfUserLoginIpId) {
		this.gfUserLoginIpId = gfUserLoginIpId;
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
		return "CustUserProfChannelEntity [gUserMgmtChannelId=" + gUserMgmtChannelId + ", gUserAccountId=" + gUserAccountId + ", gfUserChanFirstAccessDate="
				+ gfUserChanFirstAccessDate + ", gfLastAccessChannelDate=" + gfLastAccessChannelDate + ", gfUserAuditId=" + gfUserAuditId
				+ ", gProfileChannelStatusType=" + gProfileChannelStatusType + ", gfAuditDate=" + gfAuditDate + ", gfUserLoginIpId=" + gfUserLoginIpId
				+ ", gfPrevLastAccessChanDate=" + gfPrevLastAccessChanDate + ", gUsrProfCustmChanIndType=" + gUsrProfCustmChanIndType
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}

}
