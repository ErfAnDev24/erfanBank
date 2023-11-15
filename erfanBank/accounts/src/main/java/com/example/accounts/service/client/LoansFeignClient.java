package com.example.accounts.service.client;

import com.example.accounts.dto.LoansDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loans" , fallback = LoansFallBack.class)
public interface LoansFeignClient {
    @RequestMapping(value = "/api/fetch" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoansDto> fetchLoan(@RequestHeader("erfanbank_correlation_id") String correlationId , @RequestParam String mobileNumber);

    }
