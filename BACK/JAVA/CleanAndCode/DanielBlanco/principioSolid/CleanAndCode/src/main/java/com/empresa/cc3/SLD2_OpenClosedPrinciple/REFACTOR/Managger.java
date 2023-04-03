/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD2_OpenClosedPrinciple.REFACTOR;

/**
 *
 * @author brycorfe
 */
public class Managger extends  HEmploye {
    //ATRIBUTES
    private Integer bonusSalary; 

    //CONSTRUCTORS
    public Managger(String fullName, Integer salary, Integer bonusSalary) {
        super(fullName, salary);
        this.bonusSalary = bonusSalary;
    }

    //METHODS
    @Override
    public String toString() {
        return "\tManagger{" + "fullName=" + super.fullName 
                + ", salary=" + super.getSalary() + ", bonusSalary=" + this.bonusSalary + '}';
    }
    
    //GETTERS && SETTERS
    public void setBonusSalary(Integer bonusSalary) {
        this.bonusSalary = bonusSalary;
    }
  
}
