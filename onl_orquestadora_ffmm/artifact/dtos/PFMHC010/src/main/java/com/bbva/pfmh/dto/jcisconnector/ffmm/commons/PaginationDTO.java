package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import java.io.Serializable;

public class PaginationDTO implements Serializable {
    private static final long serialVersionUID = 8268731132101006705L;
    private LinksDTO dtoLinks;
    private Integer page;
    private Integer totalPages;
    private Integer totalElements;
    private Integer pageSize;

    public LinksDTO getDTOLinks() {
        return dtoLinks;
    }

    public void setDTOLinks(LinksDTO dtoLinks) {
        this.dtoLinks = dtoLinks;
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