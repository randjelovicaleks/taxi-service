package com.taxiservice.controller;

import com.taxiservice.dto.VehicleDTO;
import com.taxiservice.model.Vehicle;
import com.taxiservice.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicle(id);

        if (vehicle != null) {
            return new ResponseEntity<>(new VehicleDTO(vehicle), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

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

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleService.updateVehicle(vehicleDTO);

        if (vehicle != null) {
            return new ResponseEntity<>(new VehicleDTO(vehicle), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.removeVehicle(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/without/driver")
    public ResponseEntity<List<VehicleDTO>> getAllVehicleWithoutDriver() {
        List<Vehicle> vehicles = vehicleService.getAllVehicleWithoutDriver();
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();

        for (Vehicle v : vehicles) {
            vehicleDTOS.add(new VehicleDTO(v));
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
