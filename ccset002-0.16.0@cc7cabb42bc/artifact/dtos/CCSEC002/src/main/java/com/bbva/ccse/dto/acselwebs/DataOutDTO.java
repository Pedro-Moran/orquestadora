package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataOutDTO implements Serializable {

    private static final long serialVersionUID = 4497920086084527585L;
    private List<PolicyDTO> policy;
    private PaginationDTO pagination;

    public DataOutDTO() {
        this.policy = new ArrayList<>();
    }

    public List<PolicyDTO> getPolicy() {
        return policy;
    }

    public void setPolicy(List<PolicyDTO> policy) {
        this.policy = policy;
    }

    public PaginationDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDTO pagination) {
        this.pagination = pagination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataOutDTO that = (DataOutDTO) o;
        return Objects.equals(policy, that.policy) && Objects.equals(pagination, that.pagination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policy, pagination);
    }

    @Override
    public String toString() {
        return "DataOutDTO{" +
                "policy=" + policy +
                ", pagination=" + pagination +
                '}';
    }
}

