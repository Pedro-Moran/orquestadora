package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.util.PaginationDTO;
import java.io.Serializable;
import java.util.List;

public class RolePagination implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<RoleEntity> roleEntities;
	private PaginationDTO pagination;

	public List<RoleEntity> getRoleEntities() {
		return this.roleEntities;
	}

	public void setRoleEntities(List<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}

	public PaginationDTO getPagination() {
		return this.pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "RolePagination [roleEntities=" + roleEntities + ", pagination=" + pagination + "]";
	}

}
