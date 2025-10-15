package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.bbva.kusu.dto.mapper.commons.UserMapperCommons;
import com.bbva.kusu.dto.users.beans.AccessType;
import com.bbva.kusu.dto.users.beans.ContactDetail;
import com.bbva.kusu.dto.users.beans.ContactEmail;
import com.bbva.kusu.dto.users.beans.ContactLandLine;
import com.bbva.kusu.dto.users.beans.ContactMobile;
import com.bbva.kusu.dto.users.beans.DocumentType;
import com.bbva.kusu.dto.users.beans.IdentityDocument;
import com.bbva.kusu.dto.users.beans.Preferences;
import com.bbva.kusu.dto.users.beans.User;
import com.bbva.kusu.dto.users.entity.UserEntity;
import com.bbva.kusu.dto.users.entity.UserManagementEntity;
import com.bbva.kusu.dto.users.types.EnumAccessType;
import com.bbva.kusu.dto.users.types.EnumDocumentType;
import com.bbva.kusu.dto.users.util.MapperEnumStatus;
import com.bbva.kusu.dto.users.util.MapperEnumsUser;

public class UserMapper extends UserMapperCommons{
	

	public User setUser(UserEntity userEntityRegular) {
		User userRegular = new User();
		userRegular.setId(userEntityRegular.getGUserId());
		userRegular.setFirstName(userEntityRegular.getGfFirstName());
		userRegular.setLastName(userEntityRegular.getGfLastName());
		userRegular.setSecondLastName(userEntityRegular.getGfSecondLastName());
		userRegular.setAlias(userEntityRegular.getGfAliasName());
		userRegular.setEntryDate(userEntityRegular.getGfUserStartDate());
		userRegular.setStatusMode(LIVE);
		userRegular.setStatus(MapperEnumStatus.getStatusEntity(userEntityRegular.getGUserStatusType()));
		if (StringUtils.isNotBlank(userEntityRegular.getGUserAccessMethodType())) {
			AccessType accessTypeReg = new AccessType();
			accessTypeReg.setId(EnumAccessType.getByCodigo(userEntityRegular.getGUserAccessMethodType()).name());
			userRegular.setAccessType(accessTypeReg);
		} 
		if (StringUtils.isNotBlank(userEntityRegular.getGPersonalType()) && !EnumDocumentType.NONE.getCodigo().equals(userEntityRegular.getGPersonalType())) {
			IdentityDocument identityDocumentReg = new IdentityDocument();
			DocumentType documentType = new DocumentType();
			documentType.setId(EnumDocumentType.getByCodigo(userEntityRegular.getGPersonalType()).name());
			documentType.setDescription(EnumDocumentType.getByCodigo(userEntityRegular.getGPersonalType()).getDescripcion());
			identityDocumentReg.setDocumentType(documentType);
			identityDocumentReg.setDocumentNumber(userEntityRegular.getGfPersonalId()!=null ? userEntityRegular.getGfPersonalId().trim() : userEntityRegular.getGfPersonalId());
			identityDocumentReg.setIsVerified(userEntityRegular.getGfPersonalDocVerifiedType());
			userRegular.setIdentityDocument(identityDocumentReg);
		} 
		List<ContactDetail> contactDetailsReg = new ArrayList<>();
		ContactDetail contactDetailReg = new ContactDetail();
		contactDetailReg.setId("1");
		ContactEmail contactEmailReg = new ContactEmail();
		contactEmailReg.setContactDetailType(EMAIL);
		contactEmailReg.setAddress(userEntityRegular.getGfEmailDesc());
		contactEmailReg.setReceivesNotifications(userEntityRegular.getGfEmailVeryfiedType());
		contactDetailReg.setContactEmail(contactEmailReg);
		contactDetailsReg.add(contactDetailReg);
		if (StringUtils.isNotBlank(userEntityRegular.getGfPhoneId())) {
			contactDetailReg = new ContactDetail();
			contactDetailReg.setId("2");
			if (null != userEntityRegular.getGPhoneType() && userEntityRegular.getGPhoneType().equals(LANDLINE)) {
				ContactLandLine contactLandLineReg = new ContactLandLine();
				contactLandLineReg.setContactDetailType(LANDLINE);
				contactLandLineReg.setNumber(userEntityRegular.getGfPhoneId());
				contactLandLineReg.setCountryCode(userEntityRegular.getGPrefixPhoneId());
				contactLandLineReg.setExtension(userEntityRegular.getGfExtensionPhoneId());
				contactDetailReg.setContactLandLine(contactLandLineReg);
			} else {
				ContactMobile contactMobileReg = new ContactMobile();
				contactMobileReg.setContactDetailType(MOBILE);
				contactMobileReg.setNumber(userEntityRegular.getGfPhoneId());
				contactMobileReg.setCountryCode(userEntityRegular.getGPrefixPhoneId());
				contactDetailReg.setContactMobile(contactMobileReg);
			} 
			contactDetailsReg.add(contactDetailReg);
		} 
		userRegular.setContactDetails(contactDetailsReg);
		if (StringUtils.isNotBlank(userEntityRegular.getGLanguageId()) && StringUtils.isNotBlank(userEntityRegular.getGTimeZoneId()) && 
				StringUtils.isNotBlank(userEntityRegular.getGDateFormatType()) && StringUtils.isNotBlank(userEntityRegular.getGAmountNumberFormatType())) {
			Preferences preferencesReg = new Preferences();
			preferencesReg.setLanguage(MapperEnumsUser.languageOut(userEntityRegular.getGLanguageId()));
			preferencesReg.setTimeZone(MapperEnumsUser.timeZoneIdOut(userEntityRegular.getGTimeZoneId()));
			preferencesReg.setDateFormat(MapperEnumsUser.dateFormatTypeOut(userEntityRegular.getGDateFormatType()));
			preferencesReg.setAmountFormat(MapperEnumsUser.amounFormatOut(userEntityRegular.getGAmountNumberFormatType()));
			userRegular.setPreferences(preferencesReg);
		} 
		return userRegular;
	}

