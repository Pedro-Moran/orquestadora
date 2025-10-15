package com.bbva.kusu.dto.users.entity;


import java.io.Serializable;


public class ProfCstMltxSmcAttEntity extends UserCustomSmcAttEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    private String gCustomerId;

    public String getgCustomerId() {
        return gCustomerId;
    }

    public void setgCustomerId(String gCustomerId) {
        this.gCustomerId = gCustomerId;
    }

    @Override
    public String toString() {
        return "ProfCstMltxSmcAttEntity [super.toString()=" + super.toString() + "]";
    }

}
