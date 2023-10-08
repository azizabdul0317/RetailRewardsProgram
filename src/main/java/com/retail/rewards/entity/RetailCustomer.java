package com.retail.rewards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents a retail customer, including customer details such as
 * customer ID and customer name.
 */
@Data
@Entity
@Table(name = "RETAIL_CUSTOMER")
public class RetailCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private String customerId;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;

}
