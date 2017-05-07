package com.patterns.template.composition.dto;

@SuppressWarnings("serial")
public final class CustResponseDTO extends BaseResponseDTO {
	private String customerName;
	
	public CustResponseDTO(boolean success, String customerName) {
		super(success);
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
