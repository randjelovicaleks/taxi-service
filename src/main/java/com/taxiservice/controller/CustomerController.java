package com.taxiservice.controller;

import com.taxiservice.dto.CustomerDTO;
import com.taxiservice.model.Customer;
import com.taxiservice.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(new CustomerDTO(customer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer c : customers) {
            customerDTOS.add(new CustomerDTO(c));
        }

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);

    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.updateCustomer(customerDTO);

        if (customer != null) {
            return new ResponseEntity<>(new CustomerDTO(customer), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.removeCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
