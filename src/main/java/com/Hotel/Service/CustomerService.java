package com.Hotel.Service;

import com.Hotel.Entity.CustomerEntity;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    // Create Customer
    CustomerEntity createCustomer(CustomerEntity customer0);

    // Get customer by ID
    Optional<CustomerEntity> getCustomerById(Long id);

    // Get all customers
    List<CustomerEntity> getAllCustomers();

    // Update customer by ID
   CustomerEntity updateCustomer(Long id,CustomerEntity updatedCustomer);

    // Delete customer
    void deleteCustomer(Long id);
}
