package com.andrew.creditcardapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CreditCardRequestDto {
    @NotBlank
    @Size(max = 50, message = "The character count should not exceed 50 ")
    @Pattern(regexp = "[A-Za-z0-9]")
    private String full_name;

    @NotBlank
    @Pattern(regexp = "[0-9]")
    private String cardNumber;

    @NotBlank
    @Pattern(regexp = "[0-9]")
    private String cvc;

    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate expiryDate;
}
