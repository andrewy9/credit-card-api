package com.andrew.creditcardapi.services;

import com.andrew.creditcardapi.exceptions.CardDoesNotExistException;
import com.andrew.creditcardapi.exceptions.CardNumberExistsExeption;
import com.andrew.creditcardapi.models.CreditCard;
import com.andrew.creditcardapi.repositories.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreditCardServiceImpl implements CreditCardService{

    private final CreditCardRepository creditCardRepository;

    @Override
    public CreditCard getCreditCardByCardNumber(String cardNumber) throws CardDoesNotExistException {
        Optional<CreditCard> creditCardOptional =creditCardRepository.findByCardNumber(cardNumber);
        if (creditCardOptional.isEmpty()) {
            throw new CardDoesNotExistException("Card with provided number does not exist", cardNumber);
        }
        return creditCardOptional.get();
    }

    @Override
    public Collection<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard saveCreditCard(CreditCard creditCard) throws CardNumberExistsExeption {
        String cardNumber = creditCard.getCardNumber();
        Optional<CreditCard> cardOptional = creditCardRepository.findByCardNumber(cardNumber);

        if(cardOptional.isPresent()) {
            throw new CardNumberExistsExeption("Card with provided number already exists", cardNumber);
        }

        return creditCardRepository.save(creditCard);
    }
}
