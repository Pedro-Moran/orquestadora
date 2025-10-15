package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.Date;

public class CapabilitySmcVersionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gfUserRoleId;

	private String gfUserCapabilityId;

	private String gfSmcInternalId;

	private String gfSmcId;

	private Date gfSmcStartDate;

	private Date gfSmcEndDate;

	private String gRoleMgmtIndType;

	private String gCapabilityMgmtIndType;

	private String gSmcMgmtIndType;

	private String gfUserAuditId;

	private Date gfAuditDate;
	
	private String gSmcContractIndType;
	
	private String gSmcCustomizableIndType;
	
	private String gUserMgmtMasterIndType;
	
	private String gApplyBastanteoSmcIndType;

	public String getGfUserCapabilityId() {
		return this.gfUserCapabilityId;
	}

	public void setGfUserCapabilityId(String gfUserCapabilityId) {
		this.gfUserCapabilityId = gfUserCapabilityId;
	}

	public String getGfSmcInternalId() {
		return this.gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	public String getGfSmcId() {
		return this.gfSmcId;
	}

	public void setGfSmcId(String gfSmcId) {
		this.gfSmcId = gfSmcId;
	}

	public Date getGfSmcStartDate() {
		return this.gfSmcStartDate;
	}

	public void setGfSmcStartDate(Date gfSmcStartDate) {
		this.gfSmcStartDate = gfSmcStartDate;
	}

	public Date getGfSmcEndDate() {
		return this.gfSmcEndDate;
	}

	public void setGfSmcEndDate(Date gfSmcEndDate) {
		this.gfSmcEndDate = gfSmcEndDate;
	}

	public String getGfUserAuditId() {
		return this.gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Date getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Date gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getGfUserRoleId() {
		return this.gfUserRoleId;
	}

	public void setGfUserRoleId(String gfUserRoleId) {
		this.gfUserRoleId = gfUserRoleId;
	}

	public String getgRoleMgmtIndType() {
		return this.gRoleMgmtIndType;
	}

	public void setgRoleMgmtIndType(String gRoleMgmtIndType) {
		this.gRoleMgmtIndType = gRoleMgmtIndType;
	}

	public String getgCapabilityMgmtIndType() {
		return this.gCapabilityMgmtIndType;
	}

	public void setgCapabilityMgmtIndType(String gCapabilityMgmtIndType) {
		this.gCapabilityMgmtIndType = gCapabilityMgmtIndType;
	}

	public String getgSmcMgmtIndType() {
		return this.gSmcMgmtIndType;
	}

	public void setgSmcMgmtIndType(String gSmcMgmtIndType) {
		this.gSmcMgmtIndType = gSmcMgmtIndType;
	}

	public String getgSmcContractIndType() {
		return gSmcContractIndType;
	}

	public void setgSmcContractIndType(String gSmcContractIndType) {
		this.gSmcContractIndType = gSmcContractIndType;
	}
	

	public String getgSmcCustomizableIndType() {
		return gSmcCustomizableIndType;
	}

	public void setgSmcCustomizableIndType(String gSmcCustomizableIndType) {
		this.gSmcCustomizableIndType = gSmcCustomizableIndType;
	}

	public String getgUserMgmtMasterIndType() {
		return gUserMgmtMasterIndType;
	}

	public void setgUserMgmtMasterIndType(String gUserMgmtMasterIndType) {
		this.gUserMgmtMasterIndType = gUserMgmtMasterIndType;
	}

	public String getgApplyBastanteoSmcIndType() {
		return gApplyBastanteoSmcIndType;
	}

	public void setgApplyBastanteoSmcIndType(String gApplyBastanteoSmcIndType) {
		this.gApplyBastanteoSmcIndType = gApplyBastanteoSmcIndType;
	}

	@Override
	public String toString() {
		return "CapabilitySmcVersionEntity [gfUserRoleId=" + gfUserRoleId + ", gfUserCapabilityId=" + gfUserCapabilityId
				+ ", gfSmcInternalId=" + gfSmcInternalId + ", gfSmcId=" + gfSmcId + ", gfSmcStartDate=" + gfSmcStartDate
				+ ", gfSmcEndDate=" + gfSmcEndDate + ", gRoleMgmtIndType=" + gRoleMgmtIndType
				+ ", gCapabilityMgmtIndType=" + gCapabilityMgmtIndType + ", gSmcMgmtIndType=" + gSmcMgmtIndType
				+ ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + ", gSmcContractIndType="
				+ gSmcContractIndType + ", gSmcCustomizableIndType=" + gSmcCustomizableIndType
				+ ", gUserMgmtMasterIndType=" + gUserMgmtMasterIndType + ", gApplyBastanteoSmcIndType=" + gApplyBastanteoSmcIndType + "]";
	}



}
