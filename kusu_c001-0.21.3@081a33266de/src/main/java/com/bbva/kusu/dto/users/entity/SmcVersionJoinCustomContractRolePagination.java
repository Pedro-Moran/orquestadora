package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.bbva.kusu.dto.users.beans.Division;
import com.bbva.kusu.dto.users.util.PaginationDTO;

public class SmcVersionJoinCustomContractRolePagination implements Serializable {
	private static final long serialVersionUID = 1L;

	private PaginationDTO pagination;

	private String isAllContracted;

	private String customerId;

	private BigDecimal gfSignatureWeightPer;

	private BigDecimal userValidationWeightPer;

	private	String categoryId;
	
	private Division division;

	private RelatedPerson relatedPerson;

	private List<SmcVersionJoinCustomContractRole> listSmcVersionJoinCustomContractRole;
	
	private boolean isFullRetail;
	
	private boolean isFastTrack;
	
	private	String rolePersonId;
	
	private	String personRoleType;

    private String gUserCustomRoleIndType;

    private String gUserCustomCtrctIndType;

	public PaginationDTO getPagination() {
		return this.pagination;
	}

	public void setPagination(PaginationDTO pagination) {
		this.pagination = pagination;
	}

	public String getIsAllContracted() {
		return isAllContracted;
	}

	public void setIsAllContracted(String isAllContracted) {
		this.isAllContracted = isAllContracted;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the gfSignatureWeightPer
	 */
	public BigDecimal getGfSignatureWeightPer() {
		return gfSignatureWeightPer;
	}

	/**
	 * @param gfSignatureWeightPer the gfSignatureWeightPer to set
	 */
	public void setGfSignatureWeightPer(BigDecimal gfSignatureWeightPer) {
		this.gfSignatureWeightPer = gfSignatureWeightPer;
	}

	/**
	 * @return the userValidationWeightPer
	 */
	public BigDecimal getUserValidationWeightPer() {
		return userValidationWeightPer;
	}

	/**
	 * @param userValidationWeightPer the userValidationWeightPer to set
	 */
	public void setUserValidationWeightPer(BigDecimal userValidationWeightPer) {
		this.userValidationWeightPer = userValidationWeightPer;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<SmcVersionJoinCustomContractRole> getListSmcVersionJoinCustomContractRole() {
		return this.listSmcVersionJoinCustomContractRole;
	}

	public void setListSmcVersionJoinCustomContractRole(List<SmcVersionJoinCustomContractRole> listSmcVersionJoinCustomContractRole) {
		this.listSmcVersionJoinCustomContractRole = listSmcVersionJoinCustomContractRole;
	}

	/**
	 * @return the relatedPerson
	 */
	public RelatedPerson getRelatedPerson() {
		return relatedPerson;
	}

	/**
	 * @param relatedPerson the relatedPerson to set
	 */
	public void setRelatedPerson(RelatedPerson relatedPerson) {
		this.relatedPerson = relatedPerson;
	}
	
	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}
	
	

	public boolean isFullRetail() {
		return isFullRetail;
	}

	public void setFullRetail(boolean isFullRetail) {
		this.isFullRetail = isFullRetail;
	}

	public boolean isFastTrack() {
		return isFastTrack;
	}

	public void setFastTrack(boolean isFastTrack) {
		this.isFastTrack = isFastTrack;
	}

	public String getRolePersonId() {
		return rolePersonId;
	}

	public void setRolePersonId(String rolePersonId) {
		this.rolePersonId = rolePersonId;
	}

	public String getPersonRoleType() {
		return personRoleType;
	}

	public void setPersonRoleType(String personRoleType) {
		this.personRoleType = personRoleType;
	}

    public String getgUserCustomRoleIndType() {
        return gUserCustomRoleIndType;
    }

    public void setgUserCustomRoleIndType(String gUserCustomRoleIndType) {
        this.gUserCustomRoleIndType = gUserCustomRoleIndType;
    }

    public String getgUserCustomCtrctIndType() {
        return gUserCustomCtrctIndType;
    }

    public void setgUserCustomCtrctIndType(String gUserCustomCtrctIndType) {
        this.gUserCustomCtrctIndType = gUserCustomCtrctIndType;
    }

    @Override
    public String toString() {
        return "SmcVersionJoinCustomContractRolePagination{" +
                "pagination=" + pagination +
                ", isAllContracted='" + isAllContracted + '\'' +
                ", customerId='" + customerId + '\'' +
                ", gfSignatureWeightPer=" + gfSignatureWeightPer +
                ", userValidationWeightPer=" + userValidationWeightPer +
                ", categoryId='" + categoryId + '\'' +
                ", division=" + division +
                ", relatedPerson=" + relatedPerson +
                ", listSmcVersionJoinCustomContractRole=" + listSmcVersionJoinCustomContractRole +
                ", isFullRetail=" + isFullRetail +
                ", isFastTrack=" + isFastTrack +
                ", rolePersonId='" + rolePersonId + '\'' +
                ", personRoleType='" + personRoleType + '\'' +
                ", gUserCustomRoleIndType='" + gUserCustomRoleIndType + '\'' +
                ", gUserCustomCtrctIndType='" + gUserCustomCtrctIndType + '\'' +
                '}';
    }
}
