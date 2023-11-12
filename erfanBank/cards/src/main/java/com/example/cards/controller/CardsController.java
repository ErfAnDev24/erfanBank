package com.example.cards.controller;


import com.example.cards.constants.CardsConstants;
import com.example.cards.dto.CardsContactInfoDto;
import com.example.cards.dto.CardsDto;
import com.example.cards.dto.ErrorResponseDto;
import com.example.cards.dto.ResponseDto;
import com.example.cards.service.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "REST APIs",
description = "REST APIs which involved CRUD APIs for create , fetch , update and delete Cards details")
public class CardsController {

    private ICardsService iCardsService;

    @Autowired
    private CardsContactInfoDto cardsContactInfoDto;

    @Autowired
    private Environment environment;

    /*@Value("${build.version}")
    private String buildVersion;*/
    public CardsController(ICardsService iCardsService) {
        this.iCardsService = iCardsService;
    }

    @Operation(summary = "creating cards",
    description = "This is an API for creating cards")
    @ApiResponses({
            @ApiResponse(responseCode = "201",
            description = "Http Status code Created")
            ,
            @ApiResponse(responseCode = "500",
            description = "Https Status Internal Server Error"
            ,content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestParam
                                                      @Pattern(regexp = "^[0-9]{10}$" , message = "Mobile number must be 10 digits") String mobileNumber){
        iCardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201,CardsConstants.MSG_201));
    }

    @GetMapping("/fetch")
    @Operation(summary = "fetching cards",
    description = "This is an API which you can fetch Cards details from it")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
            description = "This is an API which you can fetch Cards details from it")
            ,
            @ApiResponse(responseCode = "500",
            description = "Https Status Internal Server Error"
            ,content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits") String mobileNumber){
        CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardsDto);
    }

    @PutMapping("/update")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "Http Status OK")
            ,
            @ApiResponse(responseCode = "417" , description = "Exception failed",content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
            ,
            @ApiResponse(responseCode = "500" , description = "Http Status Internal Server error"
            ,content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardsDto cardsDto){
        boolean isUpdated = iCardsService.updateCard(cardsDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200,CardsConstants.MSG_200));
        }else
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardsConstants.STATUS_417,CardsConstants.MSG_417_UPDATE));
    }
    @DeleteMapping("/delete")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "Http Status OK"),
            @ApiResponse(responseCode = "417" , description = "Exception Failed"),
            @ApiResponse(responseCode = "500" , description = "Http Status Internal Server Error"
            ,content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits") String mobileNumber){
        boolean isDeleted = iCardsService.deleteCard(mobileNumber);
        if (isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200,CardsConstants.MSG_200));
        }else
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardsConstants.STATUS_417,CardsConstants.MSG_417_DELETE));
    }

    @GetMapping("/contact-info")
    public ResponseEntity<CardsContactInfoDto> getCantactInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardsContactInfoDto);
    }

    /*@GetMapping
    public ResponseEntity<String> getBuildVersion() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(buildVersion);
    }*/

    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }
}
