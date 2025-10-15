package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class CustPackageSmcEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String relatedSmcPackageId;
	private String smcInternalId;

	public String getRelatedSmcPackageId() {
		return relatedSmcPackageId;
	}

	public void setRelatedSmcPackageId(String relatedSmcPackageId) {
		this.relatedSmcPackageId = relatedSmcPackageId;
	}

	public String getSmcInternalId() {
		return smcInternalId;
	}

	public void setSmcInternalId(String smcInternalId) {
		this.smcInternalId = smcInternalId;
	}

	@Override
	public String toString() {
		return "CustPackageSmcEntity [super()=" + super.toString() + ", relatedSmcPackageId=" + relatedSmcPackageId + ", smcInternalId=" + smcInternalId + "]";
	}

}
