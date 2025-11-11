package com.bbva.pfmh;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.PaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.investmen.InvestmentFund;

import java.util.List;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractPFMHT01001PETransaction extends AbstractTransaction {

	protected AbstractPFMHT01001PETransaction(){
	}


	/**
	 * Return value for input parameter InputListInvestmentFundsDTO
	 */
	protected InputListInvestmentFundsDTO getInputlistinvestmentfundsdto(){
		return (InputListInvestmentFundsDTO)this.getParameter("InputListInvestmentFundsDTO");
	}

	/**
	 * Set value for List<InvestmentFund> output parameter data
	 */
	protected void setData(final List<InvestmentFund> field){
		this.addParameter("data", field);
	}

	/**
	 * Set value for PaginationDTO output parameter DTOPagination
	 */
	protected void setDTOPagination(final PaginationDTO field){
		this.addParameter("DTOPagination", field);
	}

	/**
	 * Set value for IntPaginationDTO output parameter DTOIntPagination
	 */
	protected void setDTOIntPagination(final IntPaginationDTO field){
		this.addParameter("DTOIntPagination", field);
	}
}