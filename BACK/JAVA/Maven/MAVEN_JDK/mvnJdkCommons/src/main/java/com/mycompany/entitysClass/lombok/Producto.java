/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entitysClass.lombok;


/**
 * https://netbeans.apache.org//kb/docs/java/
 * https://netbeans.apache.org//kb/docs/java/annotations-lombok.html
 * 
 * https://stevenmwesigwa.com/tutorials/project-lombok/2/how-to-install-project-lombok-in-apache-netbeans
 * @author BryanCFz
 */



@lombok.Data                //canEqual(), equals(), hashCode(), toString(), getters() y setters()
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Producto {
    private Integer id;
    private String nombre;
    private double precio;
}
