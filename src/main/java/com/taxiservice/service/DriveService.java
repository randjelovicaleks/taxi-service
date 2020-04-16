package com.taxiservice.service;

import com.taxiservice.model.Drive;

import java.util.List;

public interface DriveService {

    Drive getDrive(Long id);
    List<Drive> getAllDrives();
    List<Drive> getAllDrivesForDriver(Long idDriver);
    List<Drive> getAllDrivesForCustomer(Long idCustomer);
    List<Drive> getAllDrivesByApp();
}
