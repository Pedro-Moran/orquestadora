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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.atomic.AtomicReference;


public class PFMHT01001PETransaction extends AbstractPFMHT01001PETransaction {


    private static final Logger LOGGER = LoggerFactory.getLogger(PFMHT01001PETransaction.class);
    @Override
    public void execute() {
        LOGGER.info("[PFMHT010] execute:: START 2025");
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

        LOGGER.info("DEBUG PFMHT010 - antes de invokeLibrary");
        InvocationOutcome outcome = invokeLibrary(pfmhR010, serviceRequest);
        LOGGER.info("DEBUG PFMHT010 - después de invokeLibrary, failureHandled={}", outcome.isFailureHandled());

        if (outcome.isFailureHandled()) {
            LOGGER.warn("DEBUG PFMHT010 - outcome.isFailureHandled() = true, saliendo antes de construir paginación");
            return;
        }

        LOGGER.info("DEBUG PFMHT010 - antes de construir rawResponse y paginación");
        List<OutputInvestmentFundsDTO> rawResponse = outcome.getPayload();

        IntPaginationDTO paginationNode = extractPagination(rawResponse);
        List<OutputInvestmentFundsDTO> sanitizedResponse = sanitizeResponse(rawResponse);
        List<InvestmentFund> availableFunds = extractFunds(sanitizedResponse);
        Integer normalizedPageSize = resolvePageSize(paginationNode, input);
        int currentPage = resolveCurrentPage(input, normalizedPageSize);
        int startIndex = computeStartIndex(currentPage, normalizedPageSize);

        List<OutputInvestmentFundsDTO> payload = resolvePayload(sanitizedResponse, paginationNode, normalizedPageSize, startIndex);

        ResponseSummary summary = summarizeResponse(payload, availableFunds);

        this.setResponseOut(payload);
        this.setData(summary.getVisibleFunds());

        LOGGER.info("response envelopes -> {}, investment funds -> {}", payload.size(), summary.getVisibleFunds().size());
        LOGGER.debug("response detail -> {}", payload);

        LinksDTO links = buildLinks(availableFunds, summary.getVisibleFunds());
        LOGGER.info("linksDTO -> {}", links);
        PaginationDTO pagination = mapPagination(summary, links, normalizedPageSize, currentPage);
        LinksDTO paginationLinks = ensurePaginationLinks(pagination, summary, normalizedPageSize, currentPage);
        LinksDTO exposedLinks = synchronizePaginationLinks(pagination, paginationLinks);

        exposeLinks(exposedLinks, pagination);

        applyPaginationMetadata(paginationNode, pagination);

        updateSeverity(summary);
    }

