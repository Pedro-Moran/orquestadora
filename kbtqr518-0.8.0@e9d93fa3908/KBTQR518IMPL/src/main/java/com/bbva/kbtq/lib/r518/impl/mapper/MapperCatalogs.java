package com.bbva.kbtq.lib.r518.impl.mapper;

import com.bbva.kbtq.dto.c100.entities.CustomerDocumentEntity;
import com.bbva.kbtq.dto.c101.entities.CustomerEntity;
import com.bbva.kbtq.dto.catalogs.CatalogType;
import com.bbva.kbtq.dto.catalogs.InputCatalog;
import com.bbva.kbtq.dto.catalogs.OutputCatalog;
import com.bbva.kbtq.dto.catalogs.OutputDescription;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.BIRTHCOUNTRYID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.CORRESPONDENCELANGUAGEID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.COUNTRYNATIONALITYID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.CUSTOMERLANGUAGEID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.ENTITYID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.EXPEDITIONDOCCOUNTRYID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.EXPEDITIONDOCSTATEID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.GENDERTYPE;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.MARITALSTATUSTYPE;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.PERSONALSTATUSTYPE;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.PERSONALTYPE;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.PERSONMAINBRANCHID;
import static com.bbva.kbtq.lib.r518.impl.mapper.ConstantCatalogs.TITLETYPE;

public class MapperCatalogs {
    public static List<InputCatalog> mapCatalogs(CustomerEntity customerEntity, List<CustomerDocumentEntity> customerDocumentEntities) {
        if (customerEntity != null) {
            List<InputCatalog> inputCatalogs = new ArrayList<>();

            //Documents
            mapCatalog(EXPEDITIONDOCCOUNTRYID, customerDocumentEntities, CustomerDocumentEntity::getgExpeditionDocCountryId, CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(EXPEDITIONDOCSTATEID, customerDocumentEntities, CustomerDocumentEntity::getGfExpeditionDocStateId, CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(PERSONALSTATUSTYPE, customerDocumentEntities, CustomerDocumentEntity::getGfPersonalStatusType, CatalogType.GENERAL).ifPresent(inputCatalogs::add);
            mapCatalog(PERSONALTYPE, customerDocumentEntities, CustomerDocumentEntity::getGfPersonalType, CatalogType.GENERAL).ifPresent(inputCatalogs::add);

            //Customey
            if (StringUtils.isNotBlank(customerEntity.getgCountryId()) && StringUtils.isNotBlank(customerEntity.getGfEntityId()) && StringUtils.isNotBlank(customerEntity.getgPersonMainBranchId())) {
                if (customerEntity.getgPersonMainBranchId().length() == 6) {
                    mapCatalog(PERSONMAINBRANCHID, customerEntity.getgCountryId() + customerEntity.getGfEntityId() + customerEntity.getgPersonMainBranchId().substring(2, 6), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
                } else {
                    mapCatalog(PERSONMAINBRANCHID, customerEntity.getgCountryId() + customerEntity.getGfEntityId() + customerEntity.getgPersonMainBranchId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
                }
            }

            mapCatalog(PERSONALSTATUSTYPE, customerEntity.getGfPersonalStatusType(), CatalogType.GENERAL).ifPresent(inputCatalogs::add);
            mapCatalog(EXPEDITIONDOCCOUNTRYID, customerEntity.getgExpeditionDocCountryId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(EXPEDITIONDOCSTATEID, customerEntity.getGfExpeditionDocStateId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(COUNTRYNATIONALITYID, customerEntity.getGfCountryNationalityId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(ENTITYID, customerEntity.getgCountryId() + customerEntity.getGfEntityId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(CUSTOMERLANGUAGEID, customerEntity.getgCustomerLanguageId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(CORRESPONDENCELANGUAGEID, customerEntity.getgCustomerLanguageId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(GENDERTYPE, customerEntity.getGfGenderType(), CatalogType.GENERAL).ifPresent(inputCatalogs::add);
            mapCatalog(TITLETYPE, customerEntity.getGfTitleType(), CatalogType.GENERAL).ifPresent(inputCatalogs::add);
            mapCatalog(MARITALSTATUSTYPE, customerEntity.getGfMaritalStatusType(), CatalogType.GENERAL).ifPresent(inputCatalogs::add);
            mapCatalog(BIRTHCOUNTRYID, customerEntity.getGBirthCountryId(), CatalogType.CORPORATIVE).ifPresent(inputCatalogs::add);
            mapCatalog(PERSONALTYPE, customerEntity.getGfPersonalType(), CatalogType.GENERAL).ifPresent(inputCatalogs::add);

            if (!inputCatalogs.isEmpty()) {
                return inputCatalogs;
            }
        }
        return null;
    }


    private static Optional<InputCatalog> mapCatalog(String type, String parameter, CatalogType catalogType) {
        if (StringUtils.isNotBlank(parameter)) {
            InputCatalog inputCatalog = new InputCatalog();
            inputCatalog.setParameters(Collections.singletonList(parameter));
            inputCatalog.setCatalogType(catalogType);
            inputCatalog.setType(type);
            return Optional.of(inputCatalog);
        }
        return Optional.empty();
    }


    private static Optional<InputCatalog> mapCatalog(String type, List<CustomerDocumentEntity> list, Function<CustomerDocumentEntity, String> function, CatalogType catalogType) {
        if (list != null) {
            List<String> parameters = list.stream().map(function).filter(Objects::nonNull).distinct().collect(Collectors.toList());

            if (!parameters.isEmpty()) {
                InputCatalog inputCatalog = new InputCatalog();
                inputCatalog.setParameters(parameters);
                inputCatalog.setCatalogType(catalogType);
                inputCatalog.setType(type);
                return Optional.of(inputCatalog);
            }
        }
        return Optional.empty();
    }

    public static String getDescription(String type, String parameter, List<OutputCatalog> outputCatalogs) {
        if (outputCatalogs != null && StringUtils.isNotBlank(parameter)) {
            OutputCatalog outputCatalog = outputCatalogs.stream()
                    .filter(outputCatalog1 -> type.equals(outputCatalog1.getType()))
                    .findFirst()
                    .orElse(null);

            if (outputCatalog != null && outputCatalog.getOutputDescriptions() != null) {
                for (OutputDescription outputDescription : outputCatalog.getOutputDescriptions()) {
                    if (StringUtils.isNotBlank(outputDescription.getParameter())
                            && parameter.equalsIgnoreCase(outputDescription.getParameter())) {
                        return outputDescription.getDescription();
                    }
                }
            }
        }
        return parameter;
    }
}
