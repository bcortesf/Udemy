/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc2.TestUnitarios_JUnit;

/**
 *
 * @author brycorfe
 */
public class MainJUnit {

/**
 * https://carvajal.udemy.com/course/principios-solid-y-clean-code-escribe-codigo-de-calidad/learn/lecture/24922034?start=362#notes
 * https://mvnrepository.com/
 * https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.7.0
 */    
    public static void main(String[] args ) {        
        Double numA = 2.0, numB = 1.0;
        Calculadora cal = new Calculadora();
        System.out.println(numA + " * " + numB +" = " +cal.multiply(numA, numB));
        System.out.println(numA + " / " + numB +" = " +cal.divide(numA, numB));
        System.out.println(numA + " / " + numB +" = " +cal.abs(numA));
        System.out.println("Numero mayor : " + numA + " y " + numB +" es = " +cal.higherValue(numA, numB));
    }
        
}
