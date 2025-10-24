package com.bbva.kbtq.lib.r518.impl;

import com.bbva.kbtq.dto.c100.entities.CustomerDocumentEntity;
import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.dto.c400.KbtqAdvices;
import com.bbva.kbtq.dto.catalogs.OutputCatalog;
import com.bbva.kbtq.dto.persons.domain.Customer;
import com.bbva.kbtq.lib.r518.impl.mapper.Mapper;
import com.bbva.kbtq.lib.r518.impl.mapper.MapperCatalogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class KBTQR518DistributedImpl extends KBTQR518Abstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR518DistributedImpl.class);
    private static final String SERVICE_NAME = "basicdata";

    public KBTQR518DistributedImpl(KBTQR518Abstract clone) {
        this.setApplicationConfigurationService(clone.applicationConfigurationService);
        this.setKbtqR110(clone.kbtqR110);
        this.setKbtqR115(clone.kbtqR115);
        this.setKbtqR404(clone.kbtqR404);
        this.setKbtqR718(clone.kbtqR718);
        this.setKbtqR807(clone.kbtqR807);
        this.setKbtqR410(clone.kbtqR410);
    }

    @Override
    public Customer executeGetCustomer(String id) {
        LOGGER.info("DISTRIBUTED IMPL {}", id);
        CustomerEntity customerEntity = this.kbtqR110.executeReadCustomer(id);
        LOGGER.info("DISTRIBUTED IMPL CUSTOMER ENTITY {}", customerEntity);
        this.getAdviceList().clear();
        if (customerEntity != null) {
            List<CustomerDocumentEntity> customerDocumentEntities = this.kbtqR115.executeListCustomerDocument(customerEntity.getId());
            LOGGER.info("DISTRIBUTED IMPL CUSTOMER DOCUMENT ENTITY {}", customerDocumentEntities);
            this.getAdviceList().removeIf(a -> KbtqAdvices.KBTQ01429036.getId().equals(a.getCode()));
            List<OutputCatalog> outputCatalogs = kbtqR410.executeGetListParamName(SERVICE_NAME, MapperCatalogs.mapCatalogs(customerEntity, customerDocumentEntities));
            Customer customer = new Mapper(outputCatalogs).toDomain(customerEntity, customerDocumentEntities);
            if (customer != null) {
                return customer;
            }
        }
        this.addAdvice(KbtqAdvices.KBTQ01429036.getId());
        return null;
    }

}