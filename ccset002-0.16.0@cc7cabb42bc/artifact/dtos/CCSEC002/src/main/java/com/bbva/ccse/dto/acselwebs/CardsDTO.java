package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class CardsDTO implements Serializable {

    private static final long serialVersionUID = -7050539200758753879L;
    private String tipo;
    private String numero;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardsDTO cardsDTO = (CardsDTO) o;
        return Objects.equals(tipo, cardsDTO.tipo) && Objects.equals(numero, cardsDTO.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, numero);
    }

    @Override
    public String toString() {
        return "CardsDTO{" +
                "tipo='" + tipo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
