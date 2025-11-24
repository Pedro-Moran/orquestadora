package com.bbva.pfmh.lib.r010.impl.cics;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.dto.users.entity.commons.AliasFavCommons;
import com.bbva.kusu.lib.r325.KUSUR325;
import com.bbva.pfmh.dto.fmc7.ffmm.FFMM7;
import com.bbva.pfmh.dto.fmc7.pague.FFMMPagination;
import com.bbva.pfmh.dto.fmc7.request.FMC7Request;
import com.bbva.pfmh.dto.fmc7.response.FMC7Response;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.FundsNumberTypeIdOutputEnum;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;

import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFundNumberType;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFundType;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.AvailableFundPosition;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFund;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.FundPosition;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.FundCurrency;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.NetAssetValue;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.Title;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.Fund;
import com.bbva.pfmh.lib.r010.impl.utils.ValidationUtils;
import com.bbva.pfmh.lib.r015.PFMHR015;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FMC7Connection extends AbstractLibrary {

    private static final Logger LOGGER = LoggerFactory.getLogger(FMC7Connection.class);
    private PFMHR015 pfmhR015;
    private KUSUR325 kusuR325;
    private List<String> uniqueErrorCodes = Collections.emptyList();
    private String defaultError = FME2026;
    private static final String INVESTMENT_FUND_TYPE_SIMPLE = "SIMPLE";
    private static final String PFMHCUSTOMERID = "Es obligatorio indicar el customerId";
    private static final String PFMH_NOT_DPS = "No existen DPS a mostrar con esos datos ingresados";
    private static final String FME2026 = "FME2026";
    private static final String FME2059 = "FME2059";
    private static final String FME2099 = "FME2099";
    private static final String FME2084 = "FME2084";
    private static final String FME2060 = "FME2060";
    private static final String FME2100 = "FME2100";
    private static final String FME2092 = "FME2092";
    private static final String VISIBLE_CONTRACT_INDICATOR_FIELD = "gVisibleContractIndType";
    private static final String VISIBLE_CONTRACT_INDICATOR_GETTER = "get" +
            StringUtils.capitalize(VISIBLE_CONTRACT_INDICATOR_FIELD);
    private static final Pattern VISIBLE_CONTRACT_INDICATOR_PATTERN = Pattern.compile(
            VISIBLE_CONTRACT_INDICATOR_FIELD + "=([^,\\]]*)");

    public List<OutputInvestmentFundsDTO> executeFMC7Transaction(InputListInvestmentFundsDTO input) {
        List<OutputInvestmentFundsDTO> response = Collections.emptyList();
        if (!ValidationUtils.validationInputIsNullOrEmpty(input)) {
            LOGGER.info("***** PFMH010Impl - input: {} *****", input);
            LOGGER.info("***** PFMH010Impl - participantDTO: {} *****", input.getCustomerId());
            LOGGER.info("***** PFMH010Impl - profileId: {} *****", input.getProfileId());
            response = executeFMC7Input(input);
        } else {
            this.addAdviceWithDescription(" PFMH", PFMHCUSTOMERID);
            LOGGER.info("***** PFMH010Impl - executeFMC7Transaction - FFMM  is null *****");
        }
        return response;
    }

    public List<OutputInvestmentFundsDTO> executeFMC7Input(InputListInvestmentFundsDTO input) {
        LOGGER.info("***** PFMH010Impl - executeFMC7Transaction - Start *****");
        LOGGER.info("***** PFMH010Impl - executeFMC7Transaction - request: {}", input);

        FMC7Request request = new FMC7Request();

        if (input.getPageSize() != null) {
            request.setTamPagi(input.getPageSize());
        }

        request.setNumCli(input.getCustomerId());
        request.setIndPagi(input.getPaginationKey());
        LOGGER.info("***** PFMH010Impl - executeFMC7Transaction - request: {}", request);

        FMC7Response response = this.pfmhR015.executeFMC7(request);
        LOGGER.info("***** PFMH010Impl - executeFMC7Transaction - response: {}", response);

        if (response.getHostAdviceCode() != null) {
            this.addAdviceWithDescription(matchErrorCodeHost(response), response.getHostMessage());
            LOGGER.info("***** PFMH010Impl - executeFMC7Transaction - Error at FMC7 execution - Host advice code: {}", response.getHostAdviceCode());
            return Collections.emptyList();
        }

        return mapFMC7ouput(response, input);
    }

    public List<OutputInvestmentFundsDTO> mapFMC7ouput(FMC7Response responsefmc7, InputListInvestmentFundsDTO input) {
        LOGGER.info("***** PFMH010Impl - mapFMC7ouput - Start response: {} *****", responsefmc7);
        List<OutputInvestmentFundsDTO> dtoIntInvestmentFundsList = new ArrayList<>();

        if (responsefmc7.getFfmm7() == null || responsefmc7.getFfmm7().isEmpty()) {
            this.addAdviceWithDescription("PFMH_DPS", PFMH_NOT_DPS);
            return Collections.emptyList();
        }

        List<Fund> allFunds = mapOutFunds(responsefmc7);
        for (int i = 0; i < responsefmc7.getFfmm7().size(); i++) {
            FFMM7 ffmm7 = responsefmc7.getFfmm7().get(i);
            if (ffmm7 == null) {
                continue;
            }
            OutputInvestmentFundsDTO dto = buildOutputInvestmentFund(ffmm7, allFunds.get(i), input);
            if (dto != null) {
                dtoIntInvestmentFundsList.add(dto);
            }
        }

        attachPaginationMetadata(dtoIntInvestmentFundsList, responsefmc7.getPagination());
        LOGGER.info("***** PFMH010Impl - mapFMC7ouput - dtoIntInvestmentFundsList: {} *****", dtoIntInvestmentFundsList);
        return dtoIntInvestmentFundsList;
    }

    private void attachPaginationMetadata(List<OutputInvestmentFundsDTO> funds, FFMMPagination pagination) {
        if (pagination == null || funds.isEmpty()) {
            return;
        }
        IntPaginationDTO intPaginationDTO = new IntPaginationDTO();
        intPaginationDTO.setPaginationKey(pagination.getIdpagin());
        if (pagination.getTampagi() != null) {
            intPaginationDTO.setPageSize(pagination.getTampagi().longValue());
        }
        for (OutputInvestmentFundsDTO dto : funds) {
            dto.setDTOIntPagination(intPaginationDTO);
        }
    }

    private OutputInvestmentFundsDTO buildOutputInvestmentFund(FFMM7 ffmm7, Fund fund, InputListInvestmentFundsDTO input) {
        InvestmentFund investmentFund = new InvestmentFund();
        investmentFund.setNumber(ffmm7.getIdContr());
        investmentFund.setInvestmentFundId(ffmm7.getIdContr());
        InvestmentFundNumberType numberType = mapOutNumberType(ffmm7.getcTipNum(), ffmm7.getdTipNum());
        if (numberType == null) {
            LOGGER.warn("[buildOutputInvestmentFund] - contrato {} sin numberType, se descarta del resultado", ffmm7.getIdContr());
            return null;
        }
        investmentFund.setNumberType(numberType);
        InvestmentFundType type = new InvestmentFundType();
        type.setId(INVESTMENT_FUND_TYPE_SIMPLE);
        type.setName(INVESTMENT_FUND_TYPE_SIMPLE);
        investmentFund.setInvestmentFundType(type);

        if (hasFundData(ffmm7) && fund != null) {
            investmentFund.setFunds(Collections.singletonList(fund));
        }

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setData(Collections.singletonList(investmentFund));
        if (validarContratoEnKsanYHost("PE" + ffmm7.getIdContr(), output)) {
            String profileId = StringUtils.trimToNull(input.getProfileId());
            if (profileId == null) {
                profileId = StringUtils.trimToNull(input.getCustomerId());
                LOGGER.debug("[buildOutputInvestmentFund] - profileId no informado, usando customerId como respaldo");
            }
            investmentFund.setIsVisible(getVisible("PE" + ffmm7.getIdContr(), profileId));
            return output;
        }
        return null;
    }

    private boolean hasFundData(FFMM7 ffmm7) {
        if (!hasMandatoryFundFields(ffmm7)) {
            String contractId = ffmm7 != null ? ffmm7.getIdContr() : null;
            LOGGER.debug("[hasFundData] - se omite la sección funds para el contrato {} por datos obligatorios incompletos", contractId);
            return false;
        }
        return true;
    }

    private boolean hasMandatoryFundFields(FFMM7 ffmm7) {
        if (ffmm7 == null) {
            return false;
        }
        return StringUtils.isNotBlank(ffmm7.getIdSubPr())
                && ffmm7.getNumCuot() != null
                && ffmm7.getSalCont() != null
                && StringUtils.isNotBlank(resolveCurrencyId(ffmm7))
                && ffmm7.getValCuot() != null
                && resolveAvailableAmount(ffmm7) != null;
    }

    private BigDecimal resolveAvailableAmount(FFMM7 ffmm7) {
        if (ffmm7 == null) {
            return null;
        }
        if (ffmm7.getSalDisp() != null) {
            return ffmm7.getSalDisp();
        }
        return ffmm7.getSalCont();
    }

    private String resolveCurrencyId(FFMM7 ffmm7) {
        if (ffmm7 == null) {
            return null;
        }
        String currencyId = StringUtils.trimToNull(ffmm7.getdMonEsd());
        if (currencyId == null) {
            currencyId = StringUtils.trimToNull(ffmm7.getIdMonFn());
            if (currencyId != null) {
                LOGGER.warn("[mapOutFunds] - código de moneda ausente, se usará el identificador informado por el host");
            }
        }
        return currencyId;
    }

    public boolean getVisible(String globalContractId, String profileId) {
        if (!isKusuConfigured()) {
            LOGGER.info("[getVisible] - KUSU no configurado, se mantendrá la visibilidad por defecto (visible)");
            return true;
        }
        IdentificationData identificationData = resolveIdentifiers(profileId);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("[getVisible] - globalContractId: {}, resolved userId: {}, resolved profileId: {}",
                    globalContractId, identificationData.getUserId(), identificationData.getProfileId());
        }

        if (!identificationData.hasIdentifiers()) {
            LOGGER.warn("[getVisible] - no fue posible resolver identificadores, se mantendrá la visibilidad por defecto (visible)");
            return true;
        }

        List<AliasFavContractEntity> contracts = fetchFavoriteContracts(globalContractId, identificationData);
        if (contracts.isEmpty()) {
            LOGGER.debug("[getVisible] - sin contratos asociados en KUSU, se mantendrá la visibilidad por defecto (visible)");
            return true;
        }

        AliasFavContractEntity matchedContract = findMatchingContract(globalContractId, contracts);
        if (matchedContract != null) {
            return resolveVisibilityFromIndicator(matchedContract);
        }

        LOGGER.debug("[getVisible] - no contract matched {}, falling back to visibility indicator scan", globalContractId);

        VisibilityEvaluation evaluation = evaluateVisibilityFallback(contracts);
        if (evaluation.hasDecision()) {
            return evaluation.getDecision();
        }
        return applyFallbackDecision(evaluation.getFallbackState());
    }

    public boolean tieneSoporteKusu() {
        // Se expone para que la transacción pueda decidir la visibilidad ante la ausencia de KUSU.
        return kusuR325 != null;
    }

    private boolean isKusuConfigured() {
        if (tieneSoporteKusu()) {
            return true;
        }
        LOGGER.warn("[getVisible] - kusur325 no configurado");
        return false;
    }

    private List<AliasFavContractEntity> fetchFavoriteContracts(String globalContractId, IdentificationData identificationData) {
        List<AliasFavContractEntity> contractEntityListIn = new ArrayList<>();
        AliasFavContractEntity contractEntity = new AliasFavContractEntity();
        contractEntity.setGContractId(globalContractId);
        contractEntityListIn.add(contractEntity);
        LOGGER.debug("[getVisible] - contractEntityListIn: {}", contractEntityListIn);

        if (!identificationData.hasIdentifiers()) {
            LOGGER.warn("[getVisible] - identifiers not available to query kusuR325");
            return Collections.emptyList();
        }

        String resolvedProfileId = StringUtils.trimToNull(identificationData.getProfileId());
        if (resolvedProfileId == null) {
            return Collections.emptyList();
        }

        List<AliasFavContractEntity> result = kusuR325.executeGetAliasFavoriteContractsList(
                resolvedProfileId,
                resolvedProfileId,
                contractEntityListIn);
        LOGGER.debug("[getVisible] - result of kusu: {}", result);
        return result == null ? Collections.emptyList() : result;
    }

    private IdentificationData resolveIdentifiers(String providedProfileId) {
        String normalizedProvided = StringUtils.trimToNull(providedProfileId);
        if (normalizedProvided != null) {
            return new IdentificationData(normalizedProvided, normalizedProvided);
        }

        CommonRequestHeader requestHeader = resolveRequestHeader();
        String headerUserId = null;
        String headerProfileId = null;

        if (requestHeader != null) {
            headerUserId = readHeaderParameter(requestHeader,
                    RequestHeaderParamsName.USERCODE,
                    RequestHeaderParamsName.USERLOGON,
                    RequestHeaderParamsName.AGENTUSER,
                    RequestHeaderParamsName.MANAGERUSER);
            headerProfileId = readHeaderParameter(requestHeader, RequestHeaderParamsName.PID);
        }

        String resolvedProfileId = firstNonBlank(headerProfileId, headerUserId);
        return new IdentificationData(resolvedProfileId, resolvedProfileId);
    }

    private CommonRequestHeader resolveRequestHeader() {
        Context context = ThreadContext.get();
        if (context == null) {
            LOGGER.debug("[getVisible] - request context unavailable while resolving identifiers");
            return null;
        }

        TransactionRequest transactionRequest = context.getTransactionRequest();
        if (transactionRequest == null) {
            LOGGER.debug("[getVisible] - transaction request unavailable while resolving identifiers");
            return null;
        }

        Object header = transactionRequest.getHeader();
        if (!(header instanceof CommonRequestHeader)) {
            LOGGER.debug("[getVisible] - request header unavailable or incompatible while resolving identifiers");
            return null;
        }

        return (CommonRequestHeader) header;
    }

    private String readHeaderParameter(CommonRequestHeader requestHeader, RequestHeaderParamsName... parameterNames) {
        if (requestHeader == null || parameterNames == null) {
            return null;
        }
        for (RequestHeaderParamsName parameterName : parameterNames) {
            if (parameterName == null) {
                continue;
            }
            Object value = requestHeader.getHeaderParameter(parameterName);
            String normalized = normalizeHeaderValue(value);
            if (normalized != null) {
                return normalized;
            }
        }
        return null;
    }

    private String firstNonBlank(String... values) {
        if (values == null) {
            return null;
        }
        for (String value : values) {
            String normalized = StringUtils.trimToNull(value);
            if (normalized != null) {
                return normalized;
            }
        }
        return null;
    }

    private String normalizeHeaderValue(Object value) {
        if (value == null) {
            return null;
        }
        return StringUtils.trimToNull(value.toString());
    }

    private AliasFavContractEntity findMatchingContract(String globalContractId, List<AliasFavContractEntity> contracts) {
        for (AliasFavContractEntity entity : contracts) {
            if (entity != null && StringUtils.equalsIgnoreCase(globalContractId, entity.getGContractId())) {
                return entity;
            }
        }
        return null;
    }

    private boolean resolveVisibilityFromIndicator(AliasFavContractEntity entity) {
        Object indicator = getVisibilityIndicator(entity);
        if (indicator == null) {
            LOGGER.info("[getVisible] - matched contract {} has no explicit indicator, defaulting to visible",
                    entity.getGContractId());
            return true;
        }
        boolean visible = toBoolean(indicator);
        LOGGER.info("[getVisible] - matched contract {} with indicator {} => {}",
                entity.getGContractId(), indicator, visible);
        return visible;
    }

    private Object getVisibilityIndicator(AliasFavContractEntity entity) {
        if (entity == null) {
            return null;
        }

        Object indicator = safelyReadVisibilityIndicator(entity);
        if (indicator == IndicatorExtractionResult.UNAVAILABLE) {
            indicator = null;
        }

        if (indicator instanceof CharSequence) {
            String normalized = StringUtils.trimToNull(indicator.toString());
            if (normalized != null) {
                return normalized;
            }
        } else if (indicator != null) {
            return indicator;
        }

        Object extracted = extractIndicator(entity.toString());
        if (extracted == IndicatorExtractionResult.UNAVAILABLE) {
            LOGGER.warn("[getVisible] - visibility indicator not found in entity representation: {}", entity);
            return null;
        }
        return extracted;
    }

    private Object safelyReadVisibilityIndicator(AliasFavContractEntity entity) {
        Method getter = findVisibilityIndicatorGetter(entity.getClass());
        if (getter == null) {
            return IndicatorExtractionResult.UNAVAILABLE;
        }
        Class<?> declaringClass = getter.getDeclaringClass();
        if (!AliasFavCommons.class.equals(declaringClass)
                && !AliasFavContractEntity.class.equals(declaringClass)) {
            LOGGER.debug("[getVisible] - skipping visibility getter declared in {}", declaringClass.getName());
            return IndicatorExtractionResult.UNAVAILABLE;
        }
        return entity.getgVisibleContractIndType();
    }

    private Method findVisibilityIndicatorGetter(Class<?> type) {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method != null
                    && method.getParameterCount() == 0
                    && VISIBLE_CONTRACT_INDICATOR_GETTER.equals(method.getName())) {
                return method;
            }
        }
        return null;
    }

    private VisibilityIndicator interpretVisibility(AliasFavContractEntity entity) {
        if (entity == null) {
            return VisibilityIndicator.UNKNOWN;
        }
        Object indicator = getVisibilityIndicator(entity);
        if (indicator == null || indicator == IndicatorExtractionResult.UNAVAILABLE) {
            return VisibilityIndicator.UNKNOWN;
        }
        return toBoolean(indicator) ? VisibilityIndicator.VISIBLE : VisibilityIndicator.INVISIBLE;
    }

    private Object extractIndicator(String representation) {
        if (StringUtils.isBlank(representation)) {
            return IndicatorExtractionResult.UNAVAILABLE;
        }
        Matcher matcher = VISIBLE_CONTRACT_INDICATOR_PATTERN.matcher(representation);
        if (!matcher.find()) {
            return IndicatorExtractionResult.UNAVAILABLE;
        }
        String raw = StringUtils.trim(matcher.group(1));
        if (StringUtils.isEmpty(raw) || StringUtils.equalsIgnoreCase(raw, "null")) {
            return null;
        }
        raw = unquote(raw);
        if (StringUtils.equalsIgnoreCase(raw, "true") || StringUtils.equalsIgnoreCase(raw, "false")) {
            return Boolean.valueOf(raw);
        }
        return raw;
    }

    private String unquote(String value) {
        if (value.length() < 2) {
            return value;
        }
        char first = value.charAt(0);
        char last = value.charAt(value.length() - 1);
        if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private enum IndicatorExtractionResult {
        UNAVAILABLE
    }

    private enum VisibilityIndicator {
        VISIBLE,
        INVISIBLE,
        UNKNOWN
    }

    private enum VisibilityFallbackState {
        NONE,
        MISSING_INDICATOR,
        EXPLICIT_INVISIBLE
    }

    private static final class VisibilityEvaluation {
        private final Boolean decision;
        private final VisibilityFallbackState fallbackState;

        private VisibilityEvaluation(Boolean decision, VisibilityFallbackState fallbackState) {
            this.decision = decision;
            this.fallbackState = fallbackState;
        }

        private static VisibilityEvaluation decision(boolean decision) {
            return new VisibilityEvaluation(decision, VisibilityFallbackState.NONE);
        }

        private static VisibilityEvaluation withFallback(VisibilityFallbackState fallbackState) {
            return new VisibilityEvaluation(null, fallbackState);
        }

        private boolean hasDecision() {
            return decision != null;
        }

        private boolean getDecision() {
            return Boolean.TRUE.equals(decision);
        }

        private VisibilityFallbackState getFallbackState() {
            return fallbackState;
        }
    }

    private VisibilityEvaluation evaluateVisibilityFallback(List<AliasFavContractEntity> contracts) {
        VisibilityFallbackState fallbackState = VisibilityFallbackState.NONE;

        for (AliasFavContractEntity entity : contracts) {
            VisibilityIndicator visibility = interpretVisibility(entity);
            String contractId = entity != null ? entity.getGContractId() : null;
            switch (visibility) {
                case VISIBLE:
                    LOGGER.info("[getVisible] - found visible indicator in unmatched contract {}", contractId);
                    return VisibilityEvaluation.decision(true);
                case INVISIBLE:
                    LOGGER.info("[getVisible] - found explicit invisible indicator in contract {}", contractId);
                    fallbackState = VisibilityFallbackState.EXPLICIT_INVISIBLE;
                    break;
                case UNKNOWN:
                    LOGGER.info("[getVisible] - contract {} has no indicator", contractId);
                    if (fallbackState != VisibilityFallbackState.EXPLICIT_INVISIBLE) {
                        fallbackState = VisibilityFallbackState.MISSING_INDICATOR;
                    }
                    break;
                default:
                    break;
            }
        }

        return VisibilityEvaluation.withFallback(fallbackState);
    }

    private boolean applyFallbackDecision(VisibilityFallbackState fallbackState) {
        switch (fallbackState) {
            case EXPLICIT_INVISIBLE:
                LOGGER.info("[getVisible] - contrato marcado como no visible por indicador explícito");
                return false;
            case MISSING_INDICATOR:
                LOGGER.info("[getVisible] - se usará visibilidad por defecto al no existir indicadores");
                return true;
            default:
                LOGGER.info("[getVisible] - sin información de indicadores, se marcará no visible por defecto");
                return false;
        }
    }

    private boolean toBoolean(Object value) {
        if (value == null) {
            return false;
        }
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue() != 0;
        }
        String normalized = StringUtils.trim(value.toString());
        if (StringUtils.isBlank(normalized)) {
            return false;
        }
        normalized = normalized.toUpperCase(Locale.ROOT);
        return "TRUE".equals(normalized)
                || "T".equals(normalized)
                || "Y".equals(normalized)
                || "YES".equals(normalized)
                || "S".equals(normalized)
                || "SI".equals(normalized)
                || "SÍ".equals(normalized)
                || "VERDADERO".equals(normalized)
                || "1".equals(normalized);
    }

    private static final class IdentificationData {
        private final String userId;
        private final String profileId;

        private IdentificationData(String userId, String profileId) {
            String normalizedProfileId = StringUtils.trimToNull(profileId);
            if (normalizedProfileId == null) {
                normalizedProfileId = StringUtils.trimToNull(userId);
            }
            this.profileId = normalizedProfileId;
            this.userId = normalizedProfileId;
        }

        private String getUserId() {
            return userId;
        }

        private String getProfileId() {
            return profileId;
        }

        private boolean hasIdentifiers() {
            return StringUtils.isNotBlank(userId) || StringUtils.isNotBlank(profileId);
        }
    }

    public List<Fund> mapOutFunds(FMC7Response response) {
        LOGGER.info("***** PFMH010Impl - mapOutFunds - Start FMC7Response: {} *****", response);
        List<Fund> dtoOutList = new ArrayList<>();

        if (response == null || response.getFfmm7() == null || response.getFfmm7().isEmpty()) {
            LOGGER.warn("La lista FFMM7  está vacía o es nula.");
            return dtoOutList;
        }

        for (FFMM7 ffmm7 : response.getFfmm7()) {
            dtoOutList.add(buildFund(ffmm7));
        }

        LOGGER.info("***** PFMH010Impl - mapOutFunds - Start dtoOutList: {} *****", dtoOutList);
        return dtoOutList;
    }

    private Fund buildFund(FFMM7 ffmm7) {
        if (!hasMandatoryFundFields(ffmm7)) {
            String contractId = ffmm7 != null ? ffmm7.getIdContr() : null;
            LOGGER.warn("[mapOutFunds] - no se generará fund para el contrato {} por información incompleta", contractId);
            return null;
        }

        Fund fund = new Fund();
        String fundId = StringUtils.trimToNull(ffmm7.getIdSubPr());
        fund.setFundId(fundId);
        fund.setOwnedShares(ffmm7.getNumCuot());
        fund.setFundPosition(buildFundPosition(ffmm7));
        fund.setTitle(buildTitle(ffmm7, fundId));
        fund.setCurrency(buildCurrency(ffmm7));
        fund.setAvailableFundPosition(buildAvailablePosition(ffmm7));
        fund.setNetAssetValue(buildNetAssetValue(ffmm7));
        return fund;
    }

    private FundPosition buildFundPosition(FFMM7 ffmm7) {
        FundPosition fundPosition = new FundPosition();
        fundPosition.setAmount(ffmm7.getSalCont());
        fundPosition.setCurrency(resolveCurrencyId(ffmm7));
        return fundPosition;
    }

    private Title buildTitle(FFMM7 ffmm7, String fallbackId) {
        Title title = new Title();
        title.setId(fallbackId);
        String titleName = StringUtils.trimToNull(ffmm7.getdSubPro());
        if (titleName == null) {
            titleName = fallbackId;
            LOGGER.warn("[mapOutFunds] - título ausente para el contrato {}, se usará el identificador del fondo", ffmm7.getIdContr());
        }
        title.setName(titleName);
        return title;
    }

    private FundCurrency buildCurrency(FFMM7 ffmm7) {
        FundCurrency currency = new FundCurrency();
        String currencyId = resolveCurrencyId(ffmm7);
        currency.setId(currencyId);
        String currencyName = StringUtils.trimToNull(ffmm7.getIdMonFn());
        if (currencyName == null) {
            currencyName = currencyId;
            LOGGER.warn("[mapOutFunds] - nombre de moneda ausente para el contrato {}, se usará el código", ffmm7.getIdContr());
        }
        currency.setName(currencyName);
        return currency;
    }

    private AvailableFundPosition buildAvailablePosition(FFMM7 ffmm7) {
        if (ffmm7 == null) {
            LOGGER.warn("[mapOutFunds] - no es posible construir availableFundPosition sin información del contrato");
            return null;
        }
        AvailableFundPosition availableFundPosition = new AvailableFundPosition();
        BigDecimal availableAmount = resolveAvailableAmount(ffmm7);
        if (ffmm7.getSalDisp() == null && availableAmount != null) {
            LOGGER.warn("[mapOutFunds] - monto disponible ausente para el contrato {}, se usará el saldo contable", ffmm7.getIdContr());
        }
        availableFundPosition.setAmount(availableAmount);
        availableFundPosition.setCurrency(resolveCurrencyId(ffmm7));
        return availableFundPosition;
    }

    private NetAssetValue buildNetAssetValue(FFMM7 ffmm7) {
        NetAssetValue netAssetValue = new NetAssetValue();
        netAssetValue.setAmount(ffmm7.getValCuot());
        netAssetValue.setCurrency(resolveCurrencyId(ffmm7));
        return netAssetValue;
    }

    public InvestmentFundNumberType mapOutNumberType(final String ctipnum, final String dtipnum) {
        String code = StringUtils.trimToNull(ctipnum);
        String description = StringUtils.trimToNull(dtipnum);

        if (StringUtils.isBlank(code) && StringUtils.isBlank(description)) {
            return null;
        }

        if (StringUtils.isBlank(description)) {
            description = code;
            LOGGER.warn("[mapOutNumberType] - descripción ausente para el tipo {}, se usará el código como nombre", code);
        }

        String resolvedId = FundsNumberTypeIdOutputEnum.getValueFromKey(code);
        if (StringUtils.isBlank(resolvedId)) {
            resolvedId = code;
        }
        if (StringUtils.isBlank(resolvedId)) {
            resolvedId = description;
        }

        if (StringUtils.isBlank(resolvedId) || StringUtils.isBlank(description)) {
            LOGGER.warn("[mapOutNumberType] - no es posible construir numberType con código '{}' y descripción '{}'", code, description);
            return null;
        }

        InvestmentFundNumberType dtoOut = new InvestmentFundNumberType();
        dtoOut.setId(resolvedId);
        dtoOut.setName(description);
        return dtoOut;
    }


    public String matchErrorCodeHost(FMC7Response response) {
        ensureErrorCodesInitialized();

        if (uniqueErrorCodes.contains(response.getHostAdviceCode())) {
            return"PFMH" + response.getHostAdviceCode();
        } else {
            return"PFMH" + defaultError;
        }
    }

    public void initializeErrorCodeList() {
        defaultError = FME2026;
        uniqueErrorCodes = Arrays.asList(FME2026, FME2059, FME2099, FME2084, FME2060, FME2100, FME2092);
    }

    private void ensureErrorCodesInitialized() {

        if (uniqueErrorCodes == null || uniqueErrorCodes.isEmpty()) {
            initializeErrorCodeList();
        }

        if (defaultError == null) {
            defaultError = FME2026;
        }
    }

    public boolean validarContratoEnKsanYHost(String contratoGlobal, OutputInvestmentFundsDTO dto) {
        if (contratoGlobal == null) {
            LOGGER.warn("[validarContratoEnKsanYHost] - contratoGlobal nulo");
            return false;
        }
        return validateContractHostLocal(dto, contratoGlobal);
    }


    public boolean validateContractHostLocal(OutputInvestmentFundsDTO dto, String contratoGlobal) {
        LOGGER.info("***** PFMHR010Impl - validateContractHostLocal - Start *****");
        if (dto == null || dto.getData() == null || dto.getData().isEmpty()) {
            LOGGER.warn("[validateContractHostLocal] - el DTO de fondos de inversión no contiene contratos");
            return false;
        }
        String contratoHost = contratoGlobal.substring(2); // Elimina "PE"
        return dto.getData().stream()
                .anyMatch(fund -> contratoHost.equals(fund.getNumber()));
    }

    public void setPfmhR015(PFMHR015 pfmhR015) {
        this.pfmhR015 = pfmhR015;
    }

    public void setKusuR325(KUSUR325 kusur325) {
        this.kusuR325 = kusur325;
    }
}