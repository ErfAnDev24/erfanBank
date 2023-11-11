package com.example.loans.controller;

import com.example.loans.constants.LoansConstants;
import com.example.loans.dto.LoansDto;
import com.example.loans.dto.ResponseDto;
import com.example.loans.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api" ,produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Loans REST APIs"
,description = "these are the APIs which are implemented for CRUD operations in Loans microservice")
public class LoansController {

    ILoansService iLoansService;
    @PostMapping("/create")
    @Operation(
            summary = "create loan API"
            , description = "this is an API for creating loans"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Http Status OK"),
            @ApiResponse(responseCode = "500" , description = "Http Status Internal Server error")
    })
    public ResponseEntity<ResponseDto> createLoan(@Valid @RequestParam
                                       @Pattern(regexp="(^$|[0-9]{10})",message = "mobile number must be 10 digits")
                                       String mobileNumber){
        iLoansService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoansConstants.STATUS_201,LoansConstants.MSG_201));
    }

    @GetMapping("/fetch")
    @Operation(
            summary = "fetch loan API"
            , description = "This is an API for fetching loans"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "Http Status OK"),
            @ApiResponse(responseCode = "500" , description = "Http Status Internal Server error")
    })
    public ResponseEntity<LoansDto> fetchLoan(@Valid @RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "mobile number must be 10 digits") String mobileNumber){
        LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansDto);
    }

    @PutMapping("/update")
    @Operation(
            summary = "update loan API"
            , description = "This is an API for updating loans"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "Http status OK"),
            @ApiResponse(responseCode = "417" , description = "Exception Failed"),
            @ApiResponse(responseCode = "500" , description = "Http Status Internal Server error")
    })
    public ResponseEntity<ResponseDto> updateLoans(@Valid @RequestBody LoansDto loansDto){
        boolean isUpdated = iLoansService.updateLoan(loansDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200,LoansConstants.MSG_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417,LoansConstants.MSG_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete loans API"
            , description = "this is an API for deleting loans"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200"  ,description = "Http Status OK")
            ,@ApiResponse(responseCode = "500" , description = "Http Status Internal Server error")
            ,@ApiResponse(responseCode = "417" , description = "Exception Failed")
    })
    public ResponseEntity<ResponseDto> deleteLoans(@Valid @RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "mobile number must be 10 digits") String mobileNumber){
        boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200,LoansConstants.MSG_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417,LoansConstants.MSG_417_DELETE));
        }

    }
}
