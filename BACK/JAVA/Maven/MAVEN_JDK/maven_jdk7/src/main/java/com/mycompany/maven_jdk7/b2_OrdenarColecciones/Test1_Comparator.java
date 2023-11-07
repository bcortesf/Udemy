/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b2_OrdenarColecciones;

import com.mycompany.entitysClass.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author BryanCFz
 */
public class Test1_Comparator {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b2_OrdenarColecciones.TEST1<COMPARATOR>".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //->Ordenamiento lista enteros
        System.out.println("->LIST<INTEGER>");
        List<Integer> listIntegers = getIntegers();

        System.out.println("  lista-desordenada \t:" + listIntegers);
        Collections.sort(listIntegers);
        System.out.println("  lista-ordenada    \t:" + listIntegers);
        Collections.reverse(listIntegers);
        System.out.println("  lista-al-reves    \t:" + listIntegers);
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");


        //->Ordenamiento lista personas
        System.out.println("->LIST<PERSONA>");
        List<Persona> listPersons = getPersons();

        showPersons("  lista-desordenada        \t:", listPersons);
        Collections.sort(listPersons, new NombreComparator());
        showPersons("  lista-ordenada-byNameASC \t:", listPersons);

        Collections.sort(listPersons, new Object_CustomComparator("Persona.pais"));
        showPersons("  lista-ordenada-byCountry \t:" , listPersons);
        Collections.sort(listPersons, new Object_CustomComparator("Persona.id"));
        showPersons("  lista-ordenada-byId \t:" , listPersons);

        Collections.sort(listPersons, new Person_CustomComparator("Persona.edad"));
        showPersons("  lista-ordenada-byAge \t:" , listPersons);
        
        //->Ordenamiento, sin crear clase externa
        // Collections.sort(listPersons, (Persona persona1, Persona persona2) -> persona2.getNombre().compareTo(persona1.getNombre()));
        Collections.sort(listPersons, new Comparator<Persona>() {
            @Override
            public int compare(Persona persona1, Persona persona2) {
                if (persona1.getEdad() > persona2.getEdad()) {
                    return 1;
                }
                if (persona1.getEdad() < persona2.getEdad()) {
                    return -1;
                } else { //if (persona1.getEdad() == persona2.getEdad())
                    return 0;
                }
            }
        });
        showPersons("  lista-ordenada-byID \t:", listPersons);
    }
    
    public static List<Integer> getIntegers() {
        List<Integer> list = new ArrayList<>();
        list.add(25); list.add(1000); list.add(1);
        return list;
    }
    
    public static List<Persona> getPersons() {
        List<Persona> list = Arrays.asList(
                new Persona(3, "Minnie"  , 25, "US"),          //2022
                new Persona(1, "Shushito", 15, "FR"),          //2013
                new Persona(2, "Bryan"   , 29, "CO"),
                new Persona(4, "Moticas" , 14, "ANGELITO")     //2006-2020
        );
        return list;
    }
    public static void showPersons(String titulo, List<Persona> lista) {
        System.out.println( titulo.concat(lista.toString()) );
        for (Persona persona : lista) {
            System.out.println("\t\t\t" + persona.toString());
        }
        System.out.println();
    }
}
