package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFund;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class OutputInvestmentFundsDTO implements Serializable {

    private static final long serialVersionUID = 4834085047780260103L;

    private List<InvestmentFund> data;
    private IntPaginationDTO dtoIntPagination;
    // Se expone como "DTOPagination" para alinearse con el parámetro de salida
    // del transaction, que ya publica el nodo aunque el DTO no lo tuviera.
    @JsonProperty("DTOPagination")
    private PaginationDTO dtoPagination;

    public List<InvestmentFund> getData() {
        return data;
    }

    public void setData(List<InvestmentFund> data) {
        this.data = data;
    }

    public IntPaginationDTO getDTOIntPagination() {
        return dtoIntPagination;
    }

    public void setDTOIntPagination(IntPaginationDTO dtoIntPagination) {
        this.dtoIntPagination = dtoIntPagination;
    }

    public PaginationDTO getDTOPagination() {
        return dtoPagination;
    }

    public void setDTOPagination(PaginationDTO dtoPagination) {
        this.dtoPagination = dtoPagination;
    }

    @Override
    public String toString() {
        return "DTOIntInvestmentFunds{" +
                "data=" + data +
                ", DTOIntPagination=" + dtoIntPagination +
                ", DTOPagination=" + dtoPagination +
                '}';
    }
}