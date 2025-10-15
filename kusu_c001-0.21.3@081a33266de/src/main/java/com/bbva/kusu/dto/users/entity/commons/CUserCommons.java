package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class CUserCommons extends CUserProfCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gUserCustomRoleIndType;

	private String gUserCustomCtrctIndType;

	private String gUpdatedUsrProfileIndType;

	private String gUserMgmtMasterIndType;

	private String gUserLanguage;

	private String gfLocalUserId;

	private String gfFirstName;

	private String gfLastName;

	private String gfSecondLastName;

	public String getGUserCustomRoleIndType() {
		return this.gUserCustomRoleIndType;
	}

	public void setGUserCustomRoleIndType(String gUserCustomRoleIndType) {
		this.gUserCustomRoleIndType = gUserCustomRoleIndType;
	}

	public String getGUserCustomCtrctIndType() {
		return this.gUserCustomCtrctIndType;
	}

	public void setGUserCustomCtrctIndType(String gUserCustomCtrctIndType) {
		this.gUserCustomCtrctIndType = gUserCustomCtrctIndType;
	}

	public String getGUpdatedUsrProfileIndType() {
		return this.gUpdatedUsrProfileIndType;
	}

	public void setGUpdatedUsrProfileIndType(String gUpdatedUsrProfileIndType) {
		this.gUpdatedUsrProfileIndType = gUpdatedUsrProfileIndType;
	}

	public String getGUserMgmtMasterIndType() {
		return gUserMgmtMasterIndType;
	}

	public void setGUserMgmtMasterIndType(String gUserMgmtMasterIndType) {
		this.gUserMgmtMasterIndType = gUserMgmtMasterIndType;
	}

	public String getgUserLanguage() {
		return gUserLanguage;
	}

	public void setgUserLanguage(String gUserLanguage) {
		this.gUserLanguage = gUserLanguage;
	}

	public String getGfLocalUserId() {
		return gfLocalUserId;
	}

	public void setGfLocalUserId(String gfLocalUserId) {
		this.gfLocalUserId = gfLocalUserId;
	}

	public String getGfFirstName() {
		return gfFirstName;
	}

	public void setGfFirstName(String gfFirstName) {
		this.gfFirstName = gfFirstName;
	}

	public String getGfLastName() {
		return gfLastName;
	}

	public void setGfLastName(String gfLastName) {
		this.gfLastName = gfLastName;
	}

	public String getGfSecondLastName() {
		return gfSecondLastName;
	}

	public void setGfSecondLastName(String gfSecondLastName) {
		this.gfSecondLastName = gfSecondLastName;
	}

	@Override
	public String toString() {
		return "CUserCommons [super.toString()=" + super.toString() + ", gUserCustomRoleIndType="
				+ gUserCustomRoleIndType + ", gUserCustomCtrctIndType=" + gUserCustomCtrctIndType
				+ ", gUpdatedUsrProfileIndType=" + gUpdatedUsrProfileIndType + ", gUserMgmtMasterIndType="
				+ gUserMgmtMasterIndType + ", gUserLanguage=" + gUserLanguage + ", gfLocalUserId=" + gfLocalUserId
				+ ", gfFirstName=" + gfFirstName + ", gfLastName=" + gfLastName + ", gfSecondLastName="
				+ gfSecondLastName + "]";
	}

}
