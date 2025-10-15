package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UprofIdentMchmMgmtEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userAccountId;
	private String securityMechanismId;
	private String channelId;
	private String operationUserId;
	private String recordUpdateType;

	public String getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getSecurityMechanismId() {
		return securityMechanismId;
	}

	public void setSecurityMechanismId(String securityMechanismId) {
		this.securityMechanismId = securityMechanismId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getOperationUserId() {
		return operationUserId;
	}

	public void setOperationUserId(String operationUserId) {
		this.operationUserId = operationUserId;
	}

	public String getRecordUpdateType() {
		return recordUpdateType;
	}

	public void setRecordUpdateType(String recordUpdateType) {
		this.recordUpdateType = recordUpdateType;
	}

	@Override
	public String toString() {
		return "UprofIdentMchmMgmtEntity [userAccountId=" + userAccountId + ", securityMechanismId=" + securityMechanismId + ", channelId=" + channelId
				+ ", operationUserId=" + operationUserId + ", recordUpdateType=" + recordUpdateType + ", super()=" + super.toString() + "]";
	}

}