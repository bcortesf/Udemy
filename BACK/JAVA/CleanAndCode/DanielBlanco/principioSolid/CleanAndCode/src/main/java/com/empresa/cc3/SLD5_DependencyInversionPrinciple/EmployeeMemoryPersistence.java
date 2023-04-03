/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple;

import com.empresa.cc3.SLD2_OpenClosedPrinciple.*;
import java.util.List;

/**
 *
 * @author brycorfe
 */
public class EmployeeMemoryPersistence implements IEmployeePersistence{
    
    //ATRIBUTES
    private List<HEmployee> employes;
    
    //CONSTRUCTORS
    public EmployeeMemoryPersistence(List<HEmployee> employes){
        this.employes = employes;
    }
    
    //METHODS
    @Override
    public void save(HEmployee employe) {
        this.employes.add(employe);
    }
    
    @Override
    public List<HEmployee> findAll(){
        return employes;
    }
    
    //GETTERS && SETTERS
    public List<HEmployee> getProgrammers() {
        return employes;
    }

    public void setProgrammers(List<HEmployee> employes) {
        this.employes = employes;
    }
    
}
