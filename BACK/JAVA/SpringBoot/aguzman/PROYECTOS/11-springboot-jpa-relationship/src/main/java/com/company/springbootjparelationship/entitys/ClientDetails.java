package com.company.springbootjparelationship.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/*
 * EJEMPLO : PARA CREAR OTRO ATRIBUTO EN UNA RELACION OneToOne
 * CONTEXTO HOSPITAL
 * Un Médico de medicina, Clinica, Hospitales
 * - Historial medico RELACION todo el detalle que ha realizado a este paciente o cliente
 * .
 */

@Entity
@Table(name = "clients_details")
public class ClientDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isPremium;
    private Integer points; //cantidad-de-puntos-acumulados



    public ClientDetails() {
    }
    public ClientDetails(boolean isPremium, Integer points) {
        this.isPremium = isPremium;
        this.points = points;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isPremium() {
        return isPremium;
    }
    public void setPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }



    @Override
    public String toString() {
        return "{id=" + id +
                ", isPremium=" + isPremium +
                ", points=" + points +
                "]";
    }
}
