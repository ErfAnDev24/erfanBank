package com.example.accounts.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String recourceName , String fieldName , String fieldValue){
        super(String.format("%s not found with the given input data %s : %s",recourceName , fieldName , fieldValue));
    }

}
