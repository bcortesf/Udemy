/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD2_OpenClosedPrinciple;

import java.util.List;

/**
 *
 * @author brycorfe
 */
public class Company {
    
    //ATRIBUTES
    private ProgrammerMemoryPersistence persistence;
    
    //CONSTRUCTOR
    public Company(List<Programmer> programmers) {
        this.persistence = new ProgrammerMemoryPersistence(programmers);
    }
    
    //METHODS
    public List<Programmer> getProgrammers(){
        return persistence.findAll();
    }
    
    public void addProgrammer(String fullName, Integer salary, String language) {
        persistence.save(new Programmer(fullName, salary, language));
    }
    
    
}
