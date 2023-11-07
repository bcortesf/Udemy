/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b4_Map;

import com.mycompany.entitys.comparable.Persona_impComparable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author BryanCFz
 */
public class Test3b_LinkedHashMap_Persona {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b4_Map.Test3b_LinkedHashMap_Persona".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * OJO, UTILIZAR UNA CLASE QUE IMPLEMENTE  Comparable<T>
         * No se permite valores duplicados como: {llaves-keys}
         *  - Si la KEY es de tipo INTEGER o STRING, estos seran ordenados por la KEY de forma ascendente
         * Se preocupa el orden en el que voy agregando los elementos al MAP
         * 
         * 
         * https://www.youtube.com/watch?v=U_7qilLSa8k&list=PLvimn1Ins-43qPXR3gBcxwe7tydxZtsON&t=320s
         * OBJETO CUSTOMIZABLE O OBJETO PROPIO... EJ:<Persona>
         * - Necesitara que la clase<Persona> implements Comparable<Persona>
         *   -con  sus metodos {equas, hashCode}
         * 
         */
        Map<Persona_impComparable, String> mapStr = getMapPersona_impComparable__String();
        showMapPersona_impComparable__String(mapStr);
        
        //
    }
    
    public static Map<Persona_impComparable, String> getMapPersona_impComparable__String() {
        Map<Persona_impComparable, String> mapPers = new LinkedHashMap<>();
        mapPers.put(new Persona_impComparable(1, "MitoCode", 21, "CO"), "MitoCode");
        mapPers.put(new Persona_impComparable(2, "MitoCode", 21, "CO"), "Mito");
        mapPers.put(new Persona_impComparable(3, "MitoCode", 21, "CO"), "Code");
        mapPers.put(new Persona_impComparable(4, "MitoCode", 21, "CO"), "Jaime");
        mapPers.put(new Persona_impComparable(5, "MitoCode", 21, "CO"), "AAA");
        mapPers.put(new Persona_impComparable(6, "MitoCode", 21, "CO"), null);
        
        return mapPers;
    }
    public static void showMapPersona_impComparable__String(Map<Persona_impComparable, String> mapStr) {      
        for (Map.Entry<Persona_impComparable, String> entry : mapStr.entrySet()) {
            //Object key = entry.getKey();
            Persona_impComparable key  = entry.getKey();
            String value = entry.getValue();
            System.out.println("Clave<" + key + ">  ->  Value{" + value + "}");
        }
    }
}
