package com.patterns.template.composition;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.SystemUtils;
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

		List<Customer> customerList = null;
		if (CollectionUtils.isNotEmpty(customerList)){
			for (Customer c : customerList){
				//
			}			
		}
		
		String windows_filename = "c:\\view\\apps\\content\\fhct\\en\\balloon_help\\filename.json";
		String unix_filename = "/opt/content/fhct/en/balloon_help/filename.json";
		
//		String[] arr = filename.split("\\.");
//		
//		for (String s: arr){
//			System.out.println(s);
//		}
//		
//		System.out.println(filename.split("\\.")[0].split("\\:")[1].replaceAll("\\\\", "_"));
		
		//if (SystemUtils.IS_OS_WINDOWS){
			System.out.println(windows_filename.split("\\.")[0].split(":")[1].replaceAll("(\\\\|:|\\.|//)", "_"));
		//} else {
			//FileNameUtils.
			System.out.println(unix_filename.split("\\.")[0].replaceAll("(\\\\|:|\\.|\\/)", "_"));
		//}

			String text = "this is a lt&number&gt";
			String replaced = text.replace("number", "Nand");
			System.out.println(replaced);
	}
}
