package com.patterns.template.composition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.patterns.template.composition.delegate.CustomerDelegate;
import com.patterns.template.composition.dto.AccountRequestDTO;
import com.patterns.template.composition.dto.AccountResponseDTO;
import com.patterns.template.composition.dto.CustRequestDTO;
import com.patterns.template.composition.dto.CustResponseDTO;

public class App {
	public static void main(String[] args) {
		final Logger customerLogger = LogManager.getLogger("CustomerDelegate");
		final Logger accountLogger = LogManager.getLogger("AccountDelegate");
		
		// method 1
		DelegateProcessor<CustRequestDTO, CustResponseDTO> cd = new DelegateProcessor<CustRequestDTO, CustResponseDTO>(new CustomerDelegate(), customerLogger);
		customerLogger.debug(cd.process(new CustRequestDTO("1234")));
		
		// method 2
		IDelegate<AccountRequestDTO, AccountResponseDTO> accountDelegate = (request) -> {
			accountLogger.debug("calling account service with request {}", () -> request);
			return new AccountResponseDTO(true);
		};

		DelegateProcessor<AccountRequestDTO, AccountResponseDTO> ad = new DelegateProcessor<AccountRequestDTO, AccountResponseDTO>(accountDelegate, accountLogger);
		accountLogger.debug(ad.process(new AccountRequestDTO()));

	}
}
