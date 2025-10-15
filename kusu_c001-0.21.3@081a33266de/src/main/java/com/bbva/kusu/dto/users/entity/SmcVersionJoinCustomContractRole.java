package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SmcVersionJoinCustomContractRole implements Serializable {
	private static final long serialVersionUID = 1L;

	private String rolePersonId;

	private String personRoleType;

	private String customerId;

	private String multitaxCustomer;

	private String smcId;

	private String smcInternalId;

	private String capabilityId;

	private String userRoleId;

	private String isAdmin;
	
	private String hasContractFlag; 

	private BigDecimal gfSignatureWeightPer;

	private BigDecimal userValidationWeightPer;
	
	private String capOrSmcNonCustomizeContInd;
	
	private String smcCustomizeFlag;

	private BigDecimal gfSignatureLimitAmount;

	private String gCurrencyId;

	private String gUserPermissionSmcType;



	private List<CustomContractRoleEntity> listCustomContractRoleEntity;
	
	private List<ProfCstMltxContRoleEntity> listCustomContractRoleEntityMltx;
	
	private List<String> operativeModes;

	private String userSgntrSmcIndType;
	
	private String relationshipId;

	private List<CurrencyData> listMultiCurrency;

	private String applyBastanteo;


	public String getUserSgntrSmcIndType() {
		return userSgntrSmcIndType;
	}

	public void setUserSgntrSmcIndType(String userSgntrSmcIndType) {
		this.userSgntrSmcIndType = userSgntrSmcIndType;
	}

	public String getRolePersonId() {
		return rolePersonId;
	}

	public void setRolePersonId(String rolePersonId) {
		this.rolePersonId = rolePersonId;
	}

	public String getPersonRoleType() {
		return personRoleType;
	}

	public void setPersonRoleType(String personRoleType) {
		this.personRoleType = personRoleType;
	}

	public String getMultitaxCustomer() {
		return multitaxCustomer;
	}

	public void setMultitaxCustomer(String multitaxCustomer) {
		this.multitaxCustomer = multitaxCustomer;
	}

	public String getSmcId() {
		return this.smcId;
	}

	public void setSmcId(String smcId) {
		this.smcId = smcId;
	}

	public String getSmcInternalId() {
		return this.smcInternalId;
	}

	public void setSmcInternalId(String smcInternalId) {
		this.smcInternalId = smcInternalId;
	}

	public String getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getCapabilityId() {
		return capabilityId;
	}

	public void setCapabilityId(String capabilityId) {
		this.capabilityId = capabilityId;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public BigDecimal getGfSignatureWeightPer() {
		return gfSignatureWeightPer;
	}

	public void setGfSignatureWeightPer(BigDecimal gfSignatureWeightPer) {
		this.gfSignatureWeightPer = gfSignatureWeightPer;
	}

	public BigDecimal getUserValidationWeightPer() {
		return this.userValidationWeightPer;
	}

	public void setUserValidationWeightPer(BigDecimal userValidationWeightPer) {
		this.userValidationWeightPer = userValidationWeightPer;
	}

	public List<CustomContractRoleEntity> getListCustomContractRoleEntity() {
		return this.listCustomContractRoleEntity;
	}

	public void setListCustomContractRoleEntity(List<CustomContractRoleEntity> listCustomContractRoleEntity) {
		this.listCustomContractRoleEntity = listCustomContractRoleEntity;
	}
	

	public List<ProfCstMltxContRoleEntity> getListCustomContractRoleEntityMltx() {
		return listCustomContractRoleEntityMltx;
	}

	public void setListCustomContractRoleEntityMltx(List<ProfCstMltxContRoleEntity> listCustomContractRoleEntityMltx) {
		this.listCustomContractRoleEntityMltx = listCustomContractRoleEntityMltx;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
	public String getHasContractFlag() {
		return hasContractFlag;
	}

	public void setHasContractFlag(String hasContractFlag) {
		this.hasContractFlag = hasContractFlag;
	}
	
	public String getCapOrSmcNonCustomizeContInd() {
		return capOrSmcNonCustomizeContInd;
	}

	public void setCapOrSmcNonCustomizeContInd(String capOrSmcNonCustomizeContInd) {
		this.capOrSmcNonCustomizeContInd = capOrSmcNonCustomizeContInd;
	}
	
	public String getSmcCustomizeFlag() {
		return smcCustomizeFlag;
	}

	public void setSmcCustomizeFlag(String smcCustomizeFlag) {
		this.smcCustomizeFlag = smcCustomizeFlag;
	}
	

	public List<String> getOperativeModes() {
		return operativeModes;
	}

	public void setOperativeModes(List<String> operativeModes) {
		this.operativeModes = operativeModes;
	}
	

	public String getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(String relationshipId) {
		this.relationshipId = relationshipId;
	}

	public List<CurrencyData> getListMultiCurrency() {
		return listMultiCurrency;
	}

	public void setListMultiCurrency(List<CurrencyData> listMultiCurrency) {
		this.listMultiCurrency = listMultiCurrency;
	}

	public String getApplyBastanteo() {return applyBastanteo;}

	public void setApplyBastanteo(String applyBastanteo) {this.applyBastanteo = applyBastanteo;}

	public String getgUserPermissionSmcType() {
		return gUserPermissionSmcType;
	}

	public void setgUserPermissionSmcType(String gUserPermissionSmcType) {
		this.gUserPermissionSmcType = gUserPermissionSmcType;
	}

	public BigDecimal getGfSignatureLimitAmount() {
		return gfSignatureLimitAmount;
	}

	public void setGfSignatureLimitAmount(BigDecimal gfSignatureLimitAmount) {
		this.gfSignatureLimitAmount = gfSignatureLimitAmount;
	}

	public String getgCurrencyId() {
		return gCurrencyId;
	}

	public void setgCurrencyId(String gCurrencyId) {
		this.gCurrencyId = gCurrencyId;
	}

	@Override
	public String toString() {
		return "SmcVersionJoinCustomContractRole{" + "rolePersonId='" + rolePersonId + '\'' + ", personRoleType='" + personRoleType + '\'' + ", customerId='" + customerId + '\'' + ", multitaxCustomer='" + multitaxCustomer + '\'' + ", smcId='" + smcId + '\'' + ", smcInternalId='" + smcInternalId + '\'' + ", capabilityId='" + capabilityId + '\'' + ", userRoleId='" + userRoleId + '\'' + ", isAdmin='" + isAdmin + '\'' + ", hasContractFlag='" + hasContractFlag + '\'' + ", gfSignatureWeightPer=" + gfSignatureWeightPer + ", userValidationWeightPer=" + userValidationWeightPer + ", capOrSmcNonCustomizeContInd='" + capOrSmcNonCustomizeContInd + '\'' + ", smcCustomizeFlag='" + smcCustomizeFlag + '\'' + ", gfSignatureLimitAmount=" + gfSignatureLimitAmount + ", gCurrencyId='" + gCurrencyId + '\'' + ", gUserPermissionSmcType='" + gUserPermissionSmcType + '\'' + ", listCustomContractRoleEntity=" + listCustomContractRoleEntity + ", listCustomContractRoleEntityMltx=" + listCustomContractRoleEntityMltx + ", operativeModes=" + operativeModes + ", userSgntrSmcIndType='" + userSgntrSmcIndType + '\'' + ", relationshipId='" + relationshipId + '\'' + ", listMultiCurrency=" + listMultiCurrency + ", applyBastanteo=" + applyBastanteo + '}';
	}
}
