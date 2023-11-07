/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b3_ListasSet;

import com.mycompany.entitysRecords.Persona;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author BryanCFz
 */
public class Test1_HashSet {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b3_Listas.HashSet".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * Encontrar datos en una lista; Sin que contenga datos duplicados
         * No se preocupa por el orden de adicion; Se adicionan en distinto orden, al del codigo.
         * 
         */

        Set<String> listaString = new HashSet<>();
        listaString.add("Bryan"); //Lo almacena
        listaString.add("Bryan"); //No lo almacena, porque ya existe
        showStrings(listaString);
        System.out.println("---------------------------");
        
        Set<Persona> lista = new HashSet<>();
        lista.add( new Persona(1, "MitoCode", "calle 1"));          //Queda pendiente por estar repetido: NO-SE-GUARDA
        lista.add( new Persona(1, "Mito", "calle 1"));    //LO-ALMACENA
        lista.add( new Persona(1, "Code", "calle 1"));         //Queda pendiente por estar repetido: NO-SE-GUARDA
        lista.add( new Persona(1, "Code", "calle 1"));   //LO-ALMACENA, por ser ultima coincidencia repetida
        lista.add( new Persona(1, "MitoCode", "calle 1"));    //LO-ALMACENA, por ser ultima coincidencia repetida
        lista.add( new Persona(1, "AAA", "calle 1")); //LO-ALMACENA
        showPersons(lista);
    }

    private static void showStrings(Set<String> lista) {
        System.out.println("->Esta validado para <NO-ALMACENAR> elementos repetidos");
        for (String string : lista) {
            System.out.println(string);
        }
    }
    
    private static void showPersons(Set<Persona> lista) {
        System.out.println("->Esta validado para <NO-ALMACENAR> elementos repetidos");
        for (Persona persona : lista) {
            System.out.println(persona.toString());
        }
    }
}
