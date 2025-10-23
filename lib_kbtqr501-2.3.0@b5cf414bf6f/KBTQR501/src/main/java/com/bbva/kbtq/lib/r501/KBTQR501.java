package com.bbva.kbtq.lib.r501;

import com.bbva.kbtq.dto.c101.entities.CustomerEntity;

import java.util.List;

public interface KBTQR501 {

	CustomerEntity executeGetCustomerById(String customerId);

	List<CustomerEntity> executeGetCustomerListById(List<String> customerIdList);

	CustomerEntity executeReadCustomerIdentityDocument(String personalId, String personalType);
}
