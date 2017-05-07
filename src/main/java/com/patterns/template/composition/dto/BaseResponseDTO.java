package com.patterns.template.composition.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public abstract class BaseResponseDTO implements Serializable {
	private boolean success;
	private List<String> messages;
		
	public BaseResponseDTO(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public List<String> getMessages() {
		return messages;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
