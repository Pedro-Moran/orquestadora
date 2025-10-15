package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.beans.Role;
import com.bbva.kusu.dto.users.beans.RolesPagination;
import com.bbva.kusu.dto.users.entity.RoleEntity;
import com.bbva.kusu.dto.users.entity.RolePagination;
import java.sql.Timestamp;
import java.util.ArrayList;

public class RoleMapper {

	private RoleMapper() {

	}

	public static RoleEntity setRole(String name, String auditUser) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setGfUserRoleName(name);
		roleEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		roleEntity.setGfUserAuditId(auditUser);
		return roleEntity;
	}

	public static Role setRoleFromRoleEntity(RoleEntity role) {
		Role res = null;
		if (role != null) {
			res = new Role();
			res.setDescription(role.getGfUserRoleName());
			res.setId(role.getGfUserRoleId());
		}
		return res;
	}

	public static RolesPagination setRolePaginationFromRolePaginationEntity(RolePagination role) {
		RolesPagination res = null;
		if (role != null) {
			res = new RolesPagination();
			if (role.getRoleEntities() != null && !role.getRoleEntities().isEmpty()) {
				res.setRoles(new ArrayList<>());
				for (RoleEntity r : role.getRoleEntities())
					res.getRoles().add(setRoleFromRoleEntity(r));
			}
			res.setPagination(role.getPagination());
		}
		return res;
	}
}
