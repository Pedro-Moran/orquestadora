package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class UserCustomCapCommons extends UserCustomCapEntityCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfUserCapabilityName;

	private String gfSmcInternalID;

	private String gUserSgntrIndType;

	private String gSpecificAttributeId;

	private String gSpecificAttributeDesc;

	public String getGfUserCapabilityName() {
		return this.gfUserCapabilityName;
	}

	public void setGfUserCapabilityName(String gfUserCapabilityName) {
		this.gfUserCapabilityName = gfUserCapabilityName;
	}

	public String getGfSmcInternalID() {
		return this.gfSmcInternalID;
	}

	public void setGfSmcInternalID(String gfSmcInternalID) {
		this.gfSmcInternalID = gfSmcInternalID;
	}

	public String getGUserSgntrIndType() {
		return this.gUserSgntrIndType;
	}

	public void setGUserSgntrIndType(String gUserSgntrIndType) {
		this.gUserSgntrIndType = gUserSgntrIndType;
	}

	public String getGSpecificAttributeId() {
		return this.gSpecificAttributeId;
	}

	public void setGSpecificAttributeId(String gSpecificAttributeId) {
		this.gSpecificAttributeId = gSpecificAttributeId;
	}

	public String getGSpecificAttributeDesc() {
		return this.gSpecificAttributeDesc;
	}

	public void setGSpecificAttributeDesc(String gSpecificAttributeDesc) {
		this.gSpecificAttributeDesc = gSpecificAttributeDesc;
	}

	@Override
	public String toString() {
		return "UserCustomCapCommons [super.toString()=" + super.toString() + ", gfUserCapabilityName=" + gfUserCapabilityName + ", gfSmcInternalID="
				+ gfSmcInternalID + ", gUserSgntrIndType=" + gUserSgntrIndType + ", gSpecificAttributeId=" + gSpecificAttributeId
				+ ", gSpecificAttributeDesc=" + gSpecificAttributeDesc + "]";
	}

}
