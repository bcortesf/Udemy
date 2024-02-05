package com.company.manejoerror.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.company.manejoerror.models.ErrorCustom;
import com.company.manejoerror.models.ErrorCustomRuntimeException;

import java.text.MessageFormat;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path = "/app")

public class AppController {

    private ErrorCustomRuntimeException errorRUNEX;
    private ErrorCustom error;


    public AppController(ErrorCustomRuntimeException errorRUNEX, ErrorCustom error) {
        this.errorRUNEX = errorRUNEX;
        this.error = error;
    }


    
    @GetMapping(path = "/200-5")
    public Object metodo5() throws ErrorCustomRuntimeException {
        LocalDate createDate = LocalDate.now().plusDays(1);//1: vencido, 0:esVigente
        LocalDate expirateDate = LocalDate.now();
        boolean isCurrent = (createDate.isBefore(expirateDate) || createDate.isEqual(expirateDate));
        if (!isCurrent) {
            String mensaje = MessageFormat.format("La fechaCreacion {0} es mayor a la fechaVencimiento {1}."
                , createDate, expirateDate);
            errorRUNEX.setError("error 505: ".concat("FECHA EXPIRADA"));
            errorRUNEX.setMessage(mensaje);
            errorRUNEX.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value() + 5);
            errorRUNEX.setDate(expirateDate);
            throw errorRUNEX;
        }
        return "fecha de vencimiento de la carne, vigente";
    }
    @GetMapping(path = "/200-4")
    public Object metodo4() {
        //NO-HANDLER-EXCEPTION-CONTROLLER
        LocalDate createDate = LocalDate.now().plusDays(1);//1: vencido, 0:esVigente
        LocalDate expirateDate = LocalDate.now();
        boolean isCurrent = (createDate.isBefore(expirateDate) || createDate.isEqual(expirateDate));
        if (!isCurrent) {
            String mensaje = MessageFormat.format("La fechaCreacion {0} es mayor a la fechaVencimiento {1}."
                , createDate, expirateDate);
            error.setError("error 504: ".concat(" FECHA EXPIRADA"));
            error.setMessage(mensaje);
            error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            error.setDate(expirateDate);
            return error;
        }
        return "fecha de vencimiento de la carne, vigente";
    }


    @GetMapping(path = "/200-3b")
    public Object metodo3b() {
        Integer divisor = null;
        return 2024 / divisor;
    }
    @GetMapping(path = "/200-3a")
    public Object metodo3a() {
        return 2024 / 0;
    }
    @GetMapping(path = "/200-2")
    public Object metodo2() {
        return Integer.valueOf("uno");
    }

    @GetMapping(path = "/200-1")
    public Object metodo1() {
        //NO-HANDLER-EXCEPTION-CONTROLLER
        try {
            Integer.valueOf("uno");
        } catch (Exception e) {
            error.setError("No se puede convertir texto a numero");
            error.setMessage(e.getMessage());
            error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            error.setDate(LocalDate.now());
            return error;
        }
        return "ok 200";
    }

}
