package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import java.io.Serializable;
import java.util.Objects;

public class LinksDTO implements Serializable {
    private static final long serialVersionUID = -4216227542464304862L;
    private String first;

    private String last;

    private String previous;

    private String next;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinksDTO linksDTO = (LinksDTO) o;
        return Objects.equals(first, linksDTO.first)
                && Objects.equals(last, linksDTO.last)
                && Objects.equals(previous, linksDTO.previous)
                && Objects.equals(next, linksDTO.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, previous, next);
    }

    @Override
    public String toString() {
        return "LinksDTO{" +
                "first='" + this.first + '\'' +
                ", last='" + this.last + '\'' +
                ", previous='" + this.previous + '\'' +
                ", next='" + this.next + '\'' +
                '}';
    }
}