package com.taxiservice.controller;

import com.taxiservice.dto.DriveDTO;
import com.taxiservice.model.Drive;
import com.taxiservice.service.impl.DriveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/drive")
public class DriveController {

    @Autowired
    private DriveServiceImpl driveService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriveDTO> getDrive(@PathVariable Long id) {
        Drive drive = driveService.getDrive(id);

        if (drive != null) {
            return new ResponseEntity<>(new DriveDTO(drive), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/driver/{idDriver}")
    public ResponseEntity<List<DriveDTO>> getDriveForDriver(@PathVariable Long idDriver) {
        List<Drive> drives = driveService.getAllDrivesForDriver(idDriver);
        List<DriveDTO> driveDTOS = new ArrayList<>();

        for (Drive d : drives) {
            driveDTOS.add(new DriveDTO(d));
        }

        if (driveDTOS != null) {
            return new ResponseEntity<>(driveDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/customer/{idCustomer}")
    public ResponseEntity<List<DriveDTO>> getDriveForCustomer(@PathVariable Long idCustomer) {
        List<Drive> drives = driveService.getAllDrivesForCustomer(idCustomer);
        List<DriveDTO> driveDTOS = new ArrayList<>();

        for (Drive d : drives) {
            driveDTOS.add(new DriveDTO(d));
        }

        if (driveDTOS != null) {
            return new ResponseEntity<>(driveDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DRIVER')")
    @GetMapping(value = "/all/without/driver")
    public ResponseEntity<List<DriveDTO>> getAllDrivesByApp() {
        List<Drive> drives = driveService.getAllDrivesByApp();
        List<DriveDTO> driveDTOS = new ArrayList<>();

        for (Drive d : drives) {
            driveDTOS.add(new DriveDTO(d));
        }

        if (driveDTOS != null) {
            return new ResponseEntity<>(driveDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @GetMapping(value = "/all/phone")
    public ResponseEntity<List<DriveDTO>> getAllDrivesByPhone() {
        List<Drive> drives = driveService.getAllDrivesByPhone();
        List<DriveDTO> driveDTOS = new ArrayList<>();

        for (Drive d : drives) {
            driveDTOS.add(new DriveDTO(d));
        }

        if (driveDTOS != null) {
            return new ResponseEntity<>(driveDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_DISPATCHER')")
    @GetMapping(value = "/all/with/driver")
    public ResponseEntity<List<DriveDTO>> getAllDrivesByAppWithDriver() {
        List<Drive> drives = driveService.getAllDrivesByAppWithDriver();
        List<DriveDTO> driveDTOS = new ArrayList<>();

        for (Drive d : drives) {
            driveDTOS.add(new DriveDTO(d));
        }

        if (driveDTOS != null) {
            return new ResponseEntity<>(driveDTOS, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
