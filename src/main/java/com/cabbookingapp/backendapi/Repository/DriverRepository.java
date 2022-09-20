package com.cabbookingapp.backendapi.Repository;

import com.cabbookingapp.backendapi.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findDriverByName(String name);
    Optional<Driver> findDriverById(Long id);
}
