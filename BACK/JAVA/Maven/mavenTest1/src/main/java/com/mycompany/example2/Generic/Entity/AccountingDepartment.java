/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example2.Generic.Entity;

import java.util.List;

/**
 * DepartamentoContabilidad
 * @author BryanCFz
 */
public class AccountingDepartment {
    
    /**
     * pagarCuentas: Calcular total, para pagar nomina a la empresa
     * *             Hace uso de la clase PADRE<Empleado>, que contenga hijas en su lista <Developer>, <Manager>
     * *             *EJEMPLO: Enviar List<Empleado>
     * @param employees
     * @return 
     */
    public Double payBills (List<Employee> employees) {
        double amount = 0; //cantidad dinero
        for (Employee employee : employees) {
            amount += employee.getSalary();
        }
        return amount;
    }
    
    /**
     * pagarCuentasBonos: Calcular total, para pagar nomina a la empresa
     * *                  Hace uso de la clase PADRE<Empleado>, que contenga hijas en su lista <Developer>, <Manager>
     *                    *EJEMPLO: Enviar List<Empleado>
     * @param employees
     * @return 
     */
    public Double payBillsWithBones (List<Employee> employees) {
        double amount = 0; //cantidad dinero
        for (Employee employee : employees) {
            amount += employee.getTotalSalary();
        }
        return amount;
    }


    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    /**
     * pagarCuentas: Calcular total, para pagar nomina a la empresa
     * *             (List<? extends Employee> employeesChields): Recibe cualquier {cosa o clase} que herede de una clase PADRE<Employee>
     * 
     *               Hace uso de las clases subTipo ó hijo; que HEREDA del PADRE<Empleado>
     *               EJEMPLO: Enviar List<Developer>
     *               
     * @param employeesChields  :es convertido de tipo Abstracto <Employee>
     * @return 
     */
    public Double payBills_subType (List<? extends Employee> employeesChields) {
        double amount = 0; //cantidad dinero
        for (Employee employee : employeesChields) {
            amount += employee.getSalary();
        }
        return amount;
    }

    
    /**
     * https://www.youtube.com/watch?v=becfU6P5o1c&list=RDCMUCQufRmIMRTLdRxTsXCh4-5w&t=471s
     * https://www.youtube.com/watch?v=becfU6P5o1c&list=RDCMUCQufRmIMRTLdRxTsXCh4-5w&t=527s
     * https://www.codejava.net/java-core/collections/generics-with-extends-and-super-wildcards-and-the-get-and-put-principle
     * https://www.geeksforgeeks.org/wildcards-in-java/
     * 1. Comodines con límite SUPERIOR:
     * * Con "extends"  :podemos acotar por ARRIBA...  
     *                   cualquier subclase hija que tenga, un padre abstracto-interface
     *                   List<Developer> tiene un padre<Employee>
     *                   List<Developer> tiene un padre<Manager>
     * **                public Double payBills_subType (List<? extends Employee> employeesChields) {...}
     * 
     * 2. Comodines de límite INFERIOR: 
     * * Con "super"    :podemos acotar por ABAJO...
     *                   cualquier clase PADRE, que sea la misma clase o tenga hijos donde se implemente
     *                   <Employee> mismo <Employee>
     *                   <Employee> tiene un hijo<Developer>
     *                   <Employee> tiene un hijo<Manager>
     * **                public Double payBills_type (List<? extends Employee> employeesChields) {...}
     * 
     * https://stackoverflow.com/questions/10531513/how-to-identify-object-types-in-java
     */
    public Double payBills_type(List<? super Employee> list) {
        //System.out.println(list.get(0).getClass());
        //System.out.println(list.get(1).getClass());
        //System.out.println("====================\n");
        
        double amount = 0; //cantidad dinero
        for (int i = 0; i < list.size(); i++) {
            Object get = list.get(i);
            Class<?> myClass = get.getClass();
            
            System.out.println(get);                      //toma el toString()
            System.out.println(myClass);
            
            if (myClass == Developer.class) {
                Developer developer = (Developer)get;
                amount += developer.getSalary();
            }
            if (myClass == Manager.class) {
                Manager manager = (Manager)get;
                amount += manager.getSalary();
            }
            System.out.println("...");
            
        }
        return amount;
    }
    
    public static void printOnlyIntegerClassorSuperClass(
        List<? super Integer> list)
    {
        System.out.println(list.get(0));
    }

}




