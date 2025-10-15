package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

import java.io.Serializable;
import java.math.BigDecimal;

public class CstContractRoleAttEntity extends AuditParamsCommons implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gContractId;
    private String gUserAccountId;
    private BigDecimal gRecordSequentialId;
    private BigDecimal gfSignatureLimitAmount;
    private String gCurrencyId;
    private BigDecimal gfSignatureWeightPer;
    private String gfUserRoleId;
    private String gfUserCapabilityId;
    private String gfSmcInternalId;
    private String gUserPermissionCtrctId;
    private String gCustomerId;
    private String gOfflineDeleteIndType;

    public String getgContractId() {
        return gContractId;
    }

    public String getgUserAccountId() {
        return gUserAccountId;
    }

    public BigDecimal getgRecordSequentialId() {
        return gRecordSequentialId;
    }

    public BigDecimal getGfSignatureLimitAmount() {
        return gfSignatureLimitAmount;
    }

    public String getgCurrencyId() {
        return gCurrencyId;
    }

    public BigDecimal getGfSignatureWeightPer() {
        return gfSignatureWeightPer;
    }

    public String getGfUserRoleId() {
        return gfUserRoleId;
    }

    public String getGfUserCapabilityId() {
        return gfUserCapabilityId;
    }

    public String getGfSmcInternalId() {
        return gfSmcInternalId;
    }

    public String getgUserPermissionCtrctId() {
        return gUserPermissionCtrctId;
    }

    public String getgCustomerId() {
        return gCustomerId;
    }

    public String getgOfflineDeleteIndType() {
        return gOfflineDeleteIndType;
    }

    public void setgContractId(String gContractId) {
        this.gContractId = gContractId;
    }

    public void setgUserAccountId(String gUserAccountId) {
        this.gUserAccountId = gUserAccountId;
    }

    public void setgRecordSequentialId(BigDecimal gRecordSequentialId) {
        this.gRecordSequentialId = gRecordSequentialId;
    }

    public void setGfSignatureLimitAmount(BigDecimal gfSignatureLimitAmount) {
        this.gfSignatureLimitAmount = gfSignatureLimitAmount;
    }

    public void setgCurrencyId(String gCurrencyId) {
        this.gCurrencyId = gCurrencyId;
    }

    public void setGfSignatureWeightPer(BigDecimal gfSignatureWeightPer) {
        this.gfSignatureWeightPer = gfSignatureWeightPer;
    }

    public void setGfUserRoleId(String gfUserRoleId) {
        this.gfUserRoleId = gfUserRoleId;
    }

    public void setGfUserCapabilityId(String gfUserCapabilityId) {
        this.gfUserCapabilityId = gfUserCapabilityId;
    }

    public void setGfSmcInternalId(String gfSmcInternalId) {
        this.gfSmcInternalId = gfSmcInternalId;
    }

    public void setgUserPermissionCtrctId(String gUserPermissionCtrctId) {
        this.gUserPermissionCtrctId = gUserPermissionCtrctId;
    }

    public void setgCustomerId(String gCustomerId) {
        this.gCustomerId = gCustomerId;
    }

    public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
        this.gOfflineDeleteIndType = gOfflineDeleteIndType;
    }

    @Override
    public String toString() {
        return "CstContractRoleAttEntity{" +
                "gContractId='" + gContractId + ", gUserAccountId='" + gUserAccountId + ", gRecordSequentialId=" + gRecordSequentialId
                + ", gfSignatureLimitAmount=" + gfSignatureLimitAmount + ", gCurrencyId='" + gCurrencyId + ", gfSignatureWeightPer=" + gfSignatureWeightPer
                + ", gfUserRoleId='" + gfUserRoleId  + ", gfUserCapabilityId='" + gfUserCapabilityId + ", gfSmcInternalId='" + gfSmcInternalId
                + ", gUserPermissionCtrctId='" + gUserPermissionCtrctId + ", gCustomerId='" + gCustomerId + ", gOfflineDeleteIndType='" + gOfflineDeleteIndType + '}';
    }
}
