package com.bbva.kusu.dto.mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bbva.kusu.dto.users.beans.ContactDetail;
import com.bbva.kusu.dto.users.beans.ContactMobile;
import com.bbva.kusu.dto.users.beans.LimitAmount;
import com.bbva.kusu.dto.users.beans.PersonType;
import com.bbva.kusu.dto.users.beans.Profile;
import com.bbva.kusu.dto.users.beans.RelatedPerson;
import com.bbva.kusu.dto.users.beans.RoleType;
import com.bbva.kusu.dto.users.beans.SignatureOperationsRights;
import com.bbva.kusu.dto.users.beans.SignaturePower;
import com.bbva.kusu.dto.users.beans.UserCategoryType;
import com.bbva.kusu.dto.users.beans.UserManagement;
import com.bbva.kusu.dto.users.beans.UserType;
import com.bbva.kusu.dto.users.beans.UsersAdministrationRights;
import com.bbva.kusu.dto.users.entity.NcustUserProfileEntity;
import com.bbva.kusu.dto.users.types.EnumManagerUsersPower;
import com.bbva.kusu.dto.users.types.EnumRoleType;
import com.bbva.kusu.dto.users.types.EnumSignaturePower;
import com.bbva.kusu.dto.users.types.EnumStatus;
import com.bbva.kusu.dto.users.types.EnumUserCategoryType;
import com.bbva.kusu.dto.users.types.EnumUserProfileType;
import com.bbva.kusu.dto.users.types.EnumUserType;
import com.bbva.kusu.dto.users.util.MapperEnumStatus;

public class NcustUserProfileMapper {
  private static final String MOBILE = "MOBILE";
  private static final String NOPHONE = "NOPHONE";
  
  public NcustUserProfileEntity setNcustUserProfile(Profile profile, Map<String, String> uuids, String currency, String auditUser) {
    NcustUserProfileEntity ncustUserProfileEntity = new NcustUserProfileEntity();
    ncustUserProfileEntity.setGUserAccountId(uuids.get("uuidAccount"));
    ncustUserProfileEntity.setGUserId(uuids.get("uuidIdentity"));
    ncustUserProfileEntity.setGNonCustomerId(profile.getRelatedPerson().getId());
    ncustUserProfileEntity.setGRolePersonId(profile.getRelatedPerson().getId());
    ncustUserProfileEntity.setGPersonRoleType(EnumRoleType.valueOf(profile.getRelatedPerson().getRoleType().getId()).getCodigo());
    ncustUserProfileEntity.setGfUserStartDate(new Date());
    ncustUserProfileEntity.setGUserStatusType((profile.getStatus() == null) ? EnumStatus.ACTIVE.getCodigo() : 
        EnumStatus.valueOf(profile.getStatus().getId()).getCodigo());
    ncustUserProfileEntity.setGfUserChangeStatusDate(new Date());
    ncustUserProfileEntity.setGCategoryProfileType(
        (profile.getUserCategoryType() == null) ? EnumUserCategoryType.ATTORNEY.getCodigo() : 
        EnumUserCategoryType.valueOf(profile.getUserCategoryType().getId()).getCodigo());
    ncustUserProfileEntity.setGfUserAuditId(auditUser);
    ncustUserProfileEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    if (profile.getContactDetails() == null || profile.getContactDetails().isEmpty()) {
      ncustUserProfileEntity.setGfContactChanValidityType("N");
      ncustUserProfileEntity.setGfPhoneId("000000000000000");
      ncustUserProfileEntity.setGfExtensionPhoneId("00000");
      ncustUserProfileEntity.setGPrefixPhoneId("000000");
	  ncustUserProfileEntity.setGPhoneType(NOPHONE);
    } else if(profile.getContactDetails()!=null && !profile.getContactDetails().isEmpty() 
		&& null!=(profile.getContactDetails().get(0)).getContactMobile()) {
      ncustUserProfileEntity.setGfContactChanValidityType((profile.getContactDetails().get(0)).getContactMobile().getReceivesNotifications());
      ncustUserProfileEntity.setGfPhoneId((profile.getContactDetails().get(0)).getContactMobile().getNumber());
      ncustUserProfileEntity.setGfExtensionPhoneId((profile.getContactDetails().get(0)).getContactMobile().getExtension());
      ncustUserProfileEntity.setGPrefixPhoneId((profile.getContactDetails().get(0)).getContactMobile().getCountryCode());
      ncustUserProfileEntity.setGPhoneType(MOBILE);
      if("000000000000000".equals(profile.getContactDetails().get(0).getContactMobile().getNumber())){
        ncustUserProfileEntity.setGPhoneType(NOPHONE);
      }
    } 
	
	
    ncustUserProfileEntity.setgUserCustomRoleIndType("N");
    ncustUserProfileEntity.setgUserCustomCtrctIndType("N");
    ncustUserProfileEntity.setgUpdatedUsrProfileIndType("N");
    setNcustUserProfileSignatureOperationsRights(ncustUserProfileEntity, profile, currency);
    setNcustUserProfileUserManagement(ncustUserProfileEntity, profile);
    return ncustUserProfileEntity;
  }
  
