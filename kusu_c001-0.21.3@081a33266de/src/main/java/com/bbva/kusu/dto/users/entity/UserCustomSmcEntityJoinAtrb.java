package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomSmcEntityCommons;

public class UserCustomSmcEntityJoinAtrb extends UserCustomSmcEntityCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gfSmcInternalID;

	private String gUserSgntrIndType;

	private String gSpecificAttributeName;

	public String getGfSmcInternalId() {
		return this.gfSmcInternalID;
	}

	public void setGfSmcInternalId(String gfSmcInternalID) {
		this.gfSmcInternalID = gfSmcInternalID;
	}

	public String getGUserSgntrSmcIndType() {
		return this.gUserSgntrIndType;
	}

	public void setGUserSgntrSmcIndType(String gUserSgntrIndType) {
		this.gUserSgntrIndType = gUserSgntrIndType;
	}

	public String getGSpecificAttributeName() {
		return this.gSpecificAttributeName;
	}

	public void setGSpecificAttributeName(String gSpecificAttributeName) {
		this.gSpecificAttributeName = gSpecificAttributeName;
	}

	@Override
	public String toString() {
		return "UserCustomSmcEntityJoinAtrb [gfSmcInternalID=" + gfSmcInternalID + ", gUserSgntrIndType=" + gUserSgntrIndType
				+ ", gSpecificAttributeName=" + gSpecificAttributeName + ", toString()=" + super.toString() + "]";
	}

}
