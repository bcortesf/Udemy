/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.empresa.cc3.SLD3_LiskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


public class LSP {

    public static void main(String args[]) {
        Mammal dog     = new Dog();
        Mammal dolphin = new Dolphin();
        
        dog.walk();
        dolphin.walk();
    }
    

}