package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.Date;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ProfileGroupsEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserProfileGroupId;
	private String gUserProfileGroupType;
	private String gRolePersonId;
	private String gPersonRoleType;
	private String gUserProfileGroupDesc;
	private Date gfUsrProfGroupStartDate;
	private Date gfUsrPrfGrpChgStatusDate;
	private String gfUsrPrfGrpChgStatusType;

	public String getgUserProfileGroupId() {
		return gUserProfileGroupId;
	}

	public void setgUserProfileGroupId(String gUserProfileGroupId) {
		this.gUserProfileGroupId = gUserProfileGroupId;
	}

	public String getgUserProfileGroupType() {
		return gUserProfileGroupType;
	}

	public void setgUserProfileGroupType(String gUserProfileGroupType) {
		this.gUserProfileGroupType = gUserProfileGroupType;
	}

	public String getgRolePersonId() {
		return gRolePersonId;
	}

	public void setgRolePersonId(String gRolePersonId) {
		this.gRolePersonId = gRolePersonId;
	}

	public String getgPersonRoleType() {
		return gPersonRoleType;
	}

	public void setgPersonRoleType(String gPersonRoleType) {
		this.gPersonRoleType = gPersonRoleType;
	}

	public String getgUserProfileGroupDesc() {
		return gUserProfileGroupDesc;
	}

	public void setgUserProfileGroupDesc(String gUserProfileGroupDesc) {
		this.gUserProfileGroupDesc = gUserProfileGroupDesc;
	}

	public Date getGfUsrProfGroupStartDate() {
		return gfUsrProfGroupStartDate;
	}

	public void setGfUsrProfGroupStartDate(Date gfUsrProfGroupStartDate) {
		this.gfUsrProfGroupStartDate = gfUsrProfGroupStartDate;
	}

	public Date getGfUsrPrfGrpChgStatusDate() {
		return gfUsrPrfGrpChgStatusDate;
	}

	public void setGfUsrPrfGrpChgStatusDate(Date gfUsrPrfGrpChgStatusDate) {
		this.gfUsrPrfGrpChgStatusDate = gfUsrPrfGrpChgStatusDate;
	}

	public String getGfUsrPrfGrpChgStatusType() {
		return gfUsrPrfGrpChgStatusType;
	}

	public void setGfUsrPrfGrpChgStatusType(String gfUsrPrfGrpChgStatusType) {
		this.gfUsrPrfGrpChgStatusType = gfUsrPrfGrpChgStatusType;
	}

	@Override
	public String toString() {
		return "ProfileGroupsEntity [gUserProfileGroupId=" + gUserProfileGroupId + ", gUserProfileGroupType=" + gUserProfileGroupType
				+ ", gRolePersonId=" + gRolePersonId + ", gPersonRoleType=" + gPersonRoleType + ", gUserProfileGroupDesc=" + gUserProfileGroupDesc
				+ ", gfUsrPrfGrpChgStatusType=" + gfUsrPrfGrpChgStatusType + ", getGfUserAuditId()=" + getGfUserAuditId() + ", getGfAuditDate()="
				+ getGfAuditDate() + "]";
	}

}
