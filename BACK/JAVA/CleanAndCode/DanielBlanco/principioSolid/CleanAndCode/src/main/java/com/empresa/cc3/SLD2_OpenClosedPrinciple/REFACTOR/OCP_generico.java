/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.empresa.cc3.SLD2_OpenClosedPrinciple.REFACTOR;

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


public class OCP_generico {

    public static void main(String args[]) {
        System.out.println("Open Closed Principle");
        List<HEmploye> employes = 
            new ArrayList<>(Arrays.asList(
                    new Programmer("prog", 11, "Spring Boot"), 
                    new Programmer("sin-nombre", 0, null),
                    new Managger("mana", 31, 42)
         ));
                
        Company company = new Company(employes);
        showProgrammers(company);
        
        HEmploye programmer = new Programmer("DEVELOPER-1", 123, "java");
        HEmploye managger   = new Managger("MANAGER-1", 135, 248);
        company.addEmploye(programmer);
        company.addEmploye(managger);
        
        showProgrammers(company);
    }
    
    public static void showProgrammers(Company company){
        for (HEmploye employe : company.getEmployes() ) {
            System.out.println(employe.toString());
        }
        System.out.println("");
    }
    


}