  private void setNcustUserProfileSignatureOperationsRights(NcustUserProfileEntity ncustUserProfileEntity, Profile profile, String currency) {
    if (profile.getSignatureOperationsRights() == null) {
      ncustUserProfileEntity.setGfSignatureWeightPer(EnumSignaturePower.NONE.getValue());
    } else {
      ncustUserProfileEntity.setGfSignatureWeightPer(
          EnumSignaturePower.getByDescription(profile.getSignatureOperationsRights().getSignaturePower().getId()).getValue());
      if (profile.getSignatureOperationsRights().getLimitAmount() != null && 
        
        !profile.getSignatureOperationsRights().getSignaturePower().getId().equals(EnumSignaturePower.NONE.name())) {
        ncustUserProfileEntity.setGfSignatureLimitAmount(
            BigDecimal.valueOf(profile.getSignatureOperationsRights().getLimitAmount().getAmount().doubleValue()));
        ncustUserProfileEntity
          .setGCurrencyId(profile.getSignatureOperationsRights().getLimitAmount().getCurrency());
      } else if (profile.getSignatureOperationsRights().getLimitAmount() == null && 
        
        !profile.getSignatureOperationsRights().getSignaturePower().getId().equals(EnumSignaturePower.NONE.name())) {
        ncustUserProfileEntity.setGfSignatureLimitAmount(new BigDecimal("999999999999.999999"));
        ncustUserProfileEntity.setGCurrencyId(currency);
      } 
    } 
  }
  
