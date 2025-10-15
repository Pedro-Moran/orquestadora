package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.UserDeviceCommons;

public class UserDeviceEntity extends UserDeviceCommons implements Serializable {
	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "UserDeviceEntity [toString()=" + super.toString() + "]";
	}

}
