package com.taxiservice.service.impl;

import com.taxiservice.model.Drive;
import com.taxiservice.repository.DriveRepository;
import com.taxiservice.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveServiceImpl implements DriveService {

    @Autowired
    private DriveRepository driveRepository;

    @Override
    public Drive getDrive(Long id) {
        return driveRepository.getOne(id);
    }

    @Override
    public List<Drive> getAllDrives() {
        return driveRepository.findAll();
    }

    @Override
    public List<Drive> getAllDrivesForDriver(Long idDriver) {
        return driveRepository.findByDriverId(idDriver);
    }
}
