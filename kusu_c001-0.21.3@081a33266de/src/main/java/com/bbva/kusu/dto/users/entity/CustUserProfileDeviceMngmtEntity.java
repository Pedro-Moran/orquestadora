package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CustUserProfileDeviceCommons;

public class CustUserProfileDeviceMngmtEntity extends CustUserProfileDeviceCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String recordUpdateTypeId;

	public String getRecordUpdateTypeId() {
		return this.recordUpdateTypeId;
	}

	public void setRecordUpdateTypeId(String recordUpdateTypeId) {
		this.recordUpdateTypeId = recordUpdateTypeId;
	}

	@Override
	public String toString() {
		return "CustUserProfileDeviceMngmtEntity [recordUpdateTypeId=" + recordUpdateTypeId + ", toString()"
				+ super.toString() + "]";
	}

}
