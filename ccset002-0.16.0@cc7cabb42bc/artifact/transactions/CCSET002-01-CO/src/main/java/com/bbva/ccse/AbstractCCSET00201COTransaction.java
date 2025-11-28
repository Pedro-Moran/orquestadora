package com.bbva.ccse;

import com.bbva.ccse.dto.acselwebs.AgentesDTO;
import com.bbva.ccse.dto.acselwebs.AutorizacionesDTO;
import com.bbva.ccse.dto.acselwebs.BeneficiariosDTO;
import com.bbva.ccse.dto.acselwebs.BienesDTO;
import com.bbva.ccse.dto.acselwebs.CardsDTO;
import com.bbva.ccse.dto.acselwebs.CertificadosDTO;
import com.bbva.ccse.dto.acselwebs.ClausulasDTO;
import com.bbva.ccse.dto.acselwebs.ClientesDTO;
import com.bbva.ccse.dto.acselwebs.GarantiasDTO;
import com.bbva.ccse.dto.acselwebs.PaginationDTO;
import com.bbva.ccse.dto.acselwebs.PolicyDTO;
import com.bbva.ccse.dto.acselwebs.RecibosDTO;
import com.bbva.ccse.dto.acselwebs.RetribucionesDTO;
import com.bbva.elara.transaction.AbstractTransaction;
import java.util.Date;
import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractCCSET00201COTransaction extends AbstractTransaction {

	protected AbstractCCSET00201COTransaction(){
	}


	/**
	 * Return value for input parameter idProcesoExec
	 */
	protected String getIdprocesoexec(){
		return (String)this.getParameter("idProcesoExec");
	}

	/**
	 * Return value for input parameter cantparent
	 */
	protected Long getCantparent(){
		return (Long)this.getParameter("cantparent");
	}

	/**
	 * Return value for input parameter impuestoanual
	 */
	protected String getImpuestoanual(){
		return (String)this.getParameter("impuestoanual");
	}

	/**
	 * Return value for input parameter totalprimaanual
	 */
	protected String getTotalprimaanual(){
		return (String)this.getParameter("totalprimaanual");
	}

	/**
	 * Return value for input parameter totalprimaperiodica
	 */
	protected String getTotalprimaperiodica(){
		return (String)this.getParameter("totalprimaperiodica");
	}

	/**
	 * Return value for input parameter nomcampodatos
	 */
	protected String getNomcampodatos(){
		return (String)this.getParameter("nomcampodatos");
	}

	/**
	 * Return value for input parameter indvetoboletin
	 */
	protected String getIndvetoboletin(){
		return (String)this.getParameter("indvetoboletin");
	}

	/**
	 * Return value for input parameter codrev
	 */
	protected String getCodrev(){
		return (String)this.getParameter("codrev");
	}

	/**
	 * Return value for input parameter idestmultinivel
	 */
	protected String getIdestmultinivel(){
		return (String)this.getParameter("idestmultinivel");
	}

	/**
	 * Return value for input parameter descripcanal
	 */
	protected String getDescripcanal(){
		return (String)this.getParameter("descripcanal");
	}

	/**
	 * Return value for input parameter identificationDigit
	 */
	protected String getIdentificationdigit(){
		return (String)this.getParameter("identificationDigit");
	}

	/**
	 * Return value for input parameter firstName
	 */
	protected String getFirstname(){
		return (String)this.getParameter("firstName");
	}

	/**
	 * Return value for input parameter secondName
	 */
	protected String getSecondname(){
		return (String)this.getParameter("secondName");
	}

	/**
	 * Return value for input parameter firstLastName
	 */
	protected String getFirstlastname(){
		return (String)this.getParameter("firstLastName");
	}

	/**
	 * Return value for input parameter secondLastName
	 */
	protected String getSecondlastname(){
		return (String)this.getParameter("secondLastName");
	}

	/**
	 * Return value for input parameter dateOfBirth
	 */
	protected Long getDateofbirth(){
		return (Long)this.getParameter("dateOfBirth");
	}

	/**
	 * Return value for input parameter countryOfResidence
	 */
	protected String getCountryofresidence(){
		return (String)this.getParameter("countryOfResidence");
	}

	/**
	 * Return value for input parameter gender
	 */
	protected String getGender(){
		return (String)this.getParameter("gender");
	}

	/**
	 * Return value for input parameter address
	 */
	protected String getAddress(){
		return (String)this.getParameter("address");
	}

	/**
	 * Return value for input parameter age
	 */
	protected String getAge(){
		return (String)this.getParameter("age");
	}

	/**
	 * Return value for input parameter geographicCodeDepartment
	 */
	protected String getGeographiccodedepartment(){
		return (String)this.getParameter("geographicCodeDepartment");
	}

	/**
	 * Return value for input parameter geographicCodeTown
	 */
	protected String getGeographiccodetown(){
		return (String)this.getParameter("geographicCodeTown");
	}

	/**
	 * Return value for input parameter residenceAddress
	 */
	protected String getResidenceaddress(){
		return (String)this.getParameter("residenceAddress");
	}

	/**
	 * Return value for input parameter address2
	 */
	protected String getAddress2(){
		return (String)this.getParameter("address2");
	}

	/**
	 * Return value for input parameter address3
	 */
	protected String getAddress3(){
		return (String)this.getParameter("address3");
	}

	/**
	 * Return value for input parameter address4
	 */
	protected String getAddress4(){
		return (String)this.getParameter("address4");
	}

	/**
	 * Return value for input parameter address5
	 */
	protected String getAddress5(){
		return (String)this.getParameter("address5");
	}

	/**
	 * Return value for input parameter address6
	 */
	protected String getAddress6(){
		return (String)this.getParameter("address6");
	}

	/**
	 * Return value for input parameter address7
	 */
	protected String getAddress7(){
		return (String)this.getParameter("address7");
	}

	/**
	 * Return value for input parameter townOfResidence
	 */
	protected String getTownofresidence(){
		return (String)this.getParameter("townOfResidence");
	}

	/**
	 * Return value for input parameter departmentOfResidence
	 */
	protected String getDepartmentofresidence(){
		return (String)this.getParameter("departmentOfResidence");
	}

	/**
	 * Return value for input parameter phone1
	 */
	protected String getPhone1(){
		return (String)this.getParameter("phone1");
	}

	/**
	 * Return value for input parameter phone2
	 */
	protected String getPhone2(){
		return (String)this.getParameter("phone2");
	}

	/**
	 * Return value for input parameter email
	 */
	protected String getEmail(){
		return (String)this.getParameter("email");
	}

	/**
	 * Return value for input parameter profession
	 */
	protected String getProfession(){
		return (String)this.getParameter("profession");
	}

	/**
	 * Return value for input parameter activityEconomy
	 */
	protected String getActivityeconomy(){
		return (String)this.getParameter("activityEconomy");
	}

	/**
	 * Return value for input parameter accountNumber1
	 */
	protected String getAccountnumber1(){
		return (String)this.getParameter("accountNumber1");
	}

	/**
	 * Return value for input parameter accountNumber2
	 */
	protected String getAccountnumber2(){
		return (String)this.getParameter("accountNumber2");
	}

	/**
	 * Return value for input parameter accountNumber3
	 */
	protected String getAccountnumber3(){
		return (String)this.getParameter("accountNumber3");
	}

	/**
	 * Return value for input parameter accountNumber4
	 */
	protected String getAccountnumber4(){
		return (String)this.getParameter("accountNumber4");
	}

	/**
	 * Return value for input parameter accountNumber5
	 */
	protected String getAccountnumber5(){
		return (String)this.getParameter("accountNumber5");
	}

	/**
	 * Return value for input parameter accountNumber6
	 */
	protected String getAccountnumber6(){
		return (String)this.getParameter("accountNumber6");
	}

	/**
	 * Return value for input parameter accountNumber7
	 */
	protected String getAccountnumber7(){
		return (String)this.getParameter("accountNumber7");
	}

	/**
	 * Return value for input parameter typeIdInsured
	 */
	protected String getTypeidinsured(){
		return (String)this.getParameter("typeIdInsured");
	}

	/**
	 * Return value for input parameter municipalityBirth
	 */
	protected String getMunicipalitybirth(){
		return (String)this.getParameter("municipalityBirth");
	}

	/**
	 * Return value for input parameter departmentOfBirth
	 */
	protected String getDepartmentofbirth(){
		return (String)this.getParameter("departmentOfBirth");
	}

	/**
	 * Return value for input parameter countryOfBirth
	 */
	protected String getCountryofbirth(){
		return (String)this.getParameter("countryOfBirth");
	}

	/**
	 * Return value for input parameter phoneResidence
	 */
	protected String getPhoneresidence(){
		return (String)this.getParameter("phoneResidence");
	}

	/**
	 * Return value for input parameter cellResidency
	 */
	protected String getCellresidency(){
		return (String)this.getParameter("cellResidency");
	}

	/**
	 * Return value for input parameter occupation
	 */
	protected String getOccupation(){
		return (String)this.getParameter("occupation");
	}

	/**
	 * Return value for input parameter codeProfession
	 */
	protected String getCodeprofession(){
		return (String)this.getParameter("codeProfession");
	}

	/**
	 * Return value for input parameter independent
	 */
	protected String getIndependent(){
		return (String)this.getParameter("independent");
	}

	/**
	 * Return value for input parameter position
	 */
	protected String getPosition(){
		return (String)this.getParameter("position");
	}

	/**
	 * Return value for input parameter companyName
	 */
	protected String getCompanyname(){
		return (String)this.getParameter("companyName");
	}

	/**
	 * Return value for input parameter companyAddress
	 */
	protected String getCompanyaddress(){
		return (String)this.getParameter("companyAddress");
	}

	/**
	 * Return value for input parameter companyTelephone
	 */
	protected String getCompanytelephone(){
		return (String)this.getParameter("companyTelephone");
	}

	/**
	 * Return value for input parameter companyCellPhone
	 */
	protected String getCompanycellphone(){
		return (String)this.getParameter("companyCellPhone");
	}

	/**
	 * Return value for input parameter destinationOriginFunds
	 */
	protected String getDestinationoriginfunds(){
		return (String)this.getParameter("destinationOriginFunds");
	}

	/**
	 * Return value for input parameter incomeMonthly
	 */
	protected Long getIncomemonthly(){
		return (Long)this.getParameter("incomeMonthly");
	}

	/**
	 * Return value for input parameter expenseMonthly
	 */
	protected Long getExpensemonthly(){
		return (Long)this.getParameter("expenseMonthly");
	}

	/**
	 * Return value for input parameter otherExpenses
	 */
	protected Long getOtherexpenses(){
		return (Long)this.getParameter("otherExpenses");
	}

	/**
	 * Return value for input parameter otherIncome
	 */
	protected Long getOtherincome(){
		return (Long)this.getParameter("otherIncome");
	}

	/**
	 * Return value for input parameter destinationOtherIncome
	 */
	protected String getDestinationotherincome(){
		return (String)this.getParameter("destinationOtherIncome");
	}

	/**
	 * Return value for input parameter totalAssets
	 */
	protected Long getTotalassets(){
		return (Long)this.getParameter("totalAssets");
	}

	/**
	 * Return value for input parameter totalLiabilities
	 */
	protected Long getTotalliabilities(){
		return (Long)this.getParameter("totalLiabilities");
	}

	/**
	 * Return value for input parameter typeOfForeignCurrencyProduct
	 */
	protected String getTypeofforeigncurrencyproduct(){
		return (String)this.getParameter("typeOfForeignCurrencyProduct");
	}

	/**
	 * Return value for input parameter productForeignCurrencyAccount
	 */
	protected String getProductforeigncurrencyaccount(){
		return (String)this.getParameter("productForeignCurrencyAccount");
	}

	/**
	 * Return value for input parameter entityForeignCurrency
	 */
	protected String getEntityforeigncurrency(){
		return (String)this.getParameter("entityForeignCurrency");
	}

	/**
	 * Return value for input parameter amountForeignCurrency
	 */
	protected Long getAmountforeigncurrency(){
		return (Long)this.getParameter("amountForeignCurrency");
	}

	/**
	 * Return value for input parameter cityForeignCurrency
	 */
	protected String getCityforeigncurrency(){
		return (String)this.getParameter("cityForeignCurrency");
	}

	/**
	 * Return value for input parameter countryForeignCurrency
	 */
	protected String getCountryforeigncurrency(){
		return (String)this.getParameter("countryForeignCurrency");
	}

	/**
	 * Return value for input parameter foreignCurrency
	 */
	protected String getForeigncurrency(){
		return (String)this.getParameter("foreignCurrency");
	}

	/**
	 * Return value for input parameter datesSarlaft
	 */
	protected String getDatessarlaft(){
		return (String)this.getParameter("datesSarlaft");
	}

	/**
	 * Return value for input parameter customerImport
	 */
	protected String getCustomerimport(){
		return (String)this.getParameter("customerImport");
	}

	/**
	 * Return value for input parameter investment
	 */
	protected String getInvestment(){
		return (String)this.getParameter("investment");
	}

	/**
	 * Return value for input parameter paymentServices
	 */
	protected String getPaymentservices(){
		return (String)this.getParameter("paymentServices");
	}

	/**
	 * Return value for input parameter loan
	 */
	protected String getLoan(){
		return (String)this.getParameter("loan");
	}

	/**
	 * Return value for input parameter customerExport
	 */
	protected String getCustomerexport(){
		return (String)this.getParameter("customerExport");
	}

	/**
	 * Return value for input parameter officeCode1
	 */
	protected String getOfficecode1(){
		return (String)this.getParameter("officeCode1");
	}

	/**
	 * Return value for input parameter openingDate1
	 */
	protected Date getOpeningdate1(){
		return (Date)this.getParameter("openingDate1");
	}

	/**
	 * Return value for input parameter byProduct1
	 */
	protected String getByproduct1(){
		return (String)this.getParameter("byProduct1");
	}

	/**
	 * Return value for input parameter accountType1
	 */
	protected String getAccounttype1(){
		return (String)this.getParameter("accountType1");
	}

	/**
	 * Return value for input parameter mainChannel1
	 */
	protected String getMainchannel1(){
		return (String)this.getParameter("mainChannel1");
	}

	/**
	 * Return value for input parameter officeCode2
	 */
	protected String getOfficecode2(){
		return (String)this.getParameter("officeCode2");
	}

	/**
	 * Return value for input parameter openingDate2
	 */
	protected Date getOpeningdate2(){
		return (Date)this.getParameter("openingDate2");
	}

	/**
	 * Return value for input parameter byProduct2
	 */
	protected String getByproduct2(){
		return (String)this.getParameter("byProduct2");
	}

	/**
	 * Return value for input parameter accountType2
	 */
	protected String getAccounttype2(){
		return (String)this.getParameter("accountType2");
	}

	/**
	 * Return value for input parameter mainChannel2
	 */
	protected String getMainchannel2(){
		return (String)this.getParameter("mainChannel2");
	}

	/**
	 * Return value for input parameter officeCode3
	 */
	protected String getOfficecode3(){
		return (String)this.getParameter("officeCode3");
	}

	/**
	 * Return value for input parameter openingDate3
	 */
	protected Date getOpeningdate3(){
		return (Date)this.getParameter("openingDate3");
	}

	/**
	 * Return value for input parameter byProduct3
	 */
	protected String getByproduct3(){
		return (String)this.getParameter("byProduct3");
	}

	/**
	 * Return value for input parameter accountType3
	 */
	protected String getAccounttype3(){
		return (String)this.getParameter("accountType3");
	}

	/**
	 * Return value for input parameter mainChannel3
	 */
	protected String getMainchannel3(){
		return (String)this.getParameter("mainChannel3");
	}

	/**
	 * Return value for input parameter officeCode4
	 */
	protected String getOfficecode4(){
		return (String)this.getParameter("officeCode4");
	}

	/**
	 * Return value for input parameter openingDate4
	 */
	protected Date getOpeningdate4(){
		return (Date)this.getParameter("openingDate4");
	}

	/**
	 * Return value for input parameter byProduct4
	 */
	protected String getByproduct4(){
		return (String)this.getParameter("byProduct4");
	}

	/**
	 * Return value for input parameter accountType4
	 */
	protected String getAccounttype4(){
		return (String)this.getParameter("accountType4");
	}

	/**
	 * Return value for input parameter mainChannel4
	 */
	protected String getMainchannel4(){
		return (String)this.getParameter("mainChannel4");
	}

	/**
	 * Return value for input parameter officeCode5
	 */
	protected String getOfficecode5(){
		return (String)this.getParameter("officeCode5");
	}

	/**
	 * Return value for input parameter openingDate5
	 */
	protected Date getOpeningdate5(){
		return (Date)this.getParameter("openingDate5");
	}

	/**
	 * Return value for input parameter byProduct5
	 */
	protected String getByproduct5(){
		return (String)this.getParameter("byProduct5");
	}

	/**
	 * Return value for input parameter accountType5
	 */
	protected String getAccounttype5(){
		return (String)this.getParameter("accountType5");
	}

	/**
	 * Return value for input parameter mainChannel5
	 */
	protected String getMainchannel5(){
		return (String)this.getParameter("mainChannel5");
	}

	/**
	 * Return value for input parameter officeCode6
	 */
	protected String getOfficecode6(){
		return (String)this.getParameter("officeCode6");
	}

	/**
	 * Return value for input parameter openingDate6
	 */
	protected Date getOpeningdate6(){
		return (Date)this.getParameter("openingDate6");
	}

	/**
	 * Return value for input parameter byProduct6
	 */
	protected String getByproduct6(){
		return (String)this.getParameter("byProduct6");
	}

	/**
	 * Return value for input parameter accountType6
	 */
	protected String getAccounttype6(){
		return (String)this.getParameter("accountType6");
	}

	/**
	 * Return value for input parameter mainChannel6
	 */
	protected String getMainchannel6(){
		return (String)this.getParameter("mainChannel6");
	}

	/**
	 * Return value for input parameter officeCode7
	 */
	protected String getOfficecode7(){
		return (String)this.getParameter("officeCode7");
	}

	/**
	 * Return value for input parameter openingDate7
	 */
	protected Date getOpeningdate7(){
		return (Date)this.getParameter("openingDate7");
	}

	/**
	 * Return value for input parameter byProduct7
	 */
	protected String getByproduct7(){
		return (String)this.getParameter("byProduct7");
	}

	/**
	 * Return value for input parameter accountType7
	 */
	protected String getAccounttype7(){
		return (String)this.getParameter("accountType7");
	}

	/**
	 * Return value for input parameter mainChannel7
	 */
	protected String getMainchannel7(){
		return (String)this.getParameter("mainChannel7");
	}

	/**
	 * Return value for input parameter orderBy
	 */
	protected String getOrdersBy(){
		return (String)this.getParameter("orderBy");
	}

	/**
	 * Return value for input parameter pageSize
	 */
	protected Long getPagesSize(){
		return (Long)this.getParameter("pageSize");
	}

	/**
	 * Return value for input parameter paginationKey
	 */
	protected String getPaginationsKey(){
		return (String)this.getParameter("paginationKey");
	}

	/**
	 * Return value for input parameter digitoIdentificacion
	 */
	protected String getDigitoidentificacion(){
		return (String)this.getParameter("digitoIdentificacion");
	}

	/**
	 * Return value for input parameter primerNombre
	 */
	protected String getPrimernombre(){
		return (String)this.getParameter("primerNombre");
	}

	/**
	 * Return value for input parameter segundoNombre
	 */
	protected String getSegundonombre(){
		return (String)this.getParameter("segundoNombre");
	}

	/**
	 * Return value for input parameter primerApellido
	 */
	protected String getPrimerapellido(){
		return (String)this.getParameter("primerApellido");
	}

	/**
	 * Return value for input parameter segundoApellido
	 */
	protected String getSegundoapellido(){
		return (String)this.getParameter("segundoApellido");
	}

	/**
	 * Return value for input parameter fechaDeNacimiento
	 */
	protected Long getFechadenacimiento(){
		return (Long)this.getParameter("fechaDeNacimiento");
	}

	/**
	 * Return value for input parameter paisDeResidencia
	 */
	protected String getPaisderesidencia(){
		return (String)this.getParameter("paisDeResidencia");
	}

	/**
	 * Return value for input parameter sexo
	 */
	protected String getSexo(){
		return (String)this.getParameter("sexo");
	}

	/**
	 * Return value for input parameter edad
	 */
	protected String getEdad(){
		return (String)this.getParameter("edad");
	}

	/**
	 * Return value for input parameter codigoGeograficoCiudad
	 */
	protected String getCodigogeograficociudad(){
		return (String)this.getParameter("codigoGeograficoCiudad");
	}

	/**
	 * Return value for input parameter codigoGeograficoDepartamento
	 */
	protected String getCodigogeograficodepartamento(){
		return (String)this.getParameter("codigoGeograficoDepartamento");
	}

	/**
	 * Return value for input parameter direccionResidencia
	 */
	protected String getDireccionresidencia(){
		return (String)this.getParameter("direccionResidencia");
	}

	/**
	 * Return value for input parameter direccion2
	 */
	protected String getDireccion2(){
		return (String)this.getParameter("direccion2");
	}

	/**
	 * Return value for input parameter direccion3
	 */
	protected String getDireccion3(){
		return (String)this.getParameter("direccion3");
	}

	/**
	 * Return value for input parameter direccion4
	 */
	protected String getDireccion4(){
		return (String)this.getParameter("direccion4");
	}

	/**
	 * Return value for input parameter direccion5
	 */
	protected String getDireccion5(){
		return (String)this.getParameter("direccion5");
	}

	/**
	 * Return value for input parameter direccion6
	 */
	protected String getDireccion6(){
		return (String)this.getParameter("direccion6");
	}

	/**
	 * Return value for input parameter direccion7
	 */
	protected String getDireccion7(){
		return (String)this.getParameter("direccion7");
	}

	/**
	 * Return value for input parameter ciudadDeResidencia
	 */
	protected String getCiudadderesidencia(){
		return (String)this.getParameter("ciudadDeResidencia");
	}

	/**
	 * Return value for input parameter departamentoDeResidencia
	 */
	protected String getDepartamentoderesidencia(){
		return (String)this.getParameter("departamentoDeResidencia");
	}

	/**
	 * Return value for input parameter telefono1
	 */
	protected String getTelefono1(){
		return (String)this.getParameter("telefono1");
	}

	/**
	 * Return value for input parameter telefono2
	 */
	protected String getTelefono2(){
		return (String)this.getParameter("telefono2");
	}

	/**
	 * Return value for input parameter telefono3
	 */
	protected String getTelefono3(){
		return (String)this.getParameter("telefono3");
	}

	/**
	 * Return value for input parameter profesion
	 */
	protected String getProfesion(){
		return (String)this.getParameter("profesion");
	}

	/**
	 * Return value for input parameter actividadEconomica
	 */
	protected String getActividadeconomica(){
		return (String)this.getParameter("actividadEconomica");
	}

	/**
	 * Return value for input parameter numeroCuenta1
	 */
	protected String getNumerocuenta1(){
		return (String)this.getParameter("numeroCuenta1");
	}

	/**
	 * Return value for input parameter numeroCuenta2
	 */
	protected String getNumerocuenta2(){
		return (String)this.getParameter("numeroCuenta2");
	}

	/**
	 * Return value for input parameter numeroCuenta3
	 */
	protected String getNumerocuenta3(){
		return (String)this.getParameter("numeroCuenta3");
	}

	/**
	 * Return value for input parameter numeroCuenta4
	 */
	protected String getNumerocuenta4(){
		return (String)this.getParameter("numeroCuenta4");
	}

	/**
	 * Return value for input parameter numeroCuenta5
	 */
	protected String getNumerocuenta5(){
		return (String)this.getParameter("numeroCuenta5");
	}

	/**
	 * Return value for input parameter numeroCuenta6
	 */
	protected String getNumerocuenta6(){
		return (String)this.getParameter("numeroCuenta6");
	}

	/**
	 * Return value for input parameter numeroCuenta7
	 */
	protected String getNumerocuenta7(){
		return (String)this.getParameter("numeroCuenta7");
	}

	/**
	 * Return value for input parameter tipoIdentificacionAsegurado
	 */
	protected String getTipoidentificacionasegurado(){
		return (String)this.getParameter("tipoIdentificacionAsegurado");
	}

	/**
	 * Return value for input parameter municipioDeNacimiento
	 */
	protected String getMunicipiodenacimiento(){
		return (String)this.getParameter("municipioDeNacimiento");
	}

	/**
	 * Return value for input parameter departamentoDeNacimiento
	 */
	protected String getDepartamentodenacimiento(){
		return (String)this.getParameter("departamentoDeNacimiento");
	}

	/**
	 * Return value for input parameter paisDeNacimiento
	 */
	protected String getPaisdenacimiento(){
		return (String)this.getParameter("paisDeNacimiento");
	}

	/**
	 * Return value for input parameter telefonoResidencia
	 */
	protected String getTelefonoresidencia(){
		return (String)this.getParameter("telefonoResidencia");
	}

	/**
	 * Return value for input parameter celularResidencia
	 */
	protected String getCelularresidencia(){
		return (String)this.getParameter("celularResidencia");
	}

	/**
	 * Return value for input parameter ocupacion
	 */
	protected String getOcupacion(){
		return (String)this.getParameter("ocupacion");
	}

	/**
	 * Return value for input parameter codigoProfesion
	 */
	protected String getCodigoprofesion(){
		return (String)this.getParameter("codigoProfesion");
	}

	/**
	 * Return value for input parameter independiente
	 */
	protected String getIndependiente(){
		return (String)this.getParameter("independiente");
	}

	/**
	 * Return value for input parameter posicion
	 */
	protected String getPosicion(){
		return (String)this.getParameter("posicion");
	}

	/**
	 * Return value for input parameter nombreEmpresa
	 */
	protected String getNombreempresa(){
		return (String)this.getParameter("nombreEmpresa");
	}

	/**
	 * Return value for input parameter direccionEmpresa
	 */
	protected String getDireccionempresa(){
		return (String)this.getParameter("direccionEmpresa");
	}

	/**
	 * Return value for input parameter telefonoEmpresa
	 */
	protected String getTelefonoempresa(){
		return (String)this.getParameter("telefonoEmpresa");
	}

	/**
	 * Return value for input parameter celularEmpresa
	 */
	protected String getCelularempresa(){
		return (String)this.getParameter("celularEmpresa");
	}

	/**
	 * Return value for input parameter descripcionOrigenFondos
	 */
	protected String getDescripcionorigenfondos(){
		return (String)this.getParameter("descripcionOrigenFondos");
	}

	/**
	 * Return value for input parameter ingresoMensual
	 */
	protected Long getIngresomensual(){
		return (Long)this.getParameter("ingresoMensual");
	}

	/**
	 * Return value for input parameter gastoMensual
	 */
	protected Long getGastomensual(){
		return (Long)this.getParameter("gastoMensual");
	}

	/**
	 * Return value for input parameter otrosGastos
	 */
	protected Long getOtrosgastos(){
		return (Long)this.getParameter("otrosGastos");
	}

	/**
	 * Return value for input parameter otrosIngresos
	 */
	protected Long getOtrosingresos(){
		return (Long)this.getParameter("otrosIngresos");
	}

	/**
	 * Return value for input parameter destinoOtrosIngresos
	 */
	protected String getDestinootrosingresos(){
		return (String)this.getParameter("destinoOtrosIngresos");
	}

	/**
	 * Return value for input parameter totalActivos
	 */
	protected Long getTotalactivos(){
		return (Long)this.getParameter("totalActivos");
	}

	/**
	 * Return value for input parameter totalPasivos
	 */
	protected Long getTotalpasivos(){
		return (Long)this.getParameter("totalPasivos");
	}

	/**
	 * Return value for input parameter tipoProductoMonedaExtranjera
	 */
	protected String getTipoproductomonedaextranjera(){
		return (String)this.getParameter("tipoProductoMonedaExtranjera");
	}

	/**
	 * Return value for input parameter productoCuentaMonedaExtranjera
	 */
	protected String getProductocuentamonedaextranjera(){
		return (String)this.getParameter("productoCuentaMonedaExtranjera");
	}

	/**
	 * Return value for input parameter entidadMonedaExtranjera
	 */
	protected String getEntidadmonedaextranjera(){
		return (String)this.getParameter("entidadMonedaExtranjera");
	}

	/**
	 * Return value for input parameter cantidadMonedaExtranjera
	 */
	protected Long getCantidadmonedaextranjera(){
		return (Long)this.getParameter("cantidadMonedaExtranjera");
	}

	/**
	 * Return value for input parameter ciudadMonedaExtranjera
	 */
	protected String getCiudadmonedaextranjera(){
		return (String)this.getParameter("ciudadMonedaExtranjera");
	}

	/**
	 * Return value for input parameter paisMonedaExtranjera
	 */
	protected String getPaismonedaextranjera(){
		return (String)this.getParameter("paisMonedaExtranjera");
	}

	/**
	 * Return value for input parameter monedaExtranjera
	 */
	protected String getMonedaextranjera(){
		return (String)this.getParameter("monedaExtranjera");
	}

	/**
	 * Return value for input parameter fechaSarlaft
	 */
	protected String getFechasarlaft(){
		return (String)this.getParameter("fechaSarlaft");
	}

	/**
	 * Return value for input parameter importeCliente
	 */
	protected String getImportecliente(){
		return (String)this.getParameter("importeCliente");
	}

	/**
	 * Return value for input parameter inversion
	 */
	protected String getInversion(){
		return (String)this.getParameter("inversion");
	}

	/**
	 * Return value for input parameter serviciosPago
	 */
	protected String getServiciospago(){
		return (String)this.getParameter("serviciosPago");
	}

	/**
	 * Return value for input parameter prestamo
	 */
	protected String getPrestamo(){
		return (String)this.getParameter("prestamo");
	}

	/**
	 * Return value for input parameter exportacionCliente
	 */
	protected String getExportacioncliente(){
		return (String)this.getParameter("exportacionCliente");
	}

	/**
	 * Return value for input parameter codigoOficina1
	 */
	protected String getCodigooficina1(){
		return (String)this.getParameter("codigoOficina1");
	}

	/**
	 * Return value for input parameter fechaApertura1
	 */
	protected Date getFechaapertura1(){
		return (Date)this.getParameter("fechaApertura1");
	}

	/**
	 * Return value for input parameter porProducto1
	 */
	protected String getPorproducto1(){
		return (String)this.getParameter("porProducto1");
	}

	/**
	 * Return value for input parameter tipoCuenta1
	 */
	protected String getTipocuenta1(){
		return (String)this.getParameter("tipoCuenta1");
	}

	/**
	 * Return value for input parameter canalPrincipal1
	 */
	protected String getCanalprincipal1(){
		return (String)this.getParameter("canalPrincipal1");
	}

	/**
	 * Return value for input parameter codigoOficina2
	 */
	protected String getCodigooficina2(){
		return (String)this.getParameter("codigoOficina2");
	}

	/**
	 * Return value for input parameter fechaApertura2
	 */
	protected Date getFechaapertura2(){
		return (Date)this.getParameter("fechaApertura2");
	}

	/**
	 * Return value for input parameter porProducto2
	 */
	protected String getPorproducto2(){
		return (String)this.getParameter("porProducto2");
	}

	/**
	 * Return value for input parameter tipoCuenta2
	 */
	protected String getTipocuenta2(){
		return (String)this.getParameter("tipoCuenta2");
	}

	/**
	 * Return value for input parameter canalPrincipal2
	 */
	protected String getCanalprincipal2(){
		return (String)this.getParameter("canalPrincipal2");
	}

	/**
	 * Return value for input parameter codigoOficina3
	 */
	protected String getCodigooficina3(){
		return (String)this.getParameter("codigoOficina3");
	}

	/**
	 * Return value for input parameter fechaApertura3
	 */
	protected Date getFechaapertura3(){
		return (Date)this.getParameter("fechaApertura3");
	}

	/**
	 * Return value for input parameter porProducto3
	 */
	protected String getPorproducto3(){
		return (String)this.getParameter("porProducto3");
	}

	/**
	 * Return value for input parameter tipoCuenta3
	 */
	protected String getTipocuenta3(){
		return (String)this.getParameter("tipoCuenta3");
	}

	/**
	 * Return value for input parameter canalPrincipal3
	 */
	protected String getCanalprincipal3(){
		return (String)this.getParameter("canalPrincipal3");
	}

	/**
	 * Return value for input parameter codigoOficina4
	 */
	protected String getCodigooficina4(){
		return (String)this.getParameter("codigoOficina4");
	}

	/**
	 * Return value for input parameter fechaApertura4
	 */
	protected Date getFechaapertura4(){
		return (Date)this.getParameter("fechaApertura4");
	}

	/**
	 * Return value for input parameter porProducto4
	 */
	protected String getPorproducto4(){
		return (String)this.getParameter("porProducto4");
	}

	/**
	 * Return value for input parameter tipoCuenta4
	 */
	protected String getTipocuenta4(){
		return (String)this.getParameter("tipoCuenta4");
	}

	/**
	 * Return value for input parameter canalPrincipal4
	 */
	protected String getCanalprincipal4(){
		return (String)this.getParameter("canalPrincipal4");
	}

	/**
	 * Return value for input parameter codigoOficina5
	 */
	protected String getCodigooficina5(){
		return (String)this.getParameter("codigoOficina5");
	}

	/**
	 * Return value for input parameter fechaApertura5
	 */
	protected Date getFechaapertura5(){
		return (Date)this.getParameter("fechaApertura5");
	}

	/**
	 * Return value for input parameter porProducto5
	 */
	protected String getPorproducto5(){
		return (String)this.getParameter("porProducto5");
	}

	/**
	 * Return value for input parameter tipoCuenta5
	 */
	protected String getTipocuenta5(){
		return (String)this.getParameter("tipoCuenta5");
	}

	/**
	 * Return value for input parameter canalPrincipal5
	 */
	protected String getCanalprincipal5(){
		return (String)this.getParameter("canalPrincipal5");
	}

	/**
	 * Return value for input parameter codigoOficina6
	 */
	protected String getCodigooficina6(){
		return (String)this.getParameter("codigoOficina6");
	}

	/**
	 * Return value for input parameter fechaApertura6
	 */
	protected Date getFechaapertura6(){
		return (Date)this.getParameter("fechaApertura6");
	}

	/**
	 * Return value for input parameter porProducto6
	 */
	protected String getPorproducto6(){
		return (String)this.getParameter("porProducto6");
	}

	/**
	 * Return value for input parameter tipoCuenta6
	 */
	protected String getTipocuenta6(){
		return (String)this.getParameter("tipoCuenta6");
	}

	/**
	 * Return value for input parameter canalPrincipal6
	 */
	protected String getCanalprincipal6(){
		return (String)this.getParameter("canalPrincipal6");
	}

	/**
	 * Return value for input parameter codigoOficina7
	 */
	protected String getCodigooficina7(){
		return (String)this.getParameter("codigoOficina7");
	}

	/**
	 * Return value for input parameter fechaApertura7
	 */
	protected Date getFechaapertura7(){
		return (Date)this.getParameter("fechaApertura7");
	}

	/**
	 * Return value for input parameter porProducto7
	 */
	protected String getPorproducto7(){
		return (String)this.getParameter("porProducto7");
	}

	/**
	 * Return value for input parameter tipoCuenta7
	 */
	protected String getTipocuenta7(){
		return (String)this.getParameter("tipoCuenta7");
	}

	/**
	 * Return value for input parameter canalPrincipal7
	 */
	protected String getCanalprincipal7(){
		return (String)this.getParameter("canalPrincipal7");
	}

	/**
	 * Return value for input parameter textofinal
	 */
	protected String getTextofinal(){
		return (String)this.getParameter("textofinal");
	}

	/**
	 * Return value for input parameter textopreg
	 */
	protected String getTextopreg(){
		return (String)this.getParameter("textopreg");
	}

	/**
	 * Return value for input parameter orden
	 */
	protected Long getOrden(){
		return (Long)this.getParameter("orden");
	}

	/**
	 * Return value for input parameter indstop
	 */
	protected String getIndstop(){
		return (String)this.getParameter("indstop");
	}

	/**
	 * Return value for input parameter msgsi
	 */
	protected String getMsgsi(){
		return (String)this.getParameter("msgsi");
	}

	/**
	 * Return value for input parameter msgno
	 */
	protected String getMsgno(){
		return (String)this.getParameter("msgno");
	}

	/**
	 * Return value for input parameter cuentasdisponibles
	 */
	protected List<String> getCuentasdisponibles(){
		return (List<String>)this.getParameter("cuentasdisponibles");
	}

	/**
	 * Return value for input parameter renovacionautomatica
	 */
	protected String getRenovacionautomatica(){
		return (String)this.getParameter("renovacionautomatica");
	}

	/**
	 * Return value for input parameter mediospago
	 */
	protected List<String> getMediospago(){
		return (List<String>)this.getParameter("mediospago");
	}

	/**
	 * Return value for input parameter tipogenero
	 */
	protected String getTipogenero(){
		return (String)this.getParameter("tipogenero");
	}

	/**
	 * Return value for input parameter descripciongenero
	 */
	protected String getDescripciongenero(){
		return (String)this.getParameter("descripciongenero");
	}

	/**
	 * Return value for input parameter idgenero
	 */
	protected String getIdgenero(){
		return (String)this.getParameter("idgenero");
	}

	/**
	 * Return value for input parameter valueCheckIndem
	 */
	protected String getValuecheckindem(){
		return (String)this.getParameter("valueCheckIndem");
	}

	/**
	 * Return value for input parameter valueCheckReclamo
	 */
	protected String getValuecheckreclamo(){
		return (String)this.getParameter("valueCheckReclamo");
	}

	/**
	 * Return value for input parameter valor
	 */
	protected String getValor(){
		return (String)this.getParameter("valor");
	}

	/**
	 * Return value for input parameter compania
	 */
	protected String getCompania(){
		return (String)this.getParameter("compania");
	}

	/**
	 * Return value for input parameter ramo
	 */
	protected String getRamo(){
		return (String)this.getParameter("ramo");
	}

	/**
	 * Return value for input parameter anio
	 */
	protected String getAnio(){
		return (String)this.getParameter("anio");
	}

	/**
	 * Return value for input parameter ideaseg
	 */
	protected String getIdeaseg(){
		return (String)this.getParameter("ideaseg");
	}

	/**
	 * Return value for input parameter actividad
	 */
	protected String getActividad(){
		return (String)this.getParameter("actividad");
	}

	/**
	 * Return value for input parameter infoadic
	 */
	protected String getInfoadic(){
		return (String)this.getParameter("infoadic");
	}

	/**
	 * Return value for input parameter numplaca
	 */
	protected String getNumplaca(){
		return (String)this.getParameter("numplaca");
	}

	/**
	 * Return value for input parameter numpisos
	 */
	protected String getNumpisos(){
		return (String)this.getParameter("numpisos");
	}

	/**
	 * Return value for input parameter indbis2
	 */
	protected String getIndbis2(){
		return (String)this.getParameter("indbis2");
	}

	/**
	 * Return value for input parameter literal2
	 */
	protected String getLiteral2(){
		return (String)this.getParameter("literal2");
	}

	/**
	 * Return value for input parameter indbis1
	 */
	protected String getIndbis1(){
		return (String)this.getParameter("indbis1");
	}

	/**
	 * Return value for input parameter literal
	 */
	protected String getLiteral(){
		return (String)this.getParameter("literal");
	}

	/**
	 * Return value for input parameter estructura
	 */
	protected String getEstructura(){
		return (String)this.getParameter("estructura");
	}

	/**
	 * Return value for input parameter tipopropiedad
	 */
	protected String getTipopropiedad(){
		return (String)this.getParameter("tipopropiedad");
	}

	/**
	 * Return value for input parameter tipoinmueble
	 */
	protected String getTipoinmueble(){
		return (String)this.getParameter("tipoinmueble");
	}

	/**
	 * Return value for input parameter tipovia
	 */
	protected String getTipovia(){
		return (String)this.getParameter("tipovia");
	}

	/**
	 * Return value for input parameter tipoter
	 */
	protected String getTipoter(){
		return (String)this.getParameter("tipoter");
	}

	/**
	 * Return value for input parameter zip
	 */
	protected String getZip(){
		return (String)this.getParameter("zip");
	}

	/**
	 * Return value for input parameter piso
	 */
	protected String getPiso(){
		return (String)this.getParameter("piso");
	}

	/**
	 * Return value for input parameter tipoestructura
	 */
	protected String getTipoestructura(){
		return (String)this.getParameter("tipoestructura");
	}

	/**
	 * Return value for input parameter tiporiesgo
	 */
	protected String getTiporiesgo(){
		return (String)this.getParameter("tiporiesgo");
	}

	/**
	 * Return value for input parameter codorientacion2
	 */
	protected String getCodorientacion2(){
		return (String)this.getParameter("codorientacion2");
	}

	/**
	 * Return value for input parameter codorientacion
	 */
	protected String getCodorientacion(){
		return (String)this.getParameter("codorientacion");
	}

	/**
	 * Return value for input parameter dirvalinterseccion
	 */
	protected String getDirvalinterseccion(){
		return (String)this.getParameter("dirvalinterseccion");
	}

	/**
	 * Return value for input parameter codcalle
	 */
	protected String getCodcalle(){
		return (String)this.getParameter("codcalle");
	}

	/**
	 * Return value for input parameter numero
	 */
	protected Long getNumero(){
		return (Long)this.getParameter("numero");
	}

	/**
	 * Return value for input parameter coddepartamento
	 */
	protected String getCoddepartamento(){
		return (String)this.getParameter("coddepartamento");
	}

	/**
	 * Return value for input parameter codgrpusr
	 */
	protected String getCodgrpusr(){
		return (String)this.getParameter("codgrpusr");
	}

	/**
	 * Return value for input parameter codprod
	 */
	protected String getCodprod(){
		return (String)this.getParameter("codprod");
	}

	/**
	 * Return value for input parameter codusr
	 */
	protected String getCodusr(){
		return (String)this.getParameter("codusr");
	}

	/**
	 * Return value for input parameter codplan
	 */
	protected String getCodplan(){
		return (String)this.getParameter("codplan");
	}

	/**
	 * Return value for input parameter revplan
	 */
	protected String getRevplan(){
		return (String)this.getParameter("revplan");
	}

	/**
	 * Return value for input parameter codcanal
	 */
	protected String getCodcanal(){
		return (String)this.getParameter("codcanal");
	}

	/**
	 * Return value for input parameter codsubcanal
	 */
	protected String getCodsubcanal(){
		return (String)this.getParameter("codsubcanal");
	}

	/**
	 * Return value for input parameter codlval
	 */
	protected String getCodlval(){
		return (String)this.getParameter("codlval");
	}

	/**
	 * Return value for input parameter tipolval
	 */
	protected String getTipolval(){
		return (String)this.getParameter("tipolval");
	}

	/**
	 * Return value for input parameter tipoid
	 */
	protected String getTipoid(){
		return (String)this.getParameter("tipoid");
	}

	/**
	 * Return value for input parameter numid
	 */
	protected Long getNumid(){
		return (Long)this.getParameter("numid");
	}

	/**
	 * Return value for input parameter codcli
	 */
	protected String getCodcli(){
		return (String)this.getParameter("codcli");
	}

	/**
	 * Return value for input parameter idepol
	 */
	protected Long getIdepol(){
		return (Long)this.getParameter("idepol");
	}

	/**
	 * Return value for input parameter numpol
	 */
	protected String getNumpol(){
		return (String)this.getParameter("numpol");
	}

	/**
	 * Return value for input parameter stspol
	 */
	protected String getStspol(){
		return (String)this.getParameter("stspol");
	}

	/**
	 * Return value for input parameter stssin
	 */
	protected String getStssin(){
		return (String)this.getParameter("stssin");
	}

	/**
	 * Return value for input parameter sumaAseg
	 */
	protected Long getSumaaseg(){
		return (Long)this.getParameter("sumaAseg");
	}

	/**
	 * Return value for input parameter periodicidadPago
	 */
	protected String getPeriodicidadpago(){
		return (String)this.getParameter("periodicidadPago");
	}

	/**
	 * Return value for input parameter departamento
	 */
	protected String getDepartamento(){
		return (String)this.getParameter("departamento");
	}

	/**
	 * Return value for input parameter ciudad
	 */
	protected String getCiudad(){
		return (String)this.getParameter("ciudad");
	}

	/**
	 * Return value for input parameter anioConstruccion
	 */
	protected String getAnioconstruccion(){
		return (String)this.getParameter("anioConstruccion");
	}

	/**
	 * Return value for input parameter nomter
	 */
	protected String getNomter(){
		return (String)this.getParameter("nomter");
	}

	/**
	 * Return value for input parameter apeter
	 */
	protected String getApeter(){
		return (String)this.getParameter("apeter");
	}

	/**
	 * Return value for input parameter dvid
	 */
	protected String getDvid(){
		return (String)this.getParameter("dvid");
	}

	/**
	 * Return value for input parameter direccion
	 */
	protected String getDireccion(){
		return (String)this.getParameter("direccion");
	}

	/**
	 * Return value for input parameter fecnac
	 */
	protected String getFecnac(){
		return (String)this.getParameter("fecnac");
	}

	/**
	 * Return value for input parameter descrip
	 */
	protected String getDescrip(){
		return (String)this.getParameter("descrip");
	}

	/**
	 * Return value for input parameter codpais
	 */
	protected String getCodpais(){
		return (String)this.getParameter("codpais");
	}

	/**
	 * Return value for input parameter indben
	 */
	protected String getIndben(){
		return (String)this.getParameter("indben");
	}

	/**
	 * Return value for input parameter indcobert
	 */
	protected String getIndcobert(){
		return (String)this.getParameter("indcobert");
	}

	/**
	 * Return value for input parameter stscert
	 */
	protected String getStscert(){
		return (String)this.getParameter("stscert");
	}

	/**
	 * Return value for input parameter fecinivig
	 */
	protected String getFecinivig(){
		return (String)this.getParameter("fecinivig");
	}

	/**
	 * Return value for input parameter fecfinvig
	 */
	protected String getFecfinvig(){
		return (String)this.getParameter("fecfinvig");
	}

	/**
	 * Return value for input parameter codestado
	 */
	protected String getCodestado(){
		return (String)this.getParameter("codestado");
	}

	/**
	 * Return value for input parameter descestado
	 */
	protected String getDescestado(){
		return (String)this.getParameter("descestado");
	}

	/**
	 * Return value for input parameter zonageografica
	 */
	protected String getZonageografica(){
		return (String)this.getParameter("zonageografica");
	}

	/**
	 * Return value for input parameter descciudad
	 */
	protected String getDescciudad(){
		return (String)this.getParameter("descciudad");
	}

	/**
	 * Return value for input parameter codciudad
	 */
	protected String getCodciudad(){
		return (String)this.getParameter("codciudad");
	}

	/**
	 * Return value for input parameter estrato
	 */
	protected Long getEstrato(){
		return (Long)this.getParameter("estrato");
	}

	/**
	 * Return value for input parameter codramocert
	 */
	protected String getCodramocert(){
		return (String)this.getParameter("codramocert");
	}

	/**
	 * Return value for input parameter numcot
	 */
	protected Long getNumcot(){
		return (Long)this.getParameter("numcot");
	}

	/**
	 * Return value for input parameter idecotiza
	 */
	protected Long getIdecotiza(){
		return (Long)this.getParameter("idecotiza");
	}

	/**
	 * Return value for input parameter clasebien
	 */
	protected String getClasebien(){
		return (String)this.getParameter("clasebien");
	}

	/**
	 * Return value for input parameter codbien
	 */
	protected String getCodbien(){
		return (String)this.getParameter("codbien");
	}

	/**
	 * Return value for input parameter descbien
	 */
	protected String getDescbien(){
		return (String)this.getParameter("descbien");
	}

	/**
	 * Return value for input parameter montobien
	 */
	protected Long getMontobien(){
		return (Long)this.getParameter("montobien");
	}

	/**
	 * Return value for input parameter ideclau
	 */
	protected Long getIdeclau(){
		return (Long)this.getParameter("ideclau");
	}

	/**
	 * Return value for input parameter descclau
	 */
	protected String getDescclau(){
		return (String)this.getParameter("descclau");
	}

	/**
	 * Return value for input parameter parentesco
	 */
	protected String getParentesco(){
		return (String)this.getParameter("parentesco");
	}

	/**
	 * Return value for input parameter codparentesco
	 */
	protected String getCodparentesco(){
		return (String)this.getParameter("codparentesco");
	}

	/**
	 * Return value for input parameter nomben
	 */
	protected String getNomben(){
		return (String)this.getParameter("nomben");
	}

	/**
	 * Return value for input parameter numben
	 */
	protected Long getNumben(){
		return (Long)this.getParameter("numben");
	}

	/**
	 * Return value for input parameter idaseg
	 */
	protected String getIdaseg(){
		return (String)this.getParameter("idaseg");
	}

	/**
	 * Return value for input parameter porcpart
	 */
	protected Long getPorcpart(){
		return (Long)this.getParameter("porcpart");
	}

	/**
	 * Return value for input parameter grupopol
	 */
	protected String getGrupopol(){
		return (String)this.getParameter("grupopol");
	}

	/**
	 * Return value for input parameter numcanttc
	 */
	protected Long getNumcanttc(){
		return (Long)this.getParameter("numcanttc");
	}

	/**
	 * Return value for input parameter induserasis
	 */
	protected String getInduserasis(){
		return (String)this.getParameter("induserasis");
	}

	/**
	 * Return value for input parameter indasegadic
	 */
	protected String getIndasegadic(){
		return (String)this.getParameter("indasegadic");
	}

	/**
	 * Return value for input parameter tipotomador
	 */
	protected String getTipotomador(){
		return (String)this.getParameter("tipotomador");
	}

	/**
	 * Return value for input parameter codmunicipio
	 */
	protected String getCodmunicipio(){
		return (String)this.getParameter("codmunicipio");
	}

	/**
	 * Return value for input parameter municipio
	 */
	protected String getMunicipio(){
		return (String)this.getParameter("municipio");
	}

	/**
	 * Return value for input parameter numordimp
	 */
	protected String getNumordimp(){
		return (String)this.getParameter("numordimp");
	}

	/**
	 * Return value for input parameter pais
	 */
	protected String getPais(){
		return (String)this.getParameter("pais");
	}

	/**
	 * Return value for input parameter codcobert
	 */
	protected String getCodcobert(){
		return (String)this.getParameter("codcobert");
	}

	/**
	 * Return value for input parameter desccobert
	 */
	protected String getDesccobert(){
		return (String)this.getParameter("desccobert");
	}

	/**
	 * Return value for input parameter porcreca
	 */
	protected Long getPorcreca(){
		return (Long)this.getParameter("porcreca");
	}

	/**
	 * Return value for input parameter nomusr
	 */
	protected String getNomusr(){
		return (String)this.getParameter("nomusr");
	}

	/**
	 * Return value for input parameter codsuc
	 */
	protected String getCodsuc(){
		return (String)this.getParameter("codsuc");
	}

	/**
	 * Return value for input parameter codcia
	 */
	protected String getCodcia(){
		return (String)this.getParameter("codcia");
	}

	/**
	 * Return value for input parameter codgrppol
	 */
	protected String getCodgrppol(){
		return (String)this.getParameter("codgrppol");
	}

	/**
	 * Return value for input parameter desccanal
	 */
	protected String getDesccanal(){
		return (String)this.getParameter("desccanal");
	}

	/**
	 * Return value for input parameter descsubcanal
	 */
	protected String getDescsubcanal(){
		return (String)this.getParameter("descsubcanal");
	}

	/**
	 * Return value for input parameter codofibanc
	 */
	protected Long getCodofibanc(){
		return (Long)this.getParameter("codofibanc");
	}

	/**
	 * Return value for input parameter idesmultinivel
	 */
	protected String getIdesmultinivel(){
		return (String)this.getParameter("idesmultinivel");
	}

	/**
	 * Return value for input parameter nomest
	 */
	protected String getNomest(){
		return (String)this.getParameter("nomest");
	}

	/**
	 * Return value for input parameter desclval
	 */
	protected String getDesclval(){
		return (String)this.getParameter("desclval");
	}

	/**
	 * Return value for input parameter numcert
	 */
	protected Long getNumcert(){
		return (Long)this.getParameter("numcert");
	}

	/**
	 * Return value for input parameter indcargabdacsel
	 */
	protected String getIndcargabdacsel(){
		return (String)this.getParameter("indcargabdacsel");
	}

	/**
	 * Return value for input parameter indcontproc
	 */
	protected String getIndcontproc(){
		return (String)this.getParameter("indcontproc");
	}

	/**
	 * Return value for input parameter nomtabla
	 */
	protected String getNomtabla(){
		return (String)this.getParameter("nomtabla");
	}

	/**
	 * Return value for input parameter desccampo
	 */
	protected String getDesccampo(){
		return (String)this.getParameter("desccampo");
	}

	/**
	 * Return value for input parameter blkweb
	 */
	protected String getBlkweb(){
		return (String)this.getParameter("blkweb");
	}

	/**
	 * Return value for input parameter ordenblkweb
	 */
	protected String getOrdenblkweb(){
		return (String)this.getParameter("ordenblkweb");
	}

	/**
	 * Return value for input parameter indtipodato
	 */
	protected String getIndtipodato(){
		return (String)this.getParameter("indtipodato");
	}

	/**
	 * Return value for input parameter isfixed
	 */
	protected String getIsfixed(){
		return (String)this.getParameter("isfixed");
	}

	/**
	 * Return value for input parameter panelkey
	 */
	protected String getPanelkey(){
		return (String)this.getParameter("panelkey");
	}

	/**
	 * Return value for input parameter ordensubpanel
	 */
	protected String getOrdensubpanel(){
		return (String)this.getParameter("ordensubpanel");
	}

	/**
	 * Return value for input parameter iseditable
	 */
	protected String getIseditable(){
		return (String)this.getParameter("iseditable");
	}

	/**
	 * Return value for input parameter isrequired
	 */
	protected String getIsrequired(){
		return (String)this.getParameter("isrequired");
	}

	/**
	 * Return value for input parameter afectacampo
	 */
	protected String getAfectacampo(){
		return (String)this.getParameter("afectacampo");
	}

	/**
	 * Return value for input parameter typepresenter
	 */
	protected String getTypepresenter(){
		return (String)this.getParameter("typepresenter");
	}

	/**
	 * Return value for input parameter tarjetasaseguradas
	 */
	protected List<CardsDTO> getTarjetasaseguradas(){
		return (List<CardsDTO>)this.getParameter("tarjetasaseguradas");
	}

	/**
	 * Return value for input parameter descplanprod
	 */
	protected String getDescplanprod(){
		return (String)this.getParameter("descplanprod");
	}

	/**
	 * Return value for input parameter descprod
	 */
	protected String getDescprod(){
		return (String)this.getParameter("descprod");
	}

	/**
	 * Return value for input parameter indafinnity
	 */
	protected String getIndafinnity(){
		return (String)this.getParameter("indafinnity");
	}

	/**
	 * Return value for input parameter idSessionExec
	 */
	protected String getIdsessionexec(){
		return (String)this.getParameter("idSessionExec");
	}

	/**
	 * Return value for input parameter message
	 */
	protected String getMessage(){
		return (String)this.getParameter("message");
	}

	/**
	 * Return value for input parameter codofiges
	 */
	protected String getCodofiges(){
		return (String)this.getParameter("codofiges");
	}

	/**
	 * Return value for input parameter checkbenefley
	 */
	protected String getCheckbenefley(){
		return (String)this.getParameter("checkbenefley");
	}

	/**
	 * Return value for input parameter checkbenefoneroso
	 */
	protected String getCheckbenefoneroso(){
		return (String)this.getParameter("checkbenefoneroso");
	}

	/**
	 * Return value for input parameter genero
	 */
	protected String getGenero(){
		return (String)this.getParameter("genero");
	}

	/**
	 * Return value for input parameter apellido
	 */
	protected String getApellido(){
		return (String)this.getParameter("apellido");
	}

	/**
	 * Return value for input parameter nombre
	 */
	protected String getNombre(){
		return (String)this.getParameter("nombre");
	}

	/**
	 * Return value for input parameter codgenero
	 */
	protected String getCodgenero(){
		return (String)this.getParameter("codgenero");
	}

	/**
	 * Return value for input parameter descgenero
	 */
	protected String getDescgenero(){
		return (String)this.getParameter("descgenero");
	}

	/**
	 * Return value for input parameter tipooperacion
	 */
	protected String getTipooperacion(){
		return (String)this.getParameter("tipooperacion");
	}

	/**
	 * Return value for input parameter numoper
	 */
	protected String getNumoper(){
		return (String)this.getParameter("numoper");
	}

	/**
	 * Return value for input parameter metodoreporte
	 */
	protected String getMetodoreporte(){
		return (String)this.getParameter("metodoreporte");
	}

	/**
	 * Return value for input parameter apuntamiento
	 */
	protected String getApuntamiento(){
		return (String)this.getParameter("apuntamiento");
	}

	/**
	 * Return value for input parameter id
	 */
	protected String getId(){
		return (String)this.getParameter("id");
	}

	/**
	 * Return value for input parameter helptopicid
	 */
	protected String getHelptopicid(){
		return (String)this.getParameter("helptopicid");
	}

	/**
	 * Return value for input parameter apeben
	 */
	protected String getApeben(){
		return (String)this.getParameter("apeben");
	}

	/**
	 * Return value for input parameter gobalcondlaboral
	 */
	protected String getGobalcondlaboral(){
		return (String)this.getParameter("gobalcondlaboral");
	}

	/**
	 * Return value for input parameter method
	 */
	protected String getMethod(){
		return (String)this.getParameter("method");
	}

	/**
	 * Return value for input parameter text
	 */
	protected String getText(){
		return (String)this.getParameter("text");
	}

	/**
	 * Return value for input parameter bean
	 */
	protected String getBean(){
		return (String)this.getParameter("bean");
	}

	/**
	 * Return value for input parameter selected
	 */
	protected String getSelected(){
		return (String)this.getParameter("selected");
	}

	/**
	 * Return value for input parameter codarea
	 */
	protected String getCodarea(){
		return (String)this.getParameter("codarea");
	}

	/**
	 * Return value for input parameter stsprod
	 */
	protected String getStsprod(){
		return (String)this.getParameter("stsprod");
	}

	/**
	 * Return value for input parameter idpolcot
	 */
	protected String getIdpolcot(){
		return (String)this.getParameter("idpolcot");
	}

	/**
	 * Return value for input parameter numctto
	 */
	protected String getNumctto(){
		return (String)this.getParameter("numctto");
	}

	/**
	 * Return value for input parameter stscot
	 */
	protected String getStscot(){
		return (String)this.getParameter("stscot");
	}

	/**
	 * Return value for input parameter fecsolic
	 */
	protected String getFecsolic(){
		return (String)this.getParameter("fecsolic");
	}

	/**
	 * Return value for input parameter proveedor
	 */
	protected String getProveedor(){
		return (String)this.getParameter("proveedor");
	}

	/**
	 * Return value for input parameter territorial
	 */
	protected String getTerritorial(){
		return (String)this.getParameter("territorial");
	}

	/**
	 * Return value for input parameter zona
	 */
	protected String getZona(){
		return (String)this.getParameter("zona");
	}

	/**
	 * Return value for input parameter sucursal
	 */
	protected String getSucursal(){
		return (String)this.getParameter("sucursal");
	}

	/**
	 * Return value for input parameter fecren
	 */
	protected String getFecren(){
		return (String)this.getParameter("fecren");
	}

	/**
	 * Return value for input parameter fecfin
	 */
	protected String getFecfin(){
		return (String)this.getParameter("fecfin");
	}

	/**
	 * Return value for input parameter fecing
	 */
	protected String getFecing(){
		return (String)this.getParameter("fecing");
	}

	/**
	 * Return value for input parameter formpago
	 */
	protected String getFormpago(){
		return (String)this.getParameter("formpago");
	}

	/**
	 * Return value for input parameter cnumcot
	 */
	protected String getCnumcot(){
		return (String)this.getParameter("cnumcot");
	}

	/**
	 * Return value for input parameter pnumcot
	 */
	protected String getPnumcot(){
		return (String)this.getParameter("pnumcot");
	}

	/**
	 * Return value for input parameter ciuedo
	 */
	protected String getCiuedo(){
		return (String)this.getParameter("ciuedo");
	}

	/**
	 * Return value for input parameter cuotacamp
	 */
	protected String getCuotacamp(){
		return (String)this.getParameter("cuotacamp");
	}

	/**
	 * Return value for input parameter porccamp
	 */
	protected String getPorccamp(){
		return (String)this.getParameter("porccamp");
	}

	/**
	 * Return value for input parameter idecamp
	 */
	protected String getIdecamp(){
		return (String)this.getParameter("idecamp");
	}

	/**
	 * Return value for input parameter utilidad
	 */
	protected String getUtilidad(){
		return (String)this.getParameter("utilidad");
	}

	/**
	 * Return value for input parameter plan
	 */
	protected String getPlan(){
		return (String)this.getParameter("plan");
	}

	/**
	 * Return value for input parameter codmoneda
	 */
	protected String getCodmoneda(){
		return (String)this.getParameter("codmoneda");
	}

	/**
	 * Return value for input parameter primaadic
	 */
	protected String getPrimaadic(){
		return (String)this.getParameter("primaadic");
	}

	/**
	 * Return value for input parameter primagf
	 */
	protected String getPrimagf(){
		return (String)this.getParameter("primagf");
	}

	/**
	 * Return value for input parameter cantidad
	 */
	protected String getCantidad(){
		return (String)this.getParameter("cantidad");
	}

	/**
	 * Return value for input parameter codparent
	 */
	protected String getCodparent(){
		return (String)this.getParameter("codparent");
	}

	/**
	 * Return value for input parameter codramoplan
	 */
	protected String getCodramoplan(){
		return (String)this.getParameter("codramoplan");
	}

	/**
	 * Return value for input parameter telefono1Array
	 */
	protected List<String> getTelefono1array(){
		return (List<String>)this.getParameter("telefono1Array");
	}

	/**
	 * Return value for input parameter telefono2Array
	 */
	protected List<String> getTelefono2array(){
		return (List<String>)this.getParameter("telefono2Array");
	}

	/**
	 * Return value for input parameter telefono3Array
	 */
	protected List<String> getTelefono3array(){
		return (List<String>)this.getParameter("telefono3Array");
	}

	/**
	 * Return value for input parameter direccioncorrespondencia
	 */
	protected List<String> getDireccioncorrespondencia(){
		return (List<String>)this.getParameter("direccioncorrespondencia");
	}

	/**
	 * Return value for input parameter direccionresidenciarray
	 */
	protected List<String> getDireccionresidenciarray(){
		return (List<String>)this.getParameter("direccionresidenciarray");
	}

	/**
	 * Return value for input parameter emailarray
	 */
	protected List<String> getEmailarray(){
		return (List<String>)this.getParameter("emailarray");
	}

	/**
	 * Return value for input parameter codmediopago
	 */
	protected String getCodmediopago(){
		return (String)this.getParameter("codmediopago");
	}

	/**
	 * Return value for input parameter descmediopago
	 */
	protected String getDescmediopago(){
		return (String)this.getParameter("descmediopago");
	}

	/**
	 * Return value for input parameter indbenefone
	 */
	protected String getIndbenefone(){
		return (String)this.getParameter("indbenefone");
	}

	/**
	 * Return value for input parameter induseasis
	 */
	protected String getInduseasis(){
		return (String)this.getParameter("induseasis");
	}

	/**
	 * Return value for input parameter benfone
	 */
	protected String getBenfone(){
		return (String)this.getParameter("benfone");
	}

	/**
	 * Return value for input parameter useasis
	 */
	protected String getUseasis(){
		return (String)this.getParameter("useasis");
	}

	/**
	 * Return value for input parameter filtro
	 */
	protected String getFiltro(){
		return (String)this.getParameter("filtro");
	}

	/**
	 * Return value for input parameter documento
	 */
	protected String getDocumento(){
		return (String)this.getParameter("documento");
	}

	/**
	 * Return value for input parameter fechaini
	 */
	protected String getFechaini(){
		return (String)this.getParameter("fechaini");
	}

	/**
	 * Return value for input parameter fechafin
	 */
	protected String getFechafin(){
		return (String)this.getParameter("fechafin");
	}

	/**
	 * Return value for input parameter status
	 */
	protected String getStatus(){
		return (String)this.getParameter("status");
	}

	/**
	 * Return value for input parameter numcertini
	 */
	protected String getNumcertini(){
		return (String)this.getParameter("numcertini");
	}

	/**
	 * Return value for input parameter numcertfin
	 */
	protected String getNumcertfin(){
		return (String)this.getParameter("numcertfin");
	}

	/**
	 * Return value for input parameter codformpago
	 */
	protected String getCodformpago(){
		return (String)this.getParameter("codformpago");
	}

	/**
	 * Return value for input parameter codofiemi
	 */
	protected String getCodofiemi(){
		return (String)this.getParameter("codofiemi");
	}

	/**
	 * Return value for input parameter fecinipol
	 */
	protected String getFecinipol(){
		return (String)this.getParameter("fecinipol");
	}

	/**
	 * Return value for input parameter fechainicio
	 */
	protected String getFechainicio(){
		return (String)this.getParameter("fechainicio");
	}

	/**
	 * Return value for input parameter fechfecoper
	 */
	protected String getFechfecoper(){
		return (String)this.getParameter("fechfecoper");
	}

	/**
	 * Return value for input parameter compnumpol
	 */
	protected String getCompnumpol(){
		return (String)this.getParameter("compnumpol");
	}

	/**
	 * Return value for input parameter fecoper
	 */
	protected String getFecoper(){
		return (String)this.getParameter("fecoper");
	}

	/**
	 * Return value for input parameter codgestor
	 */
	protected String getCodgestor(){
		return (String)this.getParameter("codgestor");
	}

	/**
	 * Return value for input parameter codofisusc
	 */
	protected String getCodofisusc(){
		return (String)this.getParameter("codofisusc");
	}

	/**
	 * Return value for input parameter motivo
	 */
	protected String getMotivo(){
		return (String)this.getParameter("motivo");
	}

	/**
	 * Return value for input parameter gestor
	 */
	protected String getGestor(){
		return (String)this.getParameter("gestor");
	}

	/**
	 * Return value for input parameter fecexc
	 */
	protected String getFecexc(){
		return (String)this.getParameter("fecexc");
	}

	/**
	 * Return value for input parameter fechainipol
	 */
	protected String getFechainipol(){
		return (String)this.getParameter("fechainipol");
	}

	/**
	 * Return value for input parameter fecfincotiza
	 */
	protected String getFecfincotiza(){
		return (String)this.getParameter("fecfincotiza");
	}

	/**
	 * Return value for input parameter nompercotiza
	 */
	protected String getNompercotiza(){
		return (String)this.getParameter("nompercotiza");
	}

	/**
	 * Return value for input parameter idcliente
	 */
	protected String getIdcliente(){
		return (String)this.getParameter("idcliente");
	}

	/**
	 * Return value for input parameter codperiodicpago
	 */
	protected String getCodperiodicpago(){
		return (String)this.getParameter("codperiodicpago");
	}

	/**
	 * Return value for input parameter cotestado
	 */
	protected String getCotestado(){
		return (String)this.getParameter("cotestado");
	}

	/**
	 * Return value for input parameter indrenauto
	 */
	protected String getIndrenauto(){
		return (String)this.getParameter("indrenauto");
	}

	/**
	 * Return value for input parameter direc
	 */
	protected String getDirec(){
		return (String)this.getParameter("direc");
	}

	/**
	 * Return value for input parameter codsuplemento
	 */
	protected String getCodsuplemento(){
		return (String)this.getParameter("codsuplemento");
	}

	/**
	 * Return value for input parameter suplemento
	 */
	protected String getSuplemento(){
		return (String)this.getParameter("suplemento");
	}

	/**
	 * Return value for input parameter codmotivo
	 */
	protected String getCodmotivo(){
		return (String)this.getParameter("codmotivo");
	}

	/**
	 * Return value for input parameter codsubmotivo
	 */
	protected String getCodsubmotivo(){
		return (String)this.getParameter("codsubmotivo");
	}

	/**
	 * Return value for input parameter submotivo
	 */
	protected String getSubmotivo(){
		return (String)this.getParameter("submotivo");
	}

	/**
	 * Return value for input parameter fechasuplemento
	 */
	protected String getFechasuplemento(){
		return (String)this.getParameter("fechasuplemento");
	}

	/**
	 * Return value for input parameter includemode
	 */
	protected String getIncludemode(){
		return (String)this.getParameter("includemode");
	}

	/**
	 * Return value for input parameter primaperi
	 */
	protected String getPrimaperi(){
		return (String)this.getParameter("primaperi");
	}

	/**
	 * Return value for input parameter primaperidica
	 */
	protected String getPrimaperidica(){
		return (String)this.getParameter("primaperidica");
	}

	/**
	 * Return value for input parameter primaanual
	 */
	protected String getPrimaanual(){
		return (String)this.getParameter("primaanual");
	}

	/**
	 * Return value for input parameter coaseguro
	 */
	protected String getCoaseguro(){
		return (String)this.getParameter("coaseguro");
	}

	/**
	 * Return value for input parameter periodicidad
	 */
	protected String getPeriodicidad(){
		return (String)this.getParameter("periodicidad");
	}

	/**
	 * Return value for input parameter sumaasegurado
	 */
	protected String getSumaasegurado(){
		return (String)this.getParameter("sumaasegurado");
	}

	/**
	 * Return value for input parameter direccioncorr
	 */
	protected String getDireccioncorr(){
		return (String)this.getParameter("direccioncorr");
	}

	/**
	 * Return value for input parameter direccionres
	 */
	protected String getDireccionres(){
		return (String)this.getParameter("direccionres");
	}

	/**
	 * Return value for input parameter tipocuenta
	 */
	protected String getTipocuenta(){
		return (String)this.getParameter("tipocuenta");
	}

	/**
	 * Return value for input parameter celular
	 */
	protected String getCelular(){
		return (String)this.getParameter("celular");
	}

	/**
	 * Return value for input parameter checkrenauto
	 */
	protected String getCheckrenauto(){
		return (String)this.getParameter("checkrenauto");
	}

	/**
	 * Return value for input parameter cambiorenauto
	 */
	protected String getCambiorenauto(){
		return (String)this.getParameter("cambiorenauto");
	}

	/**
	 * Return value for input parameter codexclusion
	 */
	protected String getCodexclusion(){
		return (String)this.getParameter("codexclusion");
	}

	/**
	 * Return value for input parameter motivoexclusion
	 */
	protected String getMotivoexclusion(){
		return (String)this.getParameter("motivoexclusion");
	}

	/**
	 * Return value for input parameter observacion
	 */
	protected String getObservacion(){
		return (String)this.getParameter("observacion");
	}

	/**
	 * Return value for input parameter codramo
	 */
	protected String getCodramo(){
		return (String)this.getParameter("codramo");
	}

	/**
	 * Return value for input parameter capital
	 */
	protected String getCapital(){
		return (String)this.getParameter("capital");
	}

	/**
	 * Return value for input parameter indicevariable
	 */
	protected String getIndicevariable(){
		return (String)this.getParameter("indicevariable");
	}

	/**
	 * Return value for input parameter prima
	 */
	protected String getPrima(){
		return (String)this.getParameter("prima");
	}

	/**
	 * Return value for input parameter sobreprima
	 */
	protected String getSobreprima(){
		return (String)this.getParameter("sobreprima");
	}

	/**
	 * Return value for input parameter extraprima
	 */
	protected String getExtraprima(){
		return (String)this.getParameter("extraprima");
	}

	/**
	 * Return value for input parameter deducible
	 */
	protected String getDeducible(){
		return (String)this.getParameter("deducible");
	}

	/**
	 * Return value for input parameter stscobert
	 */
	protected String getStscobert(){
		return (String)this.getParameter("stscobert");
	}

	/**
	 * Return value for input parameter indcobertoblig
	 */
	protected String getIndcobertoblig(){
		return (String)this.getParameter("indcobertoblig");
	}

	/**
	 * Return value for input parameter idecobert
	 */
	protected String getIdecobert(){
		return (String)this.getParameter("idecobert");
	}

	/**
	 * Return value for input parameter tasa
	 */
	protected String getTasa(){
		return (String)this.getParameter("tasa");
	}

	/**
	 * Return value for input parameter bbvasbr
	 */
	protected String getBbvasbr(){
		return (String)this.getParameter("bbvasbr");
	}

	/**
	 * Return value for input parameter othersbr
	 */
	protected String getOthersbr(){
		return (String)this.getParameter("othersbr");
	}

	/**
	 * Return value for input parameter nosbr
	 */
	protected String getNosbr(){
		return (String)this.getParameter("nosbr");
	}

	/**
	 * Return value for input parameter clasecli
	 */
	protected String getClasecli(){
		return (String)this.getParameter("clasecli");
	}

	/**
	 * Return value for input parameter fecanul
	 */
	protected String getFecanul(){
		return (String)this.getParameter("fecanul");
	}

	/**
	 * Return value for input parameter frcinipol
	 */
	protected String getFrcinipol(){
		return (String)this.getParameter("frcinipol");
	}

	/**
	 * Return value for input parameter tiposusc
	 */
	protected String getTiposusc(){
		return (String)this.getParameter("tiposusc");
	}

	/**
	 * Return value for input parameter tiposuscprod
	 */
	protected String getTiposuscprod(){
		return (String)this.getParameter("tiposuscprod");
	}

	/**
	 * Return value for input parameter idedirec
	 */
	protected String getIdedirec(){
		return (String)this.getParameter("idedirec");
	}

	/**
	 * Return value for input parameter codtipovia
	 */
	protected String getCodtipovia(){
		return (String)this.getParameter("codtipovia");
	}

	/**
	 * Return value for input parameter numero2
	 */
	protected String getNumero2(){
		return (String)this.getParameter("numero2");
	}

	/**
	 * Return value for input parameter descripstatus
	 */
	protected String getDescripstatus(){
		return (String)this.getParameter("descripstatus");
	}

	/**
	 * Return value for input parameter indasegtitular
	 */
	protected String getIndasegtitular(){
		return (String)this.getParameter("indasegtitular");
	}

	/**
	 * Return value for input parameter numsolicitud
	 */
	protected String getNumsolicitud(){
		return (String)this.getParameter("numsolicitud");
	}

	/**
	 * Return value for input parameter stsaseg
	 */
	protected String getStsaseg(){
		return (String)this.getParameter("stsaseg");
	}

	/**
	 * Return value for input parameter descexclusion
	 */
	protected String getDescexclusion(){
		return (String)this.getParameter("descexclusion");
	}

	/**
	 * Return value for input parameter efecto
	 */
	protected String getEfecto(){
		return (String)this.getParameter("efecto");
	}

	/**
	 * Return value for input parameter emision
	 */
	protected String getEmision(){
		return (String)this.getParameter("emision");
	}

	/**
	 * Return value for input parameter cobertura
	 */
	protected String getCobertura(){
		return (String)this.getParameter("cobertura");
	}

	/**
	 * Return value for input parameter codcapital
	 */
	protected String getCodcapital(){
		return (String)this.getParameter("codcapital");
	}

	/**
	 * Return value for input parameter fechaexc
	 */
	protected String getFechaexc(){
		return (String)this.getParameter("fechaexc");
	}

	/**
	 * Return value for input parameter stscobertura
	 */
	protected String getStscobertura(){
		return (String)this.getParameter("stscobertura");
	}

	/**
	 * Return value for input parameter participacion
	 */
	protected String getParticipacion(){
		return (String)this.getParameter("participacion");
	}

	/**
	 * Return value for input parameter recibo
	 */
	protected String getRecibo(){
		return (String)this.getParameter("recibo");
	}

	/**
	 * Return value for input parameter tipoop
	 */
	protected String getTipoop(){
		return (String)this.getParameter("tipoop");
	}

	/**
	 * Return value for input parameter saldo
	 */
	protected String getSaldo(){
		return (String)this.getParameter("saldo");
	}

	/**
	 * Return value for input parameter clave
	 */
	protected String getClave(){
		return (String)this.getParameter("clave");
	}

	/**
	 * Return value for input parameter poliza
	 */
	protected String getPoliza(){
		return (String)this.getParameter("poliza");
	}

	/**
	 * Return value for input parameter responsabledepago
	 */
	protected String getResponsabledepago(){
		return (String)this.getParameter("responsabledepago");
	}

	/**
	 * Return value for input parameter numdocumento
	 */
	protected String getNumdocumento(){
		return (String)this.getParameter("numdocumento");
	}

	/**
	 * Return value for input parameter primabruta
	 */
	protected String getPrimabruta(){
		return (String)this.getParameter("primabruta");
	}

	/**
	 * Return value for input parameter numfinanc
	 */
	protected String getNumfinanc(){
		return (String)this.getParameter("numfinanc");
	}

	/**
	 * Return value for input parameter n
	 */
	protected String getN(){
		return (String)this.getParameter("n");
	}

	/**
	 * Return value for input parameter retribucion
	 */
	protected String getRetribucion(){
		return (String)this.getParameter("retribucion");
	}

	/**
	 * Return value for input parameter iva
	 */
	protected String getIva(){
		return (String)this.getParameter("iva");
	}

	/**
	 * Return value for input parameter reteiva
	 */
	protected String getReteiva(){
		return (String)this.getParameter("reteiva");
	}

	/**
	 * Return value for input parameter reteica
	 */
	protected String getReteica(){
		return (String)this.getParameter("reteica");
	}

	/**
	 * Return value for input parameter retefue
	 */
	protected String getRetefue(){
		return (String)this.getParameter("retefue");
	}

	/**
	 * Return value for input parameter ordenpago
	 */
	protected String getOrdenpago(){
		return (String)this.getParameter("ordenpago");
	}

	/**
	 * Return value for input parameter nrogiro
	 */
	protected String getNrogiro(){
		return (String)this.getParameter("nrogiro");
	}

	/**
	 * Return value for input parameter fechacobro
	 */
	protected String getFechacobro(){
		return (String)this.getParameter("fechacobro");
	}

	/**
	 * Return value for input parameter recpagouordpago
	 */
	protected String getRecpagouordpago(){
		return (String)this.getParameter("recpagouordpago");
	}

	/**
	 * Return value for input parameter sldofactmoneda
	 */
	protected String getSldofactmoneda(){
		return (String)this.getParameter("sldofactmoneda");
	}

	/**
	 * Return value for input parameter nivel
	 */
	protected String getNivel(){
		return (String)this.getParameter("nivel");
	}

	/**
	 * Return value for input parameter codigo
	 */
	protected String getCodigo(){
		return (String)this.getParameter("codigo");
	}

	/**
	 * Return value for input parameter clausula
	 */
	protected String getClausula(){
		return (String)this.getParameter("clausula");
	}

	/**
	 * Return value for input parameter anexo
	 */
	protected String getAnexo(){
		return (String)this.getParameter("anexo");
	}

	/**
	 * Return value for input parameter ideclaucert
	 */
	protected String getIdeclaucert(){
		return (String)this.getParameter("ideclaucert");
	}

	/**
	 * Return value for input parameter texto
	 */
	protected String getTexto(){
		return (String)this.getParameter("texto");
	}

	/**
	 * Return value for input parameter siniestro
	 */
	protected String getSiniestro(){
		return (String)this.getParameter("siniestro");
	}

	/**
	 * Return value for input parameter fnotificacion
	 */
	protected String getFnotificacion(){
		return (String)this.getParameter("fnotificacion");
	}

	/**
	 * Return value for input parameter causa
	 */
	protected String getCausa(){
		return (String)this.getParameter("causa");
	}

	/**
	 * Return value for input parameter fsiniestro
	 */
	protected String getFsiniestro(){
		return (String)this.getParameter("fsiniestro");
	}

	/**
	 * Return value for input parameter fmodificacion
	 */
	protected String getFmodificacion(){
		return (String)this.getParameter("fmodificacion");
	}

	/**
	 * Return value for input parameter boton
	 */
	protected String getBoton(){
		return (String)this.getParameter("boton");
	}

	/**
	 * Return value for input parameter servicio
	 */
	protected String getServicio(){
		return (String)this.getParameter("servicio");
	}

	/**
	 * Return value for input parameter codmodalidad
	 */
	protected String getCodmodalidad(){
		return (String)this.getParameter("codmodalidad");
	}

	/**
	 * Return value for input parameter modalidad
	 */
	protected String getModalidad(){
		return (String)this.getParameter("modalidad");
	}

	/**
	 * Return value for input parameter option
	 */
	protected String getOption(){
		return (String)this.getParameter("option");
	}

	/**
	 * Return value for input parameter customeridtype
	 */
	protected String getCustomeridtype(){
		return (String)this.getParameter("customeridtype");
	}

	/**
	 * Return value for input parameter customeridnumber
	 */
	protected String getCustomeridnumber(){
		return (String)this.getParameter("customeridnumber");
	}

	/**
	 * Return value for input parameter renewaltype
	 */
	protected String getRenewaltype(){
		return (String)this.getParameter("renewaltype");
	}

	/**
	 * Return value for input parameter policystatus
	 */
	protected String getPolicystatus(){
		return (String)this.getParameter("policystatus");
	}

	/**
	 * Return value for input parameter paymentperiod
	 */
	protected String getPaymentperiod(){
		return (String)this.getParameter("paymentperiod");
	}

	/**
	 * Return value for input parameter effectivestartdate
	 */
	protected String getEffectivestartdate(){
		return (String)this.getParameter("effectivestartdate");
	}

	/**
	 * Return value for input parameter renewaldate
	 */
	protected String getRenewaldate(){
		return (String)this.getParameter("renewaldate");
	}

	/**
	 * Return value for input parameter directdebitaccount
	 */
	protected String getDirectdebitaccount(){
		return (String)this.getParameter("directdebitaccount");
	}

	/**
	 * Return value for input parameter insuredvalue
	 */
	protected String getInsuredvalue(){
		return (String)this.getParameter("insuredvalue");
	}

	/**
	 * Return value for input parameter managementoffice
	 */
	protected String getManagementoffice(){
		return (String)this.getParameter("managementoffice");
	}

	/**
	 * Return value for input parameter insuranceproductcode
	 */
	protected String getInsuranceproductcode(){
		return (String)this.getParameter("insuranceproductcode");
	}

	/**
	 * Return value for input parameter usermanagingpolicy
	 */
	protected String getUsermanagingpolicy(){
		return (String)this.getParameter("usermanagingpolicy");
	}

	/**
	 * Return value for input parameter operationdate
	 */
	protected String getOperationdate(){
		return (String)this.getParameter("operationdate");
	}

	/**
	 * Return value for input parameter premiumamount
	 */
	protected String getPremiumamount(){
		return (String)this.getParameter("premiumamount");
	}

	/**
	 * Return value for input parameter altamiraaccountnumber
	 */
	protected String getAltamiraaccountnumber(){
		return (String)this.getParameter("altamiraaccountnumber");
	}

	/**
	 * Return value for input parameter paymentreference
	 */
	protected String getPaymentreference(){
		return (String)this.getParameter("paymentreference");
	}

	/**
	 * Return value for input parameter amountvalue
	 */
	protected String getAmountvalue(){
		return (String)this.getParameter("amountvalue");
	}

	/**
	 * Return value for input parameter operationtime
	 */
	protected String getOperationtime(){
		return (String)this.getParameter("operationtime");
	}

	/**
	 * Return value for input parameter userresponsible
	 */
	protected String getUserresponsible(){
		return (String)this.getParameter("userresponsible");
	}

	/**
	 * Return value for input parameter description
	 */
	protected String getDescription(){
		return (String)this.getParameter("description");
	}

	/**
	 * Return value for input parameter policynumberweb
	 */
	protected String getPolicynumberweb(){
		return (String)this.getParameter("policynumberweb");
	}

	/**
	 * Return value for input parameter customerpolicynumber
	 */
	protected String getCustomerpolicynumber(){
		return (String)this.getParameter("customerpolicynumber");
	}

	/**
	 * Return value for input parameter ocupacionarray
	 */
	protected List<String> getOcupacionarray(){
		return (List<String>)this.getParameter("ocupacionarray");
	}

	/**
	 * Return value for input parameter planarray
	 */
	protected List<String> getPlanarray(){
		return (List<String>)this.getParameter("planarray");
	}

	/**
	 * Return value for input parameter departamentoarray
	 */
	protected List<String> getDepartamentoarray(){
		return (List<String>)this.getParameter("departamentoarray");
	}

	/**
	 * Return value for input parameter ciudadarray
	 */
	protected List<String> getCiudadarray(){
		return (List<String>)this.getParameter("ciudadarray");
	}

	/**
	 * Return value for input parameter estratoarray
	 */
	protected List<String> getEstratoarray(){
		return (List<String>)this.getParameter("estratoarray");
	}

	/**
	 * Return value for input parameter dni
	 */
	protected String getDni(){
		return (String)this.getParameter("dni");
	}

	/**
	 * Return value for input parameter descdni
	 */
	protected String getDescdni(){
		return (String)this.getParameter("descdni");
	}

	/**
	 * Return value for input parameter tipofecha
	 */
	protected String getTipofecha(){
		return (String)this.getParameter("tipofecha");
	}

	/**
	 * Return value for input parameter certificadoinicial
	 */
	protected String getCertificadoinicial(){
		return (String)this.getParameter("certificadoinicial");
	}

	/**
	 * Return value for input parameter certificadofinal
	 */
	protected String getCertificadofinal(){
		return (String)this.getParameter("certificadofinal");
	}

	/**
	 * Return value for input parameter producto
	 */
	protected String getProducto(){
		return (String)this.getParameter("producto");
	}

	/**
	 * Return value for input parameter oper
	 */
	protected String getOper(){
		return (String)this.getParameter("oper");
	}

	/**
	 * Return value for input parameter tproduc
	 */
	protected String getTproduc(){
		return (String)this.getParameter("tproduc");
	}

	/**
	 * Return value for input parameter cpoliza
	 */
	protected String getCpoliza(){
		return (String)this.getParameter("cpoliza");
	}

	/**
	 * Return value for input parameter tpoliza
	 */
	protected String getTpoliza(){
		return (String)this.getParameter("tpoliza");
	}

	/**
	 * Return value for input parameter bmodpag
	 */
	protected String getBmodpag(){
		return (String)this.getParameter("bmodpag");
	}

	/**
	 * Return value for input parameter fefecto
	 */
	protected String getFefecto(){
		return (String)this.getParameter("fefecto");
	}

	/**
	 * Return value for input parameter cperson
	 */
	protected String getCperson(){
		return (String)this.getParameter("cperson");
	}

	/**
	 * Return value for input parameter tdninit
	 */
	protected String getTdninit(){
		return (String)this.getParameter("tdninit");
	}

	/**
	 * Return value for input parameter tapell1
	 */
	protected String getTapell1(){
		return (String)this.getParameter("tapell1");
	}

	/**
	 * Return value for input parameter tapell2
	 */
	protected String getTapell2(){
		return (String)this.getParameter("tapell2");
	}

	/**
	 * Return value for input parameter nombre1
	 */
	protected String getNombre1(){
		return (String)this.getParameter("nombre1");
	}

	/**
	 * Return value for input parameter bestado
	 */
	protected String getBestado(){
		return (String)this.getParameter("bestado");
	}

	/**
	 * Return value for input parameter cproduc
	 */
	protected String getCproduc(){
		return (String)this.getParameter("cproduc");
	}

	/**
	 * Return value for input parameter trotulo1
	 */
	protected String getTrotulo1(){
		return (String)this.getParameter("trotulo1");
	}

	/**
	 * Return value for input parameter cmodali
	 */
	protected String getCmodali(){
		return (String)this.getParameter("cmodali");
	}

	/**
	 * Return value for input parameter nvermod
	 */
	protected String getNvermod(){
		return (String)this.getParameter("nvermod");
	}

	/**
	 * Return value for input parameter trotulo2
	 */
	protected String getTrotulo2(){
		return (String)this.getParameter("trotulo2");
	}

	/**
	 * Return value for input parameter coficin
	 */
	protected String getCoficin(){
		return (String)this.getParameter("coficin");
	}

	/**
	 * Return value for input parameter tnombre
	 */
	protected String getTnombre(){
		return (String)this.getParameter("tnombre");
	}

	/**
	 * Return value for input parameter ccompan
	 */
	protected String getCcompan(){
		return (String)this.getParameter("ccompan");
	}

	/**
	 * Return value for input parameter cmotivodesc
	 */
	protected String getCmotivodesc(){
		return (String)this.getParameter("cmotivodesc");
	}

	/**
	 * Return value for input parameter nmovimi
	 */
	protected String getNmovimi(){
		return (String)this.getParameter("nmovimi");
	}

	/**
	 * Return value for input parameter btipmov
	 */
	protected String getBtipmov(){
		return (String)this.getParameter("btipmov");
	}

	/**
	 * Return value for input parameter femisio
	 */
	protected String getFemisio(){
		return (String)this.getParameter("femisio");
	}

	/**
	 * Return value for input parameter cmotivo
	 */
	protected String getCmotivo(){
		return (String)this.getParameter("cmotivo");
	}

	/**
	 * Return value for input parameter crecibo
	 */
	protected String getCrecibo(){
		return (String)this.getParameter("crecibo");
	}

	/**
	 * Return value for input parameter tusuari
	 */
	protected String getTusuari(){
		return (String)this.getParameter("tusuari");
	}

	/**
	 * Return value for input parameter ttermin
	 */
	protected String getTtermin(){
		return (String)this.getParameter("ttermin");
	}

	/**
	 * Return value for input parameter nhormov
	 */
	protected String getNhormov(){
		return (String)this.getParameter("nhormov");
	}

	/**
	 * Return value for input parameter nanexos
	 */
	protected String getNanexos(){
		return (String)this.getParameter("nanexos");
	}

	/**
	 * Return value for input parameter bmotivo
	 */
	protected String getBmotivo(){
		return (String)this.getParameter("bmotivo");
	}

	/**
	 * Return value for input parameter brepalt
	 */
	protected String getBrepalt(){
		return (String)this.getParameter("brepalt");
	}

	/**
	 * Return value for input parameter tipogarantia
	 */
	protected String getTipogarantia(){
		return (String)this.getParameter("tipogarantia");
	}

	/**
	 * Return value for input parameter amparo
	 */
	protected String getAmparo(){
		return (String)this.getParameter("amparo");
	}

	/**
	 * Return value for input parameter tipo
	 */
	protected String getTipo(){
		return (String)this.getParameter("tipo");
	}

	/**
	 * Return value for input parameter agente
	 */
	protected String getAgente(){
		return (String)this.getParameter("agente");
	}

	/**
	 * Return value for input parameter femision
	 */
	protected String getFemision(){
		return (String)this.getParameter("femision");
	}

	/**
	 * Return value for input parameter fcobro
	 */
	protected String getFcobro(){
		return (String)this.getParameter("fcobro");
	}

	/**
	 * Return value for input parameter primas
	 */
	protected String getPrimas(){
		return (String)this.getParameter("primas");
	}

	/**
	 * Return value for input parameter rcop
	 */
	protected String getRcop(){
		return (String)this.getParameter("rcop");
	}

	/**
	 * Return value for input parameter estado
	 */
	protected String getEstado(){
		return (String)this.getParameter("estado");
	}

	/**
	 * Return value for input parameter treca
	 */
	protected String getTreca(){
		return (String)this.getParameter("treca");
	}

	/**
	 * Return value for input parameter td
	 */
	protected String getTd(){
		return (String)this.getParameter("td");
	}

	/**
	 * Return value for input parameter ctabarrido
	 */
	protected String getCtabarrido(){
		return (String)this.getParameter("ctabarrido");
	}

	/**
	 * Return value for input parameter rol
	 */
	protected String getRol(){
		return (String)this.getParameter("rol");
	}

	/**
	 * Return value for input parameter nit
	 */
	protected String getNit(){
		return (String)this.getParameter("nit");
	}

	/**
	 * Return value for input parameter relva
	 */
	protected String getRelva(){
		return (String)this.getParameter("relva");
	}

	/**
	 * Return value for input parameter retlva
	 */
	protected String getRetlva(){
		return (String)this.getParameter("retlva");
	}

	/**
	 * Return value for input parameter retfue
	 */
	protected String getRetfue(){
		return (String)this.getParameter("retfue");
	}

	/**
	 * Return value for input parameter ordpago
	 */
	protected String getOrdpago(){
		return (String)this.getParameter("ordpago");
	}

	/**
	 * Return value for input parameter reccaja
	 */
	protected String getReccaja(){
		return (String)this.getParameter("reccaja");
	}

	/**
	 * Return value for input parameter garantia
	 */
	protected String getGarantia(){
		return (String)this.getParameter("garantia");
	}

	/**
	 * Return value for input parameter importa
	 */
	protected String getImporta(){
		return (String)this.getParameter("importa");
	}

	/**
	 * Return value for input parameter nombrereporte
	 */
	protected String getNombrereporte(){
		return (String)this.getParameter("nombrereporte");
	}

	/**
	 * Return value for input parameter indacsel
	 */
	protected String getIndacsel(){
		return (String)this.getParameter("indacsel");
	}

	/**
	 * Return value for input parameter indefront
	 */
	protected String getIndefront(){
		return (String)this.getParameter("indefront");
	}

	/**
	 * Return value for input parameter indaplus
	 */
	protected String getIndaplus(){
		return (String)this.getParameter("indaplus");
	}

	/**
	 * Return value for input parameter cliente
	 */
	protected List<ClientesDTO> getCliente(){
		return (List<ClientesDTO>)this.getParameter("cliente");
	}

	/**
	 * Return value for input parameter beneficiario
	 */
	protected List<BeneficiariosDTO> getBeneficiario(){
		return (List<BeneficiariosDTO>)this.getParameter("beneficiario");
	}

	/**
	 * Return value for input parameter certificado
	 */
	protected List<CertificadosDTO> getCertificado(){
		return (List<CertificadosDTO>)this.getParameter("certificado");
	}

	/**
	 * Return value for input parameter retribuciones
	 */
	protected List<RetribucionesDTO> getRetribuciones(){
		return (List<RetribucionesDTO>)this.getParameter("retribuciones");
	}

	/**
	 * Return value for input parameter agentes
	 */
	protected List<AgentesDTO> getAgentes(){
		return (List<AgentesDTO>)this.getParameter("agentes");
	}

	/**
	 * Return value for input parameter garantias
	 */
	protected List<GarantiasDTO> getGarantias(){
		return (List<GarantiasDTO>)this.getParameter("garantias");
	}

	/**
	 * Return value for input parameter bienes
	 */
	protected List<BienesDTO> getBienes(){
		return (List<BienesDTO>)this.getParameter("bienes");
	}

	/**
	 * Return value for input parameter recibos
	 */
	protected List<RecibosDTO> getRecibos(){
		return (List<RecibosDTO>)this.getParameter("recibos");
	}

	/**
	 * Return value for input parameter autorizaciones
	 */
	protected List<AutorizacionesDTO> getAutorizaciones(){
		return (List<AutorizacionesDTO>)this.getParameter("autorizaciones");
	}

	/**
	 * Return value for input parameter clausulas
	 */
	protected List<ClausulasDTO> getClausulas(){
		return (List<ClausulasDTO>)this.getParameter("clausulas");
	}

	/**
	 * Return value for input parameter codval
	 */
	protected String getCodval(){
		return (String)this.getParameter("codval");
	}

	/**
	 * Return value for input parameter tipoparam
	 */
	protected String getTipoparam(){
		return (String)this.getParameter("tipoparam");
	}

	/**
	 * Return value for input parameter codparam
	 */
	protected String getCodparam(){
		return (String)this.getParameter("codparam");
	}

	/**
	 * Return value for input parameter descparam
	 */
	protected String getDescparam(){
		return (String)this.getParameter("descparam");
	}

	/**
	 * Return value for input parameter refparam
	 */
	protected String getRefparam(){
		return (String)this.getParameter("refparam");
	}

	/**
	 * Return value for input parameter codsql
	 */
	protected String getCodsql(){
		return (String)this.getParameter("codsql");
	}

	/**
	 * Return value for input parameter totalregs
	 */
	protected String getTotalregs(){
		return (String)this.getParameter("totalregs");
	}

	/**
	 * Return value for input parameter values
	 */
	protected List<String> getValues(){
		return (List<String>)this.getParameter("values");
	}

	/**
	 * Return value for input parameter types
	 */
	protected List<String> getTypes(){
		return (List<String>)this.getParameter("types");
	}

	/**
	 * Return value for input parameter anioconstruccionarray
	 */
	protected List<String> getAnioconstruccionarray(){
		return (List<String>)this.getParameter("anioconstruccionarray");
	}

	/**
	 * Return value for input parameter periodicidadpagoarray
	 */
	protected List<String> getPeriodicidadpagoarray(){
		return (List<String>)this.getParameter("periodicidadpagoarray");
	}

	/**
	 * Return value for input parameter sumaasegarray
	 */
	protected List<String> getSumaasegarray(){
		return (List<String>)this.getParameter("sumaasegarray");
	}

	/**
	 * Return value for input parameter stsbien
	 */
	protected String getStsbien(){
		return (String)this.getParameter("stsbien");
	}

	/**
	 * Return value for input parameter additionalinfo
	 */
	protected String getAdditionalinfo(){
		return (String)this.getParameter("additionalinfo");
	}

	/**
	 * Return value for input parameter codocupac
	 */
	protected String getCodocupac(){
		return (String)this.getParameter("codocupac");
	}

	/**
	 * Return value for input parameter fechaefecto
	 */
	protected String getFechaefecto(){
		return (String)this.getParameter("fechaefecto");
	}

	/**
	 * Return value for input parameter fechaemision
	 */
	protected String getFechaemision(){
		return (String)this.getParameter("fechaemision");
	}

	/**
	 * Return value for input parameter porcpago
	 */
	protected String getPorcpago(){
		return (String)this.getParameter("porcpago");
	}

	/**
	 * Return value for input parameter descripcion
	 */
	protected String getDescripcion(){
		return (String)this.getParameter("descripcion");
	}

	/**
	 * Return value for input parameter mediodepago
	 */
	protected String getMediodepago(){
		return (String)this.getParameter("mediodepago");
	}

	/**
	 * Return value for input parameter barridodecuenta
	 */
	protected String getBarridodecuenta(){
		return (String)this.getParameter("barridodecuenta");
	}

	/**
	 * Return value for input parameter cancelacionsaldos
	 */
	protected String getCancelacionsaldos(){
		return (String)this.getParameter("cancelacionsaldos");
	}

	/**
	 * Return value for input parameter idbien
	 */
	protected String getIdbien(){
		return (String)this.getParameter("idbien");
	}

	/**
	 * Return value for input parameter tipocli
	 */
	protected String getTipocli(){
		return (String)this.getParameter("tipocli");
	}

	/**
	 * Return value for input parameter apemat
	 */
	protected String getApemat(){
		return (String)this.getParameter("apemat");
	}

	/**
	 * Return value for input parameter descoaseguro
	 */
	protected String getDescoaseguro(){
		return (String)this.getParameter("descoaseguro");
	}

	/**
	 * Return value for input parameter numpreformalizado
	 */
	protected String getNumpreformalizado(){
		return (String)this.getParameter("numpreformalizado");
	}

	/**
	 * Return value for input parameter consecutivo
	 */
	protected String getConsecutivo(){
		return (String)this.getParameter("consecutivo");
	}

	/**
	 * Return value for input parameter valaproxnueva
	 */
	protected String getValaproxnueva(){
		return (String)this.getParameter("valaproxnueva");
	}

	/**
	 * Return value for input parameter valaproxactual
	 */
	protected String getValaproxactual(){
		return (String)this.getParameter("valaproxactual");
	}

	/**
	 * Return value for input parameter codigoautoriza
	 */
	protected String getCodigoautoriza(){
		return (String)this.getParameter("codigoautoriza");
	}

	/**
	 * Return value for input parameter codinterf
	 */
	protected String getCodinterf(){
		return (String)this.getParameter("codinterf");
	}

	/**
	 * Return value for input parameter horainicio
	 */
	protected String getHorainicio(){
		return (String)this.getParameter("horainicio");
	}

	/**
	 * Return value for input parameter calendario
	 */
	protected String getCalendario(){
		return (String)this.getParameter("calendario");
	}

	/**
	 * Return value for input parameter nombrejob
	 */
	protected String getNombrejob(){
		return (String)this.getParameter("nombrejob");
	}

	/**
	 * Set value for List<PolicyDTO> output parameter data
	 */
	protected void setData(final List<PolicyDTO> field){
		this.addParameter("data", field);
	}

	/**
	 * Set value for PaginationDTO output parameter pagination
	 */
	protected void setPagination(final PaginationDTO field){
		this.addParameter("pagination", field);
	}
}
