package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProfExtAuthAttribEntity  extends AuditParamsCommons implements Serializable {

    private static final long serialVersionUID = 1L;


    private String gUserAccountId;
    private String gExtendedAttributeId;
    private String gExtendedAttributeType;
    private String gExtAttribVerifIndType;
    private String gExtAttributeStatusType;
    private Timestamp gExtAttribStatChanDate;
    private String gOfflineDeleteIndType;

    public String getgUserAccountId() {
        return gUserAccountId;
    }

    public void setgUserAccountId(String gUserAccountId) {
        this.gUserAccountId = gUserAccountId;
    }

    public String getgExtendedAttributeId() {
        return gExtendedAttributeId;
    }

    public void setgExtendedAttributeId(String gExtendedAttributeId) {
        this.gExtendedAttributeId = gExtendedAttributeId;
    }

    public String getgExtendedAttributeType() {
        return gExtendedAttributeType;
    }

    public void setgExtendedAttributeType(String gExtendedAttributeType) {
        this.gExtendedAttributeType = gExtendedAttributeType;
    }

    public String getgExtAttribVerifIndType() {
        return gExtAttribVerifIndType;
    }

    public void setgExtAttribVerifIndType(String gExtAttribVerifIndType) {
        this.gExtAttribVerifIndType = gExtAttribVerifIndType;
    }

    public String getgExtAttributeStatusType() {
        return gExtAttributeStatusType;
    }

    public void setgExtAttributeStatusType(String gExtAttributeStatusType) {
        this.gExtAttributeStatusType = gExtAttributeStatusType;
    }

    public Timestamp getgExtAttribStatChanDate() {
        return gExtAttribStatChanDate;
    }

    public void setgExtAttribStatChanDate(Timestamp gExtAttribStatChanDate) {
        this.gExtAttribStatChanDate = gExtAttribStatChanDate;
    }

    public String getgOfflineDeleteIndType() {
        return gOfflineDeleteIndType;
    }

    public void setgOfflineDeleteIndType(String gOfflineDeleteIndType) {
        this.gOfflineDeleteIndType = gOfflineDeleteIndType;
    }

    @Override
    public String toString() {
        return "ProfExtAuthAttribEntity{" +
                "gUserAccountId='" + gUserAccountId + '\'' +
                ", gExtendedAttributeId='" + gExtendedAttributeId + '\'' +
                ", gExtendedAttributeType='" + gExtendedAttributeType + '\'' +
                ", gExtAttribVerifIndType='" + gExtAttribVerifIndType + '\'' +
                ", gExtAttributeStatusType='" + gExtAttributeStatusType + '\'' +
                ", gExtAttribStatChanDate=" + gExtAttribStatChanDate +
                ", gOfflineDeleteIndType='" + gOfflineDeleteIndType + '\'' +
                '}';
    }
}
