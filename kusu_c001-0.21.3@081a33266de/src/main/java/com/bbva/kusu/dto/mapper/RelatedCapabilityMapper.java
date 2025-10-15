package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.beans.RelatedCapability;
import com.bbva.kusu.dto.users.entity.CapabilityEntity;
import com.bbva.kusu.dto.users.entity.RoleCapabilityEntity;
import java.sql.Timestamp;

public class RelatedCapabilityMapper {
  public CapabilityEntity setCapability(String description, String auditUser) {
    CapabilityEntity capabilityEntity = new CapabilityEntity();
    capabilityEntity.setGfUserCapabilityName(description);
    capabilityEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    capabilityEntity.setGfUserAuditId(auditUser);
    return capabilityEntity;
  }
  
  public static RelatedCapability mapFromRoleCapabilityEntity(RoleCapabilityEntity entity) {
    RelatedCapability res = new RelatedCapability();
    res.setId(entity.getGfUserCapabilityId());
    return res;
  }
}
