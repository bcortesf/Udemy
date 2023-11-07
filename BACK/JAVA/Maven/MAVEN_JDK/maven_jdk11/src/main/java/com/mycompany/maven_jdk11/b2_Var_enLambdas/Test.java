/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk11.b2_Var_enLambdas;

/**
 *
 * @author BryanCFz
 */
public class Test {
    
    private final Lambda lamda = new Lambda();

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk11.b2_Var_enLambdas".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // 
        Test ts = new Test();
        ts.Pares_Impares();
        ts.sumarDoubles();
    }
    public void Pares_Impares() {
        System.out.println("\n1. ->Pares_Impares()");
        lamda.numeros_pares_impares("IMPARES");
    }
    public void sumarDoubles() {
        System.out.println("\n2. ->sumar()");
        lamda.sumar();
    }
}
