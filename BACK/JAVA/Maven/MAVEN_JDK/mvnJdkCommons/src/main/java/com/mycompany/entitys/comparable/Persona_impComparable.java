/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entitys.comparable;

import com.mycompany.entitysRecords.*;
import java.util.Objects;

/**
 *
 * @author BryanCFz
 */
public class Persona_impComparable implements Comparable<Persona_impComparable> {
    private int id;
    private String nombre;
    private int edad;
    private String pais;

    public Persona_impComparable(int id, String nombre, int edad, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", pais=" + pais + '}';
    }

    ////////////////////////////////////////////////////////////////////////////
    //metodo abstracto implementado de:            implements Comparable<Object>
    @Override
    public int compareTo(Persona_impComparable persona) {
        return this.edad - persona.getEdad();   //ASC
//        return persona.getEdad() - this.edad;   //DESC
//        return this.nombre.compareTo(persona.getNombre());    //ASC
    }
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + this.edad;
        hash = 59 * hash + Objects.hashCode(this.pais);
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
        final Persona_impComparable other = (Persona_impComparable) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.pais, other.pais);
    }
    
    
    
}
