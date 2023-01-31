package com.example.opensource.service;

import com.example.opensource.entity.Address;
import com.example.opensource.entity.Customer;
import com.example.opensource.repository.CustomerRepository;
import com.example.opensource.view.CustomerRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    private static final Logger LOGGER  = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        LOGGER.trace("TRACE Log from service");
        LOGGER.debug("DEBUG Log from service");
        LOGGER.info("An INFO Log from service");
        LOGGER.warn("A WARN Log from service");
        LOGGER.error("An ERROR Log from service");
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> optional = this.customerRepository.findById(customerId);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Customer saveCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setFirstname(customerRequest.getFirstname());
        customer.setLastname(customerRequest.getLastname());
        customer.setGender(customerRequest.getGender());
        customer.setBirthday(customerRequest.getBirthday());

        Address address = new Address();
        address.setCity(customerRequest.getCity());
        address.setStreet(customerRequest.getStreet());
        address.setZipcode(customerRequest.getZipcode());

        // set address to customer and vice verse
        customer.setAddress(address);
        address.setCustomer(customer);

        return this.customerRepository.save(customer);
    }
}
