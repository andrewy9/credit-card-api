package com.andrew.creditcardapi.web.v1.controllers;

import com.andrew.creditcardapi.dto.CreditCardRequestDto;
import com.andrew.creditcardapi.dto.CreditCardResponseDto;
import com.andrew.creditcardapi.exceptions.CardDoesNotExistException;
import com.andrew.creditcardapi.exceptions.CardNumberExistsExeption;
import com.andrew.creditcardapi.models.CreditCard;
import com.andrew.creditcardapi.services.CreditCardService;
import com.andrew.creditcardapi.web.mappers.CreditCardMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    private CreditCardMapper cardMapper;

    @GetMapping(path="/creditCards")
    public ResponseEntity<Collection<CreditCardResponseDto>> findAllCreditCards() {

        List<CreditCardResponseDto> creditCardCollection = creditCardService.getAllCreditCards()
                .stream()
                .map(cardMapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(creditCardCollection);
    }


    @GetMapping(path="/creditCard/{cardNumber}")
    public ResponseEntity<CreditCardResponseDto> findCreditCardByCardNumber(
            @NotBlank @PathVariable String cardNumber) throws CardDoesNotExistException {

        CreditCardResponseDto cardResponseDto = cardMapper.toResponseDto(creditCardService.getCreditCardByCardNumber(cardNumber));
        return ResponseEntity.ok().body(cardResponseDto);
    }

    @PostMapping(path="/creditCard")
    public ResponseEntity<CreditCardResponseDto> createCreditCard(
            @Valid @RequestBody CreditCardRequestDto cardRequestDto) throws CardNumberExistsExeption {

        CreditCard creditCard = creditCardService.saveCreditCard(cardMapper.toEntity(cardRequestDto));
        CreditCardResponseDto cardResponseDto = cardMapper.toResponseDto(creditCard);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/creditCard").toUriString());
        return ResponseEntity.created(uri).body(cardResponseDto);
    }
}
