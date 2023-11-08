package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5 , max = 30 , message = "The length of the customer should be between 5 and 30")
    @Schema(
            description = "Customer's name of ErfAn Bank" , example = "ErfAn Pezeshkpour"
    )
    private String name;

    @NotEmpty(message = "Email can not be null or empty")
    @Email(message = "Email address should be valid value")
    @Schema(
            description = "Customer's email of ErfAn Bank" , example = "erfan01724@gmail.com"
    )
    private String email;

    @Pattern(regexp = "^[0-9]{10}$" , message = "mobile number must be 10 digits")
    @Schema(
            description = "Customer's mobile number , NOTE : mobile number must be 10 digits" , example = "9301846963"
    )
    private String mobileNumber;

    @Schema(
            description = "Schema to hold accounts information"
    )
    private AccountsDto accountsDto;
}
