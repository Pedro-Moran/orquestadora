package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class PaginationDTO implements Serializable {
    private static final long serialVersionUID = 8268731132101006705L;
    @JsonProperty("DTOLinks")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private LinksDTO dtoLinks = new LinksDTO();
    private Integer page;
    private Integer totalPages;
    private Integer totalElements;
    private Integer pageSize;

    @JsonProperty("DTOLinks")
    public LinksDTO getDtoLinks(){
        return dtoLinks;
    }

    @JsonProperty("DTOLinks")
    public void setDtoLinks(LinksDTO dtoLinks){
        this.dtoLinks = (dtoLinks == null) ? new LinksDTO() : dtoLinks;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "DTOPagination{" +
                "DTOLinks=" + dtoLinks +
                ", page=" + page +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", pageSize=" + pageSize +
                '}';
    }
}