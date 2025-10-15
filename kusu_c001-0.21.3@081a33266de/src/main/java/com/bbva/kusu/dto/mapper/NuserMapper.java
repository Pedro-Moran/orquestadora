package com.bbva.kusu.dto.mapper;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.bbva.kusu.dto.users.beans.AccessType;
import com.bbva.kusu.dto.users.beans.ContactDetail;
import com.bbva.kusu.dto.users.beans.ContactEmail;
import com.bbva.kusu.dto.users.beans.ContactLandLine;
import com.bbva.kusu.dto.users.beans.ContactMobile;
import com.bbva.kusu.dto.users.beans.DocumentType;
import com.bbva.kusu.dto.users.beans.IdentityDocument;
import com.bbva.kusu.dto.users.beans.Preferences;
import com.bbva.kusu.dto.users.beans.User;
import com.bbva.kusu.dto.users.entity.NuserEntity;
import com.bbva.kusu.dto.users.types.EnumAccessType;
import com.bbva.kusu.dto.users.types.EnumDocumentType;
import com.bbva.kusu.dto.users.util.MapperEnumStatus;
import com.bbva.kusu.dto.users.util.MapperEnumsUser;

public class NuserMapper {
  private static final String EMAIL = "EMAIL";
  
  private static final String MOBILE = "MOBILE";
  
  private static final String LANDLINE = "LANDLINE";
  
  public User setUser(NuserEntity nuserEntity) {
    User user = new User();
    user.setFirstName(nuserEntity.getGfFirstName());
    user.setId(nuserEntity.getGUserId());
    user.setLastName(nuserEntity.getGfLastName());
    user.setEntryDate(nuserEntity.getGfUserStartDate());
    user.setAlias(nuserEntity.getGfAliasName());
    user.setSecondLastName(nuserEntity.getGfSecondLastName());
    if (StringUtils.isNotBlank(nuserEntity.getGPersonalType()) && !EnumDocumentType.NONE.getCodigo().equals(nuserEntity.getGPersonalType())) {
      IdentityDocument identityDocument = new IdentityDocument();
      DocumentType documentType = new DocumentType();
      documentType.setId(EnumDocumentType.getByCodigo(nuserEntity.getGPersonalType()).name());
      identityDocument.setDocumentType(documentType);
      identityDocument.setDocumentNumber(nuserEntity.getGfPersonalId());
      identityDocument.setIsVerified(nuserEntity.getGfPersonalDocVerifiedType());
      user.setIdentityDocument(identityDocument);
    } 
    if (StringUtils.isNotBlank(nuserEntity.getGUserAccessMethodType())) {
      AccessType accessType = new AccessType();
      accessType.setId(EnumAccessType.getByCodigo(nuserEntity.getGUserAccessMethodType()).name());
      user.setAccessType(accessType);
    } 
    user.setStatus(MapperEnumStatus.getStatusEntity(nuserEntity.getGUserStatusType()));
    List<ContactDetail> contactDetails = new ArrayList<>();
    ContactEmail contactEmail = new ContactEmail();
    contactEmail.setContactDetailType(EMAIL);
    contactEmail.setAddress(nuserEntity.getGfEmailDesc());
    contactEmail.setReceivesNotifications(nuserEntity.getGfEmailVeryfiedType());
    ContactDetail contactDetail = new ContactDetail();
    contactDetail.setId("1");
    contactDetail.setContactEmail(contactEmail);
    contactDetails.add(contactDetail);
    if (StringUtils.isNotBlank(nuserEntity.getGfPhoneId())) {
      contactDetail = new ContactDetail();
      contactDetail.setId("2");
      if (nuserEntity.getGPhoneType().equals(LANDLINE)) {
        ContactLandLine contactLandLine = new ContactLandLine();
        contactLandLine.setContactDetailType(LANDLINE);
        contactLandLine.setExtension(nuserEntity.getGfExtensionPhoneId());
        contactLandLine.setCountryCode(nuserEntity.getGPrefixPhoneId());
        contactLandLine.setNumber(nuserEntity.getGfPhoneId());
        contactDetail.setContactLandLine(contactLandLine);
      } else {
        ContactMobile contactMobile = new ContactMobile();
        contactMobile.setNumber(nuserEntity.getGfPhoneId());
        contactMobile.setCountryCode(nuserEntity.getGPrefixPhoneId());
        contactMobile.setContactDetailType(MOBILE);
        contactDetail.setContactMobile(contactMobile);
      } 
      contactDetails.add(contactDetail);
    } 
    user.setContactDetails(contactDetails);
    if (StringUtils.isNotBlank(nuserEntity.getGLanguageId()) && StringUtils.isNotBlank(nuserEntity.getGTimeZoneId()) && 
      StringUtils.isNotBlank(nuserEntity.getGDateFormatType()) && StringUtils.isNotBlank(nuserEntity.getGAmountNumberFormatType())) {
      Preferences preferences = new Preferences();
      preferences.setDateFormat(MapperEnumsUser.dateFormatTypeOut(nuserEntity.getGDateFormatType()));
      preferences.setAmountFormat(MapperEnumsUser.amounFormatOut(nuserEntity.getGAmountNumberFormatType()));
      preferences.setLanguage(MapperEnumsUser.languageOut(nuserEntity.getGLanguageId()));
      preferences.setTimeZone(MapperEnumsUser.timeZoneIdOut(nuserEntity.getGTimeZoneId()));
      user.setPreferences(preferences);
    } 
    return user;
  }
  
