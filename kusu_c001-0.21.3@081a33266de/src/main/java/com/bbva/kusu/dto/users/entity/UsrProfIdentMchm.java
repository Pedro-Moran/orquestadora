package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class UsrProfIdentMchm extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gUserAccountId;
	private String gSecurityMechanismId;
	private String gfChannelId;
	private String gfOperationUserId;
	private String gfEmailDesc;
	private String gfEmailVerifiedType;
	private String gOfflineDelIndType;

	public String getgUserAccountId() {
		return gUserAccountId;
	}

	public void setgUserAccountId(String gUserAccountId) {
		this.gUserAccountId = gUserAccountId;
	}

	public String getgSecurityMechanismId() {
		return gSecurityMechanismId;
	}

	public void setgSecurityMechanismId(String gSecurityMechanismId) {
		this.gSecurityMechanismId = gSecurityMechanismId;
	}

	public String getGfChannelId() {
		return gfChannelId;
	}

	public void setGfChannelId(String gfChannelId) {
		this.gfChannelId = gfChannelId;
	}

	public String getGfOperationUserId() {
		return gfOperationUserId;
	}

	public void setGfOperationUserId(String gfOperationUserId) {
		this.gfOperationUserId = gfOperationUserId;
	}

	public String getGfEmailDesc() {
		return gfEmailDesc;
	}

	public void setGfEmailDesc(String gfEmailDesc) {
		this.gfEmailDesc = gfEmailDesc;
	}

	public String getGfEmailVerifiedType() {
		return gfEmailVerifiedType;
	}

	public void setGfEmailVerifiedType(String gfEmailVerifiedType) {
		this.gfEmailVerifiedType = gfEmailVerifiedType;
	}

	public String getgOfflineDelIndType() { return gOfflineDelIndType; }

	public void setgOfflineDelIndType(String gOfflineDelIndType) { this.gOfflineDelIndType = gOfflineDelIndType; }

	@Override
	public String toString() {
		return "UsrProfIdentMchm [gUserAccountId=" + gUserAccountId + ", gSecurityMechanismId=" + gSecurityMechanismId + ", gfChannelId="
				+ gfChannelId + ", gfOperationUserId=" + gfOperationUserId + ", gfEmailDesc=" + gfEmailDesc + ", gfEmailVerifiedType="
				+ gfEmailVerifiedType + ", gOfflineDelIndType=" + gOfflineDelIndType + ", super.toString()=" + super.toString() + "]";
	}

}
