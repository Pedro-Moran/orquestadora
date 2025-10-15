package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.List;

public class UserProfileStatusPagination implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserProfileStatusEntity userProfileStatusEntity;

	private List<UserProfileStatusEntity> userProfileStatusList;

	public UserProfileStatusEntity getUserProfileStatusEntity() {
		return this.userProfileStatusEntity;
	}

	public void setUserProfileStatusEntity(UserProfileStatusEntity userProfileStatusEntity) {
		this.userProfileStatusEntity = userProfileStatusEntity;
	}

	public List<UserProfileStatusEntity> getUserProfileStatusList() {
		return this.userProfileStatusList;
	}

	public void setUserProfileStatusList(List<UserProfileStatusEntity> userProfileStatusList) {
		this.userProfileStatusList = userProfileStatusList;
	}

	@Override
	public String toString() {
		return "UserProfileStatusPagination [userProfileStatusEntity=" + userProfileStatusEntity + ", userProfileStatusList=" + userProfileStatusList
				+ "]";
	}
}
