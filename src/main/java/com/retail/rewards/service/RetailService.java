package com.retail.rewards.service;

import com.retail.rewards.model.RetailRewards;

/**
 * A service interface for calculating retail rewards for a customer.
 * Implementations of this interface are responsible for calculating and
 * providing rewards information based on a customer's unique identifier.
 */
public interface RetailService {

	/**
	 * Calculates and retrieves retail rewards for a specific customer.
	 *
	 * @param customerId The unique identifier of the customer for whom rewards are
	 *                   calculated.
	 * @return A RetailRewards object containing the calculated rewards information.
	 */
	public RetailRewards calculateCustomerRewards(String customerId);
}
