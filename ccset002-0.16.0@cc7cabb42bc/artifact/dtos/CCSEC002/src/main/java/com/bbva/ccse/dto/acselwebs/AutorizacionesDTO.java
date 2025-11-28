package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class AutorizacionesDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String nivel;
    private String autorizacion;
    private String motivo;
    private String faut;
    private String usuario;
    private String causal;
    private String descripcion;
    private String estado;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFaut() {
        return faut;
    }

    public void setFaut(String faut) {
        this.faut = faut;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCausal() {
        return causal;
    }

    public void setCausal(String causal) {
        this.causal = causal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        AutorizacionesDTO that = (AutorizacionesDTO) o;
        return Objects.equals(nivel, that.nivel) && Objects.equals(autorizacion, that.autorizacion) && Objects.equals(motivo, that.motivo) && Objects.equals(faut, that.faut) && Objects.equals(usuario, that.usuario) && Objects.equals(causal, that.causal) && Objects.equals(descripcion, that.descripcion) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nivel, autorizacion, motivo, faut, usuario, causal, descripcion, estado);
    }

    @Override
    public String toString() {
        return "AutorizacionesDTO{" +
                "nivel='" + nivel + '\'' +
                ", autorizacion='" + autorizacion + '\'' +
                ", motivo='" + motivo + '\'' +
                ", faut='" + faut + '\'' +
                ", usuario='" + usuario + '\'' +
                ", causal='" + causal + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
