/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.example2.Generic.Entity;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;



/**
 * https://github.com/danirod/ejemplos-java/blob/trunk/genericos/src/test/java/es/makigas/ejemplos/genericos/EnvoltorioTest.java
 * @author BryanCFz
 */
public class AccountingDepartmentTest {
    
    /**
     * Test of payBills method, of class AccountingDepartment.
     */
    @Test
    public void testPayBills() {
        System.out.println("DEPARTAMENTO CONTABILIDAD \t:PayBills()");
        List<Employee> employees = Arrays.asList(Manager.factory(), Developer.factory()); 
        
        System.out.println("\n\t-> Nomina empresa".toUpperCase() + "\t:salarios");
        Double amount = new AccountingDepartment().payBills(employees);
        System.out.println(amount);
        assertTrue(amount >= 0);
        
        System.out.println("\n\t-> Nomina empresa".toUpperCase() + "\t:salarios + bonos");
        Double amountBono = new AccountingDepartment().payBillsWithBones(employees);
        System.out.println(amountBono);
        assertTrue(amountBono >= 0);
    }

    /**
     * \t   :8-espacios
     */
    @Test
    public void testPayBills_Developers_Managers() {
        System.out.println("DEPARTAMENTO CONTABILIDAD \t:PayBills_Developers_Managers()" + "\n");
        
        
        List<Developer> employeesDevelopers; 
        employeesDevelopers = Arrays.asList( ((Developer)Developer.factory()), ((Developer)Developer.factory()) );
        Double amountD = new AccountingDepartment().payBills_subType(employeesDevelopers);
        
        System.out.println("    + <Developers>");
        System.out.println("\t-> Nomina desarrolladores".toUpperCase() + "\t:salarios = " + amountD);
        assertTrue(amountD >= 0);
        
        //----------------------------------------------------------------------------------------------------------
        List<Manager> employeesManagers; 
        employeesManagers = Arrays.asList( ((Manager)Manager.factory()), ((Manager)Manager.factory()) );
        Double amountM = new AccountingDepartment().payBills_subType(employeesManagers);
        
        System.out.print("    + <Managers>");
        System.out.println("\n\t-> Nomina Administradores".toUpperCase() + "\t:salarios = " + amountM);
        assertTrue(amountM >= 0);
    }


    /**
     * https://www.geeksforgeeks.org/wildcards-in-java/
     */
    @Test
    public void pruebaUsando_super() {
        List<Employee> employees;
        employees = Arrays.asList( Manager.factory(), Developer.factory() );
        Double amount = new AccountingDepartment().payBills_type(employees);
        
        System.out.println("    + <Developers + Managers>");
        System.out.println("\t-> Nomina trabajadores".toUpperCase() + "\t:salario neto = " + amount);
    }

}
