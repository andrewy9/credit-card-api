package com.andrew.creditcardapi.services;

import com.andrew.creditcardapi.exceptions.CardDoesNotExistException;
import com.andrew.creditcardapi.exceptions.CardNumberExistsExeption;
import com.andrew.creditcardapi.models.CreditCard;

import java.util.Collection;

public interface CreditCardService {
    CreditCard getCreditCardByCardNumber(String cardNumber) throws CardDoesNotExistException;

    Collection<CreditCard> getAllCreditCards();

    CreditCard saveCreditCard(CreditCard creditCard) throws CardNumberExistsExeption;
}
