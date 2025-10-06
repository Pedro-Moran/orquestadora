package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FundsNumberTypeIdOutputEnum {

    L("L");

    private final String value;

    private static final Map<String, String> KEYS_TO_VALUES_MAP = Stream.of(values())
            .collect(Collectors.toMap(FundsNumberTypeIdOutputEnum::getKey, FundsNumberTypeIdOutputEnum::getValue));

    FundsNumberTypeIdOutputEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return this.name().substring(1);
    }

    public static String getValueFromKey(String key) {
        return KEYS_TO_VALUES_MAP.get(key);
    }
}