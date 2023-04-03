/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD5_DependencyInversionPrinciple;

import com.empresa.cc3.SLD2_OpenClosedPrinciple.*;

/**
 *
 * @author brycorfe
 */
public class HEmployee {
    private String fullName; 
    private Integer salary;

    protected HEmployee(String fullName, Integer salary) {
        this.fullName = fullName;
        this.salary = salary;
    }
    
    //METHODS

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HEmployee{");
        sb.append("fullName=").append(fullName);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
    
    
    //GETTERS && SETTERS
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
}
