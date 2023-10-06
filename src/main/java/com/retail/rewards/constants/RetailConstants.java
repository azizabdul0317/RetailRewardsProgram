package com.retail.rewards.constants;

/**
 * Constants used in retail-related calculations and operations.
 */
public class RetailConstants {

	/**
	 * The number of days in a month, used for date-related calculations.
	 */
	public static final int daysInaMonth = 30;

	/**
	 * The initial reward over-limit threshold for retail transactions.
	 */
	public static int intialRewardOverLimit = 50;

	/**
	 * The second reward over-limit threshold for retail transactions.
	 */
	public static int secondRewardOverLimit = 100;
	
	/**
	 * The error codes for retail transactions.
	 */
	public static String missingId="1001";
	public static String customerNotFound="1002";
	public static String internalServerError="1003";
	
}