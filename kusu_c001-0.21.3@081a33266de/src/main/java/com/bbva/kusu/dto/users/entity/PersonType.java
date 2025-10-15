package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

public class PersonType implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "personType [id=" + this.id + "]";
	}
}
