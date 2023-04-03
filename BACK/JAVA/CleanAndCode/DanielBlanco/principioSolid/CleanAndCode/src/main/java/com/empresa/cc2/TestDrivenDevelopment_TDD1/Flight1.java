/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author brycorfe
 */
public class Flight1 {
    
    private String referencia;
    private LocalDateTime fechaSalida;
    private String origen;
    private String destino;
    //
    private List<Flight1> listaVuelos = new ArrayList<>();
    

    /*CONSTRUCTOR*/
    public Flight1() {    
    }

    public Flight1(String referencia, LocalDateTime fechaSalida, String origen, String destino) {
        this.referencia = referencia;
        this.fechaSalida = fechaSalida;
        this.origen = origen;
        this.destino = destino;
    }
    
                                /*METHODS*/
    public void addFlight(Flight1 vuelo) {
        this.listaVuelos.add(vuelo);
    }
    
    public Flight1 getByReferenceReturnFlight(String reference) {
        Flight1 vueloReferencia = new Flight1();

        for (Flight1 flight : listaVuelos) {
            if (flight.referencia.equalsIgnoreCase(reference)) {
                vueloReferencia = flight;
            }
        }
        return vueloReferencia;
    }

    public List<Flight1> getByOriginFlight(String origin) {
        List<Flight1> vuelosReferenciados = new ArrayList<>();

        for (Flight1 vuelo : listaVuelos) {
            if (vuelo.origen.equalsIgnoreCase(origin)) {
                //vuelosReferenciados.add(this);
                vuelosReferenciados.add(vuelo);
            }
        }
        return vuelosReferenciados;
    }

    
                                /*METHODS GENERATE AUTOMATIC*/
    // ALT + INS
    
                                /*GETTERS && SETTERS*/
    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the fechaSalida
     */
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the listaVuelos
     */
    public List<Flight1> getListaVuelos() {
        return listaVuelos;
    }

    /**
     * @param listaVuelos the listaVuelos to set
     */
    public void setListaVuelos(List<Flight1> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    

}
