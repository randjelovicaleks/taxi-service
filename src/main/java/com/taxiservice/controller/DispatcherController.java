package com.taxiservice.controller;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.model.Drive;
import com.taxiservice.service.impl.DispatcherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/dispatcher")
public class DispatcherController {

    @Autowired
    DispatcherServiceImpl dispatcherService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DispatcherDTO> getDispatcher(@PathVariable Long id) {
        Dispatcher dispatcher = dispatcherService.getDispatcher(id);
        return new ResponseEntity<>(new DispatcherDTO(dispatcher),HttpStatus.OK);
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DispatcherDTO> updateDispatcher(@RequestBody DispatcherDTO dispatcherDTO) {
        Dispatcher dispatcher = dispatcherService.updateDispatcher(dispatcherDTO);

        if (dispatcher != null ) {
            return new ResponseEntity<>(new DispatcherDTO(dispatcher), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/create/{idDispatcher}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DriveDTO> addDriveByPhone(@PathVariable Long idDispatcher, @RequestBody DriveDTO driveDTO) {
        Drive drive = dispatcherService.addDriveByPhone(idDispatcher, driveDTO);

        if (drive != null) {
            return new ResponseEntity<>(new DriveDTO(drive), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
