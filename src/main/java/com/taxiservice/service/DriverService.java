package com.taxiservice.service;

import com.taxiservice.dto.DriverDTO;
import com.taxiservice.model.Driver;

import java.util.List;

public interface DriverService {

    Driver getDriver(Long id);
    List<Driver> getAllDrivers();
    Driver updateDraver(DriverDTO driverDTO);
    void removeDriver(Long id);
}
