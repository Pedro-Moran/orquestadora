package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class SpecificAttributeEntity extends AuditParamsCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gSpecificAttributeId;
	private String gSpecificAttributedName;

	public String getgSpecificAttributeId() {
		return this.gSpecificAttributeId;
	}

	public void setgSpecificAttributeId(String gSpecificAttributeId) {
		this.gSpecificAttributeId = gSpecificAttributeId;
	}

	public String getgSpecificAttributedName() {
		return this.gSpecificAttributedName;
	}

	public void setgSpecificAttributedName(String gSpecificAttributedName) {
		this.gSpecificAttributedName = gSpecificAttributedName;
	}

	@Override
	public String toString() {
		return "SpecificAttributeEntity [super.toString()=" + super.toString() + ", gSpecificAttributeId=" + gSpecificAttributeId
				+ ", gSpecificAttributedName=" + gSpecificAttributedName + "]";
	}

}
