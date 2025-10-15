package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.entity.commons.AuditParamsCommons;

import java.io.Serializable;

public class ExtAttributeMgmtEntity extends AuditParamsCommons implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gExtendedAttributeType;

    public String getgExtendedAttributeType() {
        return gExtendedAttributeType;
    }

    public void setgExtendedAttributeType(String gExtendedAttributeType) {
        this.gExtendedAttributeType = gExtendedAttributeType;
    }

    @Override
    public String toString() {
        return "ExtAttributeMgmtEntity{" +
                "gExtendedAttributeType='" + gExtendedAttributeType + '\'' +
                '}';
    }
}
