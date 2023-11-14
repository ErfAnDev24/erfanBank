package com.example.accounts.dto;

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
        name = "Loans",
        description = "this is a schema for holding Loans information"
)
public class LoansDto {

    @NotEmpty(message = "Mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "this is a field for holding mobile number" , example = "9301846963"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number must be 10 digits")
    @Schema(
            description = "This is a field for holding the loan number" , example = "123456789101"
    )
    private String loanNumber;

    @NotEmpty(message = "Loan type number can not be null or empty")
    @Schema(
            description = "This is a field for holding the loan type" , example = "Home loan"
    )
    private String loanType;

    @Positive(message = "Total loan must be greater than zero")
    @Schema(
            description = "This is a field for holding the total loan" , example = "1000000"
    )
    private Integer totalLoan;

    @PositiveOrZero(message = "Amount paid must be zero or greater than zero")
    @Schema(
            description = "This is a field for holding the amount paid" , example = "124254"
    )
    private Integer amountPaid;

    @PositiveOrZero(message = "Outstanding amount must be zero or greater than zero")
    @Schema(
            description = "This is a field for holding the amount outstanding amount" , example = "34000"
    )
    private Integer outstandingAmount;

}