package com.bbva.ccse.lib.r003.impl;

import com.bbva.ccse.dto.acselwebs.DataDTO;
import com.bbva.ccse.dto.acselwebs.DataOutDTO;
import com.bbva.ccse.dto.acselwebs.PolicyDTO;
import com.bbva.ccse.lib.r003.impl.util.Constants;
import com.bbva.ccse.lib.r003.impl.util.Functions;
import com.bbva.ccse.lib.r003.impl.util.Mapper;
import com.bbva.ccse.lib.r006.Config;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.Map;

/**
 * The CCSER003Impl class...
 */
public class CCSER003Impl extends CCSER003Abstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(CCSER003Impl.class);



    /**
     * The execute method...
     */
    @Override
    public DataOutDTO execute(DataDTO dataDTO){
        LOGGER.info("Execute CCSER003Impl - Start");
        if (dataDTO == null || dataDTO.getIdProcesoExec() == null || dataDTO.getIdProcesoExec().isEmpty()) {
            addAdvice(Constants.ERROR_PARAM_REQUERID);
            return new DataOutDTO();
        }
        return sendDtoToLibrary(dataDTO);
    }

    public DataOutDTO sendDtoToLibrary(DataDTO dataDTO){
        LOGGER.info("Execute sendDtoToLibrary - Start");
        String proxy = determineProxy(dataDTO);

        boolean semmas = Constants.ID_CORREO.equals(dataDTO.getMetodoreporte());
        Map<String, Object> mapperToRequest;

        if (dataDTO.getIdProcesoExec().equals(Constants.ID_PROCESS_1) ||
                dataDTO.getIdProcesoExec().equals(Constants.ID_PROCESS_2) ||
                dataDTO.getIdProcesoExec().equals(Constants.ID_PROCESS_3)) {
            LOGGER.info("Execute sendDtoToLibrary - IdProcess{} : ", dataDTO.getIdProcesoExec());
            mapperToRequest = Mapper.mapperDataPower(dataDTO);
            LOGGER.info("Result executionServiceGetDataPower {}", mapperToRequest);
        }else{
            mapperToRequest = Functions.convertToMap(dataDTO);
        }

        String response = ccseR002.executeMethod(mapperToRequest, proxy, semmas);
        LOGGER.info("response ccseR002: {}", response);

        if (response == null) {
            addAdvice(Constants.ERROR_CONNECTION_WITH_LIBRARY);
            return new DataOutDTO();
        }

        if (Constants.ID_PREVISUALIZACION.equals(dataDTO.getMetodoreporte()) && dataDTO.getIdProcesoExec().equals(Constants.ID_REPORTE)) {
            LOGGER.info("Execute sendDtoToLibrary ccseR006");
            String validateResponse = validateResponseCcser006(response);
            if (!validateResponse.equals("OK")) {
                return new DataOutDTO();
            }
            String newResponse = ccseR006.executeMapAndCallDocument(response, Map.of(Config.PROTECTION, "false"));
            LOGGER.info("response ccseR006: {}", newResponse);
            PolicyDTO policyDTO = new PolicyDTO();
            policyDTO.setMessage(newResponse);
            DataOutDTO dataOutDTO = new DataOutDTO();
            dataOutDTO.setPolicy(Collections.singletonList(policyDTO));
            return dataOutDTO;
        }

        return validateResponseCcser002(response);
    }

    public DataOutDTO validateResponseCcser002(String response) {
        JSONObject responseJson = new JSONObject(response);
        if (responseJson.has(Constants.DATA_PARAM)) {
            LOGGER.info("Execute sendDtoToLibrary ccseR002- Response Data");
            return Mapper.mapperResponse(responseJson);
        } else if ((responseJson.has(Constants.TYPE) && responseJson.getString(Constants.TYPE).equals(Constants.ERROR) && responseJson.getString(Constants.MESSAGES).contains(Constants.ORA))) {
            LOGGER.info("Execute sendDtoToLibrary ccseR002- Response Ora");
            addAdviceWithDescription(Constants.ERROR_ORA, Mapper.errorResponse(responseJson));
        } else if (responseJson.has(Constants.TYPE) && responseJson.getString(Constants.TYPE).equals(Constants.ERROR)) {
            LOGGER.info("Execute sendDtoToLibrary ccseR002- Response Error");
            addAdviceWithDescription(Constants.ERROR_FUNCTION_JBOSS, Mapper.errorResponse(responseJson));
        } else if (responseJson.has(Constants.STATUS) && responseJson.getInt(Constants.STATUS) == 401) {
            LOGGER.info("Execute sendDtoToLibrary ccseR002 - Response Unauthorized");
            addAdviceWithDescription(Constants.ERROR_FUNCTION_JBOSS, Mapper.errorResponseUnathorized(responseJson));
        } else {
            addAdvice(Constants.ERROR_CONNECTION_WITH_LIBRARY);
        }

        return new DataOutDTO();
    }

    public String validateResponseCcser006(String response) {
        JSONObject responseJson = new JSONObject(response);
        if ((responseJson.has(Constants.TYPE) && responseJson.getString(Constants.TYPE).equals(Constants.ERROR) && responseJson.getString(Constants.MESSAGES).contains(Constants.ORA))) {
            LOGGER.info("Execute sendDtoToLibrary ccseR006 - Response Ora");
            addAdviceWithDescription(Constants.ERROR_ORA, Mapper.errorResponse(responseJson));
        } else if (responseJson.has(Constants.TYPE) && responseJson.getString(Constants.TYPE).equals(Constants.ERROR)) {
            LOGGER.info("Execute sendDtoToLibrary ccseR006 - Response Error");
            addAdviceWithDescription(Constants.ERROR_FUNCTION_JBOSS, Mapper.errorResponse(responseJson));
        }

        return "OK";
    }

    private String determineProxy(DataDTO dataDTO) {
        if (dataDTO.getIdProcesoExec().equals(Constants.ID_REPORTE) || dataDTO.getIdProcesoExec().equals(Constants.ID_CARATULAS)) {
            return Constants.PROXY_REPORTS;
        }
        if (Constants.ID_BUSQUEDA_DOC.equals(dataDTO.getApuntamiento())) {
            return Constants.PROXY_BUSQUEDA;
        }
        if (Constants.ID_FRONTWEB.equals(dataDTO.getApuntamiento())) {
            return Constants.PROXY_FRONTWEB;
        }
        return Constants.PROXY_ACSEL_WEBS;
    }
}
