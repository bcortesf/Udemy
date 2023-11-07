/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk7.b8_Date;

import java.util.Calendar;

/**
 *
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b8_Date".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        //
        Calendar fecha1 = Calendar.getInstance();//fecha-actual
        Calendar fecha2 = Calendar.getInstance();//fecha-actual
        
        //mes-month:    de [0,.. ,11]
        fecha1.set(1991, 0, 11);
        
        System.out.println(fecha1);
        System.out.println(fecha1.after(fecha2));  //-> 1991 esMAyor añoActual(2023)
    }
}
