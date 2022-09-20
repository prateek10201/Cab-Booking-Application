package com.cabbookingapp.backendapi.Exception;

import com.cabbookingapp.backendapi.Model.Driver;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(String msg)
    {
        super(msg);
    }
}
