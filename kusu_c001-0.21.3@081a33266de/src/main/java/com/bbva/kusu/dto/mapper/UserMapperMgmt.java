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
import com.bbva.kusu.dto.users.entity.UserManagementEntity;
import com.bbva.kusu.dto.users.types.EnumAccessType;
import com.bbva.kusu.dto.users.types.EnumDocumentType;
import com.bbva.kusu.dto.users.util.MapperEnumStatus;
import com.bbva.kusu.dto.users.util.MapperEnumsUser;

public class UserMapperMgmt extends UserMapperCommons{
	

	public User setUser(UserManagementEntity userEntity) {
		User user = new User();
		user.setId(userEntity.getGUserId());
		user.setFirstName(userEntity.getGfFirstName());
		user.setLastName(userEntity.getGfLastName());
		user.setSecondLastName(userEntity.getGfSecondLastName());
		user.setAlias(userEntity.getGfAliasName());
		user.setEntryDate(userEntity.getGfUserStartDate());
		user.setStatusMode(PENDING);
		user.setStatus(MapperEnumStatus.getStatusEntity(userEntity.getGUserStatusType()));
		if (StringUtils.isNotBlank(userEntity.getGUserAccessMethodType())) {
			AccessType accessType = new AccessType();
			accessType.setId(EnumAccessType.getByCodigo(userEntity.getGUserAccessMethodType()).name());
			user.setAccessType(accessType);
		} 
		if (StringUtils.isNotBlank(userEntity.getGPersonalType()) && !EnumDocumentType.NONE.getCodigo().equals(userEntity.getGPersonalType())) {
			IdentityDocument identityDocument = new IdentityDocument();
			DocumentType documentType = new DocumentType();
			documentType.setId(EnumDocumentType.getByCodigo(userEntity.getGPersonalType()).name());
			documentType.setDescription(EnumDocumentType.getByCodigo(userEntity.getGPersonalType()).getDescripcion());
			identityDocument.setDocumentType(documentType);
			identityDocument.setDocumentNumber(userEntity.getGfPersonalId()!=null ? userEntity.getGfPersonalId().trim() : userEntity.getGfPersonalId());
			identityDocument.setIsVerified(userEntity.getGfPersonalDocVerifiedType());
			user.setIdentityDocument(identityDocument);
		} 
		List<ContactDetail> contactDetails = new ArrayList<>();
		ContactDetail contactDetail = new ContactDetail();
		contactDetail.setId("1");
		ContactEmail contactEmail = new ContactEmail();
		contactEmail.setContactDetailType(EMAIL);
		contactEmail.setAddress(userEntity.getGfEmailDesc());
		contactEmail.setReceivesNotifications(userEntity.getGfEmailVeryfiedType());
		contactDetail.setContactEmail(contactEmail);
		contactDetails.add(contactDetail);
		if (StringUtils.isNotBlank(userEntity.getGfPhoneId())) {
			contactDetail = new ContactDetail();
			contactDetail.setId("2");
			if (userEntity.getGPhoneType().equals(LANDLINE)) {
				ContactLandLine contactLandLine = new ContactLandLine();
				contactLandLine.setContactDetailType(LANDLINE);
				contactLandLine.setNumber(userEntity.getGfPhoneId());
				contactLandLine.setCountryCode(userEntity.getGPrefixPhoneId());
				contactLandLine.setExtension(userEntity.getGfExtensionPhoneId());
				contactDetail.setContactLandLine(contactLandLine);
			} else {
				ContactMobile contactMobile = new ContactMobile();
				contactMobile.setContactDetailType(MOBILE);
				contactMobile.setNumber(userEntity.getGfPhoneId());
				contactMobile.setCountryCode(userEntity.getGPrefixPhoneId());
				contactDetail.setContactMobile(contactMobile);
			} 
			contactDetails.add(contactDetail);
		} 
		user.setContactDetails(contactDetails);
		if (StringUtils.isNotBlank(userEntity.getGLanguageId()) && StringUtils.isNotBlank(userEntity.getGTimeZoneId()) && 
				StringUtils.isNotBlank(userEntity.getGDateFormatType()) && StringUtils.isNotBlank(userEntity.getGAmountNumberFormatType())) {
			Preferences preferences = new Preferences();
			preferences.setLanguage(MapperEnumsUser.languageOut(userEntity.getGLanguageId()));
			preferences.setTimeZone(MapperEnumsUser.timeZoneIdOut(userEntity.getGTimeZoneId()));
			preferences.setDateFormat(MapperEnumsUser.dateFormatTypeOut(userEntity.getGDateFormatType()));
			preferences.setAmountFormat(MapperEnumsUser.amounFormatOut(userEntity.getGAmountNumberFormatType()));
			user.setPreferences(preferences);
		} 
		return user;
	}

	public User setUserId(UserManagementEntity userEntity) {
		User user = new User();
		user.setId(userEntity.getGUserId());
		return user;
	}

