/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD2_OpenClosedPrinciple.REFACTOR;

import java.util.List;

/**
 *
 * @author brycorfe
 */
public class EmployeMemoryPersistence implements IEmployePersistence{
    
    //ATRIBUTES
    private List<HEmploye> employes;
    
    //CONSTRUCTORS
    public EmployeMemoryPersistence(List<HEmploye> employes){
        this.employes = employes;
    }
    
    //METHODS
    @Override
    public void save(HEmploye employe) {
        this.employes.add(employe);
    }
    
    @Override
    public List<HEmploye> findAll(){
        return employes;
    }
    
    //GETTERS && SETTERS
    public void setEmployes(List<HEmploye> employes) {
        this.employes = employes;
    }
       
}
