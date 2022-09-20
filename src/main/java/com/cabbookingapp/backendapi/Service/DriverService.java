package com.cabbookingapp.backendapi.Service;

import com.cabbookingapp.backendapi.Exception.DriverGenerationException;
import com.cabbookingapp.backendapi.Exception.DriverNotFoundException;
import com.cabbookingapp.backendapi.Model.Driver;
import com.cabbookingapp.backendapi.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver addDriver(Driver driver) throws DriverGenerationException
    {
        if(driver.getName() == null || driver.getGender() == null || driver.getAge() <=0 || driver.getCar() == null ||
                driver.getModel() == null || driver.getXcord() < 0 || driver.getYcord() < 0)
            throw new DriverGenerationException("Fields cannot be empty or no negative values!");

        driverRepository.findDriverByName(driver.getName())
                .ifPresent(d -> {
                    throw new DriverGenerationException("Driver already exists!");
                });
        driver.setAvailable(true);
        return driverRepository.save(driver);
    }

    public List<Driver> findAllDrivers(){
        return driverRepository.findAll();
    }

    public Driver findDriverById(Long id)
    {
        return driverRepository.findDriverById(id).orElseThrow(() -> new DriverNotFoundException("Driver with id: "+id+" not found!"));
    }

    public Driver updateDriverAvailability(Driver driver)
    {
        driverRepository.findDriverById(driver.getId()).orElseThrow(() ->
                new DriverNotFoundException("Driver with id: "+driver.getId()+" doesnt exists!"));
        driver.setAvailable(true);
        return driverRepository.save(driver);
    }
}
