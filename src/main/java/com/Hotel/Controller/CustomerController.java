package com.Hotel.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private  CustomerService customerService ;

    // Add Customer (POST)
    @PostMapping("/add")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer0) {
        CustomerEntity savedCustomer = customerService.createCustomer(customer0);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Get Customer by ID (GET)
    @GetMapping("/get/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) {
        Optional<CustomerEntity> customer = customerService.getCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
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
//    public ResponseEntity<CustomerEntity> updateCustomer(
//            @PathVariable Long id,
//            @RequestBody CustomerEntity updatedCustomer) {
//
//        Optional<CustomerEntity> updated = customerService.updateCustomer(
//                id,
//                updatedCustomer.getFirstName(),
//                updatedCustomer.getLastName(),
//                updatedCustomer.getEmail(),
//                updatedCustomer.getMobileNumber(),
//                updatedCustomer
//        );
//
//        return updated.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    // Delete Customer (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted successfully!", HttpStatus.OK);
    }
}
