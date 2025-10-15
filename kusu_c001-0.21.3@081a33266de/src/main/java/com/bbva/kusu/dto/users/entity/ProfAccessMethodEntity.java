package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.ExternalContractCommons;

public class ProfAccessMethodEntity extends ExternalContractCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserProfAccessMethodType;
	private String gUserProfAccessMethodName;
	private String gAuthMchmDeviceIndType;

	public String getgUserProfAccessMethodType() {
		return gUserProfAccessMethodType;
	}

	public void setgUserProfAccessMethodType(String gUserProfAccessMethodType) {
		this.gUserProfAccessMethodType = gUserProfAccessMethodType;
	}

	public String getgUserProfAccessMethodName() {
		return gUserProfAccessMethodName;
	}

	public void setgUserProfAccessMethodName(String gUserProfAccessMethodName) {
		this.gUserProfAccessMethodName = gUserProfAccessMethodName;
	}

	public String getgAuthMchmDeviceIndType() {
		return gAuthMchmDeviceIndType;
	}

	public void setgAuthMchmDeviceIndType(String gAuthMchmDeviceIndType) {
		this.gAuthMchmDeviceIndType = gAuthMchmDeviceIndType;
	}

	@Override
	public String toString() {
		return "ProfAccessMethodEntity [gUserProfAccessMethodType=" + gUserProfAccessMethodType
				+ ", gUserProfAccessMethodName=" + gUserProfAccessMethodName + ", gAuthMchmDeviceIndType="
				+ gAuthMchmDeviceIndType + "]";
	}
	
}