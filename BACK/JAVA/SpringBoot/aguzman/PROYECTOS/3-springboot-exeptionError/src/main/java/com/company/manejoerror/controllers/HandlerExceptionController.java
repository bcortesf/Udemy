package com.company.manejoerror.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.manejoerror.models.ErrorCustom;
import com.company.manejoerror.models.ErrorCustomRuntimeException;

@RestControllerAdvice
public class HandlerExceptionController {
    private ErrorCustom errorCustomDTO;

    public HandlerExceptionController(ErrorCustom errorCustomDTO) {
        this.errorCustomDTO = errorCustomDTO;
    }


    @ExceptionHandler(value = ErrorCustomRuntimeException.class) //atrapa exepcion del controlador
    public ResponseEntity<ErrorCustom> expirateDateError(ErrorCustomRuntimeException err) { //505
        errorCustomDTO.setError(err.getError());
        errorCustomDTO.setMessage(err.getMessage());
        errorCustomDTO.setStatus(err.getStatus());
        errorCustomDTO.setDate(err.getDate());
        // return ResponseEntity.internalServerError().body(errorCustomDTO); //FORMA-1
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorCustomDTO); //FORMA-2
    }
    /////////////////////////////////////////////////////////////
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorCustom> dataNull(NullPointerException err) {
        errorCustomDTO.setError("error 503b: ".concat(err.getMessage()));
        errorCustomDTO.setMessage(err.fillInStackTrace().toString());
        errorCustomDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorCustomDTO.setDate(LocalDate.now());
        return ResponseEntity.internalServerError().body(errorCustomDTO);
    }
    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<?> divideByZero(ArithmeticException err) {
        return new ResponseEntity<>("error 503a:".concat(err.getMessage())
            , HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /////////////////////////////////////////////////////////////
    // @ExceptionHandler
    // public ResponseEntity<String> convertTypeError(NumberFormatException ex) {
    //     return ResponseEntity.internalServerError()
    //         .body("error 502: ".concat(ex.getMessage()));
    // }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR) //postman
    public Map<String, Object> convertTypeError(NumberFormatException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("dateTime", LocalDateTime.now());
        error.put("error", "error 502: numero invalido o incorrecto; no tiene formato de digito!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); //mi-respuesta
        return error;
    }


    @ExceptionHandler
    public ResponseEntity<String> unknowError(Exception ex) {
        //Cualquier tipo de exepcion que no se tenga atrapada y/o controlada
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("error 404-89: EXEPCION-NO-CONTROLADA:\n".concat(ex.toString()));
    }
    /////////////////////////////////////////////////////////////
}
