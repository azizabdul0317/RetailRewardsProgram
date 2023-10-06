package com.retail.rewards.repository;



import org.springframework.data.repository.CrudRepository;

import com.retail.rewards.entity.RetailCustomer;

import jakarta.transaction.Transactional;

/**
 * A repository interface for managing retail customer data.
 * This interface extends CrudRepository and provides methods to interact with retail customer entities.
 */
@Transactional
public interface RetailCustomerRepository extends CrudRepository<RetailCustomer, String> {

    /**
     * Retrieves a retail customer entity by their unique customer ID.
     *
     * @param customerId The unique identifier of the customer to retrieve.
     * @return A retail customer entity with the specified customer ID, or null if not found.
     */
    public RetailCustomer findByCustomerId(String customerId);
}
