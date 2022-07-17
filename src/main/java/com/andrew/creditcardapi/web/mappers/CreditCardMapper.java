package com.andrew.creditcardapi.web.mappers;

import com.andrew.creditcardapi.dto.CreditCardRequestDto;
import com.andrew.creditcardapi.dto.CreditCardResponseDto;
import com.andrew.creditcardapi.models.CreditCard;

import java.time.LocalDate;

public class CreditCardMapper {
    public CreditCardResponseDto creditCardResponseDto(CreditCard creditCard) {
        Long id = creditCard.getId();
        String fullName = creditCard.getFullName();
        String cardNumber = creditCard.getCardNumber();
        String cvc = creditCard.getCvc();
        LocalDate expiryDate = creditCard.getExpiryDate();

        return new CreditCardResponseDto(id, fullName, cardNumber, cvc, expiryDate);
    }

    public CreditCard toEntity(CreditCardRequestDto requestDto) {
        CreditCard creditCard = new CreditCard(
                null,
                requestDto.getFullName(),
                requestDto.getCardNumber(),
                requestDto.getCvc(),
                requestDto.getExpiryDate()
        );

        return creditCard;
    }
}
