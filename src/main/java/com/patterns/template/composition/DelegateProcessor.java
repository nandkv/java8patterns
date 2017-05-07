package com.patterns.template.composition;

import java.util.Objects;

import org.apache.logging.log4j.Logger;

import com.patterns.template.composition.dto.BaseRequestDTO;
import com.patterns.template.composition.dto.BaseResponseDTO;


public final class DelegateProcessor <X extends BaseRequestDTO, Y extends BaseResponseDTO> {
	private IDelegate<X, Y> delegate;
	private Logger logger;
	
	DelegateProcessor(IDelegate<X, Y> delegate, Logger logger){
		Objects.requireNonNull(delegate);
		Objects.requireNonNull(logger);
		this.delegate = delegate;
		this.logger = logger;
	}

	private void validate(X x){
		Objects.requireNonNull(x);
		logger.debug("Validating request object: {}", () -> x);
	}
	
	private void logRequest(X x){
		logger.debug("Logging request object: {}", () -> x);
	}
	
	private void logResponse(Y y){
		logger.debug("Logging Response object: {}", () -> y);
	}
	
	Y process(X x){
		validate(x);
		logRequest(x);
		Y u = delegate.execute(x);
		logResponse(u);
		return u;
	}
	
}
