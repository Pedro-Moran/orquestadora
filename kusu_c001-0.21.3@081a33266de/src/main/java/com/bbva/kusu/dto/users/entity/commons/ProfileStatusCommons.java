package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class ProfileStatusCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gUserStatusType;
	private String gCountryId;
	private String gfUserStatusType;

	public String getgUserStatusType() {
		return this.gUserStatusType;
	}

	public void setgUserStatusType(String gUserStatusType) {
		this.gUserStatusType = gUserStatusType;
	}

	public String getgCountryId() {
		return this.gCountryId;
	}

	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfUserStatusType() {
		return this.gfUserStatusType;
	}

	public void setGfUserStatusType(String gfUserStatusType) {
		this.gfUserStatusType = gfUserStatusType;
	}

	@Override
	public String toString() {
		return "ProfileStatusCommons [super.toString()=" + super.toString() + ", gUserStatusType=" + gUserStatusType + ", gCountryId=" + gCountryId
				+ ", gfUserStatusType=" + gfUserStatusType + "]";
	}

}
