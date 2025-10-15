package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustUserProfChannelSubchannelEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gUserMgmtChannelId;
	private String gfChannelId;
	private Timestamp gfUserChanFirstAccessDate;
	private Timestamp gfLastAccessDate;
	private Timestamp gfPrevLastAccessDate;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;

	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgUserMgmtChannelId() {
		return gUserMgmtChannelId;
	}

	public void setgUserMgmtChannelId(String gUserMgmtChannelId) {
		this.gUserMgmtChannelId = gUserMgmtChannelId;
	}

	public String getGfChannelId() {
		return gfChannelId;
	}

	public void setGfChannelId(String gfChannelId) {
		this.gfChannelId = gfChannelId;
	}

	public Timestamp getGfUserChanFirstAccessDate() {
		return gfUserChanFirstAccessDate;
	}

	public void setGfUserChanFirstAccessDate(Timestamp gfUserChanFirstAccessDate) {
		this.gfUserChanFirstAccessDate = gfUserChanFirstAccessDate;
	}

	public Timestamp getGfLastAccessDate() {
		return gfLastAccessDate;
	}

	public void setGfLastAccessDate(Timestamp gfLastAccessDate) {
		this.gfLastAccessDate = gfLastAccessDate;
	}

	public Timestamp getGfPrevLastAccessDate() {
		return gfPrevLastAccessDate;
	}

	public void setGfPrevLastAccessDate(Timestamp gfPrevLastAccessDate) {
		this.gfPrevLastAccessDate = gfPrevLastAccessDate;
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

	@Override
	public String toString() {
		return "CustUserProfChannelSubchannelEntity [gUserAccountId=" + gUserAccountId + ", gUserMgmtChannelId=" + gUserMgmtChannelId
				+ ", gfChannelId=" + gfChannelId + ", gfUserChanFirstAccessDate=" + gfUserChanFirstAccessDate + ", gfLastAccessDate="
				+ gfLastAccessDate + ", gfPrevLastAccessDate=" + gfPrevLastAccessDate + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate="
				+ gfAuditDate + "]";
	}

}
