package com.example.opensource.controller;


import com.example.opensource.entity.Customer;
import com.example.opensource.service.CustomerService;
import com.example.opensource.view.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        LOGGER.trace("TRACE Log");
        LOGGER.debug("DEBUG Log");
        LOGGER.info("An INFO Log");
        LOGGER.warn("A WARN Log");
        LOGGER.error("An ERROR Log");
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.ok(this.customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerRequest customerRequest){
        return ResponseEntity.ok(this.customerService.saveCustomer(customerRequest));
    }
}

