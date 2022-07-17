package com.andrew.creditcardapi.models;

import java.time.LocalDate;


public class CreditCard {
    private Long id;
    private String full_name;
    private String cardNumber;
    private String cvc;
    private LocalDate expiryDate;
}
