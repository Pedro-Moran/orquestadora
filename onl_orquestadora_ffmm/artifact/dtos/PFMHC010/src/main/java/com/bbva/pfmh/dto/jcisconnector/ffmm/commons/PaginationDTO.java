package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import java.io.Serializable;

public class PaginationDTO implements Serializable {
    private static final long serialVersionUID = 8268731132101006705L;
    @SuppressWarnings("java:S116")
    private LinksDTO DTOLinks;
    private Integer page;
    private Integer totalPages;
    private Integer totalElements;
    private Integer pageSize;

    public LinksDTO getDTOLinks() {
        return DTOLinks;
    }

    public void setDTOLinks(LinksDTO dtoLinks) {
        this.DTOLinks = dtoLinks;
    }

    public LinksDTO getLinks() {
        if (DTOLinks == null) {
            return null;
        }

        LinksDTO copy = new LinksDTO();
        copy.setFirst(DTOLinks.getFirst());
        copy.setLast(DTOLinks.getLast());
        copy.setPrevious(DTOLinks.getPrevious());
        copy.setNext(DTOLinks.getNext());
        return copy;
    }

    public void setLinks(LinksDTO links) {
        if (links == null) {
            this.DTOLinks = null;
            return;
        }

        LinksDTO copy = new LinksDTO();
        copy.setFirst(links.getFirst());
        copy.setLast(links.getLast());
        copy.setPrevious(links.getPrevious());
        copy.setNext(links.getNext());
        this.DTOLinks = copy;
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
                "DTOLinks=" + DTOLinks +
                ", page=" + page +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", pageSize=" + pageSize +
                '}';
    }
}