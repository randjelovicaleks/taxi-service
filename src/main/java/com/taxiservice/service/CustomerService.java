package com.taxiservice.service;

import com.taxiservice.dto.CustomerDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.model.Customer;
import com.taxiservice.model.Drive;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(CustomerDTO customerDTO);
    void removeCustomer(Long id);
    Drive addDriveByApp(Long idCustomer, DriveDTO driveDTO);
    Drive updateDriveByCustomer(Long idCustomer, DriveDTO driveDTO);
}
