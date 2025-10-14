package com.bbva.kusu.lib.r325.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.kusu.lib.r106.KUSUR106;
import com.bbva.kusu.lib.r121.KUSUR121;
import com.bbva.kusu.lib.r183.KUSUR183;
import com.bbva.kusu.lib.r205.KUSUR205;
import com.bbva.kusu.lib.r232.KUSUR232;
import com.bbva.kusu.lib.r325.KUSUR325;
import com.bbva.kusu.lib.rf25.KUSURF25;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class KUSUR325Abstract extends AbstractLibrary implements KUSUR325 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected KUSUR106 kusuR106;

	protected KUSUR205 kusuR205;

	protected KUSUR232 kusuR232;

	protected KUSUR121 kusuR121;

	protected KUSURF25 kusuRF25;

	protected KUSUR183 kusuR183;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	/**
	* @param kusuR106 the this.kusuR106 to set
	*/
	public void setKusuR106(KUSUR106 kusuR106) {
		this.kusuR106 = kusuR106;
	}

	/**
	* @param kusuR205 the this.kusuR205 to set
	*/
	public void setKusuR205(KUSUR205 kusuR205) {
		this.kusuR205 = kusuR205;
	}

	/**
	* @param kusuR232 the this.kusuR232 to set
	*/
	public void setKusuR232(KUSUR232 kusuR232) {
		this.kusuR232 = kusuR232;
	}

	/**
	* @param kusuR121 the this.kusuR121 to set
	*/
	public void setKusuR121(KUSUR121 kusuR121) {
		this.kusuR121 = kusuR121;
	}

	/**
	* @param kusuRF25 the this.kusuRF25 to set
	*/
	public void setKusuRF25(KUSURF25 kusuRF25) {
		this.kusuRF25 = kusuRF25;
	}

	/**
	* @param kusuR183 the this.kusuR183 to set
	*/
	public void setKusuR183(KUSUR183 kusuR183) {
		this.kusuR183 = kusuR183;
	}

}