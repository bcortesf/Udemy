package com.company.springboot3di.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3di.services.IClientService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private IClientService service;

    public ClientController(
            IClientService service) { //->Tiene configurado un @Primary, sobre "Client1ServiceImpl"
        this.service = service;
    }

    @GetMapping(path = "list")
    public Map<String, Object> getlist() {
        Map<String, Object> json = new HashMap<>();
        json.put("clientes", this.service.findAll());
        return json;
    }

}
