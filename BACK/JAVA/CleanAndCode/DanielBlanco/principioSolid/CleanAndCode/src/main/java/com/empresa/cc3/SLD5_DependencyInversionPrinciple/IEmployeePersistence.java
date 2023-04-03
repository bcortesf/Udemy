/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple;

import com.empresa.cc3.SLD2_OpenClosedPrinciple.*;
import java.util.List;

/**
 *
 * @author brycorfe
 */
public interface IEmployeePersistence {
    
    public void save(HEmployee employe);
    public List<HEmployee> findAll();
    
}
