package com.bbva.kusu.dto.mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bbva.kusu.dto.users.beans.ContactDetail;
import com.bbva.kusu.dto.users.beans.ContactMobile;
import com.bbva.kusu.dto.users.beans.Division;
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
import com.bbva.kusu.dto.users.entity.CuserProfManagementEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfileEntity;
import com.bbva.kusu.dto.users.types.EnumManagerUsersPower;
import com.bbva.kusu.dto.users.types.EnumRoleType;
import com.bbva.kusu.dto.users.types.EnumSignaturePower;
import com.bbva.kusu.dto.users.types.EnumUserCategoryType;
import com.bbva.kusu.dto.users.types.EnumUserType;
import com.bbva.kusu.dto.users.util.MapperEnumStatus;

public class CuserProfMapperMgmt {
	
  private static final String MOBILE = "MOBILE";  
  private static final String PENDING = "PENDING";  
  private static final String NOPHONE = "NOPHONE";
  private static final String FULL_OPERATIVE = "FULLOPER";
  
  public CuserProfManagementEntity setCustUserProfile(Profile profile, Map<String, String> uuids, String currency, String auditUser, String recordUpdateType) {
    CuserProfManagementEntity custUserProfileEntity = new CuserProfManagementEntity();
    custUserProfileEntity.setGRecordUpdateType(recordUpdateType);
    custUserProfileEntity.setGUserAccountId(uuids.get("uuidAccount"));
    custUserProfileEntity.setGUserId(uuids.get("uuidIdentity"));
    custUserProfileEntity.setGPersonRoleType(EnumRoleType.valueOf(profile.getRelatedPerson().getRoleType().getId()).getCodigo());
    custUserProfileEntity.setGRolePersonId(profile.getRelatedPerson().getId());
    custUserProfileEntity.setgCstMultitaxRoleIndType("N");
    custUserProfileEntity.setgCstMltxExtCtrctIndType("N");
    custUserProfileEntity.setgProfOperativeModeType(FULL_OPERATIVE);
    custUserProfileEntity.setgCustomMultitaxIndType((profile.getRelatedPerson().getMultitax()!=null && !profile.getRelatedPerson().getMultitax().isEmpty())
    		? "Y" : "N");
    custUserProfileEntity.setGfUserStartDate(new Date());
    setStatus(profile, custUserProfileEntity);
    custUserProfileEntity.setGfUserChangeStatusDate(new Date());
    custUserProfileEntity.setGCategoryProfileType((profile.getUserCategoryType() == null) ? EnumUserCategoryType.ATTORNEY.getCodigo() : 
        EnumUserCategoryType.valueOf(profile.getUserCategoryType().getId()).getCodigo());
    custUserProfileEntity.setGfUserAuditId(auditUser);
    custUserProfileEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    if (profile.getContactDetails() == null || profile.getContactDetails().isEmpty()) {
      custUserProfileEntity.setGfContactChanValidityType("N");
      custUserProfileEntity.setGfPhoneId("000000000000000");
      custUserProfileEntity.setGfExtensionPhoneId("00000");
      custUserProfileEntity.setGPrefixPhoneId("000000");
      custUserProfileEntity.setGPhoneType(NOPHONE);
    } else {
      setContactDetails(profile.getContactDetails(), custUserProfileEntity);
    } 
    setCustUserProfileSignatureOperationsRights(custUserProfileEntity, profile, currency);
    setCustUserProfileUserManagement(custUserProfileEntity, profile);
    custUserProfileEntity.setGUserCustomRoleIndType((profile.getHasRolesCustomization() != null && profile.getHasRolesCustomization().booleanValue()) ? "Y" : "N");
    custUserProfileEntity.setGUserCustomCtrctIndType((profile.getHasContractsCustomization() != null && profile.getHasContractsCustomization().booleanValue()) ? "Y" : "N");
    custUserProfileEntity.setGUpdatedUsrProfileIndType((profile.getIsUpdated() != null && profile.getIsUpdated().booleanValue()) ? "Y" : "N");
    custUserProfileEntity.setgCstMultitaxCtrctIndType("N");
    custUserProfileEntity.setgCstExtCtrctIndType("N");
    custUserProfileEntity.setgSolProfBastanteoIndType("N");

    if(profile.getRelatedPerson().getDivision() !=null) {
      custUserProfileEntity.setgUserProfileGroupId(profile.getRelatedPerson().getDivision().getId());
      custUserProfileEntity.setgUserProfileGroupType(profile.getRelatedPerson().getDivision().getDivisionType());
    }

    return custUserProfileEntity;
  }
  
