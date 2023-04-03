/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.factory;

import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence.IEmployeePersistenceAbstracProduct;

/**
 *
 * @author brycorfe
 */

/**************************/
/*    ABSTRACT-FACTORY    */
/**************************/
/**
 * Es la interfaz de factorias que van a tener todas, un metodo que va a crear
 * un tipo de persistencia de empleados.
*/
public interface IEmployeePersistenceAbstractFactory {
    
    //Create persistence
    public IEmployeePersistenceAbstracProduct getEmployeePersistence();
     
}
