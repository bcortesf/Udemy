/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.example2.Generic;



import com.mycompany.example2.Generic.Entity.AccountingDepartment;
import com.mycompany.example2.Generic.Entity.Developer;
import com.mycompany.example2.Generic.Entity.Employee;
import com.mycompany.example2.Generic.Entity.Manager;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author BryanCFz
 */
public class ReporteTest {
    
    /**
     * Test of imprimir method, of class Reporte.
     */
    @Test
    public void testImprimir() {
        AccountingDepartment accouting = new AccountingDepartment();
        Report reporte = new Report();
        
        System.out.println("\t-> FABRICA-ORIGINAL".toUpperCase());
        Employee empManager   = Manager.factory();
        Employee empDeveloper = Developer.factory();
        List<Employee> employees = Arrays.asList(empManager, empDeveloper);
        reporte.imprimir(employees);
        
        System.out.println("\n\t-> <DEVELOPER-PROGRAMADOR>".toUpperCase());
        System.out.println("\t-> Obsequio bono doble -> salario doble");
            empDeveloper.setBonoSalary(2.0);
            empDeveloper.getTotalSalary(); //Aqui suma salario + bonoSalaryDoble
        reporte.imprimir(employees);

        ////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n\n\t-> Nomina empresa".toUpperCase() + "\t:salarios");
        System.out.println(accouting.payBills(employees));
        System.out.println("\n\n\t-> Nomina empresa".toUpperCase() + "\t:salarios + bonos");
        System.out.println(accouting.payBillsWithBones(employees));
    }
    
    /**
     * Poner Cursor sobre error marcado en rojo
       Alt + Enter   :mostrar error o completar clase
     * 
     */
    @Test
    public void prueba() {
        java.util.Random rnd = new java.util.Random();
        System.out.println(rnd.nextDouble());
    }
    
}
