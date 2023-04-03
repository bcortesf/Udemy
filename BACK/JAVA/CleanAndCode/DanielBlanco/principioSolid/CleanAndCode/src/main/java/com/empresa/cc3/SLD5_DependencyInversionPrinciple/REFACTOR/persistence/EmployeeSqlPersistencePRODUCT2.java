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
/*    PRODUCT-CONCRET-2    */
/**************************/
public class EmployeeSqlPersistencePRODUCT2 implements IEmployeePersistenceAbstracProduct {
    
    //CONSTRUCTORS
    public EmployeeSqlPersistencePRODUCT2(String url, String user, String password){
        System.out.println("Hacemos conexion con la base de datos SQL");
    }

    //METHODS
    @Override
    public void save(HEmployee employe) {
        System.out.println("guarda un empleado en SQL");
    }

    @Override
    public List<HEmployee> findAll() {
        System.out.println("obtiene lista de empleados en SQL");
        return null;
    }
    
}
