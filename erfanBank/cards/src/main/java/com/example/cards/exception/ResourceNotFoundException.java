package com.example.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName , String fieldName , String valueName){
        super(String.format("%s not found with the given input %s : %s",resourceName,fieldName,valueName));
    }
}
