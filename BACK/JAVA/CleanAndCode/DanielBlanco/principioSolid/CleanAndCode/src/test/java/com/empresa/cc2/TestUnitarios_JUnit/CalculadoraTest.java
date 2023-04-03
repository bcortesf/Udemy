/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.empresa.cc2.TestUnitarios_JUnit;

import com.empresa.cc2.TestUnitarios_JUnit.DivisionByZeroException;
import com.empresa.cc2.TestUnitarios_JUnit.Calculadora;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brycorfe
 */
public class CalculadoraTest {

    private Calculadora calculator;
    
    public CalculadoraTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * Antes de cada Test, se va a crear una "Calculadora.class" instancia nueva.
     * para la ejecucion de cada TEST, se va  a llamar al metodo setUp()
     */
    @BeforeEach
    public void setUp() {
        calculator = new Calculadora();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * https://carvajal.udemy.com/course/principios-solid-y-clean-code-escribe-codigo-de-calidad/learn/lecture/24922034?start=511#notes
     * Test of multiply method, of class Calculadora.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        assertEquals(4.6, calculator.multiply(2.0, 2.3));
    }


    /**
     * Test of divide method, of class Calculadora.
     */
    @Test
    public void testDivide() {
        assertEquals(3, calculator.divide(6.0, 2.0));
    }
    @Test
    public void testInvalideDivide() {
        assertThrows(DivisionByZeroException.class, () -> {
            calculator.divide(5.0, 0.0);
        });
    }


    /**
     * Test of abs method, of class Calculadora.
     */
    @Test
    public void testPositiveAbs() {
        System.out.println("abs");
        assertEquals(3.0, calculator.abs(3.0));
    }
    @Test
    public void testNegativeAbs() {
        System.out.println("abs");
        assertEquals(2.0, calculator.abs(-2.0));
    }
    
    
    /**
     * Test of higherValue method, of class Calculadora.
     */
    @Test
    public void higherValue() {
        System.out.println("abs");
        assertEquals(8.0, calculator.higherValue(8.0, 5.0));
    }
    
    
    /*@Test
    public void testPrueba() {
        System.out.println("abs");
        Double numA = null;
        Double numB = null;
        Calculadora instance = new Calculadora();
        Double expResult = null;
        Double result = instance.abs(numA, numB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
