/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b3_Functionalnterfaces;

/**
 *
 * @author BryanCFz
 */
public class Test {
    
    public double operar(double numA, double numB) {
        /**
         * Al usar una <expresion-lambda> de una <INTERFACE> :
         *      - solo puede haber <1-solo-metodo-declarado>; En caso contrario se genera ***ERROR***
         */
        IOperacion op = (double numero1, double numero2) -> numero1 + numero2;
        return op.calcular(numA, numB);
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b3_Functionalnterfaces".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Test tst = new Test();
        final double num1 = 2.5, num2 = 2.0;
        System.out.println("Los numeros: " + num1 + ", " + num2);
        System.out.println("La suma es: " + tst.operar(num1, num2));
    }
}
