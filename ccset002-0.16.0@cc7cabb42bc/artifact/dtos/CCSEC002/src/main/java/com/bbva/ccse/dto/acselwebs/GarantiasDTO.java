package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class GarantiasDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String ramo;
    private String amparo;
    private String emision;
    private String fefecto;
    private String capital;
    private String indicevariable;
    private String primaanualunica;
    private String sobreprima;
    private String extraprima;

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getAmparo() {
        return amparo;
    }

    public void setAmparo(String amparo) {
        this.amparo = amparo;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getFefecto() {
        return fefecto;
    }

    public void setFefecto(String fefecto) {
        this.fefecto = fefecto;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIndicevariable() {
        return indicevariable;
    }

    public void setIndicevariable(String indicevariable) {
        this.indicevariable = indicevariable;
    }

    public String getPrimaanualunica() {
        return primaanualunica;
    }

    public void setPrimaanualunica(String primaanualunica) {
        this.primaanualunica = primaanualunica;
    }

    public String getSobreprima() {
        return sobreprima;
    }

    public void setSobreprima(String sobreprima) {
        this.sobreprima = sobreprima;
    }

    public String getExtraprima() {
        return extraprima;
    }

    public void setExtraprima(String extraprima) {
        this.extraprima = extraprima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GarantiasDTO that = (GarantiasDTO) o;
        return Objects.equals(ramo, that.ramo) && Objects.equals(amparo, that.amparo) && Objects.equals(emision, that.emision) && Objects.equals(fefecto, that.fefecto) && Objects.equals(capital, that.capital) && Objects.equals(indicevariable, that.indicevariable) && Objects.equals(primaanualunica, that.primaanualunica) && Objects.equals(sobreprima, that.sobreprima) && Objects.equals(extraprima, that.extraprima);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ramo, amparo, emision, fefecto, capital, indicevariable, primaanualunica, sobreprima, extraprima);
    }

    @Override
    public String toString() {
        return "GarantiasDTO{" +
                "ramo='" + ramo + '\'' +
                ", amparo='" + amparo + '\'' +
                ", emision='" + emision + '\'' +
                ", fefecto='" + fefecto + '\'' +
                ", capital='" + capital + '\'' +
                ", indicevariable='" + indicevariable + '\'' +
                ", primaanualunica='" + primaanualunica + '\'' +
                ", sobreprima='" + sobreprima + '\'' +
                ", extraprima='" + extraprima + '\'' +
                '}';
    }
}
