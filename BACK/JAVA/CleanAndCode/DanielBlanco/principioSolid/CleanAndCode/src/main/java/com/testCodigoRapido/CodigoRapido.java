/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testCodigoRapido;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author brycorfe
 */
public class CodigoRapido {
    public static void main(String[] args) {
        Set<String> uuids;
        
        Set<String> set = new HashSet<>(Arrays.asList("aaa", "bbb", "ccc","ddd","eee","fff","ggg"));
//        Set<String> set = new HashSet<>(Arrays.asList("aaa"));

        ////////////////////////////////////////////////
        String cadena1 = set.toString();
                System.out.print(set);   
                System.out.print("\t"+cadena1);                                 System.out.println("\tsize:"+cadena1.length());
        cadena1 = formatToVarcharSQL_1(set);
                System.out.print("\t"+cadena1);                                 System.out.println("\tsize:"+cadena1.length());
                System.out.println();
               
        ////////////////////////////////////////////////
        System.out.print( formatToVarcharSQL_2(set) );                          System.out.println("\t\tsize:"+cadena1.length());
        
    }
    
    private static String formatToVarcharSQL_2(Set<String> set) {
        String items = "";
        for (String item : set) {
            items += "'" + item + "',";
        }
        System.out.println( items );
        return items.substring(0, items.length()-1);
    }
    
    private static String formatToVarcharSQL_1(Set<String> set) {
            String cadena = set.toString();
            cadena = cadena.replace(" ", "'");
            cadena = cadena.replace(",'", "','");
            cadena = cadena.replace("[", "'"); cadena = cadena.replace("]", "'");
            return cadena;
    }
}
