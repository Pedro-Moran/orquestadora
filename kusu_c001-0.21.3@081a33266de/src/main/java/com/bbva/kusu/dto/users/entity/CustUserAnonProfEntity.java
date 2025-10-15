package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CUserCommons;

public class CustUserAnonProfEntity extends CUserCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gAnonymUserProfileId;
	private String gPhoneVerifiedIndType;
	private String gfEmailDesc;
	private String gfEmailVerifiedType;

	public String getgAnonymUserProfileId() {
		return gAnonymUserProfileId;
	}

	public void setgAnonymUserProfileId(String gAnonymUserProfileId) {
		this.gAnonymUserProfileId = gAnonymUserProfileId;
	}

	public String getgPhoneVerifiedIndType() {
		return gPhoneVerifiedIndType;
	}

	public void setgPhoneVerifiedIndType(String gPhoneVerifiedIndType) {
		this.gPhoneVerifiedIndType = gPhoneVerifiedIndType;
	}

	public String getGfEmailDesc() {
		return gfEmailDesc;
	}

	public void setGfEmailDesc(String gfEmailDesc) {
		this.gfEmailDesc = gfEmailDesc;
	}

	public String getGfEmailVerifiedType() {
		return gfEmailVerifiedType;
	}

	public void setGfEmailVerifiedType(String gfEmailVerifiedType) {
		this.gfEmailVerifiedType = gfEmailVerifiedType;
	}

	@Override
	public String toString() {
		return "CustUserAnonProfEntity [gAnonymUserProfileId=" + gAnonymUserProfileId + ", gPhoneVerifiedIndType=" + gPhoneVerifiedIndType + ", gfEmailDesc="
				+ gfEmailDesc + ", gfEmailVerifiedType=" + gfEmailVerifiedType + ", super()= " + super.toString() + "]";
	}

}
