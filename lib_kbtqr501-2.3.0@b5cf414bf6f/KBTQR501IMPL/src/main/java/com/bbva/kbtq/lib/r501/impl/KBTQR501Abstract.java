package com.bbva.kbtq.lib.r501.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.kbtq.lib.r110.KBTQR110;
import com.bbva.kbtq.lib.r501.KBTQR501;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class KBTQR501Abstract extends AbstractLibrary implements KBTQR501 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected KBTQR110 kbtqR110;

	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	public void setKbtqR110(KBTQR110 kbtqR110) {
		this.kbtqR110 = kbtqR110;
	}
}