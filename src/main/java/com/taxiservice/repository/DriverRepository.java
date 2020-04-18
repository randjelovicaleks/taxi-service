package com.taxiservice.repository;

import com.taxiservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByUsername(String username);
}