	public User setUserId(UserEntity userEntityReg) {
		User userReg = new User();
		userReg.setId(userEntityReg.getGUserId());
		return userReg;
	}

	public UserEntity setUserEntity(User userReg, String userIdReg, String auditUserReg) {
		ContactEmail contactEmailReg = null;
		ContactLandLine contactLandLineReg = null;
		ContactMobile contactMobileReg = null;
		for (ContactDetail contactDetailReg : userReg.getContactDetails()) {
			contactEmailReg = validatedContactEmail(contactDetailReg, contactEmailReg);
			contactLandLineReg = validatedContactLandLine(contactDetailReg, contactLandLineReg);
			contactMobileReg = validatedContactMobile(contactDetailReg, contactMobileReg);
		} 
		UserEntity userEntityReg = new UserEntity();
		userEntityReg.setGUserId(userIdReg);
		userEntityReg.setGfUserStartDate(new Date());
		userEntityReg.setGUserStatusType(MapperEnumStatus.statusIn("ACTIVE"));
		userEntityReg.setGLanguageId(MapperEnumsUser.languageIn("ES"));
		userEntityReg.setGTimeZoneId(MapperEnumsUser.timeZoneIdIn("Mexico DF, Central Time (USA and Canada), Saskatchewan"));
		userEntityReg.setGDateFormatType(MapperEnumsUser.dateFormatTypeIn("yyyy-MM-dd"));
		userEntityReg.setGAmountNumberFormatType(MapperEnumsUser.amounFormatIn("0,000.00"));
		userEntityReg.setGPersonalType(EnumDocumentType.NONE.getCodigo());
		userEntityReg.setGfPersonalId(" ");
		userEntityReg.setGfPersonalDocVerifiedType("N");
		if (userReg.getIdentityDocument() != null) {
			userEntityReg.setGPersonalType(EnumDocumentType.valueOf(userReg.getIdentityDocument().getDocumentType().getId()).getCodigo());
			userEntityReg.setGfPersonalId(userReg.getIdentityDocument().getDocumentNumber());
			userEntityReg.setGfPersonalDocVerifiedType(userReg.getIdentityDocument().getIsVerified());
		} 
		userEntityReg.setGfFirstName(userReg.getFirstName());
		userEntityReg.setGfLastName(userReg.getLastName());
		userEntityReg.setGfSecondLastName(StringUtils.isBlank(userReg.getSecondLastName()) ? " " : userReg.getSecondLastName());
		userEntityReg.setGfEmailDesc((contactEmailReg != null) ? contactEmailReg.getAddress() : " ");
		userEntityReg.setGfEmailVeryfiedType((contactEmailReg != null) ? validatedEmailVeryfiedType(contactEmailReg) : "N");
		userEntityReg.setGPhoneType("NOPHONE");
		userEntityReg.setGPrefixPhoneId("000000");
		userEntityReg.setGfExtensionPhoneId("00000");
		userEntityReg.setGfPhoneId("000000000000000");
		if (contactLandLineReg != null || contactMobileReg != null) {
			userEntityReg.setGPhoneType(validatedPhoneType(contactMobileReg));
			userEntityReg.setGPrefixPhoneId(validatedPrefixPhoneId(contactLandLineReg, contactMobileReg));
			userEntityReg.setGfExtensionPhoneId(validatedExtensionPhoneId(contactLandLineReg));
			userEntityReg.setGfPhoneId((contactLandLineReg != null) ? contactLandLineReg.getNumber() : contactMobileReg.getNumber());
		} 
		userEntityReg.setGAddressCountryId(" ");
		userEntityReg.setGfGeographicalGroupId(" ");
		userEntityReg.setGfProvinceId(" ");
		userEntityReg.setGfTownId(" ");
		userEntityReg.setGRoadType(" ");
		userEntityReg.setGfAddressRoadDesc(" ");
		userEntityReg.setGfPrimryAddrRoadNumberId(" ");
		userEntityReg.setGfSecndyAddrRoadNumberId(" ");
		userEntityReg.setGfZipcodeId(" ");
		userEntityReg.setGfUrbanizationType(" ");
		userEntityReg.setGfUrbanizationName(" ");
		userEntityReg.setGfAddressVerifiedDate(getInitializedDate());
		userEntityReg.setGfAddressVerifiedType("N");
		userEntityReg.setGfAddressDesc(" ");
		userEntityReg.setGfAddressDistrictId(" ");
		userEntityReg.setGfAddressReferenceDesc(" ");
		userEntityReg.setGUserAccessMethodType(
				(userReg.getAccessType() == null) ? EnumAccessType.USER_PASSWORD.getCodigo() : EnumAccessType.valueOf(userReg.getAccessType().getId()).getCodigo());
		userEntityReg.setGfAliasName(StringUtils.isBlank(userReg.getAlias()) ? " " : userReg.getAlias());
		userEntityReg.setGfUserAuditId(auditUserReg);
		userEntityReg.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		return userEntityReg;
	}

