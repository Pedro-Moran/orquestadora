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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;


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

        LOGGER.info("DEBUG PFMHT010 - antes de invokeLibrary");
        serviceRequest.setPageSize(null);
        serviceRequest.setPaginationKey(null);
        FullHostResult full = fetchAllFromHost(pfmhR010, serviceRequest);

        List<OutputInvestmentFundsDTO> sanitizedResponse = full.envelopes;
        List<InvestmentFund> availableFunds = full.funds;
        IntPaginationDTO paginationNode = full.lastPaginationNode;

        if (sanitizedResponse.isEmpty() || availableFunds.isEmpty()) {
            handleFailure();
            return;
        }

        Integer normalizedPageSize = resolvePageSize(input);

        String inputKey = input.getPaginationKey();
        int startIndex = resolveStartIndexByCursor(inputKey, availableFunds);

        int currentPage = (normalizedPageSize == null || normalizedPageSize <= 0)
                ? 0
                : startIndex / normalizedPageSize;

        List<OutputInvestmentFundsDTO> payload = resolvePayload(
                sanitizedResponse, paginationNode, normalizedPageSize, startIndex);


        ResponseSummary summary = summarizeResponse(payload, availableFunds);

        LOGGER.info("response envelopes -> {}, investment funds -> {}", payload.size(), summary.getVisibleFunds().size());
        LOGGER.debug("response detail -> {}", payload);

        LinksDTO links = buildLinks(availableFunds, summary.getVisibleFunds());
        LOGGER.info("linksDTO -> {}", links);
        PaginationDTO pagination = mapPagination(summary, links, normalizedPageSize, currentPage);
        LOGGER.info("DTOPagination finaleeeeessss (antes de exponer) -> {}", pagination);
        LOGGER.info("DTOPagination.DTOLinks final -> {}",
                pagination.getDtoLinks());
        exposeLinks(pagination.getDtoLinks(), pagination);
        applyPaginationMetadata(paginationNode, pagination);
        propagatePaginationToEnvelopes(payload, pagination);

        updateSeverity(summary);
        LinksDTO l = pagination.getDtoLinks();
        LOGGER.info("REAL links -> first='{}', last='{}', prev='{}', next='{}'",
                l == null ? null : l.getFirst(),
                l == null ? null : l.getLast(),
                l == null ? null : l.getPrevious(),
                l == null ? null : l.getNext()
        );

        this.setResponseOut(payload);
        this.setData(summary.getVisibleFunds());
    }

    private static final class FullHostResult {
        private final List<OutputInvestmentFundsDTO> envelopes;
        private final List<InvestmentFund> funds;
        private final IntPaginationDTO lastPaginationNode;

        private FullHostResult(List<OutputInvestmentFundsDTO> envelopes,
                               List<InvestmentFund> funds,
                               IntPaginationDTO lastPaginationNode) {
            this.envelopes = envelopes;
            this.funds = funds;
            this.lastPaginationNode = lastPaginationNode;
        }
    }

    private FullHostResult fetchAllFromHost(PFMHR010 pfmhR010,
                                            InputListInvestmentFundsDTO baseRequest) {

        List<OutputInvestmentFundsDTO> allEnvelopes = new ArrayList<>();
        List<InvestmentFund> allFunds = new ArrayList<>();

        String key = null;
        IntPaginationDTO lastNode = null;

        Set<String> seenFundKeys = new HashSet<>();
        Set<String> seenPageKeys = new HashSet<>();

        int safety = 0;
        boolean done = false;

        while (!done && safety++ < 200) {

            InputListInvestmentFundsDTO req = buildPagedRequest(baseRequest, key);
            List<OutputInvestmentFundsDTO> page =
                    normalizeResponse(pfmhR010.executeGetFFMMStatements(req));

            if (isEmptyPage(page)) {
                done = true;
            } else {

                List<OutputInvestmentFundsDTO> sanitizedPage = sanitizeResponse(page);
                allEnvelopes.addAll(sanitizedPage);

                List<InvestmentFund> pageFunds = extractFunds(sanitizedPage);

                allFunds.addAll(filterNewFunds(pageFunds, seenFundKeys));

                lastNode = extractPagination(page);
                String nextKey = extractNextKey(lastNode);

                done = isPagingFinished(nextKey, key, seenPageKeys);

                if (!done) {
                    key = nextKey;
                }
            }
        }

        return new FullHostResult(allEnvelopes, allFunds, lastNode);
    }


    private List<InvestmentFund> filterNewFunds(List<InvestmentFund> pageFunds,
                                                Set<String> seenFundKeys) {
        if (pageFunds == null || pageFunds.isEmpty()) {
            return Collections.emptyList();
        }

        List<InvestmentFund> newFunds = new ArrayList<>();
        for (InvestmentFund f : pageFunds) {
            if (f == null) {
                continue;
            }
            String fid = sanitizeKey(f.getInvestmentFundId());
            String fnum = sanitizeKey(f.getNumber());
            String dedupKey = fid != null ? fid : fnum;

            if (dedupKey != null && seenFundKeys.add(dedupKey)) {
                newFunds.add(f);
            }
        }
        return newFunds;
    }

    private boolean isPagingFinished(String nextKey,
                                     String currentKey,
                                     Set<String> seenPageKeys) {
        if (nextKey == null || nextKey.isEmpty()) {
            return true;
        }
        if (nextKey.equals(currentKey)) {
            return true;
        }
        // si ya vimos esa key, es ciclo
        return !seenPageKeys.add(nextKey);
    }


    private InputListInvestmentFundsDTO buildPagedRequest(InputListInvestmentFundsDTO baseRequest,
                                                          String paginationKey) {
        InputListInvestmentFundsDTO req = buildServiceRequest(baseRequest);

        if (paginationKey != null) {
            req.setPaginationKey(paginationKey);
        }

        req.setPageSize(null);

        return req;
    }

    private boolean isEmptyPage(List<OutputInvestmentFundsDTO> page) {
        return page == null || page.isEmpty();
    }

    private String extractNextKey(IntPaginationDTO node) {
        if (node == null) return null;
        String key = node.getPaginationKey();
        return (key == null) ? null : key.trim();
    }

    private int resolveStartIndexByCursor(String paginationKey,
                                          List<InvestmentFund> availableFunds) {
        if (paginationKey == null || paginationKey.trim().isEmpty()
                || availableFunds == null || availableFunds.isEmpty()) {
            return 0;
        }

        String key = paginationKey.trim();

        // ✅ SOLO interpretar como índice si es numérico "corto"
        // (así no confundimos IDs largos del host con índices)
        if (key.matches("\\d{1,6}")) {  // ajusta 6 si quieres más/menos
            try {
                int idx = Integer.parseInt(key);
                if (idx >= 0 && idx < availableFunds.size()) {
                    return idx;
                }
            } catch (NumberFormatException ignored) {
                // si algo raro pasa, seguimos con la búsqueda por id/number
            }
        }

        // Búsqueda normal por investmentFundId o number
        for (int i = 0; i < availableFunds.size(); i++) {
            InvestmentFund f = availableFunds.get(i);
            if (f == null) continue;

            String id = sanitizeKey(f.getInvestmentFundId());
            String num = sanitizeKey(f.getNumber());

            if (key.equals(id) || key.equals(num)) {
                return i;
            }
        }

        return 0;
    }

    private void handleFailure() {

        LinksDTO emptyLinks = new LinksDTO();
        emptyLinks.setFirst("0");
        emptyLinks.setLast("0");

        PaginationDTO emptyPagination = new PaginationDTO();
        emptyPagination.setPage(0L);
        emptyPagination.setPageSize(0L);
        emptyPagination.setTotalElements(0L);
        emptyPagination.setTotalPages(0L);
        emptyPagination.setDtoLinks(emptyLinks);

        List<OutputInvestmentFundsDTO> emptyEnvelope = buildEmptyEnvelope(null);
        propagatePaginationToEnvelopes(emptyEnvelope, emptyPagination);

        this.setResponseOut(emptyEnvelope);
        this.setData(Collections.emptyList());

        this.setPagination(emptyPagination);
        this.setDTOPagination(emptyPagination);

        this.setSeverity(Severity.ENR);
    }


    private InputListInvestmentFundsDTO buildServiceRequest(InputListInvestmentFundsDTO original) {
        InputListInvestmentFundsDTO request = new InputListInvestmentFundsDTO();
        if (original == null) {
            return request;
        }

        request.setCustomerId(original.getCustomerId());
        request.setProfileId(original.getProfileId());
        request.setPageSize(original.getPageSize());
        request.setPaginationKey(original.getPaginationKey());

        return request;
    }

    private List<OutputInvestmentFundsDTO> normalizeResponse(List<OutputInvestmentFundsDTO> response) {
        if (response != null) {
            return response;
        }

        LOGGER.warn("PFMHR010 devolvió un cuerpo nulo. Se utilizará una lista vacía");
        return Collections.emptyList();
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
        return new ResponseSummary(visibleFunds,  totalElements);
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
        publishLinks(pagination.getDtoLinks());
        publishPaginationParameterTable(pagination);
    }

    private void publishLinks(LinksDTO links) {
        if (links == null) {
            return;
        }

        this.addParameter("DTOLinks", copyLinks(links));
    }
    private void propagatePaginationToEnvelopes(List<OutputInvestmentFundsDTO> payload,
                                                PaginationDTO pagination) {
        if (payload == null || payload.isEmpty()) {
            return;
        }

        for (OutputInvestmentFundsDTO dto : payload) {
            if (dto == null) {
                continue;
            }
            dto.setDTOPagination(clonePagination(pagination));
        }
    }
    private void updateSeverity(ResponseSummary summary) {
        Severity severity = summary.hasVisibleFunds() ? Severity.OK : Severity.ENR;
        this.setSeverity(severity);
    }

    private final class ResponseSummary {
        private final List<InvestmentFund> visibleFunds;
        private final int totalElements;

        private ResponseSummary(List<InvestmentFund> visibleFunds,
                                int totalElements) {
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
        int totalElements = summary == null ? 0 : summary.getTotalElements();
        pagination.setTotalElements((long) totalElements);

        Long pageSize = normalizedPageSize == null ? null : asLong(normalizedPageSize);
        pagination.setPageSize(pageSize);

        long totalPages = 0;
        if (pageSize != null && pageSize > 0 && totalElements > 0) {
            totalPages = (long) Math.ceil((double) totalElements / pageSize);
        }
        pagination.setTotalPages(totalPages);

        int lastPage = totalPages > 0 ? Math.max(clampToInt(totalPages - 1), 0) : 0;
        int safeCurrentPage = Math.min(Math.max(currentPage, 0), lastPage);
        pagination.setPage((long) safeCurrentPage);

        LinksDTO resolvedLinks = resolveLinks(links, safeCurrentPage, lastPage);
        pagination.setDtoLinks(resolvedLinks);
        return pagination;
    }


    private LinksDTO resolveLinks(LinksDTO baseLinks, int currentPage, int lastPage) {
        LinksDTO resolved = baseLinks == null ? new LinksDTO() : copyLinks(baseLinks);

        if (!hasAnyLinkValue(resolved)) {
            resolved.setFirst("0");
            resolved.setLast(String.valueOf(lastPage));
            if (currentPage > 0) {
                resolved.setPrevious(String.valueOf(currentPage - 1));
            }
            if (currentPage < lastPage) {
                resolved.setNext(String.valueOf(currentPage + 1));
            }
            return resolved;
        }

        if (!notBlank(resolved.getFirst())) {
            resolved.setFirst("0");
        }

        if (!notBlank(resolved.getLast())) {
            resolved.setLast(String.valueOf(lastPage));
        }

        return resolved;
    }

    private PaginationDTO clonePagination(PaginationDTO pagination) {
        if (pagination == null) {
            return null;
        }

        PaginationDTO clone = new PaginationDTO();
        clone.setPage(pagination.getPage());
        clone.setPageSize(pagination.getPageSize());
        clone.setTotalElements(pagination.getTotalElements());
        clone.setTotalPages(pagination.getTotalPages());
        clone.setDtoLinks(copyLinks(pagination.getDtoLinks()));
        return clone;
    }

    private void publishPaginationParameterTable(PaginationDTO pagination) {
        if (pagination == null) {
            return;
        }

        PaginationDTO safePagination = clonePagination(pagination);
        this.addParameter("pagination", safePagination);
        this.addParameter("DTOPagination", safePagination);
    }

    private void exposeLinks(LinksDTO exposedLinks, PaginationDTO pagination) {
        LinksDTO safeLinks = exposedLinks == null ? new LinksDTO() : exposedLinks;

        pagination.setDtoLinks(copyLinks(safeLinks));
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
            return new LinksDTO();
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

    private boolean hasAnyLinkValue(LinksDTO links) {
        if (links == null) {
            return false;
        }

        return notBlank(links.getFirst())
                || notBlank(links.getLast())
                || notBlank(links.getPrevious())
                || notBlank(links.getNext());
    }

    private boolean notBlank(String s){
        return s != null && !s.trim().isEmpty();
    }

    private LinksDTO copyLinks(LinksDTO source) {
        if (source == null) {
            return new LinksDTO();
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
            LOGGER.warn("DEBUG PFMHT010 - Se omitieron {} fondos nulos al generar DTOLinks", funds.size() - sanitized.size());
        }

        return sanitized;
    }

    private int indexOf(List<InvestmentFund> funds, InvestmentFund target) {
        if (funds == null || funds.isEmpty() || target == null) {
            return -1;
        }

        String targetId = sanitizeKey(target.getInvestmentFundId());
        String targetNumber = sanitizeKey(target.getNumber());

        for (int i = 0; i < funds.size(); i++) {
            InvestmentFund f = funds.get(i);
            if (f == null) {
                continue;
            }

            String fId = sanitizeKey(f.getInvestmentFundId());
            if (targetId != null && targetId.equals(fId)) {
                return i;
            }

            String fNumber = sanitizeKey(f.getNumber());
            if (targetNumber != null && targetNumber.equals(fNumber)) {
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

    private Integer resolvePageSize(InputListInvestmentFundsDTO input) {
        if (input != null && input.getPageSize() != null && input.getPageSize() > 0) {
            return normalizePageSize(asLong(input.getPageSize()));
        }

        return null;
    }

    private Long asLong(Integer value) {
        return value == null ? null : value.longValue();
    }

    private int clampToInt(Long value) {
        if (value == null) {
            return 0;
        }

        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return value.intValue();
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
