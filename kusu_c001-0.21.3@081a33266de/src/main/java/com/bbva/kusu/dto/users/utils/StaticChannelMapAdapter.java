package com.bbva.kusu.dto.users.utils;

import com.bbva.kusu.dto.users.entity.UserMgmtChannelMapEntity;
import com.bbva.kusu.dto.users.util.StaticChannelMap;

public class StaticChannelMapAdapter {

	/** Converts to {@link UserMgmtChannelMapEntity} the {@link StaticChannelMap} values */
	public static UserMgmtChannelMapEntity staticChannelMapToUserMgmtChannelMapEntity(StaticChannelMap staticChannelMap) {

		UserMgmtChannelMapEntity userMgmtChannelMapEntity = null;

		if (null != staticChannelMap) {
			userMgmtChannelMapEntity = new UserMgmtChannelMapEntity();
			userMgmtChannelMapEntity.setgAapChannelType(staticChannelMap.getChannelType());
			userMgmtChannelMapEntity.setgChannelOperModeIndType(staticChannelMap.getChannelOperModeIndType());
			userMgmtChannelMapEntity.setGCountryId(staticChannelMap.getCountry());
			userMgmtChannelMapEntity.setGfAuditDate(null);
			userMgmtChannelMapEntity.setGfChannelId(staticChannelMap.getAap());
			userMgmtChannelMapEntity.setGfUserAuditId(null);
			userMgmtChannelMapEntity.setGUserMgmtChannelId(staticChannelMap.getChannelId());
			userMgmtChannelMapEntity.setgUserMgmtMasterIndType(staticChannelMap.getMasterIndType());
		}

		return userMgmtChannelMapEntity;

	}

	private StaticChannelMapAdapter() {
		// default constructor
	}
}