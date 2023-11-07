/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk8.b1_LambdaScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author BryanCFz
 */
public class Test2_sintaxis {
    
    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b1_LambdaScope.2-SINTAX".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //______________________________________________________________________
        //______________________________________________________________________

        Test2_sintaxis tst = new Test2_sintaxis();

        System.out.println("=================================================");
        System.out.println("->CALCULO DE PROMEDIOS ");

        System.out.println( "El promedio de {" + 2 + "+" + 3 + "} /2 = " +
                tst.Calcular()
        );// (2+3)=5 -> 5/2=2.5
        
        System.out.println("=================================================");
        System.out.println("->CALCULO DE PROMEDIO UNIVERSIDAD CENTRAL #1");
        System.out.println( "El promedio de {" + 2 + "+" + 3 + "+" + 4.5 + "} /2 = " +
                tst.ProgramacionObjetos().calcularPromedio(2, 3)
        );// (2+3+4.5)=9.5 -> 9.5/3=3.5
        
        System.out.println("=================================================");
        System.out.println("->CALCULO DE PROMEDIO UNIVERSIDAD CENTRAL #2");
        System.out.println( "El promedio de {" + 2 + "+" + 3 + "+" + 5 + "} /2 = " +
                tst.ProgramacionAvanzada().calcularPromedio(2, 3)
        );// (2+3+4)=9 -> 9/3=3.0
    }

    public double Calcular() {
        IOperacion operacion = (double numero1, double numero2) -> (numero1 + numero2) /2;
        return     operacion.calcularPromedio(2, 3);// (2+3)=5 -> 5/2=2.5
    }
    
    public IOperacion ProgramacionObjetos() {
        IOperacion operacion;
        operacion =  (numero1, numero2) -> {
            double nota3_Final = 4.5;
            return (numero1 + numero2 + nota3_Final) /3;
        };
        return operacion;
    }
    
    public IOperacion ProgramacionAvanzada() {
        return  (double numero1, double numero2) -> {
            double nota3_Final = 5.0;
            return (numero1 + numero2 + nota3_Final) /3;
        };
    }

}
