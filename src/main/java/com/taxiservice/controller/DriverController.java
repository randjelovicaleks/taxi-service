package com.taxiservice.controller;

import com.taxiservice.dto.DriveDTO;
import com.taxiservice.dto.DriverDTO;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;
import com.taxiservice.service.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/driver")
public class DriverController {

    @Autowired
    private DriverServiceImpl driverService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> getDriver(@PathVariable Long id) {
        Driver driver = driverService.getDriver(id);
        return new ResponseEntity<>(new DriverDTO(driver), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        List<DriverDTO> driverDTOS = new ArrayList<>();

        for (Driver d : drivers) {
            driverDTOS.add(new DriverDTO(d));
        }

        return new ResponseEntity<>(driverDTOS, HttpStatus.OK);
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DriverDTO> updateDriver(@RequestBody DriverDTO driverDTO) {
        Driver driver = driverService.updateDraver(driverDTO);

        if (driver != null) {
            return new ResponseEntity<>(new DriverDTO(driver), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long id) {
        driverService.removeDriver(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "take/drive/{idDrive}/{idDriver}")
    public ResponseEntity<DriveDTO> takeDrive(@PathVariable Long idDrive, @PathVariable Long idDriver) {
        Drive drive = driverService.takeDrive(idDrive, idDriver);

        if (drive != null) {
            return new ResponseEntity<>(new DriveDTO(drive), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
