package com.patterns.template.composition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.patterns.template.composition.dto.CustRequestDTO;
import com.patterns.template.composition.dto.CustResponseDTO;

@RunWith(MockitoJUnitRunner.class)
public class DelegateProcessorTest {
	private static final String CUST_NUMBER = "1232123";
	private static final String CUST_NAME = "customerName";
	
	Logger logger;	
	IDelegate<CustRequestDTO, CustResponseDTO> mockDelegate;
	DelegateProcessor<CustRequestDTO, CustResponseDTO> classUnderTest;

	
	@Before
	public void setUp() throws Exception {
		logger = Mockito.mock(Logger.class);
		mockDelegate = (request) -> {return new CustResponseDTO(true, CUST_NAME);};
		classUnderTest = new DelegateProcessor<CustRequestDTO, CustResponseDTO>(mockDelegate, logger);
	}

	@Test(expected=NullPointerException.class)
	public void testInitialization() {
		classUnderTest = new DelegateProcessor<CustRequestDTO, CustResponseDTO>(null, null);
		CustRequestDTO request = new CustRequestDTO(CUST_NUMBER);
		classUnderTest.process(request);
	}

	@Test
	public void testProcess() {
		CustRequestDTO request = new CustRequestDTO(CUST_NUMBER);
		CustResponseDTO response = classUnderTest.process(request);
		assertNotNull(response);
		assertEquals(CUST_NUMBER, request.getCustomerId());
		assertNotNull(request.getRequestDateTime());
		assertNotNull(request.getRequestId());
		assertEquals(CUST_NAME, response.getCustomerName());
		assertNotNull(response.getCustomerName());
		assertTrue(response.isSuccess());
		assertNull(response.getMessages());
	}
	
	@After
	public void tearDown() throws Exception {
		classUnderTest = null;
	}

}
