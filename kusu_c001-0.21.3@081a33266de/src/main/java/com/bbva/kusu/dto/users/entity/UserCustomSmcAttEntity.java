package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.entity.commons.GeneralSmcCommons;

import java.io.Serializable;

public class UserCustomSmcAttEntity extends GeneralSmcCommons implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gfSmcInternalId;
    private String gUserSgntrSmcIndType;

    public String getGfSmcInternalId() {
        return gfSmcInternalId;
    }

    public void setGfSmcInternalId(String gfSmcInternalId) {
        this.gfSmcInternalId = gfSmcInternalId;
    }

    public String getgUserSgntrSmcIndType() {
        return gUserSgntrSmcIndType;
    }

    public void setgUserSgntrSmcIndType(String gUserSgntrSmcIndType) {
        this.gUserSgntrSmcIndType = gUserSgntrSmcIndType;
    }

    @Override
    public String toString() {
        return "UserCustomSmcAttEntity{" +
                "gfSmcInternalId='" + gfSmcInternalId + '\'' +
                ", gUserSgntrSmcIndType='" + gUserSgntrSmcIndType + '\'' +
                '}' + super.toString();
    }
}
