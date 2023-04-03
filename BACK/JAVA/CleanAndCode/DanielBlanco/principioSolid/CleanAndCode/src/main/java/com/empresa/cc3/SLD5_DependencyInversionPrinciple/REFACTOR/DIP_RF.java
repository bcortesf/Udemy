/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR;

import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.HEmployee;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.CompanyCLIENT;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.factory.EmployeeMemoryPersistenceFCONCRET1;
import com.empresa.cc3.SLD5_DependencyInversionPrinciple.REFACTOR.factory.EmployeeSqlPersistenceFCONCRET2;

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


public class DIP_RF {

    public static void main(String args[]) {
        System.out.println("Dependency Inversion Principle: RF".toUpperCase());
        List<HEmployee> employes = 
            new ArrayList<>(Arrays.asList(new HEmployee("aa", 11), new HEmployee("sin-nombre", 0) ));
        
        
        CompanyCLIENT compaySQL = new CompanyCLIENT(new EmployeeSqlPersistenceFCONCRET2());
        compaySQL.addEmployes(new HEmployee("emp_SQL", 123));
        compaySQL.getEmployes();


        /////////////////////////////////////////////////////////////////////////
        System.out.println("\n\n");
        EmployeeMemoryPersistenceFCONCRET1 employePF = new EmployeeMemoryPersistenceFCONCRET1(employes);

                                //      employePF: SE ENVIA ABSTRACT-CONCRET  y  lo recibo como ABSTRAC-FACTORY."GENERIC"
        CompanyCLIENT company = new CompanyCLIENT(employePF);
        showEmployees( company.getEmployes() );

        company.addEmployes(new HEmployee("Bryan", 123));        
        showEmployees( company.getEmployes() );


        /////////////////////////////////////////////////////////////////////////
        //System.out.println("\t->#MAIN.TESTS-OBTENIENDO-L;ISTA-EMPLEADOS");
        //System.out.println(employePF.getEmployeePersistence().findAll());
        //System.out.println(company.factory.getEmployeePersistence().findAll());        
    }
    
    public static void showEmployees(List<HEmployee> employes){
        for (HEmployee employe : employes) {
            System.out.println(employe.toString());
        }
        System.out.println("");
    }
    


}