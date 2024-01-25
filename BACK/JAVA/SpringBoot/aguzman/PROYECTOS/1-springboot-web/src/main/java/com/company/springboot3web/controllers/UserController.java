package com.company.springboot3web.controllers;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3web.controllers.response.AbstractResponse;
import com.company.springboot3web.domain.entitys.User;
import com.company.springboot3web.domain.entitys.dto.UserDTO;
import com.company.springboot3web.domain.entitys.dto.UserTest1DTO;
import com.company.springboot3web.domain.entitys.dto.UserTest2DTO;

@RestController
@RequestMapping(path = {"/api/user"})
public class UserController {
    Logger log = LoggerFactory.getLogger(getClass());
    private final AbstractResponse responseOk;
    private final AbstractResponse responseEr;

    private UserDTO userDTO;
    private UserTest1DTO userTest1DTO;
    private UserTest2DTO userTest2DTO;


    /*CONSTRUCTOR */
    public UserController(
        @Qualifier(value = "okResponse") AbstractResponse responseOk,
        @Qualifier(value = "errorResponse") AbstractResponse responseEr,
        UserDTO userDTO,
        UserTest1DTO userTest1DTO,  UserTest2DTO userTest2DTO
    ) {
        this.responseOk = responseOk;
        this.responseEr = responseEr;
        //
        this.userDTO = userDTO;
        this.userTest1DTO = userTest1DTO;
        this.userTest2DTO = userTest2DTO;
    }


    /*END-POINTS */
    @GetMapping(path = {"/getList"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuarios() {
        Object body;
        try {
            body = getUsers();
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
    private List<User> getUsers() {
        return Arrays.asList(
            new User(1, "Bryan1", "CFz1", "pass123"),
            new User(2, "Bryan2", "CFz2", "pass456"),
            new User(3, "Bryan3", "CFz3", "pass789")
        );
    }



    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = {"/map"})
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Object> getMap() {
        Map<String, Object> body = new HashMap<>();
        body.put("propA", "aaa");    body.put("propB", "bbb");    body.put("propC", "ccc");
        return body;
    }
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = {"/mapr"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Map<String, Object>> getMapResponse() {
        Map<String, Object> body = new HashMap<>();
        body.put("propA", "aaa");    body.put("propB", "bbb");    body.put("propC", "ccc");
        return new ResponseEntity</*Map<String, Object>*/>(body, HttpStatus.OK);
    }
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = {"/string"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<String> getString() {
        this.responseOk.setHttpStatus(HttpStatus.OK);
        this.responseOk.setMensaje("hola mundo2");
        this.responseOk.setObjeto(null);
        log.info("responseOk: {}", this.responseOk);
        return new ResponseEntity</*String*/>(this.responseOk.toString(), HttpStatus.OK);
    }
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = {"/abstractResponse"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> getAbstractResponse() {
        this.responseOk.setHttpStatus(HttpStatus.OK);
        this.responseOk.setMensaje("hola mundo3");
        this.responseOk.setObjeto(true);
        log.info("responseOk: {}" , this.responseOk);
        return new ResponseEntity</*AbstractResponse*/>(this.responseOk, HttpStatus.OK);
    }
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = {"/greet"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> getSaludar() {
        String helloWorld;
        try {
            helloWorld = "hola mundo";
            // Integer.parseInt(helloWorld);    /*->MOSTRAR SALIDA CON ERROR*/
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
            helloWorld,
            HttpStatus.OK);
        ///////////////////////////////////////////////////////////
        /*OPCIONAL: Tipos de respuesta con propiedades distintas*/
        pruebasTiposDeRespuesta();
        ///////////////////////////////////////////////////////////
        return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
    }

    private void pruebasTiposDeRespuesta(){
        /*RESPUESTA1: borrar propiedad."newPropertyOK"*/
        borrarPropiedadesHashMap();

        /*RESPUESTA2: borrar propiedad."newPropertyOK"  y  crear nuevas propiedades."propertyCat","propertyDog"*/
        // borrarPropiedadesSetearNuevasPropiedadesHashMap();

        /*RESPUESTA3: agregarNuevasPropiedades."appendPropperty", y dejar propiedad."newPropertyOK"*/
        // agregarNuevasPropiedadesHashMap();
    }
    private void borrarPropiedadesHashMap(){
        this.responseOk.setRespuestaHashMap(new HashMap<String, Object>());
    }
    private void borrarPropiedadesSetearNuevasPropiedadesHashMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("propertyCat", "Shushi");
        map.put("propertyDog", "Minnie");
        this.responseOk.setRespuestaHashMap(map);
    }
    private void agregarNuevasPropiedadesHashMap(){
        this.responseOk.getRespuestaHashMap().put("appendPropperty", "propiedadA agregada ");
    }
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = {"/getUsuarioMap"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> getUsuarioMap() {
        Map<String, Object> body;
        try {
            body = getUserMap();
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
            body,         //->SHOW: encapsular una Clase<propiedades>, Usuario(propiedades)
            HttpStatus.OK);
        return new ResponseEntity<>(this.responseOk, responseOk.getHttpStatus());
    }
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @GetMapping(path = {"/getUser"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuario() {
        Object body;
        try {
            body = getBody();
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
    private Object getBody() {
        Object[] responses = {
            getUser(),        //->SHOW[0]: solo propiedad(name,lastname,password): Usuario
            getUserMap(),     //->SHOW[1]: encapsular una Clase<propiedades>, Usuario(propiedades)
            getUserTest1DTO(),//->SHOW[2]: Usuario(propiedades), set VALUES especificas; otras propertys NULL
            getUserTest2DTO(),//->SHOW[3]: solo propiedad(name,lastname,password): Usuario
            /////////////////
            getUserDTO(),     //->SHOW[4]: Tener clase<Customizada> con propiedades personalizadas
        };
        return responses[3];
    }

    private User getUser() {
        return new User(1, "Bryan", "CFz", "pass123");
    }
    private Map<String, Object> getUserMap() {
        User user = new User(2, "Bryan", "CF", "pass456");
        return Map.ofEntries(
            Map.entry("user", user)
        );
    }
    private Object getUserTest1DTO(){
        User user  = getUser();
        return this.userTest1DTO.getUserTestDTO(user);
    }
    private Object getUserTest2DTO(){
        User user  = getUser();
        this.userTest2DTO.setUser(user);
        return this.userTest2DTO.getUser();
    }
    private Object getUserDTO(){
        User user  = getUser();
        return this.userDTO.getUserDTO(user.getName(), user.getLastName());
    }
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------

}
