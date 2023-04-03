/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.empresa.cc3.SLD3_LiskovSubstitutionPrinciple.REFACTOR;

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
        //Land: TERRESTRE
        Mammal mamifero    = new Dog();
        LandMammal dog     = new Dog();
        Dolphin dolphin    = new Dolphin();
        
        ((LandMammal)mamifero).walk();
        dog.walk();
        dolphin.swim();
    }
    

}