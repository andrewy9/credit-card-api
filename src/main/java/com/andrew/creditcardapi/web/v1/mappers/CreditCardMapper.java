package com.andrew.creditcardapi.web.v1.mappers;

import com.andrew.creditcardapi.dto.CreditCardRequestDto;
import com.andrew.creditcardapi.dto.CreditCardResponseDto;
import com.andrew.creditcardapi.models.CreditCard;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CreditCardMapper {
    public CreditCardResponseDto toResponseDto(CreditCard creditCard) {
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
