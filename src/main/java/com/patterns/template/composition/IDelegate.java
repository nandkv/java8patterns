package com.patterns.template.composition;

import com.patterns.template.composition.dto.BaseRequestDTO;
import com.patterns.template.composition.dto.BaseResponseDTO;

@FunctionalInterface
public interface IDelegate <X extends BaseRequestDTO, Y extends BaseResponseDTO> {
	
	Y execute(X request);
	
}
