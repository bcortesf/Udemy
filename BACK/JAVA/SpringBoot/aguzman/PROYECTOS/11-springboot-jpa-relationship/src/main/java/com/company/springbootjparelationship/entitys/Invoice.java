package com.company.springbootjparelationship.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double total;


    /* LLAVE_FORANEA(nombramiento-pordefecto):
     * <NOMBRE-ATRIBUTO> + <ID>   =   "client_id" */
    @ManyToOne  //ManyInvoice_To_OneClient
    private Client client;


    public Invoice() {
    }
    public Invoice(String description, Double total) {          //create
        this.description = description;
        this.total = total;
    }
    public Invoice(Long id, String description, Double total) { //update
        this.id = id;
        this.description = description;
        this.total = total;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }


    public Invoice getInvoice(){
        return this;
    }


    @Override
    public String toString() {
        return "Invoice {id=" + id + ", description=" + description + ", total=" + total + ", client=" + client + "}";
    }
}
