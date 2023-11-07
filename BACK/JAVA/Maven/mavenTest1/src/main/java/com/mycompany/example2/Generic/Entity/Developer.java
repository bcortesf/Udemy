/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example2.Generic.Entity;

/**
 *
 * @author BryanCFz
 */
public class Developer extends Employee {

    public Developer(int dni, String name, String job, Double salary, Double bonoSalary, Double totalSalary) {
        super(dni, name, job, salary, bonoSalary, totalSalary);
    }


    public static Employee factory() {
        return new Developer(2, "Bryan", "Desarrollador", 4.500, 0.0, 4.500);
    }

    public void setBonoSalary(Double bono) {
        bonoSalary = bono;
    }

    @Override
    public Double getTotalSalary() {
        setTotalSalary(salary * bonoSalary);
        return totalSalary;
    }

}
