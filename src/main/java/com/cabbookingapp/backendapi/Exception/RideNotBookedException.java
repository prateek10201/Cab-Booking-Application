package com.cabbookingapp.backendapi.Exception;

import com.cabbookingapp.backendapi.Model.Ride;

public class RideNotBookedException extends RuntimeException{
    public RideNotBookedException(String msg){
        super(msg);
    }
}
