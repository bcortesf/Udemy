package com.company.springboot3web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3web.controllers.response.AbstractResponse;
import com.company.springboot3web.services.RequestParamService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(path = "/api/requestParam")
public class RequestParamsController {
    Logger log = LoggerFactory.getLogger(getClass());
    private final AbstractResponse responseOk;
    private final AbstractResponse responseEr;

    private final RequestParamService service;

    /*CONSTRUCTOR */
    public RequestParamsController(
        @Qualifier(value = "okResponse") AbstractResponse responseOk,
        @Qualifier(value = "errorResponse") AbstractResponse responseEr,
        RequestParamService service
    ) {
        this.responseOk = responseOk;
        this.responseEr = responseEr;
        //
        this.service = service;
    }


    /*END-POINTS */
    @GetMapping(path = {"/get"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuarios() {
        Object body;
        try {
            body = "respuesta request-param";
        } catch (Exception err) {
            this.responseEr.setPropiedadHashMap(
                "No se puede consultar el mensaje del usuario",
                err.getMessage().concat(": ").concat(err.getLocalizedMessage()), //dato nulo, campo duplicado, cualquier cosa
                HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(this.responseEr, responseEr.getHttpStatus());
        }
        //->Envio de Subclase<OKResponse> a Clase<AbstractResponse>
        this.responseOk.setPropiedadHashMap(
            null,
            body,
            HttpStatus.OK);
        return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
    }
    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping(path = {"/get2"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuarios2() {
        Object body;
        try {
            body = "respuesta request-param";
        } catch (Exception err) {
            this.responseEr.setPropiedadHashMap(
                "No se puede consultar el mensaje del usuario",
                err.getMessage().concat(": ").concat(err.getLocalizedMessage()), //dato nulo, campo duplicado, cualquier cosa
                HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(this.responseEr, responseEr.getHttpStatus());
        }
        //->Envio de Subclase<OKResponse> a Clase<AbstractResponse>
        this.responseOk.setPropiedadHashMap(
            null,
            body,
            HttpStatus.OK);
        return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
    }
    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    /*  http://localhost:8080/api/requestParam/convert2?name=Hola Bryan       :->GOOGLE-CHROME, POST-MAN
        http://localhost:8080/api/requestParam/convert2?name=Hola%20Bryan     :(Angular,React, JSP,.. etc)*/
        @GetMapping(path = {"/convert3"})
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<AbstractResponse> textUpperCase3(
                @RequestParam String name,
                @RequestParam(required = false, defaultValue = "CFz!!!") String lastname) {
            Object body;
            try {
                // lastname = (lastname != null) ? lastname : "CFz!";
                body = this.service.convertToUpperCase(name.concat("-").concat(lastname));
            } catch (Exception err) {
                this.responseEr.setPropiedadHashMap(
                    "No se puede consultar el mensaje del usuario",
                    err.getMessage().concat(": ").concat(err.getLocalizedMessage()), //dato nulo, campo duplicado, cualquier cosa
                    HttpStatus.INTERNAL_SERVER_ERROR);
                return new ResponseEntity<>(this.responseEr, responseEr.getHttpStatus());
            }
            //->Envio de Subclase<OKResponse> a Clase<AbstractResponse>
            this.responseOk.setPropiedadHashMap(
                null,
                body,
                HttpStatus.OK);
            return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
        }
    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////
    /*  http://localhost:8080/api/requestParam/convert2?name=Hola Bryan&lastname=CF z         :->GOOGLE-CHROME, POST-MAN
        http://localhost:8080/api/requestParam/convert2?name=Hola%20Bryan&lastname=CF%20z     :(Angular,React, JSP,.. etc)*/
        @GetMapping(path = {"/convert2"})
        @ResponseStatus(code = HttpStatus.OK)
        public ResponseEntity<AbstractResponse> textUpperCase2(@RequestParam String name, @RequestParam String lastname) {
            Object body;
            try {
                body = this.service.convertToUpperCase(name.concat("-").concat(lastname));
            } catch (Exception err) {
                this.responseEr.setPropiedadHashMap(
                    "No se puede consultar el mensaje del usuario",
                    err.getMessage().concat(": ").concat(err.getLocalizedMessage()), //dato nulo, campo duplicado, cualquier cosa
                    HttpStatus.INTERNAL_SERVER_ERROR);
                return new ResponseEntity<>(this.responseEr, responseEr.getHttpStatus());
            }
            //->Envio de Subclase<OKResponse> a Clase<AbstractResponse>
            this.responseOk.setPropiedadHashMap(
                null,
                body,
                HttpStatus.OK);
            return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
        }
    /////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
    /*  http://localhost:8080/api/requestParam/convert?message=Hola Bryan CFz         :TEST->GOOGLE-CHROME, POST-MAN
        http://localhost:8080/api/requestParam/convert?message=Hola%20Bryan%20CFz     :TEST->FRONT(Angular,React, JSP,.. etc)*/
    @GetMapping(path = {"/convert1"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> textUpperCase1(@RequestParam String message) {
        Object body;
        try {
            body = this.service.convertToUpperCase(message);
        } catch (Exception err) {
            this.responseEr.setPropiedadHashMap(
                "No se puede consultar el mensaje del usuario",
                err.getMessage().concat(": ").concat(err.getLocalizedMessage()), //dato nulo, campo duplicado, cualquier cosa
                HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(this.responseEr, responseEr.getHttpStatus());
        }
        //->Envio de Subclase<OKResponse> a Clase<AbstractResponse>
        this.responseOk.setPropiedadHashMap(
            null,
            body,
            HttpStatus.OK);
        return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
    }

}
