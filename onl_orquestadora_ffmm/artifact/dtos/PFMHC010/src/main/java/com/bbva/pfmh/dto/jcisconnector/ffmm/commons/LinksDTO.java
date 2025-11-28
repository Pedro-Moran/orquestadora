package com.bbva.pfmh.dto.jcisconnector.ffmm.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class LinksDTO implements Serializable {

    @JsonProperty("first")
    private String first;

    @JsonProperty("last")
    private String last;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("next")
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
