/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc1_Introduccion;

/**
 *
 * @author brycorfe
 */
public class TrianguloRectangulo {
    /*FIELDS*/

    /*CONSTRUCTORS*/
    public TrianguloRectangulo(){}

    /*METHODS*/
    public double calcularArea(double hipotenusa, double cateto) {
        double cateto_2 = Math.sqrt( (hipotenusa*hipotenusa) - (cateto*cateto) );
        return cateto * cateto_2 / 2;
    }

}
