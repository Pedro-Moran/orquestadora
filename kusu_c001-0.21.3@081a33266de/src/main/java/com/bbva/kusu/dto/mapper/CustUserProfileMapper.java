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
import com.bbva.kusu.dto.users.types.EnumStatus;
import com.bbva.kusu.dto.users.types.EnumUserCategoryType;
import com.bbva.kusu.dto.users.types.EnumUserProfileType;
import com.bbva.kusu.dto.users.types.EnumUserType;
import com.bbva.kusu.dto.users.util.MapperEnumStatus;

public class CustUserProfileMapper {
	
  private static final String MOBILE = "MOBILE";
  private static final String LIVE = "LIVE";
  private static final String NOPHONE = "NOPHONE";  
  private static final String BUSINESS = "BUSINESS";
  private static final String FULL_OPERATIVE = "FULLOPER";
  private static final String YES = "Y";
  
  public CustUserProfileEntity setCustUserProfile(Profile profileReg, Map<String, String> uuids, String currency, String auditUserReg) {
    CustUserProfileEntity custUserProfileEntityReg = new CustUserProfileEntity();
    custUserProfileEntityReg.setGUserAccountId(uuids.get("uuidAccount"));
    custUserProfileEntityReg.setGUserId(uuids.get("uuidIdentity"));
    custUserProfileEntityReg.setGRolePersonId(profileReg.getRelatedPerson().getId());
    custUserProfileEntityReg.setGPersonRoleType(EnumRoleType.valueOf(profileReg.getRelatedPerson().getRoleType().getId()).getCodigo());
    custUserProfileEntityReg.setGfUserStartDate(new Date());
    custUserProfileEntityReg
      .setGUserStatusType((profileReg.getStatus() == null) ? EnumStatus.ACTIVE.getCodigo() : EnumStatus.valueOf(profileReg.getStatus().getId()).getCodigo());
    custUserProfileEntityReg.setGfUserChangeStatusDate(new Date());
    custUserProfileEntityReg.setGCategoryProfileType((profileReg.getUserCategoryType() == null) ? EnumUserCategoryType.ATTORNEY.getCodigo() : 
        EnumUserCategoryType.valueOf(profileReg.getUserCategoryType().getId()).getCodigo());
    custUserProfileEntityReg.setGfUserAuditId(auditUserReg);
    custUserProfileEntityReg.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    
	if (profileReg.getContactDetails() == null || profileReg.getContactDetails().isEmpty()) {
    	custUserProfileEntityReg.setGfContactChanValidityType("N");
    	custUserProfileEntityReg.setGfPhoneId("000000000000000");
    	custUserProfileEntityReg.setGfExtensionPhoneId("00000");
    	custUserProfileEntityReg.setGPrefixPhoneId("000000");
    	custUserProfileEntityReg.setGPhoneType(NOPHONE);
		
	} else if(profileReg.getContactDetails()!=null && !profileReg.getContactDetails().isEmpty() 
				&& null!=(profileReg.getContactDetails().get(0)).getContactMobile()) {
    	custUserProfileEntityReg.setGfContactChanValidityType((profileReg.getContactDetails().get(0)).getContactMobile().getReceivesNotifications());
    	custUserProfileEntityReg.setGfPhoneId((profileReg.getContactDetails().get(0)).getContactMobile().getNumber());
    	custUserProfileEntityReg.setGfExtensionPhoneId((profileReg.getContactDetails().get(0)).getContactMobile().getExtension());
    	custUserProfileEntityReg.setGPrefixPhoneId((profileReg.getContactDetails().get(0)).getContactMobile().getCountryCode());
    	custUserProfileEntityReg.setGPhoneType("CONMOPHO");
      if("000000000000000".equals(profileReg.getContactDetails().get(0).getContactMobile().getNumber())){
    	  custUserProfileEntityReg.setGPhoneType(NOPHONE);
      }
    } 
	
    custUserProfileEntityReg.setgProfOperativeModeType(FULL_OPERATIVE);
    setCustUserProfileSignatureOperationsRights(custUserProfileEntityReg, profileReg, currency);
    setCustUserProfileUserManagement(custUserProfileEntityReg, profileReg);
        
    setPersonalizationsOfCustUserProfileEntity(custUserProfileEntityReg, profileReg);

    if(profileReg.getRelatedPerson().getDivision() !=null) {
        custUserProfileEntityReg.setgUserProfileGroupId(profileReg.getRelatedPerson().getDivision().getId());
        custUserProfileEntityReg.setgUserProfileGroupType(profileReg.getRelatedPerson().getDivision().getDivisionType());
    }

    return custUserProfileEntityReg;
  }
  
