package com.bbva.pfmh;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.LinksDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.PaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFund;
import com.bbva.pfmh.lib.r010.PFMHR010;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.atomic.AtomicReference;


public class PFMHT01001PETransaction extends AbstractPFMHT01001PETransaction {


    private static final Logger LOGGER = LoggerFactory.getLogger(PFMHT01001PETransaction.class);
    @Override
    public void execute() {
        LOGGER.info("[PFMHT010] execute:: START");
        PFMHR010 pfmhR010 = this.getServiceLibrary(PFMHR010.class);
        InputListInvestmentFundsDTO input = this.getInputlistinvestmentfundsdto();
        if (input == null) {
            LOGGER.warn("No se recibió InputListInvestmentFundsDTO. Se retorna respuesta vacía");
            handleFailure();
            return;
        }

        InputListInvestmentFundsDTO serviceRequest = buildServiceRequest(input);

        String customerId = input.getCustomerId();
        String paginationKey = input.getPaginationKey();
        Integer pageSize = input.getPageSize();
        String profileId = input.getProfileId();

        LOGGER.info("customerId: {}", customerId);
        LOGGER.info("paginationKey: {}", paginationKey);
        LOGGER.info("pageSize: {}", pageSize);
        LOGGER.info("profileId: {}", profileId);

        LOGGER.info("RBVDT30301PETransaction - START");

        InvocationOutcome outcome = invokeLibrary(pfmhR010, serviceRequest);

        if (outcome.isFailureHandled()) {
            return;
        }

        List<OutputInvestmentFundsDTO> rawResponse = outcome.getPayload();

        IntPaginationDTO paginationNode = extractPagination(rawResponse);
        List<OutputInvestmentFundsDTO> sanitizedResponse = sanitizeResponse(rawResponse);
        List<InvestmentFund> availableFunds = extractFunds(sanitizedResponse);
        Integer normalizedPageSize = resolvePageSize(paginationNode, input);
        int currentPage = resolveCurrentPage(input, normalizedPageSize);
        int startIndex = computeStartIndex(currentPage, normalizedPageSize);

        List<OutputInvestmentFundsDTO> payload = resolvePayload(sanitizedResponse, paginationNode, normalizedPageSize, startIndex);

        this.setResponseOut(payload);
        this.setData(availableFunds);

        ResponseSummary summary = summarizeResponse(payload, availableFunds);

        LOGGER.info("response envelopes -> {}, investment funds -> {}", payload.size(), summary.getVisibleFunds().size());
        LOGGER.debug("response detail -> {}", payload);

        LinksDTO links = buildLinks(availableFunds, summary.getVisibleFunds());
        if (links == null && summary.hasVisibleFunds() && !availableFunds.isEmpty()) {
            links = buildFallbackLinks(summary, normalizedPageSize, currentPage);
        }
        applyPaginationMetadata(paginationNode, links, summary, normalizedPageSize, currentPage);

        this.setDTOLinks(links);

        updateSeverity(summary);
        if (!summary.hasVisibleFunds()) {
            return;
        }
    }

    private void handleFailure() {
        this.setResponseOut(buildEmptyEnvelope(null));
        this.setData(Collections.emptyList());
        this.setDTOLinks(null);
        this.setSeverity(Severity.ENR);
    }

    private InputListInvestmentFundsDTO buildServiceRequest(InputListInvestmentFundsDTO original) {
        if (original == null) {
            return null;
        }

        InputListInvestmentFundsDTO request = new InputListInvestmentFundsDTO();
        request.setCustomerId(original.getCustomerId());
        request.setProfileId(original.getProfileId());
        return request;
    }

