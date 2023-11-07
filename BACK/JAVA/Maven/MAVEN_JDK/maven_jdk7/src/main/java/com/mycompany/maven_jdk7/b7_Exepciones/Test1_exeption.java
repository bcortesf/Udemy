/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maven_jdk7.b7_Exepciones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BryanCFz
 */
public class Test1_exeption {
    
    /**
     * Muestra la traza del log para el error.
     * @param ex 
     */
    private static void logErrorTEST(ExceptionCustom ex) {
        /* ->OPCION #1 */
        System.err.println("\n".concat("...ERROR"));
        Logger.getLogger(Test1_exeption.class.getName()).log(
            Level.SEVERE,
            ex.getMessage(),
            ex
        );
        System.err.println("FIN-ERROR...".concat("\n"));
        /* ->OPCION #2 */
        //ExeptionCustom.myLogError(ex, Test1_exeption.class.getName());
    }

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b7_Exepciones.Test1_exeption".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // https://www.youtube.com/watch?v=m8hmBlbpJRc&list=PLvimn1Ins-42o8Ms1G2SuRloD01nnXn31&index=43
        //throw new UnsupportedOperationException("Not supported yet.");


        System.out.println("->CHECKED     :extends Exeption");
        try {
            Test1_exeption t = new Test1_exeption();
            double division = t.dividir_CHECKED();
            System.out.println("resultado division: " + division);
        } catch (ExceptionCustom ex) {
            //->manejo de la exepcion
            //logErrorTEST(ex);
            ExceptionCustom.myLogErrorSTATIC(ex, Test1_exeption.class.getName());
        } finally { /*->se ejecuta de ultimas; si o si*/ }
        System.out.println("-------------------------");

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        System.out.println("->UNCHECKED     :extends RuntimeExeption");
        try {
            Test1_exeption t = new Test1_exeption();
            double division = t.dividir_UNCHECKED();
            
            
            System.out.println("resultado division: " + division);
        } catch (RuntimeException ex) {
            //->manejo de la exepcion
            System.err.println(ex.getMessage());
            //Logger.getLogger(Test1_exeption.class.getName()).log(Level.SEVERE, null, ex);
        } finally { //->se ejecuta de ultimas; si o si 
        }

    }

    /**
     * UNCHECKED
     * - <exepcion-unchecked>: Solo falla en tiempo de ejecucion
     *      - Hereda de "RuntimeExeption"; son exepciones <UNCHECKED>
     *      - No se requiere de palabra reservada "throws"
     * @return 
     */
    private double dividir_UNCHECKED() {
        double num1 = 7, num2 = 0;
        return num1 / num2;
    }
    /**
     * CHECKED
     * - <exepcion-checked>: Falla en tiempo de compilacion (osea en sintaxis)
     *      - Hereda de "Exeption"; son exepciones <CHECKED>
     *      - Requiere de palabra reservada "throws"
     * @return 
     */
    private double dividir_CHECKED() throws ExceptionCustom {
        double num1 = 7, num2 = 0;
        if (num2 == 0) {
            throw new ExceptionCustom("No se puede dividir por cero");
        }
        return num1 / num2;
    }
}
