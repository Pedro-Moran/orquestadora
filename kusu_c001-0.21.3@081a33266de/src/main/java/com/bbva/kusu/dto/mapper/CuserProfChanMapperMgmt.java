package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.beans.Channel;
import com.bbva.kusu.dto.users.entity.CuserProfChanMgmtEntity;
import com.bbva.kusu.dto.users.types.EnumStatusChannel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

public class CuserProfChanMapperMgmt {
	public CuserProfChanMgmtEntity setCustUserProfChannel(Map<String, String> uuids, String auditUser, String channelId, String recordUpdateType) {
		CuserProfChanMgmtEntity custUserProfChannelEntity = new CuserProfChanMgmtEntity();
		custUserProfChannelEntity.setGRecordUpdateType(recordUpdateType);
		custUserProfChannelEntity.setGUserAccountId(uuids.get("uuidAccount"));
		custUserProfChannelEntity.setgUserMgmtChannelId(channelId);
		custUserProfChannelEntity.setGProfileChannelStatusType("AC");
		custUserProfChannelEntity.setGfUserChanFirstAccessDate(new Timestamp(System.currentTimeMillis()));
		custUserProfChannelEntity.setGfLastAccessChannelDate(new Timestamp(System.currentTimeMillis()));
		custUserProfChannelEntity.setGfUserAuditId(auditUser);
		custUserProfChannelEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		custUserProfChannelEntity.setGfPrevLastAccessChanDate(new Timestamp(System.currentTimeMillis()));
		return custUserProfChannelEntity;
	}

	public Channel setChannel(CuserProfChanMgmtEntity custUserProfChannelEntity) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Channel channel = new Channel();
		String status = EnumStatusChannel.getByCodigo(custUserProfChannelEntity.getGProfileChannelStatusType()).name();
		channel.setId(custUserProfChannelEntity.getgUserMgmtChannelId());
		channel.setIsBlocked(status.equals(EnumStatusChannel.INACTIVE.name()) ? "Y" : "N");
		channel.setDescription("");
		channel.setStatusMode("PENDING");
		channel.setHasApplications(custUserProfChannelEntity.getgUsrProfCustmChanIndType());
		channel.setLastAccessDate(dateFormat.format(custUserProfChannelEntity.getGfLastAccessChannelDate()));
		channel.setLastLoginDate(custUserProfChannelEntity.getGfPrevLastAccessChanDate() != null ? dateFormat.format(custUserProfChannelEntity.getGfPrevLastAccessChanDate()) : null);
		return channel;
	}
}
