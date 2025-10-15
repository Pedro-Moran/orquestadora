package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class UserCustomSmcEntityCommons extends GeneralSmcCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gSpecificAttributeId;

	public String getGSpecificAttributeId() {
		return this.gSpecificAttributeId;
	}

	public void setGSpecificAttributeId(String gSpecificAttributeId) {
		this.gSpecificAttributeId = gSpecificAttributeId;
	}

	@Override
	public String toString() {
		return "UserCustomSmcEntityCommons [super.toString()=" + super.toString() + ", gSpecificAttributeId=" + gSpecificAttributeId + "]";
	}

}