  private Date getInitializedDate() {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String initializedDateStr = "1900-01-01 00:00:00";
    return formatter.parse(initializedDateStr, new ParsePosition(0));
    
  }
  
  public NuserEntity setNuserEntity(User user, String userId, String auditUser) {
    ContactEmail contactEmail = null;
    ContactLandLine contactLandLine = null;
    ContactMobile contactMobile = null;
    for (ContactDetail contactDetail : user.getContactDetails()) {
      contactLandLine = validatedContactLandLine(contactDetail, contactLandLine);
      contactMobile = validatedContactMobile(contactDetail, contactMobile);
      contactEmail = validatedContactEmail(contactDetail, contactEmail);
    } 
    NuserEntity nuserEntity = new NuserEntity();
    nuserEntity.setGUserId(userId);
    nuserEntity.setGfUserStartDate(new Date());
    nuserEntity.setGUserStatusType(MapperEnumStatus.statusIn("ACTIVE"));
    nuserEntity.setGLanguageId(MapperEnumsUser.languageIn("ES"));
    nuserEntity.setGTimeZoneId(MapperEnumsUser.timeZoneIdIn("Mexico DF, Central Time (USA and Canada), Saskatchewan"));
    nuserEntity.setGDateFormatType(MapperEnumsUser.dateFormatTypeIn("yyyy-MM-dd"));
    nuserEntity.setGAmountNumberFormatType(MapperEnumsUser.amounFormatIn("0,000.00"));
    if (user.getIdentityDocument() == null) {
      nuserEntity.setGPersonalType(EnumDocumentType.NONE.getCodigo());
      nuserEntity.setGfPersonalId(" ");
      nuserEntity.setGfPersonalDocVerifiedType("N");
    } else {
      nuserEntity.setGPersonalType(EnumDocumentType.valueOf(user.getIdentityDocument().getDocumentType().getId()).getCodigo());
      nuserEntity.setGfPersonalId(user.getIdentityDocument().getDocumentNumber());
      nuserEntity.setGfPersonalDocVerifiedType(user.getIdentityDocument().getIsVerified());
    } 
    nuserEntity.setGfFirstName(user.getFirstName());
    nuserEntity.setGfLastName(user.getLastName());
    nuserEntity.setGfSecondLastName(StringUtils.isBlank(user.getSecondLastName()) ? " " : user.getSecondLastName());
    nuserEntity.setGfPersonNameSuffixType(" ");
    nuserEntity.setGfEmailDesc((contactEmail != null) ? contactEmail.getAddress() : " ");
    nuserEntity.setGfEmailVeryfiedType((contactEmail != null) ? validatedEmailVeryfiedType(contactEmail) : " ");
    if (contactLandLine == null && contactMobile == null) {
      nuserEntity.setGPhoneType("NOPHONE");
      nuserEntity.setGPrefixPhoneId("000000");
      nuserEntity.setGfExtensionPhoneId("00000");
      nuserEntity.setGfPhoneId("000000000000000");
    } else {
      nuserEntity.setGPhoneType(validatedPhoneType(contactLandLine));
      nuserEntity.setGPrefixPhoneId(validatedPrefixPhoneId(contactLandLine, contactMobile));
      nuserEntity.setGfExtensionPhoneId(validatedExtensionPhoneId(contactLandLine));
      nuserEntity.setGfPhoneId((contactLandLine != null) ? contactLandLine.getNumber() : contactMobile.getNumber());
    } 
    nuserEntity.setGAddressCountryId(" ");
    nuserEntity.setGfGeographicalGroupId(" ");
    nuserEntity.setGfProvinceId(" ");
    nuserEntity.setGfTownId(" ");
    nuserEntity.setGRoadType(" ");
    nuserEntity.setGfAddressRoadDesc(" ");
    nuserEntity.setGfPrimryAddrRoadNumberId(" ");
    nuserEntity.setGfSecndyAddrRoadNumberId(" ");
    nuserEntity.setGfZipcodeId(" ");
    nuserEntity.setGfUrbanizationType(" ");
    nuserEntity.setGfUrbanizationName(" ");
    nuserEntity.setGfAddressVerifiedDate(getInitializedDate());
    nuserEntity.setGfAddressVerifiedType("N");
    nuserEntity.setGfAddressDesc(" ");
    nuserEntity.setGfAddressDistrictId(" ");
    nuserEntity.setGfAddressReferenceDesc(" ");
    nuserEntity.setGUserAccessMethodType(
        (user.getAccessType() == null) ? EnumAccessType.USER_PASSWORD.getCodigo() : EnumAccessType.valueOf(user.getAccessType().getId()).getCodigo());
    nuserEntity.setGfAliasName(StringUtils.isBlank(user.getAlias()) ? " " : user.getAlias());
    nuserEntity.setGNonCustomerId(" ");
    nuserEntity.setGfUserAuditId(auditUser);
    nuserEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    return nuserEntity;
  }
  
