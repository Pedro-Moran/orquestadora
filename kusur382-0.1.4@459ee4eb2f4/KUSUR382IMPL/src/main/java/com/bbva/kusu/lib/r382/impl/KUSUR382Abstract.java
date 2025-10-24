package com.bbva.kusu.lib.r382.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import com.bbva.kbtq.lib.r504.KBTQR504;
import com.bbva.kusu.lib.r183.KUSUR183;
import com.bbva.kusu.lib.r205.KUSUR205;
import com.bbva.kusu.lib.r216.KUSUR216;
import com.bbva.kusu.lib.r382.KUSUR382;
import com.bbva.kusu.lib.rf82.KUSURF82;

public abstract class KUSUR382Abstract extends AbstractLibrary implements KUSUR382 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected JdbcUtils jdbcUtils;

	protected KUSUR183 kusuR183;
	protected KUSUR205 kusuR205;
	protected KUSUR216 kusuR216;
	protected KUSURF82 kusuRF82;
	protected KBTQR504 kbtqR504;

	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	public void setJdbcUtils(JdbcUtils jdbcUtils) {
		this.jdbcUtils = jdbcUtils;
	}

	public void setKusuR183(KUSUR183 kusuR183) {
		this.kusuR183 = kusuR183;
	}

	public void setKusuR205(KUSUR205 kusuR205) {
		this.kusuR205 = kusuR205;
	}

	public void setKusuR216(KUSUR216 kusuR216) {
		this.kusuR216 = kusuR216;
	}

	public void setKusuRF82(KUSURF82 kusuRF82) {
		this.kusuRF82 = kusuRF82;
	}

	public void setKbtqR504(KBTQR504 kbtqR504) {
		this.kbtqR504 = kbtqR504;
	}
}