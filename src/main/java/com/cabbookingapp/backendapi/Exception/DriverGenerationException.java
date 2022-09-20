package com.cabbookingapp.backendapi.Exception;

import com.cabbookingapp.backendapi.Repository.DriverRepository;

public class DriverGenerationException extends RuntimeException{
    public DriverGenerationException(String msg)
    {
        super(msg);
    }
}
