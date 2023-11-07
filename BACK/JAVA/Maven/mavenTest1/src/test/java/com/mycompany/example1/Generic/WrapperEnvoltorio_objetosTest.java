/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example1.Generic;

import com.mycompany.example1.Generic.WrapperEnvoltorio_objetos;
import com.mycompany.example1.Generic.Entity.Department;
import com.mycompany.example1.Generic.Entity.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 *
 * @author BryanCFz
 */
public class WrapperEnvoltorio_objetosTest {
    
    @Test
    public void TestEnvuelveEmpleado() {
        Department department = new Department(1, "Contabilidad", "Colombia");
        Employee employee = new Employee("Bryan", "Cortes", "Bogota D.C");
        
        WrapperEnvoltorio_objetos wrapper = new WrapperEnvoltorio_objetos(employee);
        Assertions.assertTrue(wrapper.toString().contains("Envolvemos {"));
        
        //ERROR
//        String location = ((Department)wrapper.get()).location();
//        Assertions.assertEquals("Colombia", location);
    }

    @Test
    public void TestEnvuelveDepartamento() {
        Department department = new Department(1, "Contabilidad", "Colombia");
        WrapperEnvoltorio_objetos wrapper = new WrapperEnvoltorio_objetos(department);
        Assertions.assertTrue(wrapper.toString().contains("Envolvemos {"));
        
        String location = ((Department)wrapper.get()).location();
        Assertions.assertEquals("Colombia", location);
    }

}
