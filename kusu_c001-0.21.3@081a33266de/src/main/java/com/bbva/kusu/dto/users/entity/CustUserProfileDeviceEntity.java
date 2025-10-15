package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CustUserProfileDeviceCommons;

public class CustUserProfileDeviceEntity extends CustUserProfileDeviceCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "CustUserProfileDeviceEntity [toString()=" + super.toString() + "]";
	}

}
