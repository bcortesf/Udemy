package com.company.springboot3di.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.springboot3di.models.Client;

@Component
public class ClientData {
    private final List<Client> list;

    public ClientData() {
        this.list = Arrays.asList(
            new Client(1L, "ClientA"),
            new Client(2L, "ClientB")
        );
    }

    public List<Client> getList() {
        return list;
    }

}