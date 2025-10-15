package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.bbva.kusu.dto.users.beans.SpecificAttribute;
import com.bbva.kusu.dto.users.beans.SpecificAttributesPagination;
import com.bbva.kusu.dto.users.entity.SpecificAttributeEntity;
import com.bbva.kusu.dto.users.entity.SpecificAttributePagination;

public class SpecificAttributeMapper {

	private SpecificAttributeMapper() {

	}

	public SpecificAttributeEntity setSpecificAttribute(String id, String description, String auditUser) {
		SpecificAttributeEntity specificAttributeEntity = new SpecificAttributeEntity();
		specificAttributeEntity.setgSpecificAttributeId(id);
		specificAttributeEntity.setgSpecificAttributedName(description);
		specificAttributeEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		specificAttributeEntity.setGfUserAuditId(auditUser);
		return specificAttributeEntity;
	}

	public static SpecificAttribute setSpecificAttributeFromSpecificAttributeEntity(SpecificAttributeEntity specificAttributeEntity) {
		SpecificAttribute specificAttribute = null;
		if (specificAttributeEntity != null) {
			specificAttribute = new SpecificAttribute();
			specificAttribute.setDescription(specificAttributeEntity.getgSpecificAttributedName());
			specificAttribute.setId(specificAttributeEntity.getgSpecificAttributeId());
		}
		return specificAttribute;
	}

	public static SpecificAttributesPagination setSpecificAttributesPaginationFromSpecificAttributesPaginationEntity(
			SpecificAttributePagination specificAttributePagination) {
		
		SpecificAttributesPagination specificAttribute = null;
		if (specificAttributePagination != null) {
			specificAttribute = new SpecificAttributesPagination();
			if (specificAttributePagination.getSpecificAttributes() != null && !specificAttributePagination.getSpecificAttributes().isEmpty()) {
				specificAttribute.setSpecificAttribute(new ArrayList<>());
				for (SpecificAttributeEntity c : specificAttributePagination.getSpecificAttributes())
					specificAttribute.getSpecificAttribute().add(setSpecificAttributeFromSpecificAttributeEntity(c));
			}
			specificAttribute.setPagination(specificAttributePagination.getPagination());
		}
		return specificAttribute;
	}

}
