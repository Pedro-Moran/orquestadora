package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ProfileAuthAttributeMgmtEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gPhoneType;
	private String gPrefixPhoneId;
	private String gfPhoneId;
	private String gPhoneVerifiedIndType;
	private String gfEmailDesc;
	private String gfEmailVerifiedType;
	private Timestamp gfDoubleFactorLastAccDate;
	private String gRecordUpdateType;
	private String gOfflineDeleteIndType;
	private String gProfAuthAttSplitIndType;
	private String gFacialRecognitionIndType;

	public String getgUserAccountId() {
		return gUserAccountId;
	}
	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgPhoneType() {
		return gPhoneType;
	}
	public void setgPhoneType(String gPhoneType) {
		this.gPhoneType = gPhoneType;
	}

	public String getgPrefixPhoneId() {
		return gPrefixPhoneId;
	}
	public void setgPrefixPhoneId(String gPrefixPhoneId) {
		this.gPrefixPhoneId = gPrefixPhoneId;
	}

	public String getGfPhoneId() {
		return gfPhoneId;
	}
	public void setGfPhoneId(String gfPhoneId) {
		this.gfPhoneId = gfPhoneId;
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

	public Timestamp getGfDoubleFactorLastAccDate() {
		return gfDoubleFactorLastAccDate;
	}
	public void setGfDoubleFactorLastAccDate(Timestamp gfDoubleFactorLastAccDate) {
		this.gfDoubleFactorLastAccDate = gfDoubleFactorLastAccDate;
	}

	public String getgRecordUpdateType() {
		return gRecordUpdateType;
	}
	public void setgRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
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
		return "ProfileAuthAttributeMgmtEntity [super.toString()=" + super.toString() + ", gUserAccountId=" + gUserAccountId + ", gPhoneType="
				+ gPhoneType + ", gPrefixPhoneId=" + gPrefixPhoneId + ", gfPhoneId=" + gfPhoneId + ", gPhoneVerifiedIndType=" + gPhoneVerifiedIndType
				+ ", gfEmailDesc=" + gfEmailDesc + ", gfEmailVerifiedType=" + gfEmailVerifiedType + ", gfDoubleFactorLastAccDate="
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + ", gProfAuthAttSplitIndType=" + gProfAuthAttSplitIndType
				+ gfDoubleFactorLastAccDate + ", gRecordUpdateType=" + gRecordUpdateType + ", gFacialRecognitionIndType=" + gFacialRecognitionIndType
				+ "]";
	}

}
