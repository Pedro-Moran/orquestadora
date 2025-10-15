package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class SmcVersionEntity extends AuditParamsCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gfSmcId;
	private String gfSmcInternalId;

	public String getGfSmcId() {
		return this.gfSmcId;
	}

	public void setGfSmcId(String gfSmcId) {
		this.gfSmcId = gfSmcId;
	}

	public String getGfSmcInternalId() {
		return this.gfSmcInternalId;
	}

	public void setGfSmcInternalId(String gfSmcInternalId) {
		this.gfSmcInternalId = gfSmcInternalId;
	}

	@Override
	public String toString() {
		return "SmcVersionEntity [super.toString()=" + super.toString() + ", gfSmcId=" + gfSmcId + ", gfSmcInternalId=" + gfSmcInternalId + "]";
	}

}
