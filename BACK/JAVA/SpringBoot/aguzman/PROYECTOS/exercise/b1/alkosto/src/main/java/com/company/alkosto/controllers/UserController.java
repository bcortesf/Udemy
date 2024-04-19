package com.company.alkosto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.alkosto.entities.User;
import com.company.alkosto.services.IUserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final IUserService service;
    public UserController(
            IUserService service)
    {
        this.service = service;
    }


    /* ______________________________________________________________
     * ______________________________________________________________
     *                    ***PERFIL<ADMINISTRADOR>***
          * Estos metodos son         PRIVADOS
     *   - Al no tener un "path"  -  <GetMapping(path="algunaRuta1") y @PostMapping(path="algunaRuta2")>
     */

    @GetMapping
    public List<User> listAll() {
        return this.service.findAll();
    }
    /**
     * PERFIL<Administrador> :crear usuarios
     * @param userDTO
     * @param result
     * @return
     */
    @PostMapping
    public ResponseEntity<?> create(
            @Valid @RequestBody User userDTO, BindingResult result)
    {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body( this.service.save(userDTO) );
    }


    /* ______________________________________________________________
     * ______________________________________________________________
     *                    ***PERFIL<USUARIO>***
     * Estos metodos son         PUBLICOS
     *   - Al no tener un path <GetMapping y @PostMapping>
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(
                @Valid @RequestBody User userDTO, BindingResult result)
    {
        userDTO.setAdmin(false);
        return this.create(userDTO, result);
    }



    //----------------------------------------------------------
    //TODO: agregar validacion en otra clase"HELPPERS"
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach( err  ->
            errors.put(
                err.getField(),
                "El campo " + err.getField() + " " + err.getDefaultMessage()
            )
        );
        return ResponseEntity.badRequest().body(errors);
    }

}
