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
            boolean hasFunds = !sanitizedResponse.isEmpty();

            List<OutputInvestmentFundsDTO> payload = hasFunds
                    ? sanitizedResponse
                    : buildEmptyEnvelope(paginationNode);

            this.setResponseOut(payload);

            LOGGER.info("response envelopes -> {}, investment funds -> {}", payload.size(), countFunds(payload));
            LOGGER.debug("response detail -> {}", payload);

            if (paginationNode != null) {
                this.setDTOIntPagination(paginationNode);
            }

            if (!hasFunds) {
                this.setSeverity(Severity.ENR);
                return;
            }

            if (paginationNode != null && paginationNode.getPaginationKey() != null && paginationNode.getPageSize() != null) {
                BigInteger currentKey = safeParse(paginationNode.getPaginationKey());
                int size = paginationNode.getPageSize().intValue();
                PaginationDTO pagination = mapPagination(currentKey, size, payload.size());
                this.setPagination(pagination);
            }

            this.setSeverity(Severity.OK);
        } catch (RestClientException e) {
            LOGGER.error("Error executing PFMHR010 service: {}", e.getMessage());
            this.setResponseOut(buildEmptyEnvelope(null));
            this.setSeverity(Severity.ENR);
        }
    }

    private PaginationDTO mapPagination(BigInteger paginationKey, int pageSize, int total) {
        PaginationDTO pagination = new PaginationDTO();
        if (total <= 0) {
            return pagination;
        }

        if (pageSize <= 0) {
            LOGGER.warn("Invalid page size {}. Falling back to the current result size {}", pageSize, total);
            pageSize = Math.max(total, 1);
        }

        int totalPages = (int) Math.ceil((double) total / pageSize);
        int current = normalize(paginationKey);

        LinksDTO links = new LinksDTO();
        links.setFirst("0");
        links.setLast(String.valueOf(totalPages - 1));
        if (current > 0 && current <= totalPages - 1) {
            links.setPrevious(String.valueOf(current - 1));
        }
        if (current < totalPages - 1) {
            links.setNext(String.valueOf(current + 1));
        }

        pagination.setLinks(links);
        pagination.setPage(current);
        pagination.setTotalPages(totalPages);
        pagination.setTotalElements(total);
        pagination.setPageSize(pageSize);
        return pagination;
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

    private int countFunds(List<OutputInvestmentFundsDTO> response) {
        int total = 0;
        for (OutputInvestmentFundsDTO dto : response) {
            if (dto != null && dto.getData() != null) {
                total += dto.getData().size();
            }
        }
        return total;
    }
}
