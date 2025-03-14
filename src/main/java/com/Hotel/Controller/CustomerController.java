package com.Hotel.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Hotel.Entity.CustomerEntity;
import com.Hotel.Service.CustomerService;
import lombok.AllArgsConstructor;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private  CustomerService customerService; // No need for @Autowired when using @AllArgsConstructor

    // Add Customer (POST)
    @PostMapping("/add")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
        CustomerEntity savedCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Get Customer by ID (GET)
    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get All Customers (GET)
    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Update Customer (PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity updatedCustomer) {
        try {
            CustomerEntity updated = customerService.updateCustomer(id, updatedCustomer);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Customer (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>("Customer deleted successfully!", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Customer not found!", HttpStatus.NOT_FOUND);
        }
    }
}
