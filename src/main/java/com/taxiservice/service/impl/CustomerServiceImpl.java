package com.taxiservice.service.impl;

import com.taxiservice.dto.CustomerDTO;
import com.taxiservice.model.Customer;
import com.taxiservice.repository.CustomerRepository;
import com.taxiservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {
        Customer customer = getCustomer(customerDTO.getId());

        if (customer != null) {
            customer.setName(customerDTO.getName());
            customer.setSurname(customerDTO.getSurname());
            customer.setAddress(customerDTO.getAddress());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
        }
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void removeCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
