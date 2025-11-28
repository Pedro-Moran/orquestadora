package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class CertificadosDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String fivig;
    private String ffvig;
    private String cartera;
    private String gestor;
    private String duracion;
    private String modpago;
    private String periodicidad;
    private String coaseguro;
    private String crecimiento;
    private String utilidad;
    private String administrativos;
    private String comision;
    private String capitalprincipal;

    public String getFivig() {
        return fivig;
    }

    public void setFivig(String fivig) {
        this.fivig = fivig;
    }

    public String getFfvig() {
        return ffvig;
    }

    public void setFfvig(String ffvig) {
        this.ffvig = ffvig;
    }

    public String getCartera() {
        return cartera;
    }

    public void setCartera(String cartera) {
        this.cartera = cartera;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getModpago() {
        return modpago;
    }

    public void setModpago(String modpago) {
        this.modpago = modpago;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getCoaseguro() {
        return coaseguro;
    }

    public void setCoaseguro(String coaseguro) {
        this.coaseguro = coaseguro;
    }

    public String getCrecimiento() {
        return crecimiento;
    }

    public void setCrecimiento(String crecimiento) {
        this.crecimiento = crecimiento;
    }

    public String getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(String utilidad) {
        this.utilidad = utilidad;
    }

    public String getAdministrativos() {
        return administrativos;
    }

    public void setAdministrativos(String administrativos) {
        this.administrativos = administrativos;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getCapitalprincipal() {
        return capitalprincipal;
    }

    public void setCapitalprincipal(String capitalprincipal) {
        this.capitalprincipal = capitalprincipal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificadosDTO that = (CertificadosDTO) o;
        return Objects.equals(fivig, that.fivig) && Objects.equals(ffvig, that.ffvig) && Objects.equals(cartera, that.cartera) && Objects.equals(gestor, that.gestor) && Objects.equals(duracion, that.duracion) && Objects.equals(modpago, that.modpago) && Objects.equals(periodicidad, that.periodicidad) && Objects.equals(coaseguro, that.coaseguro) && Objects.equals(crecimiento, that.crecimiento) && Objects.equals(utilidad, that.utilidad) && Objects.equals(administrativos, that.administrativos) && Objects.equals(comision, that.comision) && Objects.equals(capitalprincipal, that.capitalprincipal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fivig, ffvig, cartera, gestor, duracion, modpago, periodicidad, coaseguro, crecimiento, utilidad, administrativos, comision, capitalprincipal);
    }

    @Override
    public String toString() {
        return "CertificadosDTO{" +
                "fivig='" + fivig + '\'' +
                ", ffvig='" + ffvig + '\'' +
                ", cartera='" + cartera + '\'' +
                ", gestor='" + gestor + '\'' +
                ", duracion='" + duracion + '\'' +
                ", modpago='" + modpago + '\'' +
                ", periodicidad='" + periodicidad + '\'' +
                ", coaseguro='" + coaseguro + '\'' +
                ", crecimiento='" + crecimiento + '\'' +
                ", utilidad='" + utilidad + '\'' +
                ", administrativos='" + administrativos + '\'' +
                ", comision='" + comision + '\'' +
                ", capitalprincipal='" + capitalprincipal + '\'' +
                '}';
    }
}
