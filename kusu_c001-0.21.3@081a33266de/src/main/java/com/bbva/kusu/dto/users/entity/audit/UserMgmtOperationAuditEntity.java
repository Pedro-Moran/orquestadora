package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class UserMgmtOperationAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "user_mgmt_operation")
	private String userMgmtOperation;

	public String getUserMgmtOperation() {
		return userMgmtOperation;
	}

	public void setUserMgmtOperation(String userMgmtOperation) {
		this.userMgmtOperation = userMgmtOperation;
	}

	@Override
	public String toString() {
		return "UserMgmtOperationAuditEntity [userMgmtOperation=" + userMgmtOperation + "]";
	}

}
