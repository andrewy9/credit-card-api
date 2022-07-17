package com.andrew.creditcardapi.exceptions;

public class CardNumberExistsExeption extends Exception {

    private final String cardNumber;

    public CardNumberExistsExeption(String message, String cardNumber) {
        super(message);
        this.cardNumber = cardNumber;
    }

    public CardNumberExistsExeption(String message, Throwable cause, String cardNumber) {
        super(message, cause);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {return cardNumber;}
}
