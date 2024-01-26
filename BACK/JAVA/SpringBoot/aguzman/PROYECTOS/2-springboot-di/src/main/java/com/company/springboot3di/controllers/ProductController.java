package com.company.springboot3di.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot3di.models.Product;
import com.company.springboot3di.services.ProductService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(path = "/list")
    public Map<String, Object> getList() {
        Map<String, Object> json = new HashMap<>();
        json.put("almacen", "Alkosto");
        json.put("products", this.service.findAll());
        return json;
    }

    @GetMapping(path = "/list-taxPrice")
    public Map<String, Object> getListTaxPrice() {
        Map<String, Object> json = new HashMap<>();
        json.put("almacen", "Alkosto");
        json.put("products", getList());
        json.put("productsTaxt", this.service.findTaxAll());
        json.put("tax", "21%");
        return json;
    }

    @GetMapping(path = "/find/{idProduct}")
    public Map<String, Object> getObj(
            @PathVariable Long idProduct
    ) {
        Optional<Product> optProduct = this.service.findById(idProduct);
        Object product = (optProduct.isEmpty()) ? "El producto, no se encuentra en stock" : optProduct.get();

        Map<String, Object> json = new HashMap<>();
        json.put("almacen", "Alkosto");
        json.put("product", product);
        return json;
    }

}
