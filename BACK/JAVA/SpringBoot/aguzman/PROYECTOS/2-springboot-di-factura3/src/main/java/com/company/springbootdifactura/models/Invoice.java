package com.company.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {
    private Long id;
    @Value(value = "${model.invoice.name}")
    private String name;
    /*@Autowired */private Client client; /*:inyectado por constructor*/

    /*  GENERAR INSTANCIA  (tipo"@Autowired"); para librerias-clases que no son creadas por mi:
            - "List, JPARepository, Clonnable, Map, HaspMap.. ETC"
     * .\src\main\java\com\company\springbootdifactura\configuration\InvoiceConfiguration.java
     * <InvoiceConfiguration>.List<InvoiceItem> invoiceGetItems()
     */
    @Autowired
    private List<InvoiceItem> items;
    private Float total;


    @Autowired
    public Invoice(Client client) {       /*:inyectado por constructor*/
        this.client = client;
    }
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

    /*Generar en JSON: nuevo atributo "totalAutomatic"
     * Crea atributo "totalAutomatic", se mapea y ejecuta automaticamente
     * No se necesita llamar este metodo en nuestra logica de "InvoiceRepositoryImpl.class"
     */
    public Float getTotalAutomatic() {
        // return 0f;
        // return totalCalculatedJDK7();
        return totalCalculatedJDK8a();
        // return totalCalculatedJDK8b();
    }

    ///////
    private Float totalCalculatedJDK7() {
        float invTotal = 0f;
        for (InvoiceItem invoiceItem : items) {
            invTotal += invoiceItem.getImporte();
        }
        return invTotal;
    }
    private Float totalCalculatedJDK8a() {
        //         identity=0; ~ sumAcumulator=identity=0
        //                       (sumAcumulator+importeValue) === sumAcumulator+=importeValue
        return items.stream()
            .map(InvoiceItem::getImporte)
            .reduce(0f, (sumAcumulator, importeValue) -> sumAcumulator + importeValue);
    }
    private Float totalCalculatedJDK8b() {
        return (float)items.stream()
            .mapToDouble(InvoiceItem::getImporte)
            .sum();
    }
}
