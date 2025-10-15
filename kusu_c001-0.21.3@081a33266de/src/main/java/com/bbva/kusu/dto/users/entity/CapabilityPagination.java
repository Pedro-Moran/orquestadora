package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.List;

import com.bbva.kusu.dto.users.util.PaginationDTO;

public class CapabilityPagination implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CapabilityEntity> capabilityEntities;
	private PaginationDTO pagination;

	public List<CapabilityEntity> getCapabilityEntities() {
		return capabilityEntities;
	}

	public void setCapabilityEntities(List<CapabilityEntity> capabilityEntities) {
		this.capabilityEntities = capabilityEntities;
	}

	public PaginationDTO getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "CapabilityPagination [capabilityEntities=" + capabilityEntities + ", pagination=" + pagination + "]";
	}

}