	public static UserEntity userFromMgmt(UserManagementEntity user, String auditId) {
		UserEntity entity = new UserEntity();
		entity.setgPersonRoleType(user.getgPersonRoleType());
		entity.setGUserId(user.getGUserId());
		entity.setGfUserStartDate(user.getGfUserStartDate());
		entity.setGUserStatusType(user.getGUserStatusType());
		entity.setGLanguageId(user.getGLanguageId());
		entity.setGTimeZoneId(user.getGTimeZoneId());
		entity.setGDateFormatType(user.getGDateFormatType());
		entity.setGAmountNumberFormatType(user.getGAmountNumberFormatType());
		entity.setGPersonalType(user.getGPersonalType());
		entity.setGfPersonalId(user.getGfPersonalId());
		entity.setGfPersonalDocVerifiedType(user.getGfPersonalDocVerifiedType());
		entity.setGfFirstName(user.getGfFirstName());
		entity.setGfLastName(user.getGfLastName());
		entity.setGfSecondLastName(user.getGfSecondLastName());
		entity.setGfPersonNameSuffixType(user.getGfPersonNameSuffixType());
		entity.setGfEmailDesc(user.getGfEmailDesc());
		entity.setGfEmailVeryfiedType(user.getGfEmailVeryfiedType());
		entity.setGPhoneType(user.getGPhoneType());
		entity.setGPrefixPhoneId(user.getGPrefixPhoneId());
		entity.setGfExtensionPhoneId(user.getGfExtensionPhoneId());
		entity.setGfPhoneId(user.getGfPhoneId());
		entity.setGAddressCountryId(user.getGAddressCountryId());
		entity.setGfGeographicalGroupId(user.getGfGeographicalGroupId());
		entity.setGfProvinceId(user.getGfProvinceId());
		entity.setGfTownId(user.getGfTownId());
		entity.setGfAddressDistrictId(user.getGfAddressDistrictId());
		entity.setGRoadType(user.getGRoadType());
		entity.setGfAddressRoadDesc(user.getGfAddressRoadDesc());
		entity.setGfPrimryAddrRoadNumberId(user.getGfPrimryAddrRoadNumberId());
		entity.setGfUrbanizationType(user.getGfUrbanizationType());
		entity.setGfUrbanizationName(user.getGfUrbanizationName());
		entity.setGfSecndyAddrRoadNumberId(user.getGfSecndyAddrRoadNumberId());
		entity.setGfAddressReferenceDesc(user.getGfAddressReferenceDesc());
		entity.setGfZipcodeId(user.getGfZipcodeId());
		entity.setGfAddressVerifiedType(user.getGfAddressVerifiedType());
		entity.setGfAddressVerifiedDate(user.getGfAddressVerifiedDate());
		entity.setGfAddressDesc(user.getGfAddressDesc());
		entity.setGUserAccessMethodType(user.getGUserAccessMethodType());
		entity.setGfAliasName(user.getGfAliasName());
		entity.setGCustomerId(user.getGCustomerId());
		entity.setGfUserLocalId(user.getGfUserLocalId());
		entity.setgUserLocaldFormatType(user.getgUserLocaldFormatType());
		entity.setGfUserAuditId(auditId);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(user.getgOfflineDeleteIndType());
		return entity;
	}
}
