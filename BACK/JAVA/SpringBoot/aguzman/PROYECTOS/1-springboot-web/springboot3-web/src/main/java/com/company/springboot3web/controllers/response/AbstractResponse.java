package com.company.springboot3web.controllers.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public abstract class AbstractResponse implements IConstruyendoRespuesta {

    protected Map<String, Object> respuestaHashMap;
    protected String mensaje;
    protected Object objeto;
    protected HttpStatus httpStatus;


    protected AbstractResponse() {
        this.setRespuestaHashMap(new HashMap</*String, Object*/>());
    }

    protected AbstractResponse(String mensaje, Object objeto, HttpStatus httpStatus) {
        this.mensaje = mensaje;
        this.objeto = objeto;
        this.httpStatus = httpStatus;
    }


    public Map<String, Object> getRespuestaHashMap() {
        return respuestaHashMap;
    }

    public void setRespuestaHashMap(Map<String, Object> respuestaHashMap) {
        this.respuestaHashMap = respuestaHashMap;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "AbstractResponse [respuestaHashMap=" + respuestaHashMap + ", mensaje=" + mensaje + ", objeto=" + objeto
                + ", httpStatus=" + httpStatus + "]";
    }

}
