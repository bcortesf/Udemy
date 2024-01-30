package com.company.springbootdifactura.models;

import java.util.List;

public class Invoice {
    private Long id;
    private String name;
    private Client client;
    private List<InvoiceItem> items;
    private Float total;


    public Invoice(Long id, String name, Client client, List<InvoiceItem> items, Float total) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.items = items;
        this.total = total;
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
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public List<InvoiceItem> getItems() {
        return items;
    }
    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
    public Float getTotal() {
        return total;
    }
    public void setTotal(Float total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "Invoice [id=" + id + ", name=" + name + ", client=" + client + ", items=" + items + ", total=" + total
                + "]";
    }
}
