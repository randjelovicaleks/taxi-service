package com.taxiservice.service;

import com.taxiservice.dto.DispatcherDTO;
import com.taxiservice.model.Dispatcher;

public interface DispatcherService {

    Dispatcher getDispatcher(Long id);

    Dispatcher updateDispatcher(DispatcherDTO dispatcherDTO);
}
