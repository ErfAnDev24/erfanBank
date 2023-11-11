package com.example.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Schema(name = "Error Response"
,description = "this is a schema for holding error response information")
public class ErrorResponseDto {

    @Schema(
            description = "The API which is client is invoking"
    )
    private String apiPath;

    @Schema(
            description = "The http status code"
    )
    private HttpStatus httpStatus;

    @Schema(
            description = "the origin content of error response"
    )
    private String errorMessage;

    @Schema(
            description = "the time which error happened"
    )
    private LocalDateTime errorTime;
}
