package com.bbva.kbtq.lib.r518.impl;

import com.bbva.kbtq.dto.basicdata.entities.BasicDataEntities;
import com.bbva.kbtq.dto.c400.KbtqAdvices;
import com.bbva.kbtq.dto.catalogs.OutputCatalog;
import com.bbva.kbtq.dto.persons.domain.Customer;
import com.bbva.kbtq.lib.r518.impl.mapper.Mapper;
import com.bbva.kbtq.lib.r518.impl.mapper.MapperCatalogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class KBTQR518CoexistenceCrudImpl extends KBTQR518Abstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(KBTQR518CoexistenceCrudImpl.class);
    private static final String SERVICE_NAME = "basicdata";

    public KBTQR518CoexistenceCrudImpl(KBTQR518Abstract clone){
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
        Customer customer =null;

        Optional<BasicDataEntities> customerEntityOptional = kbtqR807.executeGetBasicDataEntities(id);
        this.getAdviceList().clear();
        if (customerEntityOptional.isPresent()) {
            BasicDataEntities customerEntity = customerEntityOptional.get();
            LOGGER.info("DISTRIBUTED IMPL CUSTOMER ENTITY {}", customerEntity);
            List<OutputCatalog> outputCatalogs = kbtqR410.executeGetListParamName(SERVICE_NAME,
                    MapperCatalogs.mapCatalogs(customerEntity.getCustomerEntity(), customerEntity.getCustomerDocumentEntities()));
            LOGGER.info("OUTPUTCATALOGS {}", outputCatalogs);
            customer = new Mapper(outputCatalogs).toDomain(customerEntity.getCustomerEntity(), customerEntity.getCustomerDocumentEntities());
            LOGGER.info("CUSTOMER {}", customer);
        }else {
            this.getAdviceList().clear();
            this.addAdvice(KbtqAdvices.KBTQ01429036.getId());
        }
        return customer;
    }




}