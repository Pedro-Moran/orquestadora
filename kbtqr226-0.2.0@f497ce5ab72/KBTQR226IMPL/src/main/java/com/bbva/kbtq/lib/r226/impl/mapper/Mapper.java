package com.bbva.kbtq.lib.r226.impl.mapper;

import com.bbva.kbtq.dto.c226.entity.CustomerNationalityEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Mapper {


    public static Map<String, Object> readCustomerNationalities(String customerId) {
        Map<String, Object> map = new HashMap<>();
        map.put(MapperConstants.CUSTOMER_ID, customerId);
        return map;
    }

    public static List<CustomerNationalityEntity> mapToCustomerNationalitiesEntity(List<Map<String, Object>> mapList) {
        List<CustomerNationalityEntity> customerNationalityEntities = new ArrayList<>();

        getPrimaryNationality(mapList).ifPresent(customerNationalityEntities::add);

        mapList.forEach(map -> {
            CustomerNationalityEntity customerNationalityEntity = new CustomerNationalityEntity();
            customerNationalityEntity.setCustomerId((String) map.get(MapperConstants.CUSTOMER_ID));
            customerNationalityEntity.setCountryNationalityId((String) map.get(MapperConstants.SECONDARY_NATIONALITY));
            customerNationalityEntity.setCountryId((String) map.get(MapperConstants.COUNTRY_ID));
            customerNationalityEntity.setEntityId((String) map.get(MapperConstants.ENTITY_ID));
            customerNationalityEntity.setMainNationalityIndType("N");
            customerNationalityEntity.setRecordFunclUpdateDate((Date) map.get(MapperConstants.RECORD_FUNCL_UPDATE_DATE));
            customerNationalityEntity.setOperationalAuditDate((Date) map.get(MapperConstants.OPERATIONAL_AUDIT_DATE));
            customerNationalityEntity.setAuditOperuserId((String) map.get(MapperConstants.AUDIT_OPERUSER_ID));
            customerNationalityEntity.setCreationTerminalId((String) map.get(MapperConstants.CREATION_TERMINAL_ID));
            customerNationalityEntity.setTerminalLastModifyId((String) map.get(MapperConstants.TERMINAL_LAST_MODIFY_ID));
            customerNationalityEntity.setAccountRegisterBranchId((String) map.get(MapperConstants.ACCOUNT_REGISTER_BRANCH_ID));
            customerNationalityEntity.setLastChangeBranchId((String) map.get(MapperConstants.LAST_CHANGE_BRANCH_ID));
            customerNationalityEntity.setAuditInsertionUserId((String) map.get(MapperConstants.AUDIT_INSERTION_USER_ID));
            customerNationalityEntity.setSourceInsertAuditDate((Date) map.get(MapperConstants.SOURCE_INSERT_AUDIT_DATE));
            customerNationalityEntity.setConciliationId((String) map.get(MapperConstants.CONCILIATION_ID));
            customerNationalityEntity.setUserAuditId((String) map.get(MapperConstants.USER_AUDIT_ID));
            customerNationalityEntity.setAuditDate((Date) map.get(MapperConstants.AUDIT_DATE));
            customerNationalityEntities.add(customerNationalityEntity);
        });

        return customerNationalityEntities;
    }

    private static Optional<CustomerNationalityEntity> getPrimaryNationality(List<Map<String, Object>> mapList) {
        Map<String, Object> mapFilter;

        mapFilter = mapList.stream()
                .filter(map -> StringUtils.isNotEmpty((String) map.get(MapperConstants.PRIMARY_NATIONALITY)) ||
                        checkMainNationalityIndType((String) map.get(MapperConstants.MAIN_NATIONALITY_IND_TYPE)))
                .findFirst()
                .orElse(null);

        if (mapFilter != null) {

            CustomerNationalityEntity customerNationalityEntity = new CustomerNationalityEntity();
            customerNationalityEntity.setCustomerId((String) mapFilter.get(MapperConstants.CUSTOMER_ID));

            if (StringUtils.isNotEmpty((String) mapFilter.get(MapperConstants.PRIMARY_NATIONALITY))) {
                customerNationalityEntity.setCountryNationalityId((String) mapFilter.get(MapperConstants.PRIMARY_NATIONALITY));
                customerNationalityEntity.setMainNationalityIndType("Y");
            } else {
                customerNationalityEntity.setCountryNationalityId((String) mapFilter.get(MapperConstants.SECONDARY_NATIONALITY));
                customerNationalityEntity.setMainNationalityIndType((String) mapFilter.get(MapperConstants.MAIN_NATIONALITY_IND_TYPE));

                mapList.remove(mapFilter);
            }

            customerNationalityEntity.setCountryId((String) mapFilter.get(MapperConstants.COUNTRY_ID));
            customerNationalityEntity.setEntityId((String) mapFilter.get(MapperConstants.ENTITY_ID));
            customerNationalityEntity.setRecordFunclUpdateDate((Date) mapFilter.get(MapperConstants.RECORD_FUNCL_UPDATE_DATE));
            customerNationalityEntity.setOperationalAuditDate((Date) mapFilter.get(MapperConstants.OPERATIONAL_AUDIT_DATE));
            customerNationalityEntity.setAuditOperuserId((String) mapFilter.get(MapperConstants.AUDIT_OPERUSER_ID));
            customerNationalityEntity.setCreationTerminalId((String) mapFilter.get(MapperConstants.CREATION_TERMINAL_ID));
            customerNationalityEntity.setTerminalLastModifyId((String) mapFilter.get(MapperConstants.TERMINAL_LAST_MODIFY_ID));
            customerNationalityEntity.setAccountRegisterBranchId((String) mapFilter.get(MapperConstants.ACCOUNT_REGISTER_BRANCH_ID));
            customerNationalityEntity.setLastChangeBranchId((String) mapFilter.get(MapperConstants.LAST_CHANGE_BRANCH_ID));
            customerNationalityEntity.setAuditInsertionUserId((String) mapFilter.get(MapperConstants.AUDIT_INSERTION_USER_ID));
            customerNationalityEntity.setSourceInsertAuditDate((Date) mapFilter.get(MapperConstants.SOURCE_INSERT_AUDIT_DATE));
            customerNationalityEntity.setConciliationId((String) mapFilter.get(MapperConstants.CONCILIATION_ID));
            customerNationalityEntity.setUserAuditId((String) mapFilter.get(MapperConstants.USER_AUDIT_ID));
            customerNationalityEntity.setAuditDate((Date) mapFilter.get(MapperConstants.AUDIT_DATE));
            return Optional.of(customerNationalityEntity);
        }
        return Optional.empty();
    }

    private static boolean checkMainNationalityIndType(String mainNationalityIndType) {
        return (mainNationalityIndType.equalsIgnoreCase("Y") || mainNationalityIndType.equalsIgnoreCase("S"));
    }
}
