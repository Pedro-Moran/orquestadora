package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.util.PaginationDTO;
import java.io.Serializable;
import java.util.List;

public class UserCustomContractJoinAliasFavRoleCapMgmtPagination implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<UserCustomContractJoinAliasFavRoleCapMgmtEntity> userCustomContractJoinAliasFavRoleCapabilityEntities;

	private PaginationDTO pagination;

	public List<UserCustomContractJoinAliasFavRoleCapMgmtEntity> getUserCustomContractJoinAliasFavRoleCapabilityEntities() {
		return this.userCustomContractJoinAliasFavRoleCapabilityEntities;
	}

	public void setUserCustomContractJoinAliasFavRoleCapabilityEntities(
			List<UserCustomContractJoinAliasFavRoleCapMgmtEntity> userCustomContractJoinAliasFavEntities) {
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
		return "UserCustomContractJoinAliasFavRoleCapMgmtPagination [userCustomContractJoinAliasFavRoleCapabilityEntities="
				+ userCustomContractJoinAliasFavRoleCapabilityEntities + ", pagination=" + pagination + "]";
	}
}
