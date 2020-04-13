package com.taxiservice.repository;

import com.taxiservice.model.TaxiService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiServiceRepository extends JpaRepository<TaxiService, Long> {
}
