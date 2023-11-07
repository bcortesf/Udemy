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
public class Test2__throw_throws {

    public static void main(String[] args) {
        System.out.println("*****************************************");
        System.out.println("com.mycompany.maven_jdk7.b7_Exepciones.Test2__throw_throws".toUpperCase());
        System.out.println("*****************************************".concat("\n"));

        // https://www.youtube.com/watch?v=m8hmBlbpJRc&list=PLvimn1Ins-42o8Ms1G2SuRloD01nnXn31&index=43
        
        //throw new UnsupportedOperationException("Not supported yet.");

        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        //double res = 1/0;

        //______________________________________________________________________
        //______________________________________________________________________
        //______________________________________________________________________
                            final String ITEM = "ITEM-7";
        //______________________________________________________________________
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-1")) {
            System.out.println("-------->ITEM-1");
            System.out.println("+ UNCHECKED-RuntimeExeption   :Sin mensaje".concat("\n"));

            try {
                Test2__throw_throws t = new Test2__throw_throws();
                t.dividir_sinMensaje_UNCHECKED(1, 0);
            } catch (ArithmeticException e) {
                //->manejo de la exepcion
                Logger.getLogger(Test2__throw_throws.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            } finally {/* ->se ejecuta de ultimas; si o si */}
        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-2")) {
            System.out.println("-------->ITEM-2");
            System.out.println("+ UNCHECKED-RuntimeExeption   :Con mensaje".concat("\n"));

            try {
                Test2__throw_throws t = new Test2__throw_throws();
                t.dividir_conMensaje_UNCHECKED(1, 0);
            } catch (ArithmeticException e) {
                //->manejo de la exepcion
                Logger.getLogger(Test2__throw_throws.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            } finally {/* ->se ejecuta de ultimas; si o si */}
        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-3")) {
            System.out.println("-------->ITEM-3");
            System.out.println("+ CHECKED-Exeption   :Con mensaje".concat("\n"));

            try {
                Test2__throw_throws t = new Test2__throw_throws();
                t.dividir_conMensaje_CHECKED(1, 0);
            } catch (Exception e) {
                //->manejo de la exepcion
                Logger.getLogger(Test2__throw_throws.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            } finally {/* ->se ejecuta de ultimas; si o si */}
        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-4")) {
            System.out.println("-------->ITEM-4");
            System.out.println(" + CHECKED-Exeption   :con mensaje + CLASE.EXEPCION-PERSONALIZADA");

            try {
                Test2__throw_throws t = new Test2__throw_throws();
                t.dividir_conMensaje_customCHECKED(1, 0);
            } catch (ExceptionCustom e) {
                //->manejo de la exepcion
                Logger.getLogger(Test2__throw_throws.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            } finally {/* ->se ejecuta de ultimas; si o si */}
        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-5")) {
            System.out.println("-------->ITEM-5");
            System.out.println("CHECKED-Exeption   :Ejemplo MitoCode");
            // https://www.youtube.com/watch?v=m8hmBlbpJRc&list=PLvimn1Ins-42o8Ms1G2SuRloD01nnXn31&t=181s

            try {
                Test2__throw_throws t = new Test2__throw_throws();
                t.metodo1();
            } catch (Exception e) {
                //->manejo de la exepcion
                Logger.getLogger(Test2__throw_throws.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            } finally {/* ->se ejecuta de ultimas; si o si */}
        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-6")) {
            System.out.println("-------->ITEM-6");
            System.out.println("CHECKED-Exeption   :Ejemplo return");

            try {
                Test2__throw_throws t = new Test2__throw_throws();
                t.divide_return1(1, 0);
            } catch (ExceptionCustom e) {
                //->manejo de la exepcion
                Logger.getLogger(Test2__throw_throws.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            } finally {/* ->se ejecuta de ultimas; si o si */}
        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-7")) {
            System.out.println("-------->ITEM-7");
            System.out.println("CHECKED-Exeption   :¿¿¿¿¿DUDAS?????");

            
            //BCF
            if (false) {
                try {
                    Test2__throw_throws t = new Test2__throw_throws();
                    t.DUDA1_EXEPCION_POR_TIPO_DOUBLE_INTEGER();
                } catch (ArithmeticException e) {
                    //->manejo de la exepcion
                    Logger.getLogger(Test2__throw_throws.class.getName()).log(Level.SEVERE, e.getMessage(), e);
                } finally {/* ->se ejecuta de ultimas; si o si */}
            }

            if (true) {
                try {
                    Test2__throw_throws t = new Test2__throw_throws();
                    t.EXEPCION_CON_LOG_TRANSACCIONAL_PERSONALIZADO();
                } catch (ExceptionCustom e) {
                    //->manejo de la exepcion
                    
                    e.myLogError(e, Test2__throw_throws.class);     //---------->Asperooooooooooooooo este logsazooooooooooo
                    
                } finally {/* ->se ejecuta de ultimas; si o si */}
            }


        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        if (ITEM.equals("ITEM-")) {
            System.out.println("-------->ITEM-");
            System.out.println("CHECKED-Exeption   :S");
            //
        }
        
        //______________________________________________________________________
        //______________________________________________________________________
        System.out.println("");

    }
    
    //OJO: si dejo los parametros de tipo "double" ¿porque no presenta exepcion?
    private void dividir_sinMensaje_UNCHECKED(int num1, int num2) {             //NO-CONTIENE-"throws"
        try {
            double res = num1 / num2;
        } catch (java.lang.ArithmeticException e) { //UNCHECKED :RuntimeExeption
            throw e;
        }
    }
    
    private void dividir_conMensaje_UNCHECKED(int num1, int num2) {             //NO-CONTIENE-"throws"
        try {
            double res = num1 / num2;
        } catch (ArithmeticException e) { //UNCHECKED :RuntimeExeption
            throw new ArithmeticException("No puedo dividir /por cero");
        }
    }
    
    private void dividir_conMensaje_CHECKED(int num1, int num2) throws Exception {
        try {
            double res = num1 / num2;
        } catch (Exception e) {          
            throw new Exception("No puedo dividir /por cero");
        }
    }
    
    private void dividir_conMensaje_customCHECKED(int num1, int num2) throws ExceptionCustom {
        if (num2 == 0) {
            throw new ExceptionCustom("No puedo dividir /por cero");
        }
        double res = num1 / num2;
    }
    
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public void metodo1() throws Exception {
        try {
            metodo2();
        } catch(Exception e) {
            //System.err.println("m1[\""+ e.getMessage() + "\"]"); //-> m1["enviando exception"]
            System.err.println("\t III.(METODO1): Recibo la excepcion intermedia de 'metodo2()'");
            System.err.println("\t\t - Paso exception a capa superior --> main()");
            throw e;    //1. se lanza al catch de donde se invoco este "metodo1()" desde el main
        }
    }
    public void metodo2() throws Exception {
        try {
            metodo3();
        } catch(Exception e) {
            System.err.println("\t  II.(METODO2): Recibo la excepcion que fue iniciada en 'metodo3()'");
            System.err.println("\t\t - Paso exception a capa superior --> metodo1()");
            throw e;    //2. se lanza al catch de "metodo1()"
        }
    }
    private void metodo3() throws Exception {
        try {
            int res = 1 / 0;
        } catch (Exception error) {
            /* OPCION #1    :mensaje-por-defecto */
//            throw e;  //->  / by cero

            /* OPCION #2    :mensaje-por-defecto */
//            throw new Exception(error.getMessage());

            /* OPCION #3    :mensaje-personalizado*/
            System.err.println("\t   I.(METODO3): Inicio lanzando una exepcion, por problema tecnico encontrado");
            System.err.println("\t\t - Paso exception a capa superior --> metodo2()");
            throw new Exception("enviando exception");    //1. se lanza al catch de "metodo2()"
        }
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    public double divide_return1(int num1, int num2) throws ExceptionCustom {
        return divide_return2(num1, num2);
    }
    public double divide_return2(int num1, int num2) throws ExceptionCustom {
        return divide_return3(num1, num2);
    }
    private double divide_return3(int num1, int num2) throws ExceptionCustom {
        if (num2 == 0) {
            throw new ExceptionCustom("No puedo dividir / by zero");
        }
        double res = num1 / num2;
        return res;
    }


    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //BCF
    private double DUDA1_EXEPCION_POR_TIPO_DOUBLE_INTEGER() /*throws ArithmeticException*/ {  //UNCHECKED
//        double num1 = 7, num2 = 0; //double :   FAIL: NO-HAY-EXEPCION  -  ¿porque no sirve al estar double?
        int num1 = 7, num2 = 0; //int    :OK: MUESTRA-EXEPCION, por ser parametros enteros

        double res = num1 / num2;
        return res;
    }
    
    private double EXEPCION_CON_LOG_TRANSACCIONAL_PERSONALIZADO() throws ExceptionCustom {          //CHECKED
        int num1 = 7, num2 = 0; //int    :OK: MUESTRA-EXEPCION, por ser parametros enteros
        if (num2 == 0) {
            throw new ExceptionCustom("lo siento!, note puedo dividir por cero :s");
        }
        return num1 / num2;
    }

}
