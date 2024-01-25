package com.company.springboot3di.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Invoice {
    private Long id;
    private Client client;
    private List<Product> products;


    public Invoice() {
        this.products = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> product) {
        this.products = product;
    }

    @Override
    public String toString() {
        return "Bill [id=" + id + ", client=" + client + ", products=" + products + "]";
    }

}
