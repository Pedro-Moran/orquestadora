package com.bbva.pfmh.lib.r010.impl.cics;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.kusu.dto.users.entity.AliasFavContractEntity;
import com.bbva.kusu.lib.r325.KUSUR325;
import com.bbva.kusu.dto.users.entity.commons.AliasFavCommons;
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
    private List<String> uniqueErrorCodes;
    private String defaultError;
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
    private static final String VISIBLE_CONTRACT_INDICATOR_GETTER = "getgVisibleContractIndType";
    private static final Pattern VISIBLE_CONTRACT_INDICATOR_PATTERN = Pattern.compile(
            VISIBLE_CONTRACT_INDICATOR_FIELD + "=([^,\\]]*)");

    public List<OutputInvestmentFundsDTO> executeFMC7Transaction(InputListInvestmentFundsDTO input) {
        List<OutputInvestmentFundsDTO> response = Collections.emptyList();
        if (!ValidationUtils.validationInputIsNullOrEmpty(input)) {
            LOGGER.info("***** PFMH010Impl - input: {} *****", input);
            LOGGER.info("***** PFMH010Impl - participantDTO: {} *****", input.getCustomerId());
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

        applyPagination(dtoIntInvestmentFundsList, responsefmc7.getPagination());
        LOGGER.info("***** PFMH010Impl - mapFMC7ouput - dtoIntInvestmentFundsList: {} *****", dtoIntInvestmentFundsList);
        return dtoIntInvestmentFundsList;
    }

    private void applyPagination(List<OutputInvestmentFundsDTO> funds, FFMMPagination pagination) {
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
        investmentFund.setNumberType(mapOutNumberType(ffmm7.getcTipNum(), ffmm7.getdTipNum()));
        InvestmentFundType type = new InvestmentFundType();
        type.setId(INVESTMENT_FUND_TYPE_SIMPLE);
        type.setName(INVESTMENT_FUND_TYPE_SIMPLE);
        investmentFund.setInvestmentFundType(type);

        if (hasFundData(ffmm7)) {
            investmentFund.setFunds(Collections.singletonList(fund));
        }

        OutputInvestmentFundsDTO output = new OutputInvestmentFundsDTO();
        output.setData(Collections.singletonList(investmentFund));
        if (validarContratoEnKsanYHost("PE" + ffmm7.getIdContr(), output)) {
            investmentFund.setIsVisible(getVisible("PE" + ffmm7.getIdContr(), input.getCustomerId()));
            return output;
        }
        return null;
    }

    private boolean hasFundData(FFMM7 ffmm7) {
        return ffmm7.getIdSubPr() != null || ffmm7.getNumCuot() != null || ffmm7.getSalCont() != null ||
                ffmm7.getdMonEsd() != null || ffmm7.getdSubPro() != null || ffmm7.getIdMonFn() != null ||
                ffmm7.getSalDisp() != null || ffmm7.getValCuot() != null;
    }

    public boolean getVisible(String globalContractId, String profileId) {
        if (!isKusuConfigured()) {
            return false;
        }
        LOGGER.info("[getVisible] - globalContractId: {}", globalContractId);
        IdentificationData identificationData = resolveIdentifiers(profileId);
        LOGGER.info("[getVisible] - resolved userId: {}", identificationData.getUserId());
        LOGGER.info("[getVisible] - resolved profileId: {}", identificationData.getProfileId());

        if (!identificationData.hasIdentifiers()) {
            LOGGER.warn("[getVisible] - unable to resolve identifiers, returning invisible by default");
            return false;
        }

        List<AliasFavContractEntity> contracts = fetchFavoriteContracts(globalContractId, identificationData);
        if (contracts.isEmpty()) {
            return false;
        }

        AliasFavContractEntity matchedContract = findMatchingContract(globalContractId, contracts);
        if (matchedContract != null) {
            return resolveVisibilityFromIndicator(matchedContract);
        }

        LOGGER.warn("[getVisible] - no contract matched {}, falling back to visibility indicator scan", globalContractId);

        VisibilityEvaluation evaluation = evaluateVisibilityFallback(contracts);
        if (evaluation.hasDecision()) {
            return evaluation.getDecision();
        }
        return applyFallbackDecision(evaluation.getFallbackState());
    }

    private boolean isKusuConfigured() {
        if (kusuR325 != null) {
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
        LOGGER.info("[getVisible] - contractEntityListIn: {}", contractEntityListIn);

        if (!identificationData.hasIdentifiers()) {
            LOGGER.warn("[getVisible] - identifiers not available to query kusuR325");
            return Collections.emptyList();
        }

        List<AliasFavContractEntity> result;
        if (StringUtils.isNotBlank(identificationData.getProfileId())) {
            result = kusuR325.executeGetAliasFavoriteContractsList(
                    identificationData.getUserId(),
                    identificationData.getProfileId(),
                    contractEntityListIn);
        } else {
            result = kusuR325.executeGetAliasFavoriteContractsList(
                    identificationData.getUserId(),
                    contractEntityListIn);
        }
        LOGGER.info("[getVisible] - result of kusu: {}", result);
        return result == null ? Collections.emptyList() : result;
    }

    private IdentificationData resolveIdentifiers(String providedProfileId) {
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

        String resolvedProfileId = firstNonBlank(headerProfileId, providedProfileId, headerUserId);
        String resolvedUserId = firstNonBlank(headerUserId, resolvedProfileId);

        if (StringUtils.isBlank(resolvedProfileId)) {
            resolvedProfileId = resolvedUserId;
        }

        return new IdentificationData(resolvedUserId, resolvedProfileId);
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
        Object indicator = invokeVisibilityIndicatorGetter(entity);
        if (indicator == IndicatorExtractionResult.UNAVAILABLE) {
            indicator = null;
        }
        if (indicator != null) {
            if (indicator instanceof CharSequence) {
                String stringIndicator = StringUtils.trim(indicator.toString());
                if (StringUtils.isNotBlank(stringIndicator)) {
                    return stringIndicator;
                }
            } else {
                return indicator;
            }
        }

        Object extracted = extractIndicator(entity.toString());
        if (extracted == IndicatorExtractionResult.UNAVAILABLE) {
            LOGGER.warn("[getVisible] - visibility indicator not found in entity representation: {}", entity);
            return null;
        }
        return extracted;
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

    private Object invokeVisibilityIndicatorGetter(AliasFavContractEntity entity) {
        if (entity == null) {
            return IndicatorExtractionResult.UNAVAILABLE;
        }
        Method getter = findVisibilityIndicatorGetter(entity.getClass());
        if (getter == null) {
            LOGGER.debug("[getVisible] - visibility indicator getter not found on {}", entity.getClass().getName());
            return IndicatorExtractionResult.UNAVAILABLE;
        }
        if (!AliasFavCommons.class.equals(getter.getDeclaringClass())) {
            LOGGER.debug("[getVisible] - skipping overridden visibility indicator getter on {}", entity.getClass().getName());
            return IndicatorExtractionResult.UNAVAILABLE;
        }
        return entity.getgVisibleContractIndType();
    }

    private Method findVisibilityIndicatorGetter(Class<?> type) {
        Class<?> current = type;
        while (current != null) {
            for (Method method : current.getDeclaredMethods()) {
                if (VISIBLE_CONTRACT_INDICATOR_GETTER.equals(method.getName()) && method.getParameterCount() == 0) {
                    return method;
                }
            }
            current = current.getSuperclass();
        }
        return null;
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
                LOGGER.info("[getVisible] - returning invisible due to explicit indicator");
                return false;
            case MISSING_INDICATOR:
                LOGGER.info("[getVisible] - defaulting to visible because indicators are missing");
                return true;
            default:
                LOGGER.info("[getVisible] - no indicator information available, returning invisible by default");
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
            this.userId = userId;
            this.profileId = profileId;
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

        if (response.getFfmm7() == null || response.getFfmm7().isEmpty()) {
            LOGGER.warn("La lista FFMM7  está vacía o es nula.");
            return dtoOutList;
        }
        for (FFMM7 ffmm7 : response.getFfmm7()){
            Fund fund = new Fund();
            fund.setFundId(ffmm7.getIdSubPr());
            fund.setOwnedShares(ffmm7.getNumCuot());
            FundPosition fundPosition = new FundPosition();
            fundPosition.setAmount(ffmm7.getSalCont());
            fundPosition.setCurrency(ffmm7.getdMonEsd());
            fund.setFundPosition(fundPosition);
            Title title = new Title();
            title.setId(ffmm7.getIdSubPr());
            title.setName(ffmm7.getdSubPro());
            fund.setTitle(title);
            FundCurrency currency = new FundCurrency();
            currency.setId(ffmm7.getdMonEsd());
            currency.setName(ffmm7.getIdMonFn());
            fund.setCurrency(currency);
            AvailableFundPosition availableFundPosition = new AvailableFundPosition();
            availableFundPosition.setAmount(ffmm7.getSalDisp());
            availableFundPosition.setCurrency(ffmm7.getdMonEsd());
            fund.setAvailableFundPosition(availableFundPosition);
            NetAssetValue netAssetValue = new NetAssetValue();
            netAssetValue.setAmount(ffmm7.getValCuot());
            netAssetValue.setCurrency(ffmm7.getdMonEsd());
            fund.setNetAssetValue(netAssetValue);
            dtoOutList.add(fund);
        }

        LOGGER.info("***** PFMH010Impl - mapOutFunds - Start dtoOutList: {} *****", dtoOutList);
        return dtoOutList;
    }

    public InvestmentFundNumberType mapOutNumberType(final String ctipnum, final String dtipnum) {
        if (StringUtils.isEmpty(ctipnum) && StringUtils.isEmpty(dtipnum)) {
            return null;
        }
        InvestmentFundNumberType dtoOut = new InvestmentFundNumberType();
        if (!StringUtils.isEmpty(ctipnum)) {
            String id = FundsNumberTypeIdOutputEnum.getValueFromKey(ctipnum);
            dtoOut.setId(id != null ? id : ctipnum);
        }
        dtoOut.setName(dtipnum);
        return dtoOut;
    }


    public String matchErrorCodeHost(FMC7Response response) {
        if (uniqueErrorCodes.contains(response.getHostAdviceCode())) {
            return "PFMH" + response.getHostAdviceCode();
        } else {
            return "PFMH" + defaultError;
        }
    }

    public void initializeErrorCodeList() {
        defaultError = FME2026;
        uniqueErrorCodes = Arrays.asList(FME2026, FME2059, FME2099, FME2084, FME2060, FME2100, FME2092);
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
            LOGGER.error("El DTO de fondos de inversión no contiene contratos");
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
