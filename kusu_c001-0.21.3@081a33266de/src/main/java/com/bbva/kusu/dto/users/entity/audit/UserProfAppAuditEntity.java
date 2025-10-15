package com.bbva.kusu.dto.users.entity.audit;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class UserProfAppAuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName(value = "gf_platform_application_id")
	private String platformApplicationId;
	
	@SerializedName(value = "g_record_update_type")
	private String recordUpdateType;
	
	@SerializedName(value = "gf_user_audit_id")
	private String userAuditId;
	
	@SerializedName(value = "gf_audit_date")
	private String auditDate;
	
	@SerializedName(value = "gf_double_factor_last_acc_date")
	private String doubleFactorLastAccDate;

	public String getPlatformApplicationId() {
		return platformApplicationId;
	}

	public void setPlatformApplicationId(String platformApplicationId) {
		this.platformApplicationId = platformApplicationId;
	}

	public String getRecordUpdateType() {
		return recordUpdateType;
	}

	public void setRecordUpdateType(String recordUpdateType) {
		this.recordUpdateType = recordUpdateType;
	}

	public String getUserAuditId() {
		return userAuditId;
	}

	public void setUserAuditId(String userAuditId) {
		this.userAuditId = userAuditId;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public String getDoubleFactorLastAccDate() {
		return doubleFactorLastAccDate;
	}

	public void setDoubleFactorLastAccDate(String doubleFactorLastAccDate) {
		this.doubleFactorLastAccDate = doubleFactorLastAccDate;
	}

	@Override
	public String toString() {
		return "UserProfAppAuditEntity [platformApplicationId=" + platformApplicationId + ", recordUpdateType="
				+ recordUpdateType + ", userAuditId=" + userAuditId + ", auditDate=" + auditDate
				+ ", doubleFactorLastAccDate=" + doubleFactorLastAccDate + "]";
	}
	
}
