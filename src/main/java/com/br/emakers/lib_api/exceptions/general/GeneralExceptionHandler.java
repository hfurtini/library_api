package com.br.emakers.lib_api.exceptions.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GeneralExceptionHandler{

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<com.br.emakers.lib_api.exceptions.general.RestErrorMessage> entityNotFoundHandler(EntityNotFoundException exception){

        com.br.emakers.lib_api.exceptions.general.RestErrorMessage errorMessage = new com.br.emakers.lib_api.exceptions.general.RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.status(errorMessage.status()).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<com.br.emakers.lib_api.exceptions.general.RestErrorMessage>> methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        List<com.br.emakers.lib_api.exceptions.general.RestErrorMessage> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> new com.br.emakers.lib_api.exceptions.general.RestErrorMessage(HttpStatus.BAD_REQUEST, fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}

