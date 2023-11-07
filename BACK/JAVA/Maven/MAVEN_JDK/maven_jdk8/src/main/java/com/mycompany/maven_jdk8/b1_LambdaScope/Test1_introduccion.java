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
public class Test1_introduccion {
    
    private static List<String> getListStrings() {
        List<String> lista = new ArrayList<>();
        lista.add("MitoCode");
        lista.add("Code");
        lista.add("Mito");
        return lista;
    }
    private static void showListStrings(List<String> lista) {
        System.out.println("-> LISTA ORDENADA:");
        for (String string : lista) {
            System.out.println(string);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk8.b1_LambdaScope.1-INTRO".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        System.out.println("->Ordenamiento de lista con java 1.7");
        List<String> lista_7 = getListStrings();
        ordenar_jdk7(lista_7);        //JAVA-1.7
        showListStrings(lista_7);

        //______________________________________________________________________
        //______________________________________________________________________

        System.out.println("=================================================");
        System.out.println("->Ordenamiento de lista con java 1.8");
        List<String> lista_8 = getListStrings();
        ordenar_jdk8(lista_8);        //JAVA-1.8
        showListStrings(lista_8);
        
        System.out.println("\n\n++++++++++++++++++++");
        System.out.println("CALCULO DE PROMEDIOS ");
        Test1_introduccion tst = new Test1_introduccion();
        tst.Calcular();                           // (2+3)=5 -> 5/2=2.5
        tst.Calcular_conParametros(6, 3); // (6+3)=9 -> 9/2=4.5
    }

    public void Calcular() {
        /**
         *            EQUIVALENTES O IGUALES
           
            IOperacion operacion = (numero1, numero2) -> 0;
            IOperacion operacion = (numero1, numero2) -> {
                return 0;
            };
         */
        /**
            IOperacion operacion = (int numero1, int numero2) -> (numero1 + numero2) /2;
            IOperacion operacion = new IOperacion() {
                @Override
                public double calcularPromedio(double numero1, double numero2) {
                    return (numero1 + numero2) /2;
                }
            };
        */
        IOperacion operacion;
        operacion = (double numero1, double numero2) -> (numero1 + numero2) /2;
        
        
        System.out.println( "El promedio de {" + 2 + "+" + 3 + "} /2 = " +
                operacion.calcularPromedio(2, 3) 
        );// (2+3)=5 -> 5/2=2.5
    }
    public void Calcular_conParametros(double NumA, double NumB) {
        IOperacion operacion;
        operacion = (double numero1, double numero2) -> (NumA + NumB) /2;
        
        System.out.println( "El promedio de {" + NumA + "+" + NumB + "} /2 = " +
                operacion.calcularPromedio(NumA, NumB) 
        );// (6+3)=9 -> 9/2=4.5
    }



    /**
     * Collections.sort(                (parametros)        operador      expresion-ó-funcion--a-evaluar );
     * Collections.sort(lista,     (String o1, String o2)      ->                 o1.compareTo(o2));
     * @param lista 
     */
    public static void ordenar_jdk8(List<String> lista) {
        /**
         * -use:  member-reference
                  Collections.sort(lista, String::compareTo); 
         * 
         * -use:  lambda-expression
                  Collections.sort(lista, (String o1, String o2) -> o1.compareTo(o2));
         * 
         * -use:  block as the lambda's body
                  Collections.sort(lista, (String str1, String str2) -> {
                      return str1.compareTo(str2);
                  } );
         */
          Collections.sort( lista, (String str1, String str2) -> str1.compareTo(str2) );
    }

    //---------------------------------------------------
    public static void ordenar_jdk7(List<String> lista) {
        Collections.sort(lista, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
