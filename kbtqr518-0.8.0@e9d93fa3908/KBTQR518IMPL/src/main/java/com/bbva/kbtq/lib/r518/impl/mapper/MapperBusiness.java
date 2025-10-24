package com.bbva.kbtq.lib.r518.impl.mapper;

import com.bbva.kbtq.dto.c100.entities.CustomerDocumentEntity;
import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.dto.c101.utils.Utils;
import com.bbva.kbtq.dto.catalogs.OutputCatalog;
import com.bbva.kbtq.dto.persons.domain.BusinessDocument;
import com.bbva.kbtq.dto.persons.domain.BusinessDocumentType;
import com.bbva.kbtq.dto.persons.domain.IncapacitationType;
import com.bbva.kbtq.dto.persons.domain.State;
import com.bbva.kbtq.dto.persons.domain.Status;
import com.bbva.kbtq.dto.persons.domain.economicData.LegalPersonType;
import com.bbva.kbtq.dto.persons.domain.shared.Country;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.EXPEDITIONDOCCOUNTRYID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.EXPEDITIONDOCSTATEID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.PERSONALSTATUSTYPE;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.PERSONALTYPE;

public class MapperBusiness {
    private final List<OutputCatalog> outputCatalogs;


    public MapperBusiness(List<OutputCatalog> outputCatalogs) {
        this.outputCatalogs = outputCatalogs;
    }

    public LegalPersonType generateLegalPersonType(CustomerEntity customerEntity, List<CustomerDocumentEntity> customerDocumentEntities) {
        LegalPersonType legalPersonType = new LegalPersonType();
        legalPersonType.setLegalName(customerEntity.getGfFirstName());
        legalPersonType.setDoingBusinessAs(customerEntity.getGfCompanyTradeName());
        legalPersonType.setCountry(generateCountry(customerEntity.getGCountryId()));
        legalPersonType.setBusinessDocuments(getBusinessDocuments(customerEntity, customerDocumentEntities));
        legalPersonType.setIncapacitationType(generateIncapacitationType(customerEntity));
        return legalPersonType;
    }

    public List<BusinessDocument> getBusinessDocuments(CustomerEntity customerEntity, List<CustomerDocumentEntity> customerDocumentEntities) {
        List<BusinessDocument> listDocuments = generateBusinessDocuments(customerDocumentEntities);
        BusinessDocument document = generatePrincipalBusinessDocument(customerEntity);
        if (document != null) {
            if (listDocuments != null && !listDocuments.isEmpty()) {
                if (listDocuments.stream().noneMatch(d -> d.getDocumentNumber().equals(document.getDocumentNumber())
                        && d.getBusinessDocumentType().getId().equals(document.getBusinessDocumentType().getId()))) {
                    listDocuments.add(document);
                }
            } else {
                listDocuments = Collections.singletonList(document);
            }
        }
        return listDocuments;
    }

    private List<BusinessDocument> generateBusinessDocuments(List<CustomerDocumentEntity> customerDocumentEntities) {
        List<BusinessDocument> businessDocuments = null;
        if (customerDocumentEntities != null && !customerDocumentEntities.isEmpty()) {
            businessDocuments = customerDocumentEntities.stream().map(this::generateBusinessDocument).collect(Collectors.toList());
        }
        return businessDocuments;
    }

    private BusinessDocument generateBusinessDocument(CustomerDocumentEntity customerDocumentEntity) {
        BusinessDocument businessDocument = new BusinessDocument();

        BusinessDocumentType businessDocumentType = new BusinessDocumentType();
        businessDocumentType.setId(customerDocumentEntity.getGfPersonalType());
        businessDocumentType.setName(MapperCatalogs.getDescription(PERSONALTYPE, customerDocumentEntity.getGfPersonalType(), outputCatalogs));
        businessDocument.setBusinessDocumentType(businessDocumentType);

        businessDocument.setDocumentNumber(customerDocumentEntity.getGfPersonalId());

        businessDocument.setCountry(generateDocumentCountry(customerDocumentEntity.getgExpeditionDocCountryId()));
        businessDocument.setState(generateState(customerDocumentEntity.getGfExpeditionDocStateId()));
        businessDocument.setStatus(generateStatus(customerDocumentEntity.getGfPersonalStatusType()));

        businessDocument.setIsMainDocument(Utils.stringToBoolean(customerDocumentEntity.getGfMainDocumentType()));
        businessDocument.setExpirationDate(customerDocumentEntity.getGfDocumentExpirationDate());

        /**
         * ver de donde coger estos parametros
         */
        //----------------------------------------
        businessDocument.setCity(null);
        businessDocument.setIssueDate(null);
        //----------------------------------------

        return businessDocument;
    }

    public BusinessDocument generatePrincipalBusinessDocument(CustomerEntity customerEntity) {
        BusinessDocument businessDocument = new BusinessDocument();

        BusinessDocumentType businessDocumentType = new BusinessDocumentType();
        businessDocumentType.setId(customerEntity.getGfPersonalType());
        businessDocument.setBusinessDocumentType(businessDocumentType);

        businessDocument.setDocumentNumber(customerEntity.getGfPersonalId());
        businessDocument.setCity(customerEntity.getGfExpeditionDocTownName());

        businessDocument.setState(generateState(customerEntity.getGfExpeditionDocStateId()));
        businessDocument.setCountry(generateDocumentCountry(customerEntity.getgExpeditionDocCountryId()));

        businessDocument.setIsMainDocument(true);
        return businessDocument;
    }

    private Country generateDocumentCountry(String countryId) {
        Country country = null;
        if (StringUtils.isNotBlank(countryId)) {
            country = new Country();
            country.setId(countryId);
            country.setName(MapperCatalogs.getDescription(EXPEDITIONDOCCOUNTRYID, countryId, outputCatalogs));
        }
        return country;
    }

    private Country generateCountry(String countryId) {
        Country country = null;
        if (StringUtils.isNotBlank(countryId)) {
            country = new Country();
            country.setId(countryId);
            country.setName(MapperCatalogs.getDescription(EXPEDITIONDOCCOUNTRYID, countryId, outputCatalogs));
        }
        return country;
    }

    private State generateState(String stateId) {
        State state = null;
        if (StringUtils.isNotBlank(stateId)) {
            state = new State();
            state.setId(stateId);
            state.setName(MapperCatalogs.getDescription(EXPEDITIONDOCSTATEID, stateId, outputCatalogs));
        }
        return state;
    }

    private Status generateStatus(String statusId) {
        Status status = null;
        if (StringUtils.isNotBlank(statusId)) {
            status = new Status();
            status.setId(statusId);
            status.setDescription(MapperCatalogs.getDescription(PERSONALSTATUSTYPE, statusId, outputCatalogs));
        }
        return status;
    }

    private IncapacitationType generateIncapacitationType(CustomerEntity customerEntity) {
        IncapacitationType incapacitationType = null;
        if (StringUtils.isNotBlank(customerEntity.getgCtrngDisqualificationType())) {
            incapacitationType = new IncapacitationType();
            incapacitationType.setId(customerEntity.getgCtrngDisqualificationType());
        }
        return incapacitationType;
    }
}