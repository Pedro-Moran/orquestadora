package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

import com.bbva.kusu.dto.users.entity.commons.CategoryCommons;

public class CategoryProfMapEntity extends CategoryCommons implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gCountryId;

	private String gfCategoryProfileType;

	public String getgCountryId() {
		return this.gCountryId;
	}

	public void setgCountryId(String gCountryId) {
		this.gCountryId = gCountryId;
	}

	public String getGfCategoryProfileType() {
		return this.gfCategoryProfileType;
	}

	public void setGfCategoryProfileType(String gfCategoryProfileType) {
		this.gfCategoryProfileType = gfCategoryProfileType;
	}

	@Override
	public String toString() {
		return "CategoryProfMapEntity [gCountryId=" + gCountryId + ", gfCategoryProfileType=" + gfCategoryProfileType
				+ ", toString()=" + super.toString() + "]";
	}

}
