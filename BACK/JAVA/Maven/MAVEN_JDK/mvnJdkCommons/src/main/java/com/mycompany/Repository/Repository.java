/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Repository;

import com.mycompany.entitysClass.Persona;
import com.mycompany.entitysRecords.Nota;
import com.mycompany.entitysClass.lombok.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BryanCFz
 */
public class Repository {
    private List<Nota> notas;
    private List<Persona> personas;
    private List<Producto> productos;

    public Repository() {
        llenarNotas();
        llenarPersonas();
        llenarProductos();
    }


    //->FULL DATA ARRAYS
    private void llenarNotas() {    //class
        notas = new ArrayList<>();
        notas.add(new Nota("matematicas",3));   //11.length
        notas.add(new Nota("quimica",10));       //7.length
        notas.add(new Nota("ingles-basico",5.1)); //13.length
        notas.add(new Nota("ingles-medio",5.2));  //12.length
        notas.add(new Nota("fisica",7));         //6.length
    }
    private void llenarPersonas() { //records
        Persona persona1 = new Persona(1, "Mito", LocalDate.of(1991, 1, 21));
        Persona persona2 = new Persona(2, "Code", LocalDate.of(1990, 2, 21));
        Persona persona3 = new Persona(3, "Bryan", LocalDate.of(1980, 6, 23));
        Persona persona4 = new Persona(4, "Shushi", LocalDate.of(2019, 5, 15));
        Persona persona5 = new Persona(5, "Minnie", LocalDate.of(2010, 1, 4));
//        personas = Arrays.asList(persona1, persona2, persona3, persona4, persona5);

        Persona p6 = new Persona(6, "P6", LocalDate.of(1991, 1, 21));
        Persona p7 = new Persona(7, "P7", LocalDate.of(1991, 1, 21));
        personas = Arrays.asList(persona1, persona2, persona3, persona4, persona5,
        p6,p7);
        
    }
    private void llenarProductos() { //lombok
        Producto producto1 =  new Producto(1, "Ceviche",15.0);
        Producto producto2 =  new Producto(2, "Chilaquiles",25.50);
        Producto producto3 =  new Producto(3, "Bandeja paisa",35.50);
        Producto producto4 =  new Producto(4, "Ceviche",15.0);
        productos = Arrays.asList(producto1, producto2, producto3, producto4);
    }

    //->GETTERS
    public List<Nota> getNotas() {
        return notas;
    }
    public List<Persona> getPersonas() {
        return personas;
    }
    public List<Producto> getProductos() {
        return productos;
    }

}
