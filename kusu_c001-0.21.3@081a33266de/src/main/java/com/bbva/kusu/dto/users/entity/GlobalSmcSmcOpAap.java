package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;
import java.util.List;

import com.bbva.kusu.dto.users.entity.commons.AapCommons;

public class GlobalSmcSmcOpAap implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private List<SmcVersionJoinCustomContractRole> listSmc;
	
	private List<SmcVersionJoinCustomContractRole> listSmcOperative;
	
	private List<AapCommons> listAap;
	
	private List<SmcVersionJoinCustomContractRole> smcAdmin;
	
	private List<SmcVersionJoinCustomContractRole> smcConsult;

	private List<SmcVersionJoinCustomContractRole> smcNonDefault;

	private List<SmcVersionJoinCustomContractRole> smcRestrictive;


	public List<SmcVersionJoinCustomContractRole> getSmcRestrictive() {return smcRestrictive;	}

	public void setSmcRestrictive( List<SmcVersionJoinCustomContractRole> smcRestrictive) {
		this.smcRestrictive = smcRestrictive;}


	
	

	public List<SmcVersionJoinCustomContractRole> getListSmc() {
		return listSmc;
	}

	public void setListSmc(List<SmcVersionJoinCustomContractRole> listSmc) {
		this.listSmc = listSmc;
	}

	public List<SmcVersionJoinCustomContractRole> getListSmcOperative() {
		return listSmcOperative;
	}

	public void setListSmcOperative(List<SmcVersionJoinCustomContractRole> listSmcOperative) {
		this.listSmcOperative = listSmcOperative;
	}

	public List<AapCommons> getListAap() {
		return listAap;
	}

	public void setListAap(List<AapCommons> listAap) {
		this.listAap = listAap;
	}
	

	public List<SmcVersionJoinCustomContractRole> getSmcAdmin() {
		return smcAdmin;
	}

	public void setSmcAdmin(List<SmcVersionJoinCustomContractRole> smcAdmin) {
		this.smcAdmin = smcAdmin;
	}

	public List<SmcVersionJoinCustomContractRole> getSmcConsult() {
		return smcConsult;
	}

	public void setSmcConsult(List<SmcVersionJoinCustomContractRole> smcConsult) {
		this.smcConsult = smcConsult;
	}

	public List<SmcVersionJoinCustomContractRole> getSmcNonDefault() {return smcNonDefault;}

	public void setSmcNonDefault(List<SmcVersionJoinCustomContractRole> smcNonDefault) {this.smcNonDefault = smcNonDefault;}

	@Override
	public String toString() {
		return "GlobalSmcSmcOpAap{" +
				"listSmc=" + listSmc +
				", listSmcOperative=" + listSmcOperative +
				", listAap=" + listAap +
				", smcAdmin=" + smcAdmin +
				", smcConsult=" + smcConsult +
				", smcNonDefault=" + smcNonDefault +
				", smcRestrictive=" + smcRestrictive +
				'}';
	}



}
