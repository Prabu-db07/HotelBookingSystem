package com.Hotel.Service;

import com.Hotel.Entity.CustomerEntity;
import com.Hotel.Repossitory.CustomerRepossitory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  CustomerRepossitory customerRepository;

    //add user 
    @Override
    public CustomerEntity createCustomer(CustomerEntity customer0) {
        return customerRepository.save(customer0);
    }
     // get user by id
    @Override
    public Optional<CustomerEntity> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
  
      // get all user
    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }
    
  // delete user
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    //update
     @Override
    public CustomerEntity updateCustomer(Long id, CustomerEntity updatedCustomer) {
	 CustomerEntity existingCustomer = customerRepository.findById(id).orElseThrow(() 
			 -> new RuntimeException("Customer not found: " + id));
	 existingCustomer.setFirstName(updatedCustomer.getFirstName());
	 existingCustomer.setLastName(updatedCustomer.getLastName());
	 existingCustomer.setEmail(updatedCustomer.getEmail());
	 existingCustomer.setMobileNumber(updatedCustomer.getMobileNumber());
	 existingCustomer.setAge(updatedCustomer.getAge());
	 return customerRepository.save(existingCustomer);
}


	
}
