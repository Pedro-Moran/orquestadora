package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.List;

import com.bbva.kusu.dto.users.util.PaginationDTO;

public class SpecificAttributePagination implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SpecificAttributeEntity> specificAttributes;
	private PaginationDTO pagination;

	public List<SpecificAttributeEntity> getSpecificAttributes() {
		return specificAttributes;
	}

	public void setSpecificAttributes(List<SpecificAttributeEntity> specificAttributes) {
		this.specificAttributes = specificAttributes;
	}

	public PaginationDTO getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "SpecificAttributePagination [specificAttributes=" + specificAttributes + ", pagination=" + pagination + "]";
	}

}
