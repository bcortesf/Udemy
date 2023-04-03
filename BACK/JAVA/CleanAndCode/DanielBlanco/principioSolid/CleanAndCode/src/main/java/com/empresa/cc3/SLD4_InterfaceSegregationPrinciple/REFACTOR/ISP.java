/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc3.SLD4_InterfaceSegregationPrinciple.REFACTOR;

import com.empresa.cc3.SLD4_InterfaceSegregationPrinciple.*;

/**
 *
 * @author brycorfe
 */
public class ISP {
    
    public static void main(String[] args) {
        
        IOPeracionBasic   basic = new CalculatorBasic();
        System.out.println(basic.add(2.0, 3.0));
        
        IOPeracionAdvance advance = new CalculatorAdvance();
        IOPeracionBasic ba = new CalculatorAdvance();
        System.out.println(advance.sine(90.0));
        System.out.println(ba.add(1.0, 2.0));
        
    }
    
}
