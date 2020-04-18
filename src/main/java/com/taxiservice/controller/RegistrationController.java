package com.taxiservice.controller;

import com.taxiservice.dto.CustomerDTO;
import com.taxiservice.model.Customer;
import com.taxiservice.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/registration")
public class RegistrationController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CustomerDTO> registracija(@RequestBody CustomerDTO customerDTO) {

        Customer existingCustomer = customerService.findByUsername(customerDTO.getUsername());

        if (existingCustomer != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = new Customer(customerDTO);

        if (customer != null) {
            customerService.save(customer);
            return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}


