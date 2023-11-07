/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b4_Map;

import com.mycompany.entitys.comparable.Persona_impComparable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author BryanCFz
 */
public class Test1_HashMap {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b4_Map.Test1_HashMap".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        /**
         * OJO, UTILIZAR UNA CLASE QUE IMPLEMENTE  Comparable<T>
         * No se permite valores duplicados como: {llaves-keys}
         *  - Si la KEY es de tipo INTEGER, estos seran ordenados por la KEY de forma ascendente
         *  - Si la KEY es de otro tipo, entonces se almacenara de forma aleatoria
         */
        Map<Integer, String> mapStr = getMapIntegerString();
        showMapIntegerString(mapStr);
        
        //
//        Map<Integer, Persona_impComparable> mapPer = new HashMap<>();
    }
    
    public static Map<Integer, String> getMapIntegerString() {
        Map<Integer, String> mapStr = new HashMap<>();
        mapStr.put(3, "MitoCode");
        mapStr.put(4, "Mito");
        mapStr.put(1, "Code");
        mapStr.put(2, "Jaime");
        mapStr.put(5, null);
        mapStr.put(null, "sin llave"); //No-se-almacena
        
        mapStr.put(6, "lo ignora");
        mapStr.put(6, "lo ignora");
        mapStr.put(6, "solo-guarda-el-ultima-KEY-repetida");
        return mapStr;
    }
    public static void showMapIntegerString(Map<Integer, String> mapStr) {      
        for (Map.Entry<Integer, String> entry : mapStr.entrySet()) {
            //Object key = entry.getKey();
            Integer key  = entry.getKey();
            String value = entry.getValue();
            System.out.println("Clave<" + key + ">  ->  Value{" + value + "}");
        }
    }
}
