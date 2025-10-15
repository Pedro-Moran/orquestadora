package com.bbva.kusu.dto.users.entity;

import java.util.List;

import com.bbva.kusu.dto.users.util.PaginationDTO;

public class ProfAuthMechanismsPagination {

	private List<ProfAuthMechanismsEntity> profAuthMechanismsEntities;

	private PaginationDTO pagination;

	public List<ProfAuthMechanismsEntity> getProfAuthMechanismsEntities() {
		return profAuthMechanismsEntities;
	}

	public void setProfAuthMechanismsEntities(List<ProfAuthMechanismsEntity> profAuthMechanismsEntities) {
		this.profAuthMechanismsEntities = profAuthMechanismsEntities;
	}

	public PaginationDTO getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "ProfAuthMechanismsPagination [profAuthMechanismsEntities=" + profAuthMechanismsEntities
				+ ", pagination=" + pagination + "]";
	}
	
}
