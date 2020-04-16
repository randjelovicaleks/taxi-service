package com.taxiservice.repository;

import com.taxiservice.model.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DriveRepository extends JpaRepository<Drive, Long> {

    List<Drive> findByDriverId(Long id);
    List<Drive> findByCustomerId(Long id);
}
