package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

public class UsrProfCstChanMgmtEntity extends UsrProfCustmChannelEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gRecordUpdateType;

	public String getgRecordUpdateType() {
		return gRecordUpdateType;
	}

	public void setgRecordUpdateType(String gRecordUpdateType) {
		this.gRecordUpdateType = gRecordUpdateType;
	}

	@Override
	public String toString() {
		return "UsrProfCstChanMgmtEntity [gRecordUpdateType=" + gRecordUpdateType + ", super()=" + super.toString() + "]";
	}

}
