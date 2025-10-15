package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.bbva.kusu.dto.users.beans.Capability;
import com.bbva.kusu.dto.users.beans.CapabilitiesPagination;
import com.bbva.kusu.dto.users.entity.CapabilityEntity;
import com.bbva.kusu.dto.users.entity.CapabilityPagination;

public class CapabilityMapper {

	private CapabilityMapper() {

	}

	public CapabilityEntity setCapability(String id, String description, String auditUser) {
		CapabilityEntity capabilityEntity = new CapabilityEntity();
		capabilityEntity.setGfUserCapabilityId(id);
		capabilityEntity.setGfUserCapabilityName(description);
		capabilityEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		capabilityEntity.setGfUserAuditId(auditUser);
		return capabilityEntity;
	}

	public static Capability setCapabilityFromCapabilityEntity(CapabilityEntity capabilityEntity) {
		Capability capability = null;
		if (capabilityEntity != null) {
			capability = new Capability();
			capability.setDescription(capabilityEntity.getGfUserCapabilityName());
			capability.setId(capabilityEntity.getGfUserCapabilityId());
		}
		return capability;
	}

	public static CapabilitiesPagination setCapabilityPaginationFromCapabilityPaginationEntity(CapabilityPagination capabilityPagination) {
		CapabilitiesPagination caps = null;
		if (capabilityPagination != null) {
			caps = new CapabilitiesPagination();
			if (capabilityPagination.getCapabilityEntities() != null && !capabilityPagination.getCapabilityEntities().isEmpty()) {
				caps.setCapabilities(new ArrayList<>());
				for (CapabilityEntity capEnt : capabilityPagination.getCapabilityEntities())
					caps.getCapabilities().add(setCapabilityFromCapabilityEntity(capEnt));
			}
			caps.setPagination(capabilityPagination.getPagination());
		}
		return caps;
	}

}