  public User setUserId(NuserEntity nuserEntity) {
    User user = new User();
    user.setId(nuserEntity.getGUserId());
    return user;
  }
  
  private String validatedExtensionPhoneId(ContactLandLine contactLandLine) {
    if (contactLandLine == null || StringUtils.isBlank(contactLandLine.getExtension()))
      return " "; 
    return contactLandLine.getExtension();
  }
  
  private String validatedPrefixPhoneId(ContactLandLine contactLandLine, ContactMobile contactMobile) {
    String prefixPhoneId = " ";
    if (contactLandLine != null && StringUtils.isNotBlank(contactLandLine.getCountryCode()))
      prefixPhoneId = contactLandLine.getCountryCode(); 
    if (contactMobile != null && StringUtils.isNotBlank(contactMobile.getCountryCode()))
      prefixPhoneId = contactMobile.getCountryCode(); 
    return prefixPhoneId;
  }
  
  private String validatedPhoneType(ContactLandLine contactLandLine) {
    if (contactLandLine != null)
      return LANDLINE; 
    return MOBILE;
  }
  
  private ContactEmail validatedContactEmail(ContactDetail contactDetail, ContactEmail contactEmail) {
    return (contactDetail.getContactEmail() == null) ? contactEmail : contactDetail.getContactEmail();
  }
  
  private ContactLandLine validatedContactLandLine(ContactDetail contactDetail, ContactLandLine contactLandLine) {
    return (contactDetail.getContactLandLine() == null) ? contactLandLine : contactDetail.getContactLandLine();
  }
  
  private ContactMobile validatedContactMobile(ContactDetail contactDetail, ContactMobile contactMobile) {
    return (contactDetail.getContactMobile() == null) ? contactMobile : contactDetail.getContactMobile();
  }
  
  private String validatedEmailVeryfiedType(ContactEmail contactEmail) {
    if (StringUtils.isBlank(contactEmail.getReceivesNotifications()))
      return "N"; 
    return contactEmail.getReceivesNotifications();
  }
}
