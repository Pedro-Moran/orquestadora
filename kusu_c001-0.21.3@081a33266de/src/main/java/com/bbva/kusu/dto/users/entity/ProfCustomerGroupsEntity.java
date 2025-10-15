package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProfCustomerGroupsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gRolePersonType;

	private String gRolePersonId;
	private String gProfileGroupType;
	private String gProfileGroupId;
	private String gProfileGroupDesc;
	private Timestamp gfStartDate;
	private Timestamp gfChangeStatusDate;
	private String gStatusType;
	private String gfAuditId;
	private Timestamp gfAuditDate;

	public String getgRolePersonType() {
		return gRolePersonType;
	}

	public void setgRolePersonType(String gRolePersonType) {
		this.gRolePersonType = gRolePersonType;
	}

	public String getgRolePersonId() {
		return gRolePersonId;
	}

	public void setgRolePersonId(String gRolePersonId) {
		this.gRolePersonId = gRolePersonId;
	}

	public String getgProfileGroupType() {
		return gProfileGroupType;
	}

	public void setgProfileGroupType(String gProfileGroupType) {
		this.gProfileGroupType = gProfileGroupType;
	}

	public String getgProfileGroupId() {
		return gProfileGroupId;
	}

	public void setgProfileGroupId(String gProfileGroupId) {
		this.gProfileGroupId = gProfileGroupId;
	}

	public String getgProfileGroupDesc() {
		return gProfileGroupDesc;
	}

	public void setgProfileGroupDesc(String gProfileGroupDesc) {
		this.gProfileGroupDesc = gProfileGroupDesc;
	}

	public Timestamp getGfStartDate() {
		return gfStartDate;
	}

	public void setGfStartDate(Timestamp gfStartDate) {
		this.gfStartDate = gfStartDate;
	}

	public Timestamp getGfChangeStatusDate() {
		return gfChangeStatusDate;
	}

	public void setGfChangeStatusDate(Timestamp gfChangeStatusDate) {
		this.gfChangeStatusDate = gfChangeStatusDate;
	}

	public String getgStatusType() {
		return gStatusType;
	}

	public void setgStatusType(String gStatusType) {
		this.gStatusType = gStatusType;
	}

	public String getGfAuditId() {
		return gfAuditId;
	}

	public void setGfAuditId(String gfAuditId) {
		this.gfAuditId = gfAuditId;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	@Override
	public String toString() {
		return "ProfCustomerGroupsEntity [gRolePersonType=" + gRolePersonType + ", gRolePersonId=" + gRolePersonId + ", gProfileGroupType="
				+ gProfileGroupType + ", gProfileGroupId=" + gProfileGroupId + ", gProfileGroupDesc=" + gProfileGroupDesc + ", gfStartDate="
				+ gfStartDate + ", gfChangeStatusDate=" + gfChangeStatusDate + ", gStatusType=" + gStatusType + ", gfAuditId=" + gfAuditId
				+ ", gfAuditDate=" + gfAuditDate + "]";
	}

}
