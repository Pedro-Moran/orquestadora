package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SmcOperativeModeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String smcId;
	private String smcConsModeIndType;
	private String smcMinorOperModeIndType;
	private String smcMentorCnsModeIndType;
	private String smcPreOperModeIndType;
	private String smcMinPreopermodeIndType;
	private String userAuditId;
	private Timestamp auditDate;
	private String mainRelationshipId;

	public String getSmcId() {
		return smcId;
	}

	public void setSmcId(String smcId) {
		this.smcId = smcId;
	}

	public String getSmcConsModeIndType() {
		return smcConsModeIndType;
	}

	public void setSmcConsModeIndType(String smcConsModeIndType) {
		this.smcConsModeIndType = smcConsModeIndType;
	}

	public String getSmcMinorOperModeIndType() {
		return smcMinorOperModeIndType;
	}

	public void setSmcMinorOperModeIndType(String smcMinorOperModeIndType) {
		this.smcMinorOperModeIndType = smcMinorOperModeIndType;
	}

	public String getSmcMentorCnsModeIndType() {
		return smcMentorCnsModeIndType;
	}

	public void setSmcMentorCnsModeIndType(String smcMentorCnsModeIndType) {
		this.smcMentorCnsModeIndType = smcMentorCnsModeIndType;
	}

	public String getSmcPreOperModeIndType() {
		return smcPreOperModeIndType;
	}

	public void setSmcPreOperModeIndType(String smcPreOperModeIndType) {
		this.smcPreOperModeIndType = smcPreOperModeIndType;
	}

	public String getSmcMinPreopermodeIndType() {
		return smcMinPreopermodeIndType;
	}

	public void setSmcMinPreopermodeIndType(String smcMinPreopermodeIndType) {
		this.smcMinPreopermodeIndType = smcMinPreopermodeIndType;
	}

	public String getUserAuditId() {
		return userAuditId;
	}

	public void setUserAuditId(String userAuditId) {
		this.userAuditId = userAuditId;
	}

	public Timestamp getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getMainRelationshipId() {
		return mainRelationshipId;
	}

	public void setMainRelationshipId(String mainRelationshipId) {
		this.mainRelationshipId = mainRelationshipId;
	}

	@Override
	public String toString() {
		return "SmcOperativeModeEntity [smcId=" + smcId + ", smcConsModeIndType=" + smcConsModeIndType + ", smcMinorOperModeIndType=" + smcMinorOperModeIndType
				+ ", smcMentorCnsModeIndType=" + smcMentorCnsModeIndType + ", smcPreOperModeIndType=" + smcPreOperModeIndType + ", smcMinPreopermodeIndType="
				+ smcMinPreopermodeIndType + ", userAuditId=" + userAuditId + ", auditDate=" + auditDate + ", mainRelationshipId=" + mainRelationshipId + "]";
	}

}