package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProfLimitsEntity extends AuditParamsCommons implements Serializable {

    private String gUserAccountId;
    private String gCurrencyId;
    private BigDecimal gfSignatureLimitAmount;
    private String gOfflineDeleteIndType;

    public String getgUserAccountId() {
        return gUserAccountId;
    }

    public void setgUserAccountId(String gUserAccountId) {
        this.gUserAccountId = gUserAccountId;
    }

    public String getgCurrencyId() {
        return gCurrencyId;
    }

    public void setgCurrencyId(String gCurrencyId) {
        this.gCurrencyId = gCurrencyId;
    }

    public BigDecimal getGfSignatureLimitAmount() {
        return gfSignatureLimitAmount;
    }

    public void setGfSignatureLimitAmount(BigDecimal gfSignatureLimitAmount) {
        this.gfSignatureLimitAmount = gfSignatureLimitAmount;
    }

    public String getgOfflineDeleteIndType() {
        return gOfflineDeleteIndType;
    }

    public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
        this.gOfflineDeleteIndType = gOfflineDeleteIndType;
    }

    @Override
    public String toString() {
        return "ProfLimits{" +
                "gUserAccountId='" + gUserAccountId + '\'' +
                ", gCurrencyId='" + gCurrencyId + '\'' +
                ", gfSignatureLimitAmount=" + gfSignatureLimitAmount +
                ", gOfflineDeleteIndType='" + gOfflineDeleteIndType + '\'' +
                '}';
    }
}
