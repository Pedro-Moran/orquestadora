package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CUserProfCommons;

public class NcustUserProfileEntity extends CUserProfCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gNonCustomerId;

	private String gUserCustomRoleIndType;

	private String gUserCustomCtrctIndType;

	private String gUpdatedUsrProfileIndType;

	public String getGNonCustomerId() {
		return this.gNonCustomerId;
	}

	public void setGNonCustomerId(String gNonCustomerId) {
		this.gNonCustomerId = gNonCustomerId;
	}

	public String getgUserCustomRoleIndType() {
		return this.gUserCustomRoleIndType;
	}

	public void setgUserCustomRoleIndType(String gUserCustomRoleIndType) {
		this.gUserCustomRoleIndType = gUserCustomRoleIndType;
	}

	public String getgUserCustomCtrctIndType() {
		return this.gUserCustomCtrctIndType;
	}

	public void setgUserCustomCtrctIndType(String gUserCustomCtrctIndType) {
		this.gUserCustomCtrctIndType = gUserCustomCtrctIndType;
	}

	public String getgUpdatedUsrProfileIndType() {
		return this.gUpdatedUsrProfileIndType;
	}

	public void setgUpdatedUsrProfileIndType(String gUpdatedUsrProfileIndType) {
		this.gUpdatedUsrProfileIndType = gUpdatedUsrProfileIndType;
	}

	@Override
	public String toString() {
		return "NcustUserProfileEntity [gNonCustomerId=" + gNonCustomerId + ", gUserCustomRoleIndType="
				+ gUserCustomRoleIndType + ", gUserCustomCtrctIndType=" + gUserCustomCtrctIndType
				+ ", gUpdatedUsrProfileIndType=" + gUpdatedUsrProfileIndType + ", toString()=" + super.toString() + "]";
	}

}
