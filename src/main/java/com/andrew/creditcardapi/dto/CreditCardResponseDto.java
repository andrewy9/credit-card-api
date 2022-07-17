package com.andrew.creditcardapi.dto;

import java.time.LocalDate;

public class CreditCardResponseDto {
    private Long id;
    private String full_name;
    private String cardNumber;
    private String cvc;
    private LocalDate expiryDate;
}
