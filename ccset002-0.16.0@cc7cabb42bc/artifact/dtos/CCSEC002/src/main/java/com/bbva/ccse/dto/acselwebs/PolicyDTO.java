package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PolicyDTO implements Serializable {
    private static final long serialVersionUID = -4200916547430476012L;

    private Long cantparent;
    private String impuestoanual;
    private String totalprimaanual;
    private String totalprimaperiodica;
    private String nomcampodatos;
    private String indvetoboletin;
    private String codrev;
    private String idestmultinivel;
    private String descripcanal;
    private String digitoIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long fechaDeNacimiento;
    private String paisDeResidencia;
    private String sexo;
    private String edad;
    private String codigoGeograficoCiudad;
    private String codigoGeograficoDepartamento;
    private String direccionResidencia;
    private String direccion2;
    private String direccion3;
    private String direccion4;
    private String direccion5;
    private String direccion6;
    private String direccion7;
    private String ciudadDeResidencia;
    private String departamentoDeResidencia;
    private String telefono1;
    private String telefono2;
    private String telefono3;
    private String profesion;
    private String actividadEconomica;
    private String numeroCuenta1;
    private String numeroCuenta2;
    private String numeroCuenta3;
    private String numeroCuenta4;
    private String numeroCuenta5;
    private String numeroCuenta6;
    private String numeroCuenta7;
    private String tipoIdentificacionAsegurado;
    private String municipioDeNacimiento;
    private String departamentoDeNacimiento;
    private String paisDeNacimiento;
    private String telefonoResidencia;
    private String celularResidencia;
    private String ocupacion;
    private String codigoProfesion;
    private String independiente;
    private String posicion;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String celularEmpresa;
    private String descripcionOrigenFondos;
    private Long ingresoMensual;
    private Long gastoMensual;
    private Long otrosGastos;
    private Long otrosIngresos;
    private String destinoOtrosIngresos;
    private Long totalActivos;
    private Long totalPasivos;
    private String tipoProductoMonedaExtranjera;
    private String productoCuentaMonedaExtranjera;
    private String entidadMonedaExtranjera;
    private Long cantidadMonedaExtranjera;
    private String ciudadMonedaExtranjera;
    private String paisMonedaExtranjera;
    private String monedaExtranjera;
    private String fechaSarlaft;
    private String importeCliente;
    private String inversion;
    private String serviciosPago;
    private String prestamo;
    private String exportacionCliente;
    private String codigoOficina1;
    private Date fechaApertura1;
    private String porProducto1;
    private String tipoCuenta1;
    private String canalPrincipal1;
    private String codigoOficina2;
    private Date fechaApertura2;
    private String porProducto2;
    private String tipoCuenta2;
    private String canalPrincipal2;
    private String codigoOficina3;
    private Date fechaApertura3;
    private String porProducto3;
    private String tipoCuenta3;
    private String canalPrincipal3;
    private String codigoOficina4;
    private Date fechaApertura4;
    private String porProducto4;
    private String tipoCuenta4;
    private String canalPrincipal4;
    private String codigoOficina5;
    private Date fechaApertura5;
    private String porProducto5;
    private String tipoCuenta5;
    private String canalPrincipal5;
    private String codigoOficina6;
    private Date fechaApertura6;
    private String porProducto6;
    private String tipoCuenta6;
    private String canalPrincipal6;
    private String codigoOficina7;
    private Date fechaApertura7;
    private String porProducto7;
    private String tipoCuenta7;
    private String canalPrincipal7;
    private String textofinal;
    private String textopreg;
    private Long orden;
    private String indstop;
    private String msgsi;
    private String msgno;
    private List<String> cuentasdisponibles;
    private String renovacionautomatica;
    private List<String> mediospago;
    private String tipogenero;
    private String descripciongenero;
    private String idgenero;
    private String valueCheckIndem;
    private String valueCheckReclamo;
    private String valor;
    private String compania;
    private String ramo;
    private String anio;
    private String ideaseg;
    private String actividad;
    private String infoadic;
    private String numplaca;
    private String numpisos;
    private String indbis2;
    private String literal2;
    private String indbis1;
    private String literal;
    private String estructura;
    private String tipopropiedad;
    private String tipoinmueble;
    private String tipovia;
    private String tipoter;
    private String zip;
    private String piso;
    private String tipoestructura;
    private String tiporiesgo;
    private String codorientacion2;
    private String codorientacion;
    private String dirvalinterseccion;
    private String codcalle;
    private Long numero;
    private String coddepartamento;
    private String codgrpusr;
    private String codprod;
    private String codusr;
    private String codplan;
    private String revplan;
    private String codcanal;
    private String codsubcanal;
    private String codlval;
    private String tipolval;
    private String tipoid;
    private Long numid;
    private String codcli;
    private Long idepol;
    private String numpol;
    private String stspol;
    private String stssin;
    private Long sumaAseg;
    private String periodicidadPago;
    private String departamento;
    private String ciudad;
    private String anioConstruccion;
    private String nomter;
    private String apeter;
    private String dvid;
    private String direccion;
    private String fecnac;
    private String descrip;
    private String codpais;
    private String indben;
    private String indcobert;
    private String stscert;
    private String fecinivig;
    private String fecfinvig;
    private String codestado;
    private String descestado;
    private String zonageografica;
    private String descciudad;
    private String codciudad;
    private Long estrato;
    private String codramocert;
    private Long numcot;
    private Long idecotiza;
    private String clasebien;
    private String codbien;
    private String descbien;
    private Long montobien;
    private Long ideclau;
    private String descclau;
    private String parentesco;
    private String codparentesco;
    private String nomben;
    private Long numben;
    private String idaseg;
    private Long porcpart;
    private String grupopol;
    private Long numcanttc;
    private String induserasis;
    private String indasegadic;
    private String tipotomador;
    private String codmunicipio;
    private String municipio;
    private String numordimp;
    private String pais;
    private String codcobert;
    private String desccobert;
    private Long porcreca;
    private String nomusr;
    private String codsuc;
    private String codcia;
    private String codgrppol;
    private String desccanal;
    private String descsubcanal;
    private Long codofibanc;
    private String idesmultinivel;
    private String nomest;
    private String desclval;
    private Long numcert;
    private String indcargabdacsel;
    private String indcontproc;
    private String nomtabla;
    private String desccampo;
    private String blkweb;
    private String ordenblkweb;
    private String indtipodato;
    private String isfixed;
    private String panelkey;
    private String ordensubpanel;
    private String iseditable;
    private String isrequired;
    private String afectacampo;
    private String typepresenter;
    private List<CardsDTO> tarjetasaseguradas;
    private String idSessionExec;
    private String message;
    private String descplanprod;
    private String descprod;
    private String indafinnity;
    private String email;
    private String codofiges;
    private String checkbenefley;
    private String checkbenefoneroso;
    private String genero;
    private String apellido;
    private String nombre;
    private String codgenero;
    private String descgenero;
    private String apuntamiento;
    private String id;
    private String helptopicid;
    private String apeben;
    private String gobalcondlaboral;
    private String method;
    private String text;
    private String bean;
    private String selected;
    private String codarea;
    private String stsprod;
    private String idpolcot;
    private String numctto;
    private String stscot;
    private String fecsolic;
    private String proveedor;
    private String territorial;
    private String zona;
    private String sucursal;
    private String fecren;
    private String fecfin;
    private String fecing;
    private String formpago;
    private String cnumcot;
    private String pnumcot;
    private String ciuedo;
    private String cuotacamp;
    private String porccamp;
    private String idecamp;
    private String utilidad;
    private String plan;
    private String codmoneda;
    private String primaadic;
    private String primagf;
    private String cantidad;
    private String codparent;
    private String codramoplan;
    private List<String> emailarray;
    private List<String> direccionresidenciarray;
    private List<String> direccioncorrespondencia;
    private List<String> telefono3Array;
    private List<String> telefono2Array;
    private List<String> telefono1Array;
    private String codmediopago;
    private String descmediopago;
    private String indbenefone;
    private String induseasis;
    private String benfone;
    private String useasis;
    private String filtro;
    private String documento;
    private String fechaini;
    private String fechafin;
    private String status;
    private String numcertini;
    private String numcertfin;
    private String codformpago;
    private String codofiemi;
    private String fecinipol;
    private String fechainicio;
    private String fechfecoper;
    private String compnumpol;
    private String fecoper;
    private String codgestor;
    private String codofisusc;
    private String motivo;
    private String gestor;
    private String fecexc;
    private String fechainipol;
    private String fecfincotiza;
    private String nompercotiza;
    private String idcliente;
    private String codperiodicpago;
    private String cotestado;
    private String indrenauto;
    private String direc;
    private String codsuplemento;
    private String suplemento;
    private String codmotivo;
    private String codsubmotivo;
    private String submotivo;
    private String fechasuplemento;
    private String includemode;
    private String primaperi;
    private String primaperidica;
    private String primaanual;
    private String coaseguro;
    private String sumaasegurado;
    private String periodicidad;
    private String direccioncorr;
    private String direccionres;
    private String tipocuenta;
    private String celular;
    private String checkrenauto;
    private String cambiorenauto;
    private String codexclusion;
    private String motivoexclusion;
    private String observacion;
    private String codramo;
    private String fefecto;
    private String capital;
    private String prima;
    private String sobreprima;
    private String extraprima;
    private String deducible;
    private String stscobert;
    private String indcobertoblig;
    private String tasa;
    private String bbvasbr;
    private String othersbr;
    private String nosbr;
    private String clasecli;
    private String fecanul;
    private String frcinipol;
    private String tiposusc;
    private String tiposuscprod;
    private String codtipovia;
    private String idedirec;
    private String numero2;
    private String descripstatus;
    private String numsolicitud;
    private String indasegtitular;
    private String stsaseg;
    private String descexclusion;
    private String efecto;
    private String emision;
    private String cobertura;
    private String indicevariable;
    private String codcapital;
    private String fechaexc;
    private String stscobertura;
    private String participacion;
    private String recibo;
    private String tipoop;
    private String saldo;
    private String poliza;
    private String clave;
    private String responsabledepago;
    private String numdocumento;
    private String primabruta;
    private String numfinanc;
    private String retribucion;
    private String n;
    private String iva;
    private String reteiva;
    private String reteica;
    private String retefue;
    private String ordenpago;
    private String nrogiro;
    private String fechacobro;
    private String recpagouordpago;
    private String idefact;
    private String sldofactmoneda;
    private String nivel;
    private String codigo;
    private String clausula;
    private String anexo;
    private String ideclaucert;
    private String texto;
    private String siniestro;
    private String fnotificacion;
    private String fsiniestro;
    private String fmodificacion;
    private String causa;
    private String boton;
    private String servicio;
    private String codmodalidad;
    private String modalidad;
    private String nota;
    private String policynumberweb;
    private String option;
    private String customeridtype;
    private String renewaltype;
    private String customeridnumber;
    private String policystatus;
    private String paymentperiod;
    private String effectivestartdate;
    private String renewaldate;
    private String directdebitaccount;
    private String insuredvalue;
    private String managementoffice;
    private String insuranceproductcode;
    private String usermanagingpolicy;
    private String operationdate;
    private String premiumamount;
    private String altamiraaccountnumber;
    private String paymentreference;
    private String amountvalue;
    private String operationtime;
    private String userresponsible;
    private String description;
    private String customerpolicynumber;
    private List<String> sumaasegarray;
    private List<String> ocupacionarray;
    private List<String> periodicidadpagoarray;
    private List<String> planarray;
    private List<String> departamentoarray;
    private List<String> ciudadarray;
    private List<String> estratoarray;
    private List<String> anioconstruccionarray;
    private String idecobert;

    private String nombrereporte;
    private String nit;
    private String ctabarrido;
    private String rol;
    private String rcop;
    private String td;
    private String treca;
    private String estado;
    private String primas;
    private String fcobro;
    private String femision;
    private String agente;
    private String cmotivodesc;
    private String ccompan;
    private String tnombre;
    private String dni;
    private String descdni;
    private String tipofecha;
    private String certificadoinicial;
    private String certificadofinal;
    private String producto;
    private String oper;
    private String tproduc;
    private String cpoliza;
    private String tpoliza;
    private String bmodpag;
    private String cperson;
    private String tdninit;
    private String tapell1;
    private String tapell2;
    private String nombre1;
    private String bestado;
    private String cproduc;
    private String trotulo1;
    private String cmodali;
    private String nvermod;
    private String trotulo2;
    private String coficin;
    private String nmovimi;
    private String btipmov;
    private String femisio;
    private String cmotivo;
    private String crecibo;
    private String tusuari;
    private String ttermin;
    private String nhormov;
    private String nanexos;
    private String bmotivo;
    private String brepalt;
    private String tipogarantia;
    private String amparo;
    private String tipo;
    private String relva;
    private String retlva;
    private String retfue;
    private String ordpago;
    private String reccaja;
    private String garantia;
    private String importa;
    private String indacsel;
    private String indefront;
    private String indaplus;
    private List<ClientesDTO> cliente;
    private List<BeneficiariosDTO> beneficiario;
    private List<CertificadosDTO> certificado;
    private List<RetribucionesDTO> retribuciones;
    private List<AgentesDTO> agentes;
    private List<GarantiasDTO> garantias;
    private List<BienesDTO> bienes;
    private List<RecibosDTO> recibos;
    private List<AutorizacionesDTO> autorizaciones;
    private List<ClausulasDTO> clausulas;
    private String codval;
    private String tipoparam;
    private String codparam;
    private String descparam;
    private String refparam;
    private String codsql;
    private String totalregs;
    private String stsbien;
    private String additionalinfo;
    private String codocupac;
    private String fechaefecto;
    private String fechaemision;
    private String porcpago;
    private String descripcion;
    private String mediodepago;
    private String barridodecuenta;
    private String cancelacionsaldos;
    private String sector;
    private String idbien;
    private String tipocli;
    private List<AseguradoDTO> asegurado;
    private String idProcesoExec;
    private String apemat;
    private String descoaseguro;
    private String numpreformalizado;
    private String consecutivo;
    private String channelred;
    private String indcondig;
    private String codsucursal;
    private String numvaldoc;
    private String numcredpre;
    private String fecvalida;
    private String numoper;
    private String valaproxnueva;
    private String valaproxactual;
    private String idjob;
    private String nombrejob;
    private String calendario;
    private String horainicio;
    private String horafin;
    private String codinterf;
    private String codigoautoriza;
    private String cnextrun;
    private String descdia;
    private String simulacion;
    private String indprimultdiames;
    private String diasemana;
    private String descjob;
    private String indbackground;
    private String usrrunma;
    private String nombreusr;
    private String nombreusrma;
    private String cantlotes;
    private String descinterface;
    private String usrresp;
    private String tipojob;
    private String usrmodif;
    private String fechamodif;
    private String parametroadic;
    private String periocidad;
    private String descperiocidad;
    private String stsjob;
    private String cdescsts;
    private String fecharunma;
    private String fecsts;
    private String inddiahabil;
    private String fechacrea;
    private String tipointerfaz;
    private String accionjob;
    private String nombreuseresp;
    private String usrcrea;
    private String desctipo;
    private String bysegundo;
    private String byminuto;
    private String byhora;
    private String intervalo;
    private String indreproceso;
    private String observaciones;

    public Long getCantparent() {
        return cantparent;
    }

    public void setCantparent(Long cantparent) {
        this.cantparent = cantparent;
    }

    public String getImpuestoanual() {
        return impuestoanual;
    }

    public void setImpuestoanual(String impuestoanual) {
        this.impuestoanual = impuestoanual;
    }

    public String getTotalprimaanual() {
        return totalprimaanual;
    }

    public void setTotalprimaanual(String totalprimaanual) {
        this.totalprimaanual = totalprimaanual;
    }

    public String getTotalprimaperiodica() {
        return totalprimaperiodica;
    }

    public void setTotalprimaperiodica(String totalprimaperiodica) {
        this.totalprimaperiodica = totalprimaperiodica;
    }

    public String getNomcampodatos() {
        return nomcampodatos;
    }

    public void setNomcampodatos(String nomcampodatos) {
        this.nomcampodatos = nomcampodatos;
    }

    public String getIndvetoboletin() {
        return indvetoboletin;
    }

    public void setIndvetoboletin(String indvetoboletin) {
        this.indvetoboletin = indvetoboletin;
    }

    public String getCodrev() {
        return codrev;
    }

    public void setCodrev(String codrev) {
        this.codrev = codrev;
    }

    public String getIdestmultinivel() {
        return idestmultinivel;
    }

    public void setIdestmultinivel(String idestmultinivel) {
        this.idestmultinivel = idestmultinivel;
    }

    public String getDescripcanal() {
        return descripcanal;
    }

    public void setDescripcanal(String descripcanal) {
        this.descripcanal = descripcanal;
    }

    public String getDigitoIdentificacion() {
        return digitoIdentificacion;
    }

    public void setDigitoIdentificacion(String digitoIdentificacion) {
        this.digitoIdentificacion = digitoIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Long getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Long fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getPaisDeResidencia() {
        return paisDeResidencia;
    }

    public void setPaisDeResidencia(String paisDeResidencia) {
        this.paisDeResidencia = paisDeResidencia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCodigoGeograficoCiudad() {
        return codigoGeograficoCiudad;
    }

    public void setCodigoGeograficoCiudad(String codigoGeograficoCiudad) {
        this.codigoGeograficoCiudad = codigoGeograficoCiudad;
    }

    public String getCodigoGeograficoDepartamento() {
        return codigoGeograficoDepartamento;
    }

    public void setCodigoGeograficoDepartamento(String codigoGeograficoDepartamento) {
        this.codigoGeograficoDepartamento = codigoGeograficoDepartamento;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getDireccion3() {
        return direccion3;
    }

    public void setDireccion3(String direccion3) {
        this.direccion3 = direccion3;
    }

    public String getDireccion4() {
        return direccion4;
    }

    public void setDireccion4(String direccion4) {
        this.direccion4 = direccion4;
    }

    public String getDireccion5() {
        return direccion5;
    }

    public void setDireccion5(String direccion5) {
        this.direccion5 = direccion5;
    }

    public String getDireccion6() {
        return direccion6;
    }

    public void setDireccion6(String direccion6) {
        this.direccion6 = direccion6;
    }

    public String getDireccion7() {
        return direccion7;
    }

    public void setDireccion7(String direccion7) {
        this.direccion7 = direccion7;
    }

    public String getCiudadDeResidencia() {
        return ciudadDeResidencia;
    }

    public void setCiudadDeResidencia(String ciudadDeResidencia) {
        this.ciudadDeResidencia = ciudadDeResidencia;
    }

    public String getDepartamentoDeResidencia() {
        return departamentoDeResidencia;
    }

    public void setDepartamentoDeResidencia(String departamentoDeResidencia) {
        this.departamentoDeResidencia = departamentoDeResidencia;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getNumeroCuenta1() {
        return numeroCuenta1;
    }

    public void setNumeroCuenta1(String numeroCuenta1) {
        this.numeroCuenta1 = numeroCuenta1;
    }

    public String getNumeroCuenta2() {
        return numeroCuenta2;
    }

    public void setNumeroCuenta2(String numeroCuenta2) {
        this.numeroCuenta2 = numeroCuenta2;
    }

    public String getNumeroCuenta3() {
        return numeroCuenta3;
    }

    public void setNumeroCuenta3(String numeroCuenta3) {
        this.numeroCuenta3 = numeroCuenta3;
    }

    public String getNumeroCuenta4() {
        return numeroCuenta4;
    }

    public void setNumeroCuenta4(String numeroCuenta4) {
        this.numeroCuenta4 = numeroCuenta4;
    }

    public String getNumeroCuenta5() {
        return numeroCuenta5;
    }

    public void setNumeroCuenta5(String numeroCuenta5) {
        this.numeroCuenta5 = numeroCuenta5;
    }

    public String getNumeroCuenta6() {
        return numeroCuenta6;
    }

    public void setNumeroCuenta6(String numeroCuenta6) {
        this.numeroCuenta6 = numeroCuenta6;
    }

    public String getNumeroCuenta7() {
        return numeroCuenta7;
    }

    public void setNumeroCuenta7(String numeroCuenta7) {
        this.numeroCuenta7 = numeroCuenta7;
    }

    public String getTipoIdentificacionAsegurado() {
        return tipoIdentificacionAsegurado;
    }

    public void setTipoIdentificacionAsegurado(String tipoIdentificacionAsegurado) {
        this.tipoIdentificacionAsegurado = tipoIdentificacionAsegurado;
    }

    public String getMunicipioDeNacimiento() {
        return municipioDeNacimiento;
    }

    public void setMunicipioDeNacimiento(String municipioDeNacimiento) {
        this.municipioDeNacimiento = municipioDeNacimiento;
    }

    public String getDepartamentoDeNacimiento() {
        return departamentoDeNacimiento;
    }

    public void setDepartamentoDeNacimiento(String departamentoDeNacimiento) {
        this.departamentoDeNacimiento = departamentoDeNacimiento;
    }

    public String getPaisDeNacimiento() {
        return paisDeNacimiento;
    }

    public void setPaisDeNacimiento(String paisDeNacimiento) {
        this.paisDeNacimiento = paisDeNacimiento;
    }

    public String getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public String getCelularResidencia() {
        return celularResidencia;
    }

    public void setCelularResidencia(String celularResidencia) {
        this.celularResidencia = celularResidencia;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(String codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public String getIndependiente() {
        return independiente;
    }

    public void setIndependiente(String independiente) {
        this.independiente = independiente;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCelularEmpresa() {
        return celularEmpresa;
    }

    public void setCelularEmpresa(String celularEmpresa) {
        this.celularEmpresa = celularEmpresa;
    }

    public String getDescripcionOrigenFondos() {
        return descripcionOrigenFondos;
    }

    public void setDescripcionOrigenFondos(String descripcionOrigenFondos) {
        this.descripcionOrigenFondos = descripcionOrigenFondos;
    }

    public Long getIngresoMensual() {
        return ingresoMensual;
    }

    public void setIngresoMensual(Long ingresoMensual) {
        this.ingresoMensual = ingresoMensual;
    }

    public Long getGastoMensual() {
        return gastoMensual;
    }

    public void setGastoMensual(Long gastoMensual) {
        this.gastoMensual = gastoMensual;
    }

    public Long getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(Long otrosGastos) {
        this.otrosGastos = otrosGastos;
    }

    public Long getOtrosIngresos() {
        return otrosIngresos;
    }

    public void setOtrosIngresos(Long otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public String getDestinoOtrosIngresos() {
        return destinoOtrosIngresos;
    }

    public void setDestinoOtrosIngresos(String destinoOtrosIngresos) {
        this.destinoOtrosIngresos = destinoOtrosIngresos;
    }

    public Long getTotalActivos() {
        return totalActivos;
    }

    public void setTotalActivos(Long totalActivos) {
        this.totalActivos = totalActivos;
    }

    public Long getTotalPasivos() {
        return totalPasivos;
    }

    public void setTotalPasivos(Long totalPasivos) {
        this.totalPasivos = totalPasivos;
    }

    public String getTipoProductoMonedaExtranjera() {
        return tipoProductoMonedaExtranjera;
    }

    public void setTipoProductoMonedaExtranjera(String tipoProductoMonedaExtranjera) {
        this.tipoProductoMonedaExtranjera = tipoProductoMonedaExtranjera;
    }

    public String getProductoCuentaMonedaExtranjera() {
        return productoCuentaMonedaExtranjera;
    }

    public void setProductoCuentaMonedaExtranjera(String productoCuentaMonedaExtranjera) {
        this.productoCuentaMonedaExtranjera = productoCuentaMonedaExtranjera;
    }

    public String getEntidadMonedaExtranjera() {
        return entidadMonedaExtranjera;
    }

    public void setEntidadMonedaExtranjera(String entidadMonedaExtranjera) {
        this.entidadMonedaExtranjera = entidadMonedaExtranjera;
    }

    public Long getCantidadMonedaExtranjera() {
        return cantidadMonedaExtranjera;
    }

    public void setCantidadMonedaExtranjera(Long cantidadMonedaExtranjera) {
        this.cantidadMonedaExtranjera = cantidadMonedaExtranjera;
    }

    public String getCiudadMonedaExtranjera() {
        return ciudadMonedaExtranjera;
    }

    public void setCiudadMonedaExtranjera(String ciudadMonedaExtranjera) {
        this.ciudadMonedaExtranjera = ciudadMonedaExtranjera;
    }

    public String getPaisMonedaExtranjera() {
        return paisMonedaExtranjera;
    }

    public void setPaisMonedaExtranjera(String paisMonedaExtranjera) {
        this.paisMonedaExtranjera = paisMonedaExtranjera;
    }

    public String getMonedaExtranjera() {
        return monedaExtranjera;
    }

    public void setMonedaExtranjera(String monedaExtranjera) {
        this.monedaExtranjera = monedaExtranjera;
    }

    public String getFechaSarlaft() {
        return fechaSarlaft;
    }

    public void setFechaSarlaft(String fechaSarlaft) {
        this.fechaSarlaft = fechaSarlaft;
    }

    public String getImporteCliente() {
        return importeCliente;
    }

    public void setImporteCliente(String importeCliente) {
        this.importeCliente = importeCliente;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public String getServiciosPago() {
        return serviciosPago;
    }

    public void setServiciosPago(String serviciosPago) {
        this.serviciosPago = serviciosPago;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public String getExportacionCliente() {
        return exportacionCliente;
    }

    public void setExportacionCliente(String exportacionCliente) {
        this.exportacionCliente = exportacionCliente;
    }

    public String getCodigoOficina1() {
        return codigoOficina1;
    }

    public void setCodigoOficina1(String codigoOficina1) {
        this.codigoOficina1 = codigoOficina1;
    }

    public Date getFechaApertura1() {
        return fechaApertura1;
    }

    public void setFechaApertura1(Date fechaApertura1) {
        this.fechaApertura1 = fechaApertura1;
    }

    public String getPorProducto1() {
        return porProducto1;
    }

    public void setPorProducto1(String porProducto1) {
        this.porProducto1 = porProducto1;
    }

    public String getTipoCuenta1() {
        return tipoCuenta1;
    }

    public void setTipoCuenta1(String tipoCuenta1) {
        this.tipoCuenta1 = tipoCuenta1;
    }

    public String getCanalPrincipal1() {
        return canalPrincipal1;
    }

    public void setCanalPrincipal1(String canalPrincipal1) {
        this.canalPrincipal1 = canalPrincipal1;
    }

    public String getCodigoOficina2() {
        return codigoOficina2;
    }

    public void setCodigoOficina2(String codigoOficina2) {
        this.codigoOficina2 = codigoOficina2;
    }

    public Date getFechaApertura2() {
        return fechaApertura2;
    }

    public void setFechaApertura2(Date fechaApertura2) {
        this.fechaApertura2 = fechaApertura2;
    }

    public String getPorProducto2() {
        return porProducto2;
    }

    public void setPorProducto2(String porProducto2) {
        this.porProducto2 = porProducto2;
    }

    public String getTipoCuenta2() {
        return tipoCuenta2;
    }

    public void setTipoCuenta2(String tipoCuenta2) {
        this.tipoCuenta2 = tipoCuenta2;
    }

    public String getCanalPrincipal2() {
        return canalPrincipal2;
    }

    public void setCanalPrincipal2(String canalPrincipal2) {
        this.canalPrincipal2 = canalPrincipal2;
    }

    public String getCodigoOficina3() {
        return codigoOficina3;
    }

    public void setCodigoOficina3(String codigoOficina3) {
        this.codigoOficina3 = codigoOficina3;
    }

    public Date getFechaApertura3() {
        return fechaApertura3;
    }

    public void setFechaApertura3(Date fechaApertura3) {
        this.fechaApertura3 = fechaApertura3;
    }

    public String getPorProducto3() {
        return porProducto3;
    }

    public void setPorProducto3(String porProducto3) {
        this.porProducto3 = porProducto3;
    }

    public String getTipoCuenta3() {
        return tipoCuenta3;
    }

    public void setTipoCuenta3(String tipoCuenta3) {
        this.tipoCuenta3 = tipoCuenta3;
    }

    public String getCanalPrincipal3() {
        return canalPrincipal3;
    }

    public void setCanalPrincipal3(String canalPrincipal3) {
        this.canalPrincipal3 = canalPrincipal3;
    }

    public String getCodigoOficina4() {
        return codigoOficina4;
    }

    public void setCodigoOficina4(String codigoOficina4) {
        this.codigoOficina4 = codigoOficina4;
    }

    public Date getFechaApertura4() {
        return fechaApertura4;
    }

    public void setFechaApertura4(Date fechaApertura4) {
        this.fechaApertura4 = fechaApertura4;
    }

    public String getPorProducto4() {
        return porProducto4;
    }

    public void setPorProducto4(String porProducto4) {
        this.porProducto4 = porProducto4;
    }

    public String getTipoCuenta4() {
        return tipoCuenta4;
    }

    public void setTipoCuenta4(String tipoCuenta4) {
        this.tipoCuenta4 = tipoCuenta4;
    }

    public String getCanalPrincipal4() {
        return canalPrincipal4;
    }

    public void setCanalPrincipal4(String canalPrincipal4) {
        this.canalPrincipal4 = canalPrincipal4;
    }

    public String getCodigoOficina5() {
        return codigoOficina5;
    }

    public void setCodigoOficina5(String codigoOficina5) {
        this.codigoOficina5 = codigoOficina5;
    }

    public Date getFechaApertura5() {
        return fechaApertura5;
    }

    public void setFechaApertura5(Date fechaApertura5) {
        this.fechaApertura5 = fechaApertura5;
    }

    public String getPorProducto5() {
        return porProducto5;
    }

    public void setPorProducto5(String porProducto5) {
        this.porProducto5 = porProducto5;
    }

    public String getTipoCuenta5() {
        return tipoCuenta5;
    }

    public void setTipoCuenta5(String tipoCuenta5) {
        this.tipoCuenta5 = tipoCuenta5;
    }

    public String getCanalPrincipal5() {
        return canalPrincipal5;
    }

    public void setCanalPrincipal5(String canalPrincipal5) {
        this.canalPrincipal5 = canalPrincipal5;
    }

    public String getCodigoOficina6() {
        return codigoOficina6;
    }

    public void setCodigoOficina6(String codigoOficina6) {
        this.codigoOficina6 = codigoOficina6;
    }

    public Date getFechaApertura6() {
        return fechaApertura6;
    }

    public void setFechaApertura6(Date fechaApertura6) {
        this.fechaApertura6 = fechaApertura6;
    }

    public String getPorProducto6() {
        return porProducto6;
    }

    public void setPorProducto6(String porProducto6) {
        this.porProducto6 = porProducto6;
    }

    public String getTipoCuenta6() {
        return tipoCuenta6;
    }

    public void setTipoCuenta6(String tipoCuenta6) {
        this.tipoCuenta6 = tipoCuenta6;
    }

    public String getCanalPrincipal6() {
        return canalPrincipal6;
    }

    public void setCanalPrincipal6(String canalPrincipal6) {
        this.canalPrincipal6 = canalPrincipal6;
    }

    public String getCodigoOficina7() {
        return codigoOficina7;
    }

    public void setCodigoOficina7(String codigoOficina7) {
        this.codigoOficina7 = codigoOficina7;
    }

    public Date getFechaApertura7() {
        return fechaApertura7;
    }

    public void setFechaApertura7(Date fechaApertura7) {
        this.fechaApertura7 = fechaApertura7;
    }

    public String getPorProducto7() {
        return porProducto7;
    }

    public void setPorProducto7(String porProducto7) {
        this.porProducto7 = porProducto7;
    }

    public String getTipoCuenta7() {
        return tipoCuenta7;
    }

    public void setTipoCuenta7(String tipoCuenta7) {
        this.tipoCuenta7 = tipoCuenta7;
    }

    public String getCanalPrincipal7() {
        return canalPrincipal7;
    }

    public void setCanalPrincipal7(String canalPrincipal7) {
        this.canalPrincipal7 = canalPrincipal7;
    }

    public String getTextofinal() {
        return textofinal;
    }

    public void setTextofinal(String textofinal) {
        this.textofinal = textofinal;
    }

    public String getTextopreg() {
        return textopreg;
    }

    public void setTextopreg(String textopreg) {
        this.textopreg = textopreg;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public String getIndstop() {
        return indstop;
    }

    public void setIndstop(String indstop) {
        this.indstop = indstop;
    }

    public String getMsgsi() {
        return msgsi;
    }

    public void setMsgsi(String msgsi) {
        this.msgsi = msgsi;
    }

    public String getMsgno() {
        return msgno;
    }

    public void setMsgno(String msgno) {
        this.msgno = msgno;
    }

    public List<String> getCuentasdisponibles() {
        return cuentasdisponibles;
    }

    public void setCuentasdisponibles(List<String> cuentasdisponibles) {
        this.cuentasdisponibles = cuentasdisponibles;
    }

    public String getRenovacionautomatica() {
        return renovacionautomatica;
    }

    public void setRenovacionautomatica(String renovacionautomatica) {
        this.renovacionautomatica = renovacionautomatica;
    }

    public List<String> getMediospago() {
        return mediospago;
    }

    public void setMediospago(List<String> mediospago) {
        this.mediospago = mediospago;
    }

    public String getTipogenero() {
        return tipogenero;
    }

    public void setTipogenero(String tipogenero) {
        this.tipogenero = tipogenero;
    }

    public String getDescripciongenero() {
        return descripciongenero;
    }

    public void setDescripciongenero(String descripciongenero) {
        this.descripciongenero = descripciongenero;
    }

    public String getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(String idgenero) {
        this.idgenero = idgenero;
    }

    public String getValueCheckIndem() {
        return valueCheckIndem;
    }

    public void setValueCheckIndem(String valueCheckIndem) {
        this.valueCheckIndem = valueCheckIndem;
    }

    public String getValueCheckReclamo() {
        return valueCheckReclamo;
    }

    public void setValueCheckReclamo(String valueCheckReclamo) {
        this.valueCheckReclamo = valueCheckReclamo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getIdeaseg() {
        return ideaseg;
    }

    public void setIdeaseg(String ideaseg) {
        this.ideaseg = ideaseg;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getInfoadic() {
        return infoadic;
    }

    public void setInfoadic(String infoadic) {
        this.infoadic = infoadic;
    }

    public String getNumplaca() {
        return numplaca;
    }

    public void setNumplaca(String numplaca) {
        this.numplaca = numplaca;
    }

    public String getNumpisos() {
        return numpisos;
    }

    public void setNumpisos(String numpisos) {
        this.numpisos = numpisos;
    }

    public String getIndbis2() {
        return indbis2;
    }

    public void setIndbis2(String indbis2) {
        this.indbis2 = indbis2;
    }

    public String getLiteral2() {
        return literal2;
    }

    public void setLiteral2(String literal2) {
        this.literal2 = literal2;
    }

    public String getIndbis1() {
        return indbis1;
    }

    public void setIndbis1(String indbis1) {
        this.indbis1 = indbis1;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public String getTipopropiedad() {
        return tipopropiedad;
    }

    public void setTipopropiedad(String tipopropiedad) {
        this.tipopropiedad = tipopropiedad;
    }

    public String getTipoinmueble() {
        return tipoinmueble;
    }

    public void setTipoinmueble(String tipoinmueble) {
        this.tipoinmueble = tipoinmueble;
    }

    public String getTipovia() {
        return tipovia;
    }

    public void setTipovia(String tipovia) {
        this.tipovia = tipovia;
    }

    public String getTipoter() {
        return tipoter;
    }

    public void setTipoter(String tipoter) {
        this.tipoter = tipoter;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTipoestructura() {
        return tipoestructura;
    }

    public void setTipoestructura(String tipoestructura) {
        this.tipoestructura = tipoestructura;
    }

    public String getTiporiesgo() {
        return tiporiesgo;
    }

    public void setTiporiesgo(String tiporiesgo) {
        this.tiporiesgo = tiporiesgo;
    }

    public String getCodorientacion2() {
        return codorientacion2;
    }

    public void setCodorientacion2(String codorientacion2) {
        this.codorientacion2 = codorientacion2;
    }

    public String getCodorientacion() {
        return codorientacion;
    }

    public void setCodorientacion(String codorientacion) {
        this.codorientacion = codorientacion;
    }

    public String getDirvalinterseccion() {
        return dirvalinterseccion;
    }

    public void setDirvalinterseccion(String dirvalinterseccion) {
        this.dirvalinterseccion = dirvalinterseccion;
    }

    public String getCodcalle() {
        return codcalle;
    }

    public void setCodcalle(String codcalle) {
        this.codcalle = codcalle;
    }


    public String getCoddepartamento() {
        return coddepartamento;
    }

    public void setCoddepartamento(String coddepartamento) {
        this.coddepartamento = coddepartamento;
    }

    public String getCodgrpusr() {
        return codgrpusr;
    }

    public void setCodgrpusr(String codgrpusr) {
        this.codgrpusr = codgrpusr;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getCodusr() {
        return codusr;
    }

    public void setCodusr(String codusr) {
        this.codusr = codusr;
    }

    public String getCodplan() {
        return codplan;
    }

    public void setCodplan(String codplan) {
        this.codplan = codplan;
    }

    public String getRevplan() {
        return revplan;
    }

    public void setRevplan(String revplan) {
        this.revplan = revplan;
    }

    public String getCodcanal() {
        return codcanal;
    }

    public void setCodcanal(String codcanal) {
        this.codcanal = codcanal;
    }

    public String getCodsubcanal() {
        return codsubcanal;
    }

    public void setCodsubcanal(String codsubcanal) {
        this.codsubcanal = codsubcanal;
    }

    public String getCodlval() {
        return codlval;
    }

    public void setCodlval(String codlval) {
        this.codlval = codlval;
    }

    public String getTipolval() {
        return tipolval;
    }

    public void setTipolval(String tipolval) {
        this.tipolval = tipolval;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public Long getNumid() {
        return numid;
    }

    public void setNumid(Long numid) {
        this.numid = numid;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Long getIdepol() {
        return idepol;
    }

    public void setIdepol(Long idepol) {
        this.idepol = idepol;
    }

    public String getNumpol() {
        return numpol;
    }

    public void setNumpol(String numpol) {
        this.numpol = numpol;
    }

    public String getStspol() {
        return stspol;
    }

    public void setStspol(String stspol) {
        this.stspol = stspol;
    }

    public String getStssin() {
        return stssin;
    }

    public void setStssin(String stssin) {
        this.stssin = stssin;
    }

    public Long getSumaAseg() {
        return sumaAseg;
    }

    public void setSumaAseg(Long sumaAseg) {
        this.sumaAseg = sumaAseg;
    }

    public String getPeriodicidadPago() {
        return periodicidadPago;
    }

    public void setPeriodicidadPago(String periodicidadPago) {
        this.periodicidadPago = periodicidadPago;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAnioConstruccion() {
        return anioConstruccion;
    }

    public void setAnioConstruccion(String anioConstruccion) {
        this.anioConstruccion = anioConstruccion;
    }

    public String getNomter() {
        return nomter;
    }

    public void setNomter(String nomter) {
        this.nomter = nomter;
    }

    public String getApeter() {
        return apeter;
    }

    public void setApeter(String apeter) {
        this.apeter = apeter;
    }

    public String getDvid() {
        return dvid;
    }

    public void setDvid(String dvid) {
        this.dvid = dvid;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecnac() {
        return fecnac;
    }

    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getIndben() {
        return indben;
    }

    public void setIndben(String indben) {
        this.indben = indben;
    }

    public String getIndcobert() {
        return indcobert;
    }

    public void setIndcobert(String indcobert) {
        this.indcobert = indcobert;
    }

    public String getStscert() {
        return stscert;
    }

    public void setStscert(String stscert) {
        this.stscert = stscert;
    }

    public String getFecinivig() {
        return fecinivig;
    }

    public void setFecinivig(String fecinivig) {
        this.fecinivig = fecinivig;
    }

    public String getFecfinvig() {
        return fecfinvig;
    }

    public void setFecfinvig(String fecfinvig) {
        this.fecfinvig = fecfinvig;
    }

    public String getCodestado() {
        return codestado;
    }

    public void setCodestado(String codestado) {
        this.codestado = codestado;
    }

    public String getDescestado() {
        return descestado;
    }

    public void setDescestado(String descestado) {
        this.descestado = descestado;
    }

    public String getZonageografica() {
        return zonageografica;
    }

    public void setZonageografica(String zonageografica) {
        this.zonageografica = zonageografica;
    }

    public String getDescciudad() {
        return descciudad;
    }

    public void setDescciudad(String descciudad) {
        this.descciudad = descciudad;
    }

    public String getCodciudad() {
        return codciudad;
    }

    public void setCodciudad(String codciudad) {
        this.codciudad = codciudad;
    }

    public Long getEstrato() {
        return estrato;
    }

    public void setEstrato(Long estrato) {
        this.estrato = estrato;
    }

    public String getCodramocert() {
        return codramocert;
    }

    public void setCodramocert(String codramocert) {
        this.codramocert = codramocert;
    }

    public Long getNumcot() {
        return numcot;
    }

    public void setNumcot(Long numcot) {
        this.numcot = numcot;
    }

    public Long getIdecotiza() {
        return idecotiza;
    }

    public void setIdecotiza(Long idecotiza) {
        this.idecotiza = idecotiza;
    }

    public String getClasebien() {
        return clasebien;
    }

    public void setClasebien(String clasebien) {
        this.clasebien = clasebien;
    }

    public String getCodbien() {
        return codbien;
    }

    public void setCodbien(String codbien) {
        this.codbien = codbien;
    }

    public String getDescbien() {
        return descbien;
    }

    public void setDescbien(String descbien) {
        this.descbien = descbien;
    }

    public Long getMontobien() {
        return montobien;
    }

    public void setMontobien(Long montobien) {
        this.montobien = montobien;
    }

    public Long getIdeclau() {
        return ideclau;
    }

    public void setIdeclau(Long ideclau) {
        this.ideclau = ideclau;
    }

    public String getDescclau() {
        return descclau;
    }

    public void setDescclau(String descclau) {
        this.descclau = descclau;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getCodparentesco() {
        return codparentesco;
    }

    public void setCodparentesco(String codparentesco) {
        this.codparentesco = codparentesco;
    }

    public String getNomben() {
        return nomben;
    }

    public void setNomben(String nomben) {
        this.nomben = nomben;
    }

    public Long getNumben() {
        return numben;
    }

    public void setNumben(Long numben) {
        this.numben = numben;
    }

    public String getIdaseg() {
        return idaseg;
    }

    public void setIdaseg(String idaseg) {
        this.idaseg = idaseg;
    }

    public Long getPorcpart() {
        return porcpart;
    }

    public void setPorcpart(Long porcpart) {
        this.porcpart = porcpart;
    }

    public String getGrupopol() {
        return grupopol;
    }

    public void setGrupopol(String grupopol) {
        this.grupopol = grupopol;
    }

    public Long getNumcanttc() {
        return numcanttc;
    }

    public void setNumcanttc(Long numcanttc) {
        this.numcanttc = numcanttc;
    }

    public String getInduserasis() {
        return induserasis;
    }

    public void setInduserasis(String induserasis) {
        this.induserasis = induserasis;
    }

    public String getIndasegadic() {
        return indasegadic;
    }

    public void setIndasegadic(String indasegadic) {
        this.indasegadic = indasegadic;
    }

    public String getTipotomador() {
        return tipotomador;
    }

    public void setTipotomador(String tipotomador) {
        this.tipotomador = tipotomador;
    }

    public String getCodmunicipio() {
        return codmunicipio;
    }

    public void setCodmunicipio(String codmunicipio) {
        this.codmunicipio = codmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumordimp() {
        return numordimp;
    }

    public void setNumordimp(String numordimp) {
        this.numordimp = numordimp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodcobert() {
        return codcobert;
    }

    public void setCodcobert(String codcobert) {
        this.codcobert = codcobert;
    }

    public String getDesccobert() {
        return desccobert;
    }

    public void setDesccobert(String desccobert) {
        this.desccobert = desccobert;
    }

    public Long getPorcreca() {
        return porcreca;
    }

    public void setPorcreca(Long porcreca) {
        this.porcreca = porcreca;
    }

    public String getNomusr() {
        return nomusr;
    }

    public void setNomusr(String nomusr) {
        this.nomusr = nomusr;
    }

    public String getCodsuc() {
        return codsuc;
    }

    public void setCodsuc(String codsuc) {
        this.codsuc = codsuc;
    }

    public String getCodcia() {
        return codcia;
    }

    public void setCodcia(String codcia) {
        this.codcia = codcia;
    }

    public String getCodgrppol() {
        return codgrppol;
    }

    public void setCodgrppol(String codgrppol) {
        this.codgrppol = codgrppol;
    }

    public String getDesccanal() {
        return desccanal;
    }

    public void setDesccanal(String desccanal) {
        this.desccanal = desccanal;
    }

    public String getDescsubcanal() {
        return descsubcanal;
    }

    public void setDescsubcanal(String descsubcanal) {
        this.descsubcanal = descsubcanal;
    }

    public Long getCodofibanc() {
        return codofibanc;
    }

    public void setCodofibanc(Long codofibanc) {
        this.codofibanc = codofibanc;
    }

    public String getIdesmultinivel() {
        return idesmultinivel;
    }

    public void setIdesmultinivel(String idesmultinivel) {
        this.idesmultinivel = idesmultinivel;
    }

    public String getNomest() {
        return nomest;
    }

    public void setNomest(String nomest) {
        this.nomest = nomest;
    }

    public String getDesclval() {
        return desclval;
    }

    public void setDesclval(String desclval) {
        this.desclval = desclval;
    }

    public Long getNumcert() {
        return numcert;
    }

    public void setNumcert(Long numcert) {
        this.numcert = numcert;
    }

    public String getIndcargabdacsel() {
        return indcargabdacsel;
    }

    public void setIndcargabdacsel(String indcargabdacsel) {
        this.indcargabdacsel = indcargabdacsel;
    }

    public String getIndcontproc() {
        return indcontproc;
    }

    public void setIndcontproc(String indcontproc) {
        this.indcontproc = indcontproc;
    }

    public String getNomtabla() {
        return nomtabla;
    }

    public void setNomtabla(String nomtabla) {
        this.nomtabla = nomtabla;
    }

    public String getDesccampo() {
        return desccampo;
    }

    public void setDesccampo(String desccampo) {
        this.desccampo = desccampo;
    }

    public String getBlkweb() {
        return blkweb;
    }

    public void setBlkweb(String blkweb) {
        this.blkweb = blkweb;
    }

    public String getOrdenblkweb() {
        return ordenblkweb;
    }

    public void setOrdenblkweb(String ordenblkweb) {
        this.ordenblkweb = ordenblkweb;
    }

    public String getIndtipodato() {
        return indtipodato;
    }

    public void setIndtipodato(String indtipodato) {
        this.indtipodato = indtipodato;
    }

    public String getIsfixed() {
        return isfixed;
    }

    public void setIsfixed(String isfixed) {
        this.isfixed = isfixed;
    }

    public String getPanelkey() {
        return panelkey;
    }

    public void setPanelkey(String panelkey) {
        this.panelkey = panelkey;
    }

    public String getOrdensubpanel() {
        return ordensubpanel;
    }

    public void setOrdensubpanel(String ordensubpanel) {
        this.ordensubpanel = ordensubpanel;
    }

    public String getIseditable() {
        return iseditable;
    }

    public void setIseditable(String iseditable) {
        this.iseditable = iseditable;
    }

    public String getIsrequired() {
        return isrequired;
    }

    public void setIsrequired(String isrequired) {
        this.isrequired = isrequired;
    }

    public String getAfectacampo() {
        return afectacampo;
    }

    public void setAfectacampo(String afectacampo) {
        this.afectacampo = afectacampo;
    }

    public String getTypepresenter() {
        return typepresenter;
    }

    public void setTypepresenter(String typepresenter) {
        this.typepresenter = typepresenter;
    }

    public List<CardsDTO> getTarjetasaseguradas() {
        return tarjetasaseguradas;
    }

    public void setTarjetasaseguradas(List<CardsDTO> tarjetasaseguradas) {
        this.tarjetasaseguradas = tarjetasaseguradas;
    }

    public String getIdSessionExec() {
        return idSessionExec;
    }

    public void setIdSessionExec(String idSessionExec) {
        this.idSessionExec = idSessionExec;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescplanprod() {
        return descplanprod;
    }

    public void setDescplanprod(String descplanprod) {
        this.descplanprod = descplanprod;
    }

    public String getDescprod() {
        return descprod;
    }

    public void setDescprod(String descprod) {
        this.descprod = descprod;
    }

    public String getIndafinnity() {
        return indafinnity;
    }

    public void setIndafinnity(String indafinnity) {
        this.indafinnity = indafinnity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodofiges() {
        return codofiges;
    }

    public void setCodofiges(String codofiges) {
        this.codofiges = codofiges;
    }

    public String getCheckbenefley() {
        return checkbenefley;
    }

    public void setCheckbenefley(String checkbenefley) {
        this.checkbenefley = checkbenefley;
    }

    public String getCheckbenefoneroso() {
        return checkbenefoneroso;
    }

    public void setCheckbenefoneroso(String checkbenefoneroso) {
        this.checkbenefoneroso = checkbenefoneroso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodgenero() {
        return codgenero;
    }

    public void setCodgenero(String codgenero) {
        this.codgenero = codgenero;
    }

    public String getDescgenero() {
        return descgenero;
    }

    public void setDescgenero(String descgenero) {
        this.descgenero = descgenero;
    }

    public String getApuntamiento() {
        return apuntamiento;
    }

    public void setApuntamiento(String apuntamiento) {
        this.apuntamiento = apuntamiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHelptopicid() {
        return helptopicid;
    }

    public void setHelptopicid(String helptopicid) {
        this.helptopicid = helptopicid;
    }

    public String getApeben() {
        return apeben;
    }

    public void setApeben(String apeben) {
        this.apeben = apeben;
    }

    public String getGobalcondlaboral() {
        return gobalcondlaboral;
    }

    public void setGobalcondlaboral(String gobalcondlaboral) {
        this.gobalcondlaboral = gobalcondlaboral;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getCodarea() {
        return codarea;
    }

    public void setCodarea(String codarea) {
        this.codarea = codarea;
    }

    public String getStsprod() {
        return stsprod;
    }

    public void setStsprod(String stsprod) {
        this.stsprod = stsprod;
    }

    public String getIdpolcot() {
        return idpolcot;
    }

    public void setIdpolcot(String idpolcot) {
        this.idpolcot = idpolcot;
    }

    public String getNumctto() {
        return numctto;
    }

    public void setNumctto(String numctto) {
        this.numctto = numctto;
    }

    public String getStscot() {
        return stscot;
    }

    public void setStscot(String stscot) {
        this.stscot = stscot;
    }

    public String getFecsolic() {
        return fecsolic;
    }

    public void setFecsolic(String fecsolic) {
        this.fecsolic = fecsolic;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTerritorial() {
        return territorial;
    }

    public void setTerritorial(String territorial) {
        this.territorial = territorial;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getFecren() {
        return fecren;
    }

    public void setFecren(String fecren) {
        this.fecren = fecren;
    }

    public String getFecfin() {
        return fecfin;
    }

    public void setFecfin(String fecfin) {
        this.fecfin = fecfin;
    }

    public String getFecing() {
        return fecing;
    }

    public void setFecing(String fecing) {
        this.fecing = fecing;
    }

    public String getFormpago() {
        return formpago;
    }

    public void setFormpago(String formpago) {
        this.formpago = formpago;
    }

    public String getCnumcot() {
        return cnumcot;
    }

    public void setCnumcot(String cnumcot) {
        this.cnumcot = cnumcot;
    }

    public String getPnumcot() {
        return pnumcot;
    }

    public void setPnumcot(String pnumcot) {
        this.pnumcot = pnumcot;
    }

    public String getCiuedo() {
        return ciuedo;
    }

    public void setCiuedo(String ciuedo) {
        this.ciuedo = ciuedo;
    }

    public String getCuotacamp() {
        return cuotacamp;
    }

    public void setCuotacamp(String cuotacamp) {
        this.cuotacamp = cuotacamp;
    }

    public String getPorccamp() {
        return porccamp;
    }

    public void setPorccamp(String porccamp) {
        this.porccamp = porccamp;
    }

    public String getIdecamp() {
        return idecamp;
    }

    public void setIdecamp(String idecamp) {
        this.idecamp = idecamp;
    }

    public String getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(String utilidad) {
        this.utilidad = utilidad;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }


    public String getCodmoneda() {
        return codmoneda;
    }

    public void setCodmoneda(String codmoneda) {
        this.codmoneda = codmoneda;
    }

    public String getPrimaadic() {
        return primaadic;
    }

    public void setPrimaadic(String primaadic) {
        this.primaadic = primaadic;
    }

    public String getPrimagf() {
        return primagf;
    }

    public void setPrimagf(String primagf) {
        this.primagf = primagf;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodparent() {
        return codparent;
    }

    public void setCodparent(String codparent) {
        this.codparent = codparent;
    }

    public String getCodramoplan() {
        return codramoplan;
    }

    public void setCodramoplan(String codramoplan) {
        this.codramoplan = codramoplan;
    }

    public List<String> getEmailarray() {
        return emailarray;
    }

    public void setEmailarray(List<String> emailarray) {
        this.emailarray = emailarray;
    }

    public List<String> getDireccionresidenciarray() {
        return direccionresidenciarray;
    }

    public void setDireccionresidenciarray(List<String> direccionresidenciarray) {
        this.direccionresidenciarray = direccionresidenciarray;
    }

    public List<String> getDireccioncorrespondencia() {
        return direccioncorrespondencia;
    }

    public void setDireccioncorrespondencia(List<String> direccioncorrespondencia) {
        this.direccioncorrespondencia = direccioncorrespondencia;
    }

    public List<String> getTelefono3Array() {
        return telefono3Array;
    }

    public void setTelefono3Array(List<String> telefono3Array) {
        this.telefono3Array = telefono3Array;
    }

    public List<String> getTelefono2Array() {
        return telefono2Array;
    }

    public void setTelefono2Array(List<String> telefono2Array) {
        this.telefono2Array = telefono2Array;
    }

    public List<String> getTelefono1Array() {
        return telefono1Array;
    }

    public void setTelefono1Array(List<String> telefono1Array) {
        this.telefono1Array = telefono1Array;
    }

    public String getCodmediopago() {
        return codmediopago;
    }

    public void setCodmediopago(String codmediopago) {
        this.codmediopago = codmediopago;
    }

    public String getDescmediopago() {
        return descmediopago;
    }

    public void setDescmediopago(String descmediopago) {
        this.descmediopago = descmediopago;
    }

    public String getIndbenefone() {
        return indbenefone;
    }

    public void setIndbenefone(String indbenefone) {
        this.indbenefone = indbenefone;
    }

    public String getInduseasis() {
        return induseasis;
    }

    public void setInduseasis(String induseasis) {
        this.induseasis = induseasis;
    }

    public String getBenfone() {
        return benfone;
    }

    public void setBenfone(String benfone) {
        this.benfone = benfone;
    }

    public String getUseasis() {
        return useasis;
    }

    public void setUseasis(String useasis) {
        this.useasis = useasis;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechaini() {
        return fechaini;
    }

    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumcertini() {
        return numcertini;
    }

    public void setNumcertini(String numcertini) {
        this.numcertini = numcertini;
    }

    public String getNumcertfin() {
        return numcertfin;
    }

    public void setNumcertfin(String numcertfin) {
        this.numcertfin = numcertfin;
    }

    public String getCodformpago() {
        return codformpago;
    }

    public void setCodformpago(String codformpago) {
        this.codformpago = codformpago;
    }

    public String getCodofiemi() {
        return codofiemi;
    }

    public void setCodofiemi(String codofiemi) {
        this.codofiemi = codofiemi;
    }

    public String getFecinipol() {
        return fecinipol;
    }

    public void setFecinipol(String fecinipol) {
        this.fecinipol = fecinipol;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechfecoper() {
        return fechfecoper;
    }

    public void setFechfecoper(String fechfecoper) {
        this.fechfecoper = fechfecoper;
    }

    public String getCompnumpol() {
        return compnumpol;
    }

    public void setCompnumpol(String compnumpol) {
        this.compnumpol = compnumpol;
    }

    public String getFecoper() {
        return fecoper;
    }

    public void setFecoper(String fecoper) {
        this.fecoper = fecoper;
    }

    public String getCodgestor() {
        return codgestor;
    }

    public void setCodgestor(String codgestor) {
        this.codgestor = codgestor;
    }

    public String getCodofisusc() {
        return codofisusc;
    }

    public void setCodofisusc(String codofisusc) {
        this.codofisusc = codofisusc;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getFecexc() {
        return fecexc;
    }

    public void setFecexc(String fecexc) {
        this.fecexc = fecexc;
    }

    public String getFechainipol() {
        return fechainipol;
    }

    public void setFechainipol(String fechainipol) {
        this.fechainipol = fechainipol;
    }

    public String getFecfincotiza() {
        return fecfincotiza;
    }

    public void setFecfincotiza(String fecfincotiza) {
        this.fecfincotiza = fecfincotiza;
    }

    public String getNompercotiza() {
        return nompercotiza;
    }

    public void setNompercotiza(String nompercotiza) {
        this.nompercotiza = nompercotiza;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getCodperiodicpago() {
        return codperiodicpago;
    }

    public void setCodperiodicpago(String codperiodicpago) {
        this.codperiodicpago = codperiodicpago;
    }

    public String getCotestado() {
        return cotestado;
    }

    public void setCotestado(String cotestado) {
        this.cotestado = cotestado;
    }

    public String getIndrenauto() {
        return indrenauto;
    }

    public void setIndrenauto(String indrenauto) {
        this.indrenauto = indrenauto;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getCodsuplemento() {
        return codsuplemento;
    }

    public void setCodsuplemento(String codsuplemento) {
        this.codsuplemento = codsuplemento;
    }

    public String getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(String suplemento) {
        this.suplemento = suplemento;
    }

    public String getCodmotivo() {
        return codmotivo;
    }

    public void setCodmotivo(String codmotivo) {
        this.codmotivo = codmotivo;
    }

    public String getCodsubmotivo() {
        return codsubmotivo;
    }

    public void setCodsubmotivo(String codsubmotivo) {
        this.codsubmotivo = codsubmotivo;
    }

    public String getSubmotivo() {
        return submotivo;
    }

    public void setSubmotivo(String submotivo) {
        this.submotivo = submotivo;
    }

    public String getFechasuplemento() {
        return fechasuplemento;
    }

    public void setFechasuplemento(String fechasuplemento) {
        this.fechasuplemento = fechasuplemento;
    }

    public String getIncludemode() {
        return includemode;
    }

    public void setIncludemode(String includemode) {
        this.includemode = includemode;
    }

    public String getPrimaperi() {
        return primaperi;
    }

    public void setPrimaperi(String primaperi) {
        this.primaperi = primaperi;
    }

    public String getPrimaperidica() {
        return primaperidica;
    }

    public void setPrimaperidica(String primaperidica) {
        this.primaperidica = primaperidica;
    }

    public String getPrimaanual() {
        return primaanual;
    }

    public void setPrimaanual(String primaanual) {
        this.primaanual = primaanual;
    }

    public String getCoaseguro() {
        return coaseguro;
    }

    public void setCoaseguro(String coaseguro) {
        this.coaseguro = coaseguro;
    }

    public String getSumaasegurado() {
        return sumaasegurado;
    }

    public void setSumaasegurado(String sumaasegurado) {
        this.sumaasegurado = sumaasegurado;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getDireccioncorr() {
        return direccioncorr;
    }

    public void setDireccioncorr(String direccioncorr) {
        this.direccioncorr = direccioncorr;
    }

    public String getDireccionres() {
        return direccionres;
    }

    public void setDireccionres(String direccionres) {
        this.direccionres = direccionres;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCheckrenauto() {
        return checkrenauto;
    }

    public void setCheckrenauto(String checkrenauto) {
        this.checkrenauto = checkrenauto;
    }

    public String getCambiorenauto() {
        return cambiorenauto;
    }

    public void setCambiorenauto(String cambiorenauto) {
        this.cambiorenauto = cambiorenauto;
    }

    public String getCodexclusion() {
        return codexclusion;
    }

    public void setCodexclusion(String codexclusion) {
        this.codexclusion = codexclusion;
    }

    public String getMotivoexclusion() {
        return motivoexclusion;
    }

    public void setMotivoexclusion(String motivoexclusion) {
        this.motivoexclusion = motivoexclusion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCodramo() {
        return codramo;
    }

    public void setCodramo(String codramo) {
        this.codramo = codramo;
    }

    public String getFefecto() {
        return fefecto;
    }

    public void setFefecto(String fefecto) {
        this.fefecto = fefecto;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPrima() {
        return prima;
    }

    public void setPrima(String prima) {
        this.prima = prima;
    }

    public String getSobreprima() {
        return sobreprima;
    }

    public void setSobreprima(String sobreprima) {
        this.sobreprima = sobreprima;
    }

    public String getExtraprima() {
        return extraprima;
    }

    public void setExtraprima(String extraprima) {
        this.extraprima = extraprima;
    }

    public String getDeducible() {
        return deducible;
    }

    public void setDeducible(String deducible) {
        this.deducible = deducible;
    }

    public String getStscobert() {
        return stscobert;
    }

    public void setStscobert(String stscobert) {
        this.stscobert = stscobert;
    }

    public String getIndcobertoblig() {
        return indcobertoblig;
    }

    public void setIndcobertoblig(String indcobertoblig) {
        this.indcobertoblig = indcobertoblig;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public String getBbvasbr() {
        return bbvasbr;
    }

    public void setBbvasbr(String bbvasbr) {
        this.bbvasbr = bbvasbr;
    }

    public String getOthersbr() {
        return othersbr;
    }

    public void setOthersbr(String othersbr) {
        this.othersbr = othersbr;
    }

    public String getNosbr() {
        return nosbr;
    }

    public void setNosbr(String nosbr) {
        this.nosbr = nosbr;
    }

    public String getClasecli() {
        return clasecli;
    }

    public void setClasecli(String clasecli) {
        this.clasecli = clasecli;
    }

    public String getFecanul() {
        return fecanul;
    }

    public void setFecanul(String fecanul) {
        this.fecanul = fecanul;
    }

    public String getFrcinipol() {
        return frcinipol;
    }

    public void setFrcinipol(String frcinipol) {
        this.frcinipol = frcinipol;
    }

    public String getTiposusc() {
        return tiposusc;
    }

    public void setTiposusc(String tiposusc) {
        this.tiposusc = tiposusc;
    }

    public String getTiposuscprod() {
        return tiposuscprod;
    }

    public void setTiposuscprod(String tiposuscprod) {
        this.tiposuscprod = tiposuscprod;
    }

    public String getCodtipovia() {
        return codtipovia;
    }

    public void setCodtipovia(String codtipovia) {
        this.codtipovia = codtipovia;
    }

    public String getIdedirec() {
        return idedirec;
    }

    public void setIdedirec(String idedirec) {
        this.idedirec = idedirec;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getDescripstatus() {
        return descripstatus;
    }

    public void setDescripstatus(String descripstatus) {
        this.descripstatus = descripstatus;
    }

    public String getNumsolicitud() {
        return numsolicitud;
    }

    public void setNumsolicitud(String numsolicitud) {
        this.numsolicitud = numsolicitud;
    }

    public String getIndasegtitular() {
        return indasegtitular;
    }

    public void setIndasegtitular(String indasegtitular) {
        this.indasegtitular = indasegtitular;
    }

    public String getStsaseg() {
        return stsaseg;
    }

    public void setStsaseg(String stsaseg) {
        this.stsaseg = stsaseg;
    }

    public String getDescexclusion() {
        return descexclusion;
    }

    public void setDescexclusion(String descexclusion) {
        this.descexclusion = descexclusion;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getIndicevariable() {
        return indicevariable;
    }

    public void setIndicevariable(String indicevariable) {
        this.indicevariable = indicevariable;
    }

    public String getCodcapital() {
        return codcapital;
    }

    public void setCodcapital(String codcapital) {
        this.codcapital = codcapital;
    }

    public String getFechaexc() {
        return fechaexc;
    }

    public void setFechaexc(String fechaexc) {
        this.fechaexc = fechaexc;
    }

    public String getStscobertura() {
        return stscobertura;
    }

    public void setStscobertura(String stscobertura) {
        this.stscobertura = stscobertura;
    }

    public String getParticipacion() {
        return participacion;
    }

    public void setParticipacion(String participacion) {
        this.participacion = participacion;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getTipoop() {
        return tipoop;
    }

    public void setTipoop(String tipoop) {
        this.tipoop = tipoop;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getResponsabledepago() {
        return responsabledepago;
    }

    public void setResponsabledepago(String responsabledepago) {
        this.responsabledepago = responsabledepago;
    }

    public String getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(String numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getPrimabruta() {
        return primabruta;
    }

    public void setPrimabruta(String primabruta) {
        this.primabruta = primabruta;
    }

    public String getNumfinanc() {
        return numfinanc;
    }

    public void setNumfinanc(String numfinanc) {
        this.numfinanc = numfinanc;
    }

    public String getRetribucion() {
        return retribucion;
    }

    public void setRetribucion(String retribucion) {
        this.retribucion = retribucion;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getReteiva() {
        return reteiva;
    }

    public void setReteiva(String reteiva) {
        this.reteiva = reteiva;
    }

    public String getReteica() {
        return reteica;
    }

    public void setReteica(String reteica) {
        this.reteica = reteica;
    }

    public String getRetefue() {
        return retefue;
    }

    public void setRetefue(String retefue) {
        this.retefue = retefue;
    }

    public String getOrdenpago() {
        return ordenpago;
    }

    public void setOrdenpago(String ordenpago) {
        this.ordenpago = ordenpago;
    }

    public String getNrogiro() {
        return nrogiro;
    }

    public void setNrogiro(String nrogiro) {
        this.nrogiro = nrogiro;
    }

    public String getFechacobro() {
        return fechacobro;
    }

    public void setFechacobro(String fechacobro) {
        this.fechacobro = fechacobro;
    }

    public String getRecpagouordpago() {
        return recpagouordpago;
    }

    public void setRecpagouordpago(String recpagouordpago) {
        this.recpagouordpago = recpagouordpago;
    }

    public String getIdefact() {
        return idefact;
    }

    public void setIdefact(String idefact) {
        this.idefact = idefact;
    }

    public String getSldofactmoneda() {
        return sldofactmoneda;
    }

    public void setSldofactmoneda(String sldofactmoneda) {
        this.sldofactmoneda = sldofactmoneda;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClausula() {
        return clausula;
    }

    public void setClausula(String clausula) {
        this.clausula = clausula;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getIdeclaucert() {
        return ideclaucert;
    }

    public void setIdeclaucert(String ideclaucert) {
        this.ideclaucert = ideclaucert;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getSiniestro() {
        return siniestro;
    }

    public void setSiniestro(String siniestro) {
        this.siniestro = siniestro;
    }

    public String getFnotificacion() {
        return fnotificacion;
    }

    public void setFnotificacion(String fnotificacion) {
        this.fnotificacion = fnotificacion;
    }

    public String getFsiniestro() {
        return fsiniestro;
    }

    public void setFsiniestro(String fsiniestro) {
        this.fsiniestro = fsiniestro;
    }

    public String getFmodificacion() {
        return fmodificacion;
    }

    public void setFmodificacion(String fmodificacion) {
        this.fmodificacion = fmodificacion;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getCodmodalidad() {
        return codmodalidad;
    }

    public void setCodmodalidad(String codmodalidad) {
        this.codmodalidad = codmodalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getPolicynumberweb() {
        return policynumberweb;
    }

    public void setPolicynumberweb(String policynumberweb) {
        this.policynumberweb = policynumberweb;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getCustomeridtype() {
        return customeridtype;
    }

    public void setCustomeridtype(String customeridtype) {
        this.customeridtype = customeridtype;
    }

    public String getRenewaltype() {
        return renewaltype;
    }

    public void setRenewaltype(String renewaltype) {
        this.renewaltype = renewaltype;
    }

    public String getCustomeridnumber() {
        return customeridnumber;
    }

    public void setCustomeridnumber(String customeridnumber) {
        this.customeridnumber = customeridnumber;
    }

    public String getPolicystatus() {
        return policystatus;
    }

    public void setPolicystatus(String policystatus) {
        this.policystatus = policystatus;
    }

    public String getPaymentperiod() {
        return paymentperiod;
    }

    public void setPaymentperiod(String paymentperiod) {
        this.paymentperiod = paymentperiod;
    }

    public String getEffectivestartdate() {
        return effectivestartdate;
    }

    public void setEffectivestartdate(String effectivestartdate) {
        this.effectivestartdate = effectivestartdate;
    }

    public String getRenewaldate() {
        return renewaldate;
    }

    public void setRenewaldate(String renewaldate) {
        this.renewaldate = renewaldate;
    }

    public String getDirectdebitaccount() {
        return directdebitaccount;
    }

    public void setDirectdebitaccount(String directdebitaccount) {
        this.directdebitaccount = directdebitaccount;
    }

    public String getInsuredvalue() {
        return insuredvalue;
    }

    public void setInsuredvalue(String insuredvalue) {
        this.insuredvalue = insuredvalue;
    }

    public String getManagementoffice() {
        return managementoffice;
    }

    public void setManagementoffice(String managementoffice) {
        this.managementoffice = managementoffice;
    }

    public String getInsuranceproductcode() {
        return insuranceproductcode;
    }

    public void setInsuranceproductcode(String insuranceproductcode) {
        this.insuranceproductcode = insuranceproductcode;
    }

    public String getUsermanagingpolicy() {
        return usermanagingpolicy;
    }

    public void setUsermanagingpolicy(String usermanagingpolicy) {
        this.usermanagingpolicy = usermanagingpolicy;
    }

    public String getOperationdate() {
        return operationdate;
    }

    public void setOperationdate(String operationdate) {
        this.operationdate = operationdate;
    }

    public String getPremiumamount() {
        return premiumamount;
    }

    public void setPremiumamount(String premiumamount) {
        this.premiumamount = premiumamount;
    }

    public String getAltamiraaccountnumber() {
        return altamiraaccountnumber;
    }

    public void setAltamiraaccountnumber(String altamiraaccountnumber) {
        this.altamiraaccountnumber = altamiraaccountnumber;
    }

    public String getPaymentreference() {
        return paymentreference;
    }

    public void setPaymentreference(String paymentreference) {
        this.paymentreference = paymentreference;
    }

    public String getAmountvalue() {
        return amountvalue;
    }

    public void setAmountvalue(String amountvalue) {
        this.amountvalue = amountvalue;
    }

    public String getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(String operationtime) {
        this.operationtime = operationtime;
    }

    public String getUserresponsible() {
        return userresponsible;
    }

    public void setUserresponsible(String userresponsible) {
        this.userresponsible = userresponsible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerpolicynumber() {
        return customerpolicynumber;
    }

    public void setCustomerpolicynumber(String customerpolicynumber) {
        this.customerpolicynumber = customerpolicynumber;
    }

    public List<String> getOcupacionarray() {
        return ocupacionarray;
    }

    public void setOcupacionarray(List<String> ocupacionarray) {
        this.ocupacionarray = ocupacionarray;
    }

    public List<String> getPlanarray() {
        return planarray;
    }

    public void setPlanarray(List<String> planarray) {
        this.planarray = planarray;
    }

    public List<String> getDepartamentoarray() {
        return departamentoarray;
    }

    public void setDepartamentoarray(List<String> departamentoarray) {
        this.departamentoarray = departamentoarray;
    }

    public List<String> getCiudadarray() {
        return ciudadarray;
    }

    public void setCiudadarray(List<String> ciudadarray) {
        this.ciudadarray = ciudadarray;
    }

    public List<String> getEstratoarray() {
        return estratoarray;
    }

    public void setEstratoarray(List<String> estratoarray) {
        this.estratoarray = estratoarray;
    }

    public String getIdecobert() {
        return idecobert;
    }

    public void setIdecobert(String idecobert) {
        this.idecobert = idecobert;
    }

    public String getNombrereporte() {
        return nombrereporte;
    }

    public void setNombrereporte(String nombrereporte) {
        this.nombrereporte = nombrereporte;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCtabarrido() {
        return ctabarrido;
    }

    public void setCtabarrido(String ctabarrido) {
        this.ctabarrido = ctabarrido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRcop() {
        return rcop;
    }

    public void setRcop(String rcop) {
        this.rcop = rcop;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public String getTreca() {
        return treca;
    }

    public void setTreca(String treca) {
        this.treca = treca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrimas() {
        return primas;
    }

    public void setPrimas(String primas) {
        this.primas = primas;
    }

    public String getFcobro() {
        return fcobro;
    }

    public void setFcobro(String fcobro) {
        this.fcobro = fcobro;
    }

    public String getFemision() {
        return femision;
    }

    public void setFemision(String femision) {
        this.femision = femision;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getCmotivodesc() {
        return cmotivodesc;
    }

    public void setCmotivodesc(String cmotivodesc) {
        this.cmotivodesc = cmotivodesc;
    }

    public String getCcompan() {
        return ccompan;
    }

    public void setCcompan(String ccompan) {
        this.ccompan = ccompan;
    }

    public String getTnombre() {
        return tnombre;
    }

    public void setTnombre(String tnombre) {
        this.tnombre = tnombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDescdni() {
        return descdni;
    }

    public void setDescdni(String descdni) {
        this.descdni = descdni;
    }

    public String getTipofecha() {
        return tipofecha;
    }

    public void setTipofecha(String tipofecha) {
        this.tipofecha = tipofecha;
    }

    public String getCertificadoinicial() {
        return certificadoinicial;
    }

    public void setCertificadoinicial(String certificadoinicial) {
        this.certificadoinicial = certificadoinicial;
    }

    public String getCertificadofinal() {
        return certificadofinal;
    }

    public void setCertificadofinal(String certificadofinal) {
        this.certificadofinal = certificadofinal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getTproduc() {
        return tproduc;
    }

    public void setTproduc(String tproduc) {
        this.tproduc = tproduc;
    }

    public String getCpoliza() {
        return cpoliza;
    }

    public void setCpoliza(String cpoliza) {
        this.cpoliza = cpoliza;
    }

    public String getTpoliza() {
        return tpoliza;
    }

    public void setTpoliza(String tpoliza) {
        this.tpoliza = tpoliza;
    }

    public String getBmodpag() {
        return bmodpag;
    }

    public void setBmodpag(String bmodpag) {
        this.bmodpag = bmodpag;
    }

    public String getCperson() {
        return cperson;
    }

    public void setCperson(String cperson) {
        this.cperson = cperson;
    }

    public String getTdninit() {
        return tdninit;
    }

    public void setTdninit(String tdninit) {
        this.tdninit = tdninit;
    }

    public String getTapell1() {
        return tapell1;
    }

    public void setTapell1(String tapell1) {
        this.tapell1 = tapell1;
    }

    public String getTapell2() {
        return tapell2;
    }

    public void setTapell2(String tapell2) {
        this.tapell2 = tapell2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getBestado() {
        return bestado;
    }

    public void setBestado(String bestado) {
        this.bestado = bestado;
    }

    public String getCproduc() {
        return cproduc;
    }

    public void setCproduc(String cproduc) {
        this.cproduc = cproduc;
    }

    public String getTrotulo1() {
        return trotulo1;
    }

    public void setTrotulo1(String trotulo1) {
        this.trotulo1 = trotulo1;
    }

    public String getCmodali() {
        return cmodali;
    }

    public void setCmodali(String cmodali) {
        this.cmodali = cmodali;
    }

    public String getNvermod() {
        return nvermod;
    }

    public void setNvermod(String nvermod) {
        this.nvermod = nvermod;
    }

    public String getTrotulo2() {
        return trotulo2;
    }

    public void setTrotulo2(String trotulo2) {
        this.trotulo2 = trotulo2;
    }

    public String getCoficin() {
        return coficin;
    }

    public void setCoficin(String coficin) {
        this.coficin = coficin;
    }

    public String getNmovimi() {
        return nmovimi;
    }

    public void setNmovimi(String nmovimi) {
        this.nmovimi = nmovimi;
    }

    public String getBtipmov() {
        return btipmov;
    }

    public void setBtipmov(String btipmov) {
        this.btipmov = btipmov;
    }

    public String getFemisio() {
        return femisio;
    }

    public void setFemisio(String femisio) {
        this.femisio = femisio;
    }

    public String getCmotivo() {
        return cmotivo;
    }

    public void setCmotivo(String cmotivo) {
        this.cmotivo = cmotivo;
    }

    public String getCrecibo() {
        return crecibo;
    }

    public void setCrecibo(String crecibo) {
        this.crecibo = crecibo;
    }

    public String getTusuari() {
        return tusuari;
    }

    public void setTusuari(String tusuari) {
        this.tusuari = tusuari;
    }

    public String getTtermin() {
        return ttermin;
    }

    public void setTtermin(String ttermin) {
        this.ttermin = ttermin;
    }

    public String getNhormov() {
        return nhormov;
    }

    public void setNhormov(String nhormov) {
        this.nhormov = nhormov;
    }

    public String getNanexos() {
        return nanexos;
    }

    public void setNanexos(String nanexos) {
        this.nanexos = nanexos;
    }

    public String getBmotivo() {
        return bmotivo;
    }

    public void setBmotivo(String bmotivo) {
        this.bmotivo = bmotivo;
    }

    public String getBrepalt() {
        return brepalt;
    }

    public void setBrepalt(String brepalt) {
        this.brepalt = brepalt;
    }

    public String getTipogarantia() {
        return tipogarantia;
    }

    public void setTipogarantia(String tipogarantia) {
        this.tipogarantia = tipogarantia;
    }

    public String getAmparo() {
        return amparo;
    }

    public void setAmparo(String amparo) {
        this.amparo = amparo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRelva() {
        return relva;
    }

    public void setRelva(String relva) {
        this.relva = relva;
    }

    public String getRetlva() {
        return retlva;
    }

    public void setRetlva(String retlva) {
        this.retlva = retlva;
    }

    public String getRetfue() {
        return retfue;
    }

    public void setRetfue(String retfue) {
        this.retfue = retfue;
    }

    public String getOrdpago() {
        return ordpago;
    }

    public void setOrdpago(String ordpago) {
        this.ordpago = ordpago;
    }

    public String getReccaja() {
        return reccaja;
    }

    public void setReccaja(String reccaja) {
        this.reccaja = reccaja;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getImporta() {
        return importa;
    }

    public void setImporta(String importa) {
        this.importa = importa;
    }

    public String getIndacsel() {
        return indacsel;
    }

    public void setIndacsel(String indacsel) {
        this.indacsel = indacsel;
    }

    public String getIndefront() {
        return indefront;
    }

    public void setIndefront(String indefront) {
        this.indefront = indefront;
    }

    public String getIndaplus() {
        return indaplus;
    }

    public void setIndaplus(String indaplus) {
        this.indaplus = indaplus;
    }

    public List<ClientesDTO> getCliente() {
        return cliente;
    }

    public void setCliente(List<ClientesDTO> cliente) {
        this.cliente = cliente;
    }

    public List<BeneficiariosDTO> getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(List<BeneficiariosDTO> beneficiario) {
        this.beneficiario = beneficiario;
    }

    public List<CertificadosDTO> getCertificado() {
        return certificado;
    }

    public void setCertificado(List<CertificadosDTO> certificado) {
        this.certificado = certificado;
    }

    public List<RetribucionesDTO> getRetribuciones() {
        return retribuciones;
    }

    public void setRetribuciones(List<RetribucionesDTO> retribuciones) {
        this.retribuciones = retribuciones;
    }

    public List<AgentesDTO> getAgentes() {
        return agentes;
    }

    public void setAgentes(List<AgentesDTO> agentes) {
        this.agentes = agentes;
    }

    public List<GarantiasDTO> getGarantias() {
        return garantias;
    }

    public void setGarantias(List<GarantiasDTO> garantias) {
        this.garantias = garantias;
    }

    public List<BienesDTO> getBienes() {
        return bienes;
    }

    public void setBienes(List<BienesDTO> bienes) {
        this.bienes = bienes;
    }

    public List<RecibosDTO> getRecibos() {
        return recibos;
    }

    public void setRecibos(List<RecibosDTO> recibos) {
        this.recibos = recibos;
    }

    public List<AutorizacionesDTO> getAutorizaciones() {
        return autorizaciones;
    }

    public void setAutorizaciones(List<AutorizacionesDTO> autorizaciones) {
        this.autorizaciones = autorizaciones;
    }

    public List<ClausulasDTO> getClausulas() {
        return clausulas;
    }

    public void setClausulas(List<ClausulasDTO> clausulas) {
        this.clausulas = clausulas;
    }

    public String getCodval() {
        return codval;
    }

    public void setCodval(String codval) {
        this.codval = codval;
    }

    public String getTipoparam() {
        return tipoparam;
    }

    public void setTipoparam(String tipoparam) {
        this.tipoparam = tipoparam;
    }

    public String getCodparam() {
        return codparam;
    }

    public void setCodparam(String codparam) {
        this.codparam = codparam;
    }

    public String getDescparam() {
        return descparam;
    }

    public void setDescparam(String descparam) {
        this.descparam = descparam;
    }

    public String getRefparam() {
        return refparam;
    }

    public void setRefparam(String refparam) {
        this.refparam = refparam;
    }

    public String getCodsql() {
        return codsql;
    }

    public void setCodsql(String codsql) {
        this.codsql = codsql;
    }

    public String getTotalregs() {
        return totalregs;
    }

    public void setTotalregs(String totalregs) {
        this.totalregs = totalregs;
    }

    public String getStsbien() {
        return stsbien;
    }

    public void setStsbien(String stsbien) {
        this.stsbien = stsbien;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

    public String getCodocupac() {
        return codocupac;
    }

    public void setCodocupac(String codocupac) {
        this.codocupac = codocupac;
    }

    public String getFechaefecto() {
        return fechaefecto;
    }

    public void setFechaefecto(String fechaefecto) {
        this.fechaefecto = fechaefecto;
    }

    public String getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(String fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getPorcpago() {
        return porcpago;
    }

    public void setPorcpago(String porcpago) {
        this.porcpago = porcpago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMediodepago() {
        return mediodepago;
    }

    public void setMediodepago(String mediodepago) {
        this.mediodepago = mediodepago;
    }

    public String getBarridodecuenta() {
        return barridodecuenta;
    }

    public void setBarridodecuenta(String barridodecuenta) {
        this.barridodecuenta = barridodecuenta;
    }

    public String getCancelacionsaldos() {
        return cancelacionsaldos;
    }

    public void setCancelacionsaldos(String cancelacionsaldos) {
        this.cancelacionsaldos = cancelacionsaldos;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIdbien() {
        return idbien;
    }

    public void setIdbien(String idbien) {
        this.idbien = idbien;
    }

    public String getTipocli() {
        return tipocli;
    }

    public void setTipocli(String tipocli) {
        this.tipocli = tipocli;
    }

    public List<String> getSumaasegarray() {
        return sumaasegarray;
    }

    public void setSumaasegarray(List<String> sumaasegarray) {
        this.sumaasegarray = sumaasegarray;
    }

    public List<String> getPeriodicidadpagoarray() {
        return periodicidadpagoarray;
    }

    public void setPeriodicidadpagoarray(List<String> periodicidadpagoarray) {
        this.periodicidadpagoarray = periodicidadpagoarray;
    }

    public List<String> getAnioconstruccionarray() {
        return anioconstruccionarray;
    }

    public void setAnioconstruccionarray(List<String> anioconstruccionarray) {
        this.anioconstruccionarray = anioconstruccionarray;
    }

    public List<AseguradoDTO> getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(List<AseguradoDTO> asegurado) {
        this.asegurado = asegurado;
    }

    public String getIdProcesoExec() {
        return idProcesoExec;
    }

    public void setIdProcesoExec(String idProcesoExec) {
        this.idProcesoExec = idProcesoExec;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getDescoaseguro() {
        return descoaseguro;
    }

    public void setDescoaseguro(String descoaseguro) {
        this.descoaseguro = descoaseguro;
    }

    public String getNumpreformalizado() {
        return numpreformalizado;
    }

    public void setNumpreformalizado(String numpreformalizado) {
        this.numpreformalizado = numpreformalizado;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getChannelred() {
        return channelred;
    }

    public void setChannelred(String channelred) {
        this.channelred = channelred;
    }

    public String getIndcondig() {
        return indcondig;
    }

    public void setIndcondig(String indcondig) {
        this.indcondig = indcondig;
    }

    public String getCodsucursal() {
        return codsucursal;
    }

    public void setCodsucursal(String codsucursal) {
        this.codsucursal = codsucursal;
    }

    public String getNumvaldoc() {
        return numvaldoc;
    }

    public void setNumvaldoc(String numvaldoc) {
        this.numvaldoc = numvaldoc;
    }

    public String getNumcredpre() {
        return numcredpre;
    }

    public void setNumcredpre(String numcredpre) {
        this.numcredpre = numcredpre;
    }

    public String getFecvalida() {
        return fecvalida;
    }

    public void setFecvalida(String fecvalida) {
        this.fecvalida = fecvalida;
    }

    public String getNumoper() {
        return numoper;
    }

    public void setNumoper(String numoper) {
        this.numoper = numoper;
    }

    public String getValaproxnueva() {
        return valaproxnueva;
    }

    public void setValaproxnueva(String valaproxnueva) {
        this.valaproxnueva = valaproxnueva;
    }

    public String getValaproxactual() {
        return valaproxactual;
    }

    public void setValaproxactual(String valaproxactual) {
        this.valaproxactual = valaproxactual;
    }

    public String getIdjob() {
        return idjob;
    }

    public void setIdjob(String idjob) {
        this.idjob = idjob;
    }

    public String getNombrejob() {
        return nombrejob;
    }

    public void setNombrejob(String nombrejob) {
        this.nombrejob = nombrejob;
    }

    public String getCalendario() {
        return calendario;
    }

    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String getCodinterf() {
        return codinterf;
    }

    public void setCodinterf(String codinterf) {
        this.codinterf = codinterf;
    }

    public String getCodigoautoriza() {
        return codigoautoriza;
    }

    public void setCodigoautoriza(String codigoautoriza) {
        this.codigoautoriza = codigoautoriza;
    }

    public String getCnextrun() {
        return cnextrun;
    }

    public void setCnextrun(String cnextrun) {
        this.cnextrun = cnextrun;
    }

    public String getDescdia() {
        return descdia;
    }

    public void setDescdia(String descdia) {
        this.descdia = descdia;
    }

    public String getSimulacion() {
        return simulacion;
    }

    public void setSimulacion(String simulacion) {
        this.simulacion = simulacion;
    }

    public String getIndprimultdiames() {
        return indprimultdiames;
    }

    public void setIndprimultdiames(String indprimultdiames) {
        this.indprimultdiames = indprimultdiames;
    }

    public String getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(String diasemana) {
        this.diasemana = diasemana;
    }

    public String getDescjob() {
        return descjob;
    }

    public void setDescjob(String descjob) {
        this.descjob = descjob;
    }

    public String getIndbackground() {
        return indbackground;
    }

    public void setIndbackground(String indbackground) {
        this.indbackground = indbackground;
    }

    public String getUsrrunma() {
        return usrrunma;
    }

    public void setUsrrunma(String usrrunma) {
        this.usrrunma = usrrunma;
    }

    public String getNombreusr() {
        return nombreusr;
    }

    public void setNombreusr(String nombreusr) {
        this.nombreusr = nombreusr;
    }

    public String getNombreusrma() {
        return nombreusrma;
    }

    public void setNombreusrma(String nombreusrma) {
        this.nombreusrma = nombreusrma;
    }

    public String getCantlotes() {
        return cantlotes;
    }

    public void setCantlotes(String cantlotes) {
        this.cantlotes = cantlotes;
    }

    public String getDescinterface() {
        return descinterface;
    }

    public void setDescinterface(String descinterface) {
        this.descinterface = descinterface;
    }

    public String getUsrresp() {
        return usrresp;
    }

    public void setUsrresp(String usrresp) {
        this.usrresp = usrresp;
    }

    public String getTipojob() {
        return tipojob;
    }

    public void setTipojob(String tipojob) {
        this.tipojob = tipojob;
    }

    public String getUsrmodif() {
        return usrmodif;
    }

    public void setUsrmodif(String usrmodif) {
        this.usrmodif = usrmodif;
    }

    public String getFechamodif() {
        return fechamodif;
    }

    public void setFechamodif(String fechamodif) {
        this.fechamodif = fechamodif;
    }

    public String getParametroadic() {
        return parametroadic;
    }

    public void setParametroadic(String parametroadic) {
        this.parametroadic = parametroadic;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public String getDescperiocidad() {
        return descperiocidad;
    }

    public void setDescperiocidad(String descperiocidad) {
        this.descperiocidad = descperiocidad;
    }

    public String getStsjob() {
        return stsjob;
    }

    public void setStsjob(String stsjob) {
        this.stsjob = stsjob;
    }

    public String getCdescsts() {
        return cdescsts;
    }

    public void setCdescsts(String cdescsts) {
        this.cdescsts = cdescsts;
    }

    public String getFecharunma() {
        return fecharunma;
    }

    public void setFecharunma(String fecharunma) {
        this.fecharunma = fecharunma;
    }

    public String getFecsts() {
        return fecsts;
    }

    public void setFecsts(String fecsts) {
        this.fecsts = fecsts;
    }

    public String getInddiahabil() {
        return inddiahabil;
    }

    public void setInddiahabil(String inddiahabil) {
        this.inddiahabil = inddiahabil;
    }

    public String getFechacrea() {
        return fechacrea;
    }

    public void setFechacrea(String fechacrea) {
        this.fechacrea = fechacrea;
    }

    public String getTipointerfaz() {
        return tipointerfaz;
    }

    public void setTipointerfaz(String tipointerfaz) {
        this.tipointerfaz = tipointerfaz;
    }

    public String getAccionjob() {
        return accionjob;
    }

    public void setAccionjob(String accionjob) {
        this.accionjob = accionjob;
    }

    public String getNombreuseresp() {
        return nombreuseresp;
    }

    public void setNombreuseresp(String nombreuseresp) {
        this.nombreuseresp = nombreuseresp;
    }

    public String getUsrcrea() {
        return usrcrea;
    }

    public void setUsrcrea(String usrcrea) {
        this.usrcrea = usrcrea;
    }

    public String getDesctipo() {
        return desctipo;
    }

    public void setDesctipo(String desctipo) {
        this.desctipo = desctipo;
    }

    public String getBysegundo() {
        return bysegundo;
    }

    public void setBysegundo(String bysegundo) {
        this.bysegundo = bysegundo;
    }

    public String getByminuto() {
        return byminuto;
    }

    public void setByminuto(String byminuto) {
        this.byminuto = byminuto;
    }

    public String getByhora() {
        return byhora;
    }

    public void setByhora(String byhora) {
        this.byhora = byhora;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public String getIndreproceso() {
        return indreproceso;
    }

    public void setIndreproceso(String indreproceso) {
        this.indreproceso = indreproceso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PolicyDTO policyDTO = (PolicyDTO) o;
        return Objects.equals(cantparent, policyDTO.cantparent) && Objects.equals(impuestoanual, policyDTO.impuestoanual) && Objects.equals(totalprimaanual, policyDTO.totalprimaanual) && Objects.equals(totalprimaperiodica, policyDTO.totalprimaperiodica) && Objects.equals(nomcampodatos, policyDTO.nomcampodatos) && Objects.equals(indvetoboletin, policyDTO.indvetoboletin) && Objects.equals(codrev, policyDTO.codrev) && Objects.equals(idestmultinivel, policyDTO.idestmultinivel) && Objects.equals(descripcanal, policyDTO.descripcanal) && Objects.equals(digitoIdentificacion, policyDTO.digitoIdentificacion) && Objects.equals(primerNombre, policyDTO.primerNombre) && Objects.equals(segundoNombre, policyDTO.segundoNombre) && Objects.equals(primerApellido, policyDTO.primerApellido) && Objects.equals(segundoApellido, policyDTO.segundoApellido) && Objects.equals(fechaDeNacimiento, policyDTO.fechaDeNacimiento) && Objects.equals(paisDeResidencia, policyDTO.paisDeResidencia) && Objects.equals(sexo, policyDTO.sexo) && Objects.equals(edad, policyDTO.edad) && Objects.equals(codigoGeograficoCiudad, policyDTO.codigoGeograficoCiudad) && Objects.equals(codigoGeograficoDepartamento, policyDTO.codigoGeograficoDepartamento) && Objects.equals(direccionResidencia, policyDTO.direccionResidencia) && Objects.equals(direccion2, policyDTO.direccion2) && Objects.equals(direccion3, policyDTO.direccion3) && Objects.equals(direccion4, policyDTO.direccion4) && Objects.equals(direccion5, policyDTO.direccion5) && Objects.equals(direccion6, policyDTO.direccion6) && Objects.equals(direccion7, policyDTO.direccion7) && Objects.equals(ciudadDeResidencia, policyDTO.ciudadDeResidencia) && Objects.equals(departamentoDeResidencia, policyDTO.departamentoDeResidencia) && Objects.equals(telefono1, policyDTO.telefono1) && Objects.equals(telefono2, policyDTO.telefono2) && Objects.equals(telefono3, policyDTO.telefono3) && Objects.equals(profesion, policyDTO.profesion) && Objects.equals(actividadEconomica, policyDTO.actividadEconomica) && Objects.equals(numeroCuenta1, policyDTO.numeroCuenta1) && Objects.equals(numeroCuenta2, policyDTO.numeroCuenta2) && Objects.equals(numeroCuenta3, policyDTO.numeroCuenta3) && Objects.equals(numeroCuenta4, policyDTO.numeroCuenta4) && Objects.equals(numeroCuenta5, policyDTO.numeroCuenta5) && Objects.equals(numeroCuenta6, policyDTO.numeroCuenta6) && Objects.equals(numeroCuenta7, policyDTO.numeroCuenta7) && Objects.equals(tipoIdentificacionAsegurado, policyDTO.tipoIdentificacionAsegurado) && Objects.equals(municipioDeNacimiento, policyDTO.municipioDeNacimiento) && Objects.equals(departamentoDeNacimiento, policyDTO.departamentoDeNacimiento) && Objects.equals(paisDeNacimiento, policyDTO.paisDeNacimiento) && Objects.equals(telefonoResidencia, policyDTO.telefonoResidencia) && Objects.equals(celularResidencia, policyDTO.celularResidencia) && Objects.equals(ocupacion, policyDTO.ocupacion) && Objects.equals(codigoProfesion, policyDTO.codigoProfesion) && Objects.equals(independiente, policyDTO.independiente) && Objects.equals(posicion, policyDTO.posicion) && Objects.equals(nombreEmpresa, policyDTO.nombreEmpresa) && Objects.equals(direccionEmpresa, policyDTO.direccionEmpresa) && Objects.equals(telefonoEmpresa, policyDTO.telefonoEmpresa) && Objects.equals(celularEmpresa, policyDTO.celularEmpresa) && Objects.equals(descripcionOrigenFondos, policyDTO.descripcionOrigenFondos) && Objects.equals(ingresoMensual, policyDTO.ingresoMensual) && Objects.equals(gastoMensual, policyDTO.gastoMensual) && Objects.equals(otrosGastos, policyDTO.otrosGastos) && Objects.equals(otrosIngresos, policyDTO.otrosIngresos) && Objects.equals(destinoOtrosIngresos, policyDTO.destinoOtrosIngresos) && Objects.equals(totalActivos, policyDTO.totalActivos) && Objects.equals(totalPasivos, policyDTO.totalPasivos) && Objects.equals(tipoProductoMonedaExtranjera, policyDTO.tipoProductoMonedaExtranjera) && Objects.equals(productoCuentaMonedaExtranjera, policyDTO.productoCuentaMonedaExtranjera) && Objects.equals(entidadMonedaExtranjera, policyDTO.entidadMonedaExtranjera) && Objects.equals(cantidadMonedaExtranjera, policyDTO.cantidadMonedaExtranjera) && Objects.equals(ciudadMonedaExtranjera, policyDTO.ciudadMonedaExtranjera) && Objects.equals(paisMonedaExtranjera, policyDTO.paisMonedaExtranjera) && Objects.equals(monedaExtranjera, policyDTO.monedaExtranjera) && Objects.equals(fechaSarlaft, policyDTO.fechaSarlaft) && Objects.equals(importeCliente, policyDTO.importeCliente) && Objects.equals(inversion, policyDTO.inversion) && Objects.equals(serviciosPago, policyDTO.serviciosPago) && Objects.equals(prestamo, policyDTO.prestamo) && Objects.equals(exportacionCliente, policyDTO.exportacionCliente) && Objects.equals(codigoOficina1, policyDTO.codigoOficina1) && Objects.equals(fechaApertura1, policyDTO.fechaApertura1) && Objects.equals(porProducto1, policyDTO.porProducto1) && Objects.equals(tipoCuenta1, policyDTO.tipoCuenta1) && Objects.equals(canalPrincipal1, policyDTO.canalPrincipal1) && Objects.equals(codigoOficina2, policyDTO.codigoOficina2) && Objects.equals(fechaApertura2, policyDTO.fechaApertura2) && Objects.equals(porProducto2, policyDTO.porProducto2) && Objects.equals(tipoCuenta2, policyDTO.tipoCuenta2) && Objects.equals(canalPrincipal2, policyDTO.canalPrincipal2) && Objects.equals(codigoOficina3, policyDTO.codigoOficina3) && Objects.equals(fechaApertura3, policyDTO.fechaApertura3) && Objects.equals(porProducto3, policyDTO.porProducto3) && Objects.equals(tipoCuenta3, policyDTO.tipoCuenta3) && Objects.equals(canalPrincipal3, policyDTO.canalPrincipal3) && Objects.equals(codigoOficina4, policyDTO.codigoOficina4) && Objects.equals(fechaApertura4, policyDTO.fechaApertura4) && Objects.equals(porProducto4, policyDTO.porProducto4) && Objects.equals(tipoCuenta4, policyDTO.tipoCuenta4) && Objects.equals(canalPrincipal4, policyDTO.canalPrincipal4) && Objects.equals(codigoOficina5, policyDTO.codigoOficina5) && Objects.equals(fechaApertura5, policyDTO.fechaApertura5) && Objects.equals(porProducto5, policyDTO.porProducto5) && Objects.equals(tipoCuenta5, policyDTO.tipoCuenta5) && Objects.equals(canalPrincipal5, policyDTO.canalPrincipal5) && Objects.equals(codigoOficina6, policyDTO.codigoOficina6) && Objects.equals(fechaApertura6, policyDTO.fechaApertura6) && Objects.equals(porProducto6, policyDTO.porProducto6) && Objects.equals(tipoCuenta6, policyDTO.tipoCuenta6) && Objects.equals(canalPrincipal6, policyDTO.canalPrincipal6) && Objects.equals(codigoOficina7, policyDTO.codigoOficina7) && Objects.equals(fechaApertura7, policyDTO.fechaApertura7) && Objects.equals(porProducto7, policyDTO.porProducto7) && Objects.equals(tipoCuenta7, policyDTO.tipoCuenta7) && Objects.equals(canalPrincipal7, policyDTO.canalPrincipal7) && Objects.equals(textofinal, policyDTO.textofinal) && Objects.equals(textopreg, policyDTO.textopreg) && Objects.equals(orden, policyDTO.orden) && Objects.equals(indstop, policyDTO.indstop) && Objects.equals(msgsi, policyDTO.msgsi) && Objects.equals(msgno, policyDTO.msgno) && Objects.equals(cuentasdisponibles, policyDTO.cuentasdisponibles) && Objects.equals(renovacionautomatica, policyDTO.renovacionautomatica) && Objects.equals(mediospago, policyDTO.mediospago) && Objects.equals(tipogenero, policyDTO.tipogenero) && Objects.equals(descripciongenero, policyDTO.descripciongenero) && Objects.equals(idgenero, policyDTO.idgenero) && Objects.equals(valueCheckIndem, policyDTO.valueCheckIndem) && Objects.equals(valueCheckReclamo, policyDTO.valueCheckReclamo) && Objects.equals(valor, policyDTO.valor) && Objects.equals(compania, policyDTO.compania) && Objects.equals(ramo, policyDTO.ramo) && Objects.equals(anio, policyDTO.anio) && Objects.equals(ideaseg, policyDTO.ideaseg) && Objects.equals(actividad, policyDTO.actividad) && Objects.equals(infoadic, policyDTO.infoadic) && Objects.equals(numplaca, policyDTO.numplaca) && Objects.equals(numpisos, policyDTO.numpisos) && Objects.equals(indbis2, policyDTO.indbis2) && Objects.equals(literal2, policyDTO.literal2) && Objects.equals(indbis1, policyDTO.indbis1) && Objects.equals(literal, policyDTO.literal) && Objects.equals(estructura, policyDTO.estructura) && Objects.equals(tipopropiedad, policyDTO.tipopropiedad) && Objects.equals(tipoinmueble, policyDTO.tipoinmueble) && Objects.equals(tipovia, policyDTO.tipovia) && Objects.equals(tipoter, policyDTO.tipoter) && Objects.equals(zip, policyDTO.zip) && Objects.equals(piso, policyDTO.piso) && Objects.equals(tipoestructura, policyDTO.tipoestructura) && Objects.equals(tiporiesgo, policyDTO.tiporiesgo) && Objects.equals(codorientacion2, policyDTO.codorientacion2) && Objects.equals(codorientacion, policyDTO.codorientacion) && Objects.equals(dirvalinterseccion, policyDTO.dirvalinterseccion) && Objects.equals(codcalle, policyDTO.codcalle) && Objects.equals(numero, policyDTO.numero) && Objects.equals(coddepartamento, policyDTO.coddepartamento) && Objects.equals(codgrpusr, policyDTO.codgrpusr) && Objects.equals(codprod, policyDTO.codprod) && Objects.equals(codusr, policyDTO.codusr) && Objects.equals(codplan, policyDTO.codplan) && Objects.equals(revplan, policyDTO.revplan) && Objects.equals(codcanal, policyDTO.codcanal) && Objects.equals(codsubcanal, policyDTO.codsubcanal) && Objects.equals(codlval, policyDTO.codlval) && Objects.equals(tipolval, policyDTO.tipolval) && Objects.equals(tipoid, policyDTO.tipoid) && Objects.equals(numid, policyDTO.numid) && Objects.equals(codcli, policyDTO.codcli) && Objects.equals(idepol, policyDTO.idepol) && Objects.equals(numpol, policyDTO.numpol) && Objects.equals(stspol, policyDTO.stspol) && Objects.equals(stssin, policyDTO.stssin) && Objects.equals(sumaAseg, policyDTO.sumaAseg) && Objects.equals(periodicidadPago, policyDTO.periodicidadPago) && Objects.equals(departamento, policyDTO.departamento) && Objects.equals(ciudad, policyDTO.ciudad) && Objects.equals(anioConstruccion, policyDTO.anioConstruccion) && Objects.equals(nomter, policyDTO.nomter) && Objects.equals(apeter, policyDTO.apeter) && Objects.equals(dvid, policyDTO.dvid) && Objects.equals(direccion, policyDTO.direccion) && Objects.equals(fecnac, policyDTO.fecnac) && Objects.equals(descrip, policyDTO.descrip) && Objects.equals(codpais, policyDTO.codpais) && Objects.equals(indben, policyDTO.indben) && Objects.equals(indcobert, policyDTO.indcobert) && Objects.equals(stscert, policyDTO.stscert) && Objects.equals(fecinivig, policyDTO.fecinivig) && Objects.equals(fecfinvig, policyDTO.fecfinvig) && Objects.equals(codestado, policyDTO.codestado) && Objects.equals(descestado, policyDTO.descestado) && Objects.equals(zonageografica, policyDTO.zonageografica) && Objects.equals(descciudad, policyDTO.descciudad) && Objects.equals(codciudad, policyDTO.codciudad) && Objects.equals(estrato, policyDTO.estrato) && Objects.equals(codramocert, policyDTO.codramocert) && Objects.equals(numcot, policyDTO.numcot) && Objects.equals(idecotiza, policyDTO.idecotiza) && Objects.equals(clasebien, policyDTO.clasebien) && Objects.equals(codbien, policyDTO.codbien) && Objects.equals(descbien, policyDTO.descbien) && Objects.equals(montobien, policyDTO.montobien) && Objects.equals(ideclau, policyDTO.ideclau) && Objects.equals(descclau, policyDTO.descclau) && Objects.equals(parentesco, policyDTO.parentesco) && Objects.equals(codparentesco, policyDTO.codparentesco) && Objects.equals(nomben, policyDTO.nomben) && Objects.equals(numben, policyDTO.numben) && Objects.equals(idaseg, policyDTO.idaseg) && Objects.equals(porcpart, policyDTO.porcpart) && Objects.equals(grupopol, policyDTO.grupopol) && Objects.equals(numcanttc, policyDTO.numcanttc) && Objects.equals(induserasis, policyDTO.induserasis) && Objects.equals(indasegadic, policyDTO.indasegadic) && Objects.equals(tipotomador, policyDTO.tipotomador) && Objects.equals(codmunicipio, policyDTO.codmunicipio) && Objects.equals(municipio, policyDTO.municipio) && Objects.equals(numordimp, policyDTO.numordimp) && Objects.equals(pais, policyDTO.pais) && Objects.equals(codcobert, policyDTO.codcobert) && Objects.equals(desccobert, policyDTO.desccobert) && Objects.equals(porcreca, policyDTO.porcreca) && Objects.equals(nomusr, policyDTO.nomusr) && Objects.equals(codsuc, policyDTO.codsuc) && Objects.equals(codcia, policyDTO.codcia) && Objects.equals(codgrppol, policyDTO.codgrppol) && Objects.equals(desccanal, policyDTO.desccanal) && Objects.equals(descsubcanal, policyDTO.descsubcanal) && Objects.equals(codofibanc, policyDTO.codofibanc) && Objects.equals(idesmultinivel, policyDTO.idesmultinivel) && Objects.equals(nomest, policyDTO.nomest) && Objects.equals(desclval, policyDTO.desclval) && Objects.equals(numcert, policyDTO.numcert) && Objects.equals(indcargabdacsel, policyDTO.indcargabdacsel) && Objects.equals(indcontproc, policyDTO.indcontproc) && Objects.equals(nomtabla, policyDTO.nomtabla) && Objects.equals(desccampo, policyDTO.desccampo) && Objects.equals(blkweb, policyDTO.blkweb) && Objects.equals(ordenblkweb, policyDTO.ordenblkweb) && Objects.equals(indtipodato, policyDTO.indtipodato) && Objects.equals(isfixed, policyDTO.isfixed) && Objects.equals(panelkey, policyDTO.panelkey) && Objects.equals(ordensubpanel, policyDTO.ordensubpanel) && Objects.equals(iseditable, policyDTO.iseditable) && Objects.equals(isrequired, policyDTO.isrequired) && Objects.equals(afectacampo, policyDTO.afectacampo) && Objects.equals(typepresenter, policyDTO.typepresenter) && Objects.equals(tarjetasaseguradas, policyDTO.tarjetasaseguradas) && Objects.equals(idSessionExec, policyDTO.idSessionExec) && Objects.equals(message, policyDTO.message) && Objects.equals(descplanprod, policyDTO.descplanprod) && Objects.equals(descprod, policyDTO.descprod) && Objects.equals(indafinnity, policyDTO.indafinnity) && Objects.equals(email, policyDTO.email) && Objects.equals(codofiges, policyDTO.codofiges) && Objects.equals(checkbenefley, policyDTO.checkbenefley) && Objects.equals(checkbenefoneroso, policyDTO.checkbenefoneroso) && Objects.equals(genero, policyDTO.genero) && Objects.equals(apellido, policyDTO.apellido) && Objects.equals(nombre, policyDTO.nombre) && Objects.equals(codgenero, policyDTO.codgenero) && Objects.equals(descgenero, policyDTO.descgenero) && Objects.equals(apuntamiento, policyDTO.apuntamiento) && Objects.equals(id, policyDTO.id) && Objects.equals(helptopicid, policyDTO.helptopicid) && Objects.equals(apeben, policyDTO.apeben) && Objects.equals(gobalcondlaboral, policyDTO.gobalcondlaboral) && Objects.equals(method, policyDTO.method) && Objects.equals(text, policyDTO.text) && Objects.equals(bean, policyDTO.bean) && Objects.equals(selected, policyDTO.selected) && Objects.equals(codarea, policyDTO.codarea) && Objects.equals(stsprod, policyDTO.stsprod) && Objects.equals(idpolcot, policyDTO.idpolcot) && Objects.equals(numctto, policyDTO.numctto) && Objects.equals(stscot, policyDTO.stscot) && Objects.equals(fecsolic, policyDTO.fecsolic) && Objects.equals(proveedor, policyDTO.proveedor) && Objects.equals(territorial, policyDTO.territorial) && Objects.equals(zona, policyDTO.zona) && Objects.equals(sucursal, policyDTO.sucursal) && Objects.equals(fecren, policyDTO.fecren) && Objects.equals(fecfin, policyDTO.fecfin) && Objects.equals(fecing, policyDTO.fecing) && Objects.equals(formpago, policyDTO.formpago) && Objects.equals(cnumcot, policyDTO.cnumcot) && Objects.equals(pnumcot, policyDTO.pnumcot) && Objects.equals(ciuedo, policyDTO.ciuedo) && Objects.equals(cuotacamp, policyDTO.cuotacamp) && Objects.equals(porccamp, policyDTO.porccamp) && Objects.equals(idecamp, policyDTO.idecamp) && Objects.equals(utilidad, policyDTO.utilidad) && Objects.equals(plan, policyDTO.plan) && Objects.equals(codmoneda, policyDTO.codmoneda) && Objects.equals(primaadic, policyDTO.primaadic) && Objects.equals(primagf, policyDTO.primagf) && Objects.equals(cantidad, policyDTO.cantidad) && Objects.equals(codparent, policyDTO.codparent) && Objects.equals(codramoplan, policyDTO.codramoplan) && Objects.equals(emailarray, policyDTO.emailarray) && Objects.equals(direccionresidenciarray, policyDTO.direccionresidenciarray) && Objects.equals(direccioncorrespondencia, policyDTO.direccioncorrespondencia) && Objects.equals(telefono3Array, policyDTO.telefono3Array) && Objects.equals(telefono2Array, policyDTO.telefono2Array) && Objects.equals(telefono1Array, policyDTO.telefono1Array) && Objects.equals(codmediopago, policyDTO.codmediopago) && Objects.equals(descmediopago, policyDTO.descmediopago) && Objects.equals(indbenefone, policyDTO.indbenefone) && Objects.equals(induseasis, policyDTO.induseasis) && Objects.equals(benfone, policyDTO.benfone) && Objects.equals(useasis, policyDTO.useasis) && Objects.equals(filtro, policyDTO.filtro) && Objects.equals(documento, policyDTO.documento) && Objects.equals(fechaini, policyDTO.fechaini) && Objects.equals(fechafin, policyDTO.fechafin) && Objects.equals(status, policyDTO.status) && Objects.equals(numcertini, policyDTO.numcertini) && Objects.equals(numcertfin, policyDTO.numcertfin) && Objects.equals(codformpago, policyDTO.codformpago) && Objects.equals(codofiemi, policyDTO.codofiemi) && Objects.equals(fecinipol, policyDTO.fecinipol) && Objects.equals(fechainicio, policyDTO.fechainicio) && Objects.equals(fechfecoper, policyDTO.fechfecoper) && Objects.equals(compnumpol, policyDTO.compnumpol) && Objects.equals(fecoper, policyDTO.fecoper) && Objects.equals(codgestor, policyDTO.codgestor) && Objects.equals(codofisusc, policyDTO.codofisusc) && Objects.equals(motivo, policyDTO.motivo) && Objects.equals(gestor, policyDTO.gestor) && Objects.equals(fecexc, policyDTO.fecexc) && Objects.equals(fechainipol, policyDTO.fechainipol) && Objects.equals(fecfincotiza, policyDTO.fecfincotiza) && Objects.equals(nompercotiza, policyDTO.nompercotiza) && Objects.equals(idcliente, policyDTO.idcliente) && Objects.equals(codperiodicpago, policyDTO.codperiodicpago) && Objects.equals(cotestado, policyDTO.cotestado) && Objects.equals(indrenauto, policyDTO.indrenauto) && Objects.equals(direc, policyDTO.direc) && Objects.equals(codsuplemento, policyDTO.codsuplemento) && Objects.equals(suplemento, policyDTO.suplemento) && Objects.equals(codmotivo, policyDTO.codmotivo) && Objects.equals(codsubmotivo, policyDTO.codsubmotivo) && Objects.equals(submotivo, policyDTO.submotivo) && Objects.equals(fechasuplemento, policyDTO.fechasuplemento) && Objects.equals(includemode, policyDTO.includemode) && Objects.equals(primaperi, policyDTO.primaperi) && Objects.equals(primaperidica, policyDTO.primaperidica) && Objects.equals(primaanual, policyDTO.primaanual) && Objects.equals(coaseguro, policyDTO.coaseguro) && Objects.equals(sumaasegurado, policyDTO.sumaasegurado) && Objects.equals(periodicidad, policyDTO.periodicidad) && Objects.equals(direccioncorr, policyDTO.direccioncorr) && Objects.equals(direccionres, policyDTO.direccionres) && Objects.equals(tipocuenta, policyDTO.tipocuenta) && Objects.equals(celular, policyDTO.celular) && Objects.equals(checkrenauto, policyDTO.checkrenauto) && Objects.equals(cambiorenauto, policyDTO.cambiorenauto) && Objects.equals(codexclusion, policyDTO.codexclusion) && Objects.equals(motivoexclusion, policyDTO.motivoexclusion) && Objects.equals(observacion, policyDTO.observacion) && Objects.equals(codramo, policyDTO.codramo) && Objects.equals(fefecto, policyDTO.fefecto) && Objects.equals(capital, policyDTO.capital) && Objects.equals(prima, policyDTO.prima) && Objects.equals(sobreprima, policyDTO.sobreprima) && Objects.equals(extraprima, policyDTO.extraprima) && Objects.equals(deducible, policyDTO.deducible) && Objects.equals(stscobert, policyDTO.stscobert) && Objects.equals(indcobertoblig, policyDTO.indcobertoblig) && Objects.equals(tasa, policyDTO.tasa) && Objects.equals(bbvasbr, policyDTO.bbvasbr) && Objects.equals(othersbr, policyDTO.othersbr) && Objects.equals(nosbr, policyDTO.nosbr) && Objects.equals(clasecli, policyDTO.clasecli) && Objects.equals(fecanul, policyDTO.fecanul) && Objects.equals(frcinipol, policyDTO.frcinipol) && Objects.equals(tiposusc, policyDTO.tiposusc) && Objects.equals(tiposuscprod, policyDTO.tiposuscprod) && Objects.equals(codtipovia, policyDTO.codtipovia) && Objects.equals(idedirec, policyDTO.idedirec) && Objects.equals(numero2, policyDTO.numero2) && Objects.equals(descripstatus, policyDTO.descripstatus) && Objects.equals(numsolicitud, policyDTO.numsolicitud) && Objects.equals(indasegtitular, policyDTO.indasegtitular) && Objects.equals(stsaseg, policyDTO.stsaseg) && Objects.equals(descexclusion, policyDTO.descexclusion) && Objects.equals(efecto, policyDTO.efecto) && Objects.equals(emision, policyDTO.emision) && Objects.equals(cobertura, policyDTO.cobertura) && Objects.equals(indicevariable, policyDTO.indicevariable) && Objects.equals(codcapital, policyDTO.codcapital) && Objects.equals(fechaexc, policyDTO.fechaexc) && Objects.equals(stscobertura, policyDTO.stscobertura) && Objects.equals(participacion, policyDTO.participacion) && Objects.equals(recibo, policyDTO.recibo) && Objects.equals(tipoop, policyDTO.tipoop) && Objects.equals(saldo, policyDTO.saldo) && Objects.equals(poliza, policyDTO.poliza) && Objects.equals(clave, policyDTO.clave) && Objects.equals(responsabledepago, policyDTO.responsabledepago) && Objects.equals(numdocumento, policyDTO.numdocumento) && Objects.equals(primabruta, policyDTO.primabruta) && Objects.equals(numfinanc, policyDTO.numfinanc) && Objects.equals(retribucion, policyDTO.retribucion) && Objects.equals(n, policyDTO.n) && Objects.equals(iva, policyDTO.iva) && Objects.equals(reteiva, policyDTO.reteiva) && Objects.equals(reteica, policyDTO.reteica) && Objects.equals(retefue, policyDTO.retefue) && Objects.equals(ordenpago, policyDTO.ordenpago) && Objects.equals(nrogiro, policyDTO.nrogiro) && Objects.equals(fechacobro, policyDTO.fechacobro) && Objects.equals(recpagouordpago, policyDTO.recpagouordpago) && Objects.equals(idefact, policyDTO.idefact) && Objects.equals(sldofactmoneda, policyDTO.sldofactmoneda) && Objects.equals(nivel, policyDTO.nivel) && Objects.equals(codigo, policyDTO.codigo) && Objects.equals(clausula, policyDTO.clausula) && Objects.equals(anexo, policyDTO.anexo) && Objects.equals(ideclaucert, policyDTO.ideclaucert) && Objects.equals(texto, policyDTO.texto) && Objects.equals(siniestro, policyDTO.siniestro) && Objects.equals(fnotificacion, policyDTO.fnotificacion) && Objects.equals(fsiniestro, policyDTO.fsiniestro) && Objects.equals(fmodificacion, policyDTO.fmodificacion) && Objects.equals(causa, policyDTO.causa) && Objects.equals(boton, policyDTO.boton) && Objects.equals(servicio, policyDTO.servicio) && Objects.equals(codmodalidad, policyDTO.codmodalidad) && Objects.equals(modalidad, policyDTO.modalidad) && Objects.equals(nota, policyDTO.nota) && Objects.equals(policynumberweb, policyDTO.policynumberweb) && Objects.equals(option, policyDTO.option) && Objects.equals(customeridtype, policyDTO.customeridtype) && Objects.equals(renewaltype, policyDTO.renewaltype) && Objects.equals(customeridnumber, policyDTO.customeridnumber) && Objects.equals(policystatus, policyDTO.policystatus) && Objects.equals(paymentperiod, policyDTO.paymentperiod) && Objects.equals(effectivestartdate, policyDTO.effectivestartdate) && Objects.equals(renewaldate, policyDTO.renewaldate) && Objects.equals(directdebitaccount, policyDTO.directdebitaccount) && Objects.equals(insuredvalue, policyDTO.insuredvalue) && Objects.equals(managementoffice, policyDTO.managementoffice) && Objects.equals(insuranceproductcode, policyDTO.insuranceproductcode) && Objects.equals(usermanagingpolicy, policyDTO.usermanagingpolicy) && Objects.equals(operationdate, policyDTO.operationdate) && Objects.equals(premiumamount, policyDTO.premiumamount) && Objects.equals(altamiraaccountnumber, policyDTO.altamiraaccountnumber) && Objects.equals(paymentreference, policyDTO.paymentreference) && Objects.equals(amountvalue, policyDTO.amountvalue) && Objects.equals(operationtime, policyDTO.operationtime) && Objects.equals(userresponsible, policyDTO.userresponsible) && Objects.equals(description, policyDTO.description) && Objects.equals(customerpolicynumber, policyDTO.customerpolicynumber) && Objects.equals(sumaasegarray, policyDTO.sumaasegarray) && Objects.equals(ocupacionarray, policyDTO.ocupacionarray) && Objects.equals(periodicidadpagoarray, policyDTO.periodicidadpagoarray) && Objects.equals(planarray, policyDTO.planarray) && Objects.equals(departamentoarray, policyDTO.departamentoarray) && Objects.equals(ciudadarray, policyDTO.ciudadarray) && Objects.equals(estratoarray, policyDTO.estratoarray) && Objects.equals(anioconstruccionarray, policyDTO.anioconstruccionarray) && Objects.equals(idecobert, policyDTO.idecobert) && Objects.equals(nombrereporte, policyDTO.nombrereporte) && Objects.equals(nit, policyDTO.nit) && Objects.equals(ctabarrido, policyDTO.ctabarrido) && Objects.equals(rol, policyDTO.rol) && Objects.equals(rcop, policyDTO.rcop) && Objects.equals(td, policyDTO.td) && Objects.equals(treca, policyDTO.treca) && Objects.equals(estado, policyDTO.estado) && Objects.equals(primas, policyDTO.primas) && Objects.equals(fcobro, policyDTO.fcobro) && Objects.equals(femision, policyDTO.femision) && Objects.equals(agente, policyDTO.agente) && Objects.equals(cmotivodesc, policyDTO.cmotivodesc) && Objects.equals(ccompan, policyDTO.ccompan) && Objects.equals(tnombre, policyDTO.tnombre) && Objects.equals(dni, policyDTO.dni) && Objects.equals(descdni, policyDTO.descdni) && Objects.equals(tipofecha, policyDTO.tipofecha) && Objects.equals(certificadoinicial, policyDTO.certificadoinicial) && Objects.equals(certificadofinal, policyDTO.certificadofinal) && Objects.equals(producto, policyDTO.producto) && Objects.equals(oper, policyDTO.oper) && Objects.equals(tproduc, policyDTO.tproduc) && Objects.equals(cpoliza, policyDTO.cpoliza) && Objects.equals(tpoliza, policyDTO.tpoliza) && Objects.equals(bmodpag, policyDTO.bmodpag) && Objects.equals(cperson, policyDTO.cperson) && Objects.equals(tdninit, policyDTO.tdninit) && Objects.equals(tapell1, policyDTO.tapell1) && Objects.equals(tapell2, policyDTO.tapell2) && Objects.equals(nombre1, policyDTO.nombre1) && Objects.equals(bestado, policyDTO.bestado) && Objects.equals(cproduc, policyDTO.cproduc) && Objects.equals(trotulo1, policyDTO.trotulo1) && Objects.equals(cmodali, policyDTO.cmodali) && Objects.equals(nvermod, policyDTO.nvermod) && Objects.equals(trotulo2, policyDTO.trotulo2) && Objects.equals(coficin, policyDTO.coficin) && Objects.equals(nmovimi, policyDTO.nmovimi) && Objects.equals(btipmov, policyDTO.btipmov) && Objects.equals(femisio, policyDTO.femisio) && Objects.equals(cmotivo, policyDTO.cmotivo) && Objects.equals(crecibo, policyDTO.crecibo) && Objects.equals(tusuari, policyDTO.tusuari) && Objects.equals(ttermin, policyDTO.ttermin) && Objects.equals(nhormov, policyDTO.nhormov) && Objects.equals(nanexos, policyDTO.nanexos) && Objects.equals(bmotivo, policyDTO.bmotivo) && Objects.equals(brepalt, policyDTO.brepalt) && Objects.equals(tipogarantia, policyDTO.tipogarantia) && Objects.equals(amparo, policyDTO.amparo) && Objects.equals(tipo, policyDTO.tipo) && Objects.equals(relva, policyDTO.relva) && Objects.equals(retlva, policyDTO.retlva) && Objects.equals(retfue, policyDTO.retfue) && Objects.equals(ordpago, policyDTO.ordpago) && Objects.equals(reccaja, policyDTO.reccaja) && Objects.equals(garantia, policyDTO.garantia) && Objects.equals(importa, policyDTO.importa) && Objects.equals(indacsel, policyDTO.indacsel) && Objects.equals(indefront, policyDTO.indefront) && Objects.equals(indaplus, policyDTO.indaplus) && Objects.equals(cliente, policyDTO.cliente) && Objects.equals(beneficiario, policyDTO.beneficiario) && Objects.equals(certificado, policyDTO.certificado) && Objects.equals(retribuciones, policyDTO.retribuciones) && Objects.equals(agentes, policyDTO.agentes) && Objects.equals(garantias, policyDTO.garantias) && Objects.equals(bienes, policyDTO.bienes) && Objects.equals(recibos, policyDTO.recibos) && Objects.equals(autorizaciones, policyDTO.autorizaciones) && Objects.equals(clausulas, policyDTO.clausulas) && Objects.equals(codval, policyDTO.codval) && Objects.equals(tipoparam, policyDTO.tipoparam) && Objects.equals(codparam, policyDTO.codparam) && Objects.equals(descparam, policyDTO.descparam) && Objects.equals(refparam, policyDTO.refparam) && Objects.equals(codsql, policyDTO.codsql) && Objects.equals(totalregs, policyDTO.totalregs) && Objects.equals(stsbien, policyDTO.stsbien) && Objects.equals(additionalinfo, policyDTO.additionalinfo) && Objects.equals(codocupac, policyDTO.codocupac) && Objects.equals(fechaefecto, policyDTO.fechaefecto) && Objects.equals(fechaemision, policyDTO.fechaemision) && Objects.equals(porcpago, policyDTO.porcpago) && Objects.equals(descripcion, policyDTO.descripcion) && Objects.equals(mediodepago, policyDTO.mediodepago) && Objects.equals(barridodecuenta, policyDTO.barridodecuenta) && Objects.equals(cancelacionsaldos, policyDTO.cancelacionsaldos) && Objects.equals(sector, policyDTO.sector) && Objects.equals(idbien, policyDTO.idbien) && Objects.equals(tipocli, policyDTO.tipocli) && Objects.equals(asegurado, policyDTO.asegurado) && Objects.equals(idProcesoExec, policyDTO.idProcesoExec) && Objects.equals(apemat, policyDTO.apemat) && Objects.equals(descoaseguro, policyDTO.descoaseguro) && Objects.equals(numpreformalizado, policyDTO.numpreformalizado) && Objects.equals(consecutivo, policyDTO.consecutivo) && Objects.equals(channelred, policyDTO.channelred) && Objects.equals(indcondig, policyDTO.indcondig) && Objects.equals(codsucursal, policyDTO.codsucursal) && Objects.equals(numvaldoc, policyDTO.numvaldoc) && Objects.equals(numcredpre, policyDTO.numcredpre) && Objects.equals(fecvalida, policyDTO.fecvalida) && Objects.equals(numoper, policyDTO.numoper) && Objects.equals(valaproxnueva, policyDTO.valaproxnueva) && Objects.equals(valaproxactual, policyDTO.valaproxactual) && Objects.equals(idjob, policyDTO.idjob) && Objects.equals(nombrejob, policyDTO.nombrejob) && Objects.equals(calendario, policyDTO.calendario) && Objects.equals(horainicio, policyDTO.horainicio) && Objects.equals(horafin, policyDTO.horafin) && Objects.equals(codinterf, policyDTO.codinterf) && Objects.equals(codigoautoriza, policyDTO.codigoautoriza) && Objects.equals(cnextrun, policyDTO.cnextrun) && Objects.equals(descdia, policyDTO.descdia) && Objects.equals(simulacion, policyDTO.simulacion) && Objects.equals(indprimultdiames, policyDTO.indprimultdiames) && Objects.equals(diasemana, policyDTO.diasemana) && Objects.equals(descjob, policyDTO.descjob) && Objects.equals(indbackground, policyDTO.indbackground) && Objects.equals(usrrunma, policyDTO.usrrunma) && Objects.equals(nombreusr, policyDTO.nombreusr) && Objects.equals(nombreusrma, policyDTO.nombreusrma) && Objects.equals(cantlotes, policyDTO.cantlotes) && Objects.equals(descinterface, policyDTO.descinterface) && Objects.equals(usrresp, policyDTO.usrresp) && Objects.equals(tipojob, policyDTO.tipojob) && Objects.equals(usrmodif, policyDTO.usrmodif) && Objects.equals(fechamodif, policyDTO.fechamodif) && Objects.equals(parametroadic, policyDTO.parametroadic) && Objects.equals(periocidad, policyDTO.periocidad) && Objects.equals(descperiocidad, policyDTO.descperiocidad) && Objects.equals(stsjob, policyDTO.stsjob) && Objects.equals(cdescsts, policyDTO.cdescsts) && Objects.equals(fecharunma, policyDTO.fecharunma) && Objects.equals(fecsts, policyDTO.fecsts) && Objects.equals(inddiahabil, policyDTO.inddiahabil) && Objects.equals(fechacrea, policyDTO.fechacrea) && Objects.equals(tipointerfaz, policyDTO.tipointerfaz) && Objects.equals(accionjob, policyDTO.accionjob) && Objects.equals(nombreuseresp, policyDTO.nombreuseresp) && Objects.equals(usrcrea, policyDTO.usrcrea) && Objects.equals(desctipo, policyDTO.desctipo) && Objects.equals(bysegundo, policyDTO.bysegundo) && Objects.equals(byminuto, policyDTO.byminuto) && Objects.equals(byhora, policyDTO.byhora) && Objects.equals(intervalo, policyDTO.intervalo) && Objects.equals(indreproceso, policyDTO.indreproceso) && Objects.equals(observaciones, policyDTO.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantparent, impuestoanual, totalprimaanual, totalprimaperiodica, nomcampodatos, indvetoboletin, codrev, idestmultinivel, descripcanal, digitoIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaDeNacimiento, paisDeResidencia, sexo, edad, codigoGeograficoCiudad, codigoGeograficoDepartamento, direccionResidencia, direccion2, direccion3, direccion4, direccion5, direccion6, direccion7, ciudadDeResidencia, departamentoDeResidencia, telefono1, telefono2, telefono3, profesion, actividadEconomica, numeroCuenta1, numeroCuenta2, numeroCuenta3, numeroCuenta4, numeroCuenta5, numeroCuenta6, numeroCuenta7, tipoIdentificacionAsegurado, municipioDeNacimiento, departamentoDeNacimiento, paisDeNacimiento, telefonoResidencia, celularResidencia, ocupacion, codigoProfesion, independiente, posicion, nombreEmpresa, direccionEmpresa, telefonoEmpresa, celularEmpresa, descripcionOrigenFondos, ingresoMensual, gastoMensual, otrosGastos, otrosIngresos, destinoOtrosIngresos, totalActivos, totalPasivos, tipoProductoMonedaExtranjera, productoCuentaMonedaExtranjera, entidadMonedaExtranjera, cantidadMonedaExtranjera, ciudadMonedaExtranjera, paisMonedaExtranjera, monedaExtranjera, fechaSarlaft, importeCliente, inversion, serviciosPago, prestamo, exportacionCliente, codigoOficina1, fechaApertura1, porProducto1, tipoCuenta1, canalPrincipal1, codigoOficina2, fechaApertura2, porProducto2, tipoCuenta2, canalPrincipal2, codigoOficina3, fechaApertura3, porProducto3, tipoCuenta3, canalPrincipal3, codigoOficina4, fechaApertura4, porProducto4, tipoCuenta4, canalPrincipal4, codigoOficina5, fechaApertura5, porProducto5, tipoCuenta5, canalPrincipal5, codigoOficina6, fechaApertura6, porProducto6, tipoCuenta6, canalPrincipal6, codigoOficina7, fechaApertura7, porProducto7, tipoCuenta7, canalPrincipal7, textofinal, textopreg, orden, indstop, msgsi, msgno, cuentasdisponibles, renovacionautomatica, mediospago, tipogenero, descripciongenero, idgenero, valueCheckIndem, valueCheckReclamo, valor, compania, ramo, anio, ideaseg, actividad, infoadic, numplaca, numpisos, indbis2, literal2, indbis1, literal, estructura, tipopropiedad, tipoinmueble, tipovia, tipoter, zip, piso, tipoestructura, tiporiesgo, codorientacion2, codorientacion, dirvalinterseccion, codcalle, numero, coddepartamento, codgrpusr, codprod, codusr, codplan, revplan, codcanal, codsubcanal, codlval, tipolval, tipoid, numid, codcli, idepol, numpol, stspol, stssin, sumaAseg, periodicidadPago, departamento, ciudad, anioConstruccion, nomter, apeter, dvid, direccion, fecnac, descrip, codpais, indben, indcobert, stscert, fecinivig, fecfinvig, codestado, descestado, zonageografica, descciudad, codciudad, estrato, codramocert, numcot, idecotiza, clasebien, codbien, descbien, montobien, ideclau, descclau, parentesco, codparentesco, nomben, numben, idaseg, porcpart, grupopol, numcanttc, induserasis, indasegadic, tipotomador, codmunicipio, municipio, numordimp, pais, codcobert, desccobert, porcreca, nomusr, codsuc, codcia, codgrppol, desccanal, descsubcanal, codofibanc, idesmultinivel, nomest, desclval, numcert, indcargabdacsel, indcontproc, nomtabla, desccampo, blkweb, ordenblkweb, indtipodato, isfixed, panelkey, ordensubpanel, iseditable, isrequired, afectacampo, typepresenter, tarjetasaseguradas, idSessionExec, message, descplanprod, descprod, indafinnity, email, codofiges, checkbenefley, checkbenefoneroso, genero, apellido, nombre, codgenero, descgenero, apuntamiento, id, helptopicid, apeben, gobalcondlaboral, method, text, bean, selected, codarea, stsprod, idpolcot, numctto, stscot, fecsolic, proveedor, territorial, zona, sucursal, fecren, fecfin, fecing, formpago, cnumcot, pnumcot, ciuedo, cuotacamp, porccamp, idecamp, utilidad, plan, codmoneda, primaadic, primagf, cantidad, codparent, codramoplan, emailarray, direccionresidenciarray, direccioncorrespondencia, telefono3Array, telefono2Array, telefono1Array, codmediopago, descmediopago, indbenefone, induseasis, benfone, useasis, filtro, documento, fechaini, fechafin, status, numcertini, numcertfin, codformpago, codofiemi, fecinipol, fechainicio, fechfecoper, compnumpol, fecoper, codgestor, codofisusc, motivo, gestor, fecexc, fechainipol, fecfincotiza, nompercotiza, idcliente, codperiodicpago, cotestado, indrenauto, direc, codsuplemento, suplemento, codmotivo, codsubmotivo, submotivo, fechasuplemento, includemode, primaperi, primaperidica, primaanual, coaseguro, sumaasegurado, periodicidad, direccioncorr, direccionres, tipocuenta, celular, checkrenauto, cambiorenauto, codexclusion, motivoexclusion, observacion, codramo, fefecto, capital, prima, sobreprima, extraprima, deducible, stscobert, indcobertoblig, tasa, bbvasbr, othersbr, nosbr, clasecli, fecanul, frcinipol, tiposusc, tiposuscprod, codtipovia, idedirec, numero2, descripstatus, numsolicitud, indasegtitular, stsaseg, descexclusion, efecto, emision, cobertura, indicevariable, codcapital, fechaexc, stscobertura, participacion, recibo, tipoop, saldo, poliza, clave, responsabledepago, numdocumento, primabruta, numfinanc, retribucion, n, iva, reteiva, reteica, retefue, ordenpago, nrogiro, fechacobro, recpagouordpago, idefact, sldofactmoneda, nivel, codigo, clausula, anexo, ideclaucert, texto, siniestro, fnotificacion, fsiniestro, fmodificacion, causa, boton, servicio, codmodalidad, modalidad, nota, policynumberweb, option, customeridtype, renewaltype, customeridnumber, policystatus, paymentperiod, effectivestartdate, renewaldate, directdebitaccount, insuredvalue, managementoffice, insuranceproductcode, usermanagingpolicy, operationdate, premiumamount, altamiraaccountnumber, paymentreference, amountvalue, operationtime, userresponsible, description, customerpolicynumber, sumaasegarray, ocupacionarray, periodicidadpagoarray, planarray, departamentoarray, ciudadarray, estratoarray, anioconstruccionarray, idecobert, nombrereporte, nit, ctabarrido, rol, rcop, td, treca, estado, primas, fcobro, femision, agente, cmotivodesc, ccompan, tnombre, dni, descdni, tipofecha, certificadoinicial, certificadofinal, producto, oper, tproduc, cpoliza, tpoliza, bmodpag, cperson, tdninit, tapell1, tapell2, nombre1, bestado, cproduc, trotulo1, cmodali, nvermod, trotulo2, coficin, nmovimi, btipmov, femisio, cmotivo, crecibo, tusuari, ttermin, nhormov, nanexos, bmotivo, brepalt, tipogarantia, amparo, tipo, relva, retlva, retfue, ordpago, reccaja, garantia, importa, indacsel, indefront, indaplus, cliente, beneficiario, certificado, retribuciones, agentes, garantias, bienes, recibos, autorizaciones, clausulas, codval, tipoparam, codparam, descparam, refparam, codsql, totalregs, stsbien, additionalinfo, codocupac, fechaefecto, fechaemision, porcpago, descripcion, mediodepago, barridodecuenta, cancelacionsaldos, sector, idbien, tipocli, asegurado, idProcesoExec, apemat, descoaseguro, numpreformalizado, consecutivo, channelred, indcondig, codsucursal, numvaldoc, numcredpre, fecvalida, numoper, valaproxnueva, valaproxactual, idjob, nombrejob, calendario, horainicio, horafin, codinterf, codigoautoriza, cnextrun, descdia, simulacion, indprimultdiames, diasemana, descjob, indbackground, usrrunma, nombreusr, nombreusrma, cantlotes, descinterface, usrresp, tipojob, usrmodif, fechamodif, parametroadic, periocidad, descperiocidad, stsjob, cdescsts, fecharunma, fecsts, inddiahabil, fechacrea, tipointerfaz, accionjob, nombreuseresp, usrcrea, desctipo, bysegundo, byminuto, byhora, intervalo, indreproceso, observaciones);
    }

    @Override
    public String toString() {
        return "PolicyDTO{" +
                "cantparent=" + cantparent +
                ", impuestoanual='" + impuestoanual + '\'' +
                ", totalprimaanual='" + totalprimaanual + '\'' +
                ", totalprimaperiodica='" + totalprimaperiodica + '\'' +
                ", nomcampodatos='" + nomcampodatos + '\'' +
                ", indvetoboletin='" + indvetoboletin + '\'' +
                ", codrev='" + codrev + '\'' +
                ", idestmultinivel='" + idestmultinivel + '\'' +
                ", descripcanal='" + descripcanal + '\'' +
                ", digitoIdentificacion='" + digitoIdentificacion + '\'' +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", paisDeResidencia='" + paisDeResidencia + '\'' +
                ", sexo='" + sexo + '\'' +
                ", edad='" + edad + '\'' +
                ", codigoGeograficoCiudad='" + codigoGeograficoCiudad + '\'' +
                ", codigoGeograficoDepartamento='" + codigoGeograficoDepartamento + '\'' +
                ", direccionResidencia='" + direccionResidencia + '\'' +
                ", direccion2='" + direccion2 + '\'' +
                ", direccion3='" + direccion3 + '\'' +
                ", direccion4='" + direccion4 + '\'' +
                ", direccion5='" + direccion5 + '\'' +
                ", direccion6='" + direccion6 + '\'' +
                ", direccion7='" + direccion7 + '\'' +
                ", ciudadDeResidencia='" + ciudadDeResidencia + '\'' +
                ", departamentoDeResidencia='" + departamentoDeResidencia + '\'' +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                ", telefono3='" + telefono3 + '\'' +
                ", profesion='" + profesion + '\'' +
                ", actividadEconomica='" + actividadEconomica + '\'' +
                ", numeroCuenta1='" + numeroCuenta1 + '\'' +
                ", numeroCuenta2='" + numeroCuenta2 + '\'' +
                ", numeroCuenta3='" + numeroCuenta3 + '\'' +
                ", numeroCuenta4='" + numeroCuenta4 + '\'' +
                ", numeroCuenta5='" + numeroCuenta5 + '\'' +
                ", numeroCuenta6='" + numeroCuenta6 + '\'' +
                ", numeroCuenta7='" + numeroCuenta7 + '\'' +
                ", tipoIdentificacionAsegurado='" + tipoIdentificacionAsegurado + '\'' +
                ", municipioDeNacimiento='" + municipioDeNacimiento + '\'' +
                ", departamentoDeNacimiento='" + departamentoDeNacimiento + '\'' +
                ", paisDeNacimiento='" + paisDeNacimiento + '\'' +
                ", telefonoResidencia='" + telefonoResidencia + '\'' +
                ", celularResidencia='" + celularResidencia + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", codigoProfesion='" + codigoProfesion + '\'' +
                ", independiente='" + independiente + '\'' +
                ", posicion='" + posicion + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", direccionEmpresa='" + direccionEmpresa + '\'' +
                ", telefonoEmpresa='" + telefonoEmpresa + '\'' +
                ", celularEmpresa='" + celularEmpresa + '\'' +
                ", descripcionOrigenFondos='" + descripcionOrigenFondos + '\'' +
                ", ingresoMensual=" + ingresoMensual +
                ", gastoMensual=" + gastoMensual +
                ", otrosGastos=" + otrosGastos +
                ", otrosIngresos=" + otrosIngresos +
                ", destinoOtrosIngresos='" + destinoOtrosIngresos + '\'' +
                ", totalActivos=" + totalActivos +
                ", totalPasivos=" + totalPasivos +
                ", tipoProductoMonedaExtranjera='" + tipoProductoMonedaExtranjera + '\'' +
                ", productoCuentaMonedaExtranjera='" + productoCuentaMonedaExtranjera + '\'' +
                ", entidadMonedaExtranjera='" + entidadMonedaExtranjera + '\'' +
                ", cantidadMonedaExtranjera=" + cantidadMonedaExtranjera +
                ", ciudadMonedaExtranjera='" + ciudadMonedaExtranjera + '\'' +
                ", paisMonedaExtranjera='" + paisMonedaExtranjera + '\'' +
                ", monedaExtranjera='" + monedaExtranjera + '\'' +
                ", fechaSarlaft='" + fechaSarlaft + '\'' +
                ", importeCliente='" + importeCliente + '\'' +
                ", inversion='" + inversion + '\'' +
                ", serviciosPago='" + serviciosPago + '\'' +
                ", prestamo='" + prestamo + '\'' +
                ", exportacionCliente='" + exportacionCliente + '\'' +
                ", codigoOficina1='" + codigoOficina1 + '\'' +
                ", fechaApertura1=" + fechaApertura1 +
                ", porProducto1='" + porProducto1 + '\'' +
                ", tipoCuenta1='" + tipoCuenta1 + '\'' +
                ", canalPrincipal1='" + canalPrincipal1 + '\'' +
                ", codigoOficina2='" + codigoOficina2 + '\'' +
                ", fechaApertura2=" + fechaApertura2 +
                ", porProducto2='" + porProducto2 + '\'' +
                ", tipoCuenta2='" + tipoCuenta2 + '\'' +
                ", canalPrincipal2='" + canalPrincipal2 + '\'' +
                ", codigoOficina3='" + codigoOficina3 + '\'' +
                ", fechaApertura3=" + fechaApertura3 +
                ", porProducto3='" + porProducto3 + '\'' +
                ", tipoCuenta3='" + tipoCuenta3 + '\'' +
                ", canalPrincipal3='" + canalPrincipal3 + '\'' +
                ", codigoOficina4='" + codigoOficina4 + '\'' +
                ", fechaApertura4=" + fechaApertura4 +
                ", porProducto4='" + porProducto4 + '\'' +
                ", tipoCuenta4='" + tipoCuenta4 + '\'' +
                ", canalPrincipal4='" + canalPrincipal4 + '\'' +
                ", codigoOficina5='" + codigoOficina5 + '\'' +
                ", fechaApertura5=" + fechaApertura5 +
                ", porProducto5='" + porProducto5 + '\'' +
                ", tipoCuenta5='" + tipoCuenta5 + '\'' +
                ", canalPrincipal5='" + canalPrincipal5 + '\'' +
                ", codigoOficina6='" + codigoOficina6 + '\'' +
                ", fechaApertura6=" + fechaApertura6 +
                ", porProducto6='" + porProducto6 + '\'' +
                ", tipoCuenta6='" + tipoCuenta6 + '\'' +
                ", canalPrincipal6='" + canalPrincipal6 + '\'' +
                ", codigoOficina7='" + codigoOficina7 + '\'' +
                ", fechaApertura7=" + fechaApertura7 +
                ", porProducto7='" + porProducto7 + '\'' +
                ", tipoCuenta7='" + tipoCuenta7 + '\'' +
                ", canalPrincipal7='" + canalPrincipal7 + '\'' +
                ", textofinal='" + textofinal + '\'' +
                ", textopreg='" + textopreg + '\'' +
                ", orden=" + orden +
                ", indstop='" + indstop + '\'' +
                ", msgsi='" + msgsi + '\'' +
                ", msgno='" + msgno + '\'' +
                ", cuentasdisponibles=" + cuentasdisponibles +
                ", renovacionautomatica='" + renovacionautomatica + '\'' +
                ", mediospago=" + mediospago +
                ", tipogenero='" + tipogenero + '\'' +
                ", descripciongenero='" + descripciongenero + '\'' +
                ", idgenero='" + idgenero + '\'' +
                ", valueCheckIndem='" + valueCheckIndem + '\'' +
                ", valueCheckReclamo='" + valueCheckReclamo + '\'' +
                ", valor='" + valor + '\'' +
                ", compania='" + compania + '\'' +
                ", ramo='" + ramo + '\'' +
                ", anio='" + anio + '\'' +
                ", ideaseg='" + ideaseg + '\'' +
                ", actividad='" + actividad + '\'' +
                ", infoadic='" + infoadic + '\'' +
                ", numplaca='" + numplaca + '\'' +
                ", numpisos='" + numpisos + '\'' +
                ", indbis2='" + indbis2 + '\'' +
                ", literal2='" + literal2 + '\'' +
                ", indbis1='" + indbis1 + '\'' +
                ", literal='" + literal + '\'' +
                ", estructura='" + estructura + '\'' +
                ", tipopropiedad='" + tipopropiedad + '\'' +
                ", tipoinmueble='" + tipoinmueble + '\'' +
                ", tipovia='" + tipovia + '\'' +
                ", tipoter='" + tipoter + '\'' +
                ", zip='" + zip + '\'' +
                ", piso='" + piso + '\'' +
                ", tipoestructura='" + tipoestructura + '\'' +
                ", tiporiesgo='" + tiporiesgo + '\'' +
                ", codorientacion2='" + codorientacion2 + '\'' +
                ", codorientacion='" + codorientacion + '\'' +
                ", dirvalinterseccion='" + dirvalinterseccion + '\'' +
                ", codcalle='" + codcalle + '\'' +
                ", numero=" + numero +
                ", coddepartamento='" + coddepartamento + '\'' +
                ", codgrpusr='" + codgrpusr + '\'' +
                ", codprod='" + codprod + '\'' +
                ", codusr='" + codusr + '\'' +
                ", codplan='" + codplan + '\'' +
                ", revplan='" + revplan + '\'' +
                ", codcanal='" + codcanal + '\'' +
                ", codsubcanal='" + codsubcanal + '\'' +
                ", codlval='" + codlval + '\'' +
                ", tipolval='" + tipolval + '\'' +
                ", tipoid='" + tipoid + '\'' +
                ", numid=" + numid +
                ", codcli='" + codcli + '\'' +
                ", idepol=" + idepol +
                ", numpol='" + numpol + '\'' +
                ", stspol='" + stspol + '\'' +
                ", stssin='" + stssin + '\'' +
                ", sumaAseg=" + sumaAseg +
                ", periodicidadPago='" + periodicidadPago + '\'' +
                ", departamento='" + departamento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", anioConstruccion='" + anioConstruccion + '\'' +
                ", nomter='" + nomter + '\'' +
                ", apeter='" + apeter + '\'' +
                ", dvid='" + dvid + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fecnac='" + fecnac + '\'' +
                ", descrip='" + descrip + '\'' +
                ", codpais='" + codpais + '\'' +
                ", indben='" + indben + '\'' +
                ", indcobert='" + indcobert + '\'' +
                ", stscert='" + stscert + '\'' +
                ", fecinivig='" + fecinivig + '\'' +
                ", fecfinvig='" + fecfinvig + '\'' +
                ", codestado='" + codestado + '\'' +
                ", descestado='" + descestado + '\'' +
                ", zonageografica='" + zonageografica + '\'' +
                ", descciudad='" + descciudad + '\'' +
                ", codciudad='" + codciudad + '\'' +
                ", estrato=" + estrato +
                ", codramocert='" + codramocert + '\'' +
                ", numcot=" + numcot +
                ", idecotiza=" + idecotiza +
                ", clasebien='" + clasebien + '\'' +
                ", codbien='" + codbien + '\'' +
                ", descbien='" + descbien + '\'' +
                ", montobien=" + montobien +
                ", ideclau=" + ideclau +
                ", descclau='" + descclau + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", codparentesco='" + codparentesco + '\'' +
                ", nomben='" + nomben + '\'' +
                ", numben=" + numben +
                ", idaseg='" + idaseg + '\'' +
                ", porcpart=" + porcpart +
                ", grupopol='" + grupopol + '\'' +
                ", numcanttc=" + numcanttc +
                ", induserasis='" + induserasis + '\'' +
                ", indasegadic='" + indasegadic + '\'' +
                ", tipotomador='" + tipotomador + '\'' +
                ", codmunicipio='" + codmunicipio + '\'' +
                ", municipio='" + municipio + '\'' +
                ", numordimp='" + numordimp + '\'' +
                ", pais='" + pais + '\'' +
                ", codcobert='" + codcobert + '\'' +
                ", desccobert='" + desccobert + '\'' +
                ", porcreca=" + porcreca +
                ", nomusr='" + nomusr + '\'' +
                ", codsuc='" + codsuc + '\'' +
                ", codcia='" + codcia + '\'' +
                ", codgrppol='" + codgrppol + '\'' +
                ", desccanal='" + desccanal + '\'' +
                ", descsubcanal='" + descsubcanal + '\'' +
                ", codofibanc=" + codofibanc +
                ", idesmultinivel='" + idesmultinivel + '\'' +
                ", nomest='" + nomest + '\'' +
                ", desclval='" + desclval + '\'' +
                ", numcert=" + numcert +
                ", indcargabdacsel='" + indcargabdacsel + '\'' +
                ", indcontproc='" + indcontproc + '\'' +
                ", nomtabla='" + nomtabla + '\'' +
                ", desccampo='" + desccampo + '\'' +
                ", blkweb='" + blkweb + '\'' +
                ", ordenblkweb='" + ordenblkweb + '\'' +
                ", indtipodato='" + indtipodato + '\'' +
                ", isfixed='" + isfixed + '\'' +
                ", panelkey='" + panelkey + '\'' +
                ", ordensubpanel='" + ordensubpanel + '\'' +
                ", iseditable='" + iseditable + '\'' +
                ", isrequired='" + isrequired + '\'' +
                ", afectacampo='" + afectacampo + '\'' +
                ", typepresenter='" + typepresenter + '\'' +
                ", tarjetasaseguradas=" + tarjetasaseguradas +
                ", idSessionExec='" + idSessionExec + '\'' +
                ", message='" + message + '\'' +
                ", descplanprod='" + descplanprod + '\'' +
                ", descprod='" + descprod + '\'' +
                ", indafinnity='" + indafinnity + '\'' +
                ", email='" + email + '\'' +
                ", codofiges='" + codofiges + '\'' +
                ", checkbenefley='" + checkbenefley + '\'' +
                ", checkbenefoneroso='" + checkbenefoneroso + '\'' +
                ", genero='" + genero + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", codgenero='" + codgenero + '\'' +
                ", descgenero='" + descgenero + '\'' +
                ", apuntamiento='" + apuntamiento + '\'' +
                ", id='" + id + '\'' +
                ", helptopicid='" + helptopicid + '\'' +
                ", apeben='" + apeben + '\'' +
                ", gobalcondlaboral='" + gobalcondlaboral + '\'' +
                ", method='" + method + '\'' +
                ", text='" + text + '\'' +
                ", bean='" + bean + '\'' +
                ", selected='" + selected + '\'' +
                ", codarea='" + codarea + '\'' +
                ", stsprod='" + stsprod + '\'' +
                ", idpolcot='" + idpolcot + '\'' +
                ", numctto='" + numctto + '\'' +
                ", stscot='" + stscot + '\'' +
                ", fecsolic='" + fecsolic + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", territorial='" + territorial + '\'' +
                ", zona='" + zona + '\'' +
                ", sucursal='" + sucursal + '\'' +
                ", fecren='" + fecren + '\'' +
                ", fecfin='" + fecfin + '\'' +
                ", fecing='" + fecing + '\'' +
                ", formpago='" + formpago + '\'' +
                ", cnumcot='" + cnumcot + '\'' +
                ", pnumcot='" + pnumcot + '\'' +
                ", ciuedo='" + ciuedo + '\'' +
                ", cuotacamp='" + cuotacamp + '\'' +
                ", porccamp='" + porccamp + '\'' +
                ", idecamp='" + idecamp + '\'' +
                ", utilidad='" + utilidad + '\'' +
                ", plan='" + plan + '\'' +
                ", codmoneda='" + codmoneda + '\'' +
                ", primaadic='" + primaadic + '\'' +
                ", primagf='" + primagf + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", codparent='" + codparent + '\'' +
                ", codramoplan='" + codramoplan + '\'' +
                ", emailarray=" + emailarray +
                ", direccionresidenciarray=" + direccionresidenciarray +
                ", direccioncorrespondencia=" + direccioncorrespondencia +
                ", telefono3Array=" + telefono3Array +
                ", telefono2Array=" + telefono2Array +
                ", telefono1Array=" + telefono1Array +
                ", codmediopago='" + codmediopago + '\'' +
                ", descmediopago='" + descmediopago + '\'' +
                ", indbenefone='" + indbenefone + '\'' +
                ", induseasis='" + induseasis + '\'' +
                ", benfone='" + benfone + '\'' +
                ", useasis='" + useasis + '\'' +
                ", filtro='" + filtro + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaini='" + fechaini + '\'' +
                ", fechafin='" + fechafin + '\'' +
                ", status='" + status + '\'' +
                ", numcertini='" + numcertini + '\'' +
                ", numcertfin='" + numcertfin + '\'' +
                ", codformpago='" + codformpago + '\'' +
                ", codofiemi='" + codofiemi + '\'' +
                ", fecinipol='" + fecinipol + '\'' +
                ", fechainicio='" + fechainicio + '\'' +
                ", fechfecoper='" + fechfecoper + '\'' +
                ", compnumpol='" + compnumpol + '\'' +
                ", fecoper='" + fecoper + '\'' +
                ", codgestor='" + codgestor + '\'' +
                ", codofisusc='" + codofisusc + '\'' +
                ", motivo='" + motivo + '\'' +
                ", gestor='" + gestor + '\'' +
                ", fecexc='" + fecexc + '\'' +
                ", fechainipol='" + fechainipol + '\'' +
                ", fecfincotiza='" + fecfincotiza + '\'' +
                ", nompercotiza='" + nompercotiza + '\'' +
                ", idcliente='" + idcliente + '\'' +
                ", codperiodicpago='" + codperiodicpago + '\'' +
                ", cotestado='" + cotestado + '\'' +
                ", indrenauto='" + indrenauto + '\'' +
                ", direc='" + direc + '\'' +
                ", codsuplemento='" + codsuplemento + '\'' +
                ", suplemento='" + suplemento + '\'' +
                ", codmotivo='" + codmotivo + '\'' +
                ", codsubmotivo='" + codsubmotivo + '\'' +
                ", submotivo='" + submotivo + '\'' +
                ", fechasuplemento='" + fechasuplemento + '\'' +
                ", includemode='" + includemode + '\'' +
                ", primaperi='" + primaperi + '\'' +
                ", primaperidica='" + primaperidica + '\'' +
                ", primaanual='" + primaanual + '\'' +
                ", coaseguro='" + coaseguro + '\'' +
                ", sumaasegurado='" + sumaasegurado + '\'' +
                ", periodicidad='" + periodicidad + '\'' +
                ", direccioncorr='" + direccioncorr + '\'' +
                ", direccionres='" + direccionres + '\'' +
                ", tipocuenta='" + tipocuenta + '\'' +
                ", celular='" + celular + '\'' +
                ", checkrenauto='" + checkrenauto + '\'' +
                ", cambiorenauto='" + cambiorenauto + '\'' +
                ", codexclusion='" + codexclusion + '\'' +
                ", motivoexclusion='" + motivoexclusion + '\'' +
                ", observacion='" + observacion + '\'' +
                ", codramo='" + codramo + '\'' +
                ", fefecto='" + fefecto + '\'' +
                ", capital='" + capital + '\'' +
                ", prima='" + prima + '\'' +
                ", sobreprima='" + sobreprima + '\'' +
                ", extraprima='" + extraprima + '\'' +
                ", deducible='" + deducible + '\'' +
                ", stscobert='" + stscobert + '\'' +
                ", indcobertoblig='" + indcobertoblig + '\'' +
                ", tasa='" + tasa + '\'' +
                ", bbvasbr='" + bbvasbr + '\'' +
                ", othersbr='" + othersbr + '\'' +
                ", nosbr='" + nosbr + '\'' +
                ", clasecli='" + clasecli + '\'' +
                ", fecanul='" + fecanul + '\'' +
                ", frcinipol='" + frcinipol + '\'' +
                ", tiposusc='" + tiposusc + '\'' +
                ", tiposuscprod='" + tiposuscprod + '\'' +
                ", codtipovia='" + codtipovia + '\'' +
                ", idedirec='" + idedirec + '\'' +
                ", numero2='" + numero2 + '\'' +
                ", descripstatus='" + descripstatus + '\'' +
                ", numsolicitud='" + numsolicitud + '\'' +
                ", indasegtitular='" + indasegtitular + '\'' +
                ", stsaseg='" + stsaseg + '\'' +
                ", descexclusion='" + descexclusion + '\'' +
                ", efecto='" + efecto + '\'' +
                ", emision='" + emision + '\'' +
                ", cobertura='" + cobertura + '\'' +
                ", indicevariable='" + indicevariable + '\'' +
                ", codcapital='" + codcapital + '\'' +
                ", fechaexc='" + fechaexc + '\'' +
                ", stscobertura='" + stscobertura + '\'' +
                ", participacion='" + participacion + '\'' +
                ", recibo='" + recibo + '\'' +
                ", tipoop='" + tipoop + '\'' +
                ", saldo='" + saldo + '\'' +
                ", poliza='" + poliza + '\'' +
                ", clave='" + clave + '\'' +
                ", responsabledepago='" + responsabledepago + '\'' +
                ", numdocumento='" + numdocumento + '\'' +
                ", primabruta='" + primabruta + '\'' +
                ", numfinanc='" + numfinanc + '\'' +
                ", retribucion='" + retribucion + '\'' +
                ", n='" + n + '\'' +
                ", iva='" + iva + '\'' +
                ", reteiva='" + reteiva + '\'' +
                ", reteica='" + reteica + '\'' +
                ", retefue='" + retefue + '\'' +
                ", ordenpago='" + ordenpago + '\'' +
                ", nrogiro='" + nrogiro + '\'' +
                ", fechacobro='" + fechacobro + '\'' +
                ", recpagouordpago='" + recpagouordpago + '\'' +
                ", idefact='" + idefact + '\'' +
                ", sldofactmoneda='" + sldofactmoneda + '\'' +
                ", nivel='" + nivel + '\'' +
                ", codigo='" + codigo + '\'' +
                ", clausula='" + clausula + '\'' +
                ", anexo='" + anexo + '\'' +
                ", ideclaucert='" + ideclaucert + '\'' +
                ", texto='" + texto + '\'' +
                ", siniestro='" + siniestro + '\'' +
                ", fnotificacion='" + fnotificacion + '\'' +
                ", fsiniestro='" + fsiniestro + '\'' +
                ", fmodificacion='" + fmodificacion + '\'' +
                ", causa='" + causa + '\'' +
                ", boton='" + boton + '\'' +
                ", servicio='" + servicio + '\'' +
                ", codmodalidad='" + codmodalidad + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", nota='" + nota + '\'' +
                ", policynumberweb='" + policynumberweb + '\'' +
                ", option='" + option + '\'' +
                ", customeridtype='" + customeridtype + '\'' +
                ", renewaltype='" + renewaltype + '\'' +
                ", customeridnumber='" + customeridnumber + '\'' +
                ", policystatus='" + policystatus + '\'' +
                ", paymentperiod='" + paymentperiod + '\'' +
                ", effectivestartdate='" + effectivestartdate + '\'' +
                ", renewaldate='" + renewaldate + '\'' +
                ", directdebitaccount='" + directdebitaccount + '\'' +
                ", insuredvalue='" + insuredvalue + '\'' +
                ", managementoffice='" + managementoffice + '\'' +
                ", insuranceproductcode='" + insuranceproductcode + '\'' +
                ", usermanagingpolicy='" + usermanagingpolicy + '\'' +
                ", operationdate='" + operationdate + '\'' +
                ", premiumamount='" + premiumamount + '\'' +
                ", altamiraaccountnumber='" + altamiraaccountnumber + '\'' +
                ", paymentreference='" + paymentreference + '\'' +
                ", amountvalue='" + amountvalue + '\'' +
                ", operationtime='" + operationtime + '\'' +
                ", userresponsible='" + userresponsible + '\'' +
                ", description='" + description + '\'' +
                ", customerpolicynumber='" + customerpolicynumber + '\'' +
                ", sumaasegarray=" + sumaasegarray +
                ", ocupacionarray=" + ocupacionarray +
                ", periodicidadpagoarray=" + periodicidadpagoarray +
                ", planarray=" + planarray +
                ", departamentoarray=" + departamentoarray +
                ", ciudadarray=" + ciudadarray +
                ", estratoarray=" + estratoarray +
                ", anioconstruccionarray=" + anioconstruccionarray +
                ", idecobert='" + idecobert + '\'' +
                ", nombrereporte='" + nombrereporte + '\'' +
                ", nit='" + nit + '\'' +
                ", ctabarrido='" + ctabarrido + '\'' +
                ", rol='" + rol + '\'' +
                ", rcop='" + rcop + '\'' +
                ", td='" + td + '\'' +
                ", treca='" + treca + '\'' +
                ", estado='" + estado + '\'' +
                ", primas='" + primas + '\'' +
                ", fcobro='" + fcobro + '\'' +
                ", femision='" + femision + '\'' +
                ", agente='" + agente + '\'' +
                ", cmotivodesc='" + cmotivodesc + '\'' +
                ", ccompan='" + ccompan + '\'' +
                ", tnombre='" + tnombre + '\'' +
                ", dni='" + dni + '\'' +
                ", descdni='" + descdni + '\'' +
                ", tipofecha='" + tipofecha + '\'' +
                ", certificadoinicial='" + certificadoinicial + '\'' +
                ", certificadofinal='" + certificadofinal + '\'' +
                ", producto='" + producto + '\'' +
                ", oper='" + oper + '\'' +
                ", tproduc='" + tproduc + '\'' +
                ", cpoliza='" + cpoliza + '\'' +
                ", tpoliza='" + tpoliza + '\'' +
                ", bmodpag='" + bmodpag + '\'' +
                ", cperson='" + cperson + '\'' +
                ", tdninit='" + tdninit + '\'' +
                ", tapell1='" + tapell1 + '\'' +
                ", tapell2='" + tapell2 + '\'' +
                ", nombre1='" + nombre1 + '\'' +
                ", bestado='" + bestado + '\'' +
                ", cproduc='" + cproduc + '\'' +
                ", trotulo1='" + trotulo1 + '\'' +
                ", cmodali='" + cmodali + '\'' +
                ", nvermod='" + nvermod + '\'' +
                ", trotulo2='" + trotulo2 + '\'' +
                ", coficin='" + coficin + '\'' +
                ", nmovimi='" + nmovimi + '\'' +
                ", btipmov='" + btipmov + '\'' +
                ", femisio='" + femisio + '\'' +
                ", cmotivo='" + cmotivo + '\'' +
                ", crecibo='" + crecibo + '\'' +
                ", tusuari='" + tusuari + '\'' +
                ", ttermin='" + ttermin + '\'' +
                ", nhormov='" + nhormov + '\'' +
                ", nanexos='" + nanexos + '\'' +
                ", bmotivo='" + bmotivo + '\'' +
                ", brepalt='" + brepalt + '\'' +
                ", tipogarantia='" + tipogarantia + '\'' +
                ", amparo='" + amparo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", relva='" + relva + '\'' +
                ", retlva='" + retlva + '\'' +
                ", retfue='" + retfue + '\'' +
                ", ordpago='" + ordpago + '\'' +
                ", reccaja='" + reccaja + '\'' +
                ", garantia='" + garantia + '\'' +
                ", importa='" + importa + '\'' +
                ", indacsel='" + indacsel + '\'' +
                ", indefront='" + indefront + '\'' +
                ", indaplus='" + indaplus + '\'' +
                ", cliente=" + cliente +
                ", beneficiario=" + beneficiario +
                ", certificado=" + certificado +
                ", retribuciones=" + retribuciones +
                ", agentes=" + agentes +
                ", garantias=" + garantias +
                ", bienes=" + bienes +
                ", recibos=" + recibos +
                ", autorizaciones=" + autorizaciones +
                ", clausulas=" + clausulas +
                ", codval='" + codval + '\'' +
                ", tipoparam='" + tipoparam + '\'' +
                ", codparam='" + codparam + '\'' +
                ", descparam='" + descparam + '\'' +
                ", refparam='" + refparam + '\'' +
                ", codsql='" + codsql + '\'' +
                ", totalregs='" + totalregs + '\'' +
                ", stsbien='" + stsbien + '\'' +
                ", additionalinfo='" + additionalinfo + '\'' +
                ", codocupac='" + codocupac + '\'' +
                ", fechaefecto='" + fechaefecto + '\'' +
                ", fechaemision='" + fechaemision + '\'' +
                ", porcpago='" + porcpago + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", mediodepago='" + mediodepago + '\'' +
                ", barridodecuenta='" + barridodecuenta + '\'' +
                ", cancelacionsaldos='" + cancelacionsaldos + '\'' +
                ", sector='" + sector + '\'' +
                ", idbien='" + idbien + '\'' +
                ", tipocli='" + tipocli + '\'' +
                ", asegurado=" + asegurado +
                ", idProcesoExec='" + idProcesoExec + '\'' +
                ", apemat='" + apemat + '\'' +
                ", descoaseguro='" + descoaseguro + '\'' +
                ", numpreformalizado='" + numpreformalizado + '\'' +
                ", consecutivo='" + consecutivo + '\'' +
                ", channelred='" + channelred + '\'' +
                ", indcondig='" + indcondig + '\'' +
                ", codsucursal='" + codsucursal + '\'' +
                ", numvaldoc='" + numvaldoc + '\'' +
                ", numcredpre='" + numcredpre + '\'' +
                ", fecvalida='" + fecvalida + '\'' +
                ", numoper='" + numoper + '\'' +
                ", valaproxnueva='" + valaproxnueva + '\'' +
                ", valaproxactual='" + valaproxactual + '\'' +
                ", idjob='" + idjob + '\'' +
                ", nombrejob='" + nombrejob + '\'' +
                ", calendario='" + calendario + '\'' +
                ", horainicio='" + horainicio + '\'' +
                ", horafin='" + horafin + '\'' +
                ", codinterf='" + codinterf + '\'' +
                ", codigoautoriza='" + codigoautoriza + '\'' +
                ", cnextrun='" + cnextrun + '\'' +
                ", descdia='" + descdia + '\'' +
                ", simulacion='" + simulacion + '\'' +
                ", indprimultdiames='" + indprimultdiames + '\'' +
                ", diasemana='" + diasemana + '\'' +
                ", descjob='" + descjob + '\'' +
                ", indbackground='" + indbackground + '\'' +
                ", usrrunma='" + usrrunma + '\'' +
                ", nombreusr='" + nombreusr + '\'' +
                ", nombreusrma='" + nombreusrma + '\'' +
                ", cantlotes='" + cantlotes + '\'' +
                ", descinterface='" + descinterface + '\'' +
                ", usrresp='" + usrresp + '\'' +
                ", tipojob='" + tipojob + '\'' +
                ", usrmodif='" + usrmodif + '\'' +
                ", fechamodif='" + fechamodif + '\'' +
                ", parametroadic='" + parametroadic + '\'' +
                ", periocidad='" + periocidad + '\'' +
                ", descperiocidad='" + descperiocidad + '\'' +
                ", stsjob='" + stsjob + '\'' +
                ", cdescsts='" + cdescsts + '\'' +
                ", fecharunma='" + fecharunma + '\'' +
                ", fecsts='" + fecsts + '\'' +
                ", inddiahabil='" + inddiahabil + '\'' +
                ", fechacrea='" + fechacrea + '\'' +
                ", tipointerfaz='" + tipointerfaz + '\'' +
                ", accionjob='" + accionjob + '\'' +
                ", nombreuseresp='" + nombreuseresp + '\'' +
                ", usrcrea='" + usrcrea + '\'' +
                ", desctipo='" + desctipo + '\'' +
                ", bysegundo='" + bysegundo + '\'' +
                ", byminuto='" + byminuto + '\'' +
                ", byhora='" + byhora + '\'' +
                ", intervalo='" + intervalo + '\'' +
                ", indreproceso='" + indreproceso + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}