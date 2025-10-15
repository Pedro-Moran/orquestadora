package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.beans.RelatedFunctionality;
import com.bbva.kusu.dto.users.entity.CapabilitySmcEntity;

public class RelatedFunctionalityMapper {

	private RelatedFunctionalityMapper() {

	}

	public static RelatedFunctionality mapFromCapabilityFunctionalityEntity(CapabilitySmcEntity entity) {
		RelatedFunctionality res = new RelatedFunctionality();
		res.setId(entity.getGfSmcInternalId());
		res.setHasSignaturePower(Boolean.valueOf(true));
		return res;
	}

}
