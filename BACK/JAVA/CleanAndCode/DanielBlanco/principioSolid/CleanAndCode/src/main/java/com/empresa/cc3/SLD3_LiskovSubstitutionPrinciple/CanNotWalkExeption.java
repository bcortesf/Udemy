/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD3_LiskovSubstitutionPrinciple;

/**
 *
 * @author brycorfe
 */
public class CanNotWalkExeption extends RuntimeException {
    
    //CONSTRUCTOR
    public CanNotWalkExeption(String message) {
        super(message);
    }
}
