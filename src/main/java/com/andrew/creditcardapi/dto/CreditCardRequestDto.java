package com.andrew.creditcardapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class CreditCardRequestDto {
    @NotBlank
    @Size(max = 50, message = "The character count should not exceed 50 ")
    @Pattern(regexp = "[A-Za-z0-9]")
    private String fullName;

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
