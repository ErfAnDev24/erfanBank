package com.example.getwayserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GatewayFallBackCircuitBreaker {

    @GetMapping("/contactSupport")
    public Mono<String> contactSupport(){
        return Mono.just("please attempt after a while or contact dev team");
    }
}
