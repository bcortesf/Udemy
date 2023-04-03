/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.factory;



import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence.EmployeeSqlPersistencePRODUCT2;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence.IEmployeePersistenceAbstracProduct;

/**
 *
 * @author brycorfe
 */

/**************************/
/*    FACTORY-CONCRET-2    */
/**************************/
public class EmployeeSqlPersistenceFCONCRET2 implements IEmployeePersistenceAbstractFactory {

    @Override
    public IEmployeePersistenceAbstracProduct getEmployeePersistence() {
        return new EmployeeSqlPersistencePRODUCT2(
                System.getProperty("mysqlurl"), 
                System.getProperty("mysqluser"), 
                System.getProperty("mysqlpassword"));
    }
    
}