  private void setPersonalizationsOfCustUserProfileEntity(CustUserProfileEntity custUserProfileEntityReg, 
          Profile profileReg) {
      custUserProfileEntityReg.setGUserCustomRoleIndType((profileReg.getHasRolesCustomization() != null && profileReg.getHasRolesCustomization().booleanValue()) ? "Y" : "N");
      custUserProfileEntityReg.setGUserCustomCtrctIndType((profileReg.getHasContractsCustomization() != null && profileReg.getHasContractsCustomization().booleanValue()) ? "Y" : "N");
      custUserProfileEntityReg.setGUpdatedUsrProfileIndType((profileReg.getIsUpdated() != null && profileReg.getIsUpdated().booleanValue()) ? "Y" : "N");
      custUserProfileEntityReg.setgCustomMultitaxIndType((profileReg.getRelatedPerson().getMultitax()!=null && !profileReg.getRelatedPerson().getMultitax().isEmpty())
              ? "Y" : "N");
      custUserProfileEntityReg.setgCstMultitaxRoleIndType("N");
      custUserProfileEntityReg.setgCstMultitaxCtrctIndType("N");
      custUserProfileEntityReg.setgCstExtCtrctIndType("N");
      custUserProfileEntityReg.setgSolProfBastanteoIndType("Y");
      custUserProfileEntityReg.setgCstMltxExtCtrctIndType("N");
  }
  
  private void setCustUserProfileSignatureOperationsRights(CustUserProfileEntity custUserProfileEntityReg, Profile profileReg, String currency) {
    if (profileReg.getSignatureOperationsRights() == null) {
    	custUserProfileEntityReg.setGfSignatureWeightPer(EnumSignaturePower.NONE.getValue());
    } else {
    	custUserProfileEntityReg.setGfSignatureWeightPer(
          EnumSignaturePower.getByDescription(profileReg.getSignatureOperationsRights().getSignaturePower().getId()).getValue());
      if (profileReg.getSignatureOperationsRights().getLimitAmount() != null && 
        !profileReg.getSignatureOperationsRights().getSignaturePower().getId().equals(EnumSignaturePower.NONE.name())) {
    	  custUserProfileEntityReg.setGfSignatureLimitAmount(BigDecimal.valueOf(profileReg.getSignatureOperationsRights().getLimitAmount().getAmount().doubleValue()));
    	  custUserProfileEntityReg.setGCurrencyId(profileReg.getSignatureOperationsRights().getLimitAmount().getCurrency());
      } else if (profileReg.getSignatureOperationsRights().getLimitAmount() == null && 
        !profileReg.getSignatureOperationsRights().getSignaturePower().getId().equals(EnumSignaturePower.NONE.name())) {
    	  custUserProfileEntityReg.setGfSignatureLimitAmount(new BigDecimal("999999999999.999999"));
    	  custUserProfileEntityReg.setGCurrencyId(currency);
      } 
    } 
  }
  
