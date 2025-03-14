package com.Hotel.Service;

import com.Hotel.Entity.CustomerEntity;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    // Create Customer
    CustomerEntity createCustomer(CustomerEntity customer0);

    // Get customer by ID
    Optional<CustomerEntity> getCustomerById(Long id);

    // Get customer by email
    Optional<CustomerEntity> getCustomerByEmail(String email);

    // Get all customers
    List<CustomerEntity> getAllCustomers();

    // Update customer by ID
    Optional<CustomerEntity> updateCustomer(Long id, String firstName,String lastName,String email,String mobileNumber,CustomerEntity updatedCustomer);

    // Delete customer
    void deleteCustomer(Long id);
}