  private void setNcustUserProfileUserManagement(NcustUserProfileEntity ncustUserProfileEntity, Profile profile) {
    if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USERS_MANAGER.getCodigo())) {
      ncustUserProfileEntity.setGUserProfileId(EnumUserProfileType.USERS_MANAGER.getCodigo());
      ncustUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USER_H2H.getCodigo())) {
      ncustUserProfileEntity.setGUserProfileId(EnumUserType.USER_H2H.getCodigo());
      ncustUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USER_API_CHANNEL.getCodigo())) {
      ncustUserProfileEntity.setGUserProfileId(EnumUserType.USER_API_CHANNEL.getCodigo());
      ncustUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.OPEN_BANKING.getCodigo())) {
        ncustUserProfileEntity.setGUserProfileId(EnumUserType.OPEN_BANKING.getCodigo());
        ncustUserProfileEntity.setGfUserValidationWeightPer(
            EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.ECP_FILES.getCodigo())) {
        ncustUserProfileEntity.setGUserProfileId(EnumUserType.ECP_FILES.getCodigo());
        ncustUserProfileEntity.setGfUserValidationWeightPer(
            EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else {
      ncustUserProfileEntity.setGUserProfileId(EnumUserProfileType.NON_USERS_MANAGER.getCodigo());
      ncustUserProfileEntity.setGfUserValidationWeightPer(EnumManagerUsersPower.NONE.getValue());
    } 
  }
  
  public Profile setProfile(NcustUserProfileEntity ncustUserProfileEntity) {
    Profile profile = new Profile();
    profile.setId(ncustUserProfileEntity.getGUserAccountId());
    RelatedPerson relatedPerson = new RelatedPerson();
    relatedPerson.setId(ncustUserProfileEntity.getGRolePersonId());
    PersonType personType = new PersonType();
    personType.setId("NON_BUSINESS");
    relatedPerson.setPersonType(personType);
    relatedPerson.setRoleType(new RoleType());
    relatedPerson.getRoleType().setId(EnumRoleType.getByCodigo(ncustUserProfileEntity.getGPersonRoleType()).name());
    profile.setRelatedPerson(relatedPerson);
    UserCategoryType userCategoryType = new UserCategoryType();
    userCategoryType
      .setId(EnumUserCategoryType.getByCodigo(ncustUserProfileEntity.getGCategoryProfileType()).name());
    profile.setUserCategoryType(userCategoryType);
    profile.setStatus(MapperEnumStatus.getStatusEntity(ncustUserProfileEntity.getGUserStatusType()));
    List<ContactDetail> contactDetails = new ArrayList<>();
    ContactDetail contacDetail = new ContactDetail();
    ContactMobile contactMobile = new ContactMobile();
    contactMobile.setContactDetailType(MOBILE);
    contactMobile.setReceivesNotifications(ncustUserProfileEntity.getGfContactChanValidityType());
    contactMobile.setCountryCode(ncustUserProfileEntity.getGPrefixPhoneId());
    contactMobile.setNumber(ncustUserProfileEntity.getGfPhoneId());
    contacDetail.setContactMobile(contactMobile);
    contactDetails.add(contacDetail);
    if (ncustUserProfileEntity.getGfPhoneId() != null && ncustUserProfileEntity.getGPrefixPhoneId() != null)
      profile.setContactDetails(contactDetails); 
    if (ncustUserProfileEntity.getGfSignatureWeightPer() != null) {
      SignatureOperationsRights signatureOperationsRights = new SignatureOperationsRights();
      if (ncustUserProfileEntity.getGfSignatureLimitAmount() != null && ncustUserProfileEntity
        .getGCurrencyId() != null) {
        LimitAmount limitAmount = new LimitAmount();
        limitAmount.setAmount(Double.valueOf(ncustUserProfileEntity.getGfSignatureLimitAmount().doubleValue()));
        limitAmount.setCurrency(ncustUserProfileEntity.getGCurrencyId());
        signatureOperationsRights.setLimitAmount(limitAmount);
      } 
      SignaturePower signaturePower = new SignaturePower();
      signaturePower
        .setId(EnumSignaturePower.getByValue(ncustUserProfileEntity.getGfSignatureWeightPer()).name());
      signatureOperationsRights.setSignaturePower(signaturePower);
      profile.setSignatureOperationsRights(signatureOperationsRights);
    } 
    UserManagement userManagement = new UserManagement();
    UserType userType = new UserType();
    UsersAdministrationRights usersAdministrationRights = new UsersAdministrationRights();
    if (ncustUserProfileEntity.getGUserProfileId().equals(EnumUserType.USERS_MANAGER.getCodigo())) {
      userType.setId(EnumUserType.USERS_MANAGER.getCodigo());
      userManagement.setUserType(userType);
      usersAdministrationRights.setId(EnumManagerUsersPower.getByValue(ncustUserProfileEntity.getGfUserValidationWeightPer()).name());
      userManagement.setUsersAdministrationRights(usersAdministrationRights);
    } else if (ncustUserProfileEntity.getGUserProfileId().equals(EnumUserType.USER_H2H.getCodigo())) {
      userType.setId(EnumUserType.USER_H2H.getCodigo());
      userManagement.setUserType(userType);
      usersAdministrationRights.setId(EnumManagerUsersPower.getByValue(ncustUserProfileEntity.getGfUserValidationWeightPer()).name());
      userManagement.setUsersAdministrationRights(usersAdministrationRights);
    } else if (ncustUserProfileEntity.getGUserProfileId().equals(EnumUserType.USER_API_CHANNEL.getCodigo())) {
      userType.setId(EnumUserType.USER_API_CHANNEL.getCodigo());
      userManagement.setUserType(userType);
      usersAdministrationRights.setId(EnumManagerUsersPower.getByValue(ncustUserProfileEntity.getGfUserValidationWeightPer()).name());
      userManagement.setUsersAdministrationRights(usersAdministrationRights);
    } else if (ncustUserProfileEntity.getGUserProfileId().equals(EnumUserType.OPEN_BANKING.getCodigo())) {
        userType.setId(EnumUserType.OPEN_BANKING.getCodigo());
        userManagement.setUserType(userType);
        usersAdministrationRights.setId(EnumManagerUsersPower.getByValue(ncustUserProfileEntity.getGfUserValidationWeightPer()).name());
        userManagement.setUsersAdministrationRights(usersAdministrationRights);
    } else if (ncustUserProfileEntity.getGUserProfileId().equals(EnumUserType.ECP_FILES.getCodigo())) {
        userType.setId(EnumUserType.ECP_FILES.getCodigo());
        userManagement.setUserType(userType);
        usersAdministrationRights.setId(EnumManagerUsersPower.getByValue(ncustUserProfileEntity.getGfUserValidationWeightPer()).name());
        userManagement.setUsersAdministrationRights(usersAdministrationRights);
    } else {
      userType.setId(EnumUserType.NON_USERS_MANAGER.getCodigo());
      userManagement.setUserType(userType);
      usersAdministrationRights.setId(EnumManagerUsersPower.NONE.name());
      userManagement.setUsersAdministrationRights(usersAdministrationRights);
    } 
    profile.setUserManagement(userManagement);
    profile.setUpdated(Boolean.valueOf("Y".equals(ncustUserProfileEntity.getgUpdatedUsrProfileIndType())));
    profile.setHasContractsCustomization(Boolean.valueOf("Y".equals(ncustUserProfileEntity.getgUserCustomRoleIndType())));
    profile.setHasRolesCustomization(Boolean.valueOf("Y".equals(ncustUserProfileEntity.getgUserCustomRoleIndType())));
	profile.setHasExternalContractCustomization(Boolean.valueOf("Y".equals(ncustUserProfileEntity.getgCstExtCtrctIndType())));

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    profile.setStartDate(dateFormat.format(ncustUserProfileEntity.getGfUserStartDate()));
    profile.setChangeStatusDate(dateFormat.format(ncustUserProfileEntity.getGfUserChangeStatusDate()));
    return profile;
  }
}
