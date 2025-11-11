package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFund;

import java.io.Serializable;
import java.util.List;

public class OutputInvestmentFundsDTO implements Serializable {

    private static final long serialVersionUID = 4834085047780260103L;

    private List<InvestmentFund> data;
    private IntPaginationDTO dtoIntPagination;

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

    @Override
    public String toString() {
        return "DTOIntInvestmentFunds{" +
                "data=" + data +
                ", DTOIntPagination=" + dtoIntPagination +
                '}';
    }
}