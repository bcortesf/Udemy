/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.example1.Generic;

import com.mycompany.example1.Generic.Entity.Department;
import com.mycompany.example1.Generic.Entity.Employee;
import org.junit.jupiter.api.Assertions;

/**
 * @author BryanCFz
 */
public class GenericTest1 {

    public static void main(String[] args) {
        System.out.println("Clase generica");
        
        Department department = new Department(1, "Contabilidad", "Colombia");
        Employee employee = new Employee("Bryan", "Cortes", "Bogota D.C");
        
        WrapperEnvoltorio_objetos wrapper = new WrapperEnvoltorio_objetos(employee);
        Assertions.assertTrue(wrapper.toString().contains("Envolvemos {"));  //Si hay error no ejecuta las siguientes lineas
        System.out.println(wrapper);        //WrapperEnvoltorio
        System.out.println(wrapper.get());  //Employee
        
        
    }
}
