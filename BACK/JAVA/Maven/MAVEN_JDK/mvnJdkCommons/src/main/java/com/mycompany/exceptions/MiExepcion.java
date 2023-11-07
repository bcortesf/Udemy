/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exceptions;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BryanCFz
 */
public class MiExepcion extends Exception {
    

    public MiExepcion(String mensaje) {
        super(mensaje);
    }

    public static void myLogErrorSTATIC(MiExepcion ex, String className) {
        System.err.println("\n".concat("...ERROR"));
        Logger.getLogger(className).log(
            Level.SEVERE,
            ex.getMessage(),
            ex
        );
        System.err.println("FIN-ERROR...".concat("\n"));
    }
    
    public void myLogError(MiExepcion err, Class clase) {
        System.err.println("\n".concat("...ERROR"));
        Logger.getLogger(clase.getName()).log(
            Level.SEVERE,
            err.getMessage(),
            err
        );
        System.err.println("FIN-ERROR...".concat("\n"));
    }

}