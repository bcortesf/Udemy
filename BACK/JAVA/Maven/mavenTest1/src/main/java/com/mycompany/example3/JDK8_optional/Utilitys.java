/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example3.JDK8_optional;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author BryanCFz
 */
public class Utilitys {
    private static Random rand = new Random();
    
    public static double RANDOM_DOUBLE(){
        double maxD = 999999.0;   double minD = 100.0;   double    randomDouble = 0.0;
        randomDouble = minD + (maxD - minD) * rand.nextDouble();
        return randomDouble;
    }
    public static int RANDOM_INT(){
        int    maxI = 99999;   int    minI = 10000;       int       randomInteger = 0;
        randomInteger = rand.nextInt((maxI - minI) + 1) + minI;
        return randomInteger;
    }
    
    /**
     * 
     * @param valor :Valor en pesos colombianos
     * @return 
     */
    public static String ConvertirDoubleToPesosColombianos(double valor) {
        Locale colombianLocale = new Locale("es", "CO");
        NumberFormat colombianFormat = NumberFormat.getCurrencyInstance(colombianLocale);

        String valorEnPesos = colombianFormat.format(valor);
        //System.out.println("Valor en pesos colombianos: " + valorEnPesos);
        return valorEnPesos;
    }
}
