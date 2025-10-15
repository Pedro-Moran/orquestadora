package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UserMgmtChannelEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserMgmtChannelId;
	private String gUserMgmtChannelName;

	public String getgUserMgmtChannelId() {
		return gUserMgmtChannelId;
	}

	public void setgUserMgmtChannelId(String gUserMgmtChannelId) {
		this.gUserMgmtChannelId = gUserMgmtChannelId;
	}

	public String getgUserMgmtChannelName() {
		return gUserMgmtChannelName;
	}

	public void setgUserMgmtChannelName(String gUserMgmtChannelName) {
		this.gUserMgmtChannelName = gUserMgmtChannelName;
	}

	@Override
	public String toString() {
		return "UserMgmtChannel [super.toString()=" + super.toString() + ", gUserMgmtChannelId=" + gUserMgmtChannelId + ", gUserMgmtChannelName="
				+ gUserMgmtChannelName + "]";
	}

}