/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.example.common;

import java.util.Random;

/**
 *
 * @author BryanCFz
 */
public class MavenTest1_common {

    public static void main(String[] args) {
        /**
         * https://maven.apache.org/plugins/maven-compiler-plugin/examples/compile-using-different-jdk.html
         * https://www.geeksforgeeks.org/what-are-java-records-and-how-to-use-them-alongside-constructors-and-methods/
         * https://pastebin.com/raw/qTe5Vtnq
         */
        
        System.out.println("\n" + "*****************************************************");
        System.out.println("com.mycompany.example.common.MavenTest1_common.main()");
        System.out.println("Componente de entidades compartidas".toUpperCase());
        System.out.println("*****************************************************" + "\n");
        //
        show();
    }
    
    public static void show(){
        Random rnd = new Random();
        String id          = "F-2023-" + rnd.nextInt();
        double precioTotal = rnd.nextDouble();
        
        CFactura factura = new CFactura(id, "EXITO", precioTotal);
        System.out.println("Factura   :" + factura);
        System.out.println("A pagar   :" + factura.precioTotal());
    }
}
