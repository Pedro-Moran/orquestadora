package com.bbva.pfmh.lib.r015.impl;

import com.bbva.apx.exception.business.BusinessException;
import com.bbva.elara.utility.interbackend.cics.dto.HostAttributeResponse;
import com.bbva.elara.utility.interbackend.cics.dto.SendMessageResponse;
import com.bbva.pfmh.dto.fmc7.constant.PFMHC005Constant;
import com.bbva.pfmh.dto.fmc7.ffmm.FFMM7;
import com.bbva.pfmh.dto.fmc7.pague.FFMMPagination;
import com.bbva.pfmh.dto.fmc7.request.FMC7Request;
import com.bbva.pfmh.dto.fmc7.response.FMC7Response;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PFMHR015Impl extends PFMHR015Abstract {

        private static final Map<Character, OverpunchDigit> OVERPUNCH_LOOKUP;

        static {
                Map<Character, OverpunchDigit> lookup = new HashMap<>();
                //
                // En los registros CICS el último dígito y el signo se representan con la notación
                // "overpunch". Las letras {A..I indican valores positivos 0..9 y }J..R indican
                // valores negativos 0..9 respectivamente. Con este mapa reconstruimos el último
                // dígito para que la conversión a BigDecimal mantenga la precisión original.
                //
                lookup.put('{', new OverpunchDigit(0, false));
                lookup.put('A', new OverpunchDigit(1, false));
                lookup.put('B', new OverpunchDigit(2, false));
                lookup.put('C', new OverpunchDigit(3, false));
                lookup.put('D', new OverpunchDigit(4, false));
                lookup.put('E', new OverpunchDigit(5, false));
                lookup.put('F', new OverpunchDigit(6, false));
                lookup.put('G', new OverpunchDigit(7, false));
                lookup.put('H', new OverpunchDigit(8, false));
                lookup.put('I', new OverpunchDigit(9, false));

                lookup.put('}', new OverpunchDigit(0, true));
                lookup.put('J', new OverpunchDigit(1, true));
                lookup.put('K', new OverpunchDigit(2, true));
                lookup.put('L', new OverpunchDigit(3, true));
                lookup.put('M', new OverpunchDigit(4, true));
                lookup.put('N', new OverpunchDigit(5, true));
                lookup.put('O', new OverpunchDigit(6, true));
                lookup.put('P', new OverpunchDigit(7, true));
                lookup.put('Q', new OverpunchDigit(8, true));
                lookup.put('R', new OverpunchDigit(9, true));

                OVERPUNCH_LOOKUP = Collections.unmodifiableMap(lookup);
        }

	private static final Logger LOGGER = LoggerFactory.getLogger(PFMHR015Impl.class);

	@Override
	public FMC7Response executeFMC7(FMC7Request request) {
		return executeInternalApiCicsConector(request);
	}

	private FMC7Response executeInternalApiCicsConector(FMC7Request request) {
		LOGGER.info("***** PFMHR015Impl - executeInternalApiCicsConector START ***** request: {}", request);
		Map<String, Object> params = new HashMap<>();

		if (request.getNumCli() != null) {
			params.put(PFMHC005Constant.HostFMC7FieldsIn.NUMCLIE, request.getNumCli());
		}

		if (request.getIndPagi() != null) {
			params.put(PFMHC005Constant.HostFMC7FieldsIn.INDPAGI, request.getIndPagi());
		}

		if (request.getTamPagi() != null) {
			String tamPagi = String.format("%03d", request.getTamPagi());
			params.put(PFMHC005Constant.HostFMC7FieldsIn.TAMPAGI, tamPagi);
		}

		LOGGER.info("***** PFMHR015Impl - params: {}", params);

		FMC7Response response = new FMC7Response();

		try {
			SendMessageResponse sendMessageResponse = this.interBackendCicsUtils.invokeCics(PFMHC005Constant.HostProperties.CICS_KEY_CONNECTION, PFMHC005Constant.HostProperties.FMC7, params);
			LOGGER.info("sendMessageResponse :: {}", sendMessageResponse);
			if (sendMessageResponse.getHostAdvices().isEmpty()) {
				LOGGER.info("Status OK");
				this.mapperFMC7(sendMessageResponse.getAttributeResponses(), response);
				LOGGER.debug("FMC7Response: {}", response);
			} else {
				LOGGER.info("Response {}", sendMessageResponse);
				LOGGER.info("Code: {} Description: {}", sendMessageResponse.getHostAdvices().get(0).getCode(), sendMessageResponse.getHostAdvices().get(0).getDescription());
				response.setHostAdviceCode(sendMessageResponse.getHostAdvices().get(0).getCode());
				response.setHostMessage(sendMessageResponse.getHostAdvices().get(0).getDescription());
			}
		} catch (BusinessException e) {
			LOGGER.info("[executeInternalApiCicsConector] Error al consumir Host: {}", ExceptionUtils.getStackTrace(e));
			getHostAdvice(response, e);
			LOGGER.info("[executeInternalApiCicsConector] FMC7Response Advice = [{}] , message = [{}]", response.getHostAdviceCode(), response.getHostMessage());
		}
		LOGGER.info("***** PFMHR015Impl - executeInternalApiCicsConector END *****");
		return response;
	}

	private void mapperFMC7(List<HostAttributeResponse> result, FMC7Response response) {
		List<FFMM7> list = new ArrayList<>();
		FFMMPagination ffmmPagination = null;

		for (HostAttributeResponse res : result) {
			LOGGER.info("mapperFMC7 - res.getFormat(): {}", res.getFormat());

			String format = res.getFormat().trim();
			if (format.equalsIgnoreCase(PFMHC005Constant.HostProperties.FFMM7_FORMAT)) {
				String value = res.getValue();
				int index = 0;

				try {
					FFMM7 ffmm7 = new FFMM7();

					ffmm7.setIdContr(extractString(value, index, 20));
					index += 20;
					ffmm7.setNumCuot(extractBigDecimal(value, index, 17, 8));
					index += 17;
					ffmm7.setSalDisp(extractBigDecimal(value, index, 17, 2));
					index += 17;
					ffmm7.setdMonEsd(extractString(value, index, 3));
					index += 3;
					ffmm7.setIdSubPr(extractString(value, index, 4));
					index += 4;
					ffmm7.setdSubPro(extractString(value, index, 50));
					index += 50;
					ffmm7.setIdMonFn(extractString(value, index, 35));
					index += 35;
					ffmm7.setSalCont(extractBigDecimal(value, index, 17, 2));
					index += 17;
					ffmm7.setValCuot(extractBigDecimal(value, index, 17, 8));
					index += 17;
					ffmm7.setcTipNum(extractString(value, index, 1));
					index += 1;
					ffmm7.setdTipNum(extractString(value, index, 30));

					list.add(ffmm7);
				} catch (BusinessException e) {
					LOGGER.error("Error al procesar el valor: {}. Índices fuera de rango o datos inválidos.", value, e);
				}
			} else if (format.equalsIgnoreCase(PFMHC005Constant.HostProperties.FMMAC72)) {
				String value = res.getValue();
				ffmmPagination = new FFMMPagination();
				ffmmPagination.setIdpagin(extractString(value, 0, 18));
				String size = extractString(value, value.length() - 3, 3);
				if (!size.isEmpty()) {
					ffmmPagination.setTampagi(Integer.valueOf(size));
				}
			}
		}

		response.setFfmm7(list);
		response.setPagination(ffmmPagination);
	}

	public FFMMPagination mapPaginationFFMM(final FFMMPagination ffmmPagination) {
		if (ffmmPagination == null) {
			return null;
		}
		FFMMPagination pagination = new FFMMPagination();
		pagination.setIdpagin(ffmmPagination.getIdpagin());
		pagination.setTampagi(ffmmPagination.getTampagi());

		return pagination;
	}

	private String extractString(String value, int startIndex, int length) {
		return safeSubstring(value, startIndex, startIndex + length).trim();
	}

        private BigDecimal extractBigDecimal(String value, int startIndex, int length, int scale) {
                String substring = safeSubstring(value, startIndex, startIndex + length);
                HostNumber hostNumber = decodeHostNumber(substring);

                if (hostNumber.isZero()) {
                        return BigDecimal.ZERO.setScale(scale);
                }

                return hostNumber.toBigDecimal(scale);
        }

        BigDecimal cleanAndConvertToBigDecimal(String value) {
                HostNumber hostNumber = decodeHostNumber(value);
                if (hostNumber.isZero()) {
                        return BigDecimal.ZERO;
                }
                return hostNumber.toBigDecimal();
        }

        private HostNumber decodeHostNumber(String value) {
                String trimmedValue = normalizeInput(value);
                if (trimmedValue == null) {
                        return HostNumber.zero();
                }

                boolean negative = trimmedValue.indexOf('-') >= 0;
                StringBuilder digits = new StringBuilder(trimmedValue.length());
                for (int i = 0; i < trimmedValue.length(); i++) {
                        char currentChar = trimmedValue.charAt(i);
                        if (Character.isDigit(currentChar)) {
                                digits.append(currentChar);
                        }
                }

                if (!trimmedValue.isEmpty()) {
                        OverpunchDigit overpunch = decodeOverpunchDigit(trimmedValue.charAt(trimmedValue.length() - 1));
                        if (overpunch != null && (digits.length() > 0 || trimmedValue.length() == 1)) {
                                digits.append((char) ('0' + overpunch.digit));
                                negative = negative || overpunch.negative;
                        }
                }

                if (digits.length() == 0) {
                        return HostNumber.zero();
                }

                BigInteger unscaled = new BigInteger(digits.toString());
                if (negative && unscaled.signum() != 0) {
                        unscaled = unscaled.negate();
                }
                return new HostNumber(unscaled);
        }

        private String normalizeInput(String value) {
                if (value == null) {
                        return null;
                }

                String trimmedValue = value.trim();
                return trimmedValue.isEmpty() ? null : trimmedValue;
        }

        private OverpunchDigit decodeOverpunchDigit(char value) {
                char normalized = Character.toUpperCase(value);
                return OVERPUNCH_LOOKUP.get(normalized);
        }

        private static final class HostNumber {
                private final BigInteger unscaled;

                private HostNumber(BigInteger unscaled) {
                        this.unscaled = unscaled;
                }

                private static HostNumber zero() {
                        return new HostNumber(BigInteger.ZERO);
                }

                private boolean isZero() {
                        return unscaled.signum() == 0;
                }

                private BigDecimal toBigDecimal(int scale) {
                        return new BigDecimal(unscaled, scale);
                }

                private BigDecimal toBigDecimal() {
                        return new BigDecimal(unscaled);
                }
        }

        private static final class OverpunchDigit {
                private final int digit;
                private final boolean negative;

                private OverpunchDigit(int digit, boolean negative) {
                        this.digit = digit;
                        this.negative = negative;
                }
        }

	private String safeSubstring(String value, int beginIndex, int endIndex) {
		if (value == null || beginIndex < 0 || beginIndex > value.length() || beginIndex > endIndex) {
			return "";
		}
		int safeEndIndex = Math.min(endIndex, value.length());
		return value.substring(beginIndex, safeEndIndex);
	}

	private void getHostAdvice(FMC7Response response, BusinessException e) {
		String[] errors = e.getMessage().split(";");
		String messageAdvice = errors[1].replace("HostAdvice", "").trim();
		messageAdvice = messageAdvice.substring(2, messageAdvice.length() - 2);
		Map<String, String> map = Arrays.stream(messageAdvice.split(","))
				.map(s -> s.replace("'", "").split("="))
				.collect(Collectors.toMap(s -> s[0].trim(), s -> s[1].trim()));
		response.setHostAdviceCode(map.get("code"));
		response.setHostMessage(map.get("description"));
	}
}
