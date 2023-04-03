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
public class ProgrammerMemoryPersistence implements IPersistenceEmploye{
    
    //ATRIBUTES
    private List<Programmer> programmers;
    
    //CONSTRUCTORS
    public ProgrammerMemoryPersistence(List<Programmer> programmers){
        this.programmers = programmers;
    }
    
    //METHODS
    @Override
    public void save(Programmer programmer) {
        this.programmers.add(programmer);
    }
    
    @Override
    public List<Programmer> findAll(){
        return programmers;
    }
    
    //GETTERS && SETTERS
    public List<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(List<Programmer> programmers) {
        this.programmers = programmers;
    }
    
    
}