  private void setContactDetails(List<ContactDetail> contactDetails, CuserProfManagementEntity custUserProfileEnitityContactDetails) {
    if ((contactDetails.get(0)).getContactMobile().getReceivesNotifications() == null || (contactDetails
      .get(0)).getContactMobile().getReceivesNotifications().isEmpty()) {
    	custUserProfileEnitityContactDetails.setGfContactChanValidityType("N");
    } else {
    	custUserProfileEnitityContactDetails.setGfContactChanValidityType((contactDetails.get(0)).getContactMobile().getReceivesNotifications());
    } 
    custUserProfileEnitityContactDetails.setGfPhoneId((contactDetails.get(0)).getContactMobile().getNumber());
    if ((contactDetails.get(0)).getContactMobile().getExtension() == null || (contactDetails.get(0)).getContactMobile().getExtension().isEmpty()) {
    	custUserProfileEnitityContactDetails.setGfExtensionPhoneId("00000");
    } else {
    	custUserProfileEnitityContactDetails.setGfExtensionPhoneId((contactDetails.get(0)).getContactMobile().getExtension());
    } 
    if ((contactDetails.get(0)).getContactMobile().getCountryCode() == null || (contactDetails.get(0)).getContactMobile().getCountryCode().isEmpty()) {
    	custUserProfileEnitityContactDetails.setGPrefixPhoneId("000000");
    } else {
    	custUserProfileEnitityContactDetails.setGPrefixPhoneId((contactDetails.get(0)).getContactMobile().getCountryCode());
    } 
    custUserProfileEnitityContactDetails.setGPhoneType(contactDetails.get(0).getContactMobile()!=null ? "CONMOPHO" : "LANDLINE");
    if(contactDetails.get(0).getContactMobile().getNumber().equals("000000000000000")){
    	custUserProfileEnitityContactDetails.setGPhoneType(NOPHONE);
    }
  }
  
  private void setStatus(Profile profile, CuserProfManagementEntity custUserProfileEntity) {
    if (!StringUtils.isBlank(profile.getStatus().getId())) {
      if (profile.getStatus().getReason() != null && !StringUtils.isBlank(profile.getStatus().getReason().getId())) {
        custUserProfileEntity
          .setGUserStatusType(MapperEnumStatus.statusIn(profile.getStatus().getId() + "&" + profile.getStatus().getReason().getId()));
      } else {
        custUserProfileEntity.setGUserStatusType(MapperEnumStatus.statusIn(profile.getStatus().getId()));
      } 
    } else {
      custUserProfileEntity.setGUserStatusType(MapperEnumStatus.statusIn("ACTIVE"));
    } 
  }
  
  private void setCustUserProfileSignatureOperationsRights(CuserProfManagementEntity custUserProfileEntity, Profile profile, String currency) {
    if (profile.getSignatureOperationsRights() == null) {
      custUserProfileEntity.setGfSignatureWeightPer(EnumSignaturePower.NONE.getValue());
    } else {
      custUserProfileEntity.setGfSignatureWeightPer(
          EnumSignaturePower.getByDescription(profile.getSignatureOperationsRights().getSignaturePower().getId()).getValue());
      if (profile.getSignatureOperationsRights().getLimitAmount() != null && 
        !profile.getSignatureOperationsRights().getSignaturePower().getId().equals(EnumSignaturePower.NONE.name())) {
        custUserProfileEntity.setGfSignatureLimitAmount(BigDecimal.valueOf(profile.getSignatureOperationsRights().getLimitAmount().getAmount().doubleValue()));
        custUserProfileEntity.setGCurrencyId(profile.getSignatureOperationsRights().getLimitAmount().getCurrency());
      } else if (profile.getSignatureOperationsRights().getLimitAmount() == null && 
        !profile.getSignatureOperationsRights().getSignaturePower().getId().equals(EnumSignaturePower.NONE.name())) {
        custUserProfileEntity.setGfSignatureLimitAmount(new BigDecimal("999999999999.999999"));
        custUserProfileEntity.setGCurrencyId(currency);
      } 
    } 
  }
  
