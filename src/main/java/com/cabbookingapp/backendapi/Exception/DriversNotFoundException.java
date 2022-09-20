package com.cabbookingapp.backendapi.Exception;

public class DriversNotFoundException extends RuntimeException{
    public DriversNotFoundException(String msg)
    {
        super(msg);
    }
}
