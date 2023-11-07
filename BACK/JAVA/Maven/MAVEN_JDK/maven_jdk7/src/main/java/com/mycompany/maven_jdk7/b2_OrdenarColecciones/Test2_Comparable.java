/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b2_OrdenarColecciones;


import com.mycompany.entitys.comparable.Persona_impComparable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author BryanCFz
 */
public class Test2_Comparable {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b2_OrdenarColecciones.TEST2<COMPARABLE>".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //->Ordenamiento lista personas
        System.out.println("->LIST<PERSONA>");
        List<Persona_impComparable> listPersons = getPersons();

        showPersons("  lista-desordenada    \t:", listPersons);
        Collections.sort(listPersons);
        showPersons("  lista-ordenada-byAge \t:", listPersons);        
    }
    
    public static List<Persona_impComparable> getPersons() {
        List<Persona_impComparable> list = Arrays.asList(
                new Persona_impComparable(3, "Minnie"  , 25, "US"),          //2022
                new Persona_impComparable(1, "Shushito", 15, "FR"),          //2013
                new Persona_impComparable(2, "Bryan"   , 29, "CO"),
                new Persona_impComparable(4, "Moticas" , 14, "ANGEL")     //2006-2020
        );
        return list;
    }
    public static void showPersons(String titulo, List<Persona_impComparable> lista) {
        System.out.println( titulo.concat(lista.toString()) );
        for (Persona_impComparable persona : lista) {
            System.out.println("\t\t\t" + persona.toString());
        }
        System.out.println();
    }
}
