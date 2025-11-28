package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class RetribucionesDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String rol;
    private String nit;
    private String nombre;
    private String retribucion;
    private String desaut;
    private String causacion;
    private String finicio;
    private String flimite;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRetribucion() {
        return retribucion;
    }

    public void setRetribucion(String retribucion) {
        this.retribucion = retribucion;
    }

    public String getDesaut() {
        return desaut;
    }

    public void setDesaut(String desaut) {
        this.desaut = desaut;
    }

    public String getCausacion() {
        return causacion;
    }

    public void setCausacion(String causacion) {
        this.causacion = causacion;
    }

    public String getFinicio() {
        return finicio;
    }

    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }

    public String getFlimite() {
        return flimite;
    }

    public void setFlimite(String flimite) {
        this.flimite = flimite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetribucionesDTO that = (RetribucionesDTO) o;
        return Objects.equals(rol, that.rol) && Objects.equals(nit, that.nit) && Objects.equals(nombre, that.nombre) && Objects.equals(retribucion, that.retribucion) && Objects.equals(desaut, that.desaut) && Objects.equals(causacion, that.causacion) && Objects.equals(finicio, that.finicio) && Objects.equals(flimite, that.flimite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol, nit, nombre, retribucion, desaut, causacion, finicio, flimite);
    }

    @Override
    public String toString() {
        return "RetribucionesDTO{" +
                "rol='" + rol + '\'' +
                ", nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", retribucion='" + retribucion + '\'' +
                ", desaut='" + desaut + '\'' +
                ", causacion='" + causacion + '\'' +
                ", finicio='" + finicio + '\'' +
                ", flimite='" + flimite + '\'' +
                '}';
    }
}
