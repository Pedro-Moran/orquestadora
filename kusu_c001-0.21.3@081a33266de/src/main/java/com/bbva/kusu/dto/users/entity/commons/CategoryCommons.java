package com.bbva.kusu.dto.users.entity.commons;

import java.io.Serializable;

public class CategoryCommons extends CategoryAndUserStatusCommons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gCategoryProfileType;

	public String getgCategoryProfileType() {
		return gCategoryProfileType;
	}

	public void setgCategoryProfileType(String gCategoryProfileType) {
		this.gCategoryProfileType = gCategoryProfileType;
	}

	@Override
	public String toString() {
		return "CategoryCommons [super.toString()=" + super.toString() + ", gCategoryProfileType=" + gCategoryProfileType + "]";
	}

}
