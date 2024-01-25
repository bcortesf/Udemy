package com.company.springboot3web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3web.controllers.response.AbstractResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(path = "/api")
public class PLANTILLAController {
    Logger log = LoggerFactory.getLogger(getClass());
    private final AbstractResponse responseOk;
    private final AbstractResponse responseEr;

    /*CONSTRUCTOR */
    public PLANTILLAController(
        @Qualifier(value = "okResponse") AbstractResponse responseOk,
        @Qualifier(value = "errorResponse") AbstractResponse responseEr
    ) {
        this.responseOk = responseOk;
        this.responseEr = responseEr;
        //
    }


    /*END-POINTS */
    @GetMapping(path = {"/get"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuarios() {
        Object body;
        try {
            body = "respuesta";
        } catch (Exception err) {
            this.responseEr.setPropiedadHashMap(
                "mensaje del error",//dato nulo, campo duplicado, cualquier cosa
                err.getCause(), //objeto-error
                HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(this.responseEr, responseEr.getHttpStatus());
        }
        //->Envio de Subclase<OKResponse> a Clase<AbstractResponse>
        this.responseOk.setPropiedadHashMap(
            null,
            body,
            HttpStatus.OK);
        log.info("responseOk: {}", this.responseOk);
        return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
    }

}
