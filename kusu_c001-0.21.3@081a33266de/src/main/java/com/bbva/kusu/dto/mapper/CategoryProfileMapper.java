package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.entity.CategoryProfileEntity;
import java.sql.Timestamp;

public class CategoryProfileMapper {
  public CategoryProfileEntity setCategoryProfileEntity(String gCategoryProfileType, String gCategoryProfileName, String auditUser) {
    CategoryProfileEntity categoryProfileEntity = new CategoryProfileEntity();
    categoryProfileEntity.setgCategoryProfileType(gCategoryProfileType);
    categoryProfileEntity.setgCategoryProfileName(gCategoryProfileName);
    categoryProfileEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    categoryProfileEntity.setGfUserAuditId(auditUser);
    return categoryProfileEntity;
  }
}
