package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.util.PaginationDTO;
import java.io.Serializable;
import java.util.List;

public class CustUserProfilePagination implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CustUserProfileEntity> custUserProfileEntities;

	private PaginationDTO pagination;

	public List<CustUserProfileEntity> getCustUserProfileEntities() {
		return this.custUserProfileEntities;
	}

	public void setCustUserProfileEntities(List<CustUserProfileEntity> custUserProfileEntities) {
		this.custUserProfileEntities = custUserProfileEntities;
	}

	public PaginationDTO getPagination() {
		return this.pagination;
	}

	public void setPaginationDTO(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "CustUserProfilePagination [custUserProfileEntities=" + custUserProfileEntities + ", pagination="
				+ pagination + "]";
	}
}
