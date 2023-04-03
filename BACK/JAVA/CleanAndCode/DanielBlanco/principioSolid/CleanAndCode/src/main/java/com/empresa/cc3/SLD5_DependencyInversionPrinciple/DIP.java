/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.empresa.cc3.SLD5_DependencyInversionPrinciple;

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


public class DIP {

    public static void main(String args[]) {
        System.out.println("Dependency Inversion Principle");
        List<HEmployee> employes = 
            new ArrayList<>(Arrays.asList(new HEmployee("aa", 11), new HEmployee("sin-nombre", 0) ));
        
        Company company = new Company(employes);
        showEmployees(company);
        
        company.addEmployes(new HEmployee("Bryan", 123));
        showEmployees(company);
    }
    
    public static void showEmployees(Company company){
        for (HEmployee employe : company.getEmployes()) {
            System.out.println(employe.toString());
        }
        System.out.println("");
    }
    


}