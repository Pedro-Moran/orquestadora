package com.bbva.kbtq.lib.r518.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.kbtq.lib.r110.KBTQR110;
import com.bbva.kbtq.lib.r115.KBTQR115;
import com.bbva.kbtq.lib.r404.KBTQR404;
import com.bbva.kbtq.lib.r410.KBTQR410;
import com.bbva.kbtq.lib.r518.KBTQR518;
import com.bbva.kbtq.lib.r718.KBTQR718;
import com.bbva.kbtq.lib.r807.KBTQR807;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class KBTQR518Abstract extends AbstractLibrary implements KBTQR518 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected KBTQR404 kbtqR404;

	protected KBTQR110 kbtqR110;

	protected KBTQR718 kbtqR718;

	protected KBTQR115 kbtqR115;

	protected KBTQR410 kbtqR410;

	protected KBTQR807 kbtqR807;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	/**
	* @param kbtqR404 the this.kbtqR404 to set
	*/
	public void setKbtqR404(KBTQR404 kbtqR404) {
		this.kbtqR404 = kbtqR404;
	}

	/**
	* @param kbtqR110 the this.kbtqR110 to set
	*/
	public void setKbtqR110(KBTQR110 kbtqR110) {
		this.kbtqR110 = kbtqR110;
	}

	/**
	* @param kbtqR718 the this.kbtqR718 to set
	*/
	public void setKbtqR718(KBTQR718 kbtqR718) {
		this.kbtqR718 = kbtqR718;
	}

	/**
	* @param kbtqR115 the this.kbtqR115 to set
	*/
	public void setKbtqR115(KBTQR115 kbtqR115) {
		this.kbtqR115 = kbtqR115;
	}

	/**
	* @param kbtqR410 the this.kbtqR410 to set
	*/
	public void setKbtqR410(KBTQR410 kbtqR410) {
		this.kbtqR410 = kbtqR410;
	}

	/**
	* @param kbtqR807 the this.kbtqR807 to set
	*/
	public void setKbtqR807(KBTQR807 kbtqR807) {
		this.kbtqR807 = kbtqR807;
	}

}