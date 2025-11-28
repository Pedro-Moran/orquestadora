package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class ClausulasDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String nivel;
    private String codigo;
    private String tipo;
    private String clausula;
    private String anexo;
    private String fefecto;
    private String estado;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClausula() {
        return clausula;
    }

    public void setClausula(String clausula) {
        this.clausula = clausula;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getFefecto() {
        return fefecto;
    }

    public void setFefecto(String fefecto) {
        this.fefecto = fefecto;
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
        ClausulasDTO that = (ClausulasDTO) o;
        return Objects.equals(nivel, that.nivel) && Objects.equals(codigo, that.codigo) && Objects.equals(tipo, that.tipo) && Objects.equals(clausula, that.clausula) && Objects.equals(anexo, that.anexo) && Objects.equals(fefecto, that.fefecto) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nivel, codigo, tipo, clausula, anexo, fefecto, estado);
    }

    @Override
    public String toString() {
        return "ClausulasDTO{" +
                "nivel='" + nivel + '\'' +
                ", codigo='" + codigo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", clausula='" + clausula + '\'' +
                ", anexo='" + anexo + '\'' +
                ", fefecto='" + fefecto + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
