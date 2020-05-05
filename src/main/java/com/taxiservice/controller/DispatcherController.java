package com.taxiservice.controller;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.dto.DriverDTO;
import com.taxiservice.dto.FreeDateForDriversDTO;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;
import com.taxiservice.service.impl.DispatcherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/dispatcher")
public class DispatcherController {

    @Autowired
    private DispatcherServiceImpl dispatcherService;

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<DispatcherDTO> getDispatcher(@PathVariable Long id) {
        Dispatcher dispatcher = dispatcherService.getDispatcher(id);
        return new ResponseEntity<>(new DispatcherDTO(dispatcher),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DispatcherDTO> updateDispatcher(@RequestBody DispatcherDTO dispatcherDTO) {
        Dispatcher dispatcher = dispatcherService.updateDispatcher(dispatcherDTO);

        if (dispatcher != null ) {
            return new ResponseEntity<>(new DispatcherDTO(dispatcher), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @PostMapping(value = "/create/{idDispatcher}/{idDriver}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DriveDTO> addDriveByPhone(@PathVariable Long idDispatcher, @PathVariable Long idDriver,
                                                    @RequestBody DriveDTO driveDTO) {
        Drive drive = dispatcherService.addDriveByPhone(idDispatcher, idDriver, driveDTO);

        if (drive != null) {
            return new ResponseEntity<>(new DriveDTO(drive), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @PostMapping(value = "/find/free/drivers", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<DriverDTO>> findFreeDrivers(@RequestBody FreeDateForDriversDTO freeDateForDriversDTO) {
        List<Driver> drivers = dispatcherService.findFreeDriver(freeDateForDriversDTO);
        List<DriverDTO> driverDTOS = new ArrayList<>();

        if (drivers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        for (Driver d : drivers) {
            driverDTOS.add(new DriverDTO(d));
        }

        return new ResponseEntity<>(driverDTOS, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @PostMapping(value = "/create/driver/{idVehicle}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DriverDTO> addNewDriver(@RequestBody DriverDTO driverDTO, @PathVariable Long idVehicle) {
        Driver driver = dispatcherService.addNewDriver(driverDTO, idVehicle);

        if (driver != null) {
            return new ResponseEntity<>(new DriverDTO(driver), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
