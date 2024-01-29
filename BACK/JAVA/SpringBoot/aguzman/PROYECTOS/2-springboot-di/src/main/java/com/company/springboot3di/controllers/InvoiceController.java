package com.company.springboot3di.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3di.services.IInvoiceService;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/invoice")
public class InvoiceController {

    private IInvoiceService service;

    public InvoiceController(IInvoiceService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public Map<String, Object> getList() {
        Map<String, Object> json = new HashMap<>();
        json.put("list", this.service.findAll());
        return json;
    }

    @GetMapping("/get/{idInvoice}")
    public Map<String, Object> getObj(
        @PathVariable Long idInvoice
    ) {
        Map<String, Object> json = new HashMap<>();
        json.put("obj", this.service.findById(idInvoice));
        return json;
    }
}
