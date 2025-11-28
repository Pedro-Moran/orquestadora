package com.bbva.ccse.lib.r003.impl.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class Functions {
    private Functions() {
    }

    public static <T> Map<String, Object> convertToMap(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.convertValue(object, new TypeReference<Map<String, Object>>() {
        });
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            if (entry.getValue() == null || (entry.getValue() instanceof Collection && ((Collection<?>) entry.getValue()).isEmpty())) {
                iterator.remove();
            }
        }

        return map;
    }

    public static Long getLong(JSONObject jsonObject, String key) {
        return jsonObject.has(key) ? jsonObject.optLong(key) : null;
    }

    public static String dateToString(Date date) {
        return date != null ? date.toString() : null;
    }

    public static Date stringToDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
