package com.company.springbootdifactura.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {
    @Value(value = "${model.client.id}")
    private Long id;
    @Value(value = "${model.client.name}")
    private String name;

    @Autowired
    public Client() {}
    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
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


    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + "]";
    }
}
