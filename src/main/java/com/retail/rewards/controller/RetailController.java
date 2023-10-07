package com.retail.rewards.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.rewards.constants.RetailConstants;
import com.retail.rewards.entity.RetailCustomer;
import com.retail.rewards.model.RetailErrorMessages;
import com.retail.rewards.model.RetailRewards;
import com.retail.rewards.repository.RetailCustomerRepository;
import com.retail.rewards.service.RetailService;

@RestController
@RequestMapping("/retailCustomers")
public class RetailController {

	@Autowired
	RetailService rewardsService;

	@Autowired
	RetailCustomerRepository customerRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(RetailController.class);

	/**
	 * Retrieves and returns retail rewards information for a specific customer by
	 * their unique customer ID.
	 *
	 * @param customerId The unique identifier of the customer for whom rewards
	 *                   information is requested.
	 * @return A ResponseEntity containing retail rewards information in JSON
	 *         format, or an error message with an appropriate HTTP status code.
	 */
	@GetMapping(value = {"/getRewards/{customerId}","/getRewards/"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getRewardsByCustomerId(@PathVariable(name="customerId",required=false) String customerId) {
		RetailCustomer customer = new RetailCustomer();
		RetailRewards customerRewards = new RetailRewards();
		RetailErrorMessages retailErrorMessages = new RetailErrorMessages();
		;
		try {
			if (customerId == null || customerId.isBlank()) {
				retailErrorMessages.setErrorMessage("Customer Id field is Blank");
				retailErrorMessages.setErrorCode(RetailConstants.missingId);
				LOGGER.debug(retailErrorMessages.getErrorMessage());
				return new ResponseEntity<>(retailErrorMessages, HttpStatus.BAD_REQUEST);
			}
			LOGGER.debug("CustomerId::{}", customerId);
			customer = customerRepository.findByCustomerId(customerId);
			if (customer == null) {
				retailErrorMessages.setErrorMessage("Unable To Find Customer Id, Please Enter Valid Customer Id");
				retailErrorMessages.setErrorCode(RetailConstants.customerNotFound);
				LOGGER.debug(retailErrorMessages.getErrorMessage());
				return new ResponseEntity<>(retailErrorMessages, HttpStatus.OK);
			}
			customerRewards = rewardsService.calculateCustomerRewards(customerId);
			return new ResponseEntity<>(customerRewards, HttpStatus.OK);
		} catch (Exception e) {
			retailErrorMessages.setErrorMessage(e.getMessage().toString());
			retailErrorMessages.setErrorCode(RetailConstants.internalServerError);
			LOGGER.error(retailErrorMessages.getErrorMessage());
			return new ResponseEntity<>(retailErrorMessages, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
