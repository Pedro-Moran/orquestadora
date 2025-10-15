package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UserProfileAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "g_user_account_id")
	private String userAccountId;
    
	@SerializedName(value = "basic_profile_data_str")
	private BasicProfileAuditEntity basicProfileData;
    
	@SerializedName(value = "user_profile_channels_arc")
	private List<UserProfChannelAuditEntity> userProfChannels;
    
	@SerializedName(value = "user_profile_devices_arc")
	private List<UserProfDeviceAuditEntity> userProfileDevices;
    
	@SerializedName(value = "user_profile_roles_arc")
	private List<UserProfRoleAuditEntity> userProfileRoles;
    
	@SerializedName(value = "user_profile_custom_cont_arc")
	private List<UserProfContractAuditEntity> userProfileContracts;

	@SerializedName(value = "user_profile_app_arc")
	private List<UserProfAppAuditEntity> userProfApps;
	
	@SerializedName(value = "user_profile_auth_atrb_arc")
	private List<UserProfAuthAtrb> userProfAuthAtrb;
	
	public String getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	public BasicProfileAuditEntity getBasicProfileData() {
		return basicProfileData;
	}

	public void setBasicProfileData(BasicProfileAuditEntity basicProfileData) {
		this.basicProfileData = basicProfileData;
	}

	public List<UserProfChannelAuditEntity> getUserProfChannels() {
		return userProfChannels;
	}

	public void setUserProfChannels(List<UserProfChannelAuditEntity> userProfChannels) {
		this.userProfChannels = userProfChannels;
	}

	public List<UserProfDeviceAuditEntity> getUserProfileDevices() {
		return userProfileDevices;
	}

	public void setUserProfileDevices(List<UserProfDeviceAuditEntity> userProfileDevices) {
		this.userProfileDevices = userProfileDevices;
	}

	public List<UserProfRoleAuditEntity> getUserProfileRoles() {
		return userProfileRoles;
	}

	public void setUserProfileRoles(List<UserProfRoleAuditEntity> userProfileRoles) {
		this.userProfileRoles = userProfileRoles;
	}

	public List<UserProfContractAuditEntity> getUserProfileContracts() {
		return userProfileContracts;
	}

	public void setUserProfileContracts(List<UserProfContractAuditEntity> userProfileContracts) {
		this.userProfileContracts = userProfileContracts;
	}

	public List<UserProfAppAuditEntity> getUserProfApps() {
		return userProfApps;
	}

	public void setUserProfApps(List<UserProfAppAuditEntity> userProfApps) {
		this.userProfApps = userProfApps;
	}

	public List<UserProfAuthAtrb> getUserProfAuthAtrb() {
		return userProfAuthAtrb;
	}

	public void setUserProfAuthAtrb(List<UserProfAuthAtrb> userProfAuthAtrb) {
		this.userProfAuthAtrb = userProfAuthAtrb;
	}

	@Override
	public String toString() {
		return "UserProfileAuditEntity [userAccountId=" + userAccountId + ", basicProfileData=" + basicProfileData
				+ ", userProfChannels=" + userProfChannels + ", userProfileDevices=" + userProfileDevices
				+ ", userProfileRoles=" + userProfileRoles + ", userProfileContracts=" + userProfileContracts
				+ ", userProfApps=" + userProfApps + ", userProfAuthAtrb=" + userProfAuthAtrb + "]";
	}

}
