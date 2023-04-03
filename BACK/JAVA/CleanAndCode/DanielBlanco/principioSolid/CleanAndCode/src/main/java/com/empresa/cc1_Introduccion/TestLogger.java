/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.cc1_Introduccion;

import java.io.IOException;

/**
 *
 * @author brycorfe
 */
public class TestLogger {

    public static void main(String args []) throws IOException {
        /*CODIGO-NORMAL*/
        Logger log = new Logger();
//        log.logNumberOfEmployes(2);


        /*CLEAN_&&_CODE - REFACTORIZADO*/
        LoggerRefactorizado logref = new LoggerRefactorizado();
        logref.logNumberOfEmployees(2);
    }

}
