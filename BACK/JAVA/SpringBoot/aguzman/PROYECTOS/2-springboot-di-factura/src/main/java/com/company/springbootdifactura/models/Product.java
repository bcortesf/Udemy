package com.company.springbootdifactura.models;

import java.time.LocalDate;

public class Product implements Cloneable {
    private Long id;
    private String name;
    private LocalDate expirationDate;


    public Product() {
    }
    public Product(Long id, String name, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", expirationDate=" + expirationDate + "]";
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(id, name, expirationDate);
        }
    }
}
