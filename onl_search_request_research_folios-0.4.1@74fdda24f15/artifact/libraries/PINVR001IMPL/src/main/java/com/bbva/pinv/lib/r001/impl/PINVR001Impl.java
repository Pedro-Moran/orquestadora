package com.bbva.pinv.lib.r001.impl;

import com.bbva.pinv.dto.research.SearchResearchFolioRequest;
import com.bbva.pinv.dto.research.SearchResearchFolioResponse;
import com.bbva.pinv.dto.research.SearchResearchFolioResponseData;
import com.bbva.pinv.dto.research.Pagination;
import com.bbva.pinv.dto.research.PaginationLinks;
import com.bbva.pinv.lib.r001.mapper.SearchResearchFolioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Date;
import java.util.Map;


/**
 * The PINVR001Impl class...
 */
public class PINVR001Impl extends PINVR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(PINVR001Impl.class);
	private static final String PAGINATION_KEY = "paginationKey";
	private static final String PAGE_SIZE = "pageSize";

	@Override
	public SearchResearchFolioResponse executeSearchResearchFolio(SearchResearchFolioRequest searchResearchFolioRequest) {
		LOGGER.info("[executeSearchResearchFolio]: INIT, SearchResearchFolioRequest = {}", searchResearchFolioRequest);

		SearchResearchFolioResponse response = new SearchResearchFolioResponse();
		response.setData(Collections.emptyList());

		Map<String, Object> requestMap = SearchResearchFolioMapper.mapSearchResearchRequestFolio(searchResearchFolioRequest);
		LOGGER.debug("Mapped request: {}", requestMap);

		Map<String, Object> mapResult = mockDataExternalResponse();

		List<Map<String, Object>> respSql = (List<Map<String, Object>>) mapResult.get("elements");
		int registersCount = (int) mapResult.get("totalElements");

		if (registersCount > 0 && respSql != null && !respSql.isEmpty()) {
			try {
				Integer paginationKey = Integer.parseInt(searchResearchFolioRequest.getPaginationKey());
				Integer pageSize = Integer.parseInt(searchResearchFolioRequest.getPageSize());

				List<SearchResearchFolioResponseData> responseData =
						SearchResearchFolioMapper.fromListMapSearchResearchFolioResponseData(respSql);
				response.setData(responseData);

				Pagination pagination = mapPagination(paginationKey, pageSize, registersCount);
				response.setPagination(pagination);
			} catch (NumberFormatException e) {
				LOGGER.error("Error parsing pagination values", e);
			}
		}

		LOGGER.info("[executeSearchResearchFolio] Response: {}", response);
		return response;
	}

	private Map<String, Object> mockDataExternalResponse() {
		List<Map<String, Object>> listMockData = new ArrayList<>();

		Map<String, Object> mockData = new HashMap<>();
		mockData.put("ID_FOLIO", "112254");
		mockData.put("OPER_ORIGIN_BRANCH_ID", "11");
		mockData.put("LIQUIDATION_DATE", new Date());
		mockData.put("OPERATION_NUMBER", "336107");
		mockData.put("OPER_TYPE", "11");
		mockData.put("CREDIT_ACCOUNT_TYPE", "1600871745132665");
		mockData.put("CREDIT_ACCOUNT_HOLDER_NAME", "ALEX RAMIREZ DE LA ROSA");
		mockData.put("RESEARCH_USER", "P029664");
		mockData.put("FULLNAME_RESEARCH_USER", "PEDRO PAREDES LOPEZ");
		mockData.put("DEBT_ACCOUNT", "1600871745132685");
		mockData.put("DEBIT_ACC_HOLD_NAME", "GUSTAVO RAMIREZ DE LA ROSA");
		mockData.put("STATUS_CODE", "RETURNED");
		mockData.put("TRANSMISSION_COD", "1");

		listMockData.add(mockData);

		Map<String, Object> result = new HashMap<>();
		result.put("elements", listMockData);
		result.put("totalElements", listMockData.size());
		return result;
	}

	public Pagination mapPagination(Integer paginationKey, Integer paginationSize, Integer count) {
		Pagination pagination = new Pagination();

		if (count <= 0) {
			LOGGER.warn("El contador es menor o igual a cero: {}", count);
			return pagination;
		}

		long totalPages = count / paginationSize;
		if (count % paginationSize > 0) {
			totalPages += 1;
		}

		long next = paginationKey + 1L;
		long last = totalPages - 1L;
		long previous = paginationKey > 0 ? paginationKey - 1L : 0L;

		PaginationLinks links = new PaginationLinks();
		links.setFirst(PAGINATION_KEY + 0L + "&" + PAGE_SIZE + paginationSize);
		links.setLast(PAGINATION_KEY + last + "&" + PAGE_SIZE + paginationSize);
		if (next < totalPages) {
			links.setNext(PAGINATION_KEY + next + "&" + PAGE_SIZE + paginationSize);
		}
		if (paginationKey > 0) {
			links.setPrevious(PAGINATION_KEY + previous + "&" + PAGE_SIZE + paginationSize);
		}

		pagination.setPage(paginationKey);
		pagination.setTotalPages(totalPages);
		pagination.setTotalElements(count);
		pagination.setPageSize(paginationSize);
		pagination.setLinks(links);

		return pagination;
	}

}
