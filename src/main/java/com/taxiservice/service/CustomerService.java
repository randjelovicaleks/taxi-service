package com.taxiservice.service;

import com.taxiservice.dto.CustomerDTO;
import com.taxiservice.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(CustomerDTO customerDTO);
    void removeCustomer(Long id);
}
