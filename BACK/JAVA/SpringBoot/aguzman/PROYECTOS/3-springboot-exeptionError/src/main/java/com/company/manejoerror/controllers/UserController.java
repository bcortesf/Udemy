package com.company.manejoerror.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.manejoerror.exceptions.UserNotFoundException;
import com.company.manejoerror.models.domains.User;
import com.company.manejoerror.services.UserService;


@RestController
@RequestMapping(path = "user")
public class UserController {
    private UserNotFoundException userNotFoundException;
    private UserService service;


    public UserController(UserNotFoundException userNotFoundException, UserService service) {
        this.userNotFoundException = userNotFoundException;
        this.service = service;
    }

    @GetMapping("list")
    public List<User> getlist() {
        return this.service.findAll();
    }


    @GetMapping("getEXa/{idUser}")
    public User getExceptionA(@PathVariable Long idUser) {
        /*FORMA-1 */
        return this.service.findById1(idUser).orElseThrow();

        /*FORMA-2 */
        // return this.service.findById1(idUser).orElseThrow(() -> {
        //     //->En caso de no encontrar el usuario
        //     userNotFoundException.setIdUser(idUser);
        //     userNotFoundException.setMessage("Usuario no existente - CONTROLLER!");
        //     userNotFoundException.setDateTime(LocalDateTime.now());
        //     userNotFoundException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        //     throw userNotFoundException;
        // });
    }
    @GetMapping("getEXb/{idUser}")
    public User getExceptionB(@PathVariable Long idUser) /*throws UserNotFoundException, NoSuchElementException*/ {
        Optional<User> optUser = this.service.findById1(idUser);
        if (optUser.isEmpty()) {
            userNotFoundException.setIdUser(idUser);
            userNotFoundException.setMessage("Usuario no existe");
            userNotFoundException.setDateTime(LocalDateTime.now());
            userNotFoundException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            throw userNotFoundException;
        }
        return optUser.get();
    }
    @GetMapping("getEXc/{idUser}")
    public User getExceptionC(@PathVariable Long idUser) throws UserNotFoundException {
        User user = this.service.findById2(idUser);
        if (user == null) {
            /*FORMA-1 */
            // throw new UserNotFoundException(idUser, "Usuario no existe");

            /*FORMA-2 */
            userNotFoundException.setIdUser(idUser);
            userNotFoundException.setMessage("Usuario no existe");
            userNotFoundException.setDateTime(LocalDateTime.now());
            userNotFoundException.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            throw userNotFoundException;
        }
        return user;
    }


    @GetMapping("get/{idUser}")
    public User get(@PathVariable Long idUser) {
        User user = this.service.findById2(idUser);
        System.out.println(user.getName());
        return user;
    }

}
