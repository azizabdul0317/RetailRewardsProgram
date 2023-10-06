package com.retail.rewards.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.rewards.constants.RetailConstants;
import com.retail.rewards.entity.RetailTransaction;
import com.retail.rewards.model.RetailRewards;
import com.retail.rewards.repository.RetailTransactionRepository;

@Service
public class RetailServiceImpl implements RetailService {

	@Autowired
	RetailTransactionRepository transactionRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(RetailServiceImpl.class);

	/**
	 * Calculate the total rewards for a customer based on their transactions.
	 *
	 * @param customerId The ID of the customer for whom rewards are calculated.
	 * @return The total rewards earned for 3 months.
	 */
	public RetailRewards calculateCustomerRewards(String customerId) {

		LOGGER.info("Entering into calculateCustomerRewards Method");
		Timestamp lastMonthTimestamp = getTimestampMinusDays(RetailConstants.daysInaMonth);
		Timestamp secondLastMonthTimestamp = getTimestampMinusDays(2 * RetailConstants.daysInaMonth);
		Timestamp ThirdLastMonthTimestamp = getTimestampMinusDays(3 * RetailConstants.daysInaMonth);
		RetailRewards customerRewards = new RetailRewards();
		List<RetailTransaction> lastMonthTransactions = null;
		List<RetailTransaction> lastSecondMonthTransactions = null;
		List<RetailTransaction> lastThirdMonthTransactions = null;
		try {
			lastMonthTransactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId,
					lastMonthTimestamp, Timestamp.from(Instant.now()));
			lastSecondMonthTransactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId,
					secondLastMonthTimestamp, lastMonthTimestamp);
			lastThirdMonthTransactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId,
					ThirdLastMonthTimestamp, secondLastMonthTimestamp);
		} catch (Exception e) {
			customerRewards.setErrorMessage(e.getMessage().toString());
			LOGGER.error(customerRewards.getErrorMessage().toString());
			return customerRewards;
		}
		Double lastMonthRewards = calculateRewardsPerMonth(lastMonthTransactions);
		Double SecondLastMonthRewards = calculateRewardsPerMonth(lastSecondMonthTransactions);
		Double ThirdLastMonthRewards = calculateRewardsPerMonth(lastThirdMonthTransactions);
		customerRewards.setCustomerId(customerId);
		customerRewards.setLastMonthRewards(lastMonthRewards);
		customerRewards.setSecondLastMonthRewards(SecondLastMonthRewards);
		customerRewards.setThirdLastMonthRewards(ThirdLastMonthRewards);
		customerRewards.setTotalRewards(lastMonthRewards + SecondLastMonthRewards + ThirdLastMonthRewards);
		LOGGER.debug(
				"CustomerId::{},lastMonthRewards::{},SecondLastMonthRewards::{},ThirdLastMonthRewards::{},totalRewards::{}",
				customerRewards.getCustomerId(), customerRewards.getLastMonthRewards(),
				customerRewards.getSecondLastMonthRewards(), customerRewards.getThirdLastMonthRewards(),
				customerRewards.getTotalRewards());
		LOGGER.info("Exiting the calculateCustomerRewards Method");
		return customerRewards;

	}

	/**
	 * Calculates the total rewards earned for a list of retail transactions within
	 * a month.
	 *
	 * @param transactions A list of retail transactions for which rewards are
	 *                     calculated.
	 * @return The total rewards earned for the specified month.
	 */
	private double calculateRewardsPerMonth(List<RetailTransaction> transactions) {
		return transactions.stream().map(this::calculateRewards).mapToDouble(Double::doubleValue).sum();
	}

	/**
	 * Calculates the rewards for a retail transaction based on the transaction
	 * amount and predefined reward limits.
	 *
	 * @param t The retail transaction for which rewards are calculated.
	 * @return The rewards earned for the given transaction.
	 */
	private double calculateRewards(RetailTransaction t) {
		double amountSpent = t.getAmountSpent();

		if (amountSpent > RetailConstants.secondRewardOverLimit) {
			return ((amountSpent - RetailConstants.secondRewardOverLimit) * 1)
					+ (amountSpent - RetailConstants.intialRewardOverLimit);
		} else if (amountSpent > RetailConstants.intialRewardOverLimit) {
			return amountSpent - RetailConstants.intialRewardOverLimit;
		} else {
			return 0.0;
		}
	}

	/**
	 * Calculates a Timestamp representing a date and time by subtracting a
	 * specified number of days from the current LocalDateTime.
	 *
	 * @param days The number of days to subtract from the current date and time.
	 * @return A Timestamp representing the date and time resulting from the
	 *         subtraction.
	 */
	private Timestamp getTimestampMinusDays(int days) {
		LocalDateTime dateTime = LocalDateTime.now().minusDays(days);
		return Timestamp.valueOf(dateTime);
	}
}
