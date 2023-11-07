/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maventest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.baeldung.com/java-printstream-printf
 * @author BryanCFz
 */
public class ArrayList_JDK8 {

    public static void main(String[] args) {
        System.out.println("Listas genericas");
        
        List<Integer> listNumber = Arrays.asList(1,2,3,4,5);
        listNumber.forEach(numero -> {
//            System.out.printf("Elemento %d%n", numero);
            System.out.printf("Elemento %d\n", numero);
        });
        
        List<String> listString = new ArrayList<>();
        listString.addAll(Arrays.asList("Hola", "Bryan, ", "¿", "Comó", "estás", "?"));
        listString.forEach(System.out::println);
    }
}
