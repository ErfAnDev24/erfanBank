package com.example.accounts.service.client;

import com.example.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards" , fallback = CardsFallBack.class)
public interface CardsFeignClient {
    @GetMapping(value = "/api/fetch" , consumes = "application/json")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader("erfanbank_correlation_id") String correlationId, @RequestParam String mobileNumber);
}
