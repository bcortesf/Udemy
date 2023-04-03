/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc2.TestUnitarios_JUnit;

/**
 *
 * @author brycorfe
 */
public class Calculadora {
    
    public Double multiply(Double numA, Double numB) {
        return numA * numB;
    }
    
    public Double divide(Double numA, Double numB) {
        if(numB == 0) 
            throw new DivisionByZeroException("the second parameter was 0. This is not allowed");
        return numA / numB;
    }
    
    public Double abs(Double numA) {
        if (numA >= 0)
            return numA;
        return -numA;
    }
    
    public Double higherValue(Double numA, Double numB) {
        if (numA >= numB)
            return numA;
        return numB;
    }
    
}
