package com.taxiservice.service;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.dto.DriverDTO;
import com.taxiservice.dto.FreeDateForDriversDTO;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;

import java.util.List;

public interface DispatcherService {

    Dispatcher getDispatcher(Long id);
    Dispatcher updateDispatcher(DispatcherDTO dispatcherDTO);

    Drive addDriveByPhone(Long idDispatcher, Long idDriver, DriveDTO driveDTO);
    Driver addNewDriver(DriverDTO driverDTO, Long idVehicle);
    List<Driver> findFreeDriver(FreeDateForDriversDTO freeDateForDriversDTO);
}
