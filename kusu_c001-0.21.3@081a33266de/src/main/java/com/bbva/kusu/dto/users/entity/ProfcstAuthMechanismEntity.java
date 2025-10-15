package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.ProfileMultitaxCommons;

public class ProfcstAuthMechanismEntity extends ProfileMultitaxCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gfChannelId;
	private String gSecurityMechanismId;
	private String gSecurityMechanismCustomId;
	private String gUserMgmtMasterIndType;

	public String getGfChannelId() {
		return gfChannelId;
	}

	public void setGfChannelId(String gfChannelId) {
		this.gfChannelId = gfChannelId;
	}

	public String getgSecurityMechanismId() {
		return gSecurityMechanismId;
	}

	public void setgSecurityMechanismId(String gSecurityMechanismId) {
		this.gSecurityMechanismId = gSecurityMechanismId;
	}

	public String getgSecurityMechanismCustomId() {
		return gSecurityMechanismCustomId;
	}

	public void setgSecurityMechanismCustomId(String gSecurityMechanismCustomId) {
		this.gSecurityMechanismCustomId = gSecurityMechanismCustomId;
	}

	public String getgUserMgmtMasterIndType() {
		return gUserMgmtMasterIndType;
	}

	public void setgUserMgmtMasterIndType(String gUserMgmtMasterIndType) {
		this.gUserMgmtMasterIndType = gUserMgmtMasterIndType;
	}

	@Override
	public String toString() {
		return "ProfcstAuthMechanismEntity [gfChannelId=" + gfChannelId + ", gSecurityMechanismId=" + gSecurityMechanismId
				+ ", gSecurityMechanismCustomId=" + gSecurityMechanismCustomId + ", gUserMgmtMasterIndType=" + gUserMgmtMasterIndType
				+ ", super.toString()=" + super.toString() + "]";
	}

}