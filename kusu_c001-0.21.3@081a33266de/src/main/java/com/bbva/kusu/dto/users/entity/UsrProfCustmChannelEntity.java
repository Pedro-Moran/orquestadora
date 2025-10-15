package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UsrProfCustmChannelEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gUserMgmtChannelId;
	private String gfChannelId; // aap
	private Timestamp gfUserChanFirstAccessDate;
	private Timestamp gfLastAccessChannelDate;
	private Timestamp gfPrevLastAccessChanDate;
	private String gOfflineDeleteIndType;

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

	public Timestamp getGfLastAccessChannelDate() {
		return gfLastAccessChannelDate;
	}

	public void setGfLastAccessChannelDate(Timestamp gfLastAccessChannelDate) {
		this.gfLastAccessChannelDate = gfLastAccessChannelDate;
	}

	public Timestamp getGfPrevLastAccessChanDate() {
		return gfPrevLastAccessChanDate;
	}

	public void setGfPrevLastAccessChanDate(Timestamp gfPrevLastAccessChanDate) {
		this.gfPrevLastAccessChanDate = gfPrevLastAccessChanDate;
	}

	public String getgOfflineDeleteIndType() { return gOfflineDeleteIndType; }

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "UsrProfCustmChannelEntity [gUserAccountId=" + gUserAccountId + ", gUserMgmtChannelId=" + gUserMgmtChannelId + ", gfChannelId="
				+ gfChannelId + ", gfUserChanFirstAccessDate=" + gfUserChanFirstAccessDate + ", gfLastAccessChannelDate=" + gfLastAccessChannelDate
				+ ", gfPrevLastAccessChanDate=" + gfPrevLastAccessChanDate + ", getGfUserAuditId()=" + getGfUserAuditId() + ", getGfAuditDate()="
				+ getGfAuditDate() + ", gOfflineDeleteIndType()=" + gOfflineDeleteIndType + "]";
	}

}
