package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CustomContractRoleCommons;

public class UserCapabilitySmcCounterpartEntity extends CustomContractRoleCommons implements Serializable {

	private static final long serialVersionUID = 3637654846680364306L;

	private String gfSMCId;
	private String gfCommercialProductGrpId;

	// Getters and Setters
	public String getGfSMCId() {
		return gfSMCId;
	}

	public void setGfSMCId(String gfSMCId) {
		this.gfSMCId = gfSMCId;
	}

	public String getGfCommercialProductGrpId() {
		return gfCommercialProductGrpId;
	}

	public void setGfCommercialProductGrpId(String gfCommercialProductGrpId) {
		this.gfCommercialProductGrpId = gfCommercialProductGrpId;
	}

	@Override
	public String toString() {
		return "UserCapabilitySmcCounterpartEntity [gfSMCId=" + gfSMCId + ", gfCommercialProductGrpId=" + gfCommercialProductGrpId + ", toString()="
				+ super.toString() + "]";
	}

}
