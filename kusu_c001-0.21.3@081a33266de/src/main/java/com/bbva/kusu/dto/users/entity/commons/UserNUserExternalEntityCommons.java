package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserNUserExternalEntityCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gUserId;
	private String gPlatformId;
	private String gfExternalUserId;
	private Timestamp gfRegistryEntryDate;

	public String getgUserId() {
		return gUserId;
	}

	public void setgUserId(String gUserId) {
		this.gUserId = gUserId;
	}

	public String getgPlatformId() {
		return gPlatformId;
	}

	public void setgPlatformId(String gPlatformId) {
		this.gPlatformId = gPlatformId;
	}

	public String getGfExternalUserId() {
		return gfExternalUserId;
	}

	public void setGfExternalUserId(String gfExternalUserId) {
		this.gfExternalUserId = gfExternalUserId;
	}

	public Timestamp getGfRegistryEntryDate() {
		return gfRegistryEntryDate;
	}

	public void setGfRegistryEntryDate(Timestamp gfRegistryEntryDate) {
		this.gfRegistryEntryDate = gfRegistryEntryDate;
	}

	@Override
	public String toString() {
		return "UserNUserExternalEntityCommons [super.toString()=" + super.toString() + ", gUserId=" + gUserId + ", gPlatformId=" + gPlatformId
				+ ", gfExternalUserId=" + gfExternalUserId + ", gfRegistryEntryDate=" + gfRegistryEntryDate + "]";
	}

}
