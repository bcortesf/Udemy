package com.company.springboot3web.controllers.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component(value = "errorResponse")
public class ErrorResponse extends AbstractResponse {

    /**
     * Class FAIL
     */
    @Override
    public void setPropiedadHashMap(String mensaje, Object objeto, HttpStatus httpStatus) {
        super.setMensaje(mensaje);
        super.setObjeto(objeto);
        super.setHttpStatus(httpStatus);
        this.getRespuestaHashMap().put("newPropertyBAD" , "BryanCFz_FAIL");
    }

}
