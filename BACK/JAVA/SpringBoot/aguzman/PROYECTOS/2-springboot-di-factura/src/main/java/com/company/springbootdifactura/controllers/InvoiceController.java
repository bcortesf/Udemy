package com.company.springbootdifactura.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springbootdifactura.services.IInvoiceService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "invoice")
public class InvoiceController {
    // private Map<String, Object> json;
    private IInvoiceService service;

    public InvoiceController(/*Map<String, Object> json,*/ IInvoiceService service) {
        // this.json = json;
        this.service = service;
    }

    @GetMapping(value = "list")
    public Map<String, Object> getFindAll() {
        Map<String, Object> json = new HashMap<>();
        json.put("invoice", this.service.findAll());
        return json;
    }
}
