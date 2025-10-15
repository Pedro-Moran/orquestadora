package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class ChannelCommons extends AuditParamsCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gProfileChannelStatusType;
	private String gCountryId;
	private String gfProfileChannelStatusType;

	public String getgProfileChannelStatusType() {
		return gProfileChannelStatusType;
	}

	public void setgProfileChannelStatusType(String gProfileChannelStatusType) {
		this.gProfileChannelStatusType = gProfileChannelStatusType;
	}

	public String getgCountryId() {
		return gCountryId;
	}

	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfProfileChannelStatusType() {
		return gfProfileChannelStatusType;
	}

	public void setGfProfileChannelStatusType(String gfProfileChannelStatusType) {
		this.gfProfileChannelStatusType = gfProfileChannelStatusType;
	}

	@Override
	public String toString() {
		return "ChannelCommons [super.toString()=" + super.toString() + ", gProfileChannelStatusType=" + gProfileChannelStatusType + ", gCountryId="
				+ gCountryId + ", gfProfileChannelStatusType=" + gfProfileChannelStatusType + "]";
	}

}
