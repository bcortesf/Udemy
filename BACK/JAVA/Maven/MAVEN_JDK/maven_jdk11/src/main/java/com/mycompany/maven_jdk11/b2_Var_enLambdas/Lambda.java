/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk11.b2_Var_enLambdas;

import com.mycompany.entitys.Interface.IOperacion;
import java.util.stream.IntStream;

/**
 *
 * @author BryanCFz
 */
public class Lambda {
    public void numeros_pares_impares(String tipoNumero){
        switch (tipoNumero) {
            case "PARES":
                IntStream.of(1,2,3,4,5,6,7)
                        .filter((var value) -> value % 2 == 0)
                        .forEach(System.out::println);
                break;
            case "IMPARES":
                IntStream.of(1,2,3,4,5,6,7)
                        .filter((var value) -> value % 2 != 0)
                        .forEach(System.out::println);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void sumar() {
        IOperacion operacion = (double numero1, double numero2) -> numero1 + numero2;
        var suma = operacion.calcular(2.6, 2.4);
        System.out.println("la suma es :" + suma);
    }
}
