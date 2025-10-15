package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ProfileAuthAttributeEntity extends AuditParamsCommons implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gPhoneType;
	private String gPrefixPhoneId;
	private String gfPhoneId;
	private String gPhoneVerifiedIndType;
	private String gfEmailDesc;
	private String gfEmailVerifiedType;
	private Timestamp gfDoubleFactorLastAccDate;
	private String gOfflineDeleteIndType;
	private String gProfAuthAttSplitIndType;
	private String gFacialRecognitionIndType;

	public String getgUserAccountId() {
		return this.gUserAccountId;
	}
	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgPhoneType() {
		return this.gPhoneType;
	}
	public void setgPhoneType(String gPhoneType) {
		this.gPhoneType = gPhoneType;
	}

	public String getgPrefixPhoneId() {
		return this.gPrefixPhoneId;
	}
	public void setgPrefixPhoneId(String gPrefixPhoneId) {
		this.gPrefixPhoneId = gPrefixPhoneId;
	}

	public String getGfPhoneId() {
		return this.gfPhoneId;
	}
	public void setGfPhoneId(String gfPhoneId) {
		this.gfPhoneId = gfPhoneId;
	}

	public String getgPhoneVerifiedIndType() {
		return this.gPhoneVerifiedIndType;
	}
	public void setgPhoneVerifiedIndType(String gPhoneVerifiedIndType) {
		this.gPhoneVerifiedIndType = gPhoneVerifiedIndType;
	}

	public String getGfEmailDesc() {
		return this.gfEmailDesc;
	}
	public void setGfEmailDesc(String gfEmailDesc) {
		this.gfEmailDesc = gfEmailDesc;
	}

	public String getGfEmailVerifiedType() {
		return this.gfEmailVerifiedType;
	}
	public void setGfEmailVerifiedType(String gfEmailVerifiedType) {
		this.gfEmailVerifiedType = gfEmailVerifiedType;
	}

	public Timestamp getGfDoubleFactorLastAccDate() {
		return this.gfDoubleFactorLastAccDate;
	}
	
	public void setGfDoubleFactorLastAccDate(Timestamp gfDoubleFactorLastAccDate) {
		this.gfDoubleFactorLastAccDate = gfDoubleFactorLastAccDate;
	}

	public String getGOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setGOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	public String getGProfAuthAttSplitIndType() {
		return gProfAuthAttSplitIndType;
	}
	
	public void setGProfAuthAttSplitIndType(String gProfAuthAttSplitIndType) {
		this.gProfAuthAttSplitIndType = gProfAuthAttSplitIndType;
	}
	
	public String getgFacialRecognitionIndType() {
		return gFacialRecognitionIndType;
	}
	
	public void setgFacialRecognitionIndType(String gFacialRecognitionIndType) {
		this.gFacialRecognitionIndType = gFacialRecognitionIndType;
	}
	
	@Override
	public String toString() {
		return "ProfileAuthAttributeEntity [super.toString()=" + super.toString() + ", gUserAccountId=" + gUserAccountId + ", gPhoneType="
				+ gPhoneType + ", gPrefixPhoneId=" + gPrefixPhoneId + ", gfPhoneId=" + gfPhoneId + ", gPhoneVerifiedIndType=" + gPhoneVerifiedIndType
				+ ", gfEmailDesc=" + gfEmailDesc + ", gfEmailVerifiedType=" + gfEmailVerifiedType + ", gfDoubleFactorLastAccDate="
				+ gfDoubleFactorLastAccDate + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + ", gProfAuthAttSplitIndType="
				+ gProfAuthAttSplitIndType + ", gFacialRecognitionIndType=" + gFacialRecognitionIndType + "]";
	}
}
