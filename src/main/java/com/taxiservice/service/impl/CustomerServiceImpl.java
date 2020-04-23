package com.taxiservice.service.impl;

import com.taxiservice.dto.CustomerDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.model.Customer;
import com.taxiservice.model.Drive;
import com.taxiservice.model.TaxiService;
import com.taxiservice.repository.CustomerRepository;
import com.taxiservice.repository.DriveRepository;
import com.taxiservice.repository.TaxiServiceRepository;
import com.taxiservice.security.authority.Authority;
import com.taxiservice.security.authority.AuthorityService;
import com.taxiservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriveRepository driveRepository;

    @Autowired
    private TaxiServiceRepository taxiServiceRepository;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Customer save(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        List<Authority> auth = authService.findByRole("ROLE_CUSTOMER");
        customer.setAuthorities(auth);
        TaxiService taxiService = taxiServiceRepository.getOne(Long.valueOf(1));
        customer.setTaxiService(taxiService);
        return customerRepository.save(customer);
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
        List<Authority> auth = authService.findByRole("ROLE_CUSTOMER");
        customer.setAuthorities(auth);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void removeCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Drive addDriveByApp(Long idCustomer, DriveDTO driveDTO) {
        Customer customer = customerRepository.getOne(idCustomer);
        Drive drive = new Drive();

        if (customer != null) {
            drive.setCustomer(customer);
            drive.setOrderDate(driveDTO.getOrderDate());
            drive.setStartingAddress(driveDTO.getStartingAddress());
            drive.setNote(driveDTO.getNote());
            drive.setPrice(0);
        }
        driveRepository.save(drive);
        return drive;
    }

    @Override
    public Drive updateDriveByCustomer(Long idCustomer, DriveDTO driveDTO) {
        Customer customer = customerRepository.getOne(idCustomer);
        Drive drive = driveRepository.getOne(driveDTO.getId());

        if (customer != null && drive != null && drive.getDriver() == null) {
            drive.setStartingAddress(driveDTO.getStartingAddress());
            drive.setOrderDate(driveDTO.getOrderDate());
            drive.setNote(driveDTO.getNote());
        }
        driveRepository.save(drive);
        return drive;
    }

}
