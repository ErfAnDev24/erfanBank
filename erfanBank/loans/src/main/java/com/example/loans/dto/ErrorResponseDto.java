package com.example.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Schema(
        name = "Error Response"
        ,description = "This is a schema for holding Error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "This is the API which our client is invoking"
    )
    private String apiPath;

    @Schema(
            description = "This is for recording http status code"
    )
    private HttpStatus httpStatus;

    @Schema(
            description = "This is for holding message details"
    )
    private String errorMessage;

    @Schema(
            description = "This is for our Local Date time"
    )
    private LocalDateTime localDateTime;

}
