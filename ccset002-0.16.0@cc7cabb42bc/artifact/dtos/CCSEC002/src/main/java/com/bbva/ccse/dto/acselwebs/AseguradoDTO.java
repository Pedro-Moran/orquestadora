package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class AseguradoDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;

    private String cedula;
    private String nombre;
    private String direccion;
    private String edad;
    private String fecnac;
    private String parentesco;
    private String prima;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFecnac() {
        return fecnac;
    }

    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getPrima() {
        return prima;
    }

    public void setPrima(String prima) {
        this.prima = prima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AseguradoDTO that = (AseguradoDTO) o;
        return Objects.equals(cedula, that.cedula) && Objects.equals(nombre, that.nombre) && Objects.equals(direccion, that.direccion) && Objects.equals(edad, that.edad) && Objects.equals(fecnac, that.fecnac) && Objects.equals(parentesco, that.parentesco) && Objects.equals(prima, that.prima);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula, nombre, direccion, edad, fecnac, parentesco, prima);
    }

    @Override
    public String toString() {
        return "AseguradoDTO{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad='" + edad + '\'' +
                ", fecnac='" + fecnac + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", prima='" + prima + '\'' +
                '}';
    }
}
