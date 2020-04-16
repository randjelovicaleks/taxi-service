package com.taxiservice.service.impl;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.dto.DriveDTO;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.model.Drive;
import com.taxiservice.model.Driver;
import com.taxiservice.repository.DispatcherRepository;
import com.taxiservice.repository.DriveRepository;
import com.taxiservice.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatcherServiceImpl implements DispatcherService {

    @Autowired
    private DispatcherRepository dispatcherRepository;

    @Autowired
    private DriveRepository driveRepository;

    @Override
    public Dispatcher getDispatcher(Long id) {
       return dispatcherRepository.getOne(id);
    }

    @Override
    public Dispatcher updateDispatcher(DispatcherDTO dispatcherDTO) {
        Dispatcher dispatcher = getDispatcher(dispatcherDTO.getId());

        if (dispatcher != null) {
            dispatcher.setName(dispatcherDTO.getName());
            dispatcher.setSurname(dispatcherDTO.getSurname());
            dispatcher.setAddress(dispatcherDTO.getAddress());
            dispatcher.setPhoneNumber(dispatcherDTO.getPhoneNumber());
            dispatcher.setSalary(dispatcherDTO.getSalary());
        }

        dispatcherRepository.save(dispatcher);
        return dispatcher;
    }

    @Override
    public Drive addDriveByPhone(Long idDispatcher, DriveDTO driveDTO) {
        Dispatcher dispatcher = dispatcherRepository.getOne(idDispatcher);

        Drive drive = new Drive();

        if (dispatcher != null) {
            drive.setDispatcher(dispatcher);
            drive.setOrderDate(driveDTO.getOrderDate());
            drive.setStartingAddress(driveDTO.getStartingAddress());
            drive.setCustomerName(driveDTO.getCustomerName());
            drive.setDriver(new Driver(driveDTO.getDriverDTO()));
        }
        driveRepository.save(drive);
        return drive;
    }


}
