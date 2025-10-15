package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.UserCustomSmcCommons;

public class UsrCstmSmcAtrbMgmtEntity extends UserCustomSmcCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gSpecificAttributeId;

	private String gRecordUpdateType;

	public String getGSpecificAttributeId() {
		return this.gSpecificAttributeId;
	}

	public void setGSpecificAttributeId(String gSpecificAttributeId) {
		this.gSpecificAttributeId = gSpecificAttributeId;
	}

	public String getGRecordUpdateType() {
		return this.gRecordUpdateType;
	}

	public void setGRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	@Override
	public String toString() {
		return "UsrCstmSmcAtrbMgmtEntity [gSpecificAttributeId=" + gSpecificAttributeId + ", gRecordUpdateType=" + gRecordUpdateType + ", toString()="
				+ super.toString() + "]";
	}

}
