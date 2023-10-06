package com.retail.rewards.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents retail rewards information for a customer.
 */
@Getter
@Setter
public class RetailRewards {
    
    /**
     * The unique identifier of the customer.
     */
    private String customerId;
    
    /**
     * The rewards earned in the last month.
     */
    private double lastMonthRewards;
    
    /**
     * The rewards earned in the second-to-last month.
     */
    private double secondLastMonthRewards;
    
    /**
     * The rewards earned in the third-to-last month.
     */
    private double thirdLastMonthRewards;
    
    /**
     * The total rewards earned by the customer.
     */
    private double totalRewards;
    
    /**
     * An error message, if applicable, describing any issues or errors related to rewards calculation.
     */
    private String errorMessage;
}
