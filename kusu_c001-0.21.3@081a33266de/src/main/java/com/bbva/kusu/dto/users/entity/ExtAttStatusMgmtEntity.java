package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

import java.io.Serializable;

public class ExtAttStatusMgmtEntity extends AuditParamsCommons implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gExtAttributeStatusType;

    public String getgExtAttributeStatusType() {
        return gExtAttributeStatusType;
    }

    public void setgExtAttributeStatusType(String gExtAttributeStatusType) {
        this.gExtAttributeStatusType = gExtAttributeStatusType;
    }

    @Override
    public String toString() {
        return "ExtAttStatusMgmtEntity{" +
                "gExtAttributeStatusType='" + gExtAttributeStatusType + '\'' +
                '}';
    }
}
