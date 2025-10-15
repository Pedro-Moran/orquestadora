package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ProfSplitAuthAtrb extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gUsrProfileAuthAttIdType;
	private String gPhoneType;
	private String gPrefixPhoneId;
	private String gfPhoneId;
	private String gPhoneVerifiedIndType;
	private String gfEmailDesc;
	private String gfEmailVerifiedType;
	private String gOfflineDeleteIndType;
	private String gFacialRecognitionIndType;
	private Timestamp gfDoubleFactorLastAccDate;

	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgUsrProfileAuthAttIdType() {
		return gUsrProfileAuthAttIdType;
	}

	public void setgUsrProfileAuthAttIdType(String gUsrProfileAuthAttIdType) {
		this.gUsrProfileAuthAttIdType = gUsrProfileAuthAttIdType;
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

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	public String getgFacialRecognitionIndType() {
		return gFacialRecognitionIndType;
	}

	public void setgFacialRecognitionIndType(String gFacialRecognitionIndType) {
		this.gFacialRecognitionIndType = gFacialRecognitionIndType;
	}

	public Timestamp getGfDoubleFactorLastAccDate() {
		return gfDoubleFactorLastAccDate;
	}

	public void setGfDoubleFactorLastAccDate(Timestamp gfDoubleFactorLastAccDate) {
		this.gfDoubleFactorLastAccDate = gfDoubleFactorLastAccDate;
	}

	@Override
	public String toString() {
		return "ProfSplitAuthAtrb [gUserAccountId=" + gUserAccountId + ", gUsrProfileAuthAttIdType=" + gUsrProfileAuthAttIdType + ", gPhoneType=" + gPhoneType
				+ ", gPrefixPhoneId=" + gPrefixPhoneId + ", gfPhoneId=" + gfPhoneId + ", gPhoneVerifiedIndType=" + gPhoneVerifiedIndType + ", gfEmailDesc="
				+ gfEmailDesc + ", gfEmailVerifiedType=" + gfEmailVerifiedType + ", gOfflineDeleteIndType=" + gOfflineDeleteIndType
				+ ", gFacialRecognitionIndType=" + gFacialRecognitionIndType + ", gfDoubleFactorLastAccDate=" + gfDoubleFactorLastAccDate + "]";
	}

}
