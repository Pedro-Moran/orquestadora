package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CoexistenceUserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gfLocalUserAccountId;
	private String gPersonRoleType;
	private String gRolePersonId;
	private String gLocalUsrAcIdFormatType;
	private String gfCustomerId;
	private String gfLocalAccessCodeId;
	private String gfLocalUserCodeId;
	private String gOfflineDeleteIndType;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;


	public String getGUserAccountId() {
		return gUserAccountId;
	}

	public void setGUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getGfLocalUserAccountId() {
		return gfLocalUserAccountId;
	}

	public void setGfLocalUserAccountId(String gfLocalUserAccountId) {
		this.gfLocalUserAccountId = gfLocalUserAccountId;
	}

	public String getGPersonRoleType() {
		return gPersonRoleType;
	}

	public void setGPersonRoleType(String gPersonRoleType) {
		this.gPersonRoleType = gPersonRoleType;
	}

	public String getGRolePersonId() {
		return gRolePersonId;
	}

	public void setGRolePersonId(String gRolePersonId) {
		this.gRolePersonId = gRolePersonId;
	}

	public String getGLocalUsrAcIdFormatType() {
		return gLocalUsrAcIdFormatType;
	}

	public void setGLocalUsrAcIdFormatType(String gLocalUsrAcIdFormatType) {
		this.gLocalUsrAcIdFormatType = gLocalUsrAcIdFormatType;
	}

	public String getGfCustomerId() {
		return gfCustomerId;
	}

	public void setGfCustomerId(String gfCustomerId) {
		this.gfCustomerId = gfCustomerId;
	}

	public String getGfUserAuditId() {
		return gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getGfLocalAccessCodeId() {
		return gfLocalAccessCodeId;
	}

	public void setGfLocalAccessCodeId(String gfLocalAccessCodeId) {
		this.gfLocalAccessCodeId = gfLocalAccessCodeId;
	}

	public String getGfLocalUserCodeId() {
		return gfLocalUserCodeId;
	}

	public void setGfLocalUserCodeId(String gfLocalUserCodeId) {
		this.gfLocalUserCodeId = gfLocalUserCodeId;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "CoexistenceUserEntity [gUserAccountId=" + gUserAccountId + ", gfLocalUserAccountId=" + gfLocalUserAccountId + ", gPersonRoleType="
				+ gPersonRoleType + ", gRolePersonId=" + gRolePersonId + ", gLocalUsrAcIdFormatType=" + gLocalUsrAcIdFormatType + ", gfCustomerId="
				+ gfCustomerId + ", gfLocalAccessCodeId=" + gfLocalAccessCodeId + ", gfLocalUserCodeId=" + gfLocalUserCodeId
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + "]";
	}

}
