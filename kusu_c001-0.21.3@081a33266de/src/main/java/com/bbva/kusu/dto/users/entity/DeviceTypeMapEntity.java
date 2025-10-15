package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.DeviceTypeCommons;

public class DeviceTypeMapEntity extends DeviceTypeCommons implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String gUserMgmtMasterIndType;

	public String getgUserMgmtMasterIndType() {
		return gUserMgmtMasterIndType;
	}

	public void setgUserMgmtMasterIndType(String gUserMgmtMasterIndType) {
		this.gUserMgmtMasterIndType = gUserMgmtMasterIndType;
	}

	@Override
	public String toString() {
		return "DeviceTypeMapEntity [gUserMgmtMasterIndType=" + gUserMgmtMasterIndType + ", toString()=" + super.toString() + "]";
	}

}
