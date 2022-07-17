package com.andrew.creditcardapi.repositories;

import com.andrew.creditcardapi.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    @Query("SELECT c FROM CreditCard c WHERE c.cardNumber = ?1")
    Optional<CreditCard> findByCardNumber(String cardNumber);
}
