package com.bcf.jwt1.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * los permisos de cada path, de los endpoints, esta configurada en
 * package com.bcf.jwt1.config;
 *      [SecurityConfiguration.class]
 */
@RestController
@RequestMapping(path = "/api")
public class ApiController {

    /* No tiene ninguna autenticacion */
    @GetMapping(path = "/public")
    public ResponseEntity<String> getPublicEndpoint() {
        return ResponseEntity.ok("Hello this is  public  endpoint");
    }
    /* Información para el rol de ADMIN */
    @GetMapping(path = "/private")
    public ResponseEntity<String> getPrivateEndpoint() {
        return ResponseEntity.ok("Hello this is  private  endpoint");
    }
    /* Información para el rol de MANAGER */
    @GetMapping(path = "/manager")
    public ResponseEntity<String> getManagerEndpoint() {
        return ResponseEntity.ok("Hello this is manager  endpoint");
    }


    /* AUTENTICACION CON JWT
        - Mandar información con el "Bearer <TOKEN>"
     **/
    @GetMapping(path = "/admin")
    public ResponseEntity<String> getDashboardEndpoint() {
        return ResponseEntity.ok("Hello this is  Admin Dashboard JWT  endpoint");
    }

}
