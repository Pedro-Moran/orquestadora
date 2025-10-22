package com.bbva.kbtq.lib.r226;

import com.bbva.kbtq.dto.c226.entity.CustomerNationalityEntity;

import java.util.List;
import java.util.Optional;

public interface KBTQR226 {
	Optional<List<CustomerNationalityEntity>> executeGetCustomerNationalities(String customerId);
}
