package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bbva.kusu.dto.users.util.PaginationDTO;

public class ProfCstRoleCapSmcAndClients implements Serializable {
	private static final long serialVersionUID = 1L;

	/**list for customized smcs with sons*/
	private List<String> cstMltxActiveSonsRelatedToSmc;
	/**list of customized roles mltx*/
	private List<ProfCstMltxRoleEntity> listProfMltxRoles;
	/**list of customized caps mltx*/
	private List<ProfCstMltxCapbEntity> listProfMltxCaps;
	/**list of customized smcs mltx*/
	private List<ProfCstMltxSmcEntity> listProfMltxSmcs;
	
	
	public List<String> getCstMltxActiveSonsRelatedToSmc() {
		return cstMltxActiveSonsRelatedToSmc;
	}
	public void setCstMltxActiveSonsRelatedToSmc(List<String> cstMltxActiveSonsRelatedToSmc) {
		this.cstMltxActiveSonsRelatedToSmc = cstMltxActiveSonsRelatedToSmc;
	}
	public List<ProfCstMltxRoleEntity> getListProfMltxRoles() {
		return listProfMltxRoles;
	}
	public void setListProfMltxRoles(List<ProfCstMltxRoleEntity> listProfMltxRoles) {
		this.listProfMltxRoles = listProfMltxRoles;
	}
	public List<ProfCstMltxCapbEntity> getListProfMltxCaps() {
		return listProfMltxCaps;
	}
	public void setListProfMltxCaps(List<ProfCstMltxCapbEntity> listProfMltxCaps) {
		this.listProfMltxCaps = listProfMltxCaps;
	}
	public List<ProfCstMltxSmcEntity> getListProfMltxSmcs() {
		return listProfMltxSmcs;
	}
	public void setListProfMltxSmcs(List<ProfCstMltxSmcEntity> listProfMltxSmcs) {
		this.listProfMltxSmcs = listProfMltxSmcs;
	}
	@Override
	public String toString() {
		return "ProfCstRoleCapSmcAndClients [cstMltxActiveSonsRelatedToSmc=" + cstMltxActiveSonsRelatedToSmc
				+ ", listProfMltxRoles=" + listProfMltxRoles + ", listProfMltxCaps=" + listProfMltxCaps
				+ ", listProfMltxSmcs=" + listProfMltxSmcs + "]";
	}
	
	
	
	
	

}
