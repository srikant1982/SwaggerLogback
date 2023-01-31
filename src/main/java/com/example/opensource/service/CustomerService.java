package com.example.opensource.service;

import com.example.opensource.entity.Customer;
import com.example.opensource.view.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer customerId);
    Customer saveCustomer(CustomerRequest customerRequest);
}
