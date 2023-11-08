package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(
            description = "this is the API path which invoked by client"
    )
    private String apiPath;

    @Schema(
            description = "this is the Https Status Code"
    )
    private HttpStatusCode errorCode;

    @Schema(
            description = "this is for reporting what exactly happened"
    )
    private String errorMessage;

    @Schema(
            description = "This represents the time which when this error happened"
    )
    private LocalDateTime errorTime;

}
