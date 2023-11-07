package com.example.cards.mapper;

import com.example.cards.dto.CardsDto;
import com.example.cards.entity.Cards;

public class CardsMapper {

    public static Cards mapToCards(CardsDto cardsDto ,Cards cards){
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }

    public static CardsDto mapToCardsDto(Cards cards,CardsDto cardsDto){
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        return cardsDto;
    }
}
