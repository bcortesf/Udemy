package com.company.springboot3di.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3di.services.InvoiceService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/bill")
public class InvoiceController {

    private InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public Map<String, Object> getList() {


        Map<String, Object> json = new HashMap<>();
        json.put("list", this.service.findAll());
        // json.put("", "");
        return json;
    }
    

}
