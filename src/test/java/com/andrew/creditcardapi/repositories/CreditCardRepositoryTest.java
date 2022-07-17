package com.andrew.creditcardapi.repositories;

import com.andrew.creditcardapi.models.CreditCard;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//Will need to connect to (preferably in memory) database such as h2
@DataJpaTest
class CreditCardRepositoryTest {

    @Autowired
    private static CreditCardRepository creditCardRepoUnderTest;

    @BeforeEach
    void setUp() {
        creditCardRepoUnderTest.deleteAll();
    }

    @Test
    void canFindByCardNumber() {
        //given
        String cardNumber = "1111222233335555";
        CreditCard creditCard = new CreditCard(
                10L,
                "John Snow",
                cardNumber,
                "123",
                LocalDate.now()
        );
        creditCardRepoUnderTest.save(creditCard);
        //when
        boolean expected = creditCardRepoUnderTest.findByCardNumber(cardNumber).isPresent();
        //then
        assertThat(expected).isTrue();
    }

    @Test
    void canCheckIfCardNumberDoesNotExist() {
        //given
        String cardNumber = "1111222233334444";
        //when
        boolean expected = creditCardRepoUnderTest.findByCardNumber(cardNumber).isPresent();
        //then
        assertThat(expected).isFalse();
    }
}