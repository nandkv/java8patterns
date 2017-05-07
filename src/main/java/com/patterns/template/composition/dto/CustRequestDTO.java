package com.patterns.template.composition.dto;

@SuppressWarnings("serial")
public final class CustRequestDTO extends BaseRequestDTO {
	private String customerId;

	public CustRequestDTO(String customerId) {
		super();
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	
}
