package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomContractBasicCommons;

public class UserCustomContractMgmtEntity extends UserCustomContractBasicCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "UserCustomContractMgmtEntity [toString()=" + super.toString() + "]";
	}

}
