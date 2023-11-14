package com.example.accounts.controller;

import com.example.accounts.dto.CustomerDetailsDto;
import com.example.accounts.service.ICustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "fetch API for Customer details in ErfAnBank"
        ,description = "fetch API for fetching customer details")
@RestController
@RequestMapping(value = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    ICustomerService iCustomerService;
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@Valid @RequestParam @Pattern(regexp = "^[0-9]{10}$" , message = "mobile number must be 10 digits")
                                                                    String mobileNumber){
        CustomerDetailsDto customerDetailsDto = iCustomerService.fetchCustomerDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerDetailsDto);
    }

}
