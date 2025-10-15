package com.bbva.kusu.lib.r408.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.kusu.lib.r106.KUSUR106;
import com.bbva.kusu.lib.r121.KUSUR121;
import com.bbva.kusu.lib.r205.KUSUR205;
import com.bbva.kusu.lib.r408.KUSUR408;

public abstract class KUSUR408Abstract extends AbstractLibrary implements KUSUR408 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected KUSUR106 kusuR106;
	protected KUSUR121 kusuR121;
	protected KUSUR205 kusuR205;

	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	public void setKusuR106(KUSUR106 kusuR106) {
		this.kusuR106 = kusuR106;
	}

	public void setKusuR121(KUSUR121 kusuR121) {
		this.kusuR121 = kusuR121;
	}

	public void setKusuR205(KUSUR205 kusuR205) {
		this.kusuR205 = kusuR205;
	}

}