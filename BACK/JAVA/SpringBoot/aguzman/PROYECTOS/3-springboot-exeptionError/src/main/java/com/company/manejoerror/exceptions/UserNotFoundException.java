package com.company.manejoerror.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserNotFoundException extends RuntimeException {
    private Long idUser;
    private String message;
    private LocalDateTime dateTime;
    private HttpStatus status;


    @Autowired
    public UserNotFoundException() {
    }
    public UserNotFoundException(Long idUser, String message) {
        super(message);
        this.message = "mi mensaje que no se ve";
        this.idUser = idUser;
    }
    public UserNotFoundException(Long idUser, String message, LocalDateTime dateTime, HttpStatus status) {
        this.idUser = idUser;
        this.message = message;
        this.dateTime = dateTime;
        this.status = status;
    }

    //
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    //
    public String getIdNameUser() {
        return message.concat(" ,Con Id:".concat(String.valueOf(idUser)));
    }

}
