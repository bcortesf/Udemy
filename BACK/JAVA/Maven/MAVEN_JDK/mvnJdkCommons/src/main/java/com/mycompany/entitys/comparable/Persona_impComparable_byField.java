/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entitys.comparable;

import com.mycompany.enums.PersonaOrderEnum;

/**
 *
 * @author BryanCFz
 */
public class Persona_impComparable_byField implements Comparable<Persona_impComparable_byField> {
    private int id;
    private String nombre;
    private int edad;
    private String pais;
    
    private PersonaOrderEnum CAMPO_ORDER;

    public Persona_impComparable_byField(int id, String nombre, int edad, String pais
            ,PersonaOrderEnum CAMPO_ORDER) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
        
        this.CAMPO_ORDER = CAMPO_ORDER;
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
    public int compareTo(Persona_impComparable_byField persona) {
        if (this.CAMPO_ORDER.equals(PersonaOrderEnum.NOMBRE)) {
            return this.nombre.compareTo(persona.getNombre());
        }
        if (this.CAMPO_ORDER.equals(PersonaOrderEnum.PAIS)) {
            return this.pais.compareTo(persona.getPais());
        }
        if (this.CAMPO_ORDER.equals(PersonaOrderEnum.ID)) {
            return Integer.compare(this.id, persona.getId());
        }
        if (this.CAMPO_ORDER.equals(PersonaOrderEnum.EDAD)) {
            return this.edad - persona.getEdad();
        }
        return 0;
    }
    
}