    private InvocationOutcome invokeLibrary(PFMHR010 pfmhR010,
                                            InputListInvestmentFundsDTO input) {
        AtomicReference<Throwable> fatalCause = new AtomicReference<>();

        InvocationOutcome outcome = CompletableFuture.completedFuture(input)
                .thenApply(pfmhR010::executeGetFFMMStatements)
                .thenApply(this::normalizeResponse)
                .handle((response, throwable) -> {
                    if (throwable == null) {
                        return InvocationOutcome.success(response);
                    }

                    Throwable cause = unwrap(throwable);
                    if (isKnownFailure(cause)) {
                        return handleKnownFailure(cause);
                    }

                    fatalCause.set(cause);
                    return null;
                })
                .join();

        Throwable unhandled = fatalCause.get();
        if (unhandled != null) {
            throwUnchecked(unhandled);
        }

        return outcome;
    }

    private List<OutputInvestmentFundsDTO> normalizeResponse(List<OutputInvestmentFundsDTO> response) {
        if (response != null) {
            return response;
        }

        LOGGER.warn("PFMHR010 devolvió un cuerpo nulo. Se utilizará una lista vacía");
        return Collections.emptyList();
    }

    private InvocationOutcome handleKnownFailure(Throwable cause) {
        if (cause instanceof RestClientException) {
            LOGGER.error("Error al invocar PFMHR010", cause);
        } else {
            LOGGER.error("Error inesperado al invocar PFMHR010", cause);
        }

        handleFailure();
        return InvocationOutcome.failure();
    }

    private boolean isKnownFailure(Throwable cause) {
        return cause instanceof RestClientException
                || cause instanceof IllegalArgumentException
                || cause instanceof IllegalStateException
                || cause instanceof NullPointerException;
    }

    private Throwable unwrap(Throwable throwable) {
        if (throwable instanceof CompletionException && throwable.getCause() != null) {
            return throwable.getCause();
        }
        return throwable;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void throwUnchecked(Throwable throwable) throws T {
        throw (T) throwable;
    }

    private static final class InvocationOutcome {
        private final List<OutputInvestmentFundsDTO> payload;
        private final boolean failureHandled;

        private InvocationOutcome(List<OutputInvestmentFundsDTO> payload, boolean failureHandled) {
            this.payload = payload;
            this.failureHandled = failureHandled;
        }

        static InvocationOutcome success(List<OutputInvestmentFundsDTO> payload) {
            return new InvocationOutcome(payload, false);
        }

        static InvocationOutcome failure() {
            return new InvocationOutcome(Collections.emptyList(), true);
        }

        List<OutputInvestmentFundsDTO> getPayload() {
            return payload;
        }

        boolean isFailureHandled() {
            return failureHandled;
        }
    }

    private List<OutputInvestmentFundsDTO> resolvePayload(List<OutputInvestmentFundsDTO> sanitizedResponse,
                                                          IntPaginationDTO paginationNode,
                                                          Integer normalizedPageSize,
                                                          int startIndex) {
        List<OutputInvestmentFundsDTO> paginatedResponse = applyPageSize(sanitizedResponse, normalizedPageSize, startIndex);
        return paginatedResponse.isEmpty() ? buildEmptyEnvelope(paginationNode) : paginatedResponse;
    }

    private ResponseSummary summarizeResponse(List<OutputInvestmentFundsDTO> payload,
                                              List<InvestmentFund> availableFunds) {
        List<InvestmentFund> visibleFunds = extractFunds(payload);
        int totalElements = availableFunds == null ? 0 : availableFunds.size();
        return new ResponseSummary(visibleFunds, totalElements);
    }

    private void applyPaginationMetadata(IntPaginationDTO paginationNode,
                                         LinksDTO links,
                                         ResponseSummary summary,
                                         Integer normalizedPageSize,
                                         int currentPage) {
        if (paginationNode == null) {
            return;
        }

        this.setDTOIntPagination(paginationNode);
        PaginationDTO pagination = mapPagination(summary.getTotalElements(), links, normalizedPageSize, currentPage);
        this.setPagination(pagination);
        this.setDTOPagination(pagination);
    }

    private void updateSeverity(ResponseSummary summary) {
        Severity severity = summary.hasVisibleFunds() ? Severity.OK : Severity.ENR;
        this.setSeverity(severity);
    }

    private final class ResponseSummary {
        private final List<InvestmentFund> visibleFunds;
        private final int totalElements;

        private ResponseSummary(List<InvestmentFund> visibleFunds, int totalElements) {
            this.visibleFunds = visibleFunds == null ? Collections.emptyList() : visibleFunds;
            this.totalElements = totalElements;
        }

        private List<InvestmentFund> getVisibleFunds() {
            return visibleFunds;
        }

        private boolean hasVisibleFunds() {
            return !visibleFunds.isEmpty();
        }

        private int getTotalElements() {
            return totalElements;
        }
    }

    private PaginationDTO mapPagination(int totalElements,
                                        LinksDTO links,
                                        Integer normalizedPageSize,
                                        int currentPage) {
        PaginationDTO pagination = new PaginationDTO();

        if (links != null) {
            pagination.setDTOLinks(links);
        }

        if (normalizedPageSize != null) {
            pagination.setPageSize(normalizedPageSize);
            if (normalizedPageSize > 0) {
                pagination.setTotalPages((int) Math.ceil((double) totalElements / normalizedPageSize));
            }
        }

        pagination.setTotalElements(totalElements);
        pagination.setPage(currentPage);
        return pagination;
    }

    private int computeStartIndex(int currentPage, Integer normalizedPageSize) {
        if (currentPage <= 0 || normalizedPageSize == null || normalizedPageSize <= 0) {
            return 0;
        }

        long candidate = (long) currentPage * normalizedPageSize;
        return candidate > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) candidate;
    }

