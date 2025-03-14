package com.Hotel.Controller;

import org.springframework.web.bind.annotation.*;
import com.Hotel.Entity.CustomerEntity;
import com.Hotel.Service.CustomerService;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService; // No need for @Autowired when using @AllArgsConstructor

    // Add Customer (POST)
    @PostMapping("/add")
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
        return customerService.createCustomer(customer);
    }

    // Get Customer by ID (GET)
    @GetMapping("/get/{id}")
    public Optional<CustomerEntity> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // Get All Customers (GET)
    @GetMapping("/all")
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Update Customer (PUT)
    @PutMapping("/update/{id}")
    public CustomerEntity updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    // Delete Customer (DELETE)
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully!";
    }
}
