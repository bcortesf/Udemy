package com.company.manejoerror.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.manejoerror.models.ErrorCustomRuntimeException;

@RestControllerAdvice
public class HandlerExceptionController {

    
    @ExceptionHandler(value = ErrorCustomRuntimeException.class) //atrapa exepcion del controlador
    public ResponseEntity<ErrorCustomRuntimeException> expirateDateError(ErrorCustomRuntimeException err) {
        return ResponseEntity.internalServerError().body(err);
    }


    @ExceptionHandler
    public ResponseEntity<String> convertTypeError(NumberFormatException ex) {
        return ResponseEntity.internalServerError()
            .body("error 500: ".concat(ex.getMessage()));
    }
    @ExceptionHandler
    public ResponseEntity<String> unknowError(Exception ex) {
        return ResponseEntity.internalServerError()
            .body("error 1989: EXEPCION-NO-CONTROLADA:\n".concat(ex.toString()));
    }
    /////////////////////////////////////////////////////////////
    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<?> divideByZero() {
        return new ResponseEntity<>("mi objeto", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
