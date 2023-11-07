/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example3.JDK8_optional;

import com.mycompany.example.common.CFactura;
import com.mycompany.example.common.exeption.CFacturaExeption;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BryanCFz
 */
public class Test {

    public static void main(String[] args) {
//        pruebaDiaSemana();

        System.out.println("JAVA 8: <OPTIONAL>".concat("\n"));
        ProvedorFactura provedor = new ProvedorFactura();
        
        try {
            //->Generar factura entre semana (LUNES, ...VIERNES); En caso contrario lanzar exepcion fines de semana (SABADO, DOMINGO)
//            CFactura factura = provedor.getFactura(DiaSemana.LUNES);
            CFactura factura = provedor.getFactura(DiaSemana.DOMINGO);

            System.out.println("Factura   :" + factura);
            System.out.println("A pagar   :" + Utilitys.ConvertirDoubleToPesosColombianos( factura.precioTotal() ));
        } catch (CFacturaExeption e) {
            System.out.println("Error<CFacturaExeption>    :" + e.getMensajee());
            System.out.println("Error<Throwable>           :" + e.getMessage());
        }
        System.out.println("..");
        /*CFactura factura2 = provedor.getFactura(DiaSemana.DOMINGO);
        System.out.println("Factura   :" + factura2);
        System.out.println("---");*/
    }

/*
    public static void main2(String[] args) {
//        pruebaDiaSemana();

        System.out.println("JAVA 8: <OPTIONAL>".concat("\n"));
        ProvedorFactura provedor = new ProvedorFactura();
        try {
//            CFactura factura = provedor.getFactura(DiaSemana.LUNES);
            CFactura factura = provedor.getFactura(DiaSemana.DOMINGO);
            if (factura == null) {
                throw new CFacturaExeption("No se emiten facturas, los fines de semana!");
            }
            System.out.println("Factura   :" + factura);
            System.out.println("A pagar   :" + Utilitys.ConvertirDoubleToPesosColombianos( factura.precioTotal() ));
        } catch (CFacturaExeption e) {
            System.out.println("Error<CFacturaExeption>    :" + e.getMensajee()); //null, ¿Porque no muestra el mensaje?
            System.out.println("Error<Throwable>           :" + e.getMessage());         //AQUI SI MUESTRA EL MENSAJE
        }
        System.out.println("..");
    }    
*/

    /////////////////////////////////////////////////////////////////////////////////////////////
    public static void pruebaDiaSemana() {
        System.out.println(DiaSemana.JUEVES);               //->JUEVES
//        System.out.println(DiaSemana.JUEVES.getNombre());   //->Jueves
//        DiaSemana diaJu = DiaSemana.JUEVES;
//        System.out.println(diaJu.getDia());                 //->4
    }
    public static void valorPesosColombianos() {
        System.out.println("\nPESOS COLOMBIANOS");
        Locale colombianLocale = new Locale("es", "CO");
        NumberFormat colombianFormat = NumberFormat.getCurrencyInstance(colombianLocale);

        double valor = 1500000.50;  // Valor en pesos colombianos
        String valorEnPesos = colombianFormat.format(valor);
        System.out.println("Valor en pesos colombianos: " + valorEnPesos);
    }
    public static void random_Int_Double(){
        int    maxI = 20;   int    minI = 10;       int       randomInteger = 0;
        double maxD = 20.0;   double minD = 10.0;   double    randomDoubles = 0.0;
        Random rand = new Random();
        
        System.out.println("\nRANDOM INTEGER");
        
        for (int i = 1; i <= 5; i++) {
            randomInteger = rand.nextInt((maxI - minI) + 1) + minI;
            System.out.println("random[" + i + "]\t:" + randomInteger);
        }
        System.out.println("\nRANDOM DOUBLE");
        
        for (int i = 1; i <= 5; i++) {
            randomDoubles = minD + (maxD - minD) * rand.nextDouble();
            System.out.println("random[" + i + "]\t:" + randomDoubles);
        }
    }
}
