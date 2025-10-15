package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class UserDataAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "gf_user_start_date")
	private Date userStartDate;

	@SerializedName(value = "g_user_status_type")
	private String userStatusType;

	@SerializedName(value = "g_language_id")
	private String languageId;

	@SerializedName(value = "g_time_zone_id")
	private String timeZoneId;

	@SerializedName(value = "g_date_format_type")
	private String dateFormatType;

	@SerializedName(value = "g_amount_number_format_type")
	private String amountNumberFormatType;

	@SerializedName(value = "g_personal_type")
	private String personalType;

	@SerializedName(value = "gf_personal_id")
	private String personalId;

	@SerializedName(value = "gf_personal_doc_verified_type")
	private String personalDocVerifiedType;

	@SerializedName(value = "gf_first_name")
	private String firstName;

	@SerializedName(value = "gf_last_name")
	private String lastName;

	@SerializedName(value = "gf_second_last_name")
	private String secondLastName;

	@SerializedName(value = "gf_person_name_suffix_type")
	private String personNameSuffixType;

	@SerializedName(value = "gf_email_desc")
	private String emailDesc;

	@SerializedName(value = "gf_email_verified_type")
	private String emailVeryfiedType;

	@SerializedName(value = "g_phone_type")
	private String phoneType;

	@SerializedName(value = "g_prefix_phone_id")
	private String prefixPhoneId;

	@SerializedName(value = "gf_extension_phone_id")
	private String extensionPhoneId;

	@SerializedName(value = "gf_phone_id")
	private String phoneId;

	@SerializedName(value = "g_address_country_id")
	private String addressCountryId;

	@SerializedName(value = "gf_geographic_group_id")
	private String geographicGroupId;

	@SerializedName(value = "gf_province_id")
	private String provinceId;

	@SerializedName(value = "gf_town_id")
	private String townId;

	@SerializedName(value = "gf_road_type_id")
	private String roadType;

	@SerializedName(value = "gf_address_road_desc")
	private String addressRoadDesc;

	@SerializedName(value = "gf_primry_addr_road_number_id")
	private String primryAddrRoadNumberId;

	@SerializedName(value = "gf_zipcode_id")
	private String zipcodeId;

	@SerializedName(value = "gf_urbanization_type")
	private String urbanizationType;

	@SerializedName(value = "gf_urbanization_name")
	private String urbanizationName;

	@SerializedName(value = "gf_secndy_addr_road_number_id")
	private String secndyAddrRoadNumberId;

	@SerializedName(value = "gf_address_verified_date")
	private Date addressVerifiedDate;

	@SerializedName(value = "gf_address_verified_type")
	private String addressVerifiedType;

	@SerializedName(value = "gf_address_desc")
	private String addressDesc;

	@SerializedName(value = "gf_address_district_id")
	private String addressDistrictId;

	@SerializedName(value = "gf_address_reference_desc")
	private String addressReferenceDesc;

	@SerializedName(value = "g_user_access_method_type")
	private String userAccessMethodType;

	@SerializedName(value = "gf_alias_name")
	private String aliasName;

	@SerializedName(value = "gf_user_audit_id")
	private String userAuditId;

	@SerializedName(value = "gf_audit_date")
	private Timestamp auditDate;
	
	@SerializedName(value = "g_customer_id")
	private String customerId;

	@SerializedName(value = "gf_user_local_id")
	private String userLocalId;
	
	@SerializedName(value = "g_user_local_id_format_type")
	private String userLocalIdFormatType;
	
	public Date getUserStartDate() {
		return userStartDate;
	}

	public void setUserStartDate(Date userStartDate) {
		this.userStartDate = userStartDate;
	}

	public String getUserStatusType() {
		return userStatusType;
	}

	public void setUserStatusType(String userStatusType) {
		this.userStatusType = userStatusType;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getDateFormatType() {
		return dateFormatType;
	}

	public void setDateFormatType(String dateFormatType) {
		this.dateFormatType = dateFormatType;
	}

	public String getAmountNumberFormatType() {
		return amountNumberFormatType;
	}

	public void setAmountNumberFormatType(String amountNumberFormatType) {
		this.amountNumberFormatType = amountNumberFormatType;
	}

	public String getPersonalType() {
		return personalType;
	}

	public void setPersonalType(String personalType) {
		this.personalType = personalType;
	}

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public String getPersonalDocVerifiedType() {
		return personalDocVerifiedType;
	}

	public void setPersonalDocVerifiedType(String personalDocVerifiedType) {
		this.personalDocVerifiedType = personalDocVerifiedType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getPersonNameSuffixType() {
		return personNameSuffixType;
	}

	public void setPersonNameSuffixType(String personNameSuffixType) {
		this.personNameSuffixType = personNameSuffixType;
	}

	public String getEmailDesc() {
		return emailDesc;
	}

	public void setEmailDesc(String emailDesc) {
		this.emailDesc = emailDesc;
	}

	public String getEmailVeryfiedType() {
		return emailVeryfiedType;
	}

	public void setEmailVeryfiedType(String emailVeryfiedType) {
		this.emailVeryfiedType = emailVeryfiedType;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPrefixPhoneId() {
		return prefixPhoneId;
	}

	public void setPrefixPhoneId(String prefixPhoneId) {
		this.prefixPhoneId = prefixPhoneId;
	}

	public String getExtensionPhoneId() {
		return extensionPhoneId;
	}

	public void setExtensionPhoneId(String extensionPhoneId) {
		this.extensionPhoneId = extensionPhoneId;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public String getAddressCountryId() {
		return addressCountryId;
	}

	public void setAddressCountryId(String addressCountryId) {
		this.addressCountryId = addressCountryId;
	}

	public String getGeographicGroupId() {
		return geographicGroupId;
	}

	public void setGeographicGroupId(String geographicGroupId) {
		this.geographicGroupId = geographicGroupId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getTownId() {
		return townId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getAddressRoadDesc() {
		return addressRoadDesc;
	}

	public void setAddressRoadDesc(String addressRoadDesc) {
		this.addressRoadDesc = addressRoadDesc;
	}

	public String getPrimryAddrRoadNumberId() {
		return primryAddrRoadNumberId;
	}

	public void setPrimryAddrRoadNumberId(String primryAddrRoadNumberId) {
		this.primryAddrRoadNumberId = primryAddrRoadNumberId;
	}

	public String getZipcodeId() {
		return zipcodeId;
	}

	public void setZipcodeId(String zipcodeId) {
		this.zipcodeId = zipcodeId;
	}

	public String getUrbanizationType() {
		return urbanizationType;
	}

	public void setUrbanizationType(String urbanizationType) {
		this.urbanizationType = urbanizationType;
	}

	public String getUrbanizationName() {
		return urbanizationName;
	}

	public void setUrbanizationName(String urbanizationName) {
		this.urbanizationName = urbanizationName;
	}

	public String getSecndyAddrRoadNumberId() {
		return secndyAddrRoadNumberId;
	}

	public void setSecndyAddrRoadNumberId(String secndyAddrRoadNumberId) {
		this.secndyAddrRoadNumberId = secndyAddrRoadNumberId;
	}

	public Date getAddressVerifiedDate() {
		return addressVerifiedDate;
	}

	public void setAddressVerifiedDate(Date addressVerifiedDate) {
		this.addressVerifiedDate = addressVerifiedDate;
	}

	public String getAddressVerifiedType() {
		return addressVerifiedType;
	}

	public void setAddressVerifiedType(String addressVerifiedType) {
		this.addressVerifiedType = addressVerifiedType;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getAddressDistrictId() {
		return addressDistrictId;
	}

	public void setAddressDistrictId(String addressDistrictId) {
		this.addressDistrictId = addressDistrictId;
	}

	public String getAddressReferenceDesc() {
		return addressReferenceDesc;
	}

	public void setAddressReferenceDesc(String addressReferenceDesc) {
		this.addressReferenceDesc = addressReferenceDesc;
	}

	public String getUserAccessMethodType() {
		return userAccessMethodType;
	}

	public void setUserAccessMethodType(String userAccessMethodType) {
		this.userAccessMethodType = userAccessMethodType;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getUserAuditId() {
		return userAuditId;
	}

	public void setUserAuditId(String userAuditId) {
		this.userAuditId = userAuditId;
	}

	public Timestamp getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUserLocalId() {
		return userLocalId;
	}

	public void setUserLocalId(String userLocalId) {
		this.userLocalId = userLocalId;
	}

	public String getUserLocalIdFormatType() {
		return userLocalIdFormatType;
	}

	public void setUserLocalIdFormatType(String userLocalIdFormatType) {
		this.userLocalIdFormatType = userLocalIdFormatType;
	}

	@Override
	public String toString() {
		return "UserDataAuditEntity [userStartDate=" + userStartDate + ", userStatusType=" + userStatusType
				+ ", languageId=" + languageId + ", timeZoneId=" + timeZoneId + ", dateFormatType=" + dateFormatType
				+ ", amountNumberFormatType=" + amountNumberFormatType + ", personalType=" + personalType
				+ ", personalId=" + personalId + ", personalDocVerifiedType=" + personalDocVerifiedType + ", firstName="
				+ firstName + ", lastName=" + lastName + ", secondLastName=" + secondLastName
				+ ", personNameSuffixType=" + personNameSuffixType + ", emailDesc=" + emailDesc + ", emailVeryfiedType="
				+ emailVeryfiedType + ", phoneType=" + phoneType + ", prefixPhoneId=" + prefixPhoneId
				+ ", extensionPhoneId=" + extensionPhoneId + ", phoneId=" + phoneId + ", addressCountryId="
				+ addressCountryId + ", geographicGroupId=" + geographicGroupId + ", provinceId=" + provinceId
				+ ", townId=" + townId + ", roadType=" + roadType + ", addressRoadDesc=" + addressRoadDesc
				+ ", primryAddrRoadNumberId=" + primryAddrRoadNumberId + ", zipcodeId=" + zipcodeId
				+ ", urbanizationType=" + urbanizationType + ", urbanizationName=" + urbanizationName
				+ ", secndyAddrRoadNumberId=" + secndyAddrRoadNumberId + ", addressVerifiedDate=" + addressVerifiedDate
				+ ", addressVerifiedType=" + addressVerifiedType + ", addressDesc=" + addressDesc
				+ ", addressDistrictId=" + addressDistrictId + ", addressReferenceDesc=" + addressReferenceDesc
				+ ", userAccessMethodType=" + userAccessMethodType + ", aliasName=" + aliasName + ", userAuditId="
				+ userAuditId + ", auditDate=" + auditDate + ", customerId=" + customerId + ", userLocalId="
				+ userLocalId + ", userLocalIdFormatType=" + userLocalIdFormatType + "]";
	}

}
