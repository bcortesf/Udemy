/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD2_OpenClosedPrinciple.REFACTOR;

/**
 *
 * @author brycorfe
 */
public class HEmploye {
    protected String fullName; 
    private Integer salary;

    protected HEmploye(String fullName, Integer salary) {
        this.fullName = fullName;
        this.salary = salary;
    }
    
    //GETTERS && SETTERS
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
}
