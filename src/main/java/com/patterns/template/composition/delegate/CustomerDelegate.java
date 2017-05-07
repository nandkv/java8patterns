package com.patterns.template.composition.delegate;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.patterns.template.composition.IDelegate;
import com.patterns.template.composition.dto.CustRequestDTO;
import com.patterns.template.composition.dto.CustResponseDTO;

public final class CustomerDelegate implements IDelegate<CustRequestDTO, CustResponseDTO>{
	private static final Logger LOGGER = LogManager.getLogger(CustomerDelegate.class);

	@Override
	public CustResponseDTO execute(CustRequestDTO request) {
		Objects.requireNonNull(request);
		LOGGER.debug("Transforming DTO request object to XML: {}", () -> request);
		CustResponseDTO response = new CustResponseDTO(true, "test");
		LOGGER.debug("Calling service with request: {}", () -> request);
		LOGGER.debug("Transforming XML request object to DTO: {}", () -> request);
		return response;
	}

}
