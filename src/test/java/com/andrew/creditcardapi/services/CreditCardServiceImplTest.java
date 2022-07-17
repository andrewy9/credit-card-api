package com.andrew.creditcardapi.services;

import com.andrew.creditcardapi.exceptions.CardDoesNotExistException;
import com.andrew.creditcardapi.exceptions.CardNumberExistsExeption;
import com.andrew.creditcardapi.models.CreditCard;
import com.andrew.creditcardapi.repositories.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreditCardServiceImplTest {

    @Mock
    private CreditCardRepository creditCardRepository;
    private CreditCardService creditCardServiceUnderTest;

    @BeforeEach
    void setUp() {
        creditCardServiceUnderTest = new CreditCardServiceImpl(creditCardRepository);
    }

    @Test
    void canGetAllCreditCards() {
        creditCardServiceUnderTest.getAllCreditCards();

        verify(creditCardRepository).findAll();
    }

    @Test
    void canGetCreditCards() throws CardDoesNotExistException {
        String cardNumber = "1111222233334444";
        CreditCard creditCard = new CreditCard(
                10L,
                "John Snow",
                cardNumber,
                "123",
                LocalDate.now()
        );
        given(creditCardRepository.findByCardNumber(any())).willReturn(Optional.of(creditCard));

        creditCardServiceUnderTest.getCreditCardByCardNumber(cardNumber);

        verify(creditCardRepository).findByCardNumber(cardNumber);
    }

    @Test
    void saveCreditCard() throws CardNumberExistsExeption {
        String cardNumber = "1111222233334444";
        CreditCard creditCard = new CreditCard(
                10L,
                "John Snow",
                cardNumber,
                "123",
                LocalDate.now()
        );

        creditCardServiceUnderTest.saveCreditCard(creditCard);

        ArgumentCaptor<CreditCard> creditCardArgumentCaptor = ArgumentCaptor.forClass(CreditCard.class);

        verify(creditCardRepository).save(creditCardArgumentCaptor.capture());

        assertThat(creditCardArgumentCaptor.getValue()).isEqualTo(creditCard);

    }
}