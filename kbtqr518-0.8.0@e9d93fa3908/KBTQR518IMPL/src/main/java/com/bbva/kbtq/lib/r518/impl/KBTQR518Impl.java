package com.bbva.kbtq.lib.r518.impl;

import com.bbva.kbtq.dto.c400.coexistence.CoexistenceType;
import com.bbva.kbtq.dto.persons.domain.Customer;
import com.bbva.kbtq.lib.r518.KBTQR518;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Optional;


public class KBTQR518Impl extends KBTQR518Abstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR518Impl.class);
    private static final String PROPERTY_COEXISTENCE_TYPE = "kbtq.lib.kbtqr518.coexistence.type";

    @Override
    public Customer executeGetCustomer(String id) {
        KBTQR518 kbtqr518 = null;
        if (id != null && !id.isEmpty()) {

            Optional<String> value = this.kbtqR404.executeGetProperty(PROPERTY_COEXISTENCE_TYPE);
            CoexistenceType coexistenceType = CoexistenceType.getType(value.orElse(""));
            switch (coexistenceType) {
                case COEXISTENCE_TIMESTAMP:
                    kbtqr518 = new KBTQR518CoexistenceImpl(this);
                    break;
                case COEXISTENCE_TIMESTAMP_CRUD:
                    kbtqr518 = new KBTQR518CoexistenceCrudImpl(this);
                    break;
                case DISTRIBUTED:
                default:
                    kbtqr518 = new KBTQR518DistributedImpl(this);
                    break;

            }
        }

        return kbtqr518 != null ? kbtqr518.executeGetCustomer(id) : null;
    }

}