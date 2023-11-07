/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b2_OrdenarColecciones;


import com.mycompany.entitys.comparable.Persona_impComparable_byField;
import com.mycompany.enums.PersonaOrderEnum;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author BryanCFz
 */
public class Test2_ComparableCustom {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b2_OrdenarColecciones.TEST2<COMPARABLE>".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //->Ordenamiento lista personas
        System.out.println("->LIST<PERSONA>");
        List<Persona_impComparable_byField> listPersons = getPersons();

        showPersons("  lista-desordenada    \t:", listPersons);
        Collections.sort(listPersons);
        showPersons("  lista-ordenada-by... \t:", listPersons);        
    }
    
    public static List<Persona_impComparable_byField> getPersons() {
        //Filtrar por el campo 
        PersonaOrderEnum PERSONA_ORDER = PersonaOrderEnum.ID;
        
        List<Persona_impComparable_byField> list = Arrays.asList(
                new Persona_impComparable_byField(3, "Minnie"  , 25, "US"   , PERSONA_ORDER),          //2022
                new Persona_impComparable_byField(1, "Shushito", 15, "FR"   , PERSONA_ORDER),          //2013
                new Persona_impComparable_byField(2, "Bryan"   , 29, "CO"   , PERSONA_ORDER),
                new Persona_impComparable_byField(4, "Moticas" , 14, "ANGEL", PERSONA_ORDER)     //2006-2020
        );
        return list;
    }
    public static void showPersons(String titulo, List<Persona_impComparable_byField> lista) {
        System.out.println( titulo.concat(lista.toString()) );
        for (Persona_impComparable_byField persona : lista) {
            System.out.println("\t\t\t" + persona.toString());
        }
        System.out.println();
    }
}
