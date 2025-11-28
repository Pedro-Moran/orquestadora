package com.bbva.ccse.lib.r003.impl;

import com.bbva.ccse.dto.acselwebs.DataDTO;
import com.bbva.ccse.lib.r002.CCSER002;
import com.bbva.ccse.lib.r003.impl.util.Constants;
import com.bbva.ccse.lib.r003.impl.util.Functions;
import com.bbva.ccse.lib.r006.CCSER006;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;

import com.bbva.elara.utility.api.connector.APIConnector;
import com.bbva.elara.utility.api.connector.APIConnectorBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

public class CCSER003ImplTest {

    private static final String RESPONSE_JSON_LIBRARY = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"codgrpusr\": \"2080\",\n" +
            "      \"codusr\": \"CGS1507\",\n" +
            "      \"nomusr\": \"Ana Catherine Cardenas Gonzalez\",\n" +
            "      \"codsuc\": \"10\",\n" +
            "      \"codcia\": \"01\",\n" +
            "      \"codcanal\": \"0001\",\n" +
            "      \"codsubcanal\": \"0003\",\n" +
            "      \"codgrppol\": \"P001\",\n" +
            "      \"desccanal\": \"Canal Online\",\n" +
            "      \"descsubcanal\": \"Subcanal A\",\n" +
            "      \"codofibanc\": 766,\n" +
            "      \"idesmultinivel\": \"MULTI001\",\n" +
            "      \"nomest\": \"cajica\",\n" +
            "      \"codlval\": \"L01\",\n" +
            "      \"desclval\": \"L01\",\n" +
            "      \"tipolval\": \"C\",\n" +
            "      \"idepol\": 1,\n" +
            "      \"numpol\": \"P12345\",\n" +
            "      \"numcert\": 78945,\n" +
            "      \"tipoid\": \"CC\",\n" +
            "      \"numid\": 1090876543,\n" +
            "      \"indcargabdacsel\": \"N\",\n" +
            "      \"indcontproc\": \"S\",\n" +
            "      \"nomter\": \"ALEXANDRA ROA\",\n" +
            "      \"apeter\": \"ROJAS\",\n" +
            "      \"dvid\": \"1090876543\",\n" +
            "      \"direccion\": \"Calle 123 #45-67, Bogotá, Colombia\",\n" +
            "      \"sexo\": \"M\",\n" +
            "      \"fecnac\": \"1987-02-20\",\n" +
            "      \"descrip\": \"Descripción de cliente\",\n" +
            "      \"codpais\": \"COL\",\n" +
            "      \"telefono1\": \"+57123456789\",\n" +
            "      \"telefono2\": \"+57123456780\",\n" +
            "      \"telefono3\": \"+57123456781\",\n" +
            "      \"email\": \"prueba@bbva.com\",\n" +
            "      \"indben\": \"S\",\n" +
            "      \"indcobert\": \"S\",\n" +
            "      \"stscert\": \"ACT\",\n" +
            "      \"fecinivig\": \"2025-01-01\",\n" +
            "      \"fecfinvig\": \"2025-12-31\",\n" +
            "      \"nomtabla\": \"poliza\",\n" +
            "      \"desccampo\": \"Campo A\",\n" +
            "      \"blkweb\": \"N\",\n" +
            "      \"ordenblkweb\": \"1\",\n" +
            "      \"indtipodato\": \"C\",\n" +
            "      \"isfixed\": \"Y\",\n" +
            "      \"panelkey\": \"PANEL001\",\n" +
            "      \"ordensubpanel\": \"1\",\n" +
            "      \"iseditable\": \"S\",\n" +
            "      \"codestado\": \"BTA\",\n" +
            "      \"descestado\": \"Activo\",\n" +
            "      \"zonageografica\": \"Zona Norte\",\n" +
            "      \"descciudad\": \"Bogotá\",\n" +
            "      \"codciudad\": \"BOG\",\n" +
            "      \"estrato\": 4,\n" +
            "      \"codramocert\": \"S01\",\n" +
            "      \"numcot\": 12345,\n" +
            "      \"idecotiza\": 12345,\n" +
            "      \"clasebien\": \"Bien A\",\n" +
            "      \"codbien\": \"B001\",\n" +
            "      \"descbien\": \"Bien de prueba\",\n" +
            "      \"sumaasegarray\": [\"1000000\", \"2000000\"], \n" +
            "      \"ocupacionarray\": [\"Ingeniero\", \"Contador\"], \n" +
            "      \"periodicidadpagoarray\": [\"Mensual\"], \n" +
            "      \"planarray\": [\"Básico\", \"Premium\"], \n" +
            "      \"departamentoarray\": [\"Cundinamarca\", \"Antioquia\"], \n" +
            "      \"ciudadarray\": [\"Bogotá\", \"Medellín\"], \n" +
            "      \"estratoarray\": [\"3\", \"4\"], \n" +
            "      \"anioconstruccionarray\": [\"2010\"], \n" +
            "      \"emailarray\": [\"ejemplo1@mail.com\", \"ejemplo2@mail.com\"], \n" +
            "      \"direccionresidenciarray\": [\"Calle Falsa 123\"], \n" +
            "      \"direccioncorrespondencia\": [\"Avenida Siempre Viva 742\"], \n" +
            "      \"telefono3Array\": [\"555-0000\"], \n" +
            "      \"telefono2Array\": [\"555-0001\"], \n" +
            "      \"telefono1Array\": [\"555-0002\"], \n" +
            "      \"cuentasdisponibles\": [\"0002\"], \n" +
            "      \"mediospago\": [\"A\"], \n" +
            "      \"tarjetasaseguradas\": [{ \n" +
            "           \"tipo\": \"a\", \n" +
            "           \"codigo\": \"001\" \n" +
            "      }], \n" +
            "      \"cliente\":[{ \n" +
            "           \"cedula\":\"\", \n" +
            "           \"nombre\":\"\", \n" +
            "           \"direccion\":\"\", \n" +
            "           \"cuenta\":\"\", \n" +
            "           \"tipocuenta\":\"\" \n" +
            "      }], \n" +
            "      \"beneficiario\":[{ \n" +
            "           \"cedula\":\"\", \n" +
            "           \"nombre\":\"\", \n" +
            "           \"parentesco\":\"\", \n" +
            "           \"porcpart\":\"\", \n" +
            "           \"asegurado\":\"\" \n" +
            "      }], \n" +
            "      \"certificado\":[{ \n" +
                        "\"fivig\":\"\", \n" +
                        "\"ffvig\":\"\", \n" +
                        "\"cartera\":\"\", \n" +
                        "\"gestor\":\"\", \n" +
                        "\"duracion\":\"\", \n" +
                        "\"modpago\":\"\", \n" +
                        "\"periodicidad\":\"\", \n" +
                        "\"coaseguro\":\"\", \n" +
                        "\"crecimiento\":\"\", \n" +
                        "\"utilidad\":\"\", \n" +
                        "\"administrativos\":\"\", \n" +
                        "\"comision\":\"\", \n" +
                        "\"capitalprincipal\":\"\" \n" +
            "      }], \n" +
            "      \"retribuciones\":[{ \n" +
                        "\"rol\":\"\", \n" +
                        "\"nit\":\"\", \n" +
                        "\"nombre\":\"\", \n" +
                        "\"retribucion\":\"\", \n" +
                        "\"desaut\":\"\", \n" +
                        "\"causacion\":\"\", \n" +
                        "\"finicio\":\"\", \n" +
                        "\"flimite\":\"\" \n" +
            "      }], \n" +
            "      \"agentes\":[{ \n" +
                        "\"nombre\":\"\", \n" +
                        "\"participacion\":\"\", \n" +
                        "\"comision\":\"\", \n" +
                        "\"porcentajecomision\":\"\" \n" +
            "      }], \n" +
            "      \"garantias\":[{ \n" +
                        "\"ramo\":\"\", \n" +
                        "\"amparo\":\"\", \n" +
                        "\"emision\":\"\", \n" +
                        "\"fefecto\":\"\", \n" +
                        "\"capital\":\"\", \n" +
                        "\"indicevariable\":\"\", \n" +
                        "\"primaanualunica\":\"\", \n" +
                        "\"sobreprima\":\"\", \n" +
                        "\"extraprima\":\"\" \n" +
            "      }], \n" +
            "      \"bienes\":[{ \n" +
                        "\"desc\":\"\", \n" +
                        "\"porcentaje\":\"\", \n" +
                        "\"tar\":\"\", \n" +
                        "\"capital\":\"\", \n" +
                        "\"ind\":\"\" \n" +
            "      }], \n" +
            "      \"recibos\":[{ \n" +
                        "\"recibo\":\"\", \n" +
                        "\"tipo\":\"\", \n" +
                        "\"fefecto\":\"\", \n" +
                        "\"fvencimiento\":\"\", \n" +
                        "\"financiado\":\"\", \n" +
                        "\"coaseguro\":\"\", \n" +
                        "\"importe\":\"\", \n" +
                        "\"saldo\":\"\", \n" +
                        "\"estado\":\"\" \n" +
            "      }], \n" +
            "      \"autorizaciones\":[{ \n" +
                        "\"nivel\":\"\", \n" +
                        "\"autorizacion\":\"\", \n" +
                        "\"motivo\":\"\", \n" +
                        "\"faut\":\"\", \n" +
                        "\"usuario\":\"\", \n" +
                        "\"causal\":\"\", \n" +
                        "\"descripcion\":\"\", \n" +
                        "\"estado\":\"\" \n" +
            "      }], \n" +
            "      \"clausulas\":[{ \n" +
                        "\"nivel\":\"\", \n" +
                        "\"codigo\":\"\", \n" +
                        "\"tipo\":\"\", \n" +
                        "\"clausula\":\"\", \n" +
                        "\"anexo\":\"\", \n" +
                        "\"fefecto\":\"\", \n" +
                        "\"estado\":\"\" \n" +
            "      }], \n" +
            "      \"asegurado\":[{ \n" +
                        "\"cedula\":\"\", \n" +
                        "\"nombre\":\"\", \n" +
                        "\"direccion\":\"\", \n" +
                        "\"edad\":\"\", \n" +
                        "\"fecnac\":\"\", \n" +
                        "\"parentesco\":\"\", \n" +
                        "\"prima\":\"\" \n" +
            "      }], \n" +
            "      \"idSessionExec\": \"SESSION123\" \n" +
            "    }\n" +
            "  ],\n" +
            "  \"pagination\": {\n" +
            "    \"links\": {\n" +
            "      \"first\": \"3\",\n" +
            "      \"last\": \"45\",\n" +
            "      \"previous\": \"4\",\n" +
            "      \"next\": \"4\"\n" +
            "    },\n" +
            "    \"page\": 15,\n" +
            "    \"totalPages\": 12,\n" +
            "    \"totalElements\": 3645,\n" +
            "    \"pageSize\": 3\n" +
            "  }\n" +
            "}";

