package com.example.cards.dto;

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
public class CardsDto {

    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "^[0-9]{10}$",message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card number can not be null or empty")
    @Pattern(regexp = "^[0-9]{12}$" , message = "Card number must be 12 digits")
    private String cardNumber;

    @NotEmpty(message = "Card number can not be null or empty")
    private String cardType;

    @Positive(message = "Total limit must be greater than zero")
    private Integer totalLimit;

    @PositiveOrZero(message = "Amount used must equal zero or greater than zero")
    private Integer amountUsed;

    @PositiveOrZero(message = "Available amount must equal zero or greater than zero")
    private Integer availableAmount;
}
