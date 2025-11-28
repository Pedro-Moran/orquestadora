package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class BeneficiariosDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String cedula;
    private String nombre;
    private String parentesco;
    private String porcpart;
    private String asegurado;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getPorcpart() {
        return porcpart;
    }

    public void setPorcpart(String porcpart) {
        this.porcpart = porcpart;
    }

    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiariosDTO that = (BeneficiariosDTO) o;
        return Objects.equals(cedula, that.cedula) && Objects.equals(nombre, that.nombre) && Objects.equals(parentesco, that.parentesco) && Objects.equals(porcpart, that.porcpart) && Objects.equals(asegurado, that.asegurado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula, nombre, parentesco, porcpart, asegurado);
    }

    @Override
    public String toString() {
        return "BeneficiariosDTO{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", porcpart='" + porcpart + '\'' +
                ", asegurado='" + asegurado + '\'' +
                '}';
    }
}
