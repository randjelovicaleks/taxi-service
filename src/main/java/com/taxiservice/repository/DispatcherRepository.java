package com.taxiservice.repository;

import com.taxiservice.model.Dispatcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatcherRepository extends JpaRepository<Dispatcher, Long> {
    Dispatcher findByUsername(String username);
}
