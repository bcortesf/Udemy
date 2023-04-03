/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.empresa.testmv;

import com.empresa.cc2.TestDrivenDevelopment_TDD3.Flight3;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brycorfe
 */
//public class Testmv {
//
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//    }
//}


public class Testmv {

    public static void main(String args[]) {
        int a;
//        Map<String,int> mapa = new HashMap<String, int>();

        Flight3 vuelo1 = new Flight3("1", LocalDateTime.now(), "bogota", "cali");
        Flight3 vuelo2 = new Flight3("2", LocalDateTime.now(), "bogota", "cali");

        Map<String, Flight3> mapa = new HashMap<>();
        mapa.put("key1", vuelo1);
        mapa.put("key2", vuelo2);
        System.out.println(mapa);
        
        for (Map.Entry<String, Flight3> entry : mapa.entrySet()) {
            String key = entry.getKey();
            Flight3 val = entry.getValue();
            if (val.getReferencia().equalsIgnoreCase("1")) {
                System.out.println("vuelo 1");
            }
        }    
    }

}