package com.bbva.ccse.dto.acselwebs;

import java.io.Serializable;
import java.util.Objects;

public class PaginationDTO implements Serializable {


    private static final long serialVersionUID = 110092385528645489L;
    private LinksDTO links;
    private Long page;
    private Long totalPages;
    private Long totalElements;
    private Long pageSize;

    public LinksDTO getLinks() {
        return links;
    }

    public void setLinks(LinksDTO links) {
        this.links = links;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginationDTO that = (PaginationDTO) o;
        return Objects.equals(links, that.links) && Objects.equals(page, that.page) && Objects.equals(totalPages, that.totalPages) && Objects.equals(totalElements, that.totalElements) && Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, page, totalPages, totalElements, pageSize);
    }

    @Override
    public String toString() {
        return "PaginationDTO{" +
                "links=" + links +
                ", page=" + page +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", pageSize=" + pageSize +
                '}';
    }
}
