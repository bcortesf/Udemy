/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.persistence;


import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.HEmployee;
import java.util.List;

/**
 *
 * @author brycorfe
 */
public interface IEmployeePersistenceAbstracProduct {
    
    public void save(HEmployee employe);
    public List<HEmployee> findAll();
    
}
