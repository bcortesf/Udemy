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
public class Company {
    
    //ATRIBUTES
    private IEmployeePersistence persistence;
    
    //CONSTRUCTOR
    public Company(List<HEmployee> employees) {
        //ERROR: La clase depende de implementaciones concretas
        //       Es la clase la encargada de crear el tipo de persistencia que queria (CLASE-CONCRETA)
        this.persistence = new EmployeeMemoryPersistence(employees);
    }
    
    //METHODS
    public List<HEmployee> getEmployes(){
        return persistence.findAll();
    }
    
    public void addEmployes(HEmployee employee) {
        persistence.save(employee);
    }
    
    
}
