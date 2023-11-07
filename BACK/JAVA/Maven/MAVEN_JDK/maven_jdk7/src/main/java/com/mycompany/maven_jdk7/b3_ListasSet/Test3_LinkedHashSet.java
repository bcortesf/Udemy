/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b3_ListasSet;

import com.mycompany.entitys.comparable.Persona_impComparable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=y_YjHAyzEGE&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&index=15
 * @author BryanCFz
 */
public class Test3_LinkedHashSet {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b3_Listas.Test3_LinkedHashSet".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * Se preocupa que todos los valores sean unicos 
         * Se preocupa el orden en el que voy agregando los elementos al MAP
         */
        Set<Persona_impComparable> lista = new LinkedHashSet<>();
        lista.add( new Persona_impComparable(1, "MitoCode", 22, "CO"));
        lista.add( new Persona_impComparable(1, "Mito"    , 22, "CO"));
        lista.add( new Persona_impComparable(1, "Code"    , 22, "CO"));
        lista.add( new Persona_impComparable(1, "Code"    , 22, "CO"));
        lista.add( new Persona_impComparable(1, "MitoCode", 115, "CO"));
        lista.add( new Persona_impComparable(1, "AAA"     , 22, "CO"));
        showPersons(lista);
    }

    
    private static void showPersons(Set<Persona_impComparable> lista) {
        System.out.println("->Esta validado para <NO-ALMACENAR> elementos repetidos");
        for (Persona_impComparable persona : lista) {
            System.out.println(persona.toString());
        }
    }
}