  private void setCustUserProfileUserManagement(CustUserProfileEntity custUserProfileEntity, Profile profile) {
    if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USERS_MANAGER.getCodigo())) {
      custUserProfileEntity.setGUserProfileId(EnumUserProfileType.USERS_MANAGER.getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USER_H2H.getCodigo())) {
      custUserProfileEntity.setGUserProfileId(EnumUserType.USER_H2H.getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else if (profile.getUserManagement().getUserType().getId().equals(EnumUserType.USER_API_CHANNEL.getCodigo())) {
      custUserProfileEntity.setGUserProfileId(EnumUserType.USER_API_CHANNEL.getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(
          EnumManagerUsersPower.getByDescription(profile.getUserManagement().getUsersAdministrationRights().getId()).getValue());
    } else {
      custUserProfileEntity.setGUserProfileId(EnumUserProfileType.NON_USERS_MANAGER.getCodigo());
      custUserProfileEntity.setGfUserValidationWeightPer(EnumManagerUsersPower.NONE.getValue());
    } 
  }
  
  public Profile setProfile(CustUserProfileEntity custUserProfileEntityReg) {
    Profile profileReg = new Profile();
    profileReg.setId(custUserProfileEntityReg.getGUserAccountId());
    RelatedPerson relatedPersonReg = new RelatedPerson();
    relatedPersonReg.setId(custUserProfileEntityReg.getGRolePersonId());
    
    PersonType personTypeReg = new PersonType();
    personTypeReg.setId(BUSINESS);
    relatedPersonReg.setPersonType(personTypeReg);
    
    RoleType roleTypeReg = new RoleType();
    roleTypeReg.setId(EnumRoleType.getByCodigo(custUserProfileEntityReg.getGPersonRoleType()).name());
    relatedPersonReg.setRoleType(roleTypeReg);
    
    if(StringUtils.isNoneBlank(custUserProfileEntityReg.getgUserProfileGroupId(), custUserProfileEntityReg.getgUserProfileGroupType())){
    	Division division = new Division();
    	division.setId(custUserProfileEntityReg.getgUserProfileGroupId());
    	division.setDivisionType(custUserProfileEntityReg.getgUserProfileGroupType());
    	relatedPersonReg.setDivision(division);
    }
    
    profileReg.setRelatedPerson(relatedPersonReg);
    profileReg.setStatusMode(LIVE);
    profileReg.setStatus(MapperEnumStatus.getStatusEntity(custUserProfileEntityReg.getGUserStatusType()));
    UserCategoryType userCategoryTypeReg = new UserCategoryType();
    userCategoryTypeReg.setId(EnumUserCategoryType.getByCodigo(custUserProfileEntityReg.getGCategoryProfileType()).name());
    profileReg.setUserCategoryType(userCategoryTypeReg);
    
    if (!NOPHONE.equalsIgnoreCase(custUserProfileEntityReg.getGPhoneType()) 
    		&& StringUtils.isNotBlank(custUserProfileEntityReg.getGfPhoneId()) 
    		&& StringUtils.isNotBlank(custUserProfileEntityReg.getGPrefixPhoneId())) {
    	List<ContactDetail> contactDetailsReg = new ArrayList<>();
	    ContactDetail contacDetailReg = new ContactDetail();
	    ContactMobile contactMobileReg = new ContactMobile();
	    contactMobileReg.setNumber(custUserProfileEntityReg.getGfPhoneId());
	    contactMobileReg.setContactDetailType(MOBILE);
	    contactMobileReg.setReceivesNotifications(custUserProfileEntityReg.getGfContactChanValidityType());
	    contactMobileReg.setCountryCode(custUserProfileEntityReg.getGPrefixPhoneId());
	    contacDetailReg.setContactMobile(contactMobileReg);
	    contactDetailsReg.add(contacDetailReg);
    	profileReg.setContactDetails(contactDetailsReg); 
    }
    
    if (custUserProfileEntityReg.getGfSignatureWeightPer() != null) {
      SignatureOperationsRights signatureOperationsRights = new SignatureOperationsRights();
      if (custUserProfileEntityReg.getGfSignatureLimitAmount() != null && custUserProfileEntityReg.getGCurrencyId() != null) {
        LimitAmount limitAmount = new LimitAmount();
        limitAmount.setAmount(Double.valueOf(custUserProfileEntityReg.getGfSignatureLimitAmount().doubleValue()));
        limitAmount.setCurrency(custUserProfileEntityReg.getGCurrencyId());
        signatureOperationsRights.setLimitAmount(limitAmount);
      } 
      SignaturePower signaturePowerReg = new SignaturePower();
      signaturePowerReg.setId(EnumSignaturePower.getByValue(custUserProfileEntityReg.getGfSignatureWeightPer()).name());
      signatureOperationsRights.setSignaturePower(signaturePowerReg);
      profileReg.setSignatureOperationsRights(signatureOperationsRights);
    } 
    
    UserManagement userManagement = new UserManagement();
    UsersAdministrationRights usersAdministrationRights = new UsersAdministrationRights();
	if(custUserProfileEntityReg.getGUserProfileId().equals(EnumUserType.NON_USERS_MANAGER.getCodigo()) ||
			!EnumUserType.containsCode(custUserProfileEntityReg.getGUserProfileId())){
		userManagement.setUserType(new UserType());
		userManagement.getUserType().setId(EnumUserType.NON_USERS_MANAGER.getDescripcion());
		usersAdministrationRights.setId(EnumManagerUsersPower.NONE.name());
		userManagement.setUsersAdministrationRights(usersAdministrationRights);
	}	else {
		userManagement.setUserType(new UserType());
		userManagement.getUserType().setId(EnumUserType.getByCodigo(custUserProfileEntityReg.getGUserProfileId()).getDescripcion());
		usersAdministrationRights.setId(EnumManagerUsersPower.getByValue(custUserProfileEntityReg.getGfUserValidationWeightPer()).name());
		userManagement.setUsersAdministrationRights(usersAdministrationRights);
	}
	
    profileReg.setUserManagement(userManagement);
    profileReg.setUpdated(Boolean.valueOf(YES.equals(custUserProfileEntityReg.getGUpdatedUsrProfileIndType())));
    profileReg.setHasContractsCustomization(Boolean.valueOf(YES.equals(custUserProfileEntityReg.getGUserCustomCtrctIndType()) || YES.equals(custUserProfileEntityReg.getgCstMultitaxCtrctIndType())));
    profileReg.setHasRolesCustomization(Boolean.valueOf(YES.equals(custUserProfileEntityReg.getGUserCustomRoleIndType()) || YES.equals(custUserProfileEntityReg.getgCstMultitaxRoleIndType())));
	profileReg.setHasExternalContractCustomization(Boolean.valueOf(YES.equals(custUserProfileEntityReg.getgCstExtCtrctIndType()) || YES.equals(custUserProfileEntityReg.getgCstMltxExtCtrctIndType())));

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    profileReg.setStartDate(dateFormat.format(custUserProfileEntityReg.getGfUserStartDate()));
    profileReg.setChangeStatusDate(dateFormat.format(custUserProfileEntityReg.getGfUserChangeStatusDate()));
    return profileReg;
  }
  
  //T_KUSU_CUST_USER_PROFILE
  public static CustUserProfileEntity profileFromMgmt(CuserProfManagementEntity profile, String audit) {
		CustUserProfileEntity entity = new CustUserProfileEntity();
		entity.setGUserAccountId(profile.getGUserAccountId());
		entity.setGUserId(profile.getGUserId());
		entity.setGPersonRoleType(profile.getGPersonRoleType());
		entity.setGRolePersonId(profile.getGRolePersonId());
		entity.setGfUserStartDate(profile.getGfUserStartDate());
		entity.setGUserStatusType(profile.getGUserStatusType());
		entity.setGfUserChangeStatusDate(profile.getGfUserChangeStatusDate());
		entity.setGUserProfileId(profile.getGUserProfileId());
		entity.setGCategoryProfileType(profile.getGCategoryProfileType());
		entity.setGfSignatureWeightPer(profile.getGfSignatureWeightPer());
		entity.setGfSignatureLimitAmount(profile.getGfSignatureLimitAmount());
		entity.setGCurrencyId(profile.getGCurrencyId());
		entity.setGPhoneType(profile.getGPhoneType());
		entity.setGPrefixPhoneId(profile.getGPrefixPhoneId());
		entity.setGfExtensionPhoneId(profile.getGfExtensionPhoneId());
		entity.setGfPhoneId(profile.getGfPhoneId());
		entity.setGfContactChanValidityType(profile.getGfContactChanValidityType());
		entity.setGfUserValidationWeightPer(profile.getGfUserValidationWeightPer());
		entity.setGUserCustomRoleIndType(profile.getGUserCustomRoleIndType());
		entity.setGUserCustomCtrctIndType(profile.getGUserCustomCtrctIndType());
		entity.setGUpdatedUsrProfileIndType(profile.getGUpdatedUsrProfileIndType());
		entity.setGUserMgmtMasterIndType(profile.getGUserMgmtMasterIndType());
		entity.setGfUserAuditId(audit);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgCustomMultitaxIndType(profile.getgCustomMultitaxIndType());
		entity.setgCstMultitaxRoleIndType(profile.getgCstMultitaxRoleIndType());
		entity.setgCstMultitaxCtrctIndType(profile.getgCstMultitaxCtrctIndType());
		entity.setgCstExtCtrctIndType(profile.getgCstExtCtrctIndType());
		entity.setgSolProfBastanteoIndType(profile.getgSolProfBastanteoIndType());
		entity.setgProfOperativeModeType(profile.getgProfOperativeModeType());
		entity.setgCstMltxExtCtrctIndType(profile.getgCstMltxExtCtrctIndType());
		entity.setgUserProfileGroupId(profile.getgUserProfileGroupId());
		entity.setgUserProfileGroupType(profile.getgUserProfileGroupType());
		entity.setgAuthMechanismCstmIndType(profile.getgAuthMechanismCstmIndType());
		entity.setgAdminSmcPackageIndType(profile.getgAdminSmcPackageIndType());
		entity.setgOfflineDeleteIndType(profile.getgOfflineDeleteIndType());
		return entity;
	}
}