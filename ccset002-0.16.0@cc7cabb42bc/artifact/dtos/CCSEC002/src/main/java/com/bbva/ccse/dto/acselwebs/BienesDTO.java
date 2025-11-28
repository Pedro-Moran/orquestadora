package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class BienesDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String desc;
    private String porcentaje;
    private String tar;
    private String capital;
    private String ind;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTar() {
        return tar;
    }

    public void setTar(String tar) {
        this.tar = tar;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BienesDTO bienesDTO = (BienesDTO) o;
        return Objects.equals(desc, bienesDTO.desc) && Objects.equals(porcentaje, bienesDTO.porcentaje) && Objects.equals(tar, bienesDTO.tar) && Objects.equals(capital, bienesDTO.capital) && Objects.equals(ind, bienesDTO.ind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desc, porcentaje, tar, capital, ind);
    }

    @Override
    public String toString() {
        return "BienesDTO{" +
                "desc='" + desc + '\'' +
                ", porcentaje='" + porcentaje + '\'' +
                ", tar='" + tar + '\'' +
                ", capital='" + capital + '\'' +
                ", ind='" + ind + '\'' +
                '}';
    }
}
