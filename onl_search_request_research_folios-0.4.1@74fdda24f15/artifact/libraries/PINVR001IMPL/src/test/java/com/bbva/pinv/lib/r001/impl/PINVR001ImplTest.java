package com.bbva.pinv.lib.r001.impl;

import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.pinv.dto.research.SearchResearchFolioResponseData;
import com.bbva.pinv.dto.research.SearchResearchFolioRequest;
import com.bbva.pinv.dto.research.Branch;
import com.bbva.pinv.dto.research.ResearchUser;
import com.bbva.pinv.dto.research.Status;
import com.bbva.pinv.dto.research.SearchResearchFolioResponse;


import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.aop.framework.Advised;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PINVR001ImplTest {

	@Spy
	private Context context;

	@InjectMocks
	private PINVR001Impl pinvR001;

	List<Map<String, Object>> responseDetailJdbc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		responseDetailJdbc = new ArrayList<>();
		Map<String, Object> detailItem = new HashMap<>();

		detailItem.put("ID_FOLIO", "112254");
		detailItem.put("OPERATION_NUMBER", "336107");
		detailItem.put("OPER_TYPE", "11");
		detailItem.put("LIQUIDATION_DATE", java.sql.Date.valueOf("2025-02-12"));
		detailItem.put("OPER_ORIGIN_BRANCH_ID", "11");
		detailItem.put("DEBT_ACCOUNT", "1600871745132685");
		detailItem.put("DEBIT_ACC_HOLD_NAME", "GUSTAVO RAMIREZ DE LA ROSA");
		detailItem.put("CREDIT_ACCOUNT_TYPE", "1600871745132665");
		detailItem.put("CREDIT_ACCOUNT_HOLDER_NAME", "ALEX RAMIREZ DE LA ROSA");
		detailItem.put("RESEARCH_USER", "P029664");
		detailItem.put("FULLNAME_RESEARCH_USER", "PEDRO PAREDES LOPEZ");
		detailItem.put("STATUS_CODE", "RETURNED");
		detailItem.put("TRANSMISSION_COD", "1");

		responseDetailJdbc.add(detailItem);

		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}

	private Object getObjectIntrospection() throws Exception {
		Object result = this.pinvR001;
		if (this.pinvR001 instanceof Advised) {
			Advised advised = (Advised) this.pinvR001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}

	@Test
	public void executeSearchResearchFolioTestwithInfo() {
		SearchResearchFolioRequest request = new SearchResearchFolioRequest();
		Branch branch = new Branch();
		branch.setId("11");

		Status status = new Status();
		status.setId("RETURNED");

		ResearchUser researchUser = new ResearchUser();
		researchUser.setId("P029664");

		request.setOperationNumber("336107");
		request.setOperationType("11");
		request.setStartDate(null);
		request.setEndDate(null);
		request.setBranch(branch);
		request.setResearchUser(researchUser);
		request.setStatus(status);
		request.setPaginationKey("0");
		request.setPageSize("10");

		SearchResearchFolioResponse response = pinvR001.executeSearchResearchFolio(request);
		System.out.println("dataTest: " + response.getData());

		assertNotNull(response);
		assertNotNull(response.getData());
		assertEquals(1, response.getData().size());

		SearchResearchFolioResponseData firstItem = response.getData().get(0);
		assertEquals("336107", firstItem.getOperationNumber());
		assertEquals("112254", firstItem.getId());
		assertEquals("RETURNED", firstItem.getStatus().getId());
		assertEquals("P029664", firstItem.getResearchUser().getId());
	}


}
