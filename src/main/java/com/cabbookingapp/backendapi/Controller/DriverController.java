package com.cabbookingapp.backendapi.Controller;

import com.cabbookingapp.backendapi.Model.Driver;
import com.cabbookingapp.backendapi.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cabBooking")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/viewAllDrivers")
    public ResponseEntity<List<Driver>> viewAllDrivers()
    {
        List<Driver> drivers = driverService.findAllDrivers();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @GetMapping("/viewDriverById/{id}")
    public ResponseEntity<Driver> viewDriverById(@PathVariable("id") Long id)
    {
        Driver driver = driverService.findDriverById(id);
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }

    @PostMapping("/addDriver")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver)
    {
        Driver newDriver = driverService.addDriver(driver);
        return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
    }

    @PutMapping("/updateDriverAvailability")
    public ResponseEntity<Driver> updateDriverAvailability(@RequestBody Driver driver)
    {
        Driver updateDriver = driverService.updateDriverAvailability(driver);
        return new ResponseEntity<>(updateDriver, HttpStatus.OK);
    }
}
