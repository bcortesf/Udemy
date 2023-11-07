/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;
import com.mycompany.entitysClass.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BryanCFz
 */
public class Service {
    private final List<Persona> persons;
    
    public Service() {
        persons = new ArrayList<>();
    }
    public void registrarPersona(Persona p) {
        persons.add(p);
    }
    public List<Persona> getPersons(){
        return persons;
    }
}
