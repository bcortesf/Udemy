/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc2.TestDrivenDevelopment_TDD2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author brycorfe
 */
public class Flight2 {
    
    private String referencia;
    private LocalDateTime fechaSalida;
    private String origen;
    private String destino;
    
    
                                    /*CONSTRUCTOR*/
    /**
     * 
     * @param referencia
     * @param fechaSalida
     * @param origen
     * @param destino 
     */
    public Flight2(String referencia, LocalDateTime fechaSalida, String origen, String destino) {
        this.referencia = referencia;
        this.fechaSalida = fechaSalida;
        this.origen = origen;
        this.destino = destino;
    }
     
                                /*METHODS GENERATE AUTOMATIC*/
    // ALT + INS

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.referencia);
        hash = 29 * hash + Objects.hashCode(this.fechaSalida);
        hash = 29 * hash + Objects.hashCode(this.origen);
        hash = 29 * hash + Objects.hashCode(this.destino);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight2 other = (Flight2) obj;
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        if (!Objects.equals(this.origen, other.origen)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        return Objects.equals(this.fechaSalida, other.fechaSalida);
    }

    
    
    
    
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

}
