package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomSmcCommons;

public class UserCustomSmcJoinAtrbMgmtEntity extends UserCustomSmcCommons implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String gUserSgntrIndType;

	private String gSpecificAttributeId;

	private String gSpecificAttributeName;

	private String gRecordUpdateType;

	
	public String getgUserSgntrIndType() {
		return this.gUserSgntrIndType;
	}

	public void setgUserSgntrIndType(String gUserSgntrIndType) {
		this.gUserSgntrIndType = gUserSgntrIndType;
	}

	public String getGSpecificAttributeId() {
		return this.gSpecificAttributeId;
	}

	public void setGSpecificAttributeId(String gSpecificAttributeId) {
		this.gSpecificAttributeId = gSpecificAttributeId;
	}

	public String getGSpecificAttributeName() {
		return this.gSpecificAttributeName;
	}

	public void setGSpecificAttributeName(String gSpecificAttributeName) {
		this.gSpecificAttributeName = gSpecificAttributeName;
	}

	public String getGRecordUpdateType() {
		return this.gRecordUpdateType;
	}

	public void setGRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	@Override
	public String toString() {
		return "UserCustomSmcJoinAtrbMgmtEntity [gUserSgntrIndType=" + gUserSgntrIndType + ", gSpecificAttributeId=" + gSpecificAttributeId
				+ ", gSpecificAttributeName=" + gSpecificAttributeName + ", gRecordUpdateType=" + gRecordUpdateType + ", toString()="
				+ super.toString() + "]";
	}

}
