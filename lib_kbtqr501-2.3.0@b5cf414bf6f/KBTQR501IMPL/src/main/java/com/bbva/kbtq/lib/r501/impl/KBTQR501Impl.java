package com.bbva.kbtq.lib.r501.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.dto.c400.KbtqAdvices;

/**
 * The interface KBTQR501Impl class...
 */
public class KBTQR501Impl extends KBTQR501Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR501Impl.class);

	@Override
	public CustomerEntity executeReadCustomerIdentityDocument(String personalId, String personalType) {
		if (StringUtils.isNotBlank(personalId) && StringUtils.isNotBlank(personalType)) {
			return kbtqR110.executeReadCustomerIdentityDocument(personalId, personalType);
		}
		this.addAdvice(KbtqAdvices.KBTQ01429000.getId());
		return null;
	}

	@Override
	public CustomerEntity executeGetCustomerById(String customerId) {
		if (StringUtils.isNotBlank(customerId)) {
			return kbtqR110.executeReadCustomer(customerId);
		}
		this.addAdvice(KbtqAdvices.KBTQ01429000.getId());
		return null;
	}

	@Override
	public List<CustomerEntity> executeGetCustomerListById(List<String> customerIdList) {
		if (customerIdList != null && !customerIdList.isEmpty()) {
			return kbtqR110.executeReadCustomerListByIdsList(customerIdList);
		}
		this.addAdvice(KbtqAdvices.KBTQ01429000.getId());
		return null;
	}
}
