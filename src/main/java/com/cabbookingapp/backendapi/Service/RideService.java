package com.cabbookingapp.backendapi.Service;

import com.cabbookingapp.backendapi.Exception.DriverGenerationException;
import com.cabbookingapp.backendapi.Exception.DriversNotFoundException;
import com.cabbookingapp.backendapi.Exception.RideNotBookedException;
import com.cabbookingapp.backendapi.Exception.UserNotFoundException;
import com.cabbookingapp.backendapi.Model.Driver;
import com.cabbookingapp.backendapi.Model.Ride;
import com.cabbookingapp.backendapi.Repository.DriverRepository;
import com.cabbookingapp.backendapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RideService {

    @Autowired
    private DriverRepository  driverRepository;

    @Autowired
    private UserRepository userRepository;

    private static Integer MAX_DISTANCE = 4;

    public String findRide(Ride ride)
    {
        if(ride.getName() == null || ride.getSourcexcord() < 0 || ride.getSourceycord() < 0
           || ride.getDestxcord() < 0 || ride.getDestycord() < 0)
            throw new DriverGenerationException("Fields cannot be empty nor negative!");

        userRepository.findUserByName(ride.getName())
                .orElseThrow(() -> new UserNotFoundException("User with "+ride.getName()+"doesn't exists!"));

        List<Driver> driversList = getAllAvailableDrivers(ride.getSourcexcord(), ride.getSourceycord());
        if(driversList.isEmpty())
        {
            return "No Ride Found!";
        }

        driversList.get(0).setAvailable(false);
        String result = driversList.get(0).getName();

        return result;
    }

    private List<Driver> getAllAvailableDrivers(int sourcexcord, int sourceycord) {
        List<Driver> driversList = driverRepository.findAll();
        List<Driver> reqDriverList = new ArrayList<Driver>();
        Map<Long, Driver> driverMap = new HashMap<Long, Driver>();

        for(Driver d : driversList)
        {
            driverMap.put(d.getId(), d);
        }

        for(Driver driver : driverMap.values()){
            if(driver.isAvailable() && distance(driver.getXcord(), driver.getYcord(), sourcexcord, sourceycord) <= MAX_DISTANCE)
                reqDriverList.add(driver);
        }

        return reqDriverList;
    }

    private Integer distance(int xcord, int ycord, int sourcexcord, int sourceycord) {
        return Math.abs(xcord - sourcexcord) + Math.abs(ycord - sourcexcord);
    }
}
