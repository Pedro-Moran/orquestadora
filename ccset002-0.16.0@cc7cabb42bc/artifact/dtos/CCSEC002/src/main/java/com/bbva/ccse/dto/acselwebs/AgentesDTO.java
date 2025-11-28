package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class AgentesDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String nombre;
    private String participacion;
    private String comision;
    private String porcentajecomision;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParticipacion() {
        return participacion;
    }

    public void setParticipacion(String participacion) {
        this.participacion = participacion;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public String getPorcentajecomision() {
        return porcentajecomision;
    }

    public void setPorcentajecomision(String porcentajecomision) {
        this.porcentajecomision = porcentajecomision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgentesDTO that = (AgentesDTO) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(participacion, that.participacion) && Objects.equals(comision, that.comision) && Objects.equals(porcentajecomision, that.porcentajecomision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, participacion, comision, porcentajecomision);
    }

    @Override
    public String toString() {
        return "AgentesDTO{" +
                "nombre='" + nombre + '\'' +
                ", participacion='" + participacion + '\'' +
                ", comision='" + comision + '\'' +
                ", porcentajecomision='" + porcentajecomision + '\'' +
                '}';
    }
}
