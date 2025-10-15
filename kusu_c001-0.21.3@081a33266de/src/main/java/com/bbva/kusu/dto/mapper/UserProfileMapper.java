package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.entity.UserProfileEntity;
import java.sql.Timestamp;

public class UserProfileMapper {
  public UserProfileEntity setCategoryProfileEntity(String gCategoryProfileType, String gCategoryProfileName, String auditUser) {
    UserProfileEntity userProfileEntity = new UserProfileEntity();
    userProfileEntity.setGUserProfileId(gCategoryProfileType);
    userProfileEntity.setGUserProfileName(gCategoryProfileName);
    userProfileEntity.setGfUserAuditId(auditUser);
    userProfileEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    return userProfileEntity;
  }
}
