package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ProfileChannelStatusEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gProfileChannelStatusType;
	private String gProfileChannelStatusName;

	public String getgProfileChannelStatusType() {
		return this.gProfileChannelStatusType;
	}

	public void setgProfileChannelStatusType(String gProfileChannelStatusType) {
		this.gProfileChannelStatusType = gProfileChannelStatusType;
	}

	public String getgProfileChannelStatusName() {
		return this.gProfileChannelStatusName;
	}

	public void setgProfileChannelStatusName(String gProfileChannelStatusName) {
		this.gProfileChannelStatusName = gProfileChannelStatusName;
	}

	@Override
	public String toString() {
		return "ProfileChannelStatusEntity [super.toString()=" + super.toString() + ", gProfileChannelStatusType=" + gProfileChannelStatusType
				+ ", gProfileChannelStatusName=" + gProfileChannelStatusName + "]";
	}
}
