package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class UserNUserEntityCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gUserId;

	private Date gfUserStartDate;

	private String gUserStatusType;

	private String gLanguageId;

	private String gTimeZoneId;

	private String gDateFormatType;

	private String gAmountNumberFormatType;

	private String gPersonalType;

	private String gfPersonalId;

	private String gfPersonalDocVerifiedType;

	private String gfFirstName;

	private String gfLastName;

	private String gfSecondLastName;

	private String gfPersonNameSuffixType;

	private String gfEmailDesc;

	private String gfEmailVeryfiedType;

	private String gPhoneType;

	private String gPrefixPhoneId;

	private String gfExtensionPhoneId;

	private String gfPhoneId;
	
	private String gfPhoneVeryfiedType;

	private String gAddressCountryId;

	private String gfGeographicGroupId;

	private String gfProvinceId;

	private String gfTownId;

	private String gRoadType;

	private String gfAddressRoadDesc;

	private String gfPrimryAddrRoadNumberId;

	private String gfZipcodeId;

	private String gfUrbanizationType;

	private String gfUrbanizationName;

	private String gfSecndyAddrRoadNumberId;

	private Date gfAddressVerifiedDate;

	private String gfAddressVerifiedType;

	private String gfAddressDesc;

	private String gfAddressDistrictId;

	private String gfAddressReferenceDesc;

	private String gUserAccessMethodType;

	private String gfAliasName;

	private String gfUserAuditId;

	private Timestamp gfAuditDate;

	private String gfUserLocalId;

	private String gUserLocaldFormatType;

	private String gPersonRoleType;

	private String gRolePersonId;

	private String gOfflineDeleteIndType;

	public String getGUserId() {
		return this.gUserId;
	}

	public void setGUserId(String gUserId) {
		this.gUserId = gUserId;
	}

	public Date getGfUserStartDate() {
		return this.gfUserStartDate;
	}

	public void setGfUserStartDate(Date gfUserStartDate) {
		this.gfUserStartDate = gfUserStartDate;
	}

	public String getGUserStatusType() {
		return this.gUserStatusType;
	}

	public void setGUserStatusType(String gUserStatusType) {
		this.gUserStatusType = gUserStatusType;
	}

	public String getGLanguageId() {
		return this.gLanguageId;
	}

	public void setGLanguageId(String gLanguageId) {
		this.gLanguageId = gLanguageId;
	}

	public String getGTimeZoneId() {
		return this.gTimeZoneId;
	}

	public void setGTimeZoneId(String gTimeZoneId) {
		this.gTimeZoneId = gTimeZoneId;
	}

	public String getGDateFormatType() {
		return this.gDateFormatType;
	}

	public void setGDateFormatType(String gDateFormatType) {
		this.gDateFormatType = gDateFormatType;
	}

	public String getGAmountNumberFormatType() {
		return this.gAmountNumberFormatType;
	}

	public void setGAmountNumberFormatType(String gAmountNumberFormatType) {
		this.gAmountNumberFormatType = gAmountNumberFormatType;
	}

	public String getGPersonalType() {
		return this.gPersonalType;
	}

	public void setGPersonalType(String gPersonalType) {
		this.gPersonalType = gPersonalType;
	}

	public String getGfPersonalId() {
		return this.gfPersonalId;
	}

	public void setGfPersonalId(String gfPersonalId) {
		this.gfPersonalId = gfPersonalId;
	}

	public String getGfPersonalDocVerifiedType() {
		return this.gfPersonalDocVerifiedType;
	}

	public void setGfPersonalDocVerifiedType(String gfPersonalDocVerifiedType) {
		this.gfPersonalDocVerifiedType = gfPersonalDocVerifiedType;
	}

	public String getGfFirstName() {
		return this.gfFirstName;
	}

	public void setGfFirstName(String gfFirstName) {
		this.gfFirstName = gfFirstName;
	}

	public String getGfLastName() {
		return this.gfLastName;
	}

	public void setGfLastName(String gfLastName) {
		this.gfLastName = gfLastName;
	}

	public String getGfSecondLastName() {
		return this.gfSecondLastName;
	}

	public void setGfSecondLastName(String gfSecondLastName) {
		this.gfSecondLastName = gfSecondLastName;
	}

	public String getGfPersonNameSuffixType() {
		return this.gfPersonNameSuffixType;
	}

	public void setGfPersonNameSuffixType(String gfPersonNameSuffixType) {
		this.gfPersonNameSuffixType = gfPersonNameSuffixType;
	}

	public String getGfEmailDesc() {
		return this.gfEmailDesc;
	}

	public void setGfEmailDesc(String gfEmailDesc) {
		this.gfEmailDesc = gfEmailDesc;
	}

	public String getGfEmailVeryfiedType() {
		return this.gfEmailVeryfiedType;
	}

	public void setGfEmailVeryfiedType(String gfEmailVeryfiedType) {
		this.gfEmailVeryfiedType = gfEmailVeryfiedType;
	}

	public String getGPhoneType() {
		return this.gPhoneType;
	}

	public void setGPhoneType(String gPhoneType) {
		this.gPhoneType = gPhoneType;
	}

	public String getGPrefixPhoneId() {
		return this.gPrefixPhoneId;
	}

	public void setGPrefixPhoneId(String gPrefixPhoneId) {
		this.gPrefixPhoneId = gPrefixPhoneId;
	}

	public String getGfExtensionPhoneId() {
		return this.gfExtensionPhoneId;
	}

	public void setGfExtensionPhoneId(String gfExtensionPhoneId) {
		this.gfExtensionPhoneId = gfExtensionPhoneId;
	}

	public String getGfPhoneId() {
		return this.gfPhoneId;
	}

	public void setGfPhoneId(String gfPhoneId) {
		this.gfPhoneId = gfPhoneId;
	}

	public String getGfPhoneVeryfiedType() {
		return gfPhoneVeryfiedType;
	}

	public void setGfPhoneVeryfiedType(String gfPhoneVeryfiedType) {
		this.gfPhoneVeryfiedType = gfPhoneVeryfiedType;
	}

	public String getGAddressCountryId() {
		return this.gAddressCountryId;
	}

	public void setGAddressCountryId(String gAddressCountryId) {
		this.gAddressCountryId = gAddressCountryId;
	}

	public String getGfGeographicalGroupId() {
		return this.gfGeographicGroupId;
	}

	public void setGfGeographicalGroupId(String gfGeographicGroupId) {
		this.gfGeographicGroupId = gfGeographicGroupId;
	}

	public String getGfProvinceId() {
		return this.gfProvinceId;
	}

	public void setGfProvinceId(String gfProvinceId) {
		this.gfProvinceId = gfProvinceId;
	}

	public String getGfTownId() {
		return this.gfTownId;
	}

	public void setGfTownId(String gfTownId) {
		this.gfTownId = gfTownId;
	}

	public String getGRoadType() {
		return this.gRoadType;
	}

	public void setGRoadType(String gRoadType) {
		this.gRoadType = gRoadType;
	}

	public String getGfAddressRoadDesc() {
		return this.gfAddressRoadDesc;
	}

	public void setGfAddressRoadDesc(String gfAddressRoadDesc) {
		this.gfAddressRoadDesc = gfAddressRoadDesc;
	}

	public String getGfPrimryAddrRoadNumberId() {
		return this.gfPrimryAddrRoadNumberId;
	}

	public void setGfPrimryAddrRoadNumberId(String gfPrimryAddrRoadNumberId) {
		this.gfPrimryAddrRoadNumberId = gfPrimryAddrRoadNumberId;
	}

	public String getGfZipcodeId() {
		return this.gfZipcodeId;
	}

	public void setGfZipcodeId(String gfZipcodeId) {
		this.gfZipcodeId = gfZipcodeId;
	}

	public String getGfUrbanizationType() {
		return this.gfUrbanizationType;
	}

	public void setGfUrbanizationType(String gfUrbanizationType) {
		this.gfUrbanizationType = gfUrbanizationType;
	}

	public String getGfUrbanizationName() {
		return this.gfUrbanizationName;
	}

	public void setGfUrbanizationName(String gfUrbanizationName) {
		this.gfUrbanizationName = gfUrbanizationName;
	}

	public String getGfSecndyAddrRoadNumberId() {
		return this.gfSecndyAddrRoadNumberId;
	}

	public void setGfSecndyAddrRoadNumberId(String gfSecndyAddrRoadNumberId) {
		this.gfSecndyAddrRoadNumberId = gfSecndyAddrRoadNumberId;
	}

	public Date getGfAddressVerifiedDate() {
		return this.gfAddressVerifiedDate;
	}

	public void setGfAddressVerifiedDate(Date gfAddressVerifiedDate) {
		this.gfAddressVerifiedDate = gfAddressVerifiedDate;
	}

	public String getGfAddressVerifiedType() {
		return this.gfAddressVerifiedType;
	}

	public void setGfAddressVerifiedType(String gfAddressVerifiedType) {
		this.gfAddressVerifiedType = gfAddressVerifiedType;
	}

	public String getGfAddressDesc() {
		return this.gfAddressDesc;
	}

	public void setGfAddressDesc(String gfAddressDesc) {
		this.gfAddressDesc = gfAddressDesc;
	}

	public String getGfAddressDistrictId() {
		return this.gfAddressDistrictId;
	}

	public void setGfAddressDistrictId(String gfAddressDistrictId) {
		this.gfAddressDistrictId = gfAddressDistrictId;
	}

	public String getGfAddressReferenceDesc() {
		return this.gfAddressReferenceDesc;
	}

	public void setGfAddressReferenceDesc(String gfAddressReferenceDesc) {
		this.gfAddressReferenceDesc = gfAddressReferenceDesc;
	}

	public String getGUserAccessMethodType() {
		return this.gUserAccessMethodType;
	}

	public void setGUserAccessMethodType(String gUserAccessMethodType) {
		this.gUserAccessMethodType = gUserAccessMethodType;
	}

	public String getGfAliasName() {
		return this.gfAliasName;
	}

	public void setGfAliasName(String gfAliasName) {
		this.gfAliasName = gfAliasName;
	}

	public String getGfUserAuditId() {
		return this.gfUserAuditId;
	}

	public void setGfUserAuditId(String gfUserAuditId) {
		this.gfUserAuditId = gfUserAuditId;
	}

	public Timestamp getGfAuditDate() {
		return this.gfAuditDate;
	}

	public void setGfAuditDate(Timestamp gfAuditDate) {
		this.gfAuditDate = gfAuditDate;
	}

	public String getGfUserLocalId() {
		return gfUserLocalId;
	}

	public void setGfUserLocalId(String gfUserLocalId) {
		this.gfUserLocalId = gfUserLocalId;
	}

	public String getgUserLocaldFormatType() {
		return gUserLocaldFormatType;
	}

	public void setgUserLocaldFormatType(String gUserLocaldFormatType) {
		this.gUserLocaldFormatType = gUserLocaldFormatType;
	}

	public String getgPersonRoleType() {
		return gPersonRoleType;
	}

	public void setgPersonRoleType(String gPersonRoleType) {
		this.gPersonRoleType = gPersonRoleType;
	}

	public String getgRolePersonId() {
		return gRolePersonId;
	}

	public void setgRolePersonId(String gRolePersonId) {
		this.gRolePersonId = gRolePersonId;
	}

	public String getgOfflineDeleteIndType() {
		return gOfflineDeleteIndType;
	}

	public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
		this.gOfflineDeleteIndType = gOfflineDeleteIndType;
	}

	@Override
	public String toString() {
		return "UserNUserEntityCommons [gUserId=" + gUserId + ", gfUserStartDate=" + gfUserStartDate + ", gUserStatusType=" + gUserStatusType + ", gLanguageId="
				+ gLanguageId + ", gTimeZoneId=" + gTimeZoneId + ", gDateFormatType=" + gDateFormatType + ", gAmountNumberFormatType=" + gAmountNumberFormatType
				+ ", gPersonalType=" + gPersonalType + ", gfPersonalId=" + gfPersonalId + ", gfPersonalDocVerifiedType=" + gfPersonalDocVerifiedType
				+ ", gfFirstName=" + gfFirstName + ", gfLastName=" + gfLastName + ", gfSecondLastName=" + gfSecondLastName + ", gfPersonNameSuffixType="
				+ gfPersonNameSuffixType + ", gfEmailDesc=" + gfEmailDesc + ", gfEmailVeryfiedType=" + gfEmailVeryfiedType + ", gPhoneType=" + gPhoneType
				+ ", gPrefixPhoneId=" + gPrefixPhoneId + ", gfExtensionPhoneId=" + gfExtensionPhoneId + ", gfPhoneId=" + gfPhoneId + ", gfPhoneVeryfiedType="
				+ gfPhoneVeryfiedType + ", gAddressCountryId=" + gAddressCountryId + ", gfGeographicGroupId=" + gfGeographicGroupId + ", gfProvinceId="
				+ gfProvinceId + ", gfTownId=" + gfTownId + ", gRoadType=" + gRoadType + ", gfAddressRoadDesc=" + gfAddressRoadDesc
				+ ", gfPrimryAddrRoadNumberId=" + gfPrimryAddrRoadNumberId + ", gfZipcodeId=" + gfZipcodeId + ", gfUrbanizationType=" + gfUrbanizationType
				+ ", gfUrbanizationName=" + gfUrbanizationName + ", gfSecndyAddrRoadNumberId=" + gfSecndyAddrRoadNumberId + ", gfAddressVerifiedDate="
				+ gfAddressVerifiedDate + ", gfAddressVerifiedType=" + gfAddressVerifiedType + ", gfAddressDesc=" + gfAddressDesc + ", gfAddressDistrictId="
				+ gfAddressDistrictId + ", gfAddressReferenceDesc=" + gfAddressReferenceDesc + ", gUserAccessMethodType=" + gUserAccessMethodType
				+ ", gfAliasName=" + gfAliasName + ", gfUserAuditId=" + gfUserAuditId + ", gfAuditDate=" + gfAuditDate + ", gfUserLocalId=" + gfUserLocalId
				+ ", gUserLocaldFormatType=" + gUserLocaldFormatType + ", gPersonRoleType=" + gPersonRoleType + ", gRolePersonId=" + gRolePersonId
				+ ", gOfflineDeleteIndType=" + gOfflineDeleteIndType + "]";
	}


}
