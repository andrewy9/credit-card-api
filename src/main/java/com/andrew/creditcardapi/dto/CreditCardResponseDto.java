package com.andrew.creditcardapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class CreditCardResponseDto {
    private Long id;
    private String fullName;
    private String cardNumber;
    private String cvc;
    private LocalDate expiryDate;
}
