package com.example.cards.service.impl;

import com.example.cards.constants.CardsConstants;
import com.example.cards.dto.CardsDto;
import com.example.cards.entity.Cards;
import com.example.cards.exception.CardAlreadyExistException;
import com.example.cards.exception.ResourceNotFoundException;
import com.example.cards.mapper.CardsMapper;
import com.example.cards.repository.CardsRepository;
import com.example.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> card = cardsRepository.findByMobileNumber(mobileNumber);
        if (card.isPresent()){
            throw new CardAlreadyExistException("Card Already registered with give mobile number");
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    public CardsDto fetchCard(String mobileNumber){
       Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Card","Mobile number",mobileNumber)
        );
       return CardsMapper.mapToCardsDto(cards,new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        return true;
    }

    public Cards createNewCard(String mobileNumber){
        Cards newCard = new Cards();
        long randomCardNumber = 1000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.valueOf(randomCardNumber).toString());
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }
}
