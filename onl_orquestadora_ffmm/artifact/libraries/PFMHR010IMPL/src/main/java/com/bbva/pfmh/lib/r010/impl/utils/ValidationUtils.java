package com.bbva.pfmh.lib.r010.impl.utils;

import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;

import java.util.Objects;

public class ValidationUtils {


    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validationInputIsNullOrEmpty(InputListInvestmentFundsDTO input) {
        if (input == null) {
            return true;
        }

        return isBlank(input.getCustomerId()) || isBlank(input.getProfileId());
    }

    public static boolean validationResponseIsNullOrEmpty(OutputInvestmentFundsDTO response) {
        return Objects.nonNull(response) && Objects.nonNull(response.getData()) && !response.getData().isEmpty();
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

}
