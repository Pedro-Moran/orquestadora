package com.bbva.kusu.dto.users.entity;

import java.util.List;

public class ProfileSmcPackage {
	
	private String profileId;
	private String packageId;
	private List<SmcPackage> smcList;
	
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public List<SmcPackage> getSmcs() {
		return smcList;
	}
	public void setSmcs(List<SmcPackage> smcList) {
		this.smcList = smcList;
	}
	
	@Override
	public String toString() {
		return "ProfileSmcPackageEntity [profileId=" + profileId + ", packageId=" + packageId + ", smcList=" + smcList + "]";
	}
	
	
	
	

}
