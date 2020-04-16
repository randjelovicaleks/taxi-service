package com.taxiservice.service.impl;

import com.taxiservice.dto.CustomerDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.model.Customer;
import com.taxiservice.model.Drive;
import com.taxiservice.repository.CustomerRepository;
import com.taxiservice.repository.DriveRepository;
import com.taxiservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriveRepository driveRepository;

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

    @Override
    public Drive addDriveByApp(Long idCustomer, DriveDTO driveDTO) {
        Customer customer = customerRepository.getOne(idCustomer);
        Drive drive = new Drive();

        if (customer != null) {
            drive.setCustomer(customer);
            drive.setOrderDate(driveDTO.getOrderDate());
            drive.setStartingAddress(driveDTO.getStartingAddress());
            drive.setNote(driveDTO.getNote());
        }
        driveRepository.save(drive);
        return drive;
    }

    @Override
    public Drive updateDriveByCustomer(Long idCustomer, DriveDTO driveDTO) {
        Customer customer = customerRepository.getOne(idCustomer);
        Drive drive = driveRepository.getOne(driveDTO.getId());

        if (customer != null && drive != null) {
            drive.setStartingAddress(driveDTO.getStartingAddress());
            //drive.setOrderDate(driveDTO.getOrderDate());
            drive.setNote(driveDTO.getNote());
        }
        driveRepository.save(drive);
        return drive;
    }
}
