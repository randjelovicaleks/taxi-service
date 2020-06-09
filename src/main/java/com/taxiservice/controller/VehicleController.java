package com.taxiservice.controller;

import com.taxiservice.dto.VehicleDTO;
import com.taxiservice.model.Vehicle;
import com.taxiservice.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicle(id);

        if (vehicle != null) {
            return new ResponseEntity<>(new VehicleDTO(vehicle), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();

        for (Vehicle v : vehicles) {
            vehicleDTOS.add(new VehicleDTO(v));
        }

        if (vehicleDTOS != null) {
            return new ResponseEntity<>(vehicleDTOS, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<VehicleDTO> addNewVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.addNewVehicle(vehicleDTO);

        if (vehicle != null) {
            return new ResponseEntity<>(new VehicleDTO(vehicle), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.updateVehicle(vehicleDTO);

        if (vehicle != null) {
            return new ResponseEntity<>(new VehicleDTO(vehicle), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @GetMapping(value = "/without/driver")
    public ResponseEntity<List<VehicleDTO>> getAllVehicleWithoutDriver() {
        List<Vehicle> vehicles = vehicleService.getAllVehiclesWithoutDriver();
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();

        for (Vehicle v : vehicles) {
            vehicleDTOS.add(new VehicleDTO(v));
        }
        return  new ResponseEntity<>(vehicleDTOS,HttpStatus.OK);
    }
}
