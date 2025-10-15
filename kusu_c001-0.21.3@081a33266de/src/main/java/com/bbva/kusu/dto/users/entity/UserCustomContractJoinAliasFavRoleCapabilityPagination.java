package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.util.PaginationDTO;
import java.io.Serializable;
import java.util.List;

public class UserCustomContractJoinAliasFavRoleCapabilityPagination implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<UserCustomContractJoinAliasFavRoleCapabilityEntity> userCustomContractJoinAliasFavRoleCapabilityEntities;

	private PaginationDTO pagination;

	public List<UserCustomContractJoinAliasFavRoleCapabilityEntity> getUserCustomContractJoinAliasFavRoleCapabilityEntities() {
		return this.userCustomContractJoinAliasFavRoleCapabilityEntities;
	}

	public void setUserCustomContractJoinAliasFavRoleCapabilityEntities(
			List<UserCustomContractJoinAliasFavRoleCapabilityEntity> userCustomContractJoinAliasFavEntities) {
		this.userCustomContractJoinAliasFavRoleCapabilityEntities = userCustomContractJoinAliasFavEntities;
	}

	public PaginationDTO getPagination() {
		return this.pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "UserCustomContractJoinAliasFavRoleCapabilityPagination [userCustomContractJoinAliasFavRoleCapabilityEntities="
				+ userCustomContractJoinAliasFavRoleCapabilityEntities + ", pagination=" + pagination + "]";
	}
}
