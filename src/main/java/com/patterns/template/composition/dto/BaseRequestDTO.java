package com.patterns.template.composition.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public abstract class BaseRequestDTO implements Serializable{
	private String requestId;
	private LocalDateTime requestDateTime;
	
	public BaseRequestDTO() {
		this.requestId = UUID.randomUUID().toString();
		this.requestDateTime = LocalDateTime.now();
	}

	public String getRequestId() {
		return requestId;
	}

	public LocalDateTime getRequestDateTime() {
		return requestDateTime;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
		 
}
