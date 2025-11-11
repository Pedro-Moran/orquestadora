package com.bbva.pfmh;

import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.LinksDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.PaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFund;
import com.bbva.pfmh.lib.r010.PFMHR010;
import com.bbva.elara.domain.transaction.Severity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PFMHT01001PETransaction extends AbstractPFMHT01001PETransaction {


    private static final Logger LOGGER = LoggerFactory.getLogger(PFMHT01001PETransaction.class);
    private static final String LINKS_BASE_PATH_PROPERTY = "pfmht01001pe.links.base-path";
    private static final String DEFAULT_LINKS_BASE_PATH = "/investment-funds/v0/investment-funds";
    // Los enlaces de paginación solo exponen el índice de página

    @Override
    public void execute() {
        LOGGER.info("[PFMHT010] execute:: START");
        PFMHR010 pfmhR010 = this.getServiceLibrary(PFMHR010.class);
        InputListInvestmentFundsDTO input = this.getInputlistinvestmentfundsdto();

        String customerId = input.getCustomerId();
        String paginationKey = input.getPaginationKey();
        Integer pageSize = input.getPageSize();
        String profileId = input.getProfileId();

        LOGGER.info("customerId: {}", customerId);
        LOGGER.info("paginationKey: {}", paginationKey);
        LOGGER.info("pageSize: {}", pageSize);
        LOGGER.info("profileId: {}", profileId);

        LOGGER.info("RBVDT30301PETransaction - START");

        try {
            List<OutputInvestmentFundsDTO> rawResponse = pfmhR010.executeGetFFMMStatements(input);
            if (rawResponse == null) {
                LOGGER.warn("PFMHR010 service returned a null body. Falling back to an empty list");
                rawResponse = Collections.emptyList();
            }

            IntPaginationDTO paginationNode = extractPagination(rawResponse);
            List<OutputInvestmentFundsDTO> sanitizedResponse = sanitizeResponse(rawResponse);

            List<OutputInvestmentFundsDTO> payload = sanitizedResponse.isEmpty()
                    ? buildEmptyEnvelope(paginationNode)
                    : sanitizedResponse;

            this.setResponseOut(payload);
            List<InvestmentFund> aggregatedFunds = extractFunds(payload);
            this.setData(aggregatedFunds);

            boolean hasFunds = !aggregatedFunds.isEmpty();

            LOGGER.info("response envelopes -> {}, investment funds -> {}", payload.size(), aggregatedFunds.size());
            LOGGER.debug("response detail -> {}", payload);

            if (paginationNode != null) {
                this.setDTOIntPagination(paginationNode);
            }

            if (!hasFunds) {
                this.setDTOLinks(null);
                this.setSeverity(Severity.ENR);
                return;
            }

            if (paginationNode != null) {
                Integer normalizedPageSize = resolvePageSize(paginationNode, input);
                LinksDTO links = buildLinks(paginationNode, input, normalizedPageSize, aggregatedFunds.size());
                PaginationDTO pagination = mapPagination(aggregatedFunds.size(), links, normalizedPageSize, input);
                this.setPagination(pagination);
                this.setDTOPagination(pagination);
                this.setDTOLinks(links);
            } else {
                this.setDTOLinks(null);
            }

            this.setSeverity(Severity.OK);
        } catch (RestClientException e) {
            LOGGER.error("Error executing PFMHR010 service: {}", e.getMessage());
            this.setResponseOut(buildEmptyEnvelope(null));
            this.setData(Collections.emptyList());
            this.setDTOLinks(null);
            this.setSeverity(Severity.ENR);
        }
    }

    private PaginationDTO mapPagination(int totalElements,
                                        LinksDTO links,
                                        Integer normalizedPageSize,
                                        InputListInvestmentFundsDTO input) {
        PaginationDTO pagination = new PaginationDTO();

        if (links != null) {
            pagination.setLinks(links);
        }

        if (normalizedPageSize != null) {
            pagination.setPageSize(normalizedPageSize);
            if (normalizedPageSize > 0) {
                pagination.setTotalPages((int) Math.ceil((double) totalElements / normalizedPageSize));
            }
        }

        pagination.setTotalElements(totalElements);
        pagination.setPage(resolveCurrentPage(input));
        return pagination;
    }

    private LinksDTO buildLinks(IntPaginationDTO paginationNode,
                                InputListInvestmentFundsDTO input,
                                Integer normalizedPageSize,
                                int totalElements) {
        String basePath = resolveLinksBasePath();
        LinksDTO links = new LinksDTO();

        boolean hasLinks = appendStaticLinks(links, normalizedPageSize, totalElements, basePath);
        hasLinks |= appendPreviousLink(links, input, normalizedPageSize, basePath);
        hasLinks |= appendNextLink(links, paginationNode, normalizedPageSize, basePath);

        return hasLinks ? links : null;
    }

    private boolean appendStaticLinks(LinksDTO links,
                                      Integer normalizedPageSize,
                                      int totalElements,
                                      String basePath) {
        if (normalizedPageSize == null) {
            return false;
        }

        String first = buildPageLink(basePath, 0, normalizedPageSize);
        links.setFirst(first);

        if (normalizedPageSize <= 0) {
            links.setLast(first);
            return first != null;
        }

        int totalPages = (int) Math.ceil((double) totalElements / normalizedPageSize);
        int lastPage = Math.max(totalPages - 1, 0);
        links.setLast(buildPageLink(basePath, lastPage, normalizedPageSize));

        return first != null || links.getLast() != null;
    }

    private boolean appendPreviousLink(LinksDTO links,
                                       InputListInvestmentFundsDTO input,
                                       Integer normalizedPageSize,
                                       String basePath) {
        String previousKey = sanitizeKey(input != null ? input.getPaginationKey() : null);
        if (previousKey == null) {
            return false;
        }

        links.setPrevious(buildKeyLink(basePath, previousKey, normalizedPageSize,
                input != null ? input.getPageSize() : null));
        return true;
    }

    private boolean appendNextLink(LinksDTO links,
                                   IntPaginationDTO paginationNode,
                                   Integer normalizedPageSize,
                                   String basePath) {
        String nextKey = sanitizeKey(paginationNode != null ? paginationNode.getPaginationKey() : null);
        if (nextKey == null) {
            return false;
        }

        links.setNext(buildKeyLink(basePath, nextKey, normalizedPageSize,
                paginationNode != null ? toInteger(paginationNode.getPageSize()) : null));
        return true;
    }

    private String resolveLinksBasePath() {
        String configured = sanitizeKey(this.getProperty(LINKS_BASE_PATH_PROPERTY));
        return configured != null ? configured : DEFAULT_LINKS_BASE_PATH;
    }

    private Integer normalizePageSize(Long pageSize) {
        if (pageSize == null || pageSize <= 0) {
            return null;
        }

        if (pageSize > Integer.MAX_VALUE) {
            LOGGER.warn("Page size {} exceeds Integer.MAX_VALUE. Capping value to {}", pageSize, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }

        return pageSize.intValue();
    }

    private Integer resolvePageSize(IntPaginationDTO paginationNode, InputListInvestmentFundsDTO input) {
        Integer normalized = paginationNode != null ? normalizePageSize(paginationNode.getPageSize()) : null;
        if (normalized != null) {
            return normalized;
        }

        if (input != null && input.getPageSize() != null) {
            return normalizePageSize(input.getPageSize().longValue());
        }

        return null;
    }

    private int resolveCurrentPage(InputListInvestmentFundsDTO input) {
        if (input == null) {
            return 0;
        }

        return normalize(safeParse(input.getPaginationKey()));
    }

    private BigInteger safeParse(String value) {
        if (value == null) {
            return BigInteger.ZERO;
        }

        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            return BigInteger.ZERO;
        }

        for (int i = 0; i < trimmed.length(); i++) {
            if (!Character.isDigit(trimmed.charAt(i))) {
                return BigInteger.ZERO;
            }
        }

        return new BigInteger(trimmed);
    }

    private int normalize(BigInteger key) {
        if (key == null || key.signum() < 0) {
            return 0;
        }

        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        if (key.compareTo(maxInt) > 0) {
            return 0;
        }

        return key.intValue();
    }

    private String buildKeyLink(String basePath,
                                String paginationKey,
                                Integer normalizedPageSize,
                                Integer fallbackPageSize) {
        if (paginationKey == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(basePath)
                .append("?paginationKey=")
                .append(paginationKey);

        Integer pageSize = normalizedPageSize != null ? normalizedPageSize : fallbackPageSize;
        if (pageSize != null && pageSize > 0) {
            builder.append("&pageSize=").append(pageSize);
        }

        return builder.toString();
    }

    private String buildPageLink(String basePath, Integer page, Integer pageSize) {
        if (page == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(basePath)
                .append("?page=")
                .append(page);

        if (pageSize != null && pageSize > 0) {
            builder.append("&pageSize=").append(pageSize);
        }

        return builder.toString();
    }

    private String sanitizeKey(String value) {
        if (value == null) {
            return null;
        }

        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    private Integer toInteger(Long value) {
        if (value == null) {
            return null;
        }

        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (value <= 0) {
            return null;
        }

        return value.intValue();
    }

    private List<OutputInvestmentFundsDTO> sanitizeResponse(List<OutputInvestmentFundsDTO> response) {
        if (response.isEmpty()) {
            return Collections.emptyList();
        }

        List<OutputInvestmentFundsDTO> sanitized = new ArrayList<>(response.size());
        for (OutputInvestmentFundsDTO dto : response) {
            OutputInvestmentFundsDTO cleanedDto = sanitizeInvestmentFund(dto);
            if (cleanedDto != null) {
                sanitized.add(cleanedDto);
            }
        }

        return sanitized.isEmpty() ? Collections.emptyList() : sanitized;
    }

    private OutputInvestmentFundsDTO sanitizeInvestmentFund(OutputInvestmentFundsDTO dto) {
        if (dto == null) {
            return null;
        }

        dto.setData(sanitizeFunds(dto.getData()));
        return dto;
    }

    private List<InvestmentFund> sanitizeFunds(List<InvestmentFund> funds) {
        if (funds == null || funds.isEmpty()) {
            return Collections.emptyList();
        }

        List<InvestmentFund> cleanedFunds = new ArrayList<>(funds.size());
        for (InvestmentFund fund : funds) {
            if (fund != null) {
                cleanedFunds.add(fund);
            }
        }

        return cleanedFunds.isEmpty() ? Collections.emptyList() : cleanedFunds;
    }

    private IntPaginationDTO extractPagination(List<OutputInvestmentFundsDTO> response) {
        for (OutputInvestmentFundsDTO dto : response) {
            if (dto != null && dto.getDTOIntPagination() != null) {
                return dto.getDTOIntPagination();
            }
        }
        return null;
    }

    private List<OutputInvestmentFundsDTO> buildEmptyEnvelope(IntPaginationDTO pagination) {
        OutputInvestmentFundsDTO emptyEnvelope = new OutputInvestmentFundsDTO();
        emptyEnvelope.setData(Collections.emptyList());
        emptyEnvelope.setDTOIntPagination(pagination);
        return Collections.singletonList(emptyEnvelope);
    }

    private List<InvestmentFund> extractFunds(List<OutputInvestmentFundsDTO> response) {
        if (response == null || response.isEmpty()) {
            return Collections.emptyList();
        }

        List<InvestmentFund> funds = new ArrayList<>();
        for (OutputInvestmentFundsDTO dto : response) {
            if (dto != null && dto.getData() != null && !dto.getData().isEmpty()) {
                funds.addAll(dto.getData());
            }
        }

        return funds.isEmpty() ? Collections.emptyList() : funds;
    }

}
