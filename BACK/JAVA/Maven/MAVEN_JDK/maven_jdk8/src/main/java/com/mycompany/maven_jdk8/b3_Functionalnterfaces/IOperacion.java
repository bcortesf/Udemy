/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.maven_jdk8.b3_Functionalnterfaces;

import com.mycompany.maven_jdk8.b1_LambdaScope.*;

/**
 * Para ser una INTERFAZ-FUNCIONAL debe cumplir con:
 *      - <OBLIGATORIO>:   UNO SOLO  ó  Un solo  <metodoGeneral> declarado
 *      - <OPCIONAL>   :   Puede tener <N-metodosDefault> con implementacion en esta interfaz, ilimitados
 * 
 * @author BryanCFz
 */

//@FunctionalInterface
public interface IOperacion {
    /**<OBLIGATORIO>
     * @param numero1
     * @param numero2
     * @return  */
    public double calcular(double numero1, double numero2);
    
    /**<OPCIONAL>
     * @return  */
    default public String saludar() {
        return "hola";
    }
}
