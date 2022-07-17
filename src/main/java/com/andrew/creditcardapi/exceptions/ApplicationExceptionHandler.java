package com.andrew.creditcardapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(CardNumberExistsExeption.class)
    protected ResponseEntity<Object> handleCardNumberExistsExeption(CardNumberExistsExeption e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(CardDoesNotExistException.class)
    protected ResponseEntity<Object> handleCardDoesNotExistException(CardDoesNotExistException e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(e.getMessage());
        return ResponseEntity.badRequest().body(apiError);
    }
}
