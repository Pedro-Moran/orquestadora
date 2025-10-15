package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "g_user_id")
    private String userId;
	
	@SerializedName(value = "gf_user_change_id")
	private String userChangeId;
	
	@SerializedName(value = "gf_user_change_date")
	private String userChangeDate;
	
	@SerializedName(value = "user_mgmt_operation_arc")
	private List<UserMgmtOperationAuditEntity> userMgmtOperation;
	
	@SerializedName(value = "basic_user_data_str")
	private UserDataAuditEntity userData;
	
	@SerializedName(value = "user_profiles_arc")
	private List<UserProfileAuditEntity> userProfiles;
	
	@SerializedName(value = "devices")
	private List<DeviceAuditEntity> devices;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserChangeId() {
		return userChangeId;
	}

	public void setUserChangeId(String userChangeId) {
		this.userChangeId = userChangeId;
	}

	public String getUserChangeDate() {
		return userChangeDate;
	}

	public void setUserChangeDate(String userChangeDate) {
		this.userChangeDate = userChangeDate;
	}

	public List<UserMgmtOperationAuditEntity> getUserMgmtOperation() {
		return userMgmtOperation;
	}

	public void setUserMgmtOperation(List<UserMgmtOperationAuditEntity> userMgmtOperation) {
		this.userMgmtOperation = userMgmtOperation;
	}

	public UserDataAuditEntity getUserData() {
		return userData;
	}

	public void setUserData(UserDataAuditEntity userData) {
		this.userData = userData;
	}

	public List<UserProfileAuditEntity> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfileAuditEntity> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public List<DeviceAuditEntity> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceAuditEntity> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "AuditEntity [userId=" + userId + ", userChangeId=" + userChangeId + ", userChangeDate=" + userChangeDate
				+ ", userMgmtOperation=" + userMgmtOperation + ", userData=" + userData + ", userProfiles="
				+ userProfiles + ", devices=" + devices + "]";
	}

}
