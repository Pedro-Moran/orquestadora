package com.bbva.ccse.lib.r003.impl;

import com.bbva.ccse.lib.r002.CCSER002;
import com.bbva.ccse.lib.r003.CCSER003;
import com.bbva.ccse.lib.r006.CCSER006;
import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.elara.utility.api.connector.APIConnector;
import com.bbva.elara.utility.api.connector.APIConnectorBuilder;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class CCSER003Abstract extends AbstractLibrary implements CCSER003 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected APIConnector internalApiConnector;

	protected APIConnectorBuilder apiConnectorBuilder;

	protected CCSER002 ccseR002;

	protected CCSER006 ccseR006;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	/**
	* @param internalApiConnector the this.internalApiConnector to set
	*/
	public void setInternalApiConnector(APIConnector internalApiConnector) {
		this.internalApiConnector = internalApiConnector;
	}

	/**
	* @param apiConnectorBuilder the this.apiConnectorBuilder to set
	*/
	public void setApiConnectorBuilder(APIConnectorBuilder apiConnectorBuilder) {
		this.apiConnectorBuilder = apiConnectorBuilder;
	}

	/**
	* @param ccseR002 the this.ccseR002 to set
	*/
	public void setCcseR002(CCSER002 ccseR002) {
		this.ccseR002 = ccseR002;
	}

	/**
	* @param ccseR006 the this.ccseR006 to set
	*/
	public void setCcseR006(CCSER006 ccseR006) {
		this.ccseR006 = ccseR006;
	}

}