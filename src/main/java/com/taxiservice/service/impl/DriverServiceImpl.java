package com.taxiservice.service.impl;

import com.taxiservice.dto.DriverDTO;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;
import com.taxiservice.repository.DriveRepository;
import com.taxiservice.repository.DriverRepository;
import com.taxiservice.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriveRepository driveRepository;

    @Override
    public Driver getDriver(Long id) {
        return driverRepository.getOne(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver updateDraver(DriverDTO driverDTO) {
        Driver driver = getDriver(driverDTO.getId());

        if (driver != null) {
            driver.setName(driverDTO.getName());
            driver.setSurname(driverDTO.getSurname());
            driver.setAddress(driverDTO.getAddress());
            driver.setPhoneNumber(driverDTO.getPhoneNumber());
        }

        driverRepository.save(driver);
        return driver;
    }

    @Override
    public void removeDriver(Long id) {
        driverRepository.deleteById(id);
    }

    @Override
    public Drive takeDrive(Long idDrive, Long idDriver) {
        Drive drive = driveRepository.getOne(idDrive);
        Driver driver = driverRepository.getOne(idDriver);

        if (drive.getDriver() == null && driver != null) {
            drive.setDriver(driver);
            driveRepository.save(drive);
        }

        return drive;
    }
}
