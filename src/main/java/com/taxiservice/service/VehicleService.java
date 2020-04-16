package com.taxiservice.service;

import com.taxiservice.dto.VehicleDTO;
import com.taxiservice.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle getVehicle(Long id);
    List<Vehicle> getAllVehicles();
    Vehicle updateVehicle(VehicleDTO vehicleDTO);
    void removeVehicle(Long id);
    List<Vehicle> getAllVehicleWithoutDriver();
}
