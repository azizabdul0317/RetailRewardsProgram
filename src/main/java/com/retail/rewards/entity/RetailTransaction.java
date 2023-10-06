package com.retail.rewards.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a retail transaction, including transaction details such as
 * transaction ID, customer ID, transaction date, and amount spent.
 */
@Getter
@Setter
@Entity
@Table(name = "RETAIL_TRANSACTION")
public class RetailTransaction {
    
	@Id
    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Column(name="CUSTOMER_ID")
    private String customerId;
    @Column(name = "TRANSACTION_DATE")
    private Timestamp transactionDate;
    @Column(name = "AMOUNT_SPENT")
    private double amountSpent;
}
