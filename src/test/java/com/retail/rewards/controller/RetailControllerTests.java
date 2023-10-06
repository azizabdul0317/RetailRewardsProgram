package com.retail.rewards.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.retail.rewards.entity.RetailCustomer;
import com.retail.rewards.model.RetailRewards;
import com.retail.rewards.repository.RetailCustomerRepository;
import com.retail.rewards.service.RetailService;

public class RetailControllerTests {

	@InjectMocks
	private RetailController retailController;

	@Mock
	private RetailCustomerRepository retailCustomerRepository;

	@Mock
	private RetailService retailService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetRewardsByCustomerIdValidCustomer() {
		String validCustomerId = "validCustomerId";
		RetailCustomer customer = new RetailCustomer();
		customer.setCustomerId(validCustomerId);
		RetailRewards customerRewards = new RetailRewards();
		when(retailCustomerRepository.findByCustomerId(eq(validCustomerId))).thenReturn(customer);
		when(retailService.calculateCustomerRewards(eq(validCustomerId))).thenReturn(customerRewards);

		ResponseEntity<?> responseEntity = retailController.getRewardsByCustomerId(validCustomerId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(customerRewards, responseEntity.getBody());
	}

	@Test
	public void testGetRewardsByCustomerIdInvalidCustomer() {
		String invalidCustomerId = "invalidCustomerId";
		when(retailCustomerRepository.findByCustomerId(eq(invalidCustomerId))).thenReturn(null);

		ResponseEntity<?> responseEntity = retailController.getRewardsByCustomerId(invalidCustomerId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		// You can also assert the response body here if needed.
	}

	@Test
	public void testGetRewardsByCustomerIdInvalidInput() {
		String invalidCustomerId = "";
		ResponseEntity<?> responseEntity = retailController.getRewardsByCustomerId(invalidCustomerId);

		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
		// You can also assert the response body here if needed.
	}

	@Test
	public void testGetRewardsByCustomerIdException() {
		String validCustomerId = "validCustomerId";
		when(retailCustomerRepository.findByCustomerId(eq(validCustomerId)))
				.thenThrow(new RuntimeException("Test Exception"));

		ResponseEntity<?> responseEntity = retailController.getRewardsByCustomerId(validCustomerId);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
		// You can also assert the response body here if needed.
	}
}