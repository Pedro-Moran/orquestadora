package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class PcstAuthMechMgmtEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userAccountId;
	private String channelId;
	private String securityMechanismId;
	private String securityMechanismCustomId;
	private String userMgmtMasterIndType;
	private String offlineDeletedIndType;
	private String recordUpdateType;

	public String getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getSecurityMechanismId() {
		return securityMechanismId;
	}

	public void setSecurityMechanismId(String securityMechanismId) {
		this.securityMechanismId = securityMechanismId;
	}

	public String getSecurityMechanismCustomId() {
		return securityMechanismCustomId;
	}

	public void setSecurityMechanismCustomId(String securityMechanismCustomId) {
		this.securityMechanismCustomId = securityMechanismCustomId;
	}

	public String getUserMgmtMasterIndType() {
		return userMgmtMasterIndType;
	}

	public void setUserMgmtMasterIndType(String userMgmtMasterIndType) {
		this.userMgmtMasterIndType = userMgmtMasterIndType;
	}

	public String getOfflineDeletedIndType() {
		return offlineDeletedIndType;
	}

	public void setOfflineDeletedIndType(String offlineDeletedIndType) {
		this.offlineDeletedIndType = offlineDeletedIndType;
	}

	public String getRecordUpdateType() {
		return recordUpdateType;
	}

	public void setRecordUpdateType(String recordUpdateType) {
		this.recordUpdateType = recordUpdateType;
	}

	@Override
	public String toString() {
		return "PcstAuthMechMgmtEntity [userAccountId=" + userAccountId + ", channelId=" + channelId + ", securityMechanismId=" + securityMechanismId
				+ ", securityMechanismCustomId=" + securityMechanismCustomId + ", userMgmtMasterIndType=" + userMgmtMasterIndType + ", offlineDeletedIndType="
				+ offlineDeletedIndType + ", recordUpdateType=" + recordUpdateType + ", super()=" + super.toString() + "]";
	}

}
