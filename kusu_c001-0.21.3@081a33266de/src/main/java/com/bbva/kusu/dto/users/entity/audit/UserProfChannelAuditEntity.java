package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import java.sql.Timestamp;

import com.google.gson.annotations.SerializedName;

public class UserProfChannelAuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@SerializedName(value = "g_user_mgmt_channel_id")
	private String userMgmtChannelId;

	@SerializedName(value = "g_profile_channel_status_type")
	private String profileChannelStatusType;

	@SerializedName(value = "gf_user_chan_first_access_date")
	private Timestamp userChanFirstAccessDate;

	@SerializedName(value = "gf_last_access_channel_date")
	private Timestamp lastAccessChannelDate;

	@SerializedName(value = "gf_user_login_ip_id")
	private String userLoginIpId;

	@SerializedName(value = "g_record_update_type")
	private String rcdUpdateTypeIdChan;

	@SerializedName(value = "gf_user_audit_id")
	private String userAuditIdChan;

	@SerializedName(value = "gf_audit_date")
	private Timestamp auditDateChan;

	public String getUserMgmtChannelId() {
		return userMgmtChannelId;
	}

	public void setUserMgmtChannelId(String userMgmtChannelId) {
		this.userMgmtChannelId = userMgmtChannelId;
	}

	public String getProfileChannelStatusType() {
		return profileChannelStatusType;
	}

	public void setProfileChannelStatusType(String profileChannelStatusType) {
		this.profileChannelStatusType = profileChannelStatusType;
	}

	public Timestamp getUserChanFirstAccessDate() {
		return userChanFirstAccessDate;
	}

	public void setUserChanFirstAccessDate(Timestamp userChanFirstAccessDate) {
		this.userChanFirstAccessDate = userChanFirstAccessDate;
	}

	public Timestamp getLastAccessChannelDate() {
		return lastAccessChannelDate;
	}

	public void setLastAccessChannelDate(Timestamp lastAccessChannelDate) {
		this.lastAccessChannelDate = lastAccessChannelDate;
	}

	public String getUserLoginIpId() {
		return userLoginIpId;
	}

	public void setUserLoginIpId(String userLoginIpId) {
		this.userLoginIpId = userLoginIpId;
	}

	public String getRcdUpdateTypeIdChan() {
		return rcdUpdateTypeIdChan;
	}

	public void setRcdUpdateTypeIdChan(String rcdUpdateTypeIdChan) {
		this.rcdUpdateTypeIdChan = rcdUpdateTypeIdChan;
	}

	public String getUserAuditIdChan() {
		return userAuditIdChan;
	}

	public void setUserAuditIdChan(String userAuditIdChan) {
		this.userAuditIdChan = userAuditIdChan;
	}

	public Timestamp getAuditDateChan() {
		return auditDateChan;
	}

	public void setAuditDateChan(Timestamp auditDateChan) {
		this.auditDateChan = auditDateChan;
	}

	@Override
	public String toString() {
		return "UserProfChannelAuditEntity [userMgmtChannelId=" + userMgmtChannelId + ", profileChannelStatusType="
				+ profileChannelStatusType + ", userChanFirstAccessDate=" + userChanFirstAccessDate
				+ ", lastAccessChannelDate=" + lastAccessChannelDate + ", userLoginIpId=" + userLoginIpId
				+ ", rcdUpdateTypeIdChan=" + rcdUpdateTypeIdChan + ", userAuditIdChan=" + userAuditIdChan
				+ ", auditDateChan=" + auditDateChan + "]";
	}

}
