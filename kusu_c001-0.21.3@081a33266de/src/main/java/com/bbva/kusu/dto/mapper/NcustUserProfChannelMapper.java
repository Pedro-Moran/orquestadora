package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.beans.Channel;
import com.bbva.kusu.dto.users.entity.NcustUserProfChannelEntity;
import com.bbva.kusu.dto.users.types.EnumChannelId;
import com.bbva.kusu.dto.users.types.EnumStatusChannel;
import java.sql.Timestamp;
import java.util.Map;
import java.text.SimpleDateFormat;

public class NcustUserProfChannelMapper {
  public NcustUserProfChannelEntity setNcustUserProfChannel(Map<String, String> uuids, String auditUser, String channelId) {
    NcustUserProfChannelEntity ncustUserProfChannelEntity = new NcustUserProfChannelEntity();
    ncustUserProfChannelEntity.setGUserAccountId(uuids.get("uuidAccount"));
    ncustUserProfChannelEntity.setgUserMgmtChannelId(channelId);
    ncustUserProfChannelEntity.setGProfileChannelStatusType(EnumStatusChannel.ACTIVE.getCodigo());
    ncustUserProfChannelEntity.setGfUserChanFirstAccessDate(new Timestamp(System.currentTimeMillis()));
    ncustUserProfChannelEntity.setGfLastAccessChannelDate(new Timestamp(System.currentTimeMillis()));
    ncustUserProfChannelEntity.setGfUserAuditId(auditUser);
    ncustUserProfChannelEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
    return ncustUserProfChannelEntity;
  }
  
  public Channel setChannel(NcustUserProfChannelEntity ncustUserProfChannelEntity) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Channel channel = new Channel();
    String status = EnumStatusChannel.getByCodigo(ncustUserProfChannelEntity.getGProfileChannelStatusType()).name();
    channel.setId(EnumChannelId.getByCodigo(ncustUserProfChannelEntity.getgUserMgmtChannelId()).name());
    channel.setIsBlocked(EnumStatusChannel.BLOCKED.name().equals(status) ? "Y" : "N");
	channel.setDescription("");
	channel.setStatusMode("LIVE");
	channel.setLastAccessDate(dateFormat.format(ncustUserProfChannelEntity.getGfLastAccessChannelDate()));
    return channel;
  }
  
}
