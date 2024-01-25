package com.company.springboot3web.controllers.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component(value = "okResponse")
public class OkResponse extends AbstractResponse {
    /**
     * Class OK
     */
    @Override
    public void setPropiedadHashMap(String mensaje, Object objeto, HttpStatus httpStatus) {
        super.setMensaje(mensaje);
        super.setObjeto(objeto);
        super.setHttpStatus(httpStatus);
        super.getRespuestaHashMap().put("newPropertyOK" , "BryanCFz_DONE");
    }
}
