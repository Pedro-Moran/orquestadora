package com.bbva.pinv.lib.r001.mapper;

import com.bbva.pinv.dto.research.SearchResearchFolioResponseData;
import com.bbva.pinv.dto.research.SearchResearchFolioRequest;
import com.bbva.pinv.dto.research.Branch;
import com.bbva.pinv.dto.research.Sender;
import com.bbva.pinv.dto.research.Receiver;
import com.bbva.pinv.dto.research.ResearchUser;
import com.bbva.pinv.dto.research.Contract;
import com.bbva.pinv.dto.research.Holder;
import com.bbva.pinv.dto.research.Status;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchResearchFolioMapper {
    private SearchResearchFolioMapper() {
    }

    public static final String OPERATION_NUMBER = "OPERATION_NUMBER";
    public static final String OPER_TYPE = "OPER_TYPE";
    public static final String RESEARCH_USER = "RESEARCH_USER";
    public static final String FULLNAME_RESEARCH_USER = "FULLNAME_RESEARCH_USER";
    public static final String STATUS_CODE = "STATUS_CODE";
    public static final String LIQUIDATION_DATE = "LIQUIDATION_DATE";
    public static final String OPER_ORIGIN_BRANCH_ID = "OPER_ORIGIN_BRANCH_ID";
    public static final String DEBIT_ACC_HOLD_NAME = "DEBIT_ACC_HOLD_NAME";
    public static final String DEBT_ACCOUNT = "DEBT_ACCOUNT";
    public static final String CREDIT_ACCOUNT_TYPE = "CREDIT_ACCOUNT_TYPE";
    public static final String CREDIT_ACCOUNT_HOLDER_NAME = "CREDIT_ACCOUNT_HOLDER_NAME";
    public static final String TRANSMISSION_COD = "TRANSMISSION_COD";
    public static final String ID_FOLIO = "ID_FOLIO";

    public static Map<String, Object> mapSearchResearchRequestFolio(SearchResearchFolioRequest request) {
        Map<String, Object> requestMap = new java.util.HashMap<>();
        requestMap.put(OPERATION_NUMBER, request.getOperationNumber());
        requestMap.put(OPER_TYPE, request.getOperationType());
        requestMap.put(RESEARCH_USER, request.getResearchUser() != null ? request.getResearchUser().getId() : null);
        requestMap.put(STATUS_CODE, request.getStatus() != null ? request.getStatus().getId() : null);
        requestMap.put("START_DATE", request.getStartDate());
        requestMap.put("END_DATE", request.getEndDate());
        requestMap.put(OPER_ORIGIN_BRANCH_ID, request.getBranch() != null ? request.getBranch().getId() : null);
        requestMap.put("PAGINATION", request.getPaginationKey());
        requestMap.put("PAGE_SIZE", request.getPageSize());
        return requestMap;
    }

    public static SearchResearchFolioResponseData mapSearchResearchFolioResponseData(Map<String, Object> mapOut) {
        SearchResearchFolioResponseData response = new SearchResearchFolioResponseData();

        Branch branch = new Branch();
        Sender sender = new Sender();
        Receiver receiver = new Receiver();
        ResearchUser researchUser = new ResearchUser();
        Contract senderContract = new Contract();
        Contract receiverContract = new Contract();
        Holder senderHolder = new Holder();
        Holder receiverHolder = new Holder();
        Status status = new Status();

        response.setId((String) mapOut.get(ID_FOLIO));
        response.setOperationNumber((String) mapOut.get(OPERATION_NUMBER));
        response.setOperationType((String) mapOut.get(OPER_TYPE));
        response.setLiquidationDate((Date) mapOut.get(LIQUIDATION_DATE));
        response.setTransmissionCode((String) mapOut.get(TRANSMISSION_COD));

        branch.setId((String) mapOut.get(OPER_ORIGIN_BRANCH_ID));
        response.setBranch(branch);

        senderContract.setId((String) mapOut.get(DEBT_ACCOUNT));
        sender.setContract(senderContract);
        senderHolder.setFullName((String) mapOut.get(DEBIT_ACC_HOLD_NAME));
        sender.setHolder(senderHolder);
        response.setSender(sender);

        receiverContract.setId((String) mapOut.get(CREDIT_ACCOUNT_TYPE));
        receiver.setContract(receiverContract);
        receiverHolder.setFullName((String) mapOut.get(CREDIT_ACCOUNT_HOLDER_NAME));
        receiver.setHolder(receiverHolder);
        response.setReceiver(receiver);

        researchUser.setId((String) mapOut.get(RESEARCH_USER));
        researchUser.setFullName((String) mapOut.get(FULLNAME_RESEARCH_USER));
        response.setResearchUser(researchUser);

        status.setId((String) mapOut.get(STATUS_CODE));
        response.setStatus(status);

        return response;
    }

    public static List<SearchResearchFolioResponseData> fromListMapSearchResearchFolioResponseData(List<Map<String, Object>> listMapOut) {
        return listMapOut.stream()
                .map(SearchResearchFolioMapper::mapSearchResearchFolioResponseData)
                .collect(Collectors.toList());
    }
}
