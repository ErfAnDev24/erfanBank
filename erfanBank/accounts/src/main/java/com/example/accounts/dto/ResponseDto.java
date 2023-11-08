package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response"
        ,description = "Schema to hold Response information"
)
public class ResponseDto {
    @Schema(
            description = "This represents the HttpStatus code"
    )
    private String statusCode;
    @Schema(
            description = "This one has the message and the origin content of response"
    )
    private String statusMsg;
}
