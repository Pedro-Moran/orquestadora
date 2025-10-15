package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.bbva.kusu.dto.users.entity.commons.RoleCapabilitySmcidsCommons;

public class SmcAttributeEntity extends RoleCapabilitySmcidsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gSpecificAttributeId;
	private String gfUserAuditId;
	private Timestamp gfAuditDate;

	public String getgSpecificAttributeId() {
		return gSpecificAttributeId;
	}

	public void setgSpecificAttributeId(String gSpecificAttributeId) {
		this.gSpecificAttributeId = gSpecificAttributeId;
	}

	public String getGSpecificAttributeId() {
		return getgSpecificAttributeId();
	}
	
	public void setGSpecificAttributeId(String gSpecificAttributeId) {	
		this.setgSpecificAttributeId(gSpecificAttributeId);
	}
	
	public String getGfUserAuditId() {
		return gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	@Override
	public String toString() {
		return "SmcAttributeEntity [super.toString()=" + super.toString() + ", gSpecificAttributeId=" + gSpecificAttributeId + ", gfUserAuditId="
				+ gfUserAuditId + ", gfAuditDate=" + gfAuditDate + "]";
	}

}
