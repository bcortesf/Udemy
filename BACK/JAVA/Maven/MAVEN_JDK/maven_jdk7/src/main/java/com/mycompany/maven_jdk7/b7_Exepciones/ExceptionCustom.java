/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven_jdk7.b7_Exepciones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BryanCFz
 */
public class ExceptionCustom extends Exception {
    
    Class a;

    public ExceptionCustom(String mensaje) {
        super(mensaje);
    }

    public static void myLogErrorSTATIC(ExceptionCustom ex, String className) {
        System.err.println("\n".concat("...ERROR"));
        Logger.getLogger(className).log(
            Level.SEVERE,
            ex.getMessage(),
            ex
        );
        System.err.println("FIN-ERROR...".concat("\n"));
    }
    
    public void myLogError(ExceptionCustom err, Class clase) {
        System.err.println("\n".concat("...ERROR"));
        Logger.getLogger(clase.getName()).log(
            Level.SEVERE,
            err.getMessage(),
            err
        );
        System.err.println("FIN-ERROR...".concat("\n"));
    }

}

