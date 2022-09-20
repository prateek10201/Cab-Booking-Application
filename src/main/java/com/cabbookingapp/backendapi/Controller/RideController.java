package com.cabbookingapp.backendapi.Controller;

import com.cabbookingapp.backendapi.Model.Ride;
import com.cabbookingapp.backendapi.Service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cabBooking")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/findRide")
    public ResponseEntity<String> findRide(@RequestBody Ride ride)
    {
        String response = rideService.findRide(ride);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
