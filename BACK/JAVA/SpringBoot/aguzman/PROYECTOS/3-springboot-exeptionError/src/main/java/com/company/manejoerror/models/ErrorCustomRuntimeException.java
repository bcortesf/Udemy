package com.company.manejoerror.models;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class ErrorCustomRuntimeException extends RuntimeException {
    private String error;
    private String message;
    private Integer status;
    private LocalDate date;


    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
