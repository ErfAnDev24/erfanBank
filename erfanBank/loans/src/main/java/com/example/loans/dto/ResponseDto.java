package com.example.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Schema(
        name = "Response"
        ,description = "this is a schema for holding Response information"
)
public class ResponseDto {

    @Schema(
            description = "Http code status"
    )
    private String code;

    @Schema(
            description = "the origin message"
    )
    private String message;

}
