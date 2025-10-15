package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

public class Multitax implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Multitax [id=" + id + "]";
	}

}
