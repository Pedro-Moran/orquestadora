package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.List;

public class RelatedPerson implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private PersonType personType;
	private RoleType roleType;
	private List<Multitax> multitax;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PersonType getPersonType() {
		return this.personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public RoleType getRoleType() {
		return this.roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public List<Multitax> getMultitax() {
		return multitax;
	}

	public void setMultitax(List<Multitax> multitax) {
		this.multitax = multitax;
	}

	@Override
	public String toString() {
		return "RelatedPerson [id=" + id + ", personType=" + personType + ", roleType=" + roleType + ", multitax=" + multitax + "]";
	}

}
