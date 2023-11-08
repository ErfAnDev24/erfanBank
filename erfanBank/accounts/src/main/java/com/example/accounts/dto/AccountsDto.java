package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Accounts information"
)
public class AccountsDto {

    @NotEmpty(message = "Account number can not be null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account number of ErfAn Bank account" , example = "3454433243"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account type can not be null or empty")
    @Schema(
            description = "Account type of ErfAn Bank account" , example = "Saving"
    )
    private String accountType;

    @NotEmpty(message = "branch address can not be null or empty")
    @Schema(
            description = "branch Address of ErfAn Bank" , example = "Vanak sqare,123th street"
    )
    private String branchAddress;

}
