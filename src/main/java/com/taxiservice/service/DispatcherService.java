package com.taxiservice.service;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.model.Drive;

public interface DispatcherService {

    Dispatcher getDispatcher(Long id);
    Dispatcher updateDispatcher(DispatcherDTO dispatcherDTO);

    Drive addDriveByPhone(Long idDispatcher, DriveDTO driveDTO);
}
