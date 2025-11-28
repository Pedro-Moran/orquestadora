package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class RecibosDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String recibo;
    private String tipo;
    private String fefecto;
    private String fvencimiento;
    private String financiado;
    private String coaseguro;
    private String importe;
    private String saldo;
    private String estado;

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFefecto() {
        return fefecto;
    }

    public void setFefecto(String fefecto) {
        this.fefecto = fefecto;
    }

    public String getFvencimiento() {
        return fvencimiento;
    }

    public void setFvencimiento(String fvencimiento) {
        this.fvencimiento = fvencimiento;
    }

    public String getFinanciado() {
        return financiado;
    }

    public void setFinanciado(String financiado) {
        this.financiado = financiado;
    }

    public String getCoaseguro() {
        return coaseguro;
    }

    public void setCoaseguro(String coaseguro) {
        this.coaseguro = coaseguro;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecibosDTO that = (RecibosDTO) o;
        return Objects.equals(recibo, that.recibo) && Objects.equals(tipo, that.tipo) && Objects.equals(fefecto, that.fefecto) && Objects.equals(fvencimiento, that.fvencimiento) && Objects.equals(financiado, that.financiado) && Objects.equals(coaseguro, that.coaseguro) && Objects.equals(importe, that.importe) && Objects.equals(saldo, that.saldo) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recibo, tipo, fefecto, fvencimiento, financiado, coaseguro, importe, saldo, estado);
    }

    @Override
    public String toString() {
        return "RecibosDTO{" +
                "recibo='" + recibo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fefecto='" + fefecto + '\'' +
                ", fvencimiento='" + fvencimiento + '\'' +
                ", financiado='" + financiado + '\'' +
                ", coaseguro='" + coaseguro + '\'' +
                ", importe='" + importe + '\'' +
                ", saldo='" + saldo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
