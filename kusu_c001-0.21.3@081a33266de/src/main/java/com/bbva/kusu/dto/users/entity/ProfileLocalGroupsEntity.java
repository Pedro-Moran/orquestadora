package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ProfileLocalGroupsEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserProfileGroupId;
	private String gfUserProfileLocalGroupId;
	private String gUsrProfGrpLcIdFmtType;
	private String gCountryId;
	private String gHoldingEntityId;
	
	public String getgUserProfileGroupId() {
		return gUserProfileGroupId;
	}
	public void setgUserProfileGroupId(String gUserProfileGroupId) {
		this.gUserProfileGroupId = gUserProfileGroupId;
	}
	public String getGfUserProfileLocalGroupId() {
		return gfUserProfileLocalGroupId;
	}
	public void setGfUserProfileLocalGroupId(String gfUserProfileLocalGroupId) {
		this.gfUserProfileLocalGroupId = gfUserProfileLocalGroupId;
	}
	public String getgUsrProfGrpLcIdFmtType() {
		return gUsrProfGrpLcIdFmtType;
	}
	public void setgUsrProfGrpLcIdFmtType(String gUsrProfGrpLcIdFmtType) {
		this.gUsrProfGrpLcIdFmtType = gUsrProfGrpLcIdFmtType;
	}
	public String getgCountryId() {
		return gCountryId;
	}
	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}
	public String getgHoldingEntityId() {
		return gHoldingEntityId;
	}
	public void setgHoldingEntityId(String gHoldingEntityId) {
		this.gHoldingEntityId = gHoldingEntityId;
	}
	
	@Override
	public String toString() {
		return "ProfileLocalGroupsEntity [gUserProfileGroupId=" + gUserProfileGroupId + ", gfUserProfileLocalGroupId="
				+ gfUserProfileLocalGroupId + ", gUsrProfGrpLcIdFmtType=" + gUsrProfGrpLcIdFmtType + ", gCountryId="
				+ gCountryId + ", gHoldingEntityId=" + gHoldingEntityId + "]";
	}
}