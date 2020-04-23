package com.taxiservice.service;

import com.taxiservice.dto.DriverDTO;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;

import java.util.List;

public interface DriverService {

    Driver getDriver(Long id);
    List<Driver> getAllDrivers();
    Driver updateDriver(DriverDTO driverDTO);
    void removeDriver(Long id);
    Drive takeDrive(Long idDrive, Long idDriver);
    void calculatePriceForDriver(Long idDriver, Long idDrive, double kilometers);
}
