/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence;


import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.HEmployee;
import java.util.List;

/**
 *
 * @author brycorfe
 */

/**************************/
/*    PRODUCT-CONCRET-1    */
/**************************/
public class EmployeeMemoryPersistencePRODUCT1 implements IEmployeePersistenceAbstracProduct{
    
    //ATRIBUTES
    private List<HEmployee> employees;
    
    //CONSTRUCTORS
    public EmployeeMemoryPersistencePRODUCT1(List<HEmployee> listEmployes) {
        this.employees = listEmployes;
    }
    
    //METHODS IMPLEMENTS
    @Override
    public void save(HEmployee employe) {
        this.employees.add(employe);
    }
    
    @Override
    public List<HEmployee> findAll(){
        return employees;
    }
    
}
