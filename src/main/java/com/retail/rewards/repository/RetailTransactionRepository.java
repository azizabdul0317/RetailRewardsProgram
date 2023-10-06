package com.retail.rewards.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.retail.rewards.entity.RetailTransaction;

import jakarta.transaction.Transactional;

/**
 * A repository interface for managing retail transaction data.
 * This interface extends CrudRepository and provides methods to interact with retail transaction entities.
 */
@Transactional
public interface RetailTransactionRepository extends CrudRepository<RetailTransaction, String> {

    /**
     * Retrieves a list of retail transactions for a specific customer within a specified date range.
     *
     * @param customerId     The unique identifier of the customer for whom transactions are retrieved.
     * @param startTimestamp The starting timestamp of the date range.
     * @param endTimestamp   The ending timestamp of the date range.
     * @return A list of retail transactions within the specified date range for the given customer.
     */
    public List<RetailTransaction> findByCustomerIdAndTransactionDateBetween(
            String customerId, Timestamp startTimestamp, Timestamp endTimestamp);
}