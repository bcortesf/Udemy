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
public class Company {
    
    //ATRIBUTES
//    private EmployeMemoryPersistence persistence;
    private IEmployePersistence persistence;
    
    //CONSTRUCTOR
    public Company(List<HEmploye> empleados) {
        this.persistence = new EmployeMemoryPersistence(empleados);
    }
    
    //METHODS
    public List<HEmploye> getEmployes(){
        return persistence.findAll();
    }
    
    public void addEmploye(HEmploye employe) {
        persistence.save(employe);
    }
    
}
