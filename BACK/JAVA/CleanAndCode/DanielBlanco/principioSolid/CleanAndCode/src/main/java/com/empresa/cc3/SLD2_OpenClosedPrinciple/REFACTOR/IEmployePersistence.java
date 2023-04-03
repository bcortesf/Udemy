/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.empresa.cc3.SLD2_OpenClosedPrinciple.REFACTOR;

import java.util.List;

/**
 *
 * @author brycorfe
 */
public interface IEmployePersistence {
    
    public void save(HEmploye employe);
    public List<HEmploye> findAll();
    
}
