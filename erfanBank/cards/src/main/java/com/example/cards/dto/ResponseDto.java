package com.example.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@Schema(
        name = "Response"
        ,description = "A schema for holding response information"
)
public class ResponseDto {
    @Schema(
            description = "A field for holding status code"
    )
    private String statusCode;

    @Schema(
            description = "A field for holing status message"
    )
    private String statusMessage;

}
