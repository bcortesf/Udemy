/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b4_Map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author BryanCFz
 */
public class Test3a_LinkedHashMap {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b4_Map.Test3a_LinkedHashMap".toUpperCase());
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
        Map<String, String> mapStr = getMapIntegerString();
        showMapIntegerString(mapStr);
        
        //
//        Map<Integer, Persona_impComparable> mapPer = new HashMap<>();
    }
    
    public static Map<String, String> getMapIntegerString() {
        Map<String, String> mapStr = new LinkedHashMap<>();
        mapStr.put("3", "MitoCode");
        mapStr.put("4", "Mito");
        mapStr.put("1", "Code");
        mapStr.put("2", "Jaime");
        mapStr.put("5", null);
        
        return mapStr;
    }
    public static void showMapIntegerString(Map<String, String> mapStr) {      
        for (Map.Entry<String, String> entry : mapStr.entrySet()) {
            //Object key = entry.getKey();
            String key  = entry.getKey();
            String value = entry.getValue();
            System.out.println("Clave<" + key + ">  ->  Value{" + value + "}");
        }
    }
}
