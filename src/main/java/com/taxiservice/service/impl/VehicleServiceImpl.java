package com.taxiservice.service.impl;

import com.taxiservice.dto.VehicleDTO;
import com.taxiservice.model.TaxiService;
import com.taxiservice.model.Vehicle;
import com.taxiservice.repository.TaxiServiceRepository;
import com.taxiservice.repository.VehicleRepository;
import com.taxiservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private TaxiServiceRepository taxiServiceRepository;

    @Override
    public Vehicle getVehicle(Long id) {
        return vehicleRepository.getOne(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle addNewVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();

        if (vehicle != null) {
            vehicle.setId(vehicleDTO.getId());
            vehicle.setModel(vehicleDTO.getModel());
            vehicle.setManufacturer(vehicleDTO.getManufacturer());
            vehicle.setFirstRegistration(vehicleDTO.getFirstRegistration());
            vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
            vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
            TaxiService taxiService = taxiServiceRepository.getOne(Long.valueOf(1));
            vehicle.setTaxiService(taxiService);
        }
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = getVehicle(vehicleDTO.getId());

        if (vehicle != null) {
            vehicle.setModel(vehicleDTO.getModel());
            vehicle.setManufacturer(vehicleDTO.getManufacturer());
            vehicle.setFirstRegistration(vehicleDTO.getFirstRegistration());
            vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
            vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
        }

        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehiclesWithoutDriver() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<Vehicle> vehiclesWithoutDriver = new ArrayList<>();

        for (Vehicle v : vehicles) {
            if (v.getDriver() == null) {
                vehiclesWithoutDriver.add(v);
            }
        }
        return vehiclesWithoutDriver;
    }

}
