/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example1.Generic;

import com.mycompany.example1.Generic.WrapperEnvoltorio_generic;
import com.mycompany.example1.Generic.Entity.Department;
import com.mycompany.example1.Generic.Entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author BryanCFz
 */
public class WrapperEnvoltorio_genericTest {
    
    @Test
    public void TestEnvuelveEmpleado() {
        Department department = new Department(1, "Contabilidad", "Colombia");
        Employee employee = new Employee("Bryan", "Cortes", "Bogota D.C");
        
        WrapperEnvoltorio_generic<Employee> wrapper = new WrapperEnvoltorio_generic<>(employee);
        Assertions.assertTrue(wrapper.toString().contains("Envolvemos ["));
        //System.out.println(wrapper.toString());

        //ENVOLTORIO YA VIENE CASTEADO POR SER GENERICO
        String name = wrapper.get().name(); //Employee
        Assertions.assertEquals("Bryan", name);
    }

    @Test
    public void TestEnvuelveDepartamento() {
        Department department = new Department(1, "Contabilidad", "Colombia");
        WrapperEnvoltorio_generic<Department> wrapper = new WrapperEnvoltorio_generic<>(department);
        Assertions.assertTrue(wrapper.toString().contains("Envolvemos ["));
        
        String location = wrapper.get().location();
        Assertions.assertEquals("Colombia", location);
    }

}
