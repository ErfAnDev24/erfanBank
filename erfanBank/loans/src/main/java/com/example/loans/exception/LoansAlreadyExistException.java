package com.example.loans.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@AllArgsConstructor
public class LoansAlreadyExistException extends RuntimeException{

    public LoansAlreadyExistException(String message){
        super(message);
    }
}
