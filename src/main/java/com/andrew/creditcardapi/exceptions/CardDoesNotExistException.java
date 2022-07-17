package com.andrew.creditcardapi.exceptions;

public class CardDoesNotExistException extends Exception{

    private final String cardNumber;

    public CardDoesNotExistException(String message, String cardNumber) {
        super(message);
        this.cardNumber = cardNumber;
    }

    public CardDoesNotExistException(String message, Throwable cause, String cardNumber) {
        super(message, cause);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {return cardNumber;}
}
