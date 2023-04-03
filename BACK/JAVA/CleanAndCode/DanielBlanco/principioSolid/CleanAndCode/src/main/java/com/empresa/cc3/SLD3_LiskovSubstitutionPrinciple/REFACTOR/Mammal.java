/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD3_LiskovSubstitutionPrinciple.REFACTOR;

import com.empresa.cc3.SLD3_LiskovSubstitutionPrinciple.*;

/**
 *
 * @author brycorfe
 */
public class Mammal {

    //ATRIBUTES
    private Integer weight;
    private Integer ageInDays;
    
    
    //METHODS
    /*public void walk(){
        System.out.println("I am walking");
    }*/


    //GETTERS && SETTERS
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAgeInDays() {
        return ageInDays;
    }

    public void setAgeInDays(Integer ageInDays) {
        this.ageInDays = ageInDays;
    }
    
}
