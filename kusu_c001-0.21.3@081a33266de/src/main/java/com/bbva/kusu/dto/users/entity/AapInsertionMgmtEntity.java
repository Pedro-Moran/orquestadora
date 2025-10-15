package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class AapInsertionMgmtEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gAapRelativeInsertionType;

	public String getgAapRelativeInsertionType() {
		return gAapRelativeInsertionType;
	}

	public void setgAapRelativeInsertionType(String gAapRelativeInsertionType) {
		this.gAapRelativeInsertionType = gAapRelativeInsertionType;
	}

	@Override
	public String toString() {
		return "AapInsertionMgmtEntity [gAapRelativeInsertionType=" + gAapRelativeInsertionType + ", gfUserAuditId=" + getGfUserAuditId() + ", gfAuditDate="
				+ getGfAuditDate() + "]";
	}

}