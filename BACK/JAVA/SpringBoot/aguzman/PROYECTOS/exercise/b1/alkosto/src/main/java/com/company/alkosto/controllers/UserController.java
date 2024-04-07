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
@RequestMapping(path = "/users")
public class UserController {

    private final IUserService service;
    public UserController(
            IUserService service)
    {
        this.service = service;
    }


    @GetMapping("/all")
    public List<User> listAll() {
        return this.service.findAll();
    }

    @PostMapping("/save")
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
