package com.bbva.kusu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.domain.transaction.Advice;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.kusu.dto.users.beans.ContractsVisibleOperableArray;
import com.bbva.kusu.lib.r408.KUSUR408;

public class KUSUT40801ZZTransaction extends AbstractKUSUT40801ZZTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(KUSUT40801ZZTransaction.class);

	@Override
	public void execute() {

		LOGGER.info("KUSUT40801ZZ - START ...");

		KUSUR408 kusuR408 = getServiceLibrary(KUSUR408.class);

		String profileId = this.getProfileId();
		LOGGER.info("profileId {}", profileId);

		ContractsVisibleOperableArray contractsVisibleOperableArray = kusuR408.executeGetVisibleOperableContracts(profileId);
		LOGGER.info("kusuR408.executeGetVisibleOperableContracts {}", contractsVisibleOperableArray);

		Advice miAdvice = getAdvice();

		if (miAdvice != null) {
			LOGGER.info("KUSUT40801ZZ - ERROR ... {}", miAdvice);
			this.setSeverity(Severity.ENR);
			
		} else {
			this.setContractsVisibleOperableArray(contractsVisibleOperableArray);
			this.setSeverity(Severity.OK);
		}

		LOGGER.info("KUSUT40801ZZ - END ...");
	}
}