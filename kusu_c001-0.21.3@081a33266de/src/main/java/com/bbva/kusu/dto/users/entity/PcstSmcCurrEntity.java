package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CustomContractRoleCommons;

public class PcstSmcCurrEntity extends CustomContractRoleCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;

	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	@Override
	public String toString() {
		return "PcstSmcCurrEntity [gUserAccountId=" + gUserAccountId + ", super()=" + super.toString() + "]";
	}

}