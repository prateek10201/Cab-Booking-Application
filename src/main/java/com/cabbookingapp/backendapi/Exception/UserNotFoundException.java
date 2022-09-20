package com.cabbookingapp.backendapi.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String msg)
    {
        super(msg);
    }
}
