package com.example.customer.controller;


import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.customer.mapping.CustomerDto;

import java.util.List;

@RestController
@RequestMapping("/main/customers")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto createdCustomer = customerService.saveCustomer(customerDto);
        return ResponseEntity.status(201).body(createdCustomer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers(){
        List<CustomerDto> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto){
        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
        customerService.removeCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
