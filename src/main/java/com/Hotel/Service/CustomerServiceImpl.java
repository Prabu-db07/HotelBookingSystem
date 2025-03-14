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

    @Override
    public CustomerEntity createCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<CustomerEntity> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

//    @Override
//    public Optional<CustomerEntity> updateCustomer(Long id, String firstName, String lastName, String email, String mobileNumber, CustomerEntity updatedCustomer) {
//        return customerRepository.findById(id).map(existingCustomer -> {
//            existingCustomer.setFirstName(firstName);
//            existingCustomer.setLastName(lastName);
//            existingCustomer.setEmail(email);
//            existingCustomer.setMobileNumber(mobileNumber);
//            existingCustomer.setAge(updatedCustomer.getAge());
//            existingCustomer.setGender(updatedCustomer.getGender());
//            return customerRepository.save(existingCustomer);
//        });
//    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

	@Override
	public Optional<CustomerEntity> updateCustomer(Long id, String firstName, String lastName, String email,
			String mobileNumber, CustomerEntity updatedCustomer) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
