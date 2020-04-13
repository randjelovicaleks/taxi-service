package com.taxiservice.service.impl;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.model.Dispatcher;
import com.taxiservice.repository.DispatcherRepository;
import com.taxiservice.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatcherServiceImpl implements DispatcherService {

    @Autowired
    private DispatcherRepository dispatcherRepository;

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
            dispatcher.setJmbg(dispatcherDTO.getJmbg());
            dispatcher.setAddress(dispatcherDTO.getAddress());
            dispatcher.setPhoneNumber(dispatcherDTO.getPhoneNumber());
            dispatcher.setSalary(dispatcherDTO.getSalary());
        }

        dispatcherRepository.save(dispatcher);
        return dispatcher;
    }

}
