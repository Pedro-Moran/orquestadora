package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class AapCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String gUserMgmtChannelId;
	private String gCountryId;
	private String gfChannelId;
	private String gAapChannelType;
	private String gUserMgmtMasterIndType;
	private String gChannelOperModeIndType;
	private String gSmcPackageApplIndType;
	private String gAapOriginType;

	public String getgAapOriginType() {
		return gAapOriginType;
	}


	public void setgAapOriginType(String gAapOriginType) {
		this.gAapOriginType = gAapOriginType;
	}
	
	
	public String getgUserMgmtChannelId() {
		return gUserMgmtChannelId;
	}
	public void setgUserMgmtChannelId(String gUserMgmtChannelId) {
		this.gUserMgmtChannelId = gUserMgmtChannelId;
	}
	public String getgCountryId() {
		return gCountryId;
	}
	public void setgCountryId(String gCountryId) {
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

	@Override
	public String toString() {
		return "AapCommons{" +
				"gUserMgmtChannelId='" + gUserMgmtChannelId + '\'' +
				", gCountryId='" + gCountryId + '\'' +
				", gfChannelId='" + gfChannelId + '\'' +
				", gAapChannelType='" + gAapChannelType + '\'' +
				", gUserMgmtMasterIndType='" + gUserMgmtMasterIndType + '\'' +
				", gChannelOperModeIndType='" + gChannelOperModeIndType + '\'' +
				", gSmcPackageApplIndType='" + gSmcPackageApplIndType + '\'' +
				", gAapOriginType='" + gAapOriginType + '\'' +
				'}';
	}

}
