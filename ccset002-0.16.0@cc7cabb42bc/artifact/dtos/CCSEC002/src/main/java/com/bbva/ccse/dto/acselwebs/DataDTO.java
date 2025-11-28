package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class DataDTO implements Serializable {

    private static final long serialVersionUID = 9102101451782041638L;

    private String idProcesoExec;
    private Long cantparent;
    private String impuestoanual;
    private String totalprimaanual;
    private String totalprimaperiodica;
    private String nomcampodatos;
    private String indvetoboletin;
    private String codrev;
    private String idestmultinivel;
    private String descripcanal;
    private String identificationDigit;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private Long dateOfBirth;
    private String countryOfResidence;
    private String gender;
    private String address;
    private String age;
    private String geographicCodeDepartment;
    private String geographicCodeTown;
    private String residenceAddress;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String address6;
    private String address7;
    private String townOfResidence;
    private String departmentOfResidence;
    private String phone1;
    private String phone2;
    private String email;
    private String profession;
    private String activityEconomy;
    private String accountNumber1;
    private String accountNumber2;
    private String accountNumber3;
    private String accountNumber4;
    private String accountNumber5;
    private String accountNumber6;
    private String accountNumber7;
    private String typeIdInsured;
    private String municipalityBirth;
    private String departmentOfBirth;
    private String countryOfBirth;
    private String phoneResidence;
    private String cellResidency;
    private String occupation;
    private String codeProfession;
    private String independent;
    private String position;
    private String companyName;
    private String companyAddress;
    private String companyTelephone;
    private String companyCellPhone;
    private String destinationOriginFunds;
    private Long incomeMonthly;
    private Long expenseMonthly;
    private Long otherExpenses;
    private Long otherIncome;
    private String destinationOtherIncome;
    private Long totalAssets;
    private Long totalLiabilities;
    private String typeOfForeignCurrencyProduct;
    private String productForeignCurrencyAccount;
    private String entityForeignCurrency;
    private Long amountForeignCurrency;
    private String cityForeignCurrency;
    private String countryForeignCurrency;
    private String foreignCurrency;
    private String datesSarlaft;
    private String customerImport;
    private String investment;
    private String paymentServices;
    private String loan;
    private String customerExport;
    private String officeCode1;
    private Date openingDate1;
    private String byProduct1;
    private String accountType1;
    private String mainChannel1;
    private String officeCode2;
    private Date openingDate2;
    private String byProduct2;
    private String accountType2;
    private String mainChannel2;
    private String officeCode3;
    private Date openingDate3;
    private String byProduct3;
    private String accountType3;
    private String mainChannel3;
    private String officeCode4;
    private Date openingDate4;
    private String byProduct4;
    private String accountType4;
    private String mainChannel4;
    private String officeCode5;
    private Date openingDate5;
    private String byProduct5;
    private String accountType5;
    private String mainChannel5;
    private String officeCode6;
    private Date openingDate6;
    private String byProduct6;
    private String accountType6;
    private String mainChannel6;
    private String officeCode7;
    private Date openingDate7;
    private String byProduct7;
    private String accountType7;
    private String mainChannel7;
    private String orderBy;
    private Long pageSize;
    private String paginationKey;
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
    private String descplanprod;
    private String descprod;
    private String indafinnity;
    private String message;
    private String codofiges;
    private String checkbenefley;
    private String checkbenefoneroso;
    private String genero;
    private String apellido;
    private String nombre;
    private String codgenero;
    private String descgenero;
    private String tipooperacion;
    private String numoper;
    private String metodoreporte;
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
    private String periodicidad;
    private String sumaasegurado;
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
    private String capital;
    private String indicevariable;
    private String prima;
    private String sobreprima;
    private String extraprima;
    private String deducible;
    private String stscobert;
    private String indcobertoblig;
    private String idecobert;
    private String tasa;
    private String bbvasbr;
    private String othersbr;
    private String nosbr;
    private String clasecli;
    private String fecanul;
    private String frcinipol;
    private String tiposusc;
    private String tiposuscprod;
    private String idedirec;
    private String codtipovia;
    private String numero2;
    private String descripstatus;
    private String indasegtitular;
    private String numsolicitud;
    private String stsaseg;
    private String descexclusion;
    private String efecto;
    private String emision;
    private String cobertura;
    private String codcapital;
    private String fechaexc;
    private String stscobertura;
    private String participacion;
    private String recibo;
    private String tipoop;
    private String saldo;
    private String clave;
    private String poliza;
    private String responsabledepago;
    private String numdocumento;
    private String primabruta;
    private String numfinanc;
    private String n;
    private String retribucion;
    private String iva;
    private String reteiva;
    private String reteica;
    private String retefue;
    private String ordenpago;
    private String nrogiro;
    private String fechacobro;
    private String recpagouordpago;
    private String sldofactmoneda;
    private String nivel;
    private String codigo;
    private String clausula;
    private String anexo;
    private String ideclaucert;
    private String texto;
    private String siniestro;
    private String fnotificacion;
    private String causa;
    private String fsiniestro;
    private String fmodificacion;
    private String boton;
    private String servicio;
    private String codmodalidad;
    private String modalidad;
    private String option;
    private String customeridtype;
    private String customeridnumber;
    private String renewaltype;
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
    private String policynumberweb;
    private String customerpolicynumber;
    private List<String> sumaasegarray;
    private List<String> ocupacionarray;
    private List<String> periodicidadpagoarray;
    private List<String> planarray;
    private List<String> departamentoarray;
    private List<String> ciudadarray;
    private List<String> estratoarray;
    private List<String> anioconstruccionarray;
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
    private String fefecto;
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
    private String tnombre;
    private String ccompan;
    private String cmotivodesc;
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
    private String agente;
    private String femision;
    private String fcobro;
    private String primas;
    private String rcop;
    private String estado;
    private String treca;
    private String td;
    private String ctabarrido;
    private String rol;
    private String nit;
    private String relva;
    private String retlva;
    private String retfue;
    private String ordpago;
    private String reccaja;
    private String garantia;
    private String importa;
    private String nombrereporte;
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
    private List<String> values;
    private List<String> types;
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
    private String idbien;
    private String tipocli;
    private String apemat;
    private String descoaseguro;
    private String numpreformalizado;
    private String consecutivo;
    private String valaproxnueva;
    private String valaproxactual;
    private String codigoautoriza;
    private String codinterf;
    private String horainicio;
    private String calendario;
    private String nombrejob;

    public String getIdProcesoExec() {
        return idProcesoExec;
    }

    public void setIdProcesoExec(String idProcesoExec) {
        this.idProcesoExec = idProcesoExec;
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

    public String getIdentificationDigit() {
        return identificationDigit;
    }

    public void setIdentificationDigit(String identificationDigit) {
        this.identificationDigit = identificationDigit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGeographicCodeDepartment() {
        return geographicCodeDepartment;
    }

    public void setGeographicCodeDepartment(String geographicCodeDepartment) {
        this.geographicCodeDepartment = geographicCodeDepartment;
    }

    public String getGeographicCodeTown() {
        return geographicCodeTown;
    }

    public void setGeographicCodeTown(String geographicCodeTown) {
        this.geographicCodeTown = geographicCodeTown;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    public String getAddress6() {
        return address6;
    }

    public void setAddress6(String address6) {
        this.address6 = address6;
    }

    public String getAddress7() {
        return address7;
    }

    public void setAddress7(String address7) {
        this.address7 = address7;
    }

    public String getTownOfResidence() {
        return townOfResidence;
    }

    public void setTownOfResidence(String townOfResidence) {
        this.townOfResidence = townOfResidence;
    }

    public String getDepartmentOfResidence() {
        return departmentOfResidence;
    }

    public void setDepartmentOfResidence(String departmentOfResidence) {
        this.departmentOfResidence = departmentOfResidence;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getActivityEconomy() {
        return activityEconomy;
    }

    public void setActivityEconomy(String activityEconomy) {
        this.activityEconomy = activityEconomy;
    }

    public String getAccountNumber1() {
        return accountNumber1;
    }

    public void setAccountNumber1(String accountNumber1) {
        this.accountNumber1 = accountNumber1;
    }

    public String getAccountNumber2() {
        return accountNumber2;
    }

    public void setAccountNumber2(String accountNumber2) {
        this.accountNumber2 = accountNumber2;
    }

    public String getAccountNumber3() {
        return accountNumber3;
    }

    public void setAccountNumber3(String accountNumber3) {
        this.accountNumber3 = accountNumber3;
    }

    public String getAccountNumber4() {
        return accountNumber4;
    }

    public void setAccountNumber4(String accountNumber4) {
        this.accountNumber4 = accountNumber4;
    }

    public String getAccountNumber5() {
        return accountNumber5;
    }

    public void setAccountNumber5(String accountNumber5) {
        this.accountNumber5 = accountNumber5;
    }

    public String getAccountNumber6() {
        return accountNumber6;
    }

    public void setAccountNumber6(String accountNumber6) {
        this.accountNumber6 = accountNumber6;
    }

    public String getAccountNumber7() {
        return accountNumber7;
    }

    public void setAccountNumber7(String accountNumber7) {
        this.accountNumber7 = accountNumber7;
    }

    public String getTypeIdInsured() {
        return typeIdInsured;
    }

    public void setTypeIdInsured(String typeIdInsured) {
        this.typeIdInsured = typeIdInsured;
    }

    public String getMunicipalityBirth() {
        return municipalityBirth;
    }

    public void setMunicipalityBirth(String municipalityBirth) {
        this.municipalityBirth = municipalityBirth;
    }

    public String getDepartmentOfBirth() {
        return departmentOfBirth;
    }

    public void setDepartmentOfBirth(String departmentOfBirth) {
        this.departmentOfBirth = departmentOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getPhoneResidence() {
        return phoneResidence;
    }

    public void setPhoneResidence(String phoneResidence) {
        this.phoneResidence = phoneResidence;
    }

    public String getCellResidency() {
        return cellResidency;
    }

    public void setCellResidency(String cellResidency) {
        this.cellResidency = cellResidency;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCodeProfession() {
        return codeProfession;
    }

    public void setCodeProfession(String codeProfession) {
        this.codeProfession = codeProfession;
    }

    public String getIndependent() {
        return independent;
    }

    public void setIndependent(String independent) {
        this.independent = independent;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public String getCompanyCellPhone() {
        return companyCellPhone;
    }

    public void setCompanyCellPhone(String companyCellPhone) {
        this.companyCellPhone = companyCellPhone;
    }

    public String getDestinationOriginFunds() {
        return destinationOriginFunds;
    }

    public void setDestinationOriginFunds(String destinationOriginFunds) {
        this.destinationOriginFunds = destinationOriginFunds;
    }

    public Long getIncomeMonthly() {
        return incomeMonthly;
    }

    public void setIncomeMonthly(Long incomeMonthly) {
        this.incomeMonthly = incomeMonthly;
    }

    public Long getExpenseMonthly() {
        return expenseMonthly;
    }

    public void setExpenseMonthly(Long expenseMonthly) {
        this.expenseMonthly = expenseMonthly;
    }

    public Long getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(Long otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public Long getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(Long otherIncome) {
        this.otherIncome = otherIncome;
    }

    public String getDestinationOtherIncome() {
        return destinationOtherIncome;
    }

    public void setDestinationOtherIncome(String destinationOtherIncome) {
        this.destinationOtherIncome = destinationOtherIncome;
    }

    public Long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Long getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(Long totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public String getTypeOfForeignCurrencyProduct() {
        return typeOfForeignCurrencyProduct;
    }

    public void setTypeOfForeignCurrencyProduct(String typeOfForeignCurrencyProduct) {
        this.typeOfForeignCurrencyProduct = typeOfForeignCurrencyProduct;
    }

    public String getProductForeignCurrencyAccount() {
        return productForeignCurrencyAccount;
    }

    public void setProductForeignCurrencyAccount(String productForeignCurrencyAccount) {
        this.productForeignCurrencyAccount = productForeignCurrencyAccount;
    }

    public String getEntityForeignCurrency() {
        return entityForeignCurrency;
    }

    public void setEntityForeignCurrency(String entityForeignCurrency) {
        this.entityForeignCurrency = entityForeignCurrency;
    }

    public Long getAmountForeignCurrency() {
        return amountForeignCurrency;
    }

    public void setAmountForeignCurrency(Long amountForeignCurrency) {
        this.amountForeignCurrency = amountForeignCurrency;
    }

    public String getCityForeignCurrency() {
        return cityForeignCurrency;
    }

    public void setCityForeignCurrency(String cityForeignCurrency) {
        this.cityForeignCurrency = cityForeignCurrency;
    }

    public String getCountryForeignCurrency() {
        return countryForeignCurrency;
    }

    public void setCountryForeignCurrency(String countryForeignCurrency) {
        this.countryForeignCurrency = countryForeignCurrency;
    }

    public String getForeignCurrency() {
        return foreignCurrency;
    }

    public void setForeignCurrency(String foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }

    public String getDatesSarlaft() {
        return datesSarlaft;
    }

    public void setDatesSarlaft(String datesSarlaft) {
        this.datesSarlaft = datesSarlaft;
    }

    public String getCustomerImport() {
        return customerImport;
    }

    public void setCustomerImport(String customerImport) {
        this.customerImport = customerImport;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }

    public String getPaymentServices() {
        return paymentServices;
    }

    public void setPaymentServices(String paymentServices) {
        this.paymentServices = paymentServices;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getCustomerExport() {
        return customerExport;
    }

    public void setCustomerExport(String customerExport) {
        this.customerExport = customerExport;
    }

    public String getOfficeCode1() {
        return officeCode1;
    }

    public void setOfficeCode1(String officeCode1) {
        this.officeCode1 = officeCode1;
    }

    public Date getOpeningDate1() {
        return openingDate1;
    }

    public void setOpeningDate1(Date openingDate1) {
        this.openingDate1 = openingDate1;
    }

    public String getByProduct1() {
        return byProduct1;
    }

    public void setByProduct1(String byProduct1) {
        this.byProduct1 = byProduct1;
    }

    public String getAccountType1() {
        return accountType1;
    }

    public void setAccountType1(String accountType1) {
        this.accountType1 = accountType1;
    }

    public String getMainChannel1() {
        return mainChannel1;
    }

    public void setMainChannel1(String mainChannel1) {
        this.mainChannel1 = mainChannel1;
    }

    public String getOfficeCode2() {
        return officeCode2;
    }

    public void setOfficeCode2(String officeCode2) {
        this.officeCode2 = officeCode2;
    }

    public Date getOpeningDate2() {
        return openingDate2;
    }

    public void setOpeningDate2(Date openingDate2) {
        this.openingDate2 = openingDate2;
    }

    public String getByProduct2() {
        return byProduct2;
    }

    public void setByProduct2(String byProduct2) {
        this.byProduct2 = byProduct2;
    }

    public String getAccountType2() {
        return accountType2;
    }

    public void setAccountType2(String accountType2) {
        this.accountType2 = accountType2;
    }

    public String getMainChannel2() {
        return mainChannel2;
    }

    public void setMainChannel2(String mainChannel2) {
        this.mainChannel2 = mainChannel2;
    }

    public String getOfficeCode3() {
        return officeCode3;
    }

    public void setOfficeCode3(String officeCode3) {
        this.officeCode3 = officeCode3;
    }

    public Date getOpeningDate3() {
        return openingDate3;
    }

    public void setOpeningDate3(Date openingDate3) {
        this.openingDate3 = openingDate3;
    }

    public String getByProduct3() {
        return byProduct3;
    }

    public void setByProduct3(String byProduct3) {
        this.byProduct3 = byProduct3;
    }

    public String getAccountType3() {
        return accountType3;
    }

    public void setAccountType3(String accountType3) {
        this.accountType3 = accountType3;
    }

    public String getMainChannel3() {
        return mainChannel3;
    }

    public void setMainChannel3(String mainChannel3) {
        this.mainChannel3 = mainChannel3;
    }

    public String getOfficeCode4() {
        return officeCode4;
    }

    public void setOfficeCode4(String officeCode4) {
        this.officeCode4 = officeCode4;
    }

    public Date getOpeningDate4() {
        return openingDate4;
    }

    public void setOpeningDate4(Date openingDate4) {
        this.openingDate4 = openingDate4;
    }

    public String getByProduct4() {
        return byProduct4;
    }

    public void setByProduct4(String byProduct4) {
        this.byProduct4 = byProduct4;
    }

    public String getAccountType4() {
        return accountType4;
    }

    public void setAccountType4(String accountType4) {
        this.accountType4 = accountType4;
    }

    public String getMainChannel4() {
        return mainChannel4;
    }

    public void setMainChannel4(String mainChannel4) {
        this.mainChannel4 = mainChannel4;
    }

    public String getOfficeCode5() {
        return officeCode5;
    }

    public void setOfficeCode5(String officeCode5) {
        this.officeCode5 = officeCode5;
    }

    public Date getOpeningDate5() {
        return openingDate5;
    }

    public void setOpeningDate5(Date openingDate5) {
        this.openingDate5 = openingDate5;
    }

    public String getByProduct5() {
        return byProduct5;
    }

    public void setByProduct5(String byProduct5) {
        this.byProduct5 = byProduct5;
    }

    public String getAccountType5() {
        return accountType5;
    }

    public void setAccountType5(String accountType5) {
        this.accountType5 = accountType5;
    }

    public String getMainChannel5() {
        return mainChannel5;
    }

    public void setMainChannel5(String mainChannel5) {
        this.mainChannel5 = mainChannel5;
    }

    public String getOfficeCode6() {
        return officeCode6;
    }

    public void setOfficeCode6(String officeCode6) {
        this.officeCode6 = officeCode6;
    }

    public Date getOpeningDate6() {
        return openingDate6;
    }

    public void setOpeningDate6(Date openingDate6) {
        this.openingDate6 = openingDate6;
    }

    public String getByProduct6() {
        return byProduct6;
    }

    public void setByProduct6(String byProduct6) {
        this.byProduct6 = byProduct6;
    }

    public String getAccountType6() {
        return accountType6;
    }

    public void setAccountType6(String accountType6) {
        this.accountType6 = accountType6;
    }

    public String getMainChannel6() {
        return mainChannel6;
    }

    public void setMainChannel6(String mainChannel6) {
        this.mainChannel6 = mainChannel6;
    }

    public String getOfficeCode7() {
        return officeCode7;
    }

    public void setOfficeCode7(String officeCode7) {
        this.officeCode7 = officeCode7;
    }

    public Date getOpeningDate7() {
        return openingDate7;
    }

    public void setOpeningDate7(Date openingDate7) {
        this.openingDate7 = openingDate7;
    }

    public String getByProduct7() {
        return byProduct7;
    }

    public void setByProduct7(String byProduct7) {
        this.byProduct7 = byProduct7;
    }

    public String getAccountType7() {
        return accountType7;
    }

    public void setAccountType7(String accountType7) {
        this.accountType7 = accountType7;
    }

    public String getMainChannel7() {
        return mainChannel7;
    }

    public void setMainChannel7(String mainChannel7) {
        this.mainChannel7 = mainChannel7;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getPaginationKey() {
        return paginationKey;
    }

    public void setPaginationKey(String paginationKey) {
        this.paginationKey = paginationKey;
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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    public String getNumoper() {
        return numoper;
    }

    public void setNumoper(String numoper) {
        this.numoper = numoper;
    }

    public String getMetodoreporte() {
        return metodoreporte;
    }

    public void setMetodoreporte(String metodoreporte) {
        this.metodoreporte = metodoreporte;
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

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getSumaasegurado() {
        return sumaasegurado;
    }

    public void setSumaasegurado(String sumaasegurado) {
        this.sumaasegurado = sumaasegurado;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIndicevariable() {
        return indicevariable;
    }

    public void setIndicevariable(String indicevariable) {
        this.indicevariable = indicevariable;
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

    public String getIdecobert() {
        return idecobert;
    }

    public void setIdecobert(String idecobert) {
        this.idecobert = idecobert;
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

    public String getIdedirec() {
        return idedirec;
    }

    public void setIdedirec(String idedirec) {
        this.idedirec = idedirec;
    }

    public String getCodtipovia() {
        return codtipovia;
    }

    public void setCodtipovia(String codtipovia) {
        this.codtipovia = codtipovia;
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

    public String getIndasegtitular() {
        return indasegtitular;
    }

    public void setIndasegtitular(String indasegtitular) {
        this.indasegtitular = indasegtitular;
    }

    public String getNumsolicitud() {
        return numsolicitud;
    }

    public void setNumsolicitud(String numsolicitud) {
        this.numsolicitud = numsolicitud;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
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

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getRetribucion() {
        return retribucion;
    }

    public void setRetribucion(String retribucion) {
        this.retribucion = retribucion;
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

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
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

    public String getCustomeridnumber() {
        return customeridnumber;
    }

    public void setCustomeridnumber(String customeridnumber) {
        this.customeridnumber = customeridnumber;
    }

    public String getRenewaltype() {
        return renewaltype;
    }

    public void setRenewaltype(String renewaltype) {
        this.renewaltype = renewaltype;
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

    public String getPolicynumberweb() {
        return policynumberweb;
    }

    public void setPolicynumberweb(String policynumberweb) {
        this.policynumberweb = policynumberweb;
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

    public String getFefecto() {
        return fefecto;
    }

    public void setFefecto(String fefecto) {
        this.fefecto = fefecto;
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

    public String getTnombre() {
        return tnombre;
    }

    public void setTnombre(String tnombre) {
        this.tnombre = tnombre;
    }

    public String getCcompan() {
        return ccompan;
    }

    public void setCcompan(String ccompan) {
        this.ccompan = ccompan;
    }

    public String getCmotivodesc() {
        return cmotivodesc;
    }

    public void setCmotivodesc(String cmotivodesc) {
        this.cmotivodesc = cmotivodesc;
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

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getFemision() {
        return femision;
    }

    public void setFemision(String femision) {
        this.femision = femision;
    }

    public String getFcobro() {
        return fcobro;
    }

    public void setFcobro(String fcobro) {
        this.fcobro = fcobro;
    }

    public String getPrimas() {
        return primas;
    }

    public void setPrimas(String primas) {
        this.primas = primas;
    }

    public String getRcop() {
        return rcop;
    }

    public void setRcop(String rcop) {
        this.rcop = rcop;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTreca() {
        return treca;
    }

    public void setTreca(String treca) {
        this.treca = treca;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getNombrereporte() {
        return nombrereporte;
    }

    public void setNombrereporte(String nombrereporte) {
        this.nombrereporte = nombrereporte;
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

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
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

    public String getCodigoautoriza() {
        return codigoautoriza;
    }

    public void setCodigoautoriza(String codigoautoriza) {
        this.codigoautoriza = codigoautoriza;
    }

    public String getCodinterf() {
        return codinterf;
    }

    public void setCodinterf(String codinterf) {
        this.codinterf = codinterf;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getCalendario() {
        return calendario;
    }

    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }

    public String getNombrejob() {
        return nombrejob;
    }

    public void setNombrejob(String nombrejob) {
        this.nombrejob = nombrejob;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DataDTO dataDTO = (DataDTO) o;
        return Objects.equals(idProcesoExec, dataDTO.idProcesoExec) && Objects.equals(cantparent, dataDTO.cantparent) && Objects.equals(impuestoanual, dataDTO.impuestoanual) && Objects.equals(totalprimaanual, dataDTO.totalprimaanual) && Objects.equals(totalprimaperiodica, dataDTO.totalprimaperiodica) && Objects.equals(nomcampodatos, dataDTO.nomcampodatos) && Objects.equals(indvetoboletin, dataDTO.indvetoboletin) && Objects.equals(codrev, dataDTO.codrev) && Objects.equals(idestmultinivel, dataDTO.idestmultinivel) && Objects.equals(descripcanal, dataDTO.descripcanal) && Objects.equals(identificationDigit, dataDTO.identificationDigit) && Objects.equals(firstName, dataDTO.firstName) && Objects.equals(secondName, dataDTO.secondName) && Objects.equals(firstLastName, dataDTO.firstLastName) && Objects.equals(secondLastName, dataDTO.secondLastName) && Objects.equals(dateOfBirth, dataDTO.dateOfBirth) && Objects.equals(countryOfResidence, dataDTO.countryOfResidence) && Objects.equals(gender, dataDTO.gender) && Objects.equals(address, dataDTO.address) && Objects.equals(age, dataDTO.age) && Objects.equals(geographicCodeDepartment, dataDTO.geographicCodeDepartment) && Objects.equals(geographicCodeTown, dataDTO.geographicCodeTown) && Objects.equals(residenceAddress, dataDTO.residenceAddress) && Objects.equals(address2, dataDTO.address2) && Objects.equals(address3, dataDTO.address3) && Objects.equals(address4, dataDTO.address4) && Objects.equals(address5, dataDTO.address5) && Objects.equals(address6, dataDTO.address6) && Objects.equals(address7, dataDTO.address7) && Objects.equals(townOfResidence, dataDTO.townOfResidence) && Objects.equals(departmentOfResidence, dataDTO.departmentOfResidence) && Objects.equals(phone1, dataDTO.phone1) && Objects.equals(phone2, dataDTO.phone2) && Objects.equals(email, dataDTO.email) && Objects.equals(profession, dataDTO.profession) && Objects.equals(activityEconomy, dataDTO.activityEconomy) && Objects.equals(accountNumber1, dataDTO.accountNumber1) && Objects.equals(accountNumber2, dataDTO.accountNumber2) && Objects.equals(accountNumber3, dataDTO.accountNumber3) && Objects.equals(accountNumber4, dataDTO.accountNumber4) && Objects.equals(accountNumber5, dataDTO.accountNumber5) && Objects.equals(accountNumber6, dataDTO.accountNumber6) && Objects.equals(accountNumber7, dataDTO.accountNumber7) && Objects.equals(typeIdInsured, dataDTO.typeIdInsured) && Objects.equals(municipalityBirth, dataDTO.municipalityBirth) && Objects.equals(departmentOfBirth, dataDTO.departmentOfBirth) && Objects.equals(countryOfBirth, dataDTO.countryOfBirth) && Objects.equals(phoneResidence, dataDTO.phoneResidence) && Objects.equals(cellResidency, dataDTO.cellResidency) && Objects.equals(occupation, dataDTO.occupation) && Objects.equals(codeProfession, dataDTO.codeProfession) && Objects.equals(independent, dataDTO.independent) && Objects.equals(position, dataDTO.position) && Objects.equals(companyName, dataDTO.companyName) && Objects.equals(companyAddress, dataDTO.companyAddress) && Objects.equals(companyTelephone, dataDTO.companyTelephone) && Objects.equals(companyCellPhone, dataDTO.companyCellPhone) && Objects.equals(destinationOriginFunds, dataDTO.destinationOriginFunds) && Objects.equals(incomeMonthly, dataDTO.incomeMonthly) && Objects.equals(expenseMonthly, dataDTO.expenseMonthly) && Objects.equals(otherExpenses, dataDTO.otherExpenses) && Objects.equals(otherIncome, dataDTO.otherIncome) && Objects.equals(destinationOtherIncome, dataDTO.destinationOtherIncome) && Objects.equals(totalAssets, dataDTO.totalAssets) && Objects.equals(totalLiabilities, dataDTO.totalLiabilities) && Objects.equals(typeOfForeignCurrencyProduct, dataDTO.typeOfForeignCurrencyProduct) && Objects.equals(productForeignCurrencyAccount, dataDTO.productForeignCurrencyAccount) && Objects.equals(entityForeignCurrency, dataDTO.entityForeignCurrency) && Objects.equals(amountForeignCurrency, dataDTO.amountForeignCurrency) && Objects.equals(cityForeignCurrency, dataDTO.cityForeignCurrency) && Objects.equals(countryForeignCurrency, dataDTO.countryForeignCurrency) && Objects.equals(foreignCurrency, dataDTO.foreignCurrency) && Objects.equals(datesSarlaft, dataDTO.datesSarlaft) && Objects.equals(customerImport, dataDTO.customerImport) && Objects.equals(investment, dataDTO.investment) && Objects.equals(paymentServices, dataDTO.paymentServices) && Objects.equals(loan, dataDTO.loan) && Objects.equals(customerExport, dataDTO.customerExport) && Objects.equals(officeCode1, dataDTO.officeCode1) && Objects.equals(openingDate1, dataDTO.openingDate1) && Objects.equals(byProduct1, dataDTO.byProduct1) && Objects.equals(accountType1, dataDTO.accountType1) && Objects.equals(mainChannel1, dataDTO.mainChannel1) && Objects.equals(officeCode2, dataDTO.officeCode2) && Objects.equals(openingDate2, dataDTO.openingDate2) && Objects.equals(byProduct2, dataDTO.byProduct2) && Objects.equals(accountType2, dataDTO.accountType2) && Objects.equals(mainChannel2, dataDTO.mainChannel2) && Objects.equals(officeCode3, dataDTO.officeCode3) && Objects.equals(openingDate3, dataDTO.openingDate3) && Objects.equals(byProduct3, dataDTO.byProduct3) && Objects.equals(accountType3, dataDTO.accountType3) && Objects.equals(mainChannel3, dataDTO.mainChannel3) && Objects.equals(officeCode4, dataDTO.officeCode4) && Objects.equals(openingDate4, dataDTO.openingDate4) && Objects.equals(byProduct4, dataDTO.byProduct4) && Objects.equals(accountType4, dataDTO.accountType4) && Objects.equals(mainChannel4, dataDTO.mainChannel4) && Objects.equals(officeCode5, dataDTO.officeCode5) && Objects.equals(openingDate5, dataDTO.openingDate5) && Objects.equals(byProduct5, dataDTO.byProduct5) && Objects.equals(accountType5, dataDTO.accountType5) && Objects.equals(mainChannel5, dataDTO.mainChannel5) && Objects.equals(officeCode6, dataDTO.officeCode6) && Objects.equals(openingDate6, dataDTO.openingDate6) && Objects.equals(byProduct6, dataDTO.byProduct6) && Objects.equals(accountType6, dataDTO.accountType6) && Objects.equals(mainChannel6, dataDTO.mainChannel6) && Objects.equals(officeCode7, dataDTO.officeCode7) && Objects.equals(openingDate7, dataDTO.openingDate7) && Objects.equals(byProduct7, dataDTO.byProduct7) && Objects.equals(accountType7, dataDTO.accountType7) && Objects.equals(mainChannel7, dataDTO.mainChannel7) && Objects.equals(orderBy, dataDTO.orderBy) && Objects.equals(pageSize, dataDTO.pageSize) && Objects.equals(paginationKey, dataDTO.paginationKey) && Objects.equals(digitoIdentificacion, dataDTO.digitoIdentificacion) && Objects.equals(primerNombre, dataDTO.primerNombre) && Objects.equals(segundoNombre, dataDTO.segundoNombre) && Objects.equals(primerApellido, dataDTO.primerApellido) && Objects.equals(segundoApellido, dataDTO.segundoApellido) && Objects.equals(fechaDeNacimiento, dataDTO.fechaDeNacimiento) && Objects.equals(paisDeResidencia, dataDTO.paisDeResidencia) && Objects.equals(sexo, dataDTO.sexo) && Objects.equals(edad, dataDTO.edad) && Objects.equals(codigoGeograficoCiudad, dataDTO.codigoGeograficoCiudad) && Objects.equals(codigoGeograficoDepartamento, dataDTO.codigoGeograficoDepartamento) && Objects.equals(direccionResidencia, dataDTO.direccionResidencia) && Objects.equals(direccion2, dataDTO.direccion2) && Objects.equals(direccion3, dataDTO.direccion3) && Objects.equals(direccion4, dataDTO.direccion4) && Objects.equals(direccion5, dataDTO.direccion5) && Objects.equals(direccion6, dataDTO.direccion6) && Objects.equals(direccion7, dataDTO.direccion7) && Objects.equals(ciudadDeResidencia, dataDTO.ciudadDeResidencia) && Objects.equals(departamentoDeResidencia, dataDTO.departamentoDeResidencia) && Objects.equals(telefono1, dataDTO.telefono1) && Objects.equals(telefono2, dataDTO.telefono2) && Objects.equals(telefono3, dataDTO.telefono3) && Objects.equals(profesion, dataDTO.profesion) && Objects.equals(actividadEconomica, dataDTO.actividadEconomica) && Objects.equals(numeroCuenta1, dataDTO.numeroCuenta1) && Objects.equals(numeroCuenta2, dataDTO.numeroCuenta2) && Objects.equals(numeroCuenta3, dataDTO.numeroCuenta3) && Objects.equals(numeroCuenta4, dataDTO.numeroCuenta4) && Objects.equals(numeroCuenta5, dataDTO.numeroCuenta5) && Objects.equals(numeroCuenta6, dataDTO.numeroCuenta6) && Objects.equals(numeroCuenta7, dataDTO.numeroCuenta7) && Objects.equals(tipoIdentificacionAsegurado, dataDTO.tipoIdentificacionAsegurado) && Objects.equals(municipioDeNacimiento, dataDTO.municipioDeNacimiento) && Objects.equals(departamentoDeNacimiento, dataDTO.departamentoDeNacimiento) && Objects.equals(paisDeNacimiento, dataDTO.paisDeNacimiento) && Objects.equals(telefonoResidencia, dataDTO.telefonoResidencia) && Objects.equals(celularResidencia, dataDTO.celularResidencia) && Objects.equals(ocupacion, dataDTO.ocupacion) && Objects.equals(codigoProfesion, dataDTO.codigoProfesion) && Objects.equals(independiente, dataDTO.independiente) && Objects.equals(posicion, dataDTO.posicion) && Objects.equals(nombreEmpresa, dataDTO.nombreEmpresa) && Objects.equals(direccionEmpresa, dataDTO.direccionEmpresa) && Objects.equals(telefonoEmpresa, dataDTO.telefonoEmpresa) && Objects.equals(celularEmpresa, dataDTO.celularEmpresa) && Objects.equals(descripcionOrigenFondos, dataDTO.descripcionOrigenFondos) && Objects.equals(ingresoMensual, dataDTO.ingresoMensual) && Objects.equals(gastoMensual, dataDTO.gastoMensual) && Objects.equals(otrosGastos, dataDTO.otrosGastos) && Objects.equals(otrosIngresos, dataDTO.otrosIngresos) && Objects.equals(destinoOtrosIngresos, dataDTO.destinoOtrosIngresos) && Objects.equals(totalActivos, dataDTO.totalActivos) && Objects.equals(totalPasivos, dataDTO.totalPasivos) && Objects.equals(tipoProductoMonedaExtranjera, dataDTO.tipoProductoMonedaExtranjera) && Objects.equals(productoCuentaMonedaExtranjera, dataDTO.productoCuentaMonedaExtranjera) && Objects.equals(entidadMonedaExtranjera, dataDTO.entidadMonedaExtranjera) && Objects.equals(cantidadMonedaExtranjera, dataDTO.cantidadMonedaExtranjera) && Objects.equals(ciudadMonedaExtranjera, dataDTO.ciudadMonedaExtranjera) && Objects.equals(paisMonedaExtranjera, dataDTO.paisMonedaExtranjera) && Objects.equals(monedaExtranjera, dataDTO.monedaExtranjera) && Objects.equals(fechaSarlaft, dataDTO.fechaSarlaft) && Objects.equals(importeCliente, dataDTO.importeCliente) && Objects.equals(inversion, dataDTO.inversion) && Objects.equals(serviciosPago, dataDTO.serviciosPago) && Objects.equals(prestamo, dataDTO.prestamo) && Objects.equals(exportacionCliente, dataDTO.exportacionCliente) && Objects.equals(codigoOficina1, dataDTO.codigoOficina1) && Objects.equals(fechaApertura1, dataDTO.fechaApertura1) && Objects.equals(porProducto1, dataDTO.porProducto1) && Objects.equals(tipoCuenta1, dataDTO.tipoCuenta1) && Objects.equals(canalPrincipal1, dataDTO.canalPrincipal1) && Objects.equals(codigoOficina2, dataDTO.codigoOficina2) && Objects.equals(fechaApertura2, dataDTO.fechaApertura2) && Objects.equals(porProducto2, dataDTO.porProducto2) && Objects.equals(tipoCuenta2, dataDTO.tipoCuenta2) && Objects.equals(canalPrincipal2, dataDTO.canalPrincipal2) && Objects.equals(codigoOficina3, dataDTO.codigoOficina3) && Objects.equals(fechaApertura3, dataDTO.fechaApertura3) && Objects.equals(porProducto3, dataDTO.porProducto3) && Objects.equals(tipoCuenta3, dataDTO.tipoCuenta3) && Objects.equals(canalPrincipal3, dataDTO.canalPrincipal3) && Objects.equals(codigoOficina4, dataDTO.codigoOficina4) && Objects.equals(fechaApertura4, dataDTO.fechaApertura4) && Objects.equals(porProducto4, dataDTO.porProducto4) && Objects.equals(tipoCuenta4, dataDTO.tipoCuenta4) && Objects.equals(canalPrincipal4, dataDTO.canalPrincipal4) && Objects.equals(codigoOficina5, dataDTO.codigoOficina5) && Objects.equals(fechaApertura5, dataDTO.fechaApertura5) && Objects.equals(porProducto5, dataDTO.porProducto5) && Objects.equals(tipoCuenta5, dataDTO.tipoCuenta5) && Objects.equals(canalPrincipal5, dataDTO.canalPrincipal5) && Objects.equals(codigoOficina6, dataDTO.codigoOficina6) && Objects.equals(fechaApertura6, dataDTO.fechaApertura6) && Objects.equals(porProducto6, dataDTO.porProducto6) && Objects.equals(tipoCuenta6, dataDTO.tipoCuenta6) && Objects.equals(canalPrincipal6, dataDTO.canalPrincipal6) && Objects.equals(codigoOficina7, dataDTO.codigoOficina7) && Objects.equals(fechaApertura7, dataDTO.fechaApertura7) && Objects.equals(porProducto7, dataDTO.porProducto7) && Objects.equals(tipoCuenta7, dataDTO.tipoCuenta7) && Objects.equals(canalPrincipal7, dataDTO.canalPrincipal7) && Objects.equals(textofinal, dataDTO.textofinal) && Objects.equals(textopreg, dataDTO.textopreg) && Objects.equals(orden, dataDTO.orden) && Objects.equals(indstop, dataDTO.indstop) && Objects.equals(msgsi, dataDTO.msgsi) && Objects.equals(msgno, dataDTO.msgno) && Objects.equals(cuentasdisponibles, dataDTO.cuentasdisponibles) && Objects.equals(renovacionautomatica, dataDTO.renovacionautomatica) && Objects.equals(mediospago, dataDTO.mediospago) && Objects.equals(tipogenero, dataDTO.tipogenero) && Objects.equals(descripciongenero, dataDTO.descripciongenero) && Objects.equals(idgenero, dataDTO.idgenero) && Objects.equals(valueCheckIndem, dataDTO.valueCheckIndem) && Objects.equals(valueCheckReclamo, dataDTO.valueCheckReclamo) && Objects.equals(valor, dataDTO.valor) && Objects.equals(compania, dataDTO.compania) && Objects.equals(ramo, dataDTO.ramo) && Objects.equals(anio, dataDTO.anio) && Objects.equals(ideaseg, dataDTO.ideaseg) && Objects.equals(actividad, dataDTO.actividad) && Objects.equals(infoadic, dataDTO.infoadic) && Objects.equals(numplaca, dataDTO.numplaca) && Objects.equals(numpisos, dataDTO.numpisos) && Objects.equals(indbis2, dataDTO.indbis2) && Objects.equals(literal2, dataDTO.literal2) && Objects.equals(indbis1, dataDTO.indbis1) && Objects.equals(literal, dataDTO.literal) && Objects.equals(estructura, dataDTO.estructura) && Objects.equals(tipopropiedad, dataDTO.tipopropiedad) && Objects.equals(tipoinmueble, dataDTO.tipoinmueble) && Objects.equals(tipovia, dataDTO.tipovia) && Objects.equals(tipoter, dataDTO.tipoter) && Objects.equals(zip, dataDTO.zip) && Objects.equals(piso, dataDTO.piso) && Objects.equals(tipoestructura, dataDTO.tipoestructura) && Objects.equals(tiporiesgo, dataDTO.tiporiesgo) && Objects.equals(codorientacion2, dataDTO.codorientacion2) && Objects.equals(codorientacion, dataDTO.codorientacion) && Objects.equals(dirvalinterseccion, dataDTO.dirvalinterseccion) && Objects.equals(codcalle, dataDTO.codcalle) && Objects.equals(numero, dataDTO.numero) && Objects.equals(coddepartamento, dataDTO.coddepartamento) && Objects.equals(codgrpusr, dataDTO.codgrpusr) && Objects.equals(codprod, dataDTO.codprod) && Objects.equals(codusr, dataDTO.codusr) && Objects.equals(codplan, dataDTO.codplan) && Objects.equals(revplan, dataDTO.revplan) && Objects.equals(codcanal, dataDTO.codcanal) && Objects.equals(codsubcanal, dataDTO.codsubcanal) && Objects.equals(codlval, dataDTO.codlval) && Objects.equals(tipolval, dataDTO.tipolval) && Objects.equals(tipoid, dataDTO.tipoid) && Objects.equals(numid, dataDTO.numid) && Objects.equals(codcli, dataDTO.codcli) && Objects.equals(idepol, dataDTO.idepol) && Objects.equals(numpol, dataDTO.numpol) && Objects.equals(stspol, dataDTO.stspol) && Objects.equals(stssin, dataDTO.stssin) && Objects.equals(sumaAseg, dataDTO.sumaAseg) && Objects.equals(periodicidadPago, dataDTO.periodicidadPago) && Objects.equals(departamento, dataDTO.departamento) && Objects.equals(ciudad, dataDTO.ciudad) && Objects.equals(anioConstruccion, dataDTO.anioConstruccion) && Objects.equals(nomter, dataDTO.nomter) && Objects.equals(apeter, dataDTO.apeter) && Objects.equals(dvid, dataDTO.dvid) && Objects.equals(direccion, dataDTO.direccion) && Objects.equals(fecnac, dataDTO.fecnac) && Objects.equals(descrip, dataDTO.descrip) && Objects.equals(codpais, dataDTO.codpais) && Objects.equals(indben, dataDTO.indben) && Objects.equals(indcobert, dataDTO.indcobert) && Objects.equals(stscert, dataDTO.stscert) && Objects.equals(fecinivig, dataDTO.fecinivig) && Objects.equals(fecfinvig, dataDTO.fecfinvig) && Objects.equals(codestado, dataDTO.codestado) && Objects.equals(descestado, dataDTO.descestado) && Objects.equals(zonageografica, dataDTO.zonageografica) && Objects.equals(descciudad, dataDTO.descciudad) && Objects.equals(codciudad, dataDTO.codciudad) && Objects.equals(estrato, dataDTO.estrato) && Objects.equals(codramocert, dataDTO.codramocert) && Objects.equals(numcot, dataDTO.numcot) && Objects.equals(idecotiza, dataDTO.idecotiza) && Objects.equals(clasebien, dataDTO.clasebien) && Objects.equals(codbien, dataDTO.codbien) && Objects.equals(descbien, dataDTO.descbien) && Objects.equals(montobien, dataDTO.montobien) && Objects.equals(ideclau, dataDTO.ideclau) && Objects.equals(descclau, dataDTO.descclau) && Objects.equals(parentesco, dataDTO.parentesco) && Objects.equals(codparentesco, dataDTO.codparentesco) && Objects.equals(nomben, dataDTO.nomben) && Objects.equals(numben, dataDTO.numben) && Objects.equals(idaseg, dataDTO.idaseg) && Objects.equals(porcpart, dataDTO.porcpart) && Objects.equals(grupopol, dataDTO.grupopol) && Objects.equals(numcanttc, dataDTO.numcanttc) && Objects.equals(induserasis, dataDTO.induserasis) && Objects.equals(indasegadic, dataDTO.indasegadic) && Objects.equals(tipotomador, dataDTO.tipotomador) && Objects.equals(codmunicipio, dataDTO.codmunicipio) && Objects.equals(municipio, dataDTO.municipio) && Objects.equals(numordimp, dataDTO.numordimp) && Objects.equals(pais, dataDTO.pais) && Objects.equals(codcobert, dataDTO.codcobert) && Objects.equals(desccobert, dataDTO.desccobert) && Objects.equals(porcreca, dataDTO.porcreca) && Objects.equals(nomusr, dataDTO.nomusr) && Objects.equals(codsuc, dataDTO.codsuc) && Objects.equals(codcia, dataDTO.codcia) && Objects.equals(codgrppol, dataDTO.codgrppol) && Objects.equals(desccanal, dataDTO.desccanal) && Objects.equals(descsubcanal, dataDTO.descsubcanal) && Objects.equals(codofibanc, dataDTO.codofibanc) && Objects.equals(idesmultinivel, dataDTO.idesmultinivel) && Objects.equals(nomest, dataDTO.nomest) && Objects.equals(desclval, dataDTO.desclval) && Objects.equals(numcert, dataDTO.numcert) && Objects.equals(indcargabdacsel, dataDTO.indcargabdacsel) && Objects.equals(indcontproc, dataDTO.indcontproc) && Objects.equals(nomtabla, dataDTO.nomtabla) && Objects.equals(desccampo, dataDTO.desccampo) && Objects.equals(blkweb, dataDTO.blkweb) && Objects.equals(ordenblkweb, dataDTO.ordenblkweb) && Objects.equals(indtipodato, dataDTO.indtipodato) && Objects.equals(isfixed, dataDTO.isfixed) && Objects.equals(panelkey, dataDTO.panelkey) && Objects.equals(ordensubpanel, dataDTO.ordensubpanel) && Objects.equals(iseditable, dataDTO.iseditable) && Objects.equals(isrequired, dataDTO.isrequired) && Objects.equals(afectacampo, dataDTO.afectacampo) && Objects.equals(typepresenter, dataDTO.typepresenter) && Objects.equals(tarjetasaseguradas, dataDTO.tarjetasaseguradas) && Objects.equals(idSessionExec, dataDTO.idSessionExec) && Objects.equals(descplanprod, dataDTO.descplanprod) && Objects.equals(descprod, dataDTO.descprod) && Objects.equals(indafinnity, dataDTO.indafinnity) && Objects.equals(message, dataDTO.message) && Objects.equals(codofiges, dataDTO.codofiges) && Objects.equals(checkbenefley, dataDTO.checkbenefley) && Objects.equals(checkbenefoneroso, dataDTO.checkbenefoneroso) && Objects.equals(genero, dataDTO.genero) && Objects.equals(apellido, dataDTO.apellido) && Objects.equals(nombre, dataDTO.nombre) && Objects.equals(codgenero, dataDTO.codgenero) && Objects.equals(descgenero, dataDTO.descgenero) && Objects.equals(tipooperacion, dataDTO.tipooperacion) && Objects.equals(numoper, dataDTO.numoper) && Objects.equals(metodoreporte, dataDTO.metodoreporte) && Objects.equals(apuntamiento, dataDTO.apuntamiento) && Objects.equals(id, dataDTO.id) && Objects.equals(helptopicid, dataDTO.helptopicid) && Objects.equals(apeben, dataDTO.apeben) && Objects.equals(gobalcondlaboral, dataDTO.gobalcondlaboral) && Objects.equals(method, dataDTO.method) && Objects.equals(text, dataDTO.text) && Objects.equals(bean, dataDTO.bean) && Objects.equals(selected, dataDTO.selected) && Objects.equals(codarea, dataDTO.codarea) && Objects.equals(stsprod, dataDTO.stsprod) && Objects.equals(idpolcot, dataDTO.idpolcot) && Objects.equals(numctto, dataDTO.numctto) && Objects.equals(stscot, dataDTO.stscot) && Objects.equals(fecsolic, dataDTO.fecsolic) && Objects.equals(proveedor, dataDTO.proveedor) && Objects.equals(territorial, dataDTO.territorial) && Objects.equals(zona, dataDTO.zona) && Objects.equals(sucursal, dataDTO.sucursal) && Objects.equals(fecren, dataDTO.fecren) && Objects.equals(fecfin, dataDTO.fecfin) && Objects.equals(fecing, dataDTO.fecing) && Objects.equals(formpago, dataDTO.formpago) && Objects.equals(cnumcot, dataDTO.cnumcot) && Objects.equals(pnumcot, dataDTO.pnumcot) && Objects.equals(ciuedo, dataDTO.ciuedo) && Objects.equals(cuotacamp, dataDTO.cuotacamp) && Objects.equals(porccamp, dataDTO.porccamp) && Objects.equals(idecamp, dataDTO.idecamp) && Objects.equals(utilidad, dataDTO.utilidad) && Objects.equals(plan, dataDTO.plan) && Objects.equals(codmoneda, dataDTO.codmoneda) && Objects.equals(primaadic, dataDTO.primaadic) && Objects.equals(primagf, dataDTO.primagf) && Objects.equals(cantidad, dataDTO.cantidad) && Objects.equals(codparent, dataDTO.codparent) && Objects.equals(codramoplan, dataDTO.codramoplan) && Objects.equals(emailarray, dataDTO.emailarray) && Objects.equals(direccionresidenciarray, dataDTO.direccionresidenciarray) && Objects.equals(direccioncorrespondencia, dataDTO.direccioncorrespondencia) && Objects.equals(telefono3Array, dataDTO.telefono3Array) && Objects.equals(telefono2Array, dataDTO.telefono2Array) && Objects.equals(telefono1Array, dataDTO.telefono1Array) && Objects.equals(codmediopago, dataDTO.codmediopago) && Objects.equals(descmediopago, dataDTO.descmediopago) && Objects.equals(indbenefone, dataDTO.indbenefone) && Objects.equals(induseasis, dataDTO.induseasis) && Objects.equals(benfone, dataDTO.benfone) && Objects.equals(useasis, dataDTO.useasis) && Objects.equals(filtro, dataDTO.filtro) && Objects.equals(documento, dataDTO.documento) && Objects.equals(fechaini, dataDTO.fechaini) && Objects.equals(fechafin, dataDTO.fechafin) && Objects.equals(status, dataDTO.status) && Objects.equals(numcertini, dataDTO.numcertini) && Objects.equals(numcertfin, dataDTO.numcertfin) && Objects.equals(codformpago, dataDTO.codformpago) && Objects.equals(codofiemi, dataDTO.codofiemi) && Objects.equals(fecinipol, dataDTO.fecinipol) && Objects.equals(fechainicio, dataDTO.fechainicio) && Objects.equals(fechfecoper, dataDTO.fechfecoper) && Objects.equals(compnumpol, dataDTO.compnumpol) && Objects.equals(fecoper, dataDTO.fecoper) && Objects.equals(codgestor, dataDTO.codgestor) && Objects.equals(codofisusc, dataDTO.codofisusc) && Objects.equals(motivo, dataDTO.motivo) && Objects.equals(gestor, dataDTO.gestor) && Objects.equals(fecexc, dataDTO.fecexc) && Objects.equals(fechainipol, dataDTO.fechainipol) && Objects.equals(fecfincotiza, dataDTO.fecfincotiza) && Objects.equals(nompercotiza, dataDTO.nompercotiza) && Objects.equals(idcliente, dataDTO.idcliente) && Objects.equals(codperiodicpago, dataDTO.codperiodicpago) && Objects.equals(cotestado, dataDTO.cotestado) && Objects.equals(indrenauto, dataDTO.indrenauto) && Objects.equals(direc, dataDTO.direc) && Objects.equals(codsuplemento, dataDTO.codsuplemento) && Objects.equals(suplemento, dataDTO.suplemento) && Objects.equals(codmotivo, dataDTO.codmotivo) && Objects.equals(codsubmotivo, dataDTO.codsubmotivo) && Objects.equals(submotivo, dataDTO.submotivo) && Objects.equals(fechasuplemento, dataDTO.fechasuplemento) && Objects.equals(includemode, dataDTO.includemode) && Objects.equals(primaperi, dataDTO.primaperi) && Objects.equals(primaperidica, dataDTO.primaperidica) && Objects.equals(primaanual, dataDTO.primaanual) && Objects.equals(coaseguro, dataDTO.coaseguro) && Objects.equals(periodicidad, dataDTO.periodicidad) && Objects.equals(sumaasegurado, dataDTO.sumaasegurado) && Objects.equals(direccioncorr, dataDTO.direccioncorr) && Objects.equals(direccionres, dataDTO.direccionres) && Objects.equals(tipocuenta, dataDTO.tipocuenta) && Objects.equals(celular, dataDTO.celular) && Objects.equals(checkrenauto, dataDTO.checkrenauto) && Objects.equals(cambiorenauto, dataDTO.cambiorenauto) && Objects.equals(codexclusion, dataDTO.codexclusion) && Objects.equals(motivoexclusion, dataDTO.motivoexclusion) && Objects.equals(observacion, dataDTO.observacion) && Objects.equals(codramo, dataDTO.codramo) && Objects.equals(capital, dataDTO.capital) && Objects.equals(indicevariable, dataDTO.indicevariable) && Objects.equals(prima, dataDTO.prima) && Objects.equals(sobreprima, dataDTO.sobreprima) && Objects.equals(extraprima, dataDTO.extraprima) && Objects.equals(deducible, dataDTO.deducible) && Objects.equals(stscobert, dataDTO.stscobert) && Objects.equals(indcobertoblig, dataDTO.indcobertoblig) && Objects.equals(idecobert, dataDTO.idecobert) && Objects.equals(tasa, dataDTO.tasa) && Objects.equals(bbvasbr, dataDTO.bbvasbr) && Objects.equals(othersbr, dataDTO.othersbr) && Objects.equals(nosbr, dataDTO.nosbr) && Objects.equals(clasecli, dataDTO.clasecli) && Objects.equals(fecanul, dataDTO.fecanul) && Objects.equals(frcinipol, dataDTO.frcinipol) && Objects.equals(tiposusc, dataDTO.tiposusc) && Objects.equals(tiposuscprod, dataDTO.tiposuscprod) && Objects.equals(idedirec, dataDTO.idedirec) && Objects.equals(codtipovia, dataDTO.codtipovia) && Objects.equals(numero2, dataDTO.numero2) && Objects.equals(descripstatus, dataDTO.descripstatus) && Objects.equals(indasegtitular, dataDTO.indasegtitular) && Objects.equals(numsolicitud, dataDTO.numsolicitud) && Objects.equals(stsaseg, dataDTO.stsaseg) && Objects.equals(descexclusion, dataDTO.descexclusion) && Objects.equals(efecto, dataDTO.efecto) && Objects.equals(emision, dataDTO.emision) && Objects.equals(cobertura, dataDTO.cobertura) && Objects.equals(codcapital, dataDTO.codcapital) && Objects.equals(fechaexc, dataDTO.fechaexc) && Objects.equals(stscobertura, dataDTO.stscobertura) && Objects.equals(participacion, dataDTO.participacion) && Objects.equals(recibo, dataDTO.recibo) && Objects.equals(tipoop, dataDTO.tipoop) && Objects.equals(saldo, dataDTO.saldo) && Objects.equals(clave, dataDTO.clave) && Objects.equals(poliza, dataDTO.poliza) && Objects.equals(responsabledepago, dataDTO.responsabledepago) && Objects.equals(numdocumento, dataDTO.numdocumento) && Objects.equals(primabruta, dataDTO.primabruta) && Objects.equals(numfinanc, dataDTO.numfinanc) && Objects.equals(n, dataDTO.n) && Objects.equals(retribucion, dataDTO.retribucion) && Objects.equals(iva, dataDTO.iva) && Objects.equals(reteiva, dataDTO.reteiva) && Objects.equals(reteica, dataDTO.reteica) && Objects.equals(retefue, dataDTO.retefue) && Objects.equals(ordenpago, dataDTO.ordenpago) && Objects.equals(nrogiro, dataDTO.nrogiro) && Objects.equals(fechacobro, dataDTO.fechacobro) && Objects.equals(recpagouordpago, dataDTO.recpagouordpago) && Objects.equals(sldofactmoneda, dataDTO.sldofactmoneda) && Objects.equals(nivel, dataDTO.nivel) && Objects.equals(codigo, dataDTO.codigo) && Objects.equals(clausula, dataDTO.clausula) && Objects.equals(anexo, dataDTO.anexo) && Objects.equals(ideclaucert, dataDTO.ideclaucert) && Objects.equals(texto, dataDTO.texto) && Objects.equals(siniestro, dataDTO.siniestro) && Objects.equals(fnotificacion, dataDTO.fnotificacion) && Objects.equals(causa, dataDTO.causa) && Objects.equals(fsiniestro, dataDTO.fsiniestro) && Objects.equals(fmodificacion, dataDTO.fmodificacion) && Objects.equals(boton, dataDTO.boton) && Objects.equals(servicio, dataDTO.servicio) && Objects.equals(codmodalidad, dataDTO.codmodalidad) && Objects.equals(modalidad, dataDTO.modalidad) && Objects.equals(option, dataDTO.option) && Objects.equals(customeridtype, dataDTO.customeridtype) && Objects.equals(customeridnumber, dataDTO.customeridnumber) && Objects.equals(renewaltype, dataDTO.renewaltype) && Objects.equals(policystatus, dataDTO.policystatus) && Objects.equals(paymentperiod, dataDTO.paymentperiod) && Objects.equals(effectivestartdate, dataDTO.effectivestartdate) && Objects.equals(renewaldate, dataDTO.renewaldate) && Objects.equals(directdebitaccount, dataDTO.directdebitaccount) && Objects.equals(insuredvalue, dataDTO.insuredvalue) && Objects.equals(managementoffice, dataDTO.managementoffice) && Objects.equals(insuranceproductcode, dataDTO.insuranceproductcode) && Objects.equals(usermanagingpolicy, dataDTO.usermanagingpolicy) && Objects.equals(operationdate, dataDTO.operationdate) && Objects.equals(premiumamount, dataDTO.premiumamount) && Objects.equals(altamiraaccountnumber, dataDTO.altamiraaccountnumber) && Objects.equals(paymentreference, dataDTO.paymentreference) && Objects.equals(amountvalue, dataDTO.amountvalue) && Objects.equals(operationtime, dataDTO.operationtime) && Objects.equals(userresponsible, dataDTO.userresponsible) && Objects.equals(description, dataDTO.description) && Objects.equals(policynumberweb, dataDTO.policynumberweb) && Objects.equals(customerpolicynumber, dataDTO.customerpolicynumber) && Objects.equals(sumaasegarray, dataDTO.sumaasegarray) && Objects.equals(ocupacionarray, dataDTO.ocupacionarray) && Objects.equals(periodicidadpagoarray, dataDTO.periodicidadpagoarray) && Objects.equals(planarray, dataDTO.planarray) && Objects.equals(departamentoarray, dataDTO.departamentoarray) && Objects.equals(ciudadarray, dataDTO.ciudadarray) && Objects.equals(estratoarray, dataDTO.estratoarray) && Objects.equals(anioconstruccionarray, dataDTO.anioconstruccionarray) && Objects.equals(dni, dataDTO.dni) && Objects.equals(descdni, dataDTO.descdni) && Objects.equals(tipofecha, dataDTO.tipofecha) && Objects.equals(certificadoinicial, dataDTO.certificadoinicial) && Objects.equals(certificadofinal, dataDTO.certificadofinal) && Objects.equals(producto, dataDTO.producto) && Objects.equals(oper, dataDTO.oper) && Objects.equals(tproduc, dataDTO.tproduc) && Objects.equals(cpoliza, dataDTO.cpoliza) && Objects.equals(tpoliza, dataDTO.tpoliza) && Objects.equals(bmodpag, dataDTO.bmodpag) && Objects.equals(fefecto, dataDTO.fefecto) && Objects.equals(cperson, dataDTO.cperson) && Objects.equals(tdninit, dataDTO.tdninit) && Objects.equals(tapell1, dataDTO.tapell1) && Objects.equals(tapell2, dataDTO.tapell2) && Objects.equals(nombre1, dataDTO.nombre1) && Objects.equals(bestado, dataDTO.bestado) && Objects.equals(cproduc, dataDTO.cproduc) && Objects.equals(trotulo1, dataDTO.trotulo1) && Objects.equals(cmodali, dataDTO.cmodali) && Objects.equals(nvermod, dataDTO.nvermod) && Objects.equals(trotulo2, dataDTO.trotulo2) && Objects.equals(coficin, dataDTO.coficin) && Objects.equals(tnombre, dataDTO.tnombre) && Objects.equals(ccompan, dataDTO.ccompan) && Objects.equals(cmotivodesc, dataDTO.cmotivodesc) && Objects.equals(nmovimi, dataDTO.nmovimi) && Objects.equals(btipmov, dataDTO.btipmov) && Objects.equals(femisio, dataDTO.femisio) && Objects.equals(cmotivo, dataDTO.cmotivo) && Objects.equals(crecibo, dataDTO.crecibo) && Objects.equals(tusuari, dataDTO.tusuari) && Objects.equals(ttermin, dataDTO.ttermin) && Objects.equals(nhormov, dataDTO.nhormov) && Objects.equals(nanexos, dataDTO.nanexos) && Objects.equals(bmotivo, dataDTO.bmotivo) && Objects.equals(brepalt, dataDTO.brepalt) && Objects.equals(tipogarantia, dataDTO.tipogarantia) && Objects.equals(amparo, dataDTO.amparo) && Objects.equals(tipo, dataDTO.tipo) && Objects.equals(agente, dataDTO.agente) && Objects.equals(femision, dataDTO.femision) && Objects.equals(fcobro, dataDTO.fcobro) && Objects.equals(primas, dataDTO.primas) && Objects.equals(rcop, dataDTO.rcop) && Objects.equals(estado, dataDTO.estado) && Objects.equals(treca, dataDTO.treca) && Objects.equals(td, dataDTO.td) && Objects.equals(ctabarrido, dataDTO.ctabarrido) && Objects.equals(rol, dataDTO.rol) && Objects.equals(nit, dataDTO.nit) && Objects.equals(relva, dataDTO.relva) && Objects.equals(retlva, dataDTO.retlva) && Objects.equals(retfue, dataDTO.retfue) && Objects.equals(ordpago, dataDTO.ordpago) && Objects.equals(reccaja, dataDTO.reccaja) && Objects.equals(garantia, dataDTO.garantia) && Objects.equals(importa, dataDTO.importa) && Objects.equals(nombrereporte, dataDTO.nombrereporte) && Objects.equals(indacsel, dataDTO.indacsel) && Objects.equals(indefront, dataDTO.indefront) && Objects.equals(indaplus, dataDTO.indaplus) && Objects.equals(cliente, dataDTO.cliente) && Objects.equals(beneficiario, dataDTO.beneficiario) && Objects.equals(certificado, dataDTO.certificado) && Objects.equals(retribuciones, dataDTO.retribuciones) && Objects.equals(agentes, dataDTO.agentes) && Objects.equals(garantias, dataDTO.garantias) && Objects.equals(bienes, dataDTO.bienes) && Objects.equals(recibos, dataDTO.recibos) && Objects.equals(autorizaciones, dataDTO.autorizaciones) && Objects.equals(clausulas, dataDTO.clausulas) && Objects.equals(codval, dataDTO.codval) && Objects.equals(tipoparam, dataDTO.tipoparam) && Objects.equals(codparam, dataDTO.codparam) && Objects.equals(descparam, dataDTO.descparam) && Objects.equals(refparam, dataDTO.refparam) && Objects.equals(codsql, dataDTO.codsql) && Objects.equals(totalregs, dataDTO.totalregs) && Objects.equals(values, dataDTO.values) && Objects.equals(types, dataDTO.types) && Objects.equals(stsbien, dataDTO.stsbien) && Objects.equals(additionalinfo, dataDTO.additionalinfo) && Objects.equals(codocupac, dataDTO.codocupac) && Objects.equals(fechaefecto, dataDTO.fechaefecto) && Objects.equals(fechaemision, dataDTO.fechaemision) && Objects.equals(porcpago, dataDTO.porcpago) && Objects.equals(descripcion, dataDTO.descripcion) && Objects.equals(mediodepago, dataDTO.mediodepago) && Objects.equals(barridodecuenta, dataDTO.barridodecuenta) && Objects.equals(cancelacionsaldos, dataDTO.cancelacionsaldos) && Objects.equals(idbien, dataDTO.idbien) && Objects.equals(tipocli, dataDTO.tipocli) && Objects.equals(apemat, dataDTO.apemat) && Objects.equals(descoaseguro, dataDTO.descoaseguro) && Objects.equals(numpreformalizado, dataDTO.numpreformalizado) && Objects.equals(consecutivo, dataDTO.consecutivo) && Objects.equals(valaproxnueva, dataDTO.valaproxnueva) && Objects.equals(valaproxactual, dataDTO.valaproxactual) && Objects.equals(codigoautoriza, dataDTO.codigoautoriza) && Objects.equals(codinterf, dataDTO.codinterf) && Objects.equals(horainicio, dataDTO.horainicio) && Objects.equals(calendario, dataDTO.calendario) && Objects.equals(nombrejob, dataDTO.nombrejob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProcesoExec, cantparent, impuestoanual, totalprimaanual, totalprimaperiodica, nomcampodatos, indvetoboletin, codrev, idestmultinivel, descripcanal, identificationDigit, firstName, secondName, firstLastName, secondLastName, dateOfBirth, countryOfResidence, gender, address, age, geographicCodeDepartment, geographicCodeTown, residenceAddress, address2, address3, address4, address5, address6, address7, townOfResidence, departmentOfResidence, phone1, phone2, email, profession, activityEconomy, accountNumber1, accountNumber2, accountNumber3, accountNumber4, accountNumber5, accountNumber6, accountNumber7, typeIdInsured, municipalityBirth, departmentOfBirth, countryOfBirth, phoneResidence, cellResidency, occupation, codeProfession, independent, position, companyName, companyAddress, companyTelephone, companyCellPhone, destinationOriginFunds, incomeMonthly, expenseMonthly, otherExpenses, otherIncome, destinationOtherIncome, totalAssets, totalLiabilities, typeOfForeignCurrencyProduct, productForeignCurrencyAccount, entityForeignCurrency, amountForeignCurrency, cityForeignCurrency, countryForeignCurrency, foreignCurrency, datesSarlaft, customerImport, investment, paymentServices, loan, customerExport, officeCode1, openingDate1, byProduct1, accountType1, mainChannel1, officeCode2, openingDate2, byProduct2, accountType2, mainChannel2, officeCode3, openingDate3, byProduct3, accountType3, mainChannel3, officeCode4, openingDate4, byProduct4, accountType4, mainChannel4, officeCode5, openingDate5, byProduct5, accountType5, mainChannel5, officeCode6, openingDate6, byProduct6, accountType6, mainChannel6, officeCode7, openingDate7, byProduct7, accountType7, mainChannel7, orderBy, pageSize, paginationKey, digitoIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaDeNacimiento, paisDeResidencia, sexo, edad, codigoGeograficoCiudad, codigoGeograficoDepartamento, direccionResidencia, direccion2, direccion3, direccion4, direccion5, direccion6, direccion7, ciudadDeResidencia, departamentoDeResidencia, telefono1, telefono2, telefono3, profesion, actividadEconomica, numeroCuenta1, numeroCuenta2, numeroCuenta3, numeroCuenta4, numeroCuenta5, numeroCuenta6, numeroCuenta7, tipoIdentificacionAsegurado, municipioDeNacimiento, departamentoDeNacimiento, paisDeNacimiento, telefonoResidencia, celularResidencia, ocupacion, codigoProfesion, independiente, posicion, nombreEmpresa, direccionEmpresa, telefonoEmpresa, celularEmpresa, descripcionOrigenFondos, ingresoMensual, gastoMensual, otrosGastos, otrosIngresos, destinoOtrosIngresos, totalActivos, totalPasivos, tipoProductoMonedaExtranjera, productoCuentaMonedaExtranjera, entidadMonedaExtranjera, cantidadMonedaExtranjera, ciudadMonedaExtranjera, paisMonedaExtranjera, monedaExtranjera, fechaSarlaft, importeCliente, inversion, serviciosPago, prestamo, exportacionCliente, codigoOficina1, fechaApertura1, porProducto1, tipoCuenta1, canalPrincipal1, codigoOficina2, fechaApertura2, porProducto2, tipoCuenta2, canalPrincipal2, codigoOficina3, fechaApertura3, porProducto3, tipoCuenta3, canalPrincipal3, codigoOficina4, fechaApertura4, porProducto4, tipoCuenta4, canalPrincipal4, codigoOficina5, fechaApertura5, porProducto5, tipoCuenta5, canalPrincipal5, codigoOficina6, fechaApertura6, porProducto6, tipoCuenta6, canalPrincipal6, codigoOficina7, fechaApertura7, porProducto7, tipoCuenta7, canalPrincipal7, textofinal, textopreg, orden, indstop, msgsi, msgno, cuentasdisponibles, renovacionautomatica, mediospago, tipogenero, descripciongenero, idgenero, valueCheckIndem, valueCheckReclamo, valor, compania, ramo, anio, ideaseg, actividad, infoadic, numplaca, numpisos, indbis2, literal2, indbis1, literal, estructura, tipopropiedad, tipoinmueble, tipovia, tipoter, zip, piso, tipoestructura, tiporiesgo, codorientacion2, codorientacion, dirvalinterseccion, codcalle, numero, coddepartamento, codgrpusr, codprod, codusr, codplan, revplan, codcanal, codsubcanal, codlval, tipolval, tipoid, numid, codcli, idepol, numpol, stspol, stssin, sumaAseg, periodicidadPago, departamento, ciudad, anioConstruccion, nomter, apeter, dvid, direccion, fecnac, descrip, codpais, indben, indcobert, stscert, fecinivig, fecfinvig, codestado, descestado, zonageografica, descciudad, codciudad, estrato, codramocert, numcot, idecotiza, clasebien, codbien, descbien, montobien, ideclau, descclau, parentesco, codparentesco, nomben, numben, idaseg, porcpart, grupopol, numcanttc, induserasis, indasegadic, tipotomador, codmunicipio, municipio, numordimp, pais, codcobert, desccobert, porcreca, nomusr, codsuc, codcia, codgrppol, desccanal, descsubcanal, codofibanc, idesmultinivel, nomest, desclval, numcert, indcargabdacsel, indcontproc, nomtabla, desccampo, blkweb, ordenblkweb, indtipodato, isfixed, panelkey, ordensubpanel, iseditable, isrequired, afectacampo, typepresenter, tarjetasaseguradas, idSessionExec, descplanprod, descprod, indafinnity, message, codofiges, checkbenefley, checkbenefoneroso, genero, apellido, nombre, codgenero, descgenero, tipooperacion, numoper, metodoreporte, apuntamiento, id, helptopicid, apeben, gobalcondlaboral, method, text, bean, selected, codarea, stsprod, idpolcot, numctto, stscot, fecsolic, proveedor, territorial, zona, sucursal, fecren, fecfin, fecing, formpago, cnumcot, pnumcot, ciuedo, cuotacamp, porccamp, idecamp, utilidad, plan, codmoneda, primaadic, primagf, cantidad, codparent, codramoplan, emailarray, direccionresidenciarray, direccioncorrespondencia, telefono3Array, telefono2Array, telefono1Array, codmediopago, descmediopago, indbenefone, induseasis, benfone, useasis, filtro, documento, fechaini, fechafin, status, numcertini, numcertfin, codformpago, codofiemi, fecinipol, fechainicio, fechfecoper, compnumpol, fecoper, codgestor, codofisusc, motivo, gestor, fecexc, fechainipol, fecfincotiza, nompercotiza, idcliente, codperiodicpago, cotestado, indrenauto, direc, codsuplemento, suplemento, codmotivo, codsubmotivo, submotivo, fechasuplemento, includemode, primaperi, primaperidica, primaanual, coaseguro, periodicidad, sumaasegurado, direccioncorr, direccionres, tipocuenta, celular, checkrenauto, cambiorenauto, codexclusion, motivoexclusion, observacion, codramo, capital, indicevariable, prima, sobreprima, extraprima, deducible, stscobert, indcobertoblig, idecobert, tasa, bbvasbr, othersbr, nosbr, clasecli, fecanul, frcinipol, tiposusc, tiposuscprod, idedirec, codtipovia, numero2, descripstatus, indasegtitular, numsolicitud, stsaseg, descexclusion, efecto, emision, cobertura, codcapital, fechaexc, stscobertura, participacion, recibo, tipoop, saldo, clave, poliza, responsabledepago, numdocumento, primabruta, numfinanc, n, retribucion, iva, reteiva, reteica, retefue, ordenpago, nrogiro, fechacobro, recpagouordpago, sldofactmoneda, nivel, codigo, clausula, anexo, ideclaucert, texto, siniestro, fnotificacion, causa, fsiniestro, fmodificacion, boton, servicio, codmodalidad, modalidad, option, customeridtype, customeridnumber, renewaltype, policystatus, paymentperiod, effectivestartdate, renewaldate, directdebitaccount, insuredvalue, managementoffice, insuranceproductcode, usermanagingpolicy, operationdate, premiumamount, altamiraaccountnumber, paymentreference, amountvalue, operationtime, userresponsible, description, policynumberweb, customerpolicynumber, sumaasegarray, ocupacionarray, periodicidadpagoarray, planarray, departamentoarray, ciudadarray, estratoarray, anioconstruccionarray, dni, descdni, tipofecha, certificadoinicial, certificadofinal, producto, oper, tproduc, cpoliza, tpoliza, bmodpag, fefecto, cperson, tdninit, tapell1, tapell2, nombre1, bestado, cproduc, trotulo1, cmodali, nvermod, trotulo2, coficin, tnombre, ccompan, cmotivodesc, nmovimi, btipmov, femisio, cmotivo, crecibo, tusuari, ttermin, nhormov, nanexos, bmotivo, brepalt, tipogarantia, amparo, tipo, agente, femision, fcobro, primas, rcop, estado, treca, td, ctabarrido, rol, nit, relva, retlva, retfue, ordpago, reccaja, garantia, importa, nombrereporte, indacsel, indefront, indaplus, cliente, beneficiario, certificado, retribuciones, agentes, garantias, bienes, recibos, autorizaciones, clausulas, codval, tipoparam, codparam, descparam, refparam, codsql, totalregs, values, types, stsbien, additionalinfo, codocupac, fechaefecto, fechaemision, porcpago, descripcion, mediodepago, barridodecuenta, cancelacionsaldos, idbien, tipocli, apemat, descoaseguro, numpreformalizado, consecutivo, valaproxnueva, valaproxactual, codigoautoriza, codinterf, horainicio, calendario, nombrejob);
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "idProcesoExec='" + idProcesoExec + '\'' +
                ", cantparent=" + cantparent +
                ", impuestoanual='" + impuestoanual + '\'' +
                ", totalprimaanual='" + totalprimaanual + '\'' +
                ", totalprimaperiodica='" + totalprimaperiodica + '\'' +
                ", nomcampodatos='" + nomcampodatos + '\'' +
                ", indvetoboletin='" + indvetoboletin + '\'' +
                ", codrev='" + codrev + '\'' +
                ", idestmultinivel='" + idestmultinivel + '\'' +
                ", descripcanal='" + descripcanal + '\'' +
                ", identificationDigit='" + identificationDigit + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstLastName='" + firstLastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", countryOfResidence='" + countryOfResidence + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", geographicCodeDepartment='" + geographicCodeDepartment + '\'' +
                ", geographicCodeTown='" + geographicCodeTown + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", address4='" + address4 + '\'' +
                ", address5='" + address5 + '\'' +
                ", address6='" + address6 + '\'' +
                ", address7='" + address7 + '\'' +
                ", townOfResidence='" + townOfResidence + '\'' +
                ", departmentOfResidence='" + departmentOfResidence + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                ", activityEconomy='" + activityEconomy + '\'' +
                ", accountNumber1='" + accountNumber1 + '\'' +
                ", accountNumber2='" + accountNumber2 + '\'' +
                ", accountNumber3='" + accountNumber3 + '\'' +
                ", accountNumber4='" + accountNumber4 + '\'' +
                ", accountNumber5='" + accountNumber5 + '\'' +
                ", accountNumber6='" + accountNumber6 + '\'' +
                ", accountNumber7='" + accountNumber7 + '\'' +
                ", typeIdInsured='" + typeIdInsured + '\'' +
                ", municipalityBirth='" + municipalityBirth + '\'' +
                ", departmentOfBirth='" + departmentOfBirth + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", phoneResidence='" + phoneResidence + '\'' +
                ", cellResidency='" + cellResidency + '\'' +
                ", occupation='" + occupation + '\'' +
                ", codeProfession='" + codeProfession + '\'' +
                ", independent='" + independent + '\'' +
                ", position='" + position + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyTelephone='" + companyTelephone + '\'' +
                ", companyCellPhone='" + companyCellPhone + '\'' +
                ", destinationOriginFunds='" + destinationOriginFunds + '\'' +
                ", incomeMonthly=" + incomeMonthly +
                ", expenseMonthly=" + expenseMonthly +
                ", otherExpenses=" + otherExpenses +
                ", otherIncome=" + otherIncome +
                ", destinationOtherIncome='" + destinationOtherIncome + '\'' +
                ", totalAssets=" + totalAssets +
                ", totalLiabilities=" + totalLiabilities +
                ", typeOfForeignCurrencyProduct='" + typeOfForeignCurrencyProduct + '\'' +
                ", productForeignCurrencyAccount='" + productForeignCurrencyAccount + '\'' +
                ", entityForeignCurrency='" + entityForeignCurrency + '\'' +
                ", amountForeignCurrency=" + amountForeignCurrency +
                ", cityForeignCurrency='" + cityForeignCurrency + '\'' +
                ", countryForeignCurrency='" + countryForeignCurrency + '\'' +
                ", foreignCurrency='" + foreignCurrency + '\'' +
                ", datesSarlaft='" + datesSarlaft + '\'' +
                ", customerImport='" + customerImport + '\'' +
                ", investment='" + investment + '\'' +
                ", paymentServices='" + paymentServices + '\'' +
                ", loan='" + loan + '\'' +
                ", customerExport='" + customerExport + '\'' +
                ", officeCode1='" + officeCode1 + '\'' +
                ", openingDate1=" + openingDate1 +
                ", byProduct1='" + byProduct1 + '\'' +
                ", accountType1='" + accountType1 + '\'' +
                ", mainChannel1='" + mainChannel1 + '\'' +
                ", officeCode2='" + officeCode2 + '\'' +
                ", openingDate2=" + openingDate2 +
                ", byProduct2='" + byProduct2 + '\'' +
                ", accountType2='" + accountType2 + '\'' +
                ", mainChannel2='" + mainChannel2 + '\'' +
                ", officeCode3='" + officeCode3 + '\'' +
                ", openingDate3=" + openingDate3 +
                ", byProduct3='" + byProduct3 + '\'' +
                ", accountType3='" + accountType3 + '\'' +
                ", mainChannel3='" + mainChannel3 + '\'' +
                ", officeCode4='" + officeCode4 + '\'' +
                ", openingDate4=" + openingDate4 +
                ", byProduct4='" + byProduct4 + '\'' +
                ", accountType4='" + accountType4 + '\'' +
                ", mainChannel4='" + mainChannel4 + '\'' +
                ", officeCode5='" + officeCode5 + '\'' +
                ", openingDate5=" + openingDate5 +
                ", byProduct5='" + byProduct5 + '\'' +
                ", accountType5='" + accountType5 + '\'' +
                ", mainChannel5='" + mainChannel5 + '\'' +
                ", officeCode6='" + officeCode6 + '\'' +
                ", openingDate6=" + openingDate6 +
                ", byProduct6='" + byProduct6 + '\'' +
                ", accountType6='" + accountType6 + '\'' +
                ", mainChannel6='" + mainChannel6 + '\'' +
                ", officeCode7='" + officeCode7 + '\'' +
                ", openingDate7=" + openingDate7 +
                ", byProduct7='" + byProduct7 + '\'' +
                ", accountType7='" + accountType7 + '\'' +
                ", mainChannel7='" + mainChannel7 + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", pageSize=" + pageSize +
                ", paginationKey='" + paginationKey + '\'' +
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
                ", descplanprod='" + descplanprod + '\'' +
                ", descprod='" + descprod + '\'' +
                ", indafinnity='" + indafinnity + '\'' +
                ", message='" + message + '\'' +
                ", codofiges='" + codofiges + '\'' +
                ", checkbenefley='" + checkbenefley + '\'' +
                ", checkbenefoneroso='" + checkbenefoneroso + '\'' +
                ", genero='" + genero + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", codgenero='" + codgenero + '\'' +
                ", descgenero='" + descgenero + '\'' +
                ", tipooperacion='" + tipooperacion + '\'' +
                ", numoper='" + numoper + '\'' +
                ", metodoreporte='" + metodoreporte + '\'' +
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
                ", periodicidad='" + periodicidad + '\'' +
                ", sumaasegurado='" + sumaasegurado + '\'' +
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
                ", capital='" + capital + '\'' +
                ", indicevariable='" + indicevariable + '\'' +
                ", prima='" + prima + '\'' +
                ", sobreprima='" + sobreprima + '\'' +
                ", extraprima='" + extraprima + '\'' +
                ", deducible='" + deducible + '\'' +
                ", stscobert='" + stscobert + '\'' +
                ", indcobertoblig='" + indcobertoblig + '\'' +
                ", idecobert='" + idecobert + '\'' +
                ", tasa='" + tasa + '\'' +
                ", bbvasbr='" + bbvasbr + '\'' +
                ", othersbr='" + othersbr + '\'' +
                ", nosbr='" + nosbr + '\'' +
                ", clasecli='" + clasecli + '\'' +
                ", fecanul='" + fecanul + '\'' +
                ", frcinipol='" + frcinipol + '\'' +
                ", tiposusc='" + tiposusc + '\'' +
                ", tiposuscprod='" + tiposuscprod + '\'' +
                ", idedirec='" + idedirec + '\'' +
                ", codtipovia='" + codtipovia + '\'' +
                ", numero2='" + numero2 + '\'' +
                ", descripstatus='" + descripstatus + '\'' +
                ", indasegtitular='" + indasegtitular + '\'' +
                ", numsolicitud='" + numsolicitud + '\'' +
                ", stsaseg='" + stsaseg + '\'' +
                ", descexclusion='" + descexclusion + '\'' +
                ", efecto='" + efecto + '\'' +
                ", emision='" + emision + '\'' +
                ", cobertura='" + cobertura + '\'' +
                ", codcapital='" + codcapital + '\'' +
                ", fechaexc='" + fechaexc + '\'' +
                ", stscobertura='" + stscobertura + '\'' +
                ", participacion='" + participacion + '\'' +
                ", recibo='" + recibo + '\'' +
                ", tipoop='" + tipoop + '\'' +
                ", saldo='" + saldo + '\'' +
                ", clave='" + clave + '\'' +
                ", poliza='" + poliza + '\'' +
                ", responsabledepago='" + responsabledepago + '\'' +
                ", numdocumento='" + numdocumento + '\'' +
                ", primabruta='" + primabruta + '\'' +
                ", numfinanc='" + numfinanc + '\'' +
                ", n='" + n + '\'' +
                ", retribucion='" + retribucion + '\'' +
                ", iva='" + iva + '\'' +
                ", reteiva='" + reteiva + '\'' +
                ", reteica='" + reteica + '\'' +
                ", retefue='" + retefue + '\'' +
                ", ordenpago='" + ordenpago + '\'' +
                ", nrogiro='" + nrogiro + '\'' +
                ", fechacobro='" + fechacobro + '\'' +
                ", recpagouordpago='" + recpagouordpago + '\'' +
                ", sldofactmoneda='" + sldofactmoneda + '\'' +
                ", nivel='" + nivel + '\'' +
                ", codigo='" + codigo + '\'' +
                ", clausula='" + clausula + '\'' +
                ", anexo='" + anexo + '\'' +
                ", ideclaucert='" + ideclaucert + '\'' +
                ", texto='" + texto + '\'' +
                ", siniestro='" + siniestro + '\'' +
                ", fnotificacion='" + fnotificacion + '\'' +
                ", causa='" + causa + '\'' +
                ", fsiniestro='" + fsiniestro + '\'' +
                ", fmodificacion='" + fmodificacion + '\'' +
                ", boton='" + boton + '\'' +
                ", servicio='" + servicio + '\'' +
                ", codmodalidad='" + codmodalidad + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", option='" + option + '\'' +
                ", customeridtype='" + customeridtype + '\'' +
                ", customeridnumber='" + customeridnumber + '\'' +
                ", renewaltype='" + renewaltype + '\'' +
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
                ", policynumberweb='" + policynumberweb + '\'' +
                ", customerpolicynumber='" + customerpolicynumber + '\'' +
                ", sumaasegarray=" + sumaasegarray +
                ", ocupacionarray=" + ocupacionarray +
                ", periodicidadpagoarray=" + periodicidadpagoarray +
                ", planarray=" + planarray +
                ", departamentoarray=" + departamentoarray +
                ", ciudadarray=" + ciudadarray +
                ", estratoarray=" + estratoarray +
                ", anioconstruccionarray=" + anioconstruccionarray +
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
                ", fefecto='" + fefecto + '\'' +
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
                ", tnombre='" + tnombre + '\'' +
                ", ccompan='" + ccompan + '\'' +
                ", cmotivodesc='" + cmotivodesc + '\'' +
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
                ", agente='" + agente + '\'' +
                ", femision='" + femision + '\'' +
                ", fcobro='" + fcobro + '\'' +
                ", primas='" + primas + '\'' +
                ", rcop='" + rcop + '\'' +
                ", estado='" + estado + '\'' +
                ", treca='" + treca + '\'' +
                ", td='" + td + '\'' +
                ", ctabarrido='" + ctabarrido + '\'' +
                ", rol='" + rol + '\'' +
                ", nit='" + nit + '\'' +
                ", relva='" + relva + '\'' +
                ", retlva='" + retlva + '\'' +
                ", retfue='" + retfue + '\'' +
                ", ordpago='" + ordpago + '\'' +
                ", reccaja='" + reccaja + '\'' +
                ", garantia='" + garantia + '\'' +
                ", importa='" + importa + '\'' +
                ", nombrereporte='" + nombrereporte + '\'' +
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
                ", values=" + values +
                ", types=" + types +
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
                ", idbien='" + idbien + '\'' +
                ", tipocli='" + tipocli + '\'' +
                ", apemat='" + apemat + '\'' +
                ", descoaseguro='" + descoaseguro + '\'' +
                ", numpreformalizado='" + numpreformalizado + '\'' +
                ", consecutivo='" + consecutivo + '\'' +
                ", valaproxnueva='" + valaproxnueva + '\'' +
                ", valaproxactual='" + valaproxactual + '\'' +
                ", codigoautoriza='" + codigoautoriza + '\'' +
                ", codinterf='" + codinterf + '\'' +
                ", horainicio='" + horainicio + '\'' +
                ", calendario='" + calendario + '\'' +
                ", nombrejob='" + nombrejob + '\'' +
                '}';
    }

}