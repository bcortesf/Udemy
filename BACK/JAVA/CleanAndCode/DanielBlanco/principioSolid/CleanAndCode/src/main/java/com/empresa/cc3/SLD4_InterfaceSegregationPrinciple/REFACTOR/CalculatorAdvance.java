/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD4_InterfaceSegregationPrinciple.REFACTOR;

import com.empresa.cc3.SLD4_InterfaceSegregationPrinciple.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brycorfe
 */
public class CalculatorAdvance implements IOPeracionBasic, IOPeracionAdvance {
    //CLIENTE-1

    @Override
    public Double add(Double num1, Double num2) {
        return num1 + num2;
    }

    @Override
    public Double subtract(Double num1, Double num2) {
        return num1 - num2;
    }

    @Override
    public Double multiply(Double num1, Double num2) {
        return num1 * num2;
    }

    @Override
    public Double divide(Double num1, Double num2) {
        if(num2 == 0){
            try {
                throw new Exception("No se puede dividir por cero");
            } catch (Exception ex) {
                Logger.getLogger(CalculatorAdvance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return num1 / num2;
    }

    @Override
    public Double sine(Double angle) {
        return Math.sin(angle);
    }

    @Override
    public Double cosine(Double angle) {
        return Math.cos(angle);
    }

}
