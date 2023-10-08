package com.retail.rewards.model;

import lombok.Data;

/**
 * Represents retail rewards information for a customer.
 */
@Data
public class RetailRewards {
    
    /**
     * The unique identifier of the customer.
     */
    private String customerId;
    
    /**
     * The rewards earned in the last month.
     */
    private long lastMonthRewards;
    
    /**
     * The rewards earned in the second-to-last month.
     */
    private long secondLastMonthRewards;
    
    /**
     * The rewards earned in the third-to-last month.
     */
    private long thirdLastMonthRewards;
    
    /**
     * The total rewards earned by the customer.
     */
    private long totalRewards;
    
    /**
     * An error message, if applicable, describing any issues or errors related to rewards calculation.
     */
    private String errorMessage;
}
