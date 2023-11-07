package com.example.cards.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName , String fieldName , String valueName){
        super(String.format("%s not found with the given input %s : s%",resourceName,fieldName,valueName));
    }
}
