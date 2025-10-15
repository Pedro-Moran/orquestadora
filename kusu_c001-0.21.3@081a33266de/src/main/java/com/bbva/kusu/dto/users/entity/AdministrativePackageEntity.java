package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

public class AdministrativePackageEntity extends AuditParamsCommons implements Serializable {

	private static final long serialVersionUID = 1L;

	private String gdAdminSmcPackageId;
	private String gfAdminSmcPackageDesc;

	public String getGdAdminSmcPackageId() {
		return gdAdminSmcPackageId;
	}

	public void setGdAdminSmcPackageId(String gdAdminSmcPackageId) {
		this.gdAdminSmcPackageId = gdAdminSmcPackageId;
	}

	public String getGfAdminSmcPackageDesc() {
		return gfAdminSmcPackageDesc;
	}

	public void setGfAdminSmcPackageDesc(String gfAdminSmcPackageDesc) {
		this.gfAdminSmcPackageDesc = gfAdminSmcPackageDesc;
	}

	@Override
	public String toString() {
		return "AdministrativePackageEntity [gdAdminSmcPackageId=" + gdAdminSmcPackageId + ", gfAdminSmcPackageDesc=" + gfAdminSmcPackageDesc + ", super()="
				+ super.toString() + "]";
	}
}
