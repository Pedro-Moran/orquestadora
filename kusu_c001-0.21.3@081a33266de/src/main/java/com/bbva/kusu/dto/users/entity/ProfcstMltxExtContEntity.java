package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ExternalContractCommons;

public class ProfcstMltxExtContEntity extends ExternalContractCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gCustomerId;

	public String getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(String gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	@Override
	public String toString() {
		return "ProfcstMltxextCtrMgEntity [gCustomerId=" + gCustomerId + ", super.toString()=" + super.toString() + "]";
	}

}