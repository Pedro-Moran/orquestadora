package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CategoryCommons;

public class CategoryProfileEntity extends CategoryCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gCategoryProfileName;

	public String getgCategoryProfileName() {
		return this.gCategoryProfileName;
	}

	public void setgCategoryProfileName(String gCategoryProfileName) {
		this.gCategoryProfileName = gCategoryProfileName;
	}

	@Override
	public String toString() {
		return "CategoryProfileEntity [gCategoryProfileName=" + gCategoryProfileName + ", toString()="
				+ super.toString() + "]";
	}

}