    private static final String RESPONSE_JSON_LIBRARY_ORA = "{"
            + "\"type\": \"ERROR\","
            + "\"message\": \"ORA-Conexión no iniciada\""
            + "}";

    private static final String RESPONSE_JSON_LIBRARY_ERROR_NORMAL = "{"
            + "\"type\": \"ERROR\","
            + "\"message\": \"Servidor apagado\""
            + "}";

    private static final String RESPONSE_JSON_LIBRARY_UNATHORIZED= "{"
            + "\"status\": 401,\n"
            + "\"error\": \"Unauthorized\""
            + "}";

    @InjectMocks
    private CCSER003Impl ccseR003;

    @Mock
    CCSER002 ccser002;

    @Mock
    CCSER006 ccser006;

    @Mock
    APIConnectorBuilder apiConnectorBuilder;

    @Mock
    APIConnector apiConnector;

    DummyMock dummyMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ThreadContext.set(new Context());
        Mockito.when(apiConnectorBuilder.internal()).thenReturn(apiConnectorBuilder);
        Mockito.when(apiConnectorBuilder.build()).thenReturn(apiConnector);
        dummyMock = new DummyMock();
    }

    @Test
    public void executeTest(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY);
        ccseR003.execute(dummyMock.dataDtoRequest());
        Assert.assertEquals(0, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestProxySearch(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY);
        ccseR003.execute(dummyMock.dataDtoRequestSearch());
        Assert.assertEquals(0, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestCCSR06(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY);
        Mockito.when(ccser006.executeMapAndCallDocument(Mockito.any(), Mockito.any())).thenReturn("base64");
        ccseR003.execute(dummyMock.dataDtoRequestPre());
        Assert.assertEquals(0, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestResponseOraCSR06(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY_ORA);
        Mockito.when(ccser006.executeMapAndCallDocument(Mockito.any(), Mockito.any())).thenReturn("base64");
        ccseR003.execute(dummyMock.dataDtoRequestPre());
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestResponseErrorNormalCSR06(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY_ERROR_NORMAL);
        Mockito.when(ccser006.executeMapAndCallDocument(Mockito.any(), Mockito.any())).thenReturn("base64");
        ccseR003.execute(dummyMock.dataDtoRequestPre());
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestNullData(){
        ccseR003.execute(null);
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestEmptyIdProcess(){
        DataDTO dataDTO = new DataDTO();
        dataDTO.setIdProcesoExec("");
        ccseR003.execute(dataDTO);
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestNullIdProcess(){
        DataDTO dataDTO = new DataDTO();
        dataDTO.setIdProcesoExec(null);
        ccseR003.execute(dataDTO);
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestResponseNull(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(null);
        ccseR003.execute(dummyMock.dataDtoRequest());
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestResponseOra(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY_ORA);
        ccseR003.execute(dummyMock.dataDtoRequest());
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestResponseErrorNormal(){
        Mockito.when(ccser002.executeMethod(Mockito.any(), Mockito.any(), Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY_ERROR_NORMAL);
        ccseR003.execute(dummyMock.dataDtoRequest());
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void executeTestServiceGetDataPower(){
        DataDTO dataDTO = new DataDTO();
        dataDTO.setIdProcesoExec(Constants.ID_PROCESS_1);
        ccseR003.execute(dataDTO);
        Assert.assertEquals(1, ccseR003.getAdviceList().size());

    }

    @Test
    public void executeTestResponseUnathorized() {
        Mockito.when(ccser002.executeMethod(Mockito.any(),Mockito.any(),Mockito.any(Boolean.class))).thenReturn(RESPONSE_JSON_LIBRARY_UNATHORIZED);
        ccseR003.execute(dummyMock.dataDtoRequest());
        Assert.assertEquals(1, ccseR003.getAdviceList().size());
    }

    @Test
    public void testConvertToMap(){
        DataDTO dataDTO = new DataDTO();
        dataDTO.setCodprod("555");
        Map<String, Object> map = Functions.convertToMap(dataDTO);
        Assert.assertEquals("555", map.get("codprod"));
    }

    @Test
    public void testConvertToMapNullValue(){
        DataDTO dataDTO = new DataDTO();
        Map<String, Object> map = Functions.convertToMap(dataDTO);
        Assert.assertFalse(map.containsKey("codprod"));
    }

    @Test
    public void testConvertToMapEmptyList(){
        DataDTO dataDTO = new DataDTO();
        List<String> empty = List.of();
        dataDTO.setEmailarray(empty);
        Map<String, Object> map = Functions.convertToMap(dataDTO);
        Assert.assertFalse(map.containsKey("emailarray"));
    }
}
