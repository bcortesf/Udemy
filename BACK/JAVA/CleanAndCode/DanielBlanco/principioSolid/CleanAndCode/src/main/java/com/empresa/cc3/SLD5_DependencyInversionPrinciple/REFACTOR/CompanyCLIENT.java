/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR;

import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.HEmployee;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.factory.IEmployeePersistenceAbstractFactory;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence.IEmployeePersistenceAbstracProduct;
import java.util.List;


/**
 *
 * @author brycorfe
 */

/**************************/
/*    CLIENT    */
/**************************/
public class CompanyCLIENT {
    
    //ATRIBUTES
    private IEmployeePersistenceAbstracProduct persistence;//
    
    public IEmployeePersistenceAbstractFactory factory;
    
    
    //CONSTRUCTOR
    public CompanyCLIENT(IEmployeePersistenceAbstractFactory factory) {
        //            new EmployeeMemoryPersistenceFCONCRET1(employes)
        persistence = factory.getEmployeePersistence();
        
        //prueba mia
        this.factory = factory;
    }

    
    //METHODS
    public List<HEmployee> getEmployes(){
        return persistence.findAll();
    }
    
    public void addEmployes(HEmployee employee) {
        persistence.save(employee);
    }
    
    
}
