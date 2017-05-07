package com.patterns.template.composition.delegate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.patterns.template.composition.dto.CustRequestDTO;
import com.patterns.template.composition.dto.CustResponseDTO;

public class CustomerDelegateTest {
	private static final String CUST_NUMBER = "12345";
	CustomerDelegate classUnderTest;
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new CustomerDelegate();
	}

	@Test(expected=NullPointerException.class)
	public void testExecuteNullRequest() {
		classUnderTest.execute(null);
	}

	@Test
	public void testExecuteWithCriteria() {
		CustRequestDTO request = new CustRequestDTO(CUST_NUMBER);
		CustResponseDTO response = classUnderTest.execute(request);
		assertEquals(CUST_NUMBER, request.getCustomerId());
		assertNotNull(request.getRequestDateTime());
		assertNotNull(request.getRequestId());
		assertNotNull(response.getCustomerName());
		assertTrue(response.isSuccess());
		assertNull(response.getMessages());
	}
	
	@After
	public void tearDown() throws Exception {
		classUnderTest = null;
	}

}
