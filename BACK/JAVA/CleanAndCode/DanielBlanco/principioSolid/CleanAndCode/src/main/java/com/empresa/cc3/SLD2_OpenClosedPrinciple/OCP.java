/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.empresa.cc3.SLD2_OpenClosedPrinciple;

import com.empresa.cc3.SLD1_SingleResponsabilityPrinciple.*;
import com.empresa.testmv.*;
import com.empresa.cc2.TestDrivenDevelopment_TDD3.Flight3;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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


public class OCP {

    public static void main(String args[]) {
        System.out.println("Open Closed Principle");
        List<Programmer> programmers = 
            new ArrayList<>(Arrays.asList(new Programmer("aa", 11, "Spring Boot"), new Programmer("sin-nombre", 0, null)));
        
        Company company = new Company(programmers);
        showProgrammers(company);
        company.addProgrammer("Bryan", 123, "java");
        showProgrammers(company);
    }
    
    public static void showProgrammers(Company company){
        for (Programmer programmer : company.getProgrammers()) {
            System.out.println(programmer.toString());
        }
        System.out.println("");
    }
    


}