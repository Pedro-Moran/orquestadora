package com.bbva.kbtq.lib.r226.impl;

import com.bbva.kbtq.dto.c226.entity.CustomerNationalityEntity;
import com.bbva.kbtq.dto.c400.KbtqAdvices;
import com.bbva.kbtq.lib.r226.impl.mapper.Mapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The KBTQR226Impl class...
 */
public class KBTQR226Impl extends KBTQR226Abstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR226Impl.class);
    public static final String KBTQ_READ_CUSTOMER_NATIONALITIES = "KBTQ.readCustomerNationalities";

    @Override
    public Optional<List<CustomerNationalityEntity>> executeGetCustomerNationalities(String customerId) {
        LOGGER.info("customerId: {}", customerId);

        if (StringUtils.isNotEmpty(customerId)) {
            List<Map<String, Object>> mapOut = jdbcUtils.queryForList(KBTQ_READ_CUSTOMER_NATIONALITIES, Mapper.readCustomerNationalities(customerId));
            LOGGER.info("[paramOut] CustomerNationalitiesOut: {}", mapOut);

            if (!mapOut.isEmpty()) {
                List<CustomerNationalityEntity> customerNationalityEntities = Mapper.mapToCustomerNationalitiesEntity(mapOut);
                LOGGER.info("customerNationalityEntities: {}", customerNationalityEntities);
                return Optional.of(customerNationalityEntities);

            } else {
                LOGGER.info("No results found for customerId: {}", customerId);
                addAdvice(KbtqAdvices.KBTQ01429142.getId());
                return Optional.empty();
            }

        } else {
            addAdvice(KbtqAdvices.KBTQ01429000.getId());
        }
        return Optional.empty();
    }
}
