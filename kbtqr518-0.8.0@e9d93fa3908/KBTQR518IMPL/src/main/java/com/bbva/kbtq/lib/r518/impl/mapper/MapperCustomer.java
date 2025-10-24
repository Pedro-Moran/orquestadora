package com.bbva.kbtq.lib.r518.impl.mapper;

import com.bbva.kbtq.dto.c100.entities.CustomerDocumentEntity;
import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.dto.catalogs.OutputCatalog;
import com.bbva.kbtq.dto.persons.domain.BankRelationAffiliation;
import com.bbva.kbtq.dto.persons.domain.BirthData;
import com.bbva.kbtq.dto.persons.domain.Correspondance;
import com.bbva.kbtq.dto.persons.domain.DocumentType;
import com.bbva.kbtq.dto.persons.domain.Gender;
import com.bbva.kbtq.dto.persons.domain.IdentityDocument;
import com.bbva.kbtq.dto.persons.domain.IncapacitationType;
import com.bbva.kbtq.dto.persons.domain.Language;
import com.bbva.kbtq.dto.persons.domain.MaritalStatus;
import com.bbva.kbtq.dto.persons.domain.Nationality;
import com.bbva.kbtq.dto.persons.domain.PersonalTitle;
import com.bbva.kbtq.dto.persons.domain.State;
import com.bbva.kbtq.dto.persons.domain.economicData.NaturalPersonType;
import com.bbva.kbtq.dto.persons.domain.shared.Country;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapperCustomer {
    private final List<OutputCatalog> outputCatalogs;

    public MapperCustomer(List<OutputCatalog> outputCatalogs) {
        this.outputCatalogs = outputCatalogs;
    }

    public NaturalPersonType generateNaturalPersonType(CustomerEntity customerEntity, List<CustomerDocumentEntity> customerDocumentEntities) {
        NaturalPersonType naturalPersonType = new NaturalPersonType();
        naturalPersonType.setFirstName(customerEntity.getGfFirstName());
        naturalPersonType.setSecondLastName(customerEntity.getGfSecondLastName());
        naturalPersonType.setLastName(customerEntity.getGfLastName());
        naturalPersonType.setMiddleName(customerEntity.getGfMiddleName());
        naturalPersonType.setLastAccessDate(null);

        naturalPersonType.setPersonalTitle(generatePersonalTitle(customerEntity));
        naturalPersonType.setBirthData(generateBirthData(customerEntity));
        naturalPersonType.setNationalities(generateNationalities(customerEntity));
        naturalPersonType.setIdentityDocuments(getIdentityDocuments(customerEntity, customerDocumentEntities));
        naturalPersonType.setGender(generateGender(customerEntity));
        naturalPersonType.setMaritalStatus(generateMaritalStatus(customerEntity));
        naturalPersonType.setLanguage(generateLanguage(customerEntity));
        naturalPersonType.setBankRelationAffiliation(generateBankRelationAffiliation(customerEntity));
        naturalPersonType.setIncapacitationType(generateIncapacitationType(customerEntity));

        return naturalPersonType;
    }

    private PersonalTitle generatePersonalTitle(CustomerEntity customerEntity) {
        PersonalTitle personalTitle = null;
        if (StringUtils.isNotBlank(customerEntity.getGfTitleType())) {
            personalTitle = new PersonalTitle();
            personalTitle.setId(customerEntity.getGfTitleType());
            personalTitle.setDescription(MapperCatalogs.getDescription(ConstantCatalogs.TITLETYPE, customerEntity.getGfTitleType(), outputCatalogs));
        }
        return personalTitle;
    }

    private BirthData generateBirthData(CustomerEntity customerEntity) {
        BirthData birthData = null;
        if (customerEntity.getGfBirthDate() != null) {
            birthData = new BirthData();
            birthData.setBirthDate(customerEntity.getGfBirthDate());
            birthData.setCountry(generateCountryBirthday(customerEntity.getgBirthCountryId()));
            birthData.setCity(customerEntity.getGfBirthTownName());
        }
        return birthData;
    }


    private Country generateCountryBirthday(String getgBirthCountryId) {
        Country country = null;
        if (StringUtils.isNotBlank(getgBirthCountryId)) {
            country = new Country();
            country.setId(getgBirthCountryId);
            country.setName(getgBirthCountryId);
        }
        return country;
    }

    private List<Nationality> generateNationalities(CustomerEntity customerEntity) {
        List<Nationality> nationalityList = null;
        if (StringUtils.isNotBlank(customerEntity.getGfCountryNationalityId())) {
            Nationality nationality = new Nationality();
            nationality.setId(customerEntity.getGfCountryNationalityId());
            nationality.setDescription(MapperCatalogs.getDescription(ConstantCatalogs.COUNTRYNATIONALITYID, customerEntity.getGfCountryNationalityId(), outputCatalogs));
            nationalityList = Collections.singletonList(nationality);
        }
        return nationalityList;
    }

    public List<IdentityDocument> getIdentityDocuments(CustomerEntity customerEntity, List<CustomerDocumentEntity> customerDocumentEntities) {
        IdentityDocument documentPrincipal = generateCustomerIdentityDocument(customerEntity);

        List<IdentityDocument> listDocuments = new ArrayList<>();
        listDocuments.add(documentPrincipal);

        List<IdentityDocument> listDocumentsFromTable = generateIdentityDocuments(customerDocumentEntities);

        if (listDocumentsFromTable != null && !listDocumentsFromTable.isEmpty()) {
            if(documentPrincipal!=null) {
                listDocumentsFromTable.removeIf(q ->
                        q.getDocumentNumber().equals(documentPrincipal.getDocumentNumber())
                    && q.getDocumentType().getId().equals(documentPrincipal.getDocumentType().getId())
                );
            }
            listDocuments.addAll(listDocumentsFromTable);
        }
        return listDocuments;
    }

    public IdentityDocument generateCustomerIdentityDocument(CustomerEntity customerEntity) {
        IdentityDocument identityDocument = new IdentityDocument();

        DocumentType documentType = new DocumentType();
        documentType.setId(customerEntity.getGfPersonalType());
        documentType.setDescription(MapperCatalogs.getDescription(ConstantCatalogs.PERSONALTYPE, customerEntity.getGfPersonalType(), outputCatalogs));
        identityDocument.setDocumentType(documentType);

        identityDocument.setDocumentNumber(customerEntity.getGfPersonalId());
        identityDocument.setCity(customerEntity.getGfExpeditionDocTownName());
        identityDocument.setTemporalType(customerEntity.getGfPersonalDocSubtypeType());

        identityDocument.setCountry(generateCountry(customerEntity.getgExpeditionDocCountryId()));
        identityDocument.setState(generateState(customerEntity.getGfExpeditionDocStateId()));

        return identityDocument;
    }

    private List<IdentityDocument> generateIdentityDocuments(List<CustomerDocumentEntity> customerDocumentEntities) {
        List<IdentityDocument> identityDocuments = null;
        if (customerDocumentEntities != null && !customerDocumentEntities.isEmpty()) {
            identityDocuments = customerDocumentEntities.stream().map(this::generateCustomerIdentityDocument).collect(Collectors.toList());
        }
        return identityDocuments;
    }

    private IdentityDocument generateCustomerIdentityDocument(CustomerDocumentEntity customerEntity) {
        IdentityDocument identityDocument = new IdentityDocument();

        DocumentType documentType = new DocumentType();
        documentType.setId(customerEntity.getGfPersonalType());
        identityDocument.setDocumentType(documentType);

        identityDocument.setDocumentNumber(customerEntity.getGfPersonalId());
        identityDocument.setCity(customerEntity.getGfExpeditionDocTownName());
        identityDocument.setCountry(generateCountry(customerEntity.getgExpeditionDocCountryId()));
        identityDocument.setState(generateState(customerEntity.getGfExpeditionDocStateId()));

        return identityDocument;
    }

    private Country generateCountry(String countryId) {
        Country country = null;
        if (StringUtils.isNotBlank(countryId)) {
            country = new Country();
            country.setId(countryId);
            country.setName(MapperCatalogs.getDescription(ConstantCatalogs.EXPEDITIONDOCCOUNTRYID, countryId, outputCatalogs));
        }
        return country;
    }

    private State generateState(String stateId) {
        State state = null;
        if (StringUtils.isNotBlank(stateId)) {
            state = new State();
            state.setId(stateId);
            state.setName(MapperCatalogs.getDescription(ConstantCatalogs.EXPEDITIONDOCSTATEID, stateId, outputCatalogs));
        }
        return state;
    }

    private Gender generateGender(CustomerEntity customerEntity) {
        Gender gender = null;
        if (StringUtils.isNotBlank(customerEntity.getGfGenderType())) {
            gender = new Gender();
            gender.setId(customerEntity.getGfGenderType());
            gender.setDescription(MapperCatalogs.getDescription(ConstantCatalogs.GENDERTYPE, customerEntity.getGfGenderType(), outputCatalogs));
        }
        return gender;
    }

    private MaritalStatus generateMaritalStatus(CustomerEntity customerEntity) {
        MaritalStatus maritalStatus = null;
        if (StringUtils.isNotBlank(customerEntity.getGfMaritalStatusType())) {
            maritalStatus = new MaritalStatus();
            maritalStatus.setId(customerEntity.getGfMaritalStatusType());
            maritalStatus.setDescription(MapperCatalogs.getDescription(ConstantCatalogs.MARITALSTATUSTYPE, customerEntity.getGfMaritalStatusType(), outputCatalogs));
        }
        return maritalStatus;
    }

    private Language generateLanguage(CustomerEntity customerEntity) {
        Language language = null;
        if (StringUtils.isNotBlank(customerEntity.getgCustomerLanguageId())) {
            language = new Language();
            language.setId(customerEntity.getgCustomerLanguageId());
            language.setName(MapperCatalogs.getDescription(ConstantCatalogs.CUSTOMERLANGUAGEID, customerEntity.getgCustomerLanguageId(), outputCatalogs));

            Correspondance correspondance = null;
            if (StringUtils.isNotBlank(customerEntity.getGfCorrespondenceLanguageId())) {
                correspondance = new Correspondance();
                correspondance.setId(customerEntity.getGfCorrespondenceLanguageId());
                correspondance.setName(MapperCatalogs.getDescription(ConstantCatalogs.CORRESPONDENCELANGUAGEID, customerEntity.getGfCorrespondenceLanguageId(), outputCatalogs));
            }

            language.setCorrespondance(correspondance);
        }
        return language;
    }

    private BankRelationAffiliation generateBankRelationAffiliation(CustomerEntity customerEntity) {
        BankRelationAffiliation bankRelationAffiliation = null;

        if (StringUtils.isNotBlank(customerEntity.getGfEmployeeEntityId())) {
            bankRelationAffiliation = new BankRelationAffiliation();
            bankRelationAffiliation.setId(customerEntity.getGfEmployeeEntityId());
        }
        return bankRelationAffiliation;
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
