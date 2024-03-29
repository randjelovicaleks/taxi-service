package com.taxiservice.controller;

import com.taxiservice.dto.DriveDTO;
import com.taxiservice.dto.DriverDTO;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;
import com.taxiservice.service.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/driver")
public class DriverController {

    @Autowired
    private DriverServiceImpl driverService;

    @PreAuthorize("hasRole('ROLE_DRIVER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> getDriver(@PathVariable Long id) {
        Driver driver = driverService.getDriver(id);
        return new ResponseEntity<>(new DriverDTO(driver), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @GetMapping
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        List<DriverDTO> driverDTOS = new ArrayList<>();

        for (Driver d : drivers) {
            driverDTOS.add(new DriverDTO(d));
        }

        return new ResponseEntity<>(driverDTOS, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DRIVER') or hasRole('ROLE_DISPATCHER')")
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<DriverDTO> updateDriver(@RequestBody DriverDTO driverDTO) {
        Driver driver = driverService.updateDriver(driverDTO);

        if (driver != null) {
            return new ResponseEntity<>(new DriverDTO(driver), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DRIVER')")
    @PutMapping(value = "{idDriver}/drive/{idDrive}")
    public ResponseEntity<DriveDTO> takeDrive(@PathVariable Long idDrive, @PathVariable Long idDriver) {
        Drive drive = driverService.takeDrive(idDrive, idDriver);

        if (drive != null) {
            return new ResponseEntity<>(new DriveDTO(drive), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DRIVER')")
    @PutMapping(value = "{idDriver}/drive/{idDrive}/{kilometers}")
    public ResponseEntity<?> calculatePriceForDriver(@PathVariable Long idDriver, @PathVariable Long idDrive,
                                                     @PathVariable double kilometers) {
        driverService.calculatePriceForDriver(idDriver, idDrive, kilometers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
