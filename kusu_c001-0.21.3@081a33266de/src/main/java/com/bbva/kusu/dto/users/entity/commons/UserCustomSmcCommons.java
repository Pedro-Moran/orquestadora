package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserCustomSmcCommons extends GeneralSmcCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfSmcInternalId;

	private String gUserSgntrSmcIndType;

	public String getGfSmcInternalId() {
		return this.gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	public String getGUserSgntrSmcIndType() {
		return this.gUserSgntrSmcIndType;
	}

	public void setGUserSgntrSmcIndType(String gUserSgntrSmcIndType) {
		this.gUserSgntrSmcIndType = gUserSgntrSmcIndType;
	}


	@Override
	public String toString() {
		return "UserCustomSmcCommons [super.toString()=" + super.toString() + ", gfSmcInternalId=" + gfSmcInternalId + ", gUserSgntrSmcIndType="
				+ gUserSgntrSmcIndType + "]";
	}

}
