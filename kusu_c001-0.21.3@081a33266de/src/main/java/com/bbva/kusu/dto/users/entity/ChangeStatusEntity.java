package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ChangeStatusEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gChangeStatusType;
	private String gChangeStatusName;

	public String getgChangeStatusType() {
		return gChangeStatusType;
	}

	public void setgChangeStatusType(String gChangeStatusType) {
		this.gChangeStatusType = gChangeStatusType;
	}

	public String getgChangeStatusName() {
		return gChangeStatusName;
	}

	public void setgChangeStatusName(String gChangeStatusName) {
		this.gChangeStatusName = gChangeStatusName;
	}

	@Override
	public String toString() {
		return "ChangeStatusEntity [super.toString()=" + super.toString() + ", gChangeStatusType=" + gChangeStatusType + ", gChangeStatusName="
				+ gChangeStatusName + "]";
	}

}
