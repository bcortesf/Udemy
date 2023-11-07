/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.example3.JDK8_optional;

/**
 *
 * @author BryanCFz
 */
public enum DiaSemana {
        LUNES("Lunes",1),
        MARTES("Martes",2),
        MIERCOLES("Miercoles",3),
        JUEVES("Jueves",4),
        VIERNES("Viernes",5),
        SABADO("Sabado",6),
        DOMINGO("Domingo",7);
        
        private final String nombre;
        private final int dia;

    private DiaSemana(String nombre, int dia) {
        this.nombre = nombre;
        this.dia = dia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDia() {
        return dia;
    }

    /*
    @Override
    public String toString() {
        return "DiaSemana{" + "nombre=" + nombre + ", dia=" + dia + '}';
    }
    */
}