  private void setCustUserProfileUserManagement(CuserProfManagementEntity custUserProfileEntity, Profile profile) {
    if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.NON_USERS_MANAGER.getDescripcion())) {
      custUserProfileEntity.setGUserProfileId(EnumUserType.NON_USERS_MANAGER.getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(EnumManagerUsersPower.NONE.getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USER_H2H.getDescripcion())) {
      custUserProfileEntity.setGUserProfileId(EnumUserType.USER_H2H.getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USER_API_CHANNEL.getDescripcion())) {
      custUserProfileEntity.setGUserProfileId(EnumUserType.USER_API_CHANNEL.getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else {
      custUserProfileEntity.setGUserProfileId(EnumUserType.getByDescripcion(profile.getUserManagement().getUserType().getId()).getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } 
  }
  
  public Profile setProfile(CuserProfManagementEntity custUserProfileEntity) {
    Profile profile = new Profile();
    profile.setId(custUserProfileEntity.getGUserAccountId());
    RelatedPerson relatedPerson = new RelatedPerson();
    relatedPerson.setId(custUserProfileEntity.getGRolePersonId());
    
    PersonType personTypeReg = new PersonType();
    personTypeReg.setId("BUSINESS");
    relatedPerson.setPersonType(personTypeReg);
    
    RoleType roleTypeReg = new RoleType();
    roleTypeReg.setId(EnumRoleType.getByCodigo(custUserProfileEntity.getGPersonRoleType()).name());
    relatedPerson.setRoleType(roleTypeReg);
    
    if(StringUtils.isNoneBlank(custUserProfileEntity.getgUserProfileGroupId(), custUserProfileEntity.getgUserProfileGroupType())){
    	Division division = new Division();
    	division.setId(custUserProfileEntity.getgUserProfileGroupId());
    	division.setDivisionType(custUserProfileEntity.getgUserProfileGroupType());
    	relatedPerson.setDivision(division);
    }
    
    profile.setRelatedPerson(relatedPerson);
    profile.setStatusMode(PENDING);
    profile.setStatus(MapperEnumStatus.getStatusEntity(custUserProfileEntity.getGUserStatusType()));
    UserCategoryType userCategoryType = new UserCategoryType();
    userCategoryType.setId(EnumUserCategoryType.getByCodigo(custUserProfileEntity.getGCategoryProfileType()).name());
    profile.setUserCategoryType(userCategoryType);
    List<ContactDetail> contactDetails = new ArrayList<>();
    ContactDetail contacDetail = new ContactDetail();
    ContactMobile contactMobile = new ContactMobile();
    contactMobile.setNumber(custUserProfileEntity.getGfPhoneId());
    contactMobile.setContactDetailType(MOBILE);
    contactMobile.setReceivesNotifications(custUserProfileEntity.getGfContactChanValidityType());
    contactMobile.setCountryCode(custUserProfileEntity.getGPrefixPhoneId());
    contacDetail.setContactMobile(contactMobile);
    contactDetails.add(contacDetail);
    if (custUserProfileEntity.getGfPhoneId() != null && custUserProfileEntity.getGPrefixPhoneId() != null)
      profile.setContactDetails(contactDetails); 
    if (custUserProfileEntity.getGfSignatureWeightPer() != null) {
      SignatureOperationsRights signatureOperationsRights = new SignatureOperationsRights();
      if (custUserProfileEntity.getGfSignatureLimitAmount() != null && custUserProfileEntity.getGCurrencyId() != null) {
        LimitAmount limitAmount = new LimitAmount();
        limitAmount.setAmount(Double.valueOf(custUserProfileEntity.getGfSignatureLimitAmount().doubleValue()));
        limitAmount.setCurrency(custUserProfileEntity.getGCurrencyId());
        signatureOperationsRights.setLimitAmount(limitAmount);
      } 
      SignaturePower signaturePower = new SignaturePower();
      signaturePower.setId(EnumSignaturePower.getByValue(custUserProfileEntity.getGfSignatureWeightPer()).name());
      signatureOperationsRights.setSignaturePower(signaturePower);
      profile.setSignatureOperationsRights(signatureOperationsRights);
    } 
    
    UserManagement userManagement = new UserManagement();
    UsersAdministrationRights usersAdministrationRights = new UsersAdministrationRights();
	if(custUserProfileEntity.getGUserProfileId().equals(EnumUserType.NON_USERS_MANAGER.getCodigo()) ||
			!EnumUserType.containsCode(custUserProfileEntity.getGUserProfileId())){
		userManagement.setUserType(new UserType());
		userManagement.getUserType().setId(EnumUserType.NON_USERS_MANAGER.getDescripcion());
		usersAdministrationRights.setId(EnumManagerUsersPower.NONE.name());
		userManagement.setUsersAdministrationRights(usersAdministrationRights);
	}	else {
		userManagement.setUserType(new UserType());
		userManagement.getUserType().setId(EnumUserType.getByCodigo(custUserProfileEntity.getGUserProfileId()).getDescripcion());
		usersAdministrationRights.setId(EnumManagerUsersPower.getByValue(custUserProfileEntity.getGfUserValidationWeightPer()).name());
		userManagement.setUsersAdministrationRights(usersAdministrationRights);
	}
	
    profile.setUserManagement(userManagement);
    profile.setUpdated(Boolean.valueOf("Y".equals(custUserProfileEntity.getGUpdatedUsrProfileIndType())));
    profile.setHasContractsCustomization(Boolean.valueOf("Y".equals(custUserProfileEntity.getGUserCustomCtrctIndType()) || "Y".equals(custUserProfileEntity.getgCstMultitaxCtrctIndType())));
    profile.setHasRolesCustomization(Boolean.valueOf("Y".equals(custUserProfileEntity.getGUserCustomRoleIndType()) || "Y".equals(custUserProfileEntity.getgCstMultitaxRoleIndType())));
	profile.setHasExternalContractCustomization(Boolean.valueOf("Y".equals(custUserProfileEntity.getgCstExtCtrctIndType()) || "Y".equals(custUserProfileEntity.getgCstMltxExtCtrctIndType())));

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    profile.setStartDate(dateFormat.format(custUserProfileEntity.getGfUserStartDate()));
    profile.setChangeStatusDate(dateFormat.format(custUserProfileEntity.getGfUserChangeStatusDate()));
    return profile;
  }
  
  //T_KUSU_CUSER_PROF_MANAGEMENT
  public static CuserProfManagementEntity mapFromCustUserProfile(CustUserProfileEntity userProfile, String recordType) {
    CuserProfManagementEntity res = new CuserProfManagementEntity();
    res.setGCategoryProfileType(userProfile.getGCategoryProfileType());
    res.setGCurrencyId(userProfile.getGCurrencyId());
    res.setGPersonRoleType(userProfile.getGPersonRoleType());
    res.setGRolePersonId(userProfile.getGRolePersonId());
    res.setGfAuditDate(userProfile.getGfAuditDate());
    res.setGfContactChanValidityType(userProfile.getGfContactChanValidityType());
    res.setGfExtensionPhoneId(userProfile.getGfExtensionPhoneId());
    res.setGfPhoneId(userProfile.getGfPhoneId());
    res.setGfSignatureLimitAmount(userProfile.getGfSignatureLimitAmount());
    res.setGfSignatureWeightPer(userProfile.getGfSignatureWeightPer());
    res.setGfUserAuditId(userProfile.getGfUserAuditId());
    res.setGfUserChangeStatusDate(userProfile.getGfUserChangeStatusDate());
    res.setGfUserStartDate(userProfile.getGfUserStartDate());
    res.setGfUserValidationWeightPer(userProfile.getGfUserValidationWeightPer());
    res.setGPhoneType(userProfile.getGPhoneType());
    res.setGPrefixPhoneId(userProfile.getGPrefixPhoneId());
    res.setGRecordUpdateType(recordType);
    res.setGUpdatedUsrProfileIndType(userProfile.getGUpdatedUsrProfileIndType());
    res.setGUserMgmtMasterIndType(userProfile.getGUserMgmtMasterIndType());
    res.setGUserAccountId(userProfile.getGUserAccountId());
    res.setGUserCustomCtrctIndType(userProfile.getGUserCustomCtrctIndType());
    res.setGUserCustomRoleIndType(userProfile.getGUserCustomRoleIndType());
    res.setgCstMultitaxRoleIndType(userProfile.getgCstMultitaxRoleIndType());
    res.setgCustomMultitaxIndType(userProfile.getgCustomMultitaxIndType());
    res.setGUserId(userProfile.getGUserId());
    res.setGUserProfileId(userProfile.getGUserProfileId());
    res.setGUserStatusType(userProfile.getGUserStatusType());
    res.setgCstMultitaxCtrctIndType(userProfile.getgCstMultitaxCtrctIndType());
    res.setgCstExtCtrctIndType(userProfile.getgCstExtCtrctIndType());
    res.setgSolProfBastanteoIndType(userProfile.getgSolProfBastanteoIndType());
    res.setgProfOperativeModeType(userProfile.getgProfOperativeModeType());
    res.setgCstMltxExtCtrctIndType(userProfile.getgCstMltxExtCtrctIndType());
    res.setgUserProfileGroupId(userProfile.getgUserProfileGroupId());
    res.setgUserProfileGroupType(userProfile.getgUserProfileGroupType());
    res.setgAuthMechanismCstmIndType(userProfile.getgAuthMechanismCstmIndType());
    res.setgAdminSmcPackageIndType(userProfile.getgAdminSmcPackageIndType());
    res.setgOfflineDeleteIndType(userProfile.getgOfflineDeleteIndType());
    return res;
  }
}