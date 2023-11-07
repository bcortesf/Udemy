/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b3_ListasSet;

import com.mycompany.entitys.comparable.Persona_impComparable;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.youtube.com/watch?v=Gclb5YHIi0o&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&index=14
 * @author BryanCFz
 */
public class Test2_TreeSet {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b3_Listas.TreeSet".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * Encontrar datos en una lista; Sin que contenga datos duplicados
         * Tiene un algoritmo SORT.ASCENDENTE de forma automatica
         * 
         */

        
        Set<Persona_impComparable> lista = new TreeSet<>();
        lista.add( new Persona_impComparable(1, "MitoCode", 20, "CO"));          //Queda pendiente por estar repetido: NO-SE-GUARDA
        lista.add( new Persona_impComparable(1, "Code", 18, "CO"));    //LO-ALMACENA
        lista.add( new Persona_impComparable(1, "Mito", 115, "CO"));         //Queda pendiente por estar repetido: NO-SE-GUARDA
        lista.add( new Persona_impComparable(1, "Jaime", 5, "CO"));   //LO-ALMACENA, por ser ultima coincidencia repetida
        lista.add( new Persona_impComparable(1, "Mito", 115, "CO"));    //LO-ALMACENA, por ser ultima coincidencia repetida
        lista.add( new Persona_impComparable(1, "AAA", 33, "CO")); //LO-ALMACENA
        showPersons(lista);
    }

    
    private static void showPersons(Set<Persona_impComparable> lista) {
        System.out.println("->Esta validado para <NO-ALMACENAR> elementos repetidos");
        for (Persona_impComparable persona : lista) {
            System.out.println(persona.toString());
        }
    }
}

