package com.cabbookingapp.backendapi.Exception;

import com.cabbookingapp.backendapi.Model.User;

public class UserGenderException extends RuntimeException{
    public UserGenderException(String msg){
        super(msg);
    }
}
