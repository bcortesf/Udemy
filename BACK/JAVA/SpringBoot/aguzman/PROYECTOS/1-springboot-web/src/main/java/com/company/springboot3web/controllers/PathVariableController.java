package com.company.springboot3web.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3web.controllers.request.ProductValueController;
import com.company.springboot3web.controllers.request.UserRequest;
import com.company.springboot3web.controllers.response.AbstractResponse;
import com.company.springboot3web.domain.entitys.User;
import com.company.springboot3web.services.PathVariableService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping(path = "/api/pathVariable")
public class PathVariableController {
    Logger log = LoggerFactory.getLogger(getClass());
    private final AbstractResponse responseOk;
    private final AbstractResponse responseEr;
    //
    private PathVariableService service;

    //--------------------------------------
    @Value(value = "${config.code}")
    private String code;
    @Value(value = "${config.username}")
    private String username;
    @Value(value = "${config.message}")
    private String message;
    @Value(value = "${config.listOfValues}")
    private String[] arrayOfValues;

    /*      LENGUAJE-EXPRESION-SPRING 'CODE-JAVA'       */
    @Value(value = "${config.listOfValues}")
    private List<String> listOfValues;
    // @Value(value = "#{'${config.listOfValues}'}")                //->todos los valores en string
    @Value(value = "#{'${config.listOfValues}'.split(',')[3]}")     //->separar valores por COMA en un array y obtener valor de posicion de array
    private String fieldOfList;
    //--------------------------------------
    @Autowired
    private Environment enviroment;
    //--------------------------------------


    /*CONSTRUCTOR */
    public PathVariableController(
        @Qualifier(value = "okResponse") AbstractResponse responseOk,
        @Qualifier(value = "errorResponse") AbstractResponse responseEr,
        PathVariableService service
    ) {
        this.responseOk = responseOk;
        this.responseEr = responseEr;
        //
        this.service = service;
    }

    private void showAplicationPropertyValues() {
        /*@Value(PASSWORD): dato sensible y  no se muestra */
        log.info("mi-log parametros @Values: code = {}, username = {}, Message = {}, ArrayOfValues = {}"
                ,code, username, message, arrayOfValues
        );
        log.info("mi-log parametros @Values:\n code = {},\n username = {},\n Message = {},\n ArrayOfValues = {}"
                ,code, username, message, arrayOfValues
        );

        //obteniendo un campo @Value, mediante lenguaje expresion spring
        log.info("mi-log SpringExpressionLenguage(SpEL) @Value:\n ListOfValues = {},\n" +" FieldOfList = {}"
                ,listOfValues, fieldOfList
        );
    }

    /*END-POINTS */

    @GetMapping(path = "/values")
    public Map<String, Object> getValues(
            @Value("${config.password}") String password,
            @Value("${config2.date}") LocalDate date,
            @Value("#{ ${config2.product} }") Map<String, Object> valuesMapJSON,
            @Value("#{ ${config2.product}.price }") Float priceOfMapJSON,
            @Value("#{ ${config2.product}.name }") String nameOfMapJSON

            // ,@Value("#{ ${config2.product} }") ProductValueController objeto
    ) {
        showAplicationPropertyValues();
        //
        Map<String, Object> json= new HashMap<>();
        //->@Value inyectado desde ATRIBUTOS
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        //->@Value inyectado desde METODO
        json.put("password", password);
        json.put("date", date);
        json.put("valuesMapJSON", valuesMapJSON);
        json.put("priceOfMapJSON", priceOfMapJSON);
        //
        // json.put("objeto", objeto);
        //________________________________________________________________________________________________________
        json.put("nameOfMapJSON", nameOfMapJSON);
        // json.put("nameOfMapJSON2", enviroment.getProperty("config2.date", "no-existe-propiedad date"));

        json.put("nameOfMapJSON2", enviroment.getProperty("config2.product", "no-existe-propiedad product"));
        // json.put("nameOfMapJSON2", enviroment.getProperty("config2.product.name", "no-existe-propiedad product.name"));

        return json;
    }
    
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    /**
     * OBTENER-JSON
     *  - Para usar en POSTMAN, por el servicio metodo POST en:
     *          -@PostMapping(path = {"/create/{idPersona}"})
     */
    @GetMapping(path = {"/json"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Object> getPostJSON() {
        UserRequest json = new UserRequest();
        String[] phones = {"312", "305"};
        json.setNit(1L); json.setName("B"); json.setContactNumbers( phones );
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
    @PostMapping(path = {"/create/{idPersona}"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuario(
            @RequestBody UserRequest bodyRequest
    ) {
        Object body;
        try {
            log.info("optUser: {}", bodyRequest);
            body = bodyRequest;

        } catch (Exception err) {
            this.responseEr.setPropiedadHashMap(
                "mensaje del error",//dato nulo, campo duplicado, cualquier cosa
                err.getCause(),
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
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    @GetMapping(path = {"/get/{idPersona}"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuario(
            @PathVariable Integer idPersona
    ) {
        Object body;
        try {
            Optional<User> optUser = service.getUser(idPersona);
            log.info("optUser: {}", optUser);
            if (optUser.isEmpty()) {
                throw new Exception("Usuario invalido");
            }
            body = optUser.get();

        } catch (Exception err) {
            this.responseEr.setPropiedadHashMap(
                "No se puede consultar el usuario ID<".concat(idPersona.toString().concat(">")),
                err.getMessage().concat(": ").concat(err.getLocalizedMessage()), //dato nulo, campo duplicado, objeto-cualquier cosa
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
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    //http://localhost:8080/api/pathVariable/getMixParams/televisor oled LG/89/1
    @GetMapping(path = {"/getMixParams/{product}/{id}/{idUser}"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<AbstractResponse> usuarioMixParams(
            @PathVariable String product,
            @PathVariable Long id,
            @PathVariable Integer idUser
    ) {
        Object body;
        try {
            Optional<User> optUser = service.getUser(idUser);
            if (optUser.isEmpty()) {
                throw new Exception("Usuario invalido");
            }
            Map<String, Object> json = Map.ofEntries(
                Map.entry("product", product),
                Map.entry("id", id),
                Map.entry("user", optUser.get())
            );
            body = json;

        } catch (Exception err) {
            this.responseEr.setPropiedadHashMap(
                "No se puede consultar ID<".concat(id.toString().concat(">")),
                err.getMessage().concat(": ").concat(err.getLocalizedMessage()), //dato nulo, campo duplicado, objeto-cualquier cosa
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
