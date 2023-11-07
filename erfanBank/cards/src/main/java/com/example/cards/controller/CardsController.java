package com.example.cards.controller;


import com.example.cards.constants.CardsConstants;
import com.example.cards.dto.CardsDto;
import com.example.cards.dto.ResponseDto;
import com.example.cards.service.ICardsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CardsController {

    private ICardsService iCardsService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam
                                                      @Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber){
        iCardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201,CardsConstants.MSG_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})") String mobileNumber){
        CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardsDto);
    }

   /* @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardsDto cardsDto){
        iCardsService.u
    }*/
}
