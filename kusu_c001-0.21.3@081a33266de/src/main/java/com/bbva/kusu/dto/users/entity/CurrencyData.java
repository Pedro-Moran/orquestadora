package com.bbva.kusu.dto.users.entity;

import java.io.Serializable;

public class CurrencyData implements Serializable {

	private static final long serialVersionUID = 1L; // Versión de serialización

	private String currency;

	private Double signatureLimit;

	public Double getSignatureLimit() {
		return signatureLimit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setSignatureLimit(Double signatureLimit) {
		this.signatureLimit = signatureLimit;
	}

	@Override
	public String toString() {
		return "CurrencyData{" + "currency='" + currency + '\'' + ", signatureLimit=" + signatureLimit + '}';
	}
}
