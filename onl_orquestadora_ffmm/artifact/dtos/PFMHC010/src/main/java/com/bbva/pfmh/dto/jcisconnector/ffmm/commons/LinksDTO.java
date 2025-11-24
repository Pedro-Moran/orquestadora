package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import java.io.Serializable;

public class LinksDTO implements Serializable {

    private static final long serialVersionUID = 4845434800549142797L;

    private  String first;
    private  String last;
    private  String previous;
    private  String next;

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
        return java.util.Objects.equals(first, linksDTO.first)
                && java.util.Objects.equals(last, linksDTO.last)
                && java.util.Objects.equals(previous, linksDTO.previous)
                && java.util.Objects.equals(next, linksDTO.next);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(first, last, previous, next);
    }

    @Override
    public String toString() {
        return "DTOLinks{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", previous='" + previous + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}
