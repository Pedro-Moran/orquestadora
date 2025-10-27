package com.bbva.pfmh;


import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.PaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.LinksDTO;
import com.bbva.pfmh.lib.r010.PFMHR010;
import com.bbva.elara.domain.transaction.Severity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;

import java.math.BigInteger;
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
            List<OutputInvestmentFundsDTO> responseOut = pfmhR010.executeGetFFMMStatements(input);
            LOGGER.info("responseOut -> {}", responseOut);
            if (responseOut != null && !responseOut.isEmpty()) {
                this.setResponseOut(responseOut);
                IntPaginationDTO intPag = responseOut.get(0).getDTOIntPagination();
                if (intPag != null) {
                    this.setDTOIntPagination(intPag);
                    if (intPag.getPaginationKey() != null && intPag.getPageSize() != null) {
                        BigInteger currentKey = safeParse(intPag.getPaginationKey());
                        int size = intPag.getPageSize().intValue();
                        PaginationDTO pagination = mapPagination(currentKey, size, responseOut.size());
                        this.setPagination(pagination);
                    }
                }
                this.setSeverity(Severity.OK);
            } else {
                this.setResponseOut(List.of());
                this.setSeverity(Severity.ENR);
            }
        } catch (RestClientException e) {
            LOGGER.error("Error executing PFMHR010 service: {}", e.getMessage());
            this.setResponseOut(List.of());
            this.setSeverity(Severity.ENR);
        }
    }

    private PaginationDTO mapPagination(BigInteger paginationKey, int pageSize, int total) {
        PaginationDTO pagination = new PaginationDTO();
        if (total <= 0) {
            return pagination;
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
}