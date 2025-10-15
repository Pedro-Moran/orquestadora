package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class ValidationIndUpdEntity extends AuditParamsCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gValidationIndUpdType;
	private String gValidationIndUpdName;

	public String getgValidationIndUpdType() {
		return this.gValidationIndUpdType;
	}

	public void setgValidationIndUpdType(String gValidationIndUpdType) {
		this.gValidationIndUpdType = gValidationIndUpdType;
	}

	public String getgValidationIndUpdName() {
		return this.gValidationIndUpdName;
	}

	public void setgValidationIndUpdName(String gValidationIndUpdName) {
		this.gValidationIndUpdName = gValidationIndUpdName;
	}

	@Override
	public String toString() {
		return "ValidationIndUpdEntity [gValidationIndUpdType=" + gValidationIndUpdType + ", gValidationIndUpdName=" + gValidationIndUpdName
				+ ", toString()=" + super.toString() + "]";
	}
}
