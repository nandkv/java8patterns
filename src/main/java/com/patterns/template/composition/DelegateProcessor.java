package com.patterns.template.composition;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.Logger;

import com.patterns.template.composition.dto.BaseRequestDTO;
import com.patterns.template.composition.dto.BaseResponseDTO;

public final class DelegateProcessor <X extends BaseRequestDTO, Y extends BaseResponseDTO> {
	private IDelegate<X, Y> delegate;	
	private Logger logger;
	
	DelegateProcessor(@NotNull IDelegate<X, Y> delegate, @NotNull Logger logger){
		this.delegate = delegate;
		this.logger = logger;
	}

	private void validate(X request){
		Objects.requireNonNull(request);
		logger.debug("Validating request object: {}", () -> request);
	}
	
	private void logRequest(X request){
		logger.debug("Logging request object: {}", () -> request);
	}
	
	private void logResponse(Y response){
		logger.debug("Logging Response object: {}", () -> response);
	}
	
	Y process(X request){
		validate(request);
		logRequest(request);
		Y response = delegate.execute(request);
		logResponse(response);
		return response;
	}
	
}
