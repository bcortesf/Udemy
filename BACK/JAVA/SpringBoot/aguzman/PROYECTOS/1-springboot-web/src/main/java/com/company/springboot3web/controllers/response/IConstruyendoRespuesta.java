package com.company.springboot3web.controllers.response;

import org.springframework.http.HttpStatus;

@FunctionalInterface
public interface IConstruyendoRespuesta {
    void setPropiedadHashMap(String mensaje, Object objeto, HttpStatus httpStatus);
}
