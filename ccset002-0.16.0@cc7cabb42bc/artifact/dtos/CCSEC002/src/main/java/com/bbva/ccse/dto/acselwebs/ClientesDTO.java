package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class ClientesDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String cedula;
    private String nombre;
    private String direccion;
    private String cuenta;
    private String tipocuenta;

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

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientesDTO that = (ClientesDTO) o;
        return Objects.equals(cedula, that.cedula) && Objects.equals(nombre, that.nombre) && Objects.equals(direccion, that.direccion) && Objects.equals(cuenta, that.cuenta) && Objects.equals(tipocuenta, that.tipocuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula, nombre, direccion, cuenta, tipocuenta);
    }

    @Override
    public String toString() {
        return "ClientesDTO{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cuenta='" + cuenta + '\'' +
                ", tipocuenta='" + tipocuenta + '\'' +
                '}';
    }
}
