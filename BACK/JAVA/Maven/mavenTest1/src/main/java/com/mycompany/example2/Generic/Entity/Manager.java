/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example2.Generic.Entity;

/**
 *
 * @author BryanCFz
 */
public class Manager extends Employee {
    
    public Manager(int dni, String name, String job, Double salary, Double bonoSalary, Double totalSalary) {
        super(dni, name, job, salary, bonoSalary, totalSalary);
    }


    public static Employee factory() {
        Employee employee = new Manager(1, "Mamita", "Administrador de proyectos", 2.000, 1.5, 2.000);
        return employee;
    }

    @Override
    public Double getTotalSalary() {
        return salary *4.0;
    }
    
    
    
}
