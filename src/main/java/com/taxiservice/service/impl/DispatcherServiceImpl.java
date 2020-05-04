package com.taxiservice.service.impl;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.dto.DriverDTO;
import com.taxiservice.dto.FreeDateForDriversDTO;
import com.taxiservice.model.*;
import com.taxiservice.repository.*;
import com.taxiservice.security.authority.Authority;
import com.taxiservice.security.authority.AuthorityService;
import com.taxiservice.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DispatcherServiceImpl implements DispatcherService {

    @Autowired
    private DispatcherRepository dispatcherRepository;

    @Autowired
    private DriveRepository driveRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AuthorityService authService;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TaxiServiceRepository taxiServiceRepository;

    @Override
    public Dispatcher getDispatcher(Long id) {
       return dispatcherRepository.getOne(id);
    }

    @Override
    public Dispatcher updateDispatcher(DispatcherDTO dispatcherDTO) {
        Dispatcher dispatcher = getDispatcher(dispatcherDTO.getId());

        if (dispatcher != null) {
            dispatcher.setName(dispatcherDTO.getName());
            dispatcher.setSurname(dispatcherDTO.getSurname());
            dispatcher.setAddress(dispatcherDTO.getAddress());
            dispatcher.setPhoneNumber(dispatcherDTO.getPhoneNumber());
            dispatcher.setSalary(dispatcherDTO.getSalary());
        }

        List<Authority> auth = authService.findByRole("ROLE_DISPATCHER");
        dispatcher.setAuthorities(auth);
        dispatcherRepository.save(dispatcher);
        return dispatcher;
    }

    @Override
    public Drive addDriveByPhone(Long idDispatcher, Long idDriver, DriveDTO driveDTO) {
        Dispatcher dispatcher = dispatcherRepository.getOne(idDispatcher);
        Driver driver = driverRepository.getOne(idDriver);

        Drive drive = new Drive();

        if (dispatcher != null && driver != null) {
            drive.setDispatcher(dispatcher);
            drive.setOrderDate(new Date(driveDTO.getOrderDate().getTime() - 7200 * 1000));
            drive.setStartingAddress(driveDTO.getStartingAddress());
            drive.setCustomerName(driveDTO.getCustomerName());
            drive.setDriver(driver);
            drive.setPrice(0);
        }
        driveRepository.save(drive);
        return drive;
    }

    @Override
    public List<Driver> findFreeDriver(FreeDateForDriversDTO freeDateForDriversDTO) {
        List<Driver> drivers = driverRepository.findAll();
        List<Driver> freeDrivers = new ArrayList<>();

        for (Driver driver : drivers) {
            if (driver.getDrives().isEmpty()) {
                freeDrivers.add(driver);
            }
            for (Drive drive : driver.getDrives()) {
                if (!drive.getOrderDate().equals(freeDateForDriversDTO.getFreeDate())) {
                    if (!freeDrivers.contains(driver)) {
                        freeDrivers.add(driver);
                    }
                }
            }
        }
        return freeDrivers;
    }

    @Override
    public Driver addNewDriver(DriverDTO driverDTO, Long idVehicle) {

        Vehicle vehicle = vehicleRepository.getOne(idVehicle);

        Driver driver = new Driver();
        driver.setUsername(driverDTO.getUsername());
        driver.setName(driverDTO.getName());
        driver.setSurname(driverDTO.getSurname());
        driver.setAddress(driverDTO.getAddress());
        driver.setPhoneNumber(driverDTO.getPhoneNumber());
        driver.setPhoneNumber(driverDTO.getPhoneNumber());
        driver.setSalary(driverDTO.getSalary());
        driver.setTaxiCardNumber(driverDTO.getTaxiCardNumber());
        vehicle.setDriver(driver);
        TaxiService taxiService = taxiServiceRepository.getOne(Long.valueOf(1));
        driver.setTaxiService(taxiService);

        //postavljanje passworda za drivera direktno
        driver.setPassword(passwordEncoder.encode("driver"));
        List<Authority> auth = authService.findByRole("ROLE_DRIVER");
        driver.setAuthorities(auth);
        driverRepository.save(driver);
        return driver;
    }

}