	public UserManagementEntity setUserEntity(User user, String userId, String auditUser, String recordUpdateType) {
		ContactEmail contactEmail = null;
		ContactLandLine contactLandLine = null;
		ContactMobile contactMobile = null;
		for (ContactDetail contactDetail : user.getContactDetails()) {
			contactEmail = validatedContactEmail(contactDetail, contactEmail);
			contactLandLine = validatedContactLandLine(contactDetail, contactLandLine);
			contactMobile = validatedContactMobile(contactDetail, contactMobile);
		} 
		UserManagementEntity userEntity = new UserManagementEntity();
		userEntity.setGRecordUpdateType(recordUpdateType);
		userEntity.setGUserId(userId);
		userEntity.setGfUserStartDate(new Date());
		setStatus(user, userEntity);
		setPreferences(user, userEntity);
		userEntity.setGPersonalType(EnumDocumentType.NONE.getCodigo());
		userEntity.setGfPersonalId(" ");
		userEntity.setGfPersonalDocVerifiedType("N");
		if (user.getIdentityDocument() != null) {
			userEntity.setGPersonalType(EnumDocumentType.valueOf(user.getIdentityDocument().getDocumentType().getId()).getCodigo());
			userEntity.setGfPersonalId(user.getIdentityDocument().getDocumentNumber());
			userEntity.setGfPersonalDocVerifiedType(user.getIdentityDocument().getIsVerified());
		} 
		userEntity.setGfFirstName(user.getFirstName());
		userEntity.setGfLastName(user.getLastName());
		userEntity.setGfSecondLastName(StringUtils.isBlank(user.getSecondLastName()) ? " " : user.getSecondLastName());
		userEntity.setGfEmailDesc((contactEmail != null) ? contactEmail.getAddress() : " ");
		userEntity.setGfEmailVeryfiedType((contactEmail != null) ? validatedEmailVeryfiedType(contactEmail) : "N");
		userEntity.setGPhoneType("NOPHONE");
		userEntity.setGPrefixPhoneId("000000");
		userEntity.setGfExtensionPhoneId("00000");
		userEntity.setGfPhoneId("000000000000000");
		if (contactLandLine != null || contactMobile != null) {
			userEntity.setGPhoneType(validatedPhoneType(contactMobile));
			userEntity.setGPrefixPhoneId(validatedPrefixPhoneId(contactLandLine, contactMobile));
			userEntity.setGfExtensionPhoneId(validatedExtensionPhoneId(contactLandLine));
			userEntity.setGfPhoneId((contactMobile != null) ? contactMobile.getNumber() : contactLandLine.getNumber());
		} 
		userEntity.setGAddressCountryId(" ");
		userEntity.setGfGeographicalGroupId(" ");
		userEntity.setGfProvinceId(" ");
		userEntity.setGfTownId(" ");
		userEntity.setGRoadType(" ");
		userEntity.setGfAddressRoadDesc(" ");
		userEntity.setGfPrimryAddrRoadNumberId(" ");
		userEntity.setGfSecndyAddrRoadNumberId(" ");
		userEntity.setGfZipcodeId(" ");
		userEntity.setGfUrbanizationType(" ");
		userEntity.setGfUrbanizationName(" ");
		userEntity.setGfAddressVerifiedDate(getInitializedDate());
		userEntity.setGfAddressVerifiedType("N");
		userEntity.setGfAddressDesc(" ");
		userEntity.setGfAddressDistrictId(" ");
		userEntity.setGfAddressReferenceDesc(" ");
		userEntity.setGUserAccessMethodType(
				(user.getAccessType() == null) ? EnumAccessType.USER_PASSWORD.getCodigo() : EnumAccessType.valueOf(user.getAccessType().getId()).getCodigo());
		userEntity.setGfAliasName(StringUtils.isBlank(user.getAlias()) ? " " : user.getAlias());
		userEntity.setGfUserAuditId(auditUser);
		userEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		return userEntity;
	}

	private void setStatus(User user, UserManagementEntity userEntity) {
		if (!StringUtils.isBlank(user.getStatus().getId())) {
			if (user.getStatus().getReason() != null && !StringUtils.isBlank(user.getStatus().getReason().getId())) {
				userEntity.setGUserStatusType(MapperEnumStatus.statusIn(user.getStatus().getId() + "&" + user.getStatus().getReason().getId()));
			} else {
				userEntity.setGUserStatusType(MapperEnumStatus.statusIn(user.getStatus().getId()));
			} 
		} else {
			userEntity.setGUserStatusType(MapperEnumStatus.statusIn("ACTIVE"));
		} 
	}

	private void setPreferences(User user, UserManagementEntity userEntity) {
		if (user.getPreferences() != null && !StringUtils.isBlank(user.getPreferences().getLanguage())) {
			userEntity.setGLanguageId(MapperEnumsUser.languageIn(user.getPreferences().getLanguage()));
		} else {
			userEntity.setGLanguageId(MapperEnumsUser.languageIn("ES"));
		} 
		if (user.getPreferences() != null && !StringUtils.isBlank(user.getPreferences().getTimeZone())) {
			userEntity.setGTimeZoneId(MapperEnumsUser.timeZoneIdIn(user.getPreferences().getTimeZone()));
		} else {
			userEntity.setGTimeZoneId(MapperEnumsUser.timeZoneIdIn("Mexico DF, Central Time (USA and Canada), Saskatchewan"));
		} 
		if (user.getPreferences() != null && !StringUtils.isBlank(user.getPreferences().getDateFormat())) {
			userEntity.setGDateFormatType(MapperEnumsUser.dateFormatTypeIn(user.getPreferences().getDateFormat()));
		} else {
			userEntity.setGDateFormatType(MapperEnumsUser.dateFormatTypeIn("yyyy-MM-dd"));
		} 
		if (user.getPreferences() != null && !StringUtils.isBlank(user.getPreferences().getAmountFormat())) {
			userEntity.setGAmountNumberFormatType(MapperEnumsUser.amounFormatIn(user.getPreferences().getAmountFormat()));
		} else {
			userEntity.setGAmountNumberFormatType(MapperEnumsUser.amounFormatIn("0,000.00"));
		} 
	}

	 
}
