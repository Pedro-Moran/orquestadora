package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class AliasFavCommons extends AuditContAccountCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gfContractAliasName;
	private BigDecimal gPreferredContractId;
	private Timestamp gfAuditDate;
	private String gOperativeContractIndType;
	private String gVisibleContractIndType;
	
	public String getGfContractAliasName() {
		return gfContractAliasName;
	}

	public void setGfContractAliasName(String gfContractAliasName) {
		this.gfContractAliasName = gfContractAliasName;
	}

	public BigDecimal getGPreferredContractId() {
		return this.gPreferredContractId;
	}

	public void setGPreferredContractId(BigDecimal gPreferredContractId) {
		this.gPreferredContractId = gPreferredContractId;
	}

	public Timestamp getGfAuditDate() {
		return gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getgOperativeContractIndType() {
		return gOperativeContractIndType;
	}

	public void setgOperativeContractIndType(String gOperativeContractIndType) {
		this.gOperativeContractIndType = gOperativeContractIndType;
	}

	public String getgVisibleContractIndType() {
		return gVisibleContractIndType;
	}

	public void setgVisibleContractIndType(String gVisibleContractIndType) {
		this.gVisibleContractIndType = gVisibleContractIndType;
	}

	@Override
	public String toString() {
		return "AliasFavCommons [gfContractAliasName=" + gfContractAliasName + ", gPreferredContractId=" + gPreferredContractId + ", gfAuditDate="
				+ gfAuditDate + ", gOperativeContractIndType=" + gOperativeContractIndType + ", gVisibleContractIndType=" + gVisibleContractIndType
				+ ", toString()=" + super.toString() + "]";
	}

}
