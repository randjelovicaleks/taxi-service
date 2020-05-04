package com.taxiservice.service.impl;

import com.taxiservice.model.Drive;
import com.taxiservice.repository.DriveRepository;
import com.taxiservice.service.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Drive> drives = driveRepository.findByDriverId(idDriver);
        List<Drive> driveForDriver = new ArrayList<>();

        for (Drive d : drives) {
            if (d.getCustomer() != null || d.getDriver() != null || d.getDispatcher() != null) {
                driveForDriver.add(d);
            }
        }
        return driveForDriver;
    }

    @Override
    public List<Drive> getAllDrivesForCustomer(Long idCustomer) {
        List<Drive> driveForCustomer = driveRepository.findByCustomerId(idCustomer);
        List<Drive> driveForCustomerWithoutDriver = new ArrayList<>();

        for (Drive d : driveForCustomer) {
            if (d.getDriver() == null) {
                driveForCustomerWithoutDriver.add(d);
            }
        }
        return driveForCustomerWithoutDriver;
    }

    @Override
    public List<Drive> getAllDrivesByApp() {
        List<Drive> drives = driveRepository.findAll();
        List<Drive> drivesByApp = new ArrayList<>();

        for (Drive d : drives) {
            if (d.getCustomer() != null && d.getDriver() != null) {
                drivesByApp.add(d);
            } else if (d.getCustomer() != null && d.getDriver() == null) {
                drivesByApp.add(d);
            }
        }
        return  drivesByApp;
    }

    @Override
    public List<Drive> getAllDrivesByPhone() {
        List<Drive> drives =  driveRepository.findAll();
        List<Drive> drivesByPhone = new ArrayList<>();

        for (Drive d : drives) {
            if (d.getCustomer() == null && d.getDriver() != null && d.getDispatcher() != null) {
                drivesByPhone.add(d);
            }
        }
        return drivesByPhone;
    }

    @Override
    public List<Drive> getAllDrivesByAppWithDriver() {
        List<Drive> drives =  driveRepository.findAll();
        List<Drive> drivesWithDriver = new ArrayList<>();

        for (Drive d : drives) {
            if (d.getCustomer() != null && d.getDriver() != null) {
                drivesWithDriver.add(d);
            }
        }
        return drivesWithDriver;
    }

    @Override
    public List<Drive> getAllDrivesByAppWithoutDriver() {
        List<Drive> drives = driveRepository.findAll();
        List<Drive> drivesWithoutDriver = new ArrayList<>();

        for (Drive d : drives) {
            if (d.getCustomer() != null && d.getDriver() == null) {
                drivesWithoutDriver.add(d);
            }
        }
        return  drivesWithoutDriver;
    }
}