    private List<OutputInvestmentFundsDTO> applyPageSize(List<OutputInvestmentFundsDTO> response,
                                                         Integer normalizedPageSize,
                                                         int startIndex) {
        if (response == null || response.isEmpty()) {
            return response == null ? Collections.emptyList() : response;
        }

        if (normalizedPageSize == null || normalizedPageSize <= 0) {
            return response;
        }

        int totalFunds = countFunds(response);
        if (totalFunds <= 0) {
            return response;
        }

        if (startIndex <= 0 && normalizedPageSize >= totalFunds) {
            return response;
        }

        List<OutputInvestmentFundsDTO> limited = new ArrayList<>();
        PageWindow window = new PageWindow(startIndex, normalizedPageSize);
        for (OutputInvestmentFundsDTO dto : response) {
            if (window.isComplete()) {
                break;
            }

            List<InvestmentFund> funds = extractFunds(dto);
            if (!funds.isEmpty()) {
                window.consume(dto, funds, limited);
            }
        }

        return limited;
    }

    private int countFunds(List<OutputInvestmentFundsDTO> response) {
        int total = 0;
        for (OutputInvestmentFundsDTO dto : response) {
            total += extractFunds(dto).size();
        }
        return total;
    }

    private List<InvestmentFund> extractFunds(OutputInvestmentFundsDTO dto) {
        if (dto == null) {
            return Collections.emptyList();
        }

        List<InvestmentFund> funds = dto.getData();
        return funds == null ? Collections.emptyList() : funds;
    }

    private final class PageWindow {
        private int offset;
        private int remaining;

        private PageWindow(int offset, int remaining) {
            this.offset = Math.max(offset, 0);
            this.remaining = remaining;
        }

        private boolean isComplete() {
            return remaining <= 0;
        }

        private void consume(OutputInvestmentFundsDTO dto,
                              List<InvestmentFund> funds,
                              List<OutputInvestmentFundsDTO> limited) {
            if (funds.isEmpty() || isComplete()) {
                return;
            }

            if (offset >= funds.size()) {
                offset -= funds.size();
                return;
            }

            int fromIndex = offset;
            int sliceLength = Math.min(remaining, funds.size() - fromIndex);
            if (sliceLength > 0) {
                limited.add(buildLimitedDto(dto, funds, fromIndex, fromIndex + sliceLength));
                remaining -= sliceLength;
            }

            offset = 0;
        }

