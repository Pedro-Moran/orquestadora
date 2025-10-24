package com.bbva.kbtq.lib.r518.impl.mapper;

import com.bbva.kbtq.dto.c100.entities.CustomerDocumentEntity;
import com.bbva.kbtq.dto.c101.constants.GenericConstants;
import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.dto.c101.enums.CustomerTypeValues;
import com.bbva.kbtq.dto.catalogs.OutputCatalog;
import com.bbva.kbtq.dto.persons.domain.Bank;
import com.bbva.kbtq.dto.persons.domain.Branch;
import com.bbva.kbtq.dto.persons.domain.Customer;
import com.bbva.kbtq.dto.persons.domain.HighValueCustomer;
import com.bbva.kbtq.dto.persons.domain.Status;
import com.bbva.kbtq.dto.persons.domain.TaxResidence;
import com.bbva.kbtq.dto.persons.domain.TaxpayerIdentification;
import com.bbva.kbtq.dto.persons.domain.economicData.PersonType;
import com.bbva.kbtq.dto.persons.domain.shared.Country;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.ENTITYID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.PERSONMAINBRANCHID;

public class Mapper {
    private final Logger LOGGER = LoggerFactory.getLogger(Mapper.class);
    private final List<OutputCatalog> outputCatalogs;

    public Mapper(List<OutputCatalog> outputCatalogs) {
        this.outputCatalogs = outputCatalogs;
    }

    public Customer toDomain(CustomerEntity customerEntity, List<CustomerDocumentEntity> customerDocumentEntities) {
        LOGGER.info("DISTRIBUTED IMPL CUSTOMER ENTITY {}", customerEntity);
        LOGGER.info("CUSTOMERDOCUMENTENTITIES {}", customerDocumentEntities);
        LOGGER.info("OUTPUTCATALOGS {}", outputCatalogs);

        if (checkCustomerEntity(customerEntity)) {
            Customer customer = new Customer();
            PersonType personType = new PersonType();
            customer.setId(customerEntity.getId());
            personType.setId(customerEntity.getGfCustomerType());

            if (GenericConstants.JURIDCA.equalsIgnoreCase(CustomerTypeValues.getTypeValues(customerEntity.getGfCustomerType()))) {
                LOGGER.info("JURIDICA");
                personType.setLegalPersonType(new MapperBusiness(outputCatalogs).generateLegalPersonType(customerEntity, customerDocumentEntities));
            } else {
                LOGGER.info("NATURAL");
                personType.setNaturalPersonType(new MapperCustomer(outputCatalogs).generateNaturalPersonType(customerEntity, customerDocumentEntities));
            }

            LOGGER.info("PERSONTYPE {}", personType);
            customer.setCreationDate(customerEntity.getGfCustomerEntryDate());
            customer.setPersonType(personType);

            customer.setBank(generateBank(customerEntity));
            customer.setTaxResidence(generateTaxResidence(customerEntity));
            customer.setHighValueCustomer(generateHighValueCustomer(customerEntity));
            customer.setTaxpayerIdentification(generateTaxpayerIdentification(customerEntity));
            customer.setStatus(generateStatus(customerEntity));

            LOGGER.info("CUSTOMER {}", customer);
            return customer;
        }
        return null;
    }

    private boolean checkCustomerEntity(CustomerEntity customerEntity) {
        return customerEntity != null
                && StringUtils.isNotBlank(customerEntity.getId())
                && StringUtils.isNotBlank(customerEntity.getGfFirstName())
                && StringUtils.isNotBlank(customerEntity.getGfPersonalType())
                && StringUtils.isNotBlank(customerEntity.getGfCustomerType())
                && customerEntity.getGfCustomerEntryDate() != null;
    }

    private Bank generateBank(CustomerEntity customerEntity) {
        if (StringUtils.isNotBlank(customerEntity.getGfEntityId())) {
            Bank bank = new Bank();
            bank.setId(customerEntity.getGfEntityId());
            bank.setDescription(MapperCatalogs.getDescription(ENTITYID, customerEntity.getGfEntityId(), outputCatalogs));
            if (StringUtils.isNotBlank(customerEntity.getgPersonMainBranchId())) {
                Branch branch = new Branch();
                branch.setId(customerEntity.getgPersonMainBranchId());

                if (customerEntity.getgPersonMainBranchId().length() == 6) {
                    customerEntity.setgPersonMainBranchId(customerEntity.getgPersonMainBranchId().substring(2, 6));
                }

                if (StringUtils.isNotBlank(customerEntity.getgCountryId())) {
                    String mainBranchForDesc = customerEntity.getgCountryId() + customerEntity.getGfEntityId() + customerEntity.getgPersonMainBranchId();
                    branch.setDescription(MapperCatalogs.getDescription(PERSONMAINBRANCHID, mainBranchForDesc, outputCatalogs));
                }

                bank.setBranch(branch);
            }
            return bank;
        }
        return null;
    }

    private TaxResidence generateTaxResidence(CustomerEntity customerEntity) {
        TaxResidence taxResidence = null;
        if (StringUtils.isNotBlank(customerEntity.getGResidenceCountryId())) {
            taxResidence = new TaxResidence();
            Country country = new Country();
            country.setId(customerEntity.getGResidenceCountryId());
            taxResidence.setCountry(country);
        }
        return taxResidence;
    }

    private HighValueCustomer generateHighValueCustomer(CustomerEntity customerEntity) {
        HighValueCustomer highValueCustomer = null;
        if (StringUtils.isNotBlank(customerEntity.getgCavaCustomerType())) {
            highValueCustomer = new HighValueCustomer();
            highValueCustomer.setId(customerEntity.getgCavaCustomerType());
        }
        return highValueCustomer;
    }

    private TaxpayerIdentification generateTaxpayerIdentification(CustomerEntity customerEntity) {
        TaxpayerIdentification taxpayerIdentification = null;
        if (StringUtils.isNotBlank(customerEntity.getGfTaxpayerId())) {
            taxpayerIdentification = new TaxpayerIdentification();
            taxpayerIdentification.setDocumentNumber(customerEntity.getGfTaxpayerId());
        }
        return taxpayerIdentification;
    }

    private Status generateStatus(CustomerEntity customerEntity) {
        Status status = null;
        if (StringUtils.isNotBlank(customerEntity.getGfCustomerStatusType())) {
            status = new Status();
            status.setId(customerEntity.getGfCustomerStatusType());
            status.setDescription(MapperCatalogs.getDescription(ConstantCatalogs.CUSTOMERSTATUSTYPE, customerEntity.getGfCustomerStatusType(), outputCatalogs));
        }
        return status;
    }
}