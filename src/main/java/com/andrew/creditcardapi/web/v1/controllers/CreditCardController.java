package com.andrew.creditcardapi.web.v1.controllers;

import com.andrew.creditcardapi.dto.CreditCardRequestDto;
import com.andrew.creditcardapi.dto.CreditCardResponseDto;
import com.andrew.creditcardapi.web.mappers.CreditCardMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1")
public class CreditCardController {

//    private CreditCardMapper cardMapper;
//
//    @GetMapping(path="/creditCards")
//    public ResponseEntity<Collection<CreditCardResponseDto>> findAllCreditCards() {
//
//        return ResponseEntity.ok().body(// collection of all credit cards);
//    }
//
//
//    @GetMapping(path="/creditCard/{cardNumber}")
//    public ResponseEntity<CreditCardResponseDto> findCreditCardByCardNumber(
//            @PathVariable("cardNumber") String cardNumber) {
//
//        return ResponseEntity.ok().body(// found credit card);
//    }
//
//    @PostMapping(path="/creditCard")
//    public ResponseEntity<CreditCardResponseDto> createCreditCard(@RequestBody CreditCardRequestDto requestDto) {
//
//        return ResponseEntity.ok().body(// credit card entity);
//    }
}
