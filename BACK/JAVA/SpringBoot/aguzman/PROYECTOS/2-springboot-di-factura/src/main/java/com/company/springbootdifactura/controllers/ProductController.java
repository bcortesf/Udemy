package com.company.springbootdifactura.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springbootdifactura.services.IProductService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private Map<String, Object> json;
    private IProductService service;

    public ProductController(IProductService service) {
        this.json = new HashMap<>();
        this.service = service;
    }

    @GetMapping(path = "/get/{idProduct}")
    public Map<String, Object> getMethodName(
            @PathVariable Long idProduct) {
        json.put("product", this.service.findById(idProduct));
        return json;
    }
}
