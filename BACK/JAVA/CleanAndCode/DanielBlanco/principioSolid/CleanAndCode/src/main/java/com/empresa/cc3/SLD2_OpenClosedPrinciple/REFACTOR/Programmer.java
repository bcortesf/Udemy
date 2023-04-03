/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD2_OpenClosedPrinciple.REFACTOR;

/**
 *
 * @author brycorfe
 */
public class Programmer extends  HEmploye {
    //ATRIBUTES
    private String language; 

    //CONSTRUCTORS
    public Programmer(String fullName, Integer salary, String language) {
        super(fullName, salary);
        this.language = language;
    }

    //METHODS
    @Override
    public String toString() {
        if(this.language == null) {
            return "Programmer{" + "fullName=" + super.fullName + ", salary=" + super.getSalary() + '}';
        }
        return "Programmer{" + "fullName=" + super.fullName 
                + ", salary=" + super.getSalary() + ", LANGUAGE=" + this.language + '}';
    }
    
    //GETTERS && SETTERS
    public void setLanguage(String language) {
        this.language = language;
    }
  
}
