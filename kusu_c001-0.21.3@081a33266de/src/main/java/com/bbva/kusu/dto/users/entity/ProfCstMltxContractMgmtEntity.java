package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ProfileMultitaxCommons;
import com.bbva.kusu.dto.users.entity.commons.UserCustomContractBasicCommons;

public class ProfCstMltxContractMgmtEntity extends UserCustomContractBasicCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "ProfCstMltxContractMgmtEntity [super.toString()=" + super.toString() + "]";
	}

}