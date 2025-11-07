package com.bbva.pfmh;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.InputListInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.OutputInvestmentFundsDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.PaginationDTO;
import com.bbva.pfmh.dto.jcisconnector.ffmm.commons.IntPaginationDTO;

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
         * Set value for List<OutputInvestmentFundsDTO> output parameter responseOut
         */
        protected void setResponseOut(final List<OutputInvestmentFundsDTO> field){
                this.addParameter("responseOut", field);
        }

        /**
         * Set value for PaginationDTO output parameter pagination
         */
        protected void setPagination(final PaginationDTO field){
                this.addParameter("pagination", field);
        }

        /**
         * Set value for IntPaginationDTO output parameter DTOIntPagination
         */
        protected void setDTOIntPagination(final IntPaginationDTO field){
                this.addParameter("DTOIntPagination", field);
        }
}
