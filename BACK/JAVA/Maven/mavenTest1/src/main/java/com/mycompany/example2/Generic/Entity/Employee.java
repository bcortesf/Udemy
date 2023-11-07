/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example2.Generic.Entity;

/**
 *
 * @author BryanCFz
 */
public abstract class Employee {
    
    protected final int dni;
    protected final String name;
    protected final String job; //cargo
    protected  Double salary;
    protected Double bonoSalary;
    protected Double totalSalary;

    protected Employee(int dni, String name, String job, Double salary, Double bonoSalary, Double totalSalary) {
        this.dni = dni;
        this.name = name;
        this.job = job;
        this.salary = salary;
        this.bonoSalary = bonoSalary;
        this.totalSalary = totalSalary;
    }


    public int getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
    
    public Double getSalary() {
        return salary;
    }
    
    public Double getBonoSalary() {
        return bonoSalary;
    }


    @Override
    public String toString() {
        return "Employee{" + "dni=" + dni + ", name=" + name + ", job=" + job.toUpperCase() + ", salary=" + salary + ", bonoSalary=" + bonoSalary + ", totalSalary=" + totalSalary + '}';
    }


    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setBonoSalary(Double bonoSalary) {
        this.bonoSalary = bonoSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }
    
    ///////////////////////////////////
    public abstract Double getTotalSalary();
}
