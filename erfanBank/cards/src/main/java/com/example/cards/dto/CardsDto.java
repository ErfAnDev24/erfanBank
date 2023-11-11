package com.example.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Cards" ,
        description = "This is a schema for holing Cards information"
)
public class CardsDto {

    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "^[0-9]{10}$",message = "Mobile number must be 10 digits")
    @Schema(
            description = "for holding mobile number" , example = "9301846963"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card number can not be null or empty")
    @Pattern(regexp = "^[0-9]{12}$" , message = "Card number must be 12 digits")
    @Schema(
            description = "for holing card number" , example = "1234566789101"
    )
    private String cardNumber;

    @NotEmpty(message = "Card number can not be null or empty")
    @Schema(description = "for holding card type" , example = "Credit card")
    private String cardType;

    @Positive(message = "Total limit must be greater than zero")
    @Schema(description = "total limit of money which you have" , example = "10000")
    private Integer totalLimit;

    @PositiveOrZero(message = "Amount used must equal zero or greater than zero")
    @Schema(description = "total amount which used by customer" , example = "9000")
    private Integer amountUsed;

    @PositiveOrZero(message = "Available amount must equal zero or greater than zero")
    @Schema(description = "total available amount which is in your card")
    private Integer availableAmount;
}
