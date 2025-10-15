package com.bbva.kusu.dto.mapper;

import com.bbva.kusu.dto.users.beans.Channel;
import com.bbva.kusu.dto.users.entity.CuserProfChanMgmtEntity;
import com.bbva.kusu.dto.users.entity.CustUserProfChannelEntity;
import com.bbva.kusu.dto.users.types.EnumStatusChannel;

import java.sql.Timestamp;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;


public class CustUserProfChannelMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustUserProfChannelMapper.class);


	public CustUserProfChannelEntity setCustUserProfChannel(Map<String, String> uuids, String auditUser, String aap, String channelId) {
		LOGGER.info(aap);
		return setCustUserProfChannel(uuids, auditUser, channelId);
	}

	public CustUserProfChannelEntity setCustUserProfChannel(Map<String, String> uuids, String auditUser, String channelId) {
		CustUserProfChannelEntity custUserProfChannelEntity = new CustUserProfChannelEntity();
		custUserProfChannelEntity.setGUserAccountId(uuids.get("uuidAccount"));
		custUserProfChannelEntity.setGUserMgmtChannelId(channelId);
		custUserProfChannelEntity.setGProfileChannelStatusType("AC");
		custUserProfChannelEntity.setGfUserChanFirstAccessDate(new Timestamp(System.currentTimeMillis()));
		custUserProfChannelEntity.setGfLastAccessChannelDate(new Timestamp(System.currentTimeMillis()));
		custUserProfChannelEntity.setGfUserAuditId(auditUser);
		custUserProfChannelEntity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		custUserProfChannelEntity.setGfPrevLastAccessChanDate(new Timestamp(System.currentTimeMillis()));
		return custUserProfChannelEntity;
	}

	public Channel setChannel(CustUserProfChannelEntity custUserProfChannelEntity) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Channel channel = new Channel();
		String status = EnumStatusChannel.getByCodigo(custUserProfChannelEntity.getGProfileChannelStatusType()).name();
		channel.setId(custUserProfChannelEntity.getGUserMgmtChannelId());
		channel.setIsBlocked(EnumStatusChannel.INACTIVE.name().equals(status) ? "Y" : "N");
		channel.setDescription("");
		channel.setStatusMode("LIVE");
		channel.setHasApplications(custUserProfChannelEntity.getgUsrProfCustmChanIndType());
		channel.setLastAccessDate(dateFormat.format(custUserProfChannelEntity.getGfLastAccessChannelDate()));
		channel.setLastLoginDate(custUserProfChannelEntity.getGfPrevLastAccessChanDate() != null ? dateFormat.format(custUserProfChannelEntity.getGfPrevLastAccessChanDate()) : null);
		return channel;
	}
	
	//T_KUSU_CUST_USER_PROF_CHANNEL
	public static CustUserProfChannelEntity channelMapperFromMgmt(CuserProfChanMgmtEntity channel, String auditUser) {
		CustUserProfChannelEntity entity = new CustUserProfChannelEntity();
		entity.setGUserAccountId(channel.getGUserAccountId());
		entity.setGUserMgmtChannelId(channel.getgUserMgmtChannelId());
		entity.setGProfileChannelStatusType(channel.getGProfileChannelStatusType());
		entity.setGfUserChanFirstAccessDate(channel.getGfUserChanFirstAccessDate());
		entity.setGfLastAccessChannelDate(channel.getGfLastAccessChannelDate());
		entity.setGfUserLoginIpId(channel.getGfUserLoginIpId());
		entity.setGfPrevLastAccessChanDate(channel.getGfPrevLastAccessChanDate());
		entity.setgUsrProfCustmChanIndType(channel.getgUsrProfCustmChanIndType());
		entity.setGfUserAuditId(auditUser);
		entity.setGfAuditDate(new Timestamp(System.currentTimeMillis()));
		entity.setgOfflineDeleteIndType(channel.getgOfflineDeleteIndType());
		return entity;
	}
	
}