    private void handleFailure() {
        LinksDTO emptyLinks = new LinksDTO();
        PaginationDTO emptyPagination = new PaginationDTO();
        emptyPagination.setPage(0);
        emptyPagination.setPageSize(0);
        emptyPagination.setTotalElements(0);
        emptyPagination.setTotalPages(0);
        emptyPagination.setDTOLinks(emptyLinks);

        this.setResponseOut(buildEmptyEnvelope(null));
        this.setData(Collections.emptyList());
        this.setPagination(emptyPagination);
        this.setDTOPagination(emptyPagination);
        this.setDTOLinks(copyLinks(emptyLinks));
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
                                         PaginationDTO pagination) {
        if (paginationNode != null) {
            this.setDTOIntPagination(paginationNode);
        }

        if (pagination == null) {
            return;
        }

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

    private PaginationDTO mapPagination(ResponseSummary summary,
                                        LinksDTO links,
                                        Integer normalizedPageSize,
                                        int currentPage) {
        PaginationDTO pagination = new PaginationDTO();

        if (links != null) {
            LinksDTO c = copyLinks(links);
            pagination.setLinks(c);
            pagination.setDTOLinks(copyLinks(c));
        }

        int totalElements = summary == null ? 0 : summary.getTotalElements();

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

    private LinksDTO ensurePaginationLinks(PaginationDTO pagination,
                                           ResponseSummary summary,
                                           Integer normalizedPageSize,
                                           int currentPage) {
        if (pagination == null) {
            return new LinksDTO();
        }

        LinksDTO links = pagination.getDTOLinks();
        if (hasAnyLinkValue(links)) {
            return links;
        }

        LinksDTO fallback = buildFallbackLinks(summary, normalizedPageSize, currentPage);
        if (fallback == null) {
            fallback = buildPaginationLinksFromMetadata(pagination);
        }

        if (fallback != null) {
            pagination.setDTOLinks(fallback);
            return fallback;
        }

        if (links == null) {
            links = new LinksDTO();
            pagination.setDTOLinks(links);
        }

        return links;
    }

    private LinksDTO synchronizePaginationLinks(PaginationDTO pagination, LinksDTO paginationLinks) {
        LinksDTO resolvedLinks = paginationLinks == null ? new LinksDTO() : paginationLinks;

        LinksDTO snapshot = copyLinks(resolvedLinks);
        if (pagination != null) {
            pagination.setLinks(copyLinks(resolvedLinks));
        }

        return snapshot;
    }

    private void exposeLinks(LinksDTO exposedLinks, PaginationDTO pagination) {
        LinksDTO safeLinks = exposedLinks == null ? new LinksDTO() : exposedLinks;

        if (pagination != null) {
            pagination.setLinks(copyLinks(safeLinks));
            pagination.setDTOLinks(copyLinks(safeLinks));
        }

        this.setDTOLinks(copyLinks(safeLinks));
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
        if (dto == null || dto.getData() == null || dto.getData().isEmpty()) {
            return Collections.emptyList();
        }

        List<InvestmentFund> funds = new ArrayList<>();
        for (InvestmentFund fund : dto.getData()) {
            if (fund != null) {
                funds.add(fund);
            }
        }

        return funds.isEmpty() ? Collections.emptyList() : funds;
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
        LOGGER.info("DEBUG PFMHT010 - List<InvestmentFund> antes de exponer: {}", availableFunds);
        if ((availableFunds == null || availableFunds.isEmpty()) &&
                visibleFunds != null && !visibleFunds.isEmpty()) {
            availableFunds = visibleFunds;
        }

        List<InvestmentFund> sanitizedAvailable = filterNonNullFunds(availableFunds);
        List<InvestmentFund> sanitizedVisible = filterNonNullFunds(visibleFunds);

        if (sanitizedAvailable.isEmpty()) {
            return null;
        }

        LinksDTO links = new LinksDTO();
        links.setFirst(describeFund(sanitizedAvailable.get(0)));
        links.setLast(describeFund(sanitizedAvailable.get(sanitizedAvailable.size() - 1)));

        if (!sanitizedVisible.isEmpty()) {
            int startIndex = indexOf(sanitizedAvailable, sanitizedVisible.get(0));
            if (startIndex > 0) {
                links.setPrevious(describeFund(sanitizedAvailable.get(startIndex - 1)));
            }

            int endIndex = indexOf(sanitizedAvailable, sanitizedVisible.get(sanitizedVisible.size() - 1));
            if (endIndex >= 0 && endIndex + 1 < sanitizedAvailable.size()) {
                links.setNext(describeFund(sanitizedAvailable.get(endIndex + 1)));
            }
        }

        if (hasAnyLinkValue(links)) {
            return links;
        }

        return buildPositionalLinks(sanitizedAvailable, sanitizedVisible);
    }

    private LinksDTO buildPositionalLinks(List<InvestmentFund> availableFunds,
                                          List<InvestmentFund> visibleFunds) {
        if (availableFunds == null || availableFunds.isEmpty()) {
            return null;
        }

        LinksDTO positional = new LinksDTO();
        positional.setFirst("0");
        positional.setLast(String.valueOf(Math.max(availableFunds.size() - 1, 0)));

        if (visibleFunds != null && !visibleFunds.isEmpty()) {
            int startIndex = indexOf(availableFunds, visibleFunds.get(0));
            if (startIndex > 0) {
                positional.setPrevious(String.valueOf(startIndex - 1));
            }

            int endIndex = indexOf(availableFunds, visibleFunds.get(visibleFunds.size() - 1));
            if (endIndex >= 0 && endIndex + 1 < availableFunds.size()) {
                positional.setNext(String.valueOf(endIndex + 1));
            }
        }

        return positional;
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

    private LinksDTO buildPaginationLinksFromMetadata(PaginationDTO pagination) {
        if (pagination == null) {
            return null;
        }

        Integer totalPages = pagination.getTotalPages();
        Integer currentPage = pagination.getPage();

        if (totalPages == null || totalPages <= 0 || currentPage == null) {
            return null;
        }

        int lastPageIndex = Math.max(totalPages - 1, 0);
        int normalizedCurrent = Math.min(Math.max(currentPage, 0), lastPageIndex);

        LinksDTO links = new LinksDTO();
        links.setFirst("0");
        links.setLast(String.valueOf(lastPageIndex));

        if (normalizedCurrent > 0) {
            links.setPrevious(String.valueOf(normalizedCurrent - 1));
        }

        if (normalizedCurrent < lastPageIndex) {
            links.setNext(String.valueOf(normalizedCurrent + 1));
        }

        return links;
    }

    private boolean hasAnyLinkValue(LinksDTO links) {
        if (links == null) {
            return false;
        }

        return links.getFirst() != null
                || links.getLast() != null
                || links.getPrevious() != null
                || links.getNext() != null;
    }

    private LinksDTO copyLinks(LinksDTO source) {
        if (source == null) {
            return null;
        }

        LinksDTO copy = new LinksDTO();
        copy.setFirst(source.getFirst());
        copy.setLast(source.getLast());
        copy.setPrevious(source.getPrevious());
        copy.setNext(source.getNext());
        return copy;
    }

    private String describeFund(InvestmentFund fund) {
        if (fund == null) {
            return null;
        }

        String identifier = sanitizeKey(fund.getInvestmentFundId());
        if (identifier != null) {
            return identifier;
        }

        identifier = sanitizeKey(fund.getNumber());
        if (identifier != null) {
            return identifier;
        }

        // Comentario en español: sin identificadores válidos no se debe derivar el enlace desde alias
        LOGGER.warn("DEBUG PFMHT010 - Fondo sin identificadores válidos para DTOLinks: {}", fund);
        return null;
    }

    private List<InvestmentFund> filterNonNullFunds(List<InvestmentFund> funds) {
        if (funds == null) {
            return Collections.emptyList();
        }

        List<InvestmentFund> sanitized = new ArrayList<>();
        for (InvestmentFund fund : funds) {
            if (fund != null) {
                sanitized.add(fund);
            }
        }

        if (sanitized.size() != funds.size()) {
            // Comentario en español: se omiten fondos nulos para evitar enlaces incompletos
            LOGGER.warn("DEBUG PFMHT010 - Se omitieron {} fondos nulos al generar DTOLinks", funds.size() - sanitized.size());
        }

        return sanitized;
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
            List<InvestmentFund> dtoFunds = extractFunds(dto);
            if (!dtoFunds.isEmpty()){
                funds.addAll(dtoFunds);
            }
        }

        return funds.isEmpty() ? Collections.emptyList() : funds;
    }

}