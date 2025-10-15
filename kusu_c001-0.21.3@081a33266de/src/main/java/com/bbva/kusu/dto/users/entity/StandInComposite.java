package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

public class StandInComposite implements Serializable {
  private static final long serialVersionUID = 1L;

  private String localUserProfileId;
  private String globalUserProfileId;
  private String aapOriginType;
  private CustUserProfileEntity custUserProfileEntity;
  private UserMgmtChannelMapEntity userMgmtChannelMapEntity;


  public UserMgmtChannelMapEntity getUserMgmtChannelMapEntity() {
    return userMgmtChannelMapEntity;
  }

  public void setUserMgmtChannelMapEntity(
      UserMgmtChannelMapEntity userMgmtChannelMapEntity) {
    this.userMgmtChannelMapEntity = userMgmtChannelMapEntity;
  }
  public String getLocalUserProfileId() {
    return localUserProfileId;
  }

  public void setLocalUserProfileId(String localUserProfileId) {
    this.localUserProfileId = localUserProfileId;
  }

  public String getGlobalUserProfileId() {
    return globalUserProfileId;
  }

  public void setGlobalUserProfileId(String globalUserProfileId) {
    this.globalUserProfileId = globalUserProfileId;
  }

  public String getAapOriginType() {
    return aapOriginType;
  }

  public void setAapOriginType(String aapOriginType) {
    this.aapOriginType = aapOriginType;
  }

  public CustUserProfileEntity getCustUserProfileEntity() {
    return custUserProfileEntity;
  }

  public void setCustUserProfileEntity(
      CustUserProfileEntity custUserProfileEntity) {
    this.custUserProfileEntity = custUserProfileEntity;
  }

  @Override
  public String toString() {
    return "StandInComposite{" +
        "localUserProfileId='" + localUserProfileId + '\'' +
        ", globalUserProfileId='" + globalUserProfileId + '\'' +
        ", aapOriginType='" + aapOriginType + '\'' +
        ", custUserProfileEntity=" + custUserProfileEntity +
        ", userMgmtChannelMapEntity=" + userMgmtChannelMapEntity +
        '}';
  }
}
