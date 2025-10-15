package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UserMgmtChannelMapEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserMgmtChannelId;
	private String gCountryId;
	private String gfChannelId;
	private String gAapChannelType;
	private String gUserMgmtMasterIndType;
	private String gChannelOperModeIndType;
	private String gSmcPackageApplIndType;
	private String gAapRelativeInsertionType;
	private String gAapOriginType;

	public String getGUserMgmtChannelId() {
		return gUserMgmtChannelId;
	}

	public void setGUserMgmtChannelId(String gUserMgmtChannelId) {
		this.gUserMgmtChannelId = gUserMgmtChannelId;
	}

	public String getGCountryId() {
		return gCountryId;
	}

	public void setGCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfChannelId() {
		return gfChannelId;
	}

	public void setGfChannelId(String gfChannelId) {
		this.gfChannelId = gfChannelId;
	}

	public String getgAapChannelType() {
		return gAapChannelType;
	}

	public void setgAapChannelType(String gAapChannelType) {
		this.gAapChannelType = gAapChannelType;
	}

	public String getgUserMgmtMasterIndType() {
		return gUserMgmtMasterIndType;
	}

	public void setgUserMgmtMasterIndType(String gUserMgmtMasterIndType) {
		this.gUserMgmtMasterIndType = gUserMgmtMasterIndType;
	}

	public String getgChannelOperModeIndType() {
		return gChannelOperModeIndType;
	}

	public void setgChannelOperModeIndType(String gChannelOperModeIndType) {
		this.gChannelOperModeIndType = gChannelOperModeIndType;
	}

	public String getgSmcPackageApplIndType() {
		return gSmcPackageApplIndType;
	}

	public void setgSmcPackageApplIndType(String gSmcPackageApplIndType) {
		this.gSmcPackageApplIndType = gSmcPackageApplIndType;
	}

	public String getgAapRelativeInsertionType() {
		return gAapRelativeInsertionType;
	}

	public void setgAapRelativeInsertionType(String gAapRelativeInsertionType) {
		this.gAapRelativeInsertionType = gAapRelativeInsertionType;
	}

	public String getgAapOriginType() {
		return gAapOriginType;
	}

	public void setgAapOriginType(String gAapOriginType) {
		this.gAapOriginType = gAapOriginType;
	}

	@Override
	public String toString() {
		return "UserMgmtChannelMapEntity [gUserMgmtChannelId=" + gUserMgmtChannelId + ", gCountryId=" + gCountryId + ", gfChannelId=" + gfChannelId
				+ ", gAapChannelType=" + gAapChannelType + ", gUserMgmtMasterIndType=" + gUserMgmtMasterIndType + ", gChannelOperModeIndType="
				+ gChannelOperModeIndType + ", gSmcPackageApplIndType=" + gSmcPackageApplIndType + ", gAapRelativeInsertionType=" + gAapRelativeInsertionType
				+ ", gAapOriginType=" + gAapOriginType + ", gfUserAuditId=" + getGfUserAuditId() + ", gfAuditDate=" + getGfAuditDate() + "]";
	}

}