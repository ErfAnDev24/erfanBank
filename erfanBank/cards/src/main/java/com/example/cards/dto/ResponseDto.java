package com.example.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String statusCode;
    private String statusMessage;

}
