package com.bbva.ccse;

import com.bbva.ccse.dto.acselwebs.DataOutDTO;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.ccse.lib.r003.CCSER003;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
public class CCSET00201COTransactionTest {

    private Map<String, Object> parameters;

    private Map<Class<?>, Object> serviceLibraries;

    @Mock
    private ApplicationConfigurationService applicationConfigurationService;

    @Mock
    private CommonRequestHeader commonRequestHeader;

    @Mock
    private CCSER003 ccseR003;

    private final CCSET00201COTransaction transaction = new CCSET00201COTransaction() {
        @Override
        protected void addParameter(String field, Object obj) {
            if (parameters != null) {
                parameters.put(field, obj);
            }
        }

        @Override
        protected Object getParameter(String field) {
            return parameters.get(field);
        }

        @Override
        protected <T> T getServiceLibrary(Class<T> serviceInterface) {
            return (T) serviceLibraries.get(serviceInterface);
        }

        @Override
        public String getProperty(String keyProperty) {
            return applicationConfigurationService.getProperty(keyProperty);
        }

        @Override
        protected CommonRequestHeader getRequestHeader() {
            return commonRequestHeader;
        }
    };

    private void setServiceLibrary(Class<?> clasz, Object mockObject) {
        serviceLibraries.put(clasz, mockObject);
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        initializeTransaction();
        this.setServiceLibrary(CCSER003.class, ccseR003);
    }

    private void initializeTransaction() {
        transaction.setContext(new Context());
        parameters = new HashMap<>();
        serviceLibraries = new HashMap<>();
    }


    @Test
    public void executeTest() {
        Mockito.when(ccseR003.execute(Mockito.any())).thenReturn(new DataOutDTO());
        transaction.execute();
        Assert.assertEquals(0,transaction.getAdviceList().size());
    }

    @Test
    public void executetestNull(){
        Mockito.when(ccseR003.execute(Mockito.any())).thenReturn(new DataOutDTO());
        Context context = this.transaction.getContext();
        LinkedList<Advice> adviceList = context.getAdviceList();
        Advice advice = new Advice();
        advice.setCode("CCSE00000001");
        adviceList.add(advice);
        transaction.execute();
        Assert.assertFalse(this.transaction.getContext().getAdviceList().isEmpty());
    }
}