        private OutputInvestmentFundsDTO buildLimitedDto(OutputInvestmentFundsDTO dto,
                                                         List<InvestmentFund> funds,
                                                         int fromIndex,
                                                         int toIndex) {
            OutputInvestmentFundsDTO copy = new OutputInvestmentFundsDTO();
            copy.setDTOIntPagination(dto.getDTOIntPagination());
            copy.setData(new ArrayList<>(funds.subList(fromIndex, toIndex)));
            return copy;
        }
    }

    private LinksDTO buildLinks(List<InvestmentFund> availableFunds,
                                List<InvestmentFund> visibleFunds) {
        if (availableFunds == null || availableFunds.isEmpty()) {
            return null;
        }

        LinksDTO links = new LinksDTO();
        links.setFirst(describeFund(availableFunds.get(0)));
        links.setLast(describeFund(availableFunds.get(availableFunds.size() - 1)));

        if (visibleFunds != null && !visibleFunds.isEmpty()) {
            int startIndex = indexOf(availableFunds, visibleFunds.get(0));
            if (startIndex > 0) {
                links.setPrevious(describeFund(availableFunds.get(startIndex - 1)));
            }

            int endIndex = indexOf(availableFunds, visibleFunds.get(visibleFunds.size() - 1));
            if (endIndex >= 0 && endIndex + 1 < availableFunds.size()) {
                links.setNext(describeFund(availableFunds.get(endIndex + 1)));
            }
        }

        return hasAnyLinkValue(links) ? links : null;
    }

    private LinksDTO buildFallbackLinks(ResponseSummary summary,
                                        Integer normalizedPageSize,
                                        int currentPage) {
        if (summary == null) {
            return null;
        }

        int totalElements = summary.getTotalElements();
        if (totalElements <= 0) {
            return null;
        }

        if (normalizedPageSize == null || normalizedPageSize <= 0) {
            return null;
        }

        int totalPages = (int) Math.ceil((double) totalElements / normalizedPageSize);
        if (totalPages <= 0) {
            return null;
        }

        int lastPageIndex = Math.max(totalPages - 1, 0);
        int clampedCurrentPage = Math.min(Math.max(currentPage, 0), lastPageIndex);

        LinksDTO links = new LinksDTO();
        // Enlaces basados en índices como respaldo cuando no hay identificadores disponibles
        links.setFirst("0");
        links.setLast(String.valueOf(lastPageIndex));

        if (clampedCurrentPage > 0) {
            links.setPrevious(String.valueOf(clampedCurrentPage - 1));
        }

        if (clampedCurrentPage < lastPageIndex) {
            links.setNext(String.valueOf(clampedCurrentPage + 1));
        }

        return links;
    }

    private boolean hasAnyLinkValue(LinksDTO links) {
        return links.getFirst() != null
                || links.getLast() != null
                || links.getPrevious() != null
                || links.getNext() != null;
    }

    private String describeFund(InvestmentFund fund) {
        if (fund == null) {
            return null;
        }

        String identifier = sanitizeKey(fund.getInvestmentFundId());
        if (identifier != null) {
            return identifier;
        }

        return sanitizeKey(fund.getNumber());
    }

    private int indexOf(List<InvestmentFund> funds, InvestmentFund target) {
        if (funds == null || funds.isEmpty() || target == null) {
            return -1;
        }

        for (int i = 0; i < funds.size(); i++) {
            if (funds.get(i) == target) {
                return i;
            }
        }

        return -1;
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
        if (input != null && input.getPageSize() != null && input.getPageSize() > 0) {
            return normalizePageSize(asLong(input.getPageSize()));
        }

        if (paginationNode != null && paginationNode.getPageSize() != null && paginationNode.getPageSize() > 0) {
            return normalizePageSize(paginationNode.getPageSize());
        }

        return null;
    }

    private Long asLong(Integer value) {
        return value == null ? null : value.longValue();
    }

    private int resolveCurrentPage(InputListInvestmentFundsDTO input, Integer normalizedPageSize) {
        if (input == null || normalizedPageSize == null || normalizedPageSize <= 0) {
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

    private String sanitizeKey(String value) {
        if (value == null) {
            return null;
        }

        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
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
