package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CUserCommons;

public class CustUserProfileEntityAux implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String gUserId;
	
	private String gfLocalUserId;
	
	private String gUserAccountId;
	
	private String gfLocalUserAccountId;
	
	private String gUserLanguage;

	private String gfFirstName;

	private String gfLastName;

	private String gfSecondLastName;

	private String gSolProfBastanteoIndType;

	private String gApplyBastanteoSmcIndType;

	public String getgUserId() {
		return gUserId;
	}

	public void setgUserId(String gUserId) {
		this.gUserId = gUserId;
	}

	public String getGfLocalUserId() {
		return gfLocalUserId;
	}

	public void setGfLocalUserId(String gfLocalUserId) {
		this.gfLocalUserId = gfLocalUserId;
	}

	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGfLocalUserAccountId() {
		return gfLocalUserAccountId;
	}

	public void setGfLocalUserAccountId(String gfLocalUserAccountId) {
		this.gfLocalUserAccountId = gfLocalUserAccountId;
	}

	public String getgUserLanguage() {
		return gUserLanguage;
	}

	public void setgUserLanguage(String gUserLanguage) {
		this.gUserLanguage = gUserLanguage;
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

	public String getgSolProfBastanteoIndType() {
		return gSolProfBastanteoIndType;
	}

	public void setgSolProfBastanteoIndType(String gSolProfBastanteoIndType) {
		this.gSolProfBastanteoIndType = gSolProfBastanteoIndType;
	}

	public String getgApplyBastanteoSmcIndType() {
		return gApplyBastanteoSmcIndType;
	}

	public void setgApplyBastanteoSmcIndType(String gApplyBastanteoSmcIndType) {
		this.gApplyBastanteoSmcIndType = gApplyBastanteoSmcIndType;
	}

	@Override
	public String toString() {
		return "CustUserProfileEntityAux{" +
				"gUserId='" + gUserId + '\'' +
				", gfLocalUserId='" + gfLocalUserId + '\'' +
				", gUserAccountId='" + gUserAccountId + '\'' +
				", gfLocalUserAccountId='" + gfLocalUserAccountId + '\'' +
				", gUserLanguage='" + gUserLanguage + '\'' +
				", gfFirstName='" + gfFirstName + '\'' +
				", gfLastName='" + gfLastName + '\'' +
				", gfSecondLastName='" + gfSecondLastName + '\'' +
				", gSolProfBastanteoIndType='" + gSolProfBastanteoIndType + '\'' +
				", gApplyBastanteoSmcIndType='" + gApplyBastanteoSmcIndType + '\'' +
				'}';
	}
}
