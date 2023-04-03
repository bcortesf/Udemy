/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.factory;



import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.HEmployee;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence.EmployeeMemoryPersistencePRODUCT1;
import java.util.List;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence.IEmployeePersistenceAbstracProduct;

/**
 *
 * @author brycorfe
 */

/**************************/
/*    FACTORY-CONCRET-1    */
/**************************/
public class EmployeeMemoryPersistenceFCONCRET1 implements IEmployeePersistenceAbstractFactory {

    //ATRIBUTES
    private List<HEmployee> employees;
    
    //CONSTRUCTOR
    public EmployeeMemoryPersistenceFCONCRET1(List<HEmployee> employees) {
        this.employees = employees;
    }
    
    //METHODS IMPLEMENTS
    @Override
    public IEmployeePersistenceAbstracProduct getEmployeePersistence() {
        //Create persistence
        return new EmployeeMemoryPersistencePRODUCT1(employees) ;
    }
    
}
