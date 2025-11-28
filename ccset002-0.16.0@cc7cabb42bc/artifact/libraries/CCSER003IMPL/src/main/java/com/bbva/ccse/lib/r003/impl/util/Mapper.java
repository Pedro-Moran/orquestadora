package com.bbva.ccse.lib.r003.impl.util;
import com.bbva.ccse.dto.acselwebs.AgentesDTO;
import com.bbva.ccse.dto.acselwebs.AseguradoDTO;
import com.bbva.ccse.dto.acselwebs.AutorizacionesDTO;
import com.bbva.ccse.dto.acselwebs.BeneficiariosDTO;
import com.bbva.ccse.dto.acselwebs.BienesDTO;
import com.bbva.ccse.dto.acselwebs.CardsDTO;
import com.bbva.ccse.dto.acselwebs.CertificadosDTO;
import com.bbva.ccse.dto.acselwebs.ClausulasDTO;
import com.bbva.ccse.dto.acselwebs.ClientesDTO;
import com.bbva.ccse.dto.acselwebs.DataDTO;
import com.bbva.ccse.dto.acselwebs.DataOutDTO;
import com.bbva.ccse.dto.acselwebs.DataPowerDTO;
import com.bbva.ccse.dto.acselwebs.GarantiasDTO;
import com.bbva.ccse.dto.acselwebs.LinksDTO;
import com.bbva.ccse.dto.acselwebs.PaginationDTO;
import com.bbva.ccse.dto.acselwebs.PolicyDTO;
import com.bbva.ccse.dto.acselwebs.RecibosDTO;
import com.bbva.ccse.dto.acselwebs.RetribucionesDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Objects;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mapper {

    private Mapper() {
    }

    public static DataOutDTO mapperResponse(JSONObject data){
        List<PolicyDTO> dataResponse = new ArrayList<>();
        JSONArray dataArray = data.optJSONArray(Constants.DATA_PARAM);
        JSONObject paginationObject = data.optJSONObject(Constants.PAGINATION_PARAM);
        DataOutDTO dataOutDTO = new DataOutDTO();

        for (int i = 0; i < dataArray.length(); i++) {
            PolicyDTO policyDTO = new PolicyDTO();
            JSONObject jsonObject = dataArray.getJSONObject(i);
            policyDTO.setNomcampodatos(jsonObject.optString(Constants.NOMCAMPODATOS_PARAM,null));
            policyDTO.setIndvetoboletin(jsonObject.optString(Constants.INDVETOBOLETIN_PARAM,null));
            policyDTO.setCodrev(jsonObject.optString(Constants.CODREV_PARAM,null));
            policyDTO.setIdesmultinivel(jsonObject.optString(Constants.IDESMULTINIVEL_PARAM,null));
            policyDTO.setDescripcanal(jsonObject.optString(Constants.DESCRIPCANAL_PARAM,null));
            policyDTO.setDigitoIdentificacion(jsonObject.optString(Constants.DIGITOIDENTIFICACION_PARAM, null));
            policyDTO.setPrimerNombre(jsonObject.optString(Constants.PRIMERNOMBRE_PARAM, null));
            policyDTO.setSegundoNombre(jsonObject.optString(Constants.SEGUNDONOMBRE_PARAM, null));
            policyDTO.setPrimerApellido(jsonObject.optString(Constants.PRIMERAPELLIDO_PARAM, null));
            policyDTO.setSegundoApellido(jsonObject.optString(Constants.SEGUNDOAPELLIDO_PARAM, null));
            policyDTO.setFechaDeNacimiento(Functions.getLong(jsonObject,Constants.FECHADENACIMIENTO_PARAM));
            policyDTO.setPaisDeResidencia(jsonObject.optString(Constants.PAISDERESIDENCIA_PARAM, null));
            policyDTO.setSexo(jsonObject.optString(Constants.SEXO_PARAM, null));
            policyDTO.setEdad(jsonObject.optString(Constants.EDAD_PARAM, null));
            policyDTO.setCodigoGeograficoCiudad(jsonObject.optString(Constants.CODIGOGEOGRAFICOCIUDAD_PARAM, null));
            policyDTO.setCodigoGeograficoDepartamento(jsonObject.optString(Constants.CODIGOGEOGRAFICODEPARTAMENTO_PARAM, null));
            policyDTO.setDireccionResidencia(jsonObject.optString(Constants.DIRECCIONRESIDENCIA_PARAM, null));
            policyDTO.setDireccion2(jsonObject.optString(Constants.DIRECCION2_PARAM, null));
            policyDTO.setDireccion3(jsonObject.optString(Constants.DIRECCION3_PARAM, null));
            policyDTO.setDireccion4(jsonObject.optString(Constants.DIRECCION4_PARAM, null));
            policyDTO.setDireccion5(jsonObject.optString(Constants.DIRECCION5_PARAM, null));
            policyDTO.setDireccion6(jsonObject.optString(Constants.DIRECCION6_PARAM, null));
            policyDTO.setDireccion7(jsonObject.optString(Constants.DIRECCION7_PARAM, null));
            policyDTO.setCiudadDeResidencia(jsonObject.optString(Constants.CIUDADDERESIDENCIA_PARAM, null));
            policyDTO.setDepartamentoDeResidencia(jsonObject.optString(Constants.DEPARTAMENTODERESIDENCIA_PARAM, null));
            policyDTO.setTelefono1(jsonObject.optString(Constants.TELEFONO1_PARAM, null));
            policyDTO.setTelefono2(jsonObject.optString(Constants.TELEFONO2_PARAM, null));
            policyDTO.setTelefono3(jsonObject.optString(Constants.TELEFONO3_PARAM, null));
            policyDTO.setProfesion(jsonObject.optString(Constants.PROFESION_PARAM, null));
            policyDTO.setActividadEconomica(jsonObject.optString(Constants.ACTIVIDADECONOMICA_PARAM, null));
            policyDTO.setNumeroCuenta1(jsonObject.optString(Constants.NUMEROCUENTA1_PARAM, null));
            policyDTO.setNumeroCuenta2(jsonObject.optString(Constants.NUMEROCUENTA2_PARAM, null));
            policyDTO.setNumeroCuenta3(jsonObject.optString(Constants.NUMEROCUENTA3_PARAM, null));
            policyDTO.setNumeroCuenta4(jsonObject.optString(Constants.NUMEROCUENTA4_PARAM, null));
            policyDTO.setNumeroCuenta5(jsonObject.optString(Constants.NUMEROCUENTA5_PARAM, null));
            policyDTO.setNumeroCuenta6(jsonObject.optString(Constants.NUMEROCUENTA6_PARAM, null));
            policyDTO.setNumeroCuenta7(jsonObject.optString(Constants.NUMEROCUENTA7_PARAM, null));
            policyDTO.setTipoIdentificacionAsegurado(jsonObject.optString(Constants.TIPOIDENTIFICACIONASEGURADO_PARAM, null));
            policyDTO.setMunicipioDeNacimiento(jsonObject.optString(Constants.MUNICIPIODENACIMIENTO_PARAM, null));
            policyDTO.setDepartamentoDeNacimiento(jsonObject.optString(Constants.DEPARTAMENTODENACIMIENTO_PARAM, null));
            policyDTO.setPaisDeNacimiento(jsonObject.optString(Constants.PAISDENACIMIENTO_PARAM, null));
            policyDTO.setTelefonoResidencia(jsonObject.optString(Constants.TELEFONORESIDENCIA_PARAM, null));
            policyDTO.setCelularResidencia(jsonObject.optString(Constants.CELULARRESIDENCIA_PARAM, null));
            policyDTO.setOcupacion(jsonObject.optString(Constants.OCUPACION_PARAM, null));
            policyDTO.setCodigoProfesion(jsonObject.optString(Constants.CODIGOPROFESION_PARAM, null));
            policyDTO.setIndependiente(jsonObject.optString(Constants.INDEPENDIENTE_PARAM, null));
            policyDTO.setPosicion(jsonObject.optString(Constants.POSICION_PARAM, null));
            policyDTO.setNombreEmpresa(jsonObject.optString(Constants.NOMBREEMPRESA_PARAM, null));
            policyDTO.setDireccionEmpresa(jsonObject.optString(Constants.DIRECCIONEMPRESA_PARAM, null));
            policyDTO.setTelefonoEmpresa(jsonObject.optString(Constants.TELEFONOEMPRESA_PARAM, null));
            policyDTO.setCelularEmpresa(jsonObject.optString(Constants.CELULAREMPRESA_PARAM, null));
            policyDTO.setDescripcionOrigenFondos(jsonObject.optString(Constants.DESCRIPCIONORIGENFONDOS_PARAM, null));
            policyDTO.setIngresoMensual(Functions.getLong(jsonObject,Constants.INGRESOMENSUAL_PARAM));
            policyDTO.setGastoMensual(Functions.getLong(jsonObject,Constants.GASTOMENSUAL_PARAM));
            policyDTO.setOtrosGastos(Functions.getLong(jsonObject,Constants.OTROSGASTOS_PARAM));
            policyDTO.setOtrosIngresos(Functions.getLong(jsonObject,Constants.OTROSINGRESOS_PARAM));
            policyDTO.setDestinoOtrosIngresos(jsonObject.optString(Constants.DESTINOOTROSINGRESOS_PARAM, null));
            policyDTO.setTotalActivos(Functions.getLong(jsonObject,Constants.TOTALACTIVOS_PARAM));
            policyDTO.setTotalPasivos(Functions.getLong(jsonObject,Constants.TOTALPASIVOS_PARAM));
            policyDTO.setTipoProductoMonedaExtranjera(jsonObject.optString(Constants.TIPOPRODUCTOMONEDAEXTRANJERA_PARAM, null));
            policyDTO.setProductoCuentaMonedaExtranjera(jsonObject.optString(Constants.PRODUCTOCUENTAMONEDAEXTRANJERA_PARAM, null));
            policyDTO.setEntidadMonedaExtranjera(jsonObject.optString(Constants.ENTIDADMONEDAEXTRANJERA_PARAM, null));
            policyDTO.setCantidadMonedaExtranjera(Functions.getLong(jsonObject,Constants.CANTIDADMONEDAEXTRANJERA_PARAM));
            policyDTO.setCiudadMonedaExtranjera(jsonObject.optString(Constants.CIUDADMONEDAEXTRANJERA_PARAM, null));
            policyDTO.setPaisMonedaExtranjera(jsonObject.optString(Constants.PAISMONEDAEXTRANJERA_PARAM, null));
            policyDTO.setMonedaExtranjera(jsonObject.optString(Constants.MONEDAEXTRANJERA_PARAM, null));
            policyDTO.setFechaSarlaft(jsonObject.optString(Constants.FECHASARLAFT_PARAM, null));
            policyDTO.setImporteCliente(jsonObject.optString(Constants.IMPORTECLIENTE_PARAM, null));
            policyDTO.setInversion(jsonObject.optString(Constants.INVERSION_PARAM, null));
            policyDTO.setServiciosPago(jsonObject.optString(Constants.SERVICIOSPAGO_PARAM, null));
            policyDTO.setPrestamo(jsonObject.optString(Constants.PRESTAMO_PARAM, null));
            policyDTO.setExportacionCliente(jsonObject.optString(Constants.EXPORTACIONCLIENTE_PARAM, null));
            policyDTO.setCodigoOficina1(jsonObject.optString(Constants.CODIGOOFICINA1_PARAM, null));
            policyDTO.setFechaApertura1(Functions.stringToDate(jsonObject.optString(Constants.FECHAAPERTURA1_PARAM,null)));
            policyDTO.setPorProducto1(jsonObject.optString(Constants.PORPRODUCTO1_PARAM, null));
            policyDTO.setTipoCuenta1(jsonObject.optString(Constants.TIPOCUENTA1_PARAM, null));
            policyDTO.setCanalPrincipal1(jsonObject.optString(Constants.CANALPRINCIPAL1_PARAM, null));
            policyDTO.setCodigoOficina2(jsonObject.optString(Constants.CODIGOOFICINA2_PARAM, null));
            policyDTO.setFechaApertura2(Functions.stringToDate(jsonObject.optString(Constants.FECHAAPERTURA2_PARAM,null)));
            policyDTO.setPorProducto2(jsonObject.optString(Constants.PORPRODUCTO2_PARAM, null));
            policyDTO.setTipoCuenta2(jsonObject.optString(Constants.TIPOCUENTA2_PARAM, null));
            policyDTO.setCanalPrincipal2(jsonObject.optString(Constants.CANALPRINCIPAL2_PARAM, null));
            policyDTO.setCodigoOficina3(jsonObject.optString(Constants.CODIGOOFICINA3_PARAM, null));
            policyDTO.setFechaApertura3(Functions.stringToDate(jsonObject.optString(Constants.FECHAAPERTURA3_PARAM,null)));
            policyDTO.setPorProducto3(jsonObject.optString(Constants.PORPRODUCTO3_PARAM, null));
            policyDTO.setTipoCuenta3(jsonObject.optString(Constants.TIPOCUENTA3_PARAM, null));
            policyDTO.setCanalPrincipal3(jsonObject.optString(Constants.CANALPRINCIPAL3_PARAM, null));
            policyDTO.setCodigoOficina4(jsonObject.optString(Constants.CODIGOOFICINA4_PARAM, null));
            policyDTO.setFechaApertura4(Functions.stringToDate(jsonObject.optString(Constants.FECHAAPERTURA4_PARAM,null)));
            policyDTO.setPorProducto4(jsonObject.optString(Constants.PORPRODUCTO4_PARAM, null));
            policyDTO.setTipoCuenta4(jsonObject.optString(Constants.TIPOCUENTA4_PARAM, null));
            policyDTO.setCanalPrincipal4(jsonObject.optString(Constants.CANALPRINCIPAL4_PARAM, null));
            policyDTO.setCodigoOficina5(jsonObject.optString(Constants.CODIGOOFICINA5_PARAM, null));
            policyDTO.setFechaApertura5(Functions.stringToDate(jsonObject.optString(Constants.FECHAAPERTURA5_PARAM,null)));
            policyDTO.setPorProducto5(jsonObject.optString(Constants.PORPRODUCTO5_PARAM, null));
            policyDTO.setTipoCuenta5(jsonObject.optString(Constants.TIPOCUENTA5_PARAM, null));
            policyDTO.setCanalPrincipal5(jsonObject.optString(Constants.CANALPRINCIPAL5_PARAM, null));
            policyDTO.setCodigoOficina6(jsonObject.optString(Constants.CODIGOOFICINA6_PARAM, null));
            policyDTO.setFechaApertura6(Functions.stringToDate(jsonObject.optString(Constants.FECHAAPERTURA6_PARAM,null)));
            policyDTO.setPorProducto6(jsonObject.optString(Constants.PORPRODUCTO6_PARAM, null));
            policyDTO.setTipoCuenta6(jsonObject.optString(Constants.TIPOCUENTA6_PARAM, null));
            policyDTO.setCanalPrincipal6(jsonObject.optString(Constants.CANALPRINCIPAL6_PARAM, null));
            policyDTO.setCodigoOficina7(jsonObject.optString(Constants.CODIGOOFICINA7_PARAM, null));
            policyDTO.setFechaApertura7(Functions.stringToDate(jsonObject.optString(Constants.FECHAAPERTURA7_PARAM,null)));
            policyDTO.setPorProducto7(jsonObject.optString(Constants.PORPRODUCTO7_PARAM, null));
            policyDTO.setTipoCuenta7(jsonObject.optString(Constants.TIPOCUENTA7_PARAM, null));
            policyDTO.setCanalPrincipal7(jsonObject.optString(Constants.CANALPRINCIPAL7_PARAM, null));
            policyDTO.setTextofinal(jsonObject.optString(Constants.TEXTOFINAL_PARAM, null));
            policyDTO.setTextopreg(jsonObject.optString(Constants.TEXTOPREG_PARAM, null));
            policyDTO.setOrden(Functions.getLong(jsonObject,Constants.ORDEN_PARAM));
            policyDTO.setIndstop(jsonObject.optString(Constants.INDSTOP_PARAM, null));
            policyDTO.setMsgsi(jsonObject.optString(Constants.MSGSI_PARAM, null));
            policyDTO.setMsgno(jsonObject.optString(Constants.MSGNO_PARAM, null));

            JSONArray cuentasArray = jsonObject.optJSONArray(Constants.CUENTASDISPONIBLES_PARAM);
            List<String> cuentasList;
            cuentasList = Optional.ofNullable(cuentasArray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);

            policyDTO.setCuentasdisponibles(cuentasList);
            policyDTO.setRenovacionautomatica(jsonObject.optString(Constants.RENOVACIONAUTOMATICA_PARAM, null));

            JSONArray mediosArray = jsonObject.optJSONArray(Constants.MEDIOSPAGO_PARAM);
            List<String> mediosList ;
            mediosList = Optional.ofNullable(mediosArray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setMediospago(mediosList);
            policyDTO.setTipogenero(jsonObject.optString(Constants.TIPOGENERO_PARAM, null));
            policyDTO.setDescripciongenero(jsonObject.optString(Constants.DESCRIPCIONGENERO_PARAM, null));
            policyDTO.setIdgenero(jsonObject.optString(Constants.IDGENERO_PARAM, null));
            policyDTO.setValueCheckIndem(jsonObject.optString(Constants.VALUECHECKINDEM_PARAM, null));
            policyDTO.setValueCheckReclamo(jsonObject.optString(Constants.VALUECHECKRECLAMO_PARAM, null));
            policyDTO.setValor(jsonObject.optString(Constants.VALOR_PARAM, null));
            policyDTO.setCompania(jsonObject.optString(Constants.COMPANIA_PARAM, null));
            policyDTO.setRamo(jsonObject.optString(Constants.RAMO_PARAM, null));
            policyDTO.setAnio(jsonObject.optString(Constants.ANIO_PARAM, null));
            policyDTO.setIdeaseg(jsonObject.optString(Constants.IDEASEG_PARAM, null));
            policyDTO.setActividad(jsonObject.optString(Constants.ACTIVIDAD_PARAM, null));
            policyDTO.setInfoadic(jsonObject.optString(Constants.INFOADIC_PARAM, null));
            policyDTO.setNumplaca(jsonObject.optString(Constants.NUMPLACA_PARAM, null));
            policyDTO.setNumpisos(jsonObject.optString(Constants.NUMPISOS_PARAM, null));
            policyDTO.setIndbis2(jsonObject.optString(Constants.INDBIS2_PARAM, null));
            policyDTO.setLiteral2(jsonObject.optString(Constants.LITERAL2_PARAM, null));
            policyDTO.setIndbis1(jsonObject.optString(Constants.INDBIS1_PARAM, null));
            policyDTO.setLiteral(jsonObject.optString(Constants.LITERAL_PARAM, null));
            policyDTO.setEstructura(jsonObject.optString(Constants.ESTRUCTURA_PARAM, null));
            policyDTO.setTipopropiedad(jsonObject.optString(Constants.TIPOPROPIEDAD_PARAM, null));
            policyDTO.setTipoinmueble(jsonObject.optString(Constants.TIPOINMUEBLE_PARAM, null));
            policyDTO.setTipovia(jsonObject.optString(Constants.TIPOVIA_PARAM, null));
            policyDTO.setTipoter(jsonObject.optString(Constants.TIPOTER_PARAM, null));
            policyDTO.setZip(jsonObject.optString(Constants.ZIP_PARAM, null));
            policyDTO.setPiso(jsonObject.optString(Constants.PISO_PARAM, null));
            policyDTO.setTipoestructura(jsonObject.optString(Constants.TIPOESTRUCTURA_PARAM, null));
            policyDTO.setTiporiesgo(jsonObject.optString(Constants.TIPORIESGO_PARAM, null));
            policyDTO.setCodorientacion2(jsonObject.optString(Constants.CODORIENTACION2_PARAM, null));
            policyDTO.setCodorientacion(jsonObject.optString(Constants.CODORIENTACION_PARAM, null));
            policyDTO.setDirvalinterseccion(jsonObject.optString(Constants.DIRVALINTERSECCION_PARAM, null));
            policyDTO.setCodcalle(jsonObject.optString(Constants.CODCALLE_PARAM, null));
            policyDTO.setNumero(Functions.getLong(jsonObject,Constants.NUMERO_PARAM));
            policyDTO.setCoddepartamento(jsonObject.optString(Constants.CODDEPARTAMENTO_PARAM, null));
            policyDTO.setCodgrpusr(jsonObject.optString(Constants.CODGRPUSR_PARAM,null));
            policyDTO.setCodprod(jsonObject.optString(Constants.CODPROD_PARAM, null));
            policyDTO.setCodusr(jsonObject.optString(Constants.CODUSR_PARAM,null));
            policyDTO.setCodplan(jsonObject.optString(Constants.CODPLAN_PARAM, null));
            policyDTO.setRevplan(jsonObject.optString(Constants.REVPLAN_PARAM, null));
            policyDTO.setCodcanal(jsonObject.optString(Constants.CODCANAL_PARAM,null));
            policyDTO.setCodsubcanal(jsonObject.optString(Constants.CODSUBCANAL_PARAM,null));
            policyDTO.setCodlval(jsonObject.optString(Constants.CODLVAL_PARAM,null));
            policyDTO.setTipolval(jsonObject.optString(Constants.TIPOLVAL_PARAM,null));
            policyDTO.setTipoid(jsonObject.optString(Constants.TIPOID_PARAM,null));
            policyDTO.setNumid(Functions.getLong(jsonObject,Constants.NUMID_PARAM));
            policyDTO.setCodcli(jsonObject.optString(Constants.CODCLI_PARAM, null));
            policyDTO.setIdepol(Functions.getLong(jsonObject,Constants.IDEPOL_PARAM));
            policyDTO.setNumpol(jsonObject.optString(Constants.NUMPOL_PARAM,null));
            policyDTO.setStspol(jsonObject.optString(Constants.STSPOL_PARAM, null));
            policyDTO.setStssin(jsonObject.optString(Constants.STSSIN_PARAM, null));
            policyDTO.setSumaAseg(Functions.getLong(jsonObject,Constants.SUMASEG_PARAM));
            policyDTO.setPeriodicidadPago(jsonObject.optString(Constants.PERIODICIDADPAGO_PARAM, null));
            policyDTO.setDepartamento(jsonObject.optString(Constants.DEPARTAMENTO_PARAM, null));
            policyDTO.setCiudad(jsonObject.optString(Constants.CIUDAD_PARAM, null));
            policyDTO.setAnioConstruccion(jsonObject.optString(Constants.ANIOCONSTRUCCION_PARAM, null));
            policyDTO.setNomter(jsonObject.optString(Constants.NOMTER_PARAM,null));
            policyDTO.setApeter(jsonObject.optString(Constants.APETER_PARAM,null));
            policyDTO.setDvid(jsonObject.optString(Constants.DVID_PARAM,null));
            policyDTO.setDireccion(jsonObject.optString(Constants.DIRECCION_PARAM,null));
            policyDTO.setDireccion2(jsonObject.optString(Constants.DIRECCION2_PARAM,null));
            policyDTO.setFecnac(jsonObject.optString(Constants.FECNAC_PARAM,null));
            policyDTO.setDescrip(jsonObject.optString(Constants.DESCRIP_PARAM,null));
            policyDTO.setCodpais(jsonObject.optString(Constants.CODPAIS_PARAM,null));
            policyDTO.setTelefono1(jsonObject.optString(Constants.TELEFONO1_PARAM,null));
            policyDTO.setTelefono2(jsonObject.optString(Constants.TELEFONO2_PARAM,null));
            policyDTO.setTelefono3(jsonObject.optString(Constants.TELEFONO3_PARAM,null));
            policyDTO.setDescrip(jsonObject.optString(Constants.DESCRIP_PARAM,null));
            policyDTO.setCodpais(jsonObject.optString(Constants.CODPAIS_PARAM,null));
            policyDTO.setEmail(jsonObject.optString(Constants.EMAIL_PARAM,null));
            policyDTO.setIndben(jsonObject.optString(Constants.INDBEN_PARAM,null));
            policyDTO.setIndcobert(jsonObject.optString(Constants.INDCOBERT_PARAM,null));
            policyDTO.setStscert(jsonObject.optString(Constants.STSCERT_PARAM,null));
            policyDTO.setFecinivig(jsonObject.optString(Constants.FECINIVIG_PARAM,null));
            policyDTO.setFecfinvig(jsonObject.optString(Constants.FECFINVIG_PARAM,null));
            policyDTO.setCodestado(jsonObject.optString(Constants.CODESTADO_PARAM,null));
            policyDTO.setDescestado(jsonObject.optString(Constants.DESCESTADO_PARAM,null));
            policyDTO.setZonageografica(jsonObject.optString(Constants.ZONAGEOGRAFICA_PARAM,null));
            policyDTO.setDescciudad(jsonObject.optString(Constants.DESCCIUDAD_PARAM,null));
            policyDTO.setCodciudad(jsonObject.optString(Constants.CODCIUDAD_PARAM,null));
            policyDTO.setEstrato(Functions.getLong(jsonObject,Constants.ESTRATO_PARAM));
            policyDTO.setCodramocert(jsonObject.optString(Constants.CODRAMOCERT_PARAM,null));
            policyDTO.setNumcot(Functions.getLong(jsonObject,Constants.NUMCOT_PARAM));
            policyDTO.setIdecotiza(Functions.getLong(jsonObject,Constants.IDECOTIZA_PARAM));
            policyDTO.setClasebien(jsonObject.optString(Constants.CLASEBIEN_PARAM,null));
            policyDTO.setCodbien(jsonObject.optString(Constants.CODBIEN_PARAM,null));
            policyDTO.setDescbien(jsonObject.optString(Constants.DESCBIEN_PARAM,null));
            policyDTO.setMontobien(Functions.getLong(jsonObject,Constants.MONTOBIEN_PARAM));
            policyDTO.setIdeclau(Functions.getLong(jsonObject,Constants.IDECLAU_PARAM));
            policyDTO.setDescclau(jsonObject.optString(Constants.DESCCLAU_PARAM,null));
            policyDTO.setParentesco(jsonObject.optString(Constants.PARENTESCO_PARAM,null));
            policyDTO.setCodparentesco(jsonObject.optString(Constants.CODPARENTESCO_PARAM,null));
            policyDTO.setNomben(jsonObject.optString(Constants.NOMBEN_PARAM,null));
            policyDTO.setNumben(Functions.getLong(jsonObject,Constants.NUMBEN_PARAM));
            policyDTO.setIdaseg(jsonObject.optString(Constants.IDASEG_PARAM,null));
            policyDTO.setPorcpart(Functions.getLong(jsonObject,Constants.PORCPART_PARAM));
            policyDTO.setGrupopol(jsonObject.optString(Constants.GRUPOPOL_PARAM,null));
            policyDTO.setNumcanttc(Functions.getLong(jsonObject,Constants.NUMCANTTC_PARAM));
            policyDTO.setInduserasis(jsonObject.optString(Constants.INDUSERASIS_PARAM,null));
            policyDTO.setIndasegadic(jsonObject.optString(Constants.INDASEGADIC_PARAM,null));
            policyDTO.setTipotomador(jsonObject.optString(Constants.TIPOTOMADOR_PARAM,null));
            policyDTO.setCodmunicipio(jsonObject.optString(Constants.CODMUNICIPIO_PARAM,null));
            policyDTO.setMunicipio(jsonObject.optString(Constants.MUNICIPIO_PARAM,null));
            policyDTO.setNumordimp(jsonObject.optString(Constants.NUMORDIMP_PARAM,null));
            policyDTO.setPais(jsonObject.optString(Constants.PAIS_PARAM,null));
            policyDTO.setCodcobert(jsonObject.optString(Constants.CODCOBERT_PARAM,null));
            policyDTO.setDesccobert(jsonObject.optString(Constants.DESCCOBERT_PARAM,null));
            policyDTO.setDesccobert(jsonObject.optString(Constants.DESCCOBERT_PARAM,null));
            policyDTO.setPorcreca(Functions.getLong(jsonObject,Constants.PORCRECA_PARAM));
            policyDTO.setNomusr(jsonObject.optString(Constants.NOMUSR_PARAM,null));
            policyDTO.setCodsuc(jsonObject.optString(Constants.CODSUC_PARAM,null));
            policyDTO.setCodcia(jsonObject.optString(Constants.CODCIA_PARAM,null));
            policyDTO.setCodcanal(jsonObject.optString(Constants.CODCANAL_PARAM,null));
            policyDTO.setCodsubcanal(jsonObject.optString(Constants.CODSUBCANAL_PARAM,null));
            policyDTO.setCodgrppol(jsonObject.optString(Constants.CODGRPPOL_PARAM,null));
            policyDTO.setDesccanal(jsonObject.optString(Constants.DESCCANAL_PARAM,null));
            policyDTO.setDescsubcanal(jsonObject.optString(Constants.DESCSUBCANAL_PARAM,null));
            policyDTO.setCodofibanc(Functions.getLong(jsonObject,Constants.CODOFIBANC_PARAM));
            policyDTO.setNomest(jsonObject.optString(Constants.NOMEST_PARAM,null));
            policyDTO.setDesclval(jsonObject.optString(Constants.DESCLVAL_PARAM,null));
            policyDTO.setNumcert(Functions.getLong(jsonObject,Constants.NUMCERT_PARAM));
            policyDTO.setIndcargabdacsel(jsonObject.optString(Constants.INDCARGABDACSEL_PARAM,null));
            policyDTO.setIndcontproc(jsonObject.optString(Constants.INDCONTPROC_PARAM,null));
            policyDTO.setNomtabla(jsonObject.optString(Constants.NOMTABLA_PARAM,null));
            policyDTO.setDesccampo(jsonObject.optString(Constants.DESCCAMPO_PARAM,null));
            policyDTO.setBlkweb(jsonObject.optString(Constants.BLKWEB_PARAM,null));
            policyDTO.setOrdenblkweb(jsonObject.optString(Constants.ORDENBLKWEB_PARAM,null));
            policyDTO.setIndtipodato(jsonObject.optString(Constants.INDTIPODATO_PARAM,null));
            policyDTO.setIsfixed(jsonObject.optString(Constants.ISFIXED_PARAM,null));
            policyDTO.setPanelkey(jsonObject.optString(Constants.PANELKEY_PARAM,null));
            policyDTO.setOrdensubpanel(jsonObject.optString(Constants.ORDENSUBPANEL_PARAM,null));
            policyDTO.setIseditable(jsonObject.optString(Constants.ISEDITABLE_PARAM,null));
            policyDTO.setIsrequired(jsonObject.optString(Constants.ISREQUIRED_PARAM,null));
            policyDTO.setAfectacampo(jsonObject.optString(Constants.AFECTACAMPO_PARAM,null));
            policyDTO.setTypepresenter(jsonObject.optString(Constants.TYPEPRESENTER_PARAM,null));

            JSONArray cards = jsonObject.optJSONArray(Constants.TARJETA_ASEGURADA_PARAM);
            List<CardsDTO> cardsList = Optional.ofNullable(cards)
                    .map(cardsArray -> IntStream.range(0, cardsArray.length())
                            .mapToObj(cardsArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(card -> {
                                CardsDTO cardsDTO = new CardsDTO();
                                cardsDTO.setTipo(card.optString(Constants.TARJETA_ASEGURADA_TIPO_PARAM, null));
                                cardsDTO.setNumero(card.optString(Constants.TARJETA_ASEGURADA_NUMERO_PARAM, null));
                                return cardsDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setTarjetasaseguradas(cardsList);

            policyDTO.setIdSessionExec(jsonObject.optString(Constants.IDSESSIONEXEC_PARAM,null));
            policyDTO.setMessage(jsonObject.optString(Constants.MESSAGES_PARAM,null));
            policyDTO.setDescplanprod(jsonObject.optString(Constants.DESCPLANPROD_PARAM, null));
            policyDTO.setDescprod(jsonObject.optString(Constants.DESCPROD_PARAM, null));
            policyDTO.setIndafinnity(jsonObject.optString(Constants.INDAFINNITY_PARAM, null));
            policyDTO.setCantparent(Functions.getLong(jsonObject,Constants.CANTPARENT_PARAM));
            policyDTO.setImpuestoanual(jsonObject.optString(Constants.IMPUESTOANUAL_PARAM, null));
            policyDTO.setTotalprimaanual(jsonObject.optString(Constants.TOTALPRIMAANUAL_PARAM, null));
            policyDTO.setTotalprimaperiodica(jsonObject.optString(Constants.TOTALPRIMAPERIODICA_PARAM, null));
            policyDTO.setCodofiges(jsonObject.optString(Constants.CODOFIGES_PARAM, null));
            policyDTO.setCheckbenefley(jsonObject.optString(Constants.CHECKBENEFLEY_PARAM, null));
            policyDTO.setCheckbenefoneroso(jsonObject.optString(Constants.CHECKBENEFONEROSO_PARAM, null));
            policyDTO.setGenero(jsonObject.optString(Constants.GENERO_PARAM , null));
            policyDTO.setApellido(jsonObject.optString(Constants.APELLIDO_PARAM, null));
            policyDTO.setNombre(jsonObject.optString(Constants.NOMBRE_PARAM, null));
            policyDTO.setCodgenero(jsonObject.optString(Constants.CODGENERO_PARAM, null));
            policyDTO.setDescgenero(jsonObject.optString(Constants.DESCGENERO_PARAM, null));
            policyDTO.setApuntamiento(jsonObject.optString(Constants.APUNTAMIENTO_PARAM, null));
            policyDTO.setId(jsonObject.optString(Constants.ID_PARAM, null));
            policyDTO.setHelptopicid(jsonObject.optString(Constants.HELP_TOPIC_ID_PARAM, null));
            policyDTO.setApeben(jsonObject.optString(Constants.APEBEN_PARAM, null));
            policyDTO.setGobalcondlaboral(jsonObject.optString(Constants.GOBALCONDLABORAL_PARAM, null));
            policyDTO.setMethod(jsonObject.optString(Constants.METHOD_PARAM, null));
            policyDTO.setText(jsonObject.optString(Constants.TEXT_PARAM, null));
            policyDTO.setBean(jsonObject.optString(Constants.BEAN_PARAM, null));
            policyDTO.setSelected(jsonObject.optString(Constants.SELECTED_PARAM, null));
            policyDTO.setCodarea(jsonObject.optString(Constants.CODAREA_PARAM, null));
            policyDTO.setStsprod(jsonObject.optString(Constants.STSPROD_PARAM, null));
            policyDTO.setIdpolcot(jsonObject.optString(Constants.IDPOLCOT_PARAM, null));
            policyDTO.setNumctto(jsonObject.optString(Constants.NUMCTTO_PARAM, null));
            policyDTO.setStscot(jsonObject.optString(Constants.STSCOT_PARAM, null));
            policyDTO.setFecsolic(jsonObject.optString(Constants.FECSOLIC_PARAM, null));
            policyDTO.setProveedor(jsonObject.optString(Constants.PROVEEDOR_PARAM, null));
            policyDTO.setTerritorial(jsonObject.optString(Constants.TERRITORIAL_PARAM, null));
            policyDTO.setZona(jsonObject.optString(Constants.ZONA_PARAM, null));
            policyDTO.setSucursal(jsonObject.optString(Constants.SUCURSAL_PARAM, null));
            policyDTO.setFecren(jsonObject.optString(Constants.FECREN_PARAM, null));
            policyDTO.setFecfin(jsonObject.optString(Constants.FECFIN_PARAM, null));
            policyDTO.setFecing(jsonObject.optString(Constants.FECING_PARAM, null));
            policyDTO.setFormpago(jsonObject.optString(Constants.FORMPAGO_PARAM, null));
            policyDTO.setCnumcot(jsonObject.optString(Constants.CNUMCOT_PARAM, null));
            policyDTO.setPnumcot(jsonObject.optString(Constants.PNUMCOT_PARAM, null));
            policyDTO.setCiuedo(jsonObject.optString(Constants.CIUEDO_PARAM, null));
            policyDTO.setCuotacamp(jsonObject.optString(Constants.CUOTACAMP_PARAM, null));
            policyDTO.setPorccamp(jsonObject.optString(Constants.PORCCAMP_PARAM, null));
            policyDTO.setIdecamp(jsonObject.optString(Constants.IDECAMP_PARAM, null));
            policyDTO.setUtilidad(jsonObject.optString(Constants.UTILIDAD_PARAM, null));
            policyDTO.setPlan(jsonObject.optString(Constants.PLAN_PARAM, null));
            policyDTO.setCodmoneda(jsonObject.optString(Constants.COD_MONEDA_PARAM, null));
            policyDTO.setPrimaadic(jsonObject.optString(Constants.PRIMA_ADIC_PARAM, null));
            policyDTO.setPrimagf(jsonObject.optString(Constants.PRIMA_GF_PARAM, null));
            policyDTO.setCantidad(jsonObject.optString(Constants.CANTIDAD_PARAM, null));
            policyDTO.setCodparent(jsonObject.optString(Constants.COD_PARENT_PARAM, null));
            policyDTO.setCodramoplan(jsonObject.optString(Constants.COD_RAMO_PLAN_PARAM, null));


            JSONArray directionResidential = jsonObject.optJSONArray(Constants.DIRECCION_RESIDENCIA_ARRAY_PARAM);
            List<String> direccionResidenciaList;
            direccionResidenciaList = Optional.ofNullable(directionResidential)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setDireccionresidenciarray(direccionResidenciaList);

            JSONArray directionCorrespondence = jsonObject.optJSONArray(Constants.DIRECCION_CORRESPONDENCIA_PARAM);
            List<String> direccionCorrespondenciaList;
            direccionCorrespondenciaList = Optional.ofNullable(directionCorrespondence)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setDireccioncorrespondencia(direccionCorrespondenciaList);

            JSONArray emailArray = jsonObject.optJSONArray(Constants.EMAIL_ARRAY_PARAM);
            List<String> emailList;
            emailList = Optional.ofNullable(emailArray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setEmailarray(emailList);

            JSONArray phone3Array = jsonObject.optJSONArray(Constants.TELEFONO_3_PARAM);
            List<String> phone3List;
            phone3List = Optional.ofNullable(phone3Array)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setTelefono3Array(phone3List);

            JSONArray phone2Array = jsonObject.optJSONArray(Constants.TELEFONO_2_PARAM);
            List<String> phone2List;
            phone2List = Optional.ofNullable(phone2Array)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setTelefono2Array(phone2List);

            JSONArray phone1Array = jsonObject.optJSONArray(Constants.TELEFONO_1_PARAM);
            List<String> phone1List;
            phone1List = Optional.ofNullable(phone1Array)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setTelefono1Array(phone1List);

            policyDTO.setCodmediopago(jsonObject.optString(Constants.COD_MEDIO_PAGO, null));
            policyDTO.setDescmediopago(jsonObject.optString(Constants.DESC_MEDIO_PAGO, null));

            policyDTO.setIndbenefone(jsonObject.optString(Constants.IND_BENE_FONE, null));
            policyDTO.setInduseasis(jsonObject.optString(Constants.IND_USE_ASIS, null));
            policyDTO.setBenfone(jsonObject.optString(Constants.BEN_FONE, null));
            policyDTO.setUseasis(jsonObject.optString(Constants.USE_ASIS, null));
            policyDTO.setFiltro(jsonObject.optString(Constants.FILTRO, null));

            policyDTO.setDocumento(jsonObject.optString(Constants.DOCUMENTO_PARAM, null));
            policyDTO.setFechaini(jsonObject.optString(Constants.FECHAINI_PARAM, null));
            policyDTO.setFechafin(jsonObject.optString(Constants.FECHAFIN_PARAM, null));
            policyDTO.setStatus(jsonObject.optString(Constants.STATUS_PARAM, null));
            policyDTO.setNumcertini(jsonObject.optString(Constants.NUMCERTINI_PARAM, null));
            policyDTO.setNumcertfin(jsonObject.optString(Constants.NUMCERTFIN_PARAM, null));
            policyDTO.setCodformpago(jsonObject.optString(Constants.CODFORMPAGO_PARAM, null));
            policyDTO.setCodofiemi(jsonObject.optString(Constants.CODOFIEMI_PARAM, null));
            policyDTO.setFecinipol(jsonObject.optString(Constants.FECINIPOL_PARAM, null));
            policyDTO.setFechainicio(jsonObject.optString(Constants.FECHAINICIO_PARAM, null));
            policyDTO.setFechfecoper(jsonObject.optString(Constants.FECHFECOPER_PARAM, null));
            policyDTO.setCompnumpol(jsonObject.optString(Constants.COMPNUMPOL_PARAM, null));
            policyDTO.setFecoper(jsonObject.optString(Constants.FECOPER_PARAM, null));
            policyDTO.setCodgestor(jsonObject.optString(Constants.CODGESTOR_PARAM, null));
            policyDTO.setCodofisusc(jsonObject.optString(Constants.CODOFISUSC_PARAM, null));
            policyDTO.setMotivo(jsonObject.optString(Constants.MOTIVO_PARAM, null));
            policyDTO.setGestor(jsonObject.optString(Constants.GESTOR_PARAM, null));
            policyDTO.setFecexc(jsonObject.optString(Constants.FECEXC_PARAM, null));
            policyDTO.setFechainipol(jsonObject.optString(Constants.FECHAINIPOL_PARAM, null));
            policyDTO.setFecfincotiza(jsonObject.optString(Constants.FECFINCOTIZA_PARAM, null));
            policyDTO.setNompercotiza(jsonObject.optString(Constants.NOMPERCOTIZA_PARAM, null));
            policyDTO.setIdcliente(jsonObject.optString(Constants.IDCLIENTE_PARAM, null));
            policyDTO.setCodperiodicpago(jsonObject.optString(Constants.CODPERIODICPAGO_PARAM, null));
            policyDTO.setCotestado(jsonObject.optString(Constants.COTESTADO_PARAM, null));
            policyDTO.setIndrenauto(jsonObject.optString(Constants.INDRENAUTO_PARAM, null));
            policyDTO.setDirec(jsonObject.optString(Constants.DIREC_PARAM, null));
            policyDTO.setCodsuplemento(jsonObject.optString(Constants.CODSUPLEMENTO_PARAM, null));
            policyDTO.setSuplemento(jsonObject.optString(Constants.SUPLEMENTO_PARAM, null));
            policyDTO.setCodmotivo(jsonObject.optString(Constants.CODMOTIVO_PARAM, null));
            policyDTO.setCodsubmotivo(jsonObject.optString(Constants.CODSUBMOTIVO_PARAM, null));
            policyDTO.setSubmotivo(jsonObject.optString(Constants.SUBMOTIVO_PARAM, null));
            policyDTO.setFechasuplemento(jsonObject.optString(Constants.FECHASUPLEMENTO_PARAM, null));
            policyDTO.setIncludemode(jsonObject.optString(Constants.INCLUDEMODE_PARAM, null));
            policyDTO.setPrimaperi(jsonObject.optString(Constants.PRIMAPERI_PARAM, null));
            policyDTO.setPrimaperidica(jsonObject.optString(Constants.PRIMAPERIDICA_PARAM, null));
            policyDTO.setPrimaanual(jsonObject.optString(Constants.PRIMAANUAL_PARAM, null));
            policyDTO.setCoaseguro(jsonObject.optString(Constants.COASEGURO_PARAM, null));
            policyDTO.setSumaasegurado(jsonObject.optString(Constants.SUMAASEGURADO_PARAM, null));
            policyDTO.setPeriodicidad(jsonObject.optString(Constants.PERIODICIDAD_PARAM, null));
            policyDTO.setDireccioncorr(jsonObject.optString(Constants.DIRECCIONCORR_PARAM, null));
            policyDTO.setDireccionres(jsonObject.optString(Constants.DIRECCIONRES_PARAM, null));
            policyDTO.setTipocuenta(jsonObject.optString(Constants.TIPOCUENTA_PARAM, null));
            policyDTO.setCelular(jsonObject.optString(Constants.CELULAR_PARAM, null));
            policyDTO.setCheckrenauto(jsonObject.optString(Constants.CHECKRENAUTO_PARAM, null));
            policyDTO.setCambiorenauto(jsonObject.optString(Constants.CAMBIORENAUTO_PARAM, null));
            policyDTO.setCodexclusion(jsonObject.optString(Constants.CODEXCLUSION_PARAM, null));
            policyDTO.setMotivoexclusion(jsonObject.optString(Constants.MOTIVOEXCLUSION_PARAM, null));
            policyDTO.setObservacion(jsonObject.optString(Constants.OBSERVACION_PARAM, null));
            policyDTO.setCodramo(jsonObject.optString(Constants.CODRAMO_PARAM, null));
            policyDTO.setFefecto(jsonObject.optString(Constants.FEFECTO_PARAM, null));
            policyDTO.setCapital(jsonObject.optString(Constants.CAPITAL_PARAM, null));
            policyDTO.setPrima(jsonObject.optString(Constants.PRIMA_PARAM, null));
            policyDTO.setSobreprima(jsonObject.optString(Constants.SOBREPRIMA_PARAM, null));
            policyDTO.setExtraprima(jsonObject.optString(Constants.EXTRAPRIMA_PARAM, null));
            policyDTO.setDeducible(jsonObject.optString(Constants.DEDUCIBLE_PARAM, null));
            policyDTO.setStscobert(jsonObject.optString(Constants.STSCOBERT_PARAM, null));
            policyDTO.setIndcobertoblig(jsonObject.optString(Constants.INDCOBERTOBLIG_PARAM, null));
            policyDTO.setTasa(jsonObject.optString(Constants.TASA_PARAM, null));
            policyDTO.setBbvasbr(jsonObject.optString(Constants.BBVASBR_PARAM, null));
            policyDTO.setOthersbr(jsonObject.optString(Constants.OTHERSBR_PARAM, null));
            policyDTO.setNosbr(jsonObject.optString(Constants.NOSBR_PARAM, null));
            policyDTO.setClasecli(jsonObject.optString(Constants.CLASECLI_PARAM, null));
            policyDTO.setFecanul(jsonObject.optString(Constants.FECANUL_PARAM, null));
            policyDTO.setFrcinipol(jsonObject.optString(Constants.FRCINIPOL_PARAM, null));
            policyDTO.setTiposusc(jsonObject.optString(Constants.TIPOSUSC_PARAM, null));
            policyDTO.setTiposuscprod(jsonObject.optString(Constants.TIPOSUSCPROD_PARAM, null));
            policyDTO.setCodtipovia(jsonObject.optString(Constants.CODTIPOVIA_PARAM, null));
            policyDTO.setIdedirec(jsonObject.optString(Constants.IDEDIREC_PARAM, null));
            policyDTO.setNumero2(jsonObject.optString(Constants.NUMERO2_PARAM, null));
            policyDTO.setDescripstatus(jsonObject.optString(Constants.DESCRIPSTATUS_PARAM, null));
            policyDTO.setNumsolicitud(jsonObject.optString(Constants.NUMSOLICITUD_PARAM, null));
            policyDTO.setIndasegtitular(jsonObject.optString(Constants.INDASEGTITULAR_PARAM, null));
            policyDTO.setStsaseg(jsonObject.optString(Constants.STSASEG_PARAM, null));
            policyDTO.setDescexclusion(jsonObject.optString(Constants.DESCEXCLUSION_PARAM, null));
            policyDTO.setEfecto(jsonObject.optString(Constants.EFECTO_PARAM, null));
            policyDTO.setEmision(jsonObject.optString(Constants.EMISION_PARAM, null));
            policyDTO.setCobertura(jsonObject.optString(Constants.COBERTURA_PARAM, null));
            policyDTO.setIndicevariable(jsonObject.optString(Constants.INDICEVARIABLE_PARAM, null));
            policyDTO.setCodcapital(jsonObject.optString(Constants.CODCAPITAL_PARAM, null));
            policyDTO.setFechaexc(jsonObject.optString(Constants.FECHAEXC_PARAM, null));
            policyDTO.setStscobertura(jsonObject.optString(Constants.STSCOBERTURA_PARAM, null));
            policyDTO.setParticipacion(jsonObject.optString(Constants.PARTICIPACION_PARAM, null));
            policyDTO.setRecibo(jsonObject.optString(Constants.RECIBO_PARAM, null));
            policyDTO.setTipoop(jsonObject.optString(Constants.TIPOOP_PARAM, null));
            policyDTO.setSaldo(jsonObject.optString(Constants.SALDO_PARAM, null));
            policyDTO.setPoliza(jsonObject.optString(Constants.POLIZA_PARAM, null));
            policyDTO.setClave(jsonObject.optString(Constants.CLAVE_PARAM, null));
            policyDTO.setResponsabledepago(jsonObject.optString(Constants.RESPONSABLEDEPAGO_PARAM, null));
            policyDTO.setNumdocumento(jsonObject.optString(Constants.NUMDOCUMENTO_PARAM, null));
            policyDTO.setPrimabruta(jsonObject.optString(Constants.PRIMABRUTA_PARAM, null));
            policyDTO.setNumfinanc(jsonObject.optString(Constants.NUMFINANC_PARAM, null));
            policyDTO.setRetribucion(jsonObject.optString(Constants.RETRIBUCION_PARAM, null));
            policyDTO.setN(jsonObject.optString(Constants.N_PARAM, null));
            policyDTO.setIva(jsonObject.optString(Constants.IVA_PARAM, null));
            policyDTO.setReteiva(jsonObject.optString(Constants.RETEIVA_PARAM, null));
            policyDTO.setReteica(jsonObject.optString(Constants.RETEICA_PARAM, null));
            policyDTO.setRetefue(jsonObject.optString(Constants.RETEFUE_PARAM, null));
            policyDTO.setOrdenpago(jsonObject.optString(Constants.ORDENPAGO_PARAM, null));
            policyDTO.setNrogiro(jsonObject.optString(Constants.NROGIRO_PARAM, null));
            policyDTO.setFechacobro(jsonObject.optString(Constants.FECHACOBRO_PARAM, null));
            policyDTO.setRecpagouordpago(jsonObject.optString(Constants.RECPAGOUORDPAGO_PARAM, null));
            policyDTO.setIdefact(jsonObject.optString(Constants.IDEFACT_PARAM, null));
            policyDTO.setSldofactmoneda(jsonObject.optString(Constants.SLDOFACTMONEDA_PARAM, null));
            policyDTO.setNivel(jsonObject.optString(Constants.NIVEL_PARAM, null));
            policyDTO.setCodigo(jsonObject.optString(Constants.CODIGO_PARAM, null));
            policyDTO.setClausula(jsonObject.optString(Constants.CLAUSULA_PARAM, null));
            policyDTO.setAnexo(jsonObject.optString(Constants.ANEXO_PARAM, null));
            policyDTO.setIdeclaucert(jsonObject.optString(Constants.IDECLAUCERT_PARAM, null));
            policyDTO.setTexto(jsonObject.optString(Constants.TEXTO_PARAM, null));
            policyDTO.setSiniestro(jsonObject.optString(Constants.SINIESTRO_PARAM, null));
            policyDTO.setFnotificacion(jsonObject.optString(Constants.FNOTIFICACION_PARAM, null));
            policyDTO.setFsiniestro(jsonObject.optString(Constants.FSINIESTRO_PARAM, null));
            policyDTO.setFmodificacion(jsonObject.optString(Constants.FMODIFICACION_PARAM, null));
            policyDTO.setCausa(jsonObject.optString(Constants.CAUSA_PARAM, null));
            policyDTO.setBoton(jsonObject.optString(Constants.BOTON_PARAM, null));
            policyDTO.setServicio(jsonObject.optString(Constants.SERVICIO_PARAM, null));
            policyDTO.setCodmodalidad(jsonObject.optString(Constants.CODMODALIDAD_PARAM, null));
            policyDTO.setModalidad(jsonObject.optString(Constants.MODALIDAD_PARAM, null));
            policyDTO.setNota(jsonObject.optString(Constants.NOTA_PARAM, null));
            policyDTO.setPolicynumberweb(jsonObject.optString(Constants.POLICYNUMBERWEB_PARAM, null));
            policyDTO.setOption(jsonObject.optString(Constants.OPTION_PARAM, null));
            policyDTO.setCustomeridtype(jsonObject.optString(Constants.CUSTOMERIDTYPE_PARAM, null));
            policyDTO.setRenewaltype(jsonObject.optString(Constants.RENEWALTYPE_PARAM, null));
            policyDTO.setCustomeridnumber(jsonObject.optString(Constants.CUSTOMERIDNUMBER_PARAM, null));
            policyDTO.setPolicystatus(jsonObject.optString(Constants.POLICYSTATUS_PARAM, null));
            policyDTO.setPaymentperiod(jsonObject.optString(Constants.PAYMENTPERIOD_PARAM, null));
            policyDTO.setEffectivestartdate(jsonObject.optString(Constants.EFFECTIVESTARTDATE_PARAM, null));
            policyDTO.setRenewaldate(jsonObject.optString(Constants.RENEWALDATE_PARAM, null));
            policyDTO.setDirectdebitaccount(jsonObject.optString(Constants.DIRECTDEBITACCOUNT_PARAM, null));
            policyDTO.setInsuredvalue(jsonObject.optString(Constants.INSUREDVALUE_PARAM, null));
            policyDTO.setManagementoffice(jsonObject.optString(Constants.MANAGEMENTOFFICE_PARAM, null));
            policyDTO.setInsuranceproductcode(jsonObject.optString(Constants.INSURANCEPRODUCTCODE_PARAM, null));
            policyDTO.setUsermanagingpolicy(jsonObject.optString(Constants.USERMANAGINGPOLICY_PARAM, null));
            policyDTO.setOperationdate(jsonObject.optString(Constants.OPERATIONDATE_PARAM, null));
            policyDTO.setPremiumamount(jsonObject.optString(Constants.PREMIUMAMOUNT_PARAM, null));
            policyDTO.setAltamiraaccountnumber(jsonObject.optString(Constants.ALTAMIRAACCOUNTNUMBER_PARAM, null));
            policyDTO.setPaymentreference(jsonObject.optString(Constants.PAYMENTREFERENCE_PARAM, null));
            policyDTO.setAmountvalue(jsonObject.optString(Constants.AMOUNTVALUE_PARAM, null));
            policyDTO.setOperationtime(jsonObject.optString(Constants.OPERATIONTIME_PARAM, null));
            policyDTO.setUserresponsible(jsonObject.optString(Constants.USERRESPONSIBLE_PARAM, null));
            policyDTO.setDescription(jsonObject.optString(Constants.DESCRIPTION_PARAM, null));
            policyDTO.setCustomerpolicynumber(jsonObject.optString(Constants.CUSTOMERPOLICYNUMBER_PARAM, null));
            policyDTO.setIdecobert(jsonObject.optString(Constants.IDECOBERT_PARAM, null));

            JSONArray sumaasegarray = jsonObject.optJSONArray(Constants.SUMAASEGARRAY_PARAM);
            List<String> sumaasegList;
            sumaasegList = Optional.ofNullable(sumaasegarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setSumaasegarray(sumaasegList);

            JSONArray ocupacionarray = jsonObject.optJSONArray(Constants.OCUPACIONARRAY_PARAM);
            List<String> ocupacionList;
            ocupacionList = Optional.ofNullable(ocupacionarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setOcupacionarray(ocupacionList);

            JSONArray periodicidadpagoarray = jsonObject.optJSONArray(Constants.PERIODICIDADPAGOARRAY_PARAM);
            List<String> periodicidadpagoList;
            periodicidadpagoList = Optional.ofNullable(periodicidadpagoarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setPeriodicidadpagoarray(periodicidadpagoList);

            JSONArray planarray = jsonObject.optJSONArray(Constants.PLANARRAY_PARAM);
            List<String> planList;
            planList = Optional.ofNullable(planarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setPlanarray(planList);

            JSONArray departamentoarray = jsonObject.optJSONArray(Constants.DEPARTAMENTOARRAY_PARAM);
            List<String> departamentoList;
            departamentoList = Optional.ofNullable(departamentoarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setDepartamentoarray(departamentoList);

            JSONArray ciudadarray = jsonObject.optJSONArray(Constants.CIUDADARRAY_PARAM);
            List<String> ciudadList;
            ciudadList = Optional.ofNullable(ciudadarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setCiudadarray(ciudadList);

            JSONArray estratoarray = jsonObject.optJSONArray(Constants.ESTRATOARRAY_PARAM);
            List<String> estratoList;
            estratoList = Optional.ofNullable(estratoarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setEstratoarray(estratoList);

            JSONArray anioconstruccionarray = jsonObject.optJSONArray(Constants.ANIOCONSTRUCCIONARRAY_PARAM);
            List<String> anioconstruccionList;
            anioconstruccionList = Optional.ofNullable(anioconstruccionarray)
                    .map(array -> IntStream.range(0, array.length())
                            .mapToObj(array::optString)
                            .collect(Collectors.toList()))
                    .orElse(null);
            policyDTO.setAnioconstruccionarray(anioconstruccionList);


            policyDTO.setNombrereporte(jsonObject.optString(Constants.NOMBREREPORTE_PARAM, null));
            policyDTO.setNit(jsonObject.optString(Constants.NIT_PARAM, null));
            policyDTO.setCtabarrido(jsonObject.optString(Constants.CTABARRIDO_PARAM, null));
            policyDTO.setRol(jsonObject.optString(Constants.ROL_PARAM, null));
            policyDTO.setRcop(jsonObject.optString(Constants.RCOP_PARAM, null));
            policyDTO.setTd(jsonObject.optString(Constants.TD_PARAM, null));
            policyDTO.setTreca(jsonObject.optString(Constants.TRECA_PARAM, null));
            policyDTO.setEstado(jsonObject.optString(Constants.ESTADO_PARAM, null));
            policyDTO.setPrimas(jsonObject.optString(Constants.PRIMAS_PARAM, null));
            policyDTO.setFcobro(jsonObject.optString(Constants.FCOBRO_PARAM, null));
            policyDTO.setFemision(jsonObject.optString(Constants.FEMISION_PARAM, null));
            policyDTO.setAgente(jsonObject.optString(Constants.AGENTE_PARAM, null));
            policyDTO.setCmotivodesc(jsonObject.optString(Constants.CMOTIVODESC_PARAM, null));
            policyDTO.setCcompan(jsonObject.optString(Constants.CCOMPAN_PARAM, null));
            policyDTO.setTnombre(jsonObject.optString(Constants.TNOMBRE_PARAM, null));
            policyDTO.setDni(jsonObject.optString(Constants.DNI_PARAM, null));
            policyDTO.setDescdni(jsonObject.optString(Constants.DESCDNI_PARAM, null));
            policyDTO.setTipofecha(jsonObject.optString(Constants.TIPOFECHA_PARAM, null));
            policyDTO.setCertificadoinicial(jsonObject.optString(Constants.CERTIFICADOINICIAL_PARAM, null));
            policyDTO.setCertificadofinal(jsonObject.optString(Constants.CERTIFICADOFINAL_PARAM, null));
            policyDTO.setProducto(jsonObject.optString(Constants.PRODUCTO_PARAM, null));
            policyDTO.setOper(jsonObject.optString(Constants.OPER_PARAM, null));
            policyDTO.setTproduc(jsonObject.optString(Constants.TPRODUC_PARAM, null));
            policyDTO.setCpoliza(jsonObject.optString(Constants.CPOLIZA_PARAM, null));
            policyDTO.setTpoliza(jsonObject.optString(Constants.TPOLIZA_PARAM, null));
            policyDTO.setBmodpag(jsonObject.optString(Constants.BMODPAG_PARAM, null));
            policyDTO.setCperson(jsonObject.optString(Constants.CPERSON_PARAM, null));
            policyDTO.setTdninit(jsonObject.optString(Constants.TDNINIT_PARAM, null));
            policyDTO.setTapell1(jsonObject.optString(Constants.TAPELL1_PARAM, null));
            policyDTO.setTapell2(jsonObject.optString(Constants.TAPELL2_PARAM, null));
            policyDTO.setNombre1(jsonObject.optString(Constants.NOMBRE1_PARAM, null));
            policyDTO.setBestado(jsonObject.optString(Constants.BESTADO_PARAM, null));
            policyDTO.setCproduc(jsonObject.optString(Constants.CPRODUC_PARAM, null));
            policyDTO.setTrotulo1(jsonObject.optString(Constants.TROTULO1_PARAM, null));
            policyDTO.setCmodali(jsonObject.optString(Constants.CMODALI_PARAM, null));
            policyDTO.setNvermod(jsonObject.optString(Constants.NVERMOD_PARAM, null));
            policyDTO.setTrotulo2(jsonObject.optString(Constants.TROTULO2_PARAM, null));
            policyDTO.setCoficin(jsonObject.optString(Constants.COFICIN_PARAM, null));
            policyDTO.setNmovimi(jsonObject.optString(Constants.NMOVIMI_PARAM, null));
            policyDTO.setBtipmov(jsonObject.optString(Constants.BTIPMOV_PARAM, null));
            policyDTO.setFemisio(jsonObject.optString(Constants.FEMISIO_PARAM, null));
            policyDTO.setCmotivo(jsonObject.optString(Constants.CMOTIVO_PARAM, null));
            policyDTO.setCrecibo(jsonObject.optString(Constants.CRECIBO_PARAM, null));
            policyDTO.setTusuari(jsonObject.optString(Constants.TUSUARI_PARAM, null));
            policyDTO.setTtermin(jsonObject.optString(Constants.TTERMIN_PARAM, null));
            policyDTO.setNhormov(jsonObject.optString(Constants.NHORMOV_PARAM, null));
            policyDTO.setNanexos(jsonObject.optString(Constants.NANEXOS_PARAM, null));
            policyDTO.setBmotivo(jsonObject.optString(Constants.BMOTIVO_PARAM, null));
            policyDTO.setBrepalt(jsonObject.optString(Constants.BREPALT_PARAM, null));
            policyDTO.setTipogarantia(jsonObject.optString(Constants.TIPOGARANTIA_PARAM, null));
            policyDTO.setAmparo(jsonObject.optString(Constants.AMPARO_PARAM, null));
            policyDTO.setTipo(jsonObject.optString(Constants.TIPO_PARAM, null));
            policyDTO.setRelva(jsonObject.optString(Constants.RELVA_PARAM, null));
            policyDTO.setRetlva(jsonObject.optString(Constants.RETLVA_PARAM, null));
            policyDTO.setRetfue(jsonObject.optString(Constants.RETFUE_PARAM, null));
            policyDTO.setOrdpago(jsonObject.optString(Constants.ORDPAGO_PARAM, null));
            policyDTO.setReccaja(jsonObject.optString(Constants.RECCAJA_PARAM, null));
            policyDTO.setGarantia(jsonObject.optString(Constants.GARANTIA_PARAM, null));
            policyDTO.setImporta(jsonObject.optString(Constants.IMPORTA_PARAM, null));
            policyDTO.setIndacsel(jsonObject.optString(Constants.INDACSEL_PARAM, null));
            policyDTO.setIndefront(jsonObject.optString(Constants.INDEFRONT_PARAM, null));
            policyDTO.setIndaplus(jsonObject.optString(Constants.INDAPLUS_PARAM, null));
            policyDTO.setCodval(jsonObject.optString(Constants.CODVAL_PARAM, null));
            policyDTO.setTipoparam(jsonObject.optString(Constants.TIPOPARAM_PARAM, null));
            policyDTO.setCodparam(jsonObject.optString(Constants.CODPARAM_PARAM, null));
            policyDTO.setDescparam(jsonObject.optString(Constants.DESCPARAM_PARAM, null));
            policyDTO.setRefparam(jsonObject.optString(Constants.REFPARAM_PARAM, null));
            policyDTO.setCodsql(jsonObject.optString(Constants.CODSQL_PARAM, null));
            policyDTO.setTotalregs(jsonObject.optString(Constants.TOTALREGS_PARAM, null));


            JSONArray clientes = jsonObject.optJSONArray(Constants.CLIENTE_PARAM);
            List<ClientesDTO> clientesList = Optional.ofNullable(clientes)
                    .map(clientesArray -> IntStream.range(0, clientesArray.length())
                            .mapToObj(clientesArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                ClientesDTO clientesDTO = new ClientesDTO();
                                clientesDTO.setCedula(item.optString(Constants.CEDULA_PARAM, null));
                                clientesDTO.setNombre(item.optString(Constants.NOMBRE_PARAM, null));
                                clientesDTO.setDireccion(item.optString(Constants.DIRECCION_PARAM, null));
                                clientesDTO.setCuenta(item.optString(Constants.CUENTA_PARAM, null));
                                clientesDTO.setTipocuenta(item.optString(Constants.TIPOCUENTA_PARAM, null));
                                return clientesDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setCliente(clientesList);

            JSONArray beneficiarios = jsonObject.optJSONArray(Constants.BENEFICIARIO_PARAM);
            List<BeneficiariosDTO> beneficiariosList = Optional.ofNullable(beneficiarios)
                    .map(beneficiariosArray -> IntStream.range(0, beneficiariosArray.length())
                            .mapToObj(beneficiariosArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                BeneficiariosDTO beneficiariosDTO = new BeneficiariosDTO();
                                beneficiariosDTO.setCedula(item.optString(Constants.CEDULA_PARAM, null));
                                beneficiariosDTO.setNombre(item.optString(Constants.NOMBRE_PARAM, null));
                                beneficiariosDTO.setParentesco(item.optString(Constants.PARENTESCO_PARAM, null));
                                beneficiariosDTO.setPorcpart(item.optString(Constants.PORCPART_PARAM, null));
                                beneficiariosDTO.setAsegurado(item.optString(Constants.ASEGURADO_PARAM, null));
                                return beneficiariosDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setBeneficiario(beneficiariosList);

            JSONArray certificados = jsonObject.optJSONArray(Constants.CERTIFICADO_PARAM);
            List<CertificadosDTO> certificadosList = Optional.ofNullable(certificados)
                    .map(certificadosArray -> IntStream.range(0, certificadosArray.length())
                            .mapToObj(certificadosArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                CertificadosDTO certificadosDTO = new CertificadosDTO();
                                certificadosDTO.setFivig(item.optString(Constants.FIVIG_PARAM, null));
                                certificadosDTO.setFfvig(item.optString(Constants.FFVIG_PARAM, null));
                                certificadosDTO.setCartera(item.optString(Constants.CARTERA_PARAM, null));
                                certificadosDTO.setGestor(item.optString(Constants.GESTOR_PARAM, null));
                                certificadosDTO.setDuracion(item.optString(Constants.DURACION_PARAM, null));
                                certificadosDTO.setModpago(item.optString(Constants.MODPAGO_PARAM, null));
                                certificadosDTO.setPeriodicidad(item.optString(Constants.PERIODICIDAD_PARAM, null));
                                certificadosDTO.setCoaseguro(item.optString(Constants.COASEGURO_PARAM, null));
                                certificadosDTO.setCrecimiento(item.optString(Constants.CRECIMIENTO_PARAM, null));
                                certificadosDTO.setUtilidad(item.optString(Constants.UTILIDAD_PARAM, null));
                                certificadosDTO.setAdministrativos(item.optString(Constants.ADMINISTRATIVOS_PARAM, null));
                                certificadosDTO.setComision(item.optString(Constants.COMISION_PARAM, null));
                                certificadosDTO.setCapitalprincipal(item.optString(Constants.CAPITALPRINCIPAL_PARAM, null));
                                return certificadosDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setCertificado(certificadosList);

            JSONArray retribuciones = jsonObject.optJSONArray(Constants.RETRIBUCIONES_PARAM);
            List<RetribucionesDTO> retribucionesList = Optional.ofNullable(retribuciones)
                    .map(retribucionesArray -> IntStream.range(0, retribucionesArray.length())
                            .mapToObj(retribucionesArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                RetribucionesDTO retribucionesDTO = new RetribucionesDTO();
                                retribucionesDTO.setRol(item.optString(Constants.ROL_PARAM, null));
                                retribucionesDTO.setNit(item.optString(Constants.NIT_PARAM, null));
                                retribucionesDTO.setNombre(item.optString(Constants.NOMBRE_PARAM, null));
                                retribucionesDTO.setRetribucion(item.optString(Constants.RETRIBUCION_PARAM, null));
                                retribucionesDTO.setDesaut(item.optString(Constants.DESAUT_PARAM, null));
                                retribucionesDTO.setCausacion(item.optString(Constants.CAUSACION_PARAM, null));
                                retribucionesDTO.setFinicio(item.optString(Constants.FINICIO_PARAM, null));
                                retribucionesDTO.setFlimite(item.optString(Constants.FLIMITE_PARAM, null));
                                return retribucionesDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setRetribuciones(retribucionesList);

            JSONArray agentes = jsonObject.optJSONArray(Constants.AGENTES_PARAM);
            List<AgentesDTO> agentesList = Optional.ofNullable(agentes)
                    .map(agentesArray -> IntStream.range(0, agentesArray.length())
                            .mapToObj(agentesArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                AgentesDTO agentesDTO = new AgentesDTO();
                                agentesDTO.setNombre(item.optString(Constants.NOMBRE_PARAM, null));
                                agentesDTO.setParticipacion(item.optString(Constants.PARTICIPACION_PARAM, null));
                                agentesDTO.setComision(item.optString(Constants.COMISION_PARAM, null));
                                agentesDTO.setPorcentajecomision(item.optString(Constants.PORCENTAJE_COMISION_PARAM, null));
                                return agentesDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setAgentes(agentesList);

            JSONArray garantias = jsonObject.optJSONArray(Constants.GARANTIAS_PARAM);
            List<GarantiasDTO> garantiasList = Optional.ofNullable(garantias)
                    .map(garantiasArray -> IntStream.range(0, garantiasArray.length())
                            .mapToObj(garantiasArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                GarantiasDTO garantiasDTO = new GarantiasDTO();
                                garantiasDTO.setRamo(item.optString(Constants.RAMO_PARAM, null));
                                garantiasDTO.setAmparo(item.optString(Constants.AMPARO_PARAM, null));
                                garantiasDTO.setEmision(item.optString(Constants.EMISION_PARAM, null));
                                garantiasDTO.setFefecto(item.optString(Constants.FEFECTO_PARAM, null));
                                garantiasDTO.setCapital(item.optString(Constants.CAPITAL_PARAM, null));
                                garantiasDTO.setIndicevariable(item.optString(Constants.INDICEVARIABLE_PARAM, null));
                                garantiasDTO.setPrimaanualunica(item.optString(Constants.PRIMA_ANUAL_UNICA_PARAM, null));
                                garantiasDTO.setSobreprima(item.optString(Constants.SOBREPRIMA_PARAM, null));
                                garantiasDTO.setExtraprima(item.optString(Constants.EXTRAPRIMA_PARAM, null));
                                return garantiasDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setGarantias(garantiasList);

            JSONArray bienes = jsonObject.optJSONArray(Constants.BIENES_PARAM);
            List<BienesDTO> bienesList = Optional.ofNullable(bienes)
                    .map(bienesArray -> IntStream.range(0, bienesArray.length())
                            .mapToObj(bienesArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                BienesDTO bienesDTO = new BienesDTO();
                                bienesDTO.setDesc(item.optString(Constants.DESC_PARAM, null));
                                bienesDTO.setPorcentaje(item.optString(Constants.PORCENTAJE_PARAM, null));
                                bienesDTO.setTar(item.optString(Constants.TAR_PARAM, null));
                                bienesDTO.setCapital(item.optString(Constants.CAPITAL_PARAM, null));
                                bienesDTO.setInd(item.optString(Constants.IND_PARAM, null));
                                return bienesDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setBienes(bienesList);

            JSONArray recibos = jsonObject.optJSONArray(Constants.RECIBOS_PARAM);
            List<RecibosDTO> recibosList = Optional.ofNullable(recibos)
                    .map(recibosArray -> IntStream.range(0, recibosArray.length())
                            .mapToObj(recibosArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                RecibosDTO recibosDTO = new RecibosDTO();
                                recibosDTO.setRecibo(item.optString(Constants.RECIBO_PARAM, null));
                                recibosDTO.setTipo(item.optString(Constants.TIPO_PARAM, null));
                                recibosDTO.setFefecto(item.optString(Constants.FEFECTO_PARAM, null));
                                recibosDTO.setFvencimiento(item.optString(Constants.FVENCIMIENTO_PARAM, null));
                                recibosDTO.setFinanciado(item.optString(Constants.FINANCIADO_PARAM, null));
                                recibosDTO.setCoaseguro(item.optString(Constants.COASEGURO_PARAM, null));
                                recibosDTO.setImporte(item.optString(Constants.IMPORTE_PARAM, null));
                                recibosDTO.setSaldo(item.optString(Constants.SALDO_PARAM, null));
                                recibosDTO.setEstado(item.optString(Constants.ESTADO_PARAM, null));
                                return recibosDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setRecibos(recibosList);

            JSONArray autorizaciones = jsonObject.optJSONArray(Constants.AUTORIZACIONES_PARAM);
            List<AutorizacionesDTO> autorizacionesList = Optional.ofNullable(autorizaciones)
                    .map(autorizacionesArray -> IntStream.range(0, autorizacionesArray.length())
                            .mapToObj(autorizacionesArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                AutorizacionesDTO autorizacionesDTO = new AutorizacionesDTO();
                                autorizacionesDTO.setNivel(item.optString(Constants.NIVEL_PARAM, null));
                                autorizacionesDTO.setAutorizacion(item.optString(Constants.AUTORIZACION_PARAM, null));
                                autorizacionesDTO.setMotivo(item.optString(Constants.MOTIVO_PARAM, null));
                                autorizacionesDTO.setFaut(item.optString(Constants.FAUT_PARAM, null));
                                autorizacionesDTO.setUsuario(item.optString(Constants.USUARIO_PARAM, null));
                                autorizacionesDTO.setCausal(item.optString(Constants.CAUSAL_PARAM, null));
                                autorizacionesDTO.setDescripcion(item.optString(Constants.DESCRIPCION_PARAM, null));
                                autorizacionesDTO.setEstado(item.optString(Constants.ESTADO_PARAM, null));
                                return autorizacionesDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setAutorizaciones(autorizacionesList);

            JSONArray clausulas = jsonObject.optJSONArray(Constants.CLAUSULAS_PARAM);
            List<ClausulasDTO> clausulasList = Optional.ofNullable(clausulas)
                    .map(clausulasArray -> IntStream.range(0, clausulasArray.length())
                            .mapToObj(clausulasArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                ClausulasDTO clausulasDTO = new ClausulasDTO();
                                clausulasDTO.setNivel(item.optString(Constants.NIVEL_PARAM, null));
                                clausulasDTO.setCodigo(item.optString(Constants.CODIGO_PARAM, null));
                                clausulasDTO.setTipo(item.optString(Constants.TIPO_PARAM, null));
                                clausulasDTO.setClausula(item.optString(Constants.CLAUSULA_PARAM, null));
                                clausulasDTO.setAnexo(item.optString(Constants.ANEXO_PARAM, null));
                                clausulasDTO.setFefecto(item.optString(Constants.FEFECTO_PARAM, null));
                                clausulasDTO.setEstado(item.optString(Constants.ESTADO_PARAM, null));
                                return clausulasDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setClausulas(clausulasList);

            policyDTO.setStsbien(jsonObject.optString(Constants.STSBIEN_PARAM, null));
            policyDTO.setAdditionalinfo(jsonObject.optString(Constants.ADDITIONALINFO_PARAM, null));
            policyDTO.setCodocupac(jsonObject.optString(Constants.CODOCUPAC_PARAM, null));
            policyDTO.setFechaefecto(jsonObject.optString(Constants.FECHAEFECTO_PARAM, null));
            policyDTO.setFechaemision(jsonObject.optString(Constants.FECHAEMISION_PARAM, null));
            policyDTO.setPorcpago(jsonObject.optString(Constants.PORCPAGO_PARAM, null));
            policyDTO.setDescripcion(jsonObject.optString(Constants.DESCRIPCION_PARAM, null));
            policyDTO.setMediodepago(jsonObject.optString(Constants.MEDIODEPAGO_PARAM, null));
            policyDTO.setBarridodecuenta(jsonObject.optString(Constants.BARRIDODECUENTA_PARAM, null));
            policyDTO.setCancelacionsaldos(jsonObject.optString(Constants.CANCELACIONSALDOS_PARAM, null));
            policyDTO.setSector(jsonObject.optString(Constants.SECTOR_PARAM, null));
            policyDTO.setIdbien(jsonObject.optString(Constants.IDBIEN_PARAM, null));
            policyDTO.setTipocli(jsonObject.optString(Constants.TIPOCLI_PARAM, null));

            JSONArray asegurados = jsonObject.optJSONArray(Constants.ASEGURADO_PARAM);
            List<AseguradoDTO> aseguradosList = Optional.ofNullable(asegurados)
                    .map(aseguradosArray -> IntStream.range(0, aseguradosArray.length())
                            .mapToObj(aseguradosArray::optJSONObject)
                            .filter(Objects::nonNull)
                            .map(item -> {
                                AseguradoDTO aseguradosDTO = new AseguradoDTO();
                                aseguradosDTO.setCedula(item.optString(Constants.CEDULA_PARAM, null));
                                aseguradosDTO.setNombre(item.optString(Constants.NOMBRE_PARAM, null));
                                aseguradosDTO.setDireccion(item.optString(Constants.DIRECCION_PARAM, null));
                                aseguradosDTO.setEdad(item.optString(Constants.EDAD_PARAM, null));
                                aseguradosDTO.setFecnac(item.optString(Constants.FECNAC_PARAM, null));
                                aseguradosDTO.setParentesco(item.optString(Constants.PARENTESCO_PARAM, null));
                                aseguradosDTO.setPrima(item.optString(Constants.PRIMA_PARAM, null));
                                return aseguradosDTO;
                            })
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty())
                    .orElse(null);
            policyDTO.setAsegurado(aseguradosList);

            policyDTO.setIdProcesoExec(jsonObject.optString(Constants.IDPROCESOEXEC_PARAM, null));
            policyDTO.setDescoaseguro(jsonObject.optString(Constants.DESCOASEGURO_PARAM, null));
            policyDTO.setApemat(jsonObject.optString(Constants.APEMAT_PARAM, null));
            policyDTO.setNumpreformalizado(jsonObject.optString(Constants.NUMPREFORMALIZADO_PARAM, null));
            policyDTO.setConsecutivo(jsonObject.optString(Constants.CONSECUTIVO_PARAM, null));
            policyDTO.setChannelred(jsonObject.optString(Constants.CHANNELRED_PARAM, null));
            policyDTO.setIndcondig(jsonObject.optString(Constants.INDCONDIG_PARAM, null));
            policyDTO.setCodsucursal(jsonObject.optString(Constants.CODSUCURSAL_PARAM, null));
            policyDTO.setNumvaldoc(jsonObject.optString(Constants.NUMVALDOC_PARAM, null));
            policyDTO.setNumcredpre(jsonObject.optString(Constants.NUMCREDPRE_PARAM, null));
            policyDTO.setFecvalida(jsonObject.optString(Constants.FECVALIDA_PARAM, null));
            policyDTO.setNumoper(jsonObject.optString(Constants.NUMOPER_PARAM, null));
            policyDTO.setValaproxactual(jsonObject.optString(Constants.VALAPROX_ACTUAL_PARAM, null));
            policyDTO.setValaproxnueva(jsonObject.optString(Constants.VALAPROX_NUEVA_PARAM, null));

            policyDTO.setIdjob(jsonObject.optString(Constants.IDJOB_PARAM, null));
            policyDTO.setNombrejob(jsonObject.optString(Constants.NOMBREJOB_PARAM, null));
            policyDTO.setCalendario(jsonObject.optString(Constants.CALENDARIO_PARAM, null));
            policyDTO.setHorainicio(jsonObject.optString(Constants.HORAINICIO_PARAM, null));
            policyDTO.setHorafin(jsonObject.optString(Constants.HORAFIN_PARAM, null));
            policyDTO.setCodinterf(jsonObject.optString(Constants.CODINTERF_PARAM, null));
            policyDTO.setCodigoautoriza(jsonObject.optString(Constants.CODIGOAUTORIZA_PARAM, null));
            policyDTO.setCnextrun(jsonObject.optString(Constants.CNEXTRUN_PARAM, null));
            policyDTO.setDescdia(jsonObject.optString(Constants.DESCDIA_PARAM, null));
            policyDTO.setSimulacion(jsonObject.optString(Constants.SIMULACION_PARAM, null));
            policyDTO.setIndprimultdiames(jsonObject.optString(Constants.INDPRIMULTDIAMES_PARAM, null));
            policyDTO.setDiasemana(jsonObject.optString(Constants.DIASEMANA_PARAM, null));
            policyDTO.setDescjob(jsonObject.optString(Constants.DESCJOB_PARAM, null));
            policyDTO.setIndbackground(jsonObject.optString(Constants.INDBACKGROUND_PARAM, null));
            policyDTO.setUsrrunma(jsonObject.optString(Constants.USRRUNMA_PARAM, null));
            policyDTO.setNombreusr(jsonObject.optString(Constants.NOMBREUSR_PARAM, null));
            policyDTO.setNombreusrma(jsonObject.optString(Constants.NOMBREUSRMA_PARAM, null));
            policyDTO.setCantlotes(jsonObject.optString(Constants.CANTLOTES_PARAM, null));
            policyDTO.setDescinterface(jsonObject.optString(Constants.DESCINTERFACE_PARAM, null));
            policyDTO.setUsrresp(jsonObject.optString(Constants.USRRESP_PARAM, null));
            policyDTO.setTipojob(jsonObject.optString(Constants.TIPOJOB_PARAM, null));
            policyDTO.setUsrmodif(jsonObject.optString(Constants.USRMODIF_PARAM, null));
            policyDTO.setFechamodif(jsonObject.optString(Constants.FECHAMODIF_PARAM, null));
            policyDTO.setParametroadic(jsonObject.optString(Constants.PARAMETROADIC_PARAM, null));
            policyDTO.setPeriocidad(jsonObject.optString(Constants.PERIOCIDAD_PARAM, null));
            policyDTO.setDescperiocidad(jsonObject.optString(Constants.DESCPERIOCIDAD_PARAM, null));
            policyDTO.setStsjob(jsonObject.optString(Constants.STSJOB_PARAM, null));
            policyDTO.setCdescsts(jsonObject.optString(Constants.CDESCSTS_PARAM, null));
            policyDTO.setFecharunma(jsonObject.optString(Constants.FECHARUNMA_PARAM, null));
            policyDTO.setFecsts(jsonObject.optString(Constants.FECSTS_PARAM, null));
            policyDTO.setInddiahabil(jsonObject.optString(Constants.INDDIAHABIL_PARAM, null));
            policyDTO.setFechacrea(jsonObject.optString(Constants.FECHACREA_PARAM, null));
            policyDTO.setTipointerfaz(jsonObject.optString(Constants.TIPOINTERFAZ_PARAM, null));
            policyDTO.setAccionjob(jsonObject.optString(Constants.ACCIONJOB_PARAM, null));
            policyDTO.setNombreuseresp(jsonObject.optString(Constants.NOMBREUSERESP_PARAM, null));
            policyDTO.setUsrcrea(jsonObject.optString(Constants.USRCREA_PARAM, null));
            policyDTO.setDesctipo(jsonObject.optString(Constants.DESCTIPO_PARAM, null));
            policyDTO.setBysegundo(jsonObject.optString(Constants.BYSEGUNDO_PARAM, null));
            policyDTO.setByminuto(jsonObject.optString(Constants.BYMINUTO_PARAM, null));
            policyDTO.setByhora(jsonObject.optString(Constants.BYHORA_PARAM, null));
            policyDTO.setIntervalo(jsonObject.optString(Constants.INTERVALO_PARAM, null));
            policyDTO.setIndreproceso(jsonObject.optString(Constants.INDREPROCESO_PARAM, null));
            policyDTO.setObservaciones(jsonObject.optString(Constants.OBSERVACIONES_PARAM, null));

            dataResponse.add(policyDTO);
        }

        PaginationDTO paginationDTO = null;
        if (paginationObject != null) {
            paginationDTO = new PaginationDTO();
            paginationDTO.setPage(Functions.getLong(paginationObject,Constants.PAGINATION_PAGE_PARAM));
            paginationDTO.setTotalPages(Functions.getLong(paginationObject,Constants.PAGINATION_TOTAL_PAGES_PARAM));
            paginationDTO.setTotalElements(Functions.getLong(paginationObject,Constants.PAGINATION_TOTAL_ELEMENTS_PARAM));
            paginationDTO.setPageSize(Functions.getLong(paginationObject,Constants.PAGINATION_TOTAL_PAGE_SIZE));

            JSONObject links = paginationObject.optJSONObject(Constants.PAGINATION_LINKS);
            if (links != null) {
                LinksDTO linksDTO = new LinksDTO();
                linksDTO.setFirst(links.optString(Constants.PAGINATION_LINKS_FIRST,null));
                linksDTO.setLast(links.optString(Constants.PAGINATION_LINKS_LAST,null));
                linksDTO.setPrevious(links.optString(Constants.PAGINATION_LINKS_PREVIOS,null));
                linksDTO.setNext(links.optString(Constants.PAGINATION_LINKS_NEXT,null));
                paginationDTO.setLinks(linksDTO);
            }
        }
        dataOutDTO.setPagination(paginationDTO);
        dataOutDTO.setPolicy(dataResponse);
        return dataOutDTO;
    }

    public static String errorResponse(JSONObject data) {
        return data.optString(Constants.MESSAGES);
    }

    public static Map<String, Object> mapperDataPower(DataDTO dataDto) {
        DataPowerDTO dataPowerDTO = new DataPowerDTO();
        Map<String,Object> dataOut;
        dataPowerDTO.setIdProcesoExec(dataDto.getIdProcesoExec());
        dataPowerDTO.setDigitoIdentificacion(dataDto.getIdentificationDigit());
        dataPowerDTO.setPrimerNombre(dataDto.getFirstName());
        dataPowerDTO.setSegundoNombre(dataDto.getSecondName());
        dataPowerDTO.setPrimerApellido(dataDto.getFirstLastName());
        dataPowerDTO.setSegundoApellido(dataDto.getSecondLastName());
        dataPowerDTO.setFechaDeNacimiento(dataDto.getDateOfBirth());
        dataPowerDTO.setPaisDeResidencia(dataDto.getCountryOfResidence());
        dataPowerDTO.setSexo(dataDto.getGender());
        dataPowerDTO.setEdad(dataDto.getAge());
        dataPowerDTO.setDireccion(dataDto.getAddress());
        dataPowerDTO.setCodigoGeograficoCiudad(dataDto.getGeographicCodeTown());
        dataPowerDTO.setCodigoGeograficoDepartamento(dataDto.getGeographicCodeDepartment());
        dataPowerDTO.setDireccionResidencia(dataDto.getResidenceAddress());
        dataPowerDTO.setDireccion2(dataDto.getAddress2());
        dataPowerDTO.setDireccion3(dataDto.getAddress3());
        dataPowerDTO.setDireccion4(dataDto.getAddress4());
        dataPowerDTO.setDireccion5(dataDto.getAddress5());
        dataPowerDTO.setDireccion6(dataDto.getAddress6());
        dataPowerDTO.setDireccion7(dataDto.getAddress7());
        dataPowerDTO.setCiudadDeResidencia(dataDto.getTownOfResidence());
        dataPowerDTO.setDepartamentoDeResidencia(dataDto.getDepartmentOfResidence());
        dataPowerDTO.setTelefono1(dataDto.getPhone1());
        dataPowerDTO.setTelefono2(dataDto.getPhone2());
        dataPowerDTO.setEmail(dataDto.getEmail());
        dataPowerDTO.setProfesion(dataDto.getProfession());
        dataPowerDTO.setActividadEconomica(dataDto.getActivityEconomy());
        dataPowerDTO.setNumeroCuenta1(dataDto.getAccountNumber1());
        dataPowerDTO.setNumeroCuenta2(dataDto.getAccountNumber2());
        dataPowerDTO.setNumeroCuenta3(dataDto.getAccountNumber3());
        dataPowerDTO.setNumeroCuenta4(dataDto.getAccountNumber4());
        dataPowerDTO.setNumeroCuenta5(dataDto.getAccountNumber5());
        dataPowerDTO.setNumeroCuenta6(dataDto.getAccountNumber6());
        dataPowerDTO.setNumeroCuenta7(dataDto.getAccountNumber7());
        dataPowerDTO.setTipoIdentificacionAsegurado(dataDto.getTypeIdInsured());
        dataPowerDTO.setMunicipioDeNacimiento(dataDto.getMunicipalityBirth());
        dataPowerDTO.setDepartamentoDeNacimiento(dataDto.getDepartmentOfBirth());
        dataPowerDTO.setPaisDeNacimiento(dataDto.getCountryOfBirth());
        dataPowerDTO.setTelefonoResidencia(dataDto.getPhoneResidence());
        dataPowerDTO.setCelularResidencia(dataDto.getCellResidency());
        dataPowerDTO.setOcupacion(dataDto.getOccupation());
        dataPowerDTO.setCodigoProfesion(dataDto.getCodeProfession());
        dataPowerDTO.setIndependiente(dataDto.getIndependent());
        dataPowerDTO.setPosicion(dataDto.getPosition());
        dataPowerDTO.setNombreEmpresa(dataDto.getCompanyName());
        dataPowerDTO.setDireccionEmpresa(dataDto.getCompanyAddress());
        dataPowerDTO.setTelefonoEmpresa(dataDto.getCompanyTelephone());
        dataPowerDTO.setCelularEmpresa(dataDto.getCompanyCellPhone());
        dataPowerDTO.setDescripcionOrigenFondos(dataDto.getDestinationOriginFunds());
        dataPowerDTO.setIngresoMensual(dataDto.getIncomeMonthly());
        dataPowerDTO.setGastoMensual(dataDto.getExpenseMonthly());
        dataPowerDTO.setOtrosGastos(dataDto.getOtherExpenses());
        dataPowerDTO.setOtrosIngresos(dataDto.getOtherIncome());
        dataPowerDTO.setDestinoOtrosIngresos(dataDto.getDestinationOtherIncome());
        dataPowerDTO.setTotalActivos(dataDto.getTotalAssets());
        dataPowerDTO.setTotalPasivos(dataDto.getTotalLiabilities());
        dataPowerDTO.setTipoProductoMonedaExtranjera(dataDto.getTypeOfForeignCurrencyProduct());
        dataPowerDTO.setProductoCuentaMonedaExtranjera(dataDto.getProductForeignCurrencyAccount());
        dataPowerDTO.setEntidadMonedaExtranjera(dataDto.getEntityForeignCurrency());
        dataPowerDTO.setCantidadMonedaExtranjera(dataDto.getAmountForeignCurrency());
        dataPowerDTO.setCiudadMonedaExtranjera(dataDto.getCityForeignCurrency());
        dataPowerDTO.setPaisMonedaExtranjera(dataDto.getCountryForeignCurrency());
        dataPowerDTO.setMonedaExtranjera(dataDto.getForeignCurrency());
        dataPowerDTO.setFechaSarlaft(dataDto.getDatesSarlaft());
        dataPowerDTO.setImporteCliente(dataDto.getCustomerImport());
        dataPowerDTO.setInversion(dataDto.getInvestment());
        dataPowerDTO.setServiciosPago(dataDto.getPaymentServices());
        dataPowerDTO.setPrestamo(dataDto.getLoan());
        dataPowerDTO.setExportacionCliente(dataDto.getCustomerExport());
        dataPowerDTO.setCodigoOficina1(dataDto.getOfficeCode1());
        dataPowerDTO.setFechaApertura1(Functions.dateToString(dataDto.getOpeningDate1()));
        dataPowerDTO.setPorProducto1(dataDto.getByProduct1());
        dataPowerDTO.setTipoCuenta1(dataDto.getAccountType1());
        dataPowerDTO.setCanalPrincipal1(dataDto.getMainChannel1());
        dataPowerDTO.setCodigoOficina2(dataDto.getOfficeCode2());
        dataPowerDTO.setFechaApertura2(Functions.dateToString(dataDto.getOpeningDate2()));
        dataPowerDTO.setPorProducto2(dataDto.getByProduct2());
        dataPowerDTO.setTipoCuenta2(dataDto.getAccountType2());
        dataPowerDTO.setCanalPrincipal2(dataDto.getMainChannel2());
        dataPowerDTO.setCodigoOficina3(dataDto.getOfficeCode3());
        dataPowerDTO.setFechaApertura3(Functions.dateToString(dataDto.getOpeningDate3()));
        dataPowerDTO.setPorProducto3(dataDto.getByProduct3());
        dataPowerDTO.setTipoCuenta3(dataDto.getAccountType3());
        dataPowerDTO.setCanalPrincipal3(dataDto.getMainChannel3());
        dataPowerDTO.setCodigoOficina4(dataDto.getOfficeCode4());
        dataPowerDTO.setFechaApertura4(Functions.dateToString(dataDto.getOpeningDate4()));
        dataPowerDTO.setPorProducto4(dataDto.getByProduct4());
        dataPowerDTO.setTipoCuenta4(dataDto.getAccountType4());
        dataPowerDTO.setCanalPrincipal4(dataDto.getMainChannel4());
        dataPowerDTO.setCodigoOficina5(dataDto.getOfficeCode5());
        dataPowerDTO.setFechaApertura5(Functions.dateToString(dataDto.getOpeningDate5()));
        dataPowerDTO.setPorProducto5(dataDto.getByProduct5());
        dataPowerDTO.setTipoCuenta5(dataDto.getAccountType5());
        dataPowerDTO.setCanalPrincipal5(dataDto.getMainChannel5());
        dataPowerDTO.setCodigoOficina6(dataDto.getOfficeCode6());
        dataPowerDTO.setFechaApertura6(Functions.dateToString(dataDto.getOpeningDate6()));
        dataPowerDTO.setPorProducto6(dataDto.getByProduct6());
        dataPowerDTO.setTipoCuenta6(dataDto.getAccountType6());
        dataPowerDTO.setCanalPrincipal6(dataDto.getMainChannel6());
        dataPowerDTO.setCodigoOficina7(dataDto.getOfficeCode7());
        dataPowerDTO.setFechaApertura7(Functions.dateToString(dataDto.getOpeningDate7()));
        dataPowerDTO.setPorProducto7(dataDto.getByProduct7());
        dataPowerDTO.setTipoCuenta7(dataDto.getAccountType7());
        dataPowerDTO.setCanalPrincipal7(dataDto.getMainChannel7());
        dataPowerDTO.setCodusr(dataDto.getCodusr());
        dataPowerDTO.setNumid(dataDto.getNumid());
        dataPowerDTO.setCodprod(dataDto.getCodprod());
        dataPowerDTO.setDescprod(dataDto.getDescprod());
        dataPowerDTO.setCodplan(dataDto.getCodplan());
        dataPowerDTO.setRevplan(dataDto.getRevplan());
        dataPowerDTO.setDescplanprod(dataDto.getDescplanprod());
        dataPowerDTO.setIndafinnity(dataDto.getIndafinnity());
        dataPowerDTO.setCodcia(dataDto.getCodcia());
        dataPowerDTO.setDescripcanal(dataDto.getDescripcanal());
        dataPowerDTO.setCodgrppol(dataDto.getCodgrppol());
        dataPowerDTO.setCodcanal(dataDto.getCodcanal());
        dataPowerDTO.setCodsubcanal(dataDto.getCodsubcanal());
        dataPowerDTO.setIdesmultinivel(dataDto.getIdesmultinivel());
        dataPowerDTO.setNomest(dataDto.getNomest());
        dataPowerDTO.setCodlval(dataDto.getCodlval());
        dataPowerDTO.setDescrip(dataDto.getDescrip());
        dataPowerDTO.setCodrev(dataDto.getCodrev());
        dataPowerDTO.setIndvetoboletin(dataDto.getIndvetoboletin());
        dataPowerDTO.setMessage(dataDto.getMessage());
        dataPowerDTO.setTipoid(dataDto.getTipoid());
        dataPowerDTO.setDvid(dataDto.getDvid());
        dataPowerDTO.setCodofiges(dataDto.getCodofiges());
        dataPowerDTO.setIdepol(dataDto.getIdepol());
        dataPowerDTO.setPeriodicidad(dataDto.getPeriodicidad());
        dataPowerDTO.setIdecotiza(dataDto.getIdecotiza());
        dataOut = Functions.convertToMap(dataPowerDTO);

        return dataOut;
    }

    public static String errorResponseUnathorized(JSONObject data) {
        return data.optString(Constants.ERROR.toLowerCase(Locale.ROOT));
    }
}
